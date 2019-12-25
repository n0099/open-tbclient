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
/* loaded from: classes5.dex */
public class MultiImageView extends RelativeLayout {
    private boolean dnB;
    private DragImageView.g dnp;
    private DragImageView.e dnq;
    private ImagePagerAdapter.b dnr;
    private Button doA;
    private Button doB;
    private LinearLayout doC;
    private GalleryViewPager doD;
    private ImagePagerAdapter doE;
    private ViewPager.OnPageChangeListener doF;
    private int doG;
    private boolean doH;
    private boolean doI;
    private int doJ;
    private ArrayList<String> doK;
    private Map<String, ImageUrlData> doL;
    private boolean doM;
    private boolean doN;
    protected b doO;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.doJ;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.doA = null;
        this.doB = null;
        this.doC = null;
        this.doD = null;
        this.doE = null;
        this.mOnClickListener = null;
        this.dnq = null;
        this.mOnPageChangeListener = null;
        this.doF = null;
        this.dnp = null;
        this.dnr = null;
        this.doG = 0;
        this.doH = true;
        this.doI = false;
        this.dnB = false;
        this.doJ = 1;
        this.doK = null;
        this.doL = null;
        this.doM = false;
        this.doN = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.doD != null) {
            this.doD.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.doA = null;
        this.doB = null;
        this.doC = null;
        this.doD = null;
        this.doE = null;
        this.mOnClickListener = null;
        this.dnq = null;
        this.mOnPageChangeListener = null;
        this.doF = null;
        this.dnp = null;
        this.dnr = null;
        this.doG = 0;
        this.doH = true;
        this.doI = false;
        this.dnB = false;
        this.doJ = 1;
        this.doK = null;
        this.doL = null;
        this.doM = false;
        this.doN = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.doA = null;
        this.doB = null;
        this.doC = null;
        this.doD = null;
        this.doE = null;
        this.mOnClickListener = null;
        this.dnq = null;
        this.mOnPageChangeListener = null;
        this.doF = null;
        this.dnp = null;
        this.dnr = null;
        this.doG = 0;
        this.doH = true;
        this.doI = false;
        this.dnB = false;
        this.doJ = 1;
        this.doK = null;
        this.doL = null;
        this.doM = false;
        this.doN = true;
        init();
    }

    public void init() {
        this.doI = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.doA) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.doB && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.doF != null) {
                    MultiImageView.this.doF.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.doF != null) {
                    MultiImageView.this.doF.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.doJ) {
                    MultiImageView.this.doJ = i + 1;
                }
                if (MultiImageView.this.doD != null) {
                    int childCount = MultiImageView.this.doD.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.doD.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aKj();
                        }
                    }
                }
                if (MultiImageView.this.doF != null) {
                    MultiImageView.this.doF.onPageSelected(i);
                }
            }
        };
        this.dnp = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.doD != null && MultiImageView.this.doD.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.dnq = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.doD != null && dragImageView == MultiImageView.this.doD.getCurrentView()) {
                    if (MultiImageView.this.doH) {
                        int childCount = MultiImageView.this.doD.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.doD.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dnr = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.doD != null) {
                        MultiImageView.this.doD.setCurrentView(null);
                    }
                    MultiImageView.this.ge(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.doD != null) {
                        MultiImageView.this.doD.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.dnq != null) {
                        MultiImageView.this.dnq.a(imageView);
                    }
                }
                urlDragImageView.aKh();
                urlDragImageView.aKg();
                urlDragImageView.v(MultiImageView.this.dnB, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.doE != null) {
            return this.doE.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.doD != null) {
            int childCount = this.doD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.doD.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.doD != null && this.doD.getCurrentView() != null) {
            if (this.doH) {
                int childCount = this.doD.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.doD.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.doD.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.doD.findViewWithTag(String.valueOf(this.doD.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).v(this.dnB, true);
            }
            this.doD.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.doD != null && this.doD.getCurrentView() != null) {
            this.doD.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.doD != null) {
            int childCount = this.doD.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.doD.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.doO != null) {
            this.doO.setAssistUrl(imageUrlData);
            if (this.doM || imageUrlData == null) {
                ge(false);
                return;
            }
            if (!this.doO.aJQ()) {
                this.doO.u(false, false);
            }
            if (!this.doO.isShown()) {
                m(true, 150);
            }
        }
    }

    public void lI(int i) {
        if (this.doD != null) {
            View findViewWithTag = this.doD.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                ge(false);
            }
        }
    }

    public void lJ(int i) {
        View findViewWithTag;
        if (this.doD != null && (findViewWithTag = this.doD.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.v(this.dnB, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uf = uf(str);
                urlDragImageView.setAssistUrl(uf);
                c(uf);
            }
            urlDragImageView.v(this.dnB, true);
        }
    }

    private ImageUrlData uf(String str) {
        if (TextUtils.isEmpty(str) || this.doL == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.doL.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String lK(int i) {
        if (this.doD == null) {
            return null;
        }
        View findViewWithTag = this.doD.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void lL(int i) {
        View findViewWithTag;
        if (this.doD != null && (findViewWithTag = this.doD.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aKl();
        }
    }

    private void initUI() {
        this.doD = new GalleryViewPager(getContext());
        this.doD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.doD.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.doD);
        this.doC = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.doC.setOrientation(0);
        this.doC.setLayoutParams(layoutParams);
        addView(this.doC);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.doB = new Button(getContext());
        am.setBackgroundResource(this.doB, R.drawable.image_zoomout, 0);
        this.doB.setLayoutParams(layoutParams2);
        this.doB.setOnClickListener(this.mOnClickListener);
        this.doB.setEnabled(false);
        this.doC.addView(this.doB);
        this.doA = new Button(getContext());
        am.setBackgroundResource(this.doA, R.drawable.image_zoomin, 0);
        this.doA.setLayoutParams(layoutParams2);
        this.doA.setOnClickListener(this.mOnClickListener);
        this.doA.setEnabled(false);
        this.doC.addView(this.doA);
        if (this.doI) {
            this.doC.setVisibility(8);
        }
        this.doE = new ImagePagerAdapter(getContext(), this.dnq);
        this.doE.a(this.dnr);
        setAdapter(this.doE);
        this.doO = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.doE != null) {
            this.doE.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.doO != null) {
            this.doO.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.doF = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.doE == null) {
            return 0;
        }
        return this.doE.getCount();
    }

    public int getCurrentItem() {
        if (this.doD == null) {
            return 0;
        }
        return this.doD.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.doD == null) {
            return null;
        }
        View findViewWithTag = this.doD.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.doD == null) {
            return null;
        }
        return this.doD.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.doA.setEnabled(true);
            } else {
                this.doA.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.doB.setEnabled(true);
                return;
            } else {
                this.doB.setEnabled(false);
                return;
            }
        }
        this.doB.setEnabled(false);
        this.doA.setEnabled(false);
    }

    public void aJX() {
        if (!this.doI) {
            this.doC.setVisibility(0);
        }
    }

    public void l(boolean z, int i) {
        this.doM = z;
        m(!z, i);
    }

    public boolean aJY() {
        return this.doM;
    }

    public void ge(boolean z) {
        if (this.doO != null) {
            this.doO.setVisibility(z ? 0 : 8);
        }
    }

    public void m(boolean z, int i) {
        if (this.doN && this.doO != null) {
            this.doO.aD(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.doD != null) {
            int childCount = this.doD.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.doD.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.doO != null) {
                this.doO.setUserId(str);
            }
        }
    }

    public void aJZ() {
        if (!this.doI) {
            this.doC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.doD == null) {
            return null;
        }
        return this.doD.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.doD != null) {
            this.doD.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.doD != null) {
            this.doD.setOffscreenPageLimit(i);
            this.doG = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.doG = (int) (this.doG * 0.8d);
            if (this.doG < 6291456) {
                this.doH = true;
                this.doG = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.doH = false;
            }
            PagerAdapter adapter = this.doD.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.doG);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.dnp);
        }
        if (this.doD != null) {
            this.doD.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.doE);
        if (this.doD != null) {
            this.doD.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.doE != null) {
            this.doE.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.doE != null) {
            this.doE.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.doE != null) {
            this.doE.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.doE != null) {
            this.doE.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.doE != null) {
            this.doE.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.doK = arrayList;
        if (this.doE != null) {
            this.doE.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.doL = map;
        if (this.doE != null) {
            this.doE.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.doE != null) {
            this.doE.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.doE == null) {
            return false;
        }
        return this.doE.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.doE != null) {
            this.doE.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.doD == null || (currentView = this.doD.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.doE != null) {
            this.doE.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.doD == null || (currentView = this.doD.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.doD == null || (currentView = this.doD.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.doD != null && (currentView = this.doD.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.doD != null) {
            this.doD.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dnB = z;
        if (this.doE != null) {
            this.doE.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.doE != null) {
            this.doE.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.doE != null) {
            this.doE.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.doE != null) {
            this.doE.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.doE != null) {
            this.doE.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.doN = z;
        ge(z);
    }
}
