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
    private TbImageView gDx;
    private TbImageView iMD;
    private TextView iMG;
    private LinearLayout kpl;
    private View kpm;
    public TopicPkView kpn;
    private TopicTimelineView kpo;
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
        this.gDx = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gDx.setDrawingCacheEnabled(true);
        this.iMG = (TextView) findViewById(R.id.topic_detail_head_des);
        this.kpl = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iMD = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.kpm = findViewById(R.id.topic_detail_head_img_placeholder);
        this.kpn = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.kpo = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iMD.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iMD.setLayoutParams(layoutParams);
        this.iMD.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iMD.setConrers(15);
        this.iMD.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gDx;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.koN == null && StringUtils.isNull(bVar.koL)) {
            ((LinearLayout.LayoutParams) this.iMG.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.iMG.setText(bVar.ePv);
        if (StringUtils.isNull(bVar.koL)) {
            this.kpl.setVisibility(8);
            this.gDx.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.kpl.setVisibility(0);
            this.iMD.startLoad(bVar.koL, 10, false);
            this.gDx.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.koN == null) {
            this.kpm.setVisibility(8);
            this.kpn.setVisibility(8);
        } else {
            this.kpm.setVisibility(0);
            this.kpn.setVisibility(0);
            this.kpn.setData(bVar.koN);
        }
        if (bVar.koO == null || y.isEmpty(bVar.koO.koY)) {
            this.kpo.setVisibility(8);
        } else {
            this.kpo.setVisibility(0);
            this.kpo.setData(bVar.koO);
        }
        this.gDx.startLoad(bVar.koM, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gDx.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.iMG, R.color.CAM_X0101);
            this.iMD.setIsNight(this.mSkinType == 1);
            this.kpn.onChangeSkinType();
            this.kpo.onChangeSkinType();
        }
    }
}
