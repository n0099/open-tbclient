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
    private TbImageView eEW;
    private TextView eEZ;
    private TbImageView fOT;
    private LinearLayout fOU;
    private View fOV;
    public TopicPkView fOW;
    private TopicTimelineView fOX;
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
        this.fOT = (TbImageView) findViewById(d.g.topic_detail_head_bg);
        this.fOT.setDrawingCacheEnabled(true);
        this.eEZ = (TextView) findViewById(d.g.topic_detail_head_des);
        this.fOU = (LinearLayout) findViewById(d.g.topic_detail_head_img_layout);
        this.eEW = (TbImageView) findViewById(d.g.topic_detail_head_img);
        this.fOV = findViewById(d.g.topic_detail_head_img_placeholder);
        this.fOW = (TopicPkView) findViewById(d.g.topic_detail_head_pk);
        this.fOX = (TopicTimelineView) findViewById(d.g.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eEW.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eEW.setLayoutParams(layoutParams);
        this.eEW.setRadius(l.h(context, d.e.tbds22));
        this.eEW.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fOT;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.fOt == null && StringUtils.isNull(bVar.fOr)) {
            ((LinearLayout.LayoutParams) this.eEZ.getLayoutParams()).bottomMargin = l.h(getContext(), d.e.tbds130);
        }
        this.eEZ.setText(bVar.bAo);
        if (StringUtils.isNull(bVar.fOr)) {
            this.fOU.setVisibility(8);
            this.fOT.setDefaultBgResource(d.f.topic_detail_default_bg);
        } else {
            this.fOU.setVisibility(0);
            this.eEW.startLoad(bVar.fOr, 10, false);
            this.fOT.setDefaultBgResource(d.f.topic_detail_img_default_bg);
        }
        if (bVar.fOt == null) {
            this.fOV.setVisibility(8);
            this.fOW.setVisibility(8);
        } else {
            this.fOV.setVisibility(0);
            this.fOW.setVisibility(0);
            this.fOW.setData(bVar.fOt);
        }
        if (bVar.fOu == null || v.T(bVar.fOu.fOE)) {
            this.fOX.setVisibility(8);
        } else {
            this.fOX.setVisibility(0);
            this.fOX.setData(bVar.fOu);
        }
        this.fOT.startLoad(bVar.fOs, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fOT.setIsNight(this.mSkinType == 1);
            al.j(this.eEZ, d.C0277d.cp_btn_a);
            this.eEW.setIsNight(this.mSkinType == 1);
            this.fOW.onChangeSkinType();
            this.fOX.onChangeSkinType();
        }
    }
}
