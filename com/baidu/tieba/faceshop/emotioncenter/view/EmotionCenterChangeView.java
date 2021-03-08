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
/* loaded from: classes8.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    private TbPageContext eWx;
    private RelativeLayout jaA;
    private View jaB;
    private TextView jaC;
    private EmotionChangeModel jaD;
    private Animation jaE;
    private EmotionHorizontalView jav;
    private EmotionHorizontalView jaw;
    private EmotionHorizontalView jax;
    private ImageView jay;
    private LinearLayout jaz;
    private List<EmotionPackageData> mDatas;
    private TextView mTitle;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.jaE = null;
        this.eWx = tbPageContext;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jaE = null;
        initView();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jaE = null;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.jav = new EmotionHorizontalView(this.eWx);
        this.jaw = new EmotionHorizontalView(this.eWx);
        this.jax = new EmotionHorizontalView(this.eWx);
        this.jav.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.jaw.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.jax.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        addView(this.jav);
        addView(this.jaw);
        addView(this.jax);
        this.jav.setVisibility(8);
        this.jaw.setVisibility(8);
        this.jax.setVisibility(8);
        this.jaz = (LinearLayout) findViewById(R.id.emotion_change_item);
        this.jaA = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.jaA.setVisibility(8);
        this.jay = (ImageView) findViewById(R.id.emotion_change_iv);
        this.jay.setOnClickListener(this);
        this.jaB = findViewById(R.id.category_line_top);
        this.mTitle = (TextView) findViewById(R.id.emotion_title);
        this.jaC = (TextView) findViewById(R.id.emotion_function);
        this.jaC.setOnClickListener(this);
        this.jaD = new EmotionChangeModel(this.eWx);
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundColor(this.jaB, R.color.common_color_10312);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        ap.setImageResource(this.jay, R.drawable.emotion_icon_refresh);
        ap.setViewTextColor(this.jaC, R.color.CAM_X0109);
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

    public void cAj() {
        if (this.jaD != null) {
            this.jaD.c(this);
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (!y.isEmpty(list)) {
            this.mDatas = list;
            this.jaz.setVisibility(0);
            this.jaA.setVisibility(0);
            int size = list.size();
            if (size == 1) {
                this.jav.setVisibility(0);
                this.jav.setData(list.get(0));
                this.jaw.setVisibility(8);
                this.jax.setVisibility(8);
            } else if (size == 2) {
                this.jav.setVisibility(0);
                this.jav.setData(list.get(0));
                this.jaw.setVisibility(0);
                this.jaw.setData(list.get(1));
                this.jax.setVisibility(8);
            } else {
                this.jav.setVisibility(0);
                this.jav.setData(list.get(0));
                this.jaw.setVisibility(0);
                this.jaw.setData(list.get(1));
                this.jax.setVisibility(0);
                this.jax.setData(list.get(2));
            }
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.jaE == null) {
            this.jaE = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.jaE.setInterpolator(new LinearInterpolator());
            this.jaE.setFillAfter(true);
        }
        return this.jaE;
    }

    public void cAk() {
        if (this.jay != null) {
            this.jay.startAnimation(getClickRotateAnimation());
        }
    }

    public void cAl() {
        if (this.jay != null) {
            this.jay.clearAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.jay || view == this.jaC) && this.jaD != null) {
            this.jaD.c(this);
            cAk();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        cAl();
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
        cAl();
        if (emotionCenterData != null && !y.isEmpty(emotionCenterData.package_list)) {
            setData(emotionCenterData.package_list);
        }
    }
}
