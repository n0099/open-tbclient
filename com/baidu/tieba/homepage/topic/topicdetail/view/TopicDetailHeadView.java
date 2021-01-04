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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
/* loaded from: classes2.dex */
public class TopicDetailHeadView extends RelativeLayout {
    private TbImageView gFf;
    private TbImageView iLn;
    private TextView iLq;
    private LinearLayout klv;
    private View klw;
    public TopicPkView klx;
    private TopicTimelineView kly;
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
        this.gFf = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gFf.setDrawingCacheEnabled(true);
        this.iLq = (TextView) findViewById(R.id.topic_detail_head_des);
        this.klv = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iLn = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.klw = findViewById(R.id.topic_detail_head_img_placeholder);
        this.klx = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.kly = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iLn.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iLn.setLayoutParams(layoutParams);
        this.iLn.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iLn.setConrers(15);
        this.iLn.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gFf;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.kkX == null && StringUtils.isNull(bVar.kkV)) {
            ((LinearLayout.LayoutParams) this.iLq.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.iLq.setText(bVar.eRU);
        if (StringUtils.isNull(bVar.kkV)) {
            this.klv.setVisibility(8);
            this.gFf.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.klv.setVisibility(0);
            this.iLn.startLoad(bVar.kkV, 10, false);
            this.gFf.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.kkX == null) {
            this.klw.setVisibility(8);
            this.klx.setVisibility(8);
        } else {
            this.klw.setVisibility(0);
            this.klx.setVisibility(0);
            this.klx.setData(bVar.kkX);
        }
        if (bVar.kkY == null || x.isEmpty(bVar.kkY.kli)) {
            this.kly.setVisibility(8);
        } else {
            this.kly.setVisibility(0);
            this.kly.setData(bVar.kkY);
        }
        this.gFf.startLoad(bVar.kkW, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gFf.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.iLq, R.color.CAM_X0101);
            this.iLn.setIsNight(this.mSkinType == 1);
            this.klx.onChangeSkinType();
            this.kly.onChangeSkinType();
        }
    }
}
