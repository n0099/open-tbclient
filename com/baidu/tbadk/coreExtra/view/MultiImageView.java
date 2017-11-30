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
    private a.f avC;
    private a.e avD;
    private boolean avM;
    private int awA;
    private boolean awB;
    private boolean awC;
    private Button awu;
    private Button awv;
    private LinearLayout aww;
    private b awx;
    private ViewPager.OnPageChangeListener awy;
    private c awz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.awu = null;
        this.awv = null;
        this.aww = null;
        this.mOnClickListener = null;
        this.awx = null;
        this.mOnPageChangeListener = null;
        this.awy = null;
        this.avC = null;
        this.awz = null;
        this.avD = null;
        this.awA = 0;
        this.awB = true;
        this.awC = false;
        this.avM = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.awx != null) {
            this.awx.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.awu = null;
        this.awv = null;
        this.aww = null;
        this.mOnClickListener = null;
        this.awx = null;
        this.mOnPageChangeListener = null;
        this.awy = null;
        this.avC = null;
        this.awz = null;
        this.avD = null;
        this.awA = 0;
        this.awB = true;
        this.awC = false;
        this.avM = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.awu = null;
        this.awv = null;
        this.aww = null;
        this.mOnClickListener = null;
        this.awx = null;
        this.mOnPageChangeListener = null;
        this.awy = null;
        this.avC = null;
        this.awz = null;
        this.avD = null;
        this.awA = 0;
        this.awB = true;
        this.awC = false;
        this.avM = false;
        init();
    }

    private void init() {
        this.awC = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.awu) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HL();
                    }
                } else if (view == MultiImageView.this.awv && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HM();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.awy != null) {
                    MultiImageView.this.awy.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.awy != null) {
                    MultiImageView.this.awy.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.awx.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.awx.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BI();
                    }
                }
                if (MultiImageView.this.awy != null) {
                    MultiImageView.this.awy.onPageSelected(i);
                }
            }
        };
        this.avC = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.awx.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avD = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.awx.getCurrentView()) {
                    if (MultiImageView.this.awB) {
                        int childCount = MultiImageView.this.awx.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.awx.getChildAt(i);
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
        if (this.mSkinType != i && this.awx != null) {
            int childCount = this.awx.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.awx.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.awx.getCurrentView() != null) {
            if (this.awB) {
                int childCount = this.awx.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.awx.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.awx.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.awx.findViewWithTag(String.valueOf(this.awx.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.avM, true);
            }
            this.awx.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.awx.getCurrentView() != null) {
            this.awx.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.awx != null) {
            int childCount = this.awx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awx.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ew(int i) {
        View findViewWithTag = this.awx.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.avM, true);
        }
    }

    private void initUI() {
        this.awx = new b(getContext());
        this.awx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.awx.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.awx);
        this.aww = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aww.setOrientation(0);
        this.aww.setLayoutParams(layoutParams);
        addView(this.aww);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.awv = new Button(getContext());
        this.awv.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.awv.setLayoutParams(layoutParams2);
        this.awv.setOnClickListener(this.mOnClickListener);
        this.awv.setEnabled(false);
        this.aww.addView(this.awv);
        this.awu = new Button(getContext());
        this.awu.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.awu.setLayoutParams(layoutParams2);
        this.awu.setOnClickListener(this.mOnClickListener);
        this.awu.setEnabled(false);
        this.aww.addView(this.awu);
        if (this.awC) {
            this.aww.setVisibility(8);
        }
        this.awz = new c(getContext(), this.awx, this.avD);
        setAdapter(this.awz);
    }

    public void setIsCanDrag(boolean z) {
        if (this.awz != null) {
            this.awz.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awy = onPageChangeListener;
    }

    public int getItemNum() {
        return this.awz.getCount();
    }

    public int getCurrentItem() {
        return this.awx.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.awu.setEnabled(true);
            } else {
                this.awu.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.awv.setEnabled(true);
                return;
            } else {
                this.awv.setEnabled(false);
                return;
            }
        }
        this.awv.setEnabled(false);
        this.awu.setEnabled(false);
    }

    public void Bl() {
        if (!this.awC) {
            this.aww.setVisibility(0);
        }
    }

    public void bk(boolean z) {
        if (this.awx != null) {
            int childCount = this.awx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awx.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bk(z);
                }
            }
        }
    }

    public void Bm() {
        if (!this.awC) {
            this.aww.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.awx.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.awx.setPageMargin(i);
    }

    public void F(int i, int i2) {
        this.awx.setOffscreenPageLimit(i);
        this.awA = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.awA = (int) (this.awA * 0.8d);
        if (this.awA < 6291456) {
            this.awB = true;
            this.awA = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.awB = false;
        }
        PagerAdapter adapter = this.awx.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.awA);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avC);
        this.awx.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.awz);
        this.awx.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.awz.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.awz.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.awz.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.awz.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awz.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.awz.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.awz.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awz.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.awz.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.awz.getHasNext();
    }

    public void setNextTitle(String str) {
        this.awz.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.awx.getCurrentView();
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
        if (this.awz != null) {
            this.awz.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.awx.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avM = z;
        if (this.awz != null) {
            this.awz.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.awz != null) {
            this.awz.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awz != null) {
            this.awz.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.awz.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.awz != null) {
            this.awz.setOriImgSelectedCallback(bVar);
        }
    }
}
