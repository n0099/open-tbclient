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
    private TbImageView gmo;
    private TbImageView inr;
    private TextView inv;
    private LinearLayout jJT;
    private View jJU;
    public TopicPkView jJV;
    private TopicTimelineView jJW;
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
        this.gmo = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gmo.setDrawingCacheEnabled(true);
        this.inv = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jJT = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.inr = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jJU = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jJV = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jJW = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.inr.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.inr.setLayoutParams(layoutParams);
        this.inr.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.inr.setConrers(15);
        this.inr.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gmo;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jJv == null && StringUtils.isNull(bVar.jJt)) {
            ((LinearLayout.LayoutParams) this.inv.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.inv.setText(bVar.eCL);
        if (StringUtils.isNull(bVar.jJt)) {
            this.jJT.setVisibility(8);
            this.gmo.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jJT.setVisibility(0);
            this.inr.startLoad(bVar.jJt, 10, false);
            this.gmo.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jJv == null) {
            this.jJU.setVisibility(8);
            this.jJV.setVisibility(8);
        } else {
            this.jJU.setVisibility(0);
            this.jJV.setVisibility(0);
            this.jJV.setData(bVar.jJv);
        }
        if (bVar.jJw == null || y.isEmpty(bVar.jJw.jJG)) {
            this.jJW.setVisibility(8);
        } else {
            this.jJW.setVisibility(0);
            this.jJW.setData(bVar.jJw);
        }
        this.gmo.startLoad(bVar.jJu, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gmo.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.inv, R.color.cp_cont_a);
            this.inr.setIsNight(this.mSkinType == 1);
            this.jJV.onChangeSkinType();
            this.jJW.onChangeSkinType();
        }
    }
}
