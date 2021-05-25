package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12656e;

    /* renamed from: f  reason: collision with root package name */
    public Button f12657f;

    /* renamed from: g  reason: collision with root package name */
    public Button f12658g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12659h;

    /* renamed from: i  reason: collision with root package name */
    public GalleryViewPager f12660i;
    public ImagePagerAdapter j;
    public View.OnClickListener k;
    public DragImageView.i l;
    public ViewPager.OnPageChangeListener m;
    public ViewPager.OnPageChangeListener n;
    public DragImageView.k o;
    public ImagePagerAdapter.b p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public ArrayList<String> v;
    public Map<String, ImageUrlData> w;
    public boolean x;
    public boolean y;
    public d.a.m0.s.i.a z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragImageView currentImageView;
            if (view == MultiImageView.this.f12657f) {
                DragImageView currentImageView2 = MultiImageView.this.getCurrentImageView();
                if (currentImageView2 != null) {
                    currentImageView2.t0();
                }
            } else if (view != MultiImageView.this.f12658g || (currentImageView = MultiImageView.this.getCurrentImageView()) == null) {
            } else {
                currentImageView.u0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (MultiImageView.this.n != null) {
                MultiImageView.this.n.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (MultiImageView.this.n != null) {
                MultiImageView.this.n.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3 = i2 + 1;
            if (i3 > MultiImageView.this.u) {
                MultiImageView.this.u = i3;
            }
            if (MultiImageView.this.f12660i != null) {
                int childCount = MultiImageView.this.f12660i.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = MultiImageView.this.f12660i.getChildAt(i4);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        ((UrlDragImageView) childAt).e0();
                    }
                }
            }
            if (MultiImageView.this.n != null) {
                MultiImageView.this.n.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DragImageView.k {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            if (MultiImageView.this.f12660i == null || MultiImageView.this.f12660i.getCurrentView() != dragImageView) {
                return;
            }
            MultiImageView.this.setZoomButton(dragImageView);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DragImageView.i {
        public d() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.i
        public void a(DragImageView dragImageView) {
            if (MultiImageView.this.f12660i == null || dragImageView != MultiImageView.this.f12660i.getCurrentView()) {
                return;
            }
            if (MultiImageView.this.r) {
                int childCount = MultiImageView.this.f12660i.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = MultiImageView.this.f12660i.getChildAt(i2);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != dragImageView) {
                            urlDragImageView.Y();
                        }
                    }
                }
            }
            dragImageView.h0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ImagePagerAdapter.b {
        public e() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
        public void a(int i2, Object obj) {
            if (!(obj instanceof UrlDragImageView)) {
                if (MultiImageView.this.f12660i != null) {
                    MultiImageView.this.f12660i.setCurrentView(null);
                }
                MultiImageView.this.A(false);
                return;
            }
            UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
            DragImageView imageView = urlDragImageView.getImageView();
            if (imageView != null) {
                imageView.p0();
                if (MultiImageView.this.f12660i != null) {
                    MultiImageView.this.f12660i.setCurrentView(imageView);
                }
                if (imageView.getImageType() == 1 && MultiImageView.this.l != null) {
                    MultiImageView.this.l.a(imageView);
                }
            }
            urlDragImageView.F();
            urlDragImageView.H();
            urlDragImageView.D(MultiImageView.this.t, true);
            MultiImageView.this.z(urlDragImageView.getmAssistUrlData());
        }
    }

    public MultiImageView(Context context) {
        super(context);
        this.f12656e = 3;
        this.f12657f = null;
        this.f12658g = null;
        this.f12659h = null;
        this.f12660i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 1;
        this.w = null;
        this.x = false;
        this.y = true;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return null;
        }
        return galleryViewPager.getCurrentView();
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        if (imagePagerAdapter != null) {
            imagePagerAdapter.v(this.o);
        }
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager != null) {
            galleryViewPager.setAdapter(imagePagerAdapter);
        }
    }

    public void A(boolean z) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.n(z ? 0 : 8);
        }
    }

    public void B(boolean z, int i2) {
        d.a.m0.s.i.a aVar;
        if (this.y && (aVar = this.z) != null) {
            aVar.o(z ? 0 : 8, i2);
        }
    }

    public void C() {
        if (this.s) {
            return;
        }
        this.f12659h.setVisibility(0);
    }

    public int getBottomHeight() {
        d.a.m0.s.i.a aVar;
        if (!this.y || (aVar = this.z) == null) {
            return 0;
        }
        return aVar.c();
    }

    public byte[] getCurrentImageData() {
        DragImageView currentView;
        Bitmap imageBitmap;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null) {
            return null;
        }
        byte[] imageData = currentView.getImageData();
        return (imageData != null || currentView.getImageType() == 2 || (imageBitmap = currentView.getImageBitmap()) == null) ? imageData : BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
    }

    public String getCurrentImageQRInfo() {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return null;
        }
        return imageUrlData.qrInfo;
    }

    public String getCurrentImageUrl() {
        DragImageView currentView;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
            return null;
        }
        return (String) currentView.getTag();
    }

    public int getCurrentItem() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return 0;
        }
        return galleryViewPager.getCurrentItem();
    }

    public int getCurrentMaxIndex() {
        return this.u;
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        if (this.f12660i == null) {
            return null;
        }
        View findViewWithTag = this.f12660i.findViewWithTag(String.valueOf(getCurrentItem()));
        if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return (UrlDragImageView) findViewWithTag;
    }

    public DragImageView getCurrentView() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return null;
        }
        return galleryViewPager.getCurrentView();
    }

    public boolean getHasNext() {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter == null) {
            return false;
        }
        return imagePagerAdapter.e();
    }

    public int getItemNum() {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter == null) {
            return 0;
        }
        return imagePagerAdapter.getCount();
    }

    public int getPageCount() {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            return imagePagerAdapter.getCount();
        }
        return 0;
    }

    public void k(ImagePagerAdapter.a aVar) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.b(aVar);
        }
    }

    public void l(int i2) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return;
        }
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            z(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
        } else {
            A(false);
        }
    }

    public void m(int i2) {
        View findViewWithTag;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return;
        }
        ((UrlDragImageView) findViewWithTag).I();
    }

    public final ImageUrlData n(String str) {
        Map<String, ImageUrlData> map;
        if (!TextUtils.isEmpty(str) && (map = this.w) != null) {
            for (ImageUrlData imageUrlData : map.values()) {
                String str2 = imageUrlData.imageUrl;
                if (str2 != null && str2.equals(str)) {
                    return imageUrlData;
                }
            }
        }
        return null;
    }

    public String o(int i2) {
        View findViewWithTag;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return null;
        }
        return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (this.s) {
            return;
        }
        this.f12659h.setVisibility(8);
    }

    public void q() {
        this.s = UtilHelper.isSupportGesture(getContext());
        r();
        s();
    }

    public final void r() {
        this.k = new a();
        this.m = new b();
        this.o = new c();
        this.l = new d();
        this.p = new e();
    }

    public final void s() {
        this.f12660i = new GalleryViewPager(getContext());
        this.f12660i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f12660i.setOnPageChangeListener(this.m);
        addView(this.f12660i);
        this.f12659h = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = l.e(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.f12659h.setOrientation(0);
        this.f12659h.setLayoutParams(layoutParams);
        addView(this.f12659h);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        Button button = new Button(getContext());
        this.f12658g = button;
        SkinManager.setBackgroundResource(button, R.drawable.image_zoomout, 0);
        this.f12658g.setLayoutParams(layoutParams2);
        this.f12658g.setOnClickListener(this.k);
        this.f12658g.setEnabled(false);
        this.f12659h.addView(this.f12658g);
        Button button2 = new Button(getContext());
        this.f12657f = button2;
        SkinManager.setBackgroundResource(button2, R.drawable.image_zoomin, 0);
        this.f12657f.setLayoutParams(layoutParams2);
        this.f12657f.setOnClickListener(this.k);
        this.f12657f.setEnabled(false);
        this.f12659h.addView(this.f12657f);
        if (this.s) {
            this.f12659h.setVisibility(8);
        }
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getContext(), this.l);
        this.j = imagePagerAdapter;
        imagePagerAdapter.u(this.p);
        setAdapter(this.j);
        this.z = new d.a.m0.s.i.a(getContext(), this);
    }

    public void setAddSize(int i2) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.h(i2);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.t = z;
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.i(z);
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.w = map;
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.j(map);
        }
    }

    public void setCurrentImageQRInfo(String str) {
        DragImageView currentView;
        ImageUrlData imageUrlData;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return;
        }
        imageUrlData.qrInfo = str;
    }

    public void setCurrentItem(int i2, boolean z) {
        setAdapter(this.j);
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager != null) {
            galleryViewPager.setCurrentItem(i2, z);
        }
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.l(hVar);
        }
    }

    public void setHasNext(boolean z) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.n(z);
        }
    }

    public void setHeadImage(boolean z) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.o(z);
        }
    }

    public void setIsCanDrag(boolean z) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.p(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.q(z);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.t(onLongClickListener);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.s(onClickListener);
        }
    }

    public void setNextTitle(String str) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.r(str);
        }
    }

    public void setOffscreenPageLimit(int i2, int i3) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return;
        }
        galleryViewPager.setOffscreenPageLimit(i2);
        int bitmapMaxMemory = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i2 * 2) + 1) * i3) * 2);
        this.q = bitmapMaxMemory;
        int i4 = (int) (bitmapMaxMemory * 0.8d);
        this.q = i4;
        if (i4 < 6291456) {
            this.r = true;
            this.q = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.r = false;
        }
        PagerAdapter adapter = this.f12660i.getAdapter();
        if (adapter == null || !(adapter instanceof ImagePagerAdapter)) {
            return;
        }
        ((ImagePagerAdapter) adapter).m(this.q);
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.j(bVar);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.n = onPageChangeListener;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.k(onClickListener);
        }
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager != null) {
            galleryViewPager.setOnFlipOutListener(aVar);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.l(cVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.p pVar) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.w(pVar);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.x(onTouchListener);
        }
    }

    public void setPageMargin(int i2) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager != null) {
            galleryViewPager.setPageMargin(i2);
        }
    }

    public void setShowBottomContainer(boolean z) {
        this.y = z;
        A(z);
    }

    public void setTempSize(int i2) {
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.y(i2);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        this.v = arrayList;
        ImagePagerAdapter imagePagerAdapter = this.j;
        if (imagePagerAdapter != null) {
            imagePagerAdapter.k(arrayList);
        }
    }

    public void setUserId(String str) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f12660i.getChildAt(i2);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).setUserId(str);
            }
        }
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.m(str);
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager != null) {
            galleryViewPager.setOnTouchListener(onTouchListener);
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.p(z);
        }
    }

    public void setZoomButton(DragImageView dragImageView) {
        if (dragImageView != null) {
            if (dragImageView.Q()) {
                this.f12657f.setEnabled(true);
            } else {
                this.f12657f.setEnabled(false);
            }
            if (dragImageView.R()) {
                this.f12658g.setEnabled(true);
                return;
            } else {
                this.f12658g.setEnabled(false);
                return;
            }
        }
        this.f12658g.setEnabled(false);
        this.f12657f.setEnabled(false);
    }

    public boolean t() {
        return this.x;
    }

    public void u(int i2) {
        View findViewWithTag;
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return;
        }
        UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
        ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
        if (imageUrlData == null) {
            urlDragImageView.D(this.t, true);
            return;
        }
        String str = imageUrlData.imageUrl;
        if (!StringUtils.isNull(str)) {
            ImageUrlData n = n(str);
            urlDragImageView.setAssistUrl(n);
            z(n);
        }
        urlDragImageView.D(this.t, true);
    }

    public void v() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f12660i.getChildAt(i2);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).X();
            }
        }
    }

    public void w() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || galleryViewPager.getCurrentView() == null) {
            return;
        }
        this.f12660i.getCurrentView().g0();
    }

    public void x() {
        GalleryViewPager galleryViewPager = this.f12660i;
        if (galleryViewPager == null || galleryViewPager.getCurrentView() == null) {
            return;
        }
        if (this.r) {
            int childCount = this.f12660i.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f12660i.getChildAt(i2);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                    if (urlDragImageView.getImageView() != this.f12660i.getCurrentView()) {
                        urlDragImageView.Y();
                    }
                }
            }
        }
        View findViewWithTag = this.f12660i.findViewWithTag(String.valueOf(this.f12660i.getCurrentItem()));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).D(this.t, true);
        }
        this.f12660i.getCurrentView().h0();
    }

    public void y(int i2) {
        GalleryViewPager galleryViewPager;
        if (this.f12656e == i2 || (galleryViewPager = this.f12660i) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f12660i.getChildAt(i3);
            if (childAt instanceof UrlDragImageView) {
                ((UrlDragImageView) childAt).W(i2);
            }
        }
        this.f12656e = i2;
    }

    public void z(ImageUrlData imageUrlData) {
        d.a.m0.s.i.a aVar = this.z;
        if (aVar != null) {
            aVar.i(imageUrlData);
            if (!this.x && imageUrlData != null) {
                if (!this.z.f()) {
                    this.z.q(false);
                }
                if (this.z.g()) {
                    return;
                }
                B(true, 150);
                return;
            }
            A(false);
        }
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12656e = 3;
        this.f12657f = null;
        this.f12658g = null;
        this.f12659h = null;
        this.f12660i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 1;
        this.w = null;
        this.x = false;
        this.y = true;
        q();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12656e = 3;
        this.f12657f = null;
        this.f12658g = null;
        this.f12659h = null;
        this.f12660i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 1;
        this.w = null;
        this.x = false;
        this.y = true;
        q();
    }
}
