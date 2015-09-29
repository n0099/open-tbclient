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
    private a.e ajU;
    private a.d ajV;
    private Button akK;
    private Button akL;
    private LinearLayout akM;
    private i akN;
    private ViewPager.OnPageChangeListener akO;
    private j akP;
    private int akQ;
    private boolean akR;
    private boolean akS;
    private boolean akd;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public MultiImageView(Context context) {
        super(context);
        this.akK = null;
        this.akL = null;
        this.akM = null;
        this.mOnClickListener = null;
        this.akN = null;
        this.mOnPageChangeListener = null;
        this.akO = null;
        this.ajU = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = 0;
        this.akR = true;
        this.akS = false;
        this.akd = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.akN != null) {
            this.akN.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akK = null;
        this.akL = null;
        this.akM = null;
        this.mOnClickListener = null;
        this.akN = null;
        this.mOnPageChangeListener = null;
        this.akO = null;
        this.ajU = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = 0;
        this.akR = true;
        this.akS = false;
        this.akd = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akK = null;
        this.akL = null;
        this.akM = null;
        this.mOnClickListener = null;
        this.akN = null;
        this.mOnPageChangeListener = null;
        this.akO = null;
        this.ajU = null;
        this.akP = null;
        this.ajV = null;
        this.akQ = 0;
        this.akR = true;
        this.akS = false;
        this.akd = false;
        init();
    }

    private void init() {
        this.akS = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new t(this);
        this.mOnPageChangeListener = new u(this);
        this.ajU = new v(this);
        this.ajV = new w(this);
    }

    public void onResume() {
        if (this.akN.getCurrentView() != null) {
            if (this.akR) {
                int childCount = this.akN.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.akN.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != this.akN.getCurrentView()) {
                        ((z) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.akN.findViewWithTag(String.valueOf(this.akN.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof z)) {
                ((z) findViewWithTag).aT(this.akd);
            }
            this.akN.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.akN.getCurrentView() != null) {
            this.akN.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.akN != null) {
            int childCount = this.akN.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.akN.getChildAt(i);
                if (childAt != null && (childAt instanceof z)) {
                    ((z) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.akN = new i(getContext());
        this.akN.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.akN.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.akN);
        this.akM = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.akM.setOrientation(0);
        this.akM.setLayoutParams(layoutParams);
        addView(this.akM);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.akL = new Button(getContext());
        this.akL.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomout));
        this.akL.setLayoutParams(layoutParams2);
        this.akL.setOnClickListener(this.mOnClickListener);
        this.akL.setEnabled(false);
        this.akM.addView(this.akL);
        this.akK = new Button(getContext());
        this.akK.setBackgroundDrawable(getContext().getResources().getDrawable(i.e.image_zoomin));
        this.akK.setLayoutParams(layoutParams2);
        this.akK.setOnClickListener(this.mOnClickListener);
        this.akK.setEnabled(false);
        this.akM.addView(this.akK);
        if (this.akS) {
            this.akM.setVisibility(8);
        }
        this.akP = new j(getContext(), null, this.ajV);
        setAdapter(this.akP);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.akO = onPageChangeListener;
    }

    public int getItemNum() {
        return this.akP.getCount();
    }

    public int getCurrentItem() {
        return this.akN.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.akK.setEnabled(true);
            } else {
                this.akK.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.akL.setEnabled(true);
                return;
            } else {
                this.akL.setEnabled(false);
                return;
            }
        }
        this.akL.setEnabled(false);
        this.akK.setEnabled(false);
    }

    public void yZ() {
        if (!this.akS) {
            this.akM.setVisibility(0);
        }
    }

    public void za() {
        if (!this.akS) {
            this.akM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.akN.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.akN.setPageMargin(i);
    }

    public void G(int i, int i2) {
        this.akN.setOffscreenPageLimit(i);
        this.akQ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.akQ = (int) (this.akQ * 0.8d);
        if (this.akQ < 6291456) {
            this.akR = true;
            this.akQ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.akR = false;
        }
        PagerAdapter adapter = this.akN.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.akQ);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.ajU);
        this.akN.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.akN.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.akP.setTempSize(i);
        this.akP.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akP.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.akP.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akP.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.akP.setData(arrayList);
        this.akP.notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.akP.setAssistUrls(hashMap);
    }

    public void setHasNext(boolean z) {
        this.akP.setHasNext(z);
        this.akP.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.akP.getHasNext();
    }

    public void setNextTitle(String str) {
        this.akP.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        com.baidu.tbadk.widget.a selectedView = this.akN.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        return selectedView.getImageData();
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.akN.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.akd = z;
        if (this.akP != null) {
            this.akP.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.akP != null) {
            this.akP.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.akP != null) {
            this.akP.setHeadImage(z);
        }
    }

    public void a(j.a aVar) {
        this.akP.a(aVar);
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        if (this.akP != null) {
            this.akP.setOriImgSelectedCallback(bVar);
        }
    }
}
