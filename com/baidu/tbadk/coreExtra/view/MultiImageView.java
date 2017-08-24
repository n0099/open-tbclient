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
    private a.e awq;
    private a.d awr;
    private boolean awz;
    private Button axh;
    private Button axi;
    private LinearLayout axj;
    private b axk;
    private ViewPager.OnPageChangeListener axl;
    private c axm;
    private int axn;
    private boolean axo;
    private boolean axp;
    private boolean axq;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.axh = null;
        this.axi = null;
        this.axj = null;
        this.mOnClickListener = null;
        this.axk = null;
        this.mOnPageChangeListener = null;
        this.axl = null;
        this.awq = null;
        this.axm = null;
        this.awr = null;
        this.axn = 0;
        this.axo = true;
        this.axp = false;
        this.awz = false;
        this.axq = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.axk != null) {
            this.axk.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.axh = null;
        this.axi = null;
        this.axj = null;
        this.mOnClickListener = null;
        this.axk = null;
        this.mOnPageChangeListener = null;
        this.axl = null;
        this.awq = null;
        this.axm = null;
        this.awr = null;
        this.axn = 0;
        this.axo = true;
        this.axp = false;
        this.awz = false;
        this.axq = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.axh = null;
        this.axi = null;
        this.axj = null;
        this.mOnClickListener = null;
        this.axk = null;
        this.mOnPageChangeListener = null;
        this.axl = null;
        this.awq = null;
        this.axm = null;
        this.awr = null;
        this.axn = 0;
        this.axo = true;
        this.axp = false;
        this.awz = false;
        this.axq = false;
        init();
    }

    private void init() {
        this.axp = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.axh) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HH();
                    }
                } else if (view == MultiImageView.this.axi && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HI();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.axl != null) {
                    MultiImageView.this.axl.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.axl != null) {
                    MultiImageView.this.axl.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.axk.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bo(MultiImageView.this.axq);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.axk.setSelectedView(imageView);
                        imageView.HJ();
                    }
                }
                int childCount = MultiImageView.this.axk.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.axk.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BL();
                    }
                }
                if (MultiImageView.this.axo && i.hr()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.axk.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bs(MultiImageView.this.awz);
                        }
                    }
                }
                if (MultiImageView.this.axl != null) {
                    MultiImageView.this.axl.onPageSelected(i);
                }
            }
        };
        this.awq = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.axk.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.awr = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.axk.getCurrentView()) {
                    if (MultiImageView.this.axo) {
                        int childCount = MultiImageView.this.axk.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.axk.getChildAt(i);
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
        if (this.mSkinType != i && this.axk != null) {
            int childCount = this.axk.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.axk.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.axk.getCurrentView() != null) {
            if (this.axo) {
                int childCount = this.axk.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.axk.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.axk.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.axk.findViewWithTag(String.valueOf(this.axk.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).h(this.awz, true);
            }
            this.axk.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.axk.getCurrentView() != null) {
            this.axk.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.axk != null) {
            int childCount = this.axk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.axk.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.axk = new b(getContext());
        this.axk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.axk.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.axk);
        this.axj = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.axj.setOrientation(0);
        this.axj.setLayoutParams(layoutParams);
        addView(this.axj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.axi = new Button(getContext());
        this.axi.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.axi.setLayoutParams(layoutParams2);
        this.axi.setOnClickListener(this.mOnClickListener);
        this.axi.setEnabled(false);
        this.axj.addView(this.axi);
        this.axh = new Button(getContext());
        this.axh.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.axh.setLayoutParams(layoutParams2);
        this.axh.setOnClickListener(this.mOnClickListener);
        this.axh.setEnabled(false);
        this.axj.addView(this.axh);
        if (this.axp) {
            this.axj.setVisibility(8);
        }
        this.axm = new c(getContext(), null, this.awr);
        setAdapter(this.axm);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.axl = onPageChangeListener;
    }

    public int getItemNum() {
        return this.axm.getCount();
    }

    public int getCurrentItem() {
        return this.axk.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.axh.setEnabled(true);
            } else {
                this.axh.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.axi.setEnabled(true);
                return;
            } else {
                this.axi.setEnabled(false);
                return;
            }
        }
        this.axi.setEnabled(false);
        this.axh.setEnabled(false);
    }

    public void Bt() {
        if (!this.axp) {
            this.axj.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axq = z;
        if (this.axk != null) {
            View findViewWithTag = this.axk.findViewWithTag(String.valueOf(this.axk.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bo(z);
            }
        }
    }

    public void Bu() {
        if (!this.axp) {
            this.axj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.axk.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.axk.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.axk.setOffscreenPageLimit(i);
        this.axn = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.axn = (int) (this.axn * 0.8d);
        if (this.axn < 6291456) {
            this.axo = true;
            this.axn = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.axo = false;
        }
        PagerAdapter adapter = this.axk.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.axn);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.awq);
        this.axk.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.axm);
        this.axk.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.axm.setTempSize(i);
        this.axm.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.axm.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.axm.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axm.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.axm.setData(arrayList);
        this.axm.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.axm.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.axm.setHasNext(z);
        this.axm.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.axm.getHasNext();
    }

    public void setNextTitle(String str) {
        this.axm.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.axk.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.axk.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.awz = z;
        if (this.axm != null) {
            this.axm.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.axm != null) {
            this.axm.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axm != null) {
            this.axm.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.axm.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.axm != null) {
            this.axm.setOriImgSelectedCallback(bVar);
        }
    }
}
