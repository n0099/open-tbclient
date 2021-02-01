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
import com.baidu.live.data.aw;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes11.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private aw hJw;
    private ImageView hQc;
    private TextView hQd;
    private TextView hQe;
    private Button hQf;
    private a hQg;
    private int hQh;
    private TextView mHelp;

    /* loaded from: classes11.dex */
    public interface a {
        void cit();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.hQh = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQh = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQh = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.g.ala_live_face_verify_layout, this);
        this.hQf = (Button) findViewById(a.f.ala_live_face_btn);
        this.hQc = (ImageView) findViewById(a.f.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.f.ala_live_face_help);
        this.hQd = (TextView) findViewById(a.f.ala_live_face_error_tips);
        this.hQe = (TextView) findViewById(a.f.ala_live_face_questions_text);
        this.hQe.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hQf.setOnClickListener(this);
        this.hQc.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void ckZ() {
        if (this.hQh <= 0) {
            this.hQh = 0;
        } else if (this.hQh > this.hJw.aOi.aOl.size()) {
            this.hQh = this.hJw.aOi.aOl.size();
        }
        if (this.hQh == 0) {
            this.hQc.setVisibility(4);
            this.hQd.setVisibility(0);
        } else {
            this.hQc.setVisibility(0);
            this.hQd.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.hJw.aOi.notify)) {
            this.hQd.setText(a.h.ala_live_face_question_tips);
        } else {
            this.hQd.setText(this.hJw.aOi.notify);
        }
        if (this.hQh < this.hJw.aOi.aOl.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.hQh + 1)).append("/").append(this.hJw.aOi.aOl.size()).append(" ");
            sb.append(this.hJw.aOi.aOl.get(this.hQh));
            this.hQe.setText(sb.toString());
        } else {
            this.hQe.setText(a.h.ala_live_face_done_tips);
        }
        this.hQe.scrollTo(0, 0);
        this.hQf.setText(a.h.ala_live_face_next);
        if (this.hJw.aOi.aOl.size() - 1 == this.hQh) {
            this.hQf.setText(a.h.ala_live_face_done);
        } else if (this.hJw.aOi.aOl.size() == this.hQh) {
            this.hQf.setText(a.h.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(aw awVar) {
        this.hJw = awVar;
        if (this.hJw != null && this.hJw.aOi != null && this.hJw.aOi.aOl != null && this.hJw.aOi.aOl.size() > 0) {
            this.hQh = 0;
            ckZ();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.c(bbPageContext.getPageActivity())));
            }
        } else if (view == this.hQc) {
            this.hQh--;
            ckZ();
        } else if (view == this.hQf) {
            if (this.hQh == this.hJw.aOi.aOl.size()) {
                if (this.hQg != null) {
                    this.hQg.cit();
                    return;
                }
                return;
            }
            this.hQh++;
            ckZ();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.hQg = aVar;
    }
}
