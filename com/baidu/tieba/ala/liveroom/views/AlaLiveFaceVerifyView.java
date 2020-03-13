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
    private h fhc;
    private Button fmA;
    private a fmB;
    private int fmC;
    private ImageView fmx;
    private TextView fmy;
    private TextView fmz;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fmC = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmC = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmC = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fmA = (Button) findViewById(a.g.ala_live_face_btn);
        this.fmx = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fmy = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fmz = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fmz.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fmA.setOnClickListener(this);
        this.fmx.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bqS() {
        if (this.fmC <= 0) {
            this.fmC = 0;
        } else if (this.fmC > this.fhc.fbj.fbk.size()) {
            this.fmC = this.fhc.fbj.fbk.size();
        }
        if (this.fmC == 0) {
            this.fmx.setVisibility(4);
            this.fmy.setVisibility(0);
        } else {
            this.fmx.setVisibility(0);
            this.fmy.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fhc.fbj.notify)) {
            this.fmy.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fmy.setText(this.fhc.fbj.notify);
        }
        if (this.fmC < this.fhc.fbj.fbk.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fmC + 1)).append("/").append(this.fhc.fbj.fbk.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.fhc.fbj.fbk.get(this.fmC));
            this.fmz.setText(sb.toString());
        } else {
            this.fmz.setText(a.i.ala_live_face_done_tips);
        }
        this.fmz.scrollTo(0, 0);
        this.fmA.setText(a.i.ala_live_face_next);
        if (this.fhc.fbj.fbk.size() - 1 == this.fmC) {
            this.fmA.setText(a.i.ala_live_face_done);
        } else if (this.fhc.fbj.fbk.size() == this.fmC) {
            this.fmA.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fhc = hVar;
        if (this.fhc != null && this.fhc.fbj != null && this.fhc.fbj.fbk != null && this.fhc.fbj.fbk.size() > 0) {
            this.fmC = 0;
            bqS();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fmx) {
            this.fmC--;
            bqS();
        } else if (view == this.fmA) {
            if (this.fmC == this.fhc.fbj.fbk.size()) {
                if (this.fmB != null) {
                    this.fmB.onFinished();
                    return;
                }
                return;
            }
            this.fmC++;
            bqS();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fmB = aVar;
    }
}
