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
    private DragImageView.g drY;
    private DragImageView.e drZ;
    private ImagePagerAdapter.b dsa;
    private boolean dsj;
    private Button dth;
    private Button dti;
    private LinearLayout dtj;
    private GalleryViewPager dtk;
    private ImagePagerAdapter dtl;
    private ViewPager.OnPageChangeListener dtm;
    private int dtn;
    private boolean dto;
    private boolean dtp;
    private int dtq;
    private ArrayList<String> dtr;
    private Map<String, ImageUrlData> dts;
    private boolean dtt;
    private boolean dtu;
    protected b dtv;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.dtq;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dth = null;
        this.dti = null;
        this.dtj = null;
        this.dtk = null;
        this.dtl = null;
        this.mOnClickListener = null;
        this.drZ = null;
        this.mOnPageChangeListener = null;
        this.dtm = null;
        this.drY = null;
        this.dsa = null;
        this.dtn = 0;
        this.dto = true;
        this.dtp = false;
        this.dsj = false;
        this.dtq = 1;
        this.dtr = null;
        this.dts = null;
        this.dtt = false;
        this.dtu = true;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.dtk != null) {
            this.dtk.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dth = null;
        this.dti = null;
        this.dtj = null;
        this.dtk = null;
        this.dtl = null;
        this.mOnClickListener = null;
        this.drZ = null;
        this.mOnPageChangeListener = null;
        this.dtm = null;
        this.drY = null;
        this.dsa = null;
        this.dtn = 0;
        this.dto = true;
        this.dtp = false;
        this.dsj = false;
        this.dtq = 1;
        this.dtr = null;
        this.dts = null;
        this.dtt = false;
        this.dtu = true;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dth = null;
        this.dti = null;
        this.dtj = null;
        this.dtk = null;
        this.dtl = null;
        this.mOnClickListener = null;
        this.drZ = null;
        this.mOnPageChangeListener = null;
        this.dtm = null;
        this.drY = null;
        this.dsa = null;
        this.dtn = 0;
        this.dto = true;
        this.dtp = false;
        this.dsj = false;
        this.dtq = 1;
        this.dtr = null;
        this.dts = null;
        this.dtt = false;
        this.dtu = true;
        init();
    }

    public void init() {
        this.dtp = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.dth) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view == MultiImageView.this.dti && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.zoomOutBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.dtm != null) {
                    MultiImageView.this.dtm.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.dtm != null) {
                    MultiImageView.this.dtm.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.dtq) {
                    MultiImageView.this.dtq = i + 1;
                }
                if (MultiImageView.this.dtk != null) {
                    int childCount = MultiImageView.this.dtk.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.dtk.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aNb();
                        }
                    }
                }
                if (MultiImageView.this.dtm != null) {
                    MultiImageView.this.dtm.onPageSelected(i);
                }
            }
        };
        this.drY = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.dtk != null && MultiImageView.this.dtk.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.drZ = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.dtk != null && dragImageView == MultiImageView.this.dtk.getCurrentView()) {
                    if (MultiImageView.this.dto) {
                        int childCount = MultiImageView.this.dtk.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.dtk.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.dsa = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void g(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.dtk != null) {
                        MultiImageView.this.dtk.setCurrentView(null);
                    }
                    MultiImageView.this.gq(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (MultiImageView.this.dtk != null) {
                        MultiImageView.this.dtk.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.drZ != null) {
                        MultiImageView.this.drZ.a(imageView);
                    }
                }
                urlDragImageView.aMZ();
                urlDragImageView.aMY();
                urlDragImageView.y(MultiImageView.this.dsj, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.dtl != null) {
            return this.dtl.getCount();
        }
        return 0;
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i && this.dtk != null) {
            int childCount = this.dtk.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dtk.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.dtk != null && this.dtk.getCurrentView() != null) {
            if (this.dto) {
                int childCount = this.dtk.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.dtk.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.dtk.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.dtk.findViewWithTag(String.valueOf(this.dtk.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).y(this.dsj, true);
            }
            this.dtk.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.dtk != null && this.dtk.getCurrentView() != null) {
            this.dtk.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.dtk != null) {
            int childCount = this.dtk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dtk.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.dtv != null) {
            this.dtv.setAssistUrl(imageUrlData);
            if (this.dtt || imageUrlData == null) {
                gq(false);
                return;
            }
            if (!this.dtv.aMI()) {
                this.dtv.x(false, false);
            }
            if (!this.dtv.isShown()) {
                o(true, 150);
            }
        }
    }

    public void ma(int i) {
        if (this.dtk != null) {
            View findViewWithTag = this.dtk.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                gq(false);
            }
        }
    }

    public void mb(int i) {
        View findViewWithTag;
        if (this.dtk != null && (findViewWithTag = this.dtk.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.y(this.dsj, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData uC = uC(str);
                urlDragImageView.setAssistUrl(uC);
                c(uC);
            }
            urlDragImageView.y(this.dsj, true);
        }
    }

    private ImageUrlData uC(String str) {
        if (TextUtils.isEmpty(str) || this.dts == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.dts.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String mc(int i) {
        if (this.dtk == null) {
            return null;
        }
        View findViewWithTag = this.dtk.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void md(int i) {
        View findViewWithTag;
        if (this.dtk != null && (findViewWithTag = this.dtk.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aNd();
        }
    }

    private void initUI() {
        this.dtk = new GalleryViewPager(getContext());
        this.dtk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.dtk.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.dtk);
        this.dtj = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.dtj.setOrientation(0);
        this.dtj.setLayoutParams(layoutParams);
        addView(this.dtj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dti = new Button(getContext());
        am.setBackgroundResource(this.dti, R.drawable.image_zoomout, 0);
        this.dti.setLayoutParams(layoutParams2);
        this.dti.setOnClickListener(this.mOnClickListener);
        this.dti.setEnabled(false);
        this.dtj.addView(this.dti);
        this.dth = new Button(getContext());
        am.setBackgroundResource(this.dth, R.drawable.image_zoomin, 0);
        this.dth.setLayoutParams(layoutParams2);
        this.dth.setOnClickListener(this.mOnClickListener);
        this.dth.setEnabled(false);
        this.dtj.addView(this.dth);
        if (this.dtp) {
            this.dtj.setVisibility(8);
        }
        this.dtl = new ImagePagerAdapter(getContext(), this.drZ);
        this.dtl.a(this.dsa);
        setAdapter(this.dtl);
        this.dtv = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.dtl != null) {
            this.dtl.setIsCanDrag(z);
        }
    }

    public void setIsBJHThread(boolean z) {
        if (this.dtv != null) {
            this.dtv.setIsBjhDynamic(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dtm = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.dtl == null) {
            return 0;
        }
        return this.dtl.getCount();
    }

    public int getCurrentItem() {
        if (this.dtk == null) {
            return 0;
        }
        return this.dtk.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.dtk == null) {
            return null;
        }
        View findViewWithTag = this.dtk.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        if (this.dtk == null) {
            return null;
        }
        return this.dtk.getCurrentView();
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.dth.setEnabled(true);
            } else {
                this.dth.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.dti.setEnabled(true);
                return;
            } else {
                this.dti.setEnabled(false);
                return;
            }
        }
        this.dti.setEnabled(false);
        this.dth.setEnabled(false);
    }

    public void aMP() {
        if (!this.dtp) {
            this.dtj.setVisibility(0);
        }
    }

    public void n(boolean z, int i) {
        this.dtt = z;
        o(!z, i);
    }

    public boolean aMQ() {
        return this.dtt;
    }

    public void gq(boolean z) {
        if (this.dtv != null) {
            this.dtv.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z, int i) {
        if (this.dtu && this.dtv != null) {
            this.dtv.aH(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.dtk != null) {
            int childCount = this.dtk.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dtk.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.dtv != null) {
                this.dtv.setUserId(str);
            }
        }
    }

    public void aMR() {
        if (!this.dtp) {
            this.dtj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.dtk == null) {
            return null;
        }
        return this.dtk.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.dtk != null) {
            this.dtk.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.dtk != null) {
            this.dtk.setOffscreenPageLimit(i);
            this.dtn = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.dtn = (int) (this.dtn * 0.8d);
            if (this.dtn < 6291456) {
                this.dto = true;
                this.dtn = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.dto = false;
            }
            PagerAdapter adapter = this.dtk.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.dtn);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.drY);
        }
        if (this.dtk != null) {
            this.dtk.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.dtl);
        if (this.dtk != null) {
            this.dtk.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.dtl != null) {
            this.dtl.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.dtl != null) {
            this.dtl.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.dtl != null) {
            this.dtl.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dtl != null) {
            this.dtl.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.dtl != null) {
            this.dtl.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.dtr = arrayList;
        if (this.dtl != null) {
            this.dtl.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.dts = map;
        if (this.dtl != null) {
            this.dtl.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.dtl != null) {
            this.dtl.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.dtl == null) {
            return false;
        }
        return this.dtl.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.dtl != null) {
            this.dtl.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.dtk == null || (currentView = this.dtk.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.dtl != null) {
            this.dtl.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.dtk == null || (currentView = this.dtk.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dtk == null || (currentView = this.dtk.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.dtk != null && (currentView = this.dtk.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.dtk != null) {
            this.dtk.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.dsj = z;
        if (this.dtl != null) {
            this.dtl.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.dtl != null) {
            this.dtl.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.dtl != null) {
            this.dtl.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.dtl != null) {
            this.dtl.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.dtl != null) {
            this.dtl.setOriImgSelectedCallback(bVar);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.dtu = z;
        gq(z);
    }
}
