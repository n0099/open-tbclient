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
/* loaded from: classes7.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView ejR;
    private TbImageView fVf;
    private TextView fVi;
    private LinearLayout heA;
    private View heB;
    public TopicPkView heC;
    private TopicTimelineView heD;
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
        this.ejR = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.ejR.setDrawingCacheEnabled(true);
        this.fVi = (TextView) findViewById(R.id.topic_detail_head_des);
        this.heA = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fVf = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.heB = findViewById(R.id.topic_detail_head_img_placeholder);
        this.heC = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.heD = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fVf.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fVf.setLayoutParams(layoutParams);
        this.fVf.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fVf.setConrers(15);
        this.fVf.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.ejR;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hec == null && StringUtils.isNull(bVar.hea)) {
            ((LinearLayout.LayoutParams) this.fVi.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fVi.setText(bVar.cMz);
        if (StringUtils.isNull(bVar.hea)) {
            this.heA.setVisibility(8);
            this.ejR.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.heA.setVisibility(0);
            this.fVf.startLoad(bVar.hea, 10, false);
            this.ejR.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hec == null) {
            this.heB.setVisibility(8);
            this.heC.setVisibility(8);
        } else {
            this.heB.setVisibility(0);
            this.heC.setVisibility(0);
            this.heC.setData(bVar.hec);
        }
        if (bVar.hed == null || v.isEmpty(bVar.hed.hem)) {
            this.heD.setVisibility(8);
        } else {
            this.heD.setVisibility(0);
            this.heD.setData(bVar.hed);
        }
        this.ejR.startLoad(bVar.heb, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ejR.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fVi, (int) R.color.cp_cont_a);
            this.fVf.setIsNight(this.mSkinType == 1);
            this.heC.onChangeSkinType();
            this.heD.onChangeSkinType();
        }
    }
}
