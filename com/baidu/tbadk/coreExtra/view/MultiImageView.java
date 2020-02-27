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
    private DragImageView.g drK;
    private DragImageView.e drL;
    private ImagePagerAdapter.b drM;
    private boolean drV;
    private Button dsT;
    private Button dsU;
    private LinearLayout dsV;
    private GalleryViewPager dsW;
    private ImagePagerAdapter dsX;
    private ViewPager.OnPageChangeListener dsY;
    private int dsZ;
    private boolean dta;
    private boolean dtb;
    private int dtc;
    private ArrayList<String> dtd;
    private Map<String, ImageUrlData> dte;
    private boolean dtf;
    private boolean dtg;
    protected b dth;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dtc;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dsT = null;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.mOnClickListener = null;
        this.drL = null;
        this.mOnPageChangeListener = null;
        this.dsY = null;
        this.drK = null;
        this.drM = null;
        this.dsZ = 0;
        this.dta = true;
        this.dtb = false;
        this.drV = false;
        this.dtc = 1;
        this.dtd = null;
        this.dte = null;
        this.dtf = false;
        this.dtg = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dsW != null) {
            this.dsW.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dsT = null;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.mOnClickListener = null;
        this.drL = null;
        this.mOnPageChangeListener = null;
        this.dsY = null;
        this.drK = null;
        this.drM = null;
        this.dsZ = 0;
        this.dta = true;
        this.dtb = false;
        this.drV = false;
        this.dtc = 1;
        this.dtd = null;
        this.dte = null;
        this.dtf = false;
        this.dtg = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dsT = null;
        this.dsU = null;
        this.dsV = null;
        this.dsW = null;
        this.dsX = null;
        this.mOnClickListener = null;
        this.drL = null;
        this.mOnPageChangeListener = null;
        this.dsY = null;
        this.drK = null;
        this.drM = null;
        this.dsZ = 0;
        this.dta = true;
        this.dtb = false;
        this.drV = false;
        this.dtc = 1;
        this.dtd = null;
        this.dte = null;
        this.dtf = false;
        this.dtg = true;
        init();
    }

    public void init() {
        this.dtb = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dsT) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dsU && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dsY != null) {
                    MultiImageView.this.dsY.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dsY != null) {
                    MultiImageView.this.dsY.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dtc) {
                    MultiImageView.this.dtc = i + 1;
                }
                if (MultiImageView.this.dsW != null) {
                    int childCount = MultiImageView.this.dsW.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dsW.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aMY();
                        }
                    }
                }
                if (MultiImageView.this.dsY != null) {
                    MultiImageView.this.dsY.onPageSelected(i);
                }
            }
        };
        this.drK = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dsW != null && MultiImageView.this.dsW.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.drL = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dsW != null && dragImageView == MultiImageView.this.dsW.getCurrentView()) {
                    if (MultiImageView.this.dta) {
                        int childCount = MultiImageView.this.dsW.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dsW.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.drM = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dsW != null) {
                        MultiImageView.this.dsW.setCurrentView(null);
                    }
                    MultiImageView.this.gq(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dsW != null) {
                        MultiImageView.this.dsW.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.drL != null) {
                        MultiImageView.this.drL.a(imageView);
                    }
                }
                urlDragImageView.aMW();
                urlDragImageView.aMV();
                urlDragImageView.x(MultiImageView.this.drV, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dsX != null) {
            return this.dsX.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dsW != null) {
            int childCount = this.dsW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dsW.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dsW != null && this.dsW.getCurrentView() != null) {
            if (this.dta) {
                int childCount = this.dsW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dsW.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dsW.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dsW.findViewWithTag(String.valueOf(this.dsW.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).x(this.drV, true);
            }
            this.dsW.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dsW != null && this.dsW.getCurrentView() != null) {
            this.dsW.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dsW != null) {
            int childCount = this.dsW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dsW.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dth != null) {
            this.dth.setAssistUrl(imageUrlData);
            if (this.dtf || imageUrlData == null) {
                gq(false);
                return;
            }
            if (!this.dth.aMF()) {
                this.dth.w(false, false);
            }
            if (!this.dth.isShown()) {
                o(true, 150);
            }
        }
    }

    public void ma(int i) {
        if (this.dsW != null) {
            View findViewWithTag = this.dsW.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                gq(false);
            }
        }
    }

    public void mb(int i) {
        View findViewWithTag;
        if (this.dsW != null && (findViewWithTag = this.dsW.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.x(this.drV, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uB = uB(str);
                urlDragImageView.setAssistUrl(uB);
                c(uB);
            }
            urlDragImageView.x(this.drV, true);
        }
    }

    private ImageUrlData uB(String str) {
        if (TextUtils.isEmpty(str) || this.dte == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dte.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mc(int i) {
        if (this.dsW == null) {
            return null;
        }
        View findViewWithTag = this.dsW.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void md(int i) {
        View findViewWithTag;
        if (this.dsW != null && (findViewWithTag = this.dsW.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aNa();
        }
    }

    private void initUI() {
        this.dsW = new GalleryViewPager(getContext());
        this.dsW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dsW.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dsW);
        this.dsV = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dsV.setOrientation(0);
        this.dsV.setLayoutParams(layoutParams);
        addView(this.dsV);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dsU = new Button(getContext());
        am.setBackgroundResource(this.dsU, R.drawable.image_zoomout, 0);
        this.dsU.setLayoutParams(layoutParams2);
        this.dsU.setOnClickListener(this.mOnClickListener);
        this.dsU.setEnabled(false);
        this.dsV.addView(this.dsU);
        this.dsT = new Button(getContext());
        am.setBackgroundResource(this.dsT, R.drawable.image_zoomin, 0);
        this.dsT.setLayoutParams(layoutParams2);
        this.dsT.setOnClickListener(this.mOnClickListener);
        this.dsT.setEnabled(false);
        this.dsV.addView(this.dsT);
        if (this.dtb) {
            this.dsV.setVisibility(8);
        }
        this.dsX = new ImagePagerAdapter(getContext(), this.drL);
        this.dsX.a(this.drM);
        setAdapter(this.dsX);
        this.dth = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dsX != null) {
            this.dsX.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dth != null) {
            this.dth.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dsY = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dsX == null) {
            return 0;
        }
        return this.dsX.getCount();
    }

    public int getCurrentItem() {
        if (this.dsW == null) {
            return 0;
        }
        return this.dsW.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dsW == null) {
            return null;
        }
        View findViewWithTag = this.dsW.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dsW == null) {
            return null;
        }
        return this.dsW.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dsT.setEnabled(true);
            } else {
                this.dsT.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dsU.setEnabled(true);
                return;
            } else {
                this.dsU.setEnabled(false);
                return;
            }
        }
        this.dsU.setEnabled(false);
        this.dsT.setEnabled(false);
    }

    public void aMM() {
        if (!this.dtb) {
            this.dsV.setVisibility(0);
        }
    }

    public void n(boolean z, int i) {
        this.dtf = z;
        o(!z, i);
    }

    public boolean aMN() {
        return this.dtf;
    }

    public void gq(boolean z) {
        if (this.dth != null) {
            this.dth.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z, int i) {
        if (this.dtg && this.dth != null) {
            this.dth.aH(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dsW != null) {
            int childCount = this.dsW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dsW.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dth != null) {
                this.dth.setUserId(str);
            }
        }
    }

    public void aMO() {
        if (!this.dtb) {
            this.dsV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dsW == null) {
            return null;
        }
        return this.dsW.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dsW != null) {
            this.dsW.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dsW != null) {
            this.dsW.setOffscreenPageLimit(i);
            this.dsZ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dsZ = (int) (this.dsZ * 0.8d);
            if (this.dsZ < 6291456) {
                this.dta = true;
                this.dsZ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dta = false;
            }
            PagerAdapter adapter = this.dsW.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dsZ);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.drK);
        }
        if (this.dsW != null) {
            this.dsW.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dsX);
        if (this.dsW != null) {
            this.dsW.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dsX != null) {
            this.dsX.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dsX != null) {
            this.dsX.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dsX != null) {
            this.dsX.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dsX != null) {
            this.dsX.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dsX != null) {
            this.dsX.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dtd = arrayList;
        if (this.dsX != null) {
            this.dsX.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dte = map;
        if (this.dsX != null) {
            this.dsX.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dsX != null) {
            this.dsX.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dsX == null) {
            return false;
        }
        return this.dsX.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dsX != null) {
            this.dsX.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dsW == null || (currentView = this.dsW.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dsX != null) {
            this.dsX.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dsW == null || (currentView = this.dsW.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dsW == null || (currentView = this.dsW.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dsW != null && (currentView = this.dsW.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dsW != null) {
            this.dsW.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.drV = z;
        if (this.dsX != null) {
            this.dsX.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dsX != null) {
            this.dsX.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dsX != null) {
            this.dsX.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dsX != null) {
            this.dsX.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dsX != null) {
            this.dsX.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dtg = z;
        gq(z);
    }
}
