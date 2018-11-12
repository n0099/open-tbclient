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
    private DragImageView.g aPR;
    private DragImageView.e aPS;
    private Button aQO;
    private Button aQP;
    private LinearLayout aQQ;
    private GalleryViewPager aQR;
    private ViewPager.OnPageChangeListener aQS;
    private ImagePagerAdapter aQT;
    private int aQU;
    private boolean aQV;
    private boolean aQW;
    private boolean aQb;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aQO = null;
        this.aQP = null;
        this.aQQ = null;
        this.mOnClickListener = null;
        this.aQR = null;
        this.mOnPageChangeListener = null;
        this.aQS = null;
        this.aPR = null;
        this.aQT = null;
        this.aPS = null;
        this.aQU = 0;
        this.aQV = true;
        this.aQW = false;
        this.aQb = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aQR != null) {
            this.aQR.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aQO = null;
        this.aQP = null;
        this.aQQ = null;
        this.mOnClickListener = null;
        this.aQR = null;
        this.mOnPageChangeListener = null;
        this.aQS = null;
        this.aPR = null;
        this.aQT = null;
        this.aPS = null;
        this.aQU = 0;
        this.aQV = true;
        this.aQW = false;
        this.aQb = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aQO = null;
        this.aQP = null;
        this.aQQ = null;
        this.mOnClickListener = null;
        this.aQR = null;
        this.mOnPageChangeListener = null;
        this.aQS = null;
        this.aPR = null;
        this.aQT = null;
        this.aPS = null;
        this.aQU = 0;
        this.aQV = true;
        this.aQW = false;
        this.aQb = false;
        init();
    }

    public void init() {
        this.aQW = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aQO) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Ps();
                    }
                } else if (view == MultiImageView.this.aQP && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Pt();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aQS != null) {
                    MultiImageView.this.aQS.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aQS != null) {
                    MultiImageView.this.aQS.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aQR.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aQR.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).JH();
                    }
                }
                if (MultiImageView.this.aQS != null) {
                    MultiImageView.this.aQS.onPageSelected(i);
                }
            }
        };
        this.aPR = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aQR.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aPS = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aQR.getCurrentView()) {
                    if (MultiImageView.this.aQV) {
                        int childCount = MultiImageView.this.aQR.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aQR.getChildAt(i);
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

    public void dV(int i) {
        if (this.mSkinType != i && this.aQR != null) {
            int childCount = this.aQR.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aQR.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aQR.getCurrentView() != null) {
            if (this.aQV) {
                int childCount = this.aQR.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aQR.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aQR.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aQR.findViewWithTag(String.valueOf(this.aQR.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aQb, true);
            }
            this.aQR.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aQR.getCurrentView() != null) {
            this.aQR.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aQR != null) {
            int childCount = this.aQR.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aQR.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void ff(int i) {
        View findViewWithTag = this.aQR.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aQb, true);
        }
    }

    private void initUI() {
        this.aQR = new GalleryViewPager(getContext());
        this.aQR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aQR.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aQR);
        this.aQQ = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aQQ.setOrientation(0);
        this.aQQ.setLayoutParams(layoutParams);
        addView(this.aQQ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aQP = new Button(getContext());
        al.d(this.aQP, e.f.image_zoomout, 0);
        this.aQP.setLayoutParams(layoutParams2);
        this.aQP.setOnClickListener(this.mOnClickListener);
        this.aQP.setEnabled(false);
        this.aQQ.addView(this.aQP);
        this.aQO = new Button(getContext());
        al.d(this.aQO, e.f.image_zoomin, 0);
        this.aQO.setLayoutParams(layoutParams2);
        this.aQO.setOnClickListener(this.mOnClickListener);
        this.aQO.setEnabled(false);
        this.aQQ.addView(this.aQO);
        if (this.aQW) {
            this.aQQ.setVisibility(8);
        }
        this.aQT = new ImagePagerAdapter(getContext(), this.aQR, this.aPS);
        setAdapter(this.aQT);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aQT != null) {
            this.aQT.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aQT != null) {
            this.aQT.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aQS = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aQT.getCount();
    }

    public int getCurrentItem() {
        return this.aQR.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aQO.setEnabled(true);
            } else {
                this.aQO.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aQP.setEnabled(true);
                return;
            } else {
                this.aQP.setEnabled(false);
                return;
            }
        }
        this.aQP.setEnabled(false);
        this.aQO.setEnabled(false);
    }

    public void Jr() {
        if (!this.aQW) {
            this.aQQ.setVisibility(0);
        }
    }

    public void ce(boolean z) {
        if (this.aQR != null) {
            int childCount = this.aQR.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aQR.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).ce(z);
                }
            }
        }
    }

    public void Js() {
        if (!this.aQW) {
            this.aQQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aQR.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aQR.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aQR.setOffscreenPageLimit(i);
        this.aQU = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aQU = (int) (this.aQU * 0.8d);
        if (this.aQU < 6291456) {
            this.aQV = true;
            this.aQU = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aQV = false;
        }
        PagerAdapter adapter = this.aQR.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aQU);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aPR);
        this.aQR.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aQT);
        this.aQR.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aQT.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aQT.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aQT.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aQT.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aQT.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aQT.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aQT.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aQT.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aQT.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aQT.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aQT.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aQR.getCurrentView();
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
        if (this.aQT != null) {
            this.aQT.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aQR.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aQR.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aQb = z;
        if (this.aQT != null) {
            this.aQT.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aQT != null) {
            this.aQT.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aQT != null) {
            this.aQT.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aQT.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aQT != null) {
            this.aQT.setOriImgSelectedCallback(bVar);
        }
    }
}
