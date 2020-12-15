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
/* loaded from: classes22.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView gug;
    private TbImageView iza;
    private TextView izd;
    private LinearLayout jYj;
    private View jYk;
    public TopicPkView jYl;
    private TopicTimelineView jYm;
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
        this.gug = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gug.setDrawingCacheEnabled(true);
        this.izd = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jYj = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iza = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jYk = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jYl = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jYm = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iza.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iza.setLayoutParams(layoutParams);
        this.iza.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iza.setConrers(15);
        this.iza.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gug;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jXL == null && StringUtils.isNull(bVar.jXJ)) {
            ((LinearLayout.LayoutParams) this.izd.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.izd.setText(bVar.eIc);
        if (StringUtils.isNull(bVar.jXJ)) {
            this.jYj.setVisibility(8);
            this.gug.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jYj.setVisibility(0);
            this.iza.startLoad(bVar.jXJ, 10, false);
            this.gug.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jXL == null) {
            this.jYk.setVisibility(8);
            this.jYl.setVisibility(8);
        } else {
            this.jYk.setVisibility(0);
            this.jYl.setVisibility(0);
            this.jYl.setData(bVar.jXL);
        }
        if (bVar.jXM == null || y.isEmpty(bVar.jXM.jXW)) {
            this.jYm.setVisibility(8);
        } else {
            this.jYm.setVisibility(0);
            this.jYm.setData(bVar.jXM);
        }
        this.gug.startLoad(bVar.jXK, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gug.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.izd, R.color.CAM_X0101);
            this.iza.setIsNight(this.mSkinType == 1);
            this.jYl.onChangeSkinType();
            this.jYm.onChangeSkinType();
        }
    }
}
