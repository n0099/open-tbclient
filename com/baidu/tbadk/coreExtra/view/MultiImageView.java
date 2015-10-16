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
    private a.e ajV;
    private a.d ajW;
    private Button akL;
    private Button akM;
    private LinearLayout akN;
    private i akO;
    private ViewPager.OnPageChangeListener akP;
    private j akQ;
    private int akR;
    private boolean akS;
    private boolean akT;
    private boolean ake;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.akL = null;
        this.akM = null;
        this.akN = null;
        this.mOnClickListener = null;
        this.akO = null;
        this.mOnPageChangeListener = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = null;
        this.ajW = null;
        this.akR = 0;
        this.akS = true;
        this.akT = false;
        this.ake = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.akO != null) {
            this.akO.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akL = null;
        this.akM = null;
        this.akN = null;
        this.mOnClickListener = null;
        this.akO = null;
        this.mOnPageChangeListener = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = null;
        this.ajW = null;
        this.akR = 0;
        this.akS = true;
        this.akT = false;
        this.ake = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akL = null;
        this.akM = null;
        this.akN = null;
        this.mOnClickListener = null;
        this.akO = null;
        this.mOnPageChangeListener = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = null;
        this.ajW = null;
        this.akR = 0;
        this.akS = true;
        this.akT = false;
        this.ake = false;
        init();
    }

    private void init() {
        this.akT = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new t(this);
        this.mOnPageChangeListener = new u(this);
        this.ajV = new v(this);
        this.ajW = new w(this);
    }

    public void onResume() {
        if (this.akO.getCurrentView() != null) {
            if (this.akS) {
                int childCount = this.akO.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.akO.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != this.akO.getCurrentView()) {
                        ((z) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.akO.findViewWithTag(String.valueOf(this.akO.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof z)) {
                ((z) findViewWithTag).aT(this.ake);
            }
            this.akO.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.akO.getCurrentView() != null) {
            this.akO.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.akO != null) {
            int childCount = this.akO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.akO.getChildAt(i);
                if (childAt != null && (childAt instanceof z)) {
                    ((z) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.akO = new i(getContext());
        this.akO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.akO.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.akO);
        this.akN = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.akN.setOrientation(0);
        this.akN.setLayoutParams(layoutParams);
        addView(this.akN);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.akM = new Button(getContext());
        this.akM.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomout));
        this.akM.setLayoutParams(layoutParams2);
        this.akM.setOnClickListener(this.mOnClickListener);
        this.akM.setEnabled(false);
        this.akN.addView(this.akM);
        this.akL = new Button(getContext());
        this.akL.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomin));
        this.akL.setLayoutParams(layoutParams2);
        this.akL.setOnClickListener(this.mOnClickListener);
        this.akL.setEnabled(false);
        this.akN.addView(this.akL);
        if (this.akT) {
            this.akN.setVisibility(8);
        }
        this.akQ = new j(getContext(), null, this.ajW);
        setAdapter(this.akQ);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.akP = onPageChangeListener;
    }

    public int getItemNum() {
        return this.akQ.getCount();
    }

    public int getCurrentItem() {
        return this.akO.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.akL.setEnabled(true);
            } else {
                this.akL.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.akM.setEnabled(true);
                return;
            } else {
                this.akM.setEnabled(false);
                return;
            }
        }
        this.akM.setEnabled(false);
        this.akL.setEnabled(false);
    }

    public void yZ() {
        if (!this.akT) {
            this.akN.setVisibility(0);
        }
    }

    public void za() {
        if (!this.akT) {
            this.akN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.akO.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.akO.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.akO.setOffscreenPageLimit(i);
        this.akR = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.akR = (int) (this.akR * 0.8d);
        if (this.akR < 6291456) {
            this.akS = true;
            this.akR = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.akS = false;
        }
        PagerAdapter adapter = this.akO.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.akR);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.ajV);
        this.akO.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.akO.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.akQ.setTempSize(i);
        this.akQ.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akQ.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.akQ.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akQ.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.akQ.setData(arrayList);
        this.akQ.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.akQ.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.akQ.setHasNext(z);
        this.akQ.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.akQ.getHasNext();
    }

    public void setNextTitle(String str) {
        this.akQ.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.akO.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.akO.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.ake = z;
        if (this.akQ != null) {
            this.akQ.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.akQ != null) {
            this.akQ.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.akQ != null) {
            this.akQ.setHeadImage(z);
        }
    }

    public void a(j.a aVar) {
        this.akQ.a(aVar);
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        if (this.akQ != null) {
            this.akQ.setOriImgSelectedCallback(bVar);
        }
    }
}
