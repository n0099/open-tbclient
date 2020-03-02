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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.data.h;
/* loaded from: classes3.dex */
public class AlaLiveFaceVerifyView extends LinearLayout implements View.OnClickListener {
    private h fgP;
    private ImageView fmk;
    private TextView fml;
    private TextView fmm;
    private Button fmn;
    private a fmo;
    private int fmp;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fmp = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmp = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmp = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fmn = (Button) findViewById(a.g.ala_live_face_btn);
        this.fmk = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fml = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fmm = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fmm.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fmn.setOnClickListener(this);
        this.fmk.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bqR() {
        if (this.fmp <= 0) {
            this.fmp = 0;
        } else if (this.fmp > this.fgP.faW.faX.size()) {
            this.fmp = this.fgP.faW.faX.size();
        }
        if (this.fmp == 0) {
            this.fmk.setVisibility(4);
            this.fml.setVisibility(0);
        } else {
            this.fmk.setVisibility(0);
            this.fml.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fgP.faW.notify)) {
            this.fml.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fml.setText(this.fgP.faW.notify);
        }
        if (this.fmp < this.fgP.faW.faX.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fmp + 1)).append("/").append(this.fgP.faW.faX.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.fgP.faW.faX.get(this.fmp));
            this.fmm.setText(sb.toString());
        } else {
            this.fmm.setText(a.i.ala_live_face_done_tips);
        }
        this.fmm.scrollTo(0, 0);
        this.fmn.setText(a.i.ala_live_face_next);
        if (this.fgP.faW.faX.size() - 1 == this.fmp) {
            this.fmn.setText(a.i.ala_live_face_done);
        } else if (this.fgP.faW.faX.size() == this.fmp) {
            this.fmn.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fgP = hVar;
        if (this.fgP != null && this.fgP.faW != null && this.fgP.faW.faX != null && this.fgP.faW.faX.size() > 0) {
            this.fmp = 0;
            bqR();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fmk) {
            this.fmp--;
            bqR();
        } else if (view == this.fmn) {
            if (this.fmp == this.fgP.faW.faX.size()) {
                if (this.fmo != null) {
                    this.fmo.onFinished();
                    return;
                }
                return;
            }
            this.fmp++;
            bqR();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fmo = aVar;
    }
}
