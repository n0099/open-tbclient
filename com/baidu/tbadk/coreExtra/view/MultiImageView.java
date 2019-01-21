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
    private Button aUZ;
    private DragImageView.g aUc;
    private DragImageView.e aUd;
    private boolean aUm;
    private Button aVa;
    private LinearLayout aVb;
    private GalleryViewPager aVc;
    private ViewPager.OnPageChangeListener aVd;
    private ImagePagerAdapter aVe;
    private int aVf;
    private boolean aVg;
    private boolean aVh;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aUZ = null;
        this.aVa = null;
        this.aVb = null;
        this.mOnClickListener = null;
        this.aVc = null;
        this.mOnPageChangeListener = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = null;
        this.aUd = null;
        this.aVf = 0;
        this.aVg = true;
        this.aVh = false;
        this.aUm = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aVc != null) {
            this.aVc.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aUZ = null;
        this.aVa = null;
        this.aVb = null;
        this.mOnClickListener = null;
        this.aVc = null;
        this.mOnPageChangeListener = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = null;
        this.aUd = null;
        this.aVf = 0;
        this.aVg = true;
        this.aVh = false;
        this.aUm = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aUZ = null;
        this.aVa = null;
        this.aVb = null;
        this.mOnClickListener = null;
        this.aVc = null;
        this.mOnPageChangeListener = null;
        this.aVd = null;
        this.aUc = null;
        this.aVe = null;
        this.aUd = null;
        this.aVf = 0;
        this.aVg = true;
        this.aVh = false;
        this.aUm = false;
        init();
    }

    public void init() {
        this.aVh = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aUZ) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.QV();
                    }
                } else if (view == MultiImageView.this.aVa && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.QW();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aVd != null) {
                    MultiImageView.this.aVd.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aVd != null) {
                    MultiImageView.this.aVd.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aVc.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aVc.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).Lb();
                    }
                }
                if (MultiImageView.this.aVd != null) {
                    MultiImageView.this.aVd.onPageSelected(i);
                }
            }
        };
        this.aUc = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aVc.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aUd = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aVc.getCurrentView()) {
                    if (MultiImageView.this.aVg) {
                        int childCount = MultiImageView.this.aVc.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aVc.getChildAt(i);
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
        if (this.aVe != null) {
            return this.aVe.getCount();
        }
        return 0;
    }

    public void ej(int i) {
        if (this.mSkinType != i && this.aVc != null) {
            int childCount = this.aVc.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aVc.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aVc.getCurrentView() != null) {
            if (this.aVg) {
                int childCount = this.aVc.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aVc.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aVc.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aVc.findViewWithTag(String.valueOf(this.aVc.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aUm, true);
            }
            this.aVc.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aVc.getCurrentView() != null) {
            this.aVc.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aVc != null) {
            int childCount = this.aVc.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aVc.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void fu(int i) {
        View findViewWithTag = this.aVc.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aUm, true);
        }
    }

    private void initUI() {
        this.aVc = new GalleryViewPager(getContext());
        this.aVc.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aVc.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aVc);
        this.aVb = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aVb.setOrientation(0);
        this.aVb.setLayoutParams(layoutParams);
        addView(this.aVb);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aVa = new Button(getContext());
        al.d(this.aVa, e.f.image_zoomout, 0);
        this.aVa.setLayoutParams(layoutParams2);
        this.aVa.setOnClickListener(this.mOnClickListener);
        this.aVa.setEnabled(false);
        this.aVb.addView(this.aVa);
        this.aUZ = new Button(getContext());
        al.d(this.aUZ, e.f.image_zoomin, 0);
        this.aUZ.setLayoutParams(layoutParams2);
        this.aUZ.setOnClickListener(this.mOnClickListener);
        this.aUZ.setEnabled(false);
        this.aVb.addView(this.aUZ);
        if (this.aVh) {
            this.aVb.setVisibility(8);
        }
        this.aVe = new ImagePagerAdapter(getContext(), this.aVc, this.aUd);
        setAdapter(this.aVe);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aVe != null) {
            this.aVe.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aVe != null) {
            this.aVe.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aVd = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aVe.getCount();
    }

    public int getCurrentItem() {
        return this.aVc.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aUZ.setEnabled(true);
            } else {
                this.aUZ.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aVa.setEnabled(true);
                return;
            } else {
                this.aVa.setEnabled(false);
                return;
            }
        }
        this.aVa.setEnabled(false);
        this.aUZ.setEnabled(false);
    }

    public void KL() {
        if (!this.aVh) {
            this.aVb.setVisibility(0);
        }
    }

    public void cg(boolean z) {
        if (this.aVc != null) {
            int childCount = this.aVc.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aVc.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).cg(z);
                }
            }
        }
    }

    public void KM() {
        if (!this.aVh) {
            this.aVb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aVc.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aVc.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aVc.setOffscreenPageLimit(i);
        this.aVf = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aVf = (int) (this.aVf * 0.8d);
        if (this.aVf < 6291456) {
            this.aVg = true;
            this.aVf = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aVg = false;
        }
        PagerAdapter adapter = this.aVc.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aVf);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aUc);
        this.aVc.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aVe);
        this.aVc.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aVe.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aVe.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aVe.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aVe.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVe.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aVe.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aVe.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aVe.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aVe.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aVe.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aVe.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aVc.getCurrentView();
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
        if (this.aVe != null) {
            this.aVe.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aVc.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aVc.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aUm = z;
        if (this.aVe != null) {
            this.aVe.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aVe != null) {
            this.aVe.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aVe != null) {
            this.aVe.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aVe.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aVe != null) {
            this.aVe.setOriImgSelectedCallback(bVar);
        }
    }
}
