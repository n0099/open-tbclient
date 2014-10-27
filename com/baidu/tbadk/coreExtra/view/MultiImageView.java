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
    private com.baidu.tbadk.widget.f NV;
    private com.baidu.tbadk.widget.e NW;
    private Button OL;
    private Button OM;
    private LinearLayout OO;
    private p OP;
    private ViewPager.OnPageChangeListener OQ;
    private q OR;
    private int OS;
    private boolean OT;
    private boolean OU;
    private boolean Oc;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.OL = null;
        this.OM = null;
        this.OO = null;
        this.mOnClickListener = null;
        this.OP = null;
        this.mOnPageChangeListener = null;
        this.OQ = null;
        this.NV = null;
        this.OR = null;
        this.NW = null;
        this.OS = 0;
        this.OT = true;
        this.OU = false;
        this.Oc = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.OP != null) {
            this.OP.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OL = null;
        this.OM = null;
        this.OO = null;
        this.mOnClickListener = null;
        this.OP = null;
        this.mOnPageChangeListener = null;
        this.OQ = null;
        this.NV = null;
        this.OR = null;
        this.NW = null;
        this.OS = 0;
        this.OT = true;
        this.OU = false;
        this.Oc = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OL = null;
        this.OM = null;
        this.OO = null;
        this.mOnClickListener = null;
        this.OP = null;
        this.mOnPageChangeListener = null;
        this.OQ = null;
        this.NV = null;
        this.OR = null;
        this.NW = null;
        this.OS = 0;
        this.OT = true;
        this.OU = false;
        this.Oc = false;
        init();
    }

    private void init() {
        this.OU = UtilHelper.isSupportGesture(getContext());
        qh();
        initUI();
    }

    private void qh() {
        this.mOnClickListener = new al(this);
        this.mOnPageChangeListener = new am(this);
        this.NV = new an(this);
        this.NW = new ao(this);
    }

    public void onResume() {
        if (this.OP.getCurrentView() != null) {
            if (this.OT) {
                int childCount = this.OP.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.OP.getChildAt(i);
                    if (childAt != null && (childAt instanceof au) && ((au) childAt).getImageView() != this.OP.getCurrentView()) {
                        ((au) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.OP.findViewWithTag(String.valueOf(this.OP.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof au)) {
                ((au) findViewWithTag).al(this.Oc);
            }
            this.OP.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.OP.getCurrentView() != null) {
            this.OP.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.OP != null) {
            int childCount = this.OP.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.OP.getChildAt(i);
                if (childAt != null && (childAt instanceof au)) {
                    ((au) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.OP = new p(getContext());
        this.OP.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.OP.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.OP);
        this.OO = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.OO.setOrientation(0);
        this.OO.setLayoutParams(layoutParams);
        addView(this.OO);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.OM = new Button(getContext());
        this.OM.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomout));
        this.OM.setLayoutParams(layoutParams2);
        this.OM.setOnClickListener(this.mOnClickListener);
        this.OM.setEnabled(false);
        this.OO.addView(this.OM);
        this.OL = new Button(getContext());
        this.OL.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomin));
        this.OL.setLayoutParams(layoutParams2);
        this.OL.setOnClickListener(this.mOnClickListener);
        this.OL.setEnabled(false);
        this.OO.addView(this.OL);
        if (this.OU) {
            this.OO.setVisibility(8);
        }
        this.OR = new q(getContext(), null, this.NW);
        setAdapter(this.OR);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.OQ = onPageChangeListener;
    }

    public int getItemNum() {
        return this.OR.getCount();
    }

    public int getCurrentItem() {
        return this.OP.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.vp()) {
                this.OL.setEnabled(true);
            } else {
                this.OL.setEnabled(false);
            }
            if (aVar.vq()) {
                this.OM.setEnabled(true);
                return;
            } else {
                this.OM.setEnabled(false);
                return;
            }
        }
        this.OM.setEnabled(false);
        this.OL.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.OP.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.OP.setPageMargin(i);
    }

    public void u(int i, int i2) {
        this.OP.setOffscreenPageLimit(i);
        this.OS = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.OS = (int) (this.OS * 0.8d);
        if (this.OS < 6291456) {
            this.OT = true;
            this.OS = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.OT = false;
        }
        PagerAdapter adapter = this.OP.getAdapter();
        if (adapter != null && (adapter instanceof q)) {
            ((q) adapter).setGifMaxUseableMem(this.OS);
        }
    }

    private void setAdapter(q qVar) {
        qVar.a(this.NV);
        this.OP.setAdapter(qVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.OP.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.OR.setTempSize(i);
        this.OR.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.OR.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.OR.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.OR.setData(arrayList);
        this.OR.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.OR.setHasNext(z);
        this.OR.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.OR.getHasNext();
    }

    public void setNextTitle(String str) {
        this.OR.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.OP.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.OP.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.Oc = z;
        if (this.OR != null) {
            this.OR.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.OR != null) {
            this.OR.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.OR != null) {
            this.OR.setHeadImage(z);
        }
    }
}
