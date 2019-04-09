package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    private TextView dTG;
    private LinearLayout eiT;
    private com.baidu.tieba.homepage.topic.topicdetail.b.e fPw;
    private int mHeight;
    private int mSkinType;
    private TextView mTitleView;
    private int mWidth;

    public TopicTimelineCellCardView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.card_topic_timeline_cell_view, (ViewGroup) this, true);
        this.eiT = (LinearLayout) findViewById(d.g.card_topic_timeline_cell_date);
        this.dTG = (TextView) findViewById(d.g.card_topic_timeline_cell_time);
        this.mTitleView = (TextView) findViewById(d.g.card_topic_timeline_cell_title);
        this.mWidth = l.h(context, d.e.tbds340);
        this.mHeight = l.h(context, d.e.tbds230);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.e eVar) {
        if (eVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fPw = eVar;
        this.dTG.setText(eVar.fOr);
        this.mTitleView.setText(eVar.title);
        if (StringUtils.isNull(eVar.aZF)) {
            if (eVar.index == 0) {
                al.k(this.eiT, d.f.topic_timeline_bg_one);
                return;
            } else if (eVar.index == 1) {
                al.k(this.eiT, d.f.topic_timeline_bg_two);
                return;
            } else {
                al.k(this.eiT, d.f.topic_timeline_bg_three);
                return;
            }
        }
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(d.f.topic_timeline_bg);
            gradientDrawable.setColor(Color.parseColor(eVar.aZF));
            this.eiT.setBackgroundDrawable(gradientDrawable);
        } catch (Exception e) {
            if (eVar.index == 0) {
                al.k(this.eiT, d.f.topic_timeline_bg_one);
            } else if (eVar.index == 1) {
                al.k(this.eiT, d.f.topic_timeline_bg_two);
            } else {
                al.k(this.eiT, d.f.topic_timeline_bg_three);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPw != null) {
            TiebaStatic.log(new am("c13353").k("tid", this.fPw.tid).k("topic_id", this.fPw.topicId).T("obj_locate", this.fPw.index + 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.fPw.tid), "", "")));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this.dTG, d.C0277d.cp_cont_m);
            al.k(this.mTitleView, d.f.topic_timeline_shade_bg);
            al.j(this.mTitleView, d.C0277d.cp_cont_f);
        }
    }
}
