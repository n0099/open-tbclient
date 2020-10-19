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
/* loaded from: classes21.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> dfv;
    private DragImageView.g eUo;
    private DragImageView.e eUp;
    private ImagePagerAdapter.b eUq;
    private boolean eUz;
    private LinearLayout eVA;
    private GalleryViewPager eVB;
    private ImagePagerAdapter eVC;
    private ViewPager.OnPageChangeListener eVD;
    private int eVE;
    private boolean eVF;
    private boolean eVG;
    private int eVH;
    private Map<String, ImageUrlData> eVI;
    private boolean eVJ;
    private boolean eVK;
    protected a eVL;
    private Button eVy;
    private Button eVz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.eVH;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eVy = null;
        this.eVz = null;
        this.eVA = null;
        this.eVB = null;
        this.eVC = null;
        this.mOnClickListener = null;
        this.eUp = null;
        this.mOnPageChangeListener = null;
        this.eVD = null;
        this.eUo = null;
        this.eUq = null;
        this.eVE = 0;
        this.eVF = true;
        this.eVG = false;
        this.eUz = false;
        this.eVH = 1;
        this.dfv = null;
        this.eVI = null;
        this.eVJ = false;
        this.eVK = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.eVB != null) {
            this.eVB.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eVy = null;
        this.eVz = null;
        this.eVA = null;
        this.eVB = null;
        this.eVC = null;
        this.mOnClickListener = null;
        this.eUp = null;
        this.mOnPageChangeListener = null;
        this.eVD = null;
        this.eUo = null;
        this.eUq = null;
        this.eVE = 0;
        this.eVF = true;
        this.eVG = false;
        this.eUz = false;
        this.eVH = 1;
        this.dfv = null;
        this.eVI = null;
        this.eVJ = false;
        this.eVK = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eVy = null;
        this.eVz = null;
        this.eVA = null;
        this.eVB = null;
        this.eVC = null;
        this.mOnClickListener = null;
        this.eUp = null;
        this.mOnPageChangeListener = null;
        this.eVD = null;
        this.eUo = null;
        this.eUq = null;
        this.eVE = 0;
        this.eVF = true;
        this.eVG = false;
        this.eUz = false;
        this.eVH = 1;
        this.dfv = null;
        this.eVI = null;
        this.eVJ = false;
        this.eVK = true;
        init();
    }

    public void init() {
        this.eVG = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.eVy) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.eVz && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.eVD != null) {
                    MultiImageView.this.eVD.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.eVD != null) {
                    MultiImageView.this.eVD.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.eVH) {
                    MultiImageView.this.eVH = i + 1;
                }
                if (MultiImageView.this.eVB != null) {
                    int childCount = MultiImageView.this.eVB.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.eVB.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).btM();
                        }
                    }
                }
                if (MultiImageView.this.eVD != null) {
                    MultiImageView.this.eVD.onPageSelected(i);
                }
            }
        };
        this.eUo = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.eVB != null && MultiImageView.this.eVB.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.eUp = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.eVB != null && dragImageView == MultiImageView.this.eVB.getCurrentView()) {
                    if (MultiImageView.this.eVF) {
                        int childCount = MultiImageView.this.eVB.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.eVB.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.eUq = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void h(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.eVB != null) {
                        MultiImageView.this.eVB.setCurrentView(null);
                    }
                    MultiImageView.this.jt(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.eVB != null) {
                        MultiImageView.this.eVB.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.eUp != null) {
                        MultiImageView.this.eUp.a(imageView);
                    }
                }
                urlDragImageView.btK();
                urlDragImageView.btJ();
                urlDragImageView.E(MultiImageView.this.eUz, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.eVC != null) {
            return this.eVC.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.eVB != null) {
            int childCount = this.eVB.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eVB.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.eVB != null && this.eVB.getCurrentView() != null) {
            if (this.eVF) {
                int childCount = this.eVB.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.eVB.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.eVB.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.eVB.findViewWithTag(String.valueOf(this.eVB.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.eUz, true);
            }
            this.eVB.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.eVB != null && this.eVB.getCurrentView() != null) {
            this.eVB.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.eVB != null) {
            int childCount = this.eVB.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eVB.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.eVL != null) {
            this.eVL.setAssistUrl(imageUrlData);
            if (this.eVJ || imageUrlData == null) {
                jt(false);
                return;
            }
            if (!this.eVL.bts()) {
                this.eVL.jr(false);
            }
            if (!this.eVL.isShown()) {
                t(true, 150);
            }
        }
    }

    public void qA(int i) {
        if (this.eVB != null) {
            View findViewWithTag = this.eVB.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                jt(false);
            }
        }
    }

    public void qB(int i) {
        View findViewWithTag;
        if (this.eVB != null && (findViewWithTag = this.eVB.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.eUz, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Cx = Cx(str);
                urlDragImageView.setAssistUrl(Cx);
                c(Cx);
            }
            urlDragImageView.E(this.eUz, true);
        }
    }

    private ImageUrlData Cx(String str) {
        if (TextUtils.isEmpty(str) || this.eVI == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eVI.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String qC(int i) {
        if (this.eVB == null) {
            return null;
        }
        View findViewWithTag = this.eVB.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void qD(int i) {
        View findViewWithTag;
        if (this.eVB != null && (findViewWithTag = this.eVB.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).btO();
        }
    }

    private void initUI() {
        this.eVB = new GalleryViewPager(getContext());
        this.eVB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eVB.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.eVB);
        this.eVA = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.eVA.setOrientation(0);
        this.eVA.setLayoutParams(layoutParams);
        addView(this.eVA);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.eVz = new Button(getContext());
        ap.setBackgroundResource(this.eVz, R.drawable.image_zoomout, 0);
        this.eVz.setLayoutParams(layoutParams2);
        this.eVz.setOnClickListener(this.mOnClickListener);
        this.eVz.setEnabled(false);
        this.eVA.addView(this.eVz);
        this.eVy = new Button(getContext());
        ap.setBackgroundResource(this.eVy, R.drawable.image_zoomin, 0);
        this.eVy.setLayoutParams(layoutParams2);
        this.eVy.setOnClickListener(this.mOnClickListener);
        this.eVy.setEnabled(false);
        this.eVA.addView(this.eVy);
        if (this.eVG) {
            this.eVA.setVisibility(8);
        }
        this.eVC = new ImagePagerAdapter(getContext(), this.eUp);
        this.eVC.a(this.eUq);
        setAdapter(this.eVC);
        this.eVL = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.eVC != null) {
            this.eVC.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eVD = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.eVC == null) {
            return 0;
        }
        return this.eVC.getCount();
    }

    public int getCurrentItem() {
        if (this.eVB == null) {
            return 0;
        }
        return this.eVB.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.eVB == null) {
            return null;
        }
        View findViewWithTag = this.eVB.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.eVB == null) {
            return null;
        }
        return this.eVB.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.eVy.setEnabled(true);
            } else {
                this.eVy.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.eVz.setEnabled(true);
                return;
            } else {
                this.eVz.setEnabled(false);
                return;
            }
        }
        this.eVz.setEnabled(false);
        this.eVy.setEnabled(false);
    }

    public void btA() {
        if (!this.eVG) {
            this.eVA.setVisibility(0);
        }
    }

    public boolean btB() {
        return this.eVJ;
    }

    public void jt(boolean z) {
        if (this.eVL != null) {
            this.eVL.setVisibility(z ? 0 : 8);
        }
    }

    public void t(boolean z, int i) {
        if (this.eVK && this.eVL != null) {
            this.eVL.bd(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.eVB != null) {
            int childCount = this.eVB.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eVB.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.eVL != null) {
                this.eVL.setUserId(str);
            }
        }
    }

    public void btC() {
        if (!this.eVG) {
            this.eVA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.eVB == null) {
            return null;
        }
        return this.eVB.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.eVB != null) {
            this.eVB.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.eVB != null) {
            this.eVB.setOffscreenPageLimit(i);
            this.eVE = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.eVE = (int) (this.eVE * 0.8d);
            if (this.eVE < 6291456) {
                this.eVF = true;
                this.eVE = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.eVF = false;
            }
            PagerAdapter adapter = this.eVB.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.eVE);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.eUo);
        }
        if (this.eVB != null) {
            this.eVB.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.eVC);
        if (this.eVB != null) {
            this.eVB.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.eVC != null) {
            this.eVC.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.eVC != null) {
            this.eVC.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.eVC != null) {
            this.eVC.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eVC != null) {
            this.eVC.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.eVC != null) {
            this.eVC.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dfv = arrayList;
        if (this.eVC != null) {
            this.eVC.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eVI = map;
        if (this.eVC != null) {
            this.eVC.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.eVC != null) {
            this.eVC.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.eVC == null) {
            return false;
        }
        return this.eVC.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.eVC != null) {
            this.eVC.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.eVB == null || (currentView = this.eVB.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.eVC != null) {
            this.eVC.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.eVB == null || (currentView = this.eVB.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eVB == null || (currentView = this.eVB.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eVB != null && (currentView = this.eVB.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eVB != null) {
            this.eVB.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.eUz = z;
        if (this.eVC != null) {
            this.eVC.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.eVC != null) {
            this.eVC.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.eVC != null) {
            this.eVC.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.eVC != null) {
            this.eVC.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.eVC != null) {
            this.eVC.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.eVK = z;
        jt(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eVL != null) {
            this.eVL.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eVL != null) {
            this.eVL.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eVL != null) {
            this.eVL.setOnReplyClickListener(onClickListener);
        }
    }
}
