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
public class ih8 extends xh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public v98 c;
    public final List<qn> d;
    public kc8 e;
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
    public TbRichTextView.a0 q;
    public xa8 r;
    public View.OnLongClickListener s;

    public ih8(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.xh8
    public ArrayList<Cdo> a() {
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

    public final void b(j29 j29Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j29Var) == null) && j29Var != null && this.c != null && j29Var.getAdvertAppInfo() != null) {
            j29Var.getAdvertAppInfo().i = new xw4();
            if (this.c.z() != null) {
                j29Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            j29Var.getAdvertAppInfo().i.a = j29Var.r1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                j29Var.getAdvertAppInfo().i.c = l.getId();
                j29Var.getAdvertAppInfo().i.d = l.getFirst_class();
                j29Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                j29Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            j29Var.getAdvertAppInfo().i.g = j29Var.getAdvertAppInfo().g;
            j29Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof j29) {
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
            kc8 kc8Var = new kc8(this.a.J(), PostData.Q0);
            this.e = kc8Var;
            kc8Var.x0(this.a.J());
            this.f = new PbReplyLoadMoreAdapter(this.a.J(), PostData.X0);
            this.g = qs8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = qs8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, v98Var) != null) || v98Var == null) {
            return;
        }
        this.c = v98Var;
        if (v98Var != null && v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
            this.l = v98Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        v98 v98Var2 = this.c;
        if (v98Var2 != null && v98Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(v98Var);
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
        qn qnVar = this.h;
        if (qnVar != null && (qnVar instanceof ms8)) {
            ((ms8) qnVar).setIsFromCDN(this.n);
        }
        ArrayList<Cdo> arrayList = new ArrayList<>(v98Var.H());
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
                if (postData2.F() == 1) {
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

    public void j(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, a0Var) == null) {
            this.q = a0Var;
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

    public void m(xa8 xa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xa8Var) == null) {
            this.r = xa8Var;
        }
    }

    public final void n() {
        v98 v98Var;
        j29 j29Var;
        j29 j29Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (v98Var = this.c) == null || v98Var.c0 || v98Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = v98Var.H();
        ArrayList<j29> e = this.c.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<j29> it = e.iterator();
            while (it.hasNext()) {
                j29 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<j29> it2 = e.iterator();
            while (it2.hasNext()) {
                j29 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<j29> it3 = e.iterator();
            while (it3.hasNext()) {
                j29 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        du8.j(next3, m);
                        if (m != 28 && m != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + m);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                j29 j29Var3 = (j29) sparseArray.get(sparseArray.keyAt(i));
                if (j29Var3 != null && (j29Var2 = (j29) hashMap.put(j29Var3.p1(), j29Var3)) != null) {
                    du8.j(j29Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (j29Var = (j29) entry.getValue()) != null) {
                    sparseArray.put(j29Var.getPosition(), j29Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                j29 j29Var4 = (j29) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.l() != null) {
                    j29Var4.b1 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    j29Var4.e1 = dh.g(this.c.Q().getId(), 0L);
                }
                v98 v98Var2 = this.c;
                if (v98Var2 != null && v98Var2.z() != null) {
                    j29Var4.f1 = this.c.z().a();
                }
                b(j29Var4);
                int position = j29Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    j29Var4.h1 = position;
                    du8.k(j29Var4, 2, position + i3, mv7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    j29Var4.h1 = position;
                }
                if (position < 0) {
                    du8.j(j29Var4, 23);
                } else if (c(H, position)) {
                    du8.j(j29Var4, 1);
                } else {
                    H.add(position, j29Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", j29Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
