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
    private DragImageView.g dsl;
    private DragImageView.e dsm;
    private ImagePagerAdapter.b dsn;
    private boolean dsx;
    private int dtA;
    private boolean dtB;
    private boolean dtC;
    private int dtD;
    private ArrayList<String> dtE;
    private Map<String, ImageUrlData> dtF;
    private boolean dtG;
    private boolean dtH;
    protected b dtI;
    private Button dtu;
    private Button dtv;
    private LinearLayout dtw;
    private GalleryViewPager dtx;
    private ImagePagerAdapter dty;
    private ViewPager.OnPageChangeListener dtz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dtD;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dtu = null;
        this.dtv = null;
        this.dtw = null;
        this.dtx = null;
        this.dty = null;
        this.mOnClickListener = null;
        this.dsm = null;
        this.mOnPageChangeListener = null;
        this.dtz = null;
        this.dsl = null;
        this.dsn = null;
        this.dtA = 0;
        this.dtB = true;
        this.dtC = false;
        this.dsx = false;
        this.dtD = 1;
        this.dtE = null;
        this.dtF = null;
        this.dtG = false;
        this.dtH = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dtx != null) {
            this.dtx.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dtu = null;
        this.dtv = null;
        this.dtw = null;
        this.dtx = null;
        this.dty = null;
        this.mOnClickListener = null;
        this.dsm = null;
        this.mOnPageChangeListener = null;
        this.dtz = null;
        this.dsl = null;
        this.dsn = null;
        this.dtA = 0;
        this.dtB = true;
        this.dtC = false;
        this.dsx = false;
        this.dtD = 1;
        this.dtE = null;
        this.dtF = null;
        this.dtG = false;
        this.dtH = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dtu = null;
        this.dtv = null;
        this.dtw = null;
        this.dtx = null;
        this.dty = null;
        this.mOnClickListener = null;
        this.dsm = null;
        this.mOnPageChangeListener = null;
        this.dtz = null;
        this.dsl = null;
        this.dsn = null;
        this.dtA = 0;
        this.dtB = true;
        this.dtC = false;
        this.dsx = false;
        this.dtD = 1;
        this.dtE = null;
        this.dtF = null;
        this.dtG = false;
        this.dtH = true;
        init();
    }

    public void init() {
        this.dtC = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dtu) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dtv && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dtz != null) {
                    MultiImageView.this.dtz.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dtz != null) {
                    MultiImageView.this.dtz.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dtD) {
                    MultiImageView.this.dtD = i + 1;
                }
                if (MultiImageView.this.dtx != null) {
                    int childCount = MultiImageView.this.dtx.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dtx.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aNf();
                        }
                    }
                }
                if (MultiImageView.this.dtz != null) {
                    MultiImageView.this.dtz.onPageSelected(i);
                }
            }
        };
        this.dsl = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dtx != null && MultiImageView.this.dtx.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.dsm = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dtx != null && dragImageView == MultiImageView.this.dtx.getCurrentView()) {
                    if (MultiImageView.this.dtB) {
                        int childCount = MultiImageView.this.dtx.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dtx.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dsn = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dtx != null) {
                        MultiImageView.this.dtx.setCurrentView(null);
                    }
                    MultiImageView.this.gr(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dtx != null) {
                        MultiImageView.this.dtx.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.dsm != null) {
                        MultiImageView.this.dsm.a(imageView);
                    }
                }
                urlDragImageView.aNd();
                urlDragImageView.aNc();
                urlDragImageView.y(MultiImageView.this.dsx, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dty != null) {
            return this.dty.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dtx != null) {
            int childCount = this.dtx.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dtx.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dtx != null && this.dtx.getCurrentView() != null) {
            if (this.dtB) {
                int childCount = this.dtx.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dtx.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dtx.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dtx.findViewWithTag(String.valueOf(this.dtx.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).y(this.dsx, true);
            }
            this.dtx.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dtx != null && this.dtx.getCurrentView() != null) {
            this.dtx.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dtx != null) {
            int childCount = this.dtx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dtx.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dtI != null) {
            this.dtI.setAssistUrl(imageUrlData);
            if (this.dtG || imageUrlData == null) {
                gr(false);
                return;
            }
            if (!this.dtI.aMM()) {
                this.dtI.x(false, false);
            }
            if (!this.dtI.isShown()) {
                o(true, 150);
            }
        }
    }

    public void mc(int i) {
        if (this.dtx != null) {
            View findViewWithTag = this.dtx.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                gr(false);
            }
        }
    }

    public void md(int i) {
        View findViewWithTag;
        if (this.dtx != null && (findViewWithTag = this.dtx.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.y(this.dsx, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uC = uC(str);
                urlDragImageView.setAssistUrl(uC);
                c(uC);
            }
            urlDragImageView.y(this.dsx, true);
        }
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.dtF == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dtF.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String me(int i) {
        if (this.dtx == null) {
            return null;
        }
        View findViewWithTag = this.dtx.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void mf(int i) {
        View findViewWithTag;
        if (this.dtx != null && (findViewWithTag = this.dtx.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aNh();
        }
    }

    private void initUI() {
        this.dtx = new GalleryViewPager(getContext());
        this.dtx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dtx.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dtx);
        this.dtw = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dtw.setOrientation(0);
        this.dtw.setLayoutParams(layoutParams);
        addView(this.dtw);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dtv = new Button(getContext());
        am.setBackgroundResource(this.dtv, R.drawable.image_zoomout, 0);
        this.dtv.setLayoutParams(layoutParams2);
        this.dtv.setOnClickListener(this.mOnClickListener);
        this.dtv.setEnabled(false);
        this.dtw.addView(this.dtv);
        this.dtu = new Button(getContext());
        am.setBackgroundResource(this.dtu, R.drawable.image_zoomin, 0);
        this.dtu.setLayoutParams(layoutParams2);
        this.dtu.setOnClickListener(this.mOnClickListener);
        this.dtu.setEnabled(false);
        this.dtw.addView(this.dtu);
        if (this.dtC) {
            this.dtw.setVisibility(8);
        }
        this.dty = new ImagePagerAdapter(getContext(), this.dsm);
        this.dty.a(this.dsn);
        setAdapter(this.dty);
        this.dtI = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dty != null) {
            this.dty.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dtI != null) {
            this.dtI.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dtz = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dty == null) {
            return 0;
        }
        return this.dty.getCount();
    }

    public int getCurrentItem() {
        if (this.dtx == null) {
            return 0;
        }
        return this.dtx.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dtx == null) {
            return null;
        }
        View findViewWithTag = this.dtx.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dtx == null) {
            return null;
        }
        return this.dtx.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dtu.setEnabled(true);
            } else {
                this.dtu.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dtv.setEnabled(true);
                return;
            } else {
                this.dtv.setEnabled(false);
                return;
            }
        }
        this.dtv.setEnabled(false);
        this.dtu.setEnabled(false);
    }

    public void aMT() {
        if (!this.dtC) {
            this.dtw.setVisibility(0);
        }
    }

    public void n(boolean z, int i) {
        this.dtG = z;
        o(!z, i);
    }

    public boolean aMU() {
        return this.dtG;
    }

    public void gr(boolean z) {
        if (this.dtI != null) {
            this.dtI.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z, int i) {
        if (this.dtH && this.dtI != null) {
            this.dtI.aI(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dtx != null) {
            int childCount = this.dtx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dtx.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dtI != null) {
                this.dtI.setUserId(str);
            }
        }
    }

    public void aMV() {
        if (!this.dtC) {
            this.dtw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dtx == null) {
            return null;
        }
        return this.dtx.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dtx != null) {
            this.dtx.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dtx != null) {
            this.dtx.setOffscreenPageLimit(i);
            this.dtA = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dtA = (int) (this.dtA * 0.8d);
            if (this.dtA < 6291456) {
                this.dtB = true;
                this.dtA = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dtB = false;
            }
            PagerAdapter adapter = this.dtx.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dtA);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.dsl);
        }
        if (this.dtx != null) {
            this.dtx.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dty);
        if (this.dtx != null) {
            this.dtx.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dty != null) {
            this.dty.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dty != null) {
            this.dty.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dty != null) {
            this.dty.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dty != null) {
            this.dty.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dty != null) {
            this.dty.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dtE = arrayList;
        if (this.dty != null) {
            this.dty.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dtF = map;
        if (this.dty != null) {
            this.dty.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dty != null) {
            this.dty.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dty == null) {
            return false;
        }
        return this.dty.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dty != null) {
            this.dty.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dtx == null || (currentView = this.dtx.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dty != null) {
            this.dty.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dtx == null || (currentView = this.dtx.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dtx == null || (currentView = this.dtx.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dtx != null && (currentView = this.dtx.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dtx != null) {
            this.dtx.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dsx = z;
        if (this.dty != null) {
            this.dty.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dty != null) {
            this.dty.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dty != null) {
            this.dty.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dty != null) {
            this.dty.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dty != null) {
            this.dty.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dtH = z;
        gr(z);
    }
}
