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
/* loaded from: classes11.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private aw hJK;
    private ImageView hQq;
    private TextView hQr;
    private TextView hQs;
    private Button hQt;
    private a hQu;
    private int hQv;
    private TextView mHelp;

    /* loaded from: classes11.dex */
    public interface a {
        void ciA();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hQv = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQv = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQv = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hQt = (Button) findViewById(a.f.ala_live_face_btn);
        this.hQq = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hQr = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hQs = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hQs.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hQt.setOnClickListener(this);
        this.hQq.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void clg() {
        if (this.hQv <= 0) {
            this.hQv = 0;
        } else if (this.hQv > this.hJK.aOi.aOl.size()) {
            this.hQv = this.hJK.aOi.aOl.size();
        }
        if (this.hQv == 0) {
            this.hQq.setVisibility(4);
            this.hQr.setVisibility(0);
        } else {
            this.hQq.setVisibility(0);
            this.hQr.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hJK.aOi.notify)) {
            this.hQr.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hQr.setText(this.hJK.aOi.notify);
        }
        if (this.hQv < this.hJK.aOi.aOl.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hQv + 1)).append("/").append(this.hJK.aOi.aOl.size()).append(" ");
            sb.append(this.hJK.aOi.aOl.get(this.hQv));
            this.hQs.setText(sb.toString());
        } else {
            this.hQs.setText(a.h.ala_live_face_done_tips);
        }
        this.hQs.scrollTo(0, 0);
        this.hQt.setText(a.h.ala_live_face_next);
        if (this.hJK.aOi.aOl.size() - 1 == this.hQv) {
            this.hQt.setText(a.h.ala_live_face_done);
        } else if (this.hJK.aOi.aOl.size() == this.hQv) {
            this.hQt.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(aw awVar) {
        this.hJK = awVar;
        if (this.hJK != null && this.hJK.aOi != null && this.hJK.aOi.aOl != null && this.hJK.aOi.aOl.size() > 0) {
            this.hQv = 0;
            clg();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hQq) {
            this.hQv--;
            clg();
        } else if (view == this.hQt) {
            if (this.hQv == this.hJK.aOi.aOl.size()) {
                if (this.hQu != null) {
                    this.hQu.ciA();
                    return;
                }
                return;
            }
            this.hQv++;
            clg();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hQu = aVar;
    }
}
