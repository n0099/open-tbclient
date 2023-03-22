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
import com.baidu.tieba.an6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.xo6;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class hm6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public xo6 c;
    public an6 d;
    public EnterForumModel e;
    public List<gx4> f;
    public boolean g;
    public nm6 h;
    public ro6 i;
    public HashSet<Long> j;

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm6 a;

        /* loaded from: classes4.dex */
        public class a implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    gd9.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        public e(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String R;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.T()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new hj5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.V().b();
                if (b2 != null) {
                    int S = b2.S();
                    if (S != 220012) {
                        if (S == 2121002) {
                            g95.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a3), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1529), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14b9), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (gi.isEmpty(b2.R())) {
                            R = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049f);
                        } else {
                            R = b2.R();
                        }
                        blockPopInfoData.block_info = R;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a1);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a66);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a0);
                    if (b2 != null) {
                        if (gi.isEmpty(b2.R())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a0);
                        } else {
                            string = b2.R();
                        }
                    }
                    g95.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a66), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements xo6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro6 a;
        public final /* synthetic */ hm6 b;

        public a(hm6 hm6Var, ro6 ro6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var, ro6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm6Var;
            this.a = ro6Var;
        }

        @Override // com.baidu.tieba.xo6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements an6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm6 a;

        public b(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm6Var;
        }

        @Override // com.baidu.tieba.an6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.d0(true, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm6 a;

        public c(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new hj5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm6 a;

        public d(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new hj5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(hm6 hm6Var, a aVar) {
            this(hm6Var);
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public g(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(hm6 hm6Var, a aVar) {
            this(hm6Var);
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(hm6 hm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(hm6 hm6Var, a aVar) {
            this(hm6Var);
        }
    }

    public hm6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, ro6Var};
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
        this.i = ro6Var;
        xo6 xo6Var = new xo6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = xo6Var;
        xo6Var.C(new a(this, ro6Var));
        this.e = enterForumModel;
        an6 an6Var = new an6(this.a.getPageActivity(), Integer.valueOf(gm6.a(1)).intValue(), 0, this.c);
        this.d = an6Var;
        an6Var.u(new b(this));
    }

    public void g(int i) {
        xo6 xo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (xo6Var = this.c) != null) {
            xo6Var.u(i);
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
            List<gx4> list = this.f;
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
        an6 an6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (an6Var = this.d) != null) {
            an6Var.t(i);
        }
    }

    public void k(nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nm6Var) == null) {
            if (nm6Var != this.h) {
                this.h = nm6Var;
                notifyDataSetChanged();
            }
            xo6 xo6Var = this.c;
            if (xo6Var != null) {
                xo6Var.A(nm6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        xo6 xo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (xo6Var = this.c) != null) {
            xo6Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xo6 xo6Var = this.c;
            if (xo6Var == null) {
                return false;
            }
            return xo6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<gx4> f() {
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
            return gx4.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        xo6 xo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (xo6Var = this.c) != null) {
            xo6Var.v();
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
        uo6 uo6Var;
        gx4 gx4Var;
        f fVar;
        g gVar;
        yo6 yo6Var;
        cp6 cp6Var;
        dp6 dp6Var;
        bp6 bp6Var;
        zo6 zo6Var;
        ap6 ap6Var;
        to6 to6Var;
        rm6 rm6Var;
        so6 so6Var;
        lm6 lm6Var;
        tn6 tn6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d028b, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923fe);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920e7);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09076e);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof pm6) {
                        pm6 pm6Var = (pm6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (pm6Var != null) {
                            hVar.a.setText(pm6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            nm6 nm6Var = this.h;
                            if ((nm6Var != null && nm6Var.a) || pm6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (pm6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (pm6Var.g != -1) {
                                layoutParams.setMargins(hi.g(viewGroup.getContext(), pm6Var.g), 0, hi.g(viewGroup.getContext(), pm6Var.g), 0);
                            }
                            if (pm6Var.i != -1) {
                                n15.d(hVar.a).A(pm6Var.i);
                            }
                            if (pm6Var.h != -1) {
                                layoutParams.height = hi.g(viewGroup.getContext(), pm6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (pm6Var.j != -1) {
                                hVar.c.setPadding(hi.g(viewGroup.getContext(), pm6Var.j), 0, hi.g(viewGroup.getContext(), pm6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof uo6)) {
                        uo6Var = (uo6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03c0, viewGroup, false);
                        uo6Var = new uo6(this.a, view2, this.b);
                        view2.setTag(uo6Var);
                    }
                    if ((this.f.get(i) instanceof gx4) && (gx4Var = this.f.get(i)) != null) {
                        uo6Var.f(gx4Var);
                    }
                    uo6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d028a, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f09076e);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0288, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091e2e);
                        gVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fe8);
                        gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ec9);
                        gVar.d = (TBSpecificationBtn) view2.findViewById(R.id.footer_text);
                        j45 j45Var = new j45();
                        gVar.d.setTextSize(R.dimen.tbds42);
                        gVar.d.setConfig(j45Var);
                        view2.setTag(gVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f05b7);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0416));
                        gVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(gVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f0730);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0414));
                        SkinManager.setImageResource(gVar.b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(gVar.c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(gVar.a, R.color.CAM_X0205);
                    gVar.d.k();
                    TBSpecificationBtn tBSpecificationBtn = gVar.d;
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
                    n();
                    if (view2 != null && (view2.getTag() instanceof yo6)) {
                        yo6Var = (yo6) view2.getTag();
                    } else {
                        yo6Var = new yo6(this.a);
                        view2 = yo6Var.b();
                        view2.setTag(yo6Var);
                    }
                    yo6Var.a();
                    yo6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof cp6)) {
                        cp6Var = (cp6) view2.getTag();
                    } else {
                        cp6Var = new cp6(this.a);
                        view2 = cp6Var.d();
                        view2.setTag(cp6Var);
                    }
                    if (this.f.get(i) instanceof yy4) {
                        cp6Var.c((yy4) this.f.get(i));
                    }
                    if (this.e.V() != null && this.e.V().e() != null && this.e.V().e().b() != null) {
                        if (this.e.V().e().b().size() <= 0) {
                            z = false;
                        }
                        cp6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof dp6)) {
                        dp6Var = (dp6) view2.getTag();
                    } else {
                        dp6Var = new dp6(this.a);
                        view2 = dp6Var.k();
                        view2.setTag(dp6Var);
                    }
                    if (this.f.get(i) instanceof wy4) {
                        wy4 wy4Var = (wy4) this.f.get(i);
                        dp6Var.g(wy4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(wy4Var.h()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", wy4Var.h());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.V() != null && this.e.V().e() != null && this.e.V().e().b() != null) {
                                if (this.e.V().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                dp6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(wy4Var.h()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof bp6)) {
                        bp6Var = (bp6) view2.getTag();
                    } else {
                        bp6Var = new bp6(this.a);
                        view2 = bp6Var.c();
                        view2.setTag(bp6Var);
                    }
                    if (this.f.get(i) instanceof xy4) {
                        bp6Var.b((xy4) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof zo6)) {
                        zo6Var = (zo6) view2.getTag();
                    } else {
                        zo6Var = new zo6(this.a);
                        view2 = zo6Var.d();
                        view2.setTag(zo6Var);
                    }
                    if (this.f.get(i) instanceof jm6) {
                        zo6Var.c((jm6) this.f.get(i));
                    }
                    if (this.e.V() != null && this.e.V().e() != null && this.e.V().e().b() != null) {
                        if (this.e.V().e().b().size() <= 0) {
                            z2 = false;
                        }
                        zo6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof ap6)) {
                        ap6Var = (ap6) view2.getTag();
                    } else {
                        ap6Var = new ap6(this.a);
                        view2 = ap6Var.b();
                        view2.setTag(ap6Var);
                    }
                    ap6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof to6)) {
                        to6Var = (to6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0565, viewGroup, false);
                        to6Var = new to6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(to6Var);
                    }
                    if ((this.f.get(i) instanceof rm6) && (rm6Var = (rm6) this.f.get(i)) != null) {
                        to6Var.f(rm6Var);
                    }
                    to6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof so6)) {
                        so6Var = (so6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01f0, viewGroup, false);
                        so6Var = new so6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(so6Var);
                    }
                    if ((this.f.get(i) instanceof lm6) && (lm6Var = (lm6) this.f.get(i)) != null && !ListUtils.isEmpty(lm6Var.h())) {
                        so6Var.f(lm6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof tn6)) {
                        tn6Var = (tn6) view2.getTag();
                    } else {
                        tn6Var = new tn6(this.a);
                        view2 = tn6Var.a();
                        view2.setTag(tn6Var);
                    }
                    if (this.f.get(i) instanceof pn6) {
                        pn6 pn6Var = (pn6) this.f.get(i);
                        tn6Var.a().setData(pn6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (pn6Var == null) {
                            str = "";
                        } else {
                            str = pn6Var.h();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (pn6Var != null) {
                            str2 = pn6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<gx4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            an6 an6Var = this.d;
            if (an6Var != null) {
                an6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
