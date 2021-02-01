package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> dFh;
    private DragImageView.e fwA;
    private ImagePagerAdapter.b fwB;
    private boolean fwK;
    private DragImageView.g fwz;
    private Button fxI;
    private Button fxJ;
    private LinearLayout fxK;
    private GalleryViewPager fxL;
    private ImagePagerAdapter fxM;
    private ViewPager.OnPageChangeListener fxN;
    private int fxO;
    private boolean fxP;
    private boolean fxQ;
    private int fxR;
    private Map<String, ImageUrlData> fxS;
    private boolean fxT;
    private boolean fxU;
    protected a fxV;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fxR;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fxI = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.mOnClickListener = null;
        this.fwA = null;
        this.mOnPageChangeListener = null;
        this.fxN = null;
        this.fwz = null;
        this.fwB = null;
        this.fxO = 0;
        this.fxP = true;
        this.fxQ = false;
        this.fwK = false;
        this.fxR = 1;
        this.dFh = null;
        this.fxS = null;
        this.fxT = false;
        this.fxU = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fxL != null) {
            this.fxL.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fxI = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.mOnClickListener = null;
        this.fwA = null;
        this.mOnPageChangeListener = null;
        this.fxN = null;
        this.fwz = null;
        this.fwB = null;
        this.fxO = 0;
        this.fxP = true;
        this.fxQ = false;
        this.fwK = false;
        this.fxR = 1;
        this.dFh = null;
        this.fxS = null;
        this.fxT = false;
        this.fxU = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fxI = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.mOnClickListener = null;
        this.fwA = null;
        this.mOnPageChangeListener = null;
        this.fxN = null;
        this.fwz = null;
        this.fwB = null;
        this.fxO = 0;
        this.fxP = true;
        this.fxQ = false;
        this.fwK = false;
        this.fxR = 1;
        this.dFh = null;
        this.fxS = null;
        this.fxT = false;
        this.fxU = true;
        init();
    }

    public void init() {
        this.fxQ = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fxI) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fxJ && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fxN != null) {
                    MultiImageView.this.fxN.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fxN != null) {
                    MultiImageView.this.fxN.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fxR) {
                    MultiImageView.this.fxR = i + 1;
                }
                if (MultiImageView.this.fxL != null) {
                    int childCount = MultiImageView.this.fxL.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fxL.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bzN();
                        }
                    }
                }
                if (MultiImageView.this.fxN != null) {
                    MultiImageView.this.fxN.onPageSelected(i);
                }
            }
        };
        this.fwz = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fxL != null && MultiImageView.this.fxL.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fwA = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fxL != null && dragImageView == MultiImageView.this.fxL.getCurrentView()) {
                    if (MultiImageView.this.fxP) {
                        int childCount = MultiImageView.this.fxL.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fxL.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fwB = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fxL != null) {
                        MultiImageView.this.fxL.setCurrentView(null);
                    }
                    MultiImageView.this.kB(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fxL != null) {
                        MultiImageView.this.fxL.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fwA != null) {
                        MultiImageView.this.fwA.a(imageView);
                    }
                }
                urlDragImageView.bzL();
                urlDragImageView.bzK();
                urlDragImageView.D(MultiImageView.this.fwK, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fxM != null) {
            return this.fxM.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fxL != null) {
            int childCount = this.fxL.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fxL.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fxL != null && this.fxL.getCurrentView() != null) {
            if (this.fxP) {
                int childCount = this.fxL.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fxL.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fxL.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fxL.findViewWithTag(String.valueOf(this.fxL.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).D(this.fwK, true);
            }
            this.fxL.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fxL != null && this.fxL.getCurrentView() != null) {
            this.fxL.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fxL != null) {
            int childCount = this.fxL.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fxL.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fxV != null) {
            this.fxV.setAssistUrl(imageUrlData);
            if (this.fxT || imageUrlData == null) {
                kB(false);
                return;
            }
            if (!this.fxV.bzt()) {
                this.fxV.kz(false);
            }
            if (!this.fxV.isShown()) {
                s(true, 150);
            }
        }
    }

    public void qF(int i) {
        if (this.fxL != null) {
            View findViewWithTag = this.fxL.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                kB(false);
            }
        }
    }

    public void qG(int i) {
        View findViewWithTag;
        if (this.fxL != null && (findViewWithTag = this.fxL.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.D(this.fwK, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Co = Co(str);
                urlDragImageView.setAssistUrl(Co);
                c(Co);
            }
            urlDragImageView.D(this.fwK, true);
        }
    }

    private ImageUrlData Co(String str) {
        if (TextUtils.isEmpty(str) || this.fxS == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fxS.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qH(int i) {
        if (this.fxL == null) {
            return null;
        }
        View findViewWithTag = this.fxL.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qI(int i) {
        View findViewWithTag;
        if (this.fxL != null && (findViewWithTag = this.fxL.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bzP();
        }
    }

    private void initUI() {
        this.fxL = new GalleryViewPager(getContext());
        this.fxL.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fxL.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fxL);
        this.fxK = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fxK.setOrientation(0);
        this.fxK.setLayoutParams(layoutParams);
        addView(this.fxK);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fxJ = new Button(getContext());
        ap.setBackgroundResource(this.fxJ, R.drawable.image_zoomout, 0);
        this.fxJ.setLayoutParams(layoutParams2);
        this.fxJ.setOnClickListener(this.mOnClickListener);
        this.fxJ.setEnabled(false);
        this.fxK.addView(this.fxJ);
        this.fxI = new Button(getContext());
        ap.setBackgroundResource(this.fxI, R.drawable.image_zoomin, 0);
        this.fxI.setLayoutParams(layoutParams2);
        this.fxI.setOnClickListener(this.mOnClickListener);
        this.fxI.setEnabled(false);
        this.fxK.addView(this.fxI);
        if (this.fxQ) {
            this.fxK.setVisibility(8);
        }
        this.fxM = new ImagePagerAdapter(getContext(), this.fwA);
        this.fxM.a(this.fwB);
        setAdapter(this.fxM);
        this.fxV = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fxM != null) {
            this.fxM.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fxN = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fxM == null) {
            return 0;
        }
        return this.fxM.getCount();
    }

    public int getCurrentItem() {
        if (this.fxL == null) {
            return 0;
        }
        return this.fxL.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fxL == null) {
            return null;
        }
        View findViewWithTag = this.fxL.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fxL == null) {
            return null;
        }
        return this.fxL.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fxI.setEnabled(true);
            } else {
                this.fxI.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fxJ.setEnabled(true);
                return;
            } else {
                this.fxJ.setEnabled(false);
                return;
            }
        }
        this.fxJ.setEnabled(false);
        this.fxI.setEnabled(false);
    }

    public void bzB() {
        if (!this.fxQ) {
            this.fxK.setVisibility(0);
        }
    }

    public boolean bzC() {
        return this.fxT;
    }

    public void kB(boolean z) {
        if (this.fxV != null) {
            this.fxV.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.fxU && this.fxV != null) {
            this.fxV.bb(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fxL != null) {
            int childCount = this.fxL.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fxL.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fxV != null) {
                this.fxV.setUserId(str);
            }
        }
    }

    public void bzD() {
        if (!this.fxQ) {
            this.fxK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fxL == null) {
            return null;
        }
        return this.fxL.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fxL != null) {
            this.fxL.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fxL != null) {
            this.fxL.setOffscreenPageLimit(i);
            this.fxO = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fxO = (int) (this.fxO * 0.8d);
            if (this.fxO < 6291456) {
                this.fxP = true;
                this.fxO = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fxP = false;
            }
            PagerAdapter adapter = this.fxL.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fxO);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fwz);
        }
        if (this.fxL != null) {
            this.fxL.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fxM);
        if (this.fxL != null) {
            this.fxL.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fxM != null) {
            this.fxM.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fxM != null) {
            this.fxM.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fxM != null) {
            this.fxM.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fxM != null) {
            this.fxM.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fxM != null) {
            this.fxM.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dFh = arrayList;
        if (this.fxM != null) {
            this.fxM.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fxS = map;
        if (this.fxM != null) {
            this.fxM.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fxM != null) {
            this.fxM.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fxM == null) {
            return false;
        }
        return this.fxM.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fxM != null) {
            this.fxM.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fxL == null || (currentView = this.fxL.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fxM != null) {
            this.fxM.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fxL == null || (currentView = this.fxL.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fxL == null || (currentView = this.fxL.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fxL != null && (currentView = this.fxL.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fxL != null) {
            this.fxL.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fwK = z;
        if (this.fxM != null) {
            this.fxM.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fxM != null) {
            this.fxM.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fxM != null) {
            this.fxM.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fxM != null) {
            this.fxM.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fxM != null) {
            this.fxM.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fxU = z;
        kB(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fxV != null) {
            this.fxV.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fxV != null) {
            this.fxV.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fxV != null) {
            this.fxV.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (!this.fxU || this.fxV == null) {
            return 0;
        }
        return this.fxV.getBottomHeight();
    }
}
