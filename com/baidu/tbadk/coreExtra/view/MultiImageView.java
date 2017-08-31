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
    private a.e avC;
    private a.d avD;
    private boolean avL;
    private boolean awA;
    private boolean awB;
    private Button aws;
    private Button awt;
    private LinearLayout awu;
    private b awv;
    private ViewPager.OnPageChangeListener aww;
    private c awx;
    private int awy;
    private boolean awz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aws = null;
        this.awt = null;
        this.awu = null;
        this.mOnClickListener = null;
        this.awv = null;
        this.mOnPageChangeListener = null;
        this.aww = null;
        this.avC = null;
        this.awx = null;
        this.avD = null;
        this.awy = 0;
        this.awz = true;
        this.awA = false;
        this.avL = false;
        this.awB = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.awv != null) {
            this.awv.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aws = null;
        this.awt = null;
        this.awu = null;
        this.mOnClickListener = null;
        this.awv = null;
        this.mOnPageChangeListener = null;
        this.aww = null;
        this.avC = null;
        this.awx = null;
        this.avD = null;
        this.awy = 0;
        this.awz = true;
        this.awA = false;
        this.avL = false;
        this.awB = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aws = null;
        this.awt = null;
        this.awu = null;
        this.mOnClickListener = null;
        this.awv = null;
        this.mOnPageChangeListener = null;
        this.aww = null;
        this.avC = null;
        this.awx = null;
        this.avD = null;
        this.awy = 0;
        this.awz = true;
        this.awA = false;
        this.avL = false;
        this.awB = false;
        init();
    }

    private void init() {
        this.awA = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.aws) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HG();
                    }
                } else if (view == MultiImageView.this.awt && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HH();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.aww != null) {
                    MultiImageView.this.aww.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.aww != null) {
                    MultiImageView.this.aww.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.awv.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bn(MultiImageView.this.awB);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.awv.setSelectedView(imageView);
                        imageView.HI();
                    }
                }
                int childCount = MultiImageView.this.awv.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.awv.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BG();
                    }
                }
                if (MultiImageView.this.awz && i.hi()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.awv.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).br(MultiImageView.this.avL);
                        }
                    }
                }
                if (MultiImageView.this.aww != null) {
                    MultiImageView.this.aww.onPageSelected(i);
                }
            }
        };
        this.avC = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.awv.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avD = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.awv.getCurrentView()) {
                    if (MultiImageView.this.awz) {
                        int childCount = MultiImageView.this.awv.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.awv.getChildAt(i);
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
        if (this.mSkinType != i && this.awv != null) {
            int childCount = this.awv.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.awv.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.awv.getCurrentView() != null) {
            if (this.awz) {
                int childCount = this.awv.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.awv.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.awv.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.awv.findViewWithTag(String.valueOf(this.awv.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).i(this.avL, true);
            }
            this.awv.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.awv.getCurrentView() != null) {
            this.awv.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.awv != null) {
            int childCount = this.awv.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.awv.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.awv = new b(getContext());
        this.awv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.awv.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.awv);
        this.awu = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.awu.setOrientation(0);
        this.awu.setLayoutParams(layoutParams);
        addView(this.awu);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.awt = new Button(getContext());
        this.awt.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.awt.setLayoutParams(layoutParams2);
        this.awt.setOnClickListener(this.mOnClickListener);
        this.awt.setEnabled(false);
        this.awu.addView(this.awt);
        this.aws = new Button(getContext());
        this.aws.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.aws.setLayoutParams(layoutParams2);
        this.aws.setOnClickListener(this.mOnClickListener);
        this.aws.setEnabled(false);
        this.awu.addView(this.aws);
        if (this.awA) {
            this.awu.setVisibility(8);
        }
        this.awx = new c(getContext(), null, this.avD);
        setAdapter(this.awx);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aww = onPageChangeListener;
    }

    public int getItemNum() {
        return this.awx.getCount();
    }

    public int getCurrentItem() {
        return this.awv.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aws.setEnabled(true);
            } else {
                this.aws.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.awt.setEnabled(true);
                return;
            } else {
                this.awt.setEnabled(false);
                return;
            }
        }
        this.awt.setEnabled(false);
        this.aws.setEnabled(false);
    }

    public void Bo() {
        if (!this.awA) {
            this.awu.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.awB = z;
        if (this.awv != null) {
            View findViewWithTag = this.awv.findViewWithTag(String.valueOf(this.awv.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bn(z);
            }
        }
    }

    public void Bp() {
        if (!this.awA) {
            this.awu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.awv.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.awv.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.awv.setOffscreenPageLimit(i);
        this.awy = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.awy = (int) (this.awy * 0.8d);
        if (this.awy < 6291456) {
            this.awz = true;
            this.awy = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.awz = false;
        }
        PagerAdapter adapter = this.awv.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.awy);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avC);
        this.awv.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.awx);
        this.awv.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.awx.setTempSize(i);
        this.awx.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.awx.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.awx.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awx.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.awx.setData(arrayList);
        this.awx.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awx.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.awx.setHasNext(z);
        this.awx.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.awx.getHasNext();
    }

    public void setNextTitle(String str) {
        this.awx.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.awv.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.awv.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avL = z;
        if (this.awx != null) {
            this.awx.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.awx != null) {
            this.awx.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awx != null) {
            this.awx.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.awx.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.awx != null) {
            this.awx.setOriImgSelectedCallback(bVar);
        }
    }
}
