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
    private com.baidu.tbadk.widget.h aer;
    private com.baidu.tbadk.widget.g aes;
    private boolean aey;
    private Button afl;
    private Button afm;
    private LinearLayout afn;
    private p afo;
    private ViewPager.OnPageChangeListener afp;
    private s afq;
    private int afr;
    private boolean afs;
    private boolean aft;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.afl = null;
        this.afm = null;
        this.afn = null;
        this.mOnClickListener = null;
        this.afo = null;
        this.mOnPageChangeListener = null;
        this.afp = null;
        this.aer = null;
        this.afq = null;
        this.aes = null;
        this.afr = 0;
        this.afs = true;
        this.aft = false;
        this.aey = false;
        init();
    }

    public void setOnScrollOutListener(com.baidu.tbadk.core.view.a aVar) {
        if (this.afo != null) {
            this.afo.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afl = null;
        this.afm = null;
        this.afn = null;
        this.mOnClickListener = null;
        this.afo = null;
        this.mOnPageChangeListener = null;
        this.afp = null;
        this.aer = null;
        this.afq = null;
        this.aes = null;
        this.afr = 0;
        this.afs = true;
        this.aft = false;
        this.aey = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afl = null;
        this.afm = null;
        this.afn = null;
        this.mOnClickListener = null;
        this.afo = null;
        this.mOnPageChangeListener = null;
        this.afp = null;
        this.aer = null;
        this.afq = null;
        this.aes = null;
        this.afr = 0;
        this.afs = true;
        this.aft = false;
        this.aey = false;
        init();
    }

    private void init() {
        this.aft = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new al(this);
        this.mOnPageChangeListener = new am(this);
        this.aer = new an(this);
        this.aes = new ao(this);
    }

    public void onResume() {
        if (this.afo.getCurrentView() != null) {
            if (this.afs) {
                int childCount = this.afo.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.afo.getChildAt(i);
                    if (childAt != null && (childAt instanceof at) && ((at) childAt).getImageView() != this.afo.getCurrentView()) {
                        ((at) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.afo.findViewWithTag(String.valueOf(this.afo.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof at)) {
                ((at) findViewWithTag).aH(this.aey);
            }
            this.afo.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.afo.getCurrentView() != null) {
            this.afo.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.afo != null) {
            int childCount = this.afo.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.afo.getChildAt(i);
                if (childAt != null && (childAt instanceof at)) {
                    ((at) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.afo = new p(getContext());
        this.afo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.afo.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.afo);
        this.afn = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.afn.setOrientation(0);
        this.afn.setLayoutParams(layoutParams);
        addView(this.afn);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.afm = new Button(getContext());
        this.afm.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomout));
        this.afm.setLayoutParams(layoutParams2);
        this.afm.setOnClickListener(this.mOnClickListener);
        this.afm.setEnabled(false);
        this.afn.addView(this.afm);
        this.afl = new Button(getContext());
        this.afl.setBackgroundDrawable(getContext().getResources().getDrawable(com.baidu.tieba.u.image_zoomin));
        this.afl.setLayoutParams(layoutParams2);
        this.afl.setOnClickListener(this.mOnClickListener);
        this.afl.setEnabled(false);
        this.afn.addView(this.afl);
        if (this.aft) {
            this.afn.setVisibility(8);
        }
        this.afq = new s(getContext(), null, this.aes);
        setAdapter(this.afq);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.afp = onPageChangeListener;
    }

    public int getItemNum() {
        return this.afq.getCount();
    }

    public int getCurrentItem() {
        return this.afo.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.afl.setEnabled(true);
            } else {
                this.afl.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.afm.setEnabled(true);
                return;
            } else {
                this.afm.setEnabled(false);
                return;
            }
        }
        this.afm.setEnabled(false);
        this.afl.setEnabled(false);
    }

    public void xg() {
        if (!this.aft) {
            this.afn.setVisibility(0);
        }
    }

    public void xh() {
        if (!this.aft) {
            this.afn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.afo.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.afo.setPageMargin(i);
    }

    public void v(int i, int i2) {
        this.afo.setOffscreenPageLimit(i);
        this.afr = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.afr = (int) (this.afr * 0.8d);
        if (this.afr < 6291456) {
            this.afs = true;
            this.afr = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.afs = false;
        }
        PagerAdapter adapter = this.afo.getAdapter();
        if (adapter != null && (adapter instanceof s)) {
            ((s) adapter).setGifMaxUseableMem(this.afr);
        }
    }

    private void setAdapter(s sVar) {
        sVar.a(this.aer);
        this.afo.setAdapter(sVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.afo.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.afq.setTempSize(i);
        this.afq.notifyDataSetChanged();
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.afq.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afq.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.afq.p(arrayList);
        this.afq.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.afq.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.afq.setHasNext(z);
        this.afq.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.afq.getHasNext();
    }

    public void setNextTitle(String str) {
        this.afq.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.afo.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.afo.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aey = z;
        if (this.afq != null) {
            this.afq.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.afq != null) {
            this.afq.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.afq != null) {
            this.afq.setHeadImage(z);
        }
    }
}
