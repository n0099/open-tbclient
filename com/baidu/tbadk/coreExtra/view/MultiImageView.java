package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.i;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private Button auW;
    private Button auX;
    private LinearLayout auY;
    private h auZ;
    private b.e auf;
    private b.d aug;
    private boolean auo;
    private ViewPager.OnPageChangeListener ava;
    private i avb;
    private int avc;
    private boolean avd;
    private boolean ave;
    private boolean avf;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.auW = null;
        this.auX = null;
        this.auY = null;
        this.mOnClickListener = null;
        this.auZ = null;
        this.mOnPageChangeListener = null;
        this.ava = null;
        this.auf = null;
        this.avb = null;
        this.aug = null;
        this.avc = 0;
        this.avd = true;
        this.ave = false;
        this.auo = false;
        this.avf = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.auZ != null) {
            this.auZ.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.auW = null;
        this.auX = null;
        this.auY = null;
        this.mOnClickListener = null;
        this.auZ = null;
        this.mOnPageChangeListener = null;
        this.ava = null;
        this.auf = null;
        this.avb = null;
        this.aug = null;
        this.avc = 0;
        this.avd = true;
        this.ave = false;
        this.auo = false;
        this.avf = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.auW = null;
        this.auX = null;
        this.auY = null;
        this.mOnClickListener = null;
        this.auZ = null;
        this.mOnPageChangeListener = null;
        this.ava = null;
        this.auf = null;
        this.avb = null;
        this.aug = null;
        this.avc = 0;
        this.avd = true;
        this.ave = false;
        this.auo = false;
        this.avf = false;
        init();
    }

    private void init() {
        this.ave = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.auf = new q(this);
        this.aug = new r(this);
    }

    public void de(int i) {
        if (this.mSkinType != i && this.auZ != null) {
            int childCount = this.auZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.auZ.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.auZ.getCurrentView() != null) {
            if (this.avd) {
                int childCount = this.auZ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.auZ.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.auZ.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.auZ.findViewWithTag(String.valueOf(this.auZ.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).h(this.auo, true);
            }
            this.auZ.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.auZ.getCurrentView() != null) {
            this.auZ.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.auZ != null) {
            int childCount = this.auZ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.auZ.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.auZ = new h(getContext());
        this.auZ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.auZ.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.auZ);
        this.auY = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.auY.setOrientation(0);
        this.auY.setLayoutParams(layoutParams);
        addView(this.auY);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.auX = new Button(getContext());
        this.auX.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.auX.setLayoutParams(layoutParams2);
        this.auX.setOnClickListener(this.mOnClickListener);
        this.auX.setEnabled(false);
        this.auY.addView(this.auX);
        this.auW = new Button(getContext());
        this.auW.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.auW.setLayoutParams(layoutParams2);
        this.auW.setOnClickListener(this.mOnClickListener);
        this.auW.setEnabled(false);
        this.auY.addView(this.auW);
        if (this.ave) {
            this.auY.setVisibility(8);
        }
        this.avb = new i(getContext(), null, this.aug);
        setAdapter(this.avb);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ava = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avb.getCount();
    }

    public int getCurrentItem() {
        return this.auZ.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            if (bVar.canZoomIn()) {
                this.auW.setEnabled(true);
            } else {
                this.auW.setEnabled(false);
            }
            if (bVar.canZoomOut()) {
                this.auX.setEnabled(true);
                return;
            } else {
                this.auX.setEnabled(false);
                return;
            }
        }
        this.auX.setEnabled(false);
        this.auW.setEnabled(false);
    }

    public void Ba() {
        if (!this.ave) {
            this.auY.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.avf = z;
        if (this.auZ != null) {
            View findViewWithTag = this.auZ.findViewWithTag(String.valueOf(this.auZ.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bm(z);
            }
        }
    }

    public void Bb() {
        if (!this.ave) {
            this.auY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.b getCurrentImageView() {
        return this.auZ.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.auZ.setPageMargin(i);
    }

    public void I(int i, int i2) {
        this.auZ.setOffscreenPageLimit(i);
        this.avc = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avc = (int) (this.avc * 0.8d);
        if (this.avc < 6291456) {
            this.avd = true;
            this.avc = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.avd = false;
        }
        PagerAdapter adapter = this.auZ.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.avc);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.auf);
        this.auZ.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avb);
        this.auZ.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avb.setTempSize(i);
        this.avb.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avb.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avb.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avb.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avb.setData(arrayList);
        this.avb.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avb.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avb.setHasNext(z);
        this.avb.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.avb.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avb.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.b selectedView = this.auZ.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.b selectedView = this.auZ.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.auo = z;
        if (this.avb != null) {
            this.avb.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avb != null) {
            this.avb.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avb != null) {
            this.avb.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.avb.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.avb != null) {
            this.avb.setOriImgSelectedCallback(bVar);
        }
    }
}
