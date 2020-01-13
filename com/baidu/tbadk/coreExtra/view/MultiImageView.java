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
/* loaded from: classes6.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g dnB;
    private DragImageView.e dnC;
    private ImagePagerAdapter.b dnD;
    private boolean dnM;
    private Button doL;
    private Button doM;
    private LinearLayout doN;
    private GalleryViewPager doO;
    private ImagePagerAdapter doP;
    private ViewPager.OnPageChangeListener doQ;
    private int doR;
    private boolean doS;
    private boolean doT;
    private int doU;
    private ArrayList<String> doV;
    private Map<String, ImageUrlData> doW;
    private boolean doX;
    private boolean doY;
    protected b doZ;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.doU;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.doL = null;
        this.doM = null;
        this.doN = null;
        this.doO = null;
        this.doP = null;
        this.mOnClickListener = null;
        this.dnC = null;
        this.mOnPageChangeListener = null;
        this.doQ = null;
        this.dnB = null;
        this.dnD = null;
        this.doR = 0;
        this.doS = true;
        this.doT = false;
        this.dnM = false;
        this.doU = 1;
        this.doV = null;
        this.doW = null;
        this.doX = false;
        this.doY = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.doO != null) {
            this.doO.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.doL = null;
        this.doM = null;
        this.doN = null;
        this.doO = null;
        this.doP = null;
        this.mOnClickListener = null;
        this.dnC = null;
        this.mOnPageChangeListener = null;
        this.doQ = null;
        this.dnB = null;
        this.dnD = null;
        this.doR = 0;
        this.doS = true;
        this.doT = false;
        this.dnM = false;
        this.doU = 1;
        this.doV = null;
        this.doW = null;
        this.doX = false;
        this.doY = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.doL = null;
        this.doM = null;
        this.doN = null;
        this.doO = null;
        this.doP = null;
        this.mOnClickListener = null;
        this.dnC = null;
        this.mOnPageChangeListener = null;
        this.doQ = null;
        this.dnB = null;
        this.dnD = null;
        this.doR = 0;
        this.doS = true;
        this.doT = false;
        this.dnM = false;
        this.doU = 1;
        this.doV = null;
        this.doW = null;
        this.doX = false;
        this.doY = true;
        init();
    }

    public void init() {
        this.doT = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.doL) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.doM && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.doQ != null) {
                    MultiImageView.this.doQ.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.doQ != null) {
                    MultiImageView.this.doQ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.doU) {
                    MultiImageView.this.doU = i + 1;
                }
                if (MultiImageView.this.doO != null) {
                    int childCount = MultiImageView.this.doO.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.doO.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aKC();
                        }
                    }
                }
                if (MultiImageView.this.doQ != null) {
                    MultiImageView.this.doQ.onPageSelected(i);
                }
            }
        };
        this.dnB = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.doO != null && MultiImageView.this.doO.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.dnC = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.doO != null && dragImageView == MultiImageView.this.doO.getCurrentView()) {
                    if (MultiImageView.this.doS) {
                        int childCount = MultiImageView.this.doO.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.doO.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dnD = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.doO != null) {
                        MultiImageView.this.doO.setCurrentView(null);
                    }
                    MultiImageView.this.gj(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.doO != null) {
                        MultiImageView.this.doO.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.dnC != null) {
                        MultiImageView.this.dnC.a(imageView);
                    }
                }
                urlDragImageView.aKA();
                urlDragImageView.aKz();
                urlDragImageView.u(MultiImageView.this.dnM, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.doP != null) {
            return this.doP.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.doO != null) {
            int childCount = this.doO.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.doO.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.doO != null && this.doO.getCurrentView() != null) {
            if (this.doS) {
                int childCount = this.doO.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.doO.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.doO.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.doO.findViewWithTag(String.valueOf(this.doO.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).u(this.dnM, true);
            }
            this.doO.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.doO != null && this.doO.getCurrentView() != null) {
            this.doO.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.doO != null) {
            int childCount = this.doO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.doO.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.doZ != null) {
            this.doZ.setAssistUrl(imageUrlData);
            if (this.doX || imageUrlData == null) {
                gj(false);
                return;
            }
            if (!this.doZ.aKj()) {
                this.doZ.t(false, false);
            }
            if (!this.doZ.isShown()) {
                n(true, 150);
            }
        }
    }

    public void lI(int i) {
        if (this.doO != null) {
            View findViewWithTag = this.doO.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                gj(false);
            }
        }
    }

    public void lJ(int i) {
        View findViewWithTag;
        if (this.doO != null && (findViewWithTag = this.doO.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.u(this.dnM, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uk = uk(str);
                urlDragImageView.setAssistUrl(uk);
                c(uk);
            }
            urlDragImageView.u(this.dnM, true);
        }
    }

    private ImageUrlData uk(String str) {
        if (TextUtils.isEmpty(str) || this.doW == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.doW.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String lK(int i) {
        if (this.doO == null) {
            return null;
        }
        View findViewWithTag = this.doO.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void lL(int i) {
        View findViewWithTag;
        if (this.doO != null && (findViewWithTag = this.doO.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aKE();
        }
    }

    private void initUI() {
        this.doO = new GalleryViewPager(getContext());
        this.doO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.doO.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.doO);
        this.doN = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.doN.setOrientation(0);
        this.doN.setLayoutParams(layoutParams);
        addView(this.doN);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.doM = new Button(getContext());
        am.setBackgroundResource(this.doM, R.drawable.image_zoomout, 0);
        this.doM.setLayoutParams(layoutParams2);
        this.doM.setOnClickListener(this.mOnClickListener);
        this.doM.setEnabled(false);
        this.doN.addView(this.doM);
        this.doL = new Button(getContext());
        am.setBackgroundResource(this.doL, R.drawable.image_zoomin, 0);
        this.doL.setLayoutParams(layoutParams2);
        this.doL.setOnClickListener(this.mOnClickListener);
        this.doL.setEnabled(false);
        this.doN.addView(this.doL);
        if (this.doT) {
            this.doN.setVisibility(8);
        }
        this.doP = new ImagePagerAdapter(getContext(), this.dnC);
        this.doP.a(this.dnD);
        setAdapter(this.doP);
        this.doZ = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.doP != null) {
            this.doP.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.doZ != null) {
            this.doZ.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.doQ = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.doP == null) {
            return 0;
        }
        return this.doP.getCount();
    }

    public int getCurrentItem() {
        if (this.doO == null) {
            return 0;
        }
        return this.doO.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.doO == null) {
            return null;
        }
        View findViewWithTag = this.doO.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.doO == null) {
            return null;
        }
        return this.doO.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.doL.setEnabled(true);
            } else {
                this.doL.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.doM.setEnabled(true);
                return;
            } else {
                this.doM.setEnabled(false);
                return;
            }
        }
        this.doM.setEnabled(false);
        this.doL.setEnabled(false);
    }

    public void aKq() {
        if (!this.doT) {
            this.doN.setVisibility(0);
        }
    }

    public void m(boolean z, int i) {
        this.doX = z;
        n(!z, i);
    }

    public boolean aKr() {
        return this.doX;
    }

    public void gj(boolean z) {
        if (this.doZ != null) {
            this.doZ.setVisibility(z ? 0 : 8);
        }
    }

    public void n(boolean z, int i) {
        if (this.doY && this.doZ != null) {
            this.doZ.aH(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.doO != null) {
            int childCount = this.doO.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.doO.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.doZ != null) {
                this.doZ.setUserId(str);
            }
        }
    }

    public void aKs() {
        if (!this.doT) {
            this.doN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.doO == null) {
            return null;
        }
        return this.doO.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.doO != null) {
            this.doO.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.doO != null) {
            this.doO.setOffscreenPageLimit(i);
            this.doR = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.doR = (int) (this.doR * 0.8d);
            if (this.doR < 6291456) {
                this.doS = true;
                this.doR = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.doS = false;
            }
            PagerAdapter adapter = this.doO.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.doR);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.dnB);
        }
        if (this.doO != null) {
            this.doO.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.doP);
        if (this.doO != null) {
            this.doO.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.doP != null) {
            this.doP.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.doP != null) {
            this.doP.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.doP != null) {
            this.doP.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.doP != null) {
            this.doP.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.doP != null) {
            this.doP.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.doV = arrayList;
        if (this.doP != null) {
            this.doP.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.doW = map;
        if (this.doP != null) {
            this.doP.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.doP != null) {
            this.doP.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.doP == null) {
            return false;
        }
        return this.doP.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.doP != null) {
            this.doP.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.doO == null || (currentView = this.doO.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.doP != null) {
            this.doP.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.doO == null || (currentView = this.doO.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.doO == null || (currentView = this.doO.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.doO != null && (currentView = this.doO.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.doO != null) {
            this.doO.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dnM = z;
        if (this.doP != null) {
            this.doP.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.doP != null) {
            this.doP.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.doP != null) {
            this.doP.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.doP != null) {
            this.doP.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.doP != null) {
            this.doP.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.doY = z;
        gj(z);
    }
}
