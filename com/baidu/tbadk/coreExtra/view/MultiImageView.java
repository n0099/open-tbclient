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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean bmG;
    private a.f bmw;
    private a.e bmx;
    private Button bnn;
    private Button bno;
    private LinearLayout bnp;
    private b bnq;
    private ViewPager.OnPageChangeListener bnr;
    private c bns;
    private int bnt;
    private boolean bnu;
    private boolean bnv;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bnn = null;
        this.bno = null;
        this.bnp = null;
        this.mOnClickListener = null;
        this.bnq = null;
        this.mOnPageChangeListener = null;
        this.bnr = null;
        this.bmw = null;
        this.bns = null;
        this.bmx = null;
        this.bnt = 0;
        this.bnu = true;
        this.bnv = false;
        this.bmG = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.bnq != null) {
            this.bnq.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bnn = null;
        this.bno = null;
        this.bnp = null;
        this.mOnClickListener = null;
        this.bnq = null;
        this.mOnPageChangeListener = null;
        this.bnr = null;
        this.bmw = null;
        this.bns = null;
        this.bmx = null;
        this.bnt = 0;
        this.bnu = true;
        this.bnv = false;
        this.bmG = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bnn = null;
        this.bno = null;
        this.bnp = null;
        this.mOnClickListener = null;
        this.bnq = null;
        this.mOnPageChangeListener = null;
        this.bnr = null;
        this.bmw = null;
        this.bns = null;
        this.bmx = null;
        this.bnt = 0;
        this.bnu = true;
        this.bnv = false;
        this.bmG = false;
        init();
    }

    public void init() {
        this.bnv = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bnn) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.PG();
                    }
                } else if (view == MultiImageView.this.bno && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.PH();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.bnr != null) {
                    MultiImageView.this.bnr.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.bnr != null) {
                    MultiImageView.this.bnr.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.bnq.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.bnq.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).JJ();
                    }
                }
                if (MultiImageView.this.bnr != null) {
                    MultiImageView.this.bnr.onPageSelected(i);
                }
            }
        };
        this.bmw = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.bnq.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bmx = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.bnq.getCurrentView()) {
                    if (MultiImageView.this.bnu) {
                        int childCount = MultiImageView.this.bnq.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.bnq.getChildAt(i);
                            if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != aVar) {
                                ((f) childAt).release();
                            }
                        }
                    }
                    aVar.play();
                }
            }
        };
    }

    public void gi(int i) {
        if (this.mSkinType != i && this.bnq != null) {
            int childCount = this.bnq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.bnq.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.bnq.getCurrentView() != null) {
            if (this.bnu) {
                int childCount = this.bnq.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.bnq.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.bnq.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.bnq.findViewWithTag(String.valueOf(this.bnq.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bmG, true);
            }
            this.bnq.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.bnq.getCurrentView() != null) {
            this.bnq.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.bnq != null) {
            int childCount = this.bnq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bnq.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hp(int i) {
        View findViewWithTag = this.bnq.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bmG, true);
        }
    }

    private void initUI() {
        this.bnq = new b(getContext());
        this.bnq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bnq.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.bnq);
        this.bnp = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bnp.setOrientation(0);
        this.bnp.setLayoutParams(layoutParams);
        addView(this.bnp);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bno = new Button(getContext());
        this.bno.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bno.setLayoutParams(layoutParams2);
        this.bno.setOnClickListener(this.mOnClickListener);
        this.bno.setEnabled(false);
        this.bnp.addView(this.bno);
        this.bnn = new Button(getContext());
        this.bnn.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bnn.setLayoutParams(layoutParams2);
        this.bnn.setOnClickListener(this.mOnClickListener);
        this.bnn.setEnabled(false);
        this.bnp.addView(this.bnn);
        if (this.bnv) {
            this.bnp.setVisibility(8);
        }
        this.bns = new c(getContext(), this.bnq, this.bmx);
        setAdapter(this.bns);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bns != null) {
            this.bns.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bnr = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bns.getCount();
    }

    public int getCurrentItem() {
        return this.bnq.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bnn.setEnabled(true);
            } else {
                this.bnn.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bno.setEnabled(true);
                return;
            } else {
                this.bno.setEnabled(false);
                return;
            }
        }
        this.bno.setEnabled(false);
        this.bnn.setEnabled(false);
    }

    public void Jl() {
        if (!this.bnv) {
            this.bnp.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        if (this.bnq != null) {
            int childCount = this.bnq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bnq.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bU(z);
                }
            }
        }
    }

    public void Jm() {
        if (!this.bnv) {
            this.bnp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.bnq.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.bnq.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.bnq.setOffscreenPageLimit(i);
        this.bnt = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.bnt = (int) (this.bnt * 0.8d);
        if (this.bnt < 6291456) {
            this.bnu = true;
            this.bnt = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.bnu = false;
        }
        PagerAdapter adapter = this.bnq.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.bnt);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bmw);
        this.bnq.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bns);
        this.bnq.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bns.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bns.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bns.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bns.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bns.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bns.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bns.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bns.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bns.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bns.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bns.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.bnq.getCurrentView();
        if (currentView == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.bns != null) {
            this.bns.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.bnq.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmG = z;
        if (this.bns != null) {
            this.bns.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bns != null) {
            this.bns.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bns != null) {
            this.bns.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bns.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bns != null) {
            this.bns.setOriImgSelectedCallback(bVar);
        }
    }
}
