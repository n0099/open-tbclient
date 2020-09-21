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
    private al gIy;
    private ImageView gOr;
    private TextView gOs;
    private TextView gOt;
    private Button gOu;
    private a gOv;
    private int gOw;
    private TextView mHelp;

    /* loaded from: classes4.dex */
    public interface a {
        void Yu();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.gOw = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOw = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOw = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.gOu = (Button) findViewById(a.g.ala_live_face_btn);
        this.gOr = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.gOs = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.gOt = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.gOt.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.gOu.setOnClickListener(this);
        this.gOr.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bYG() {
        if (this.gOw <= 0) {
            this.gOw = 0;
        } else if (this.gOw > this.gIy.aJm.aJn.size()) {
            this.gOw = this.gIy.aJm.aJn.size();
        }
        if (this.gOw == 0) {
            this.gOr.setVisibility(4);
            this.gOs.setVisibility(0);
        } else {
            this.gOr.setVisibility(0);
            this.gOs.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.gIy.aJm.notify)) {
            this.gOs.setText(a.i.ala_live_face_question_tips);
        } else {
            this.gOs.setText(this.gIy.aJm.notify);
        }
        if (this.gOw < this.gIy.aJm.aJn.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.gOw + 1)).append("/").append(this.gIy.aJm.aJn.size()).append(" ");
            sb.append(this.gIy.aJm.aJn.get(this.gOw));
            this.gOt.setText(sb.toString());
        } else {
            this.gOt.setText(a.i.ala_live_face_done_tips);
        }
        this.gOt.scrollTo(0, 0);
        this.gOu.setText(a.i.ala_live_face_next);
        if (this.gIy.aJm.aJn.size() - 1 == this.gOw) {
            this.gOu.setText(a.i.ala_live_face_done);
        } else if (this.gIy.aJm.aJn.size() == this.gOw) {
            this.gOu.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(al alVar) {
        this.gIy = alVar;
        if (this.gIy != null && this.gIy.aJm != null && this.gIy.aJm.aJn != null && this.gIy.aJm.aJn.size() > 0) {
            this.gOw = 0;
            bYG();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.gOr) {
            this.gOw--;
            bYG();
        } else if (view == this.gOu) {
            if (this.gOw == this.gIy.aJm.aJn.size()) {
                if (this.gOv != null) {
                    this.gOv.Yu();
                    return;
                }
                return;
            }
            this.gOw++;
            bYG();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.gOv = aVar;
    }
}
