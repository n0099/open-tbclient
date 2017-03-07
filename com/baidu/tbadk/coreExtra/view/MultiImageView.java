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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e asW;
    private a.d asX;
    private Button atN;
    private Button atO;
    private LinearLayout atP;
    private h atQ;
    private ViewPager.OnPageChangeListener atR;
    private i atS;
    private int atT;
    private boolean atU;
    private boolean atV;
    private boolean atW;
    private boolean atf;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.atN = null;
        this.atO = null;
        this.atP = null;
        this.mOnClickListener = null;
        this.atQ = null;
        this.mOnPageChangeListener = null;
        this.atR = null;
        this.asW = null;
        this.atS = null;
        this.asX = null;
        this.atT = 0;
        this.atU = true;
        this.atV = false;
        this.atf = false;
        this.atW = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.atQ != null) {
            this.atQ.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.atN = null;
        this.atO = null;
        this.atP = null;
        this.mOnClickListener = null;
        this.atQ = null;
        this.mOnPageChangeListener = null;
        this.atR = null;
        this.asW = null;
        this.atS = null;
        this.asX = null;
        this.atT = 0;
        this.atU = true;
        this.atV = false;
        this.atf = false;
        this.atW = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.atN = null;
        this.atO = null;
        this.atP = null;
        this.mOnClickListener = null;
        this.atQ = null;
        this.mOnPageChangeListener = null;
        this.atR = null;
        this.asW = null;
        this.atS = null;
        this.asX = null;
        this.atT = 0;
        this.atU = true;
        this.atV = false;
        this.atf = false;
        this.atW = false;
        init();
    }

    private void init() {
        this.atV = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.asW = new q(this);
        this.asX = new r(this);
    }

    public void dc(int i) {
        if (this.mSkinType != i && this.atQ != null) {
            int childCount = this.atQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.atQ.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.atQ.getCurrentView() != null) {
            if (this.atU) {
                int childCount = this.atQ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.atQ.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.atQ.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.atQ.findViewWithTag(String.valueOf(this.atQ.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.atf, true);
            }
            this.atQ.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.atQ.getCurrentView() != null) {
            this.atQ.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.atQ != null) {
            int childCount = this.atQ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.atQ.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.atQ = new h(getContext());
        this.atQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.atQ.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.atQ);
        this.atP = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.atP.setOrientation(0);
        this.atP.setLayoutParams(layoutParams);
        addView(this.atP);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.atO = new Button(getContext());
        this.atO.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.atO.setLayoutParams(layoutParams2);
        this.atO.setOnClickListener(this.mOnClickListener);
        this.atO.setEnabled(false);
        this.atP.addView(this.atO);
        this.atN = new Button(getContext());
        this.atN.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.atN.setLayoutParams(layoutParams2);
        this.atN.setOnClickListener(this.mOnClickListener);
        this.atN.setEnabled(false);
        this.atP.addView(this.atN);
        if (this.atV) {
            this.atP.setVisibility(8);
        }
        this.atS = new i(getContext(), null, this.asX);
        setAdapter(this.atS);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atR = onPageChangeListener;
    }

    public int getItemNum() {
        return this.atS.getCount();
    }

    public int getCurrentItem() {
        return this.atQ.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.atN.setEnabled(true);
            } else {
                this.atN.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.atO.setEnabled(true);
                return;
            } else {
                this.atO.setEnabled(false);
                return;
            }
        }
        this.atO.setEnabled(false);
        this.atN.setEnabled(false);
    }

    public void Bc() {
        if (!this.atV) {
            this.atP.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.atW = z;
        if (this.atQ != null) {
            View findViewWithTag = this.atQ.findViewWithTag(String.valueOf(this.atQ.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bm(z);
            }
        }
    }

    public void Bd() {
        if (!this.atV) {
            this.atP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.atQ.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.atQ.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.atQ.setOffscreenPageLimit(i);
        this.atT = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.atT = (int) (this.atT * 0.8d);
        if (this.atT < 6291456) {
            this.atU = true;
            this.atT = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.atU = false;
        }
        PagerAdapter adapter = this.atQ.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.atT);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.asW);
        this.atQ.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.atS);
        this.atQ.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.atS.setTempSize(i);
        this.atS.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.atS.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.atS.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atS.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.atS.setData(arrayList);
        this.atS.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.atS.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.atS.setHasNext(z);
        this.atS.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.atS.getHasNext();
    }

    public void setNextTitle(String str) {
        this.atS.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.atQ.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.atQ.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.atf = z;
        if (this.atS != null) {
            this.atS.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.atS != null) {
            this.atS.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.atS != null) {
            this.atS.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.atS.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.atS != null) {
            this.atS.setOriImgSelectedCallback(bVar);
        }
    }
}
