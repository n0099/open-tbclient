package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> dGI;
    private DragImageView.g fxY;
    private DragImageView.e fxZ;
    private ImagePagerAdapter.b fya;
    private boolean fyj;
    private Button fzh;
    private Button fzi;
    private LinearLayout fzj;
    private GalleryViewPager fzk;
    private ImagePagerAdapter fzl;
    private ViewPager.OnPageChangeListener fzm;
    private int fzn;
    private boolean fzo;
    private boolean fzp;
    private int fzq;
    private Map<String, ImageUrlData> fzr;
    private boolean fzs;
    private boolean fzt;
    protected a fzu;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fzq;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fzh = null;
        this.fzi = null;
        this.fzj = null;
        this.fzk = null;
        this.fzl = null;
        this.mOnClickListener = null;
        this.fxZ = null;
        this.mOnPageChangeListener = null;
        this.fzm = null;
        this.fxY = null;
        this.fya = null;
        this.fzn = 0;
        this.fzo = true;
        this.fzp = false;
        this.fyj = false;
        this.fzq = 1;
        this.dGI = null;
        this.fzr = null;
        this.fzs = false;
        this.fzt = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fzk != null) {
            this.fzk.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fzh = null;
        this.fzi = null;
        this.fzj = null;
        this.fzk = null;
        this.fzl = null;
        this.mOnClickListener = null;
        this.fxZ = null;
        this.mOnPageChangeListener = null;
        this.fzm = null;
        this.fxY = null;
        this.fya = null;
        this.fzn = 0;
        this.fzo = true;
        this.fzp = false;
        this.fyj = false;
        this.fzq = 1;
        this.dGI = null;
        this.fzr = null;
        this.fzs = false;
        this.fzt = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fzh = null;
        this.fzi = null;
        this.fzj = null;
        this.fzk = null;
        this.fzl = null;
        this.mOnClickListener = null;
        this.fxZ = null;
        this.mOnPageChangeListener = null;
        this.fzm = null;
        this.fxY = null;
        this.fya = null;
        this.fzn = 0;
        this.fzo = true;
        this.fzp = false;
        this.fyj = false;
        this.fzq = 1;
        this.dGI = null;
        this.fzr = null;
        this.fzs = false;
        this.fzt = true;
        init();
    }

    public void init() {
        this.fzp = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fzh) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fzi && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fzm != null) {
                    MultiImageView.this.fzm.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fzm != null) {
                    MultiImageView.this.fzm.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fzq) {
                    MultiImageView.this.fzq = i + 1;
                }
                if (MultiImageView.this.fzk != null) {
                    int childCount = MultiImageView.this.fzk.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fzk.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bzQ();
                        }
                    }
                }
                if (MultiImageView.this.fzm != null) {
                    MultiImageView.this.fzm.onPageSelected(i);
                }
            }
        };
        this.fxY = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fzk != null && MultiImageView.this.fzk.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fxZ = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fzk != null && dragImageView == MultiImageView.this.fzk.getCurrentView()) {
                    if (MultiImageView.this.fzo) {
                        int childCount = MultiImageView.this.fzk.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fzk.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fya = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fzk != null) {
                        MultiImageView.this.fzk.setCurrentView(null);
                    }
                    MultiImageView.this.kB(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fzk != null) {
                        MultiImageView.this.fzk.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fxZ != null) {
                        MultiImageView.this.fxZ.a(imageView);
                    }
                }
                urlDragImageView.bzO();
                urlDragImageView.bzN();
                urlDragImageView.D(MultiImageView.this.fyj, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fzl != null) {
            return this.fzl.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fzk != null) {
            int childCount = this.fzk.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fzk.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fzk != null && this.fzk.getCurrentView() != null) {
            if (this.fzo) {
                int childCount = this.fzk.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fzk.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fzk.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fzk.findViewWithTag(String.valueOf(this.fzk.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).D(this.fyj, true);
            }
            this.fzk.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fzk != null && this.fzk.getCurrentView() != null) {
            this.fzk.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fzk != null) {
            int childCount = this.fzk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fzk.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fzu != null) {
            this.fzu.setAssistUrl(imageUrlData);
            if (this.fzs || imageUrlData == null) {
                kB(false);
                return;
            }
            if (!this.fzu.bzw()) {
                this.fzu.kz(false);
            }
            if (!this.fzu.isShown()) {
                s(true, 150);
            }
        }
    }

    public void qG(int i) {
        if (this.fzk != null) {
            View findViewWithTag = this.fzk.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                kB(false);
            }
        }
    }

    public void qH(int i) {
        View findViewWithTag;
        if (this.fzk != null && (findViewWithTag = this.fzk.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.D(this.fyj, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Cv = Cv(str);
                urlDragImageView.setAssistUrl(Cv);
                c(Cv);
            }
            urlDragImageView.D(this.fyj, true);
        }
    }

    private ImageUrlData Cv(String str) {
        if (TextUtils.isEmpty(str) || this.fzr == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fzr.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qI(int i) {
        if (this.fzk == null) {
            return null;
        }
        View findViewWithTag = this.fzk.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qJ(int i) {
        View findViewWithTag;
        if (this.fzk != null && (findViewWithTag = this.fzk.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bzS();
        }
    }

    private void initUI() {
        this.fzk = new GalleryViewPager(getContext());
        this.fzk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fzk.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fzk);
        this.fzj = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fzj.setOrientation(0);
        this.fzj.setLayoutParams(layoutParams);
        addView(this.fzj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fzi = new Button(getContext());
        ap.setBackgroundResource(this.fzi, R.drawable.image_zoomout, 0);
        this.fzi.setLayoutParams(layoutParams2);
        this.fzi.setOnClickListener(this.mOnClickListener);
        this.fzi.setEnabled(false);
        this.fzj.addView(this.fzi);
        this.fzh = new Button(getContext());
        ap.setBackgroundResource(this.fzh, R.drawable.image_zoomin, 0);
        this.fzh.setLayoutParams(layoutParams2);
        this.fzh.setOnClickListener(this.mOnClickListener);
        this.fzh.setEnabled(false);
        this.fzj.addView(this.fzh);
        if (this.fzp) {
            this.fzj.setVisibility(8);
        }
        this.fzl = new ImagePagerAdapter(getContext(), this.fxZ);
        this.fzl.a(this.fya);
        setAdapter(this.fzl);
        this.fzu = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fzl != null) {
            this.fzl.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fzm = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fzl == null) {
            return 0;
        }
        return this.fzl.getCount();
    }

    public int getCurrentItem() {
        if (this.fzk == null) {
            return 0;
        }
        return this.fzk.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fzk == null) {
            return null;
        }
        View findViewWithTag = this.fzk.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fzk == null) {
            return null;
        }
        return this.fzk.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fzh.setEnabled(true);
            } else {
                this.fzh.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fzi.setEnabled(true);
                return;
            } else {
                this.fzi.setEnabled(false);
                return;
            }
        }
        this.fzi.setEnabled(false);
        this.fzh.setEnabled(false);
    }

    public void bzE() {
        if (!this.fzp) {
            this.fzj.setVisibility(0);
        }
    }

    public boolean bzF() {
        return this.fzs;
    }

    public void kB(boolean z) {
        if (this.fzu != null) {
            this.fzu.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.fzt && this.fzu != null) {
            this.fzu.bb(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fzk != null) {
            int childCount = this.fzk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fzk.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fzu != null) {
                this.fzu.setUserId(str);
            }
        }
    }

    public void bzG() {
        if (!this.fzp) {
            this.fzj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fzk == null) {
            return null;
        }
        return this.fzk.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fzk != null) {
            this.fzk.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fzk != null) {
            this.fzk.setOffscreenPageLimit(i);
            this.fzn = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fzn = (int) (this.fzn * 0.8d);
            if (this.fzn < 6291456) {
                this.fzo = true;
                this.fzn = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fzo = false;
            }
            PagerAdapter adapter = this.fzk.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fzn);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fxY);
        }
        if (this.fzk != null) {
            this.fzk.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fzl);
        if (this.fzk != null) {
            this.fzk.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fzl != null) {
            this.fzl.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fzl != null) {
            this.fzl.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fzl != null) {
            this.fzl.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fzl != null) {
            this.fzl.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fzl != null) {
            this.fzl.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dGI = arrayList;
        if (this.fzl != null) {
            this.fzl.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fzr = map;
        if (this.fzl != null) {
            this.fzl.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fzl != null) {
            this.fzl.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fzl == null) {
            return false;
        }
        return this.fzl.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fzl != null) {
            this.fzl.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fzk == null || (currentView = this.fzk.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fzl != null) {
            this.fzl.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fzk == null || (currentView = this.fzk.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fzk == null || (currentView = this.fzk.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fzk != null && (currentView = this.fzk.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fzk != null) {
            this.fzk.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fyj = z;
        if (this.fzl != null) {
            this.fzl.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fzl != null) {
            this.fzl.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fzl != null) {
            this.fzl.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fzl != null) {
            this.fzl.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fzl != null) {
            this.fzl.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fzt = z;
        kB(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fzu != null) {
            this.fzu.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fzu != null) {
            this.fzu.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fzu != null) {
            this.fzu.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (!this.fzt || this.fzu == null) {
            return 0;
        }
        return this.fzu.getBottomHeight();
    }
}
