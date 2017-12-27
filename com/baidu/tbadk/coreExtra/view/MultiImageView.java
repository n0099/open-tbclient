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
    private a.f bjP;
    private a.e bjQ;
    private boolean bjZ;
    private Button bkH;
    private Button bkI;
    private LinearLayout bkJ;
    private b bkK;
    private ViewPager.OnPageChangeListener bkL;
    private c bkM;
    private int bkN;
    private boolean bkO;
    private boolean bkP;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bkH = null;
        this.bkI = null;
        this.bkJ = null;
        this.mOnClickListener = null;
        this.bkK = null;
        this.mOnPageChangeListener = null;
        this.bkL = null;
        this.bjP = null;
        this.bkM = null;
        this.bjQ = null;
        this.bkN = 0;
        this.bkO = true;
        this.bkP = false;
        this.bjZ = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.bkK != null) {
            this.bkK.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bkH = null;
        this.bkI = null;
        this.bkJ = null;
        this.mOnClickListener = null;
        this.bkK = null;
        this.mOnPageChangeListener = null;
        this.bkL = null;
        this.bjP = null;
        this.bkM = null;
        this.bjQ = null;
        this.bkN = 0;
        this.bkO = true;
        this.bkP = false;
        this.bjZ = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bkH = null;
        this.bkI = null;
        this.bkJ = null;
        this.mOnClickListener = null;
        this.bkK = null;
        this.mOnPageChangeListener = null;
        this.bkL = null;
        this.bjP = null;
        this.bkM = null;
        this.bjQ = null;
        this.bkN = 0;
        this.bkO = true;
        this.bkP = false;
        this.bjZ = false;
        init();
    }

    public void init() {
        this.bkP = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.bkH) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Pl();
                    }
                } else if (view == MultiImageView.this.bkI && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Pm();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.bkL != null) {
                    MultiImageView.this.bkL.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.bkL != null) {
                    MultiImageView.this.bkL.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int childCount = MultiImageView.this.bkK.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.bkK.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).Jl();
                    }
                }
                if (MultiImageView.this.bkL != null) {
                    MultiImageView.this.bkL.onPageSelected(i);
                }
            }
        };
        this.bjP = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.bkK.getCurrentView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.bjQ = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.bkK.getCurrentView()) {
                    if (MultiImageView.this.bkO) {
                        int childCount = MultiImageView.this.bkK.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.bkK.getChildAt(i);
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
        if (this.mSkinType != i && this.bkK != null) {
            int childCount = this.bkK.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.bkK.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.bkK.getCurrentView() != null) {
            if (this.bkO) {
                int childCount = this.bkK.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.bkK.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.bkK.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.bkK.findViewWithTag(String.valueOf(this.bkK.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).l(this.bjZ, true);
            }
            this.bkK.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.bkK.getCurrentView() != null) {
            this.bkK.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.bkK != null) {
            int childCount = this.bkK.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bkK.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void hu(int i) {
        View findViewWithTag = this.bkK.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).l(this.bjZ, true);
        }
    }

    private void initUI() {
        this.bkK = new b(getContext());
        this.bkK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.bkK.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.bkK);
        this.bkJ = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.bkJ.setOrientation(0);
        this.bkJ.setLayoutParams(layoutParams);
        addView(this.bkJ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bkI = new Button(getContext());
        this.bkI.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomout));
        this.bkI.setLayoutParams(layoutParams2);
        this.bkI.setOnClickListener(this.mOnClickListener);
        this.bkI.setEnabled(false);
        this.bkJ.addView(this.bkI);
        this.bkH = new Button(getContext());
        this.bkH.setBackgroundDrawable(getContext().getResources().getDrawable(d.f.image_zoomin));
        this.bkH.setLayoutParams(layoutParams2);
        this.bkH.setOnClickListener(this.mOnClickListener);
        this.bkH.setEnabled(false);
        this.bkJ.addView(this.bkH);
        if (this.bkP) {
            this.bkJ.setVisibility(8);
        }
        this.bkM = new c(getContext(), this.bkK, this.bjQ);
        setAdapter(this.bkM);
    }

    public void setIsCanDrag(boolean z) {
        if (this.bkM != null) {
            this.bkM.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bkL = onPageChangeListener;
    }

    public int getItemNum() {
        return this.bkM.getCount();
    }

    public int getCurrentItem() {
        return this.bkK.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.bkH.setEnabled(true);
            } else {
                this.bkH.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.bkI.setEnabled(true);
                return;
            } else {
                this.bkI.setEnabled(false);
                return;
            }
        }
        this.bkI.setEnabled(false);
        this.bkH.setEnabled(false);
    }

    public void IO() {
        if (!this.bkP) {
            this.bkJ.setVisibility(0);
        }
    }

    public void bR(boolean z) {
        if (this.bkK != null) {
            int childCount = this.bkK.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bkK.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).bR(z);
                }
            }
        }
    }

    public void IP() {
        if (!this.bkP) {
            this.bkJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.bkK.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.bkK.setPageMargin(i);
    }

    public void aF(int i, int i2) {
        this.bkK.setOffscreenPageLimit(i);
        this.bkN = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.bkN = (int) (this.bkN * 0.8d);
        if (this.bkN < 6291456) {
            this.bkO = true;
            this.bkN = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.bkO = false;
        }
        PagerAdapter adapter = this.bkK.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.bkN);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.bjP);
        this.bkK.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.bkM);
        this.bkK.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.bkM.setTempSize(i);
    }

    public void setAddSize(int i) {
        this.bkM.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bkM.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bkM.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkM.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.bkM.setData(arrayList);
    }

    public void setDrageToExitListener(a.d dVar) {
        this.bkM.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.bkM.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.bkM.setHasNext(z);
    }

    public boolean getHasNext() {
        return this.bkM.getHasNext();
    }

    public void setNextTitle(String str) {
        this.bkM.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a currentView = this.bkK.getCurrentView();
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
        if (this.bkM != null) {
            this.bkM.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a currentView = this.bkK.getCurrentView();
        if (!(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.bjZ = z;
        if (this.bkM != null) {
            this.bkM.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.bkM != null) {
            this.bkM.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bkM != null) {
            this.bkM.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.bkM.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.bkM != null) {
            this.bkM.setOriImgSelectedCallback(bVar);
        }
    }
}
