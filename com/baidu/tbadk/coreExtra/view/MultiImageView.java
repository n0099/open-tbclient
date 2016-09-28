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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private a.e anZ;
    private Button aoQ;
    private Button aoR;
    private LinearLayout aoS;
    private h aoT;
    private ViewPager.OnPageChangeListener aoU;
    private i aoV;
    private int aoW;
    private boolean aoX;
    private boolean aoY;
    private boolean aoZ;
    private a.d aoa;
    private boolean aoi;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aoQ = null;
        this.aoR = null;
        this.aoS = null;
        this.mOnClickListener = null;
        this.aoT = null;
        this.mOnPageChangeListener = null;
        this.aoU = null;
        this.anZ = null;
        this.aoV = null;
        this.aoa = null;
        this.aoW = 0;
        this.aoX = true;
        this.aoY = false;
        this.aoi = false;
        this.aoZ = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aoT != null) {
            this.aoT.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aoQ = null;
        this.aoR = null;
        this.aoS = null;
        this.mOnClickListener = null;
        this.aoT = null;
        this.mOnPageChangeListener = null;
        this.aoU = null;
        this.anZ = null;
        this.aoV = null;
        this.aoa = null;
        this.aoW = 0;
        this.aoX = true;
        this.aoY = false;
        this.aoi = false;
        this.aoZ = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.aoQ = null;
        this.aoR = null;
        this.aoS = null;
        this.mOnClickListener = null;
        this.aoT = null;
        this.mOnPageChangeListener = null;
        this.aoU = null;
        this.anZ = null;
        this.aoV = null;
        this.aoa = null;
        this.aoW = 0;
        this.aoX = true;
        this.aoY = false;
        this.aoi = false;
        this.aoZ = false;
        init();
    }

    private void init() {
        this.aoY = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.anZ = new q(this);
        this.aoa = new r(this);
    }

    public void dc(int i) {
        if (this.mSkinType != i && this.aoT != null) {
            int childCount = this.aoT.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aoT.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aoT.getCurrentView() != null) {
            if (this.aoX) {
                int childCount = this.aoT.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aoT.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aoT.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aoT.findViewWithTag(String.valueOf(this.aoT.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).h(this.aoi, true);
            }
            this.aoT.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aoT.getCurrentView() != null) {
            this.aoT.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aoT != null) {
            int childCount = this.aoT.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aoT.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aoT = new h(getContext());
        this.aoT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aoT.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aoT);
        this.aoS = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aoS.setOrientation(0);
        this.aoS.setLayoutParams(layoutParams);
        addView(this.aoS);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aoR = new Button(getContext());
        this.aoR.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomout));
        this.aoR.setLayoutParams(layoutParams2);
        this.aoR.setOnClickListener(this.mOnClickListener);
        this.aoR.setEnabled(false);
        this.aoS.addView(this.aoR);
        this.aoQ = new Button(getContext());
        this.aoQ.setBackgroundDrawable(getContext().getResources().getDrawable(r.f.image_zoomin));
        this.aoQ.setLayoutParams(layoutParams2);
        this.aoQ.setOnClickListener(this.mOnClickListener);
        this.aoQ.setEnabled(false);
        this.aoS.addView(this.aoQ);
        if (this.aoY) {
            this.aoS.setVisibility(8);
        }
        this.aoV = new i(getContext(), null, this.aoa);
        setAdapter(this.aoV);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aoU = onPageChangeListener;
    }

    public int getItemNum() {
        return this.aoV.getCount();
    }

    public int getCurrentItem() {
        return this.aoT.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.aoQ.setEnabled(true);
            } else {
                this.aoQ.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.aoR.setEnabled(true);
                return;
            } else {
                this.aoR.setEnabled(false);
                return;
            }
        }
        this.aoR.setEnabled(false);
        this.aoQ.setEnabled(false);
    }

    public void AU() {
        if (!this.aoY) {
            this.aoS.setVisibility(0);
        }
    }

    public void bj(boolean z) {
        this.aoZ = z;
        if (this.aoT != null) {
            View findViewWithTag = this.aoT.findViewWithTag(String.valueOf(this.aoT.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bj(z);
            }
        }
    }

    public void AV() {
        if (!this.aoY) {
            this.aoS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.aoT.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aoT.setPageMargin(i);
    }

    public void C(int i, int i2) {
        this.aoT.setOffscreenPageLimit(i);
        this.aoW = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aoW = (int) (this.aoW * 0.8d);
        if (this.aoW < 6291456) {
            this.aoX = true;
            this.aoW = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.aoX = false;
        }
        PagerAdapter adapter = this.aoT.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aoW);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.anZ);
        this.aoT.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.aoV);
        this.aoT.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.aoV.setTempSize(i);
        this.aoV.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aoV.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aoV.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoV.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.aoV.setData(arrayList);
        this.aoV.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aoV.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.aoV.setHasNext(z);
        this.aoV.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aoV.getHasNext();
    }

    public void setNextTitle(String str) {
        this.aoV.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.aoT.getSelectedView();
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
        com.baidu.tbadk.widget.a selectedView = this.aoT.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.aoi = z;
        if (this.aoV != null) {
            this.aoV.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.aoV != null) {
            this.aoV.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aoV != null) {
            this.aoV.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.aoV.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.aoV != null) {
            this.aoV.setOriImgSelectedCallback(bVar);
        }
    }
}
