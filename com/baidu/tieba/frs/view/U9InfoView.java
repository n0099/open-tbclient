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
    private ForegroundColorSpan aGA;
    private ImageView aGB;
    private RelativeLayout aGq;
    private LinearLayout aGr;
    private HeadImageView aGs;
    private TextView aGt;
    private TextView aGu;
    private TextView aGv;
    private View aGw;
    private TextView aGx;
    private View aGy;
    private View.OnClickListener aGz;
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
        this.aGq = (RelativeLayout) findViewById(com.baidu.tieba.v.u9_top_code);
        this.aGr = (LinearLayout) findViewById(com.baidu.tieba.v.u9_news_info);
        this.aGs = (HeadImageView) findViewById(com.baidu.tieba.v.top_code_img);
        this.aGs.setSupportNoImage(false);
        this.aGt = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_summary_text);
        this.aGu = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_surplus_text);
        this.aGv = (TextView) findViewById(com.baidu.tieba.v.top_code_getnum_btn);
        this.aGw = findViewById(com.baidu.tieba.v.u9_top_code_divider);
        this.aGB = (ImageView) findViewById(com.baidu.tieba.v.news_info_img);
        this.aGB.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.u.icon_frs_news));
        this.aGx = (TextView) findViewById(com.baidu.tieba.v.news_info_text);
        this.aGy = findViewById(com.baidu.tieba.v.u9_news_info_divider);
        this.aGA = new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aGz = new ac(this);
        Hb();
    }

    public void a(com.baidu.tbadk.core.data.r rVar, com.baidu.tbadk.core.data.u uVar) {
        this.top_code = rVar;
        this.news_info = uVar;
        if (this.top_code == null) {
            this.aGq.setVisibility(8);
            this.aGw.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.kK()) || TextUtils.isEmpty(this.top_code.kK().trim())) {
            this.aGq.setVisibility(8);
            this.aGw.setVisibility(8);
        } else {
            this.aGq.setVisibility(0);
            this.aGw.setVisibility(0);
            this.aGs.c(this.top_code.kJ(), 10, false);
            this.aGt.setText(this.top_code.kK());
            if (TextUtils.isEmpty(this.top_code.kN()) || TextUtils.isEmpty(this.top_code.kN().trim())) {
                this.aGu.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.y.u9_shengyu)) + this.top_code.kN());
                spannableString.setSpan(this.aGA, 0, 2, 34);
                this.aGu.setText(spannableString);
                this.aGu.setVisibility(0);
            }
            if (this.top_code.kM() == 2) {
                this.aGv.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_taohao));
            } else {
                this.aGv.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(uVar.kK())) {
            this.aGr.setVisibility(8);
            this.aGy.setVisibility(8);
            return;
        }
        this.aGr.setVisibility(0);
        this.aGy.setVisibility(0);
        this.aGx.setText(uVar.kK());
    }

    public void Hb() {
        this.aGq.setOnClickListener(this.aGz);
        this.aGr.setOnClickListener(this.aGz);
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
        aw.h(this.aGB, com.baidu.tieba.u.icon_frs_news);
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(i == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this);
        }
    }
}
