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
public class f38 extends u38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public uv7 c;
    public final List d;
    public jy7 e;
    public PbReplyLoadMoreAdapter f;
    public rn g;
    public rn h;
    public boolean i;
    public ArrayList j;
    public ArrayList k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public ww7 r;
    public View.OnLongClickListener s;

    public f38(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.u38
    public ArrayList a() {
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

    public final void b(qn8 qn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qn8Var) == null) && qn8Var != null && this.c != null && qn8Var.getAdvertAppInfo() != null) {
            qn8Var.getAdvertAppInfo().i = new fr4();
            if (this.c.y() != null) {
                qn8Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            qn8Var.getAdvertAppInfo().i.a = qn8Var.m1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                qn8Var.getAdvertAppInfo().i.c = l.getId();
                qn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                qn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qn8Var.getAdvertAppInfo().i.g = qn8Var.getAdvertAppInfo().g;
            qn8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean c(ArrayList arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof qn8) {
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
            jy7 jy7Var = new jy7(this.a.B(), PostData.L0);
            this.e = jy7Var;
            jy7Var.v0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.S0);
            this.g = le8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = le8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, uv7Var) != null) || uv7Var == null) {
            return;
        }
        this.c = uv7Var;
        if (uv7Var != null && uv7Var.P() != null && uv7Var.P().getAuthor() != null) {
            this.l = uv7Var.P().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.clear();
        uv7 uv7Var2 = this.c;
        if (uv7Var2 != null && uv7Var2.G() != null && this.c.G().size() > 0) {
            this.j.addAll(this.c.G());
        }
        this.e.r(uv7Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.u0(this.r);
        this.f.w(this.p);
        n();
        rn rnVar = this.h;
        if (rnVar != null && (rnVar instanceof he8)) {
            ((he8) rnVar).setIsFromCDN(this.n);
        }
        ArrayList arrayList = new ArrayList(uv7Var.G());
        boolean z = false;
        PostData postData = null;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            eo eoVar = (eo) it.next();
            if (eoVar instanceof PostData) {
                PostData postData2 = (PostData) eoVar;
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

    public void m(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ww7Var) == null) {
            this.r = ww7Var;
        }
    }

    public final void n() {
        uv7 uv7Var;
        qn8 qn8Var;
        qn8 qn8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (uv7Var = this.c) == null || uv7Var.b0 || uv7Var.c0 == 2) {
            return;
        }
        ArrayList G = uv7Var.G();
        ArrayList e = this.c.e();
        if (e != null && !e.isEmpty() && G != null && !G.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = e.iterator();
            while (it.hasNext()) {
                qn8 qn8Var3 = (qn8) it.next();
                if (qn8Var3 != null && qn8Var3.l1() != null) {
                    sb.append(qn8Var3.l1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator it2 = e.iterator();
            while (it2.hasNext()) {
                qn8 qn8Var4 = (qn8) it2.next();
                if (qn8Var4 != null) {
                    qn8Var4.c1 = qn8Var4.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it3 = e.iterator();
            while (it3.hasNext()) {
                qn8 qn8Var5 = (qn8) it3.next();
                if (qn8Var5.getAdvertAppInfo() != null) {
                    int n = qn8Var5.getAdvertAppInfo().n();
                    if (n != 0) {
                        yf8.j(qn8Var5, n);
                        if (n != 28 && n != 31) {
                            qn8Var5.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + n);
                        }
                    }
                    sparseArray.put(qn8Var5.getPosition(), qn8Var5);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                qn8 qn8Var6 = (qn8) sparseArray.get(sparseArray.keyAt(i));
                if (qn8Var6 != null && (qn8Var2 = (qn8) hashMap.put(qn8Var6.k1(), qn8Var6)) != null) {
                    yf8.j(qn8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qn8Var = (qn8) entry.getValue()) != null) {
                    sparseArray.put(qn8Var.getPosition(), qn8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                qn8 qn8Var7 = (qn8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.l() != null) {
                    qn8Var7.W0 = this.c.l().getId();
                }
                if (this.c.P() != null) {
                    qn8Var7.Z0 = eh.g(this.c.P().getId(), 0L);
                }
                uv7 uv7Var2 = this.c;
                if (uv7Var2 != null && uv7Var2.y() != null) {
                    qn8Var7.a1 = this.c.y().a();
                }
                b(qn8Var7);
                int position = qn8Var7.getPosition() + this.c.a0;
                if (position >= G.size()) {
                    qn8Var7.c1 = position;
                    yf8.k(qn8Var7, 2, position + i3, lh7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    qn8Var7.c1 = position;
                }
                if (position < 0) {
                    yf8.j(qn8Var7, 23);
                } else if (c(G, position)) {
                    yf8.j(qn8Var7, 1);
                } else {
                    G.add(position, qn8Var7);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qn8Var7.getAdvertAppInfo().p);
                }
            }
        }
    }
}
