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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.i;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean akE;
    private a.e akv;
    private a.d akw;
    private Button aln;
    private Button alo;
    private LinearLayout alp;
    private h alq;
    private ViewPager.OnPageChangeListener alr;
    private i als;
    private int alt;
    private boolean alu;
    private boolean alv;
    private boolean alw;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aln = null;
        this.alo = null;
        this.alp = null;
        this.mOnClickListener = null;
        this.alq = null;
        this.mOnPageChangeListener = null;
        this.alr = null;
        this.akv = null;
        this.als = null;
        this.akw = null;
        this.alt = 0;
        this.alu = true;
        this.alv = false;
        this.akE = false;
        this.alw = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.alq != null) {
            this.alq.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aln = null;
        this.alo = null;
        this.alp = null;
        this.mOnClickListener = null;
        this.alq = null;
        this.mOnPageChangeListener = null;
        this.alr = null;
        this.akv = null;
        this.als = null;
        this.akw = null;
        this.alt = 0;
        this.alu = true;
        this.alv = false;
        this.akE = false;
        this.alw = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aln = null;
        this.alo = null;
        this.alp = null;
        this.mOnClickListener = null;
        this.alq = null;
        this.mOnPageChangeListener = null;
        this.alr = null;
        this.akv = null;
        this.als = null;
        this.akw = null;
        this.alt = 0;
        this.alu = true;
        this.alv = false;
        this.akE = false;
        this.alw = false;
        init();
    }

    private void init() {
        this.alv = UtilHelper.isSupportGesture(getContext());
        initEvent();
        nl();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.akv = new q(this);
        this.akw = new r(this);
    }

    public void cO(int i) {
        if (this.mSkinType != i && this.alq != null) {
            int childCount = this.alq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.alq.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.alq.getCurrentView() != null) {
            if (this.alu) {
                int childCount = this.alq.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.alq.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.alq.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.alq.findViewWithTag(String.valueOf(this.alq.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).f(this.akE, true);
            }
            this.alq.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.alq.getCurrentView() != null) {
            this.alq.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.alq != null) {
            int childCount = this.alq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.alq.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void nl() {
        this.alq = new h(getContext());
        this.alq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.alq.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.alq);
        this.alp = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.alp.setOrientation(0);
        this.alp.setLayoutParams(layoutParams);
        addView(this.alp);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.alo = new Button(getContext());
        this.alo.setBackgroundDrawable(getContext().getResources().getDrawable(u.f.image_zoomout));
        this.alo.setLayoutParams(layoutParams2);
        this.alo.setOnClickListener(this.mOnClickListener);
        this.alo.setEnabled(false);
        this.alp.addView(this.alo);
        this.aln = new Button(getContext());
        this.aln.setBackgroundDrawable(getContext().getResources().getDrawable(u.f.image_zoomin));
        this.aln.setLayoutParams(layoutParams2);
        this.aln.setOnClickListener(this.mOnClickListener);
        this.aln.setEnabled(false);
        this.alp.addView(this.aln);
        if (this.alv) {
            this.alp.setVisibility(8);
        }
        this.als = new i(getContext(), null, this.akw);
        setAdapter(this.als);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.alr = onPageChangeListener;
    }

    public int getItemNum() {
        return this.als.getCount();
    }

    public int getCurrentItem() {
        return this.alq.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aln.setEnabled(true);
            } else {
                this.aln.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.alo.setEnabled(true);
                return;
            } else {
                this.alo.setEnabled(false);
                return;
            }
        }
        this.alo.setEnabled(false);
        this.aln.setEnabled(false);
    }

    public void zC() {
        if (!this.alv) {
            this.alp.setVisibility(0);
        }
    }

    public void bf(boolean z) {
        this.alw = z;
        if (this.alq != null) {
            View findViewWithTag = this.alq.findViewWithTag(String.valueOf(this.alq.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bf(z);
            }
        }
    }

    public void zD() {
        if (!this.alv) {
            this.alp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.alq.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.alq.setPageMargin(i);
    }

    public void A(int i, int i2) {
        this.alq.setOffscreenPageLimit(i);
        this.alt = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.alt = (int) (this.alt * 0.8d);
        if (this.alt < 6291456) {
            this.alu = true;
            this.alt = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.alu = false;
        }
        PagerAdapter adapter = this.alq.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.alt);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.akv);
        this.alq.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.als);
        this.alq.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.als.setTempSize(i);
        this.als.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.als.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.als.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.als.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.als.setData(arrayList);
        this.als.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.als.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.als.setHasNext(z);
        this.als.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.als.getHasNext();
    }

    public void setNextTitle(String str) {
        this.als.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.alq.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.alq.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.akE = z;
        if (this.als != null) {
            this.als.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.als != null) {
            this.als.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.als != null) {
            this.als.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.als.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.als != null) {
            this.als.setOriImgSelectedCallback(bVar);
        }
    }
}
