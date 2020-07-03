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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes9.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView fqn;
    private TbImageView hgp;
    private TextView hgs;
    private LinearLayout iyG;
    private View iyH;
    public TopicPkView iyI;
    private TopicTimelineView iyJ;
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
        this.fqn = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fqn.setDrawingCacheEnabled(true);
        this.hgs = (TextView) findViewById(R.id.topic_detail_head_des);
        this.iyG = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hgp = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.iyH = findViewById(R.id.topic_detail_head_img_placeholder);
        this.iyI = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.iyJ = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hgp.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hgp.setLayoutParams(layoutParams);
        this.hgp.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hgp.setConrers(15);
        this.hgp.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fqn;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.iyj == null && StringUtils.isNull(bVar.iyh)) {
            ((LinearLayout.LayoutParams) this.hgs.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hgs.setText(bVar.dKy);
        if (StringUtils.isNull(bVar.iyh)) {
            this.iyG.setVisibility(8);
            this.fqn.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.iyG.setVisibility(0);
            this.hgp.startLoad(bVar.iyh, 10, false);
            this.fqn.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.iyj == null) {
            this.iyH.setVisibility(8);
            this.iyI.setVisibility(8);
        } else {
            this.iyH.setVisibility(0);
            this.iyI.setVisibility(0);
            this.iyI.setData(bVar.iyj);
        }
        if (bVar.iyk == null || w.isEmpty(bVar.iyk.iyt)) {
            this.iyJ.setVisibility(8);
        } else {
            this.iyJ.setVisibility(0);
            this.iyJ.setData(bVar.iyk);
        }
        this.fqn.startLoad(bVar.iyi, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fqn.setIsNight(this.mSkinType == 1);
            an.setViewTextColor(this.hgs, (int) R.color.cp_cont_a);
            this.hgp.setIsNight(this.mSkinType == 1);
            this.iyI.onChangeSkinType();
            this.iyJ.onChangeSkinType();
        }
    }
}
