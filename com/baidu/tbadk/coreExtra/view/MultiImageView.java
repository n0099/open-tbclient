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
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private com.baidu.tbadk.widget.g aeA;
    private boolean aeG;
    private com.baidu.tbadk.widget.h aez;
    private boolean afA;
    private boolean afB;
    private Button aft;
    private Button afu;
    private LinearLayout afv;
    private p afw;
    private ViewPager.OnPageChangeListener afx;
    private s afy;
    private int afz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.aft = null;
        this.afu = null;
        this.afv = null;
        this.mOnClickListener = null;
        this.afw = null;
        this.mOnPageChangeListener = null;
        this.afx = null;
        this.aez = null;
        this.afy = null;
        this.aeA = null;
        this.afz = 0;
        this.afA = true;
        this.afB = false;
        this.aeG = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.afw != null) {
            this.afw.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aft = null;
        this.afu = null;
        this.afv = null;
        this.mOnClickListener = null;
        this.afw = null;
        this.mOnPageChangeListener = null;
        this.afx = null;
        this.aez = null;
        this.afy = null;
        this.aeA = null;
        this.afz = 0;
        this.afA = true;
        this.afB = false;
        this.aeG = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aft = null;
        this.afu = null;
        this.afv = null;
        this.mOnClickListener = null;
        this.afw = null;
        this.mOnPageChangeListener = null;
        this.afx = null;
        this.aez = null;
        this.afy = null;
        this.aeA = null;
        this.afz = 0;
        this.afA = true;
        this.afB = false;
        this.aeG = false;
        init();
    }

    private void init() {
        this.afB = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new al(this);
        this.mOnPageChangeListener = new am(this);
        this.aez = new an(this);
        this.aeA = new ao(this);
    }

    public void onResume() {
        if (this.afw.getCurrentView() != null) {
            if (this.afA) {
                int childCount = this.afw.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.afw.getChildAt(i);
                    if (childAt != null && (childAt instanceof at) && ((at) childAt).getImageView() != this.afw.getCurrentView()) {
                        ((at) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.afw.findViewWithTag(String.valueOf(this.afw.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof at)) {
                ((at) findViewWithTag).aH(this.aeG);
            }
            this.afw.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.afw.getCurrentView() != null) {
            this.afw.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.afw != null) {
            int childCount = this.afw.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.afw.getChildAt(i);
                if (childAt != null && (childAt instanceof at)) {
                    ((at) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.afw = new p(getContext());
        this.afw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.afw.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.afw);
        this.afv = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.afv.setOrientation(0);
        this.afv.setLayoutParams(layoutParams);
        addView(this.afv);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.afu = new Button(getContext());
        this.afu.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomout));
        this.afu.setLayoutParams(layoutParams2);
        this.afu.setOnClickListener(this.mOnClickListener);
        this.afu.setEnabled(false);
        this.afv.addView(this.afu);
        this.aft = new Button(getContext());
        this.aft.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomin));
        this.aft.setLayoutParams(layoutParams2);
        this.aft.setOnClickListener(this.mOnClickListener);
        this.aft.setEnabled(false);
        this.afv.addView(this.aft);
        if (this.afB) {
            this.afv.setVisibility(8);
        }
        this.afy = new s(getContext(), null, this.aeA);
        setAdapter(this.afy);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.afx = onPageChangeListener;
    }

    public int getItemNum() {
        return this.afy.getCount();
    }

    public int getCurrentItem() {
        return this.afw.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aft.setEnabled(true);
            } else {
                this.aft.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.afu.setEnabled(true);
                return;
            } else {
                this.afu.setEnabled(false);
                return;
            }
        }
        this.afu.setEnabled(false);
        this.aft.setEnabled(false);
    }

    public void xm() {
        if (!this.afB) {
            this.afv.setVisibility(0);
        }
    }

    public void xn() {
        if (!this.afB) {
            this.afv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.afw.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.afw.setPageMargin(i);
    }

    public void v(int i, int i2) {
        this.afw.setOffscreenPageLimit(i);
        this.afz = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.afz = (int) (this.afz * 0.8d);
        if (this.afz < 6291456) {
            this.afA = true;
            this.afz = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.afA = false;
        }
        PagerAdapter adapter = this.afw.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.afz);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.aez);
        this.afw.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.afw.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.afy.setTempSize(i);
        this.afy.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.afy.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afy.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.afy.p(arrayList);
        this.afy.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.afy.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.afy.setHasNext(z);
        this.afy.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.afy.getHasNext();
    }

    public void setNextTitle(String str) {
        this.afy.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.afw.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.afw.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aeG = z;
        if (this.afy != null) {
            this.afy.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.afy != null) {
            this.afy.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.afy != null) {
            this.afy.setHeadImage(z);
        }
    }
}
