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
import com.baidu.live.data.as;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes11.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private as hJQ;
    private ImageView hQo;
    private TextView hQp;
    private TextView hQq;
    private Button hQr;
    private a hQs;
    private int hQt;
    private TextView mHelp;

    /* loaded from: classes11.dex */
    public interface a {
        void cls();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hQt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQt = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hQr = (Button) findViewById(a.f.ala_live_face_btn);
        this.hQo = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hQp = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hQq = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hQq.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hQr.setOnClickListener(this);
        this.hQo.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void cnT() {
        if (this.hQt <= 0) {
            this.hQt = 0;
        } else if (this.hQt > this.hJQ.aPZ.aQc.size()) {
            this.hQt = this.hJQ.aPZ.aQc.size();
        }
        if (this.hQt == 0) {
            this.hQo.setVisibility(4);
            this.hQp.setVisibility(0);
        } else {
            this.hQo.setVisibility(0);
            this.hQp.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hJQ.aPZ.notify)) {
            this.hQp.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hQp.setText(this.hJQ.aPZ.notify);
        }
        if (this.hQt < this.hJQ.aPZ.aQc.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hQt + 1)).append("/").append(this.hJQ.aPZ.aQc.size()).append(" ");
            sb.append(this.hJQ.aPZ.aQc.get(this.hQt));
            this.hQq.setText(sb.toString());
        } else {
            this.hQq.setText(a.h.ala_live_face_done_tips);
        }
        this.hQq.scrollTo(0, 0);
        this.hQr.setText(a.h.ala_live_face_next);
        if (this.hJQ.aPZ.aQc.size() - 1 == this.hQt) {
            this.hQr.setText(a.h.ala_live_face_done);
        } else if (this.hJQ.aPZ.aQc.size() == this.hQt) {
            this.hQr.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(as asVar) {
        this.hJQ = asVar;
        if (this.hJQ != null && this.hJQ.aPZ != null && this.hJQ.aPZ.aQc != null && this.hJQ.aPZ.aQc.size() > 0) {
            this.hQt = 0;
            cnT();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hQo) {
            this.hQt--;
            cnT();
        } else if (view == this.hQr) {
            if (this.hQt == this.hJQ.aPZ.aQc.size()) {
                if (this.hQs != null) {
                    this.hQs.cls();
                    return;
                }
                return;
            }
            this.hQt++;
            cnT();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hQs = aVar;
    }
}
