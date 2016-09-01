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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.i;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean aoA;
    private a.e aor;
    private a.d aos;
    private Button api;
    private Button apj;
    private LinearLayout apk;
    private h apl;
    private ViewPager.OnPageChangeListener apm;
    private i apn;
    private int apo;
    private boolean apq;
    private boolean apr;
    private boolean aps;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.api = null;
        this.apj = null;
        this.apk = null;
        this.mOnClickListener = null;
        this.apl = null;
        this.mOnPageChangeListener = null;
        this.apm = null;
        this.aor = null;
        this.apn = null;
        this.aos = null;
        this.apo = 0;
        this.apq = true;
        this.apr = false;
        this.aoA = false;
        this.aps = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.apl != null) {
            this.apl.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.api = null;
        this.apj = null;
        this.apk = null;
        this.mOnClickListener = null;
        this.apl = null;
        this.mOnPageChangeListener = null;
        this.apm = null;
        this.aor = null;
        this.apn = null;
        this.aos = null;
        this.apo = 0;
        this.apq = true;
        this.apr = false;
        this.aoA = false;
        this.aps = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.api = null;
        this.apj = null;
        this.apk = null;
        this.mOnClickListener = null;
        this.apl = null;
        this.mOnPageChangeListener = null;
        this.apm = null;
        this.aor = null;
        this.apn = null;
        this.aos = null;
        this.apo = 0;
        this.apq = true;
        this.apr = false;
        this.aoA = false;
        this.aps = false;
        init();
    }

    private void init() {
        this.apr = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.aor = new q(this);
        this.aos = new r(this);
    }

    public void dc(int i) {
        if (this.mSkinType != i && this.apl != null) {
            int childCount = this.apl.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.apl.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.apl.getCurrentView() != null) {
            if (this.apq) {
                int childCount = this.apl.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.apl.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.apl.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.apl.findViewWithTag(String.valueOf(this.apl.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).h(this.aoA, true);
            }
            this.apl.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.apl.getCurrentView() != null) {
            this.apl.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.apl != null) {
            int childCount = this.apl.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.apl.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.apl = new h(getContext());
        this.apl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.apl.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.apl);
        this.apk = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.apk.setOrientation(0);
        this.apk.setLayoutParams(layoutParams);
        addView(this.apk);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.apj = new Button(getContext());
        this.apj.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomout));
        this.apj.setLayoutParams(layoutParams2);
        this.apj.setOnClickListener(this.mOnClickListener);
        this.apj.setEnabled(false);
        this.apk.addView(this.apj);
        this.api = new Button(getContext());
        this.api.setBackgroundDrawable(getContext().getResources().getDrawable(t.f.image_zoomin));
        this.api.setLayoutParams(layoutParams2);
        this.api.setOnClickListener(this.mOnClickListener);
        this.api.setEnabled(false);
        this.apk.addView(this.api);
        if (this.apr) {
            this.apk.setVisibility(8);
        }
        this.apn = new i(getContext(), null, this.aos);
        setAdapter(this.apn);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.apm = onPageChangeListener;
    }

    public int getItemNum() {
        return this.apn.getCount();
    }

    public int getCurrentItem() {
        return this.apl.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.api.setEnabled(true);
            } else {
                this.api.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.apj.setEnabled(true);
                return;
            } else {
                this.apj.setEnabled(false);
                return;
            }
        }
        this.apj.setEnabled(false);
        this.api.setEnabled(false);
    }

    public void AR() {
        if (!this.apr) {
            this.apk.setVisibility(0);
        }
    }

    public void bk(boolean z) {
        this.aps = z;
        if (this.apl != null) {
            View findViewWithTag = this.apl.findViewWithTag(String.valueOf(this.apl.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bk(z);
            }
        }
    }

    public void AS() {
        if (!this.apr) {
            this.apk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.apl.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.apl.setPageMargin(i);
    }

    public void C(int i, int i2) {
        this.apl.setOffscreenPageLimit(i);
        this.apo = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.apo = (int) (this.apo * 0.8d);
        if (this.apo < 6291456) {
            this.apq = true;
            this.apo = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.apq = false;
        }
        PagerAdapter adapter = this.apl.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.apo);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.aor);
        this.apl.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.apn);
        this.apl.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.apn.setTempSize(i);
        this.apn.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.apn.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.apn.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.apn.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.apn.setData(arrayList);
        this.apn.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.apn.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.apn.setHasNext(z);
        this.apn.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.apn.getHasNext();
    }

    public void setNextTitle(String str) {
        this.apn.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.apl.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.apl.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoA = z;
        if (this.apn != null) {
            this.apn.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.apn != null) {
            this.apn.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.apn != null) {
            this.apn.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.apn.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.apn != null) {
            this.apn.setOriImgSelectedCallback(bVar);
        }
    }
}
