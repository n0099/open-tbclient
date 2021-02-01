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
/* loaded from: classes2.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView gDj;
    private TbImageView iMp;
    private TextView iMs;
    private LinearLayout koX;
    private View koY;
    public TopicPkView koZ;
    private TopicTimelineView kpa;
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
        this.gDj = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gDj.setDrawingCacheEnabled(true);
        this.iMs = (TextView) findViewById(R.id.topic_detail_head_des);
        this.koX = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iMp = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.koY = findViewById(R.id.topic_detail_head_img_placeholder);
        this.koZ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.kpa = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iMp.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iMp.setLayoutParams(layoutParams);
        this.iMp.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iMp.setConrers(15);
        this.iMp.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gDj;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.koz == null && StringUtils.isNull(bVar.kox)) {
            ((LinearLayout.LayoutParams) this.iMs.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.iMs.setText(bVar.ePv);
        if (StringUtils.isNull(bVar.kox)) {
            this.koX.setVisibility(8);
            this.gDj.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.koX.setVisibility(0);
            this.iMp.startLoad(bVar.kox, 10, false);
            this.gDj.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.koz == null) {
            this.koY.setVisibility(8);
            this.koZ.setVisibility(8);
        } else {
            this.koY.setVisibility(0);
            this.koZ.setVisibility(0);
            this.koZ.setData(bVar.koz);
        }
        if (bVar.koA == null || y.isEmpty(bVar.koA.koK)) {
            this.kpa.setVisibility(8);
        } else {
            this.kpa.setVisibility(0);
            this.kpa.setData(bVar.koA);
        }
        this.gDj.startLoad(bVar.koy, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gDj.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.iMs, R.color.CAM_X0101);
            this.iMp.setIsNight(this.mSkinType == 1);
            this.koZ.onChangeSkinType();
            this.kpa.onChangeSkinType();
        }
    }
}
