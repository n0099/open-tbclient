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
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.data.h;
/* loaded from: classes3.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private h fLS;
    private ImageView fRA;
    private TextView fRB;
    private TextView fRC;
    private Button fRD;
    private a fRE;
    private int fRF;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fRF = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRF = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRF = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fRD = (Button) findViewById(a.g.ala_live_face_btn);
        this.fRA = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fRB = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fRC = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fRC.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fRD.setOnClickListener(this);
        this.fRA.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bAv() {
        if (this.fRF <= 0) {
            this.fRF = 0;
        } else if (this.fRF > this.fLS.fFV.fFW.size()) {
            this.fRF = this.fLS.fFV.fFW.size();
        }
        if (this.fRF == 0) {
            this.fRA.setVisibility(4);
            this.fRB.setVisibility(0);
        } else {
            this.fRA.setVisibility(0);
            this.fRB.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fLS.fFV.notify)) {
            this.fRB.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fRB.setText(this.fLS.fFV.notify);
        }
        if (this.fRF < this.fLS.fFV.fFW.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fRF + 1)).append("/").append(this.fLS.fFV.fFW.size()).append(" ");
            sb.append(this.fLS.fFV.fFW.get(this.fRF));
            this.fRC.setText(sb.toString());
        } else {
            this.fRC.setText(a.i.ala_live_face_done_tips);
        }
        this.fRC.scrollTo(0, 0);
        this.fRD.setText(a.i.ala_live_face_next);
        if (this.fLS.fFV.fFW.size() - 1 == this.fRF) {
            this.fRD.setText(a.i.ala_live_face_done);
        } else if (this.fLS.fFV.fFW.size() == this.fRF) {
            this.fRD.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fLS = hVar;
        if (this.fLS != null && this.fLS.fFV != null && this.fLS.fFV.fFW != null && this.fLS.fFV.fFW.size() > 0) {
            this.fRF = 0;
            bAv();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fRA) {
            this.fRF--;
            bAv();
        } else if (view == this.fRD) {
            if (this.fRF == this.fLS.fFV.fFW.size()) {
                if (this.fRE != null) {
                    this.fRE.onFinished();
                    return;
                }
                return;
            }
            this.fRF++;
            bAv();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fRE = aVar;
    }
}
