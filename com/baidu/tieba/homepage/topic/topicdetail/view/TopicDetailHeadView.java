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
    private TbImageView dyS;
    private TbImageView fej;
    private TextView fem;
    private LinearLayout gon;
    private View goo;
    public TopicPkView gop;
    private TopicTimelineView goq;
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
        this.dyS = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.dyS.setDrawingCacheEnabled(true);
        this.fem = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gon = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.fej = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.goo = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gop = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.goq = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.fej.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fej.setLayoutParams(layoutParams);
        this.fej.setRadius(l.getDimens(context, R.dimen.tbds22));
        this.fej.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.dyS;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.gnP == null && StringUtils.isNull(bVar.gnN)) {
            ((LinearLayout.LayoutParams) this.fem.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.fem.setText(bVar.caP);
        if (StringUtils.isNull(bVar.gnN)) {
            this.gon.setVisibility(8);
            this.dyS.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gon.setVisibility(0);
            this.fej.startLoad(bVar.gnN, 10, false);
            this.dyS.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.gnP == null) {
            this.goo.setVisibility(8);
            this.gop.setVisibility(8);
        } else {
            this.goo.setVisibility(0);
            this.gop.setVisibility(0);
            this.gop.setData(bVar.gnP);
        }
        if (bVar.gnQ == null || v.isEmpty(bVar.gnQ.gnZ)) {
            this.goq.setVisibility(8);
        } else {
            this.goq.setVisibility(0);
            this.goq.setData(bVar.gnQ);
        }
        this.dyS.startLoad(bVar.gnO, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.dyS.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.fem, (int) R.color.cp_cont_a);
            this.fej.setIsNight(this.mSkinType == 1);
            this.gop.onChangeSkinType();
            this.goq.onChangeSkinType();
        }
    }
}
