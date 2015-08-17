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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e akK;
    private a.d akL;
    private boolean akR;
    private Button alB;
    private Button alC;
    private LinearLayout alD;
    private i alE;
    private ViewPager.OnPageChangeListener alF;
    private k alG;
    private int alH;
    private boolean alI;
    private boolean alJ;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.alB = null;
        this.alC = null;
        this.alD = null;
        this.mOnClickListener = null;
        this.alE = null;
        this.mOnPageChangeListener = null;
        this.alF = null;
        this.akK = null;
        this.alG = null;
        this.akL = null;
        this.alH = 0;
        this.alI = true;
        this.alJ = false;
        this.akR = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.alE != null) {
            this.alE.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alB = null;
        this.alC = null;
        this.alD = null;
        this.mOnClickListener = null;
        this.alE = null;
        this.mOnPageChangeListener = null;
        this.alF = null;
        this.akK = null;
        this.alG = null;
        this.akL = null;
        this.alH = 0;
        this.alI = true;
        this.alJ = false;
        this.akR = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alB = null;
        this.alC = null;
        this.alD = null;
        this.mOnClickListener = null;
        this.alE = null;
        this.mOnPageChangeListener = null;
        this.alF = null;
        this.akK = null;
        this.alG = null;
        this.akL = null;
        this.alH = 0;
        this.alI = true;
        this.alJ = false;
        this.akR = false;
        init();
    }

    private void init() {
        this.alJ = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new x(this);
        this.mOnPageChangeListener = new y(this);
        this.akK = new z(this);
        this.akL = new aa(this);
    }

    public void onResume() {
        if (this.alE.getCurrentView() != null) {
            if (this.alI) {
                int childCount = this.alE.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.alE.getChildAt(i);
                    if (childAt != null && (childAt instanceof ae) && ((ae) childAt).getImageView() != this.alE.getCurrentView()) {
                        ((ae) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.alE.findViewWithTag(String.valueOf(this.alE.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ae)) {
                ((ae) findViewWithTag).aS(this.akR);
            }
            this.alE.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.alE.getCurrentView() != null) {
            this.alE.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.alE != null) {
            int childCount = this.alE.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.alE.getChildAt(i);
                if (childAt != null && (childAt instanceof ae)) {
                    ((ae) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.alE = new i(getContext());
        this.alE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.alE.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.alE);
        this.alD = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.alD.setOrientation(0);
        this.alD.setLayoutParams(layoutParams);
        addView(this.alD);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.alC = new Button(getContext());
        this.alC.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomout));
        this.alC.setLayoutParams(layoutParams2);
        this.alC.setOnClickListener(this.mOnClickListener);
        this.alC.setEnabled(false);
        this.alD.addView(this.alC);
        this.alB = new Button(getContext());
        this.alB.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomin));
        this.alB.setLayoutParams(layoutParams2);
        this.alB.setOnClickListener(this.mOnClickListener);
        this.alB.setEnabled(false);
        this.alD.addView(this.alB);
        if (this.alJ) {
            this.alD.setVisibility(8);
        }
        this.alG = new k(getContext(), null, this.akL);
        setAdapter(this.alG);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.alF = onPageChangeListener;
    }

    public int getItemNum() {
        return this.alG.getCount();
    }

    public int getCurrentItem() {
        return this.alE.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.alB.setEnabled(true);
            } else {
                this.alB.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.alC.setEnabled(true);
                return;
            } else {
                this.alC.setEnabled(false);
                return;
            }
        }
        this.alC.setEnabled(false);
        this.alB.setEnabled(false);
    }

    public void zj() {
        if (!this.alJ) {
            this.alD.setVisibility(0);
        }
    }

    public void zk() {
        if (!this.alJ) {
            this.alD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.alE.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.alE.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.alE.setOffscreenPageLimit(i);
        this.alH = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.alH = (int) (this.alH * 0.8d);
        if (this.alH < 6291456) {
            this.alI = true;
            this.alH = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.alI = false;
        }
        PagerAdapter adapter = this.alE.getAdapter();
        if (adapter != null && (adapter instanceof k)) {
            ((k) adapter).setGifMaxUseableMem(this.alH);
        }
    }

    private void setAdapter(k kVar) {
        kVar.a(this.akK);
        this.alE.setAdapter(kVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.alE.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.alG.setTempSize(i);
        this.alG.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.alG.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alG.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.alG.setData(arrayList);
        this.alG.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.alG.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.alG.setHasNext(z);
        this.alG.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.alG.getHasNext();
    }

    public void setNextTitle(String str) {
        this.alG.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.alE.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.alE.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.akR = z;
        if (this.alG != null) {
            this.alG.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.alG != null) {
            this.alG.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.alG != null) {
            this.alG.setHeadImage(z);
        }
    }
}
