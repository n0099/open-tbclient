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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes16.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> agN;
    private TextView dJr;
    private int iwV;
    private TextView ixh;
    private TextView ixi;
    private TbImageView ixo;
    private View ixp;
    private View ixq;
    private ImageView ixr;
    private TextView ixs;
    private View ixt;
    private e ixu;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iwV = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.ixo = (TbImageView) findViewById(R.id.coverView);
        this.ixp = findViewById(R.id.coverGradientMask);
        this.ixq = findViewById(R.id.videoTimeContainer);
        this.ixr = (ImageView) findViewById(R.id.videoPlayIcon);
        this.ixs = (TextView) findViewById(R.id.videoPlayTime);
        this.ixh = (TextView) findViewById(R.id.indexView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.ixi = (TextView) findViewById(R.id.tagView);
        this.ixo.setPlaceHolder(2);
        this.ixo.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixo.setConrers(15);
        this.ixt = findViewById(R.id.rootLayout);
        this.ixt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.ixu != null && HotTopicTabThreadItem.this.ixu.dLK != null) {
                    if (HotTopicTabThreadItem.this.agN != null) {
                        HotTopicTabThreadItem.this.agN.a(view, HotTopicTabThreadItem.this.ixu, HotTopicTabThreadItem.this.ixu.index, HotTopicTabThreadItem.this.ixu.index);
                    }
                    ax.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.ixu.dLK, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.agN = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ixu = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.ixo.setVisibility(8);
                this.ixp.setVisibility(8);
                this.ixq.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixi.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ixi.setLayoutParams(layoutParams);
            } else {
                this.ixo.startLoad(eVar.cover, 10, false);
                this.ixo.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ixi.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ixi.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.ixq.setVisibility(0);
                    this.ixp.setVisibility(0);
                    this.ixs.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.ixq.setVisibility(8);
                    this.ixp.setVisibility(8);
                }
            }
            this.dJr.setText(eVar.title);
            if (eVar.aoJ > 0) {
                this.ixi.setVisibility(0);
                this.ixi.setText(this.ixi.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, as.cG(eVar.aoJ)));
            } else {
                this.ixi.setVisibility(4);
            }
            this.ixh.setText("" + eVar.index);
            cmS();
            if (this.agN != null && this.ixu != null) {
                this.agN.b(this, this.ixu, this.ixu.index, this.ixu.index);
            }
        }
    }

    private void cmS() {
        if (this.ixu != null) {
            int lU = TagTextHelper.lU(this.ixu.index);
            Drawable background = this.ixi.getBackground();
            DrawableCompat.setTint(background, ao.getColor(lU));
            background.setAlpha(40);
            this.ixi.setBackgroundDrawable(background);
            ao.setViewTextColor(this.ixi, lU);
            Drawable background2 = this.ixh.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(lU));
            this.ixh.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            a.h(this.ixt, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.ixh, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixs, R.color.cp_cont_a);
            this.ixr.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cmS();
            this.iwV = i;
        }
    }
}
