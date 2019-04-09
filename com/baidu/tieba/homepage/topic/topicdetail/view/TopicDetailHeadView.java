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
    private TbImageView eEI;
    private TextView eEL;
    private TbImageView fOH;
    private LinearLayout fOI;
    private View fOJ;
    public TopicPkView fOK;
    private TopicTimelineView fOL;
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
        this.fOH = (TbImageView) findViewById(d.g.topic_detail_head_bg);
        this.fOH.setDrawingCacheEnabled(true);
        this.eEL = (TextView) findViewById(d.g.topic_detail_head_des);
        this.fOI = (LinearLayout) findViewById(d.g.topic_detail_head_img_layout);
        this.eEI = (TbImageView) findViewById(d.g.topic_detail_head_img);
        this.fOJ = findViewById(d.g.topic_detail_head_img_placeholder);
        this.fOK = (TopicPkView) findViewById(d.g.topic_detail_head_pk);
        this.fOL = (TopicTimelineView) findViewById(d.g.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eEI.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eEI.setLayoutParams(layoutParams);
        this.eEI.setRadius(l.h(context, d.e.tbds22));
        this.eEI.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fOH;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.fOh == null && StringUtils.isNull(bVar.fOf)) {
            ((LinearLayout.LayoutParams) this.eEL.getLayoutParams()).bottomMargin = l.h(getContext(), d.e.tbds130);
        }
        this.eEL.setText(bVar.bAs);
        if (StringUtils.isNull(bVar.fOf)) {
            this.fOI.setVisibility(8);
            this.fOH.setDefaultBgResource(d.f.topic_detail_default_bg);
        } else {
            this.fOI.setVisibility(0);
            this.eEI.startLoad(bVar.fOf, 10, false);
            this.fOH.setDefaultBgResource(d.f.topic_detail_img_default_bg);
        }
        if (bVar.fOh == null) {
            this.fOJ.setVisibility(8);
            this.fOK.setVisibility(8);
        } else {
            this.fOJ.setVisibility(0);
            this.fOK.setVisibility(0);
            this.fOK.setData(bVar.fOh);
        }
        if (bVar.fOi == null || v.T(bVar.fOi.fOs)) {
            this.fOL.setVisibility(8);
        } else {
            this.fOL.setVisibility(0);
            this.fOL.setData(bVar.fOi);
        }
        this.fOH.startLoad(bVar.fOg, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fOH.setIsNight(this.mSkinType == 1);
            al.j(this.eEL, d.C0277d.cp_btn_a);
            this.eEI.setIsNight(this.mSkinType == 1);
            this.fOK.onChangeSkinType();
            this.fOL.onChangeSkinType();
        }
    }
}
