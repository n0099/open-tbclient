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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e anK;
    private a.d anL;
    private boolean anT;
    private Button aoB;
    private Button aoC;
    private LinearLayout aoD;
    private h aoE;
    private ViewPager.OnPageChangeListener aoF;
    private i aoG;
    private int aoH;
    private boolean aoI;
    private boolean aoJ;
    private boolean aoK;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aoB = null;
        this.aoC = null;
        this.aoD = null;
        this.mOnClickListener = null;
        this.aoE = null;
        this.mOnPageChangeListener = null;
        this.aoF = null;
        this.anK = null;
        this.aoG = null;
        this.anL = null;
        this.aoH = 0;
        this.aoI = true;
        this.aoJ = false;
        this.anT = false;
        this.aoK = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aoE != null) {
            this.aoE.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aoB = null;
        this.aoC = null;
        this.aoD = null;
        this.mOnClickListener = null;
        this.aoE = null;
        this.mOnPageChangeListener = null;
        this.aoF = null;
        this.anK = null;
        this.aoG = null;
        this.anL = null;
        this.aoH = 0;
        this.aoI = true;
        this.aoJ = false;
        this.anT = false;
        this.aoK = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aoB = null;
        this.aoC = null;
        this.aoD = null;
        this.mOnClickListener = null;
        this.aoE = null;
        this.mOnPageChangeListener = null;
        this.aoF = null;
        this.anK = null;
        this.aoG = null;
        this.anL = null;
        this.aoH = 0;
        this.aoI = true;
        this.aoJ = false;
        this.anT = false;
        this.aoK = false;
        init();
    }

    private void init() {
        this.aoJ = UtilHelper.isSupportGesture(getContext());
        initEvent();
        qD();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.anK = new q(this);
        this.anL = new r(this);
    }

    public void db(int i) {
        if (this.mSkinType != i && this.aoE != null) {
            int childCount = this.aoE.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aoE.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aoE.getCurrentView() != null) {
            if (this.aoI) {
                int childCount = this.aoE.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aoE.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aoE.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aoE.findViewWithTag(String.valueOf(this.aoE.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).f(this.anT, true);
            }
            this.aoE.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aoE.getCurrentView() != null) {
            this.aoE.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aoE != null) {
            int childCount = this.aoE.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aoE.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void qD() {
        this.aoE = new h(getContext());
        this.aoE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aoE.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aoE);
        this.aoD = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aoD.setOrientation(0);
        this.aoD.setLayoutParams(layoutParams);
        addView(this.aoD);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aoC = new Button(getContext());
        this.aoC.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomout));
        this.aoC.setLayoutParams(layoutParams2);
        this.aoC.setOnClickListener(this.mOnClickListener);
        this.aoC.setEnabled(false);
        this.aoD.addView(this.aoC);
        this.aoB = new Button(getContext());
        this.aoB.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomin));
        this.aoB.setLayoutParams(layoutParams2);
        this.aoB.setOnClickListener(this.mOnClickListener);
        this.aoB.setEnabled(false);
        this.aoD.addView(this.aoB);
        if (this.aoJ) {
            this.aoD.setVisibility(8);
        }
        this.aoG = new i(getContext(), null, this.anL);
        setAdapter(this.aoG);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aoF = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aoG.getCount();
    }

    public int getCurrentItem() {
        return this.aoE.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aoB.setEnabled(true);
            } else {
                this.aoB.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aoC.setEnabled(true);
                return;
            } else {
                this.aoC.setEnabled(false);
                return;
            }
        }
        this.aoC.setEnabled(false);
        this.aoB.setEnabled(false);
    }

    public void AZ() {
        if (!this.aoJ) {
            this.aoD.setVisibility(0);
        }
    }

    public void aW(boolean z) {
        this.aoK = z;
        if (this.aoE != null) {
            View findViewWithTag = this.aoE.findViewWithTag(String.valueOf(this.aoE.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).aW(z);
            }
        }
    }

    public void Ba() {
        if (!this.aoJ) {
            this.aoD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aoE.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aoE.setPageMargin(i);
    }

    public void D(int i, int i2) {
        this.aoE.setOffscreenPageLimit(i);
        this.aoH = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aoH = (int) (this.aoH * 0.8d);
        if (this.aoH < 6291456) {
            this.aoI = true;
            this.aoH = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aoI = false;
        }
        PagerAdapter adapter = this.aoE.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aoH);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.anK);
        this.aoE.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aoG);
        this.aoE.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aoG.setTempSize(i);
        this.aoG.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoG.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aoG.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoG.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aoG.setData(arrayList);
        this.aoG.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aoG.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aoG.setHasNext(z);
        this.aoG.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aoG.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aoG.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aoE.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aoE.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.anT = z;
        if (this.aoG != null) {
            this.aoG.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aoG != null) {
            this.aoG.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aoG != null) {
            this.aoG.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aoG.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aoG != null) {
            this.aoG.setOriImgSelectedCallback(bVar);
        }
    }
}
