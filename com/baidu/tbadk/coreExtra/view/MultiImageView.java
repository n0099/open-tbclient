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
    private Button aoS;
    private Button aoT;
    private LinearLayout aoU;
    private h aoV;
    private ViewPager.OnPageChangeListener aoW;
    private i aoX;
    private int aoY;
    private boolean aoZ;
    private a.e aob;
    private a.d aoc;
    private boolean aok;
    private boolean apa;
    private boolean apb;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aoS = null;
        this.aoT = null;
        this.aoU = null;
        this.mOnClickListener = null;
        this.aoV = null;
        this.mOnPageChangeListener = null;
        this.aoW = null;
        this.aob = null;
        this.aoX = null;
        this.aoc = null;
        this.aoY = 0;
        this.aoZ = true;
        this.apa = false;
        this.aok = false;
        this.apb = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aoV != null) {
            this.aoV.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aoS = null;
        this.aoT = null;
        this.aoU = null;
        this.mOnClickListener = null;
        this.aoV = null;
        this.mOnPageChangeListener = null;
        this.aoW = null;
        this.aob = null;
        this.aoX = null;
        this.aoc = null;
        this.aoY = 0;
        this.aoZ = true;
        this.apa = false;
        this.aok = false;
        this.apb = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aoS = null;
        this.aoT = null;
        this.aoU = null;
        this.mOnClickListener = null;
        this.aoV = null;
        this.mOnPageChangeListener = null;
        this.aoW = null;
        this.aob = null;
        this.aoX = null;
        this.aoc = null;
        this.aoY = 0;
        this.aoZ = true;
        this.apa = false;
        this.aok = false;
        this.apb = false;
        init();
    }

    private void init() {
        this.apa = UtilHelper.isSupportGesture(getContext());
        initEvent();
        pU();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.aob = new q(this);
        this.aoc = new r(this);
    }

    public void de(int i) {
        if (this.mSkinType != i && this.aoV != null) {
            int childCount = this.aoV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aoV.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aoV.getCurrentView() != null) {
            if (this.aoZ) {
                int childCount = this.aoV.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aoV.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aoV.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aoV.findViewWithTag(String.valueOf(this.aoV.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).e(this.aok, true);
            }
            this.aoV.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aoV.getCurrentView() != null) {
            this.aoV.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aoV != null) {
            int childCount = this.aoV.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aoV.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void pU() {
        this.aoV = new h(getContext());
        this.aoV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aoV.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aoV);
        this.aoU = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aoU.setOrientation(0);
        this.aoU.setLayoutParams(layoutParams);
        addView(this.aoU);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aoT = new Button(getContext());
        this.aoT.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomout));
        this.aoT.setLayoutParams(layoutParams2);
        this.aoT.setOnClickListener(this.mOnClickListener);
        this.aoT.setEnabled(false);
        this.aoU.addView(this.aoT);
        this.aoS = new Button(getContext());
        this.aoS.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomin));
        this.aoS.setLayoutParams(layoutParams2);
        this.aoS.setOnClickListener(this.mOnClickListener);
        this.aoS.setEnabled(false);
        this.aoU.addView(this.aoS);
        if (this.apa) {
            this.aoU.setVisibility(8);
        }
        this.aoX = new i(getContext(), null, this.aoc);
        setAdapter(this.aoX);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aoW = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aoX.getCount();
    }

    public int getCurrentItem() {
        return this.aoV.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aoS.setEnabled(true);
            } else {
                this.aoS.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aoT.setEnabled(true);
                return;
            } else {
                this.aoT.setEnabled(false);
                return;
            }
        }
        this.aoT.setEnabled(false);
        this.aoS.setEnabled(false);
    }

    public void BC() {
        if (!this.apa) {
            this.aoU.setVisibility(0);
        }
    }

    public void bc(boolean z) {
        this.apb = z;
        if (this.aoV != null) {
            View findViewWithTag = this.aoV.findViewWithTag(String.valueOf(this.aoV.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bc(z);
            }
        }
    }

    public void BD() {
        if (!this.apa) {
            this.aoU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aoV.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aoV.setPageMargin(i);
    }

    public void A(int i, int i2) {
        this.aoV.setOffscreenPageLimit(i);
        this.aoY = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aoY = (int) (this.aoY * 0.8d);
        if (this.aoY < 6291456) {
            this.aoZ = true;
            this.aoY = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aoZ = false;
        }
        PagerAdapter adapter = this.aoV.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aoY);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.aob);
        this.aoV.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aoX);
        this.aoV.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aoX.setTempSize(i);
        this.aoX.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoX.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aoX.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoX.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aoX.setData(arrayList);
        this.aoX.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aoX.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aoX.setHasNext(z);
        this.aoX.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aoX.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aoX.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aoV.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aoV.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aok = z;
        if (this.aoX != null) {
            this.aoX.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aoX != null) {
            this.aoX.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aoX != null) {
            this.aoX.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aoX.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aoX != null) {
            this.aoX.setOriImgSelectedCallback(bVar);
        }
    }
}
