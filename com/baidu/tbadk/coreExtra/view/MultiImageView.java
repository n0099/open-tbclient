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
    private a.e ato;
    private a.d atp;
    private boolean atx;
    private Button auf;
    private Button aug;
    private LinearLayout auh;
    private h aui;
    private ViewPager.OnPageChangeListener auj;
    private i auk;
    private int aul;
    private boolean aum;
    private boolean aun;
    private boolean auo;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.auf = null;
        this.aug = null;
        this.auh = null;
        this.mOnClickListener = null;
        this.aui = null;
        this.mOnPageChangeListener = null;
        this.auj = null;
        this.ato = null;
        this.auk = null;
        this.atp = null;
        this.aul = 0;
        this.aum = true;
        this.aun = false;
        this.atx = false;
        this.auo = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aui != null) {
            this.aui.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.auf = null;
        this.aug = null;
        this.auh = null;
        this.mOnClickListener = null;
        this.aui = null;
        this.mOnPageChangeListener = null;
        this.auj = null;
        this.ato = null;
        this.auk = null;
        this.atp = null;
        this.aul = 0;
        this.aum = true;
        this.aun = false;
        this.atx = false;
        this.auo = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.auf = null;
        this.aug = null;
        this.auh = null;
        this.mOnClickListener = null;
        this.aui = null;
        this.mOnPageChangeListener = null;
        this.auj = null;
        this.ato = null;
        this.auk = null;
        this.atp = null;
        this.aul = 0;
        this.aum = true;
        this.aun = false;
        this.atx = false;
        this.auo = false;
        init();
    }

    private void init() {
        this.aun = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.ato = new q(this);
        this.atp = new r(this);
    }

    public void df(int i) {
        if (this.mSkinType != i && this.aui != null) {
            int childCount = this.aui.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aui.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aui.getCurrentView() != null) {
            if (this.aum) {
                int childCount = this.aui.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aui.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aui.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aui.findViewWithTag(String.valueOf(this.aui.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.atx, true);
            }
            this.aui.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aui.getCurrentView() != null) {
            this.aui.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aui != null) {
            int childCount = this.aui.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aui.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aui = new h(getContext());
        this.aui.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aui.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aui);
        this.auh = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.auh.setOrientation(0);
        this.auh.setLayoutParams(layoutParams);
        addView(this.auh);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aug = new Button(getContext());
        this.aug.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.aug.setLayoutParams(layoutParams2);
        this.aug.setOnClickListener(this.mOnClickListener);
        this.aug.setEnabled(false);
        this.auh.addView(this.aug);
        this.auf = new Button(getContext());
        this.auf.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.auf.setLayoutParams(layoutParams2);
        this.auf.setOnClickListener(this.mOnClickListener);
        this.auf.setEnabled(false);
        this.auh.addView(this.auf);
        if (this.aun) {
            this.auh.setVisibility(8);
        }
        this.auk = new i(getContext(), null, this.atp);
        setAdapter(this.auk);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.auj = onPageChangeListener;
    }

    public int getItemNum() {
        return this.auk.getCount();
    }

    public int getCurrentItem() {
        return this.aui.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.auf.setEnabled(true);
            } else {
                this.auf.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aug.setEnabled(true);
                return;
            } else {
                this.aug.setEnabled(false);
                return;
            }
        }
        this.aug.setEnabled(false);
        this.auf.setEnabled(false);
    }

    public void BB() {
        if (!this.aun) {
            this.auh.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.auo = z;
        if (this.aui != null) {
            View findViewWithTag = this.aui.findViewWithTag(String.valueOf(this.aui.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bo(z);
            }
        }
    }

    public void BC() {
        if (!this.aun) {
            this.auh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aui.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aui.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.aui.setOffscreenPageLimit(i);
        this.aul = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aul = (int) (this.aul * 0.8d);
        if (this.aul < 6291456) {
            this.aum = true;
            this.aul = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aum = false;
        }
        PagerAdapter adapter = this.aui.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aul);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.ato);
        this.aui.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.auk);
        this.aui.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.auk.setTempSize(i);
        this.auk.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.auk.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.auk.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auk.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.auk.setData(arrayList);
        this.auk.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auk.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.auk.setHasNext(z);
        this.auk.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.auk.getHasNext();
    }

    public void setNextTitle(String str) {
        this.auk.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aui.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aui.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.atx = z;
        if (this.auk != null) {
            this.auk.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.auk != null) {
            this.auk.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.auk != null) {
            this.auk.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.auk.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.auk != null) {
            this.auk.setOriImgSelectedCallback(bVar);
        }
    }
}
