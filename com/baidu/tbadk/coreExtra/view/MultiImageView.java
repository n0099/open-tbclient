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
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean atB;
    private b.e ats;
    private b.d att;
    private Button auj;
    private Button auk;
    private LinearLayout aul;
    private h aum;
    private ViewPager.OnPageChangeListener aun;
    private i auo;
    private int aup;
    private boolean auq;
    private boolean aur;
    private boolean aus;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.auj = null;
        this.auk = null;
        this.aul = null;
        this.mOnClickListener = null;
        this.aum = null;
        this.mOnPageChangeListener = null;
        this.aun = null;
        this.ats = null;
        this.auo = null;
        this.att = null;
        this.aup = 0;
        this.auq = true;
        this.aur = false;
        this.atB = false;
        this.aus = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.aum != null) {
            this.aum.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.auj = null;
        this.auk = null;
        this.aul = null;
        this.mOnClickListener = null;
        this.aum = null;
        this.mOnPageChangeListener = null;
        this.aun = null;
        this.ats = null;
        this.auo = null;
        this.att = null;
        this.aup = 0;
        this.auq = true;
        this.aur = false;
        this.atB = false;
        this.aus = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.auj = null;
        this.auk = null;
        this.aul = null;
        this.mOnClickListener = null;
        this.aum = null;
        this.mOnPageChangeListener = null;
        this.aun = null;
        this.ats = null;
        this.auo = null;
        this.att = null;
        this.aup = 0;
        this.auq = true;
        this.aur = false;
        this.atB = false;
        this.aus = false;
        init();
    }

    private void init() {
        this.aur = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new o(this);
        this.mOnPageChangeListener = new p(this);
        this.ats = new q(this);
        this.att = new r(this);
    }

    public void db(int i) {
        if (this.mSkinType != i && this.aum != null) {
            int childCount = this.aum.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aum.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.aum.getCurrentView() != null) {
            if (this.auq) {
                int childCount = this.aum.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.aum.getChildAt(i);
                    if (childAt != null && (childAt instanceof u) && ((u) childAt).getImageView() != this.aum.getCurrentView()) {
                        ((u) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.aum.findViewWithTag(String.valueOf(this.aum.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof u)) {
                ((u) findViewWithTag).g(this.atB, true);
            }
            this.aum.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.aum.getCurrentView() != null) {
            this.aum.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.aum != null) {
            int childCount = this.aum.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.aum.getChildAt(i);
                if (childAt != null && (childAt instanceof u)) {
                    ((u) childAt).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.aum = new h(getContext());
        this.aum.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aum.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.aum);
        this.aul = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.aul.setOrientation(0);
        this.aul.setLayoutParams(layoutParams);
        addView(this.aul);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.auk = new Button(getContext());
        this.auk.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomout));
        this.auk.setLayoutParams(layoutParams2);
        this.auk.setOnClickListener(this.mOnClickListener);
        this.auk.setEnabled(false);
        this.aul.addView(this.auk);
        this.auj = new Button(getContext());
        this.auj.setBackgroundDrawable(getContext().getResources().getDrawable(w.g.image_zoomin));
        this.auj.setLayoutParams(layoutParams2);
        this.auj.setOnClickListener(this.mOnClickListener);
        this.auj.setEnabled(false);
        this.aul.addView(this.auj);
        if (this.aur) {
            this.aul.setVisibility(8);
        }
        this.auo = new i(getContext(), null, this.att);
        setAdapter(this.auo);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aun = onPageChangeListener;
    }

    public int getItemNum() {
        return this.auo.getCount();
    }

    public int getCurrentItem() {
        return this.aum.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            if (bVar.canZoomIn()) {
                this.auj.setEnabled(true);
            } else {
                this.auj.setEnabled(false);
            }
            if (bVar.canZoomOut()) {
                this.auk.setEnabled(true);
                return;
            } else {
                this.auk.setEnabled(false);
                return;
            }
        }
        this.auk.setEnabled(false);
        this.auj.setEnabled(false);
    }

    public void AM() {
        if (!this.aur) {
            this.aul.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.aus = z;
        if (this.aum != null) {
            View findViewWithTag = this.aum.findViewWithTag(String.valueOf(this.aum.getCurrentItem()));
            if (findViewWithTag instanceof u) {
                ((u) findViewWithTag).bo(z);
            }
        }
    }

    public void AN() {
        if (!this.aur) {
            this.aul.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.b getCurrentImageView() {
        return this.aum.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.aum.setPageMargin(i);
    }

    public void J(int i, int i2) {
        this.aum.setOffscreenPageLimit(i);
        this.aup = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.aup = (int) (this.aup * 0.8d);
        if (this.aup < 6291456) {
            this.auq = true;
            this.aup = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.auq = false;
        }
        PagerAdapter adapter = this.aum.getAdapter();
        if (adapter != null && (adapter instanceof i)) {
            ((i) adapter).setGifMaxUseableMem(this.aup);
        }
    }

    private void setAdapter(i iVar) {
        iVar.a(this.ats);
        this.aum.setAdapter(iVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.auo);
        this.aum.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.auo.setTempSize(i);
        this.auo.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.auo.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.auo.setOnClickListener(onClickListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auo.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.auo.setData(arrayList);
        this.auo.notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auo.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.auo.setHasNext(z);
        this.auo.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.auo.getHasNext();
    }

    public void setNextTitle(String str) {
        this.auo.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.b selectedView = this.aum.getSelectedView();
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
        com.baidu.tbadk.widget.b selectedView = this.aum.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.atB = z;
        if (this.auo != null) {
            this.auo.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.auo != null) {
            this.auo.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.auo != null) {
            this.auo.setHeadImage(z);
        }
    }

    public void a(i.a aVar) {
        this.auo.a(aVar);
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        if (this.auo != null) {
            this.auo.setOriImgSelectedCallback(bVar);
        }
    }
}
