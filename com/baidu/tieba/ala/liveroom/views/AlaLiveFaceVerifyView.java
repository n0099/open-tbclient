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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes2.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private g faQ;
    private ImageView fge;
    private TextView fgf;
    private TextView fgg;
    private Button fgh;
    private a fgi;
    private int fgj;
    private TextView mHelp;

    /* loaded from: classes2.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fgj = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgj = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgj = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fgh = (Button) findViewById(a.g.ala_live_face_btn);
        this.fge = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fgf = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fgg = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fgg.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fgh.setOnClickListener(this);
        this.fge.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void boi() {
        if (this.fgj <= 0) {
            this.fgj = 0;
        } else if (this.fgj > this.faQ.eVj.eVk.size()) {
            this.fgj = this.faQ.eVj.eVk.size();
        }
        if (this.fgj == 0) {
            this.fge.setVisibility(4);
            this.fgf.setVisibility(0);
        } else {
            this.fge.setVisibility(0);
            this.fgf.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.faQ.eVj.notify)) {
            this.fgf.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fgf.setText(this.faQ.eVj.notify);
        }
        if (this.fgj < this.faQ.eVj.eVk.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fgj + 1)).append("/").append(this.faQ.eVj.eVk.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.faQ.eVj.eVk.get(this.fgj));
            this.fgg.setText(sb.toString());
        } else {
            this.fgg.setText(a.i.ala_live_face_done_tips);
        }
        this.fgg.scrollTo(0, 0);
        this.fgh.setText(a.i.ala_live_face_next);
        if (this.faQ.eVj.eVk.size() - 1 == this.fgj) {
            this.fgh.setText(a.i.ala_live_face_done);
        } else if (this.faQ.eVj.eVk.size() == this.fgj) {
            this.fgh.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(g gVar) {
        this.faQ = gVar;
        if (this.faQ != null && this.faQ.eVj != null && this.faQ.eVj.eVk != null && this.faQ.eVj.eVk.size() > 0) {
            this.fgj = 0;
            boi();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fge) {
            this.fgj--;
            boi();
        } else if (view == this.fgh) {
            if (this.fgj == this.faQ.eVj.eVk.size()) {
                if (this.fgi != null) {
                    this.fgi.onFinished();
                    return;
                }
                return;
            }
            this.fgj++;
            boi();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fgi = aVar;
    }
}
