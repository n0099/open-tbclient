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
    private DragImageView.g drL;
    private DragImageView.e drM;
    private ImagePagerAdapter.b drN;
    private boolean drW;
    private Button dsU;
    private Button dsV;
    private LinearLayout dsW;
    private GalleryViewPager dsX;
    private ImagePagerAdapter dsY;
    private ViewPager.OnPageChangeListener dsZ;
    private int dta;
    private boolean dtb;
    private boolean dtc;
    private int dtd;
    private ArrayList<String> dte;
    private Map<String, ImageUrlData> dtf;
    private boolean dtg;
    private boolean dth;
    protected b dti;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dtd;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.dsY = null;
        this.mOnClickListener = null;
        this.drM = null;
        this.mOnPageChangeListener = null;
        this.dsZ = null;
        this.drL = null;
        this.drN = null;
        this.dta = 0;
        this.dtb = true;
        this.dtc = false;
        this.drW = false;
        this.dtd = 1;
        this.dte = null;
        this.dtf = null;
        this.dtg = false;
        this.dth = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dsX != null) {
            this.dsX.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.dsY = null;
        this.mOnClickListener = null;
        this.drM = null;
        this.mOnPageChangeListener = null;
        this.dsZ = null;
        this.drL = null;
        this.drN = null;
        this.dta = 0;
        this.dtb = true;
        this.dtc = false;
        this.drW = false;
        this.dtd = 1;
        this.dte = null;
        this.dtf = null;
        this.dtg = false;
        this.dth = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.dsY = null;
        this.mOnClickListener = null;
        this.drM = null;
        this.mOnPageChangeListener = null;
        this.dsZ = null;
        this.drL = null;
        this.drN = null;
        this.dta = 0;
        this.dtb = true;
        this.dtc = false;
        this.drW = false;
        this.dtd = 1;
        this.dte = null;
        this.dtf = null;
        this.dtg = false;
        this.dth = true;
        init();
    }

    public void init() {
        this.dtc = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dsU) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dsV && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dsZ != null) {
                    MultiImageView.this.dsZ.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dsZ != null) {
                    MultiImageView.this.dsZ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dtd) {
                    MultiImageView.this.dtd = i + 1;
                }
                if (MultiImageView.this.dsX != null) {
                    int childCount = MultiImageView.this.dsX.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dsX.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aNa();
                        }
                    }
                }
                if (MultiImageView.this.dsZ != null) {
                    MultiImageView.this.dsZ.onPageSelected(i);
                }
            }
        };
        this.drL = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dsX != null && MultiImageView.this.dsX.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.drM = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dsX != null && dragImageView == MultiImageView.this.dsX.getCurrentView()) {
                    if (MultiImageView.this.dtb) {
                        int childCount = MultiImageView.this.dsX.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dsX.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.drN = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dsX != null) {
                        MultiImageView.this.dsX.setCurrentView(null);
                    }
                    MultiImageView.this.gq(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dsX != null) {
                        MultiImageView.this.dsX.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.drM != null) {
                        MultiImageView.this.drM.a(imageView);
                    }
                }
                urlDragImageView.aMY();
                urlDragImageView.aMX();
                urlDragImageView.x(MultiImageView.this.drW, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dsY != null) {
            return this.dsY.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dsX != null) {
            int childCount = this.dsX.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dsX.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dsX != null && this.dsX.getCurrentView() != null) {
            if (this.dtb) {
                int childCount = this.dsX.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dsX.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dsX.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dsX.findViewWithTag(String.valueOf(this.dsX.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).x(this.drW, true);
            }
            this.dsX.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dsX != null && this.dsX.getCurrentView() != null) {
            this.dsX.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dsX != null) {
            int childCount = this.dsX.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dsX.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dti != null) {
            this.dti.setAssistUrl(imageUrlData);
            if (this.dtg || imageUrlData == null) {
                gq(false);
                return;
            }
            if (!this.dti.aMH()) {
                this.dti.w(false, false);
            }
            if (!this.dti.isShown()) {
                o(true, 150);
            }
        }
    }

    public void ma(int i) {
        if (this.dsX != null) {
            View findViewWithTag = this.dsX.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                gq(false);
            }
        }
    }

    public void mb(int i) {
        View findViewWithTag;
        if (this.dsX != null && (findViewWithTag = this.dsX.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.x(this.drW, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uB = uB(str);
                urlDragImageView.setAssistUrl(uB);
                c(uB);
            }
            urlDragImageView.x(this.drW, true);
        }
    }

    private ImageUrlData uB(String str) {
        if (TextUtils.isEmpty(str) || this.dtf == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dtf.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mc(int i) {
        if (this.dsX == null) {
            return null;
        }
        View findViewWithTag = this.dsX.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void md(int i) {
        View findViewWithTag;
        if (this.dsX != null && (findViewWithTag = this.dsX.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aNc();
        }
    }

    private void initUI() {
        this.dsX = new GalleryViewPager(getContext());
        this.dsX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dsX.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dsX);
        this.dsW = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dsW.setOrientation(0);
        this.dsW.setLayoutParams(layoutParams);
        addView(this.dsW);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dsV = new Button(getContext());
        am.setBackgroundResource(this.dsV, R.drawable.image_zoomout, 0);
        this.dsV.setLayoutParams(layoutParams2);
        this.dsV.setOnClickListener(this.mOnClickListener);
        this.dsV.setEnabled(false);
        this.dsW.addView(this.dsV);
        this.dsU = new Button(getContext());
        am.setBackgroundResource(this.dsU, R.drawable.image_zoomin, 0);
        this.dsU.setLayoutParams(layoutParams2);
        this.dsU.setOnClickListener(this.mOnClickListener);
        this.dsU.setEnabled(false);
        this.dsW.addView(this.dsU);
        if (this.dtc) {
            this.dsW.setVisibility(8);
        }
        this.dsY = new ImagePagerAdapter(getContext(), this.drM);
        this.dsY.a(this.drN);
        setAdapter(this.dsY);
        this.dti = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dsY != null) {
            this.dsY.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dti != null) {
            this.dti.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dsZ = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dsY == null) {
            return 0;
        }
        return this.dsY.getCount();
    }

    public int getCurrentItem() {
        if (this.dsX == null) {
            return 0;
        }
        return this.dsX.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dsX == null) {
            return null;
        }
        View findViewWithTag = this.dsX.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dsX == null) {
            return null;
        }
        return this.dsX.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dsU.setEnabled(true);
            } else {
                this.dsU.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dsV.setEnabled(true);
                return;
            } else {
                this.dsV.setEnabled(false);
                return;
            }
        }
        this.dsV.setEnabled(false);
        this.dsU.setEnabled(false);
    }

    public void aMO() {
        if (!this.dtc) {
            this.dsW.setVisibility(0);
        }
    }

    public void n(boolean z, int i) {
        this.dtg = z;
        o(!z, i);
    }

    public boolean aMP() {
        return this.dtg;
    }

    public void gq(boolean z) {
        if (this.dti != null) {
            this.dti.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z, int i) {
        if (this.dth && this.dti != null) {
            this.dti.aH(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dsX != null) {
            int childCount = this.dsX.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dsX.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dti != null) {
                this.dti.setUserId(str);
            }
        }
    }

    public void aMQ() {
        if (!this.dtc) {
            this.dsW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dsX == null) {
            return null;
        }
        return this.dsX.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dsX != null) {
            this.dsX.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dsX != null) {
            this.dsX.setOffscreenPageLimit(i);
            this.dta = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dta = (int) (this.dta * 0.8d);
            if (this.dta < 6291456) {
                this.dtb = true;
                this.dta = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dtb = false;
            }
            PagerAdapter adapter = this.dsX.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dta);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.drL);
        }
        if (this.dsX != null) {
            this.dsX.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dsY);
        if (this.dsX != null) {
            this.dsX.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dsY != null) {
            this.dsY.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dsY != null) {
            this.dsY.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dsY != null) {
            this.dsY.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dsY != null) {
            this.dsY.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dsY != null) {
            this.dsY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dte = arrayList;
        if (this.dsY != null) {
            this.dsY.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dtf = map;
        if (this.dsY != null) {
            this.dsY.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dsY != null) {
            this.dsY.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dsY == null) {
            return false;
        }
        return this.dsY.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dsY != null) {
            this.dsY.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dsX == null || (currentView = this.dsX.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dsY != null) {
            this.dsY.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dsX == null || (currentView = this.dsX.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dsX == null || (currentView = this.dsX.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dsX != null && (currentView = this.dsX.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dsX != null) {
            this.dsX.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.drW = z;
        if (this.dsY != null) {
            this.dsY.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dsY != null) {
            this.dsY.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dsY != null) {
            this.dsY.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dsY != null) {
            this.dsY.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dsY != null) {
            this.dsY.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dth = z;
        gq(z);
    }
}
