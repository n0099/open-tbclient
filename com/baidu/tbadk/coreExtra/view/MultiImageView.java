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
    private a.e ajP;
    private a.d ajQ;
    private boolean ajY;
    private Button akG;
    private Button akH;
    private LinearLayout akI;
    private h akJ;
    private ViewPager.OnPageChangeListener akK;
    private i akL;
    private int akM;
    private boolean akN;
    private boolean akO;
    private boolean akP;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.akG = null;
        this.akH = null;
        this.akI = null;
        this.mOnClickListener = null;
        this.akJ = null;
        this.mOnPageChangeListener = null;
        this.akK = null;
        this.ajP = null;
        this.akL = null;
        this.ajQ = null;
        this.akM = 0;
        this.akN = true;
        this.akO = false;
        this.ajY = false;
        this.akP = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.akJ != null) {
            this.akJ.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.akG = null;
        this.akH = null;
        this.akI = null;
        this.mOnClickListener = null;
        this.akJ = null;
        this.mOnPageChangeListener = null;
        this.akK = null;
        this.ajP = null;
        this.akL = null;
        this.ajQ = null;
        this.akM = 0;
        this.akN = true;
        this.akO = false;
        this.ajY = false;
        this.akP = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.akG = null;
        this.akH = null;
        this.akI = null;
        this.mOnClickListener = null;
        this.akJ = null;
        this.mOnPageChangeListener = null;
        this.akK = null;
        this.ajP = null;
        this.akL = null;
        this.ajQ = null;
        this.akM = 0;
        this.akN = true;
        this.akO = false;
        this.ajY = false;
        this.akP = false;
        init();
    }

    private void init() {
        this.akO = UtilHelper.isSupportGesture(getContext());
        initEvent();
        nq();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.ajP = new q(this);
        this.ajQ = new r(this);
    }

    public void cM(int i) {
        if (this.mSkinType != i && this.akJ != null) {
            int childCount = this.akJ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.akJ.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.akJ.getCurrentView() != null) {
            if (this.akN) {
                int childCount = this.akJ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.akJ.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.akJ.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.akJ.findViewWithTag(String.valueOf(this.akJ.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).e(this.ajY, true);
            }
            this.akJ.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.akJ.getCurrentView() != null) {
            this.akJ.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.akJ != null) {
            int childCount = this.akJ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.akJ.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void nq() {
        this.akJ = new h(getContext());
        this.akJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.akJ.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.akJ);
        this.akI = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.akI.setOrientation(0);
        this.akI.setLayoutParams(layoutParams);
        addView(this.akI);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.akH = new Button(getContext());
        this.akH.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomout));
        this.akH.setLayoutParams(layoutParams2);
        this.akH.setOnClickListener(this.mOnClickListener);
        this.akH.setEnabled(false);
        this.akI.addView(this.akH);
        this.akG = new Button(getContext());
        this.akG.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomin));
        this.akG.setLayoutParams(layoutParams2);
        this.akG.setOnClickListener(this.mOnClickListener);
        this.akG.setEnabled(false);
        this.akI.addView(this.akG);
        if (this.akO) {
            this.akI.setVisibility(8);
        }
        this.akL = new i(getContext(), null, this.ajQ);
        setAdapter(this.akL);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.akK = onPageChangeListener;
    }

    public int getItemNum() {
        return this.akL.getCount();
    }

    public int getCurrentItem() {
        return this.akJ.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.akG.setEnabled(true);
            } else {
                this.akG.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.akH.setEnabled(true);
                return;
            } else {
                this.akH.setEnabled(false);
                return;
            }
        }
        this.akH.setEnabled(false);
        this.akG.setEnabled(false);
    }

    public void zx() {
        if (!this.akO) {
            this.akI.setVisibility(0);
        }
    }

    public void bi(boolean z) {
        this.akP = z;
        if (this.akJ != null) {
            View findViewWithTag = this.akJ.findViewWithTag(String.valueOf(this.akJ.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bi(z);
            }
        }
    }

    public void zy() {
        if (!this.akO) {
            this.akI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.akJ.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.akJ.setPageMargin(i);
    }

    public void A(int i, int i2) {
        this.akJ.setOffscreenPageLimit(i);
        this.akM = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.akM = (int) (this.akM * 0.8d);
        if (this.akM < 6291456) {
            this.akN = true;
            this.akM = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.akN = false;
        }
        PagerAdapter adapter = this.akJ.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.akM);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.ajP);
        this.akJ.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.akL);
        this.akJ.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.akL.setTempSize(i);
        this.akL.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akL.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.akL.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akL.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.akL.setData(arrayList);
        this.akL.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.akL.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.akL.setHasNext(z);
        this.akL.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.akL.getHasNext();
    }

    public void setNextTitle(String str) {
        this.akL.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.akJ.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.akJ.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.ajY = z;
        if (this.akL != null) {
            this.akL.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.akL != null) {
            this.akL.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.akL != null) {
            this.akL.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.akL.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.akL != null) {
            this.akL.setOriImgSelectedCallback(bVar);
        }
    }
}
