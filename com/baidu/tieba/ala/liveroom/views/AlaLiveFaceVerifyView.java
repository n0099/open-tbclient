package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.data.h;
/* loaded from: classes3.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private h fhB;
    private ImageView fmW;
    private TextView fmX;
    private TextView fmY;
    private Button fmZ;
    private a fna;
    private int fnb;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fnb = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnb = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnb = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fmZ = (Button) findViewById(a.g.ala_live_face_btn);
        this.fmW = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fmX = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fmY = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fmY.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fmZ.setOnClickListener(this);
        this.fmW.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bqX() {
        if (this.fnb <= 0) {
            this.fnb = 0;
        } else if (this.fnb > this.fhB.fbH.fbI.size()) {
            this.fnb = this.fhB.fbH.fbI.size();
        }
        if (this.fnb == 0) {
            this.fmW.setVisibility(4);
            this.fmX.setVisibility(0);
        } else {
            this.fmW.setVisibility(0);
            this.fmX.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fhB.fbH.notify)) {
            this.fmX.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fmX.setText(this.fhB.fbH.notify);
        }
        if (this.fnb < this.fhB.fbH.fbI.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fnb + 1)).append("/").append(this.fhB.fbH.fbI.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.fhB.fbH.fbI.get(this.fnb));
            this.fmY.setText(sb.toString());
        } else {
            this.fmY.setText(a.i.ala_live_face_done_tips);
        }
        this.fmY.scrollTo(0, 0);
        this.fmZ.setText(a.i.ala_live_face_next);
        if (this.fhB.fbH.fbI.size() - 1 == this.fnb) {
            this.fmZ.setText(a.i.ala_live_face_done);
        } else if (this.fhB.fbH.fbI.size() == this.fnb) {
            this.fmZ.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fhB = hVar;
        if (this.fhB != null && this.fhB.fbH != null && this.fhB.fbH.fbI != null && this.fhB.fbH.fbI.size() > 0) {
            this.fnb = 0;
            bqX();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fmW) {
            this.fnb--;
            bqX();
        } else if (view == this.fmZ) {
            if (this.fnb == this.fhB.fbH.fbI.size()) {
                if (this.fna != null) {
                    this.fna.onFinished();
                    return;
                }
                return;
            }
            this.fnb++;
            bqX();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fna = aVar;
    }
}
