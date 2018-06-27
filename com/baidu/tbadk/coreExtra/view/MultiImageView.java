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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.f aHm;
    private DragImageView.e aHn;
    private boolean aHw;
    private Button aIi;
    private Button aIj;
    private LinearLayout aIk;
    private GalleryViewPager aIl;
    private ViewPager.OnPageChangeListener aIm;
    private ImagePagerAdapter aIn;
    private int aIo;
    private boolean aIp;
    private boolean aIq;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aIi = null;
        this.aIj = null;
        this.aIk = null;
        this.mOnClickListener = null;
        this.aIl = null;
        this.mOnPageChangeListener = null;
        this.aIm = null;
        this.aHm = null;
        this.aIn = null;
        this.aHn = null;
        this.aIo = 0;
        this.aIp = true;
        this.aIq = false;
        this.aHw = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aIl != null) {
            this.aIl.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aIi = null;
        this.aIj = null;
        this.aIk = null;
        this.mOnClickListener = null;
        this.aIl = null;
        this.mOnPageChangeListener = null;
        this.aIm = null;
        this.aHm = null;
        this.aIn = null;
        this.aHn = null;
        this.aIo = 0;
        this.aIp = true;
        this.aIq = false;
        this.aHw = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aIi = null;
        this.aIj = null;
        this.aIk = null;
        this.mOnClickListener = null;
        this.aIl = null;
        this.mOnPageChangeListener = null;
        this.aIm = null;
        this.aHm = null;
        this.aIn = null;
        this.aHn = null;
        this.aIo = 0;
        this.aIp = true;
        this.aIq = false;
        this.aHw = false;
        init();
    }

    public void init() {
        this.aIq = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aIi) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.LT();
                    }
                } else if (view == MultiImageView.this.aIj && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.LU();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aIm != null) {
                    MultiImageView.this.aIm.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aIm != null) {
                    MultiImageView.this.aIm.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aIl.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aIl.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Gi();
                    }
                }
                if (MultiImageView.this.aIm != null) {
                    MultiImageView.this.aIm.onPageSelected(i);
                }
            }
        };
        this.aHm = new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aIl.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aHn = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aIl.getCurrentView()) {
                    if (MultiImageView.this.aIp) {
                        int childCount = MultiImageView.this.aIl.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aIl.getChildAt(i);
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

    public void dl(int i) {
        if (this.mSkinType != i && this.aIl != null) {
            int childCount = this.aIl.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aIl.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aIl.getCurrentView() != null) {
            if (this.aIp) {
                int childCount = this.aIl.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aIl.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aIl.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aIl.findViewWithTag(String.valueOf(this.aIl.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).i(this.aHw, true);
            }
            this.aIl.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aIl.getCurrentView() != null) {
            this.aIl.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aIl != null) {
            int childCount = this.aIl.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aIl.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void eu(int i) {
        View findViewWithTag = this.aIl.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).i(this.aHw, true);
        }
    }

    private void initUI() {
        this.aIl = new GalleryViewPager(getContext());
        this.aIl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aIl.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aIl);
        this.aIk = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aIk.setOrientation(0);
        this.aIk.setLayoutParams(layoutParams);
        addView(this.aIk);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aIj = new Button(getContext());
        am.d(this.aIj, d.f.image_zoomout, 0);
        this.aIj.setLayoutParams(layoutParams2);
        this.aIj.setOnClickListener(this.mOnClickListener);
        this.aIj.setEnabled(false);
        this.aIk.addView(this.aIj);
        this.aIi = new Button(getContext());
        am.d(this.aIi, d.f.image_zoomin, 0);
        this.aIi.setLayoutParams(layoutParams2);
        this.aIi.setOnClickListener(this.mOnClickListener);
        this.aIi.setEnabled(false);
        this.aIk.addView(this.aIi);
        if (this.aIq) {
            this.aIk.setVisibility(8);
        }
        this.aIn = new ImagePagerAdapter(getContext(), this.aIl, this.aHn);
        setAdapter(this.aIn);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aIn != null) {
            this.aIn.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aIm = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aIn.getCount();
    }

    public int getCurrentItem() {
        return this.aIl.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aIi.setEnabled(true);
            } else {
                this.aIi.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aIj.setEnabled(true);
                return;
            } else {
                this.aIj.setEnabled(false);
                return;
            }
        }
        this.aIj.setEnabled(false);
        this.aIi.setEnabled(false);
    }

    public void FS() {
        if (!this.aIq) {
            this.aIk.setVisibility(0);
        }
    }

    public void bt(boolean z) {
        if (this.aIl != null) {
            int childCount = this.aIl.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aIl.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bt(z);
                }
            }
        }
    }

    public void FT() {
        if (!this.aIq) {
            this.aIk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aIl.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aIl.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aIl.setOffscreenPageLimit(i);
        this.aIo = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aIo = (int) (this.aIo * 0.8d);
        if (this.aIo < 6291456) {
            this.aIp = true;
            this.aIo = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aIp = false;
        }
        PagerAdapter adapter = this.aIl.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aIo);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aHm);
        this.aIl.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aIn);
        this.aIl.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aIn.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aIn.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aIn.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aIn.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aIn.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aIn.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aIn.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aIn.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aIn.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aIn.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aIn.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aIl.getCurrentView();
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
        if (this.aIn != null) {
            this.aIn.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aIl.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aIl.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aHw = z;
        if (this.aIn != null) {
            this.aIn.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aIn != null) {
            this.aIn.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aIn != null) {
            this.aIn.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aIn.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aIn != null) {
            this.aIn.setOriImgSelectedCallback(bVar);
        }
    }
}
