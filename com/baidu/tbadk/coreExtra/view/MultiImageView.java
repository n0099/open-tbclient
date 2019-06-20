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
    private DragImageView.g cln;
    private DragImageView.e clo;
    private ImagePagerAdapter.b clp;
    private boolean clz;
    private Button cmA;
    private LinearLayout cmB;
    private GalleryViewPager cmC;
    private ImagePagerAdapter cmD;
    private ViewPager.OnPageChangeListener cmE;
    private int cmF;
    private boolean cmG;
    private boolean cmH;
    private int cmI;
    private ArrayList<String> cmJ;
    private Map<String, ImageUrlData> cmK;
    private boolean cmL;
    protected b cmM;
    private Button cmz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cmI;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.cmD = null;
        this.mOnClickListener = null;
        this.clo = null;
        this.mOnPageChangeListener = null;
        this.cmE = null;
        this.cln = null;
        this.clp = null;
        this.cmF = 0;
        this.cmG = true;
        this.cmH = false;
        this.clz = false;
        this.cmI = 1;
        this.cmJ = null;
        this.cmK = null;
        this.cmL = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cmC != null) {
            this.cmC.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.cmD = null;
        this.mOnClickListener = null;
        this.clo = null;
        this.mOnPageChangeListener = null;
        this.cmE = null;
        this.cln = null;
        this.clp = null;
        this.cmF = 0;
        this.cmG = true;
        this.cmH = false;
        this.clz = false;
        this.cmI = 1;
        this.cmJ = null;
        this.cmK = null;
        this.cmL = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cmz = null;
        this.cmA = null;
        this.cmB = null;
        this.cmC = null;
        this.cmD = null;
        this.mOnClickListener = null;
        this.clo = null;
        this.mOnPageChangeListener = null;
        this.cmE = null;
        this.cln = null;
        this.clp = null;
        this.cmF = 0;
        this.cmG = true;
        this.cmH = false;
        this.clz = false;
        this.cmI = 1;
        this.cmJ = null;
        this.cmK = null;
        this.cmL = false;
        init();
    }

    public void init() {
        this.cmH = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cmz) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.avO();
                    }
                } else if (view == MultiImageView.this.cmA && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.avP();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cmE != null) {
                    MultiImageView.this.cmE.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cmE != null) {
                    MultiImageView.this.cmE.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cmI) {
                    MultiImageView.this.cmI = i + 1;
                }
                if (MultiImageView.this.cmC != null) {
                    int childCount = MultiImageView.this.cmC.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cmC.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).apA();
                        }
                    }
                }
                if (MultiImageView.this.cmE != null) {
                    MultiImageView.this.cmE.onPageSelected(i);
                }
            }
        };
        this.cln = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cmC != null && MultiImageView.this.cmC.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.clo = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cmC != null && dragImageView == MultiImageView.this.cmC.getCurrentView()) {
                    if (MultiImageView.this.cmG) {
                        int childCount = MultiImageView.this.cmC.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cmC.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.clp = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cmC != null) {
                        MultiImageView.this.cmC.setCurrentView(null);
                    }
                    MultiImageView.this.eQ(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.avQ();
                    if (MultiImageView.this.cmC != null) {
                        MultiImageView.this.cmC.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.clo != null) {
                        MultiImageView.this.clo.a(imageView);
                    }
                }
                urlDragImageView.apy();
                urlDragImageView.apx();
                urlDragImageView.p(MultiImageView.this.clz, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cmD != null) {
            return this.cmD.getCount();
        }
        return 0;
    }

    public void iA(int i) {
        if (this.mSkinType != i && this.cmC != null) {
            int childCount = this.cmC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cmC.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cmC != null && this.cmC.getCurrentView() != null) {
            if (this.cmG) {
                int childCount = this.cmC.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cmC.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cmC.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cmC.findViewWithTag(String.valueOf(this.cmC.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).p(this.clz, true);
            }
            this.cmC.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cmC != null && this.cmC.getCurrentView() != null) {
            this.cmC.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cmC != null) {
            int childCount = this.cmC.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cmC.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cmM != null) {
            this.cmM.setAssistUrl(imageUrlData);
            if (this.cmL || imageUrlData == null) {
                eQ(false);
                return;
            }
            if (!this.cmM.apf()) {
                this.cmM.o(false, false);
            }
            if (!this.cmM.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jP(int i) {
        if (this.cmC != null) {
            View findViewWithTag = this.cmC.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eQ(false);
            }
        }
    }

    public void jQ(int i) {
        View findViewWithTag;
        if (this.cmC != null && (findViewWithTag = this.cmC.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.p(this.clz, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pp = pp(str);
                urlDragImageView.setAssistUrl(pp);
                c(pp);
            }
            urlDragImageView.p(this.clz, true);
        }
    }

    private ImageUrlData pp(String str) {
        if (TextUtils.isEmpty(str) || this.cmK == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cmK.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jR(int i) {
        if (this.cmC == null) {
            return null;
        }
        View findViewWithTag = this.cmC.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jS(int i) {
        View findViewWithTag;
        if (this.cmC != null && (findViewWithTag = this.cmC.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).apC();
        }
    }

    private void initUI() {
        this.cmC = new GalleryViewPager(getContext());
        this.cmC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cmC.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cmC);
        this.cmB = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cmB.setOrientation(0);
        this.cmB.setLayoutParams(layoutParams);
        addView(this.cmB);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cmA = new Button(getContext());
        al.g(this.cmA, R.drawable.image_zoomout, 0);
        this.cmA.setLayoutParams(layoutParams2);
        this.cmA.setOnClickListener(this.mOnClickListener);
        this.cmA.setEnabled(false);
        this.cmB.addView(this.cmA);
        this.cmz = new Button(getContext());
        al.g(this.cmz, R.drawable.image_zoomin, 0);
        this.cmz.setLayoutParams(layoutParams2);
        this.cmz.setOnClickListener(this.mOnClickListener);
        this.cmz.setEnabled(false);
        this.cmB.addView(this.cmz);
        if (this.cmH) {
            this.cmB.setVisibility(8);
        }
        this.cmD = new ImagePagerAdapter(getContext(), this.clo);
        this.cmD.a(this.clp);
        setAdapter(this.cmD);
        this.cmM = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cmD != null) {
            this.cmD.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cmD != null) {
            this.cmD.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cmE = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cmD == null) {
            return 0;
        }
        return this.cmD.getCount();
    }

    public int getCurrentItem() {
        if (this.cmC == null) {
            return 0;
        }
        return this.cmC.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cmC == null) {
            return null;
        }
        View findViewWithTag = this.cmC.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cmz.setEnabled(true);
            } else {
                this.cmz.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.cmA.setEnabled(true);
                return;
            } else {
                this.cmA.setEnabled(false);
                return;
            }
        }
        this.cmA.setEnabled(false);
        this.cmz.setEnabled(false);
    }

    public void apn() {
        if (!this.cmH) {
            this.cmB.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.cmL = z;
        h(!z, i);
    }

    public boolean apo() {
        return this.cmL;
    }

    public void eQ(boolean z) {
        if (this.cmM != null) {
            this.cmM.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.cmM != null) {
            this.cmM.af(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cmC != null) {
            int childCount = this.cmC.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cmC.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cmM != null) {
                this.cmM.setUserId(str);
            }
        }
    }

    public void app() {
        if (!this.cmH) {
            this.cmB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cmC == null) {
            return null;
        }
        return this.cmC.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cmC != null) {
            this.cmC.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cmC != null) {
            this.cmC.setOffscreenPageLimit(i);
            this.cmF = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cmF = (int) (this.cmF * 0.8d);
            if (this.cmF < 6291456) {
                this.cmG = true;
                this.cmF = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cmG = false;
            }
            PagerAdapter adapter = this.cmC.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cmF);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cln);
        }
        if (this.cmC != null) {
            this.cmC.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cmD);
        if (this.cmC != null) {
            this.cmC.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cmD != null) {
            this.cmD.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cmD != null) {
            this.cmD.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cmD != null) {
            this.cmD.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cmD != null) {
            this.cmD.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cmD != null) {
            this.cmD.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cmJ = arrayList;
        if (this.cmD != null) {
            this.cmD.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cmK = map;
        if (this.cmD != null) {
            this.cmD.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cmD != null) {
            this.cmD.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cmD == null) {
            return false;
        }
        return this.cmD.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cmD != null) {
            this.cmD.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cmC == null || (currentView = this.cmC.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cmD != null) {
            this.cmD.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.cmC == null || (currentView = this.cmC.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cmC == null || (currentView = this.cmC.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cmC != null && (currentView = this.cmC.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cmC != null) {
            this.cmC.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.clz = z;
        if (this.cmD != null) {
            this.cmD.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cmD != null) {
            this.cmD.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cmD != null) {
            this.cmD.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cmD != null) {
            this.cmD.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cmD != null) {
            this.cmD.setOriImgSelectedCallback(bVar);
        }
    }
}
