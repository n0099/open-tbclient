package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public BdPageContext b;
    public int c;
    public int d;
    public en e;
    public View f;
    public boolean g;
    public yy9 h;
    public iz9 i;
    public boolean j;
    public float k;
    public boolean l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public uy9 o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public vy9 r;

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fz9 fz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                SafeHandler.getInst().postDelayed(this.a.r, 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fz9 fz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData()) || !this.a.l) {
                return;
            }
            SafeHandler.getInst().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fz9 fz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.y();
            if (!this.a.l || !this.a.l) {
                return;
            }
            fz9 fz9Var = this.a;
            fz9Var.n(fz9Var.i.a(), this.a.i.b(), this.a.i.d(), this.a.i.c());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fz9 fz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (ei.isEmpty(str)) {
                    return;
                }
                SafeHandler.getInst().removeCallbacks(this.a.o);
                SafeHandler.getInst().removeCallbacks(this.a.r);
                if (this.a.f != null && (this.a.f.getTag() instanceof yy9)) {
                    if (str.equals(((yy9) this.a.f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((yy9) this.a.f.getTag()).stopPlay();
                }
                if (this.a.e == null) {
                    return;
                }
                for (int i = 0; i < this.a.e.getListView().getChildCount(); i++) {
                    View childAt = this.a.e.getListView().getChildAt(i);
                    if ((childAt.getTag() instanceof yy9) && str.equals(((yy9) childAt.getTag()).getPlayUrl())) {
                        this.a.f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public fz9(BdPageContext bdPageContext, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, enVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = 0;
        this.d = 0;
        this.g = false;
        this.j = true;
        this.k = 0.0f;
        this.l = true;
        this.m = new a(this, 2921637);
        this.n = new b(this, 2921736);
        this.o = new uy9();
        this.p = new c(this, 2000994);
        this.q = new d(this, 2921387);
        this.r = new vy9(this);
        this.b = bdPageContext;
        this.c = BdUtilHelper.getEquipmentHeight(bdPageContext.getPageActivity());
        this.e = enVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.i = new iz9();
        bdPageContext.registerListener(this.p);
        bdPageContext.registerListener(this.n);
        bdPageContext.registerListener(this.m);
    }

    public void k(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && !l(view2) && (view2.getTag() instanceof yy9)) {
            ((yy9) view2.getTag()).stopPlay();
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    public void v(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, enVar) == null) {
            this.e = enVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.d = i;
        }
    }

    public final void A(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, view2) == null) {
            if (i == 1 && (view2.getTag() instanceof yy9)) {
                yy9 yy9Var = (yy9) view2.getTag();
                if (yy9Var.isPlaying()) {
                    yy9Var.stopPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof xy9)) {
                ((xy9) view2.getTag()).e();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.o);
            SafeHandler.getInst().removeCallbacks(this.r);
            i();
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e == null) {
            return;
        }
        for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
            View childAt = this.e.getListView().getChildAt(i);
            if (childAt.getTag() instanceof yy9) {
                ((yy9) childAt.getTag()).stopPlay();
            }
        }
    }

    public boolean l(View view2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            int i2 = this.a;
            if (i2 == 1) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.b.getPageActivity()) / 2;
                int i3 = rect.top;
                if (i3 < 0 || i3 > equipmentHeight || rect.bottom - i3 < view2.getMeasuredHeight()) {
                    return false;
                }
                return true;
            } else if (i2 == 2) {
                int equipmentHeight2 = BdUtilHelper.getEquipmentHeight(this.b.getPageActivity(), true);
                float measuredHeight = (view2.getMeasuredHeight() * 2.0f) / 3.0f;
                float statusBarHeight = UtilHelper.getStatusBarHeight() + measuredHeight + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                int mainTabBottomBarHeight = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (this.j) {
                    this.k = measuredHeight + mainTabBottomBarHeight;
                } else {
                    this.k = measuredHeight;
                }
                if (rect.top > equipmentHeight2 - this.k || rect.bottom < statusBarHeight) {
                    return false;
                }
                return true;
            } else {
                int i4 = rect.top;
                if (i4 < 0 || (i = rect.bottom) > this.c - this.d || i - i4 < view2.getMeasuredHeight()) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void m(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        int i4;
        View view2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.i.e(i, i2, z);
            en enVar = this.e;
            if (enVar != null && enVar.getListView().getChildCount() != 0 && this.e.getContentViewsCount() != 0) {
                yy9 yy9Var = this.h;
                if (yy9Var != null && !l(yy9Var.getVideoContainer())) {
                    this.h.stopPlay();
                }
                View view3 = this.f;
                int i6 = 0;
                if (view3 != null && (view3.getTag() instanceof yy9) && this.g) {
                    if (l(((yy9) this.f.getTag()).getVideoContainer())) {
                        x(i3, this.f);
                        this.g = false;
                        return;
                    }
                    this.f = null;
                }
                int contentViewsCount = this.e.getContentViewsCount() + this.e.getHeaderViewsCount() + this.e.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    int i7 = contentViewsCount - 1;
                    z2 = false;
                }
                int childCount = this.e.getListView().getChildCount();
                if (i != 0 && i2 != contentViewsCount - 1) {
                    z3 = false;
                } else {
                    z3 = false;
                    for (int i8 = 0; i8 < childCount; i8++) {
                        if (z2) {
                            i4 = i8;
                        } else {
                            i4 = (childCount - 1) - i8;
                        }
                        View childAt = this.e.getListView().getChildAt(i4);
                        if (childAt.getTag() instanceof yy9) {
                            yy9 yy9Var2 = (yy9) childAt.getTag();
                            if (!z3 && l(yy9Var2.getVideoContainer())) {
                                x(i3, childAt);
                                z3 = true;
                            } else {
                                A(i3, childAt);
                            }
                        }
                    }
                }
                if (z3) {
                    return;
                }
                int i9 = -1;
                int i10 = 0;
                while (true) {
                    if (i10 >= childCount) {
                        break;
                    }
                    View childAt2 = this.e.getListView().getChildAt(i10);
                    if (childAt2.getTag() instanceof yy9) {
                        yy9 yy9Var3 = (yy9) childAt2.getTag();
                        if (yy9Var3.isPlayStarted() && l(yy9Var3.getVideoContainer())) {
                            i9 = i10;
                            break;
                        }
                    }
                    i10++;
                }
                if (i9 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.e.getListView().getChildAt(i6);
                        if (i6 != i9) {
                            A(i3, childAt3);
                        } else {
                            x(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                boolean z4 = false;
                while (i6 < childCount) {
                    if (z) {
                        i5 = (childCount - 1) - i6;
                    } else {
                        i5 = i6;
                    }
                    View childAt4 = this.e.getListView().getChildAt(i5);
                    if (childAt4.getTag() instanceof yy9) {
                        yy9 yy9Var4 = (yy9) childAt4.getTag();
                        if (!z4 && (yy9Var4.isFullScreen() || l(yy9Var4.getVideoContainer()))) {
                            x(i3, childAt4);
                            z4 = true;
                        } else {
                            A(i3, childAt4);
                        }
                    }
                    i6++;
                }
                if (!z4 && (view2 = this.f) != null && (view2.getTag() instanceof yy9)) {
                    ((yy9) this.f.getTag()).stopPlay();
                }
            }
        }
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SafeHandler.getInst().removeCallbacks(this.r);
            this.r.a(i);
            this.r.c(i2);
            this.r.b(z);
            this.r.d(z2);
            this.i.f(z2);
            SafeHandler.getInst().postDelayed(this.r, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !this.l) {
            return;
        }
        View view2 = this.f;
        if (view2 != null && (view2.getTag() instanceof yy9)) {
            yy9 yy9Var = (yy9) this.f.getTag();
            if (this.g) {
                yy9Var.startPlay();
                this.g = false;
            }
            if (this.f.getTag() instanceof xy9) {
                ((xy9) this.f.getTag()).b();
            }
        }
        this.f = null;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.o);
            SafeHandler.getInst().removeCallbacks(this.r);
            if (this.e == null) {
                return;
            }
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof yy9) {
                    yy9 yy9Var = (yy9) childAt.getTag();
                    if (yy9Var.isPlayStarted()) {
                        yy9Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.e == null) {
            return;
        }
        for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
            View childAt = this.e.getListView().getChildAt(i);
            if (childAt.getTag() instanceof yy9) {
                yy9 yy9Var = (yy9) childAt.getTag();
                if (yy9Var.isPlayStarted()) {
                    t(yy9Var.getCurrentPosition());
                    s(yy9Var.getPlayUrl());
                    this.f = childAt;
                    this.g = yy9Var.isPlaying();
                    yy9Var.stopPlay();
                    return;
                }
            }
        }
    }

    public void r(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
            if (!z && (view2 = this.f) != null && (view2.getTag() instanceof yy9) && ((yy9) this.f.getTag()).getVideoContainer() != null) {
                ((yy9) this.f.getTag()).getVideoContainer().setTag(-1001, "1");
            }
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.p;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.q;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.q.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    public final void x(int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048593, this, i, view2) != null) || view2 == null) {
            return;
        }
        View view3 = this.f;
        if (view3 != null && view3 != view2 && (view3.getTag() instanceof yy9)) {
            ((yy9) this.f.getTag()).stopPlay();
        }
        this.f = view2;
        if (i == 1 && (view2.getTag() instanceof yy9)) {
            yy9 yy9Var = (yy9) view2.getTag();
            if (this.l && !yy9Var.isPlayStarted()) {
                yy9Var.startPlay();
            }
        } else if (i == 2 && (view2.getTag() instanceof xy9)) {
            ((xy9) view2.getTag()).a();
        }
    }
}
