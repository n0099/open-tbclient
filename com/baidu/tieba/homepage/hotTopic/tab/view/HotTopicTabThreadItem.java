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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes9.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> agW;
    private TextView dDu;
    private int iqP;
    private TextView irb;
    private TextView irc;
    private TbImageView iri;
    private View irj;
    private View irk;
    private ImageView irl;
    private TextView irm;
    private View irn;
    private e iro;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iqP = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.iri = (TbImageView) findViewById(R.id.coverView);
        this.irj = findViewById(R.id.coverGradientMask);
        this.irk = findViewById(R.id.videoTimeContainer);
        this.irl = (ImageView) findViewById(R.id.videoPlayIcon);
        this.irm = (TextView) findViewById(R.id.videoPlayTime);
        this.irb = (TextView) findViewById(R.id.indexView);
        this.dDu = (TextView) findViewById(R.id.titleView);
        this.irc = (TextView) findViewById(R.id.tagView);
        this.iri.setPlaceHolder(2);
        this.iri.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iri.setConrers(15);
        this.irn = findViewById(R.id.rootLayout);
        this.irn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.iro != null && HotTopicTabThreadItem.this.iro.dLi != null) {
                    if (HotTopicTabThreadItem.this.agW != null) {
                        HotTopicTabThreadItem.this.agW.a(view, HotTopicTabThreadItem.this.iro, HotTopicTabThreadItem.this.iro.index, HotTopicTabThreadItem.this.iro.index);
                    }
                    aw.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.iro.dLi, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.agW = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.iro = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.iri.setVisibility(8);
                this.irj.setVisibility(8);
                this.irk.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.irc.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.irc.setLayoutParams(layoutParams);
            } else {
                this.iri.startLoad(eVar.cover, 10, false);
                this.iri.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.irc.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.irc.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.irk.setVisibility(0);
                    this.irj.setVisibility(0);
                    this.irm.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.irk.setVisibility(8);
                    this.irj.setVisibility(8);
                }
            }
            this.dDu.setText(eVar.title);
            if (eVar.aoN > 0) {
                this.irc.setVisibility(0);
                this.irc.setText(this.irc.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, ar.cn(eVar.aoN)));
            } else {
                this.irc.setVisibility(4);
            }
            this.irb.setText("" + eVar.index);
            cjq();
            if (this.agW != null && this.iro != null) {
                this.agW.b(this, this.iro, this.iro.index, this.iro.index);
            }
        }
    }

    private void cjq() {
        if (this.iro != null) {
            int lA = TagTextHelper.lA(this.iro.index);
            Drawable background = this.irc.getBackground();
            DrawableCompat.setTint(background, an.getColor(lA));
            background.setAlpha(40);
            this.irc.setBackgroundDrawable(background);
            an.setViewTextColor(this.irc, lA);
            Drawable background2 = this.irb.getBackground();
            DrawableCompat.setTint(background2, an.getColor(lA));
            this.irb.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            a.f(this.irn, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.irb, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.irm, (int) R.color.cp_cont_a);
            this.irl.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cjq();
            this.iqP = i;
        }
    }
}
