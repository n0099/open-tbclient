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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e alk;
    private a.d alm;
    private boolean alu;
    private Button amc;
    private Button amd;
    private LinearLayout ame;
    private h amf;
    private ViewPager.OnPageChangeListener amg;
    private i amh;
    private int ami;
    private boolean amj;
    private boolean amk;
    private boolean aml;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.amc = null;
        this.amd = null;
        this.ame = null;
        this.mOnClickListener = null;
        this.amf = null;
        this.mOnPageChangeListener = null;
        this.amg = null;
        this.alk = null;
        this.amh = null;
        this.alm = null;
        this.ami = 0;
        this.amj = true;
        this.amk = false;
        this.alu = false;
        this.aml = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.amf != null) {
            this.amf.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.amc = null;
        this.amd = null;
        this.ame = null;
        this.mOnClickListener = null;
        this.amf = null;
        this.mOnPageChangeListener = null;
        this.amg = null;
        this.alk = null;
        this.amh = null;
        this.alm = null;
        this.ami = 0;
        this.amj = true;
        this.amk = false;
        this.alu = false;
        this.aml = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.amc = null;
        this.amd = null;
        this.ame = null;
        this.mOnClickListener = null;
        this.amf = null;
        this.mOnPageChangeListener = null;
        this.amg = null;
        this.alk = null;
        this.amh = null;
        this.alm = null;
        this.ami = 0;
        this.amj = true;
        this.amk = false;
        this.alu = false;
        this.aml = false;
        init();
    }

    private void init() {
        this.amk = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.alk = new q(this);
        this.alm = new r(this);
    }

    public void cO(int i) {
        if (this.mSkinType != i && this.amf != null) {
            int childCount = this.amf.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.amf.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.amf.getCurrentView() != null) {
            if (this.amj) {
                int childCount = this.amf.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.amf.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.amf.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.amf.findViewWithTag(String.valueOf(this.amf.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).f(this.alu, true);
            }
            this.amf.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.amf.getCurrentView() != null) {
            this.amf.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.amf != null) {
            int childCount = this.amf.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.amf.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.amf = new h(getContext());
        this.amf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.amf.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.amf);
        this.ame = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ame.setOrientation(0);
        this.ame.setLayoutParams(layoutParams);
        addView(this.ame);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.amd = new Button(getContext());
        this.amd.setBackgroundDrawable(getContext().getResources().getDrawable(u.f.image_zoomout));
        this.amd.setLayoutParams(layoutParams2);
        this.amd.setOnClickListener(this.mOnClickListener);
        this.amd.setEnabled(false);
        this.ame.addView(this.amd);
        this.amc = new Button(getContext());
        this.amc.setBackgroundDrawable(getContext().getResources().getDrawable(u.f.image_zoomin));
        this.amc.setLayoutParams(layoutParams2);
        this.amc.setOnClickListener(this.mOnClickListener);
        this.amc.setEnabled(false);
        this.ame.addView(this.amc);
        if (this.amk) {
            this.ame.setVisibility(8);
        }
        this.amh = new i(getContext(), null, this.alm);
        setAdapter(this.amh);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.amg = onPageChangeListener;
    }

    public int getItemNum() {
        return this.amh.getCount();
    }

    public int getCurrentItem() {
        return this.amf.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.amc.setEnabled(true);
            } else {
                this.amc.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.amd.setEnabled(true);
                return;
            } else {
                this.amd.setEnabled(false);
                return;
            }
        }
        this.amd.setEnabled(false);
        this.amc.setEnabled(false);
    }

    public void zC() {
        if (!this.amk) {
            this.ame.setVisibility(0);
        }
    }

    public void bi(boolean z) {
        this.aml = z;
        if (this.amf != null) {
            View findViewWithTag = this.amf.findViewWithTag(String.valueOf(this.amf.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bi(z);
            }
        }
    }

    public void zD() {
        if (!this.amk) {
            this.ame.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.amf.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.amf.setPageMargin(i);
    }

    public void A(int i, int i2) {
        this.amf.setOffscreenPageLimit(i);
        this.ami = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.ami = (int) (this.ami * 0.8d);
        if (this.ami < 6291456) {
            this.amj = true;
            this.ami = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.amj = false;
        }
        PagerAdapter adapter = this.amf.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.ami);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.alk);
        this.amf.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.amh);
        this.amf.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.amh.setTempSize(i);
        this.amh.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.amh.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.amh.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amh.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.amh.setData(arrayList);
        this.amh.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.amh.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.amh.setHasNext(z);
        this.amh.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.amh.getHasNext();
    }

    public void setNextTitle(String str) {
        this.amh.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.amf.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.amf.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.alu = z;
        if (this.amh != null) {
            this.amh.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.amh != null) {
            this.amh.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.amh != null) {
            this.amh.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.amh.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.amh != null) {
            this.amh.setOriImgSelectedCallback(bVar);
        }
    }
}
