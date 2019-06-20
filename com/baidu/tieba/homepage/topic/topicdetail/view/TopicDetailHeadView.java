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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView eUD;
    private TextView eUG;
    private TbImageView gfR;
    private LinearLayout gfS;
    private View gfT;
    public TopicPkView gfU;
    private TopicTimelineView gfV;
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
        this.gfR = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gfR.setDrawingCacheEnabled(true);
        this.eUG = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gfS = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.eUD = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.gfT = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gfU = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.gfV = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eUD.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eUD.setLayoutParams(layoutParams);
        this.eUD.setRadius(l.g(context, R.dimen.tbds22));
        this.eUD.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gfR;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.gft == null && StringUtils.isNull(bVar.gfr)) {
            ((LinearLayout.LayoutParams) this.eUG.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.eUG.setText(bVar.bHF);
        if (StringUtils.isNull(bVar.gfr)) {
            this.gfS.setVisibility(8);
            this.gfR.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gfS.setVisibility(0);
            this.eUD.startLoad(bVar.gfr, 10, false);
            this.gfR.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.gft == null) {
            this.gfT.setVisibility(8);
            this.gfU.setVisibility(8);
        } else {
            this.gfT.setVisibility(0);
            this.gfU.setVisibility(0);
            this.gfU.setData(bVar.gft);
        }
        if (bVar.gfu == null || v.aa(bVar.gfu.gfD)) {
            this.gfV.setVisibility(8);
        } else {
            this.gfV.setVisibility(0);
            this.gfV.setData(bVar.gfu);
        }
        this.gfR.startLoad(bVar.gfs, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gfR.setIsNight(this.mSkinType == 1);
            al.j(this.eUG, R.color.cp_btn_a);
            this.eUD.setIsNight(this.mSkinType == 1);
            this.gfU.onChangeSkinType();
            this.gfV.onChangeSkinType();
        }
    }
}
