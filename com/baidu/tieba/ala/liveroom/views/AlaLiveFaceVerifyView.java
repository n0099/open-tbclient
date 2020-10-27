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
import com.baidu.live.data.ao;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes4.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ao hiO;
    private ImageView hpe;
    private TextView hpf;
    private TextView hpg;
    private Button hph;
    private a hpi;
    private int hpj;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void ada();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hpj = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpj = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpj = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.hph = (Button) findViewById(a.g.ala_live_face_btn);
        this.hpe = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.hpf = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.hpg = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.hpg.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hph.setOnClickListener(this);
        this.hpe.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void cfk() {
        if (this.hpj <= 0) {
            this.hpj = 0;
        } else if (this.hpj > this.hiO.aMW.aMX.size()) {
            this.hpj = this.hiO.aMW.aMX.size();
        }
        if (this.hpj == 0) {
            this.hpe.setVisibility(4);
            this.hpf.setVisibility(0);
        } else {
            this.hpe.setVisibility(0);
            this.hpf.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hiO.aMW.notify)) {
            this.hpf.setText(a.i.ala_live_face_question_tips);
        } else {
            this.hpf.setText(this.hiO.aMW.notify);
        }
        if (this.hpj < this.hiO.aMW.aMX.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hpj + 1)).append("/").append(this.hiO.aMW.aMX.size()).append(" ");
            sb.append(this.hiO.aMW.aMX.get(this.hpj));
            this.hpg.setText(sb.toString());
        } else {
            this.hpg.setText(a.i.ala_live_face_done_tips);
        }
        this.hpg.scrollTo(0, 0);
        this.hph.setText(a.i.ala_live_face_next);
        if (this.hiO.aMW.aMX.size() - 1 == this.hpj) {
            this.hph.setText(a.i.ala_live_face_done);
        } else if (this.hiO.aMW.aMX.size() == this.hpj) {
            this.hph.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ao aoVar) {
        this.hiO = aoVar;
        if (this.hiO != null && this.hiO.aMW != null && this.hiO.aMW.aMX != null && this.hiO.aMW.aMX.size() > 0) {
            this.hpj = 0;
            cfk();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hpe) {
            this.hpj--;
            cfk();
        } else if (view == this.hph) {
            if (this.hpj == this.hiO.aMW.aMX.size()) {
                if (this.hpi != null) {
                    this.hpi.ada();
                    return;
                }
                return;
            }
            this.hpj++;
            cfk();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hpi = aVar;
    }
}
