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
    private a.f bmm;
    private a.e bmn;
    private boolean bmw;
    private Button bnd;
    private Button bne;
    private LinearLayout bnf;
    private b bng;
    private ViewPager.OnPageChangeListener bnh;
    private c bni;
    private int bnj;
    private boolean bnk;
    private boolean bnl;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bnd = null;
        this.bne = null;
        this.bnf = null;
        this.mOnClickListener = null;
        this.bng = null;
        this.mOnPageChangeListener = null;
        this.bnh = null;
        this.bmm = null;
        this.bni = null;
        this.bmn = null;
        this.bnj = 0;
        this.bnk = true;
        this.bnl = false;
        this.bmw = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.bng != null) {
            this.bng.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bnd = null;
        this.bne = null;
        this.bnf = null;
        this.mOnClickListener = null;
        this.bng = null;
        this.mOnPageChangeListener = null;
        this.bnh = null;
        this.bmm = null;
        this.bni = null;
        this.bmn = null;
        this.bnj = 0;
        this.bnk = true;
        this.bnl = false;
        this.bmw = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bnd = null;
        this.bne = null;
        this.bnf = null;
        this.mOnClickListener = null;
        this.bng = null;
        this.mOnPageChangeListener = null;
        this.bnh = null;
        this.bmm = null;
        this.bni = null;
        this.bmn = null;
        this.bnj = 0;
        this.bnk = true;
        this.bnl = false;
        this.bmw = false;
        init();
    }

    public void init() {
        this.bnl = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bnd) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.PG();
                    }
                } else if (view == MultiImageView.this.bne && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.PH();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.bnh != null) {
                    MultiImageView.this.bnh.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.bnh != null) {
                    MultiImageView.this.bnh.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.bng.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.bng.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).JJ();
                    }
                }
                if (MultiImageView.this.bnh != null) {
                    MultiImageView.this.bnh.onPageSelected(i);
                }
            }
        };
        this.bmm = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.bng.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bmn = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.bng.getCurrentView()) {
                    if (MultiImageView.this.bnk) {
                        int childCount = MultiImageView.this.bng.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.bng.getChildAt(i);
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
        if (this.mSkinType != i && this.bng != null) {
            int childCount = this.bng.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.bng.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.bng.getCurrentView() != null) {
            if (this.bnk) {
                int childCount = this.bng.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.bng.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.bng.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.bng.findViewWithTag(String.valueOf(this.bng.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bmw, true);
            }
            this.bng.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.bng.getCurrentView() != null) {
            this.bng.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.bng != null) {
            int childCount = this.bng.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bng.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hp(int i) {
        View findViewWithTag = this.bng.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bmw, true);
        }
    }

    private void initUI() {
        this.bng = new b(getContext());
        this.bng.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bng.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.bng);
        this.bnf = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bnf.setOrientation(0);
        this.bnf.setLayoutParams(layoutParams);
        addView(this.bnf);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bne = new Button(getContext());
        this.bne.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bne.setLayoutParams(layoutParams2);
        this.bne.setOnClickListener(this.mOnClickListener);
        this.bne.setEnabled(false);
        this.bnf.addView(this.bne);
        this.bnd = new Button(getContext());
        this.bnd.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bnd.setLayoutParams(layoutParams2);
        this.bnd.setOnClickListener(this.mOnClickListener);
        this.bnd.setEnabled(false);
        this.bnf.addView(this.bnd);
        if (this.bnl) {
            this.bnf.setVisibility(8);
        }
        this.bni = new c(getContext(), this.bng, this.bmn);
        setAdapter(this.bni);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bni != null) {
            this.bni.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bnh = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bni.getCount();
    }

    public int getCurrentItem() {
        return this.bng.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bnd.setEnabled(true);
            } else {
                this.bnd.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bne.setEnabled(true);
                return;
            } else {
                this.bne.setEnabled(false);
                return;
            }
        }
        this.bne.setEnabled(false);
        this.bnd.setEnabled(false);
    }

    public void Jl() {
        if (!this.bnl) {
            this.bnf.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        if (this.bng != null) {
            int childCount = this.bng.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bng.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bU(z);
                }
            }
        }
    }

    public void Jm() {
        if (!this.bnl) {
            this.bnf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.bng.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.bng.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.bng.setOffscreenPageLimit(i);
        this.bnj = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.bnj = (int) (this.bnj * 0.8d);
        if (this.bnj < 6291456) {
            this.bnk = true;
            this.bnj = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.bnk = false;
        }
        PagerAdapter adapter = this.bng.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.bnj);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bmm);
        this.bng.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bni);
        this.bng.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bni.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bni.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bni.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bni.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bni.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bni.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bni.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bni.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bni.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bni.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bni.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.bng.getCurrentView();
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
        if (this.bni != null) {
            this.bni.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.bng.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bmw = z;
        if (this.bni != null) {
            this.bni.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bni != null) {
            this.bni.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bni != null) {
            this.bni.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bni.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bni != null) {
            this.bni.setOriImgSelectedCallback(bVar);
        }
    }
}
