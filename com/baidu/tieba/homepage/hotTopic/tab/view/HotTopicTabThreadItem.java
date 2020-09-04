package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes16.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> ahY;
    private TextView aiy;
    private TextView aiz;
    private TextView dSD;
    private int iLX;
    private TbImageView iMf;
    private View iMg;
    private View iMh;
    private ImageView iMi;
    private TextView iMj;
    private View iMk;
    private e iMl;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iLX = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.iMf = (TbImageView) findViewById(R.id.coverView);
        this.iMg = findViewById(R.id.coverGradientMask);
        this.iMh = findViewById(R.id.videoTimeContainer);
        this.iMi = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMj = (TextView) findViewById(R.id.videoPlayTime);
        this.aiy = (TextView) findViewById(R.id.indexView);
        this.dSD = (TextView) findViewById(R.id.titleView);
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.iMf.setPlaceHolder(2);
        this.iMf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iMf.setConrers(15);
        this.iMk = findViewById(R.id.rootLayout);
        this.iMk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.iMl != null && HotTopicTabThreadItem.this.iMl.dUW != null) {
                    if (HotTopicTabThreadItem.this.ahY != null) {
                        HotTopicTabThreadItem.this.ahY.a(view, HotTopicTabThreadItem.this.iMl, HotTopicTabThreadItem.this.iMl.index, HotTopicTabThreadItem.this.iMl.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.iMl.dUW, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ahY = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.iMl = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.iMf.setVisibility(8);
                this.iMg.setVisibility(8);
                this.iMh.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiz.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.aiz.setLayoutParams(layoutParams);
            } else {
                this.iMf.startLoad(eVar.cover, 10, false);
                this.iMf.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiz.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aiz.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.iMh.setVisibility(0);
                    this.iMg.setVisibility(0);
                    this.iMj.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.iMh.setVisibility(8);
                    this.iMg.setVisibility(8);
                }
            }
            this.dSD.setText(eVar.title);
            this.aiz.setText(this.aiz.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cR(eVar.eeD < 1000 ? 1000 : eVar.eeD)));
            this.aiy.setText(String.valueOf(eVar.index));
            cxI();
            if (this.ahY != null && this.iMl != null) {
                this.ahY.b(this, this.iMl, this.iMl.index, this.iMl.index);
            }
        }
    }

    private void cxI() {
        if (this.iMl != null) {
            int oa = TagTextHelper.oa(this.iMl.index);
            Drawable background = this.aiz.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oa));
            background.setAlpha(40);
            this.aiz.setBackgroundDrawable(background);
            ap.setViewTextColor(this.aiz, oa);
            Drawable background2 = this.aiy.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oa));
            this.aiy.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iMk, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiy, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMj, R.color.cp_cont_a);
            this.iMi.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cxI();
            this.iLX = i;
        }
    }
}
