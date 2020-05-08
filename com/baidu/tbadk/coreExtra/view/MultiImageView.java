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
    private DragImageView.g dSm;
    private DragImageView.e dSn;
    private ImagePagerAdapter.b dSo;
    private boolean dSx;
    private int dTA;
    private boolean dTB;
    private boolean dTC;
    private int dTD;
    private ArrayList<String> dTE;
    private Map<String, ImageUrlData> dTF;
    private boolean dTG;
    private boolean dTH;
    protected b dTI;
    private Button dTu;
    private Button dTv;
    private LinearLayout dTw;
    private GalleryViewPager dTx;
    private ImagePagerAdapter dTy;
    private ViewPager.OnPageChangeListener dTz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dTD;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dTu = null;
        this.dTv = null;
        this.dTw = null;
        this.dTx = null;
        this.dTy = null;
        this.mOnClickListener = null;
        this.dSn = null;
        this.mOnPageChangeListener = null;
        this.dTz = null;
        this.dSm = null;
        this.dSo = null;
        this.dTA = 0;
        this.dTB = true;
        this.dTC = false;
        this.dSx = false;
        this.dTD = 1;
        this.dTE = null;
        this.dTF = null;
        this.dTG = false;
        this.dTH = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dTx != null) {
            this.dTx.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dTu = null;
        this.dTv = null;
        this.dTw = null;
        this.dTx = null;
        this.dTy = null;
        this.mOnClickListener = null;
        this.dSn = null;
        this.mOnPageChangeListener = null;
        this.dTz = null;
        this.dSm = null;
        this.dSo = null;
        this.dTA = 0;
        this.dTB = true;
        this.dTC = false;
        this.dSx = false;
        this.dTD = 1;
        this.dTE = null;
        this.dTF = null;
        this.dTG = false;
        this.dTH = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dTu = null;
        this.dTv = null;
        this.dTw = null;
        this.dTx = null;
        this.dTy = null;
        this.mOnClickListener = null;
        this.dSn = null;
        this.mOnPageChangeListener = null;
        this.dTz = null;
        this.dSm = null;
        this.dSo = null;
        this.dTA = 0;
        this.dTB = true;
        this.dTC = false;
        this.dSx = false;
        this.dTD = 1;
        this.dTE = null;
        this.dTF = null;
        this.dTG = false;
        this.dTH = true;
        init();
    }

    public void init() {
        this.dTC = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dTu) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dTv && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dTz != null) {
                    MultiImageView.this.dTz.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dTz != null) {
                    MultiImageView.this.dTz.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dTD) {
                    MultiImageView.this.dTD = i + 1;
                }
                if (MultiImageView.this.dTx != null) {
                    int childCount = MultiImageView.this.dTx.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dTx.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aVA();
                        }
                    }
                }
                if (MultiImageView.this.dTz != null) {
                    MultiImageView.this.dTz.onPageSelected(i);
                }
            }
        };
        this.dSm = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dTx != null && MultiImageView.this.dTx.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.dSn = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dTx != null && dragImageView == MultiImageView.this.dTx.getCurrentView()) {
                    if (MultiImageView.this.dTB) {
                        int childCount = MultiImageView.this.dTx.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dTx.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dSo = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dTx != null) {
                        MultiImageView.this.dTx.setCurrentView(null);
                    }
                    MultiImageView.this.hp(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dTx != null) {
                        MultiImageView.this.dTx.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.dSn != null) {
                        MultiImageView.this.dSn.a(imageView);
                    }
                }
                urlDragImageView.aVy();
                urlDragImageView.aVx();
                urlDragImageView.x(MultiImageView.this.dSx, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dTy != null) {
            return this.dTy.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dTx != null) {
            int childCount = this.dTx.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dTx.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dTx != null && this.dTx.getCurrentView() != null) {
            if (this.dTB) {
                int childCount = this.dTx.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dTx.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dTx.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dTx.findViewWithTag(String.valueOf(this.dTx.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).x(this.dSx, true);
            }
            this.dTx.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dTx != null && this.dTx.getCurrentView() != null) {
            this.dTx.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dTx != null) {
            int childCount = this.dTx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dTx.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dTI != null) {
            this.dTI.setAssistUrl(imageUrlData);
            if (this.dTG || imageUrlData == null) {
                hp(false);
                return;
            }
            if (!this.dTI.aVh()) {
                this.dTI.w(false, false);
            }
            if (!this.dTI.isShown()) {
                p(true, 150);
            }
        }
    }

    public void mo(int i) {
        if (this.dTx != null) {
            View findViewWithTag = this.dTx.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                hp(false);
            }
        }
    }

    public void mp(int i) {
        View findViewWithTag;
        if (this.dTx != null && (findViewWithTag = this.dTx.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.x(this.dSx, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData vT = vT(str);
                urlDragImageView.setAssistUrl(vT);
                c(vT);
            }
            urlDragImageView.x(this.dSx, true);
        }
    }

    private ImageUrlData vT(String str) {
        if (TextUtils.isEmpty(str) || this.dTF == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dTF.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mq(int i) {
        if (this.dTx == null) {
            return null;
        }
        View findViewWithTag = this.dTx.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void mr(int i) {
        View findViewWithTag;
        if (this.dTx != null && (findViewWithTag = this.dTx.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aVC();
        }
    }

    private void initUI() {
        this.dTx = new GalleryViewPager(getContext());
        this.dTx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dTx.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dTx);
        this.dTw = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dTw.setOrientation(0);
        this.dTw.setLayoutParams(layoutParams);
        addView(this.dTw);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dTv = new Button(getContext());
        am.setBackgroundResource(this.dTv, R.drawable.image_zoomout, 0);
        this.dTv.setLayoutParams(layoutParams2);
        this.dTv.setOnClickListener(this.mOnClickListener);
        this.dTv.setEnabled(false);
        this.dTw.addView(this.dTv);
        this.dTu = new Button(getContext());
        am.setBackgroundResource(this.dTu, R.drawable.image_zoomin, 0);
        this.dTu.setLayoutParams(layoutParams2);
        this.dTu.setOnClickListener(this.mOnClickListener);
        this.dTu.setEnabled(false);
        this.dTw.addView(this.dTu);
        if (this.dTC) {
            this.dTw.setVisibility(8);
        }
        this.dTy = new ImagePagerAdapter(getContext(), this.dSn);
        this.dTy.a(this.dSo);
        setAdapter(this.dTy);
        this.dTI = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dTy != null) {
            this.dTy.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dTI != null) {
            this.dTI.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dTz = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dTy == null) {
            return 0;
        }
        return this.dTy.getCount();
    }

    public int getCurrentItem() {
        if (this.dTx == null) {
            return 0;
        }
        return this.dTx.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dTx == null) {
            return null;
        }
        View findViewWithTag = this.dTx.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dTx == null) {
            return null;
        }
        return this.dTx.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dTu.setEnabled(true);
            } else {
                this.dTu.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dTv.setEnabled(true);
                return;
            } else {
                this.dTv.setEnabled(false);
                return;
            }
        }
        this.dTv.setEnabled(false);
        this.dTu.setEnabled(false);
    }

    public void aVo() {
        if (!this.dTC) {
            this.dTw.setVisibility(0);
        }
    }

    public void o(boolean z, int i) {
        this.dTG = z;
        p(!z, i);
    }

    public boolean aVp() {
        return this.dTG;
    }

    public void hp(boolean z) {
        if (this.dTI != null) {
            this.dTI.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z, int i) {
        if (this.dTH && this.dTI != null) {
            this.dTI.aM(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dTx != null) {
            int childCount = this.dTx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dTx.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dTI != null) {
                this.dTI.setUserId(str);
            }
        }
    }

    public void aVq() {
        if (!this.dTC) {
            this.dTw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dTx == null) {
            return null;
        }
        return this.dTx.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dTx != null) {
            this.dTx.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dTx != null) {
            this.dTx.setOffscreenPageLimit(i);
            this.dTA = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dTA = (int) (this.dTA * 0.8d);
            if (this.dTA < 6291456) {
                this.dTB = true;
                this.dTA = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dTB = false;
            }
            PagerAdapter adapter = this.dTx.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dTA);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.dSm);
        }
        if (this.dTx != null) {
            this.dTx.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dTy);
        if (this.dTx != null) {
            this.dTx.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dTy != null) {
            this.dTy.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dTy != null) {
            this.dTy.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dTy != null) {
            this.dTy.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dTy != null) {
            this.dTy.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dTy != null) {
            this.dTy.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dTE = arrayList;
        if (this.dTy != null) {
            this.dTy.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dTF = map;
        if (this.dTy != null) {
            this.dTy.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dTy != null) {
            this.dTy.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dTy == null) {
            return false;
        }
        return this.dTy.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dTy != null) {
            this.dTy.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dTx == null || (currentView = this.dTx.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dTy != null) {
            this.dTy.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dTx == null || (currentView = this.dTx.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dTx == null || (currentView = this.dTx.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dTx != null && (currentView = this.dTx.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dTx != null) {
            this.dTx.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dSx = z;
        if (this.dTy != null) {
            this.dTy.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dTy != null) {
            this.dTy.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dTy != null) {
            this.dTy.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dTy != null) {
            this.dTy.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dTy != null) {
            this.dTy.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dTH = z;
        hp(z);
    }
}
