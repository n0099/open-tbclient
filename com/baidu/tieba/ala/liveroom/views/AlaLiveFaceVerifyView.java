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
import com.baidu.live.data.aw;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private aw hLt;
    private ImageView hRZ;
    private TextView hSa;
    private TextView hSb;
    private Button hSc;
    private a hSd;
    private int hSe;
    private TextView mHelp;

    /* loaded from: classes10.dex */
    public interface a {
        void ciG();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hSe = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSe = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSe = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hSc = (Button) findViewById(a.f.ala_live_face_btn);
        this.hRZ = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hSa = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hSb = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hSb.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hSc.setOnClickListener(this);
        this.hRZ.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void clm() {
        if (this.hSe <= 0) {
            this.hSe = 0;
        } else if (this.hSe > this.hLt.aPI.aPL.size()) {
            this.hSe = this.hLt.aPI.aPL.size();
        }
        if (this.hSe == 0) {
            this.hRZ.setVisibility(4);
            this.hSa.setVisibility(0);
        } else {
            this.hRZ.setVisibility(0);
            this.hSa.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hLt.aPI.notify)) {
            this.hSa.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hSa.setText(this.hLt.aPI.notify);
        }
        if (this.hSe < this.hLt.aPI.aPL.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hSe + 1)).append("/").append(this.hLt.aPI.aPL.size()).append(" ");
            sb.append(this.hLt.aPI.aPL.get(this.hSe));
            this.hSb.setText(sb.toString());
        } else {
            this.hSb.setText(a.h.ala_live_face_done_tips);
        }
        this.hSb.scrollTo(0, 0);
        this.hSc.setText(a.h.ala_live_face_next);
        if (this.hLt.aPI.aPL.size() - 1 == this.hSe) {
            this.hSc.setText(a.h.ala_live_face_done);
        } else if (this.hLt.aPI.aPL.size() == this.hSe) {
            this.hSc.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(aw awVar) {
        this.hLt = awVar;
        if (this.hLt != null && this.hLt.aPI != null && this.hLt.aPI.aPL != null && this.hLt.aPI.aPL.size() > 0) {
            this.hSe = 0;
            clm();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hRZ) {
            this.hSe--;
            clm();
        } else if (view == this.hSc) {
            if (this.hSe == this.hLt.aPI.aPL.size()) {
                if (this.hSd != null) {
                    this.hSd.ciG();
                    return;
                }
                return;
            }
            this.hSe++;
            clm();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hSd = aVar;
    }
}
