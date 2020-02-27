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
    private h fgO;
    private ImageView fmj;
    private TextView fmk;
    private TextView fml;
    private Button fmm;
    private a fmn;
    private int fmo;
    private TextView mHelp;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinished();
    }

    public AlaLiveFaceVerifyView(Context context) {
        super(context);
        this.fmo = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmo = 0;
        init();
    }

    public AlaLiveFaceVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmo = 0;
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_live_face_verify_layout, this);
        this.fmm = (Button) findViewById(a.g.ala_live_face_btn);
        this.fmj = (ImageView) findViewById(a.g.ala_live_face_verify_pre);
        this.mHelp = (TextView) findViewById(a.g.ala_live_face_help);
        this.fmk = (TextView) findViewById(a.g.ala_live_face_error_tips);
        this.fml = (TextView) findViewById(a.g.ala_live_face_questions_text);
        this.fml.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.fmm.setOnClickListener(this);
        this.fmj.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
    }

    private void bqP() {
        if (this.fmo <= 0) {
            this.fmo = 0;
        } else if (this.fmo > this.fgO.faV.faW.size()) {
            this.fmo = this.fgO.faV.faW.size();
        }
        if (this.fmo == 0) {
            this.fmj.setVisibility(4);
            this.fmk.setVisibility(0);
        } else {
            this.fmj.setVisibility(0);
            this.fmk.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.fgO.faV.notify)) {
            this.fmk.setText(a.i.ala_live_face_question_tips);
        } else {
            this.fmk.setText(this.fgO.faV.notify);
        }
        if (this.fmo < this.fgO.faV.faW.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.fmo + 1)).append("/").append(this.fgO.faV.faW.size()).append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.fgO.faV.faW.get(this.fmo));
            this.fml.setText(sb.toString());
        } else {
            this.fml.setText(a.i.ala_live_face_done_tips);
        }
        this.fml.scrollTo(0, 0);
        this.fmm.setText(a.i.ala_live_face_next);
        if (this.fgO.faV.faW.size() - 1 == this.fmo) {
            this.fmm.setText(a.i.ala_live_face_done);
        } else if (this.fgO.faV.faW.size() == this.fmo) {
            this.fmm.setText(a.i.sdk_dialog_ok);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setData(h hVar) {
        this.fgO = hVar;
        if (this.fgO != null && this.fgO.faV != null && this.fgO.faV.faW != null && this.fgO.faV.faW.size() > 0) {
            this.fmo = 0;
            bqP();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHelp) {
            BdPageContext<?> bbPageContext = IScrollableHelper.getBbPageContext(getContext());
            if (bbPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.b(bbPageContext.getPageActivity())));
            }
        } else if (view == this.fmj) {
            this.fmo--;
            bqP();
        } else if (view == this.fmm) {
            if (this.fmo == this.fgO.faV.faW.size()) {
                if (this.fmn != null) {
                    this.fmn.onFinished();
                    return;
                }
                return;
            }
            this.fmo++;
            bqP();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.fmn = aVar;
    }
}
