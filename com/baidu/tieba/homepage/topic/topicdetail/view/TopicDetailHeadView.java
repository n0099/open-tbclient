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
    private TbImageView eob;
    private TbImageView fXg;
    private TextView fXj;
    private LinearLayout hgA;
    private View hgB;
    public TopicPkView hgC;
    private TopicTimelineView hgD;
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
        this.eob = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eob.setDrawingCacheEnabled(true);
        this.fXj = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hgA = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fXg = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hgB = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hgC = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hgD = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fXg.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXg.setLayoutParams(layoutParams);
        this.fXg.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fXg.setConrers(15);
        this.fXg.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eob;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hgd == null && StringUtils.isNull(bVar.hgb)) {
            ((LinearLayout.LayoutParams) this.fXj.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fXj.setText(bVar.cQC);
        if (StringUtils.isNull(bVar.hgb)) {
            this.hgA.setVisibility(8);
            this.eob.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hgA.setVisibility(0);
            this.fXg.startLoad(bVar.hgb, 10, false);
            this.eob.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hgd == null) {
            this.hgB.setVisibility(8);
            this.hgC.setVisibility(8);
        } else {
            this.hgB.setVisibility(0);
            this.hgC.setVisibility(0);
            this.hgC.setData(bVar.hgd);
        }
        if (bVar.hge == null || v.isEmpty(bVar.hge.hgn)) {
            this.hgD.setVisibility(8);
        } else {
            this.hgD.setVisibility(0);
            this.hgD.setData(bVar.hge);
        }
        this.eob.startLoad(bVar.hgc, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eob.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fXj, (int) R.color.cp_cont_a);
            this.fXg.setIsNight(this.mSkinType == 1);
            this.hgC.onChangeSkinType();
            this.hgD.onChangeSkinType();
        }
    }
}
