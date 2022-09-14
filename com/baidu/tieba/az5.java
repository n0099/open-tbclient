package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class az5 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public List<bz5> b;
    public d c;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz5 a;
        public final /* synthetic */ az5 b;

        public a(az5 az5Var, bz5 bz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az5Var, bz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = az5Var;
            this.a = bz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.c == null) {
                return;
            }
            this.b.c.a(this.a.b(0));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz5 a;
        public final /* synthetic */ az5 b;

        public b(az5 az5Var, bz5 bz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az5Var, bz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = az5Var;
            this.a = bz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.c == null) {
                return;
            }
            this.b.c.a(this.a.b(1));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz5 a;
        public final /* synthetic */ az5 b;

        public c(az5 az5Var, bz5 bz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az5Var, bz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = az5Var;
            this.a = bz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.c == null) {
                return;
            }
            this.b.c.a(this.a.b(2));
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(cz5 cz5Var);
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public RelativeLayout d;
        public TextView e;
        public TextView f;
        public TbImageView g;
        public TextView h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(az5 az5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(az5 az5Var, a aVar) {
            this(az5Var);
        }
    }

    public az5(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = tbPageContext;
        this.c = dVar;
    }

    public final List<bz5> b(List<dz5> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                List<cz5> a2 = list.get(i2).a();
                int size = a2.size();
                if (size % 3 == 0) {
                    i = size / 3;
                } else {
                    i = (size / 3) + 1;
                }
                cz5[][] cz5VarArr = (cz5[][]) Array.newInstance(cz5.class, i, 3);
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = i3 / 3;
                    int i5 = i3 % 3;
                    cz5VarArr[i4][i5] = a2.get(i3);
                    cz5VarArr[i4][i5].o(list.get(i2).b());
                }
                arrayList2.add(cz5VarArr);
            }
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                for (int i7 = 0; i7 < ((cz5[][]) arrayList2.get(i6)).length; i7++) {
                    bz5 bz5Var = new bz5();
                    if (((cz5[][]) arrayList2.get(i6)).length == 1) {
                        bz5Var.e(1);
                    } else if (((cz5[][]) arrayList2.get(i6)).length > 1 && i7 == 0) {
                        bz5Var.e(2);
                    } else if (((cz5[][]) arrayList2.get(i6)).length > 1 && i7 == ((cz5[][]) arrayList2.get(i6)).length - 1) {
                        bz5Var.e(3);
                    } else {
                        bz5Var.e(4);
                    }
                    if (i6 == arrayList2.size() - 1) {
                        if (bz5Var.getType() == 1) {
                            bz5Var.e(2);
                        } else if (bz5Var.getType() == 3) {
                            bz5Var.e(4);
                        }
                    }
                    for (int i8 = 0; i8 < 3; i8++) {
                        if (((cz5[][]) arrayList2.get(i6))[i7][i8] != null) {
                            bz5Var.a(((cz5[][]) arrayList2.get(i6))[i7][i8]);
                        }
                    }
                    if (((cz5[][]) arrayList2.get(i6))[0][0] != null) {
                        bz5Var.d(((cz5[][]) arrayList2.get(i6))[0][0].h());
                    }
                    arrayList.add(bz5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.q, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5d);
            eVar.g.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5d);
            eVar.l.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5d);
        } else {
            eVar.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5c);
            eVar.g.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5c);
            eVar.l.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5c);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<dz5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        List<bz5> list2 = this.b;
        if (list2 != null && list2.size() > 0) {
            this.b.clear();
        }
        this.b = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbImageView, i) == null) || tbImageView == null) {
            return;
        }
        if (i == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{textView, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                textView.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void g(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i) == null) || textView == null) {
            return;
        }
        if (i == 0) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f4);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i == 1) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f5);
            SkinManager.setViewTextColor(textView, (int) R.color.obfuscated_res_0x7f06079e);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i == 2) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f3);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i == 3) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f2);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<bz5> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<bz5> list = this.b;
            if (list == null || i >= list.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            bz5 bz5Var = this.b.get(i);
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00e3, viewGroup, false);
                eVar = new e(this, null);
                eVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b7);
                eVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b2);
                eVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ba);
                eVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901bd);
                eVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c0);
                eVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b8);
                eVar.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b3);
                eVar.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bb);
                eVar.i = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901be);
                eVar.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c1);
                eVar.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b9);
                eVar.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b4);
                eVar.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bc);
                eVar.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901bf);
                eVar.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
                eVar.p = view2.findViewById(R.id.obfuscated_res_0x7f0901b5);
                eVar.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b6);
            } else {
                eVar = (e) view2.getTag();
            }
            c(eVar);
            if (bz5Var != null) {
                if (bz5Var.b(0) != null) {
                    cz5 b2 = bz5Var.b(0);
                    eVar.d.setVisibility(0);
                    eVar.a.setText(b2.e() == null ? "" : b2.e());
                    if (b2.f() != null) {
                        eVar.b.setDefaultBgResource(R.color.transparent);
                        eVar.b.K(b2.f(), 10, false);
                    }
                    g(eVar.c, b2.j());
                    e(eVar.b, b2.j());
                    f(eVar.e, b2.m(), b2.n);
                    eVar.d.setOnClickListener(new a(this, bz5Var));
                } else {
                    eVar.d.setVisibility(4);
                    eVar.d.setOnClickListener(null);
                }
                if (bz5Var.b(1) != null) {
                    cz5 b3 = bz5Var.b(1);
                    eVar.i.setVisibility(0);
                    eVar.f.setText(b3.e() == null ? "" : b3.e());
                    if (b3.f() != null) {
                        eVar.g.setDefaultBgResource(R.color.transparent);
                        eVar.g.K(b3.f(), 10, false);
                    }
                    g(eVar.h, b3.j());
                    e(eVar.g, b3.j());
                    f(eVar.j, b3.m(), b3.n);
                    eVar.i.setOnClickListener(new b(this, bz5Var));
                } else {
                    eVar.i.setVisibility(4);
                    eVar.i.setOnClickListener(null);
                }
                if (bz5Var.b(2) != null) {
                    cz5 b4 = bz5Var.b(2);
                    eVar.n.setVisibility(0);
                    eVar.k.setText(b4.e() != null ? b4.e() : "");
                    if (b4.f() != null) {
                        eVar.l.setDefaultBgResource(R.color.transparent);
                        eVar.l.K(b4.f(), 10, false);
                    }
                    g(eVar.m, b4.j());
                    e(eVar.l, b4.j());
                    f(eVar.o, b4.m(), b4.n);
                    eVar.n.setOnClickListener(new c(this, bz5Var));
                } else {
                    eVar.n.setVisibility(4);
                    eVar.n.setOnClickListener(null);
                }
                if (bz5Var.getType() != 3 && bz5Var.getType() != 1) {
                    eVar.p.setVisibility(8);
                } else {
                    eVar.p.setVisibility(0);
                }
                if ((bz5Var.getType() == 1 || bz5Var.getType() == 2) && bz5Var.c() != null) {
                    eVar.q.setVisibility(0);
                    eVar.q.setText(bz5Var.c());
                } else {
                    eVar.q.setVisibility(8);
                }
            }
            view2.setTag(eVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
