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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes21.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> dtS;
    private DragImageView.g fiE;
    private DragImageView.e fiF;
    private ImagePagerAdapter.b fiG;
    private boolean fiP;
    private Button fjN;
    private Button fjO;
    private LinearLayout fjP;
    private GalleryViewPager fjQ;
    private ImagePagerAdapter fjR;
    private ViewPager.OnPageChangeListener fjS;
    private int fjT;
    private boolean fjU;
    private boolean fjV;
    private int fjW;
    private Map<String, ImageUrlData> fjX;
    private boolean fjY;
    private boolean fjZ;
    protected a fka;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fjW;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fjN = null;
        this.fjO = null;
        this.fjP = null;
        this.fjQ = null;
        this.fjR = null;
        this.mOnClickListener = null;
        this.fiF = null;
        this.mOnPageChangeListener = null;
        this.fjS = null;
        this.fiE = null;
        this.fiG = null;
        this.fjT = 0;
        this.fjU = true;
        this.fjV = false;
        this.fiP = false;
        this.fjW = 1;
        this.dtS = null;
        this.fjX = null;
        this.fjY = false;
        this.fjZ = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fjQ != null) {
            this.fjQ.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fjN = null;
        this.fjO = null;
        this.fjP = null;
        this.fjQ = null;
        this.fjR = null;
        this.mOnClickListener = null;
        this.fiF = null;
        this.mOnPageChangeListener = null;
        this.fjS = null;
        this.fiE = null;
        this.fiG = null;
        this.fjT = 0;
        this.fjU = true;
        this.fjV = false;
        this.fiP = false;
        this.fjW = 1;
        this.dtS = null;
        this.fjX = null;
        this.fjY = false;
        this.fjZ = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fjN = null;
        this.fjO = null;
        this.fjP = null;
        this.fjQ = null;
        this.fjR = null;
        this.mOnClickListener = null;
        this.fiF = null;
        this.mOnPageChangeListener = null;
        this.fjS = null;
        this.fiE = null;
        this.fiG = null;
        this.fjT = 0;
        this.fjU = true;
        this.fjV = false;
        this.fiP = false;
        this.fjW = 1;
        this.dtS = null;
        this.fjX = null;
        this.fjY = false;
        this.fjZ = true;
        init();
    }

    public void init() {
        this.fjV = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fjN) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fjO && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fjS != null) {
                    MultiImageView.this.fjS.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fjS != null) {
                    MultiImageView.this.fjS.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fjW) {
                    MultiImageView.this.fjW = i + 1;
                }
                if (MultiImageView.this.fjQ != null) {
                    int childCount = MultiImageView.this.fjQ.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fjQ.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bye();
                        }
                    }
                }
                if (MultiImageView.this.fjS != null) {
                    MultiImageView.this.fjS.onPageSelected(i);
                }
            }
        };
        this.fiE = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fjQ != null && MultiImageView.this.fjQ.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fiF = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fjQ != null && dragImageView == MultiImageView.this.fjQ.getCurrentView()) {
                    if (MultiImageView.this.fjU) {
                        int childCount = MultiImageView.this.fjQ.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fjQ.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fiG = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fjQ != null) {
                        MultiImageView.this.fjQ.setCurrentView(null);
                    }
                    MultiImageView.this.jP(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fjQ != null) {
                        MultiImageView.this.fjQ.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fiF != null) {
                        MultiImageView.this.fiF.a(imageView);
                    }
                }
                urlDragImageView.byc();
                urlDragImageView.byb();
                urlDragImageView.E(MultiImageView.this.fiP, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fjR != null) {
            return this.fjR.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fjQ != null) {
            int childCount = this.fjQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fjQ.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fjQ != null && this.fjQ.getCurrentView() != null) {
            if (this.fjU) {
                int childCount = this.fjQ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fjQ.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fjQ.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(this.fjQ.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fiP, true);
            }
            this.fjQ.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fjQ != null && this.fjQ.getCurrentView() != null) {
            this.fjQ.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fjQ != null) {
            int childCount = this.fjQ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fjQ.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fka != null) {
            this.fka.setAssistUrl(imageUrlData);
            if (this.fjY || imageUrlData == null) {
                jP(false);
                return;
            }
            if (!this.fka.bxK()) {
                this.fka.jN(false);
            }
            if (!this.fka.isShown()) {
                t(true, 150);
            }
        }
    }

    public void qV(int i) {
        if (this.fjQ != null) {
            View findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                jP(false);
            }
        }
    }

    public void qW(int i) {
        View findViewWithTag;
        if (this.fjQ != null && (findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fiP, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData De = De(str);
                urlDragImageView.setAssistUrl(De);
                c(De);
            }
            urlDragImageView.E(this.fiP, true);
        }
    }

    private ImageUrlData De(String str) {
        if (TextUtils.isEmpty(str) || this.fjX == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fjX.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qX(int i) {
        if (this.fjQ == null) {
            return null;
        }
        View findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qY(int i) {
        View findViewWithTag;
        if (this.fjQ != null && (findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).byg();
        }
    }

    private void initUI() {
        this.fjQ = new GalleryViewPager(getContext());
        this.fjQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fjQ.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fjQ);
        this.fjP = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fjP.setOrientation(0);
        this.fjP.setLayoutParams(layoutParams);
        addView(this.fjP);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fjO = new Button(getContext());
        ap.setBackgroundResource(this.fjO, R.drawable.image_zoomout, 0);
        this.fjO.setLayoutParams(layoutParams2);
        this.fjO.setOnClickListener(this.mOnClickListener);
        this.fjO.setEnabled(false);
        this.fjP.addView(this.fjO);
        this.fjN = new Button(getContext());
        ap.setBackgroundResource(this.fjN, R.drawable.image_zoomin, 0);
        this.fjN.setLayoutParams(layoutParams2);
        this.fjN.setOnClickListener(this.mOnClickListener);
        this.fjN.setEnabled(false);
        this.fjP.addView(this.fjN);
        if (this.fjV) {
            this.fjP.setVisibility(8);
        }
        this.fjR = new ImagePagerAdapter(getContext(), this.fiF);
        this.fjR.a(this.fiG);
        setAdapter(this.fjR);
        this.fka = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fjR != null) {
            this.fjR.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fjS = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fjR == null) {
            return 0;
        }
        return this.fjR.getCount();
    }

    public int getCurrentItem() {
        if (this.fjQ == null) {
            return 0;
        }
        return this.fjQ.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fjQ == null) {
            return null;
        }
        View findViewWithTag = this.fjQ.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fjQ == null) {
            return null;
        }
        return this.fjQ.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fjN.setEnabled(true);
            } else {
                this.fjN.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fjO.setEnabled(true);
                return;
            } else {
                this.fjO.setEnabled(false);
                return;
            }
        }
        this.fjO.setEnabled(false);
        this.fjN.setEnabled(false);
    }

    public void bxS() {
        if (!this.fjV) {
            this.fjP.setVisibility(0);
        }
    }

    public boolean bxT() {
        return this.fjY;
    }

    public void jP(boolean z) {
        if (this.fka != null) {
            this.fka.setVisibility(z ? 0 : 8);
        }
    }

    public void t(boolean z, int i) {
        if (this.fjZ && this.fka != null) {
            this.fka.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fjQ != null) {
            int childCount = this.fjQ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fjQ.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fka != null) {
                this.fka.setUserId(str);
            }
        }
    }

    public void bxU() {
        if (!this.fjV) {
            this.fjP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fjQ == null) {
            return null;
        }
        return this.fjQ.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fjQ != null) {
            this.fjQ.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fjQ != null) {
            this.fjQ.setOffscreenPageLimit(i);
            this.fjT = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fjT = (int) (this.fjT * 0.8d);
            if (this.fjT < 6291456) {
                this.fjU = true;
                this.fjT = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fjU = false;
            }
            PagerAdapter adapter = this.fjQ.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fjT);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fiE);
        }
        if (this.fjQ != null) {
            this.fjQ.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fjR);
        if (this.fjQ != null) {
            this.fjQ.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fjR != null) {
            this.fjR.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fjR != null) {
            this.fjR.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fjR != null) {
            this.fjR.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fjR != null) {
            this.fjR.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fjR != null) {
            this.fjR.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dtS = arrayList;
        if (this.fjR != null) {
            this.fjR.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fjX = map;
        if (this.fjR != null) {
            this.fjR.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fjR != null) {
            this.fjR.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fjR == null) {
            return false;
        }
        return this.fjR.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fjR != null) {
            this.fjR.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fjQ == null || (currentView = this.fjQ.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fjR != null) {
            this.fjR.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fjQ == null || (currentView = this.fjQ.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fjQ == null || (currentView = this.fjQ.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fjQ != null && (currentView = this.fjQ.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fjQ != null) {
            this.fjQ.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fiP = z;
        if (this.fjR != null) {
            this.fjR.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fjR != null) {
            this.fjR.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fjR != null) {
            this.fjR.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fjR != null) {
            this.fjR.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fjR != null) {
            this.fjR.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fjZ = z;
        jP(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fka != null) {
            this.fka.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fka != null) {
            this.fka.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fka != null) {
            this.fka.setOnReplyClickListener(onClickListener);
        }
    }
}
