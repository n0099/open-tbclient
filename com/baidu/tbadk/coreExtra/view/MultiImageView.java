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
import com.baidu.adp.lib.util.j;
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
    private a.f auI;
    private a.e auJ;
    private boolean auS;
    private Button avA;
    private LinearLayout avB;
    private b avC;
    private ViewPager.OnPageChangeListener avD;
    private c avE;
    private int avF;
    private boolean avG;
    private boolean avH;
    private boolean avI;
    private Button avz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.avz = null;
        this.avA = null;
        this.avB = null;
        this.mOnClickListener = null;
        this.avC = null;
        this.mOnPageChangeListener = null;
        this.avD = null;
        this.auI = null;
        this.avE = null;
        this.auJ = null;
        this.avF = 0;
        this.avG = true;
        this.avH = false;
        this.auS = false;
        this.avI = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.avC != null) {
            this.avC.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.avz = null;
        this.avA = null;
        this.avB = null;
        this.mOnClickListener = null;
        this.avC = null;
        this.mOnPageChangeListener = null;
        this.avD = null;
        this.auI = null;
        this.avE = null;
        this.auJ = null;
        this.avF = 0;
        this.avG = true;
        this.avH = false;
        this.auS = false;
        this.avI = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.avz = null;
        this.avA = null;
        this.avB = null;
        this.mOnClickListener = null;
        this.avC = null;
        this.mOnPageChangeListener = null;
        this.avD = null;
        this.auI = null;
        this.avE = null;
        this.auJ = null;
        this.avF = 0;
        this.avG = true;
        this.avH = false;
        this.auS = false;
        this.avI = false;
        init();
    }

    private void init() {
        this.avH = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.avz) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Hn();
                    }
                } else if (view == MultiImageView.this.avA && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Ho();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.avD != null) {
                    MultiImageView.this.avD.onPageScrollStateChanged(i);
                }
                if (MultiImageView.this.avC != null) {
                    View findViewWithTag = MultiImageView.this.avC.findViewWithTag(String.valueOf(MultiImageView.this.avC.getCurrentItem()));
                    if (findViewWithTag instanceof f) {
                        f fVar = (f) findViewWithTag;
                        if (i == 0) {
                            if (fVar.Bi()) {
                                fVar.axi.setVisibility(0);
                                return;
                            } else {
                                fVar.axi.setVisibility(8);
                                return;
                            }
                        }
                        fVar.axi.setVisibility(8);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.avD != null) {
                    MultiImageView.this.avD.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.avC.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bm(MultiImageView.this.avI);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.avC.setSelectedView(imageView);
                        imageView.Hp();
                    }
                }
                int childCount = MultiImageView.this.avC.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.avC.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).Be();
                    }
                }
                if (MultiImageView.this.avG && j.hh()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.avC.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bq(MultiImageView.this.auS);
                        }
                    }
                }
                if (MultiImageView.this.avD != null) {
                    MultiImageView.this.avD.onPageSelected(i);
                }
            }
        };
        this.auI = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.avC.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.auJ = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.avC.getCurrentView()) {
                    if (MultiImageView.this.avG) {
                        int childCount = MultiImageView.this.avC.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.avC.getChildAt(i);
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
        if (this.mSkinType != i && this.avC != null) {
            int childCount = this.avC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.avC.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.avC.getCurrentView() != null) {
            if (this.avG) {
                int childCount = this.avC.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.avC.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.avC.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.avC.findViewWithTag(String.valueOf(this.avC.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.auS, true);
            }
            this.avC.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.avC.getCurrentView() != null) {
            this.avC.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.avC != null) {
            int childCount = this.avC.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avC.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.avC.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.auS, true);
        }
    }

    private void initUI() {
        this.avC = new b(getContext());
        this.avC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.avC.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.avC);
        this.avB = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.avB.setOrientation(0);
        this.avB.setLayoutParams(layoutParams);
        addView(this.avB);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.avA = new Button(getContext());
        this.avA.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.avA.setLayoutParams(layoutParams2);
        this.avA.setOnClickListener(this.mOnClickListener);
        this.avA.setEnabled(false);
        this.avB.addView(this.avA);
        this.avz = new Button(getContext());
        this.avz.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.avz.setLayoutParams(layoutParams2);
        this.avz.setOnClickListener(this.mOnClickListener);
        this.avz.setEnabled(false);
        this.avB.addView(this.avz);
        if (this.avH) {
            this.avB.setVisibility(8);
        }
        this.avE = new c(getContext(), null, this.auJ);
        setAdapter(this.avE);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.avD = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avE.getCount();
    }

    public int getCurrentItem() {
        return this.avC.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.avz.setEnabled(true);
            } else {
                this.avz.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.avA.setEnabled(true);
                return;
            } else {
                this.avA.setEnabled(false);
                return;
            }
        }
        this.avA.setEnabled(false);
        this.avz.setEnabled(false);
    }

    public void AM() {
        if (!this.avH) {
            this.avB.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.avI = z;
        if (this.avC != null) {
            View findViewWithTag = this.avC.findViewWithTag(String.valueOf(this.avC.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bm(z);
            }
        }
    }

    public void AN() {
        if (!this.avH) {
            this.avB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.avC.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.avC.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.avC.setOffscreenPageLimit(i);
        this.avF = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avF = (int) (this.avF * 0.8d);
        if (this.avF < 6291456) {
            this.avG = true;
            this.avF = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.avG = false;
        }
        PagerAdapter adapter = this.avC.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.avF);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.auI);
        this.avC.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avE);
        this.avC.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avE.setTempSize(i);
        this.avE.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avE.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avE.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.avE.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avE.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avE.setData(arrayList);
        this.avE.notifyDataSetChanged();
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avE.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avE.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avE.setHasNext(z);
        this.avE.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.avE.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avE.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.avC.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.avE != null) {
            this.avE.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.avC.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.auS = z;
        if (this.avE != null) {
            this.avE.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avE != null) {
            this.avE.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avE != null) {
            this.avE.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.avE.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.avE != null) {
            this.avE.setOriImgSelectedCallback(bVar);
        }
    }
}
