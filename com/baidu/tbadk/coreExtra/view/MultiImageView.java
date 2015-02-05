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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private com.baidu.tbadk.widget.h Uo;
    private com.baidu.tbadk.widget.g Up;
    private boolean Uv;
    private Button Ve;
    private Button Vf;
    private LinearLayout Vg;
    private p Vh;
    private ViewPager.OnPageChangeListener Vi;
    private s Vj;
    private int Vk;
    private boolean Vl;
    private boolean Vm;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.Ve = null;
        this.Vf = null;
        this.Vg = null;
        this.mOnClickListener = null;
        this.Vh = null;
        this.mOnPageChangeListener = null;
        this.Vi = null;
        this.Uo = null;
        this.Vj = null;
        this.Up = null;
        this.Vk = 0;
        this.Vl = true;
        this.Vm = false;
        this.Uv = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.Vh != null) {
            this.Vh.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ve = null;
        this.Vf = null;
        this.Vg = null;
        this.mOnClickListener = null;
        this.Vh = null;
        this.mOnPageChangeListener = null;
        this.Vi = null;
        this.Uo = null;
        this.Vj = null;
        this.Up = null;
        this.Vk = 0;
        this.Vl = true;
        this.Vm = false;
        this.Uv = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ve = null;
        this.Vf = null;
        this.Vg = null;
        this.mOnClickListener = null;
        this.Vh = null;
        this.mOnPageChangeListener = null;
        this.Vi = null;
        this.Uo = null;
        this.Vj = null;
        this.Up = null;
        this.Vk = 0;
        this.Vl = true;
        this.Vm = false;
        this.Uv = false;
        init();
    }

    private void init() {
        this.Vm = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new am(this);
        this.mOnPageChangeListener = new an(this);
        this.Uo = new ao(this);
        this.Up = new ap(this);
    }

    public void onResume() {
        if (this.Vh.getCurrentView() != null) {
            if (this.Vl) {
                int childCount = this.Vh.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.Vh.getChildAt(i);
                    if (childAt != null && (childAt instanceof ax) && ((ax) childAt).getImageView() != this.Vh.getCurrentView()) {
                        ((ax) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.Vh.findViewWithTag(String.valueOf(this.Vh.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ax)) {
                ((ax) findViewWithTag).aB(this.Uv);
            }
            this.Vh.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.Vh.getCurrentView() != null) {
            this.Vh.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.Vh != null) {
            int childCount = this.Vh.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.Vh.getChildAt(i);
                if (childAt != null && (childAt instanceof ax)) {
                    ((ax) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.Vh = new p(getContext());
        this.Vh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.Vh.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.Vh);
        this.Vg = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.Vg.setOrientation(0);
        this.Vg.setLayoutParams(layoutParams);
        addView(this.Vg);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.Vf = new Button(getContext());
        this.Vf.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomout));
        this.Vf.setLayoutParams(layoutParams2);
        this.Vf.setOnClickListener(this.mOnClickListener);
        this.Vf.setEnabled(false);
        this.Vg.addView(this.Vf);
        this.Ve = new Button(getContext());
        this.Ve.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomin));
        this.Ve.setLayoutParams(layoutParams2);
        this.Ve.setOnClickListener(this.mOnClickListener);
        this.Ve.setEnabled(false);
        this.Vg.addView(this.Ve);
        if (this.Vm) {
            this.Vg.setVisibility(8);
        }
        this.Vj = new s(getContext(), null, this.Up);
        setAdapter(this.Vj);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.Vi = onPageChangeListener;
    }

    public int getItemNum() {
        return this.Vj.getCount();
    }

    public int getCurrentItem() {
        return this.Vh.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.Ve.setEnabled(true);
            } else {
                this.Ve.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.Vf.setEnabled(true);
                return;
            } else {
                this.Vf.setEnabled(false);
                return;
            }
        }
        this.Vf.setEnabled(false);
        this.Ve.setEnabled(false);
    }

    public void tM() {
        if (!this.Vm) {
            this.Vg.setVisibility(0);
        }
    }

    public void tN() {
        if (!this.Vm) {
            this.Vg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.Vh.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.Vh.setPageMargin(i);
    }

    public void x(int i, int i2) {
        this.Vh.setOffscreenPageLimit(i);
        this.Vk = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.Vk = (int) (this.Vk * 0.8d);
        if (this.Vk < 6291456) {
            this.Vl = true;
            this.Vk = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.Vl = false;
        }
        PagerAdapter adapter = this.Vh.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.Vk);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.Uo);
        this.Vh.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.Vh.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.Vj.setTempSize(i);
        this.Vj.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.Vj.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Vj.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.Vj.s(arrayList);
        this.Vj.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.Vj.setHasNext(z);
        this.Vj.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.Vj.getHasNext();
    }

    public void setNextTitle(String str) {
        this.Vj.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.Vh.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.Vh.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.Uv = z;
        if (this.Vj != null) {
            this.Vj.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.Vj != null) {
            this.Vj.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.Vj != null) {
            this.Vj.setHeadImage(z);
        }
    }
}
