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
    private DragImageView.g cdi;
    private DragImageView.e cdj;
    private ImagePagerAdapter.b cdk;
    private boolean cdu;
    private boolean ceA;
    private int ceB;
    private ArrayList<String> ceC;
    private Map<String, ImageUrlData> ceD;
    private boolean ceE;
    protected b ceF;
    private Button ces;
    private Button cet;
    private LinearLayout ceu;
    private GalleryViewPager cev;
    private ImagePagerAdapter cew;
    private ViewPager.OnPageChangeListener cex;
    private int cey;
    private boolean cez;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mSkinType;

    public int getCurrentMaxIndex() {
        return this.ceB;
    }

    public MultiImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.cew = null;
        this.mOnClickListener = null;
        this.cdj = null;
        this.mOnPageChangeListener = null;
        this.cex = null;
        this.cdi = null;
        this.cdk = null;
        this.cey = 0;
        this.cez = true;
        this.ceA = false;
        this.cdu = false;
        this.ceB = 1;
        this.ceC = null;
        this.ceD = null;
        this.ceE = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        if (this.cev != null) {
            this.cev.setOnFlipOutListener(aVar);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.cew = null;
        this.mOnClickListener = null;
        this.cdj = null;
        this.mOnPageChangeListener = null;
        this.cex = null;
        this.cdi = null;
        this.cdk = null;
        this.cey = 0;
        this.cez = true;
        this.ceA = false;
        this.cdu = false;
        this.ceB = 1;
        this.ceC = null;
        this.ceD = null;
        this.ceE = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ces = null;
        this.cet = null;
        this.ceu = null;
        this.cev = null;
        this.cew = null;
        this.mOnClickListener = null;
        this.cdj = null;
        this.mOnPageChangeListener = null;
        this.cex = null;
        this.cdi = null;
        this.cdk = null;
        this.cey = 0;
        this.cez = true;
        this.ceA = false;
        this.cdu = false;
        this.ceB = 1;
        this.ceC = null;
        this.ceD = null;
        this.ceE = false;
        init();
    }

    public void init() {
        this.ceA = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragImageView currentImageView;
                if (view == MultiImageView.this.ces) {
                    DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.aqH();
                    }
                } else if (view == MultiImageView.this.cet && (currentImageView = MultiImageView.this.getCurrentImageView()) != null) {
                    currentImageView.aqI();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (MultiImageView.this.cex != null) {
                    MultiImageView.this.cex.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (MultiImageView.this.cex != null) {
                    MultiImageView.this.cex.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i + 1 > MultiImageView.this.ceB) {
                    MultiImageView.this.ceB = i + 1;
                }
                if (MultiImageView.this.cev != null) {
                    int childCount = MultiImageView.this.cev.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = MultiImageView.this.cev.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).akx();
                        }
                    }
                }
                if (MultiImageView.this.cex != null) {
                    MultiImageView.this.cex.onPageSelected(i);
                }
            }
        };
        this.cdi = new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.3
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (MultiImageView.this.cev != null && MultiImageView.this.cev.getCurrentView() == dragImageView) {
                    MultiImageView.this.setZoomButton(dragImageView);
                }
            }
        };
        this.cdj = new DragImageView.e() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.4
            @Override // com.baidu.tbadk.widget.DragImageView.e
            public void a(DragImageView dragImageView) {
                if (MultiImageView.this.cev != null && dragImageView == MultiImageView.this.cev.getCurrentView()) {
                    if (MultiImageView.this.cez) {
                        int childCount = MultiImageView.this.cev.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = MultiImageView.this.cev.getChildAt(i);
                            if (childAt != null && (childAt instanceof UrlDragImageView) && ((UrlDragImageView) childAt).getImageView() != dragImageView) {
                                ((UrlDragImageView) childAt).release();
                            }
                        }
                    }
                    dragImageView.play();
                }
            }
        };
        this.cdk = new ImagePagerAdapter.b() { // from class: com.baidu.tbadk.coreExtra.view.MultiImageView.5
            @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
            public void c(int i, Object obj) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (MultiImageView.this.cev != null) {
                        MultiImageView.this.cev.setCurrentView(null);
                    }
                    MultiImageView.this.eu(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.aqJ();
                    if (MultiImageView.this.cev != null) {
                        MultiImageView.this.cev.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && MultiImageView.this.cdj != null) {
                        MultiImageView.this.cdj.a(imageView);
                    }
                }
                urlDragImageView.akv();
                urlDragImageView.aku();
                urlDragImageView.o(MultiImageView.this.cdu, true);
                MultiImageView.this.c(((UrlDragImageView) obj).getmAssistUrlData());
            }
        };
    }

    public int getPageCount() {
        if (this.cew != null) {
            return this.cew.getCount();
        }
        return 0;
    }

    public void hM(int i) {
        if (this.mSkinType != i && this.cev != null) {
            int childCount = this.cev.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cev.getChildAt(i2);
                if (childAt instanceof UrlDragImageView) {
                    ((UrlDragImageView) childAt).onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void onResume() {
        if (this.cev != null && this.cev.getCurrentView() != null) {
            if (this.cez) {
                int childCount = this.cev.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.cev.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.cev.getCurrentView()) {
                            urlDragImageView.release();
                        }
                    }
                }
            }
            View findViewWithTag = this.cev.findViewWithTag(String.valueOf(this.cev.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                ((UrlDragImageView) findViewWithTag).o(this.cdu, true);
            }
            this.cev.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.cev != null && this.cev.getCurrentView() != null) {
            this.cev.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.cev != null) {
            int childCount = this.cev.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cev.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).onDestroy();
                }
            }
        }
    }

    public void c(ImageUrlData imageUrlData) {
        if (this.ceF != null) {
            this.ceF.setAssistUrl(imageUrlData);
            if (this.ceE || imageUrlData == null) {
                eu(false);
            } else if (!this.ceF.isShown()) {
                h(true, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            }
        }
    }

    public void jb(int i) {
        if (this.cev != null) {
            View findViewWithTag = this.cev.findViewWithTag(String.valueOf(i));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                c(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
            } else {
                eu(false);
            }
        }
    }

    public void jc(int i) {
        View findViewWithTag;
        if (this.cev != null && (findViewWithTag = this.cev.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.o(this.cdu, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData oh = oh(str);
                urlDragImageView.setAssistUrl(oh);
                c(oh);
            }
            urlDragImageView.o(this.cdu, true);
        }
    }

    private ImageUrlData oh(String str) {
        if (TextUtils.isEmpty(str) || this.ceD == null) {
            return null;
        }
        for (ImageUrlData imageUrlData : this.ceD.values()) {
            if (imageUrlData.imageUrl != null && imageUrlData.imageUrl.equals(str)) {
                return imageUrlData;
            }
        }
        return null;
    }

    public String jd(int i) {
        if (this.cev == null) {
            return null;
        }
        View findViewWithTag = this.cev.findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    public void je(int i) {
        View findViewWithTag;
        if (this.cev != null && (findViewWithTag = this.cev.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).akz();
        }
    }

    private void initUI() {
        this.cev = new GalleryViewPager(getContext());
        this.cev.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.cev.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.cev);
        this.ceu = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.dip2px(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.ceu.setOrientation(0);
        this.ceu.setLayoutParams(layoutParams);
        addView(this.ceu);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cet = new Button(getContext());
        al.e(this.cet, d.f.image_zoomout, 0);
        this.cet.setLayoutParams(layoutParams2);
        this.cet.setOnClickListener(this.mOnClickListener);
        this.cet.setEnabled(false);
        this.ceu.addView(this.cet);
        this.ces = new Button(getContext());
        al.e(this.ces, d.f.image_zoomin, 0);
        this.ces.setLayoutParams(layoutParams2);
        this.ces.setOnClickListener(this.mOnClickListener);
        this.ces.setEnabled(false);
        this.ceu.addView(this.ces);
        if (this.ceA) {
            this.ceu.setVisibility(8);
        }
        this.cew = new ImagePagerAdapter(getContext(), this.cdj);
        this.cew.a(this.cdk);
        setAdapter(this.cew);
        this.ceF = new b(getContext(), this);
    }

    public void setIsCanDrag(boolean z) {
        if (this.cew != null) {
            this.cew.setIsCanDrag(z);
        }
    }

    public void setIsHotSort(boolean z) {
        if (this.cew != null) {
            this.cew.setIsHotSort(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cex = onPageChangeListener;
    }

    public int getItemNum() {
        if (this.cew == null) {
            return 0;
        }
        return this.cew.getCount();
    }

    public int getCurrentItem() {
        if (this.cev == null) {
            return 0;
        }
        return this.cev.getCurrentItem();
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.cev == null) {
            return null;
        }
        View findViewWithTag = this.cev.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.canZoomIn()) {
                this.ces.setEnabled(true);
            } else {
                this.ces.setEnabled(false);
            }
            if (dragImageView.canZoomOut()) {
                this.cet.setEnabled(true);
                return;
            } else {
                this.cet.setEnabled(false);
                return;
            }
        }
        this.cet.setEnabled(false);
        this.ces.setEnabled(false);
    }

    public void akk() {
        if (!this.ceA) {
            this.ceu.setVisibility(0);
        }
    }

    public void g(boolean z, int i) {
        this.ceE = z;
        h(!z, i);
    }

    public boolean akl() {
        return this.ceE;
    }

    public void eu(boolean z) {
        if (this.ceF != null) {
            this.ceF.setVisibility(z ? 0 : 8);
        }
    }

    public void h(boolean z, int i) {
        if (this.ceF != null) {
            this.ceF.af(z ? 0 : 8, i);
        }
    }

    public void setUserId(String str) {
        if (this.cev != null) {
            int childCount = this.cev.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cev.getChildAt(i);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    ((UrlDragImageView) childAt).setUserId(str);
                }
            }
            if (this.ceF != null) {
                this.ceF.setUserId(str);
            }
        }
    }

    public void akm() {
        if (!this.ceA) {
            this.ceu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        if (this.cev == null) {
            return null;
        }
        return this.cev.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        if (this.cev != null) {
            this.cev.setPageMargin(i);
        }
    }

    public void setOffscreenPageLimit(int i, int i2) {
        if (this.cev != null) {
            this.cev.setOffscreenPageLimit(i);
            this.cey = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
            this.cey = (int) (this.cey * 0.8d);
            if (this.cey < 6291456) {
                this.cez = true;
                this.cey = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
            } else {
                this.cez = false;
            }
            PagerAdapter adapter = this.cev.getAdapter();
            if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
                ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.cey);
            }
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.setOnSizeChangedListener(this.cdi);
        }
        if (this.cev != null) {
            this.cev.setAdapter(imagePagerAdapter);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        setAdapter(this.cew);
        if (this.cev != null) {
            this.cev.setCurrentItem(i, z);
        }
    }

    public void setTempSize(int i) {
        if (this.cew != null) {
            this.cew.setTempSize(i);
        }
    }

    public void setAddSize(int i) {
        if (this.cew != null) {
            this.cew.setAddSize(i);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (this.cew != null) {
            this.cew.setOnClickListener(onClickListener);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cew != null) {
            this.cew.a(onTouchListener);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.cew != null) {
            this.cew.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.ceC = arrayList;
        if (this.cew != null) {
            this.cew.setData(arrayList);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ceD = map;
        if (this.cew != null) {
            this.cew.setAssistUrls(map);
        }
    }

    public void setHasNext(boolean z) {
        if (this.cew != null) {
            this.cew.setHasNext(z);
        }
    }

    public boolean getHasNext() {
        if (this.cew == null) {
            return false;
        }
        return this.cew.getHasNext();
    }

    public void setNextTitle(String str) {
        if (this.cew != null) {
            this.cew.setNextTitle(str);
        }
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        if (this.cev == null || (currentView = this.cev.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
            return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return imageData;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        if (this.cew != null) {
            this.cew.a(dVar);
        }
    }

    public String getCurrentImageUrl() {
        if (this.cev == null) {
            return null;
        }
        DragImageView currentView = this.cev.getCurrentView();
        if (currentView.getTag() instanceof String) {
            return (String) currentView.getTag();
        }
        return null;
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        if (this.cev != null) {
            this.cev.setOnTouchListener(onTouchListener);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.cdu = z;
        if (this.cew != null) {
            this.cew.setAllowLocalUrl(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        if (this.cew != null) {
            this.cew.setIsCdn(z);
        }
    }

    public void setHeadImage(boolean z) {
        if (this.cew != null) {
            this.cew.setHeadImage(z);
        }
    }

    public void a(ImagePagerAdapter.a aVar) {
        if (this.cew != null) {
            this.cew.a(aVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.b bVar) {
        if (this.cew != null) {
            this.cew.setOriImgSelectedCallback(bVar);
        }
    }
}
