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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private Button bkY;
    private Button bkZ;
    private a.f bkh;
    private a.e bki;
    private boolean bkr;
    private LinearLayout bla;
    private b blb;
    private ViewPager.OnPageChangeListener blc;
    private c bld;
    private int ble;
    private boolean blf;
    private boolean blg;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bkY = null;
        this.bkZ = null;
        this.bla = null;
        this.mOnClickListener = null;
        this.blb = null;
        this.mOnPageChangeListener = null;
        this.blc = null;
        this.bkh = null;
        this.bld = null;
        this.bki = null;
        this.ble = 0;
        this.blf = true;
        this.blg = false;
        this.bkr = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.blb != null) {
            this.blb.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bkY = null;
        this.bkZ = null;
        this.bla = null;
        this.mOnClickListener = null;
        this.blb = null;
        this.mOnPageChangeListener = null;
        this.blc = null;
        this.bkh = null;
        this.bld = null;
        this.bki = null;
        this.ble = 0;
        this.blf = true;
        this.blg = false;
        this.bkr = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bkY = null;
        this.bkZ = null;
        this.bla = null;
        this.mOnClickListener = null;
        this.blb = null;
        this.mOnPageChangeListener = null;
        this.blc = null;
        this.bkh = null;
        this.bld = null;
        this.bki = null;
        this.ble = 0;
        this.blf = true;
        this.blg = false;
        this.bkr = false;
        init();
    }

    public void init() {
        this.blg = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bkY) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Pb();
                    }
                } else if (view == MultiImageView.this.bkZ && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Pc();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.blc != null) {
                    MultiImageView.this.blc.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.blc != null) {
                    MultiImageView.this.blc.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.blb.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.blb.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).Jc();
                    }
                }
                if (MultiImageView.this.blc != null) {
                    MultiImageView.this.blc.onPageSelected(i);
                }
            }
        };
        this.bkh = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.blb.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bki = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.blb.getCurrentView()) {
                    if (MultiImageView.this.blf) {
                        int childCount = MultiImageView.this.blb.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.blb.getChildAt(i);
                            if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != aVar) {
                                ((f) childAt).release();
                            }
                        }
                    }
                    aVar.play();
                }
            }
        };
    }

    public void gg(int i) {
        if (this.mSkinType != i && this.blb != null) {
            int childCount = this.blb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.blb.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.blb.getCurrentView() != null) {
            if (this.blf) {
                int childCount = this.blb.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.blb.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.blb.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.blb.findViewWithTag(String.valueOf(this.blb.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bkr, true);
            }
            this.blb.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.blb.getCurrentView() != null) {
            this.blb.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.blb != null) {
            int childCount = this.blb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.blb.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hq(int i) {
        View findViewWithTag = this.blb.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bkr, true);
        }
    }

    private void initUI() {
        this.blb = new b(getContext());
        this.blb.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.blb.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.blb);
        this.bla = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bla.setOrientation(0);
        this.bla.setLayoutParams(layoutParams);
        addView(this.bla);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bkZ = new Button(getContext());
        this.bkZ.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bkZ.setLayoutParams(layoutParams2);
        this.bkZ.setOnClickListener(this.mOnClickListener);
        this.bkZ.setEnabled(false);
        this.bla.addView(this.bkZ);
        this.bkY = new Button(getContext());
        this.bkY.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bkY.setLayoutParams(layoutParams2);
        this.bkY.setOnClickListener(this.mOnClickListener);
        this.bkY.setEnabled(false);
        this.bla.addView(this.bkY);
        if (this.blg) {
            this.bla.setVisibility(8);
        }
        this.bld = new c(getContext(), this.blb, this.bki);
        setAdapter(this.bld);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bld != null) {
            this.bld.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.blc = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bld.getCount();
    }

    public int getCurrentItem() {
        return this.blb.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bkY.setEnabled(true);
            } else {
                this.bkY.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bkZ.setEnabled(true);
                return;
            } else {
                this.bkZ.setEnabled(false);
                return;
            }
        }
        this.bkZ.setEnabled(false);
        this.bkY.setEnabled(false);
    }

    public void IF() {
        if (!this.blg) {
            this.bla.setVisibility(0);
        }
    }

    public void bQ(boolean z) {
        if (this.blb != null) {
            int childCount = this.blb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.blb.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bQ(z);
                }
            }
        }
    }

    public void IG() {
        if (!this.blg) {
            this.bla.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.blb.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.blb.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.blb.setOffscreenPageLimit(i);
        this.ble = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.ble = (int) (this.ble * 0.8d);
        if (this.ble < 6291456) {
            this.blf = true;
            this.ble = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.blf = false;
        }
        PagerAdapter adapter = this.blb.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.ble);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bkh);
        this.blb.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bld);
        this.blb.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bld.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bld.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bld.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bld.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bld.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bld.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bld.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bld.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bld.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bld.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bld.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.blb.getCurrentView();
        if (currentView == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.bld != null) {
            this.bld.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.blb.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bkr = z;
        if (this.bld != null) {
            this.bld.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bld != null) {
            this.bld.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bld != null) {
            this.bld.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bld.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bld != null) {
            this.bld.setOriImgSelectedCallback(bVar);
        }
    }
}
