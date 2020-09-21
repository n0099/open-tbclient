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
    private ArrayList<String> cTn;
    private DragImageView.g eIh;
    private DragImageView.e eIi;
    private ImagePagerAdapter.b eIj;
    private boolean eIs;
    private int eJA;
    private Map<String, ImageUrlData> eJB;
    private boolean eJC;
    private boolean eJD;
    protected a eJE;
    private Button eJr;
    private Button eJs;
    private LinearLayout eJt;
    private GalleryViewPager eJu;
    private ImagePagerAdapter eJv;
    private ViewPager.OnPageChangeListener eJw;
    private int eJx;
    private boolean eJy;
    private boolean eJz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.eJA;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eJr = null;
        this.eJs = null;
        this.eJt = null;
        this.eJu = null;
        this.eJv = null;
        this.mOnClickListener = null;
        this.eIi = null;
        this.mOnPageChangeListener = null;
        this.eJw = null;
        this.eIh = null;
        this.eIj = null;
        this.eJx = 0;
        this.eJy = true;
        this.eJz = false;
        this.eIs = false;
        this.eJA = 1;
        this.cTn = null;
        this.eJB = null;
        this.eJC = false;
        this.eJD = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.eJu != null) {
            this.eJu.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eJr = null;
        this.eJs = null;
        this.eJt = null;
        this.eJu = null;
        this.eJv = null;
        this.mOnClickListener = null;
        this.eIi = null;
        this.mOnPageChangeListener = null;
        this.eJw = null;
        this.eIh = null;
        this.eIj = null;
        this.eJx = 0;
        this.eJy = true;
        this.eJz = false;
        this.eIs = false;
        this.eJA = 1;
        this.cTn = null;
        this.eJB = null;
        this.eJC = false;
        this.eJD = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eJr = null;
        this.eJs = null;
        this.eJt = null;
        this.eJu = null;
        this.eJv = null;
        this.mOnClickListener = null;
        this.eIi = null;
        this.mOnPageChangeListener = null;
        this.eJw = null;
        this.eIh = null;
        this.eIj = null;
        this.eJx = 0;
        this.eJy = true;
        this.eJz = false;
        this.eIs = false;
        this.eJA = 1;
        this.cTn = null;
        this.eJB = null;
        this.eJC = false;
        this.eJD = true;
        init();
    }

    public void init() {
        this.eJz = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.eJr) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.eJs && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.eJw != null) {
                    MultiImageView.this.eJw.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.eJw != null) {
                    MultiImageView.this.eJw.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.eJA) {
                    MultiImageView.this.eJA = i + 1;
                }
                if (MultiImageView.this.eJu != null) {
                    int childCount = MultiImageView.this.eJu.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.eJu.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).brc();
                        }
                    }
                }
                if (MultiImageView.this.eJw != null) {
                    MultiImageView.this.eJw.onPageSelected(i);
                }
            }
        };
        this.eIh = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.eJu != null && MultiImageView.this.eJu.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.eIi = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.eJu != null && dragImageView == MultiImageView.this.eJu.getCurrentView()) {
                    if (MultiImageView.this.eJy) {
                        int childCount = MultiImageView.this.eJu.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.eJu.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.eIj = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.eJu != null) {
                        MultiImageView.this.eJu.setCurrentView(null);
                    }
                    MultiImageView.this.iV(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.eJu != null) {
                        MultiImageView.this.eJu.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.eIi != null) {
                        MultiImageView.this.eIi.a(imageView);
                    }
                }
                urlDragImageView.bra();
                urlDragImageView.bqZ();
                urlDragImageView.E(MultiImageView.this.eIs, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.eJv != null) {
            return this.eJv.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.eJu != null) {
            int childCount = this.eJu.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eJu.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.eJu != null && this.eJu.getCurrentView() != null) {
            if (this.eJy) {
                int childCount = this.eJu.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.eJu.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.eJu.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.eJu.findViewWithTag(String.valueOf(this.eJu.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.eIs, true);
            }
            this.eJu.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.eJu != null && this.eJu.getCurrentView() != null) {
            this.eJu.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.eJu != null) {
            int childCount = this.eJu.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eJu.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.eJE != null) {
            this.eJE.setAssistUrl(imageUrlData);
            if (this.eJC || imageUrlData == null) {
                iV(false);
                return;
            }
            if (!this.eJE.bqI()) {
                this.eJE.iT(false);
            }
            if (!this.eJE.isShown()) {
                s(true, 150);
            }
        }
    }

    public void qc(int i) {
        if (this.eJu != null) {
            View findViewWithTag = this.eJu.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                iV(false);
            }
        }
    }

    public void qd(int i) {
        View findViewWithTag;
        if (this.eJu != null && (findViewWithTag = this.eJu.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.eIs, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData BL = BL(str);
                urlDragImageView.setAssistUrl(BL);
                c(BL);
            }
            urlDragImageView.E(this.eIs, true);
        }
    }

    private ImageUrlData BL(String str) {
        if (TextUtils.isEmpty(str) || this.eJB == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eJB.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qe(int i) {
        if (this.eJu == null) {
            return null;
        }
        View findViewWithTag = this.eJu.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qf(int i) {
        View findViewWithTag;
        if (this.eJu != null && (findViewWithTag = this.eJu.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bre();
        }
    }

    private void initUI() {
        this.eJu = new GalleryViewPager(getContext());
        this.eJu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eJu.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.eJu);
        this.eJt = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.eJt.setOrientation(0);
        this.eJt.setLayoutParams(layoutParams);
        addView(this.eJt);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.eJs = new Button(getContext());
        ap.setBackgroundResource(this.eJs, R.drawable.image_zoomout, 0);
        this.eJs.setLayoutParams(layoutParams2);
        this.eJs.setOnClickListener(this.mOnClickListener);
        this.eJs.setEnabled(false);
        this.eJt.addView(this.eJs);
        this.eJr = new Button(getContext());
        ap.setBackgroundResource(this.eJr, R.drawable.image_zoomin, 0);
        this.eJr.setLayoutParams(layoutParams2);
        this.eJr.setOnClickListener(this.mOnClickListener);
        this.eJr.setEnabled(false);
        this.eJt.addView(this.eJr);
        if (this.eJz) {
            this.eJt.setVisibility(8);
        }
        this.eJv = new ImagePagerAdapter(getContext(), this.eIi);
        this.eJv.a(this.eIj);
        setAdapter(this.eJv);
        this.eJE = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.eJv != null) {
            this.eJv.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eJw = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.eJv == null) {
            return 0;
        }
        return this.eJv.getCount();
    }

    public int getCurrentItem() {
        if (this.eJu == null) {
            return 0;
        }
        return this.eJu.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.eJu == null) {
            return null;
        }
        View findViewWithTag = this.eJu.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.eJu == null) {
            return null;
        }
        return this.eJu.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.eJr.setEnabled(true);
            } else {
                this.eJr.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.eJs.setEnabled(true);
                return;
            } else {
                this.eJs.setEnabled(false);
                return;
            }
        }
        this.eJs.setEnabled(false);
        this.eJr.setEnabled(false);
    }

    public void bqQ() {
        if (!this.eJz) {
            this.eJt.setVisibility(0);
        }
    }

    public boolean bqR() {
        return this.eJC;
    }

    public void iV(boolean z) {
        if (this.eJE != null) {
            this.eJE.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.eJD && this.eJE != null) {
            this.eJE.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.eJu != null) {
            int childCount = this.eJu.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eJu.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.eJE != null) {
                this.eJE.setUserId(str);
            }
        }
    }

    public void bqS() {
        if (!this.eJz) {
            this.eJt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.eJu == null) {
            return null;
        }
        return this.eJu.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.eJu != null) {
            this.eJu.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.eJu != null) {
            this.eJu.setOffscreenPageLimit(i);
            this.eJx = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.eJx = (int) (this.eJx * 0.8d);
            if (this.eJx < 6291456) {
                this.eJy = true;
                this.eJx = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.eJy = false;
            }
            PagerAdapter adapter = this.eJu.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.eJx);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.eIh);
        }
        if (this.eJu != null) {
            this.eJu.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.eJv);
        if (this.eJu != null) {
            this.eJu.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.eJv != null) {
            this.eJv.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.eJv != null) {
            this.eJv.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.eJv != null) {
            this.eJv.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eJv != null) {
            this.eJv.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.eJv != null) {
            this.eJv.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cTn = arrayList;
        if (this.eJv != null) {
            this.eJv.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eJB = map;
        if (this.eJv != null) {
            this.eJv.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.eJv != null) {
            this.eJv.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.eJv == null) {
            return false;
        }
        return this.eJv.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.eJv != null) {
            this.eJv.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.eJu == null || (currentView = this.eJu.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.eJv != null) {
            this.eJv.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.eJu == null || (currentView = this.eJu.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eJu == null || (currentView = this.eJu.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eJu != null && (currentView = this.eJu.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eJu != null) {
            this.eJu.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.eIs = z;
        if (this.eJv != null) {
            this.eJv.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.eJv != null) {
            this.eJv.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.eJv != null) {
            this.eJv.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.eJv != null) {
            this.eJv.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.eJv != null) {
            this.eJv.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.eJD = z;
        iV(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eJE != null) {
            this.eJE.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eJE != null) {
            this.eJE.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eJE != null) {
            this.eJE.setOnReplyClickListener(onClickListener);
        }
    }
}
