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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes15.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> cIk;
    private boolean evI;
    private DragImageView.g evx;
    private DragImageView.e evy;
    private ImagePagerAdapter.b evz;
    private Button ewG;
    private Button ewH;
    private LinearLayout ewI;
    private GalleryViewPager ewJ;
    private ImagePagerAdapter ewK;
    private ViewPager.OnPageChangeListener ewL;
    private int ewM;
    private boolean ewN;
    private boolean ewO;
    private int ewP;
    private Map<String, ImageUrlData> ewQ;
    private boolean ewR;
    private boolean ewS;
    protected a ewT;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.ewP;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ewG = null;
        this.ewH = null;
        this.ewI = null;
        this.ewJ = null;
        this.ewK = null;
        this.mOnClickListener = null;
        this.evy = null;
        this.mOnPageChangeListener = null;
        this.ewL = null;
        this.evx = null;
        this.evz = null;
        this.ewM = 0;
        this.ewN = true;
        this.ewO = false;
        this.evI = false;
        this.ewP = 1;
        this.cIk = null;
        this.ewQ = null;
        this.ewR = false;
        this.ewS = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ewJ != null) {
            this.ewJ.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ewG = null;
        this.ewH = null;
        this.ewI = null;
        this.ewJ = null;
        this.ewK = null;
        this.mOnClickListener = null;
        this.evy = null;
        this.mOnPageChangeListener = null;
        this.ewL = null;
        this.evx = null;
        this.evz = null;
        this.ewM = 0;
        this.ewN = true;
        this.ewO = false;
        this.evI = false;
        this.ewP = 1;
        this.cIk = null;
        this.ewQ = null;
        this.ewR = false;
        this.ewS = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ewG = null;
        this.ewH = null;
        this.ewI = null;
        this.ewJ = null;
        this.ewK = null;
        this.mOnClickListener = null;
        this.evy = null;
        this.mOnPageChangeListener = null;
        this.ewL = null;
        this.evx = null;
        this.evz = null;
        this.ewM = 0;
        this.ewN = true;
        this.ewO = false;
        this.evI = false;
        this.ewP = 1;
        this.cIk = null;
        this.ewQ = null;
        this.ewR = false;
        this.ewS = true;
        init();
    }

    public void init() {
        this.ewO = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.ewG) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.ewH && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.ewL != null) {
                    MultiImageView.this.ewL.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.ewL != null) {
                    MultiImageView.this.ewL.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.ewP) {
                    MultiImageView.this.ewP = i + 1;
                }
                if (MultiImageView.this.ewJ != null) {
                    int childCount = MultiImageView.this.ewJ.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.ewJ.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bhv();
                        }
                    }
                }
                if (MultiImageView.this.ewL != null) {
                    MultiImageView.this.ewL.onPageSelected(i);
                }
            }
        };
        this.evx = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ewJ != null && MultiImageView.this.ewJ.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.evy = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.ewJ != null && dragImageView == MultiImageView.this.ewJ.getCurrentView()) {
                    if (MultiImageView.this.ewN) {
                        int childCount = MultiImageView.this.ewJ.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ewJ.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.evz = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.ewJ != null) {
                        MultiImageView.this.ewJ.setCurrentView(null);
                    }
                    MultiImageView.this.iy(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.ewJ != null) {
                        MultiImageView.this.ewJ.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.evy != null) {
                        MultiImageView.this.evy.a(imageView);
                    }
                }
                urlDragImageView.bht();
                urlDragImageView.bhs();
                urlDragImageView.B(MultiImageView.this.evI, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.ewK != null) {
            return this.ewK.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.ewJ != null) {
            int childCount = this.ewJ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ewJ.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ewJ != null && this.ewJ.getCurrentView() != null) {
            if (this.ewN) {
                int childCount = this.ewJ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ewJ.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.ewJ.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(this.ewJ.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).B(this.evI, true);
            }
            this.ewJ.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ewJ != null && this.ewJ.getCurrentView() != null) {
            this.ewJ.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ewJ != null) {
            int childCount = this.ewJ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ewJ.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.ewT != null) {
            this.ewT.setAssistUrl(imageUrlData);
            if (this.ewR || imageUrlData == null) {
                iy(false);
                return;
            }
            if (!this.ewT.bhb()) {
                this.ewT.iw(false);
            }
            if (!this.ewT.isShown()) {
                s(true, 150);
            }
        }
    }

    public void nE(int i) {
        if (this.ewJ != null) {
            View findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                iy(false);
            }
        }
    }

    public void nF(int i) {
        View findViewWithTag;
        if (this.ewJ != null && (findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.B(this.evI, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData yY = yY(str);
                urlDragImageView.setAssistUrl(yY);
                c(yY);
            }
            urlDragImageView.B(this.evI, true);
        }
    }

    private ImageUrlData yY(String str) {
        if (TextUtils.isEmpty(str) || this.ewQ == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.ewQ.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String nG(int i) {
        if (this.ewJ == null) {
            return null;
        }
        View findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void nH(int i) {
        View findViewWithTag;
        if (this.ewJ != null && (findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bhx();
        }
    }

    private void initUI() {
        this.ewJ = new GalleryViewPager(getContext());
        this.ewJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ewJ.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ewJ);
        this.ewI = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ewI.setOrientation(0);
        this.ewI.setLayoutParams(layoutParams);
        addView(this.ewI);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ewH = new Button(getContext());
        ao.setBackgroundResource(this.ewH, R.drawable.image_zoomout, 0);
        this.ewH.setLayoutParams(layoutParams2);
        this.ewH.setOnClickListener(this.mOnClickListener);
        this.ewH.setEnabled(false);
        this.ewI.addView(this.ewH);
        this.ewG = new Button(getContext());
        ao.setBackgroundResource(this.ewG, R.drawable.image_zoomin, 0);
        this.ewG.setLayoutParams(layoutParams2);
        this.ewG.setOnClickListener(this.mOnClickListener);
        this.ewG.setEnabled(false);
        this.ewI.addView(this.ewG);
        if (this.ewO) {
            this.ewI.setVisibility(8);
        }
        this.ewK = new ImagePagerAdapter(getContext(), this.evy);
        this.ewK.a(this.evz);
        setAdapter(this.ewK);
        this.ewT = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.ewK != null) {
            this.ewK.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ewL = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.ewK == null) {
            return 0;
        }
        return this.ewK.getCount();
    }

    public int getCurrentItem() {
        if (this.ewJ == null) {
            return 0;
        }
        return this.ewJ.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.ewJ == null) {
            return null;
        }
        View findViewWithTag = this.ewJ.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.ewJ == null) {
            return null;
        }
        return this.ewJ.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.ewG.setEnabled(true);
            } else {
                this.ewG.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ewH.setEnabled(true);
                return;
            } else {
                this.ewH.setEnabled(false);
                return;
            }
        }
        this.ewH.setEnabled(false);
        this.ewG.setEnabled(false);
    }

    public void bhj() {
        if (!this.ewO) {
            this.ewI.setVisibility(0);
        }
    }

    public boolean bhk() {
        return this.ewR;
    }

    public void iy(boolean z) {
        if (this.ewT != null) {
            this.ewT.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.ewS && this.ewT != null) {
            this.ewT.aV(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.ewJ != null) {
            int childCount = this.ewJ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ewJ.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.ewT != null) {
                this.ewT.setUserId(str);
            }
        }
    }

    public void bhl() {
        if (!this.ewO) {
            this.ewI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.ewJ == null) {
            return null;
        }
        return this.ewJ.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.ewJ != null) {
            this.ewJ.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.ewJ != null) {
            this.ewJ.setOffscreenPageLimit(i);
            this.ewM = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.ewM = (int) (this.ewM * 0.8d);
            if (this.ewM < 6291456) {
                this.ewN = true;
                this.ewM = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.ewN = false;
            }
            PagerAdapter adapter = this.ewJ.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.ewM);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.evx);
        }
        if (this.ewJ != null) {
            this.ewJ.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.ewK);
        if (this.ewJ != null) {
            this.ewJ.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.ewK != null) {
            this.ewK.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.ewK != null) {
            this.ewK.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.ewK != null) {
            this.ewK.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ewK != null) {
            this.ewK.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.ewK != null) {
            this.ewK.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cIk = arrayList;
        if (this.ewK != null) {
            this.ewK.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ewQ = map;
        if (this.ewK != null) {
            this.ewK.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.ewK != null) {
            this.ewK.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.ewK == null) {
            return false;
        }
        return this.ewK.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.ewK != null) {
            this.ewK.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.ewJ == null || (currentView = this.ewJ.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.ewK != null) {
            this.ewK.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.ewJ == null || (currentView = this.ewJ.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.ewJ == null || (currentView = this.ewJ.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.ewJ != null && (currentView = this.ewJ.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ewJ != null) {
            this.ewJ.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.evI = z;
        if (this.ewK != null) {
            this.ewK.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.ewK != null) {
            this.ewK.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ewK != null) {
            this.ewK.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.ewK != null) {
            this.ewK.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.ewK != null) {
            this.ewK.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.ewS = z;
        iy(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.ewT != null) {
            this.ewT.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.ewT != null) {
            this.ewT.setOnDownloadImageListener(bVar);
        }
    }
}
