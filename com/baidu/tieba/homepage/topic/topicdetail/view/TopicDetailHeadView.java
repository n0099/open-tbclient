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
    private TbImageView drI;
    private TextView fbB;
    private TbImageView fby;
    private LinearLayout goO;
    private View goP;
    public TopicPkView goQ;
    private TopicTimelineView goR;
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
        this.drI = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.drI.setDrawingCacheEnabled(true);
        this.fbB = (TextView) findViewById(R.id.topic_detail_head_des);
        this.goO = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fby = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.goP = findViewById(R.id.topic_detail_head_img_placeholder);
        this.goQ = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.goR = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fby.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fby.setLayoutParams(layoutParams);
        this.fby.setRadius(l.g(context, R.dimen.tbds22));
        this.fby.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.drI;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.goq == null && StringUtils.isNull(bVar.goo)) {
            ((LinearLayout.LayoutParams) this.fbB.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.fbB.setText(bVar.bJi);
        if (StringUtils.isNull(bVar.goo)) {
            this.goO.setVisibility(8);
            this.drI.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.goO.setVisibility(0);
            this.fby.startLoad(bVar.goo, 10, false);
            this.drI.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.goq == null) {
            this.goP.setVisibility(8);
            this.goQ.setVisibility(8);
        } else {
            this.goP.setVisibility(0);
            this.goQ.setVisibility(0);
            this.goQ.setData(bVar.goq);
        }
        if (bVar.gor == null || v.aa(bVar.gor.goA)) {
            this.goR.setVisibility(8);
        } else {
            this.goR.setVisibility(0);
            this.goR.setData(bVar.gor);
        }
        this.drI.startLoad(bVar.gop, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.drI.setIsNight(this.mSkinType == 1);
            am.j(this.fbB, R.color.cp_cont_a);
            this.fby.setIsNight(this.mSkinType == 1);
            this.goQ.onChangeSkinType();
            this.goR.onChangeSkinType();
        }
    }
}
