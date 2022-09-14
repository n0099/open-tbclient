package com.baidu.tieba;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class g28 extends v28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public vu7 c;
    public final List<qn> d;
    public kx7 e;
    public PbReplyLoadMoreAdapter f;
    public qn g;
    public qn h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<Cdo> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public xv7 r;
    public View.OnLongClickListener s;

    public g28(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.b = bdTypeRecyclerView;
        d();
    }

    @Override // com.baidu.tieba.v28
    public ArrayList<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(um8 um8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, um8Var) == null) || um8Var == null || this.c == null || um8Var.getAdvertAppInfo() == null) {
            return;
        }
        um8Var.getAdvertAppInfo().i = new qq4();
        if (this.c.y() != null) {
            um8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        um8Var.getAdvertAppInfo().i.a = um8Var.l1();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            um8Var.getAdvertAppInfo().i.c = l.getId();
            um8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            um8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            um8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        um8Var.getAdvertAppInfo().i.g = um8Var.getAdvertAppInfo().g;
        um8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof um8) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kx7 kx7Var = new kx7(this.a.B(), PostData.K0);
            this.e = kx7Var;
            kx7Var.w0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.R0);
            this.g = md8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = md8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vu7Var) == null) || vu7Var == null) {
            return;
        }
        this.c = vu7Var;
        if (vu7Var != null && vu7Var.O() != null && vu7Var.O().getAuthor() != null) {
            this.l = vu7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        vu7 vu7Var2 = this.c;
        if (vu7Var2 != null && vu7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.r(vu7Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.v0(this.r);
        this.f.w(this.p);
        n();
        qn qnVar = this.h;
        if (qnVar != null && (qnVar instanceof id8)) {
            ((id8) qnVar).setIsFromCDN(this.n);
        }
        ArrayList<Cdo> arrayList = new ArrayList<>(vu7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<Cdo> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cdo next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.C() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yVar) == null) {
            this.q = yVar;
        }
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.s = onLongClickListener;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void m(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xv7Var) == null) {
            this.r = xv7Var;
        }
    }

    public final void n() {
        vu7 vu7Var;
        um8 um8Var;
        um8 um8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (vu7Var = this.c) == null || vu7Var.b0 || vu7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = vu7Var.F();
        ArrayList<um8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<um8> it = e.iterator();
        while (it.hasNext()) {
            um8 next = it.next();
            if (next != null && next.k1() != null) {
                sb.append(next.k1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<um8> it2 = e.iterator();
        while (it2.hasNext()) {
            um8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<um8> it3 = e.iterator();
        while (it3.hasNext()) {
            um8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ze8.j(next3, n);
                    if (n != 28 && n != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + n);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            um8 um8Var3 = (um8) sparseArray.get(sparseArray.keyAt(i));
            if (um8Var3 != null && (um8Var2 = (um8) hashMap.put(um8Var3.j1(), um8Var3)) != null) {
                ze8.j(um8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (um8Var = (um8) entry.getValue()) != null) {
                sparseArray.put(um8Var.getPosition(), um8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            um8 um8Var4 = (um8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                um8Var4.V0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                um8Var4.Y0 = dh.g(this.c.O().getId(), 0L);
            }
            vu7 vu7Var2 = this.c;
            if (vu7Var2 != null && vu7Var2.y() != null) {
                um8Var4.Z0 = this.c.y().a();
            }
            b(um8Var4);
            int position = um8Var4.getPosition() + this.c.a0;
            if (position >= F.size()) {
                um8Var4.b1 = position;
                ze8.k(um8Var4, 2, position + i3, mg7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                um8Var4.b1 = position;
            }
            if (position < 0) {
                ze8.j(um8Var4, 23);
            } else if (c(F, position)) {
                ze8.j(um8Var4, 1);
            } else {
                F.add(position, um8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", um8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
