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
    private a.f avK;
    private a.e avL;
    private boolean avU;
    private Button awC;
    private Button awD;
    private LinearLayout awE;
    private b awF;
    private ViewPager.OnPageChangeListener awG;
    private c awH;
    private int awI;
    private boolean awJ;
    private boolean awK;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.awC = null;
        this.awD = null;
        this.awE = null;
        this.mOnClickListener = null;
        this.awF = null;
        this.mOnPageChangeListener = null;
        this.awG = null;
        this.avK = null;
        this.awH = null;
        this.avL = null;
        this.awI = 0;
        this.awJ = true;
        this.awK = false;
        this.avU = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.awF != null) {
            this.awF.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.awC = null;
        this.awD = null;
        this.awE = null;
        this.mOnClickListener = null;
        this.awF = null;
        this.mOnPageChangeListener = null;
        this.awG = null;
        this.avK = null;
        this.awH = null;
        this.avL = null;
        this.awI = 0;
        this.awJ = true;
        this.awK = false;
        this.avU = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.awC = null;
        this.awD = null;
        this.awE = null;
        this.mOnClickListener = null;
        this.awF = null;
        this.mOnPageChangeListener = null;
        this.awG = null;
        this.avK = null;
        this.awH = null;
        this.avL = null;
        this.awI = 0;
        this.awJ = true;
        this.awK = false;
        this.avU = false;
        init();
    }

    private void init() {
        this.awK = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.awC) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HM();
                    }
                } else if (view == MultiImageView.this.awD && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HN();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.awG != null) {
                    MultiImageView.this.awG.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.awG != null) {
                    MultiImageView.this.awG.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.awF.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.awF.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BJ();
                    }
                }
                if (MultiImageView.this.awG != null) {
                    MultiImageView.this.awG.onPageSelected(i);
                }
            }
        };
        this.avK = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.awF.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avL = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.awF.getCurrentView()) {
                    if (MultiImageView.this.awJ) {
                        int childCount = MultiImageView.this.awF.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.awF.getChildAt(i);
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
        if (this.mSkinType != i && this.awF != null) {
            int childCount = this.awF.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.awF.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.awF.getCurrentView() != null) {
            if (this.awJ) {
                int childCount = this.awF.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.awF.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.awF.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.awF.findViewWithTag(String.valueOf(this.awF.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.avU, true);
            }
            this.awF.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.awF.getCurrentView() != null) {
            this.awF.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.awF != null) {
            int childCount = this.awF.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awF.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.awF.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.avU, true);
        }
    }

    private void initUI() {
        this.awF = new b(getContext());
        this.awF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.awF.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.awF);
        this.awE = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.awE.setOrientation(0);
        this.awE.setLayoutParams(layoutParams);
        addView(this.awE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.awD = new Button(getContext());
        this.awD.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.awD.setLayoutParams(layoutParams2);
        this.awD.setOnClickListener(this.mOnClickListener);
        this.awD.setEnabled(false);
        this.awE.addView(this.awD);
        this.awC = new Button(getContext());
        this.awC.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.awC.setLayoutParams(layoutParams2);
        this.awC.setOnClickListener(this.mOnClickListener);
        this.awC.setEnabled(false);
        this.awE.addView(this.awC);
        if (this.awK) {
            this.awE.setVisibility(8);
        }
        this.awH = new c(getContext(), this.awF, this.avL);
        setAdapter(this.awH);
    }

    public void setIsCanDrag(boolean z) {
        if (this.awH != null) {
            this.awH.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awG = onPageChangeListener;
    }

    public int getItemNum() {
        return this.awH.getCount();
    }

    public int getCurrentItem() {
        return this.awF.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.awC.setEnabled(true);
            } else {
                this.awC.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.awD.setEnabled(true);
                return;
            } else {
                this.awD.setEnabled(false);
                return;
            }
        }
        this.awD.setEnabled(false);
        this.awC.setEnabled(false);
    }

    public void Bm() {
        if (!this.awK) {
            this.awE.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        if (this.awF != null) {
            int childCount = this.awF.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awF.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bl(z);
                }
            }
        }
    }

    public void Bn() {
        if (!this.awK) {
            this.awE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.awF.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.awF.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.awF.setOffscreenPageLimit(i);
        this.awI = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.awI = (int) (this.awI * 0.8d);
        if (this.awI < 6291456) {
            this.awJ = true;
            this.awI = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.awJ = false;
        }
        PagerAdapter adapter = this.awF.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.awI);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avK);
        this.awF.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.awH);
        this.awF.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.awH.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.awH.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.awH.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.awH.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awH.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.awH.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.awH.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awH.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.awH.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.awH.getHasNext();
    }

    public void setNextTitle(String str) {
        this.awH.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.awF.getCurrentView();
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
        if (this.awH != null) {
            this.awH.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.awF.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avU = z;
        if (this.awH != null) {
            this.awH.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.awH != null) {
            this.awH.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awH != null) {
            this.awH.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.awH.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.awH != null) {
            this.awH.setOriImgSelectedCallback(bVar);
        }
    }
}
