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
import com.baidu.live.data.al;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes4.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private al gWY;
    private ImageView hdo;
    private TextView hdp;
    private TextView hdq;
    private Button hdr;
    private a hds;
    private int hdt;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void abg();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hdt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdt = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdt = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.hdr = (Button) findViewById(a.g.ala_live_face_btn);
        this.hdo = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.hdp = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.hdq = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.hdq.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hdr.setOnClickListener(this);
        this.hdo.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void ccg() {
        if (this.hdt <= 0) {
            this.hdt = 0;
        } else if (this.hdt > this.gWY.aMr.aMs.size()) {
            this.hdt = this.gWY.aMr.aMs.size();
        }
        if (this.hdt == 0) {
            this.hdo.setVisibility(4);
            this.hdp.setVisibility(0);
        } else {
            this.hdo.setVisibility(0);
            this.hdp.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gWY.aMr.notify)) {
            this.hdp.setText(a.i.ala_live_face_question_tips);
        } else {
            this.hdp.setText(this.gWY.aMr.notify);
        }
        if (this.hdt < this.gWY.aMr.aMs.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hdt + 1)).append("/").append(this.gWY.aMr.aMs.size()).append(" ");
            sb.append(this.gWY.aMr.aMs.get(this.hdt));
            this.hdq.setText(sb.toString());
        } else {
            this.hdq.setText(a.i.ala_live_face_done_tips);
        }
        this.hdq.scrollTo(0, 0);
        this.hdr.setText(a.i.ala_live_face_next);
        if (this.gWY.aMr.aMs.size() - 1 == this.hdt) {
            this.hdr.setText(a.i.ala_live_face_done);
        } else if (this.gWY.aMr.aMs.size() == this.hdt) {
            this.hdr.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(al alVar) {
        this.gWY = alVar;
        if (this.gWY != null && this.gWY.aMr != null && this.gWY.aMr.aMs != null && this.gWY.aMr.aMs.size() > 0) {
            this.hdt = 0;
            ccg();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hdo) {
            this.hdt--;
            ccg();
        } else if (view == this.hdr) {
            if (this.hdt == this.gWY.aMr.aMs.size()) {
                if (this.hds != null) {
                    this.hds.abg();
                    return;
                }
                return;
            }
            this.hdt++;
            ccg();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hds = aVar;
    }
}
