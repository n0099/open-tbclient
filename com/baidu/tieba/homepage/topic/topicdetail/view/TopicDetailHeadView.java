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
    private TbImageView fKf;
    private TbImageView hFY;
    private TextView hGb;
    private LinearLayout jcw;
    private View jcx;
    public TopicPkView jcy;
    private TopicTimelineView jcz;
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
        this.fKf = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.fKf.setDrawingCacheEnabled(true);
        this.hGb = (TextView) findViewById(R.id.topic_detail_head_des);
        this.jcw = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.hFY = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.jcx = findViewById(R.id.topic_detail_head_img_placeholder);
        this.jcy = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.jcz = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.hFY.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hFY.setLayoutParams(layoutParams);
        this.hFY.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.hFY.setConrers(15);
        this.hFY.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.fKf;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.jbZ == null && StringUtils.isNull(bVar.jbX)) {
            ((LinearLayout.LayoutParams) this.hGb.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.hGb.setText(bVar.ecr);
        if (StringUtils.isNull(bVar.jbX)) {
            this.jcw.setVisibility(8);
            this.fKf.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.jcw.setVisibility(0);
            this.hFY.startLoad(bVar.jbX, 10, false);
            this.fKf.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.jbZ == null) {
            this.jcx.setVisibility(8);
            this.jcy.setVisibility(8);
        } else {
            this.jcx.setVisibility(0);
            this.jcy.setVisibility(0);
            this.jcy.setData(bVar.jbZ);
        }
        if (bVar.jca == null || y.isEmpty(bVar.jca.jcj)) {
            this.jcz.setVisibility(8);
        } else {
            this.jcz.setVisibility(0);
            this.jcz.setData(bVar.jca);
        }
        this.fKf.startLoad(bVar.jbY, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.fKf.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.hGb, R.color.cp_cont_a);
            this.hFY.setIsNight(this.mSkinType == 1);
            this.jcy.onChangeSkinType();
            this.jcz.onChangeSkinType();
        }
    }
}
