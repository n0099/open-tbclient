package com.baidu.tieba.frs.banner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.flow.CoverFlowAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.frs.ad.FrsTopADView;
import com.baidu.tieba.frs.banner.data.FrsHeadBannerData;
import com.baidu.tieba.frs.banner.view.FrsForumMountView;
import com.baidu.tieba.g75;
import com.baidu.tieba.h75;
import com.baidu.tieba.xj7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J \u0010\u001b\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/frs/banner/adapter/FrsHeadCommonFlowAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tbadk/core/flow/data/CoverFlowData;", "Lcom/baidu/tbadk/core/flow/CoverFlowAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", CriusAttrConstants.POSITION, "", "onChangeSkinType", "", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPrimary", "isPrimary", "", "onResume", "processList", "list", "", "processViewList", "dataList", "Ljava/util/ArrayList;", "setData", "factory", "Lcom/baidu/tbadk/core/flow/CoverFlowFactory;", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsHeadCommonFlowAdapter<T extends h75> extends CoverFlowAdapter<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context h;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1998602942, "Lcom/baidu/tieba/frs/banner/adapter/FrsHeadCommonFlowAdapter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1998602942, "Lcom/baidu/tieba/frs/banner/adapter/FrsHeadCommonFlowAdapter$a;");
                    return;
                }
            }
            int[] iArr = new int[FrsHeadBannerData.BannerType.values().length];
            iArr[FrsHeadBannerData.BannerType.AD_PIC.ordinal()] = 1;
            iArr[FrsHeadBannerData.BannerType.FORUM_MOUNT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1714119519, "Lcom/baidu/tieba/frs/banner/adapter/FrsHeadCommonFlowAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1714119519, "Lcom/baidu/tieba/frs/banner/adapter/FrsHeadCommonFlowAdapter;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeadCommonFlowAdapter(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = context;
    }

    public final void j(List<? extends T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b.clear();
            this.b.addAll(list);
            int size = this.b.size();
            if (size <= 1) {
                return;
            }
            this.b.add(0, this.b.get(size - 1));
            this.b.add(this.b.get(0));
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof xj7) {
                    ((xj7) next).onChangeSkinType(TbadkApplication.getInst().getSkinType());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof xj7) {
                    ((xj7) next).onPause();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof xj7) {
                    ((xj7) next).onResume();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof xj7) {
                    ((xj7) next).onDestroy();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof xj7) {
                    ((xj7) next).onPrimary(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter
    public void h(List<? extends T> list, g75 g75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, g75Var) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (list.isEmpty()) {
                return;
            }
            j(list);
            ArrayList<T> dataList = this.b;
            Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
            k(dataList);
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.flow.CoverFlowAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i) {
        InterceptResult invokeLI;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, container, i)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.a.isEmpty()) {
                Object instantiateItem = super.instantiateItem(container, i);
                Intrinsics.checkNotNullExpressionValue(instantiateItem, "super.instantiateItem(container, position)");
                return instantiateItem;
            }
            View v = (View) ListUtils.getItem(this.a, i);
            if (v.getParent() != null) {
                ViewParent parent = v.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(v);
                }
            }
            v.setTag(Integer.valueOf(i));
            container.addView(v, new ViewGroup.LayoutParams(-2, -2));
            Intrinsics.checkNotNullExpressionValue(v, "v");
            return v;
        }
        return invokeLI.objValue;
    }

    public final void k(ArrayList<T> arrayList) {
        FrsBountyTaskData a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.a.clear();
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next instanceof FrsHeadBannerData) {
                    FrsHeadBannerData frsHeadBannerData = (FrsHeadBannerData) next;
                    int i = a.$EnumSwitchMapping$0[frsHeadBannerData.getType().ordinal()];
                    if (i != 1) {
                        if (i == 2 && (a2 = frsHeadBannerData.a()) != null) {
                            Context context = this.h;
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            FrsForumMountView frsForumMountView = new FrsForumMountView(context, null, 0, 6, null);
                            frsForumMountView.d(a2);
                            frsForumMountView.setViewClickListener(this.d);
                            this.a.add(frsForumMountView);
                        }
                    } else if (frsHeadBannerData.c() != null && frsHeadBannerData.b() != null) {
                        FrsTopADView frsTopADView = new FrsTopADView(this.h);
                        frsTopADView.e(frsHeadBannerData.c(), frsHeadBannerData.b(), frsHeadBannerData.d());
                        this.a.add(frsTopADView);
                    }
                }
            }
        }
    }
}
