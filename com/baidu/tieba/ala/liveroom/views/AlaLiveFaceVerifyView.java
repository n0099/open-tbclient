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
    private h fZS;
    private ImageView ggl;
    private TextView ggm;
    private TextView ggn;
    private Button ggo;
    private a ggp;
    private int ggq;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void Qv();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.ggq = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggq = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggq = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.ggo = (Button) findViewById(a.g.ala_live_face_btn);
        this.ggl = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.ggm = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.ggn = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.ggn.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.ggo.setOnClickListener(this);
        this.ggl.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bGK() {
        if (this.ggq <= 0) {
            this.ggq = 0;
        } else if (this.ggq > this.fZS.fTQ.fTR.size()) {
            this.ggq = this.fZS.fTQ.fTR.size();
        }
        if (this.ggq == 0) {
            this.ggl.setVisibility(4);
            this.ggm.setVisibility(0);
        } else {
            this.ggl.setVisibility(0);
            this.ggm.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fZS.fTQ.notify)) {
            this.ggm.setText(a.i.ala_live_face_question_tips);
        } else {
            this.ggm.setText(this.fZS.fTQ.notify);
        }
        if (this.ggq < this.fZS.fTQ.fTR.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.ggq + 1)).append("/").append(this.fZS.fTQ.fTR.size()).append(" ");
            sb.append(this.fZS.fTQ.fTR.get(this.ggq));
            this.ggn.setText(sb.toString());
        } else {
            this.ggn.setText(a.i.ala_live_face_done_tips);
        }
        this.ggn.scrollTo(0, 0);
        this.ggo.setText(a.i.ala_live_face_next);
        if (this.fZS.fTQ.fTR.size() - 1 == this.ggq) {
            this.ggo.setText(a.i.ala_live_face_done);
        } else if (this.fZS.fTQ.fTR.size() == this.ggq) {
            this.ggo.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fZS = hVar;
        if (this.fZS != null && this.fZS.fTQ != null && this.fZS.fTQ.fTR != null && this.fZS.fTQ.fTR.size() > 0) {
            this.ggq = 0;
            bGK();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.ggl) {
            this.ggq--;
            bGK();
        } else if (view == this.ggo) {
            if (this.ggq == this.fZS.fTQ.fTR.size()) {
                if (this.ggp != null) {
                    this.ggp.Qv();
                    return;
                }
                return;
            }
            this.ggq++;
            bGK();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.ggp = aVar;
    }
}
