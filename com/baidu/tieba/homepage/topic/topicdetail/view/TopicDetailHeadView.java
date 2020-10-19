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
    private TbImageView fWw;
    private TbImageView hUT;
    private TextView hUW;
    private LinearLayout jrv;
    private View jrw;
    public TopicPkView jrx;
    private TopicTimelineView jry;
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
        this.fWw = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fWw.setDrawingCacheEnabled(true);
        this.hUW = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jrv = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hUT = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jrw = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jrx = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jry = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hUT.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hUT.setLayoutParams(layoutParams);
        this.hUT.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hUT.setConrers(15);
        this.hUT.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fWw;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jqY == null && StringUtils.isNull(bVar.jqW)) {
            ((LinearLayout.LayoutParams) this.hUW.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hUW.setText(bVar.eow);
        if (StringUtils.isNull(bVar.jqW)) {
            this.jrv.setVisibility(8);
            this.fWw.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jrv.setVisibility(0);
            this.hUT.startLoad(bVar.jqW, 10, false);
            this.fWw.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jqY == null) {
            this.jrw.setVisibility(8);
            this.jrx.setVisibility(8);
        } else {
            this.jrw.setVisibility(0);
            this.jrx.setVisibility(0);
            this.jrx.setData(bVar.jqY);
        }
        if (bVar.jqZ == null || y.isEmpty(bVar.jqZ.jri)) {
            this.jry.setVisibility(8);
        } else {
            this.jry.setVisibility(0);
            this.jry.setData(bVar.jqZ);
        }
        this.fWw.startLoad(bVar.jqX, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fWw.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.hUW, R.color.cp_cont_a);
            this.hUT.setIsNight(this.mSkinType == 1);
            this.jrx.onChangeSkinType();
            this.jry.onChangeSkinType();
        }
    }
}
