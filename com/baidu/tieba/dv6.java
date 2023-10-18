package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.hz4;
import com.baidu.tieba.rx6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.wv6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class dv6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public rx6 c;
    public wv6 d;
    public EnterForumModel e;
    public List<jw4> f;
    public boolean g;
    public jv6 h;
    public lx6 i;
    public HashSet<Long> j;

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv6 a;

        /* loaded from: classes5.dex */
        public class a implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    wfa.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements hz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        public e(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.P()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new am5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.R().b();
                if (b2 != null) {
                    int O = b2.O();
                    if (O != 220012) {
                        if (O == 2121002) {
                            DialogUtil.createAlertDialog(this.a.a, (String) null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0513), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f16e2), this.a.a.getResources().getString(R.string.think_more), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ad.isEmpty(b2.N())) {
                            N = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050f);
                        } else {
                            N = b2.N();
                        }
                        blockPopInfoData.block_info = N;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0511);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b68);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0510);
                    if (b2 != null) {
                        if (ad.isEmpty(b2.N())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0510);
                        } else {
                            string = b2.N();
                        }
                    }
                    DialogUtil.createAlertDialog(this.a.a, (String) null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b68), (String) null, new c(this), (hz4.e) null).show();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements rx6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx6 a;
        public final /* synthetic */ dv6 b;

        public a(dv6 dv6Var, lx6 lx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var, lx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv6Var;
            this.a = lx6Var;
        }

        @Override // com.baidu.tieba.rx6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wv6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv6 a;

        public b(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv6Var;
        }

        @Override // com.baidu.tieba.wv6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.Z(true, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv6 a;

        public c(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new am5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv6 a;

        public d(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new am5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(dv6 dv6Var, a aVar) {
            this(dv6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoDataView b;

        public g(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(dv6 dv6Var, a aVar) {
            this(dv6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(dv6 dv6Var, a aVar) {
            this(dv6Var);
        }
    }

    public dv6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, lx6 lx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, lx6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.a = tbPageContext;
        this.b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = lx6Var;
        rx6 rx6Var = new rx6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = rx6Var;
        rx6Var.C(new a(this, lx6Var));
        this.e = enterForumModel;
        wv6 wv6Var = new wv6(this.a.getPageActivity(), Integer.valueOf(cv6.a(1)).intValue(), 0, this.c);
        this.d = wv6Var;
        wv6Var.u(new b(this));
    }

    public void g(int i) {
        rx6 rx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (rx6Var = this.c) != null) {
            rx6Var.u(i);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = this.f.size();
            if (size > 0 && i < size) {
                return this.f.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<jw4> list = this.f;
            if (list != null && (i >= list.size() || i < 0)) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < this.f.size() && i >= 0) {
                return this.f.get(i).c();
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public void j(int i) {
        wv6 wv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (wv6Var = this.d) != null) {
            wv6Var.t(i);
        }
    }

    public void k(jv6 jv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jv6Var) == null) {
            if (jv6Var != this.h) {
                this.h = jv6Var;
                notifyDataSetChanged();
            }
            rx6 rx6Var = this.c;
            if (rx6Var != null) {
                rx6Var.A(jv6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        rx6 rx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (rx6Var = this.c) != null) {
            rx6Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rx6 rx6Var = this.c;
            if (rx6Var == null) {
                return false;
            }
            return rx6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<jw4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return jw4.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        rx6 rx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (rx6Var = this.c) != null) {
            rx6Var.v();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        h hVar;
        ox6 ox6Var;
        jw4 jw4Var;
        f fVar;
        g gVar;
        NoDataViewFactory.d b2;
        NoDataViewFactory.e a2;
        NoDataViewFactory.c a3;
        sx6 sx6Var;
        wx6 wx6Var;
        xx6 xx6Var;
        vx6 vx6Var;
        tx6 tx6Var;
        ux6 ux6Var;
        nx6 nx6Var;
        nv6 nv6Var;
        mx6 mx6Var;
        hv6 hv6Var;
        nw6 nw6Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            boolean z = true;
            boolean z2 = true;
            int i2 = 1;
            boolean z3 = false;
            switch (getItemViewType(i)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof h)) {
                        hVar = (h) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bf, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a7);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092276);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907bc);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof lv6) {
                        lv6 lv6Var = (lv6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (lv6Var != null) {
                            hVar.a.setText(lv6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            jv6 jv6Var = this.h;
                            if ((jv6Var != null && jv6Var.a) || lv6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (lv6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (lv6Var.g != -1) {
                                layoutParams.setMargins(BdUtilHelper.getDimens(viewGroup.getContext(), lv6Var.g), 0, BdUtilHelper.getDimens(viewGroup.getContext(), lv6Var.g), 0);
                            }
                            if (lv6Var.i != -1) {
                                EMManager.from(hVar.a).setTextSize(lv6Var.i);
                            }
                            if (lv6Var.h != -1) {
                                layoutParams.height = BdUtilHelper.getDimens(viewGroup.getContext(), lv6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (lv6Var.j != -1) {
                                hVar.c.setPadding(BdUtilHelper.getDimens(viewGroup.getContext(), lv6Var.j), 0, BdUtilHelper.getDimens(viewGroup.getContext(), lv6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof ox6)) {
                        ox6Var = (ox6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0401, viewGroup, false);
                        ox6Var = new ox6(this.a, view2, this.b);
                        view2.setTag(ox6Var);
                    }
                    if ((this.f.get(i) instanceof jw4) && (jw4Var = this.f.get(i)) != null) {
                        ox6Var.h(jw4Var);
                    }
                    ox6Var.j(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02be, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0907bc);
                        view2.setTag(fVar);
                    }
                    View view3 = fVar.b;
                    if (view3 != null) {
                        view3.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(fVar.a, (int) R.color.CAM_X0304);
                    return view2;
                case 3:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bc, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091faa);
                        gVar.b = NoDataViewFactory.a(this.a.getPageActivity(), gVar.a, null, null, null);
                        view2.setTag(gVar);
                    }
                    d dVar = new d(this);
                    if (!TbadkCoreApplication.isLogin()) {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOTLOGIN, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0676);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0468), dVar));
                    } else {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f07f8);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0466), dVar));
                    }
                    gVar.b.setImgOption(b2);
                    gVar.b.setTextOption(a2);
                    gVar.b.setButtonOption(a3);
                    gVar.b.setVisibility(0);
                    SkinManager.setBackgroundColor(gVar.a, R.color.CAM_X0205);
                    gVar.b.f(this.a, TbadkCoreApplication.getInst().getSkinType());
                    return view2;
                case 4:
                    if (view2 == null) {
                        View m = this.c.m();
                        this.c.x();
                        return m;
                    }
                    return view2;
                case 5:
                    n();
                    if (view2 != null && (view2.getTag() instanceof sx6)) {
                        sx6Var = (sx6) view2.getTag();
                    } else {
                        sx6Var = new sx6(this.a);
                        view2 = sx6Var.b();
                        view2.setTag(sx6Var);
                    }
                    sx6Var.a();
                    sx6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof wx6)) {
                        wx6Var = (wx6) view2.getTag();
                    } else {
                        wx6Var = new wx6(this.a);
                        view2 = wx6Var.d();
                        view2.setTag(wx6Var);
                    }
                    if (this.f.get(i) instanceof by4) {
                        wx6Var.c((by4) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z = false;
                        }
                        wx6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof xx6)) {
                        xx6Var = (xx6) view2.getTag();
                    } else {
                        xx6Var = new xx6(this.a);
                        view2 = xx6Var.k();
                        view2.setTag(xx6Var);
                    }
                    if (this.f.get(i) instanceof zx4) {
                        zx4 zx4Var = (zx4) this.f.get(i);
                        xx6Var.g(zx4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(zx4Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", zx4Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                                if (this.e.R().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                xx6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(zx4Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof vx6)) {
                        vx6Var = (vx6) view2.getTag();
                    } else {
                        vx6Var = new vx6(this.a);
                        view2 = vx6Var.c();
                        view2.setTag(vx6Var);
                    }
                    if (this.f.get(i) instanceof ay4) {
                        vx6Var.b((ay4) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof tx6)) {
                        tx6Var = (tx6) view2.getTag();
                    } else {
                        tx6Var = new tx6(this.a);
                        view2 = tx6Var.d();
                        view2.setTag(tx6Var);
                    }
                    if (this.f.get(i) instanceof fv6) {
                        tx6Var.c((fv6) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z2 = false;
                        }
                        tx6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof ux6)) {
                        ux6Var = (ux6) view2.getTag();
                    } else {
                        ux6Var = new ux6(this.a);
                        view2 = ux6Var.b();
                        view2.setTag(ux6Var);
                    }
                    ux6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof nx6)) {
                        nx6Var = (nx6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d05b4, viewGroup, false);
                        nx6Var = new nx6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(nx6Var);
                    }
                    if ((this.f.get(i) instanceof nv6) && (nv6Var = (nv6) this.f.get(i)) != null) {
                        nx6Var.h(nv6Var);
                    }
                    nx6Var.j(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof mx6)) {
                        mx6Var = (mx6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d020a, viewGroup, false);
                        mx6Var = new mx6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(mx6Var);
                    }
                    if ((this.f.get(i) instanceof hv6) && (hv6Var = (hv6) this.f.get(i)) != null && !ListUtils.isEmpty(hv6Var.f())) {
                        mx6Var.h(hv6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof nw6)) {
                        nw6Var = (nw6) view2.getTag();
                    } else {
                        nw6Var = new nw6(this.a);
                        view2 = nw6Var.a();
                        view2.setTag(nw6Var);
                    }
                    if (this.f.get(i) instanceof lw6) {
                        lw6 lw6Var = (lw6) this.f.get(i);
                        nw6Var.a().setData(lw6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (lw6Var == null) {
                            str = "";
                        } else {
                            str = lw6Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (lw6Var != null) {
                            str2 = lw6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<jw4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            wv6 wv6Var = this.d;
            if (wv6Var != null) {
                wv6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
