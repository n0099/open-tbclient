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
    private DragImageView.g dSh;
    private DragImageView.e dSi;
    private ImagePagerAdapter.b dSj;
    private boolean dSs;
    private Map<String, ImageUrlData> dTA;
    private boolean dTB;
    private boolean dTC;
    protected b dTD;
    private Button dTp;
    private Button dTq;
    private LinearLayout dTr;
    private GalleryViewPager dTs;
    private ImagePagerAdapter dTt;
    private ViewPager.OnPageChangeListener dTu;
    private int dTv;
    private boolean dTw;
    private boolean dTx;
    private int dTy;
    private ArrayList<String> dTz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dTy;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dTp = null;
        this.dTq = null;
        this.dTr = null;
        this.dTs = null;
        this.dTt = null;
        this.mOnClickListener = null;
        this.dSi = null;
        this.mOnPageChangeListener = null;
        this.dTu = null;
        this.dSh = null;
        this.dSj = null;
        this.dTv = 0;
        this.dTw = true;
        this.dTx = false;
        this.dSs = false;
        this.dTy = 1;
        this.dTz = null;
        this.dTA = null;
        this.dTB = false;
        this.dTC = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dTs != null) {
            this.dTs.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dTp = null;
        this.dTq = null;
        this.dTr = null;
        this.dTs = null;
        this.dTt = null;
        this.mOnClickListener = null;
        this.dSi = null;
        this.mOnPageChangeListener = null;
        this.dTu = null;
        this.dSh = null;
        this.dSj = null;
        this.dTv = 0;
        this.dTw = true;
        this.dTx = false;
        this.dSs = false;
        this.dTy = 1;
        this.dTz = null;
        this.dTA = null;
        this.dTB = false;
        this.dTC = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dTp = null;
        this.dTq = null;
        this.dTr = null;
        this.dTs = null;
        this.dTt = null;
        this.mOnClickListener = null;
        this.dSi = null;
        this.mOnPageChangeListener = null;
        this.dTu = null;
        this.dSh = null;
        this.dSj = null;
        this.dTv = 0;
        this.dTw = true;
        this.dTx = false;
        this.dSs = false;
        this.dTy = 1;
        this.dTz = null;
        this.dTA = null;
        this.dTB = false;
        this.dTC = true;
        init();
    }

    public void init() {
        this.dTx = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dTp) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dTq && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dTu != null) {
                    MultiImageView.this.dTu.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dTu != null) {
                    MultiImageView.this.dTu.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dTy) {
                    MultiImageView.this.dTy = i + 1;
                }
                if (MultiImageView.this.dTs != null) {
                    int childCount = MultiImageView.this.dTs.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dTs.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aVC();
                        }
                    }
                }
                if (MultiImageView.this.dTu != null) {
                    MultiImageView.this.dTu.onPageSelected(i);
                }
            }
        };
        this.dSh = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dTs != null && MultiImageView.this.dTs.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.dSi = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dTs != null && dragImageView == MultiImageView.this.dTs.getCurrentView()) {
                    if (MultiImageView.this.dTw) {
                        int childCount = MultiImageView.this.dTs.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dTs.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dSj = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dTs != null) {
                        MultiImageView.this.dTs.setCurrentView(null);
                    }
                    MultiImageView.this.hp(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dTs != null) {
                        MultiImageView.this.dTs.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.dSi != null) {
                        MultiImageView.this.dSi.a(imageView);
                    }
                }
                urlDragImageView.aVA();
                urlDragImageView.aVz();
                urlDragImageView.x(MultiImageView.this.dSs, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dTt != null) {
            return this.dTt.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dTs != null) {
            int childCount = this.dTs.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dTs.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dTs != null && this.dTs.getCurrentView() != null) {
            if (this.dTw) {
                int childCount = this.dTs.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dTs.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dTs.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dTs.findViewWithTag(String.valueOf(this.dTs.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).x(this.dSs, true);
            }
            this.dTs.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dTs != null && this.dTs.getCurrentView() != null) {
            this.dTs.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dTs != null) {
            int childCount = this.dTs.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dTs.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dTD != null) {
            this.dTD.setAssistUrl(imageUrlData);
            if (this.dTB || imageUrlData == null) {
                hp(false);
                return;
            }
            if (!this.dTD.aVj()) {
                this.dTD.w(false, false);
            }
            if (!this.dTD.isShown()) {
                p(true, 150);
            }
        }
    }

    public void mo(int i) {
        if (this.dTs != null) {
            View findViewWithTag = this.dTs.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                hp(false);
            }
        }
    }

    public void mp(int i) {
        View findViewWithTag;
        if (this.dTs != null && (findViewWithTag = this.dTs.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.x(this.dSs, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData vQ = vQ(str);
                urlDragImageView.setAssistUrl(vQ);
                c(vQ);
            }
            urlDragImageView.x(this.dSs, true);
        }
    }

    private ImageUrlData vQ(String str) {
        if (TextUtils.isEmpty(str) || this.dTA == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dTA.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mq(int i) {
        if (this.dTs == null) {
            return null;
        }
        View findViewWithTag = this.dTs.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void mr(int i) {
        View findViewWithTag;
        if (this.dTs != null && (findViewWithTag = this.dTs.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aVE();
        }
    }

    private void initUI() {
        this.dTs = new GalleryViewPager(getContext());
        this.dTs.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dTs.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dTs);
        this.dTr = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dTr.setOrientation(0);
        this.dTr.setLayoutParams(layoutParams);
        addView(this.dTr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dTq = new Button(getContext());
        am.setBackgroundResource(this.dTq, R.drawable.image_zoomout, 0);
        this.dTq.setLayoutParams(layoutParams2);
        this.dTq.setOnClickListener(this.mOnClickListener);
        this.dTq.setEnabled(false);
        this.dTr.addView(this.dTq);
        this.dTp = new Button(getContext());
        am.setBackgroundResource(this.dTp, R.drawable.image_zoomin, 0);
        this.dTp.setLayoutParams(layoutParams2);
        this.dTp.setOnClickListener(this.mOnClickListener);
        this.dTp.setEnabled(false);
        this.dTr.addView(this.dTp);
        if (this.dTx) {
            this.dTr.setVisibility(8);
        }
        this.dTt = new ImagePagerAdapter(getContext(), this.dSi);
        this.dTt.a(this.dSj);
        setAdapter(this.dTt);
        this.dTD = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dTt != null) {
            this.dTt.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dTD != null) {
            this.dTD.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dTu = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dTt == null) {
            return 0;
        }
        return this.dTt.getCount();
    }

    public int getCurrentItem() {
        if (this.dTs == null) {
            return 0;
        }
        return this.dTs.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dTs == null) {
            return null;
        }
        View findViewWithTag = this.dTs.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dTs == null) {
            return null;
        }
        return this.dTs.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dTp.setEnabled(true);
            } else {
                this.dTp.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dTq.setEnabled(true);
                return;
            } else {
                this.dTq.setEnabled(false);
                return;
            }
        }
        this.dTq.setEnabled(false);
        this.dTp.setEnabled(false);
    }

    public void aVq() {
        if (!this.dTx) {
            this.dTr.setVisibility(0);
        }
    }

    public void o(boolean z, int i) {
        this.dTB = z;
        p(!z, i);
    }

    public boolean aVr() {
        return this.dTB;
    }

    public void hp(boolean z) {
        if (this.dTD != null) {
            this.dTD.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z, int i) {
        if (this.dTC && this.dTD != null) {
            this.dTD.aM(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dTs != null) {
            int childCount = this.dTs.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dTs.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dTD != null) {
                this.dTD.setUserId(str);
            }
        }
    }

    public void aVs() {
        if (!this.dTx) {
            this.dTr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dTs == null) {
            return null;
        }
        return this.dTs.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dTs != null) {
            this.dTs.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dTs != null) {
            this.dTs.setOffscreenPageLimit(i);
            this.dTv = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dTv = (int) (this.dTv * 0.8d);
            if (this.dTv < 6291456) {
                this.dTw = true;
                this.dTv = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dTw = false;
            }
            PagerAdapter adapter = this.dTs.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dTv);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.dSh);
        }
        if (this.dTs != null) {
            this.dTs.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dTt);
        if (this.dTs != null) {
            this.dTs.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dTt != null) {
            this.dTt.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dTt != null) {
            this.dTt.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dTt != null) {
            this.dTt.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dTt != null) {
            this.dTt.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dTt != null) {
            this.dTt.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dTz = arrayList;
        if (this.dTt != null) {
            this.dTt.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dTA = map;
        if (this.dTt != null) {
            this.dTt.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dTt != null) {
            this.dTt.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dTt == null) {
            return false;
        }
        return this.dTt.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dTt != null) {
            this.dTt.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dTs == null || (currentView = this.dTs.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dTt != null) {
            this.dTt.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dTs == null || (currentView = this.dTs.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dTs == null || (currentView = this.dTs.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dTs != null && (currentView = this.dTs.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dTs != null) {
            this.dTs.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dSs = z;
        if (this.dTt != null) {
            this.dTt.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dTt != null) {
            this.dTt.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dTt != null) {
            this.dTt.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dTt != null) {
            this.dTt.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dTt != null) {
            this.dTt.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dTC = z;
        hp(z);
    }
}
