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
    private Button avT;
    private Button avU;
    private LinearLayout avV;
    private b avW;
    private ViewPager.OnPageChangeListener avX;
    private c avY;
    private int avZ;
    private a.f avb;
    private a.e avc;
    private boolean avl;
    private boolean awa;
    private boolean awb;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.avT = null;
        this.avU = null;
        this.avV = null;
        this.mOnClickListener = null;
        this.avW = null;
        this.mOnPageChangeListener = null;
        this.avX = null;
        this.avb = null;
        this.avY = null;
        this.avc = null;
        this.avZ = 0;
        this.awa = true;
        this.awb = false;
        this.avl = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.avW != null) {
            this.avW.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.avT = null;
        this.avU = null;
        this.avV = null;
        this.mOnClickListener = null;
        this.avW = null;
        this.mOnPageChangeListener = null;
        this.avX = null;
        this.avb = null;
        this.avY = null;
        this.avc = null;
        this.avZ = 0;
        this.awa = true;
        this.awb = false;
        this.avl = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.avT = null;
        this.avU = null;
        this.avV = null;
        this.mOnClickListener = null;
        this.avW = null;
        this.mOnPageChangeListener = null;
        this.avX = null;
        this.avb = null;
        this.avY = null;
        this.avc = null;
        this.avZ = 0;
        this.awa = true;
        this.awb = false;
        this.avl = false;
        init();
    }

    private void init() {
        this.awb = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.avT) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HE();
                    }
                } else if (view == MultiImageView.this.avU && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HF();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.avX != null) {
                    MultiImageView.this.avX.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.avX != null) {
                    MultiImageView.this.avX.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.avW.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.avW.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).By();
                    }
                }
                if (MultiImageView.this.avX != null) {
                    MultiImageView.this.avX.onPageSelected(i);
                }
            }
        };
        this.avb = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.avW.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avc = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.avW.getCurrentView()) {
                    if (MultiImageView.this.awa) {
                        int childCount = MultiImageView.this.avW.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.avW.getChildAt(i);
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

    public void di(int i) {
        if (this.mSkinType != i && this.avW != null) {
            int childCount = this.avW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.avW.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.avW.getCurrentView() != null) {
            if (this.awa) {
                int childCount = this.avW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.avW.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.avW.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.avW.findViewWithTag(String.valueOf(this.avW.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.avl, true);
            }
            this.avW.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.avW.getCurrentView() != null) {
            this.avW.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.avW != null) {
            int childCount = this.avW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avW.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ev(int i) {
        View findViewWithTag = this.avW.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.avl, true);
        }
    }

    private void initUI() {
        this.avW = new b(getContext());
        this.avW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.avW.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.avW);
        this.avV = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.avV.setOrientation(0);
        this.avV.setLayoutParams(layoutParams);
        addView(this.avV);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.avU = new Button(getContext());
        this.avU.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.avU.setLayoutParams(layoutParams2);
        this.avU.setOnClickListener(this.mOnClickListener);
        this.avU.setEnabled(false);
        this.avV.addView(this.avU);
        this.avT = new Button(getContext());
        this.avT.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.avT.setLayoutParams(layoutParams2);
        this.avT.setOnClickListener(this.mOnClickListener);
        this.avT.setEnabled(false);
        this.avV.addView(this.avT);
        if (this.awb) {
            this.avV.setVisibility(8);
        }
        this.avY = new c(getContext(), this.avW, this.avc);
        setAdapter(this.avY);
    }

    public void setIsCanDrag(boolean z) {
        if (this.avY != null) {
            this.avY.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.avX = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avY.getCount();
    }

    public int getCurrentItem() {
        return this.avW.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.avT.setEnabled(true);
            } else {
                this.avT.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.avU.setEnabled(true);
                return;
            } else {
                this.avU.setEnabled(false);
                return;
            }
        }
        this.avU.setEnabled(false);
        this.avT.setEnabled(false);
    }

    public void Bb() {
        if (!this.awb) {
            this.avV.setVisibility(0);
        }
    }

    public void bk(boolean z) {
        if (this.avW != null) {
            int childCount = this.avW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avW.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bk(z);
                }
            }
        }
    }

    public void Bc() {
        if (!this.awb) {
            this.avV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.avW.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.avW.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.avW.setOffscreenPageLimit(i);
        this.avZ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avZ = (int) (this.avZ * 0.8d);
        if (this.avZ < 6291456) {
            this.awa = true;
            this.avZ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.awa = false;
        }
        PagerAdapter adapter = this.avW.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.avZ);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avb);
        this.avW.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avY);
        this.avW.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avY.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.avY.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avY.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.avY.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avY.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avY.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avY.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avY.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avY.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.avY.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avY.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.avW.getCurrentView();
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
        if (this.avY != null) {
            this.avY.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.avW.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avl = z;
        if (this.avY != null) {
            this.avY.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avY != null) {
            this.avY.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avY != null) {
            this.avY.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.avY.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.avY != null) {
            this.avY.setOriImgSelectedCallback(bVar);
        }
    }
}
