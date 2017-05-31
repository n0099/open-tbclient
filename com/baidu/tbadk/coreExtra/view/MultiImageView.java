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
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private Button atT;
    private Button atU;
    private LinearLayout atV;
    private h atW;
    private ViewPager.OnPageChangeListener atX;
    private i atY;
    private int atZ;
    private b.e atc;
    private b.d atd;
    private boolean atl;
    private boolean aua;
    private boolean aub;
    private boolean auc;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.atT = null;
        this.atU = null;
        this.atV = null;
        this.mOnClickListener = null;
        this.atW = null;
        this.mOnPageChangeListener = null;
        this.atX = null;
        this.atc = null;
        this.atY = null;
        this.atd = null;
        this.atZ = 0;
        this.aua = true;
        this.aub = false;
        this.atl = false;
        this.auc = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.atW != null) {
            this.atW.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.atT = null;
        this.atU = null;
        this.atV = null;
        this.mOnClickListener = null;
        this.atW = null;
        this.mOnPageChangeListener = null;
        this.atX = null;
        this.atc = null;
        this.atY = null;
        this.atd = null;
        this.atZ = 0;
        this.aua = true;
        this.aub = false;
        this.atl = false;
        this.auc = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.atT = null;
        this.atU = null;
        this.atV = null;
        this.mOnClickListener = null;
        this.atW = null;
        this.mOnPageChangeListener = null;
        this.atX = null;
        this.atc = null;
        this.atY = null;
        this.atd = null;
        this.atZ = 0;
        this.aua = true;
        this.aub = false;
        this.atl = false;
        this.auc = false;
        init();
    }

    private void init() {
        this.aub = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.atc = new q(this);
        this.atd = new r(this);
    }

    public void dc(int i) {
        if (this.mSkinType != i && this.atW != null) {
            int childCount = this.atW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.atW.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.atW.getCurrentView() != null) {
            if (this.aua) {
                int childCount = this.atW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.atW.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.atW.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.atW.findViewWithTag(String.valueOf(this.atW.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.atl, true);
            }
            this.atW.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.atW.getCurrentView() != null) {
            this.atW.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.atW != null) {
            int childCount = this.atW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.atW.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.atW = new h(getContext());
        this.atW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.atW.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.atW);
        this.atV = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.atV.setOrientation(0);
        this.atV.setLayoutParams(layoutParams);
        addView(this.atV);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.atU = new Button(getContext());
        this.atU.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.atU.setLayoutParams(layoutParams2);
        this.atU.setOnClickListener(this.mOnClickListener);
        this.atU.setEnabled(false);
        this.atV.addView(this.atU);
        this.atT = new Button(getContext());
        this.atT.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.atT.setLayoutParams(layoutParams2);
        this.atT.setOnClickListener(this.mOnClickListener);
        this.atT.setEnabled(false);
        this.atV.addView(this.atT);
        if (this.aub) {
            this.atV.setVisibility(8);
        }
        this.atY = new i(getContext(), null, this.atd);
        setAdapter(this.atY);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atX = onPageChangeListener;
    }

    public int getItemNum() {
        return this.atY.getCount();
    }

    public int getCurrentItem() {
        return this.atW.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            if (bVar.canZoomIn()) {
                this.atT.setEnabled(true);
            } else {
                this.atT.setEnabled(false);
            }
            if (bVar.canZoomOut()) {
                this.atU.setEnabled(true);
                return;
            } else {
                this.atU.setEnabled(false);
                return;
            }
        }
        this.atU.setEnabled(false);
        this.atT.setEnabled(false);
    }

    public void AF() {
        if (!this.aub) {
            this.atV.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.auc = z;
        if (this.atW != null) {
            View findViewWithTag = this.atW.findViewWithTag(String.valueOf(this.atW.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bl(z);
            }
        }
    }

    public void AG() {
        if (!this.aub) {
            this.atV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.b getCurrentImageView() {
        return this.atW.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.atW.setPageMargin(i);
    }

    public void I(int i, int i2) {
        this.atW.setOffscreenPageLimit(i);
        this.atZ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.atZ = (int) (this.atZ * 0.8d);
        if (this.atZ < 6291456) {
            this.aua = true;
            this.atZ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aua = false;
        }
        PagerAdapter adapter = this.atW.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.atZ);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.atc);
        this.atW.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.atY);
        this.atW.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.atY.setTempSize(i);
        this.atY.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.atY.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.atY.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atY.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.atY.setData(arrayList);
        this.atY.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.atY.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.atY.setHasNext(z);
        this.atY.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.atY.getHasNext();
    }

    public void setNextTitle(String str) {
        this.atY.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.b selectedView = this.atW.getSelectedView();
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
        com.baidu.tbadk.widget.b selectedView = this.atW.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.atl = z;
        if (this.atY != null) {
            this.atY.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.atY != null) {
            this.atY.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.atY != null) {
            this.atY.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.atY.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.atY != null) {
            this.atY.setOriImgSelectedCallback(bVar);
        }
    }
}
