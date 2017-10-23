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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private boolean auG;
    private a.f auw;
    private a.e aux;
    private Button avn;
    private Button avo;
    private LinearLayout avp;
    private b avq;
    private ViewPager.OnPageChangeListener avr;
    private c avs;
    private int avt;
    private boolean avu;
    private boolean avv;
    private boolean avw;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.avn = null;
        this.avo = null;
        this.avp = null;
        this.mOnClickListener = null;
        this.avq = null;
        this.mOnPageChangeListener = null;
        this.avr = null;
        this.auw = null;
        this.avs = null;
        this.aux = null;
        this.avt = 0;
        this.avu = true;
        this.avv = false;
        this.auG = false;
        this.avw = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.avq != null) {
            this.avq.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.avn = null;
        this.avo = null;
        this.avp = null;
        this.mOnClickListener = null;
        this.avq = null;
        this.mOnPageChangeListener = null;
        this.avr = null;
        this.auw = null;
        this.avs = null;
        this.aux = null;
        this.avt = 0;
        this.avu = true;
        this.avv = false;
        this.auG = false;
        this.avw = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.avn = null;
        this.avo = null;
        this.avp = null;
        this.mOnClickListener = null;
        this.avq = null;
        this.mOnPageChangeListener = null;
        this.avr = null;
        this.auw = null;
        this.avs = null;
        this.aux = null;
        this.avt = 0;
        this.avu = true;
        this.avv = false;
        this.auG = false;
        this.avw = false;
        init();
    }

    private void init() {
        this.avv = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.widget.a currentImageView;
                if (view == MultiImageView.this.avn) {
                    com.baidu.tbadk.widget.a currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.Hh();
                    }
                } else if (view == MultiImageView.this.avo && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.Hi();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.avr != null) {
                    MultiImageView.this.avr.onPageScrollStateChanged(i);
                }
                if (MultiImageView.this.avq != null) {
                    View findViewWithTag = MultiImageView.this.avq.findViewWithTag(String.valueOf(MultiImageView.this.avq.getCurrentItem()));
                    if (findViewWithTag instanceof f) {
                        f fVar = (f) findViewWithTag;
                        if (i == 0) {
                            if (fVar.Bc()) {
                                fVar.awW.setVisibility(0);
                                return;
                            } else {
                                fVar.awW.setVisibility(8);
                                return;
                            }
                        }
                        fVar.awW.setVisibility(8);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.avr != null) {
                    MultiImageView.this.avr.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                View findViewWithTag = MultiImageView.this.avq.findViewWithTag(String.valueOf(i));
                if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                    ((f) findViewWithTag).bl(MultiImageView.this.avw);
                    com.baidu.tbadk.widget.a imageView = ((f) findViewWithTag).getImageView();
                    if (imageView != null) {
                        MultiImageView.this.avq.setSelectedView(imageView);
                        imageView.Hj();
                    }
                }
                int childCount = MultiImageView.this.avq.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.avq.getChildAt(i2);
                    if (childAt != null && (childAt instanceof f)) {
                        ((f) childAt).AY();
                    }
                }
                if (MultiImageView.this.avu && j.hh()) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = MultiImageView.this.avq.getChildAt(i3);
                        if (childAt2 != null && (childAt2 instanceof f)) {
                            ((f) childAt2).bp(MultiImageView.this.auG);
                        }
                    }
                }
                if (MultiImageView.this.avr != null) {
                    MultiImageView.this.avr.onPageSelected(i);
                }
            }
        };
        this.auw = new a.f() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (MultiImageView.this.avq.getSelectedView() == aVar) {
                    MultiImageView.this.setZoomButton(aVar);
                }
            }
        };
        this.aux = new a.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar) {
                if (aVar == MultiImageView.this.avq.getCurrentView()) {
                    if (MultiImageView.this.avu) {
                        int childCount = MultiImageView.this.avq.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.avq.getChildAt(i);
                            if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != aVar) {
                                ((f) childAt).release();
                            }
                        }
                    }
                    aVar.play();
                }
            }
        };
    }

    public void di(int i) {
        if (this.mSkinType != i && this.avq != null) {
            int childCount = this.avq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.avq.getChildAt(i2);
                if (childAt instanceof f) {
                    ((f) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.avq.getCurrentView() != null) {
            if (this.avu) {
                int childCount = this.avq.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.avq.getChildAt(i);
                    if (childAt != null && (childAt instanceof f) && ((f) childAt).getImageView() != this.avq.getCurrentView()) {
                        ((f) childAt).release();
                    }
                }
            }
            View findViewWithTag = this.avq.findViewWithTag(String.valueOf(this.avq.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof f)) {
                ((f) findViewWithTag).j(this.auG, true);
            }
            this.avq.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.avq.getCurrentView() != null) {
            this.avq.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.avq != null) {
            int childCount = this.avq.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.avq.getChildAt(i);
                if (childAt != null && (childAt instanceof f)) {
                    ((f) childAt).onDestroy();
                }
            }
        }
    }

    public void ev(int i) {
        View findViewWithTag = this.avq.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof f)) {
            ((f) findViewWithTag).j(this.auG, true);
        }
    }

    private void initUI() {
        this.avq = new b(getContext());
        this.avq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.avq.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.avq);
        this.avp = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.avp.setOrientation(0);
        this.avp.setLayoutParams(layoutParams);
        addView(this.avp);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.avo = new Button(getContext());
        this.avo.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomout));
        this.avo.setLayoutParams(layoutParams2);
        this.avo.setOnClickListener(this.mOnClickListener);
        this.avo.setEnabled(false);
        this.avp.addView(this.avo);
        this.avn = new Button(getContext());
        this.avn.setBackgroundDrawable(getContext().getResources().getDrawable(d.g.image_zoomin));
        this.avn.setLayoutParams(layoutParams2);
        this.avn.setOnClickListener(this.mOnClickListener);
        this.avn.setEnabled(false);
        this.avp.addView(this.avn);
        if (this.avv) {
            this.avp.setVisibility(8);
        }
        this.avs = new c(getContext(), null, this.aux);
        setAdapter(this.avs);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.avr = onPageChangeListener;
    }

    public int getItemNum() {
        return this.avs.getCount();
    }

    public int getCurrentItem() {
        return this.avq.getCurrentItem();
    }

    public void setZoomButton(com.baidu.tbadk.widget.a aVar) {
        if (aVar != null) {
            if (aVar.canZoomIn()) {
                this.avn.setEnabled(true);
            } else {
                this.avn.setEnabled(false);
            }
            if (aVar.canZoomOut()) {
                this.avo.setEnabled(true);
                return;
            } else {
                this.avo.setEnabled(false);
                return;
            }
        }
        this.avo.setEnabled(false);
        this.avn.setEnabled(false);
    }

    public void AG() {
        if (!this.avv) {
            this.avp.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.avw = z;
        if (this.avq != null) {
            View findViewWithTag = this.avq.findViewWithTag(String.valueOf(this.avq.getCurrentItem()));
            if (findViewWithTag instanceof f) {
                ((f) findViewWithTag).bl(z);
            }
        }
    }

    public void AH() {
        if (!this.avv) {
            this.avp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.a getCurrentImageView() {
        return this.avq.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.avq.setPageMargin(i);
    }

    public void H(int i, int i2) {
        this.avq.setOffscreenPageLimit(i);
        this.avt = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.avt = (int) (this.avt * 0.8d);
        if (this.avt < 6291456) {
            this.avu = true;
            this.avt = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.avu = false;
        }
        PagerAdapter adapter = this.avq.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            ((c) adapter).setGifMaxUseableMem(this.avt);
        }
    }

    private void setAdapter(c cVar) {
        cVar.a(this.auw);
        this.avq.setAdapter(cVar);
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.avs);
        this.avq.setCurrentItem(i, z);
    }

    public void setTempSize(int i) {
        this.avs.setTempSize(i);
        this.avs.notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avs.setAddSize(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.avs.setOnClickListener(onClickListener);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.avs.a(onTouchListener);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avs.setOnLongClickListener(onLongClickListener);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.avs.setData(arrayList);
        this.avs.notifyDataSetChanged();
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avs.setDrageToExitListener(dVar);
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avs.setAssistUrls(map);
    }

    public void setHasNext(boolean z) {
        this.avs.setHasNext(z);
        this.avs.notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.avs.getHasNext();
    }

    public void setNextTitle(String str) {
        this.avs.setNextTitle(str);
    }

    public byte[] getCurrentImageData() {
        Bitmap imageBitmap;
        com.baidu.tbadk.widget.a selectedView = this.avq.getSelectedView();
        if (selectedView == null) {
            return null;
        }
        byte[] imageData = selectedView.getImageData();
        if (imageData == null && selectedView.getImageType() != 2 && (imageBitmap = selectedView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.avs != null) {
            this.avs.setDrageToExitListener(dVar);
        }
    }

    public String getCurrentImageUrl() {
        com.baidu.tbadk.widget.a selectedView = this.avq.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }

    public void setAllowLocalUrl(boolean z) {
        this.auG = z;
        if (this.avs != null) {
            this.avs.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.avs != null) {
            this.avs.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avs != null) {
            this.avs.setHeadImage(z);
        }
    }

    public void a(c.a aVar) {
        this.avs.a(aVar);
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        if (this.avs != null) {
            this.avs.setOriImgSelectedCallback(bVar);
        }
    }
}
