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
    private TbImageView ffc;
    private TbImageView gTG;
    private TextView gTJ;
    private LinearLayout ihB;
    private View ihC;
    public TopicPkView ihD;
    private TopicTimelineView ihE;
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
        this.ffc = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.ffc.setDrawingCacheEnabled(true);
        this.gTJ = (TextView) findViewById(R.id.topic_detail_head_des);
        this.ihB = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.gTG = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.ihC = findViewById(R.id.topic_detail_head_img_placeholder);
        this.ihD = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.ihE = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.gTG.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gTG.setLayoutParams(layoutParams);
        this.gTG.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.gTG.setConrers(15);
        this.gTG.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.ffc;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.ihe == null && StringUtils.isNull(bVar.ihc)) {
            ((LinearLayout.LayoutParams) this.gTJ.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.gTJ.setText(bVar.dDY);
        if (StringUtils.isNull(bVar.ihc)) {
            this.ihB.setVisibility(8);
            this.ffc.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.ihB.setVisibility(0);
            this.gTG.startLoad(bVar.ihc, 10, false);
            this.ffc.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.ihe == null) {
            this.ihC.setVisibility(8);
            this.ihD.setVisibility(8);
        } else {
            this.ihC.setVisibility(0);
            this.ihD.setVisibility(0);
            this.ihD.setData(bVar.ihe);
        }
        if (bVar.ihf == null || v.isEmpty(bVar.ihf.iho)) {
            this.ihE.setVisibility(8);
        } else {
            this.ihE.setVisibility(0);
            this.ihE.setData(bVar.ihf);
        }
        this.ffc.startLoad(bVar.ihd, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ffc.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gTJ, (int) R.color.cp_cont_a);
            this.gTG.setIsNight(this.mSkinType == 1);
            this.ihD.onChangeSkinType();
            this.ihE.onChangeSkinType();
        }
    }
}
