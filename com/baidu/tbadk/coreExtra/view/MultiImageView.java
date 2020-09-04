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
    private ArrayList<String> cRn;
    private DragImageView.g eGa;
    private DragImageView.e eGb;
    private ImagePagerAdapter.b eGc;
    private boolean eGl;
    private Button eHk;
    private Button eHl;
    private LinearLayout eHm;
    private GalleryViewPager eHn;
    private ImagePagerAdapter eHo;
    private ViewPager.OnPageChangeListener eHp;
    private int eHq;
    private boolean eHr;
    private boolean eHs;
    private int eHt;
    private Map<String, ImageUrlData> eHu;
    private boolean eHv;
    private boolean eHw;
    protected a eHx;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.eHt;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eHk = null;
        this.eHl = null;
        this.eHm = null;
        this.eHn = null;
        this.eHo = null;
        this.mOnClickListener = null;
        this.eGb = null;
        this.mOnPageChangeListener = null;
        this.eHp = null;
        this.eGa = null;
        this.eGc = null;
        this.eHq = 0;
        this.eHr = true;
        this.eHs = false;
        this.eGl = false;
        this.eHt = 1;
        this.cRn = null;
        this.eHu = null;
        this.eHv = false;
        this.eHw = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.eHn != null) {
            this.eHn.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eHk = null;
        this.eHl = null;
        this.eHm = null;
        this.eHn = null;
        this.eHo = null;
        this.mOnClickListener = null;
        this.eGb = null;
        this.mOnPageChangeListener = null;
        this.eHp = null;
        this.eGa = null;
        this.eGc = null;
        this.eHq = 0;
        this.eHr = true;
        this.eHs = false;
        this.eGl = false;
        this.eHt = 1;
        this.cRn = null;
        this.eHu = null;
        this.eHv = false;
        this.eHw = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eHk = null;
        this.eHl = null;
        this.eHm = null;
        this.eHn = null;
        this.eHo = null;
        this.mOnClickListener = null;
        this.eGb = null;
        this.mOnPageChangeListener = null;
        this.eHp = null;
        this.eGa = null;
        this.eGc = null;
        this.eHq = 0;
        this.eHr = true;
        this.eHs = false;
        this.eGl = false;
        this.eHt = 1;
        this.cRn = null;
        this.eHu = null;
        this.eHv = false;
        this.eHw = true;
        init();
    }

    public void init() {
        this.eHs = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.eHk) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.eHl && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.eHp != null) {
                    MultiImageView.this.eHp.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.eHp != null) {
                    MultiImageView.this.eHp.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.eHt) {
                    MultiImageView.this.eHt = i + 1;
                }
                if (MultiImageView.this.eHn != null) {
                    int childCount = MultiImageView.this.eHn.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.eHn.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bqi();
                        }
                    }
                }
                if (MultiImageView.this.eHp != null) {
                    MultiImageView.this.eHp.onPageSelected(i);
                }
            }
        };
        this.eGa = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.eHn != null && MultiImageView.this.eHn.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.eGb = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.eHn != null && dragImageView == MultiImageView.this.eHn.getCurrentView()) {
                    if (MultiImageView.this.eHr) {
                        int childCount = MultiImageView.this.eHn.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.eHn.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.eGc = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.eHn != null) {
                        MultiImageView.this.eHn.setCurrentView(null);
                    }
                    MultiImageView.this.iY(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.eHn != null) {
                        MultiImageView.this.eHn.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.eGb != null) {
                        MultiImageView.this.eGb.a(imageView);
                    }
                }
                urlDragImageView.bqg();
                urlDragImageView.bqf();
                urlDragImageView.E(MultiImageView.this.eGl, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.eHo != null) {
            return this.eHo.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.eHn != null) {
            int childCount = this.eHn.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eHn.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.eHn != null && this.eHn.getCurrentView() != null) {
            if (this.eHr) {
                int childCount = this.eHn.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.eHn.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.eHn.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.eHn.findViewWithTag(String.valueOf(this.eHn.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.eGl, true);
            }
            this.eHn.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.eHn != null && this.eHn.getCurrentView() != null) {
            this.eHn.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.eHn != null) {
            int childCount = this.eHn.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHn.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.eHx != null) {
            this.eHx.setAssistUrl(imageUrlData);
            if (this.eHv || imageUrlData == null) {
                iY(false);
                return;
            }
            if (!this.eHx.bpO()) {
                this.eHx.iW(false);
            }
            if (!this.eHx.isShown()) {
                s(true, 150);
            }
        }
    }

    public void pP(int i) {
        if (this.eHn != null) {
            View findViewWithTag = this.eHn.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                iY(false);
            }
        }
    }

    public void pQ(int i) {
        View findViewWithTag;
        if (this.eHn != null && (findViewWithTag = this.eHn.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.eGl, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Bp = Bp(str);
                urlDragImageView.setAssistUrl(Bp);
                c(Bp);
            }
            urlDragImageView.E(this.eGl, true);
        }
    }

    private ImageUrlData Bp(String str) {
        if (TextUtils.isEmpty(str) || this.eHu == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.eHu.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String pR(int i) {
        if (this.eHn == null) {
            return null;
        }
        View findViewWithTag = this.eHn.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void pS(int i) {
        View findViewWithTag;
        if (this.eHn != null && (findViewWithTag = this.eHn.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bqk();
        }
    }

    private void initUI() {
        this.eHn = new GalleryViewPager(getContext());
        this.eHn.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.eHn.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.eHn);
        this.eHm = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.eHm.setOrientation(0);
        this.eHm.setLayoutParams(layoutParams);
        addView(this.eHm);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.eHl = new Button(getContext());
        ap.setBackgroundResource(this.eHl, R.drawable.image_zoomout, 0);
        this.eHl.setLayoutParams(layoutParams2);
        this.eHl.setOnClickListener(this.mOnClickListener);
        this.eHl.setEnabled(false);
        this.eHm.addView(this.eHl);
        this.eHk = new Button(getContext());
        ap.setBackgroundResource(this.eHk, R.drawable.image_zoomin, 0);
        this.eHk.setLayoutParams(layoutParams2);
        this.eHk.setOnClickListener(this.mOnClickListener);
        this.eHk.setEnabled(false);
        this.eHm.addView(this.eHk);
        if (this.eHs) {
            this.eHm.setVisibility(8);
        }
        this.eHo = new ImagePagerAdapter(getContext(), this.eGb);
        this.eHo.a(this.eGc);
        setAdapter(this.eHo);
        this.eHx = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.eHo != null) {
            this.eHo.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eHp = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.eHo == null) {
            return 0;
        }
        return this.eHo.getCount();
    }

    public int getCurrentItem() {
        if (this.eHn == null) {
            return 0;
        }
        return this.eHn.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.eHn == null) {
            return null;
        }
        View findViewWithTag = this.eHn.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.eHn == null) {
            return null;
        }
        return this.eHn.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.eHk.setEnabled(true);
            } else {
                this.eHk.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.eHl.setEnabled(true);
                return;
            } else {
                this.eHl.setEnabled(false);
                return;
            }
        }
        this.eHl.setEnabled(false);
        this.eHk.setEnabled(false);
    }

    public void bpW() {
        if (!this.eHs) {
            this.eHm.setVisibility(0);
        }
    }

    public boolean bpX() {
        return this.eHv;
    }

    public void iY(boolean z) {
        if (this.eHx != null) {
            this.eHx.setVisibility(z ? 0 : 8);
        }
    }

    public void s(boolean z, int i) {
        if (this.eHw && this.eHx != null) {
            this.eHx.be(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.eHn != null) {
            int childCount = this.eHn.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHn.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.eHx != null) {
                this.eHx.setUserId(str);
            }
        }
    }

    public void bpY() {
        if (!this.eHs) {
            this.eHm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.eHn == null) {
            return null;
        }
        return this.eHn.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.eHn != null) {
            this.eHn.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.eHn != null) {
            this.eHn.setOffscreenPageLimit(i);
            this.eHq = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.eHq = (int) (this.eHq * 0.8d);
            if (this.eHq < 6291456) {
                this.eHr = true;
                this.eHq = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.eHr = false;
            }
            PagerAdapter adapter = this.eHn.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.eHq);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.eGa);
        }
        if (this.eHn != null) {
            this.eHn.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.eHo);
        if (this.eHn != null) {
            this.eHn.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.eHo != null) {
            this.eHo.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.eHo != null) {
            this.eHo.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.eHo != null) {
            this.eHo.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eHo != null) {
            this.eHo.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.eHo != null) {
            this.eHo.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cRn = arrayList;
        if (this.eHo != null) {
            this.eHo.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.eHu = map;
        if (this.eHo != null) {
            this.eHo.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.eHo != null) {
            this.eHo.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.eHo == null) {
            return false;
        }
        return this.eHo.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.eHo != null) {
            this.eHo.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.eHn == null || (currentView = this.eHn.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.eHo != null) {
            this.eHo.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.eHn == null || (currentView = this.eHn.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eHn == null || (currentView = this.eHn.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.eHn != null && (currentView = this.eHn.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.eHn != null) {
            this.eHn.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.eGl = z;
        if (this.eHo != null) {
            this.eHo.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.eHo != null) {
            this.eHo.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.eHo != null) {
            this.eHo.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.eHo != null) {
            this.eHo.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.eHo != null) {
            this.eHo.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.eHw = z;
        iY(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eHx != null) {
            this.eHx.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eHx != null) {
            this.eHx.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eHx != null) {
            this.eHx.setOnReplyClickListener(onClickListener);
        }
    }
}
