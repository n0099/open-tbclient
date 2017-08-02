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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
    private a.e auX;
    private a.d auY;
    private Button avO;
    private Button avP;
    private LinearLayout avQ;
    private b avR;
    private ViewPager.OnPageChangeListener avS;
    private c avT;
    private int avU;
    private boolean avV;
    private boolean avW;
    private boolean avX;
    private boolean avg;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.avO = null;
        this.avP = null;
        this.avQ = null;
        this.mOnClickListener = null;
        this.avR = null;
        this.mOnPageChangeListener = null;
        this.avS = null;
        this.auX = null;
        this.avT = null;
        this.auY = null;
        this.avU = 0;
        this.avV = true;
        this.avW = false;
        this.avg = false;
        this.avX = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.avR != null) {
            this.avR.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.avO = null;
        this.avP = null;
        this.avQ = null;
        this.mOnClickListener = null;
        this.avR = null;
        this.mOnPageChangeListener = null;
        this.avS = null;
        this.auX = null;
        this.avT = null;
        this.auY = null;
        this.avU = 0;
        this.avV = true;
        this.avW = false;
        this.avg = false;
        this.avX = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.avO = null;
        this.avP = null;
        this.avQ = null;
        this.mOnClickListener = null;
        this.avR = null;
        this.mOnPageChangeListener = null;
        this.avS = null;
        this.auX = null;
        this.avT = null;
        this.auY = null;
        this.avU = 0;
        this.avV = true;
        this.avW = false;
        this.avg = false;
        this.avX = false;
        init();
    }

    private void init() {
        this.avW = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.avO) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Hz();
                    }
                } else if (view == MultiImageView.this.avP && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HA();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.avS != null) {
                    MultiImageView.this.avS.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.avS != null) {
                    MultiImageView.this.avS.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.avR.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bo(MultiImageView.this.avX);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.avR.setSelectedView(imageView);
                        imageView.HB();
                    }
                }
                int childCount = MultiImageView.this.avR.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.avR.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BD();
                    }
                }
                if (MultiImageView.this.avV && i.hh()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.avR.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bs(MultiImageView.this.avg);
                        }
                    }
                }
                if (MultiImageView.this.avS != null) {
                    MultiImageView.this.avS.onPageSelected(i);
                }
            }
        };
        this.auX = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.avR.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.auY = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.avR.getCurrentView()) {
                    if (MultiImageView.this.avV) {
                        int childCount = MultiImageView.this.avR.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.avR.getChildAt(i);
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

    public void dg(int i) {
        if (this.mSkinType != i && this.avR != null) {
            int childCount = this.avR.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.avR.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.avR.getCurrentView() != null) {
            if (this.avV) {
                int childCount = this.avR.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.avR.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.avR.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.avR.findViewWithTag(String.valueOf(this.avR.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).h(this.avg, true);
            }
            this.avR.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.avR.getCurrentView() != null) {
            this.avR.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.avR != null) {
            int childCount = this.avR.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avR.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.avR = new b(getContext());
        this.avR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.avR.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.avR);
        this.avQ = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.avQ.setOrientation(0);
        this.avQ.setLayoutParams(layoutParams);
        addView(this.avQ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.avP = new Button(getContext());
        this.avP.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.avP.setLayoutParams(layoutParams2);
        this.avP.setOnClickListener(this.mOnClickListener);
        this.avP.setEnabled(false);
        this.avQ.addView(this.avP);
        this.avO = new Button(getContext());
        this.avO.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.avO.setLayoutParams(layoutParams2);
        this.avO.setOnClickListener(this.mOnClickListener);
        this.avO.setEnabled(false);
        this.avQ.addView(this.avO);
        if (this.avW) {
            this.avQ.setVisibility(8);
        }
        this.avT = new c(getContext(), null, this.auY);
        setAdapter(this.avT);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.avS = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avT.getCount();
    }

    public int getCurrentItem() {
        return this.avR.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.avO.setEnabled(true);
            } else {
                this.avO.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.avP.setEnabled(true);
                return;
            } else {
                this.avP.setEnabled(false);
                return;
            }
        }
        this.avP.setEnabled(false);
        this.avO.setEnabled(false);
    }

    public void Bl() {
        if (!this.avW) {
            this.avQ.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.avX = z;
        if (this.avR != null) {
            View findViewWithTag = this.avR.findViewWithTag(String.valueOf(this.avR.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bo(z);
            }
        }
    }

    public void Bm() {
        if (!this.avW) {
            this.avQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.avR.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.avR.setPageMargin(i);
    }

    public void I(int i, int i2) {
        this.avR.setOffscreenPageLimit(i);
        this.avU = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avU = (int) (this.avU * 0.8d);
        if (this.avU < 6291456) {
            this.avV = true;
            this.avU = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.avV = false;
        }
        PagerAdapter adapter = this.avR.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.avU);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.auX);
        this.avR.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avT);
        this.avR.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avT.setTempSize(i);
        this.avT.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avT.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avT.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avT.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avT.setData(arrayList);
        this.avT.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avT.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avT.setHasNext(z);
        this.avT.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.avT.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avT.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.avR.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.avR.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avg = z;
        if (this.avT != null) {
            this.avT.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avT != null) {
            this.avT.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avT != null) {
            this.avT.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.avT.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.avT != null) {
            this.avT.setOriImgSelectedCallback(bVar);
        }
    }
}
