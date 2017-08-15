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
    private a.e awp;
    private a.d awq;
    private boolean awy;
    private Button axg;
    private Button axh;
    private LinearLayout axi;
    private b axj;
    private ViewPager.OnPageChangeListener axk;
    private c axl;
    private int axm;
    private boolean axn;
    private boolean axo;
    private boolean axp;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.axg = null;
        this.axh = null;
        this.axi = null;
        this.mOnClickListener = null;
        this.axj = null;
        this.mOnPageChangeListener = null;
        this.axk = null;
        this.awp = null;
        this.axl = null;
        this.awq = null;
        this.axm = 0;
        this.axn = true;
        this.axo = false;
        this.awy = false;
        this.axp = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.axj != null) {
            this.axj.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.axg = null;
        this.axh = null;
        this.axi = null;
        this.mOnClickListener = null;
        this.axj = null;
        this.mOnPageChangeListener = null;
        this.axk = null;
        this.awp = null;
        this.axl = null;
        this.awq = null;
        this.axm = 0;
        this.axn = true;
        this.axo = false;
        this.awy = false;
        this.axp = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.axg = null;
        this.axh = null;
        this.axi = null;
        this.mOnClickListener = null;
        this.axj = null;
        this.mOnPageChangeListener = null;
        this.axk = null;
        this.awp = null;
        this.axl = null;
        this.awq = null;
        this.axm = 0;
        this.axn = true;
        this.axo = false;
        this.awy = false;
        this.axp = false;
        init();
    }

    private void init() {
        this.axo = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.axg) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HH();
                    }
                } else if (view == MultiImageView.this.axh && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HI();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.axk != null) {
                    MultiImageView.this.axk.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.axk != null) {
                    MultiImageView.this.axk.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.axj.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bo(MultiImageView.this.axp);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.axj.setSelectedView(imageView);
                        imageView.HJ();
                    }
                }
                int childCount = MultiImageView.this.axj.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.axj.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BL();
                    }
                }
                if (MultiImageView.this.axn && i.hr()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.axj.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bs(MultiImageView.this.awy);
                        }
                    }
                }
                if (MultiImageView.this.axk != null) {
                    MultiImageView.this.axk.onPageSelected(i);
                }
            }
        };
        this.awp = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.axj.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.awq = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.axj.getCurrentView()) {
                    if (MultiImageView.this.axn) {
                        int childCount = MultiImageView.this.axj.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.axj.getChildAt(i);
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
        if (this.mSkinType != i && this.axj != null) {
            int childCount = this.axj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.axj.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.axj.getCurrentView() != null) {
            if (this.axn) {
                int childCount = this.axj.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.axj.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.axj.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.axj.findViewWithTag(String.valueOf(this.axj.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).h(this.awy, true);
            }
            this.axj.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.axj.getCurrentView() != null) {
            this.axj.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.axj != null) {
            int childCount = this.axj.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.axj.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.axj = new b(getContext());
        this.axj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.axj.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.axj);
        this.axi = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.axi.setOrientation(0);
        this.axi.setLayoutParams(layoutParams);
        addView(this.axi);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.axh = new Button(getContext());
        this.axh.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.axh.setLayoutParams(layoutParams2);
        this.axh.setOnClickListener(this.mOnClickListener);
        this.axh.setEnabled(false);
        this.axi.addView(this.axh);
        this.axg = new Button(getContext());
        this.axg.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.axg.setLayoutParams(layoutParams2);
        this.axg.setOnClickListener(this.mOnClickListener);
        this.axg.setEnabled(false);
        this.axi.addView(this.axg);
        if (this.axo) {
            this.axi.setVisibility(8);
        }
        this.axl = new c(getContext(), null, this.awq);
        setAdapter(this.axl);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.axk = onPageChangeListener;
    }

    public int getItemNum() {
        return this.axl.getCount();
    }

    public int getCurrentItem() {
        return this.axj.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.axg.setEnabled(true);
            } else {
                this.axg.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.axh.setEnabled(true);
                return;
            } else {
                this.axh.setEnabled(false);
                return;
            }
        }
        this.axh.setEnabled(false);
        this.axg.setEnabled(false);
    }

    public void Bt() {
        if (!this.axo) {
            this.axi.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axp = z;
        if (this.axj != null) {
            View findViewWithTag = this.axj.findViewWithTag(String.valueOf(this.axj.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bo(z);
            }
        }
    }

    public void Bu() {
        if (!this.axo) {
            this.axi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.axj.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.axj.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.axj.setOffscreenPageLimit(i);
        this.axm = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.axm = (int) (this.axm * 0.8d);
        if (this.axm < 6291456) {
            this.axn = true;
            this.axm = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.axn = false;
        }
        PagerAdapter adapter = this.axj.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.axm);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.awp);
        this.axj.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.axl);
        this.axj.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.axl.setTempSize(i);
        this.axl.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.axl.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.axl.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axl.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.axl.setData(arrayList);
        this.axl.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.axl.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.axl.setHasNext(z);
        this.axl.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.axl.getHasNext();
    }

    public void setNextTitle(String str) {
        this.axl.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.axj.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.axj.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.awy = z;
        if (this.axl != null) {
            this.axl.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.axl != null) {
            this.axl.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axl != null) {
            this.axl.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.axl.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.axl != null) {
            this.axl.setOriImgSelectedCallback(bVar);
        }
    }
}
