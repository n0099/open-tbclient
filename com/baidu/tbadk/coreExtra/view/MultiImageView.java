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
    private DragImageView.g cmH;
    private DragImageView.e cmI;
    private ImagePagerAdapter.b cmJ;
    private boolean cmT;
    private Button cnT;
    private Button cnU;
    private LinearLayout cnV;
    private GalleryViewPager cnW;
    private ImagePagerAdapter cnX;
    private ViewPager.OnPageChangeListener cnY;
    private int cnZ;
    private boolean coa;
    private boolean cob;
    private int coc;
    private ArrayList<String> cod;
    private Map<String, ImageUrlData> coe;
    private boolean cof;
    protected b cog;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.coc;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cnT = null;
        this.cnU = null;
        this.cnV = null;
        this.cnW = null;
        this.cnX = null;
        this.mOnClickListener = null;
        this.cmI = null;
        this.mOnPageChangeListener = null;
        this.cnY = null;
        this.cmH = null;
        this.cmJ = null;
        this.cnZ = 0;
        this.coa = true;
        this.cob = false;
        this.cmT = false;
        this.coc = 1;
        this.cod = null;
        this.coe = null;
        this.cof = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cnW != null) {
            this.cnW.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cnT = null;
        this.cnU = null;
        this.cnV = null;
        this.cnW = null;
        this.cnX = null;
        this.mOnClickListener = null;
        this.cmI = null;
        this.mOnPageChangeListener = null;
        this.cnY = null;
        this.cmH = null;
        this.cmJ = null;
        this.cnZ = 0;
        this.coa = true;
        this.cob = false;
        this.cmT = false;
        this.coc = 1;
        this.cod = null;
        this.coe = null;
        this.cof = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cnT = null;
        this.cnU = null;
        this.cnV = null;
        this.cnW = null;
        this.cnX = null;
        this.mOnClickListener = null;
        this.cmI = null;
        this.mOnPageChangeListener = null;
        this.cnY = null;
        this.cmH = null;
        this.cmJ = null;
        this.cnZ = 0;
        this.coa = true;
        this.cob = false;
        this.cmT = false;
        this.coc = 1;
        this.cod = null;
        this.coe = null;
        this.cof = false;
        init();
    }

    public void init() {
        this.cob = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cnT) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.awZ();
                    }
                } else if (view == MultiImageView.this.cnU && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.axa();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cnY != null) {
                    MultiImageView.this.cnY.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cnY != null) {
                    MultiImageView.this.cnY.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.coc) {
                    MultiImageView.this.coc = i + 1;
                }
                if (MultiImageView.this.cnW != null) {
                    int childCount = MultiImageView.this.cnW.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cnW.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).aqH();
                        }
                    }
                }
                if (MultiImageView.this.cnY != null) {
                    MultiImageView.this.cnY.onPageSelected(i);
                }
            }
        };
        this.cmH = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cnW != null && MultiImageView.this.cnW.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cmI = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cnW != null && dragImageView == MultiImageView.this.cnW.getCurrentView()) {
                    if (MultiImageView.this.coa) {
                        int childCount = MultiImageView.this.cnW.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cnW.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cmJ = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cnW != null) {
                        MultiImageView.this.cnW.setCurrentView(null);
                    }
                    MultiImageView.this.eU(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.axb();
                    if (MultiImageView.this.cnW != null) {
                        MultiImageView.this.cnW.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cmI != null) {
                        MultiImageView.this.cmI.a(imageView);
                    }
                }
                urlDragImageView.aqF();
                urlDragImageView.aqE();
                urlDragImageView.r(MultiImageView.this.cmT, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cnX != null) {
            return this.cnX.getCount();
        }
        return 0;
    }

    public void iG(int i) {
        if (this.mSkinType != i && this.cnW != null) {
            int childCount = this.cnW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cnW.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cnW != null && this.cnW.getCurrentView() != null) {
            if (this.coa) {
                int childCount = this.cnW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cnW.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cnW.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cnW.findViewWithTag(String.valueOf(this.cnW.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).r(this.cmT, true);
            }
            this.cnW.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cnW != null && this.cnW.getCurrentView() != null) {
            this.cnW.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cnW != null) {
            int childCount = this.cnW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cnW.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.cog != null) {
            this.cog.setAssistUrl(imageUrlData);
            if (this.cof || imageUrlData == null) {
                eU(false);
                return;
            }
            if (!this.cog.aqn()) {
                this.cog.q(false, false);
            }
            if (!this.cog.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jW(int i) {
        if (this.cnW != null) {
            View findViewWithTag = this.cnW.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eU(false);
            }
        }
    }

    public void jX(int i) {
        View findViewWithTag;
        if (this.cnW != null && (findViewWithTag = this.cnW.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.r(this.cmT, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData pG = pG(str);
                urlDragImageView.setAssistUrl(pG);
                c(pG);
            }
            urlDragImageView.r(this.cmT, true);
        }
    }

    private ImageUrlData pG(String str) {
        if (TextUtils.isEmpty(str) || this.coe == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.coe.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jY(int i) {
        if (this.cnW == null) {
            return null;
        }
        View findViewWithTag = this.cnW.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jZ(int i) {
        View findViewWithTag;
        if (this.cnW != null && (findViewWithTag = this.cnW.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).aqJ();
        }
    }

    private void initUI() {
        this.cnW = new GalleryViewPager(getContext());
        this.cnW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cnW.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cnW);
        this.cnV = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cnV.setOrientation(0);
        this.cnV.setLayoutParams(layoutParams);
        addView(this.cnV);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cnU = new Button(getContext());
        am.g(this.cnU, R.drawable.image_zoomout, 0);
        this.cnU.setLayoutParams(layoutParams2);
        this.cnU.setOnClickListener(this.mOnClickListener);
        this.cnU.setEnabled(false);
        this.cnV.addView(this.cnU);
        this.cnT = new Button(getContext());
        am.g(this.cnT, R.drawable.image_zoomin, 0);
        this.cnT.setLayoutParams(layoutParams2);
        this.cnT.setOnClickListener(this.mOnClickListener);
        this.cnT.setEnabled(false);
        this.cnV.addView(this.cnT);
        if (this.cob) {
            this.cnV.setVisibility(8);
        }
        this.cnX = new ImagePagerAdapter(getContext(), this.cmI);
        this.cnX.a(this.cmJ);
        setAdapter(this.cnX);
        this.cog = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cnX != null) {
            this.cnX.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cnX != null) {
            this.cnX.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cnY = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cnX == null) {
            return 0;
        }
        return this.cnX.getCount();
    }

    public int getCurrentItem() {
        if (this.cnW == null) {
            return 0;
        }
        return this.cnW.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cnW == null) {
            return null;
        }
        View findViewWithTag = this.cnW.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.axc()) {
                this.cnT.setEnabled(true);
            } else {
                this.cnT.setEnabled(false);
            }
            if (dragImageView.axd()) {
                this.cnU.setEnabled(true);
                return;
            } else {
                this.cnU.setEnabled(false);
                return;
            }
        }
        this.cnU.setEnabled(false);
        this.cnT.setEnabled(false);
    }

    public void aqu() {
        if (!this.cob) {
            this.cnV.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.cof = z;
        h(!z, i);
    }

    public boolean aqv() {
        return this.cof;
    }

    public void eU(boolean z) {
        if (this.cog != null) {
            this.cog.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.cog != null) {
            this.cog.ai(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cnW != null) {
            int childCount = this.cnW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cnW.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.cog != null) {
                this.cog.setUserId(str);
            }
        }
    }

    public void aqw() {
        if (!this.cob) {
            this.cnV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cnW == null) {
            return null;
        }
        return this.cnW.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cnW != null) {
            this.cnW.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cnW != null) {
            this.cnW.setOffscreenPageLimit(i);
            this.cnZ = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cnZ = (int) (this.cnZ * 0.8d);
            if (this.cnZ < 6291456) {
                this.coa = true;
                this.cnZ = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.coa = false;
            }
            PagerAdapter adapter = this.cnW.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cnZ);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cmH);
        }
        if (this.cnW != null) {
            this.cnW.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cnX);
        if (this.cnW != null) {
            this.cnW.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cnX != null) {
            this.cnX.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cnX != null) {
            this.cnX.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cnX != null) {
            this.cnX.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cnX != null) {
            this.cnX.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cnX != null) {
            this.cnX.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cod = arrayList;
        if (this.cnX != null) {
            this.cnX.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.coe = map;
        if (this.cnX != null) {
            this.cnX.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cnX != null) {
            this.cnX.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cnX == null) {
            return false;
        }
        return this.cnX.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cnX != null) {
            this.cnX.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cnW == null || (currentView = this.cnW.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cnX != null) {
            this.cnX.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        if (this.cnW == null || (currentView = this.cnW.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cnW == null || (currentView = this.cnW.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        if (this.cnW != null && (currentView = this.cnW.getCurrentView()) != null && (imageUrlData = currentView.getImageUrlData()) != null) {
            imageUrlData.qrInfo = str;
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cnW != null) {
            this.cnW.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cmT = z;
        if (this.cnX != null) {
            this.cnX.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cnX != null) {
            this.cnX.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cnX != null) {
            this.cnX.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cnX != null) {
            this.cnX.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cnX != null) {
            this.cnX.setOriImgSelectedCallback(bVar);
        }
    }
}
