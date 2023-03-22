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
import com.baidu.tieba.hi;
import com.baidu.tieba.q95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class MultiImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Button b;
    public Button c;
    public LinearLayout d;
    public GalleryViewPager e;
    public ImagePagerAdapter f;
    public View.OnClickListener g;
    public DragImageView.i h;
    public ViewPager.OnPageChangeListener i;
    public ViewPager.OnPageChangeListener j;
    public DragImageView.k k;
    public ImagePagerAdapter.b l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ArrayList<String> r;
    public Map<String, ImageUrlData> s;
    public boolean t;
    public boolean u;
    public q95 v;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public a(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            DragImageView currentImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.b) {
                    if (view2 == this.a.c && (currentImageView = this.a.getCurrentImageView()) != null) {
                        currentImageView.u0();
                        return;
                    }
                    return;
                }
                DragImageView currentImageView2 = this.a.getCurrentImageView();
                if (currentImageView2 != null) {
                    currentImageView2.t0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public b(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.j != null) {
                this.a.j.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.a.j != null) {
                this.a.j.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int i2 = i + 1;
                if (i2 > this.a.q) {
                    this.a.q = i2;
                }
                if (this.a.e != null) {
                    int childCount = this.a.e.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = this.a.e.getChildAt(i3);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            ((UrlDragImageView) childAt).f0();
                        }
                    }
                }
                if (this.a.j != null) {
                    this.a.j.onPageSelected(i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.e != null && this.a.e.getCurrentView() == dragImageView) {
                this.a.setZoomButton(dragImageView);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, dragImageView) == null) && this.a.e != null && dragImageView == this.a.e.getCurrentView()) {
                if (this.a.n) {
                    int childCount = this.a.e.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.a.e.getChildAt(i);
                        if (childAt != null && (childAt instanceof UrlDragImageView)) {
                            UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                            if (urlDragImageView.getImageView() != dragImageView) {
                                urlDragImageView.Z();
                            }
                        }
                    }
                }
                dragImageView.h0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.b
        public void a(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, obj) == null) {
                if (obj instanceof UrlDragImageView) {
                    UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                    DragImageView imageView = urlDragImageView.getImageView();
                    if (imageView != null) {
                        imageView.p0();
                        if (this.a.e != null) {
                            this.a.e.setCurrentView(imageView);
                        }
                        if (imageView.getImageType() == 1 && this.a.h != null) {
                            this.a.h.a(imageView);
                        }
                    }
                    urlDragImageView.F();
                    urlDragImageView.H();
                    urlDragImageView.D(this.a.p, true);
                    this.a.A(urlDragImageView.getmAssistUrlData());
                    return;
                }
                if (this.a.e != null) {
                    this.a.e.setCurrentView(null);
                }
                this.a.B(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = null;
        this.t = false;
        this.u = true;
        q();
    }

    public void v(int i) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048634, this, i) == null) && (galleryViewPager = this.e) != null && (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.D(this.p, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData n = n(str);
                urlDragImageView.setAssistUrl(n);
                A(n);
            }
            urlDragImageView.D(this.p, true);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = null;
        this.t = false;
        this.u = true;
        q();
    }

    public void setOffscreenPageLimit(int i, int i2) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048616, this, i, i2) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        galleryViewPager.setOffscreenPageLimit(i);
        int bitmapMaxMemory = UtilHelper.getBitmapMaxMemory(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.m = bitmapMaxMemory;
        int i3 = (int) (bitmapMaxMemory * 0.8d);
        this.m = i3;
        if (i3 < 6291456) {
            this.n = true;
            this.m = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.n = false;
        }
        PagerAdapter adapter = this.e.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).m(this.m);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = null;
        this.t = false;
        this.u = true;
        q();
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, imagePagerAdapter) == null) {
            if (imagePagerAdapter != null) {
                imagePagerAdapter.x(this.k);
            }
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager != null) {
                galleryViewPager.setAdapter(imagePagerAdapter);
            }
        }
    }

    public void B(boolean z) {
        q95 q95Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (q95Var = this.v) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            q95Var.o(i);
        }
    }

    public void k(ImagePagerAdapter.a aVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.b(aVar);
        }
    }

    public void l(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048594, this, i) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            A(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
        } else {
            B(false);
        }
    }

    public void m(int i) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (galleryViewPager = this.e) != null && (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).I();
        }
    }

    public String o(int i) {
        InterceptResult invokeI;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
                return null;
            }
            return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
        }
        return (String) invokeI.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setAddSize(int i) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.h(i);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.p = z;
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.i(z);
            }
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, map) == null) {
            this.s = map;
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.j(map);
            }
        }
    }

    public void setCurrentImageQRInfo(String str) {
        GalleryViewPager galleryViewPager;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, str) != null) || (galleryViewPager = this.e) == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return;
        }
        imageUrlData.qrInfo = str;
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, hVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.l(hVar);
        }
    }

    public void setHasNext(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.n(z);
        }
    }

    public void setHeadImage(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.o(z);
        }
    }

    public void setIsCanDrag(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.p(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.q(z);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, onLongClickListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.t(onLongClickListener);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, onClickListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.s(onClickListener);
        }
    }

    public void setNextTitle(String str) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, str) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.r(str);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) && (q95Var = this.v) != null) {
            q95Var.k(bVar);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onPageChangeListener) == null) {
            this.j = onPageChangeListener;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, onClickListener) == null) && (q95Var = this.v) != null) {
            q95Var.l(onClickListener);
        }
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, aVar) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setOnFlipOutListener(aVar);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, cVar) == null) && (q95Var = this.v) != null) {
            q95Var.m(cVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.p pVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, pVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.y(pVar);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, onTouchListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.z(onTouchListener);
        }
    }

    public void setPageMargin(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048624, this, i) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setPageMargin(i);
        }
    }

    public void setShowBottomContainer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.u = z;
            B(z);
        }
    }

    public void setTempSize(int i) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048626, this, i) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.A(i);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, arrayList) == null) {
            this.r = arrayList;
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.k(arrayList);
            }
        }
    }

    public void setViewPagerTouchListener(View.OnTouchListener onTouchListener) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, onTouchListener) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setOnTouchListener(onTouchListener);
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && (q95Var = this.v) != null) {
            q95Var.q(z);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setAdapter(this.f);
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager != null) {
                galleryViewPager.setCurrentItem(i, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null) {
                return null;
            }
            return galleryViewPager.getCurrentView();
        }
        return (DragImageView) invokeV.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.o) {
            return;
        }
        this.d.setVisibility(0);
    }

    public int getBottomHeight() {
        InterceptResult invokeV;
        q95 q95Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.u && (q95Var = this.v) != null) {
                return q95Var.c();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getCurrentImageQRInfo() {
        InterceptResult invokeV;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
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
            GalleryViewPager galleryViewPager = this.e;
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
            GalleryViewPager galleryViewPager = this.e;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public String getCurrentOriginalUrl() {
        InterceptResult invokeV;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
                return null;
            }
            return imageUrlData.originalUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentPicId() {
        InterceptResult invokeV;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
                return null;
            }
            return imageUrlData.picId;
        }
        return (String) invokeV.objValue;
    }

    public UrlDragImageView getCurrentUrlDragImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.e == null) {
                return null;
            }
            View findViewWithTag = this.e.findViewWithTag(String.valueOf(getCurrentItem()));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter == null) {
                return false;
            }
            return imagePagerAdapter.e();
        }
        return invokeV.booleanValue;
    }

    public int getItemNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                return imagePagerAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.o) {
            return;
        }
        this.d.setVisibility(8);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.o = UtilHelper.isSupportGesture(getContext());
            r();
            s();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            q95 q95Var = this.v;
            if (q95Var == null) {
                return false;
            }
            return q95Var.g();
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.e.getChildAt(i);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).Y();
            }
        }
    }

    public void x() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (galleryViewPager = this.e) != null && galleryViewPager.getCurrentView() != null) {
            this.e.getCurrentView().g0();
        }
    }

    public void A(ImageUrlData imageUrlData) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, imageUrlData) == null) && (q95Var = this.v) != null) {
            q95Var.j(imageUrlData);
            if (!this.t && imageUrlData != null) {
                if (!this.v.g()) {
                    this.v.r(false);
                }
                if (!this.v.h()) {
                    C(true, 150);
                    return;
                }
                return;
            }
            B(false);
        }
    }

    public final ImageUrlData n(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (map = this.s) != null) {
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

    public void setUserId(String str) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, str) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.e.getChildAt(i);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).setUserId(str);
            }
        }
        q95 q95Var = this.v;
        if (q95Var != null) {
            q95Var.n(str);
        }
    }

    public void setZoomButton(DragImageView dragImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dragImageView) == null) {
            if (dragImageView != null) {
                if (dragImageView.Q()) {
                    this.b.setEnabled(true);
                } else {
                    this.b.setEnabled(false);
                }
                if (dragImageView.R()) {
                    this.c.setEnabled(true);
                    return;
                } else {
                    this.c.setEnabled(false);
                    return;
                }
            }
            this.c.setEnabled(false);
            this.b.setEnabled(false);
        }
    }

    public void z(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048638, this, i) != null) || this.a == i || (galleryViewPager = this.e) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.e.getChildAt(i2);
            if (childAt instanceof UrlDragImageView) {
                ((UrlDragImageView) childAt).X(i);
            }
        }
        this.a = i;
    }

    public void C(boolean z, int i) {
        q95 q95Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && this.u && (q95Var = this.v) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            q95Var.p(i2, i);
        }
    }

    public byte[] getCurrentImageData() {
        InterceptResult invokeV;
        DragImageView currentView;
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null || (currentView = galleryViewPager.getCurrentView()) == null) {
                return null;
            }
            byte[] imageData = currentView.getImageData();
            if (imageData == null && currentView.getImageType() != 2 && (imageBitmap = currentView.getImageBitmap()) != null) {
                return BitmapHelper.Bitmap2Bytes(imageBitmap, 100);
            }
            return imageData;
        }
        return (byte[]) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = new a(this);
            this.i = new b(this);
            this.k = new c(this);
            this.h = new d(this);
            this.l = new e(this);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.e = new GalleryViewPager(getContext());
            this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.e.setOnPageChangeListener(this.i);
            addView(this.e);
            this.d = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = hi.d(getContext(), 10.0f);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.d.setOrientation(0);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            Button button = new Button(getContext());
            this.c = button;
            SkinManager.setBackgroundResource(button, R.drawable.image_zoomout, 0);
            this.c.setLayoutParams(layoutParams2);
            this.c.setOnClickListener(this.g);
            this.c.setEnabled(false);
            this.d.addView(this.c);
            Button button2 = new Button(getContext());
            this.b = button2;
            SkinManager.setBackgroundResource(button2, R.drawable.image_zoomin, 0);
            this.b.setLayoutParams(layoutParams2);
            this.b.setOnClickListener(this.g);
            this.b.setEnabled(false);
            this.d.addView(this.b);
            if (this.o) {
                this.d.setVisibility(8);
            }
            ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getContext(), this.h);
            this.f = imagePagerAdapter;
            imagePagerAdapter.u(this.l);
            setAdapter(this.f);
            this.v = new q95(getContext(), this);
        }
    }

    public void y() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (galleryViewPager = this.e) != null && galleryViewPager.getCurrentView() != null) {
            if (this.n) {
                int childCount = this.e.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.e.getChildAt(i);
                    if (childAt != null && (childAt instanceof UrlDragImageView)) {
                        UrlDragImageView urlDragImageView = (UrlDragImageView) childAt;
                        if (urlDragImageView.getImageView() != this.e.getCurrentView()) {
                            urlDragImageView.Z();
                        }
                    }
                }
            }
            View findViewWithTag = this.e.findViewWithTag(String.valueOf(this.e.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
                UrlDragImageView urlDragImageView2 = (UrlDragImageView) findViewWithTag;
                if (urlDragImageView2.N()) {
                    this.f.notifyDataSetChanged();
                } else {
                    urlDragImageView2.D(this.p, true);
                }
            }
            if (this.e.getCurrentView() != null) {
                this.e.getCurrentView().h0();
            }
        }
    }
}
