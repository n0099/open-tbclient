package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class c08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public GameVideoGridView c;
    public xz7 d;
    public TextView e;
    public b f;
    public BdUniqueId g;
    public AdapterView.OnItemClickListener h;

    /* loaded from: classes5.dex */
    public interface b {
        void a(f08 f08Var);
    }

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c08 a;

        public a(c08 c08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c08Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.d != null && i < this.a.d.getCount() && this.a.d.getItem(i) != null && (this.a.d.getItem(i) instanceof f08)) {
                f08 f08Var = (f08) this.a.d.getItem(i);
                if (f08Var.d == 1) {
                    this.a.d.c(f08Var.a);
                    if (this.a.f != null) {
                        this.a.f.a(f08Var);
                    }
                    this.a.d();
                    SharedPrefHelper.getInstance().putInt("key_game_video_tab_has_choosed_sub_class_id", f08Var.a);
                    SharedPrefHelper.getInstance().putString("key_game_video_tab_has_choosed_sub_class_name", f08Var.b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", f08Var.a));
                }
            }
        }
    }

    public c08(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = tbPageContext;
        this.g = bdUniqueId;
        e();
    }

    public void h(List<f08> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.b(list);
        this.d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void c(ViewGroup viewGroup) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && viewGroup != null && (view2 = this.b) != null) {
            if (view2.getParent() != null) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            viewGroup.addView(this.b);
            TiebaStatic.log("c13484");
        }
    }

    public void d() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (view2 = this.b) != null && view2.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            View view2 = this.b;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (gameVideoGridView = this.c) != null) {
            gameVideoGridView.d();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03ce, (ViewGroup) null);
            this.b = inflate;
            this.c = (GameVideoGridView) inflate.findViewById(R.id.obfuscated_res_0x7f09100f);
            this.d = new xz7(this.a, 101, this.g);
            this.c.setNumColumns(4);
            this.c.setAdapter((ListAdapter) this.d);
            this.c.setOnItemClickListener(this.h);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091010);
            f();
        }
    }
}
