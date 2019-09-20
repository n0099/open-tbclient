package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g cnD;
    private DragImageView.e cnE;
    private ImagePagerAdapter.b cnF;
    private boolean cnP;
    private Button coO;
    private Button coP;
    private LinearLayout coQ;
    private GalleryViewPager coR;
    private ImagePagerAdapter coS;
    private ViewPager.OnPageChangeListener coT;
    private int coU;
    private boolean coV;
    private boolean coW;
    private int coX;
    private ArrayList<String> coY;
    private Map<String, ImageUrlData> coZ;
    private boolean cpa;
    protected b cpb;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.coX;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.coO = null;
        this.coP = null;
        this.coQ = null;
        this.coR = null;
        this.coS = null;
        this.mOnClickListener = null;
        this.cnE = null;
        this.mOnPageChangeListener = null;
        this.coT = null;
        this.cnD = null;
        this.cnF = null;
        this.coU = 0;
        this.coV = true;
        this.coW = false;
        this.cnP = false;
        this.coX = 1;
        this.coY = null;
        this.coZ = null;
        this.cpa = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.coR != null) {
            this.coR.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.coO = null;
        this.coP = null;
        this.coQ = null;
        this.coR = null;
        this.coS = null;
        this.mOnClickListener = null;
        this.cnE = null;
        this.mOnPageChangeListener = null;
        this.coT = null;
        this.cnD = null;
        this.cnF = null;
        this.coU = 0;
        this.coV = true;
        this.coW = false;
        this.cnP = false;
        this.coX = 1;
        this.coY = null;
        this.coZ = null;
        this.cpa = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.coO = null;
        this.coP = null;
        this.coQ = null;
        this.coR = null;
        this.coS = null;
        this.mOnClickListener = null;
        this.cnE = null;
        this.mOnPageChangeListener = null;
        this.coT = null;
        this.cnD = null;
        this.cnF = null;
        this.coU = 0;
        this.coV = true;
        this.coW = false;
        this.cnP = false;
        this.coX = 1;
        this.coY = null;
        this.coZ = null;
        this.cpa = false;
        init();
    }

    public void init() {
        this.coW = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.coO) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.axl();
                    }
                } else if (view == MultiImageView.this.coP && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.axm();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.coT != null) {
                    MultiImageView.this.coT.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.coT != null) {
                    MultiImageView.this.coT.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.coX) {
                    MultiImageView.this.coX = i + 1;
                }
                if (MultiImageView.this.coR != null) {
                    int childCount = MultiImageView.this.coR.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.coR.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aqT();
                        }
                    }
                }
                if (MultiImageView.this.coT != null) {
                    MultiImageView.this.coT.onPageSelected(i);
                }
            }
        };
        this.cnD = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.coR != null && MultiImageView.this.coR.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cnE = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.coR != null && dragImageView == MultiImageView.this.coR.getCurrentView()) {
                    if (MultiImageView.this.coV) {
                        int childCount = MultiImageView.this.coR.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.coR.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cnF = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.coR != null) {
                        MultiImageView.this.coR.setCurrentView(null);
                    }
                    MultiImageView.this.eX(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.axn();
                    if (MultiImageView.this.coR != null) {
                        MultiImageView.this.coR.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cnE != null) {
                        MultiImageView.this.cnE.a(imageView);
                    }
                }
                urlDragImageView.aqR();
                urlDragImageView.aqQ();
                urlDragImageView.r(MultiImageView.this.cnP, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.coS != null) {
            return this.coS.getCount();
        }
        return 0;
    }

    public void iJ(int i) {
        if (this.mSkinType != i && this.coR != null) {
            int childCount = this.coR.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.coR.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.coR != null && this.coR.getCurrentView() != null) {
            if (this.coV) {
                int childCount = this.coR.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.coR.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.coR.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.coR.findViewWithTag(String.valueOf(this.coR.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).r(this.cnP, true);
            }
            this.coR.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.coR != null && this.coR.getCurrentView() != null) {
            this.coR.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.coR != null) {
            int childCount = this.coR.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.coR.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cpb != null) {
            this.cpb.setAssistUrl(imageUrlData);
            if (this.cpa || imageUrlData == null) {
                eX(false);
                return;
            }
            if (!this.cpb.aqz()) {
                this.cpb.q(false, false);
            }
            if (!this.cpb.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jZ(int i) {
        if (this.coR != null) {
            View findViewWithTag = this.coR.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eX(false);
            }
        }
    }

    public void ka(int i) {
        View findViewWithTag;
        if (this.coR != null && (findViewWithTag = this.coR.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.r(this.cnP, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pR = pR(str);
                urlDragImageView.setAssistUrl(pR);
                c(pR);
            }
            urlDragImageView.r(this.cnP, true);
        }
    }

    private ImageUrlData pR(String str) {
        if (TextUtils.isEmpty(str) || this.coZ == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.coZ.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String kb(int i) {
        if (this.coR == null) {
            return null;
        }
        View findViewWithTag = this.coR.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void kc(int i) {
        View findViewWithTag;
        if (this.coR != null && (findViewWithTag = this.coR.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aqV();
        }
    }

    private void initUI() {
        this.coR = new GalleryViewPager(getContext());
        this.coR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.coR.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.coR);
        this.coQ = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.coQ.setOrientation(0);
        this.coQ.setLayoutParams(layoutParams);
        addView(this.coQ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.coP = new Button(getContext());
        am.g(this.coP, R.drawable.image_zoomout, 0);
        this.coP.setLayoutParams(layoutParams2);
        this.coP.setOnClickListener(this.mOnClickListener);
        this.coP.setEnabled(false);
        this.coQ.addView(this.coP);
        this.coO = new Button(getContext());
        am.g(this.coO, R.drawable.image_zoomin, 0);
        this.coO.setLayoutParams(layoutParams2);
        this.coO.setOnClickListener(this.mOnClickListener);
        this.coO.setEnabled(false);
        this.coQ.addView(this.coO);
        if (this.coW) {
            this.coQ.setVisibility(8);
        }
        this.coS = new ImagePagerAdapter(getContext(), this.cnE);
        this.coS.a(this.cnF);
        setAdapter(this.coS);
        this.cpb = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.coS != null) {
            this.coS.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.coS != null) {
            this.coS.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.coT = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.coS == null) {
            return 0;
        }
        return this.coS.getCount();
    }

    public int getCurrentItem() {
        if (this.coR == null) {
            return 0;
        }
        return this.coR.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.coR == null) {
            return null;
        }
        View findViewWithTag = this.coR.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.axo()) {
                this.coO.setEnabled(true);
            } else {
                this.coO.setEnabled(false);
            }
            if (dragImageView.axp()) {
                this.coP.setEnabled(true);
                return;
            } else {
                this.coP.setEnabled(false);
                return;
            }
        }
        this.coP.setEnabled(false);
        this.coO.setEnabled(false);
    }

    public void aqG() {
        if (!this.coW) {
            this.coQ.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.cpa = z;
        h(!z, i);
    }

    public boolean aqH() {
        return this.cpa;
    }

    public void eX(boolean z) {
        if (this.cpb != null) {
            this.cpb.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.cpb != null) {
            this.cpb.ai(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.coR != null) {
            int childCount = this.coR.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.coR.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cpb != null) {
                this.cpb.setUserId(str);
            }
        }
    }

    public void aqI() {
        if (!this.coW) {
            this.coQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.coR == null) {
            return null;
        }
        return this.coR.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.coR != null) {
            this.coR.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.coR != null) {
            this.coR.setOffscreenPageLimit(i);
            this.coU = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.coU = (int) (this.coU * 0.8d);
            if (this.coU < 6291456) {
                this.coV = true;
                this.coU = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.coV = false;
            }
            PagerAdapter adapter = this.coR.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.coU);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cnD);
        }
        if (this.coR != null) {
            this.coR.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.coS);
        if (this.coR != null) {
            this.coR.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.coS != null) {
            this.coS.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.coS != null) {
            this.coS.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.coS != null) {
            this.coS.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.coS != null) {
            this.coS.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.coS != null) {
            this.coS.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.coY = arrayList;
        if (this.coS != null) {
            this.coS.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.coZ = map;
        if (this.coS != null) {
            this.coS.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.coS != null) {
            this.coS.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.coS == null) {
            return false;
        }
        return this.coS.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.coS != null) {
            this.coS.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.coR == null || (currentView = this.coR.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.coS != null) {
            this.coS.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.coR == null || (currentView = this.coR.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.coR == null || (currentView = this.coR.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.coR != null && (currentView = this.coR.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.coR != null) {
            this.coR.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cnP = z;
        if (this.coS != null) {
            this.coS.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.coS != null) {
            this.coS.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.coS != null) {
            this.coS.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.coS != null) {
            this.coS.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.coS != null) {
            this.coS.setOriImgSelectedCallback(bVar);
        }
    }
}
