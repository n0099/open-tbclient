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
import com.baidu.live.data.ag;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private ag gFa;
    private ImageView gLb;
    private TextView gLc;
    private TextView gLd;
    private Button gLe;
    private a gLf;
    private int gLg;
    private TextView mHelp;

    /* loaded from: classes7.dex */
    public interface a {
        void XL();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.gLg = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLg = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLg = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.gLe = (Button) findViewById(a.g.ala_live_face_btn);
        this.gLb = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.gLc = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.gLd = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.gLd.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.gLe.setOnClickListener(this);
        this.gLb.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bWZ() {
        if (this.gLg <= 0) {
            this.gLg = 0;
        } else if (this.gLg > this.gFa.aHS.aHT.size()) {
            this.gLg = this.gFa.aHS.aHT.size();
        }
        if (this.gLg == 0) {
            this.gLb.setVisibility(4);
            this.gLc.setVisibility(0);
        } else {
            this.gLb.setVisibility(0);
            this.gLc.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gFa.aHS.notify)) {
            this.gLc.setText(a.i.ala_live_face_question_tips);
        } else {
            this.gLc.setText(this.gFa.aHS.notify);
        }
        if (this.gLg < this.gFa.aHS.aHT.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.gLg + 1)).append("/").append(this.gFa.aHS.aHT.size()).append(" ");
            sb.append(this.gFa.aHS.aHT.get(this.gLg));
            this.gLd.setText(sb.toString());
        } else {
            this.gLd.setText(a.i.ala_live_face_done_tips);
        }
        this.gLd.scrollTo(0, 0);
        this.gLe.setText(a.i.ala_live_face_next);
        if (this.gFa.aHS.aHT.size() - 1 == this.gLg) {
            this.gLe.setText(a.i.ala_live_face_done);
        } else if (this.gFa.aHS.aHT.size() == this.gLg) {
            this.gLe.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(ag agVar) {
        this.gFa = agVar;
        if (this.gFa != null && this.gFa.aHS != null && this.gFa.aHS.aHT != null && this.gFa.aHS.aHT.size() > 0) {
            this.gLg = 0;
            bWZ();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.gLb) {
            this.gLg--;
            bWZ();
        } else if (view == this.gLe) {
            if (this.gLg == this.gFa.aHS.aHT.size()) {
                if (this.gLf != null) {
                    this.gLf.XL();
                    return;
                }
                return;
            }
            this.gLg++;
            bWZ();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.gLf = aVar;
    }
}
