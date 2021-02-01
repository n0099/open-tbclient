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
    private EmotionHorizontalView iYA;
    private ImageView iYB;
    private LinearLayout iYC;
    private RelativeLayout iYD;
    private View iYE;
    private TextView iYF;
    private EmotionChangeModel iYG;
    private Animation iYH;
    private EmotionHorizontalView iYy;
    private EmotionHorizontalView iYz;
    private List<EmotionPackageData> mDatas;
    private TextView mTitle;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.iYH = null;
        this.eUY = tbPageContext;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iYH = null;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYH = null;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.iYy = new EmotionHorizontalView(this.eUY);
        this.iYz = new EmotionHorizontalView(this.eUY);
        this.iYA = new EmotionHorizontalView(this.eUY);
        this.iYy.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYz.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYA.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        addView(this.iYy);
        addView(this.iYz);
        addView(this.iYA);
        this.iYy.setVisibility(8);
        this.iYz.setVisibility(8);
        this.iYA.setVisibility(8);
        this.iYC = (LinearLayout) findViewById(R.id.emotion_change_item);
        this.iYD = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.iYD.setVisibility(8);
        this.iYB = (ImageView) findViewById(R.id.emotion_change_iv);
        this.iYB.setOnClickListener(this);
        this.iYE = findViewById(R.id.category_line_top);
        this.mTitle = (TextView) findViewById(R.id.emotion_title);
        this.iYF = (TextView) findViewById(R.id.emotion_function);
        this.iYF.setOnClickListener(this);
        this.iYG = new EmotionChangeModel(this.eUY);
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundColor(this.iYE, R.color.common_color_10312);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        ap.setImageResource(this.iYB, R.drawable.emotion_icon_refresh);
        ap.setViewTextColor(this.iYF, R.color.CAM_X0109);
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

    public void czW() {
        if (this.iYG != null) {
            this.iYG.c(this);
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (!y.isEmpty(list)) {
            this.mDatas = list;
            this.iYC.setVisibility(0);
            this.iYD.setVisibility(0);
            int size = list.size();
            if (size == 1) {
                this.iYy.setVisibility(0);
                this.iYy.setData(list.get(0));
                this.iYz.setVisibility(8);
                this.iYA.setVisibility(8);
            } else if (size == 2) {
                this.iYy.setVisibility(0);
                this.iYy.setData(list.get(0));
                this.iYz.setVisibility(0);
                this.iYz.setData(list.get(1));
                this.iYA.setVisibility(8);
            } else {
                this.iYy.setVisibility(0);
                this.iYy.setData(list.get(0));
                this.iYz.setVisibility(0);
                this.iYz.setData(list.get(1));
                this.iYA.setVisibility(0);
                this.iYA.setData(list.get(2));
            }
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iYH == null) {
            this.iYH = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iYH.setInterpolator(new LinearInterpolator());
            this.iYH.setFillAfter(true);
        }
        return this.iYH;
    }

    public void czX() {
        if (this.iYB != null) {
            this.iYB.startAnimation(getClickRotateAnimation());
        }
    }

    public void czY() {
        if (this.iYB != null) {
            this.iYB.clearAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iYB || view == this.iYF) && this.iYG != null) {
            this.iYG.c(this);
            czX();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        czY();
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
        czY();
        if (emotionCenterData != null && !y.isEmpty(emotionCenterData.package_list)) {
            setData(emotionCenterData.package_list);
        }
    }
}
