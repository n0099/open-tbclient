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
    private TbImageView eoH;
    private TbImageView fYd;
    private TextView fYg;
    private LinearLayout hip;
    private View hiq;
    public TopicPkView hir;
    private TopicTimelineView his;
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
        this.eoH = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eoH.setDrawingCacheEnabled(true);
        this.fYg = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hip = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fYd = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hiq = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hir = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.his = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fYd.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fYd.setLayoutParams(layoutParams);
        this.fYd.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.fYd.setConrers(15);
        this.fYd.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eoH;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hhR == null && StringUtils.isNull(bVar.hhP)) {
            ((LinearLayout.LayoutParams) this.fYg.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fYg.setText(bVar.cQR);
        if (StringUtils.isNull(bVar.hhP)) {
            this.hip.setVisibility(8);
            this.eoH.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hip.setVisibility(0);
            this.fYd.startLoad(bVar.hhP, 10, false);
            this.eoH.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hhR == null) {
            this.hiq.setVisibility(8);
            this.hir.setVisibility(8);
        } else {
            this.hiq.setVisibility(0);
            this.hir.setVisibility(0);
            this.hir.setData(bVar.hhR);
        }
        if (bVar.hhS == null || v.isEmpty(bVar.hhS.hib)) {
            this.his.setVisibility(8);
        } else {
            this.his.setVisibility(0);
            this.his.setData(bVar.hhS);
        }
        this.eoH.startLoad(bVar.hhQ, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eoH.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fYg, (int) R.color.cp_cont_a);
            this.fYd.setIsNight(this.mSkinType == 1);
            this.hir.onChangeSkinType();
            this.his.onChangeSkinType();
        }
    }
}
