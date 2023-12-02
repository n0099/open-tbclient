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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.LiveRoomEntranceButton;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dc5;
import com.baidu.tieba.mua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
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
    public dc5 v;
    public LiveRoomEntranceButton w;

    /* loaded from: classes5.dex */
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
                        currentImageView.v0();
                        return;
                    }
                    return;
                }
                DragImageView currentImageView2 = this.a.getCurrentImageView();
                if (currentImageView2 != null) {
                    currentImageView2.u0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                dragImageView.i0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                        imageView.q0();
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
                    ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
                    this.a.H(imageUrlData);
                    this.a.I(imageUrlData);
                    return;
                }
                if (this.a.e != null) {
                    this.a.e.setCurrentView(null);
                }
                this.a.J(false);
                if (this.a.w != null) {
                    this.a.w.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements LiveRoomEntranceButton.ClickCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageView a;

        public f(MultiImageView multiImageView) {
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

        @Override // com.baidu.tbadk.coreExtra.view.LiveRoomEntranceButton.ClickCallBack
        public void a(@NonNull LiveRoomEntranceButton.ClickCallBack.ClickType clickType, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, clickType, obj) == null) {
                if (clickType == LiveRoomEntranceButton.ClickCallBack.ClickType.CLOSE_CLICK) {
                    this.a.w.setVisibility(8);
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    sharedPrefHelper.putLong("key_live_room_entrance_show_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                }
                if (clickType == LiveRoomEntranceButton.ClickCallBack.ClickType.ENTER_CLICK && this.a.w.getLiveRoomEntranceData() != null) {
                    String a = this.a.w.getLiveRoomEntranceData().a();
                    if (!TextUtils.isEmpty(a)) {
                        this.a.B(a);
                    }
                }
                if (obj instanceof ImageUrlData) {
                    this.a.A((ImageUrlData) obj, CommonStatisticKey.KEY_LIVE_ROOM_ENTRANCE_CLICK, clickType.ordinal() + 1);
                }
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
        v();
    }

    public void C(int i) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (galleryViewPager = this.e) != null && (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            UrlDragImageView urlDragImageView = (UrlDragImageView) findViewWithTag;
            ImageUrlData imageUrlData = urlDragImageView.getmAssistUrlData();
            if (imageUrlData == null) {
                urlDragImageView.D(this.p, true);
                return;
            }
            String str = imageUrlData.imageUrl;
            if (!StringUtils.isNull(str)) {
                ImageUrlData s = s(str);
                urlDragImageView.setAssistUrl(s);
                H(s);
                I(s);
            }
            urlDragImageView.D(this.p, true);
        }
    }

    public void setLiveRoomEntranceButtonVisibility(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && this.w != null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            if (TimeHelper.isSameDay(System.currentTimeMillis(), sharedPrefHelper.getLong("key_live_room_entrance_show_time" + TbadkCoreApplication.getCurrentAccount(), 0L)) || this.w.getLiveRoomEntranceData() == null) {
                return;
            }
            this.w.setVisibility(i);
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
        v();
    }

    public void setOffscreenPageLimit(int i, int i2) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048622, this, i, i2) != null) || (galleryViewPager = this.e) == null) {
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
            ((ImagePagerAdapter) adapter).n(this.m);
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
        v();
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, imagePagerAdapter) == null) {
            if (imagePagerAdapter != null) {
                imagePagerAdapter.y(this.k);
            }
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager != null) {
                galleryViewPager.setAdapter(imagePagerAdapter);
            }
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                UrlManager.getInstance().dealOneLink(str);
                return;
            }
            LiveStartClickDataEvent liveStartClickDataEvent = new LiveStartClickDataEvent();
            liveStartClickDataEvent.viewTag = str;
            MutiProcessManager.publishEvent(liveStartClickDataEvent);
        }
    }

    public void J(boolean z) {
        dc5 dc5Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (dc5Var = this.v) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            dc5Var.p(i);
        }
    }

    public void o(ImagePagerAdapter.a aVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.b(aVar);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void p(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048604, this, i) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof UrlDragImageView)) {
            H(((UrlDragImageView) findViewWithTag).getmAssistUrlData());
        } else {
            J(false);
        }
    }

    public void r(int i) {
        GalleryViewPager galleryViewPager;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && (galleryViewPager = this.e) != null && (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) != null && (findViewWithTag instanceof UrlDragImageView)) {
            ((UrlDragImageView) findViewWithTag).I();
        }
    }

    public void setAddSize(int i) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.h(i);
        }
    }

    public void setAllowLocalUrl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.p = z;
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                imagePagerAdapter.i(z);
            }
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, map) == null) {
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
        if ((interceptable != null && interceptable.invokeL(1048611, this, str) != null) || (galleryViewPager = this.e) == null || (currentView = galleryViewPager.getCurrentView()) == null || (imageUrlData = currentView.getImageUrlData()) == null) {
            return;
        }
        imageUrlData.qrInfo = str;
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, hVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.l(hVar);
        }
    }

    public void setHasNext(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.o(z);
        }
    }

    public void setHeadImage(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.p(z);
        }
    }

    public void setIsCanDrag(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.q(z);
        }
    }

    public void setIsFromCDN(boolean z) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.r(z);
        }
    }

    public void setItemOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, onLongClickListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.u(onLongClickListener);
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, onClickListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.t(onClickListener);
        }
    }

    public void setNextTitle(String str) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, str) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.s(str);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, bVar) == null) && (dc5Var = this.v) != null) {
            dc5Var.l(bVar);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onPageChangeListener) == null) {
            this.j = onPageChangeListener;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, onClickListener) == null) && (dc5Var = this.v) != null) {
            dc5Var.m(onClickListener);
        }
    }

    public void setOnScrollOutListener(BaseViewPager.a aVar) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, aVar) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setOnFlipOutListener(aVar);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, cVar) == null) && (dc5Var = this.v) != null) {
            dc5Var.n(cVar);
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.p pVar) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, pVar) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.z(pVar);
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, onTouchListener) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.A(onTouchListener);
        }
    }

    public void setPageMargin(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setPageMargin(i);
        }
    }

    public void setShowBottomContainer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.u = z;
            J(z);
        }
    }

    public void setTempSize(int i) {
        ImagePagerAdapter imagePagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048632, this, i) == null) && (imagePagerAdapter = this.f) != null) {
            imagePagerAdapter.B(i);
        }
    }

    public void setUrlData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, arrayList) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048635, this, onTouchListener) == null) && (galleryViewPager = this.e) != null) {
            galleryViewPager.setOnTouchListener(onTouchListener);
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (dc5Var = this.v) != null) {
            dc5Var.r(z);
        }
    }

    public String t(int i) {
        InterceptResult invokeI;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i)) == null) {
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null || (findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i))) == null || !(findViewWithTag instanceof UrlDragImageView)) {
                return null;
            }
            return ((UrlDragImageView) findViewWithTag).getmCheckOriginPicText();
        }
        return (String) invokeI.objValue;
    }

    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
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

    public void E() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (galleryViewPager = this.e) != null && galleryViewPager.getCurrentView() != null) {
            this.e.getCurrentView().h0();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.o) {
            return;
        }
        this.d.setVisibility(0);
    }

    public int getBottomHeight() {
        InterceptResult invokeV;
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.u && (dc5Var = this.v) != null) {
                return dc5Var.c();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public String getCurrentOriginalUrl() {
        InterceptResult invokeV;
        DragImageView currentView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ImagePagerAdapter imagePagerAdapter = this.f;
            if (imagePagerAdapter != null) {
                return imagePagerAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048639, this) != null) || this.o) {
            return;
        }
        this.d.setVisibility(8);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.o = UtilHelper.isSupportGesture(getContext());
            w();
            x();
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            dc5 dc5Var = this.v;
            if (dc5Var == null) {
                return false;
            }
            return dc5Var.g();
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void A(ImageUrlData imageUrlData, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, imageUrlData, str, i) == null) && imageUrlData != null && !TextUtils.isEmpty(str)) {
            if (CommonStatisticKey.KEY_LIVE_ROOM_ENTRANCE_SHOW.equals(str) && imageUrlData.liveRoomEntranceLogged) {
                return;
            }
            imageUrlData.liveRoomEntranceLogged = true;
            StatisticItem statisticItem = new StatisticItem(str);
            if (CommonStatisticKey.KEY_LIVE_ROOM_ENTRANCE_CLICK.equals(str)) {
                statisticItem.addParam("obj_locate", i);
            }
            statisticItem.addParam("fid", imageUrlData.forumId).addParam("fname", imageUrlData.forumName).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("tid", imageUrlData.threadId).addParam("obj_source", "2");
            AlaInfoData alaInfoData = imageUrlData.alaInfoData;
            if (alaInfoData != null && alaInfoData.mYyExtData != null) {
                statisticItem.addParam("obj_type", YYLiveUtil.calculateLiveType(alaInfoData)).addParam(TiebaStatic.Params.OBJ_PARAM3, mua.l(alaInfoData)).addParam("hdid", TbadkCoreApplication.getInst().getHdid()).addParam(TiebaStatic.YYParams.YYSID, alaInfoData.mYyExtData.mSid).addParam(TiebaStatic.YYParams.YYSSID, alaInfoData.mYyExtData.mSsid).addParam("yyuid", alaInfoData.mYyExtData.mYyUid).addParam(TiebaStatic.YYParams.YYLIVEID, mua.r(alaInfoData.mYyExtData)).addParam("template_id", alaInfoData.mYyExtData.mTemplateId);
            }
            statisticItem.eventStat();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dc5 dc5Var = this.v;
            if (dc5Var != null) {
                dc5Var.j();
            }
            GalleryViewPager galleryViewPager = this.e;
            if (galleryViewPager == null) {
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
    }

    public byte[] getCurrentImageData() {
        InterceptResult invokeV;
        DragImageView currentView;
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.g = new a(this);
            this.i = new b(this);
            this.k = new c(this);
            this.h = new d(this);
            this.l = new e(this);
        }
    }

    public void F() {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (galleryViewPager = this.e) != null && galleryViewPager.getCurrentView() != null) {
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
                this.e.getCurrentView().i0();
            }
        }
    }

    public void G(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.a == i || (galleryViewPager = this.e) == null) {
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

    public void H(ImageUrlData imageUrlData) {
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, imageUrlData) == null) && (dc5Var = this.v) != null) {
            dc5Var.k(imageUrlData);
            if (!this.t && imageUrlData != null) {
                if (!this.v.g()) {
                    this.v.s(false);
                }
                if (!this.v.h()) {
                    K(true, 150);
                    return;
                }
                return;
            }
            J(false);
        }
    }

    public void q(int i) {
        GalleryViewPager galleryViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag instanceof UrlDragImageView) {
            ImageUrlData imageUrlData = ((UrlDragImageView) findViewWithTag).getmAssistUrlData();
            if (imageUrlData != null) {
                imageUrlData.liveRoomEntranceLogged = false;
            }
            I(imageUrlData);
            return;
        }
        this.w.setVisibility(8);
    }

    public final ImageUrlData s(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
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
        if ((interceptable != null && interceptable.invokeL(1048634, this, str) != null) || (galleryViewPager = this.e) == null) {
            return;
        }
        int childCount = galleryViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.e.getChildAt(i);
            if (childAt != null && (childAt instanceof UrlDragImageView)) {
                ((UrlDragImageView) childAt).setUserId(str);
            }
        }
        dc5 dc5Var = this.v;
        if (dc5Var != null) {
            dc5Var.o(str);
        }
    }

    public void setZoomButton(DragImageView dragImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, dragImageView) == null) {
            if (dragImageView != null) {
                if (dragImageView.R()) {
                    this.b.setEnabled(true);
                } else {
                    this.b.setEnabled(false);
                }
                if (dragImageView.S()) {
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

    public void I(ImageUrlData imageUrlData) {
        LiveRoomEntranceButton liveRoomEntranceButton;
        ImageUrlData.GuideInfo guideInfo;
        String text;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageUrlData) == null) && (liveRoomEntranceButton = this.w) != null) {
            liveRoomEntranceButton.setLiveRoomEntranceData(null);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            long j = sharedPrefHelper.getLong("key_live_room_entrance_show_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            int i = 8;
            if (TimeHelper.isSameDay(System.currentTimeMillis(), j)) {
                this.w.setVisibility(8);
            } else if (imageUrlData != null && (guideInfo = imageUrlData.guideInfo) != null && guideInfo.getStatus() == 1) {
                this.w.setVisibility(0);
                if (TextUtils.isEmpty(guideInfo.getText())) {
                    text = getContext().getString(R.string.live_room_entrance_text);
                } else {
                    text = guideInfo.getText();
                }
                this.w.setLiveRoomEntranceData(new LiveRoomEntranceButton.a(text, guideInfo.getScheme()));
                this.w.setLogData(imageUrlData);
                A(imageUrlData, CommonStatisticKey.KEY_LIVE_ROOM_ENTRANCE_SHOW, 0);
                dc5 dc5Var = this.v;
                if (dc5Var != null) {
                    LiveRoomEntranceButton liveRoomEntranceButton2 = this.w;
                    if (dc5Var.g()) {
                        i = 0;
                    }
                    liveRoomEntranceButton2.setVisibility(i);
                }
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    public void K(boolean z, int i) {
        dc5 dc5Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && this.u && (dc5Var = this.v) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            dc5Var.q(i2, i);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.w = new LiveRoomEntranceButton(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds650), UtilHelper.getDimenPixelSize(R.dimen.tbds107));
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds678);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.w.setClickCallBack(new f(this));
            this.w.setVisibility(8);
            addView(this.w, layoutParams);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.e = new GalleryViewPager(getContext());
            this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.e.setOnPageChangeListener(this.i);
            addView(this.e);
            this.d = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = BdUtilHelper.dip2px(getContext(), 10.0f);
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
            imagePagerAdapter.x(this.l);
            setAdapter(this.f);
            this.v = new dc5(getContext(), this);
            n();
        }
    }
}
