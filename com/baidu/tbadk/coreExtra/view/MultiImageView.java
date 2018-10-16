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
    private Button aPY;
    private Button aPZ;
    private DragImageView.g aPb;
    private DragImageView.e aPc;
    private boolean aPl;
    private LinearLayout aQa;
    private GalleryViewPager aQb;
    private ViewPager.OnPageChangeListener aQc;
    private ImagePagerAdapter aQd;
    private int aQe;
    private boolean aQf;
    private boolean aQg;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aPY = null;
        this.aPZ = null;
        this.aQa = null;
        this.mOnClickListener = null;
        this.aQb = null;
        this.mOnPageChangeListener = null;
        this.aQc = null;
        this.aPb = null;
        this.aQd = null;
        this.aPc = null;
        this.aQe = 0;
        this.aQf = true;
        this.aQg = false;
        this.aPl = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aQb != null) {
            this.aQb.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aPY = null;
        this.aPZ = null;
        this.aQa = null;
        this.mOnClickListener = null;
        this.aQb = null;
        this.mOnPageChangeListener = null;
        this.aQc = null;
        this.aPb = null;
        this.aQd = null;
        this.aPc = null;
        this.aQe = 0;
        this.aQf = true;
        this.aQg = false;
        this.aPl = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aPY = null;
        this.aPZ = null;
        this.aQa = null;
        this.mOnClickListener = null;
        this.aQb = null;
        this.mOnPageChangeListener = null;
        this.aQc = null;
        this.aPb = null;
        this.aQd = null;
        this.aPc = null;
        this.aQe = 0;
        this.aQf = true;
        this.aQg = false;
        this.aPl = false;
        init();
    }

    public void init() {
        this.aQg = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aPY) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Pj();
                    }
                } else if (view == MultiImageView.this.aPZ && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Pk();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aQc != null) {
                    MultiImageView.this.aQc.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aQc != null) {
                    MultiImageView.this.aQc.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aQb.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aQb.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Jv();
                    }
                }
                if (MultiImageView.this.aQc != null) {
                    MultiImageView.this.aQc.onPageSelected(i);
                }
            }
        };
        this.aPb = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aQb.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aPc = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aQb.getCurrentView()) {
                    if (MultiImageView.this.aQf) {
                        int childCount = MultiImageView.this.aQb.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aQb.getChildAt(i);
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

    public void dH(int i) {
        if (this.mSkinType != i && this.aQb != null) {
            int childCount = this.aQb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aQb.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aQb.getCurrentView() != null) {
            if (this.aQf) {
                int childCount = this.aQb.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aQb.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aQb.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aQb.findViewWithTag(String.valueOf(this.aQb.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aPl, true);
            }
            this.aQb.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aQb.getCurrentView() != null) {
            this.aQb.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aQb != null) {
            int childCount = this.aQb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aQb.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void eR(int i) {
        View findViewWithTag = this.aQb.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aPl, true);
        }
    }

    private void initUI() {
        this.aQb = new GalleryViewPager(getContext());
        this.aQb.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aQb.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aQb);
        this.aQa = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aQa.setOrientation(0);
        this.aQa.setLayoutParams(layoutParams);
        addView(this.aQa);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aPZ = new Button(getContext());
        al.d(this.aPZ, e.f.image_zoomout, 0);
        this.aPZ.setLayoutParams(layoutParams2);
        this.aPZ.setOnClickListener(this.mOnClickListener);
        this.aPZ.setEnabled(false);
        this.aQa.addView(this.aPZ);
        this.aPY = new Button(getContext());
        al.d(this.aPY, e.f.image_zoomin, 0);
        this.aPY.setLayoutParams(layoutParams2);
        this.aPY.setOnClickListener(this.mOnClickListener);
        this.aPY.setEnabled(false);
        this.aQa.addView(this.aPY);
        if (this.aQg) {
            this.aQa.setVisibility(8);
        }
        this.aQd = new ImagePagerAdapter(getContext(), this.aQb, this.aPc);
        setAdapter(this.aQd);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aQd != null) {
            this.aQd.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aQd != null) {
            this.aQd.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aQc = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aQd.getCount();
    }

    public int getCurrentItem() {
        return this.aQb.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aPY.setEnabled(true);
            } else {
                this.aPY.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aPZ.setEnabled(true);
                return;
            } else {
                this.aPZ.setEnabled(false);
                return;
            }
        }
        this.aPZ.setEnabled(false);
        this.aPY.setEnabled(false);
    }

    public void Jf() {
        if (!this.aQg) {
            this.aQa.setVisibility(0);
        }
    }

    public void bN(boolean z) {
        if (this.aQb != null) {
            int childCount = this.aQb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aQb.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bN(z);
                }
            }
        }
    }

    public void Jg() {
        if (!this.aQg) {
            this.aQa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aQb.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aQb.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aQb.setOffscreenPageLimit(i);
        this.aQe = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aQe = (int) (this.aQe * 0.8d);
        if (this.aQe < 6291456) {
            this.aQf = true;
            this.aQe = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aQf = false;
        }
        PagerAdapter adapter = this.aQb.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aQe);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aPb);
        this.aQb.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aQd);
        this.aQb.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aQd.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aQd.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aQd.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aQd.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aQd.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aQd.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aQd.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aQd.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aQd.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aQd.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aQd.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aQb.getCurrentView();
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
        if (this.aQd != null) {
            this.aQd.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aQb.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aQb.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aPl = z;
        if (this.aQd != null) {
            this.aQd.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aQd != null) {
            this.aQd.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aQd != null) {
            this.aQd.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aQd.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aQd != null) {
            this.aQd.setOriImgSelectedCallback(bVar);
        }
    }
}
