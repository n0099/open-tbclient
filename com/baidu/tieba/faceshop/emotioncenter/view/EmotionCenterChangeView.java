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
/* loaded from: classes9.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    private TbPageContext eXu;
    private EmotionHorizontalView iXA;
    private ImageView iXB;
    private LinearLayout iXC;
    private RelativeLayout iXD;
    private View iXE;
    private TextView iXF;
    private EmotionChangeModel iXG;
    private Animation iXH;
    private EmotionHorizontalView iXy;
    private EmotionHorizontalView iXz;
    private List<EmotionPackageData> mDatas;
    private TextView mTitle;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.iXH = null;
        this.eXu = tbPageContext;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iXH = null;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iXH = null;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.iXy = new EmotionHorizontalView(this.eXu);
        this.iXz = new EmotionHorizontalView(this.eXu);
        this.iXA = new EmotionHorizontalView(this.eXu);
        this.iXy.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iXz.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iXA.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        addView(this.iXy);
        addView(this.iXz);
        addView(this.iXA);
        this.iXy.setVisibility(8);
        this.iXz.setVisibility(8);
        this.iXA.setVisibility(8);
        this.iXC = (LinearLayout) findViewById(R.id.emotion_change_item);
        this.iXD = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.iXD.setVisibility(8);
        this.iXB = (ImageView) findViewById(R.id.emotion_change_iv);
        this.iXB.setOnClickListener(this);
        this.iXE = findViewById(R.id.category_line_top);
        this.mTitle = (TextView) findViewById(R.id.emotion_title);
        this.iXF = (TextView) findViewById(R.id.emotion_function);
        this.iXF.setOnClickListener(this);
        this.iXG = new EmotionChangeModel(this.eXu);
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        ao.setBackgroundColor(this.iXE, R.color.common_color_10312);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        ao.setImageResource(this.iXB, R.drawable.emotion_icon_refresh);
        ao.setViewTextColor(this.iXF, R.color.CAM_X0109);
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

    public void cCD() {
        if (this.iXG != null) {
            this.iXG.c(this);
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (!x.isEmpty(list)) {
            this.mDatas = list;
            this.iXC.setVisibility(0);
            this.iXD.setVisibility(0);
            int size = list.size();
            if (size == 1) {
                this.iXy.setVisibility(0);
                this.iXy.setData(list.get(0));
                this.iXz.setVisibility(8);
                this.iXA.setVisibility(8);
            } else if (size == 2) {
                this.iXy.setVisibility(0);
                this.iXy.setData(list.get(0));
                this.iXz.setVisibility(0);
                this.iXz.setData(list.get(1));
                this.iXA.setVisibility(8);
            } else {
                this.iXy.setVisibility(0);
                this.iXy.setData(list.get(0));
                this.iXz.setVisibility(0);
                this.iXz.setData(list.get(1));
                this.iXA.setVisibility(0);
                this.iXA.setData(list.get(2));
            }
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iXH == null) {
            this.iXH = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iXH.setInterpolator(new LinearInterpolator());
            this.iXH.setFillAfter(true);
        }
        return this.iXH;
    }

    public void cCE() {
        if (this.iXB != null) {
            this.iXB.startAnimation(getClickRotateAnimation());
        }
    }

    public void cCF() {
        if (this.iXB != null) {
            this.iXB.clearAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iXB || view == this.iXF) && this.iXG != null) {
            this.iXG.c(this);
            cCE();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        cCF();
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
        cCF();
        if (emotionCenterData != null && !x.isEmpty(emotionCenterData.package_list)) {
            setData(emotionCenterData.package_list);
        }
    }
}
