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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> cAI;
    private ImagePagerAdapter.b egA;
    private boolean egJ;
    private DragImageView.g egy;
    private DragImageView.e egz;
    private Button ehE;
    private Button ehF;
    private LinearLayout ehG;
    private GalleryViewPager ehH;
    private ImagePagerAdapter ehI;
    private ViewPager.OnPageChangeListener ehJ;
    private int ehK;
    private boolean ehL;
    private boolean ehM;
    private int ehN;
    private Map<String, ImageUrlData> ehO;
    private boolean ehP;
    private boolean ehQ;
    protected a ehR;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.ehN;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ehE = null;
        this.ehF = null;
        this.ehG = null;
        this.ehH = null;
        this.ehI = null;
        this.mOnClickListener = null;
        this.egz = null;
        this.mOnPageChangeListener = null;
        this.ehJ = null;
        this.egy = null;
        this.egA = null;
        this.ehK = 0;
        this.ehL = true;
        this.ehM = false;
        this.egJ = false;
        this.ehN = 1;
        this.cAI = null;
        this.ehO = null;
        this.ehP = false;
        this.ehQ = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ehH != null) {
            this.ehH.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ehE = null;
        this.ehF = null;
        this.ehG = null;
        this.ehH = null;
        this.ehI = null;
        this.mOnClickListener = null;
        this.egz = null;
        this.mOnPageChangeListener = null;
        this.ehJ = null;
        this.egy = null;
        this.egA = null;
        this.ehK = 0;
        this.ehL = true;
        this.ehM = false;
        this.egJ = false;
        this.ehN = 1;
        this.cAI = null;
        this.ehO = null;
        this.ehP = false;
        this.ehQ = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ehE = null;
        this.ehF = null;
        this.ehG = null;
        this.ehH = null;
        this.ehI = null;
        this.mOnClickListener = null;
        this.egz = null;
        this.mOnPageChangeListener = null;
        this.ehJ = null;
        this.egy = null;
        this.egA = null;
        this.ehK = 0;
        this.ehL = true;
        this.ehM = false;
        this.egJ = false;
        this.ehN = 1;
        this.cAI = null;
        this.ehO = null;
        this.ehP = false;
        this.ehQ = true;
        init();
    }

    public void init() {
        this.ehM = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.ehE) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.ehF && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.ehJ != null) {
                    MultiImageView.this.ehJ.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.ehJ != null) {
                    MultiImageView.this.ehJ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.ehN) {
                    MultiImageView.this.ehN = i + 1;
                }
                if (MultiImageView.this.ehH != null) {
                    int childCount = MultiImageView.this.ehH.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.ehH.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bbK();
                        }
                    }
                }
                if (MultiImageView.this.ehJ != null) {
                    MultiImageView.this.ehJ.onPageSelected(i);
                }
            }
        };
        this.egy = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ehH != null && MultiImageView.this.ehH.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.egz = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.ehH != null && dragImageView == MultiImageView.this.ehH.getCurrentView()) {
                    if (MultiImageView.this.ehL) {
                        int childCount = MultiImageView.this.ehH.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ehH.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.egA = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.ehH != null) {
                        MultiImageView.this.ehH.setCurrentView(null);
                    }
                    MultiImageView.this.hL(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.ehH != null) {
                        MultiImageView.this.ehH.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.egz != null) {
                        MultiImageView.this.egz.a(imageView);
                    }
                }
                urlDragImageView.bbI();
                urlDragImageView.bbH();
                urlDragImageView.A(MultiImageView.this.egJ, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.ehI != null) {
            return this.ehI.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.ehH != null) {
            int childCount = this.ehH.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ehH.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ehH != null && this.ehH.getCurrentView() != null) {
            if (this.ehL) {
                int childCount = this.ehH.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ehH.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.ehH.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.ehH.findViewWithTag(String.valueOf(this.ehH.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).A(this.egJ, true);
            }
            this.ehH.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ehH != null && this.ehH.getCurrentView() != null) {
            this.ehH.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ehH != null) {
            int childCount = this.ehH.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ehH.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.ehR != null) {
            this.ehR.setAssistUrl(imageUrlData);
            if (this.ehP || imageUrlData == null) {
                hL(false);
                return;
            }
            if (!this.ehR.bbs()) {
                this.ehR.hJ(false);
            }
            if (!this.ehR.isShown()) {
                s(true, 150);
            }
        }
    }

    public void mS(int i) {
        if (this.ehH != null) {
            View findViewWithTag = this.ehH.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                hL(false);
            }
        }
    }

    public void mT(int i) {
        View findViewWithTag;
        if (this.ehH != null && (findViewWithTag = this.ehH.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.A(this.egJ, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData xz = xz(str);
                urlDragImageView.setAssistUrl(xz);
                c(xz);
            }
            urlDragImageView.A(this.egJ, true);
        }
    }

    private ImageUrlData xz(String str) {
        if (TextUtils.isEmpty(str) || this.ehO == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.ehO.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mU(int i) {
        if (this.ehH == null) {
            return null;
        }
        View findViewWithTag = this.ehH.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void mV(int i) {
        View findViewWithTag;
        if (this.ehH != null && (findViewWithTag = this.ehH.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bbM();
        }
    }

    private void initUI() {
        this.ehH = new GalleryViewPager(getContext());
        this.ehH.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ehH.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ehH);
        this.ehG = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ehG.setOrientation(0);
        this.ehG.setLayoutParams(layoutParams);
        addView(this.ehG);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ehF = new Button(getContext());
        am.setBackgroundResource(this.ehF, R.drawable.image_zoomout, 0);
        this.ehF.setLayoutParams(layoutParams2);
        this.ehF.setOnClickListener(this.mOnClickListener);
        this.ehF.setEnabled(false);
        this.ehG.addView(this.ehF);
        this.ehE = new Button(getContext());
        am.setBackgroundResource(this.ehE, R.drawable.image_zoomin, 0);
        this.ehE.setLayoutParams(layoutParams2);
        this.ehE.setOnClickListener(this.mOnClickListener);
        this.ehE.setEnabled(false);
        this.ehG.addView(this.ehE);
        if (this.ehM) {
            this.ehG.setVisibility(8);
        }
        this.ehI = new ImagePagerAdapter(getContext(), this.egz);
        this.ehI.a(this.egA);
        setAdapter(this.ehI);
        this.ehR = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.ehI != null) {
            this.ehI.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.ehR != null) {
            this.ehR.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ehJ = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.ehI == null) {
            return 0;
        }
        return this.ehI.getCount();
    }

    public int getCurrentItem() {
        if (this.ehH == null) {
            return 0;
        }
        return this.ehH.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.ehH == null) {
            return null;
        }
        View findViewWithTag = this.ehH.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.ehH == null) {
            return null;
        }
        return this.ehH.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.ehE.setEnabled(true);
            } else {
                this.ehE.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ehF.setEnabled(true);
                return;
            } else {
                this.ehF.setEnabled(false);
                return;
            }
        }
        this.ehF.setEnabled(false);
        this.ehE.setEnabled(false);
    }

    public void bby() {
        if (!this.ehM) {
            this.ehG.setVisibility(0);
        }
    }

    public boolean bbz() {
        return this.ehP;
    }

    public void hL(boolean z) {
        if (this.ehR != null) {
            this.ehR.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.ehQ && this.ehR != null) {
            this.ehR.aQ(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.ehH != null) {
            int childCount = this.ehH.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ehH.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.ehR != null) {
                this.ehR.setUserId(str);
            }
        }
    }

    public void bbA() {
        if (!this.ehM) {
            this.ehG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.ehH == null) {
            return null;
        }
        return this.ehH.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.ehH != null) {
            this.ehH.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.ehH != null) {
            this.ehH.setOffscreenPageLimit(i);
            this.ehK = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.ehK = (int) (this.ehK * 0.8d);
            if (this.ehK < 6291456) {
                this.ehL = true;
                this.ehK = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.ehL = false;
            }
            PagerAdapter adapter = this.ehH.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.ehK);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.egy);
        }
        if (this.ehH != null) {
            this.ehH.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.ehI);
        if (this.ehH != null) {
            this.ehH.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.ehI != null) {
            this.ehI.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.ehI != null) {
            this.ehI.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.ehI != null) {
            this.ehI.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ehI != null) {
            this.ehI.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.ehI != null) {
            this.ehI.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cAI = arrayList;
        if (this.ehI != null) {
            this.ehI.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ehO = map;
        if (this.ehI != null) {
            this.ehI.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.ehI != null) {
            this.ehI.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.ehI == null) {
            return false;
        }
        return this.ehI.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.ehI != null) {
            this.ehI.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.ehH == null || (currentView = this.ehH.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.ehI != null) {
            this.ehI.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.ehH == null || (currentView = this.ehH.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.ehH == null || (currentView = this.ehH.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.ehH != null && (currentView = this.ehH.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ehH != null) {
            this.ehH.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.egJ = z;
        if (this.ehI != null) {
            this.ehI.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.ehI != null) {
            this.ehI.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ehI != null) {
            this.ehI.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.ehI != null) {
            this.ehI.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.ehI != null) {
            this.ehI.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.ehQ = z;
        hL(z);
    }
}
