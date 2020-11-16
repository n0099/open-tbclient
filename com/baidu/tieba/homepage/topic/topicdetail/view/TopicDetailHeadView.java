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
/* loaded from: classes21.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView glV;
    private TbImageView iog;
    private TextView ioj;
    private LinearLayout jKE;
    private View jKF;
    public TopicPkView jKG;
    private TopicTimelineView jKH;
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
        this.glV = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.glV.setDrawingCacheEnabled(true);
        this.ioj = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jKE = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iog = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jKF = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jKG = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jKH = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iog.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iog.setLayoutParams(layoutParams);
        this.iog.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iog.setConrers(15);
        this.iog.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.glV;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jKg == null && StringUtils.isNull(bVar.jKe)) {
            ((LinearLayout.LayoutParams) this.ioj.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.ioj.setText(bVar.eBc);
        if (StringUtils.isNull(bVar.jKe)) {
            this.jKE.setVisibility(8);
            this.glV.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jKE.setVisibility(0);
            this.iog.startLoad(bVar.jKe, 10, false);
            this.glV.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jKg == null) {
            this.jKF.setVisibility(8);
            this.jKG.setVisibility(8);
        } else {
            this.jKF.setVisibility(0);
            this.jKG.setVisibility(0);
            this.jKG.setData(bVar.jKg);
        }
        if (bVar.jKh == null || y.isEmpty(bVar.jKh.jKr)) {
            this.jKH.setVisibility(8);
        } else {
            this.jKH.setVisibility(0);
            this.jKH.setData(bVar.jKh);
        }
        this.glV.startLoad(bVar.jKf, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.glV.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.ioj, R.color.CAM_X0101);
            this.iog.setIsNight(this.mSkinType == 1);
            this.jKG.onChangeSkinType();
            this.jKH.onChangeSkinType();
        }
    }
}
