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
    private TbImageView eUC;
    private TextView eUF;
    private TbImageView gfO;
    private LinearLayout gfP;
    private View gfQ;
    public TopicPkView gfR;
    private TopicTimelineView gfS;
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
        this.gfO = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gfO.setDrawingCacheEnabled(true);
        this.eUF = (TextView) findViewById(R.id.topic_detail_head_des);
        this.gfP = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.eUC = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.gfQ = findViewById(R.id.topic_detail_head_img_placeholder);
        this.gfR = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.gfS = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.eUC.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eUC.setLayoutParams(layoutParams);
        this.eUC.setRadius(l.g(context, R.dimen.tbds22));
        this.eUC.setConrers(15);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gfO;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.gfq == null && StringUtils.isNull(bVar.gfo)) {
            ((LinearLayout.LayoutParams) this.eUF.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.eUF.setText(bVar.bHE);
        if (StringUtils.isNull(bVar.gfo)) {
            this.gfP.setVisibility(8);
            this.gfO.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.gfP.setVisibility(0);
            this.eUC.startLoad(bVar.gfo, 10, false);
            this.gfO.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.gfq == null) {
            this.gfQ.setVisibility(8);
            this.gfR.setVisibility(8);
        } else {
            this.gfQ.setVisibility(0);
            this.gfR.setVisibility(0);
            this.gfR.setData(bVar.gfq);
        }
        if (bVar.gfr == null || v.aa(bVar.gfr.gfA)) {
            this.gfS.setVisibility(8);
        } else {
            this.gfS.setVisibility(0);
            this.gfS.setData(bVar.gfr);
        }
        this.gfO.startLoad(bVar.gfp, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gfO.setIsNight(this.mSkinType == 1);
            al.j(this.eUF, R.color.cp_btn_a);
            this.eUC.setIsNight(this.mSkinType == 1);
            this.gfR.onChangeSkinType();
            this.gfS.onChangeSkinType();
        }
    }
}
