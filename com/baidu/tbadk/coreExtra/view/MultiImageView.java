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
    private ArrayList<String> dzk;
    private DragImageView.g fpj;
    private DragImageView.e fpk;
    private ImagePagerAdapter.b fpl;
    private boolean fpv;
    private boolean fqA;
    private boolean fqB;
    private int fqC;
    private Map<String, ImageUrlData> fqD;
    private boolean fqE;
    private boolean fqF;
    protected a fqG;
    private Button fqt;
    private Button fqu;
    private LinearLayout fqv;
    private GalleryViewPager fqw;
    private ImagePagerAdapter fqx;
    private ViewPager.OnPageChangeListener fqy;
    private int fqz;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.fqC;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fqt = null;
        this.fqu = null;
        this.fqv = null;
        this.fqw = null;
        this.fqx = null;
        this.mOnClickListener = null;
        this.fpk = null;
        this.mOnPageChangeListener = null;
        this.fqy = null;
        this.fpj = null;
        this.fpl = null;
        this.fqz = 0;
        this.fqA = true;
        this.fqB = false;
        this.fpv = false;
        this.fqC = 1;
        this.dzk = null;
        this.fqD = null;
        this.fqE = false;
        this.fqF = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.fqw != null) {
            this.fqw.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fqt = null;
        this.fqu = null;
        this.fqv = null;
        this.fqw = null;
        this.fqx = null;
        this.mOnClickListener = null;
        this.fpk = null;
        this.mOnPageChangeListener = null;
        this.fqy = null;
        this.fpj = null;
        this.fpl = null;
        this.fqz = 0;
        this.fqA = true;
        this.fqB = false;
        this.fpv = false;
        this.fqC = 1;
        this.dzk = null;
        this.fqD = null;
        this.fqE = false;
        this.fqF = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fqt = null;
        this.fqu = null;
        this.fqv = null;
        this.fqw = null;
        this.fqx = null;
        this.mOnClickListener = null;
        this.fpk = null;
        this.mOnPageChangeListener = null;
        this.fqy = null;
        this.fpj = null;
        this.fpl = null;
        this.fqz = 0;
        this.fqA = true;
        this.fqB = false;
        this.fpv = false;
        this.fqC = 1;
        this.dzk = null;
        this.fqD = null;
        this.fqE = false;
        this.fqF = true;
        init();
    }

    public void init() {
        this.fqB = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.fqt) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.fqu && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.fqy != null) {
                    MultiImageView.this.fqy.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.fqy != null) {
                    MultiImageView.this.fqy.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.fqC) {
                    MultiImageView.this.fqC = i + 1;
                }
                if (MultiImageView.this.fqw != null) {
                    int childCount = MultiImageView.this.fqw.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.fqw.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).bAU();
                        }
                    }
                }
                if (MultiImageView.this.fqy != null) {
                    MultiImageView.this.fqy.onPageSelected(i);
                }
            }
        };
        this.fpj = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.fqw != null && MultiImageView.this.fqw.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.fpk = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.fqw != null && dragImageView == MultiImageView.this.fqw.getCurrentView()) {
                    if (MultiImageView.this.fqA) {
                        int childCount = MultiImageView.this.fqw.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.fqw.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.fpl = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.fqw != null) {
                        MultiImageView.this.fqw.setCurrentView(null);
                    }
                    MultiImageView.this.kg(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.fqw != null) {
                        MultiImageView.this.fqw.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.fpk != null) {
                        MultiImageView.this.fpk.a(imageView);
                    }
                }
                urlDragImageView.bAS();
                urlDragImageView.bAR();
                urlDragImageView.E(MultiImageView.this.fpv, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.fqx != null) {
            return this.fqx.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.fqw != null) {
            int childCount = this.fqw.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fqw.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.fqw != null && this.fqw.getCurrentView() != null) {
            if (this.fqA) {
                int childCount = this.fqw.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.fqw.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.fqw.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.fqw.findViewWithTag(String.valueOf(this.fqw.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).E(this.fpv, true);
            }
            this.fqw.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.fqw != null && this.fqw.getCurrentView() != null) {
            this.fqw.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.fqw != null) {
            int childCount = this.fqw.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fqw.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.fqG != null) {
            this.fqG.setAssistUrl(imageUrlData);
            if (this.fqE || imageUrlData == null) {
                kg(false);
                return;
            }
            if (!this.fqG.bAA()) {
                this.fqG.ke(false);
            }
            if (!this.fqG.isShown()) {
                t(true, 150);
            }
        }
    }

    public void rU(int i) {
        if (this.fqw != null) {
            View findViewWithTag = this.fqw.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                kg(false);
            }
        }
    }

    public void rV(int i) {
        View findViewWithTag;
        if (this.fqw != null && (findViewWithTag = this.fqw.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.E(this.fpv, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData Dl = Dl(str);
                urlDragImageView.setAssistUrl(Dl);
                c(Dl);
            }
            urlDragImageView.E(this.fpv, true);
        }
    }

    private ImageUrlData Dl(String str) {
        if (TextUtils.isEmpty(str) || this.fqD == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.fqD.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String rW(int i) {
        if (this.fqw == null) {
            return null;
        }
        View findViewWithTag = this.fqw.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void rX(int i) {
        View findViewWithTag;
        if (this.fqw != null && (findViewWithTag = this.fqw.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).bAW();
        }
    }

    private void initUI() {
        this.fqw = new GalleryViewPager(getContext());
        this.fqw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fqw.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.fqw);
        this.fqv = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.fqv.setOrientation(0);
        this.fqv.setLayoutParams(layoutParams);
        addView(this.fqv);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.fqu = new Button(getContext());
        ap.setBackgroundResource(this.fqu, R.drawable.image_zoomout, 0);
        this.fqu.setLayoutParams(layoutParams2);
        this.fqu.setOnClickListener(this.mOnClickListener);
        this.fqu.setEnabled(false);
        this.fqv.addView(this.fqu);
        this.fqt = new Button(getContext());
        ap.setBackgroundResource(this.fqt, R.drawable.image_zoomin, 0);
        this.fqt.setLayoutParams(layoutParams2);
        this.fqt.setOnClickListener(this.mOnClickListener);
        this.fqt.setEnabled(false);
        this.fqv.addView(this.fqt);
        if (this.fqB) {
            this.fqv.setVisibility(8);
        }
        this.fqx = new ImagePagerAdapter(getContext(), this.fpk);
        this.fqx.a(this.fpl);
        setAdapter(this.fqx);
        this.fqG = new a(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.fqx != null) {
            this.fqx.setIsCanDrag(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fqy = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.fqx == null) {
            return 0;
        }
        return this.fqx.getCount();
    }

    public int getCurrentItem() {
        if (this.fqw == null) {
            return 0;
        }
        return this.fqw.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.fqw == null) {
            return null;
        }
        View findViewWithTag = this.fqw.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.fqw == null) {
            return null;
        }
        return this.fqw.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.fqt.setEnabled(true);
            } else {
                this.fqt.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.fqu.setEnabled(true);
                return;
            } else {
                this.fqu.setEnabled(false);
                return;
            }
        }
        this.fqu.setEnabled(false);
        this.fqt.setEnabled(false);
    }

    public void bAI() {
        if (!this.fqB) {
            this.fqv.setVisibility(0);
        }
    }

    public boolean bAJ() {
        return this.fqE;
    }

    public void kg(boolean z) {
        if (this.fqG != null) {
            this.fqG.setVisibility(z ? 0 : 8);
        }
    }

    public void t(boolean z, int i) {
        if (this.fqF && this.fqG != null) {
            this.fqG.bg(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.fqw != null) {
            int childCount = this.fqw.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.fqw.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.fqG != null) {
                this.fqG.setUserId(str);
            }
        }
    }

    public void bAK() {
        if (!this.fqB) {
            this.fqv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.fqw == null) {
            return null;
        }
        return this.fqw.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.fqw != null) {
            this.fqw.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.fqw != null) {
            this.fqw.setOffscreenPageLimit(i);
            this.fqz = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.fqz = (int) (this.fqz * 0.8d);
            if (this.fqz < 6291456) {
                this.fqA = true;
                this.fqz = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.fqA = false;
            }
            PagerAdapter adapter = this.fqw.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.fqz);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.fpj);
        }
        if (this.fqw != null) {
            this.fqw.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.fqx);
        if (this.fqw != null) {
            this.fqw.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.fqx != null) {
            this.fqx.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.fqx != null) {
            this.fqx.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.fqx != null) {
            this.fqx.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fqx != null) {
            this.fqx.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.fqx != null) {
            this.fqx.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dzk = arrayList;
        if (this.fqx != null) {
            this.fqx.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.fqD = map;
        if (this.fqx != null) {
            this.fqx.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.fqx != null) {
            this.fqx.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.fqx == null) {
            return false;
        }
        return this.fqx.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.fqx != null) {
            this.fqx.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.fqw == null || (currentView = this.fqw.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.fqx != null) {
            this.fqx.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.fqw == null || (currentView = this.fqw.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fqw == null || (currentView = this.fqw.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.fqw != null && (currentView = this.fqw.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.fqw != null) {
            this.fqw.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.fpv = z;
        if (this.fqx != null) {
            this.fqx.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.fqx != null) {
            this.fqx.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fqx != null) {
            this.fqx.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.fqx != null) {
            this.fqx.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.fqx != null) {
            this.fqx.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.fqF = z;
        kg(z);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fqG != null) {
            this.fqG.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fqG != null) {
            this.fqG.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fqG != null) {
            this.fqG.setOnReplyClickListener(onClickListener);
        }
    }
}
