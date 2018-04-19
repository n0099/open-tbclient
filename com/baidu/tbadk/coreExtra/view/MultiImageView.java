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
    private DragImageView.f axY;
    private DragImageView.e axZ;
    private Button ayP;
    private Button ayQ;
    private LinearLayout ayR;
    private GalleryViewPager ayS;
    private ViewPager.OnPageChangeListener ayT;
    private ImagePagerAdapter ayU;
    private int ayV;
    private boolean ayW;
    private boolean ayX;
    private boolean ayi;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ayP = null;
        this.ayQ = null;
        this.ayR = null;
        this.mOnClickListener = null;
        this.ayS = null;
        this.mOnPageChangeListener = null;
        this.ayT = null;
        this.axY = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = 0;
        this.ayW = true;
        this.ayX = false;
        this.ayi = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ayS != null) {
            this.ayS.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ayP = null;
        this.ayQ = null;
        this.ayR = null;
        this.mOnClickListener = null;
        this.ayS = null;
        this.mOnPageChangeListener = null;
        this.ayT = null;
        this.axY = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = 0;
        this.ayW = true;
        this.ayX = false;
        this.ayi = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ayP = null;
        this.ayQ = null;
        this.ayR = null;
        this.mOnClickListener = null;
        this.ayS = null;
        this.mOnPageChangeListener = null;
        this.ayT = null;
        this.axY = null;
        this.ayU = null;
        this.axZ = null;
        this.ayV = 0;
        this.ayW = true;
        this.ayX = false;
        this.ayi = false;
        init();
    }

    public void init() {
        this.ayX = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DragImageView currentImageView;
                if (view2 == MultiImageView.this.ayP) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Ih();
                    }
                } else if (view2 == MultiImageView.this.ayQ && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Ii();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.ayT != null) {
                    MultiImageView.this.ayT.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.ayT != null) {
                    MultiImageView.this.ayT.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.ayS.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.ayS.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Cp();
                    }
                }
                if (MultiImageView.this.ayT != null) {
                    MultiImageView.this.ayT.onPageSelected(i);
                }
            }
        };
        this.axY = new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ayS.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.axZ = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.ayS.getCurrentView()) {
                    if (MultiImageView.this.ayW) {
                        int childCount = MultiImageView.this.ayS.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ayS.getChildAt(i);
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

    public void dh(int i) {
        if (this.mSkinType != i && this.ayS != null) {
            int childCount = this.ayS.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ayS.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ayS.getCurrentView() != null) {
            if (this.ayW) {
                int childCount = this.ayS.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ayS.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.ayS.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.ayS.findViewWithTag(String.valueOf(this.ayS.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).i(this.ayi, true);
            }
            this.ayS.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ayS.getCurrentView() != null) {
            this.ayS.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ayS != null) {
            int childCount = this.ayS.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ayS.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void eo(int i) {
        View findViewWithTag = this.ayS.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).i(this.ayi, true);
        }
    }

    private void initUI() {
        this.ayS = new GalleryViewPager(getContext());
        this.ayS.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ayS.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ayS);
        this.ayR = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ayR.setOrientation(0);
        this.ayR.setLayoutParams(layoutParams);
        addView(this.ayR);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ayQ = new Button(getContext());
        ak.d(this.ayQ, d.f.image_zoomout, 0);
        this.ayQ.setLayoutParams(layoutParams2);
        this.ayQ.setOnClickListener(this.mOnClickListener);
        this.ayQ.setEnabled(false);
        this.ayR.addView(this.ayQ);
        this.ayP = new Button(getContext());
        ak.d(this.ayP, d.f.image_zoomin, 0);
        this.ayP.setLayoutParams(layoutParams2);
        this.ayP.setOnClickListener(this.mOnClickListener);
        this.ayP.setEnabled(false);
        this.ayR.addView(this.ayP);
        if (this.ayX) {
            this.ayR.setVisibility(8);
        }
        this.ayU = new ImagePagerAdapter(getContext(), this.ayS, this.axZ);
        setAdapter(this.ayU);
    }

    public void setIsCanDrag(boolean z) {
        if (this.ayU != null) {
            this.ayU.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ayT = onPageChangeListener;
    }

    public int getItemNum() {
        return this.ayU.getCount();
    }

    public int getCurrentItem() {
        return this.ayS.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.ayP.setEnabled(true);
            } else {
                this.ayP.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ayQ.setEnabled(true);
                return;
            } else {
                this.ayQ.setEnabled(false);
                return;
            }
        }
        this.ayQ.setEnabled(false);
        this.ayP.setEnabled(false);
    }

    public void BZ() {
        if (!this.ayX) {
            this.ayR.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        if (this.ayS != null) {
            int childCount = this.ayS.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ayS.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bm(z);
                }
            }
        }
    }

    public void Ca() {
        if (!this.ayX) {
            this.ayR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.ayS.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.ayS.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.ayS.setOffscreenPageLimit(i);
        this.ayV = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.ayV = (int) (this.ayV * 0.8d);
        if (this.ayV < 6291456) {
            this.ayW = true;
            this.ayV = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.ayW = false;
        }
        PagerAdapter adapter = this.ayS.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.ayV);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.axY);
        this.ayS.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.ayU);
        this.ayS.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.ayU.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.ayU.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ayU.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ayU.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayU.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.ayU.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.ayU.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ayU.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.ayU.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.ayU.getHasNext();
    }

    public void setNextTitle(String str) {
        this.ayU.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.ayS.getCurrentView();
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
        if (this.ayU != null) {
            this.ayU.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.ayS.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.ayS.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ayi = z;
        if (this.ayU != null) {
            this.ayU.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.ayU != null) {
            this.ayU.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayU != null) {
            this.ayU.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.ayU.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.ayU != null) {
            this.ayU.setOriImgSelectedCallback(bVar);
        }
    }
}
