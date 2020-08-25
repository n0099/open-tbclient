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
    private f<e> ahW;
    private TextView aiw;
    private TextView aix;
    private TextView dSz;
    private int iLR;
    private TbImageView iLZ;
    private View iMa;
    private View iMb;
    private ImageView iMc;
    private TextView iMd;
    private View iMe;
    private e iMf;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iLR = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.iLZ = (TbImageView) findViewById(R.id.coverView);
        this.iMa = findViewById(R.id.coverGradientMask);
        this.iMb = findViewById(R.id.videoTimeContainer);
        this.iMc = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMd = (TextView) findViewById(R.id.videoPlayTime);
        this.aiw = (TextView) findViewById(R.id.indexView);
        this.dSz = (TextView) findViewById(R.id.titleView);
        this.aix = (TextView) findViewById(R.id.tagView);
        this.iLZ.setPlaceHolder(2);
        this.iLZ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iLZ.setConrers(15);
        this.iMe = findViewById(R.id.rootLayout);
        this.iMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.iMf != null && HotTopicTabThreadItem.this.iMf.dUS != null) {
                    if (HotTopicTabThreadItem.this.ahW != null) {
                        HotTopicTabThreadItem.this.ahW.a(view, HotTopicTabThreadItem.this.iMf, HotTopicTabThreadItem.this.iMf.index, HotTopicTabThreadItem.this.iMf.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.iMf.dUS, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ahW = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.iMf = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.iLZ.setVisibility(8);
                this.iMa.setVisibility(8);
                this.iMb.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aix.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.aix.setLayoutParams(layoutParams);
            } else {
                this.iLZ.startLoad(eVar.cover, 10, false);
                this.iLZ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aix.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aix.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.iMb.setVisibility(0);
                    this.iMa.setVisibility(0);
                    this.iMd.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.iMb.setVisibility(8);
                    this.iMa.setVisibility(8);
                }
            }
            this.dSz.setText(eVar.title);
            this.aix.setText(this.aix.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cR(eVar.eez < 1000 ? 1000 : eVar.eez)));
            this.aiw.setText(String.valueOf(eVar.index));
            cxH();
            if (this.ahW != null && this.iMf != null) {
                this.ahW.b(this, this.iMf, this.iMf.index, this.iMf.index);
            }
        }
    }

    private void cxH() {
        if (this.iMf != null) {
            int oa = TagTextHelper.oa(this.iMf.index);
            Drawable background = this.aix.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oa));
            background.setAlpha(40);
            this.aix.setBackgroundDrawable(background);
            ap.setViewTextColor(this.aix, oa);
            Drawable background2 = this.aiw.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oa));
            this.aiw.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iMe, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiw, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMd, R.color.cp_cont_a);
            this.iMc.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cxH();
            this.iLR = i;
        }
    }
}
