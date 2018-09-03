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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g aHl;
    private DragImageView.e aHm;
    private boolean aHv;
    private Button aIg;
    private Button aIh;
    private LinearLayout aIi;
    private GalleryViewPager aIj;
    private ViewPager.OnPageChangeListener aIk;
    private ImagePagerAdapter aIl;
    private int aIm;
    private boolean aIn;
    private boolean aIo;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aIg = null;
        this.aIh = null;
        this.aIi = null;
        this.mOnClickListener = null;
        this.aIj = null;
        this.mOnPageChangeListener = null;
        this.aIk = null;
        this.aHl = null;
        this.aIl = null;
        this.aHm = null;
        this.aIm = 0;
        this.aIn = true;
        this.aIo = false;
        this.aHv = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aIj != null) {
            this.aIj.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aIg = null;
        this.aIh = null;
        this.aIi = null;
        this.mOnClickListener = null;
        this.aIj = null;
        this.mOnPageChangeListener = null;
        this.aIk = null;
        this.aHl = null;
        this.aIl = null;
        this.aHm = null;
        this.aIm = 0;
        this.aIn = true;
        this.aIo = false;
        this.aHv = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aIg = null;
        this.aIh = null;
        this.aIi = null;
        this.mOnClickListener = null;
        this.aIj = null;
        this.mOnPageChangeListener = null;
        this.aIk = null;
        this.aHl = null;
        this.aIl = null;
        this.aHm = null;
        this.aIm = 0;
        this.aIn = true;
        this.aIo = false;
        this.aHv = false;
        init();
    }

    public void init() {
        this.aIo = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aIg) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.LT();
                    }
                } else if (view == MultiImageView.this.aIh && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.LU();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aIk != null) {
                    MultiImageView.this.aIk.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aIk != null) {
                    MultiImageView.this.aIk.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aIj.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aIj.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Ge();
                    }
                }
                if (MultiImageView.this.aIk != null) {
                    MultiImageView.this.aIk.onPageSelected(i);
                }
            }
        };
        this.aHl = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aIj.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aHm = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aIj.getCurrentView()) {
                    if (MultiImageView.this.aIn) {
                        int childCount = MultiImageView.this.aIj.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aIj.getChildAt(i);
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

    public void dm(int i) {
        if (this.mSkinType != i && this.aIj != null) {
            int childCount = this.aIj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aIj.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aIj.getCurrentView() != null) {
            if (this.aIn) {
                int childCount = this.aIj.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aIj.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aIj.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aIj.findViewWithTag(String.valueOf(this.aIj.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).i(this.aHv, true);
            }
            this.aIj.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aIj.getCurrentView() != null) {
            this.aIj.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aIj != null) {
            int childCount = this.aIj.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aIj.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.aIj.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).i(this.aHv, true);
        }
    }

    private void initUI() {
        this.aIj = new GalleryViewPager(getContext());
        this.aIj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aIj.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aIj);
        this.aIi = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aIi.setOrientation(0);
        this.aIi.setLayoutParams(layoutParams);
        addView(this.aIi);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aIh = new Button(getContext());
        am.d(this.aIh, f.C0146f.image_zoomout, 0);
        this.aIh.setLayoutParams(layoutParams2);
        this.aIh.setOnClickListener(this.mOnClickListener);
        this.aIh.setEnabled(false);
        this.aIi.addView(this.aIh);
        this.aIg = new Button(getContext());
        am.d(this.aIg, f.C0146f.image_zoomin, 0);
        this.aIg.setLayoutParams(layoutParams2);
        this.aIg.setOnClickListener(this.mOnClickListener);
        this.aIg.setEnabled(false);
        this.aIi.addView(this.aIg);
        if (this.aIo) {
            this.aIi.setVisibility(8);
        }
        this.aIl = new ImagePagerAdapter(getContext(), this.aIj, this.aHm);
        setAdapter(this.aIl);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aIl != null) {
            this.aIl.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aIk = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aIl.getCount();
    }

    public int getCurrentItem() {
        return this.aIj.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aIg.setEnabled(true);
            } else {
                this.aIg.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aIh.setEnabled(true);
                return;
            } else {
                this.aIh.setEnabled(false);
                return;
            }
        }
        this.aIh.setEnabled(false);
        this.aIg.setEnabled(false);
    }

    public void FO() {
        if (!this.aIo) {
            this.aIi.setVisibility(0);
        }
    }

    public void bs(boolean z) {
        if (this.aIj != null) {
            int childCount = this.aIj.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aIj.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bs(z);
                }
            }
        }
    }

    public void FP() {
        if (!this.aIo) {
            this.aIi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aIj.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aIj.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aIj.setOffscreenPageLimit(i);
        this.aIm = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aIm = (int) (this.aIm * 0.8d);
        if (this.aIm < 6291456) {
            this.aIn = true;
            this.aIm = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aIn = false;
        }
        PagerAdapter adapter = this.aIj.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aIm);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aHl);
        this.aIj.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aIl);
        this.aIj.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aIl.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aIl.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aIl.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aIl.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aIl.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aIl.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aIl.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aIl.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aIl.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aIl.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aIl.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aIj.getCurrentView();
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
        if (this.aIl != null) {
            this.aIl.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aIj.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aIj.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aHv = z;
        if (this.aIl != null) {
            this.aIl.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aIl != null) {
            this.aIl.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aIl != null) {
            this.aIl.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aIl.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aIl != null) {
            this.aIl.setOriImgSelectedCallback(bVar);
        }
    }
}
