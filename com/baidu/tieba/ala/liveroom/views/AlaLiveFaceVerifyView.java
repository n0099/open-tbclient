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
import com.baidu.live.data.ae;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes4.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ae gsb;
    private ImageView gyP;
    private TextView gyQ;
    private TextView gyR;
    private Button gyS;
    private a gyT;
    private int gyU;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void RQ();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.gyU = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gyU = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gyU = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.gyS = (Button) findViewById(a.g.ala_live_face_btn);
        this.gyP = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.gyQ = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.gyR = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.gyR.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.gyS.setOnClickListener(this);
        this.gyP.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bNa() {
        if (this.gyU <= 0) {
            this.gyU = 0;
        } else if (this.gyU > this.gsb.aCG.aCH.size()) {
            this.gyU = this.gsb.aCG.aCH.size();
        }
        if (this.gyU == 0) {
            this.gyP.setVisibility(4);
            this.gyQ.setVisibility(0);
        } else {
            this.gyP.setVisibility(0);
            this.gyQ.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gsb.aCG.notify)) {
            this.gyQ.setText(a.i.ala_live_face_question_tips);
        } else {
            this.gyQ.setText(this.gsb.aCG.notify);
        }
        if (this.gyU < this.gsb.aCG.aCH.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.gyU + 1)).append("/").append(this.gsb.aCG.aCH.size()).append(" ");
            sb.append(this.gsb.aCG.aCH.get(this.gyU));
            this.gyR.setText(sb.toString());
        } else {
            this.gyR.setText(a.i.ala_live_face_done_tips);
        }
        this.gyR.scrollTo(0, 0);
        this.gyS.setText(a.i.ala_live_face_next);
        if (this.gsb.aCG.aCH.size() - 1 == this.gyU) {
            this.gyS.setText(a.i.ala_live_face_done);
        } else if (this.gsb.aCG.aCH.size() == this.gyU) {
            this.gyS.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ae aeVar) {
        this.gsb = aeVar;
        if (this.gsb != null && this.gsb.aCG != null && this.gsb.aCG.aCH != null && this.gsb.aCG.aCH.size() > 0) {
            this.gyU = 0;
            bNa();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.gyP) {
            this.gyU--;
            bNa();
        } else if (view == this.gyS) {
            if (this.gyU == this.gsb.aCG.aCH.size()) {
                if (this.gyT != null) {
                    this.gyT.RQ();
                    return;
                }
                return;
            }
            this.gyU++;
            bNa();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.gyT = aVar;
    }
}
