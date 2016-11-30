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
    private a.e aoT;
    private a.d aoU;
    private Button apL;
    private Button apM;
    private LinearLayout apN;
    private h apO;
    private ViewPager.OnPageChangeListener apP;
    private i apQ;
    private int apR;
    private boolean apS;
    private boolean apT;
    private boolean apU;
    private boolean apc;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.apL = null;
        this.apM = null;
        this.apN = null;
        this.mOnClickListener = null;
        this.apO = null;
        this.mOnPageChangeListener = null;
        this.apP = null;
        this.aoT = null;
        this.apQ = null;
        this.aoU = null;
        this.apR = 0;
        this.apS = true;
        this.apT = false;
        this.apc = false;
        this.apU = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.apO != null) {
            this.apO.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.apL = null;
        this.apM = null;
        this.apN = null;
        this.mOnClickListener = null;
        this.apO = null;
        this.mOnPageChangeListener = null;
        this.apP = null;
        this.aoT = null;
        this.apQ = null;
        this.aoU = null;
        this.apR = 0;
        this.apS = true;
        this.apT = false;
        this.apc = false;
        this.apU = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.apL = null;
        this.apM = null;
        this.apN = null;
        this.mOnClickListener = null;
        this.apO = null;
        this.mOnPageChangeListener = null;
        this.apP = null;
        this.aoT = null;
        this.apQ = null;
        this.aoU = null;
        this.apR = 0;
        this.apS = true;
        this.apT = false;
        this.apc = false;
        this.apU = false;
        init();
    }

    private void init() {
        this.apT = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.aoT = new q(this);
        this.aoU = new r(this);
    }

    public void dd(int i) {
        if (this.mSkinType != i && this.apO != null) {
            int childCount = this.apO.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.apO.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.apO.getCurrentView() != null) {
            if (this.apS) {
                int childCount = this.apO.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.apO.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.apO.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.apO.findViewWithTag(String.valueOf(this.apO.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.apc, true);
            }
            this.apO.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.apO.getCurrentView() != null) {
            this.apO.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.apO != null) {
            int childCount = this.apO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.apO.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.apO = new h(getContext());
        this.apO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.apO.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.apO);
        this.apN = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.apN.setOrientation(0);
        this.apN.setLayoutParams(layoutParams);
        addView(this.apN);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.apM = new Button(getContext());
        this.apM.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomout));
        this.apM.setLayoutParams(layoutParams2);
        this.apM.setOnClickListener(this.mOnClickListener);
        this.apM.setEnabled(false);
        this.apN.addView(this.apM);
        this.apL = new Button(getContext());
        this.apL.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomin));
        this.apL.setLayoutParams(layoutParams2);
        this.apL.setOnClickListener(this.mOnClickListener);
        this.apL.setEnabled(false);
        this.apN.addView(this.apL);
        if (this.apT) {
            this.apN.setVisibility(8);
        }
        this.apQ = new i(getContext(), null, this.aoU);
        setAdapter(this.apQ);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.apP = onPageChangeListener;
    }

    public int getItemNum() {
        return this.apQ.getCount();
    }

    public int getCurrentItem() {
        return this.apO.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.apL.setEnabled(true);
            } else {
                this.apL.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.apM.setEnabled(true);
                return;
            } else {
                this.apM.setEnabled(false);
                return;
            }
        }
        this.apM.setEnabled(false);
        this.apL.setEnabled(false);
    }

    public void Bb() {
        if (!this.apT) {
            this.apN.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.apU = z;
        if (this.apO != null) {
            View findViewWithTag = this.apO.findViewWithTag(String.valueOf(this.apO.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bn(z);
            }
        }
    }

    public void Bc() {
        if (!this.apT) {
            this.apN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.apO.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.apO.setPageMargin(i);
    }

    public void C(int i, int i2) {
        this.apO.setOffscreenPageLimit(i);
        this.apR = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.apR = (int) (this.apR * 0.8d);
        if (this.apR < 6291456) {
            this.apS = true;
            this.apR = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.apS = false;
        }
        PagerAdapter adapter = this.apO.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.apR);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.aoT);
        this.apO.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.apQ);
        this.apO.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.apQ.setTempSize(i);
        this.apQ.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.apQ.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.apQ.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.apQ.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.apQ.setData(arrayList);
        this.apQ.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.apQ.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.apQ.setHasNext(z);
        this.apQ.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.apQ.getHasNext();
    }

    public void setNextTitle(String str) {
        this.apQ.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.apO.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.apO.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.apc = z;
        if (this.apQ != null) {
            this.apQ.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.apQ != null) {
            this.apQ.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.apQ != null) {
            this.apQ.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.apQ.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.apQ != null) {
            this.apQ.setOriImgSelectedCallback(bVar);
        }
    }
}
