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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.ala.liveroom.data.h;
/* loaded from: classes2.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private h fdE;
    private ImageView fjp;
    private TextView fjq;
    private TextView fjr;
    private Button fjs;
    private a fjt;
    private int fju;
    private TextView mHelp;

    /* loaded from: classes2.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fju = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fju = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fju = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fjs = (Button) findViewById(a.g.ala_live_face_btn);
        this.fjp = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fjq = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fjr = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fjr.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fjs.setOnClickListener(this);
        this.fjp.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bpj() {
        if (this.fju <= 0) {
            this.fju = 0;
        } else if (this.fju > this.fdE.eXe.eXf.size()) {
            this.fju = this.fdE.eXe.eXf.size();
        }
        if (this.fju == 0) {
            this.fjp.setVisibility(4);
            this.fjq.setVisibility(0);
        } else {
            this.fjp.setVisibility(0);
            this.fjq.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fdE.eXe.notify)) {
            this.fjq.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fjq.setText(this.fdE.eXe.notify);
        }
        if (this.fju < this.fdE.eXe.eXf.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fju + 1)).append("/").append(this.fdE.eXe.eXf.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.fdE.eXe.eXf.get(this.fju));
            this.fjr.setText(sb.toString());
        } else {
            this.fjr.setText(a.i.ala_live_face_done_tips);
        }
        this.fjr.scrollTo(0, 0);
        this.fjs.setText(a.i.ala_live_face_next);
        if (this.fdE.eXe.eXf.size() - 1 == this.fju) {
            this.fjs.setText(a.i.ala_live_face_done);
        } else if (this.fdE.eXe.eXf.size() == this.fju) {
            this.fjs.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fdE = hVar;
        if (this.fdE != null && this.fdE.eXe != null && this.fdE.eXe.eXf != null && this.fdE.eXe.eXf.size() > 0) {
            this.fju = 0;
            bpj();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fjp) {
            this.fju--;
            bpj();
        } else if (view == this.fjs) {
            if (this.fju == this.fdE.eXe.eXf.size()) {
                if (this.fjt != null) {
                    this.fjt.onFinished();
                    return;
                }
                return;
            }
            this.fju++;
            bpj();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fjt = aVar;
    }
}
