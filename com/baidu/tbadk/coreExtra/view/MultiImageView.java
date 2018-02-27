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
    private a.f bmj;
    private a.e bmk;
    private boolean bmt;
    private Button bna;
    private Button bnb;
    private LinearLayout bnc;
    private b bnd;
    private ViewPager.OnPageChangeListener bne;
    private c bnf;
    private int bng;
    private boolean bnh;
    private boolean bni;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bna = null;
        this.bnb = null;
        this.bnc = null;
        this.mOnClickListener = null;
        this.bnd = null;
        this.mOnPageChangeListener = null;
        this.bne = null;
        this.bmj = null;
        this.bnf = null;
        this.bmk = null;
        this.bng = 0;
        this.bnh = true;
        this.bni = false;
        this.bmt = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.bnd != null) {
            this.bnd.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bna = null;
        this.bnb = null;
        this.bnc = null;
        this.mOnClickListener = null;
        this.bnd = null;
        this.mOnPageChangeListener = null;
        this.bne = null;
        this.bmj = null;
        this.bnf = null;
        this.bmk = null;
        this.bng = 0;
        this.bnh = true;
        this.bni = false;
        this.bmt = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bna = null;
        this.bnb = null;
        this.bnc = null;
        this.mOnClickListener = null;
        this.bnd = null;
        this.mOnPageChangeListener = null;
        this.bne = null;
        this.bmj = null;
        this.bnf = null;
        this.bmk = null;
        this.bng = 0;
        this.bnh = true;
        this.bni = false;
        this.bmt = false;
        init();
    }

    public void init() {
        this.bni = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bna) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.PF();
                    }
                } else if (view == MultiImageView.this.bnb && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.PG();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.bne != null) {
                    MultiImageView.this.bne.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.bne != null) {
                    MultiImageView.this.bne.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.bnd.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.bnd.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).JI();
                    }
                }
                if (MultiImageView.this.bne != null) {
                    MultiImageView.this.bne.onPageSelected(i);
                }
            }
        };
        this.bmj = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.bnd.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bmk = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.bnd.getCurrentView()) {
                    if (MultiImageView.this.bnh) {
                        int childCount = MultiImageView.this.bnd.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.bnd.getChildAt(i);
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
        if (this.mSkinType != i && this.bnd != null) {
            int childCount = this.bnd.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.bnd.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.bnd.getCurrentView() != null) {
            if (this.bnh) {
                int childCount = this.bnd.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.bnd.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.bnd.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.bnd.findViewWithTag(String.valueOf(this.bnd.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bmt, true);
            }
            this.bnd.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.bnd.getCurrentView() != null) {
            this.bnd.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.bnd != null) {
            int childCount = this.bnd.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bnd.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hp(int i) {
        View findViewWithTag = this.bnd.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bmt, true);
        }
    }

    private void initUI() {
        this.bnd = new b(getContext());
        this.bnd.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bnd.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.bnd);
        this.bnc = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bnc.setOrientation(0);
        this.bnc.setLayoutParams(layoutParams);
        addView(this.bnc);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bnb = new Button(getContext());
        this.bnb.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bnb.setLayoutParams(layoutParams2);
        this.bnb.setOnClickListener(this.mOnClickListener);
        this.bnb.setEnabled(false);
        this.bnc.addView(this.bnb);
        this.bna = new Button(getContext());
        this.bna.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bna.setLayoutParams(layoutParams2);
        this.bna.setOnClickListener(this.mOnClickListener);
        this.bna.setEnabled(false);
        this.bnc.addView(this.bna);
        if (this.bni) {
            this.bnc.setVisibility(8);
        }
        this.bnf = new c(getContext(), this.bnd, this.bmk);
        setAdapter(this.bnf);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bnf != null) {
            this.bnf.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bne = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bnf.getCount();
    }

    public int getCurrentItem() {
        return this.bnd.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bna.setEnabled(true);
            } else {
                this.bna.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bnb.setEnabled(true);
                return;
            } else {
                this.bnb.setEnabled(false);
                return;
            }
        }
        this.bnb.setEnabled(false);
        this.bna.setEnabled(false);
    }

    public void Jk() {
        if (!this.bni) {
            this.bnc.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        if (this.bnd != null) {
            int childCount = this.bnd.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bnd.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bU(z);
                }
            }
        }
    }

    public void Jl() {
        if (!this.bni) {
            this.bnc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.bnd.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.bnd.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.bnd.setOffscreenPageLimit(i);
        this.bng = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.bng = (int) (this.bng * 0.8d);
        if (this.bng < 6291456) {
            this.bnh = true;
            this.bng = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.bnh = false;
        }
        PagerAdapter adapter = this.bnd.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.bng);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bmj);
        this.bnd.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bnf);
        this.bnd.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bnf.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bnf.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bnf.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bnf.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnf.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bnf.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bnf.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bnf.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bnf.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bnf.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bnf.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.bnd.getCurrentView();
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
        if (this.bnf != null) {
            this.bnf.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.bnd.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmt = z;
        if (this.bnf != null) {
            this.bnf.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bnf != null) {
            this.bnf.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bnf != null) {
            this.bnf.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bnf.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bnf != null) {
            this.bnf.setOriImgSelectedCallback(bVar);
        }
    }
}
