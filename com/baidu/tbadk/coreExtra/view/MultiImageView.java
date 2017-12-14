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
    private a.f avH;
    private a.e avI;
    private boolean avR;
    private Button awA;
    private LinearLayout awB;
    private b awC;
    private ViewPager.OnPageChangeListener awD;
    private c awE;
    private int awF;
    private boolean awG;
    private boolean awH;
    private Button awz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.awz = null;
        this.awA = null;
        this.awB = null;
        this.mOnClickListener = null;
        this.awC = null;
        this.mOnPageChangeListener = null;
        this.awD = null;
        this.avH = null;
        this.awE = null;
        this.avI = null;
        this.awF = 0;
        this.awG = true;
        this.awH = false;
        this.avR = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.awC != null) {
            this.awC.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.awz = null;
        this.awA = null;
        this.awB = null;
        this.mOnClickListener = null;
        this.awC = null;
        this.mOnPageChangeListener = null;
        this.awD = null;
        this.avH = null;
        this.awE = null;
        this.avI = null;
        this.awF = 0;
        this.awG = true;
        this.awH = false;
        this.avR = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.awz = null;
        this.awA = null;
        this.awB = null;
        this.mOnClickListener = null;
        this.awC = null;
        this.mOnPageChangeListener = null;
        this.awD = null;
        this.avH = null;
        this.awE = null;
        this.avI = null;
        this.awF = 0;
        this.awG = true;
        this.awH = false;
        this.avR = false;
        init();
    }

    private void init() {
        this.awH = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.awz) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HM();
                    }
                } else if (view == MultiImageView.this.awA && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HN();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.awD != null) {
                    MultiImageView.this.awD.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.awD != null) {
                    MultiImageView.this.awD.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.awC.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.awC.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BJ();
                    }
                }
                if (MultiImageView.this.awD != null) {
                    MultiImageView.this.awD.onPageSelected(i);
                }
            }
        };
        this.avH = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.awC.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avI = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.awC.getCurrentView()) {
                    if (MultiImageView.this.awG) {
                        int childCount = MultiImageView.this.awC.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.awC.getChildAt(i);
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
        if (this.mSkinType != i && this.awC != null) {
            int childCount = this.awC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.awC.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.awC.getCurrentView() != null) {
            if (this.awG) {
                int childCount = this.awC.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.awC.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.awC.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.awC.findViewWithTag(String.valueOf(this.awC.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.avR, true);
            }
            this.awC.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.awC.getCurrentView() != null) {
            this.awC.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.awC != null) {
            int childCount = this.awC.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awC.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.awC.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.avR, true);
        }
    }

    private void initUI() {
        this.awC = new b(getContext());
        this.awC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.awC.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.awC);
        this.awB = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.awB.setOrientation(0);
        this.awB.setLayoutParams(layoutParams);
        addView(this.awB);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.awA = new Button(getContext());
        this.awA.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.awA.setLayoutParams(layoutParams2);
        this.awA.setOnClickListener(this.mOnClickListener);
        this.awA.setEnabled(false);
        this.awB.addView(this.awA);
        this.awz = new Button(getContext());
        this.awz.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.awz.setLayoutParams(layoutParams2);
        this.awz.setOnClickListener(this.mOnClickListener);
        this.awz.setEnabled(false);
        this.awB.addView(this.awz);
        if (this.awH) {
            this.awB.setVisibility(8);
        }
        this.awE = new c(getContext(), this.awC, this.avI);
        setAdapter(this.awE);
    }

    public void setIsCanDrag(boolean z) {
        if (this.awE != null) {
            this.awE.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awD = onPageChangeListener;
    }

    public int getItemNum() {
        return this.awE.getCount();
    }

    public int getCurrentItem() {
        return this.awC.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.awz.setEnabled(true);
            } else {
                this.awz.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.awA.setEnabled(true);
                return;
            } else {
                this.awA.setEnabled(false);
                return;
            }
        }
        this.awA.setEnabled(false);
        this.awz.setEnabled(false);
    }

    public void Bm() {
        if (!this.awH) {
            this.awB.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        if (this.awC != null) {
            int childCount = this.awC.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awC.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bl(z);
                }
            }
        }
    }

    public void Bn() {
        if (!this.awH) {
            this.awB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.awC.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.awC.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.awC.setOffscreenPageLimit(i);
        this.awF = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.awF = (int) (this.awF * 0.8d);
        if (this.awF < 6291456) {
            this.awG = true;
            this.awF = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.awG = false;
        }
        PagerAdapter adapter = this.awC.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.awF);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avH);
        this.awC.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.awE);
        this.awC.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.awE.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.awE.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.awE.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.awE.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awE.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.awE.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.awE.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awE.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.awE.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.awE.getHasNext();
    }

    public void setNextTitle(String str) {
        this.awE.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.awC.getCurrentView();
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
        if (this.awE != null) {
            this.awE.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.awC.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avR = z;
        if (this.awE != null) {
            this.awE.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.awE != null) {
            this.awE.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awE != null) {
            this.awE.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.awE.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.awE != null) {
            this.awE.setOriImgSelectedCallback(bVar);
        }
    }
}
