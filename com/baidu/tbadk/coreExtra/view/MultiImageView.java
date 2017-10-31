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
    private a.f auT;
    private a.e auU;
    private Button avL;
    private Button avM;
    private LinearLayout avN;
    private b avO;
    private ViewPager.OnPageChangeListener avP;
    private c avQ;
    private int avR;
    private boolean avS;
    private boolean avT;
    private boolean avd;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.avL = null;
        this.avM = null;
        this.avN = null;
        this.mOnClickListener = null;
        this.avO = null;
        this.mOnPageChangeListener = null;
        this.avP = null;
        this.auT = null;
        this.avQ = null;
        this.auU = null;
        this.avR = 0;
        this.avS = true;
        this.avT = false;
        this.avd = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.avO != null) {
            this.avO.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.avL = null;
        this.avM = null;
        this.avN = null;
        this.mOnClickListener = null;
        this.avO = null;
        this.mOnPageChangeListener = null;
        this.avP = null;
        this.auT = null;
        this.avQ = null;
        this.auU = null;
        this.avR = 0;
        this.avS = true;
        this.avT = false;
        this.avd = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.avL = null;
        this.avM = null;
        this.avN = null;
        this.mOnClickListener = null;
        this.avO = null;
        this.mOnPageChangeListener = null;
        this.avP = null;
        this.auT = null;
        this.avQ = null;
        this.auU = null;
        this.avR = 0;
        this.avS = true;
        this.avT = false;
        this.avd = false;
        init();
    }

    private void init() {
        this.avT = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.avL) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Ht();
                    }
                } else if (view == MultiImageView.this.avM && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Hu();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.avP != null) {
                    MultiImageView.this.avP.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.avP != null) {
                    MultiImageView.this.avP.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.avO.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.avO.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).Bm();
                    }
                }
                if (MultiImageView.this.avP != null) {
                    MultiImageView.this.avP.onPageSelected(i);
                }
            }
        };
        this.auT = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.avO.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.auU = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.avO.getCurrentView()) {
                    if (MultiImageView.this.avS) {
                        int childCount = MultiImageView.this.avO.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.avO.getChildAt(i);
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

    public void dj(int i) {
        if (this.mSkinType != i && this.avO != null) {
            int childCount = this.avO.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.avO.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.avO.getCurrentView() != null) {
            if (this.avS) {
                int childCount = this.avO.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.avO.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.avO.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.avO.findViewWithTag(String.valueOf(this.avO.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.avd, true);
            }
            this.avO.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.avO.getCurrentView() != null) {
            this.avO.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.avO != null) {
            int childCount = this.avO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avO.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.avO.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.avd, true);
        }
    }

    private void initUI() {
        this.avO = new b(getContext());
        this.avO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.avO.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.avO);
        this.avN = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.avN.setOrientation(0);
        this.avN.setLayoutParams(layoutParams);
        addView(this.avN);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.avM = new Button(getContext());
        this.avM.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.avM.setLayoutParams(layoutParams2);
        this.avM.setOnClickListener(this.mOnClickListener);
        this.avM.setEnabled(false);
        this.avN.addView(this.avM);
        this.avL = new Button(getContext());
        this.avL.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.avL.setLayoutParams(layoutParams2);
        this.avL.setOnClickListener(this.mOnClickListener);
        this.avL.setEnabled(false);
        this.avN.addView(this.avL);
        if (this.avT) {
            this.avN.setVisibility(8);
        }
        this.avQ = new c(getContext(), this.avO, this.auU);
        setAdapter(this.avQ);
    }

    public void setIsCanDrag(boolean z) {
        if (this.avQ != null) {
            this.avQ.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.avP = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avQ.getCount();
    }

    public int getCurrentItem() {
        return this.avO.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.avL.setEnabled(true);
            } else {
                this.avL.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.avM.setEnabled(true);
                return;
            } else {
                this.avM.setEnabled(false);
                return;
            }
        }
        this.avM.setEnabled(false);
        this.avL.setEnabled(false);
    }

    public void AP() {
        if (!this.avT) {
            this.avN.setVisibility(0);
        }
    }

    public void bj(boolean z) {
        if (this.avO != null) {
            int childCount = this.avO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avO.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bj(z);
                }
            }
        }
    }

    public void AQ() {
        if (!this.avT) {
            this.avN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.avO.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.avO.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.avO.setOffscreenPageLimit(i);
        this.avR = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avR = (int) (this.avR * 0.8d);
        if (this.avR < 6291456) {
            this.avS = true;
            this.avR = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.avS = false;
        }
        PagerAdapter adapter = this.avO.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.avR);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.auT);
        this.avO.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avQ);
        this.avO.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avQ.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.avQ.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avQ.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.avQ.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avQ.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avQ.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avQ.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avQ.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avQ.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.avQ.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avQ.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.avO.getCurrentView();
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
        if (this.avQ != null) {
            this.avQ.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.avO.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avd = z;
        if (this.avQ != null) {
            this.avQ.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avQ != null) {
            this.avQ.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avQ != null) {
            this.avQ.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.avQ.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.avQ != null) {
            this.avQ.setOriImgSelectedCallback(bVar);
        }
    }
}
