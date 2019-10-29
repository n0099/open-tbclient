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
    private DragImageView.e cAA;
    private ImagePagerAdapter.b cAB;
    private boolean cAK;
    private DragImageView.g cAz;
    private Button cBJ;
    private Button cBK;
    private LinearLayout cBL;
    private GalleryViewPager cBM;
    private ImagePagerAdapter cBN;
    private ViewPager.OnPageChangeListener cBO;
    private int cBP;
    private boolean cBQ;
    private boolean cBR;
    private int cBS;
    private ArrayList<String> cBT;
    private Map<String, ImageUrlData> cBU;
    private boolean cBV;
    protected b cBW;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cBS;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cBJ = null;
        this.cBK = null;
        this.cBL = null;
        this.cBM = null;
        this.cBN = null;
        this.mOnClickListener = null;
        this.cAA = null;
        this.mOnPageChangeListener = null;
        this.cBO = null;
        this.cAz = null;
        this.cAB = null;
        this.cBP = 0;
        this.cBQ = true;
        this.cBR = false;
        this.cAK = false;
        this.cBS = 1;
        this.cBT = null;
        this.cBU = null;
        this.cBV = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cBM != null) {
            this.cBM.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cBJ = null;
        this.cBK = null;
        this.cBL = null;
        this.cBM = null;
        this.cBN = null;
        this.mOnClickListener = null;
        this.cAA = null;
        this.mOnPageChangeListener = null;
        this.cBO = null;
        this.cAz = null;
        this.cAB = null;
        this.cBP = 0;
        this.cBQ = true;
        this.cBR = false;
        this.cAK = false;
        this.cBS = 1;
        this.cBT = null;
        this.cBU = null;
        this.cBV = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cBJ = null;
        this.cBK = null;
        this.cBL = null;
        this.cBM = null;
        this.cBN = null;
        this.mOnClickListener = null;
        this.cAA = null;
        this.mOnPageChangeListener = null;
        this.cBO = null;
        this.cAz = null;
        this.cAB = null;
        this.cBP = 0;
        this.cBQ = true;
        this.cBR = false;
        this.cAK = false;
        this.cBS = 1;
        this.cBT = null;
        this.cBU = null;
        this.cBV = false;
        init();
    }

    public void init() {
        this.cBR = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cBJ) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.cBK && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cBO != null) {
                    MultiImageView.this.cBO.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cBO != null) {
                    MultiImageView.this.cBO.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cBS) {
                    MultiImageView.this.cBS = i + 1;
                }
                if (MultiImageView.this.cBM != null) {
                    int childCount = MultiImageView.this.cBM.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cBM.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).asM();
                        }
                    }
                }
                if (MultiImageView.this.cBO != null) {
                    MultiImageView.this.cBO.onPageSelected(i);
                }
            }
        };
        this.cAz = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cBM != null && MultiImageView.this.cBM.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cAA = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cBM != null && dragImageView == MultiImageView.this.cBM.getCurrentView()) {
                    if (MultiImageView.this.cBQ) {
                        int childCount = MultiImageView.this.cBM.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cBM.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cAB = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cBM != null) {
                        MultiImageView.this.cBM.setCurrentView(null);
                    }
                    MultiImageView.this.eS(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.cBM != null) {
                        MultiImageView.this.cBM.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cAA != null) {
                        MultiImageView.this.cAA.a(imageView);
                    }
                }
                urlDragImageView.asK();
                urlDragImageView.asJ();
                urlDragImageView.u(MultiImageView.this.cAK, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cBN != null) {
            return this.cBN.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.cBM != null) {
            int childCount = this.cBM.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cBM.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cBM != null && this.cBM.getCurrentView() != null) {
            if (this.cBQ) {
                int childCount = this.cBM.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cBM.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cBM.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cBM.findViewWithTag(String.valueOf(this.cBM.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).u(this.cAK, true);
            }
            this.cBM.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cBM != null && this.cBM.getCurrentView() != null) {
            this.cBM.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cBM != null) {
            int childCount = this.cBM.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cBM.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cBW != null) {
            this.cBW.setAssistUrl(imageUrlData);
            if (this.cBV || imageUrlData == null) {
                eS(false);
                return;
            }
            if (!this.cBW.ast()) {
                this.cBW.t(false, false);
            }
            if (!this.cBW.isShown()) {
                i(true, 150);
            }
        }
    }

    public void jw(int i) {
        if (this.cBM != null) {
            View findViewWithTag = this.cBM.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eS(false);
            }
        }
    }

    public void jx(int i) {
        View findViewWithTag;
        if (this.cBM != null && (findViewWithTag = this.cBM.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.u(this.cAK, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pb = pb(str);
                urlDragImageView.setAssistUrl(pb);
                c(pb);
            }
            urlDragImageView.u(this.cAK, true);
        }
    }

    private ImageUrlData pb(String str) {
        if (TextUtils.isEmpty(str) || this.cBU == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cBU.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jy(int i) {
        if (this.cBM == null) {
            return null;
        }
        View findViewWithTag = this.cBM.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jz(int i) {
        View findViewWithTag;
        if (this.cBM != null && (findViewWithTag = this.cBM.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).asO();
        }
    }

    private void initUI() {
        this.cBM = new GalleryViewPager(getContext());
        this.cBM.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cBM.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cBM);
        this.cBL = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cBL.setOrientation(0);
        this.cBL.setLayoutParams(layoutParams);
        addView(this.cBL);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cBK = new Button(getContext());
        am.setBackgroundResource(this.cBK, R.drawable.image_zoomout, 0);
        this.cBK.setLayoutParams(layoutParams2);
        this.cBK.setOnClickListener(this.mOnClickListener);
        this.cBK.setEnabled(false);
        this.cBL.addView(this.cBK);
        this.cBJ = new Button(getContext());
        am.setBackgroundResource(this.cBJ, R.drawable.image_zoomin, 0);
        this.cBJ.setLayoutParams(layoutParams2);
        this.cBJ.setOnClickListener(this.mOnClickListener);
        this.cBJ.setEnabled(false);
        this.cBL.addView(this.cBJ);
        if (this.cBR) {
            this.cBL.setVisibility(8);
        }
        this.cBN = new ImagePagerAdapter(getContext(), this.cAA);
        this.cBN.a(this.cAB);
        setAdapter(this.cBN);
        this.cBW = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cBN != null) {
            this.cBN.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cBN != null) {
            this.cBN.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cBO = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cBN == null) {
            return 0;
        }
        return this.cBN.getCount();
    }

    public int getCurrentItem() {
        if (this.cBM == null) {
            return 0;
        }
        return this.cBM.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cBM == null) {
            return null;
        }
        View findViewWithTag = this.cBM.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cBJ.setEnabled(true);
            } else {
                this.cBJ.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.cBK.setEnabled(true);
                return;
            } else {
                this.cBK.setEnabled(false);
                return;
            }
        }
        this.cBK.setEnabled(false);
        this.cBJ.setEnabled(false);
    }

    public void asA() {
        if (!this.cBR) {
            this.cBL.setVisibility(0);
        }
    }

    public void h(boolean z, int i) {
        this.cBV = z;
        i(!z, i);
    }

    public boolean asB() {
        return this.cBV;
    }

    public void eS(boolean z) {
        if (this.cBW != null) {
            this.cBW.setVisibility(z ? 0 : 8);
        }
    }

    public void i(boolean z, int i) {
        if (this.cBW != null) {
            this.cBW.am(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cBM != null) {
            int childCount = this.cBM.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cBM.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cBW != null) {
                this.cBW.setUserId(str);
            }
        }
    }

    public void asC() {
        if (!this.cBR) {
            this.cBL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cBM == null) {
            return null;
        }
        return this.cBM.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cBM != null) {
            this.cBM.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cBM != null) {
            this.cBM.setOffscreenPageLimit(i);
            this.cBP = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cBP = (int) (this.cBP * 0.8d);
            if (this.cBP < 6291456) {
                this.cBQ = true;
                this.cBP = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cBQ = false;
            }
            PagerAdapter adapter = this.cBM.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cBP);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cAz);
        }
        if (this.cBM != null) {
            this.cBM.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cBN);
        if (this.cBM != null) {
            this.cBM.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cBN != null) {
            this.cBN.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cBN != null) {
            this.cBN.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cBN != null) {
            this.cBN.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cBN != null) {
            this.cBN.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cBN != null) {
            this.cBN.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cBT = arrayList;
        if (this.cBN != null) {
            this.cBN.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cBU = map;
        if (this.cBN != null) {
            this.cBN.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cBN != null) {
            this.cBN.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cBN == null) {
            return false;
        }
        return this.cBN.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cBN != null) {
            this.cBN.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cBM == null || (currentView = this.cBM.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cBN != null) {
            this.cBN.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.cBM == null || (currentView = this.cBM.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cBM == null || (currentView = this.cBM.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cBM != null && (currentView = this.cBM.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cBM != null) {
            this.cBM.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cAK = z;
        if (this.cBN != null) {
            this.cBN.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cBN != null) {
            this.cBN.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cBN != null) {
            this.cBN.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cBN != null) {
            this.cBN.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cBN != null) {
            this.cBN.setOriImgSelectedCallback(bVar);
        }
    }
}
