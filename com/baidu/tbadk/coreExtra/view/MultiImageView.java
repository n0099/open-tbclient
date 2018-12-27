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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public class MultiImageView extends RelativeLayout {
    private boolean aTD;
    private DragImageView.g aTt;
    private DragImageView.e aTu;
    private Button aUq;
    private Button aUr;
    private LinearLayout aUs;
    private GalleryViewPager aUt;
    private ViewPager.OnPageChangeListener aUu;
    private ImagePagerAdapter aUv;
    private int aUw;
    private boolean aUx;
    private boolean aUy;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aUq = null;
        this.aUr = null;
        this.aUs = null;
        this.mOnClickListener = null;
        this.aUt = null;
        this.mOnPageChangeListener = null;
        this.aUu = null;
        this.aTt = null;
        this.aUv = null;
        this.aTu = null;
        this.aUw = 0;
        this.aUx = true;
        this.aUy = false;
        this.aTD = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aUt != null) {
            this.aUt.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aUq = null;
        this.aUr = null;
        this.aUs = null;
        this.mOnClickListener = null;
        this.aUt = null;
        this.mOnPageChangeListener = null;
        this.aUu = null;
        this.aTt = null;
        this.aUv = null;
        this.aTu = null;
        this.aUw = 0;
        this.aUx = true;
        this.aUy = false;
        this.aTD = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aUq = null;
        this.aUr = null;
        this.aUs = null;
        this.mOnClickListener = null;
        this.aUt = null;
        this.mOnPageChangeListener = null;
        this.aUu = null;
        this.aTt = null;
        this.aUv = null;
        this.aTu = null;
        this.aUw = 0;
        this.aUx = true;
        this.aUy = false;
        this.aTD = false;
        init();
    }

    public void init() {
        this.aUy = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aUq) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.QA();
                    }
                } else if (view == MultiImageView.this.aUr && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.QB();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aUu != null) {
                    MultiImageView.this.aUu.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aUu != null) {
                    MultiImageView.this.aUu.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aUt.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aUt.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).KM();
                    }
                }
                if (MultiImageView.this.aUu != null) {
                    MultiImageView.this.aUu.onPageSelected(i);
                }
            }
        };
        this.aTt = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aUt.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aTu = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aUt.getCurrentView()) {
                    if (MultiImageView.this.aUx) {
                        int childCount = MultiImageView.this.aUt.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aUt.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
    }

    public void ej(int i) {
        if (this.mSkinType != i && this.aUt != null) {
            int childCount = this.aUt.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aUt.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aUt.getCurrentView() != null) {
            if (this.aUx) {
                int childCount = this.aUt.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aUt.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aUt.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aUt.findViewWithTag(String.valueOf(this.aUt.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aTD, true);
            }
            this.aUt.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aUt.getCurrentView() != null) {
            this.aUt.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aUt != null) {
            int childCount = this.aUt.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aUt.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void fu(int i) {
        View findViewWithTag = this.aUt.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aTD, true);
        }
    }

    private void initUI() {
        this.aUt = new GalleryViewPager(getContext());
        this.aUt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aUt.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aUt);
        this.aUs = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aUs.setOrientation(0);
        this.aUs.setLayoutParams(layoutParams);
        addView(this.aUs);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aUr = new Button(getContext());
        al.d(this.aUr, e.f.image_zoomout, 0);
        this.aUr.setLayoutParams(layoutParams2);
        this.aUr.setOnClickListener(this.mOnClickListener);
        this.aUr.setEnabled(false);
        this.aUs.addView(this.aUr);
        this.aUq = new Button(getContext());
        al.d(this.aUq, e.f.image_zoomin, 0);
        this.aUq.setLayoutParams(layoutParams2);
        this.aUq.setOnClickListener(this.mOnClickListener);
        this.aUq.setEnabled(false);
        this.aUs.addView(this.aUq);
        if (this.aUy) {
            this.aUs.setVisibility(8);
        }
        this.aUv = new ImagePagerAdapter(getContext(), this.aUt, this.aTu);
        setAdapter(this.aUv);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aUv != null) {
            this.aUv.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aUv != null) {
            this.aUv.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aUu = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aUv.getCount();
    }

    public int getCurrentItem() {
        return this.aUt.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aUq.setEnabled(true);
            } else {
                this.aUq.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aUr.setEnabled(true);
                return;
            } else {
                this.aUr.setEnabled(false);
                return;
            }
        }
        this.aUr.setEnabled(false);
        this.aUq.setEnabled(false);
    }

    public void Kw() {
        if (!this.aUy) {
            this.aUs.setVisibility(0);
        }
    }

    public void cf(boolean z) {
        if (this.aUt != null) {
            int childCount = this.aUt.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aUt.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).cf(z);
                }
            }
        }
    }

    public void Kx() {
        if (!this.aUy) {
            this.aUs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aUt.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aUt.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aUt.setOffscreenPageLimit(i);
        this.aUw = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aUw = (int) (this.aUw * 0.8d);
        if (this.aUw < 6291456) {
            this.aUx = true;
            this.aUw = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aUx = false;
        }
        PagerAdapter adapter = this.aUt.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aUw);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aTt);
        this.aUt.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aUv);
        this.aUt.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aUv.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aUv.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aUv.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aUv.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUv.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aUv.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aUv.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aUv.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aUv.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aUv.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aUv.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aUt.getCurrentView();
        if (currentView == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.aUv != null) {
            this.aUv.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aUt.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aUt.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aTD = z;
        if (this.aUv != null) {
            this.aUv.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aUv != null) {
            this.aUv.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aUv != null) {
            this.aUv.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aUv.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aUv != null) {
            this.aUv.setOriImgSelectedCallback(bVar);
        }
    }
}
