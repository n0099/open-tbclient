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
    private a.e awo;
    private a.d awp;
    private boolean awx;
    private Button axf;
    private Button axg;
    private LinearLayout axh;
    private b axi;
    private ViewPager.OnPageChangeListener axj;
    private c axk;
    private int axl;
    private boolean axm;
    private boolean axn;
    private boolean axo;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.axf = null;
        this.axg = null;
        this.axh = null;
        this.mOnClickListener = null;
        this.axi = null;
        this.mOnPageChangeListener = null;
        this.axj = null;
        this.awo = null;
        this.axk = null;
        this.awp = null;
        this.axl = 0;
        this.axm = true;
        this.axn = false;
        this.awx = false;
        this.axo = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.axi != null) {
            this.axi.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.axf = null;
        this.axg = null;
        this.axh = null;
        this.mOnClickListener = null;
        this.axi = null;
        this.mOnPageChangeListener = null;
        this.axj = null;
        this.awo = null;
        this.axk = null;
        this.awp = null;
        this.axl = 0;
        this.axm = true;
        this.axn = false;
        this.awx = false;
        this.axo = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.axf = null;
        this.axg = null;
        this.axh = null;
        this.mOnClickListener = null;
        this.axi = null;
        this.mOnPageChangeListener = null;
        this.axj = null;
        this.awo = null;
        this.axk = null;
        this.awp = null;
        this.axl = 0;
        this.axm = true;
        this.axn = false;
        this.awx = false;
        this.axo = false;
        init();
    }

    private void init() {
        this.axn = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.axf) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.HH();
                    }
                } else if (view == MultiImageView.this.axg && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.HI();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.axj != null) {
                    MultiImageView.this.axj.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.axj != null) {
                    MultiImageView.this.axj.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.axi.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bo(MultiImageView.this.axo);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.axi.setSelectedView(imageView);
                        imageView.HJ();
                    }
                }
                int childCount = MultiImageView.this.axi.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.axi.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).BL();
                    }
                }
                if (MultiImageView.this.axm && i.hr()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.axi.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bs(MultiImageView.this.awx);
                        }
                    }
                }
                if (MultiImageView.this.axj != null) {
                    MultiImageView.this.axj.onPageSelected(i);
                }
            }
        };
        this.awo = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.axi.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.awp = new a.d() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.d
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.axi.getCurrentView()) {
                    if (MultiImageView.this.axm) {
                        int childCount = MultiImageView.this.axi.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.axi.getChildAt(i);
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
        if (this.mSkinType != i && this.axi != null) {
            int childCount = this.axi.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.axi.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.axi.getCurrentView() != null) {
            if (this.axm) {
                int childCount = this.axi.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.axi.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.axi.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.axi.findViewWithTag(String.valueOf(this.axi.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).h(this.awx, true);
            }
            this.axi.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.axi.getCurrentView() != null) {
            this.axi.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.axi != null) {
            int childCount = this.axi.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.axi.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.axi = new b(getContext());
        this.axi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.axi.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.axi);
        this.axh = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.axh.setOrientation(0);
        this.axh.setLayoutParams(layoutParams);
        addView(this.axh);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.axg = new Button(getContext());
        this.axg.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.axg.setLayoutParams(layoutParams2);
        this.axg.setOnClickListener(this.mOnClickListener);
        this.axg.setEnabled(false);
        this.axh.addView(this.axg);
        this.axf = new Button(getContext());
        this.axf.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.axf.setLayoutParams(layoutParams2);
        this.axf.setOnClickListener(this.mOnClickListener);
        this.axf.setEnabled(false);
        this.axh.addView(this.axf);
        if (this.axn) {
            this.axh.setVisibility(8);
        }
        this.axk = new c(getContext(), null, this.awp);
        setAdapter(this.axk);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.axj = onPageChangeListener;
    }

    public int getItemNum() {
        return this.axk.getCount();
    }

    public int getCurrentItem() {
        return this.axi.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.axf.setEnabled(true);
            } else {
                this.axf.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.axg.setEnabled(true);
                return;
            } else {
                this.axg.setEnabled(false);
                return;
            }
        }
        this.axg.setEnabled(false);
        this.axf.setEnabled(false);
    }

    public void Bt() {
        if (!this.axn) {
            this.axh.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axo = z;
        if (this.axi != null) {
            View findViewWithTag = this.axi.findViewWithTag(String.valueOf(this.axi.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bo(z);
            }
        }
    }

    public void Bu() {
        if (!this.axn) {
            this.axh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.axi.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.axi.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.axi.setOffscreenPageLimit(i);
        this.axl = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.axl = (int) (this.axl * 0.8d);
        if (this.axl < 6291456) {
            this.axm = true;
            this.axl = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.axm = false;
        }
        PagerAdapter adapter = this.axi.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.axl);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.awo);
        this.axi.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.axk);
        this.axi.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.axk.setTempSize(i);
        this.axk.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.axk.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.axk.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axk.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.axk.setData(arrayList);
        this.axk.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.axk.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.axk.setHasNext(z);
        this.axk.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.axk.getHasNext();
    }

    public void setNextTitle(String str) {
        this.axk.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.axi.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.axi.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.awx = z;
        if (this.axk != null) {
            this.axk.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.axk != null) {
            this.axk.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axk != null) {
            this.axk.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.axk.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.axk != null) {
            this.axk.setOriImgSelectedCallback(bVar);
        }
    }
}
