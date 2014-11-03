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
    private com.baidu.tbadk.widget.f NZ;
    private Button OQ;
    private Button OR;
    private LinearLayout OS;
    private p OT;
    private ViewPager.OnPageChangeListener OU;
    private q OV;
    private int OW;
    private boolean OX;
    private boolean OY;
    private com.baidu.tbadk.widget.e Oa;
    private boolean Og;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.OQ = null;
        this.OR = null;
        this.OS = null;
        this.mOnClickListener = null;
        this.OT = null;
        this.mOnPageChangeListener = null;
        this.OU = null;
        this.NZ = null;
        this.OV = null;
        this.Oa = null;
        this.OW = 0;
        this.OX = true;
        this.OY = false;
        this.Og = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.OT != null) {
            this.OT.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OQ = null;
        this.OR = null;
        this.OS = null;
        this.mOnClickListener = null;
        this.OT = null;
        this.mOnPageChangeListener = null;
        this.OU = null;
        this.NZ = null;
        this.OV = null;
        this.Oa = null;
        this.OW = 0;
        this.OX = true;
        this.OY = false;
        this.Og = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OQ = null;
        this.OR = null;
        this.OS = null;
        this.mOnClickListener = null;
        this.OT = null;
        this.mOnPageChangeListener = null;
        this.OU = null;
        this.NZ = null;
        this.OV = null;
        this.Oa = null;
        this.OW = 0;
        this.OX = true;
        this.OY = false;
        this.Og = false;
        init();
    }

    private void init() {
        this.OY = UtilHelper.isSupportGesture(getContext());
        qj();
        initUI();
    }

    private void qj() {
        this.mOnClickListener = new al(this);
        this.mOnPageChangeListener = new am(this);
        this.NZ = new an(this);
        this.Oa = new ao(this);
    }

    public void onResume() {
        if (this.OT.getCurrentView() != null) {
            if (this.OX) {
                int childCount = this.OT.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.OT.getChildAt(i);
                    if (childAt != null && (childAt instanceof au) && ((au) childAt).getImageView() != this.OT.getCurrentView()) {
                        ((au) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.OT.findViewWithTag(String.valueOf(this.OT.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof au)) {
                ((au) findViewWithTag).al(this.Og);
            }
            this.OT.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.OT.getCurrentView() != null) {
            this.OT.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.OT != null) {
            int childCount = this.OT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.OT.getChildAt(i);
                if (childAt != null && (childAt instanceof au)) {
                    ((au) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.OT = new p(getContext());
        this.OT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.OT.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.OT);
        this.OS = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.OS.setOrientation(0);
        this.OS.setLayoutParams(layoutParams);
        addView(this.OS);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.OR = new Button(getContext());
        this.OR.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomout));
        this.OR.setLayoutParams(layoutParams2);
        this.OR.setOnClickListener(this.mOnClickListener);
        this.OR.setEnabled(false);
        this.OS.addView(this.OR);
        this.OQ = new Button(getContext());
        this.OQ.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomin));
        this.OQ.setLayoutParams(layoutParams2);
        this.OQ.setOnClickListener(this.mOnClickListener);
        this.OQ.setEnabled(false);
        this.OS.addView(this.OQ);
        if (this.OY) {
            this.OS.setVisibility(8);
        }
        this.OV = new q(getContext(), null, this.Oa);
        setAdapter(this.OV);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.OU = onPageChangeListener;
    }

    public int getItemNum() {
        return this.OV.getCount();
    }

    public int getCurrentItem() {
        return this.OT.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.vr()) {
                this.OQ.setEnabled(true);
            } else {
                this.OQ.setEnabled(false);
            }
            if (aVar.vs()) {
                this.OR.setEnabled(true);
                return;
            } else {
                this.OR.setEnabled(false);
                return;
            }
        }
        this.OR.setEnabled(false);
        this.OQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.OT.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.OT.setPageMargin(i);
    }

    public void u(int i, int i2) {
        this.OT.setOffscreenPageLimit(i);
        this.OW = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.OW = (int) (this.OW * 0.8d);
        if (this.OW < 6291456) {
            this.OX = true;
            this.OW = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.OX = false;
        }
        PagerAdapter adapter = this.OT.getAdapter();
        if (adapter != null && (adapter instanceof q)) {
            ((q) adapter).setGifMaxUseableMem(this.OW);
        }
    }

    private void setAdapter(q qVar) {
        qVar.a(this.NZ);
        this.OT.setAdapter(qVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.OT.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.OV.setTempSize(i);
        this.OV.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.OV.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.OV.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.OV.setData(arrayList);
        this.OV.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.OV.setHasNext(z);
        this.OV.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.OV.getHasNext();
    }

    public void setNextTitle(String str) {
        this.OV.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.OT.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.OT.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.Og = z;
        if (this.OV != null) {
            this.OV.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.OV != null) {
            this.OV.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.OV != null) {
            this.OV.setHeadImage(z);
        }
    }
}
