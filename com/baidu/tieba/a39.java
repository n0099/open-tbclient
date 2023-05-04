package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.view.SortSwitchButton;
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
public abstract class a39 extends g39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public qv8 c;
    public final List<vm> d;
    public boolean e;
    public ArrayList<in> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(qv8 qv8Var);

    public void D(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uw8Var) == null) {
        }
    }

    public abstract void E(qv8 qv8Var);

    public abstract void F(String str);

    public abstract kz8 e();

    public abstract hy8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(qv8 qv8Var, boolean z, String str, boolean z2);

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
        }
    }

    public abstract void v(boolean z);

    public void w(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, a0Var) == null) {
        }
    }

    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onLongClickListener) == null) {
        }
    }

    public void y(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
        }
    }

    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
        }
    }

    public a39(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
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
        this.e = true;
        this.g = null;
        this.h = true;
        this.i = false;
        this.k = -1;
        this.l = -1;
        this.a = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.N() != null && detailInfoAndReplyFragment.N().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.N().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
    }

    public final void G() {
        qv8 qv8Var;
        op9 op9Var;
        op9 op9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (qv8Var = this.c) == null || qv8Var.Z || qv8Var.a0 == 2) {
            return;
        }
        ArrayList<pp9> F = qv8Var.F();
        ArrayList<op9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<op9> it = d.iterator();
            while (it.hasNext()) {
                op9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<op9> it2 = d.iterator();
            while (it2.hasNext()) {
                op9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<op9> it3 = d.iterator();
            while (it3.hasNext()) {
                op9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        of9.j(next3, h);
                        if (h != 28 && h != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + h);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                op9 op9Var3 = (op9) sparseArray.get(sparseArray.keyAt(i));
                if (op9Var3 != null && (op9Var2 = (op9) hashMap.put(op9Var3.s1(), op9Var3)) != null) {
                    of9.j(op9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (op9Var = (op9) entry.getValue()) != null) {
                    sparseArray.put(op9Var.getPosition(), op9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                op9 op9Var4 = (op9) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    op9Var4.d1 = this.c.k().getId();
                }
                if (this.c.M() != null) {
                    op9Var4.g1 = gg.g(this.c.M().getId(), 0L);
                }
                qv8 qv8Var2 = this.c;
                if (qv8Var2 != null && qv8Var2.y() != null) {
                    op9Var4.h1 = this.c.y().a();
                }
                b(op9Var4);
                int position = op9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    op9Var4.j1 = position;
                    of9.k(op9Var4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    op9Var4.j1 = position;
                }
                if (position < 0) {
                    of9.j(op9Var4, 23);
                } else if (h(F, position)) {
                    of9.j(op9Var4, 1);
                } else {
                    F.add(position, op9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", op9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.g39
    public ArrayList<in> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (12 == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a.Q() != null) {
                return this.a.Q().c1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(op9 op9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, op9Var) == null) && op9Var != null && this.c != null && op9Var.getAdvertAppInfo() != null) {
            op9Var.getAdvertAppInfo().i = new fx4();
            if (this.c.y() != null) {
                op9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            op9Var.getAdvertAppInfo().i.a = op9Var.u1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                op9Var.getAdvertAppInfo().i.c = k.getId();
                op9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                op9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                op9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            op9Var.getAdvertAppInfo().i.g = op9Var.getAdvertAppInfo().g;
            op9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<pp9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof op9) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = false;
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) instanceof ew8) {
                    this.k = i;
                    z = true;
                }
            }
            if (!z) {
                this.k = -1;
            }
            this.l = -1;
        }
    }

    public void r(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, qv8Var) == null) {
            s(qv8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(qv8 qv8Var, boolean z) {
        op9 op9Var;
        pp9 pp9Var;
        boolean z2;
        qv8 qv8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, qv8Var, z) != null) || qv8Var == null) {
            return;
        }
        this.c = qv8Var;
        if (qv8Var != null && qv8Var.M() != null && qv8Var.M().getAuthor() != null) {
            this.g = qv8Var.M().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<pp9> it = qv8Var.F().iterator();
        while (true) {
            op9Var = null;
            if (it.hasNext()) {
                pp9 next = it.next();
                if (next instanceof pp9) {
                    pp9Var = next;
                    if (pp9Var.D() == 1) {
                        break;
                    }
                }
            } else {
                pp9Var = null;
                break;
            }
        }
        if (pp9Var == null && qv8Var.i() != null) {
            pp9Var = qv8Var.i();
        }
        if (pp9Var != null) {
            this.f.add(pp9Var);
        }
        E(qv8Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(qv8Var.F()) && qv8Var.F().get(0) != null && qv8Var.M() != null) {
            qv8Var.M().setItem(qv8Var.F().get(0).S());
            qv8Var.M().setItemStar(qv8Var.F().get(0).T());
        }
        if (qv8Var.M() != null && qv8Var.M().getRawThreadInfo() != null) {
            f05 f05Var = new f05();
            f05Var.t = qv8Var.M();
            f05Var.n = true;
            this.f.add(f05Var);
        }
        fw8 fw8Var = new fw8(qv8Var.M(), qv8Var.c());
        fw8Var.g(false);
        fw8Var.b = false;
        this.f.add(fw8Var);
        if (pp9Var != null && pp9Var.r0 != null && (qv8Var.k() == null || !TextUtils.equals(qv8Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1())) {
            tv8 tv8Var = new tv8(pp9Var.r0);
            tv8Var.b = this.a.Q().S1();
            this.f.add(tv8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && qv8Var.k() != null && !StringUtils.isNull(qv8Var.k().getName()) && (!TextUtils.equals(qv8Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1())) {
            sv8 sv8Var = new sv8(qv8Var.k());
            sv8Var.g = this.a.Q().S1();
            sv8Var.e = false;
            this.f.add(sv8Var);
            fw8Var.g(false);
            fw8Var.b = false;
        }
        if (qv8Var.M() != null && !StringUtils.isNull(qv8Var.M().getForum_name())) {
            kw8 kw8Var = new kw8();
            kw8Var.a = qv8Var.M();
            this.f.add(kw8Var);
        } else if (qv8Var.M() != null && !StringUtils.isNull(qv8Var.m())) {
            qv8Var.M().setForum_name(qv8Var.m());
            kw8 kw8Var2 = new kw8();
            kw8Var2.a = qv8Var.M();
            this.f.add(kw8Var2);
        }
        if (j() && qv8Var.y() != null && qv8Var.y().c() == 1) {
            zv8 zv8Var = new zv8(zv8.c);
            zv8Var.b(true);
            this.f.add(zv8Var);
        }
        ew8 ew8Var = new ew8(ew8.g);
        ew8Var.c = k();
        ew8Var.b = qv8Var.g;
        ew8Var.d = qv8Var.h0();
        ew8Var.e = qv8Var.f;
        C(qv8Var);
        this.f.add(ew8Var);
        if (qv8Var.J() == 4) {
            this.f.add(new dw8());
        }
        G();
        p(i());
        Iterator<pp9> it2 = qv8Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            pp9 next2 = it2.next();
            if ((next2 instanceof pp9) && next2.D() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((qv8Var2 = this.c) == null || !qv8Var2.s()))) {
            bw8 bw8Var = new bw8();
            bw8Var.c1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            bw8Var.b1 = R.drawable.new_pic_emotion_03;
            bw8Var.d1 = ii.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(bw8Var);
        }
        q(qv8Var, this.i, this.g, this.h);
        if (qv8Var.y().b() == 0) {
            qv8 qv8Var3 = this.c;
            if (qv8Var3 != null && qv8Var3.s()) {
                B(this.a.N().r3());
                this.f.add(new yv8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.O());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().r3());
                xv8 xv8Var = new xv8();
                xv8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(xv8Var);
            }
            List<op9> Y = qv8Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                op9Var = Y.get(0);
                i2 = op9Var.getPosition();
            }
            if (!ListUtils.isEmpty(qv8Var.e())) {
                int i3 = 1;
                for (rx4 rx4Var : qv8Var.e()) {
                    if (Y != null && i3 == i2) {
                        if (op9Var != null) {
                            b(op9Var);
                            this.f.add(op9Var);
                            i++;
                            if (op9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            op9 op9Var2 = Y.get(i);
                            op9Var = op9Var2;
                            i2 = op9Var2.getPosition();
                        }
                    }
                    this.f.add(rx4Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f);
        }
        o();
    }
}
