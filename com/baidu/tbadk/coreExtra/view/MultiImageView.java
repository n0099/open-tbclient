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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g clm;
    private DragImageView.e cln;
    private ImagePagerAdapter.b clo;
    private boolean cly;
    private LinearLayout cmA;
    private GalleryViewPager cmB;
    private ImagePagerAdapter cmC;
    private ViewPager.OnPageChangeListener cmD;
    private int cmE;
    private boolean cmF;
    private boolean cmG;
    private int cmH;
    private ArrayList<String> cmI;
    private Map<String, ImageUrlData> cmJ;
    private boolean cmK;
    protected b cmL;
    private Button cmy;
    private Button cmz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cmH;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cmy = null;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.mOnClickListener = null;
        this.cln = null;
        this.mOnPageChangeListener = null;
        this.cmD = null;
        this.clm = null;
        this.clo = null;
        this.cmE = 0;
        this.cmF = true;
        this.cmG = false;
        this.cly = false;
        this.cmH = 1;
        this.cmI = null;
        this.cmJ = null;
        this.cmK = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cmB != null) {
            this.cmB.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cmy = null;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.mOnClickListener = null;
        this.cln = null;
        this.mOnPageChangeListener = null;
        this.cmD = null;
        this.clm = null;
        this.clo = null;
        this.cmE = 0;
        this.cmF = true;
        this.cmG = false;
        this.cly = false;
        this.cmH = 1;
        this.cmI = null;
        this.cmJ = null;
        this.cmK = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cmy = null;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.mOnClickListener = null;
        this.cln = null;
        this.mOnPageChangeListener = null;
        this.cmD = null;
        this.clm = null;
        this.clo = null;
        this.cmE = 0;
        this.cmF = true;
        this.cmG = false;
        this.cly = false;
        this.cmH = 1;
        this.cmI = null;
        this.cmJ = null;
        this.cmK = false;
        init();
    }

    public void init() {
        this.cmG = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cmy) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.avN();
                    }
                } else if (view == MultiImageView.this.cmz && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.avO();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cmD != null) {
                    MultiImageView.this.cmD.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cmD != null) {
                    MultiImageView.this.cmD.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cmH) {
                    MultiImageView.this.cmH = i + 1;
                }
                if (MultiImageView.this.cmB != null) {
                    int childCount = MultiImageView.this.cmB.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cmB.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).apA();
                        }
                    }
                }
                if (MultiImageView.this.cmD != null) {
                    MultiImageView.this.cmD.onPageSelected(i);
                }
            }
        };
        this.clm = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cmB != null && MultiImageView.this.cmB.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cln = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cmB != null && dragImageView == MultiImageView.this.cmB.getCurrentView()) {
                    if (MultiImageView.this.cmF) {
                        int childCount = MultiImageView.this.cmB.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cmB.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.clo = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cmB != null) {
                        MultiImageView.this.cmB.setCurrentView(null);
                    }
                    MultiImageView.this.eQ(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.avP();
                    if (MultiImageView.this.cmB != null) {
                        MultiImageView.this.cmB.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cln != null) {
                        MultiImageView.this.cln.a(imageView);
                    }
                }
                urlDragImageView.apy();
                urlDragImageView.apx();
                urlDragImageView.p(MultiImageView.this.cly, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cmC != null) {
            return this.cmC.getCount();
        }
        return 0;
    }

    public void iA(int i) {
        if (this.mSkinType != i && this.cmB != null) {
            int childCount = this.cmB.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cmB.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cmB != null && this.cmB.getCurrentView() != null) {
            if (this.cmF) {
                int childCount = this.cmB.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cmB.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cmB.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cmB.findViewWithTag(String.valueOf(this.cmB.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).p(this.cly, true);
            }
            this.cmB.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cmB != null && this.cmB.getCurrentView() != null) {
            this.cmB.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cmB != null) {
            int childCount = this.cmB.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cmB.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cmL != null) {
            this.cmL.setAssistUrl(imageUrlData);
            if (this.cmK || imageUrlData == null) {
                eQ(false);
                return;
            }
            if (!this.cmL.apf()) {
                this.cmL.o(false, false);
            }
            if (!this.cmL.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jP(int i) {
        if (this.cmB != null) {
            View findViewWithTag = this.cmB.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eQ(false);
            }
        }
    }

    public void jQ(int i) {
        View findViewWithTag;
        if (this.cmB != null && (findViewWithTag = this.cmB.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.p(this.cly, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pq = pq(str);
                urlDragImageView.setAssistUrl(pq);
                c(pq);
            }
            urlDragImageView.p(this.cly, true);
        }
    }

    private ImageUrlData pq(String str) {
        if (TextUtils.isEmpty(str) || this.cmJ == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cmJ.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jR(int i) {
        if (this.cmB == null) {
            return null;
        }
        View findViewWithTag = this.cmB.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jS(int i) {
        View findViewWithTag;
        if (this.cmB != null && (findViewWithTag = this.cmB.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).apC();
        }
    }

    private void initUI() {
        this.cmB = new GalleryViewPager(getContext());
        this.cmB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cmB.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cmB);
        this.cmA = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cmA.setOrientation(0);
        this.cmA.setLayoutParams(layoutParams);
        addView(this.cmA);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cmz = new Button(getContext());
        al.g(this.cmz, R.drawable.image_zoomout, 0);
        this.cmz.setLayoutParams(layoutParams2);
        this.cmz.setOnClickListener(this.mOnClickListener);
        this.cmz.setEnabled(false);
        this.cmA.addView(this.cmz);
        this.cmy = new Button(getContext());
        al.g(this.cmy, R.drawable.image_zoomin, 0);
        this.cmy.setLayoutParams(layoutParams2);
        this.cmy.setOnClickListener(this.mOnClickListener);
        this.cmy.setEnabled(false);
        this.cmA.addView(this.cmy);
        if (this.cmG) {
            this.cmA.setVisibility(8);
        }
        this.cmC = new ImagePagerAdapter(getContext(), this.cln);
        this.cmC.a(this.clo);
        setAdapter(this.cmC);
        this.cmL = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cmC != null) {
            this.cmC.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cmC != null) {
            this.cmC.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cmD = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cmC == null) {
            return 0;
        }
        return this.cmC.getCount();
    }

    public int getCurrentItem() {
        if (this.cmB == null) {
            return 0;
        }
        return this.cmB.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cmB == null) {
            return null;
        }
        View findViewWithTag = this.cmB.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cmy.setEnabled(true);
            } else {
                this.cmy.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.cmz.setEnabled(true);
                return;
            } else {
                this.cmz.setEnabled(false);
                return;
            }
        }
        this.cmz.setEnabled(false);
        this.cmy.setEnabled(false);
    }

    public void apn() {
        if (!this.cmG) {
            this.cmA.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.cmK = z;
        h(!z, i);
    }

    public boolean apo() {
        return this.cmK;
    }

    public void eQ(boolean z) {
        if (this.cmL != null) {
            this.cmL.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.cmL != null) {
            this.cmL.af(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cmB != null) {
            int childCount = this.cmB.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cmB.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cmL != null) {
                this.cmL.setUserId(str);
            }
        }
    }

    public void app() {
        if (!this.cmG) {
            this.cmA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cmB == null) {
            return null;
        }
        return this.cmB.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cmB != null) {
            this.cmB.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cmB != null) {
            this.cmB.setOffscreenPageLimit(i);
            this.cmE = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cmE = (int) (this.cmE * 0.8d);
            if (this.cmE < 6291456) {
                this.cmF = true;
                this.cmE = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cmF = false;
            }
            PagerAdapter adapter = this.cmB.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cmE);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.clm);
        }
        if (this.cmB != null) {
            this.cmB.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cmC);
        if (this.cmB != null) {
            this.cmB.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cmC != null) {
            this.cmC.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cmC != null) {
            this.cmC.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cmC != null) {
            this.cmC.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cmC != null) {
            this.cmC.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cmC != null) {
            this.cmC.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cmI = arrayList;
        if (this.cmC != null) {
            this.cmC.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cmJ = map;
        if (this.cmC != null) {
            this.cmC.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cmC != null) {
            this.cmC.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cmC == null) {
            return false;
        }
        return this.cmC.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cmC != null) {
            this.cmC.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cmB == null || (currentView = this.cmB.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cmC != null) {
            this.cmC.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        if (this.cmB == null) {
            return null;
        }
        DragImageView currentView = this.cmB.getCurrentView();
        if (currentView.getTag() instanceof String) {
            return (String) currentView.getTag();
        }
        return null;
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cmB == null || (currentView = this.cmB.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cmB != null && (currentView = this.cmB.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cmB != null) {
            this.cmB.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cly = z;
        if (this.cmC != null) {
            this.cmC.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cmC != null) {
            this.cmC.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cmC != null) {
            this.cmC.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cmC != null) {
            this.cmC.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cmC != null) {
            this.cmC.setOriImgSelectedCallback(bVar);
        }
    }
}
