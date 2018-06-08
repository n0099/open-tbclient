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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean aGE;
    private DragImageView.f aGu;
    private DragImageView.e aGv;
    private Button aHl;
    private Button aHm;
    private LinearLayout aHn;
    private GalleryViewPager aHo;
    private ViewPager.OnPageChangeListener aHp;
    private ImagePagerAdapter aHq;
    private int aHr;
    private boolean aHs;
    private boolean aHt;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aHl = null;
        this.aHm = null;
        this.aHn = null;
        this.mOnClickListener = null;
        this.aHo = null;
        this.mOnPageChangeListener = null;
        this.aHp = null;
        this.aGu = null;
        this.aHq = null;
        this.aGv = null;
        this.aHr = 0;
        this.aHs = true;
        this.aHt = false;
        this.aGE = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aHo != null) {
            this.aHo.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aHl = null;
        this.aHm = null;
        this.aHn = null;
        this.mOnClickListener = null;
        this.aHo = null;
        this.mOnPageChangeListener = null;
        this.aHp = null;
        this.aGu = null;
        this.aHq = null;
        this.aGv = null;
        this.aHr = 0;
        this.aHs = true;
        this.aHt = false;
        this.aGE = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aHl = null;
        this.aHm = null;
        this.aHn = null;
        this.mOnClickListener = null;
        this.aHo = null;
        this.mOnPageChangeListener = null;
        this.aHp = null;
        this.aGu = null;
        this.aHq = null;
        this.aGv = null;
        this.aHr = 0;
        this.aHs = true;
        this.aHt = false;
        this.aGE = false;
        init();
    }

    public void init() {
        this.aHt = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.aHl) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.LB();
                    }
                } else if (view == MultiImageView.this.aHm && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.LC();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aHp != null) {
                    MultiImageView.this.aHp.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aHp != null) {
                    MultiImageView.this.aHp.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.aHo.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aHo.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).FQ();
                    }
                }
                if (MultiImageView.this.aHp != null) {
                    MultiImageView.this.aHp.onPageSelected(i);
                }
            }
        };
        this.aGu = new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.aHo.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.aGv = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (dragImageView == MultiImageView.this.aHo.getCurrentView()) {
                    if (MultiImageView.this.aHs) {
                        int childCount = MultiImageView.this.aHo.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aHo.getChildAt(i);
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

    public void dk(int i) {
        if (this.mSkinType != i && this.aHo != null) {
            int childCount = this.aHo.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aHo.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aHo.getCurrentView() != null) {
            if (this.aHs) {
                int childCount = this.aHo.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aHo.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != this.aHo.getCurrentView()) {
                        ((UrlDragImageView) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aHo.findViewWithTag(String.valueOf(this.aHo.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).i(this.aGE, true);
            }
            this.aHo.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aHo.getCurrentView() != null) {
            this.aHo.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aHo != null) {
            int childCount = this.aHo.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aHo.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void et(int i) {
        View findViewWithTag = this.aHo.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).i(this.aGE, true);
        }
    }

    private void initUI() {
        this.aHo = new GalleryViewPager(getContext());
        this.aHo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aHo.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aHo);
        this.aHn = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aHn.setOrientation(0);
        this.aHn.setLayoutParams(layoutParams);
        addView(this.aHn);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aHm = new Button(getContext());
        al.d(this.aHm, d.f.image_zoomout, 0);
        this.aHm.setLayoutParams(layoutParams2);
        this.aHm.setOnClickListener(this.mOnClickListener);
        this.aHm.setEnabled(false);
        this.aHn.addView(this.aHm);
        this.aHl = new Button(getContext());
        al.d(this.aHl, d.f.image_zoomin, 0);
        this.aHl.setLayoutParams(layoutParams2);
        this.aHl.setOnClickListener(this.mOnClickListener);
        this.aHl.setEnabled(false);
        this.aHn.addView(this.aHl);
        if (this.aHt) {
            this.aHn.setVisibility(8);
        }
        this.aHq = new ImagePagerAdapter(getContext(), this.aHo, this.aGv);
        setAdapter(this.aHq);
    }

    public void setIsCanDrag(boolean z) {
        if (this.aHq != null) {
            this.aHq.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aHp = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aHq.getCount();
    }

    public int getCurrentItem() {
        return this.aHo.getCurrentItem();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.aHl.setEnabled(true);
            } else {
                this.aHl.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.aHm.setEnabled(true);
                return;
            } else {
                this.aHm.setEnabled(false);
                return;
            }
        }
        this.aHm.setEnabled(false);
        this.aHl.setEnabled(false);
    }

    public void FA() {
        if (!this.aHt) {
            this.aHn.setVisibility(0);
        }
    }

    public void bq(boolean z) {
        if (this.aHo != null) {
            int childCount = this.aHo.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aHo.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).bq(z);
                }
            }
        }
    }

    public void FB() {
        if (!this.aHt) {
            this.aHn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.aHo.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aHo.setPageMargin(i);
    }

    public void setOffscreenPageLimit(int i, int i2) {
        this.aHo.setOffscreenPageLimit(i);
        this.aHr = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aHr = (int) (this.aHr * 0.8d);
        if (this.aHr < 6291456) {
            this.aHs = true;
            this.aHr = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aHs = false;
        }
        PagerAdapter adapter = this.aHo.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.aHr);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.aGu);
        this.aHo.setAdapter(imagePagerAdapter);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aHq);
        this.aHo.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aHq.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.aHq.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aHq.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aHq.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHq.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aHq.setData(arrayList);
    }

    public void setDrageToExitListener(DragImageView.d dVar) {
        this.aHq.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aHq.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aHq.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.aHq.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aHq.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        DragImageView currentView = this.aHo.getCurrentView();
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
        if (this.aHq != null) {
            this.aHq.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView = this.aHo.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        this.aHo.setOnTouchListener(onTouchListener);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aGE = z;
        if (this.aHq != null) {
            this.aHq.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aHq != null) {
            this.aHq.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aHq != null) {
            this.aHq.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        this.aHq.a(aVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.aHq != null) {
            this.aHq.setOriImgSelectedCallback(bVar);
        }
    }
}
