package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes16.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView fvx;
    private TbImageView hlZ;
    private TextView hmc;
    private LinearLayout iEM;
    private View iEN;
    public TopicPkView iEO;
    private TopicTimelineView iEP;
    private int mSkinType;

    public TopicDetailHeadView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
        this.fvx = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fvx.setDrawingCacheEnabled(true);
        this.hmc = (TextView) findViewById(R.id.topic_detail_head_des);
        this.iEM = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hlZ = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.iEN = findViewById(R.id.topic_detail_head_img_placeholder);
        this.iEO = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.iEP = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hlZ.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hlZ.setLayoutParams(layoutParams);
        this.hlZ.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hlZ.setConrers(15);
        this.hlZ.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fvx;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.iEp == null && StringUtils.isNull(bVar.iEn)) {
            ((LinearLayout.LayoutParams) this.hmc.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hmc.setText(bVar.dQK);
        if (StringUtils.isNull(bVar.iEn)) {
            this.iEM.setVisibility(8);
            this.fvx.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.iEM.setVisibility(0);
            this.hlZ.startLoad(bVar.iEn, 10, false);
            this.fvx.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.iEp == null) {
            this.iEN.setVisibility(8);
            this.iEO.setVisibility(8);
        } else {
            this.iEN.setVisibility(0);
            this.iEO.setVisibility(0);
            this.iEO.setData(bVar.iEp);
        }
        if (bVar.iEq == null || x.isEmpty(bVar.iEq.iEz)) {
            this.iEP.setVisibility(8);
        } else {
            this.iEP.setVisibility(0);
            this.iEP.setData(bVar.iEq);
        }
        this.fvx.startLoad(bVar.iEo, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fvx.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.hmc, R.color.cp_cont_a);
            this.hlZ.setIsNight(this.mSkinType == 1);
            this.iEO.onChangeSkinType();
            this.iEP.onChangeSkinType();
        }
    }
}
