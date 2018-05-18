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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.f axZ;
    private Button ayQ;
    private Button ayR;
    private LinearLayout ayS;
    private GalleryViewPager ayT;
    private ViewPager.OnPageChangeListener ayU;
    private ImagePagerAdapter ayV;
    private int ayW;
    private boolean ayX;
    private boolean ayY;
    private DragImageView.e aya;
    private boolean ayj;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ayQ = null;
        this.ayR = null;
        this.ayS = null;
        this.mOnClickListener = null;
        this.ayT = null;
        this.mOnPageChangeListener = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = null;
        this.aya = null;
        this.ayW = 0;
        this.ayX = true;
        this.ayY = false;
        this.ayj = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ayT != null) {
            this.ayT.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ayQ = null;
        this.ayR = null;
        this.ayS = null;
        this.mOnClickListener = null;
        this.ayT = null;
        this.mOnPageChangeListener = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = null;
        this.aya = null;
        this.ayW = 0;
        this.ayX = true;
        this.ayY = false;
        this.ayj = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ayQ = null;
        this.ayR = null;
        this.ayS = null;
        this.mOnClickListener = null;
        this.ayT = null;
        this.mOnPageChangeListener = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = null;
        this.aya = null;
        this.ayW = 0;
        this.ayX = true;
        this.ayY = false;
        this.ayj = false;
        init();
    }

    public void init() {
        this.ayY = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DragImageView currentImageView;
                if (view2 == MultiImageView.this.ayQ) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.If();
                    }
                } else if (view2 == MultiImageView.this.ayR && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Ig();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.ayU != null) {
                    MultiImageView.this.ayU.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.ayU != null) {
                    MultiImageView.this.ayU.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.ayT.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.ayT.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Cn();
                    }
                }
                if (MultiImageView.this.ayU != null) {
                    MultiImageView.this.ayU.onPageSelected(i);
                }
            }
        };
        this.axZ = new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ayT.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aya = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.ayT.getCurrentView()) {
                    if (MultiImageView.this.ayX) {
                        int childCount = MultiImageView.this.ayT.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ayT.getChildAt(i);
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

    public void di(int i) {
        if (this.mSkinType != i && this.ayT != null) {
            int childCount = this.ayT.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ayT.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ayT.getCurrentView() != null) {
            if (this.ayX) {
                int childCount = this.ayT.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ayT.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.ayT.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.ayT.findViewWithTag(String.valueOf(this.ayT.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).i(this.ayj, true);
            }
            this.ayT.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ayT.getCurrentView() != null) {
            this.ayT.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ayT != null) {
            int childCount = this.ayT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ayT.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void ep(int i) {
        View findViewWithTag = this.ayT.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).i(this.ayj, true);
        }
    }

    private void initUI() {
        this.ayT = new GalleryViewPager(getContext());
        this.ayT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ayT.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ayT);
        this.ayS = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ayS.setOrientation(0);
        this.ayS.setLayoutParams(layoutParams);
        addView(this.ayS);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ayR = new Button(getContext());
        ak.d(this.ayR, d.f.image_zoomout, 0);
        this.ayR.setLayoutParams(layoutParams2);
        this.ayR.setOnClickListener(this.mOnClickListener);
        this.ayR.setEnabled(false);
        this.ayS.addView(this.ayR);
        this.ayQ = new Button(getContext());
        ak.d(this.ayQ, d.f.image_zoomin, 0);
        this.ayQ.setLayoutParams(layoutParams2);
        this.ayQ.setOnClickListener(this.mOnClickListener);
        this.ayQ.setEnabled(false);
        this.ayS.addView(this.ayQ);
        if (this.ayY) {
            this.ayS.setVisibility(8);
        }
        this.ayV = new ImagePagerAdapter(getContext(), this.ayT, this.aya);
        setAdapter(this.ayV);
    }

    public void setIsCanDrag(boolean z) {
        if (this.ayV != null) {
            this.ayV.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ayU = onPageChangeListener;
    }

    public int getItemNum() {
        return this.ayV.getCount();
    }

    public int getCurrentItem() {
        return this.ayT.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.ayQ.setEnabled(true);
            } else {
                this.ayQ.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ayR.setEnabled(true);
                return;
            } else {
                this.ayR.setEnabled(false);
                return;
            }
        }
        this.ayR.setEnabled(false);
        this.ayQ.setEnabled(false);
    }

    public void BX() {
        if (!this.ayY) {
            this.ayS.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        if (this.ayT != null) {
            int childCount = this.ayT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ayT.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bm(z);
                }
            }
        }
    }

    public void BY() {
        if (!this.ayY) {
            this.ayS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.ayT.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.ayT.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.ayT.setOffscreenPageLimit(i);
        this.ayW = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.ayW = (int) (this.ayW * 0.8d);
        if (this.ayW < 6291456) {
            this.ayX = true;
            this.ayW = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.ayX = false;
        }
        PagerAdapter adapter = this.ayT.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.ayW);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.axZ);
        this.ayT.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.ayV);
        this.ayT.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.ayV.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.ayV.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ayV.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ayV.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayV.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.ayV.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.ayV.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ayV.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.ayV.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.ayV.getHasNext();
    }

    public void setNextTitle(String str) {
        this.ayV.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.ayT.getCurrentView();
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
        if (this.ayV != null) {
            this.ayV.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.ayT.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.ayT.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ayj = z;
        if (this.ayV != null) {
            this.ayV.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.ayV != null) {
            this.ayV.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayV != null) {
            this.ayV.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.ayV.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.ayV != null) {
            this.ayV.setOriImgSelectedCallback(bVar);
        }
    }
}
