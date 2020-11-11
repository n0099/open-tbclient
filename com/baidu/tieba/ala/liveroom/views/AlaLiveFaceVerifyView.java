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
import com.baidu.live.data.ap;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes4.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ap hoF;
    private ImageView hvc;
    private TextView hvd;
    private TextView hve;
    private Button hvf;
    private a hvg;
    private int hvh;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void afA();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hvh = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvh = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvh = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hvf = (Button) findViewById(a.f.ala_live_face_btn);
        this.hvc = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hvd = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hve = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hve.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hvf.setOnClickListener(this);
        this.hvc.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void chN() {
        if (this.hvh <= 0) {
            this.hvh = 0;
        } else if (this.hvh > this.hoF.aNY.aNZ.size()) {
            this.hvh = this.hoF.aNY.aNZ.size();
        }
        if (this.hvh == 0) {
            this.hvc.setVisibility(4);
            this.hvd.setVisibility(0);
        } else {
            this.hvc.setVisibility(0);
            this.hvd.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hoF.aNY.notify)) {
            this.hvd.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hvd.setText(this.hoF.aNY.notify);
        }
        if (this.hvh < this.hoF.aNY.aNZ.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hvh + 1)).append("/").append(this.hoF.aNY.aNZ.size()).append(" ");
            sb.append(this.hoF.aNY.aNZ.get(this.hvh));
            this.hve.setText(sb.toString());
        } else {
            this.hve.setText(a.h.ala_live_face_done_tips);
        }
        this.hve.scrollTo(0, 0);
        this.hvf.setText(a.h.ala_live_face_next);
        if (this.hoF.aNY.aNZ.size() - 1 == this.hvh) {
            this.hvf.setText(a.h.ala_live_face_done);
        } else if (this.hoF.aNY.aNZ.size() == this.hvh) {
            this.hvf.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ap apVar) {
        this.hoF = apVar;
        if (this.hoF != null && this.hoF.aNY != null && this.hoF.aNY.aNZ != null && this.hoF.aNY.aNZ.size() > 0) {
            this.hvh = 0;
            chN();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hvc) {
            this.hvh--;
            chN();
        } else if (view == this.hvf) {
            if (this.hvh == this.hoF.aNY.aNZ.size()) {
                if (this.hvg != null) {
                    this.hvg.afA();
                    return;
                }
                return;
            }
            this.hvh++;
            chN();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hvg = aVar;
    }
}
