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
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private Button akQ;
    private Button akR;
    private LinearLayout akS;
    private i akT;
    private ViewPager.OnPageChangeListener akU;
    private j akV;
    private int akW;
    private boolean akX;
    private boolean akY;
    private a.e aka;
    private a.d akb;
    private boolean akj;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.akQ = null;
        this.akR = null;
        this.akS = null;
        this.mOnClickListener = null;
        this.akT = null;
        this.mOnPageChangeListener = null;
        this.akU = null;
        this.aka = null;
        this.akV = null;
        this.akb = null;
        this.akW = 0;
        this.akX = true;
        this.akY = false;
        this.akj = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.akT != null) {
            this.akT.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akQ = null;
        this.akR = null;
        this.akS = null;
        this.mOnClickListener = null;
        this.akT = null;
        this.mOnPageChangeListener = null;
        this.akU = null;
        this.aka = null;
        this.akV = null;
        this.akb = null;
        this.akW = 0;
        this.akX = true;
        this.akY = false;
        this.akj = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akQ = null;
        this.akR = null;
        this.akS = null;
        this.mOnClickListener = null;
        this.akT = null;
        this.mOnPageChangeListener = null;
        this.akU = null;
        this.aka = null;
        this.akV = null;
        this.akb = null;
        this.akW = 0;
        this.akX = true;
        this.akY = false;
        this.akj = false;
        init();
    }

    private void init() {
        this.akY = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new t(this);
        this.mOnPageChangeListener = new u(this);
        this.aka = new v(this);
        this.akb = new w(this);
    }

    public void onResume() {
        if (this.akT.getCurrentView() != null) {
            if (this.akX) {
                int childCount = this.akT.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.akT.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != this.akT.getCurrentView()) {
                        ((z) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.akT.findViewWithTag(String.valueOf(this.akT.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof z)) {
                ((z) findViewWithTag).aT(this.akj);
            }
            this.akT.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.akT.getCurrentView() != null) {
            this.akT.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.akT != null) {
            int childCount = this.akT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.akT.getChildAt(i);
                if (childAt != null && (childAt instanceof z)) {
                    ((z) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.akT = new i(getContext());
        this.akT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.akT.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.akT);
        this.akS = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.akS.setOrientation(0);
        this.akS.setLayoutParams(layoutParams);
        addView(this.akS);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.akR = new Button(getContext());
        this.akR.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomout));
        this.akR.setLayoutParams(layoutParams2);
        this.akR.setOnClickListener(this.mOnClickListener);
        this.akR.setEnabled(false);
        this.akS.addView(this.akR);
        this.akQ = new Button(getContext());
        this.akQ.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomin));
        this.akQ.setLayoutParams(layoutParams2);
        this.akQ.setOnClickListener(this.mOnClickListener);
        this.akQ.setEnabled(false);
        this.akS.addView(this.akQ);
        if (this.akY) {
            this.akS.setVisibility(8);
        }
        this.akV = new j(getContext(), null, this.akb);
        setAdapter(this.akV);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.akU = onPageChangeListener;
    }

    public int getItemNum() {
        return this.akV.getCount();
    }

    public int getCurrentItem() {
        return this.akT.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.akQ.setEnabled(true);
            } else {
                this.akQ.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.akR.setEnabled(true);
                return;
            } else {
                this.akR.setEnabled(false);
                return;
            }
        }
        this.akR.setEnabled(false);
        this.akQ.setEnabled(false);
    }

    public void zb() {
        if (!this.akY) {
            this.akS.setVisibility(0);
        }
    }

    public void zc() {
        if (!this.akY) {
            this.akS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.akT.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.akT.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.akT.setOffscreenPageLimit(i);
        this.akW = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.akW = (int) (this.akW * 0.8d);
        if (this.akW < 6291456) {
            this.akX = true;
            this.akW = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.akX = false;
        }
        PagerAdapter adapter = this.akT.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.akW);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.aka);
        this.akT.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.akT.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.akV.setTempSize(i);
        this.akV.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akV.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.akV.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akV.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.akV.setData(arrayList);
        this.akV.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.akV.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.akV.setHasNext(z);
        this.akV.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.akV.getHasNext();
    }

    public void setNextTitle(String str) {
        this.akV.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.akT.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.akT.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.akj = z;
        if (this.akV != null) {
            this.akV.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.akV != null) {
            this.akV.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.akV != null) {
            this.akV.setHeadImage(z);
        }
    }

    public void a(j.a aVar) {
        this.akV.a(aVar);
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        if (this.akV != null) {
            this.akV.setOriImgSelectedCallback(bVar);
        }
    }
}
