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
    private h fLN;
    private int fRA;
    private ImageView fRv;
    private TextView fRw;
    private TextView fRx;
    private Button fRy;
    private a fRz;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fRA = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRA = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRA = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fRy = (Button) findViewById(a.g.ala_live_face_btn);
        this.fRv = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fRw = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fRx = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fRx.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fRy.setOnClickListener(this);
        this.fRv.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bAx() {
        if (this.fRA <= 0) {
            this.fRA = 0;
        } else if (this.fRA > this.fLN.fFQ.fFR.size()) {
            this.fRA = this.fLN.fFQ.fFR.size();
        }
        if (this.fRA == 0) {
            this.fRv.setVisibility(4);
            this.fRw.setVisibility(0);
        } else {
            this.fRv.setVisibility(0);
            this.fRw.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fLN.fFQ.notify)) {
            this.fRw.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fRw.setText(this.fLN.fFQ.notify);
        }
        if (this.fRA < this.fLN.fFQ.fFR.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fRA + 1)).append("/").append(this.fLN.fFQ.fFR.size()).append(" ");
            sb.append(this.fLN.fFQ.fFR.get(this.fRA));
            this.fRx.setText(sb.toString());
        } else {
            this.fRx.setText(a.i.ala_live_face_done_tips);
        }
        this.fRx.scrollTo(0, 0);
        this.fRy.setText(a.i.ala_live_face_next);
        if (this.fLN.fFQ.fFR.size() - 1 == this.fRA) {
            this.fRy.setText(a.i.ala_live_face_done);
        } else if (this.fLN.fFQ.fFR.size() == this.fRA) {
            this.fRy.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fLN = hVar;
        if (this.fLN != null && this.fLN.fFQ != null && this.fLN.fFQ.fFR != null && this.fLN.fFQ.fFR.size() > 0) {
            this.fRA = 0;
            bAx();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fRv) {
            this.fRA--;
            bAx();
        } else if (view == this.fRy) {
            if (this.fRA == this.fLN.fFQ.fFR.size()) {
                if (this.fRz != null) {
                    this.fRz.onFinished();
                    return;
                }
                return;
            }
            this.fRA++;
            bAx();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fRz = aVar;
    }
}
