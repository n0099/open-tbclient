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
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView dpX;
    private TbImageView eZS;
    private TextView eZV;
    private LinearLayout gmX;
    private View gmY;
    public TopicPkView gmZ;
    private TopicTimelineView gna;
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
        this.dpX = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.dpX.setDrawingCacheEnabled(true);
        this.eZV = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gmX = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.eZS = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.gmY = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gmZ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.gna = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eZS.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eZS.setLayoutParams(layoutParams);
        this.eZS.setRadius(l.g(context, R.dimen.tbds22));
        this.eZS.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.dpX;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.gmz == null && StringUtils.isNull(bVar.gmx)) {
            ((LinearLayout.LayoutParams) this.eZV.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.eZV.setText(bVar.bIK);
        if (StringUtils.isNull(bVar.gmx)) {
            this.gmX.setVisibility(8);
            this.dpX.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gmX.setVisibility(0);
            this.eZS.startLoad(bVar.gmx, 10, false);
            this.dpX.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.gmz == null) {
            this.gmY.setVisibility(8);
            this.gmZ.setVisibility(8);
        } else {
            this.gmY.setVisibility(0);
            this.gmZ.setVisibility(0);
            this.gmZ.setData(bVar.gmz);
        }
        if (bVar.gmA == null || v.aa(bVar.gmA.gmJ)) {
            this.gna.setVisibility(8);
        } else {
            this.gna.setVisibility(0);
            this.gna.setData(bVar.gmA);
        }
        this.dpX.startLoad(bVar.gmy, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.dpX.setIsNight(this.mSkinType == 1);
            am.j(this.eZV, R.color.cp_btn_a);
            this.eZS.setIsNight(this.mSkinType == 1);
            this.gmZ.onChangeSkinType();
            this.gna.onChangeSkinType();
        }
    }
}
