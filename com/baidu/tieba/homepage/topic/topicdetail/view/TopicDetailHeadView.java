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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView eFa;
    private TextView eFd;
    private TbImageView fOU;
    private LinearLayout fOV;
    private View fOW;
    public TopicPkView fOX;
    private TopicTimelineView fOY;
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
        LayoutInflater.from(context).inflate(d.h.topic_detail_head_view_layout, (ViewGroup) this, true);
        this.fOU = (TbImageView) findViewById(d.g.topic_detail_head_bg);
        this.fOU.setDrawingCacheEnabled(true);
        this.eFd = (TextView) findViewById(d.g.topic_detail_head_des);
        this.fOV = (LinearLayout) findViewById(d.g.topic_detail_head_img_layout);
        this.eFa = (TbImageView) findViewById(d.g.topic_detail_head_img);
        this.fOW = findViewById(d.g.topic_detail_head_img_placeholder);
        this.fOX = (TopicPkView) findViewById(d.g.topic_detail_head_pk);
        this.fOY = (TopicTimelineView) findViewById(d.g.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eFa.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eFa.setLayoutParams(layoutParams);
        this.eFa.setRadius(l.h(context, d.e.tbds22));
        this.eFa.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fOU;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.fOu == null && StringUtils.isNull(bVar.fOs)) {
            ((LinearLayout.LayoutParams) this.eFd.getLayoutParams()).bottomMargin = l.h(getContext(), d.e.tbds130);
        }
        this.eFd.setText(bVar.bAm);
        if (StringUtils.isNull(bVar.fOs)) {
            this.fOV.setVisibility(8);
            this.fOU.setDefaultBgResource(d.f.topic_detail_default_bg);
        } else {
            this.fOV.setVisibility(0);
            this.eFa.startLoad(bVar.fOs, 10, false);
            this.fOU.setDefaultBgResource(d.f.topic_detail_img_default_bg);
        }
        if (bVar.fOu == null) {
            this.fOW.setVisibility(8);
            this.fOX.setVisibility(8);
        } else {
            this.fOW.setVisibility(0);
            this.fOX.setVisibility(0);
            this.fOX.setData(bVar.fOu);
        }
        if (bVar.fOv == null || v.T(bVar.fOv.fOF)) {
            this.fOY.setVisibility(8);
        } else {
            this.fOY.setVisibility(0);
            this.fOY.setData(bVar.fOv);
        }
        this.fOU.startLoad(bVar.fOt, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fOU.setIsNight(this.mSkinType == 1);
            al.j(this.eFd, d.C0236d.cp_btn_a);
            this.eFa.setIsNight(this.mSkinType == 1);
            this.fOX.onChangeSkinType();
            this.fOY.onChangeSkinType();
        }
    }
}
