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
import com.baidu.tbadk.core.util.ao;
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
    private ArrayList<String> dDd;
    private DragImageView.g fuj;
    private DragImageView.e fuk;
    private ImagePagerAdapter.b ful;
    private boolean fuu;
    private boolean fvA;
    private int fvB;
    private Map<String, ImageUrlData> fvC;
    private boolean fvD;
    private boolean fvE;
    protected a fvF;
    private Button fvs;
    private Button fvt;
    private LinearLayout fvu;
    private GalleryViewPager fvv;
    private ImagePagerAdapter fvw;
    private ViewPager.OnPageChangeListener fvx;
    private int fvy;
    private boolean fvz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fvB;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fvs = null;
        this.fvt = null;
        this.fvu = null;
        this.fvv = null;
        this.fvw = null;
        this.mOnClickListener = null;
        this.fuk = null;
        this.mOnPageChangeListener = null;
        this.fvx = null;
        this.fuj = null;
        this.ful = null;
        this.fvy = 0;
        this.fvz = true;
        this.fvA = false;
        this.fuu = false;
        this.fvB = 1;
        this.dDd = null;
        this.fvC = null;
        this.fvD = false;
        this.fvE = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fvv != null) {
            this.fvv.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fvs = null;
        this.fvt = null;
        this.fvu = null;
        this.fvv = null;
        this.fvw = null;
        this.mOnClickListener = null;
        this.fuk = null;
        this.mOnPageChangeListener = null;
        this.fvx = null;
        this.fuj = null;
        this.ful = null;
        this.fvy = 0;
        this.fvz = true;
        this.fvA = false;
        this.fuu = false;
        this.fvB = 1;
        this.dDd = null;
        this.fvC = null;
        this.fvD = false;
        this.fvE = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fvs = null;
        this.fvt = null;
        this.fvu = null;
        this.fvv = null;
        this.fvw = null;
        this.mOnClickListener = null;
        this.fuk = null;
        this.mOnPageChangeListener = null;
        this.fvx = null;
        this.fuj = null;
        this.ful = null;
        this.fvy = 0;
        this.fvz = true;
        this.fvA = false;
        this.fuu = false;
        this.fvB = 1;
        this.dDd = null;
        this.fvC = null;
        this.fvD = false;
        this.fvE = true;
        init();
    }

    public void init() {
        this.fvA = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fvs) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fvt && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fvx != null) {
                    MultiImageView.this.fvx.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fvx != null) {
                    MultiImageView.this.fvx.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fvB) {
                    MultiImageView.this.fvB = i + 1;
                }
                if (MultiImageView.this.fvv != null) {
                    int childCount = MultiImageView.this.fvv.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fvv.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bzv();
                        }
                    }
                }
                if (MultiImageView.this.fvx != null) {
                    MultiImageView.this.fvx.onPageSelected(i);
                }
            }
        };
        this.fuj = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fvv != null && MultiImageView.this.fvv.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fuk = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fvv != null && dragImageView == MultiImageView.this.fvv.getCurrentView()) {
                    if (MultiImageView.this.fvz) {
                        int childCount = MultiImageView.this.fvv.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fvv.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.ful = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fvv != null) {
                        MultiImageView.this.fvv.setCurrentView(null);
                    }
                    MultiImageView.this.ky(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fvv != null) {
                        MultiImageView.this.fvv.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fuk != null) {
                        MultiImageView.this.fuk.a(imageView);
                    }
                }
                urlDragImageView.bzt();
                urlDragImageView.bzs();
                urlDragImageView.E(MultiImageView.this.fuu, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fvw != null) {
            return this.fvw.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fvv != null) {
            int childCount = this.fvv.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fvv.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fvv != null && this.fvv.getCurrentView() != null) {
            if (this.fvz) {
                int childCount = this.fvv.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fvv.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fvv.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fvv.findViewWithTag(String.valueOf(this.fvv.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fuu, true);
            }
            this.fvv.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fvv != null && this.fvv.getCurrentView() != null) {
            this.fvv.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fvv != null) {
            int childCount = this.fvv.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fvv.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fvF != null) {
            this.fvF.setAssistUrl(imageUrlData);
            if (this.fvD || imageUrlData == null) {
                ky(false);
                return;
            }
            if (!this.fvF.bzb()) {
                this.fvF.kw(false);
            }
            if (!this.fvF.isShown()) {
                s(true, 150);
            }
        }
    }

    public void qA(int i) {
        if (this.fvv != null) {
            View findViewWithTag = this.fvv.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                ky(false);
            }
        }
    }

    public void qB(int i) {
        View findViewWithTag;
        if (this.fvv != null && (findViewWithTag = this.fvv.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fuu, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData BX = BX(str);
                urlDragImageView.setAssistUrl(BX);
                c(BX);
            }
            urlDragImageView.E(this.fuu, true);
        }
    }

    private ImageUrlData BX(String str) {
        if (TextUtils.isEmpty(str) || this.fvC == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fvC.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qC(int i) {
        if (this.fvv == null) {
            return null;
        }
        View findViewWithTag = this.fvv.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qD(int i) {
        View findViewWithTag;
        if (this.fvv != null && (findViewWithTag = this.fvv.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bzx();
        }
    }

    private void initUI() {
        this.fvv = new GalleryViewPager(getContext());
        this.fvv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fvv.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fvv);
        this.fvu = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fvu.setOrientation(0);
        this.fvu.setLayoutParams(layoutParams);
        addView(this.fvu);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fvt = new Button(getContext());
        ao.setBackgroundResource(this.fvt, R.drawable.image_zoomout, 0);
        this.fvt.setLayoutParams(layoutParams2);
        this.fvt.setOnClickListener(this.mOnClickListener);
        this.fvt.setEnabled(false);
        this.fvu.addView(this.fvt);
        this.fvs = new Button(getContext());
        ao.setBackgroundResource(this.fvs, R.drawable.image_zoomin, 0);
        this.fvs.setLayoutParams(layoutParams2);
        this.fvs.setOnClickListener(this.mOnClickListener);
        this.fvs.setEnabled(false);
        this.fvu.addView(this.fvs);
        if (this.fvA) {
            this.fvu.setVisibility(8);
        }
        this.fvw = new ImagePagerAdapter(getContext(), this.fuk);
        this.fvw.a(this.ful);
        setAdapter(this.fvw);
        this.fvF = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fvw != null) {
            this.fvw.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fvx = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fvw == null) {
            return 0;
        }
        return this.fvw.getCount();
    }

    public int getCurrentItem() {
        if (this.fvv == null) {
            return 0;
        }
        return this.fvv.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fvv == null) {
            return null;
        }
        View findViewWithTag = this.fvv.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fvv == null) {
            return null;
        }
        return this.fvv.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fvs.setEnabled(true);
            } else {
                this.fvs.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fvt.setEnabled(true);
                return;
            } else {
                this.fvt.setEnabled(false);
                return;
            }
        }
        this.fvt.setEnabled(false);
        this.fvs.setEnabled(false);
    }

    public void bzj() {
        if (!this.fvA) {
            this.fvu.setVisibility(0);
        }
    }

    public boolean bzk() {
        return this.fvD;
    }

    public void ky(boolean z) {
        if (this.fvF != null) {
            this.fvF.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.fvE && this.fvF != null) {
            this.fvF.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fvv != null) {
            int childCount = this.fvv.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fvv.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fvF != null) {
                this.fvF.setUserId(str);
            }
        }
    }

    public void bzl() {
        if (!this.fvA) {
            this.fvu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fvv == null) {
            return null;
        }
        return this.fvv.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fvv != null) {
            this.fvv.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fvv != null) {
            this.fvv.setOffscreenPageLimit(i);
            this.fvy = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fvy = (int) (this.fvy * 0.8d);
            if (this.fvy < 6291456) {
                this.fvz = true;
                this.fvy = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fvz = false;
            }
            PagerAdapter adapter = this.fvv.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fvy);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fuj);
        }
        if (this.fvv != null) {
            this.fvv.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fvw);
        if (this.fvv != null) {
            this.fvv.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fvw != null) {
            this.fvw.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fvw != null) {
            this.fvw.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fvw != null) {
            this.fvw.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fvw != null) {
            this.fvw.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fvw != null) {
            this.fvw.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dDd = arrayList;
        if (this.fvw != null) {
            this.fvw.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fvC = map;
        if (this.fvw != null) {
            this.fvw.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fvw != null) {
            this.fvw.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fvw == null) {
            return false;
        }
        return this.fvw.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fvw != null) {
            this.fvw.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fvv == null || (currentView = this.fvv.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fvw != null) {
            this.fvw.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fvv == null || (currentView = this.fvv.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fvv == null || (currentView = this.fvv.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fvv != null && (currentView = this.fvv.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fvv != null) {
            this.fvv.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fuu = z;
        if (this.fvw != null) {
            this.fvw.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fvw != null) {
            this.fvw.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fvw != null) {
            this.fvw.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fvw != null) {
            this.fvw.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fvw != null) {
            this.fvw.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fvE = z;
        ky(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fvF != null) {
            this.fvF.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fvF != null) {
            this.fvF.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fvF != null) {
            this.fvF.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (!this.fvE || this.fvF == null) {
            return 0;
        }
        return this.fvF.getBottomHeight();
    }
}
