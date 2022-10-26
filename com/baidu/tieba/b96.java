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
import com.baidu.tieba.pu4;
import com.baidu.tieba.rb6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u96;
import com.baidu.tieba.uo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class b96 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ViewEventCenter b;
    public rb6 c;
    public u96 d;
    public EnterForumModel e;
    public List f;
    public boolean g;
    public h96 h;
    public lb6 i;
    public HashSet j;
    public uo8.c k;

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b96 a;

        /* loaded from: classes3.dex */
        public class a implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    uo8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        public e(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new bc5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z2 = false;
                ForumCreateInfoData b2 = this.a.e.D().b();
                if (b2 != null) {
                    int A = b2.A();
                    if (A != 220012) {
                        if (A == 2121002) {
                            l35.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0481), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1462), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13f3), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ej.isEmpty(b2.z())) {
                            z = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047d);
                        } else {
                            z = b2.z();
                        }
                        blockPopInfoData.block_info = z;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047f);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09c4);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z2 = true;
                }
                if (!z2) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047e);
                    if (b2 != null) {
                        if (ej.isEmpty(b2.z())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047e);
                        } else {
                            string = b2.z();
                        }
                    }
                    l35.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09c4), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements rb6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb6 a;
        public final /* synthetic */ b96 b;

        public a(b96 b96Var, lb6 lb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var, lb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b96Var;
            this.a = lb6Var;
        }

        @Override // com.baidu.tieba.rb6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.s());
                this.a.z0(this.b.c.t());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements u96.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b96 a;

        public b(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b96Var;
        }

        @Override // com.baidu.tieba.u96.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.L(true, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b96 a;

        public c(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new bc5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b96 a;

        public d(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new bc5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends uo8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.uo8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.uo8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.uo8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.uo8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public f(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
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

        public g(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(b96 b96Var, a aVar) {
            this(b96Var);
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

        public h(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(b96 b96Var, a aVar) {
            this(b96Var);
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(b96 b96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(b96 b96Var, a aVar) {
            this(b96Var);
        }
    }

    public b96(TbPageContext tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, lb6 lb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, lb6Var};
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
        this.j = new HashSet();
        this.i = lb6Var;
        rb6 rb6Var = new rb6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = rb6Var;
        rb6Var.E(new a(this, lb6Var));
        this.e = enterForumModel;
        u96 u96Var = new u96(this.a.getPageActivity(), Integer.valueOf(a96.a(1)).intValue(), 0, this.c);
        this.d = u96Var;
        u96Var.u(new b(this));
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
            List list = this.f;
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
                return ((yr4) this.f.get(i2)).c();
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public void h(int i2) {
        rb6 rb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (rb6Var = this.c) != null) {
            rb6Var.w(i2);
        }
    }

    public void k(int i2) {
        u96 u96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (u96Var = this.d) != null) {
            u96Var.t(i2);
        }
    }

    public void l(h96 h96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h96Var) == null) {
            if (h96Var != this.h) {
                this.h = h96Var;
                notifyDataSetChanged();
            }
            rb6 rb6Var = this.c;
            if (rb6Var != null) {
                rb6Var.C(h96Var);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        rb6 rb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (rb6Var = this.c) != null) {
            rb6Var.F(bdUniqueId);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rb6 rb6Var = this.c;
            if (rb6Var == null) {
                return false;
            }
            return rb6Var.k();
        }
        return invokeV.booleanValue;
    }

    public List g() {
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
            return yr4.c.length;
        }
        return invokeV.intValue;
    }

    public void i() {
        rb6 rb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (rb6Var = this.c) != null) {
            rb6Var.x();
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
        ob6 ob6Var;
        yr4 yr4Var;
        g gVar;
        h hVar;
        sb6 sb6Var;
        wb6 wb6Var;
        xb6 xb6Var;
        vb6 vb6Var;
        tb6 tb6Var;
        ub6 ub6Var;
        nb6 nb6Var;
        l96 l96Var;
        mb6 mb6Var;
        f96 f96Var;
        na6 na6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0272, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092203);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f18);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906dc);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof j96) {
                        j96 j96Var = (j96) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (j96Var != null) {
                            iVar.a.setText(j96Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            h96 h96Var = this.h;
                            if ((h96Var != null && h96Var.a) || j96Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (j96Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (j96Var.g != -1) {
                                layoutParams.setMargins(fj.f(viewGroup.getContext(), j96Var.g), 0, fj.f(viewGroup.getContext(), j96Var.g), 0);
                            }
                            if (j96Var.i != -1) {
                                nv4.d(iVar.a).z(j96Var.i);
                            }
                            if (j96Var.h != -1) {
                                layoutParams.height = fj.f(viewGroup.getContext(), j96Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (j96Var.j != -1) {
                                iVar.c.setPadding(fj.f(viewGroup.getContext(), j96Var.j), 0, fj.f(viewGroup.getContext(), j96Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof ob6)) {
                        ob6Var = (ob6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0390, viewGroup, false);
                        ob6Var = new ob6(this.a, view2, this.b);
                        view2.setTag(ob6Var);
                    }
                    if ((this.f.get(i2) instanceof yr4) && (yr4Var = (yr4) this.f.get(i2)) != null) {
                        ob6Var.f(yr4Var);
                    }
                    ob6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0271, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a47);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906dc);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026f, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091c69);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e88);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d74);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a47);
                        sy4 sy4Var = new sy4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(sy4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f058e);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f3));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06e9);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f1));
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
                        View o = this.c.o();
                        this.c.z();
                        return o;
                    }
                    return view2;
                case 5:
                    o();
                    if (view2 != null && (view2.getTag() instanceof sb6)) {
                        sb6Var = (sb6) view2.getTag();
                    } else {
                        sb6Var = new sb6(this.a);
                        view2 = sb6Var.b();
                        view2.setTag(sb6Var);
                    }
                    sb6Var.a();
                    sb6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof wb6)) {
                        wb6Var = (wb6) view2.getTag();
                    } else {
                        wb6Var = new wb6(this.a);
                        view2 = wb6Var.d();
                        view2.setTag(wb6Var);
                    }
                    if (this.f.get(i2) instanceof rt4) {
                        wb6Var.c((rt4) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z = false;
                        }
                        wb6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof xb6)) {
                        xb6Var = (xb6) view2.getTag();
                    } else {
                        xb6Var = new xb6(this.a);
                        view2 = xb6Var.k();
                        view2.setTag(xb6Var);
                    }
                    if (this.f.get(i2) instanceof pt4) {
                        pt4 pt4Var = (pt4) this.f.get(i2);
                        xb6Var.g(pt4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(pt4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", pt4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                if (this.e.D().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i3 = 3;
                                }
                                statisticItem.param("obj_type", i3);
                                xb6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(pt4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof vb6)) {
                        vb6Var = (vb6) view2.getTag();
                    } else {
                        vb6Var = new vb6(this.a);
                        view2 = vb6Var.c();
                        view2.setTag(vb6Var);
                    }
                    if (this.f.get(i2) instanceof qt4) {
                        vb6Var.b((qt4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof tb6)) {
                        tb6Var = (tb6) view2.getTag();
                    } else {
                        tb6Var = new tb6(this.a);
                        view2 = tb6Var.d();
                        view2.setTag(tb6Var);
                    }
                    if (this.f.get(i2) instanceof d96) {
                        tb6Var.c((d96) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z2 = false;
                        }
                        tb6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof ub6)) {
                        ub6Var = (ub6) view2.getTag();
                    } else {
                        ub6Var = new ub6(this.a);
                        view2 = ub6Var.b();
                        view2.setTag(ub6Var);
                    }
                    ub6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof nb6)) {
                        nb6Var = (nb6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0521, viewGroup, false);
                        nb6Var = new nb6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(nb6Var);
                    }
                    if ((this.f.get(i2) instanceof l96) && (l96Var = (l96) this.f.get(i2)) != null) {
                        nb6Var.f(l96Var);
                    }
                    nb6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof mb6)) {
                        mb6Var = (mb6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01dd, viewGroup, false);
                        mb6Var = new mb6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(mb6Var);
                    }
                    if ((this.f.get(i2) instanceof f96) && (f96Var = (f96) this.f.get(i2)) != null && !ListUtils.isEmpty(f96Var.j())) {
                        mb6Var.f(f96Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof na6)) {
                        na6Var = (na6) view2.getTag();
                    } else {
                        na6Var = new na6(this.a);
                        view2 = na6Var.a();
                        view2.setTag(na6Var);
                    }
                    if (this.f.get(i2) instanceof ja6) {
                        ja6 ja6Var = (ja6) this.f.get(i2);
                        na6Var.a().setData(ja6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (ja6Var == null) {
                            str = "";
                        } else {
                            str = ja6Var.j();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (ja6Var != null) {
                            str2 = ja6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void m(List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            u96 u96Var = this.d;
            if (u96Var != null) {
                u96Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
