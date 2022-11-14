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
/* loaded from: classes3.dex */
public class a58 extends p58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public ox7 c;
    public final List<kn> d;
    public d08 e;
    public PbReplyLoadMoreAdapter f;
    public kn g;
    public kn h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<xn> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public qy7 r;
    public View.OnLongClickListener s;

    public a58(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.p58
    public ArrayList<xn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public final void b(kp8 kp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp8Var) == null) && kp8Var != null && this.c != null && kp8Var.getAdvertAppInfo() != null) {
            kp8Var.getAdvertAppInfo().i = new xr4();
            if (this.c.z() != null) {
                kp8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            kp8Var.getAdvertAppInfo().i.a = kp8Var.o1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                kp8Var.getAdvertAppInfo().i.c = l.getId();
                kp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                kp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                kp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            kp8Var.getAdvertAppInfo().i.g = kp8Var.getAdvertAppInfo().g;
            kp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof kp8) {
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
            d08 d08Var = new d08(this.a.B(), PostData.N0);
            this.e = d08Var;
            d08Var.x0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.U0);
            this.g = gg8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = gg8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ox7Var) != null) || ox7Var == null) {
            return;
        }
        this.c = ox7Var;
        if (ox7Var != null && ox7Var.Q() != null && ox7Var.Q().getAuthor() != null) {
            this.l = ox7Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        ox7 ox7Var2 = this.c;
        if (ox7Var2 != null && ox7Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(ox7Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.w0(this.r);
        this.f.w(this.p);
        n();
        kn knVar = this.h;
        if (knVar != null && (knVar instanceof cg8)) {
            ((cg8) knVar).setIsFromCDN(this.n);
        }
        ArrayList<xn> arrayList = new ArrayList<>(ox7Var.H());
        boolean z = false;
        PostData postData = null;
        Iterator<xn> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            xn next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.D() == 1) {
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

    public void m(qy7 qy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qy7Var) == null) {
            this.r = qy7Var;
        }
    }

    public final void n() {
        ox7 ox7Var;
        kp8 kp8Var;
        kp8 kp8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (ox7Var = this.c) == null || ox7Var.c0 || ox7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = ox7Var.H();
        ArrayList<kp8> e = this.c.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<kp8> it = e.iterator();
            while (it.hasNext()) {
                kp8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<kp8> it2 = e.iterator();
            while (it2.hasNext()) {
                kp8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<kp8> it3 = e.iterator();
            while (it3.hasNext()) {
                kp8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        th8.j(next3, n);
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
                kp8 kp8Var3 = (kp8) sparseArray.get(sparseArray.keyAt(i));
                if (kp8Var3 != null && (kp8Var2 = (kp8) hashMap.put(kp8Var3.m1(), kp8Var3)) != null) {
                    th8.j(kp8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (kp8Var = (kp8) entry.getValue()) != null) {
                    sparseArray.put(kp8Var.getPosition(), kp8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                kp8 kp8Var4 = (kp8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.l() != null) {
                    kp8Var4.Y0 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    kp8Var4.b1 = xg.g(this.c.Q().getId(), 0L);
                }
                ox7 ox7Var2 = this.c;
                if (ox7Var2 != null && ox7Var2.z() != null) {
                    kp8Var4.c1 = this.c.z().a();
                }
                b(kp8Var4);
                int position = kp8Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    kp8Var4.e1 = position;
                    th8.k(kp8Var4, 2, position + i3, gj7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    kp8Var4.e1 = position;
                }
                if (position < 0) {
                    th8.j(kp8Var4, 23);
                } else if (c(H, position)) {
                    th8.j(kp8Var4, 1);
                } else {
                    H.add(position, kp8Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", kp8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
