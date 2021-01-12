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
/* loaded from: classes10.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private as hFk;
    private ImageView hLI;
    private TextView hLJ;
    private TextView hLK;
    private Button hLL;
    private a hLM;
    private int hLN;
    private TextView mHelp;

    /* loaded from: classes10.dex */
    public interface a {
        void chA();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hLN = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLN = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLN = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hLL = (Button) findViewById(a.f.ala_live_face_btn);
        this.hLI = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hLJ = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hLK = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hLK.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hLL.setOnClickListener(this);
        this.hLI.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void ckb() {
        if (this.hLN <= 0) {
            this.hLN = 0;
        } else if (this.hLN > this.hFk.aLm.aLp.size()) {
            this.hLN = this.hFk.aLm.aLp.size();
        }
        if (this.hLN == 0) {
            this.hLI.setVisibility(4);
            this.hLJ.setVisibility(0);
        } else {
            this.hLI.setVisibility(0);
            this.hLJ.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hFk.aLm.notify)) {
            this.hLJ.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hLJ.setText(this.hFk.aLm.notify);
        }
        if (this.hLN < this.hFk.aLm.aLp.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hLN + 1)).append("/").append(this.hFk.aLm.aLp.size()).append(" ");
            sb.append(this.hFk.aLm.aLp.get(this.hLN));
            this.hLK.setText(sb.toString());
        } else {
            this.hLK.setText(a.h.ala_live_face_done_tips);
        }
        this.hLK.scrollTo(0, 0);
        this.hLL.setText(a.h.ala_live_face_next);
        if (this.hFk.aLm.aLp.size() - 1 == this.hLN) {
            this.hLL.setText(a.h.ala_live_face_done);
        } else if (this.hFk.aLm.aLp.size() == this.hLN) {
            this.hLL.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(as asVar) {
        this.hFk = asVar;
        if (this.hFk != null && this.hFk.aLm != null && this.hFk.aLm.aLp != null && this.hFk.aLm.aLp.size() > 0) {
            this.hLN = 0;
            ckb();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hLI) {
            this.hLN--;
            ckb();
        } else if (view == this.hLL) {
            if (this.hLN == this.hFk.aLm.aLp.size()) {
                if (this.hLM != null) {
                    this.hLM.chA();
                    return;
                }
                return;
            }
            this.hLN++;
            ckb();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hLM = aVar;
    }
}
