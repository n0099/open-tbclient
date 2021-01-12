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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes2.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView gAz;
    private TbImageView iGG;
    private TextView iGJ;
    private LinearLayout kgP;
    private View kgQ;
    public TopicPkView kgR;
    private TopicTimelineView kgS;
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
        this.gAz = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gAz.setDrawingCacheEnabled(true);
        this.iGJ = (TextView) findViewById(R.id.topic_detail_head_des);
        this.kgP = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iGG = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.kgQ = findViewById(R.id.topic_detail_head_img_placeholder);
        this.kgR = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.kgS = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iGG.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iGG.setLayoutParams(layoutParams);
        this.iGG.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iGG.setConrers(15);
        this.iGG.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gAz;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.kgr == null && StringUtils.isNull(bVar.kgp)) {
            ((LinearLayout.LayoutParams) this.iGJ.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.iGJ.setText(bVar.eNj);
        if (StringUtils.isNull(bVar.kgp)) {
            this.kgP.setVisibility(8);
            this.gAz.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.kgP.setVisibility(0);
            this.iGG.startLoad(bVar.kgp, 10, false);
            this.gAz.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.kgr == null) {
            this.kgQ.setVisibility(8);
            this.kgR.setVisibility(8);
        } else {
            this.kgQ.setVisibility(0);
            this.kgR.setVisibility(0);
            this.kgR.setData(bVar.kgr);
        }
        if (bVar.kgs == null || x.isEmpty(bVar.kgs.kgC)) {
            this.kgS.setVisibility(8);
        } else {
            this.kgS.setVisibility(0);
            this.kgS.setData(bVar.kgs);
        }
        this.gAz.startLoad(bVar.kgq, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gAz.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.iGJ, R.color.CAM_X0101);
            this.iGG.setIsNight(this.mSkinType == 1);
            this.kgR.onChangeSkinType();
            this.kgS.onChangeSkinType();
        }
    }
}
