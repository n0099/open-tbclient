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
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private com.baidu.tbadk.widget.h afD;
    private com.baidu.tbadk.widget.g afE;
    private boolean afK;
    private int agA;
    private boolean agB;
    private boolean agC;
    private Button agu;
    private Button agv;
    private LinearLayout agw;
    private p agx;
    private ViewPager.OnPageChangeListener agy;
    private s agz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.agu = null;
        this.agv = null;
        this.agw = null;
        this.mOnClickListener = null;
        this.agx = null;
        this.mOnPageChangeListener = null;
        this.agy = null;
        this.afD = null;
        this.agz = null;
        this.afE = null;
        this.agA = 0;
        this.agB = true;
        this.agC = false;
        this.afK = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.agx != null) {
            this.agx.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agu = null;
        this.agv = null;
        this.agw = null;
        this.mOnClickListener = null;
        this.agx = null;
        this.mOnPageChangeListener = null;
        this.agy = null;
        this.afD = null;
        this.agz = null;
        this.afE = null;
        this.agA = 0;
        this.agB = true;
        this.agC = false;
        this.afK = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agu = null;
        this.agv = null;
        this.agw = null;
        this.mOnClickListener = null;
        this.agx = null;
        this.mOnPageChangeListener = null;
        this.agy = null;
        this.afD = null;
        this.agz = null;
        this.afE = null;
        this.agA = 0;
        this.agB = true;
        this.agC = false;
        this.afK = false;
        init();
    }

    private void init() {
        this.agC = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new am(this);
        this.mOnPageChangeListener = new an(this);
        this.afD = new ao(this);
        this.afE = new ap(this);
    }

    public void onResume() {
        if (this.agx.getCurrentView() != null) {
            if (this.agB) {
                int childCount = this.agx.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.agx.getChildAt(i);
                    if (childAt != null && (childAt instanceof au) && ((au) childAt).getImageView() != this.agx.getCurrentView()) {
                        ((au) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.agx.findViewWithTag(String.valueOf(this.agx.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof au)) {
                ((au) findViewWithTag).aO(this.afK);
            }
            this.agx.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.agx.getCurrentView() != null) {
            this.agx.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.agx != null) {
            int childCount = this.agx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.agx.getChildAt(i);
                if (childAt != null && (childAt instanceof au)) {
                    ((au) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.agx = new p(getContext());
        this.agx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.agx.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.agx);
        this.agw = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.agw.setOrientation(0);
        this.agw.setLayoutParams(layoutParams);
        addView(this.agw);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.agv = new Button(getContext());
        this.agv.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.p.image_zoomout));
        this.agv.setLayoutParams(layoutParams2);
        this.agv.setOnClickListener(this.mOnClickListener);
        this.agv.setEnabled(false);
        this.agw.addView(this.agv);
        this.agu = new Button(getContext());
        this.agu.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.p.image_zoomin));
        this.agu.setLayoutParams(layoutParams2);
        this.agu.setOnClickListener(this.mOnClickListener);
        this.agu.setEnabled(false);
        this.agw.addView(this.agu);
        if (this.agC) {
            this.agw.setVisibility(8);
        }
        this.agz = new s(getContext(), null, this.afE);
        setAdapter(this.agz);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.agy = onPageChangeListener;
    }

    public int getItemNum() {
        return this.agz.getCount();
    }

    public int getCurrentItem() {
        return this.agx.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.agu.setEnabled(true);
            } else {
                this.agu.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.agv.setEnabled(true);
                return;
            } else {
                this.agv.setEnabled(false);
                return;
            }
        }
        this.agv.setEnabled(false);
        this.agu.setEnabled(false);
    }

    public void xZ() {
        if (!this.agC) {
            this.agw.setVisibility(0);
        }
    }

    public void ya() {
        if (!this.agC) {
            this.agw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.agx.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.agx.setPageMargin(i);
    }

    public void w(int i, int i2) {
        this.agx.setOffscreenPageLimit(i);
        this.agA = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.agA = (int) (this.agA * 0.8d);
        if (this.agA < 6291456) {
            this.agB = true;
            this.agA = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.agB = false;
        }
        PagerAdapter adapter = this.agx.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.agA);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.afD);
        this.agx.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.agx.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.agz.setTempSize(i);
        this.agz.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.agz.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.agz.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.agz.setData(arrayList);
        this.agz.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.agz.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.agz.setHasNext(z);
        this.agz.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.agz.getHasNext();
    }

    public void setNextTitle(String str) {
        this.agz.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.agx.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.agx.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.afK = z;
        if (this.agz != null) {
            this.agz.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.agz != null) {
            this.agz.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.agz != null) {
            this.agz.setHeadImage(z);
        }
    }
}
