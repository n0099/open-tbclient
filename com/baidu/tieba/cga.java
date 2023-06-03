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
import com.baidu.tbadk.core.view.commonGroupChatCard.TbGroupChatCardLinkLayout;
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
/* loaded from: classes5.dex */
public class cga extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinkedList<db5> b;
    public LinkedList<d25> c;
    public f d;

    /* loaded from: classes5.dex */
    public interface f {
        void a(List<d25> list);

        void b(int i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ma5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cga b;

        public a(cga cgaVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cgaVar;
            this.a = i;
        }

        @Override // com.baidu.tieba.ma5
        public void a(String str) {
            db5 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !"4".equals(str) || (g = this.b.g(this.a)) == null) {
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

    /* loaded from: classes5.dex */
    public class b implements TbGroupChatCardLinkLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cga b;

        public b(cga cgaVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cgaVar;
            this.a = i;
        }

        @Override // com.baidu.tbadk.core.view.commonGroupChatCard.TbGroupChatCardLinkLayout.b
        public void a(TbGroupChatCardLinkLayout.ClickType clickType) {
            db5 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, clickType) != null) || clickType != TbGroupChatCardLinkLayout.ClickType.CLICK_CLOSE || (g = this.b.g(this.a)) == null) {
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cga b;

        public c(cga cgaVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cgaVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            db5 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (g = this.b.g(this.a)) == null) {
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

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbGroupChatCardLinkLayout a;

        public d(cga cgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(cga cgaVar, a aVar) {
            this(cgaVar);
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMountCardLinkLayout a;

        public e(cga cgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(cga cgaVar, a aVar) {
            this(cgaVar);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
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

        public g(cga cgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(cga cgaVar, a aVar) {
            this(cgaVar);
        }
    }

    public cga(TbPageContext tbPageContext) {
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

    public db5 g(int i) {
        InterceptResult invokeI;
        LinkedList<db5> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.b) != null) {
                Iterator<db5> it = linkedList.iterator();
                while (it.hasNext()) {
                    db5 next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (db5) invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        d25 d25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            LinkedList<d25> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && (d25Var = this.c.get(i)) != null) {
                int i2 = d25Var.o;
                if (i2 == 4) {
                    return 1;
                }
                if (i2 == 5) {
                    return 2;
                }
                return 0;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<d25> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i) {
                return this.c.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            LinkedList<d25> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && this.c.get(i) != null) {
                i2 = this.c.get(i).a;
            } else {
                i2 = 0;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    public void i(LinkedList<db5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.clear();
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            Iterator<db5> it = this.b.iterator();
            while (it.hasNext()) {
                db5 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.v() != null) {
                        d25 v = tbLinkSpanGroup.v();
                        v.q = tbLinkSpanGroup.f();
                        this.c.add(v);
                    }
                }
            }
            Collections.sort(this.c);
        }
    }

    public LinkedList<d25> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<db5> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<d25> linkedList = this.c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
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
            Iterator<d25> it = this.c.iterator();
            while (it.hasNext()) {
                d25 next = it.next();
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

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        g gVar;
        View view3;
        TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout;
        View view4;
        TbMountCardLinkLayout tbMountCardLinkLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            d25 d25Var = (d25) getItem(i);
            d dVar = null;
            e eVar = null;
            if (d25Var == null) {
                return null;
            }
            if (getItemViewType(i) == 1) {
                if (view2 == null) {
                    view4 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.write_link_mount_card_item_layout, (ViewGroup) null);
                    e eVar2 = new e(this, null);
                    eVar2.a = (TbMountCardLinkLayout) view4.findViewById(R.id.write_item_link_mount_card);
                    view4.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    if (view2.getTag() instanceof e) {
                        eVar = (e) view2.getTag();
                    }
                    view4 = view2;
                }
                if (eVar != null && (tbMountCardLinkLayout = eVar.a) != null) {
                    tbMountCardLinkLayout.setData(d25Var.p);
                    tbMountCardLinkLayout.setClickListener(new a(this, i));
                }
                return view4;
            } else if (getItemViewType(i) == 2) {
                if (view2 == null) {
                    TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout2 = new TbGroupChatCardLinkLayout(this.a.getPageActivity());
                    d dVar2 = new d(this, null);
                    dVar2.a = tbGroupChatCardLinkLayout2;
                    tbGroupChatCardLinkLayout2.setTag(dVar2);
                    dVar = dVar2;
                    tbGroupChatCardLinkLayout = tbGroupChatCardLinkLayout2;
                } else {
                    if (view2.getTag() instanceof d) {
                        dVar = (d) view2.getTag();
                    }
                    tbGroupChatCardLinkLayout = view2;
                }
                TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout3 = dVar.a;
                tbGroupChatCardLinkLayout3.c(d25Var);
                tbGroupChatCardLinkLayout3.setCardClickListener(new b(this, i));
                return tbGroupChatCardLinkLayout;
            } else {
                if (view2 == null) {
                    view3 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d044d, (ViewGroup) null);
                    gVar = new g(this, null);
                    gVar.a = view3.findViewById(R.id.obfuscated_res_0x7f090763);
                    gVar.b = view3.findViewById(R.id.obfuscated_res_0x7f090761);
                    TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f09075f);
                    gVar.d = tbImageView;
                    tbImageView.setConrers(15);
                    gVar.d.setRadius(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    gVar.d.setPlaceHolderAutoChangeSkinType(1);
                    gVar.d.setGifIconSupport(false);
                    gVar.d.setLongIconSupport(false);
                    gVar.d.setDrawBorder(true);
                    gVar.d.setBorderWidth(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                    gVar.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                    gVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09075e);
                    gVar.f = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09075d);
                    gVar.c = view3.findViewById(R.id.extra_info_container);
                    gVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090762);
                    gVar.h = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09075c);
                    gVar.i = view3.findViewById(R.id.obfuscated_res_0x7f090764);
                    view3.setTag(gVar);
                } else {
                    gVar = (g) view2.getTag();
                    view3 = view2;
                }
                gVar.d.N(d25Var.e, 10, false);
                if (TextUtils.isEmpty(d25Var.f)) {
                    gVar.c.setVisibility(8);
                    gVar.e.setMaxLines(2);
                } else {
                    gVar.c.setVisibility(0);
                    gVar.e.setMaxLines(1);
                }
                if (TextUtils.isEmpty(d25Var.f)) {
                    gVar.g.setVisibility(8);
                } else {
                    gVar.g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), d25Var.f));
                    gVar.g.setVisibility(0);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(d25Var.l)) {
                    spannableStringBuilder.append((CharSequence) d25Var.l);
                    int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int g5 = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int g6 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int g7 = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    p95 p95Var = new p95(g2, -1, R.color.CAM_X0305, g4, R.color.CAM_X0305, g5, vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    p95Var.b(g3);
                    p95Var.h(g6);
                    p95Var.i(g7);
                    spannableStringBuilder.setSpan(p95Var, 0, d25Var.l.length(), 17);
                }
                if (!d25Var.n && d25Var.b != 2 && !d25Var.i) {
                    String str = d25Var.g;
                    if (str != null) {
                        spannableStringBuilder.append((CharSequence) str);
                    }
                    gVar.e.setMaxLines(1);
                } else {
                    String str2 = d25Var.c;
                    if (str2 != null) {
                        spannableStringBuilder.append((CharSequence) str2);
                    }
                }
                gVar.e.setText(spannableStringBuilder);
                gVar.f.setOnClickListener(new c(this, i));
                SkinManager.setBackgroundShapeDrawable(gVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
                m75 d2 = m75.d(gVar.b);
                d2.o(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                WebPManager.setPureDrawable(gVar.f, R.drawable.icon_pure_mount_card_link_right_del, R.color.CAM_X0108, null);
                SkinManager.setViewTextColor(gVar.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(gVar.g, (int) R.color.CAM_X0305);
                SkinManager.setViewTextColor(gVar.h, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColorToTransparent(gVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
                return view3;
            }
        }
        return (View) invokeILL.objValue;
    }
}
