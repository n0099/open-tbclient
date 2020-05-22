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
    private TbImageView feR;
    private TbImageView gTv;
    private TextView gTy;
    private LinearLayout igO;
    private View igP;
    public TopicPkView igQ;
    private TopicTimelineView igR;
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
        this.feR = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.feR.setDrawingCacheEnabled(true);
        this.gTy = (TextView) findViewById(R.id.topic_detail_head_des);
        this.igO = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.gTv = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.igP = findViewById(R.id.topic_detail_head_img_placeholder);
        this.igQ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.igR = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.gTv.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gTv.setLayoutParams(layoutParams);
        this.gTv.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.gTv.setConrers(15);
        this.gTv.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.feR;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.igr == null && StringUtils.isNull(bVar.igp)) {
            ((LinearLayout.LayoutParams) this.gTy.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.gTy.setText(bVar.dDY);
        if (StringUtils.isNull(bVar.igp)) {
            this.igO.setVisibility(8);
            this.feR.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.igO.setVisibility(0);
            this.gTv.startLoad(bVar.igp, 10, false);
            this.feR.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.igr == null) {
            this.igP.setVisibility(8);
            this.igQ.setVisibility(8);
        } else {
            this.igP.setVisibility(0);
            this.igQ.setVisibility(0);
            this.igQ.setData(bVar.igr);
        }
        if (bVar.igs == null || v.isEmpty(bVar.igs.igB)) {
            this.igR.setVisibility(8);
        } else {
            this.igR.setVisibility(0);
            this.igR.setData(bVar.igs);
        }
        this.feR.startLoad(bVar.igq, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.feR.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gTy, (int) R.color.cp_cont_a);
            this.gTv.setIsNight(this.mSkinType == 1);
            this.igQ.onChangeSkinType();
            this.igR.onChangeSkinType();
        }
    }
}
