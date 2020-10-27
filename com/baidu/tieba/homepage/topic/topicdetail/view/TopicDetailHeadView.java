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
    private TbImageView ggA;
    private TbImageView iht;
    private TextView ihw;
    private LinearLayout jDV;
    private View jDW;
    public TopicPkView jDX;
    private TopicTimelineView jDY;
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
        this.ggA = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.ggA.setDrawingCacheEnabled(true);
        this.ihw = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jDV = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iht = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jDW = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jDX = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jDY = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iht.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iht.setLayoutParams(layoutParams);
        this.iht.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iht.setConrers(15);
        this.iht.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.ggA;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jDy == null && StringUtils.isNull(bVar.jDw)) {
            ((LinearLayout.LayoutParams) this.ihw.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.ihw.setText(bVar.ewT);
        if (StringUtils.isNull(bVar.jDw)) {
            this.jDV.setVisibility(8);
            this.ggA.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jDV.setVisibility(0);
            this.iht.startLoad(bVar.jDw, 10, false);
            this.ggA.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jDy == null) {
            this.jDW.setVisibility(8);
            this.jDX.setVisibility(8);
        } else {
            this.jDW.setVisibility(0);
            this.jDX.setVisibility(0);
            this.jDX.setData(bVar.jDy);
        }
        if (bVar.jDz == null || y.isEmpty(bVar.jDz.jDI)) {
            this.jDY.setVisibility(8);
        } else {
            this.jDY.setVisibility(0);
            this.jDY.setData(bVar.jDz);
        }
        this.ggA.startLoad(bVar.jDx, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ggA.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.ihw, R.color.cp_cont_a);
            this.iht.setIsNight(this.mSkinType == 1);
            this.jDX.onChangeSkinType();
            this.jDY.onChangeSkinType();
        }
    }
}
