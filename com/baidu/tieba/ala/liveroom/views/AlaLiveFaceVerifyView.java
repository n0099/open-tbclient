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
import com.baidu.live.data.aq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes4.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ImageView hEm;
    private TextView hEn;
    private TextView hEo;
    private Button hEp;
    private a hEq;
    private int hEr;
    private aq hxQ;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void aia();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hEr = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEr = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hEr = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hEp = (Button) findViewById(a.f.ala_live_face_btn);
        this.hEm = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hEn = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hEo = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hEo.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hEp.setOnClickListener(this);
        this.hEm.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void cla() {
        if (this.hEr <= 0) {
            this.hEr = 0;
        } else if (this.hEr > this.hxQ.aPk.aPn.size()) {
            this.hEr = this.hxQ.aPk.aPn.size();
        }
        if (this.hEr == 0) {
            this.hEm.setVisibility(4);
            this.hEn.setVisibility(0);
        } else {
            this.hEm.setVisibility(0);
            this.hEn.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hxQ.aPk.notify)) {
            this.hEn.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hEn.setText(this.hxQ.aPk.notify);
        }
        if (this.hEr < this.hxQ.aPk.aPn.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hEr + 1)).append("/").append(this.hxQ.aPk.aPn.size()).append(" ");
            sb.append(this.hxQ.aPk.aPn.get(this.hEr));
            this.hEo.setText(sb.toString());
        } else {
            this.hEo.setText(a.h.ala_live_face_done_tips);
        }
        this.hEo.scrollTo(0, 0);
        this.hEp.setText(a.h.ala_live_face_next);
        if (this.hxQ.aPk.aPn.size() - 1 == this.hEr) {
            this.hEp.setText(a.h.ala_live_face_done);
        } else if (this.hxQ.aPk.aPn.size() == this.hEr) {
            this.hEp.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(aq aqVar) {
        this.hxQ = aqVar;
        if (this.hxQ != null && this.hxQ.aPk != null && this.hxQ.aPk.aPn != null && this.hxQ.aPk.aPn.size() > 0) {
            this.hEr = 0;
            cla();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hEm) {
            this.hEr--;
            cla();
        } else if (view == this.hEp) {
            if (this.hEr == this.hxQ.aPk.aPn.size()) {
                if (this.hEq != null) {
                    this.hEq.aia();
                    return;
                }
                return;
            }
            this.hEr++;
            cla();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hEq = aVar;
    }
}
