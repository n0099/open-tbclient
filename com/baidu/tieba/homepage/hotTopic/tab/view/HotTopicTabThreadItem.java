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
    private int iwT;
    private TextView ixf;
    private TextView ixg;
    private TbImageView ixm;
    private View ixn;
    private View ixo;
    private ImageView ixp;
    private TextView ixq;
    private View ixr;
    private e ixs;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iwT = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.ixm = (TbImageView) findViewById(R.id.coverView);
        this.ixn = findViewById(R.id.coverGradientMask);
        this.ixo = findViewById(R.id.videoTimeContainer);
        this.ixp = (ImageView) findViewById(R.id.videoPlayIcon);
        this.ixq = (TextView) findViewById(R.id.videoPlayTime);
        this.ixf = (TextView) findViewById(R.id.indexView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.ixg = (TextView) findViewById(R.id.tagView);
        this.ixm.setPlaceHolder(2);
        this.ixm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixm.setConrers(15);
        this.ixr = findViewById(R.id.rootLayout);
        this.ixr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.ixs != null && HotTopicTabThreadItem.this.ixs.dLK != null) {
                    if (HotTopicTabThreadItem.this.agN != null) {
                        HotTopicTabThreadItem.this.agN.a(view, HotTopicTabThreadItem.this.ixs, HotTopicTabThreadItem.this.ixs.index, HotTopicTabThreadItem.this.ixs.index);
                    }
                    ax.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.ixs.dLK, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.agN = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ixs = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.ixm.setVisibility(8);
                this.ixn.setVisibility(8);
                this.ixo.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixg.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ixg.setLayoutParams(layoutParams);
            } else {
                this.ixm.startLoad(eVar.cover, 10, false);
                this.ixm.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ixg.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ixg.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.ixo.setVisibility(0);
                    this.ixn.setVisibility(0);
                    this.ixq.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.ixo.setVisibility(8);
                    this.ixn.setVisibility(8);
                }
            }
            this.dJr.setText(eVar.title);
            if (eVar.aoJ > 0) {
                this.ixg.setVisibility(0);
                this.ixg.setText(this.ixg.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, as.cG(eVar.aoJ)));
            } else {
                this.ixg.setVisibility(4);
            }
            this.ixf.setText("" + eVar.index);
            cmS();
            if (this.agN != null && this.ixs != null) {
                this.agN.b(this, this.ixs, this.ixs.index, this.ixs.index);
            }
        }
    }

    private void cmS() {
        if (this.ixs != null) {
            int lU = TagTextHelper.lU(this.ixs.index);
            Drawable background = this.ixg.getBackground();
            DrawableCompat.setTint(background, ao.getColor(lU));
            background.setAlpha(40);
            this.ixg.setBackgroundDrawable(background);
            ao.setViewTextColor(this.ixg, lU);
            Drawable background2 = this.ixf.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(lU));
            this.ixf.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            a.h(this.ixr, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
            ao.setViewTextColor(this.ixf, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixq, R.color.cp_cont_a);
            this.ixp.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cmS();
            this.iwT = i;
        }
    }
}
