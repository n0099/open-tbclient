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
    private TbImageView fGP;
    private TbImageView hyQ;
    private TextView hyT;
    private LinearLayout iTK;
    private View iTL;
    public TopicPkView iTM;
    private TopicTimelineView iTN;
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
        this.fGP = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fGP.setDrawingCacheEnabled(true);
        this.hyT = (TextView) findViewById(R.id.topic_detail_head_des);
        this.iTK = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hyQ = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.iTL = findViewById(R.id.topic_detail_head_img_placeholder);
        this.iTM = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.iTN = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hyQ.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hyQ.setLayoutParams(layoutParams);
        this.hyQ.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hyQ.setConrers(15);
        this.hyQ.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fGP;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.iTn == null && StringUtils.isNull(bVar.iTl)) {
            ((LinearLayout.LayoutParams) this.hyT.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hyT.setText(bVar.ead);
        if (StringUtils.isNull(bVar.iTl)) {
            this.iTK.setVisibility(8);
            this.fGP.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.iTK.setVisibility(0);
            this.hyQ.startLoad(bVar.iTl, 10, false);
            this.fGP.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.iTn == null) {
            this.iTL.setVisibility(8);
            this.iTM.setVisibility(8);
        } else {
            this.iTL.setVisibility(0);
            this.iTM.setVisibility(0);
            this.iTM.setData(bVar.iTn);
        }
        if (bVar.iTo == null || y.isEmpty(bVar.iTo.iTx)) {
            this.iTN.setVisibility(8);
        } else {
            this.iTN.setVisibility(0);
            this.iTN.setData(bVar.iTo);
        }
        this.fGP.startLoad(bVar.iTm, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fGP.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.hyT, R.color.cp_cont_a);
            this.hyQ.setIsNight(this.mSkinType == 1);
            this.iTM.onChangeSkinType();
            this.iTN.onChangeSkinType();
        }
    }
}
