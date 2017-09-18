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
    private a.d avA;
    private boolean avI;
    private a.e avz;
    private Button awp;
    private Button awq;
    private LinearLayout awr;
    private b aws;
    private ViewPager.OnPageChangeListener awt;
    private c awu;
    private int awv;
    private boolean aww;
    private boolean awx;
    private boolean awy;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.awp = null;
        this.awq = null;
        this.awr = null;
        this.mOnClickListener = null;
        this.aws = null;
        this.mOnPageChangeListener = null;
        this.awt = null;
        this.avz = null;
        this.awu = null;
        this.avA = null;
        this.awv = 0;
        this.aww = true;
        this.awx = false;
        this.avI = false;
        this.awy = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aws != null) {
            this.aws.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.awp = null;
        this.awq = null;
        this.awr = null;
        this.mOnClickListener = null;
        this.aws = null;
        this.mOnPageChangeListener = null;
        this.awt = null;
        this.avz = null;
        this.awu = null;
        this.avA = null;
        this.awv = 0;
        this.aww = true;
        this.awx = false;
        this.avI = false;
        this.awy = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.awp = null;
        this.awq = null;
        this.awr = null;
        this.mOnClickListener = null;
        this.aws = null;
        this.mOnPageChangeListener = null;
        this.awt = null;
        this.avz = null;
        this.awu = null;
        this.avA = null;
        this.awv = 0;
        this.aww = true;
        this.awx = false;
        this.avI = false;
        this.awy = false;
        init();
    }

    private void init() {
        this.awx = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.awp) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HG();
                    }
                } else if (view == MultiImageView.this.awq && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HH();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.awt != null) {
                    MultiImageView.this.awt.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.awt != null) {
                    MultiImageView.this.awt.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.aws.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bn(MultiImageView.this.awy);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.aws.setSelectedView(imageView);
                        imageView.HI();
                    }
                }
                int childCount = MultiImageView.this.aws.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.aws.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BG();
                    }
                }
                if (MultiImageView.this.aww && i.hi()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.aws.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).br(MultiImageView.this.avI);
                        }
                    }
                }
                if (MultiImageView.this.awt != null) {
                    MultiImageView.this.awt.onPageSelected(i);
                }
            }
        };
        this.avz = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.aws.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.avA = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.aws.getCurrentView()) {
                    if (MultiImageView.this.aww) {
                        int childCount = MultiImageView.this.aws.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.aws.getChildAt(i);
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
        if (this.mSkinType != i && this.aws != null) {
            int childCount = this.aws.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aws.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aws.getCurrentView() != null) {
            if (this.aww) {
                int childCount = this.aws.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aws.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.aws.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aws.findViewWithTag(String.valueOf(this.aws.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).i(this.avI, true);
            }
            this.aws.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aws.getCurrentView() != null) {
            this.aws.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aws != null) {
            int childCount = this.aws.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aws.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aws = new b(getContext());
        this.aws.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aws.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aws);
        this.awr = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.awr.setOrientation(0);
        this.awr.setLayoutParams(layoutParams);
        addView(this.awr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.awq = new Button(getContext());
        this.awq.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.awq.setLayoutParams(layoutParams2);
        this.awq.setOnClickListener(this.mOnClickListener);
        this.awq.setEnabled(false);
        this.awr.addView(this.awq);
        this.awp = new Button(getContext());
        this.awp.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.awp.setLayoutParams(layoutParams2);
        this.awp.setOnClickListener(this.mOnClickListener);
        this.awp.setEnabled(false);
        this.awr.addView(this.awp);
        if (this.awx) {
            this.awr.setVisibility(8);
        }
        this.awu = new c(getContext(), null, this.avA);
        setAdapter(this.awu);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awt = onPageChangeListener;
    }

    public int getItemNum() {
        return this.awu.getCount();
    }

    public int getCurrentItem() {
        return this.aws.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.awp.setEnabled(true);
            } else {
                this.awp.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.awq.setEnabled(true);
                return;
            } else {
                this.awq.setEnabled(false);
                return;
            }
        }
        this.awq.setEnabled(false);
        this.awp.setEnabled(false);
    }

    public void Bo() {
        if (!this.awx) {
            this.awr.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.awy = z;
        if (this.aws != null) {
            View findViewWithTag = this.aws.findViewWithTag(String.valueOf(this.aws.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bn(z);
            }
        }
    }

    public void Bp() {
        if (!this.awx) {
            this.awr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aws.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aws.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.aws.setOffscreenPageLimit(i);
        this.awv = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.awv = (int) (this.awv * 0.8d);
        if (this.awv < 6291456) {
            this.aww = true;
            this.awv = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aww = false;
        }
        PagerAdapter adapter = this.aws.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.awv);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.avz);
        this.aws.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.awu);
        this.aws.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.awu.setTempSize(i);
        this.awu.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.awu.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.awu.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awu.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.awu.setData(arrayList);
        this.awu.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awu.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.awu.setHasNext(z);
        this.awu.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.awu.getHasNext();
    }

    public void setNextTitle(String str) {
        this.awu.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aws.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aws.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.avI = z;
        if (this.awu != null) {
            this.awu.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.awu != null) {
            this.awu.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awu != null) {
            this.awu.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.awu.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.awu != null) {
            this.awu.setOriImgSelectedCallback(bVar);
        }
    }
}
