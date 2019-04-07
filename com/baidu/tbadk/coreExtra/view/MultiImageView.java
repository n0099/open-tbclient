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
    private DragImageView.g cdh;
    private DragImageView.e cdi;
    private ImagePagerAdapter.b cdj;
    private boolean cdt;
    private int ceA;
    private ArrayList<String> ceB;
    private Map<String, ImageUrlData> ceC;
    private boolean ceD;
    protected b ceE;
    private Button cer;
    private Button ces;
    private LinearLayout cet;
    private GalleryViewPager ceu;
    private ImagePagerAdapter cev;
    private ViewPager.OnPageChangeListener cew;
    private int cex;
    private boolean cey;
    private boolean cez;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.ceA;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.mOnClickListener = null;
        this.cdi = null;
        this.mOnPageChangeListener = null;
        this.cew = null;
        this.cdh = null;
        this.cdj = null;
        this.cex = 0;
        this.cey = true;
        this.cez = false;
        this.cdt = false;
        this.ceA = 1;
        this.ceB = null;
        this.ceC = null;
        this.ceD = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.ceu != null) {
            this.ceu.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.mOnClickListener = null;
        this.cdi = null;
        this.mOnPageChangeListener = null;
        this.cew = null;
        this.cdh = null;
        this.cdj = null;
        this.cex = 0;
        this.cey = true;
        this.cez = false;
        this.cdt = false;
        this.ceA = 1;
        this.ceB = null;
        this.ceC = null;
        this.ceD = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cer = null;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.mOnClickListener = null;
        this.cdi = null;
        this.mOnPageChangeListener = null;
        this.cew = null;
        this.cdh = null;
        this.cdj = null;
        this.cex = 0;
        this.cey = true;
        this.cez = false;
        this.cdt = false;
        this.ceA = 1;
        this.ceB = null;
        this.ceC = null;
        this.ceD = false;
        init();
    }

    public void init() {
        this.cez = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.cer) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.aqH();
                    }
                } else if (view == MultiImageView.this.ces && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.aqI();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cew != null) {
                    MultiImageView.this.cew.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cew != null) {
                    MultiImageView.this.cew.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.ceA) {
                    MultiImageView.this.ceA = i + 1;
                }
                if (MultiImageView.this.ceu != null) {
                    int childCount = MultiImageView.this.ceu.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.ceu.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).akx();
                        }
                    }
                }
                if (MultiImageView.this.cew != null) {
                    MultiImageView.this.cew.onPageSelected(i);
                }
            }
        };
        this.cdh = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.ceu != null && MultiImageView.this.ceu.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cdi = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.ceu != null && dragImageView == MultiImageView.this.ceu.getCurrentView()) {
                    if (MultiImageView.this.cey) {
                        int childCount = MultiImageView.this.ceu.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.ceu.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cdj = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.ceu != null) {
                        MultiImageView.this.ceu.setCurrentView(null);
                    }
                    MultiImageView.this.eu(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.aqJ();
                    if (MultiImageView.this.ceu != null) {
                        MultiImageView.this.ceu.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cdi != null) {
                        MultiImageView.this.cdi.a(imageView);
                    }
                }
                urlDragImageView.akv();
                urlDragImageView.aku();
                urlDragImageView.o(MultiImageView.this.cdt, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cev != null) {
            return this.cev.getCount();
        }
        return 0;
    }

    public void hM(int i) {
        if (this.mSkinType != i && this.ceu != null) {
            int childCount = this.ceu.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ceu.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.ceu != null && this.ceu.getCurrentView() != null) {
            if (this.cey) {
                int childCount = this.ceu.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.ceu.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.ceu.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.ceu.findViewWithTag(String.valueOf(this.ceu.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).o(this.cdt, true);
            }
            this.ceu.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.ceu != null && this.ceu.getCurrentView() != null) {
            this.ceu.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.ceu != null) {
            int childCount = this.ceu.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ceu.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.ceE != null) {
            this.ceE.setAssistUrl(imageUrlData);
            if (this.ceD || imageUrlData == null) {
                eu(false);
            } else if (!this.ceE.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jb(int i) {
        if (this.ceu != null) {
            View findViewWithTag = this.ceu.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eu(false);
            }
        }
    }

    public void jc(int i) {
        View findViewWithTag;
        if (this.ceu != null && (findViewWithTag = this.ceu.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.o(this.cdt, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData oh = oh(str);
                urlDragImageView.setAssistUrl(oh);
                c(oh);
            }
            urlDragImageView.o(this.cdt, true);
        }
    }

    private ImageUrlData oh(String str) {
        if (TextUtils.isEmpty(str) || this.ceC == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.ceC.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jd(int i) {
        if (this.ceu == null) {
            return null;
        }
        View findViewWithTag = this.ceu.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void je(int i) {
        View findViewWithTag;
        if (this.ceu != null && (findViewWithTag = this.ceu.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).akz();
        }
    }

    private void initUI() {
        this.ceu = new GalleryViewPager(getContext());
        this.ceu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ceu.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.ceu);
        this.cet = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.cet.setOrientation(0);
        this.cet.setLayoutParams(layoutParams);
        addView(this.cet);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ces = new Button(getContext());
        al.e(this.ces, d.f.image_zoomout, 0);
        this.ces.setLayoutParams(layoutParams2);
        this.ces.setOnClickListener(this.mOnClickListener);
        this.ces.setEnabled(false);
        this.cet.addView(this.ces);
        this.cer = new Button(getContext());
        al.e(this.cer, d.f.image_zoomin, 0);
        this.cer.setLayoutParams(layoutParams2);
        this.cer.setOnClickListener(this.mOnClickListener);
        this.cer.setEnabled(false);
        this.cet.addView(this.cer);
        if (this.cez) {
            this.cet.setVisibility(8);
        }
        this.cev = new ImagePagerAdapter(getContext(), this.cdi);
        this.cev.a(this.cdj);
        setAdapter(this.cev);
        this.ceE = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cev != null) {
            this.cev.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cev != null) {
            this.cev.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cew = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cev == null) {
            return 0;
        }
        return this.cev.getCount();
    }

    public int getCurrentItem() {
        if (this.ceu == null) {
            return 0;
        }
        return this.ceu.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.ceu == null) {
            return null;
        }
        View findViewWithTag = this.ceu.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.cer.setEnabled(true);
            } else {
                this.cer.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.ces.setEnabled(true);
                return;
            } else {
                this.ces.setEnabled(false);
                return;
            }
        }
        this.ces.setEnabled(false);
        this.cer.setEnabled(false);
    }

    public void akk() {
        if (!this.cez) {
            this.cet.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.ceD = z;
        h(!z, i);
    }

    public boolean akl() {
        return this.ceD;
    }

    public void eu(boolean z) {
        if (this.ceE != null) {
            this.ceE.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.ceE != null) {
            this.ceE.af(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.ceu != null) {
            int childCount = this.ceu.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ceu.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.ceE != null) {
                this.ceE.setUserId(str);
            }
        }
    }

    public void akm() {
        if (!this.cez) {
            this.cet.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.ceu == null) {
            return null;
        }
        return this.ceu.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.ceu != null) {
            this.ceu.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.ceu != null) {
            this.ceu.setOffscreenPageLimit(i);
            this.cex = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cex = (int) (this.cex * 0.8d);
            if (this.cex < 6291456) {
                this.cey = true;
                this.cex = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cey = false;
            }
            PagerAdapter adapter = this.ceu.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cex);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cdh);
        }
        if (this.ceu != null) {
            this.ceu.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cev);
        if (this.ceu != null) {
            this.ceu.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cev != null) {
            this.cev.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cev != null) {
            this.cev.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cev != null) {
            this.cev.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cev != null) {
            this.cev.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cev != null) {
            this.cev.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.ceB = arrayList;
        if (this.cev != null) {
            this.cev.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ceC = map;
        if (this.cev != null) {
            this.cev.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cev != null) {
            this.cev.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cev == null) {
            return false;
        }
        return this.cev.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cev != null) {
            this.cev.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.ceu == null || (currentView = this.ceu.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cev != null) {
            this.cev.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        if (this.ceu == null) {
            return null;
        }
        DragImageView currentView = this.ceu.getCurrentView();
        if (currentView.getTag() instanceof String) {
            return (String) currentView.getTag();
        }
        return null;
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.ceu != null) {
            this.ceu.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdt = z;
        if (this.cev != null) {
            this.cev.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cev != null) {
            this.cev.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cev != null) {
            this.cev.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cev != null) {
            this.cev.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cev != null) {
            this.cev.setOriImgSelectedCallback(bVar);
        }
    }
}
