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
/* loaded from: classes6.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView ejd;
    private TbImageView fRV;
    private TextView fRY;
    private LinearLayout haX;
    private View haY;
    public TopicPkView haZ;
    private TopicTimelineView hba;
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
        this.ejd = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.ejd.setDrawingCacheEnabled(true);
        this.fRY = (TextView) findViewById(R.id.topic_detail_head_des);
        this.haX = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fRV = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.haY = findViewById(R.id.topic_detail_head_img_placeholder);
        this.haZ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hba = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fRV.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fRV.setLayoutParams(layoutParams);
        this.fRV.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fRV.setConrers(15);
        this.fRV.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.ejd;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.haz == null && StringUtils.isNull(bVar.hax)) {
            ((LinearLayout.LayoutParams) this.fRY.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fRY.setText(bVar.cMp);
        if (StringUtils.isNull(bVar.hax)) {
            this.haX.setVisibility(8);
            this.ejd.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.haX.setVisibility(0);
            this.fRV.startLoad(bVar.hax, 10, false);
            this.ejd.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.haz == null) {
            this.haY.setVisibility(8);
            this.haZ.setVisibility(8);
        } else {
            this.haY.setVisibility(0);
            this.haZ.setVisibility(0);
            this.haZ.setData(bVar.haz);
        }
        if (bVar.haA == null || v.isEmpty(bVar.haA.haJ)) {
            this.hba.setVisibility(8);
        } else {
            this.hba.setVisibility(0);
            this.hba.setData(bVar.haA);
        }
        this.ejd.startLoad(bVar.hay, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ejd.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fRY, (int) R.color.cp_cont_a);
            this.fRV.setIsNight(this.mSkinType == 1);
            this.haZ.onChangeSkinType();
            this.hba.onChangeSkinType();
        }
    }
}
