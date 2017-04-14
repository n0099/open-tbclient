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
    private a.e atm;
    private a.d atn;
    private boolean atv;
    private Button aud;
    private Button aue;
    private LinearLayout auf;
    private h aug;
    private ViewPager.OnPageChangeListener auh;
    private i aui;
    private int auj;
    private boolean auk;
    private boolean aul;
    private boolean aum;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aud = null;
        this.aue = null;
        this.auf = null;
        this.mOnClickListener = null;
        this.aug = null;
        this.mOnPageChangeListener = null;
        this.auh = null;
        this.atm = null;
        this.aui = null;
        this.atn = null;
        this.auj = 0;
        this.auk = true;
        this.aul = false;
        this.atv = false;
        this.aum = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aug != null) {
            this.aug.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aud = null;
        this.aue = null;
        this.auf = null;
        this.mOnClickListener = null;
        this.aug = null;
        this.mOnPageChangeListener = null;
        this.auh = null;
        this.atm = null;
        this.aui = null;
        this.atn = null;
        this.auj = 0;
        this.auk = true;
        this.aul = false;
        this.atv = false;
        this.aum = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aud = null;
        this.aue = null;
        this.auf = null;
        this.mOnClickListener = null;
        this.aug = null;
        this.mOnPageChangeListener = null;
        this.auh = null;
        this.atm = null;
        this.aui = null;
        this.atn = null;
        this.auj = 0;
        this.auk = true;
        this.aul = false;
        this.atv = false;
        this.aum = false;
        init();
    }

    private void init() {
        this.aul = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.atm = new q(this);
        this.atn = new r(this);
    }

    public void df(int i) {
        if (this.mSkinType != i && this.aug != null) {
            int childCount = this.aug.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aug.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aug.getCurrentView() != null) {
            if (this.auk) {
                int childCount = this.aug.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aug.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aug.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aug.findViewWithTag(String.valueOf(this.aug.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.atv, true);
            }
            this.aug.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aug.getCurrentView() != null) {
            this.aug.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aug != null) {
            int childCount = this.aug.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aug.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aug = new h(getContext());
        this.aug.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aug.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aug);
        this.auf = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.auf.setOrientation(0);
        this.auf.setLayoutParams(layoutParams);
        addView(this.auf);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aue = new Button(getContext());
        this.aue.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.aue.setLayoutParams(layoutParams2);
        this.aue.setOnClickListener(this.mOnClickListener);
        this.aue.setEnabled(false);
        this.auf.addView(this.aue);
        this.aud = new Button(getContext());
        this.aud.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.aud.setLayoutParams(layoutParams2);
        this.aud.setOnClickListener(this.mOnClickListener);
        this.aud.setEnabled(false);
        this.auf.addView(this.aud);
        if (this.aul) {
            this.auf.setVisibility(8);
        }
        this.aui = new i(getContext(), null, this.atn);
        setAdapter(this.aui);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.auh = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aui.getCount();
    }

    public int getCurrentItem() {
        return this.aug.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aud.setEnabled(true);
            } else {
                this.aud.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aue.setEnabled(true);
                return;
            } else {
                this.aue.setEnabled(false);
                return;
            }
        }
        this.aue.setEnabled(false);
        this.aud.setEnabled(false);
    }

    public void BB() {
        if (!this.aul) {
            this.auf.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.aum = z;
        if (this.aug != null) {
            View findViewWithTag = this.aug.findViewWithTag(String.valueOf(this.aug.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bo(z);
            }
        }
    }

    public void BC() {
        if (!this.aul) {
            this.auf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aug.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aug.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.aug.setOffscreenPageLimit(i);
        this.auj = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.auj = (int) (this.auj * 0.8d);
        if (this.auj < 6291456) {
            this.auk = true;
            this.auj = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.auk = false;
        }
        PagerAdapter adapter = this.aug.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.auj);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.atm);
        this.aug.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aui);
        this.aug.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aui.setTempSize(i);
        this.aui.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aui.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aui.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aui.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aui.setData(arrayList);
        this.aui.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aui.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aui.setHasNext(z);
        this.aui.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aui.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aui.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aug.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aug.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.atv = z;
        if (this.aui != null) {
            this.aui.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aui != null) {
            this.aui.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aui != null) {
            this.aui.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aui.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aui != null) {
            this.aui.setOriImgSelectedCallback(bVar);
        }
    }
}
