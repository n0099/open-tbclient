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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.a.b;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionChangeModel;
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    private TbPageContext eUY;
    private EmotionHorizontalView iYM;
    private EmotionHorizontalView iYN;
    private EmotionHorizontalView iYO;
    private ImageView iYP;
    private LinearLayout iYQ;
    private RelativeLayout iYR;
    private View iYS;
    private TextView iYT;
    private EmotionChangeModel iYU;
    private Animation iYV;
    private List<EmotionPackageData> mDatas;
    private TextView mTitle;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.iYV = null;
        this.eUY = tbPageContext;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iYV = null;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYV = null;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.iYM = new EmotionHorizontalView(this.eUY);
        this.iYN = new EmotionHorizontalView(this.eUY);
        this.iYO = new EmotionHorizontalView(this.eUY);
        this.iYM.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYN.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYO.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        addView(this.iYM);
        addView(this.iYN);
        addView(this.iYO);
        this.iYM.setVisibility(8);
        this.iYN.setVisibility(8);
        this.iYO.setVisibility(8);
        this.iYQ = (LinearLayout) findViewById(R.id.emotion_change_item);
        this.iYR = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.iYR.setVisibility(8);
        this.iYP = (ImageView) findViewById(R.id.emotion_change_iv);
        this.iYP.setOnClickListener(this);
        this.iYS = findViewById(R.id.category_line_top);
        this.mTitle = (TextView) findViewById(R.id.emotion_title);
        this.iYT = (TextView) findViewById(R.id.emotion_function);
        this.iYT.setOnClickListener(this);
        this.iYU = new EmotionChangeModel(this.eUY);
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundColor(this.iYS, R.color.common_color_10312);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        ap.setImageResource(this.iYP, R.drawable.emotion_icon_refresh);
        ap.setViewTextColor(this.iYT, R.color.CAM_X0109);
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null && !y.isEmpty(this.mDatas)) {
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

    public void cAd() {
        if (this.iYU != null) {
            this.iYU.c(this);
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (!y.isEmpty(list)) {
            this.mDatas = list;
            this.iYQ.setVisibility(0);
            this.iYR.setVisibility(0);
            int size = list.size();
            if (size == 1) {
                this.iYM.setVisibility(0);
                this.iYM.setData(list.get(0));
                this.iYN.setVisibility(8);
                this.iYO.setVisibility(8);
            } else if (size == 2) {
                this.iYM.setVisibility(0);
                this.iYM.setData(list.get(0));
                this.iYN.setVisibility(0);
                this.iYN.setData(list.get(1));
                this.iYO.setVisibility(8);
            } else {
                this.iYM.setVisibility(0);
                this.iYM.setData(list.get(0));
                this.iYN.setVisibility(0);
                this.iYN.setData(list.get(1));
                this.iYO.setVisibility(0);
                this.iYO.setData(list.get(2));
            }
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iYV == null) {
            this.iYV = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iYV.setInterpolator(new LinearInterpolator());
            this.iYV.setFillAfter(true);
        }
        return this.iYV;
    }

    public void cAe() {
        if (this.iYP != null) {
            this.iYP.startAnimation(getClickRotateAnimation());
        }
    }

    public void cAf() {
        if (this.iYP != null) {
            this.iYP.clearAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iYP || view == this.iYT) && this.iYU != null) {
            this.iYU.c(this);
            cAe();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        cAf();
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
        cAf();
        if (emotionCenterData != null && !y.isEmpty(emotionCenterData.package_list)) {
            setData(emotionCenterData.package_list);
        }
    }
}
