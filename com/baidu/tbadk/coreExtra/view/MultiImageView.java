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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    private DragImageView.g cdf;
    private DragImageView.e cdg;
    private ImagePagerAdapter.b cdh;
    private boolean cdr;
    private Map<String, ImageUrlData> ceA;
    private boolean ceB;
    protected b ceC;
    private Button cep;
    private Button ceq;
    private LinearLayout cer;
    private GalleryViewPager ces;
    private ImagePagerAdapter cet;
    private ViewPager.OnPageChangeListener ceu;
    private int cev;
    private boolean cew;
    private boolean cex;
    private int cey;
    private ArrayList<String> cez;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.cey;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cep = null;
        this.ceq = null;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.mOnClickListener = null;
        this.cdg = null;
        this.mOnPageChangeListener = null;
        this.ceu = null;
        this.cdf = null;
        this.cdh = null;
        this.cev = 0;
        this.cew = true;
        this.cex = false;
        this.cdr = false;
        this.cey = 1;
        this.cez = null;
        this.ceA = null;
        this.ceB = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ces != null) {
            this.ces.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cep = null;
        this.ceq = null;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.mOnClickListener = null;
        this.cdg = null;
        this.mOnPageChangeListener = null;
        this.ceu = null;
        this.cdf = null;
        this.cdh = null;
        this.cev = 0;
        this.cew = true;
        this.cex = false;
        this.cdr = false;
        this.cey = 1;
        this.cez = null;
        this.ceA = null;
        this.ceB = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cep = null;
        this.ceq = null;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.mOnClickListener = null;
        this.cdg = null;
        this.mOnPageChangeListener = null;
        this.ceu = null;
        this.cdf = null;
        this.cdh = null;
        this.cev = 0;
        this.cew = true;
        this.cex = false;
        this.cdr = false;
        this.cey = 1;
        this.cez = null;
        this.ceA = null;
        this.ceB = false;
        init();
    }

    public void init() {
        this.cex = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cep) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.aqK();
                    }
                } else if (view == MultiImageView.this.ceq && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.aqL();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.ceu != null) {
                    MultiImageView.this.ceu.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.ceu != null) {
                    MultiImageView.this.ceu.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.cey) {
                    MultiImageView.this.cey = i + 1;
                }
                if (MultiImageView.this.ces != null) {
                    int childCount = MultiImageView.this.ces.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.ces.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).akB();
                        }
                    }
                }
                if (MultiImageView.this.ceu != null) {
                    MultiImageView.this.ceu.onPageSelected(i);
                }
            }
        };
        this.cdf = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ces != null && MultiImageView.this.ces.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cdg = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.ces != null && dragImageView == MultiImageView.this.ces.getCurrentView()) {
                    if (MultiImageView.this.cew) {
                        int childCount = MultiImageView.this.ces.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ces.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cdh = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.ces != null) {
                        MultiImageView.this.ces.setCurrentView(null);
                    }
                    MultiImageView.this.eu(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.aqM();
                    if (MultiImageView.this.ces != null) {
                        MultiImageView.this.ces.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cdg != null) {
                        MultiImageView.this.cdg.a(imageView);
                    }
                }
                urlDragImageView.akz();
                urlDragImageView.aky();
                urlDragImageView.o(MultiImageView.this.cdr, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cet != null) {
            return this.cet.getCount();
        }
        return 0;
    }

    public void hN(int i) {
        if (this.mSkinType != i && this.ces != null) {
            int childCount = this.ces.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ces.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ces != null && this.ces.getCurrentView() != null) {
            if (this.cew) {
                int childCount = this.ces.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ces.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.ces.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.ces.findViewWithTag(String.valueOf(this.ces.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).o(this.cdr, true);
            }
            this.ces.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ces != null && this.ces.getCurrentView() != null) {
            this.ces.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ces != null) {
            int childCount = this.ces.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ces.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.ceC != null) {
            this.ceC.setAssistUrl(imageUrlData);
            if (this.ceB || imageUrlData == null) {
                eu(false);
            } else if (!this.ceC.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jc(int i) {
        if (this.ces != null) {
            View findViewWithTag = this.ces.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eu(false);
            }
        }
    }

    public void jd(int i) {
        View findViewWithTag;
        if (this.ces != null && (findViewWithTag = this.ces.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.o(this.cdr, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData og = og(str);
                urlDragImageView.setAssistUrl(og);
                c(og);
            }
            urlDragImageView.o(this.cdr, true);
        }
    }

    private ImageUrlData og(String str) {
        if (TextUtils.isEmpty(str) || this.ceA == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.ceA.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String je(int i) {
        if (this.ces == null) {
            return null;
        }
        View findViewWithTag = this.ces.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void jf(int i) {
        View findViewWithTag;
        if (this.ces != null && (findViewWithTag = this.ces.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).akD();
        }
    }

    private void initUI() {
        this.ces = new GalleryViewPager(getContext());
        this.ces.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ces.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ces);
        this.cer = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cer.setOrientation(0);
        this.cer.setLayoutParams(layoutParams);
        addView(this.cer);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ceq = new Button(getContext());
        al.e(this.ceq, d.f.image_zoomout, 0);
        this.ceq.setLayoutParams(layoutParams2);
        this.ceq.setOnClickListener(this.mOnClickListener);
        this.ceq.setEnabled(false);
        this.cer.addView(this.ceq);
        this.cep = new Button(getContext());
        al.e(this.cep, d.f.image_zoomin, 0);
        this.cep.setLayoutParams(layoutParams2);
        this.cep.setOnClickListener(this.mOnClickListener);
        this.cep.setEnabled(false);
        this.cer.addView(this.cep);
        if (this.cex) {
            this.cer.setVisibility(8);
        }
        this.cet = new ImagePagerAdapter(getContext(), this.cdg);
        this.cet.a(this.cdh);
        setAdapter(this.cet);
        this.ceC = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cet != null) {
            this.cet.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cet != null) {
            this.cet.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ceu = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cet == null) {
            return 0;
        }
        return this.cet.getCount();
    }

    public int getCurrentItem() {
        if (this.ces == null) {
            return 0;
        }
        return this.ces.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.ces == null) {
            return null;
        }
        View findViewWithTag = this.ces.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cep.setEnabled(true);
            } else {
                this.cep.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ceq.setEnabled(true);
                return;
            } else {
                this.ceq.setEnabled(false);
                return;
            }
        }
        this.ceq.setEnabled(false);
        this.cep.setEnabled(false);
    }

    public void ako() {
        if (!this.cex) {
            this.cer.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.ceB = z;
        h(!z, i);
    }

    public boolean akp() {
        return this.ceB;
    }

    public void eu(boolean z) {
        if (this.ceC != null) {
            this.ceC.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.ceC != null) {
            this.ceC.af(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.ces != null) {
            int childCount = this.ces.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ces.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.ceC != null) {
                this.ceC.setUserId(str);
            }
        }
    }

    public void akq() {
        if (!this.cex) {
            this.cer.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.ces == null) {
            return null;
        }
        return this.ces.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.ces != null) {
            this.ces.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.ces != null) {
            this.ces.setOffscreenPageLimit(i);
            this.cev = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cev = (int) (this.cev * 0.8d);
            if (this.cev < 6291456) {
                this.cew = true;
                this.cev = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cew = false;
            }
            PagerAdapter adapter = this.ces.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cev);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cdf);
        }
        if (this.ces != null) {
            this.ces.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cet);
        if (this.ces != null) {
            this.ces.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cet != null) {
            this.cet.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cet != null) {
            this.cet.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cet != null) {
            this.cet.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cet != null) {
            this.cet.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cet != null) {
            this.cet.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.cez = arrayList;
        if (this.cet != null) {
            this.cet.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ceA = map;
        if (this.cet != null) {
            this.cet.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cet != null) {
            this.cet.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cet == null) {
            return false;
        }
        return this.cet.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cet != null) {
            this.cet.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.ces == null || (currentView = this.ces.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cet != null) {
            this.cet.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        if (this.ces == null) {
            return null;
        }
        DragImageView currentView = this.ces.getCurrentView();
        if (currentView.getTag() instanceof String) {
            return (String) currentView.getTag();
        }
        return null;
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ces != null) {
            this.ces.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdr = z;
        if (this.cet != null) {
            this.cet.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cet != null) {
            this.cet.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cet != null) {
            this.cet.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cet != null) {
            this.cet.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cet != null) {
            this.cet.setOriImgSelectedCallback(bVar);
        }
    }
}
