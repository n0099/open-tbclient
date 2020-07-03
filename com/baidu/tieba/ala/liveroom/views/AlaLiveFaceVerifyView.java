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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.ala.liveroom.data.h;
/* loaded from: classes3.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private h gnb;
    private ImageView gts;
    private TextView gtt;
    private TextView gtu;
    private Button gtv;
    private a gtw;
    private int gtx;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void RB();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.gtx = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtx = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtx = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.gtv = (Button) findViewById(a.g.ala_live_face_btn);
        this.gts = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.gtt = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.gtu = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.gtu.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.gtv.setOnClickListener(this);
        this.gts.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bJT() {
        if (this.gtx <= 0) {
            this.gtx = 0;
        } else if (this.gtx > this.gnb.ggI.ggJ.size()) {
            this.gtx = this.gnb.ggI.ggJ.size();
        }
        if (this.gtx == 0) {
            this.gts.setVisibility(4);
            this.gtt.setVisibility(0);
        } else {
            this.gts.setVisibility(0);
            this.gtt.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gnb.ggI.notify)) {
            this.gtt.setText(a.i.ala_live_face_question_tips);
        } else {
            this.gtt.setText(this.gnb.ggI.notify);
        }
        if (this.gtx < this.gnb.ggI.ggJ.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.gtx + 1)).append("/").append(this.gnb.ggI.ggJ.size()).append(" ");
            sb.append(this.gnb.ggI.ggJ.get(this.gtx));
            this.gtu.setText(sb.toString());
        } else {
            this.gtu.setText(a.i.ala_live_face_done_tips);
        }
        this.gtu.scrollTo(0, 0);
        this.gtv.setText(a.i.ala_live_face_next);
        if (this.gnb.ggI.ggJ.size() - 1 == this.gtx) {
            this.gtv.setText(a.i.ala_live_face_done);
        } else if (this.gnb.ggI.ggJ.size() == this.gtx) {
            this.gtv.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.gnb = hVar;
        if (this.gnb != null && this.gnb.ggI != null && this.gnb.ggI.ggJ != null && this.gnb.ggI.ggJ.size() > 0) {
            this.gtx = 0;
            bJT();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.gts) {
            this.gtx--;
            bJT();
        } else if (view == this.gtv) {
            if (this.gtx == this.gnb.ggI.ggJ.size()) {
                if (this.gtw != null) {
                    this.gtw.RB();
                    return;
                }
                return;
            }
            this.gtx++;
            bJT();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.gtw = aVar;
    }
}
