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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
public class MultiImageView extends RelativeLayout {
    private ArrayList<String> cFs;
    private DragImageView.g epi;
    private DragImageView.e epj;
    private ImagePagerAdapter.b epk;
    private boolean ept;
    private boolean eqA;
    protected a eqB;
    private Button eqo;
    private Button eqp;
    private LinearLayout eqq;
    private GalleryViewPager eqr;
    private ImagePagerAdapter eqs;
    private ViewPager.OnPageChangeListener eqt;
    private int equ;
    private boolean eqv;
    private boolean eqw;
    private int eqx;
    private Map<String, ImageUrlData> eqy;
    private boolean eqz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.eqx;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eqo = null;
        this.eqp = null;
        this.eqq = null;
        this.eqr = null;
        this.eqs = null;
        this.mOnClickListener = null;
        this.epj = null;
        this.mOnPageChangeListener = null;
        this.eqt = null;
        this.epi = null;
        this.epk = null;
        this.equ = 0;
        this.eqv = true;
        this.eqw = false;
        this.ept = false;
        this.eqx = 1;
        this.cFs = null;
        this.eqy = null;
        this.eqz = false;
        this.eqA = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.eqr != null) {
            this.eqr.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eqo = null;
        this.eqp = null;
        this.eqq = null;
        this.eqr = null;
        this.eqs = null;
        this.mOnClickListener = null;
        this.epj = null;
        this.mOnPageChangeListener = null;
        this.eqt = null;
        this.epi = null;
        this.epk = null;
        this.equ = 0;
        this.eqv = true;
        this.eqw = false;
        this.ept = false;
        this.eqx = 1;
        this.cFs = null;
        this.eqy = null;
        this.eqz = false;
        this.eqA = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eqo = null;
        this.eqp = null;
        this.eqq = null;
        this.eqr = null;
        this.eqs = null;
        this.mOnClickListener = null;
        this.epj = null;
        this.mOnPageChangeListener = null;
        this.eqt = null;
        this.epi = null;
        this.epk = null;
        this.equ = 0;
        this.eqv = true;
        this.eqw = false;
        this.ept = false;
        this.eqx = 1;
        this.cFs = null;
        this.eqy = null;
        this.eqz = false;
        this.eqA = true;
        init();
    }

    public void init() {
        this.eqw = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.eqo) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.eqp && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.eqt != null) {
                    MultiImageView.this.eqt.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.eqt != null) {
                    MultiImageView.this.eqt.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.eqx) {
                    MultiImageView.this.eqx = i + 1;
                }
                if (MultiImageView.this.eqr != null) {
                    int childCount = MultiImageView.this.eqr.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.eqr.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bdM();
                        }
                    }
                }
                if (MultiImageView.this.eqt != null) {
                    MultiImageView.this.eqt.onPageSelected(i);
                }
            }
        };
        this.epi = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.eqr != null && MultiImageView.this.eqr.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.epj = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.eqr != null && dragImageView == MultiImageView.this.eqr.getCurrentView()) {
                    if (MultiImageView.this.eqv) {
                        int childCount = MultiImageView.this.eqr.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.eqr.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.epk = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.eqr != null) {
                        MultiImageView.this.eqr.setCurrentView(null);
                    }
                    MultiImageView.this.hU(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.eqr != null) {
                        MultiImageView.this.eqr.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.epj != null) {
                        MultiImageView.this.epj.a(imageView);
                    }
                }
                urlDragImageView.bdK();
                urlDragImageView.bdJ();
                urlDragImageView.A(MultiImageView.this.ept, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.eqs != null) {
            return this.eqs.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.eqr != null) {
            int childCount = this.eqr.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eqr.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.eqr != null && this.eqr.getCurrentView() != null) {
            if (this.eqv) {
                int childCount = this.eqr.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.eqr.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.eqr.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.eqr.findViewWithTag(String.valueOf(this.eqr.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).A(this.ept, true);
            }
            this.eqr.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.eqr != null && this.eqr.getCurrentView() != null) {
            this.eqr.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.eqr != null) {
            int childCount = this.eqr.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eqr.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.eqB != null) {
            this.eqB.setAssistUrl(imageUrlData);
            if (this.eqz || imageUrlData == null) {
                hU(false);
                return;
            }
            if (!this.eqB.bdu()) {
                this.eqB.hS(false);
            }
            if (!this.eqB.isShown()) {
                s(true, 150);
            }
        }
    }

    public void nm(int i) {
        if (this.eqr != null) {
            View findViewWithTag = this.eqr.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                hU(false);
            }
        }
    }

    public void nn(int i) {
        View findViewWithTag;
        if (this.eqr != null && (findViewWithTag = this.eqr.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.A(this.ept, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData xS = xS(str);
                urlDragImageView.setAssistUrl(xS);
                c(xS);
            }
            urlDragImageView.A(this.ept, true);
        }
    }

    private ImageUrlData xS(String str) {
        if (TextUtils.isEmpty(str) || this.eqy == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eqy.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String no(int i) {
        if (this.eqr == null) {
            return null;
        }
        View findViewWithTag = this.eqr.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void np(int i) {
        View findViewWithTag;
        if (this.eqr != null && (findViewWithTag = this.eqr.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bdO();
        }
    }

    private void initUI() {
        this.eqr = new GalleryViewPager(getContext());
        this.eqr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eqr.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.eqr);
        this.eqq = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.eqq.setOrientation(0);
        this.eqq.setLayoutParams(layoutParams);
        addView(this.eqq);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.eqp = new Button(getContext());
        an.setBackgroundResource(this.eqp, R.drawable.image_zoomout, 0);
        this.eqp.setLayoutParams(layoutParams2);
        this.eqp.setOnClickListener(this.mOnClickListener);
        this.eqp.setEnabled(false);
        this.eqq.addView(this.eqp);
        this.eqo = new Button(getContext());
        an.setBackgroundResource(this.eqo, R.drawable.image_zoomin, 0);
        this.eqo.setLayoutParams(layoutParams2);
        this.eqo.setOnClickListener(this.mOnClickListener);
        this.eqo.setEnabled(false);
        this.eqq.addView(this.eqo);
        if (this.eqw) {
            this.eqq.setVisibility(8);
        }
        this.eqs = new ImagePagerAdapter(getContext(), this.epj);
        this.eqs.a(this.epk);
        setAdapter(this.eqs);
        this.eqB = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.eqs != null) {
            this.eqs.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.eqB != null) {
            this.eqB.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eqt = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.eqs == null) {
            return 0;
        }
        return this.eqs.getCount();
    }

    public int getCurrentItem() {
        if (this.eqr == null) {
            return 0;
        }
        return this.eqr.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.eqr == null) {
            return null;
        }
        View findViewWithTag = this.eqr.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.eqr == null) {
            return null;
        }
        return this.eqr.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.eqo.setEnabled(true);
            } else {
                this.eqo.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.eqp.setEnabled(true);
                return;
            } else {
                this.eqp.setEnabled(false);
                return;
            }
        }
        this.eqp.setEnabled(false);
        this.eqo.setEnabled(false);
    }

    public void bdA() {
        if (!this.eqw) {
            this.eqq.setVisibility(0);
        }
    }

    public boolean bdB() {
        return this.eqz;
    }

    public void hU(boolean z) {
        if (this.eqB != null) {
            this.eqB.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.eqA && this.eqB != null) {
            this.eqB.aU(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.eqr != null) {
            int childCount = this.eqr.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eqr.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.eqB != null) {
                this.eqB.setUserId(str);
            }
        }
    }

    public void bdC() {
        if (!this.eqw) {
            this.eqq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.eqr == null) {
            return null;
        }
        return this.eqr.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.eqr != null) {
            this.eqr.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.eqr != null) {
            this.eqr.setOffscreenPageLimit(i);
            this.equ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.equ = (int) (this.equ * 0.8d);
            if (this.equ < 6291456) {
                this.eqv = true;
                this.equ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.eqv = false;
            }
            PagerAdapter adapter = this.eqr.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.equ);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.epi);
        }
        if (this.eqr != null) {
            this.eqr.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.eqs);
        if (this.eqr != null) {
            this.eqr.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.eqs != null) {
            this.eqs.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.eqs != null) {
            this.eqs.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.eqs != null) {
            this.eqs.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eqs != null) {
            this.eqs.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.eqs != null) {
            this.eqs.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cFs = arrayList;
        if (this.eqs != null) {
            this.eqs.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eqy = map;
        if (this.eqs != null) {
            this.eqs.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.eqs != null) {
            this.eqs.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.eqs == null) {
            return false;
        }
        return this.eqs.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.eqs != null) {
            this.eqs.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.eqr == null || (currentView = this.eqr.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.eqs != null) {
            this.eqs.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.eqr == null || (currentView = this.eqr.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eqr == null || (currentView = this.eqr.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eqr != null && (currentView = this.eqr.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eqr != null) {
            this.eqr.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.ept = z;
        if (this.eqs != null) {
            this.eqs.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.eqs != null) {
            this.eqs.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.eqs != null) {
            this.eqs.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.eqs != null) {
            this.eqs.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.eqs != null) {
            this.eqs.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.eqA = z;
        hU(z);
    }
}
