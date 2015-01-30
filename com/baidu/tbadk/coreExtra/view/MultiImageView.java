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
    private com.baidu.tbadk.widget.h Ur;
    private com.baidu.tbadk.widget.g Us;
    private boolean Uy;
    private Button Vh;
    private Button Vi;
    private LinearLayout Vj;
    private p Vk;
    private ViewPager.OnPageChangeListener Vl;
    private s Vm;
    private int Vn;
    private boolean Vo;
    private boolean Vp;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.Vh = null;
        this.Vi = null;
        this.Vj = null;
        this.mOnClickListener = null;
        this.Vk = null;
        this.mOnPageChangeListener = null;
        this.Vl = null;
        this.Ur = null;
        this.Vm = null;
        this.Us = null;
        this.Vn = 0;
        this.Vo = true;
        this.Vp = false;
        this.Uy = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.Vk != null) {
            this.Vk.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vh = null;
        this.Vi = null;
        this.Vj = null;
        this.mOnClickListener = null;
        this.Vk = null;
        this.mOnPageChangeListener = null;
        this.Vl = null;
        this.Ur = null;
        this.Vm = null;
        this.Us = null;
        this.Vn = 0;
        this.Vo = true;
        this.Vp = false;
        this.Uy = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Vh = null;
        this.Vi = null;
        this.Vj = null;
        this.mOnClickListener = null;
        this.Vk = null;
        this.mOnPageChangeListener = null;
        this.Vl = null;
        this.Ur = null;
        this.Vm = null;
        this.Us = null;
        this.Vn = 0;
        this.Vo = true;
        this.Vp = false;
        this.Uy = false;
        init();
    }

    private void init() {
        this.Vp = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new am(this);
        this.mOnPageChangeListener = new an(this);
        this.Ur = new ao(this);
        this.Us = new ap(this);
    }

    public void onResume() {
        if (this.Vk.getCurrentView() != null) {
            if (this.Vo) {
                int childCount = this.Vk.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.Vk.getChildAt(i);
                    if (childAt != null && (childAt instanceof ax) && ((ax) childAt).getImageView() != this.Vk.getCurrentView()) {
                        ((ax) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.Vk.findViewWithTag(String.valueOf(this.Vk.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ax)) {
                ((ax) findViewWithTag).aB(this.Uy);
            }
            this.Vk.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.Vk.getCurrentView() != null) {
            this.Vk.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.Vk != null) {
            int childCount = this.Vk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.Vk.getChildAt(i);
                if (childAt != null && (childAt instanceof ax)) {
                    ((ax) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.Vk = new p(getContext());
        this.Vk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.Vk.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.Vk);
        this.Vj = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.Vj.setOrientation(0);
        this.Vj.setLayoutParams(layoutParams);
        addView(this.Vj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.Vi = new Button(getContext());
        this.Vi.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomout));
        this.Vi.setLayoutParams(layoutParams2);
        this.Vi.setOnClickListener(this.mOnClickListener);
        this.Vi.setEnabled(false);
        this.Vj.addView(this.Vi);
        this.Vh = new Button(getContext());
        this.Vh.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.v.image_zoomin));
        this.Vh.setLayoutParams(layoutParams2);
        this.Vh.setOnClickListener(this.mOnClickListener);
        this.Vh.setEnabled(false);
        this.Vj.addView(this.Vh);
        if (this.Vp) {
            this.Vj.setVisibility(8);
        }
        this.Vm = new s(getContext(), null, this.Us);
        setAdapter(this.Vm);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.Vl = onPageChangeListener;
    }

    public int getItemNum() {
        return this.Vm.getCount();
    }

    public int getCurrentItem() {
        return this.Vk.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.Vh.setEnabled(true);
            } else {
                this.Vh.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.Vi.setEnabled(true);
                return;
            } else {
                this.Vi.setEnabled(false);
                return;
            }
        }
        this.Vi.setEnabled(false);
        this.Vh.setEnabled(false);
    }

    public void tS() {
        if (!this.Vp) {
            this.Vj.setVisibility(0);
        }
    }

    public void tT() {
        if (!this.Vp) {
            this.Vj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.Vk.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.Vk.setPageMargin(i);
    }

    public void x(int i, int i2) {
        this.Vk.setOffscreenPageLimit(i);
        this.Vn = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.Vn = (int) (this.Vn * 0.8d);
        if (this.Vn < 6291456) {
            this.Vo = true;
            this.Vn = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.Vo = false;
        }
        PagerAdapter adapter = this.Vk.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.Vn);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.Ur);
        this.Vk.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.Vk.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.Vm.setTempSize(i);
        this.Vm.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.Vm.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Vm.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.Vm.s(arrayList);
        this.Vm.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.Vm.setHasNext(z);
        this.Vm.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.Vm.getHasNext();
    }

    public void setNextTitle(String str) {
        this.Vm.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.Vk.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.Vk.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.Uy = z;
        if (this.Vm != null) {
            this.Vm.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.Vm != null) {
            this.Vm.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.Vm != null) {
            this.Vm.setHeadImage(z);
        }
    }
}
