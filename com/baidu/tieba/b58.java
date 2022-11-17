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
public class b58 extends q58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public px7 c;
    public final List<kn> d;
    public e08 e;
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
    public ry7 r;
    public View.OnLongClickListener s;

    public b58(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.q58
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

    public final void b(lp8 lp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp8Var) == null) && lp8Var != null && this.c != null && lp8Var.getAdvertAppInfo() != null) {
            lp8Var.getAdvertAppInfo().i = new yr4();
            if (this.c.z() != null) {
                lp8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            lp8Var.getAdvertAppInfo().i.a = lp8Var.o1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                lp8Var.getAdvertAppInfo().i.c = l.getId();
                lp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                lp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lp8Var.getAdvertAppInfo().i.g = lp8Var.getAdvertAppInfo().g;
            lp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof lp8) {
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
            e08 e08Var = new e08(this.a.B(), PostData.N0);
            this.e = e08Var;
            e08Var.x0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.U0);
            this.g = hg8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = hg8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(px7 px7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, px7Var) != null) || px7Var == null) {
            return;
        }
        this.c = px7Var;
        if (px7Var != null && px7Var.Q() != null && px7Var.Q().getAuthor() != null) {
            this.l = px7Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        px7 px7Var2 = this.c;
        if (px7Var2 != null && px7Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(px7Var);
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
        if (knVar != null && (knVar instanceof dg8)) {
            ((dg8) knVar).setIsFromCDN(this.n);
        }
        ArrayList<xn> arrayList = new ArrayList<>(px7Var.H());
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

    public void m(ry7 ry7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ry7Var) == null) {
            this.r = ry7Var;
        }
    }

    public final void n() {
        px7 px7Var;
        lp8 lp8Var;
        lp8 lp8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (px7Var = this.c) == null || px7Var.c0 || px7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = px7Var.H();
        ArrayList<lp8> e = this.c.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<lp8> it = e.iterator();
            while (it.hasNext()) {
                lp8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<lp8> it2 = e.iterator();
            while (it2.hasNext()) {
                lp8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<lp8> it3 = e.iterator();
            while (it3.hasNext()) {
                lp8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        uh8.j(next3, n);
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
                lp8 lp8Var3 = (lp8) sparseArray.get(sparseArray.keyAt(i));
                if (lp8Var3 != null && (lp8Var2 = (lp8) hashMap.put(lp8Var3.m1(), lp8Var3)) != null) {
                    uh8.j(lp8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (lp8Var = (lp8) entry.getValue()) != null) {
                    sparseArray.put(lp8Var.getPosition(), lp8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                lp8 lp8Var4 = (lp8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.l() != null) {
                    lp8Var4.Y0 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    lp8Var4.b1 = xg.g(this.c.Q().getId(), 0L);
                }
                px7 px7Var2 = this.c;
                if (px7Var2 != null && px7Var2.z() != null) {
                    lp8Var4.c1 = this.c.z().a();
                }
                b(lp8Var4);
                int position = lp8Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    lp8Var4.e1 = position;
                    uh8.k(lp8Var4, 2, position + i3, hj7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    lp8Var4.e1 = position;
                }
                if (position < 0) {
                    uh8.j(lp8Var4, 23);
                } else if (c(H, position)) {
                    uh8.j(lp8Var4, 1);
                } else {
                    H.add(position, lp8Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", lp8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
