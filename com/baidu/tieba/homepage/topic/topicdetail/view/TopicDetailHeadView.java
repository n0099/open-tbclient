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
    private TbImageView dpQ;
    private TbImageView eZE;
    private TextView eZH;
    private LinearLayout gmf;
    private View gmg;
    public TopicPkView gmh;
    private TopicTimelineView gmi;
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
        this.dpQ = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.dpQ.setDrawingCacheEnabled(true);
        this.eZH = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gmf = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.eZE = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.gmg = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gmh = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.gmi = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eZE.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eZE.setLayoutParams(layoutParams);
        this.eZE.setRadius(l.g(context, R.dimen.tbds22));
        this.eZE.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.dpQ;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.glH == null && StringUtils.isNull(bVar.glF)) {
            ((LinearLayout.LayoutParams) this.eZH.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.eZH.setText(bVar.bIF);
        if (StringUtils.isNull(bVar.glF)) {
            this.gmf.setVisibility(8);
            this.dpQ.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gmf.setVisibility(0);
            this.eZE.startLoad(bVar.glF, 10, false);
            this.dpQ.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.glH == null) {
            this.gmg.setVisibility(8);
            this.gmh.setVisibility(8);
        } else {
            this.gmg.setVisibility(0);
            this.gmh.setVisibility(0);
            this.gmh.setData(bVar.glH);
        }
        if (bVar.glI == null || v.aa(bVar.glI.glR)) {
            this.gmi.setVisibility(8);
        } else {
            this.gmi.setVisibility(0);
            this.gmi.setData(bVar.glI);
        }
        this.dpQ.startLoad(bVar.glG, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.dpQ.setIsNight(this.mSkinType == 1);
            am.j(this.eZH, R.color.cp_btn_a);
            this.eZE.setIsNight(this.mSkinType == 1);
            this.gmh.onChangeSkinType();
            this.gmi.onChangeSkinType();
        }
    }
}
