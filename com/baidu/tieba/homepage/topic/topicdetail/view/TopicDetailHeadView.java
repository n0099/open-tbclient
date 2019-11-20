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
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView dyb;
    private TbImageView fds;
    private TextView fdv;
    private LinearLayout gnw;
    private View gnx;
    public TopicPkView gny;
    private TopicTimelineView gnz;
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
        this.dyb = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.dyb.setDrawingCacheEnabled(true);
        this.fdv = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gnw = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fds = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.gnx = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gny = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.gnz = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fds.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fds.setLayoutParams(layoutParams);
        this.fds.setRadius(l.getDimens(context, R.dimen.tbds22));
        this.fds.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.dyb;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.gmY == null && StringUtils.isNull(bVar.gmW)) {
            ((LinearLayout.LayoutParams) this.fdv.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fdv.setText(bVar.bZY);
        if (StringUtils.isNull(bVar.gmW)) {
            this.gnw.setVisibility(8);
            this.dyb.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gnw.setVisibility(0);
            this.fds.startLoad(bVar.gmW, 10, false);
            this.dyb.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.gmY == null) {
            this.gnx.setVisibility(8);
            this.gny.setVisibility(8);
        } else {
            this.gnx.setVisibility(0);
            this.gny.setVisibility(0);
            this.gny.setData(bVar.gmY);
        }
        if (bVar.gmZ == null || v.isEmpty(bVar.gmZ.gni)) {
            this.gnz.setVisibility(8);
        } else {
            this.gnz.setVisibility(0);
            this.gnz.setData(bVar.gmZ);
        }
        this.dyb.startLoad(bVar.gmX, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.dyb.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fdv, (int) R.color.cp_cont_a);
            this.fds.setIsNight(this.mSkinType == 1);
            this.gny.onChangeSkinType();
            this.gnz.onChangeSkinType();
        }
    }
}
