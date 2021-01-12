package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.a.b;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionChangeModel;
import java.util.List;
/* loaded from: classes8.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    private TbPageContext eSJ;
    private EmotionHorizontalView iSR;
    private EmotionHorizontalView iSS;
    private EmotionHorizontalView iST;
    private ImageView iSU;
    private LinearLayout iSV;
    private RelativeLayout iSW;
    private View iSX;
    private TextView iSY;
    private EmotionChangeModel iSZ;
    private Animation iTa;
    private List<EmotionPackageData> mDatas;
    private TextView mTitle;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.iTa = null;
        this.eSJ = tbPageContext;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iTa = null;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTa = null;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.iSR = new EmotionHorizontalView(this.eSJ);
        this.iSS = new EmotionHorizontalView(this.eSJ);
        this.iST = new EmotionHorizontalView(this.eSJ);
        this.iSR.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iSS.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iST.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        addView(this.iSR);
        addView(this.iSS);
        addView(this.iST);
        this.iSR.setVisibility(8);
        this.iSS.setVisibility(8);
        this.iST.setVisibility(8);
        this.iSV = (LinearLayout) findViewById(R.id.emotion_change_item);
        this.iSW = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.iSW.setVisibility(8);
        this.iSU = (ImageView) findViewById(R.id.emotion_change_iv);
        this.iSU.setOnClickListener(this);
        this.iSX = findViewById(R.id.category_line_top);
        this.mTitle = (TextView) findViewById(R.id.emotion_title);
        this.iSY = (TextView) findViewById(R.id.emotion_function);
        this.iSY.setOnClickListener(this);
        this.iSZ = new EmotionChangeModel(this.eSJ);
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        ao.setBackgroundColor(this.iSX, R.color.common_color_10312);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        ao.setImageResource(this.iSU, R.drawable.emotion_icon_refresh);
        ao.setViewTextColor(this.iSY, R.color.CAM_X0109);
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null && !x.isEmpty(this.mDatas)) {
            for (EmotionPackageData emotionPackageData2 : this.mDatas) {
                if (emotionPackageData2.id == emotionPackageData.id) {
                    emotionPackageData2.download = emotionPackageData.download;
                    emotionPackageData2.share = emotionPackageData.share;
                    setData(this.mDatas);
                    return;
                }
            }
        }
    }

    public List<EmotionPackageData> getDataList() {
        return this.mDatas;
    }

    public void cyL() {
        if (this.iSZ != null) {
            this.iSZ.c(this);
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (!x.isEmpty(list)) {
            this.mDatas = list;
            this.iSV.setVisibility(0);
            this.iSW.setVisibility(0);
            int size = list.size();
            if (size == 1) {
                this.iSR.setVisibility(0);
                this.iSR.setData(list.get(0));
                this.iSS.setVisibility(8);
                this.iST.setVisibility(8);
            } else if (size == 2) {
                this.iSR.setVisibility(0);
                this.iSR.setData(list.get(0));
                this.iSS.setVisibility(0);
                this.iSS.setData(list.get(1));
                this.iST.setVisibility(8);
            } else {
                this.iSR.setVisibility(0);
                this.iSR.setData(list.get(0));
                this.iSS.setVisibility(0);
                this.iSS.setData(list.get(1));
                this.iST.setVisibility(0);
                this.iST.setData(list.get(2));
            }
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iTa == null) {
            this.iTa = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iTa.setInterpolator(new LinearInterpolator());
            this.iTa.setFillAfter(true);
        }
        return this.iTa;
    }

    public void cyM() {
        if (this.iSU != null) {
            this.iSU.startAnimation(getClickRotateAnimation());
        }
    }

    public void cyN() {
        if (this.iSU != null) {
            this.iSU.clearAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iSU || view == this.iSY) && this.iSZ != null) {
            this.iSZ.c(this);
            cyM();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        cyN();
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
        cyN();
        if (emotionCenterData != null && !x.isEmpty(emotionCenterData.package_list)) {
            setData(emotionCenterData.package_list);
        }
    }
}
