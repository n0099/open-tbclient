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
/* loaded from: classes20.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> dsj;
    private DragImageView.g fhJ;
    private DragImageView.e fhK;
    private ImagePagerAdapter.b fhL;
    private boolean fhU;
    private Button fiV;
    private Button fiW;
    private LinearLayout fiX;
    private GalleryViewPager fiY;
    private ImagePagerAdapter fiZ;
    private ViewPager.OnPageChangeListener fja;
    private int fjb;
    private boolean fjc;
    private boolean fjd;
    private int fje;
    private Map<String, ImageUrlData> fjf;
    private boolean fjg;
    private boolean fjh;
    protected a fji;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fje;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fiV = null;
        this.fiW = null;
        this.fiX = null;
        this.fiY = null;
        this.fiZ = null;
        this.mOnClickListener = null;
        this.fhK = null;
        this.mOnPageChangeListener = null;
        this.fja = null;
        this.fhJ = null;
        this.fhL = null;
        this.fjb = 0;
        this.fjc = true;
        this.fjd = false;
        this.fhU = false;
        this.fje = 1;
        this.dsj = null;
        this.fjf = null;
        this.fjg = false;
        this.fjh = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fiY != null) {
            this.fiY.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fiV = null;
        this.fiW = null;
        this.fiX = null;
        this.fiY = null;
        this.fiZ = null;
        this.mOnClickListener = null;
        this.fhK = null;
        this.mOnPageChangeListener = null;
        this.fja = null;
        this.fhJ = null;
        this.fhL = null;
        this.fjb = 0;
        this.fjc = true;
        this.fjd = false;
        this.fhU = false;
        this.fje = 1;
        this.dsj = null;
        this.fjf = null;
        this.fjg = false;
        this.fjh = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fiV = null;
        this.fiW = null;
        this.fiX = null;
        this.fiY = null;
        this.fiZ = null;
        this.mOnClickListener = null;
        this.fhK = null;
        this.mOnPageChangeListener = null;
        this.fja = null;
        this.fhJ = null;
        this.fhL = null;
        this.fjb = 0;
        this.fjc = true;
        this.fjd = false;
        this.fhU = false;
        this.fje = 1;
        this.dsj = null;
        this.fjf = null;
        this.fjg = false;
        this.fjh = true;
        init();
    }

    public void init() {
        this.fjd = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fiV) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fiW && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fja != null) {
                    MultiImageView.this.fja.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fja != null) {
                    MultiImageView.this.fja.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fje) {
                    MultiImageView.this.fje = i + 1;
                }
                if (MultiImageView.this.fiY != null) {
                    int childCount = MultiImageView.this.fiY.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fiY.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bxu();
                        }
                    }
                }
                if (MultiImageView.this.fja != null) {
                    MultiImageView.this.fja.onPageSelected(i);
                }
            }
        };
        this.fhJ = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fiY != null && MultiImageView.this.fiY.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fhK = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fiY != null && dragImageView == MultiImageView.this.fiY.getCurrentView()) {
                    if (MultiImageView.this.fjc) {
                        int childCount = MultiImageView.this.fiY.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fiY.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fhL = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fiY != null) {
                        MultiImageView.this.fiY.setCurrentView(null);
                    }
                    MultiImageView.this.jQ(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fiY != null) {
                        MultiImageView.this.fiY.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fhK != null) {
                        MultiImageView.this.fhK.a(imageView);
                    }
                }
                urlDragImageView.bxs();
                urlDragImageView.bxr();
                urlDragImageView.E(MultiImageView.this.fhU, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fiZ != null) {
            return this.fiZ.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fiY != null) {
            int childCount = this.fiY.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fiY.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fiY != null && this.fiY.getCurrentView() != null) {
            if (this.fjc) {
                int childCount = this.fiY.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fiY.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fiY.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fiY.findViewWithTag(String.valueOf(this.fiY.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fhU, true);
            }
            this.fiY.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fiY != null && this.fiY.getCurrentView() != null) {
            this.fiY.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fiY != null) {
            int childCount = this.fiY.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fiY.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fji != null) {
            this.fji.setAssistUrl(imageUrlData);
            if (this.fjg || imageUrlData == null) {
                jQ(false);
                return;
            }
            if (!this.fji.bxa()) {
                this.fji.jO(false);
            }
            if (!this.fji.isShown()) {
                t(true, 150);
            }
        }
    }

    public void rt(int i) {
        if (this.fiY != null) {
            View findViewWithTag = this.fiY.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                jQ(false);
            }
        }
    }

    public void ru(int i) {
        View findViewWithTag;
        if (this.fiY != null && (findViewWithTag = this.fiY.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fhU, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData CD = CD(str);
                urlDragImageView.setAssistUrl(CD);
                c(CD);
            }
            urlDragImageView.E(this.fhU, true);
        }
    }

    private ImageUrlData CD(String str) {
        if (TextUtils.isEmpty(str) || this.fjf == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fjf.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String rv(int i) {
        if (this.fiY == null) {
            return null;
        }
        View findViewWithTag = this.fiY.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void rw(int i) {
        View findViewWithTag;
        if (this.fiY != null && (findViewWithTag = this.fiY.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bxw();
        }
    }

    private void initUI() {
        this.fiY = new GalleryViewPager(getContext());
        this.fiY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fiY.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fiY);
        this.fiX = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fiX.setOrientation(0);
        this.fiX.setLayoutParams(layoutParams);
        addView(this.fiX);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fiW = new Button(getContext());
        ap.setBackgroundResource(this.fiW, R.drawable.image_zoomout, 0);
        this.fiW.setLayoutParams(layoutParams2);
        this.fiW.setOnClickListener(this.mOnClickListener);
        this.fiW.setEnabled(false);
        this.fiX.addView(this.fiW);
        this.fiV = new Button(getContext());
        ap.setBackgroundResource(this.fiV, R.drawable.image_zoomin, 0);
        this.fiV.setLayoutParams(layoutParams2);
        this.fiV.setOnClickListener(this.mOnClickListener);
        this.fiV.setEnabled(false);
        this.fiX.addView(this.fiV);
        if (this.fjd) {
            this.fiX.setVisibility(8);
        }
        this.fiZ = new ImagePagerAdapter(getContext(), this.fhK);
        this.fiZ.a(this.fhL);
        setAdapter(this.fiZ);
        this.fji = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fiZ != null) {
            this.fiZ.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fja = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fiZ == null) {
            return 0;
        }
        return this.fiZ.getCount();
    }

    public int getCurrentItem() {
        if (this.fiY == null) {
            return 0;
        }
        return this.fiY.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fiY == null) {
            return null;
        }
        View findViewWithTag = this.fiY.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fiY == null) {
            return null;
        }
        return this.fiY.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fiV.setEnabled(true);
            } else {
                this.fiV.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fiW.setEnabled(true);
                return;
            } else {
                this.fiW.setEnabled(false);
                return;
            }
        }
        this.fiW.setEnabled(false);
        this.fiV.setEnabled(false);
    }

    public void bxi() {
        if (!this.fjd) {
            this.fiX.setVisibility(0);
        }
    }

    public boolean bxj() {
        return this.fjg;
    }

    public void jQ(boolean z) {
        if (this.fji != null) {
            this.fji.setVisibility(z ? 0 : 8);
        }
    }

    public void t(boolean z, int i) {
        if (this.fjh && this.fji != null) {
            this.fji.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fiY != null) {
            int childCount = this.fiY.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fiY.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fji != null) {
                this.fji.setUserId(str);
            }
        }
    }

    public void bxk() {
        if (!this.fjd) {
            this.fiX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fiY == null) {
            return null;
        }
        return this.fiY.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fiY != null) {
            this.fiY.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fiY != null) {
            this.fiY.setOffscreenPageLimit(i);
            this.fjb = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fjb = (int) (this.fjb * 0.8d);
            if (this.fjb < 6291456) {
                this.fjc = true;
                this.fjb = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fjc = false;
            }
            PagerAdapter adapter = this.fiY.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fjb);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fhJ);
        }
        if (this.fiY != null) {
            this.fiY.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fiZ);
        if (this.fiY != null) {
            this.fiY.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fiZ != null) {
            this.fiZ.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fiZ != null) {
            this.fiZ.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fiZ != null) {
            this.fiZ.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fiZ != null) {
            this.fiZ.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fiZ != null) {
            this.fiZ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dsj = arrayList;
        if (this.fiZ != null) {
            this.fiZ.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fjf = map;
        if (this.fiZ != null) {
            this.fiZ.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fiZ != null) {
            this.fiZ.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fiZ == null) {
            return false;
        }
        return this.fiZ.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fiZ != null) {
            this.fiZ.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fiY == null || (currentView = this.fiY.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fiZ != null) {
            this.fiZ.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fiY == null || (currentView = this.fiY.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fiY == null || (currentView = this.fiY.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fiY != null && (currentView = this.fiY.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fiY != null) {
            this.fiY.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fhU = z;
        if (this.fiZ != null) {
            this.fiZ.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fiZ != null) {
            this.fiZ.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fiZ != null) {
            this.fiZ.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fiZ != null) {
            this.fiZ.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fiZ != null) {
            this.fiZ.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fjh = z;
        jQ(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fji != null) {
            this.fji.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fji != null) {
            this.fji.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fji != null) {
            this.fji.setOnReplyClickListener(onClickListener);
        }
    }
}
