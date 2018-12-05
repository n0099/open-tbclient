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
    private boolean aTA;
    private DragImageView.g aTq;
    private DragImageView.e aTr;
    private Button aUn;
    private Button aUo;
    private LinearLayout aUp;
    private GalleryViewPager aUq;
    private ViewPager.OnPageChangeListener aUr;
    private ImagePagerAdapter aUs;
    private int aUt;
    private boolean aUu;
    private boolean aUv;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aUn = null;
        this.aUo = null;
        this.aUp = null;
        this.mOnClickListener = null;
        this.aUq = null;
        this.mOnPageChangeListener = null;
        this.aUr = null;
        this.aTq = null;
        this.aUs = null;
        this.aTr = null;
        this.aUt = 0;
        this.aUu = true;
        this.aUv = false;
        this.aTA = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aUq != null) {
            this.aUq.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aUn = null;
        this.aUo = null;
        this.aUp = null;
        this.mOnClickListener = null;
        this.aUq = null;
        this.mOnPageChangeListener = null;
        this.aUr = null;
        this.aTq = null;
        this.aUs = null;
        this.aTr = null;
        this.aUt = 0;
        this.aUu = true;
        this.aUv = false;
        this.aTA = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aUn = null;
        this.aUo = null;
        this.aUp = null;
        this.mOnClickListener = null;
        this.aUq = null;
        this.mOnPageChangeListener = null;
        this.aUr = null;
        this.aTq = null;
        this.aUs = null;
        this.aTr = null;
        this.aUt = 0;
        this.aUu = true;
        this.aUv = false;
        this.aTA = false;
        init();
    }

    public void init() {
        this.aUv = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aUn) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Qy();
                    }
                } else if (view == MultiImageView.this.aUo && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Qz();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aUr != null) {
                    MultiImageView.this.aUr.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aUr != null) {
                    MultiImageView.this.aUr.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aUq.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aUq.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).KL();
                    }
                }
                if (MultiImageView.this.aUr != null) {
                    MultiImageView.this.aUr.onPageSelected(i);
                }
            }
        };
        this.aTq = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aUq.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aTr = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aUq.getCurrentView()) {
                    if (MultiImageView.this.aUu) {
                        int childCount = MultiImageView.this.aUq.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aUq.getChildAt(i);
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
        if (this.mSkinType != i && this.aUq != null) {
            int childCount = this.aUq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aUq.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aUq.getCurrentView() != null) {
            if (this.aUu) {
                int childCount = this.aUq.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aUq.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aUq.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aUq.findViewWithTag(String.valueOf(this.aUq.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).k(this.aTA, true);
            }
            this.aUq.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aUq.getCurrentView() != null) {
            this.aUq.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aUq != null) {
            int childCount = this.aUq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aUq.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void ft(int i) {
        View findViewWithTag = this.aUq.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).k(this.aTA, true);
        }
    }

    private void initUI() {
        this.aUq = new GalleryViewPager(getContext());
        this.aUq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aUq.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aUq);
        this.aUp = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aUp.setOrientation(0);
        this.aUp.setLayoutParams(layoutParams);
        addView(this.aUp);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aUo = new Button(getContext());
        al.d(this.aUo, e.f.image_zoomout, 0);
        this.aUo.setLayoutParams(layoutParams2);
        this.aUo.setOnClickListener(this.mOnClickListener);
        this.aUo.setEnabled(false);
        this.aUp.addView(this.aUo);
        this.aUn = new Button(getContext());
        al.d(this.aUn, e.f.image_zoomin, 0);
        this.aUn.setLayoutParams(layoutParams2);
        this.aUn.setOnClickListener(this.mOnClickListener);
        this.aUn.setEnabled(false);
        this.aUp.addView(this.aUn);
        if (this.aUv) {
            this.aUp.setVisibility(8);
        }
        this.aUs = new ImagePagerAdapter(getContext(), this.aUq, this.aTr);
        setAdapter(this.aUs);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aUs != null) {
            this.aUs.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.aUs != null) {
            this.aUs.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aUr = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aUs.getCount();
    }

    public int getCurrentItem() {
        return this.aUq.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aUn.setEnabled(true);
            } else {
                this.aUn.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aUo.setEnabled(true);
                return;
            } else {
                this.aUo.setEnabled(false);
                return;
            }
        }
        this.aUo.setEnabled(false);
        this.aUn.setEnabled(false);
    }

    public void Kv() {
        if (!this.aUv) {
            this.aUp.setVisibility(0);
        }
    }

    public void cf(boolean z) {
        if (this.aUq != null) {
            int childCount = this.aUq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aUq.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).cf(z);
                }
            }
        }
    }

    public void Kw() {
        if (!this.aUv) {
            this.aUp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aUq.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aUq.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aUq.setOffscreenPageLimit(i);
        this.aUt = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aUt = (int) (this.aUt * 0.8d);
        if (this.aUt < 6291456) {
            this.aUu = true;
            this.aUt = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aUu = false;
        }
        PagerAdapter adapter = this.aUq.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aUt);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aTq);
        this.aUq.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aUs);
        this.aUq.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aUs.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aUs.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aUs.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aUs.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUs.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aUs.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aUs.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aUs.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aUs.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aUs.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aUs.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aUq.getCurrentView();
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
        if (this.aUs != null) {
            this.aUs.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aUq.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aUq.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aTA = z;
        if (this.aUs != null) {
            this.aUs.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aUs != null) {
            this.aUs.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aUs != null) {
            this.aUs.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aUs.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aUs != null) {
            this.aUs.setOriImgSelectedCallback(bVar);
        }
    }
}
