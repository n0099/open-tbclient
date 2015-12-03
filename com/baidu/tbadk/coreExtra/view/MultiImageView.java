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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e alL;
    private a.d alM;
    private boolean alU;
    private Button amB;
    private Button amC;
    private LinearLayout amD;
    private i amE;
    private ViewPager.OnPageChangeListener amF;
    private j amG;
    private int amH;
    private boolean amI;
    private boolean amJ;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.amB = null;
        this.amC = null;
        this.amD = null;
        this.mOnClickListener = null;
        this.amE = null;
        this.mOnPageChangeListener = null;
        this.amF = null;
        this.alL = null;
        this.amG = null;
        this.alM = null;
        this.amH = 0;
        this.amI = true;
        this.amJ = false;
        this.alU = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.amE != null) {
            this.amE.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amB = null;
        this.amC = null;
        this.amD = null;
        this.mOnClickListener = null;
        this.amE = null;
        this.mOnPageChangeListener = null;
        this.amF = null;
        this.alL = null;
        this.amG = null;
        this.alM = null;
        this.amH = 0;
        this.amI = true;
        this.amJ = false;
        this.alU = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amB = null;
        this.amC = null;
        this.amD = null;
        this.mOnClickListener = null;
        this.amE = null;
        this.mOnPageChangeListener = null;
        this.amF = null;
        this.alL = null;
        this.amG = null;
        this.alM = null;
        this.amH = 0;
        this.amI = true;
        this.amJ = false;
        this.alU = false;
        init();
    }

    private void init() {
        this.amJ = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new t(this);
        this.mOnPageChangeListener = new u(this);
        this.alL = new v(this);
        this.alM = new w(this);
    }

    public void onResume() {
        if (this.amE.getCurrentView() != null) {
            if (this.amI) {
                int childCount = this.amE.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.amE.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != this.amE.getCurrentView()) {
                        ((z) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.amE.findViewWithTag(String.valueOf(this.amE.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof z)) {
                ((z) findViewWithTag).aY(this.alU);
            }
            this.amE.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.amE.getCurrentView() != null) {
            this.amE.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.amE != null) {
            int childCount = this.amE.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.amE.getChildAt(i);
                if (childAt != null && (childAt instanceof z)) {
                    ((z) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.amE = new i(getContext());
        this.amE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.amE.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.amE);
        this.amD = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.amD.setOrientation(0);
        this.amD.setLayoutParams(layoutParams);
        addView(this.amD);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.amC = new Button(getContext());
        this.amC.setBackgroundDrawable(getContext().getResources().getDrawable(n.e.image_zoomout));
        this.amC.setLayoutParams(layoutParams2);
        this.amC.setOnClickListener(this.mOnClickListener);
        this.amC.setEnabled(false);
        this.amD.addView(this.amC);
        this.amB = new Button(getContext());
        this.amB.setBackgroundDrawable(getContext().getResources().getDrawable(n.e.image_zoomin));
        this.amB.setLayoutParams(layoutParams2);
        this.amB.setOnClickListener(this.mOnClickListener);
        this.amB.setEnabled(false);
        this.amD.addView(this.amB);
        if (this.amJ) {
            this.amD.setVisibility(8);
        }
        this.amG = new j(getContext(), null, this.alM);
        setAdapter(this.amG);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.amF = onPageChangeListener;
    }

    public int getItemNum() {
        return this.amG.getCount();
    }

    public int getCurrentItem() {
        return this.amE.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.amB.setEnabled(true);
            } else {
                this.amB.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.amC.setEnabled(true);
                return;
            } else {
                this.amC.setEnabled(false);
                return;
            }
        }
        this.amC.setEnabled(false);
        this.amB.setEnabled(false);
    }

    public void zX() {
        if (!this.amJ) {
            this.amD.setVisibility(0);
        }
    }

    public void zY() {
        if (!this.amJ) {
            this.amD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.amE.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.amE.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.amE.setOffscreenPageLimit(i);
        this.amH = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.amH = (int) (this.amH * 0.8d);
        if (this.amH < 6291456) {
            this.amI = true;
            this.amH = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.amI = false;
        }
        PagerAdapter adapter = this.amE.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.amH);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.alL);
        this.amE.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.amE.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.amG.setTempSize(i);
        this.amG.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.amG.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.amG.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amG.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.amG.setData(arrayList);
        this.amG.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.amG.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.amG.setHasNext(z);
        this.amG.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.amG.getHasNext();
    }

    public void setNextTitle(String str) {
        this.amG.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.amE.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return com.baidu.tbadk.core.util.c.e(imageBitmap, 100);
        }
        return imageData;
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.amE.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.alU = z;
        if (this.amG != null) {
            this.amG.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.amG != null) {
            this.amG.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.amG != null) {
            this.amG.setHeadImage(z);
        }
    }

    public void a(j.a aVar) {
        this.amG.a(aVar);
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        if (this.amG != null) {
            this.amG.setOriImgSelectedCallback(bVar);
        }
    }
}
