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
    private ap hom;
    private ImageView huJ;
    private TextView huK;
    private TextView huL;
    private Button huM;
    private a huN;
    private int huO;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void aeS();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.huO = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huO = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huO = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.huM = (Button) findViewById(a.f.ala_live_face_btn);
        this.huJ = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.huK = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.huL = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.huL.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.huM.setOnClickListener(this);
        this.huJ.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void chg() {
        if (this.huO <= 0) {
            this.huO = 0;
        } else if (this.huO > this.hom.aMn.aMo.size()) {
            this.huO = this.hom.aMn.aMo.size();
        }
        if (this.huO == 0) {
            this.huJ.setVisibility(4);
            this.huK.setVisibility(0);
        } else {
            this.huJ.setVisibility(0);
            this.huK.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hom.aMn.notify)) {
            this.huK.setText(a.h.ala_live_face_question_tips);
        } else {
            this.huK.setText(this.hom.aMn.notify);
        }
        if (this.huO < this.hom.aMn.aMo.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.huO + 1)).append("/").append(this.hom.aMn.aMo.size()).append(" ");
            sb.append(this.hom.aMn.aMo.get(this.huO));
            this.huL.setText(sb.toString());
        } else {
            this.huL.setText(a.h.ala_live_face_done_tips);
        }
        this.huL.scrollTo(0, 0);
        this.huM.setText(a.h.ala_live_face_next);
        if (this.hom.aMn.aMo.size() - 1 == this.huO) {
            this.huM.setText(a.h.ala_live_face_done);
        } else if (this.hom.aMn.aMo.size() == this.huO) {
            this.huM.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ap apVar) {
        this.hom = apVar;
        if (this.hom != null && this.hom.aMn != null && this.hom.aMn.aMo != null && this.hom.aMn.aMo.size() > 0) {
            this.huO = 0;
            chg();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.huJ) {
            this.huO--;
            chg();
        } else if (view == this.huM) {
            if (this.huO == this.hom.aMn.aMo.size()) {
                if (this.huN != null) {
                    this.huN.aeS();
                    return;
                }
                return;
            }
            this.huO++;
            chg();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.huN = aVar;
    }
}
