package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.my8;
import com.baidu.tieba.rh6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.uf6;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class bf6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public rh6 c;
    public uf6 d;
    public EnterForumModel e;
    public List<dt4> f;
    public boolean g;
    public hf6 h;
    public lh6 i;
    public HashSet<Long> j;
    public my8.c k;

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf6 a;

        /* loaded from: classes3.dex */
        public class a implements wv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    my8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    wv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements wv4.e {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements wv4.e {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    wv4Var.dismiss();
                }
            }
        }

        public e(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String G;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.I()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new me5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.K().b();
                if (b2 != null) {
                    int H = b2.H();
                    if (H != 220012) {
                        if (H == 2121002) {
                            v45.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0491), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14d9), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f146a), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (yi.isEmpty(b2.G())) {
                            G = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f048d);
                        } else {
                            G = b2.G();
                        }
                        blockPopInfoData.block_info = G;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f048f);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a21);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f048e);
                    if (b2 != null) {
                        if (yi.isEmpty(b2.G())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f048e);
                        } else {
                            string = b2.G();
                        }
                    }
                    v45.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a21), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements rh6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh6 a;
        public final /* synthetic */ bf6 b;

        public a(bf6 bf6Var, lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var, lh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bf6Var;
            this.a = lh6Var;
        }

        @Override // com.baidu.tieba.rh6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements uf6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf6 a;

        public b(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bf6Var;
        }

        @Override // com.baidu.tieba.uf6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.S(true, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf6 a;

        public c(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new me5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf6 a;

        public d(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new me5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends my8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.my8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.my8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.my8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.my8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public f(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(bf6 bf6Var, a aVar) {
            this(bf6Var);
        }
    }

    /* loaded from: classes3.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public h(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(bf6 bf6Var, a aVar) {
            this(bf6Var);
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(bf6 bf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(bf6 bf6Var, a aVar) {
            this(bf6Var);
        }
    }

    public bf6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, lh6 lh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, lh6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.k = new f(this);
        this.a = tbPageContext;
        this.b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = lh6Var;
        rh6 rh6Var = new rh6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = rh6Var;
        rh6Var.C(new a(this, lh6Var));
        this.e = enterForumModel;
        uf6 uf6Var = new uf6(this.a.getPageActivity(), Integer.valueOf(af6.a(1)).intValue(), 0, this.c);
        this.d = uf6Var;
        uf6Var.u(new b(this));
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f.size();
            if (size > 0 && i2 < size) {
                return this.f.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<dt4> list = this.f;
            if (list != null && (i2 >= list.size() || i2 < 0)) {
                return -1L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < this.f.size() && i2 >= 0) {
                return this.f.get(i2).c();
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public void h(int i2) {
        rh6 rh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (rh6Var = this.c) != null) {
            rh6Var.u(i2);
        }
    }

    public void k(int i2) {
        uf6 uf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (uf6Var = this.d) != null) {
            uf6Var.t(i2);
        }
    }

    public void l(hf6 hf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hf6Var) == null) {
            if (hf6Var != this.h) {
                this.h = hf6Var;
                notifyDataSetChanged();
            }
            rh6 rh6Var = this.c;
            if (rh6Var != null) {
                rh6Var.A(hf6Var);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        rh6 rh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (rh6Var = this.c) != null) {
            rh6Var.D(bdUniqueId);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rh6 rh6Var = this.c;
            if (rh6Var == null) {
                return false;
            }
            return rh6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<dt4> g() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return dt4.c.length;
        }
        return invokeV.intValue;
    }

    public void i() {
        rh6 rh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (rh6Var = this.c) != null) {
            rh6Var.v();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        oh6 oh6Var;
        dt4 dt4Var;
        g gVar;
        h hVar;
        sh6 sh6Var;
        wh6 wh6Var;
        xh6 xh6Var;
        vh6 vh6Var;
        th6 th6Var;
        uh6 uh6Var;
        nh6 nh6Var;
        lf6 lf6Var;
        mh6 mh6Var;
        ff6 ff6Var;
        ng6 ng6Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            boolean z = true;
            boolean z2 = true;
            int i3 = 1;
            boolean z3 = false;
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0274, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922ff);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092001);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906fb);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof jf6) {
                        jf6 jf6Var = (jf6) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (jf6Var != null) {
                            iVar.a.setText(jf6Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            hf6 hf6Var = this.h;
                            if ((hf6Var != null && hf6Var.a) || jf6Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (jf6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (jf6Var.g != -1) {
                                layoutParams.setMargins(zi.g(viewGroup.getContext(), jf6Var.g), 0, zi.g(viewGroup.getContext(), jf6Var.g), 0);
                            }
                            if (jf6Var.i != -1) {
                                cx4.d(iVar.a).z(jf6Var.i);
                            }
                            if (jf6Var.h != -1) {
                                layoutParams.height = zi.g(viewGroup.getContext(), jf6Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (jf6Var.j != -1) {
                                iVar.c.setPadding(zi.g(viewGroup.getContext(), jf6Var.j), 0, zi.g(viewGroup.getContext(), jf6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof oh6)) {
                        oh6Var = (oh6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03a5, viewGroup, false);
                        oh6Var = new oh6(this.a, view2, this.b);
                        view2.setTag(oh6Var);
                    }
                    if ((this.f.get(i2) instanceof dt4) && (dt4Var = this.f.get(i2)) != null) {
                        oh6Var.f(dt4Var);
                    }
                    oh6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0273, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906fb);
                        view2.setTag(gVar);
                    }
                    View view3 = gVar.b;
                    if (view3 != null) {
                        view3.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.a, (int) R.color.CAM_X0304);
                    return view2;
                case 3:
                    if (view2 != null && (view2.getTag() instanceof h)) {
                        hVar = (h) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0271, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091d49);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f20);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e02);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.footer_text);
                        zz4 zz4Var = new zz4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(zz4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f05a1);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0402));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06fe);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0400));
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.a, R.color.CAM_X0205);
                    hVar.d.k();
                    TBSpecificationBtn tBSpecificationBtn = hVar.d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view2;
                    }
                    return view2;
                case 4:
                    if (view2 == null) {
                        View m = this.c.m();
                        this.c.x();
                        return m;
                    }
                    return view2;
                case 5:
                    o();
                    if (view2 != null && (view2.getTag() instanceof sh6)) {
                        sh6Var = (sh6) view2.getTag();
                    } else {
                        sh6Var = new sh6(this.a);
                        view2 = sh6Var.b();
                        view2.setTag(sh6Var);
                    }
                    sh6Var.a();
                    sh6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof wh6)) {
                        wh6Var = (wh6) view2.getTag();
                    } else {
                        wh6Var = new wh6(this.a);
                        view2 = wh6Var.d();
                        view2.setTag(wh6Var);
                    }
                    if (this.f.get(i2) instanceof vu4) {
                        wh6Var.c((vu4) this.f.get(i2));
                    }
                    if (this.e.K() != null && this.e.K().e() != null && this.e.K().e().b() != null) {
                        if (this.e.K().e().b().size() <= 0) {
                            z = false;
                        }
                        wh6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof xh6)) {
                        xh6Var = (xh6) view2.getTag();
                    } else {
                        xh6Var = new xh6(this.a);
                        view2 = xh6Var.k();
                        view2.setTag(xh6Var);
                    }
                    if (this.f.get(i2) instanceof tu4) {
                        tu4 tu4Var = (tu4) this.f.get(i2);
                        xh6Var.g(tu4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(tu4Var.i()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", tu4Var.i());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.K() != null && this.e.K().e() != null && this.e.K().e().b() != null) {
                                if (this.e.K().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i3 = 3;
                                }
                                statisticItem.param("obj_type", i3);
                                xh6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(tu4Var.i()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof vh6)) {
                        vh6Var = (vh6) view2.getTag();
                    } else {
                        vh6Var = new vh6(this.a);
                        view2 = vh6Var.c();
                        view2.setTag(vh6Var);
                    }
                    if (this.f.get(i2) instanceof uu4) {
                        vh6Var.b((uu4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof th6)) {
                        th6Var = (th6) view2.getTag();
                    } else {
                        th6Var = new th6(this.a);
                        view2 = th6Var.d();
                        view2.setTag(th6Var);
                    }
                    if (this.f.get(i2) instanceof df6) {
                        th6Var.c((df6) this.f.get(i2));
                    }
                    if (this.e.K() != null && this.e.K().e() != null && this.e.K().e().b() != null) {
                        if (this.e.K().e().b().size() <= 0) {
                            z2 = false;
                        }
                        th6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof uh6)) {
                        uh6Var = (uh6) view2.getTag();
                    } else {
                        uh6Var = new uh6(this.a);
                        view2 = uh6Var.b();
                        view2.setTag(uh6Var);
                    }
                    uh6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof nh6)) {
                        nh6Var = (nh6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0541, viewGroup, false);
                        nh6Var = new nh6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(nh6Var);
                    }
                    if ((this.f.get(i2) instanceof lf6) && (lf6Var = (lf6) this.f.get(i2)) != null) {
                        nh6Var.f(lf6Var);
                    }
                    nh6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof mh6)) {
                        mh6Var = (mh6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01df, viewGroup, false);
                        mh6Var = new mh6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(mh6Var);
                    }
                    if ((this.f.get(i2) instanceof ff6) && (ff6Var = (ff6) this.f.get(i2)) != null && !ListUtils.isEmpty(ff6Var.i())) {
                        mh6Var.f(ff6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof ng6)) {
                        ng6Var = (ng6) view2.getTag();
                    } else {
                        ng6Var = new ng6(this.a);
                        view2 = ng6Var.a();
                        view2.setTag(ng6Var);
                    }
                    if (this.f.get(i2) instanceof jg6) {
                        jg6 jg6Var = (jg6) this.f.get(i2);
                        ng6Var.a().setData(jg6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (jg6Var == null) {
                            str = "";
                        } else {
                            str = jg6Var.i();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (jg6Var != null) {
                            str2 = jg6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void m(List<dt4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            uf6 uf6Var = this.d;
            if (uf6Var != null) {
                uf6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
