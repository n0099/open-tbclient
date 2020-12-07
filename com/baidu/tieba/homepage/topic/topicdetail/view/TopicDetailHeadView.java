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
/* loaded from: classes22.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView gue;
    private TbImageView iyY;
    private TextView izb;
    private LinearLayout jYh;
    private View jYi;
    public TopicPkView jYj;
    private TopicTimelineView jYk;
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
        this.gue = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gue.setDrawingCacheEnabled(true);
        this.izb = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jYh = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iyY = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jYi = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jYj = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jYk = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iyY.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iyY.setLayoutParams(layoutParams);
        this.iyY.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iyY.setConrers(15);
        this.iyY.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gue;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jXJ == null && StringUtils.isNull(bVar.jXH)) {
            ((LinearLayout.LayoutParams) this.izb.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.izb.setText(bVar.eIc);
        if (StringUtils.isNull(bVar.jXH)) {
            this.jYh.setVisibility(8);
            this.gue.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jYh.setVisibility(0);
            this.iyY.startLoad(bVar.jXH, 10, false);
            this.gue.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jXJ == null) {
            this.jYi.setVisibility(8);
            this.jYj.setVisibility(8);
        } else {
            this.jYi.setVisibility(0);
            this.jYj.setVisibility(0);
            this.jYj.setData(bVar.jXJ);
        }
        if (bVar.jXK == null || y.isEmpty(bVar.jXK.jXU)) {
            this.jYk.setVisibility(8);
        } else {
            this.jYk.setVisibility(0);
            this.jYk.setData(bVar.jXK);
        }
        this.gue.startLoad(bVar.jXI, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gue.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.izb, R.color.CAM_X0101);
            this.iyY.setIsNight(this.mSkinType == 1);
            this.jYj.onChangeSkinType();
            this.jYk.onChangeSkinType();
        }
    }
}
