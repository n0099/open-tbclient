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
    private h gad;
    private a ggA;
    private int ggB;
    private ImageView ggw;
    private TextView ggx;
    private TextView ggy;
    private Button ggz;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void Qv();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.ggB = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggB = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggB = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.ggz = (Button) findViewById(a.g.ala_live_face_btn);
        this.ggw = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.ggx = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.ggy = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.ggy.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.ggz.setOnClickListener(this);
        this.ggw.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bGM() {
        if (this.ggB <= 0) {
            this.ggB = 0;
        } else if (this.ggB > this.gad.fUb.fUc.size()) {
            this.ggB = this.gad.fUb.fUc.size();
        }
        if (this.ggB == 0) {
            this.ggw.setVisibility(4);
            this.ggx.setVisibility(0);
        } else {
            this.ggw.setVisibility(0);
            this.ggx.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gad.fUb.notify)) {
            this.ggx.setText(a.i.ala_live_face_question_tips);
        } else {
            this.ggx.setText(this.gad.fUb.notify);
        }
        if (this.ggB < this.gad.fUb.fUc.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.ggB + 1)).append("/").append(this.gad.fUb.fUc.size()).append(" ");
            sb.append(this.gad.fUb.fUc.get(this.ggB));
            this.ggy.setText(sb.toString());
        } else {
            this.ggy.setText(a.i.ala_live_face_done_tips);
        }
        this.ggy.scrollTo(0, 0);
        this.ggz.setText(a.i.ala_live_face_next);
        if (this.gad.fUb.fUc.size() - 1 == this.ggB) {
            this.ggz.setText(a.i.ala_live_face_done);
        } else if (this.gad.fUb.fUc.size() == this.ggB) {
            this.ggz.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.gad = hVar;
        if (this.gad != null && this.gad.fUb != null && this.gad.fUb.fUc != null && this.gad.fUb.fUc.size() > 0) {
            this.ggB = 0;
            bGM();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.ggw) {
            this.ggB--;
            bGM();
        } else if (view == this.ggz) {
            if (this.ggB == this.gad.fUb.fUc.size()) {
                if (this.ggA != null) {
                    this.ggA.Qv();
                    return;
                }
                return;
            }
            this.ggB++;
            bGM();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.ggA = aVar;
    }
}
