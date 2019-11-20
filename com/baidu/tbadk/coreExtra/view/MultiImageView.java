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
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    private Button cAS;
    private Button cAT;
    private LinearLayout cAU;
    private GalleryViewPager cAV;
    private ImagePagerAdapter cAW;
    private ViewPager.OnPageChangeListener cAX;
    private int cAY;
    private boolean cAZ;
    private boolean cBa;
    private int cBb;
    private ArrayList<String> cBc;
    private Map<String, ImageUrlData> cBd;
    private boolean cBe;
    protected b cBf;
    private DragImageView.g czI;
    private DragImageView.e czJ;
    private ImagePagerAdapter.b czK;
    private boolean czT;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cBb;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cAS = null;
        this.cAT = null;
        this.cAU = null;
        this.cAV = null;
        this.cAW = null;
        this.mOnClickListener = null;
        this.czJ = null;
        this.mOnPageChangeListener = null;
        this.cAX = null;
        this.czI = null;
        this.czK = null;
        this.cAY = 0;
        this.cAZ = true;
        this.cBa = false;
        this.czT = false;
        this.cBb = 1;
        this.cBc = null;
        this.cBd = null;
        this.cBe = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cAV != null) {
            this.cAV.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAS = null;
        this.cAT = null;
        this.cAU = null;
        this.cAV = null;
        this.cAW = null;
        this.mOnClickListener = null;
        this.czJ = null;
        this.mOnPageChangeListener = null;
        this.cAX = null;
        this.czI = null;
        this.czK = null;
        this.cAY = 0;
        this.cAZ = true;
        this.cBa = false;
        this.czT = false;
        this.cBb = 1;
        this.cBc = null;
        this.cBd = null;
        this.cBe = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cAS = null;
        this.cAT = null;
        this.cAU = null;
        this.cAV = null;
        this.cAW = null;
        this.mOnClickListener = null;
        this.czJ = null;
        this.mOnPageChangeListener = null;
        this.cAX = null;
        this.czI = null;
        this.czK = null;
        this.cAY = 0;
        this.cAZ = true;
        this.cBa = false;
        this.czT = false;
        this.cBb = 1;
        this.cBc = null;
        this.cBd = null;
        this.cBe = false;
        init();
    }

    public void init() {
        this.cBa = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cAS) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.cAT && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cAX != null) {
                    MultiImageView.this.cAX.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cAX != null) {
                    MultiImageView.this.cAX.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cBb) {
                    MultiImageView.this.cBb = i + 1;
                }
                if (MultiImageView.this.cAV != null) {
                    int childCount = MultiImageView.this.cAV.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cAV.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).asK();
                        }
                    }
                }
                if (MultiImageView.this.cAX != null) {
                    MultiImageView.this.cAX.onPageSelected(i);
                }
            }
        };
        this.czI = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cAV != null && MultiImageView.this.cAV.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.czJ = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cAV != null && dragImageView == MultiImageView.this.cAV.getCurrentView()) {
                    if (MultiImageView.this.cAZ) {
                        int childCount = MultiImageView.this.cAV.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cAV.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.czK = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cAV != null) {
                        MultiImageView.this.cAV.setCurrentView(null);
                    }
                    MultiImageView.this.eS(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.cAV != null) {
                        MultiImageView.this.cAV.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.czJ != null) {
                        MultiImageView.this.czJ.a(imageView);
                    }
                }
                urlDragImageView.asI();
                urlDragImageView.asH();
                urlDragImageView.u(MultiImageView.this.czT, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cAW != null) {
            return this.cAW.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.cAV != null) {
            int childCount = this.cAV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cAV.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cAV != null && this.cAV.getCurrentView() != null) {
            if (this.cAZ) {
                int childCount = this.cAV.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cAV.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cAV.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cAV.findViewWithTag(String.valueOf(this.cAV.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).u(this.czT, true);
            }
            this.cAV.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cAV != null && this.cAV.getCurrentView() != null) {
            this.cAV.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cAV != null) {
            int childCount = this.cAV.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cAV.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cBf != null) {
            this.cBf.setAssistUrl(imageUrlData);
            if (this.cBe || imageUrlData == null) {
                eS(false);
                return;
            }
            if (!this.cBf.asr()) {
                this.cBf.t(false, false);
            }
            if (!this.cBf.isShown()) {
                i(true, 150);
            }
        }
    }

    public void jv(int i) {
        if (this.cAV != null) {
            View findViewWithTag = this.cAV.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eS(false);
            }
        }
    }

    public void jw(int i) {
        View findViewWithTag;
        if (this.cAV != null && (findViewWithTag = this.cAV.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.u(this.czT, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pb = pb(str);
                urlDragImageView.setAssistUrl(pb);
                c(pb);
            }
            urlDragImageView.u(this.czT, true);
        }
    }

    private ImageUrlData pb(String str) {
        if (TextUtils.isEmpty(str) || this.cBd == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cBd.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jx(int i) {
        if (this.cAV == null) {
            return null;
        }
        View findViewWithTag = this.cAV.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jy(int i) {
        View findViewWithTag;
        if (this.cAV != null && (findViewWithTag = this.cAV.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).asM();
        }
    }

    private void initUI() {
        this.cAV = new GalleryViewPager(getContext());
        this.cAV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cAV.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cAV);
        this.cAU = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cAU.setOrientation(0);
        this.cAU.setLayoutParams(layoutParams);
        addView(this.cAU);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cAT = new Button(getContext());
        am.setBackgroundResource(this.cAT, R.drawable.image_zoomout, 0);
        this.cAT.setLayoutParams(layoutParams2);
        this.cAT.setOnClickListener(this.mOnClickListener);
        this.cAT.setEnabled(false);
        this.cAU.addView(this.cAT);
        this.cAS = new Button(getContext());
        am.setBackgroundResource(this.cAS, R.drawable.image_zoomin, 0);
        this.cAS.setLayoutParams(layoutParams2);
        this.cAS.setOnClickListener(this.mOnClickListener);
        this.cAS.setEnabled(false);
        this.cAU.addView(this.cAS);
        if (this.cBa) {
            this.cAU.setVisibility(8);
        }
        this.cAW = new ImagePagerAdapter(getContext(), this.czJ);
        this.cAW.a(this.czK);
        setAdapter(this.cAW);
        this.cBf = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cAW != null) {
            this.cAW.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cAW != null) {
            this.cAW.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cAX = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cAW == null) {
            return 0;
        }
        return this.cAW.getCount();
    }

    public int getCurrentItem() {
        if (this.cAV == null) {
            return 0;
        }
        return this.cAV.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cAV == null) {
            return null;
        }
        View findViewWithTag = this.cAV.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cAS.setEnabled(true);
            } else {
                this.cAS.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.cAT.setEnabled(true);
                return;
            } else {
                this.cAT.setEnabled(false);
                return;
            }
        }
        this.cAT.setEnabled(false);
        this.cAS.setEnabled(false);
    }

    public void asy() {
        if (!this.cBa) {
            this.cAU.setVisibility(0);
        }
    }

    public void h(boolean z, int i) {
        this.cBe = z;
        i(!z, i);
    }

    public boolean asz() {
        return this.cBe;
    }

    public void eS(boolean z) {
        if (this.cBf != null) {
            this.cBf.setVisibility(z ? 0 : 8);
        }
    }

    public void i(boolean z, int i) {
        if (this.cBf != null) {
            this.cBf.ak(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cAV != null) {
            int childCount = this.cAV.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cAV.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cBf != null) {
                this.cBf.setUserId(str);
            }
        }
    }

    public void asA() {
        if (!this.cBa) {
            this.cAU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cAV == null) {
            return null;
        }
        return this.cAV.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cAV != null) {
            this.cAV.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cAV != null) {
            this.cAV.setOffscreenPageLimit(i);
            this.cAY = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cAY = (int) (this.cAY * 0.8d);
            if (this.cAY < 6291456) {
                this.cAZ = true;
                this.cAY = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cAZ = false;
            }
            PagerAdapter adapter = this.cAV.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cAY);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.czI);
        }
        if (this.cAV != null) {
            this.cAV.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cAW);
        if (this.cAV != null) {
            this.cAV.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cAW != null) {
            this.cAW.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cAW != null) {
            this.cAW.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cAW != null) {
            this.cAW.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cAW != null) {
            this.cAW.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cAW != null) {
            this.cAW.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cBc = arrayList;
        if (this.cAW != null) {
            this.cAW.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cBd = map;
        if (this.cAW != null) {
            this.cAW.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cAW != null) {
            this.cAW.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cAW == null) {
            return false;
        }
        return this.cAW.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cAW != null) {
            this.cAW.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cAV == null || (currentView = this.cAV.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cAW != null) {
            this.cAW.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.cAV == null || (currentView = this.cAV.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cAV == null || (currentView = this.cAV.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cAV != null && (currentView = this.cAV.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cAV != null) {
            this.cAV.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.czT = z;
        if (this.cAW != null) {
            this.cAW.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cAW != null) {
            this.cAW.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cAW != null) {
            this.cAW.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cAW != null) {
            this.cAW.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cAW != null) {
            this.cAW.setOriImgSelectedCallback(bVar);
        }
    }
}
