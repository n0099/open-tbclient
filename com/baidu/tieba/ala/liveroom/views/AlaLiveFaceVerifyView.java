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
    private ImageView hEo;
    private TextView hEp;
    private TextView hEq;
    private Button hEr;
    private a hEs;
    private int hEt;
    private aq hxS;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void aia();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hEt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hEt = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hEr = (Button) findViewById(a.f.ala_live_face_btn);
        this.hEo = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hEp = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hEq = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hEq.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hEr.setOnClickListener(this);
        this.hEo.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void clb() {
        if (this.hEt <= 0) {
            this.hEt = 0;
        } else if (this.hEt > this.hxS.aPk.aPn.size()) {
            this.hEt = this.hxS.aPk.aPn.size();
        }
        if (this.hEt == 0) {
            this.hEo.setVisibility(4);
            this.hEp.setVisibility(0);
        } else {
            this.hEo.setVisibility(0);
            this.hEp.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hxS.aPk.notify)) {
            this.hEp.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hEp.setText(this.hxS.aPk.notify);
        }
        if (this.hEt < this.hxS.aPk.aPn.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hEt + 1)).append("/").append(this.hxS.aPk.aPn.size()).append(" ");
            sb.append(this.hxS.aPk.aPn.get(this.hEt));
            this.hEq.setText(sb.toString());
        } else {
            this.hEq.setText(a.h.ala_live_face_done_tips);
        }
        this.hEq.scrollTo(0, 0);
        this.hEr.setText(a.h.ala_live_face_next);
        if (this.hxS.aPk.aPn.size() - 1 == this.hEt) {
            this.hEr.setText(a.h.ala_live_face_done);
        } else if (this.hxS.aPk.aPn.size() == this.hEt) {
            this.hEr.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(aq aqVar) {
        this.hxS = aqVar;
        if (this.hxS != null && this.hxS.aPk != null && this.hxS.aPk.aPn != null && this.hxS.aPk.aPn.size() > 0) {
            this.hEt = 0;
            clb();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hEo) {
            this.hEt--;
            clb();
        } else if (view == this.hEr) {
            if (this.hEt == this.hxS.aPk.aPn.size()) {
                if (this.hEs != null) {
                    this.hEs.aia();
                    return;
                }
                return;
            }
            this.hEt++;
            clb();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hEs = aVar;
    }
}
