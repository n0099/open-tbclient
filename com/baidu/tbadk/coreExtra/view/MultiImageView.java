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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean aoE;
    private a.e aov;
    private a.d aow;
    private Button apm;
    private Button apn;
    private LinearLayout apo;
    private h apq;
    private ViewPager.OnPageChangeListener apr;
    private i aps;
    private int apt;
    private boolean apu;
    private boolean apv;
    private boolean apw;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.apm = null;
        this.apn = null;
        this.apo = null;
        this.mOnClickListener = null;
        this.apq = null;
        this.mOnPageChangeListener = null;
        this.apr = null;
        this.aov = null;
        this.aps = null;
        this.aow = null;
        this.apt = 0;
        this.apu = true;
        this.apv = false;
        this.aoE = false;
        this.apw = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.apq != null) {
            this.apq.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.apm = null;
        this.apn = null;
        this.apo = null;
        this.mOnClickListener = null;
        this.apq = null;
        this.mOnPageChangeListener = null;
        this.apr = null;
        this.aov = null;
        this.aps = null;
        this.aow = null;
        this.apt = 0;
        this.apu = true;
        this.apv = false;
        this.aoE = false;
        this.apw = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.apm = null;
        this.apn = null;
        this.apo = null;
        this.mOnClickListener = null;
        this.apq = null;
        this.mOnPageChangeListener = null;
        this.apr = null;
        this.aov = null;
        this.aps = null;
        this.aow = null;
        this.apt = 0;
        this.apu = true;
        this.apv = false;
        this.aoE = false;
        this.apw = false;
        init();
    }

    private void init() {
        this.apv = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.aov = new q(this);
        this.aow = new r(this);
    }

    public void df(int i) {
        if (this.mSkinType != i && this.apq != null) {
            int childCount = this.apq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.apq.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.apq.getCurrentView() != null) {
            if (this.apu) {
                int childCount = this.apq.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.apq.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.apq.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.apq.findViewWithTag(String.valueOf(this.apq.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.aoE, true);
            }
            this.apq.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.apq.getCurrentView() != null) {
            this.apq.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.apq != null) {
            int childCount = this.apq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.apq.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.apq = new h(getContext());
        this.apq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.apq.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.apq);
        this.apo = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.apo.setOrientation(0);
        this.apo.setLayoutParams(layoutParams);
        addView(this.apo);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.apn = new Button(getContext());
        this.apn.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomout));
        this.apn.setLayoutParams(layoutParams2);
        this.apn.setOnClickListener(this.mOnClickListener);
        this.apn.setEnabled(false);
        this.apo.addView(this.apn);
        this.apm = new Button(getContext());
        this.apm.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomin));
        this.apm.setLayoutParams(layoutParams2);
        this.apm.setOnClickListener(this.mOnClickListener);
        this.apm.setEnabled(false);
        this.apo.addView(this.apm);
        if (this.apv) {
            this.apo.setVisibility(8);
        }
        this.aps = new i(getContext(), null, this.aow);
        setAdapter(this.aps);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.apr = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aps.getCount();
    }

    public int getCurrentItem() {
        return this.apq.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.apm.setEnabled(true);
            } else {
                this.apm.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.apn.setEnabled(true);
                return;
            } else {
                this.apn.setEnabled(false);
                return;
            }
        }
        this.apn.setEnabled(false);
        this.apm.setEnabled(false);
    }

    public void AO() {
        if (!this.apv) {
            this.apo.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.apw = z;
        if (this.apq != null) {
            View findViewWithTag = this.apq.findViewWithTag(String.valueOf(this.apq.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bn(z);
            }
        }
    }

    public void AP() {
        if (!this.apv) {
            this.apo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.apq.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.apq.setPageMargin(i);
    }

    public void C(int i, int i2) {
        this.apq.setOffscreenPageLimit(i);
        this.apt = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.apt = (int) (this.apt * 0.8d);
        if (this.apt < 6291456) {
            this.apu = true;
            this.apt = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.apu = false;
        }
        PagerAdapter adapter = this.apq.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.apt);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.aov);
        this.apq.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aps);
        this.apq.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aps.setTempSize(i);
        this.aps.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aps.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aps.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aps.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aps.setData(arrayList);
        this.aps.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aps.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aps.setHasNext(z);
        this.aps.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aps.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aps.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.apq.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.apq.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoE = z;
        if (this.aps != null) {
            this.aps.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aps != null) {
            this.aps.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aps != null) {
            this.aps.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aps.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aps != null) {
            this.aps.setOriImgSelectedCallback(bVar);
        }
    }
}
