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
    private g elq;
    private ImageView eqB;
    private TextView eqC;
    private TextView eqD;
    private Button eqE;
    private a eqF;
    private int eqG;
    private TextView mHelp;

    /* loaded from: classes6.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.eqG = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqG = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqG = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.eqE = (Button) findViewById(a.g.ala_live_face_btn);
        this.eqB = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.eqC = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.eqD = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.eqD.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.eqE.setOnClickListener(this);
        this.eqB.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void aWw() {
        if (this.eqG <= 0) {
            this.eqG = 0;
        } else if (this.eqG > this.elq.egg.egh.size()) {
            this.eqG = this.elq.egg.egh.size();
        }
        if (this.eqG == 0) {
            this.eqB.setVisibility(4);
            this.eqC.setVisibility(0);
        } else {
            this.eqB.setVisibility(0);
            this.eqC.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.elq.egg.notify)) {
            this.eqC.setText(a.i.ala_live_face_question_tips);
        } else {
            this.eqC.setText(this.elq.egg.notify);
        }
        if (this.eqG < this.elq.egg.egh.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.eqG + 1)).append("/").append(this.elq.egg.egh.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.elq.egg.egh.get(this.eqG));
            this.eqD.setText(sb.toString());
        } else {
            this.eqD.setText(a.i.ala_live_face_done_tips);
        }
        this.eqD.scrollTo(0, 0);
        this.eqE.setText(a.i.ala_live_face_next);
        if (this.elq.egg.egh.size() - 1 == this.eqG) {
            this.eqE.setText(a.i.ala_live_face_done);
        } else if (this.elq.egg.egh.size() == this.eqG) {
            this.eqE.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(g gVar) {
        this.elq = gVar;
        if (this.elq != null && this.elq.egg != null && this.elq.egg.egh != null && this.elq.egg.egh.size() > 0) {
            this.eqG = 0;
            aWw();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.eqB) {
            this.eqG--;
            aWw();
        } else if (view == this.eqE) {
            if (this.eqG == this.elq.egg.egh.size()) {
                if (this.eqF != null) {
                    this.eqF.onFinished();
                    return;
                }
                return;
            }
            this.eqG++;
            aWw();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.eqF = aVar;
    }
}
