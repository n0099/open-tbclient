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
    private ArrayList<String> dHP;
    private Button fAa;
    private Button fAb;
    private LinearLayout fAc;
    private GalleryViewPager fAd;
    private ImagePagerAdapter fAe;
    private ViewPager.OnPageChangeListener fAf;
    private int fAg;
    private boolean fAh;
    private boolean fAi;
    private int fAj;
    private Map<String, ImageUrlData> fAk;
    private boolean fAl;
    private boolean fAm;
    protected a fAn;
    private DragImageView.g fyR;
    private DragImageView.e fyS;
    private ImagePagerAdapter.b fyT;
    private boolean fzc;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fAj;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fAa = null;
        this.fAb = null;
        this.fAc = null;
        this.fAd = null;
        this.fAe = null;
        this.mOnClickListener = null;
        this.fyS = null;
        this.mOnPageChangeListener = null;
        this.fAf = null;
        this.fyR = null;
        this.fyT = null;
        this.fAg = 0;
        this.fAh = true;
        this.fAi = false;
        this.fzc = false;
        this.fAj = 1;
        this.dHP = null;
        this.fAk = null;
        this.fAl = false;
        this.fAm = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fAd != null) {
            this.fAd.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fAa = null;
        this.fAb = null;
        this.fAc = null;
        this.fAd = null;
        this.fAe = null;
        this.mOnClickListener = null;
        this.fyS = null;
        this.mOnPageChangeListener = null;
        this.fAf = null;
        this.fyR = null;
        this.fyT = null;
        this.fAg = 0;
        this.fAh = true;
        this.fAi = false;
        this.fzc = false;
        this.fAj = 1;
        this.dHP = null;
        this.fAk = null;
        this.fAl = false;
        this.fAm = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fAa = null;
        this.fAb = null;
        this.fAc = null;
        this.fAd = null;
        this.fAe = null;
        this.mOnClickListener = null;
        this.fyS = null;
        this.mOnPageChangeListener = null;
        this.fAf = null;
        this.fyR = null;
        this.fyT = null;
        this.fAg = 0;
        this.fAh = true;
        this.fAi = false;
        this.fzc = false;
        this.fAj = 1;
        this.dHP = null;
        this.fAk = null;
        this.fAl = false;
        this.fAm = true;
        init();
    }

    public void init() {
        this.fAi = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fAa) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fAb && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fAf != null) {
                    MultiImageView.this.fAf.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fAf != null) {
                    MultiImageView.this.fAf.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fAj) {
                    MultiImageView.this.fAj = i + 1;
                }
                if (MultiImageView.this.fAd != null) {
                    int childCount = MultiImageView.this.fAd.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fAd.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bDo();
                        }
                    }
                }
                if (MultiImageView.this.fAf != null) {
                    MultiImageView.this.fAf.onPageSelected(i);
                }
            }
        };
        this.fyR = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fAd != null && MultiImageView.this.fAd.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fyS = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fAd != null && dragImageView == MultiImageView.this.fAd.getCurrentView()) {
                    if (MultiImageView.this.fAh) {
                        int childCount = MultiImageView.this.fAd.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fAd.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fyT = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fAd != null) {
                        MultiImageView.this.fAd.setCurrentView(null);
                    }
                    MultiImageView.this.kC(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fAd != null) {
                        MultiImageView.this.fAd.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fyS != null) {
                        MultiImageView.this.fyS.a(imageView);
                    }
                }
                urlDragImageView.bDm();
                urlDragImageView.bDl();
                urlDragImageView.E(MultiImageView.this.fzc, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fAe != null) {
            return this.fAe.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fAd != null) {
            int childCount = this.fAd.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fAd.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fAd != null && this.fAd.getCurrentView() != null) {
            if (this.fAh) {
                int childCount = this.fAd.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fAd.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fAd.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fAd.findViewWithTag(String.valueOf(this.fAd.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fzc, true);
            }
            this.fAd.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fAd != null && this.fAd.getCurrentView() != null) {
            this.fAd.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fAd != null) {
            int childCount = this.fAd.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fAd.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fAn != null) {
            this.fAn.setAssistUrl(imageUrlData);
            if (this.fAl || imageUrlData == null) {
                kC(false);
                return;
            }
            if (!this.fAn.bCU()) {
                this.fAn.kA(false);
            }
            if (!this.fAn.isShown()) {
                s(true, 150);
            }
        }
    }

    public void sg(int i) {
        if (this.fAd != null) {
            View findViewWithTag = this.fAd.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                kC(false);
            }
        }
    }

    public void sh(int i) {
        View findViewWithTag;
        if (this.fAd != null && (findViewWithTag = this.fAd.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fzc, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Dj = Dj(str);
                urlDragImageView.setAssistUrl(Dj);
                c(Dj);
            }
            urlDragImageView.E(this.fzc, true);
        }
    }

    private ImageUrlData Dj(String str) {
        if (TextUtils.isEmpty(str) || this.fAk == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fAk.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String si(int i) {
        if (this.fAd == null) {
            return null;
        }
        View findViewWithTag = this.fAd.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void sj(int i) {
        View findViewWithTag;
        if (this.fAd != null && (findViewWithTag = this.fAd.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bDq();
        }
    }

    private void initUI() {
        this.fAd = new GalleryViewPager(getContext());
        this.fAd.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fAd.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fAd);
        this.fAc = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fAc.setOrientation(0);
        this.fAc.setLayoutParams(layoutParams);
        addView(this.fAc);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fAb = new Button(getContext());
        ao.setBackgroundResource(this.fAb, R.drawable.image_zoomout, 0);
        this.fAb.setLayoutParams(layoutParams2);
        this.fAb.setOnClickListener(this.mOnClickListener);
        this.fAb.setEnabled(false);
        this.fAc.addView(this.fAb);
        this.fAa = new Button(getContext());
        ao.setBackgroundResource(this.fAa, R.drawable.image_zoomin, 0);
        this.fAa.setLayoutParams(layoutParams2);
        this.fAa.setOnClickListener(this.mOnClickListener);
        this.fAa.setEnabled(false);
        this.fAc.addView(this.fAa);
        if (this.fAi) {
            this.fAc.setVisibility(8);
        }
        this.fAe = new ImagePagerAdapter(getContext(), this.fyS);
        this.fAe.a(this.fyT);
        setAdapter(this.fAe);
        this.fAn = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fAe != null) {
            this.fAe.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fAf = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fAe == null) {
            return 0;
        }
        return this.fAe.getCount();
    }

    public int getCurrentItem() {
        if (this.fAd == null) {
            return 0;
        }
        return this.fAd.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fAd == null) {
            return null;
        }
        View findViewWithTag = this.fAd.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fAd == null) {
            return null;
        }
        return this.fAd.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fAa.setEnabled(true);
            } else {
                this.fAa.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fAb.setEnabled(true);
                return;
            } else {
                this.fAb.setEnabled(false);
                return;
            }
        }
        this.fAb.setEnabled(false);
        this.fAa.setEnabled(false);
    }

    public void bDc() {
        if (!this.fAi) {
            this.fAc.setVisibility(0);
        }
    }

    public boolean bDd() {
        return this.fAl;
    }

    public void kC(boolean z) {
        if (this.fAn != null) {
            this.fAn.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.fAm && this.fAn != null) {
            this.fAn.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fAd != null) {
            int childCount = this.fAd.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fAd.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fAn != null) {
                this.fAn.setUserId(str);
            }
        }
    }

    public void bDe() {
        if (!this.fAi) {
            this.fAc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fAd == null) {
            return null;
        }
        return this.fAd.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fAd != null) {
            this.fAd.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fAd != null) {
            this.fAd.setOffscreenPageLimit(i);
            this.fAg = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fAg = (int) (this.fAg * 0.8d);
            if (this.fAg < 6291456) {
                this.fAh = true;
                this.fAg = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fAh = false;
            }
            PagerAdapter adapter = this.fAd.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fAg);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fyR);
        }
        if (this.fAd != null) {
            this.fAd.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fAe);
        if (this.fAd != null) {
            this.fAd.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fAe != null) {
            this.fAe.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fAe != null) {
            this.fAe.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fAe != null) {
            this.fAe.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fAe != null) {
            this.fAe.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fAe != null) {
            this.fAe.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dHP = arrayList;
        if (this.fAe != null) {
            this.fAe.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fAk = map;
        if (this.fAe != null) {
            this.fAe.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fAe != null) {
            this.fAe.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fAe == null) {
            return false;
        }
        return this.fAe.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fAe != null) {
            this.fAe.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fAd == null || (currentView = this.fAd.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fAe != null) {
            this.fAe.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fAd == null || (currentView = this.fAd.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fAd == null || (currentView = this.fAd.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fAd != null && (currentView = this.fAd.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fAd != null) {
            this.fAd.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fzc = z;
        if (this.fAe != null) {
            this.fAe.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fAe != null) {
            this.fAe.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fAe != null) {
            this.fAe.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fAe != null) {
            this.fAe.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fAe != null) {
            this.fAe.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fAm = z;
        kC(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fAn != null) {
            this.fAn.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fAn != null) {
            this.fAn.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fAn != null) {
            this.fAn.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (!this.fAm || this.fAn == null) {
            return 0;
        }
        return this.fAn.getBottomHeight();
    }
}
