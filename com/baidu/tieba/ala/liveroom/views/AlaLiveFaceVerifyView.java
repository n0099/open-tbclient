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
import com.baidu.live.data.ag;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ag gEW;
    private ImageView gKX;
    private TextView gKY;
    private TextView gKZ;
    private Button gLa;
    private a gLb;
    private int gLc;
    private TextView mHelp;

    /* loaded from: classes7.dex */
    public interface a {
        void XL();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.gLc = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLc = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLc = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.gLa = (Button) findViewById(a.g.ala_live_face_btn);
        this.gKX = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.gKY = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.gKZ = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.gKZ.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.gLa.setOnClickListener(this);
        this.gKX.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bWY() {
        if (this.gLc <= 0) {
            this.gLc = 0;
        } else if (this.gLc > this.gEW.aHQ.aHR.size()) {
            this.gLc = this.gEW.aHQ.aHR.size();
        }
        if (this.gLc == 0) {
            this.gKX.setVisibility(4);
            this.gKY.setVisibility(0);
        } else {
            this.gKX.setVisibility(0);
            this.gKY.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gEW.aHQ.notify)) {
            this.gKY.setText(a.i.ala_live_face_question_tips);
        } else {
            this.gKY.setText(this.gEW.aHQ.notify);
        }
        if (this.gLc < this.gEW.aHQ.aHR.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.gLc + 1)).append("/").append(this.gEW.aHQ.aHR.size()).append(" ");
            sb.append(this.gEW.aHQ.aHR.get(this.gLc));
            this.gKZ.setText(sb.toString());
        } else {
            this.gKZ.setText(a.i.ala_live_face_done_tips);
        }
        this.gKZ.scrollTo(0, 0);
        this.gLa.setText(a.i.ala_live_face_next);
        if (this.gEW.aHQ.aHR.size() - 1 == this.gLc) {
            this.gLa.setText(a.i.ala_live_face_done);
        } else if (this.gEW.aHQ.aHR.size() == this.gLc) {
            this.gLa.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ag agVar) {
        this.gEW = agVar;
        if (this.gEW != null && this.gEW.aHQ != null && this.gEW.aHQ.aHR != null && this.gEW.aHQ.aHR.size() > 0) {
            this.gLc = 0;
            bWY();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.gKX) {
            this.gLc--;
            bWY();
        } else if (view == this.gLa) {
            if (this.gLc == this.gEW.aHQ.aHR.size()) {
                if (this.gLb != null) {
                    this.gLb.XL();
                    return;
                }
                return;
            }
            this.gLc++;
            bWY();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.gLb = aVar;
    }
}
