package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private RelativeLayout aGA;
    private LinearLayout aGB;
    private HeadImageView aGC;
    private TextView aGD;
    private TextView aGE;
    private TextView aGF;
    private View aGG;
    private TextView aGH;
    private View aGI;
    private View.OnClickListener aGJ;
    private ForegroundColorSpan aGK;
    private ImageView aGL;
    private Context mContext;
    private com.baidu.tbadk.core.data.u news_info;
    private com.baidu.tbadk.core.data.r top_code;

    public U9InfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        nu();
    }

    public U9InfoView(Context context) {
        super(context);
    }

    public void nu() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.u9_info_layout, this, true);
        this.aGA = (RelativeLayout) findViewById(com.baidu.tieba.v.u9_top_code);
        this.aGB = (LinearLayout) findViewById(com.baidu.tieba.v.u9_news_info);
        this.aGC = (HeadImageView) findViewById(com.baidu.tieba.v.top_code_img);
        this.aGC.setSupportNoImage(false);
        this.aGD = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_summary_text);
        this.aGE = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_surplus_text);
        this.aGF = (TextView) findViewById(com.baidu.tieba.v.top_code_getnum_btn);
        this.aGG = findViewById(com.baidu.tieba.v.u9_top_code_divider);
        this.aGL = (ImageView) findViewById(com.baidu.tieba.v.news_info_img);
        this.aGL.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.u.icon_frs_news));
        this.aGH = (TextView) findViewById(com.baidu.tieba.v.news_info_text);
        this.aGI = findViewById(com.baidu.tieba.v.u9_news_info_divider);
        this.aGK = new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aGJ = new ac(this);
        Hd();
    }

    public void a(com.baidu.tbadk.core.data.r rVar, com.baidu.tbadk.core.data.u uVar) {
        this.top_code = rVar;
        this.news_info = uVar;
        if (this.top_code == null) {
            this.aGA.setVisibility(8);
            this.aGG.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.kK()) || TextUtils.isEmpty(this.top_code.kK().trim())) {
            this.aGA.setVisibility(8);
            this.aGG.setVisibility(8);
        } else {
            this.aGA.setVisibility(0);
            this.aGG.setVisibility(0);
            this.aGC.c(this.top_code.kJ(), 10, false);
            this.aGD.setText(this.top_code.kK());
            if (TextUtils.isEmpty(this.top_code.kN()) || TextUtils.isEmpty(this.top_code.kN().trim())) {
                this.aGE.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.y.u9_shengyu)) + this.top_code.kN());
                spannableString.setSpan(this.aGK, 0, 2, 34);
                this.aGE.setText(spannableString);
                this.aGE.setVisibility(0);
            }
            if (this.top_code.kM() == 2) {
                this.aGF.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_taohao));
            } else {
                this.aGF.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(uVar.kK())) {
            this.aGB.setVisibility(8);
            this.aGI.setVisibility(8);
            return;
        }
        this.aGB.setVisibility(0);
        this.aGI.setVisibility(0);
        this.aGH.setText(uVar.kK());
    }

    public void Hd() {
        this.aGA.setOnClickListener(this.aGJ);
        this.aGB.setOnClickListener(this.aGJ);
    }

    public com.baidu.tbadk.core.data.r getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.r rVar) {
        this.top_code = rVar;
    }

    public com.baidu.tbadk.core.data.u getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.u uVar) {
        this.news_info = uVar;
    }

    public void bN(int i) {
        aw.h(this.aGL, com.baidu.tieba.u.icon_frs_news);
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this);
        }
    }
}
