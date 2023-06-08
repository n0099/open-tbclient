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
/* loaded from: classes5.dex */
public abstract class gb9 extends mb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public m39 c;
    public final List<in> d;
    public boolean e;
    public ArrayList<vn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(m39 m39Var);

    public void D(s49 s49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s49Var) == null) {
        }
    }

    public abstract void E(m39 m39Var);

    public abstract void F(String str);

    public abstract m79 e();

    public abstract g69 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(m39 m39Var, boolean z, String str, boolean z2);

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

    public gb9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        m39 m39Var;
        iy9 iy9Var;
        iy9 iy9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (m39Var = this.c) == null || m39Var.Z || m39Var.a0 == 2) {
            return;
        }
        ArrayList<jy9> F = m39Var.F();
        ArrayList<iy9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<iy9> it = d.iterator();
            while (it.hasNext()) {
                iy9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<iy9> it2 = d.iterator();
            while (it2.hasNext()) {
                iy9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<iy9> it3 = d.iterator();
            while (it3.hasNext()) {
                iy9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        xn9.j(next3, i);
                        if (i != 28 && i != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + i);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iy9 iy9Var3 = (iy9) sparseArray.get(sparseArray.keyAt(i2));
                if (iy9Var3 != null && (iy9Var2 = (iy9) hashMap.put(iy9Var3.s1(), iy9Var3)) != null) {
                    xn9.j(iy9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (iy9Var = (iy9) entry.getValue()) != null) {
                    sparseArray.put(iy9Var.getPosition(), iy9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                iy9 iy9Var4 = (iy9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    iy9Var4.d1 = this.c.k().getId();
                }
                if (this.c.N() != null) {
                    iy9Var4.g1 = tg.g(this.c.N().getId(), 0L);
                }
                m39 m39Var2 = this.c;
                if (m39Var2 != null && m39Var2.y() != null) {
                    iy9Var4.h1 = this.c.y().a();
                }
                b(iy9Var4);
                int position = iy9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    iy9Var4.j1 = position;
                    xn9.k(iy9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    iy9Var4.j1 = position;
                }
                if (position < 0) {
                    xn9.j(iy9Var4, 23);
                } else if (h(F, position)) {
                    xn9.j(iy9Var4, 1);
                } else {
                    F.add(position, iy9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", iy9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mb9
    public ArrayList<vn> a() {
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
                return this.a.Q().b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(iy9 iy9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iy9Var) == null) && iy9Var != null && this.c != null && iy9Var.getAdvertAppInfo() != null) {
            iy9Var.getAdvertAppInfo().i = new m15();
            if (this.c.y() != null) {
                iy9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            iy9Var.getAdvertAppInfo().i.a = iy9Var.u1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                iy9Var.getAdvertAppInfo().i.c = k.getId();
                iy9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                iy9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                iy9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            iy9Var.getAdvertAppInfo().i.g = iy9Var.getAdvertAppInfo().g;
            iy9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<jy9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof iy9) {
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
                if (this.f.get(i) instanceof c49) {
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

    public void r(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, m39Var) == null) {
            s(m39Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(m39 m39Var, boolean z) {
        iy9 iy9Var;
        jy9 jy9Var;
        boolean z2;
        m39 m39Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, m39Var, z) != null) || m39Var == null) {
            return;
        }
        this.c = m39Var;
        if (m39Var != null && m39Var.N() != null && m39Var.N().getAuthor() != null) {
            this.g = m39Var.N().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<jy9> it = m39Var.F().iterator();
        while (true) {
            iy9Var = null;
            if (it.hasNext()) {
                jy9 next = it.next();
                if (next instanceof jy9) {
                    jy9Var = next;
                    if (jy9Var.D() == 1) {
                        break;
                    }
                }
            } else {
                jy9Var = null;
                break;
            }
        }
        if (jy9Var == null && m39Var.i() != null) {
            jy9Var = m39Var.i();
        }
        if (jy9Var != null) {
            this.f.add(jy9Var);
        }
        E(m39Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(m39Var.F()) && m39Var.F().get(0) != null && m39Var.N() != null) {
            m39Var.N().setItem(m39Var.F().get(0).S());
            m39Var.N().setItemStar(m39Var.F().get(0).T());
        }
        if (m39Var.N() != null && m39Var.N().getRawThreadInfo() != null) {
            n45 n45Var = new n45();
            n45Var.t = m39Var.N();
            n45Var.n = true;
            this.f.add(n45Var);
        }
        d49 d49Var = new d49(m39Var.N(), m39Var.c());
        d49Var.h(false);
        d49Var.b = false;
        this.f.add(d49Var);
        if (jy9Var != null && jy9Var.r0 != null && (m39Var.k() == null || !TextUtils.equals(m39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            p39 p39Var = new p39(jy9Var.r0);
            p39Var.b = this.a.Q().R1();
            this.f.add(p39Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && m39Var.k() != null && !StringUtils.isNull(m39Var.k().getName()) && (!TextUtils.equals(m39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            o39 o39Var = new o39(m39Var.k());
            o39Var.g = this.a.Q().R1();
            o39Var.e = false;
            this.f.add(o39Var);
            d49Var.h(false);
            d49Var.b = false;
        }
        if (m39Var.N() != null && !StringUtils.isNull(m39Var.N().getForum_name())) {
            i49 i49Var = new i49();
            i49Var.a = m39Var.N();
            this.f.add(i49Var);
        } else if (m39Var.N() != null && !StringUtils.isNull(m39Var.m())) {
            m39Var.N().setForum_name(m39Var.m());
            i49 i49Var2 = new i49();
            i49Var2.a = m39Var.N();
            this.f.add(i49Var2);
        }
        if (j() && m39Var.y() != null && m39Var.y().c() == 1) {
            x39 x39Var = new x39(x39.c);
            x39Var.b(true);
            this.f.add(x39Var);
        }
        c49 c49Var = new c49(c49.g);
        c49Var.c = k();
        c49Var.b = m39Var.g;
        c49Var.d = m39Var.i0();
        c49Var.e = m39Var.f;
        C(m39Var);
        this.f.add(c49Var);
        if (m39Var.J() == 4) {
            this.f.add(new b49());
        }
        G();
        p(i());
        Iterator<jy9> it2 = m39Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            jy9 next2 = it2.next();
            if ((next2 instanceof jy9) && next2.D() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((m39Var2 = this.c) == null || !m39Var2.s()))) {
            z39 z39Var = new z39();
            z39Var.c1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            z39Var.b1 = R.drawable.new_pic_emotion_03;
            z39Var.d1 = vi.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(z39Var);
        }
        q(m39Var, this.i, this.g, this.h);
        if (m39Var.y().b() == 0) {
            m39 m39Var3 = this.c;
            if (m39Var3 != null && m39Var3.s()) {
                B(this.a.N().t3());
                this.f.add(new w39());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().t3());
                v39 v39Var = new v39();
                v39Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(v39Var);
            }
            List<iy9> Z = m39Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                iy9Var = Z.get(0);
                i2 = iy9Var.getPosition();
            }
            if (!ListUtils.isEmpty(m39Var.e())) {
                int i3 = 1;
                for (y15 y15Var : m39Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (iy9Var != null) {
                            b(iy9Var);
                            this.f.add(iy9Var);
                            i++;
                            if (iy9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            iy9 iy9Var2 = Z.get(i);
                            iy9Var = iy9Var2;
                            i2 = iy9Var2.getPosition();
                        }
                    }
                    this.f.add(y15Var);
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
