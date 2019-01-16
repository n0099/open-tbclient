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
    private Button aUY;
    private Button aUZ;
    private DragImageView.g aUb;
    private DragImageView.e aUc;
    private boolean aUl;
    private LinearLayout aVa;
    private GalleryViewPager aVb;
    private ViewPager.OnPageChangeListener aVc;
    private ImagePagerAdapter aVd;
    private int aVe;
    private boolean aVf;
    private boolean aVg;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aUY = null;
        this.aUZ = null;
        this.aVa = null;
        this.mOnClickListener = null;
        this.aVb = null;
        this.mOnPageChangeListener = null;
        this.aVc = null;
        this.aUb = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = 0;
        this.aVf = true;
        this.aVg = false;
        this.aUl = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aVb != null) {
            this.aVb.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aUY = null;
        this.aUZ = null;
        this.aVa = null;
        this.mOnClickListener = null;
        this.aVb = null;
        this.mOnPageChangeListener = null;
        this.aVc = null;
        this.aUb = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = 0;
        this.aVf = true;
        this.aVg = false;
        this.aUl = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aUY = null;
        this.aUZ = null;
        this.aVa = null;
        this.mOnClickListener = null;
        this.aVb = null;
        this.mOnPageChangeListener = null;
        this.aVc = null;
        this.aUb = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = 0;
        this.aVf = true;
        this.aVg = false;
        this.aUl = false;
        init();
    }

    public void init() {
        this.aVg = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aUY) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.QV();
                    }
                } else if (view == MultiImageView.this.aUZ && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.QW();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aVc != null) {
                    MultiImageView.this.aVc.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aVc != null) {
                    MultiImageView.this.aVc.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aVb.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aVb.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Lb();
                    }
                }
                if (MultiImageView.this.aVc != null) {
                    MultiImageView.this.aVc.onPageSelected(i);
                }
            }
        };
        this.aUb = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aVb.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aUc = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aVb.getCurrentView()) {
                    if (MultiImageView.this.aVf) {
                        int childCount = MultiImageView.this.aVb.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aVb.getChildAt(i);
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

    public int getPageCount() {
        if (this.aVd != null) {
            return this.aVd.getCount();
        }
        return 0;
    }

    public void ej(int i) {
        if (this.mSkinType != i && this.aVb != null) {
            int childCount = this.aVb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aVb.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aVb.getCurrentView() != null) {
            if (this.aVf) {
                int childCount = this.aVb.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aVb.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aVb.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aVb.findViewWithTag(String.valueOf(this.aVb.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aUl, true);
            }
            this.aVb.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aVb.getCurrentView() != null) {
            this.aVb.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aVb != null) {
            int childCount = this.aVb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aVb.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void fu(int i) {
        View findViewWithTag = this.aVb.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aUl, true);
        }
    }

    private void initUI() {
        this.aVb = new GalleryViewPager(getContext());
        this.aVb.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aVb.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aVb);
        this.aVa = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aVa.setOrientation(0);
        this.aVa.setLayoutParams(layoutParams);
        addView(this.aVa);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aUZ = new Button(getContext());
        al.d(this.aUZ, e.f.image_zoomout, 0);
        this.aUZ.setLayoutParams(layoutParams2);
        this.aUZ.setOnClickListener(this.mOnClickListener);
        this.aUZ.setEnabled(false);
        this.aVa.addView(this.aUZ);
        this.aUY = new Button(getContext());
        al.d(this.aUY, e.f.image_zoomin, 0);
        this.aUY.setLayoutParams(layoutParams2);
        this.aUY.setOnClickListener(this.mOnClickListener);
        this.aUY.setEnabled(false);
        this.aVa.addView(this.aUY);
        if (this.aVg) {
            this.aVa.setVisibility(8);
        }
        this.aVd = new ImagePagerAdapter(getContext(), this.aVb, this.aUc);
        setAdapter(this.aVd);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aVd != null) {
            this.aVd.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aVd != null) {
            this.aVd.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aVc = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aVd.getCount();
    }

    public int getCurrentItem() {
        return this.aVb.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aUY.setEnabled(true);
            } else {
                this.aUY.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aUZ.setEnabled(true);
                return;
            } else {
                this.aUZ.setEnabled(false);
                return;
            }
        }
        this.aUZ.setEnabled(false);
        this.aUY.setEnabled(false);
    }

    public void KL() {
        if (!this.aVg) {
            this.aVa.setVisibility(0);
        }
    }

    public void cg(boolean z) {
        if (this.aVb != null) {
            int childCount = this.aVb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aVb.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).cg(z);
                }
            }
        }
    }

    public void KM() {
        if (!this.aVg) {
            this.aVa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aVb.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aVb.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aVb.setOffscreenPageLimit(i);
        this.aVe = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aVe = (int) (this.aVe * 0.8d);
        if (this.aVe < 6291456) {
            this.aVf = true;
            this.aVe = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aVf = false;
        }
        PagerAdapter adapter = this.aVb.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aVe);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aUb);
        this.aVb.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aVd);
        this.aVb.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aVd.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aVd.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aVd.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aVd.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVd.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aVd.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aVd.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aVd.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aVd.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aVd.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aVd.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aVb.getCurrentView();
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
        if (this.aVd != null) {
            this.aVd.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aVb.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aVb.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aUl = z;
        if (this.aVd != null) {
            this.aVd.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aVd != null) {
            this.aVd.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aVd != null) {
            this.aVd.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aVd.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aVd != null) {
            this.aVd.setOriImgSelectedCallback(bVar);
        }
    }
}
