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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes9.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView eoc;
    private TbImageView fXi;
    private TextView fXl;
    private LinearLayout hgC;
    private View hgD;
    public TopicPkView hgE;
    private TopicTimelineView hgF;
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
        this.eoc = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eoc.setDrawingCacheEnabled(true);
        this.fXl = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hgC = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fXi = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hgD = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hgE = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hgF = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fXi.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXi.setLayoutParams(layoutParams);
        this.fXi.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fXi.setConrers(15);
        this.fXi.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eoc;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hgf == null && StringUtils.isNull(bVar.hgd)) {
            ((LinearLayout.LayoutParams) this.fXl.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fXl.setText(bVar.cQD);
        if (StringUtils.isNull(bVar.hgd)) {
            this.hgC.setVisibility(8);
            this.eoc.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hgC.setVisibility(0);
            this.fXi.startLoad(bVar.hgd, 10, false);
            this.eoc.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hgf == null) {
            this.hgD.setVisibility(8);
            this.hgE.setVisibility(8);
        } else {
            this.hgD.setVisibility(0);
            this.hgE.setVisibility(0);
            this.hgE.setData(bVar.hgf);
        }
        if (bVar.hgg == null || v.isEmpty(bVar.hgg.hgp)) {
            this.hgF.setVisibility(8);
        } else {
            this.hgF.setVisibility(0);
            this.hgF.setData(bVar.hgg);
        }
        this.eoc.startLoad(bVar.hge, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eoc.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fXl, (int) R.color.cp_cont_a);
            this.fXi.setIsNight(this.mSkinType == 1);
            this.hgE.onChangeSkinType();
            this.hgF.onChangeSkinType();
        }
    }
}
