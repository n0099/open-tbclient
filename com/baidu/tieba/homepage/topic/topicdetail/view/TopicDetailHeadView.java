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
    private TbImageView eSe;
    private TbImageView gEH;
    private TextView gEK;
    private LinearLayout hRY;
    private View hRZ;
    public TopicPkView hSa;
    private TopicTimelineView hSb;
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
        this.eSe = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.eSe.setDrawingCacheEnabled(true);
        this.gEK = (TextView) findViewById(R.id.topic_detail_head_des);
        this.hRY = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.gEH = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.hRZ = findViewById(R.id.topic_detail_head_img_placeholder);
        this.hSa = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.hSb = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.gEH.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gEH.setLayoutParams(layoutParams);
        this.gEH.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.gEH.setConrers(15);
        this.gEH.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.eSe;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.hRB == null && StringUtils.isNull(bVar.hRz)) {
            ((LinearLayout.LayoutParams) this.gEK.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.gEK.setText(bVar.dpX);
        if (StringUtils.isNull(bVar.hRz)) {
            this.hRY.setVisibility(8);
            this.eSe.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.hRY.setVisibility(0);
            this.gEH.startLoad(bVar.hRz, 10, false);
            this.eSe.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.hRB == null) {
            this.hRZ.setVisibility(8);
            this.hSa.setVisibility(8);
        } else {
            this.hRZ.setVisibility(0);
            this.hSa.setVisibility(0);
            this.hSa.setData(bVar.hRB);
        }
        if (bVar.hRC == null || v.isEmpty(bVar.hRC.hRL)) {
            this.hSb.setVisibility(8);
        } else {
            this.hSb.setVisibility(0);
            this.hSb.setData(bVar.hRC);
        }
        this.eSe.startLoad(bVar.hRA, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eSe.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gEK, (int) R.color.cp_cont_a);
            this.gEH.setIsNight(this.mSkinType == 1);
            this.hSa.onChangeSkinType();
            this.hSb.onChangeSkinType();
        }
    }
}
