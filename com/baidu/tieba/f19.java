package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonMountCard.TbMountCardLinkLayout;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f19 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinkedList<lw4> b;
    public LinkedList<dp4> c;
    public d d;

    /* loaded from: classes4.dex */
    public class a implements xv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f19 b;

        public a(f19 f19Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f19Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f19Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.xv4
        public void a(String str) {
            lw4 g;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && "4".equals(str) && (g = this.b.g(this.a)) != null) {
                if (this.b.d != null) {
                    this.b.d.b(g.e());
                }
                if (this.b.d != null) {
                    this.b.d.a(this.b.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f19 b;

        public b(f19 f19Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f19Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f19Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            lw4 g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.b.g(this.a)) == null) {
                return;
            }
            if (this.b.d != null) {
                this.b.d.b(g.e());
            }
            if (this.b.d != null) {
                this.b.d.a(this.b.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMountCardLinkLayout a;

        public c(f19 f19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(f19 f19Var, a aVar) {
            this(f19Var);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(List<dp4> list);

        void b(int i);
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public View c;
        public TbImageView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public View i;

        public e(f19 f19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(f19 f19Var, a aVar) {
            this(f19Var);
        }
    }

    public f19(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList<>();
        this.a = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.clear();
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            Iterator<lw4> it = this.b.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.v() != null) {
                        dp4 v = tbLinkSpanGroup.v();
                        v.q = tbLinkSpanGroup.f();
                        this.c.add(v);
                    }
                }
            }
            Collections.sort(this.c);
        }
    }

    public LinkedList<dp4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.c)) {
                return true;
            }
            Iterator<dp4> it = this.c.iterator();
            while (it.hasNext()) {
                dp4 next = it.next();
                if (next.b == 2 || !next.i) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<lw4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (LinkedList) invokeV.objValue;
    }

    public lw4 g(int i) {
        InterceptResult invokeI;
        LinkedList<lw4> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.b) != null) {
                Iterator<lw4> it = linkedList.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (lw4) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<dp4> linkedList = this.c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<dp4> linkedList = this.c;
            if (linkedList == null || linkedList.size() <= i) {
                return null;
            }
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            LinkedList<dp4> linkedList = this.c;
            return (linkedList == null || linkedList.size() <= i || this.c.get(i) == null) ? 0 : this.c.get(i).a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        dp4 dp4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            LinkedList<dp4> linkedList = this.c;
            return (linkedList == null || linkedList.size() <= i || (dp4Var = this.c.get(i)) == null || dp4Var.o != 4) ? 0 : 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        View view3;
        c cVar;
        View view4;
        TbMountCardLinkLayout tbMountCardLinkLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            dp4 dp4Var = (dp4) getItem(i);
            if (dp4Var == null) {
                return null;
            }
            if (getItemViewType(i) == 1) {
                if (view2 == null) {
                    view4 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d091b, (ViewGroup) null);
                    c cVar2 = new c(this, null);
                    cVar2.a = (TbMountCardLinkLayout) view4.findViewById(R.id.obfuscated_res_0x7f092658);
                    view4.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = view2.getTag() instanceof c ? (c) view2.getTag() : null;
                    view4 = view2;
                }
                if (cVar != null && (tbMountCardLinkLayout = cVar.a) != null) {
                    tbMountCardLinkLayout.setData(dp4Var.p);
                    tbMountCardLinkLayout.setClickListener(new a(this, i));
                }
                return view4;
            }
            if (view2 == null) {
                view3 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03e6, (ViewGroup) null);
                eVar = new e(this, null);
                eVar.a = view3.findViewById(R.id.obfuscated_res_0x7f090681);
                eVar.b = view3.findViewById(R.id.obfuscated_res_0x7f09067f);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f09067d);
                eVar.d = tbImageView;
                tbImageView.setConrers(15);
                eVar.d.setRadius(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                eVar.d.setPlaceHolderAutoChangeSkinType(1);
                eVar.d.setGifIconSupport(false);
                eVar.d.setLongIconSupport(false);
                eVar.d.setDrawBorder(true);
                eVar.d.setBorderWidth(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                eVar.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                eVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09067c);
                eVar.f = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09067b);
                eVar.c = view3.findViewById(R.id.obfuscated_res_0x7f090953);
                eVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090680);
                eVar.h = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09067a);
                eVar.i = view3.findViewById(R.id.obfuscated_res_0x7f090682);
                view3.setTag(eVar);
            } else {
                eVar = (e) view2.getTag();
                view3 = view2;
            }
            eVar.d.K(dp4Var.e, 10, false);
            if (TextUtils.isEmpty(dp4Var.f)) {
                eVar.c.setVisibility(8);
                eVar.e.setMaxLines(2);
            } else {
                eVar.c.setVisibility(0);
                eVar.e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(dp4Var.f)) {
                eVar.g.setVisibility(8);
            } else {
                eVar.g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0415), dp4Var.f));
                eVar.g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(dp4Var.l)) {
                spannableStringBuilder.append((CharSequence) dp4Var.l);
                int f = ri.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int f4 = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f5 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f6 = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                wu4 wu4Var = new wu4(f, -1, R.color.CAM_X0305, f3, R.color.CAM_X0305, f4, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                wu4Var.b(f2);
                wu4Var.h(f5);
                wu4Var.i(f6);
                spannableStringBuilder.setSpan(wu4Var, 0, dp4Var.l.length(), 17);
            }
            if (!dp4Var.n && dp4Var.b != 2 && !dp4Var.i) {
                String str = dp4Var.g;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                eVar.e.setMaxLines(1);
            } else {
                String str2 = dp4Var.c;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            eVar.e.setText(spannableStringBuilder);
            eVar.f.setOnClickListener(new b(this, i));
            ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            SkinManager.setBackgroundShapeDrawable(eVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
            ns4 d2 = ns4.d(eVar.b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            eVar.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080803, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(eVar.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(eVar.g, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(eVar.h, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(eVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c();
            notifyDataSetChanged();
        }
    }

    public void i(LinkedList<lw4> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.d = dVar;
        }
    }
}
