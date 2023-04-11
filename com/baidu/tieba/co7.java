package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class co7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ko7> a;
    public TbPageContext b;
    public int c;
    public int d;
    public BdUniqueId e;
    public boolean f;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public BarImageView b;
        public ImageView c;

        public b(co7 co7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(co7 co7Var, a aVar) {
            this(co7Var);
        }
    }

    public co7(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.f = false;
        this.b = tbPageContext;
        this.e = bdUniqueId;
        this.d = i;
        this.c = p45.m().n("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0107);
        SkinManager.setImageResource(bVar.c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.c = i;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return ListUtils.getItem(this.a, i);
        }
        return invokeI.objValue;
    }

    public void b(List<ko7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
            if (!this.f && !ListUtils.isEmpty(list)) {
                for (ko7 ko7Var : list) {
                    if (!StringUtils.isNull(ko7Var.c)) {
                        cg.h().m(ko7Var.c, 10, null, this.e);
                    }
                }
                this.f = true;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bVar = new b(this, null);
                view3 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d039c, (ViewGroup) null);
                bVar.a = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090f8f);
                bVar.b = (BarImageView) view3.findViewById(R.id.obfuscated_res_0x7f090f8d);
                bVar.c = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090f8e);
                bVar.b.setShowOval(true);
                bVar.b.setAutoChangeStyle(true);
                bVar.b.setBorderColor(this.b.getResources().getColor(R.color.black_alpha8));
                bVar.b.setBorderWidth(this.b.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view3.setTag(bVar);
            } else {
                view3 = view2;
                bVar = (b) view2.getTag();
            }
            a(bVar);
            ko7 ko7Var = (ko7) ListUtils.getItem(this.a, i);
            if (ko7Var != null) {
                TextView textView = bVar.a;
                if (StringUtils.isNull(ko7Var.b)) {
                    str = "";
                } else {
                    str = ko7Var.b;
                }
                textView.setText(str);
                bVar.b.N(ko7Var.c, 10, false);
                if (ko7Var.d == 1) {
                    bVar.b.setAlpha(1);
                    bVar.a.setAlpha(1.0f);
                } else {
                    bVar.b.setAlpha(0.5f);
                    bVar.a.setAlpha(0.5f);
                }
                if (ko7Var.a == this.c && this.d != 101) {
                    bVar.c.setVisibility(0);
                } else {
                    bVar.c.setVisibility(8);
                }
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
