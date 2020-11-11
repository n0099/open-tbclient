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
/* loaded from: classes22.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> aiM;
    private TextView ajl;
    private TextView ajm;
    private TextView evg;
    private int jBV;
    private TbImageView jCd;
    private View jCe;
    private View jCf;
    private ImageView jCg;
    private TextView jCh;
    private View jCi;
    private e jCj;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jBV = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jCd = (TbImageView) findViewById(R.id.coverView);
        this.jCe = findViewById(R.id.coverGradientMask);
        this.jCf = findViewById(R.id.videoTimeContainer);
        this.jCg = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jCh = (TextView) findViewById(R.id.videoPlayTime);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.evg = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jCd.setPlaceHolder(2);
        this.jCd.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jCd.setConrers(15);
        this.jCi = findViewById(R.id.rootLayout);
        this.jCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jCj != null && HotTopicTabThreadItem.this.jCj.exA != null) {
                    if (HotTopicTabThreadItem.this.aiM != null) {
                        HotTopicTabThreadItem.this.aiM.a(view, HotTopicTabThreadItem.this.jCj, HotTopicTabThreadItem.this.jCj.index, HotTopicTabThreadItem.this.jCj.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.jCj.exA, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.aiM = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jCj = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jCd.setVisibility(8);
                this.jCe.setVisibility(8);
                this.jCf.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ajm.setLayoutParams(layoutParams);
            } else {
                this.jCd.startLoad(eVar.cover, 10, false);
                this.jCd.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajm.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jCf.setVisibility(0);
                    this.jCe.setVisibility(0);
                    this.jCh.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jCf.setVisibility(8);
                    this.jCe.setVisibility(8);
                }
            }
            this.evg.setText(eVar.title);
            this.ajm.setText(this.ajm.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dy(eVar.eHh < 1000 ? 1000 : eVar.eHh)));
            this.ajl.setText(String.valueOf(eVar.index));
            cKF();
            if (this.aiM != null && this.jCj != null) {
                this.aiM.b(this, this.jCj, this.jCj.index, this.jCj.index);
            }
        }
    }

    private void cKF() {
        if (this.jCj != null) {
            int pe = TagTextHelper.pe(this.jCj.index);
            Drawable background = this.ajm.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pe));
            background.setAlpha(40);
            this.ajm.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ajm, pe);
            Drawable background2 = this.ajl.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(pe));
            this.ajl.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jCi, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jCh, R.color.cp_cont_a);
            this.jCg.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cKF();
            this.jBV = i;
        }
    }
}
