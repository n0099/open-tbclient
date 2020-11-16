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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes21.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> aiR;
    private TextView ajq;
    private TextView ajr;
    private TextView etx;
    private int jCS;
    private TbImageView jDa;
    private View jDb;
    private View jDc;
    private ImageView jDd;
    private TextView jDe;
    private View jDf;
    private e jDg;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jCS = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jDa = (TbImageView) findViewById(R.id.coverView);
        this.jDb = findViewById(R.id.coverGradientMask);
        this.jDc = findViewById(R.id.videoTimeContainer);
        this.jDd = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jDe = (TextView) findViewById(R.id.videoPlayTime);
        this.ajq = (TextView) findViewById(R.id.indexView);
        this.etx = (TextView) findViewById(R.id.titleView);
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.jDa.setPlaceHolder(2);
        this.jDa.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jDa.setConrers(15);
        this.jDf = findViewById(R.id.rootLayout);
        this.jDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jDg != null && HotTopicTabThreadItem.this.jDg.evQ != null) {
                    if (HotTopicTabThreadItem.this.aiR != null) {
                        HotTopicTabThreadItem.this.aiR.a(view, HotTopicTabThreadItem.this.jDg, HotTopicTabThreadItem.this.jDg.index, HotTopicTabThreadItem.this.jDg.index);
                    }
                    az.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.jDg.evQ, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.aiR = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jDg = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jDa.setVisibility(8);
                this.jDb.setVisibility(8);
                this.jDc.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajr.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ajr.setLayoutParams(layoutParams);
            } else {
                this.jDa.startLoad(eVar.cover, 10, false);
                this.jDa.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajr.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajr.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jDc.setVisibility(0);
                    this.jDb.setVisibility(0);
                    this.jDe.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jDc.setVisibility(8);
                    this.jDb.setVisibility(8);
                }
            }
            this.etx.setText(eVar.title);
            this.ajr.setText(this.ajr.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.dy(eVar.eFz < 1000 ? 1000 : eVar.eFz)));
            this.ajq.setText(String.valueOf(eVar.index));
            cKk();
            if (this.aiR != null && this.jDg != null) {
                this.aiR.b(this, this.jDg, this.jDg.index, this.jDg.index);
            }
        }
    }

    private void cKk() {
        if (this.jDg != null) {
            int pA = TagTextHelper.pA(this.jDg.index);
            Drawable background = this.ajr.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pA));
            background.setAlpha(40);
            this.ajr.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ajr, pA);
            Drawable background2 = this.ajq.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(pA));
            this.ajq.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            com.baidu.tbadk.core.util.e.a.h(this.jDf, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajq, R.color.CAM_X0101);
            ap.setViewTextColor(this.jDe, R.color.CAM_X0101);
            this.jDd.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cKk();
            this.jCS = i;
        }
    }
}
