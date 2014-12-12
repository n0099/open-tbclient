package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private com.baidu.tbadk.widget.h TM;
    private com.baidu.tbadk.widget.g TN;
    private boolean TT;
    private Button UB;
    private Button UC;
    private LinearLayout UD;
    private p UE;
    private ViewPager.OnPageChangeListener UF;
    private s UG;
    private int UH;
    private boolean UI;
    private boolean UJ;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.UB = null;
        this.UC = null;
        this.UD = null;
        this.mOnClickListener = null;
        this.UE = null;
        this.mOnPageChangeListener = null;
        this.UF = null;
        this.TM = null;
        this.UG = null;
        this.TN = null;
        this.UH = 0;
        this.UI = true;
        this.UJ = false;
        this.TT = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.UE != null) {
            this.UE.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UB = null;
        this.UC = null;
        this.UD = null;
        this.mOnClickListener = null;
        this.UE = null;
        this.mOnPageChangeListener = null;
        this.UF = null;
        this.TM = null;
        this.UG = null;
        this.TN = null;
        this.UH = 0;
        this.UI = true;
        this.UJ = false;
        this.TT = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UB = null;
        this.UC = null;
        this.UD = null;
        this.mOnClickListener = null;
        this.UE = null;
        this.mOnPageChangeListener = null;
        this.UF = null;
        this.TM = null;
        this.UG = null;
        this.TN = null;
        this.UH = 0;
        this.UI = true;
        this.UJ = false;
        this.TT = false;
        init();
    }

    private void init() {
        this.UJ = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new am(this);
        this.mOnPageChangeListener = new an(this);
        this.TM = new ao(this);
        this.TN = new ap(this);
    }

    public void onResume() {
        if (this.UE.getCurrentView() != null) {
            if (this.UI) {
                int childCount = this.UE.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.UE.getChildAt(i);
                    if (childAt != null && (childAt instanceof ay) && ((ay) childAt).getImageView() != this.UE.getCurrentView()) {
                        ((ay) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.UE.findViewWithTag(String.valueOf(this.UE.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ay)) {
                ((ay) findViewWithTag).az(this.TT);
            }
            this.UE.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.UE.getCurrentView() != null) {
            this.UE.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.UE != null) {
            int childCount = this.UE.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.UE.getChildAt(i);
                if (childAt != null && (childAt instanceof ay)) {
                    ((ay) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.UE = new p(getContext());
        this.UE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.UE.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.UE);
        this.UD = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.UD.setOrientation(0);
        this.UD.setLayoutParams(layoutParams);
        addView(this.UD);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.UC = new Button(getContext());
        this.UC.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomout));
        this.UC.setLayoutParams(layoutParams2);
        this.UC.setOnClickListener(this.mOnClickListener);
        this.UC.setEnabled(false);
        this.UD.addView(this.UC);
        this.UB = new Button(getContext());
        this.UB.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomin));
        this.UB.setLayoutParams(layoutParams2);
        this.UB.setOnClickListener(this.mOnClickListener);
        this.UB.setEnabled(false);
        this.UD.addView(this.UB);
        if (this.UJ) {
            this.UD.setVisibility(8);
        }
        this.UG = new s(getContext(), null, this.TN);
        setAdapter(this.UG);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.UF = onPageChangeListener;
    }

    public int getItemNum() {
        return this.UG.getCount();
    }

    public int getCurrentItem() {
        return this.UE.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.UB.setEnabled(true);
            } else {
                this.UB.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.UC.setEnabled(true);
                return;
            } else {
                this.UC.setEnabled(false);
                return;
            }
        }
        this.UC.setEnabled(false);
        this.UB.setEnabled(false);
    }

    public void tB() {
        if (!this.UJ) {
            this.UD.setVisibility(0);
        }
    }

    public void tC() {
        if (!this.UJ) {
            this.UD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.UE.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.UE.setPageMargin(i);
    }

    public void x(int i, int i2) {
        this.UE.setOffscreenPageLimit(i);
        this.UH = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.UH = (int) (this.UH * 0.8d);
        if (this.UH < 6291456) {
            this.UI = true;
            this.UH = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.UI = false;
        }
        PagerAdapter adapter = this.UE.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.UH);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.TM);
        this.UE.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.UE.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.UG.setTempSize(i);
        this.UG.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.UG.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.UG.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.UG.r(arrayList);
        this.UG.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.UG.setHasNext(z);
        this.UG.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.UG.getHasNext();
    }

    public void setNextTitle(String str) {
        this.UG.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.UE.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.UE.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.TT = z;
        if (this.UG != null) {
            this.UG.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.UG != null) {
            this.UG.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.UG != null) {
            this.UG.setHeadImage(z);
        }
    }
}
