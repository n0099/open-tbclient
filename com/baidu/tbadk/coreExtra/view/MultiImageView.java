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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes15.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> cRj;
    private DragImageView.g eFW;
    private DragImageView.e eFX;
    private ImagePagerAdapter.b eFY;
    private boolean eGh;
    private Button eHg;
    private Button eHh;
    private LinearLayout eHi;
    private GalleryViewPager eHj;
    private ImagePagerAdapter eHk;
    private ViewPager.OnPageChangeListener eHl;
    private int eHm;
    private boolean eHn;
    private boolean eHo;
    private int eHp;
    private Map<String, ImageUrlData> eHq;
    private boolean eHr;
    private boolean eHs;
    protected a eHt;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.eHp;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eHg = null;
        this.eHh = null;
        this.eHi = null;
        this.eHj = null;
        this.eHk = null;
        this.mOnClickListener = null;
        this.eFX = null;
        this.mOnPageChangeListener = null;
        this.eHl = null;
        this.eFW = null;
        this.eFY = null;
        this.eHm = 0;
        this.eHn = true;
        this.eHo = false;
        this.eGh = false;
        this.eHp = 1;
        this.cRj = null;
        this.eHq = null;
        this.eHr = false;
        this.eHs = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.eHj != null) {
            this.eHj.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eHg = null;
        this.eHh = null;
        this.eHi = null;
        this.eHj = null;
        this.eHk = null;
        this.mOnClickListener = null;
        this.eFX = null;
        this.mOnPageChangeListener = null;
        this.eHl = null;
        this.eFW = null;
        this.eFY = null;
        this.eHm = 0;
        this.eHn = true;
        this.eHo = false;
        this.eGh = false;
        this.eHp = 1;
        this.cRj = null;
        this.eHq = null;
        this.eHr = false;
        this.eHs = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eHg = null;
        this.eHh = null;
        this.eHi = null;
        this.eHj = null;
        this.eHk = null;
        this.mOnClickListener = null;
        this.eFX = null;
        this.mOnPageChangeListener = null;
        this.eHl = null;
        this.eFW = null;
        this.eFY = null;
        this.eHm = 0;
        this.eHn = true;
        this.eHo = false;
        this.eGh = false;
        this.eHp = 1;
        this.cRj = null;
        this.eHq = null;
        this.eHr = false;
        this.eHs = true;
        init();
    }

    public void init() {
        this.eHo = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.eHg) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.eHh && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.eHl != null) {
                    MultiImageView.this.eHl.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.eHl != null) {
                    MultiImageView.this.eHl.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.eHp) {
                    MultiImageView.this.eHp = i + 1;
                }
                if (MultiImageView.this.eHj != null) {
                    int childCount = MultiImageView.this.eHj.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.eHj.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bqh();
                        }
                    }
                }
                if (MultiImageView.this.eHl != null) {
                    MultiImageView.this.eHl.onPageSelected(i);
                }
            }
        };
        this.eFW = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.eHj != null && MultiImageView.this.eHj.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.eFX = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.eHj != null && dragImageView == MultiImageView.this.eHj.getCurrentView()) {
                    if (MultiImageView.this.eHn) {
                        int childCount = MultiImageView.this.eHj.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.eHj.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.eFY = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.eHj != null) {
                        MultiImageView.this.eHj.setCurrentView(null);
                    }
                    MultiImageView.this.iW(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.eHj != null) {
                        MultiImageView.this.eHj.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.eFX != null) {
                        MultiImageView.this.eFX.a(imageView);
                    }
                }
                urlDragImageView.bqf();
                urlDragImageView.bqe();
                urlDragImageView.E(MultiImageView.this.eGh, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.eHk != null) {
            return this.eHk.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.eHj != null) {
            int childCount = this.eHj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eHj.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.eHj != null && this.eHj.getCurrentView() != null) {
            if (this.eHn) {
                int childCount = this.eHj.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.eHj.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.eHj.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.eHj.findViewWithTag(String.valueOf(this.eHj.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.eGh, true);
            }
            this.eHj.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.eHj != null && this.eHj.getCurrentView() != null) {
            this.eHj.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.eHj != null) {
            int childCount = this.eHj.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHj.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.eHt != null) {
            this.eHt.setAssistUrl(imageUrlData);
            if (this.eHr || imageUrlData == null) {
                iW(false);
                return;
            }
            if (!this.eHt.bpN()) {
                this.eHt.iU(false);
            }
            if (!this.eHt.isShown()) {
                s(true, 150);
            }
        }
    }

    public void pP(int i) {
        if (this.eHj != null) {
            View findViewWithTag = this.eHj.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                iW(false);
            }
        }
    }

    public void pQ(int i) {
        View findViewWithTag;
        if (this.eHj != null && (findViewWithTag = this.eHj.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.eGh, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Bo = Bo(str);
                urlDragImageView.setAssistUrl(Bo);
                c(Bo);
            }
            urlDragImageView.E(this.eGh, true);
        }
    }

    private ImageUrlData Bo(String str) {
        if (TextUtils.isEmpty(str) || this.eHq == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eHq.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String pR(int i) {
        if (this.eHj == null) {
            return null;
        }
        View findViewWithTag = this.eHj.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void pS(int i) {
        View findViewWithTag;
        if (this.eHj != null && (findViewWithTag = this.eHj.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bqj();
        }
    }

    private void initUI() {
        this.eHj = new GalleryViewPager(getContext());
        this.eHj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eHj.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.eHj);
        this.eHi = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.eHi.setOrientation(0);
        this.eHi.setLayoutParams(layoutParams);
        addView(this.eHi);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.eHh = new Button(getContext());
        ap.setBackgroundResource(this.eHh, R.drawable.image_zoomout, 0);
        this.eHh.setLayoutParams(layoutParams2);
        this.eHh.setOnClickListener(this.mOnClickListener);
        this.eHh.setEnabled(false);
        this.eHi.addView(this.eHh);
        this.eHg = new Button(getContext());
        ap.setBackgroundResource(this.eHg, R.drawable.image_zoomin, 0);
        this.eHg.setLayoutParams(layoutParams2);
        this.eHg.setOnClickListener(this.mOnClickListener);
        this.eHg.setEnabled(false);
        this.eHi.addView(this.eHg);
        if (this.eHo) {
            this.eHi.setVisibility(8);
        }
        this.eHk = new ImagePagerAdapter(getContext(), this.eFX);
        this.eHk.a(this.eFY);
        setAdapter(this.eHk);
        this.eHt = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.eHk != null) {
            this.eHk.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eHl = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.eHk == null) {
            return 0;
        }
        return this.eHk.getCount();
    }

    public int getCurrentItem() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.eHj == null) {
            return null;
        }
        View findViewWithTag = this.eHj.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.eHg.setEnabled(true);
            } else {
                this.eHg.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.eHh.setEnabled(true);
                return;
            } else {
                this.eHh.setEnabled(false);
                return;
            }
        }
        this.eHh.setEnabled(false);
        this.eHg.setEnabled(false);
    }

    public void bpV() {
        if (!this.eHo) {
            this.eHi.setVisibility(0);
        }
    }

    public boolean bpW() {
        return this.eHr;
    }

    public void iW(boolean z) {
        if (this.eHt != null) {
            this.eHt.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.eHs && this.eHt != null) {
            this.eHt.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.eHj != null) {
            int childCount = this.eHj.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHj.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.eHt != null) {
                this.eHt.setUserId(str);
            }
        }
    }

    public void bpX() {
        if (!this.eHo) {
            this.eHi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.eHj != null) {
            this.eHj.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.eHj != null) {
            this.eHj.setOffscreenPageLimit(i);
            this.eHm = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.eHm = (int) (this.eHm * 0.8d);
            if (this.eHm < 6291456) {
                this.eHn = true;
                this.eHm = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.eHn = false;
            }
            PagerAdapter adapter = this.eHj.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.eHm);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.eFW);
        }
        if (this.eHj != null) {
            this.eHj.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.eHk);
        if (this.eHj != null) {
            this.eHj.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.eHk != null) {
            this.eHk.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.eHk != null) {
            this.eHk.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.eHk != null) {
            this.eHk.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eHk != null) {
            this.eHk.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.eHk != null) {
            this.eHk.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cRj = arrayList;
        if (this.eHk != null) {
            this.eHk.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eHq = map;
        if (this.eHk != null) {
            this.eHk.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.eHk != null) {
            this.eHk.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.eHk == null) {
            return false;
        }
        return this.eHk.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.eHk != null) {
            this.eHk.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.eHj == null || (currentView = this.eHj.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.eHk != null) {
            this.eHk.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.eHj == null || (currentView = this.eHj.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eHj == null || (currentView = this.eHj.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eHj != null && (currentView = this.eHj.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eHj != null) {
            this.eHj.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.eGh = z;
        if (this.eHk != null) {
            this.eHk.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.eHk != null) {
            this.eHk.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.eHk != null) {
            this.eHk.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.eHk != null) {
            this.eHk.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.eHk != null) {
            this.eHk.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.eHs = z;
        iW(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eHt != null) {
            this.eHt.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eHt != null) {
            this.eHt.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eHt != null) {
            this.eHt.setOnReplyClickListener(onClickListener);
        }
    }
}
