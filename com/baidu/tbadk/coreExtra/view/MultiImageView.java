package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e amR;
    private a.d amS;
    private Button anK;
    private Button anL;
    private LinearLayout anM;
    private i anN;
    private ViewPager.OnPageChangeListener anO;
    private j anP;
    private int anQ;
    private boolean anR;
    private boolean anS;
    private boolean anT;
    private boolean ana;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.mOnClickListener = null;
        this.anN = null;
        this.mOnPageChangeListener = null;
        this.anO = null;
        this.amR = null;
        this.anP = null;
        this.amS = null;
        this.anQ = 0;
        this.anR = true;
        this.anS = false;
        this.ana = false;
        this.anT = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.anN != null) {
            this.anN.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.mOnClickListener = null;
        this.anN = null;
        this.mOnPageChangeListener = null;
        this.anO = null;
        this.amR = null;
        this.anP = null;
        this.amS = null;
        this.anQ = 0;
        this.anR = true;
        this.anS = false;
        this.ana = false;
        this.anT = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.mOnClickListener = null;
        this.anN = null;
        this.mOnPageChangeListener = null;
        this.anO = null;
        this.amR = null;
        this.anP = null;
        this.amS = null;
        this.anQ = 0;
        this.anR = true;
        this.anS = false;
        this.ana = false;
        this.anT = false;
        init();
    }

    private void init() {
        this.anS = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new t(this);
        this.mOnPageChangeListener = new u(this);
        this.amR = new v(this);
        this.amS = new w(this);
    }

    public void cK(int i) {
        if (this.mSkinType != i && this.anN != null) {
            int childCount = this.anN.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.anN.getChildAt(i2);
                if (childAt instanceof z) {
                    ((z) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.anN.getCurrentView() != null) {
            if (this.anR) {
                int childCount = this.anN.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.anN.getChildAt(i);
                    if (childAt != null && (childAt instanceof z) && ((z) childAt).getImageView() != this.anN.getCurrentView()) {
                        ((z) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.anN.findViewWithTag(String.valueOf(this.anN.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof z)) {
                ((z) findViewWithTag).f(this.ana, true);
            }
            this.anN.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.anN.getCurrentView() != null) {
            this.anN.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.anN != null) {
            int childCount = this.anN.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.anN.getChildAt(i);
                if (childAt != null && (childAt instanceof z)) {
                    ((z) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.anN = new i(getContext());
        this.anN.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.anN.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.anN);
        this.anM = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.anM.setOrientation(0);
        this.anM.setLayoutParams(layoutParams);
        addView(this.anM);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.anL = new Button(getContext());
        this.anL.setBackgroundDrawable(getContext().getResources().getDrawable(n.f.image_zoomout));
        this.anL.setLayoutParams(layoutParams2);
        this.anL.setOnClickListener(this.mOnClickListener);
        this.anL.setEnabled(false);
        this.anM.addView(this.anL);
        this.anK = new Button(getContext());
        this.anK.setBackgroundDrawable(getContext().getResources().getDrawable(n.f.image_zoomin));
        this.anK.setLayoutParams(layoutParams2);
        this.anK.setOnClickListener(this.mOnClickListener);
        this.anK.setEnabled(false);
        this.anM.addView(this.anK);
        if (this.anS) {
            this.anM.setVisibility(8);
        }
        this.anP = new j(getContext(), null, this.amS);
        setAdapter(this.anP);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.anO = onPageChangeListener;
    }

    public int getItemNum() {
        return this.anP.getCount();
    }

    public int getCurrentItem() {
        return this.anN.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.anK.setEnabled(true);
            } else {
                this.anK.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.anL.setEnabled(true);
                return;
            } else {
                this.anL.setEnabled(false);
                return;
            }
        }
        this.anL.setEnabled(false);
        this.anK.setEnabled(false);
    }

    public void zJ() {
        if (!this.anS) {
            this.anM.setVisibility(0);
        }
    }

    public void aU(boolean z) {
        this.anT = z;
        if (this.anN != null) {
            View findViewWithTag = this.anN.findViewWithTag(String.valueOf(this.anN.getCurrentItem()));
            if (findViewWithTag instanceof z) {
                ((z) findViewWithTag).aU(z);
            }
        }
    }

    public void zK() {
        if (!this.anS) {
            this.anM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.anN.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.anN.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.anN.setOffscreenPageLimit(i);
        this.anQ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.anQ = (int) (this.anQ * 0.8d);
        if (this.anQ < 6291456) {
            this.anR = true;
            this.anQ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.anR = false;
        }
        PagerAdapter adapter = this.anN.getAdapter();
        if (adapter != null && (adapter instanceof j)) {
            ((j) adapter).setGifMaxUseableMem(this.anQ);
        }
    }

    private void setAdapter(j jVar) {
        jVar.a(this.amR);
        this.anN.setAdapter(jVar);
    }

    public void setCurrentItem(int i, boolean z) {
        this.anN.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.anP.setTempSize(i);
        this.anP.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.anP.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.anP.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anP.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.anP.setData(arrayList);
        this.anP.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.anP.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.anP.setHasNext(z);
        this.anP.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.anP.getHasNext();
    }

    public void setNextTitle(String str) {
        this.anP.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.anN.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return com.baidu.tbadk.core.util.c.e(imageBitmap, 100);
        }
        return imageData;
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.anN.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.ana = z;
        if (this.anP != null) {
            this.anP.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.anP != null) {
            this.anP.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.anP != null) {
            this.anP.setHeadImage(z);
        }
    }

    public void a(j.a aVar) {
        this.anP.a(aVar);
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        if (this.anP != null) {
            this.anP.setOriImgSelectedCallback(bVar);
        }
    }
}
