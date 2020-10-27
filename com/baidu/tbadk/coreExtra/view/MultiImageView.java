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
    private ArrayList<String> dnV;
    private DragImageView.g fcL;
    private DragImageView.e fcM;
    private ImagePagerAdapter.b fcN;
    private boolean fcW;
    private Button fdU;
    private Button fdV;
    private LinearLayout fdW;
    private GalleryViewPager fdX;
    private ImagePagerAdapter fdY;
    private ViewPager.OnPageChangeListener fdZ;
    private int fea;
    private boolean feb;
    private boolean fec;
    private int fed;
    private Map<String, ImageUrlData> fee;
    private boolean fef;
    private boolean feg;
    protected a feh;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fed;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fdU = null;
        this.fdV = null;
        this.fdW = null;
        this.fdX = null;
        this.fdY = null;
        this.mOnClickListener = null;
        this.fcM = null;
        this.mOnPageChangeListener = null;
        this.fdZ = null;
        this.fcL = null;
        this.fcN = null;
        this.fea = 0;
        this.feb = true;
        this.fec = false;
        this.fcW = false;
        this.fed = 1;
        this.dnV = null;
        this.fee = null;
        this.fef = false;
        this.feg = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fdX != null) {
            this.fdX.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fdU = null;
        this.fdV = null;
        this.fdW = null;
        this.fdX = null;
        this.fdY = null;
        this.mOnClickListener = null;
        this.fcM = null;
        this.mOnPageChangeListener = null;
        this.fdZ = null;
        this.fcL = null;
        this.fcN = null;
        this.fea = 0;
        this.feb = true;
        this.fec = false;
        this.fcW = false;
        this.fed = 1;
        this.dnV = null;
        this.fee = null;
        this.fef = false;
        this.feg = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fdU = null;
        this.fdV = null;
        this.fdW = null;
        this.fdX = null;
        this.fdY = null;
        this.mOnClickListener = null;
        this.fcM = null;
        this.mOnPageChangeListener = null;
        this.fdZ = null;
        this.fcL = null;
        this.fcN = null;
        this.fea = 0;
        this.feb = true;
        this.fec = false;
        this.fcW = false;
        this.fed = 1;
        this.dnV = null;
        this.fee = null;
        this.fef = false;
        this.feg = true;
        init();
    }

    public void init() {
        this.fec = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fdU) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fdV && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fdZ != null) {
                    MultiImageView.this.fdZ.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fdZ != null) {
                    MultiImageView.this.fdZ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fed) {
                    MultiImageView.this.fed = i + 1;
                }
                if (MultiImageView.this.fdX != null) {
                    int childCount = MultiImageView.this.fdX.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fdX.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bvF();
                        }
                    }
                }
                if (MultiImageView.this.fdZ != null) {
                    MultiImageView.this.fdZ.onPageSelected(i);
                }
            }
        };
        this.fcL = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fdX != null && MultiImageView.this.fdX.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fcM = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fdX != null && dragImageView == MultiImageView.this.fdX.getCurrentView()) {
                    if (MultiImageView.this.feb) {
                        int childCount = MultiImageView.this.fdX.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fdX.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fcN = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void h(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fdX != null) {
                        MultiImageView.this.fdX.setCurrentView(null);
                    }
                    MultiImageView.this.jG(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fdX != null) {
                        MultiImageView.this.fdX.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fcM != null) {
                        MultiImageView.this.fcM.a(imageView);
                    }
                }
                urlDragImageView.bvD();
                urlDragImageView.bvC();
                urlDragImageView.E(MultiImageView.this.fcW, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fdY != null) {
            return this.fdY.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fdX != null) {
            int childCount = this.fdX.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fdX.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fdX != null && this.fdX.getCurrentView() != null) {
            if (this.feb) {
                int childCount = this.fdX.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fdX.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fdX.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fdX.findViewWithTag(String.valueOf(this.fdX.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fcW, true);
            }
            this.fdX.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fdX != null && this.fdX.getCurrentView() != null) {
            this.fdX.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fdX != null) {
            int childCount = this.fdX.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fdX.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.feh != null) {
            this.feh.setAssistUrl(imageUrlData);
            if (this.fef || imageUrlData == null) {
                jG(false);
                return;
            }
            if (!this.feh.bvl()) {
                this.feh.jE(false);
            }
            if (!this.feh.isShown()) {
                t(true, 150);
            }
        }
    }

    public void qL(int i) {
        if (this.fdX != null) {
            View findViewWithTag = this.fdX.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                jG(false);
            }
        }
    }

    public void qM(int i) {
        View findViewWithTag;
        if (this.fdX != null && (findViewWithTag = this.fdX.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fcW, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData CQ = CQ(str);
                urlDragImageView.setAssistUrl(CQ);
                c(CQ);
            }
            urlDragImageView.E(this.fcW, true);
        }
    }

    private ImageUrlData CQ(String str) {
        if (TextUtils.isEmpty(str) || this.fee == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fee.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qN(int i) {
        if (this.fdX == null) {
            return null;
        }
        View findViewWithTag = this.fdX.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qO(int i) {
        View findViewWithTag;
        if (this.fdX != null && (findViewWithTag = this.fdX.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bvH();
        }
    }

    private void initUI() {
        this.fdX = new GalleryViewPager(getContext());
        this.fdX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fdX.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fdX);
        this.fdW = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fdW.setOrientation(0);
        this.fdW.setLayoutParams(layoutParams);
        addView(this.fdW);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fdV = new Button(getContext());
        ap.setBackgroundResource(this.fdV, R.drawable.image_zoomout, 0);
        this.fdV.setLayoutParams(layoutParams2);
        this.fdV.setOnClickListener(this.mOnClickListener);
        this.fdV.setEnabled(false);
        this.fdW.addView(this.fdV);
        this.fdU = new Button(getContext());
        ap.setBackgroundResource(this.fdU, R.drawable.image_zoomin, 0);
        this.fdU.setLayoutParams(layoutParams2);
        this.fdU.setOnClickListener(this.mOnClickListener);
        this.fdU.setEnabled(false);
        this.fdW.addView(this.fdU);
        if (this.fec) {
            this.fdW.setVisibility(8);
        }
        this.fdY = new ImagePagerAdapter(getContext(), this.fcM);
        this.fdY.a(this.fcN);
        setAdapter(this.fdY);
        this.feh = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fdY != null) {
            this.fdY.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fdZ = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fdY == null) {
            return 0;
        }
        return this.fdY.getCount();
    }

    public int getCurrentItem() {
        if (this.fdX == null) {
            return 0;
        }
        return this.fdX.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fdX == null) {
            return null;
        }
        View findViewWithTag = this.fdX.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fdX == null) {
            return null;
        }
        return this.fdX.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fdU.setEnabled(true);
            } else {
                this.fdU.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fdV.setEnabled(true);
                return;
            } else {
                this.fdV.setEnabled(false);
                return;
            }
        }
        this.fdV.setEnabled(false);
        this.fdU.setEnabled(false);
    }

    public void bvt() {
        if (!this.fec) {
            this.fdW.setVisibility(0);
        }
    }

    public boolean bvu() {
        return this.fef;
    }

    public void jG(boolean z) {
        if (this.feh != null) {
            this.feh.setVisibility(z ? 0 : 8);
        }
    }

    public void t(boolean z, int i) {
        if (this.feg && this.feh != null) {
            this.feh.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fdX != null) {
            int childCount = this.fdX.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fdX.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.feh != null) {
                this.feh.setUserId(str);
            }
        }
    }

    public void bvv() {
        if (!this.fec) {
            this.fdW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fdX == null) {
            return null;
        }
        return this.fdX.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fdX != null) {
            this.fdX.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fdX != null) {
            this.fdX.setOffscreenPageLimit(i);
            this.fea = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fea = (int) (this.fea * 0.8d);
            if (this.fea < 6291456) {
                this.feb = true;
                this.fea = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.feb = false;
            }
            PagerAdapter adapter = this.fdX.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fea);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fcL);
        }
        if (this.fdX != null) {
            this.fdX.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fdY);
        if (this.fdX != null) {
            this.fdX.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fdY != null) {
            this.fdY.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fdY != null) {
            this.fdY.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fdY != null) {
            this.fdY.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fdY != null) {
            this.fdY.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fdY != null) {
            this.fdY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dnV = arrayList;
        if (this.fdY != null) {
            this.fdY.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fee = map;
        if (this.fdY != null) {
            this.fdY.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fdY != null) {
            this.fdY.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fdY == null) {
            return false;
        }
        return this.fdY.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fdY != null) {
            this.fdY.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fdX == null || (currentView = this.fdX.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fdY != null) {
            this.fdY.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fdX == null || (currentView = this.fdX.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fdX == null || (currentView = this.fdX.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fdX != null && (currentView = this.fdX.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fdX != null) {
            this.fdX.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fcW = z;
        if (this.fdY != null) {
            this.fdY.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fdY != null) {
            this.fdY.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fdY != null) {
            this.fdY.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fdY != null) {
            this.fdY.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fdY != null) {
            this.fdY.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.feg = z;
        jG(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.feh != null) {
            this.feh.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.feh != null) {
            this.feh.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.feh != null) {
            this.feh.setOnReplyClickListener(onClickListener);
        }
    }
}
