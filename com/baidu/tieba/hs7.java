package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.gs7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hs7 implements cs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public gs7.e b;
    public Context c;
    public List<fh7> d;
    public gs7 e;
    public final BaseAdapter f;
    public AdapterView.OnItemClickListener g;

    @Override // com.baidu.tieba.cs7
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs7 a;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        public a(hs7 hs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public fh7 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.d == null) {
                    return null;
                }
                return (fh7) this.a.d.get(i);
            }
            return (fh7) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.d == null) {
                    return 0;
                }
                return this.a.d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0940, (ViewGroup) null);
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275)));
                    gs7.f fVar = new gs7.f();
                    fVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092357);
                    fVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092354);
                    fVar.c = view2.findViewById(R.id.obfuscated_res_0x7f092356);
                    fVar.d = view2.findViewById(R.id.obfuscated_res_0x7f092355);
                    view2.setTag(fVar);
                }
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0201);
                gs7.f fVar2 = (gs7.f) view2.getTag();
                fh7 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                fVar2.a.setText(item.a);
                if (item.c) {
                    SkinManager.setViewTextColor(fVar2.a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(fVar2.b, R.drawable.chx_tips_list_ok);
                    fVar2.b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(fVar2.a, R.color.CAM_X0108, 1);
                    fVar2.b.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    fVar2.d.setVisibility(0);
                    fVar2.c.setVisibility(8);
                    SkinManager.setBackgroundColor(fVar2.d, R.color.CAM_X0204);
                } else {
                    fVar2.c.setVisibility(0);
                    fVar2.d.setVisibility(8);
                    SkinManager.setBackgroundColor(fVar2.c, R.color.CAM_X0204);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs7 a;

        public b(hs7 hs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs7Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.e != null) {
                    this.a.e.c();
                }
                if (this.a.f != null && this.a.b != null) {
                    for (fh7 fh7Var : this.a.d) {
                        if (fh7Var != null) {
                            fh7Var.c = false;
                        }
                    }
                    fh7 fh7Var2 = (fh7) this.a.f.getItem(i);
                    if (fh7Var2 != null) {
                        fh7Var2.c = true;
                        this.a.b.a(fh7Var2.b);
                    }
                }
            }
        }
    }

    public hs7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
    }

    @Override // com.baidu.tieba.cs7
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs7
    public void setData(List<fh7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.d = list;
            this.f.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.cs7
    public void a(Context context, gs7 gs7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, gs7Var) == null) && context != null && gs7Var != null) {
            this.c = context;
            this.e = gs7Var;
            this.b = gs7Var.d();
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdListView bdListView = new BdListView(this.c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.g);
            this.a.setAdapter((ListAdapter) this.f);
        }
    }
}
