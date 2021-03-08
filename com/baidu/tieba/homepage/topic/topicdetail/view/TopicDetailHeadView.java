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
    private TbImageView gFg;
    private TbImageView iOm;
    private TextView iOp;
    private LinearLayout krn;
    private View kro;
    public TopicPkView krp;
    private TopicTimelineView krq;
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
        this.gFg = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.gFg.setDrawingCacheEnabled(true);
        this.iOp = (TextView) findViewById(R.id.topic_detail_head_des);
        this.krn = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.iOm = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.kro = findViewById(R.id.topic_detail_head_img_placeholder);
        this.krp = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.krq = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.iOm.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iOm.setLayoutParams(layoutParams);
        this.iOm.setRadius(l.getDimens(context, R.dimen.tbds10));
        this.iOm.setConrers(15);
        this.iOm.setPlaceHolder(3);
        onChangeSkinType();
    }

    public TbImageView getmBgImg() {
        return this.gFg;
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.kqP == null && StringUtils.isNull(bVar.kqN)) {
            ((LinearLayout.LayoutParams) this.iOp.getLayoutParams()).bottomMargin = l.getDimens(getContext(), R.dimen.tbds130);
        }
        this.iOp.setText(bVar.eQW);
        if (StringUtils.isNull(bVar.kqN)) {
            this.krn.setVisibility(8);
            this.gFg.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.krn.setVisibility(0);
            this.iOm.startLoad(bVar.kqN, 10, false);
            this.gFg.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.kqP == null) {
            this.kro.setVisibility(8);
            this.krp.setVisibility(8);
        } else {
            this.kro.setVisibility(0);
            this.krp.setVisibility(0);
            this.krp.setData(bVar.kqP);
        }
        if (bVar.kqQ == null || y.isEmpty(bVar.kqQ.kra)) {
            this.krq.setVisibility(8);
        } else {
            this.krq.setVisibility(0);
            this.krq.setData(bVar.kqQ);
        }
        this.gFg.startLoad(bVar.kqO, 10, false);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.gFg.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.iOp, R.color.CAM_X0101);
            this.iOm.setIsNight(this.mSkinType == 1);
            this.krp.onChangeSkinType();
            this.krq.onChangeSkinType();
        }
    }
}
