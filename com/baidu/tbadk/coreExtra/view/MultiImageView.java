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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g cmA;
    private DragImageView.e cmB;
    private ImagePagerAdapter.b cmC;
    private boolean cmM;
    private Button cnM;
    private Button cnN;
    private LinearLayout cnO;
    private GalleryViewPager cnP;
    private ImagePagerAdapter cnQ;
    private ViewPager.OnPageChangeListener cnR;
    private int cnS;
    private boolean cnT;
    private boolean cnU;
    private int cnV;
    private ArrayList<String> cnW;
    private Map<String, ImageUrlData> cnX;
    private boolean cnY;
    protected b cnZ;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cnV;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cnM = null;
        this.cnN = null;
        this.cnO = null;
        this.cnP = null;
        this.cnQ = null;
        this.mOnClickListener = null;
        this.cmB = null;
        this.mOnPageChangeListener = null;
        this.cnR = null;
        this.cmA = null;
        this.cmC = null;
        this.cnS = 0;
        this.cnT = true;
        this.cnU = false;
        this.cmM = false;
        this.cnV = 1;
        this.cnW = null;
        this.cnX = null;
        this.cnY = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cnP != null) {
            this.cnP.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cnM = null;
        this.cnN = null;
        this.cnO = null;
        this.cnP = null;
        this.cnQ = null;
        this.mOnClickListener = null;
        this.cmB = null;
        this.mOnPageChangeListener = null;
        this.cnR = null;
        this.cmA = null;
        this.cmC = null;
        this.cnS = 0;
        this.cnT = true;
        this.cnU = false;
        this.cmM = false;
        this.cnV = 1;
        this.cnW = null;
        this.cnX = null;
        this.cnY = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cnM = null;
        this.cnN = null;
        this.cnO = null;
        this.cnP = null;
        this.cnQ = null;
        this.mOnClickListener = null;
        this.cmB = null;
        this.mOnPageChangeListener = null;
        this.cnR = null;
        this.cmA = null;
        this.cmC = null;
        this.cnS = 0;
        this.cnT = true;
        this.cnU = false;
        this.cmM = false;
        this.cnV = 1;
        this.cnW = null;
        this.cnX = null;
        this.cnY = false;
        init();
    }

    public void init() {
        this.cnU = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cnM) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.awX();
                    }
                } else if (view == MultiImageView.this.cnN && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.awY();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cnR != null) {
                    MultiImageView.this.cnR.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cnR != null) {
                    MultiImageView.this.cnR.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cnV) {
                    MultiImageView.this.cnV = i + 1;
                }
                if (MultiImageView.this.cnP != null) {
                    int childCount = MultiImageView.this.cnP.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cnP.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aqF();
                        }
                    }
                }
                if (MultiImageView.this.cnR != null) {
                    MultiImageView.this.cnR.onPageSelected(i);
                }
            }
        };
        this.cmA = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cnP != null && MultiImageView.this.cnP.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cmB = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cnP != null && dragImageView == MultiImageView.this.cnP.getCurrentView()) {
                    if (MultiImageView.this.cnT) {
                        int childCount = MultiImageView.this.cnP.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cnP.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cmC = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cnP != null) {
                        MultiImageView.this.cnP.setCurrentView(null);
                    }
                    MultiImageView.this.eU(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.awZ();
                    if (MultiImageView.this.cnP != null) {
                        MultiImageView.this.cnP.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cmB != null) {
                        MultiImageView.this.cmB.a(imageView);
                    }
                }
                urlDragImageView.aqD();
                urlDragImageView.aqC();
                urlDragImageView.r(MultiImageView.this.cmM, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cnQ != null) {
            return this.cnQ.getCount();
        }
        return 0;
    }

    public void iG(int i) {
        if (this.mSkinType != i && this.cnP != null) {
            int childCount = this.cnP.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cnP.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cnP != null && this.cnP.getCurrentView() != null) {
            if (this.cnT) {
                int childCount = this.cnP.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cnP.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cnP.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cnP.findViewWithTag(String.valueOf(this.cnP.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).r(this.cmM, true);
            }
            this.cnP.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cnP != null && this.cnP.getCurrentView() != null) {
            this.cnP.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cnP != null) {
            int childCount = this.cnP.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cnP.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cnZ != null) {
            this.cnZ.setAssistUrl(imageUrlData);
            if (this.cnY || imageUrlData == null) {
                eU(false);
                return;
            }
            if (!this.cnZ.aql()) {
                this.cnZ.q(false, false);
            }
            if (!this.cnZ.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jV(int i) {
        if (this.cnP != null) {
            View findViewWithTag = this.cnP.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eU(false);
            }
        }
    }

    public void jW(int i) {
        View findViewWithTag;
        if (this.cnP != null && (findViewWithTag = this.cnP.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.r(this.cmM, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pG = pG(str);
                urlDragImageView.setAssistUrl(pG);
                c(pG);
            }
            urlDragImageView.r(this.cmM, true);
        }
    }

    private ImageUrlData pG(String str) {
        if (TextUtils.isEmpty(str) || this.cnX == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.cnX.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jX(int i) {
        if (this.cnP == null) {
            return null;
        }
        View findViewWithTag = this.cnP.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jY(int i) {
        View findViewWithTag;
        if (this.cnP != null && (findViewWithTag = this.cnP.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aqH();
        }
    }

    private void initUI() {
        this.cnP = new GalleryViewPager(getContext());
        this.cnP.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cnP.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cnP);
        this.cnO = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cnO.setOrientation(0);
        this.cnO.setLayoutParams(layoutParams);
        addView(this.cnO);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cnN = new Button(getContext());
        am.g(this.cnN, R.drawable.image_zoomout, 0);
        this.cnN.setLayoutParams(layoutParams2);
        this.cnN.setOnClickListener(this.mOnClickListener);
        this.cnN.setEnabled(false);
        this.cnO.addView(this.cnN);
        this.cnM = new Button(getContext());
        am.g(this.cnM, R.drawable.image_zoomin, 0);
        this.cnM.setLayoutParams(layoutParams2);
        this.cnM.setOnClickListener(this.mOnClickListener);
        this.cnM.setEnabled(false);
        this.cnO.addView(this.cnM);
        if (this.cnU) {
            this.cnO.setVisibility(8);
        }
        this.cnQ = new ImagePagerAdapter(getContext(), this.cmB);
        this.cnQ.a(this.cmC);
        setAdapter(this.cnQ);
        this.cnZ = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cnQ != null) {
            this.cnQ.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cnQ != null) {
            this.cnQ.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cnR = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cnQ == null) {
            return 0;
        }
        return this.cnQ.getCount();
    }

    public int getCurrentItem() {
        if (this.cnP == null) {
            return 0;
        }
        return this.cnP.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cnP == null) {
            return null;
        }
        View findViewWithTag = this.cnP.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.axa()) {
                this.cnM.setEnabled(true);
            } else {
                this.cnM.setEnabled(false);
            }
            if (dragImageView.axb()) {
                this.cnN.setEnabled(true);
                return;
            } else {
                this.cnN.setEnabled(false);
                return;
            }
        }
        this.cnN.setEnabled(false);
        this.cnM.setEnabled(false);
    }

    public void aqs() {
        if (!this.cnU) {
            this.cnO.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.cnY = z;
        h(!z, i);
    }

    public boolean aqt() {
        return this.cnY;
    }

    public void eU(boolean z) {
        if (this.cnZ != null) {
            this.cnZ.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.cnZ != null) {
            this.cnZ.ai(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cnP != null) {
            int childCount = this.cnP.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cnP.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cnZ != null) {
                this.cnZ.setUserId(str);
            }
        }
    }

    public void aqu() {
        if (!this.cnU) {
            this.cnO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cnP == null) {
            return null;
        }
        return this.cnP.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cnP != null) {
            this.cnP.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cnP != null) {
            this.cnP.setOffscreenPageLimit(i);
            this.cnS = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cnS = (int) (this.cnS * 0.8d);
            if (this.cnS < 6291456) {
                this.cnT = true;
                this.cnS = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cnT = false;
            }
            PagerAdapter adapter = this.cnP.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cnS);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cmA);
        }
        if (this.cnP != null) {
            this.cnP.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cnQ);
        if (this.cnP != null) {
            this.cnP.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cnQ != null) {
            this.cnQ.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cnQ != null) {
            this.cnQ.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cnQ != null) {
            this.cnQ.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cnQ != null) {
            this.cnQ.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cnQ != null) {
            this.cnQ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cnW = arrayList;
        if (this.cnQ != null) {
            this.cnQ.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.cnX = map;
        if (this.cnQ != null) {
            this.cnQ.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cnQ != null) {
            this.cnQ.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cnQ == null) {
            return false;
        }
        return this.cnQ.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cnQ != null) {
            this.cnQ.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cnP == null || (currentView = this.cnP.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cnQ != null) {
            this.cnQ.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.cnP == null || (currentView = this.cnP.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cnP == null || (currentView = this.cnP.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cnP != null && (currentView = this.cnP.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cnP != null) {
            this.cnP.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cmM = z;
        if (this.cnQ != null) {
            this.cnQ.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cnQ != null) {
            this.cnQ.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cnQ != null) {
            this.cnQ.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cnQ != null) {
            this.cnQ.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cnQ != null) {
            this.cnQ.setOriImgSelectedCallback(bVar);
        }
    }
}
