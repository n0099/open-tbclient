package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
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
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e alc;
    private a.d ald;
    private boolean alj;
    private Button amh;
    private Button ami;
    private LinearLayout amj;
    private i amk;
    private ViewPager.OnPageChangeListener aml;
    private j amm;
    private int amn;
    private boolean amo;
    private boolean amp;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.amh = null;
        this.ami = null;
        this.amj = null;
        this.mOnClickListener = null;
        this.amk = null;
        this.mOnPageChangeListener = null;
        this.aml = null;
        this.alc = null;
        this.amm = null;
        this.ald = null;
        this.amn = 0;
        this.amo = true;
        this.amp = false;
        this.alj = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.amk != null) {
            this.amk.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = null;
        this.ami = null;
        this.amj = null;
        this.mOnClickListener = null;
        this.amk = null;
        this.mOnPageChangeListener = null;
        this.aml = null;
        this.alc = null;
        this.amm = null;
        this.ald = null;
        this.amn = 0;
        this.amo = true;
        this.amp = false;
        this.alj = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amh = null;
        this.ami = null;
        this.amj = null;
        this.mOnClickListener = null;
        this.amk = null;
        this.mOnPageChangeListener = null;
        this.aml = null;
        this.alc = null;
        this.amm = null;
        this.ald = null;
        this.amn = 0;
        this.amo = true;
        this.amp = false;
        this.alj = false;
        init();
    }

    private void init() {
        this.amp = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new u(this);
        this.mOnPageChangeListener = new v(this);
        this.alc = new w(this);
        this.ald = new x(this);
    }

    public void onResume() {
        if (this.amk.getCurrentView() != null) {
            if (this.amo) {
                int childCount = this.amk.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.amk.getChildAt(i);
                    if (childAt != null && (childAt instanceof ab) && ((ab) childAt).getImageView() != this.amk.getCurrentView()) {
                        ((ab) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.amk.findViewWithTag(String.valueOf(this.amk.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ab)) {
                ((ab) findViewWithTag).aZ(this.alj);
            }
            this.amk.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.amk.getCurrentView() != null) {
            this.amk.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.amk != null) {
            int childCount = this.amk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.amk.getChildAt(i);
                if (childAt != null && (childAt instanceof ab)) {
                    ((ab) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.amk = new i(getContext());
        this.amk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.amk.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.amk);
        this.amj = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.amj.setOrientation(0);
        this.amj.setLayoutParams(layoutParams);
        addView(this.amj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ami = new Button(getContext());
        this.ami.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomout));
        this.ami.setLayoutParams(layoutParams2);
        this.ami.setOnClickListener(this.mOnClickListener);
        this.ami.setEnabled(false);
        this.amj.addView(this.ami);
        this.amh = new Button(getContext());
        this.amh.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomin));
        this.amh.setLayoutParams(layoutParams2);
        this.amh.setOnClickListener(this.mOnClickListener);
        this.amh.setEnabled(false);
        this.amj.addView(this.amh);
        if (this.amp) {
            this.amj.setVisibility(8);
        }
        this.amm = new j(getContext(), null, this.ald);
        setAdapter(this.amm);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aml = onPageChangeListener;
    }

    public int getItemNum() {
        return this.amm.getCount();
    }

    public int getCurrentItem() {
        return this.amk.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.amh.setEnabled(true);
            } else {
                this.amh.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.ami.setEnabled(true);
                return;
            } else {
                this.ami.setEnabled(false);
                return;
            }
        }
        this.ami.setEnabled(false);
        this.amh.setEnabled(false);
    }

    public void zq() {
        if (!this.amp) {
            this.amj.setVisibility(0);
        }
    }

    public void zr() {
        if (!this.amp) {
            this.amj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.amk.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.amk.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.amk.setOffscreenPageLimit(i);
        this.amn = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.amn = (int) (this.amn * 0.8d);
        if (this.amn < 6291456) {
            this.amo = true;
            this.amn = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.amo = false;
        }
        PagerAdapter adapter = this.amk.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.amn);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.alc);
        this.amk.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.amk.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.amm.setTempSize(i);
        this.amm.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.amm.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amm.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.amm.setData(arrayList);
        this.amm.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.amm.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.amm.setHasNext(z);
        this.amm.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.amm.getHasNext();
    }

    public void setNextTitle(String str) {
        this.amm.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.amk.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.amk.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.alj = z;
        if (this.amm != null) {
            this.amm.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.amm != null) {
            this.amm.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.amm != null) {
            this.amm.setHeadImage(z);
        }
    }
}
