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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes11.dex */
public class MultiImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40856e;

    /* renamed from: f  reason: collision with root package name */
    public Button f40857f;

    /* renamed from: g  reason: collision with root package name */
    public Button f40858g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f40859h;

    /* renamed from: i  reason: collision with root package name */
    public GalleryViewPager f40860i;

    /* renamed from: j  reason: collision with root package name */
    public ImagePagerAdapter f40861j;
    public View.OnClickListener k;
    public DragImageView.i l;
    public ViewPager.OnPageChangeListener m;
    public c.a.s0.t.i.a mImageViewerBottomController;
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

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageView f40862e;

        public a(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40862e = multiImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragImageView currentImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f40862e.f40857f) {
                    DragImageView currentImageView2 = this.f40862e.getCurrentImageView();
                    if (currentImageView2 != null) {
                        currentImageView2.zoomInBitmap();
                    }
                } else if (view != this.f40862e.f40858g || (currentImageView = this.f40862e.getCurrentImageView()) == null) {
                } else {
                    currentImageView.zoomOutBitmap();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageView f40863e;

        public b(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40863e = multiImageView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f40863e.n == null) {
                return;
            }
            this.f40863e.n.onPageScrollStateChanged(i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f40863e.n == null) {
                return;
            }
            this.f40863e.n.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = i2 + 1;
                if (i3 > this.f40863e.u) {
                    this.f40863e.u = i3;
                }
                if (this.f40863e.f40860i != null) {
                    int childCount = this.f40863e.f40860i.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = this.f40863e.f40860i.getChildAt(i4);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).stopGif();
                        }
                    }
                }
                if (this.f40863e.n != null) {
                    this.f40863e.n.onPageSelected(i2);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public c(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.f40860i != null && this.a.f40860i.getCurrentView() == dragImageView) {
                this.a.setZoomButton(dragImageView);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements DragImageView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public d(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.i
        public void a(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dragImageView) == null) && this.a.f40860i != null && dragImageView == this.a.f40860i.getCurrentView()) {
                if (this.a.r) {
                    int childCount = this.a.f40860i.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.a.f40860i.getChildAt(i2);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                            if (urlDragImageView.getImageView() != dragImageView) {
                                urlDragImageView.release();
                            }
                        }
                    }
                }
                dragImageView.play();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements ImagePagerAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public e(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
        public void a(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) {
                if (!(obj instanceof UrlDragImageView)) {
                    if (this.a.f40860i != null) {
                        this.a.f40860i.setCurrentView(null);
                    }
                    this.a.showBottomVisibility(false);
                    return;
                }
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                DragImageView imageView = urlDragImageView.getImageView();
                if (imageView != null) {
                    imageView.restoreSize();
                    if (this.a.f40860i != null) {
                        this.a.f40860i.setCurrentView(imageView);
                    }
                    if (imageView.getImageType() == 1 && this.a.l != null) {
                        this.a.l.a(imageView);
                    }
                }
                urlDragImageView.checkOriginalImg();
                urlDragImageView.checkThumbImage();
                urlDragImageView.checkImage(this.a.t, true);
                this.a.refreshImageViewerBottomView(urlDragImageView.getmAssistUrlData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40856e = 3;
        this.f40857f = null;
        this.f40858g = null;
        this.f40859h = null;
        this.f40860i = null;
        this.f40861j = null;
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
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null) {
                return null;
            }
            return galleryViewPager.getCurrentView();
        }
        return (DragImageView) invokeV.objValue;
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, imagePagerAdapter) == null) {
            if (imagePagerAdapter != null) {
                imagePagerAdapter.setOnSizeChangedListener(this.o);
            }
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager != null) {
                galleryViewPager.setAdapter(imagePagerAdapter);
            }
        }
    }

    public void addPageProvider(ImagePagerAdapter.a aVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.addPageProvider(aVar);
    }

    public void checkBottomViewVisibility(int i2) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            refreshImageViewerBottomView(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
        } else {
            showBottomVisibility(false);
        }
    }

    public void downloadOriginImgAtIndex(int i2) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (galleryViewPager = this.f40860i) == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return;
        }
        ((UrlDragImageView) findViewWithTag).downloadOriginPic();
    }

    public int getBottomHeight() {
        InterceptResult invokeV;
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.y || (aVar = this.mImageViewerBottomController) == null) {
                return 0;
            }
            return aVar.c();
        }
        return invokeV.intValue;
    }

    public String getCheckOriginImgStringAtIndex(int i2) {
        InterceptResult invokeI;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
                return null;
            }
            return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
        }
        return (String) invokeI.objValue;
    }

    public byte[] getCurrentImageData() {
        InterceptResult invokeV;
        DragImageView currentView;
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null) {
                return null;
            }
            byte[] imageData = currentView.getImageData();
            return (imageData != null || currentView.getImageType() == 2 || (imageBitmap = currentView.getImageBitmap()) == null) ? imageData : BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
        }
        return (byte[]) invokeV.objValue;
    }

    public String getCurrentImageQRInfo() {
        InterceptResult invokeV;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
                return null;
            }
            return imageUrlData.qrInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentImageUrl() {
        InterceptResult invokeV;
        DragImageView currentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || !(currentView.getTag() instanceof String)) {
                return null;
            }
            return (String) currentView.getTag();
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null) {
                return 0;
            }
            return galleryViewPager.getCurrentItem();
        }
        return invokeV.intValue;
    }

    public int getCurrentMaxIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.u : invokeV.intValue;
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f40860i == null) {
                return null;
            }
            View findViewWithTag = this.f40860i.findViewWithTag(String.valueOf(getCurrentItem()));
            if (findViewWithTag == null || !(findViewWithTag instanceof UrlDragImageView)) {
                return null;
            }
            return (UrlDragImageView) findViewWithTag;
        }
        return (UrlDragImageView) invokeV.objValue;
    }

    public DragImageView getCurrentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager == null) {
                return null;
            }
            return galleryViewPager.getCurrentView();
        }
        return (DragImageView) invokeV.objValue;
    }

    public boolean getHasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter == null) {
                return false;
            }
            return imagePagerAdapter.getHasNext();
        }
        return invokeV.booleanValue;
    }

    public int getItemNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter == null) {
                return 0;
            }
            return imagePagerAdapter.getCount();
        }
        return invokeV.intValue;
    }

    public int getPageCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter != null) {
                return imagePagerAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void hideTools() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.s) {
            return;
        }
        this.f40859h.setVisibility(8);
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.s = UtilHelper.isSupportGesture(getContext());
            l();
            m();
        }
    }

    public boolean isClearScreenMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public final ImageUrlData k(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
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
        return (ImageUrlData) invokeL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k = new a(this);
            this.m = new b(this);
            this.o = new c(this);
            this.l = new d(this);
            this.p = new e(this);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f40860i = new GalleryViewPager(getContext());
            this.f40860i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f40860i.setOnPageChangeListener(this.m);
            addView(this.f40860i);
            this.f40859h = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = n.d(getContext(), 10.0f);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.f40859h.setOrientation(0);
            this.f40859h.setLayoutParams(layoutParams);
            addView(this.f40859h);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            Button button = new Button(getContext());
            this.f40858g = button;
            SkinManager.setBackgroundResource(button, R.drawable.image_zoomout, 0);
            this.f40858g.setLayoutParams(layoutParams2);
            this.f40858g.setOnClickListener(this.k);
            this.f40858g.setEnabled(false);
            this.f40859h.addView(this.f40858g);
            Button button2 = new Button(getContext());
            this.f40857f = button2;
            SkinManager.setBackgroundResource(button2, R.drawable.image_zoomin, 0);
            this.f40857f.setLayoutParams(layoutParams2);
            this.f40857f.setOnClickListener(this.k);
            this.f40857f.setEnabled(false);
            this.f40859h.addView(this.f40857f);
            if (this.s) {
                this.f40859h.setVisibility(8);
            }
            ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getContext(), this.l);
            this.f40861j = imagePagerAdapter;
            imagePagerAdapter.setOnPrimaryPageChangeListener(this.p);
            setAdapter(this.f40861j);
            this.mImageViewerBottomController = new c.a.s0.t.i.a(getContext(), this);
        }
    }

    public void notifyClearScreenMode(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.x = z;
            showBottomWithAlphaAnim(!z, i2);
        }
    }

    public void notifyItemDataChanged(int i2) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (galleryViewPager = this.f40860i) == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i2))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
            return;
        }
        UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
        ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
        if (imageUrlData == null) {
            urlDragImageView.checkImage(this.t, true);
            return;
        }
        String str = imageUrlData.imageUrl;
        if (!StringUtils.isNull(str)) {
            ImageUrlData k = k(str);
            urlDragImageView.setAssistUrl(k);
            refreshImageViewerBottomView(k);
        }
        urlDragImageView.checkImage(this.t, true);
    }

    public void onDestroy() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f40860i.getChildAt(i2);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).onDestroy();
            }
        }
    }

    public void onPause() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (galleryViewPager = this.f40860i) == null || galleryViewPager.getCurrentView() == null) {
            return;
        }
        this.f40860i.getCurrentView().pause();
    }

    public void onResume() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (galleryViewPager = this.f40860i) == null || galleryViewPager.getCurrentView() == null) {
            return;
        }
        if (this.r) {
            int childCount = this.f40860i.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f40860i.getChildAt(i2);
                if (childAt != null && (childAt instanceof UrlDragImageView)) {
                    UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                    if (urlDragImageView.getImageView() != this.f40860i.getCurrentView()) {
                        urlDragImageView.release();
                    }
                }
            }
        }
        View findViewWithTag = this.f40860i.findViewWithTag(String.valueOf(this.f40860i.getCurrentItem()));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).checkImage(this.t, true);
        }
        this.f40860i.getCurrentView().play();
    }

    public void onSkinTypeChanged(int i2) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.f40856e == i2 || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f40860i.getChildAt(i3);
            if (childAt instanceof UrlDragImageView) {
                ((UrlDragImageView) childAt).onChangeSkinType(i2);
            }
        }
        this.f40856e = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) ? super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public void refreshImageViewerBottomView(ImageUrlData imageUrlData) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, imageUrlData) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.i(imageUrlData);
        if (!this.x && imageUrlData != null) {
            if (!this.mImageViewerBottomController.f()) {
                this.mImageViewerBottomController.q(false);
            }
            if (this.mImageViewerBottomController.g()) {
                return;
            }
            showBottomWithAlphaAnim(true, 150);
            return;
        }
        showBottomVisibility(false);
    }

    public void setAddSize(int i2) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setAddSize(i2);
    }

    public void setAllowLocalUrl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.t = z;
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.setAllowLocalUrl(z);
            }
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, map) == null) {
            this.w = map;
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.setAssistUrls(map);
            }
        }
    }

    public void setCurrentImageQRInfo(String str) {
        GalleryViewPager galleryViewPager;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (galleryViewPager = this.f40860i) == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return;
        }
        imageUrlData.qrInfo = str;
    }

    public void setCurrentItem(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            setAdapter(this.f40861j);
            GalleryViewPager galleryViewPager = this.f40860i;
            if (galleryViewPager != null) {
                galleryViewPager.setCurrentItem(i2, z);
            }
        }
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, hVar) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setDrageToExitListener(hVar);
    }

    public void setHasNext(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setHasNext(z);
    }

    public void setHeadImage(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setHeadImage(z);
    }

    public void setIsCanDrag(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setIsCanDrag(z);
    }

    public void setIsFromCDN(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setIsCdn(z);
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, onLongClickListener) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setOnLongClickListener(onLongClickListener);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setOnClickListener(onClickListener);
    }

    public void setNextTitle(String str) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setNextTitle(str);
    }

    public void setOffscreenPageLimit(int i2, int i3) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048618, this, i2, i3) == null) || (galleryViewPager = this.f40860i) == null) {
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
        PagerAdapter adapter = this.f40860i.getAdapter();
        if (adapter == null || !(adapter instanceof ImagePagerAdapter)) {
            return;
        }
        ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.q);
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.j(bVar);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onPageChangeListener) == null) {
            this.n = onPageChangeListener;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.k(onClickListener);
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, aVar) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        galleryViewPager.setOnFlipOutListener(aVar);
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, cVar) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.l(cVar);
    }

    public void setOriImgSelectedCallback(UrlDragImageView.p pVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, pVar) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setOriImgSelectedCallback(pVar);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, onTouchListener) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setOuterTouchListener(onTouchListener);
    }

    public void setPageMargin(int i2) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        galleryViewPager.setPageMargin(i2);
    }

    public void setShowBottomContainer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.y = z;
            showBottomVisibility(z);
        }
    }

    public void setTempSize(int i2) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (imagePagerAdapter = this.f40861j) == null) {
            return;
        }
        imagePagerAdapter.setTempSize(i2);
    }

    public void setUrlData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, arrayList) == null) {
            this.v = arrayList;
            ImagePagerAdapter imagePagerAdapter = this.f40861j;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.setData(arrayList);
            }
        }
    }

    public void setUserId(String str) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f40860i.getChildAt(i2);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).setUserId(str);
            }
        }
        c.a.s0.t.i.a aVar = this.mImageViewerBottomController;
        if (aVar != null) {
            aVar.m(str);
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, onTouchListener) == null) || (galleryViewPager = this.f40860i) == null) {
            return;
        }
        galleryViewPager.setOnTouchListener(onTouchListener);
    }

    public void setYoungterCoverSomeView(boolean z) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.p(z);
    }

    public void setZoomButton(DragImageView dragImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, dragImageView) == null) {
            if (dragImageView != null) {
                if (dragImageView.canZoomIn()) {
                    this.f40857f.setEnabled(true);
                } else {
                    this.f40857f.setEnabled(false);
                }
                if (dragImageView.canZoomOut()) {
                    this.f40858g.setEnabled(true);
                    return;
                } else {
                    this.f40858g.setEnabled(false);
                    return;
                }
            }
            this.f40858g.setEnabled(false);
            this.f40857f.setEnabled(false);
        }
    }

    public void showBottomVisibility(boolean z) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048634, this, z) == null) || (aVar = this.mImageViewerBottomController) == null) {
            return;
        }
        aVar.n(z ? 0 : 8);
    }

    public void showBottomWithAlphaAnim(boolean z, int i2) {
        c.a.s0.t.i.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && this.y && (aVar = this.mImageViewerBottomController) != null) {
            aVar.o(z ? 0 : 8, i2);
        }
    }

    public void showTools() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.s) {
            return;
        }
        this.f40859h.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40856e = 3;
        this.f40857f = null;
        this.f40858g = null;
        this.f40859h = null;
        this.f40860i = null;
        this.f40861j = null;
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40856e = 3;
        this.f40857f = null;
        this.f40858g = null;
        this.f40859h = null;
        this.f40860i = null;
        this.f40861j = null;
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
        init();
    }
}
