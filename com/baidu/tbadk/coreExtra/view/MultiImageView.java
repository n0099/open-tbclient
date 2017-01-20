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
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e anB;
    private a.d anC;
    private boolean anK;
    private boolean aoA;
    private boolean aoB;
    private Button aos;
    private Button aot;
    private LinearLayout aou;
    private h aov;
    private ViewPager.OnPageChangeListener aow;
    private i aox;
    private int aoy;
    private boolean aoz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aos = null;
        this.aot = null;
        this.aou = null;
        this.mOnClickListener = null;
        this.aov = null;
        this.mOnPageChangeListener = null;
        this.aow = null;
        this.anB = null;
        this.aox = null;
        this.anC = null;
        this.aoy = 0;
        this.aoz = true;
        this.aoA = false;
        this.anK = false;
        this.aoB = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aov != null) {
            this.aov.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aos = null;
        this.aot = null;
        this.aou = null;
        this.mOnClickListener = null;
        this.aov = null;
        this.mOnPageChangeListener = null;
        this.aow = null;
        this.anB = null;
        this.aox = null;
        this.anC = null;
        this.aoy = 0;
        this.aoz = true;
        this.aoA = false;
        this.anK = false;
        this.aoB = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aos = null;
        this.aot = null;
        this.aou = null;
        this.mOnClickListener = null;
        this.aov = null;
        this.mOnPageChangeListener = null;
        this.aow = null;
        this.anB = null;
        this.aox = null;
        this.anC = null;
        this.aoy = 0;
        this.aoz = true;
        this.aoA = false;
        this.anK = false;
        this.aoB = false;
        init();
    }

    private void init() {
        this.aoA = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.anB = new q(this);
        this.anC = new r(this);
    }

    public void dg(int i) {
        if (this.mSkinType != i && this.aov != null) {
            int childCount = this.aov.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aov.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aov.getCurrentView() != null) {
            if (this.aoz) {
                int childCount = this.aov.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aov.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aov.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aov.findViewWithTag(String.valueOf(this.aov.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.anK, true);
            }
            this.aov.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aov.getCurrentView() != null) {
            this.aov.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aov != null) {
            int childCount = this.aov.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aov.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aov = new h(getContext());
        this.aov.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aov.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aov);
        this.aou = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aou.setOrientation(0);
        this.aou.setLayoutParams(layoutParams);
        addView(this.aou);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aot = new Button(getContext());
        this.aot.setBackgroundDrawable(getContext().getResources().getDrawable(r.g.image_zoomout));
        this.aot.setLayoutParams(layoutParams2);
        this.aot.setOnClickListener(this.mOnClickListener);
        this.aot.setEnabled(false);
        this.aou.addView(this.aot);
        this.aos = new Button(getContext());
        this.aos.setBackgroundDrawable(getContext().getResources().getDrawable(r.g.image_zoomin));
        this.aos.setLayoutParams(layoutParams2);
        this.aos.setOnClickListener(this.mOnClickListener);
        this.aos.setEnabled(false);
        this.aou.addView(this.aos);
        if (this.aoA) {
            this.aou.setVisibility(8);
        }
        this.aox = new i(getContext(), null, this.anC);
        setAdapter(this.aox);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aow = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aox.getCount();
    }

    public int getCurrentItem() {
        return this.aov.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aos.setEnabled(true);
            } else {
                this.aos.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aot.setEnabled(true);
                return;
            } else {
                this.aot.setEnabled(false);
                return;
            }
        }
        this.aot.setEnabled(false);
        this.aos.setEnabled(false);
    }

    public void AJ() {
        if (!this.aoA) {
            this.aou.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.aoB = z;
        if (this.aov != null) {
            View findViewWithTag = this.aov.findViewWithTag(String.valueOf(this.aov.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bn(z);
            }
        }
    }

    public void AK() {
        if (!this.aoA) {
            this.aou.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aov.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aov.setPageMargin(i);
    }

    public void D(int i, int i2) {
        this.aov.setOffscreenPageLimit(i);
        this.aoy = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aoy = (int) (this.aoy * 0.8d);
        if (this.aoy < 6291456) {
            this.aoz = true;
            this.aoy = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aoz = false;
        }
        PagerAdapter adapter = this.aov.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aoy);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.anB);
        this.aov.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aox);
        this.aov.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aox.setTempSize(i);
        this.aox.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aox.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aox.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aox.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aox.setData(arrayList);
        this.aox.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aox.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aox.setHasNext(z);
        this.aox.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aox.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aox.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aov.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aov.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.anK = z;
        if (this.aox != null) {
            this.aox.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aox != null) {
            this.aox.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aox != null) {
            this.aox.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aox.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aox != null) {
            this.aox.setOriImgSelectedCallback(bVar);
        }
    }
}
