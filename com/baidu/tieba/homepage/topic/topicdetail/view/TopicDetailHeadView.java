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
    private TbImageView eoq;
    private TbImageView fXv;
    private TextView fXy;
    private LinearLayout hgO;
    private View hgP;
    public TopicPkView hgQ;
    private TopicTimelineView hgR;
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
        this.eoq = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eoq.setDrawingCacheEnabled(true);
        this.fXy = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hgO = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fXv = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hgP = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hgQ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hgR = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fXv.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXv.setLayoutParams(layoutParams);
        this.fXv.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fXv.setConrers(15);
        this.fXv.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eoq;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hgr == null && StringUtils.isNull(bVar.hgp)) {
            ((LinearLayout.LayoutParams) this.fXy.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fXy.setText(bVar.cQE);
        if (StringUtils.isNull(bVar.hgp)) {
            this.hgO.setVisibility(8);
            this.eoq.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hgO.setVisibility(0);
            this.fXv.startLoad(bVar.hgp, 10, false);
            this.eoq.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hgr == null) {
            this.hgP.setVisibility(8);
            this.hgQ.setVisibility(8);
        } else {
            this.hgP.setVisibility(0);
            this.hgQ.setVisibility(0);
            this.hgQ.setData(bVar.hgr);
        }
        if (bVar.hgs == null || v.isEmpty(bVar.hgs.hgB)) {
            this.hgR.setVisibility(8);
        } else {
            this.hgR.setVisibility(0);
            this.hgR.setData(bVar.hgs);
        }
        this.eoq.startLoad(bVar.hgq, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eoq.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fXy, (int) R.color.cp_cont_a);
            this.fXv.setIsNight(this.mSkinType == 1);
            this.hgQ.onChangeSkinType();
            this.hgR.onChangeSkinType();
        }
    }
}
