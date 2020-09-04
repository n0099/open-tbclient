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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes16.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView fGT;
    private TbImageView hyW;
    private TextView hyZ;
    private LinearLayout iTQ;
    private View iTR;
    public TopicPkView iTS;
    private TopicTimelineView iTT;
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
        this.fGT = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fGT.setDrawingCacheEnabled(true);
        this.hyZ = (TextView) findViewById(R.id.topic_detail_head_des);
        this.iTQ = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hyW = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.iTR = findViewById(R.id.topic_detail_head_img_placeholder);
        this.iTS = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.iTT = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hyW.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hyW.setLayoutParams(layoutParams);
        this.hyW.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hyW.setConrers(15);
        this.hyW.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fGT;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.iTt == null && StringUtils.isNull(bVar.iTr)) {
            ((LinearLayout.LayoutParams) this.hyZ.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hyZ.setText(bVar.eah);
        if (StringUtils.isNull(bVar.iTr)) {
            this.iTQ.setVisibility(8);
            this.fGT.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.iTQ.setVisibility(0);
            this.hyW.startLoad(bVar.iTr, 10, false);
            this.fGT.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.iTt == null) {
            this.iTR.setVisibility(8);
            this.iTS.setVisibility(8);
        } else {
            this.iTR.setVisibility(0);
            this.iTS.setVisibility(0);
            this.iTS.setData(bVar.iTt);
        }
        if (bVar.iTu == null || y.isEmpty(bVar.iTu.iTD)) {
            this.iTT.setVisibility(8);
        } else {
            this.iTT.setVisibility(0);
            this.iTT.setData(bVar.iTu);
        }
        this.fGT.startLoad(bVar.iTs, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fGT.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.hyZ, R.color.cp_cont_a);
            this.hyW.setIsNight(this.mSkinType == 1);
            this.iTS.onChangeSkinType();
            this.iTT.onChangeSkinType();
        }
    }
}
