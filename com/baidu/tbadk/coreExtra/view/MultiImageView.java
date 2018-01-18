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
    private a.f bjZ;
    private Button bkQ;
    private Button bkR;
    private LinearLayout bkS;
    private b bkT;
    private ViewPager.OnPageChangeListener bkU;
    private c bkV;
    private int bkW;
    private boolean bkX;
    private boolean bkY;
    private a.e bka;
    private boolean bkj;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bkQ = null;
        this.bkR = null;
        this.bkS = null;
        this.mOnClickListener = null;
        this.bkT = null;
        this.mOnPageChangeListener = null;
        this.bkU = null;
        this.bjZ = null;
        this.bkV = null;
        this.bka = null;
        this.bkW = 0;
        this.bkX = true;
        this.bkY = false;
        this.bkj = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.bkT != null) {
            this.bkT.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bkQ = null;
        this.bkR = null;
        this.bkS = null;
        this.mOnClickListener = null;
        this.bkT = null;
        this.mOnPageChangeListener = null;
        this.bkU = null;
        this.bjZ = null;
        this.bkV = null;
        this.bka = null;
        this.bkW = 0;
        this.bkX = true;
        this.bkY = false;
        this.bkj = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bkQ = null;
        this.bkR = null;
        this.bkS = null;
        this.mOnClickListener = null;
        this.bkT = null;
        this.mOnPageChangeListener = null;
        this.bkU = null;
        this.bjZ = null;
        this.bkV = null;
        this.bka = null;
        this.bkW = 0;
        this.bkX = true;
        this.bkY = false;
        this.bkj = false;
        init();
    }

    public void init() {
        this.bkY = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bkQ) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.OZ();
                    }
                } else if (view == MultiImageView.this.bkR && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Pa();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.bkU != null) {
                    MultiImageView.this.bkU.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.bkU != null) {
                    MultiImageView.this.bkU.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.bkT.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.bkT.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).Ja();
                    }
                }
                if (MultiImageView.this.bkU != null) {
                    MultiImageView.this.bkU.onPageSelected(i);
                }
            }
        };
        this.bjZ = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.bkT.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bka = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.bkT.getCurrentView()) {
                    if (MultiImageView.this.bkX) {
                        int childCount = MultiImageView.this.bkT.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.bkT.getChildAt(i);
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

    public void gg(int i) {
        if (this.mSkinType != i && this.bkT != null) {
            int childCount = this.bkT.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.bkT.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.bkT.getCurrentView() != null) {
            if (this.bkX) {
                int childCount = this.bkT.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.bkT.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.bkT.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.bkT.findViewWithTag(String.valueOf(this.bkT.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bkj, true);
            }
            this.bkT.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.bkT.getCurrentView() != null) {
            this.bkT.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.bkT != null) {
            int childCount = this.bkT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bkT.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hq(int i) {
        View findViewWithTag = this.bkT.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bkj, true);
        }
    }

    private void initUI() {
        this.bkT = new b(getContext());
        this.bkT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bkT.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.bkT);
        this.bkS = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bkS.setOrientation(0);
        this.bkS.setLayoutParams(layoutParams);
        addView(this.bkS);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bkR = new Button(getContext());
        this.bkR.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bkR.setLayoutParams(layoutParams2);
        this.bkR.setOnClickListener(this.mOnClickListener);
        this.bkR.setEnabled(false);
        this.bkS.addView(this.bkR);
        this.bkQ = new Button(getContext());
        this.bkQ.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bkQ.setLayoutParams(layoutParams2);
        this.bkQ.setOnClickListener(this.mOnClickListener);
        this.bkQ.setEnabled(false);
        this.bkS.addView(this.bkQ);
        if (this.bkY) {
            this.bkS.setVisibility(8);
        }
        this.bkV = new c(getContext(), this.bkT, this.bka);
        setAdapter(this.bkV);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bkV != null) {
            this.bkV.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bkU = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bkV.getCount();
    }

    public int getCurrentItem() {
        return this.bkT.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bkQ.setEnabled(true);
            } else {
                this.bkQ.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bkR.setEnabled(true);
                return;
            } else {
                this.bkR.setEnabled(false);
                return;
            }
        }
        this.bkR.setEnabled(false);
        this.bkQ.setEnabled(false);
    }

    public void ID() {
        if (!this.bkY) {
            this.bkS.setVisibility(0);
        }
    }

    public void bP(boolean z) {
        if (this.bkT != null) {
            int childCount = this.bkT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bkT.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bP(z);
                }
            }
        }
    }

    public void IE() {
        if (!this.bkY) {
            this.bkS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.bkT.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.bkT.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.bkT.setOffscreenPageLimit(i);
        this.bkW = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.bkW = (int) (this.bkW * 0.8d);
        if (this.bkW < 6291456) {
            this.bkX = true;
            this.bkW = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.bkX = false;
        }
        PagerAdapter adapter = this.bkT.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.bkW);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bjZ);
        this.bkT.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bkV);
        this.bkT.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bkV.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bkV.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bkV.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bkV.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkV.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bkV.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bkV.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bkV.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bkV.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bkV.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bkV.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.bkT.getCurrentView();
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
        if (this.bkV != null) {
            this.bkV.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.bkT.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bkj = z;
        if (this.bkV != null) {
            this.bkV.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bkV != null) {
            this.bkV.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bkV != null) {
            this.bkV.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bkV.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bkV != null) {
            this.bkV.setOriImgSelectedCallback(bVar);
        }
    }
}
