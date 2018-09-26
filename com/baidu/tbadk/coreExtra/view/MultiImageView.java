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
/* loaded from: classes2.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.e aKA;
    private boolean aKJ;
    private DragImageView.g aKz;
    private ViewPager.OnPageChangeListener aLA;
    private ImagePagerAdapter aLB;
    private int aLC;
    private boolean aLD;
    private boolean aLE;
    private Button aLw;
    private Button aLx;
    private LinearLayout aLy;
    private GalleryViewPager aLz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aLw = null;
        this.aLx = null;
        this.aLy = null;
        this.mOnClickListener = null;
        this.aLz = null;
        this.mOnPageChangeListener = null;
        this.aLA = null;
        this.aKz = null;
        this.aLB = null;
        this.aKA = null;
        this.aLC = 0;
        this.aLD = true;
        this.aLE = false;
        this.aKJ = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aLz != null) {
            this.aLz.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aLw = null;
        this.aLx = null;
        this.aLy = null;
        this.mOnClickListener = null;
        this.aLz = null;
        this.mOnPageChangeListener = null;
        this.aLA = null;
        this.aKz = null;
        this.aLB = null;
        this.aKA = null;
        this.aLC = 0;
        this.aLD = true;
        this.aLE = false;
        this.aKJ = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aLw = null;
        this.aLx = null;
        this.aLy = null;
        this.mOnClickListener = null;
        this.aLz = null;
        this.mOnPageChangeListener = null;
        this.aLA = null;
        this.aKz = null;
        this.aLB = null;
        this.aKA = null;
        this.aLC = 0;
        this.aLD = true;
        this.aLE = false;
        this.aKJ = false;
        init();
    }

    public void init() {
        this.aLE = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aLw) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Nl();
                    }
                } else if (view == MultiImageView.this.aLx && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Nm();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aLA != null) {
                    MultiImageView.this.aLA.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aLA != null) {
                    MultiImageView.this.aLA.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aLz.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aLz.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Hu();
                    }
                }
                if (MultiImageView.this.aLA != null) {
                    MultiImageView.this.aLA.onPageSelected(i);
                }
            }
        };
        this.aKz = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aLz.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aKA = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aLz.getCurrentView()) {
                    if (MultiImageView.this.aLD) {
                        int childCount = MultiImageView.this.aLz.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aLz.getChildAt(i);
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

    public void dx(int i) {
        if (this.mSkinType != i && this.aLz != null) {
            int childCount = this.aLz.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aLz.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aLz.getCurrentView() != null) {
            if (this.aLD) {
                int childCount = this.aLz.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aLz.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aLz.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aLz.findViewWithTag(String.valueOf(this.aLz.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aKJ, true);
            }
            this.aLz.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aLz.getCurrentView() != null) {
            this.aLz.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aLz != null) {
            int childCount = this.aLz.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aLz.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void eI(int i) {
        View findViewWithTag = this.aLz.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aKJ, true);
        }
    }

    private void initUI() {
        this.aLz = new GalleryViewPager(getContext());
        this.aLz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aLz.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aLz);
        this.aLy = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aLy.setOrientation(0);
        this.aLy.setLayoutParams(layoutParams);
        addView(this.aLy);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aLx = new Button(getContext());
        al.d(this.aLx, e.f.image_zoomout, 0);
        this.aLx.setLayoutParams(layoutParams2);
        this.aLx.setOnClickListener(this.mOnClickListener);
        this.aLx.setEnabled(false);
        this.aLy.addView(this.aLx);
        this.aLw = new Button(getContext());
        al.d(this.aLw, e.f.image_zoomin, 0);
        this.aLw.setLayoutParams(layoutParams2);
        this.aLw.setOnClickListener(this.mOnClickListener);
        this.aLw.setEnabled(false);
        this.aLy.addView(this.aLw);
        if (this.aLE) {
            this.aLy.setVisibility(8);
        }
        this.aLB = new ImagePagerAdapter(getContext(), this.aLz, this.aKA);
        setAdapter(this.aLB);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aLB != null) {
            this.aLB.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aLB != null) {
            this.aLB.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aLA = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aLB.getCount();
    }

    public int getCurrentItem() {
        return this.aLz.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aLw.setEnabled(true);
            } else {
                this.aLw.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aLx.setEnabled(true);
                return;
            } else {
                this.aLx.setEnabled(false);
                return;
            }
        }
        this.aLx.setEnabled(false);
        this.aLw.setEnabled(false);
    }

    public void He() {
        if (!this.aLE) {
            this.aLy.setVisibility(0);
        }
    }

    public void bE(boolean z) {
        if (this.aLz != null) {
            int childCount = this.aLz.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aLz.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bE(z);
                }
            }
        }
    }

    public void Hf() {
        if (!this.aLE) {
            this.aLy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aLz.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aLz.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aLz.setOffscreenPageLimit(i);
        this.aLC = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aLC = (int) (this.aLC * 0.8d);
        if (this.aLC < 6291456) {
            this.aLD = true;
            this.aLC = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aLD = false;
        }
        PagerAdapter adapter = this.aLz.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aLC);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aKz);
        this.aLz.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aLB);
        this.aLz.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aLB.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aLB.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aLB.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aLB.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aLB.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aLB.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aLB.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aLB.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aLB.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aLB.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aLB.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aLz.getCurrentView();
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
        if (this.aLB != null) {
            this.aLB.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aLz.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aLz.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aKJ = z;
        if (this.aLB != null) {
            this.aLB.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aLB != null) {
            this.aLB.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aLB != null) {
            this.aLB.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aLB.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aLB != null) {
            this.aLB.setOriImgSelectedCallback(bVar);
        }
    }
}
