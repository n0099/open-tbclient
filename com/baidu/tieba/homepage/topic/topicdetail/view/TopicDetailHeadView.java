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
    private TbImageView eSj;
    private TbImageView gEN;
    private TextView gEQ;
    private LinearLayout hSe;
    private View hSf;
    public TopicPkView hSg;
    private TopicTimelineView hSh;
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
        this.eSj = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eSj.setDrawingCacheEnabled(true);
        this.gEQ = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hSe = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.gEN = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hSf = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hSg = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hSh = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.gEN.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gEN.setLayoutParams(layoutParams);
        this.gEN.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.gEN.setConrers(15);
        this.gEN.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eSj;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hRH == null && StringUtils.isNull(bVar.hRF)) {
            ((LinearLayout.LayoutParams) this.gEQ.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.gEQ.setText(bVar.dqb);
        if (StringUtils.isNull(bVar.hRF)) {
            this.hSe.setVisibility(8);
            this.eSj.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hSe.setVisibility(0);
            this.gEN.startLoad(bVar.hRF, 10, false);
            this.eSj.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hRH == null) {
            this.hSf.setVisibility(8);
            this.hSg.setVisibility(8);
        } else {
            this.hSf.setVisibility(0);
            this.hSg.setVisibility(0);
            this.hSg.setData(bVar.hRH);
        }
        if (bVar.hRI == null || v.isEmpty(bVar.hRI.hRR)) {
            this.hSh.setVisibility(8);
        } else {
            this.hSh.setVisibility(0);
            this.hSh.setData(bVar.hRI);
        }
        this.eSj.startLoad(bVar.hRG, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eSj.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gEQ, (int) R.color.cp_cont_a);
            this.gEN.setIsNight(this.mSkinType == 1);
            this.hSg.onChangeSkinType();
            this.hSh.onChangeSkinType();
        }
    }
}
