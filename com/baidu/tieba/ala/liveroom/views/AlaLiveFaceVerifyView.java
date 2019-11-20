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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes6.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private g ekz;
    private ImageView epK;
    private TextView epL;
    private TextView epM;
    private Button epN;
    private a epO;
    private int epP;
    private TextView mHelp;

    /* loaded from: classes6.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.epP = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epP = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epP = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.epN = (Button) findViewById(a.g.ala_live_face_btn);
        this.epK = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.epL = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.epM = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.epM.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.epN.setOnClickListener(this);
        this.epK.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void aWu() {
        if (this.epP <= 0) {
            this.epP = 0;
        } else if (this.epP > this.ekz.efp.efq.size()) {
            this.epP = this.ekz.efp.efq.size();
        }
        if (this.epP == 0) {
            this.epK.setVisibility(4);
            this.epL.setVisibility(0);
        } else {
            this.epK.setVisibility(0);
            this.epL.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.ekz.efp.notify)) {
            this.epL.setText(a.i.ala_live_face_question_tips);
        } else {
            this.epL.setText(this.ekz.efp.notify);
        }
        if (this.epP < this.ekz.efp.efq.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.epP + 1)).append("/").append(this.ekz.efp.efq.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.ekz.efp.efq.get(this.epP));
            this.epM.setText(sb.toString());
        } else {
            this.epM.setText(a.i.ala_live_face_done_tips);
        }
        this.epM.scrollTo(0, 0);
        this.epN.setText(a.i.ala_live_face_next);
        if (this.ekz.efp.efq.size() - 1 == this.epP) {
            this.epN.setText(a.i.ala_live_face_done);
        } else if (this.ekz.efp.efq.size() == this.epP) {
            this.epN.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(g gVar) {
        this.ekz = gVar;
        if (this.ekz != null && this.ekz.efp != null && this.ekz.efp.efq != null && this.ekz.efp.efq.size() > 0) {
            this.epP = 0;
            aWu();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.epK) {
            this.epP--;
            aWu();
        } else if (view == this.epN) {
            if (this.epP == this.ekz.efp.efq.size()) {
                if (this.epO != null) {
                    this.epO.onFinished();
                    return;
                }
                return;
            }
            this.epP++;
            aWu();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.epO = aVar;
    }
}
