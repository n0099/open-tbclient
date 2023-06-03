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
public abstract class db9 extends jb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public j39 c;
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

    public abstract void C(j39 j39Var);

    public void D(p49 p49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p49Var) == null) {
        }
    }

    public abstract void E(j39 j39Var);

    public abstract void F(String str);

    public abstract j79 e();

    public abstract d69 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(j39 j39Var, boolean z, String str, boolean z2);

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

    public db9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        j39 j39Var;
        dy9 dy9Var;
        dy9 dy9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (j39Var = this.c) == null || j39Var.Z || j39Var.a0 == 2) {
            return;
        }
        ArrayList<ey9> F = j39Var.F();
        ArrayList<dy9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<dy9> it = d.iterator();
            while (it.hasNext()) {
                dy9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<dy9> it2 = d.iterator();
            while (it2.hasNext()) {
                dy9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<dy9> it3 = d.iterator();
            while (it3.hasNext()) {
                dy9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        sn9.j(next3, i);
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
                dy9 dy9Var3 = (dy9) sparseArray.get(sparseArray.keyAt(i2));
                if (dy9Var3 != null && (dy9Var2 = (dy9) hashMap.put(dy9Var3.s1(), dy9Var3)) != null) {
                    sn9.j(dy9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (dy9Var = (dy9) entry.getValue()) != null) {
                    sparseArray.put(dy9Var.getPosition(), dy9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                dy9 dy9Var4 = (dy9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    dy9Var4.d1 = this.c.k().getId();
                }
                if (this.c.N() != null) {
                    dy9Var4.g1 = tg.g(this.c.N().getId(), 0L);
                }
                j39 j39Var2 = this.c;
                if (j39Var2 != null && j39Var2.y() != null) {
                    dy9Var4.h1 = this.c.y().a();
                }
                b(dy9Var4);
                int position = dy9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    dy9Var4.j1 = position;
                    sn9.k(dy9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    dy9Var4.j1 = position;
                }
                if (position < 0) {
                    sn9.j(dy9Var4, 23);
                } else if (h(F, position)) {
                    sn9.j(dy9Var4, 1);
                } else {
                    F.add(position, dy9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", dy9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jb9
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

    public final void b(dy9 dy9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dy9Var) == null) && dy9Var != null && this.c != null && dy9Var.getAdvertAppInfo() != null) {
            dy9Var.getAdvertAppInfo().i = new k15();
            if (this.c.y() != null) {
                dy9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            dy9Var.getAdvertAppInfo().i.a = dy9Var.u1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                dy9Var.getAdvertAppInfo().i.c = k.getId();
                dy9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                dy9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                dy9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            dy9Var.getAdvertAppInfo().i.g = dy9Var.getAdvertAppInfo().g;
            dy9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<ey9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof dy9) {
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
                if (this.f.get(i) instanceof z39) {
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

    public void r(j39 j39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, j39Var) == null) {
            s(j39Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(j39 j39Var, boolean z) {
        dy9 dy9Var;
        ey9 ey9Var;
        boolean z2;
        j39 j39Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, j39Var, z) != null) || j39Var == null) {
            return;
        }
        this.c = j39Var;
        if (j39Var != null && j39Var.N() != null && j39Var.N().getAuthor() != null) {
            this.g = j39Var.N().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<ey9> it = j39Var.F().iterator();
        while (true) {
            dy9Var = null;
            if (it.hasNext()) {
                ey9 next = it.next();
                if (next instanceof ey9) {
                    ey9Var = next;
                    if (ey9Var.D() == 1) {
                        break;
                    }
                }
            } else {
                ey9Var = null;
                break;
            }
        }
        if (ey9Var == null && j39Var.i() != null) {
            ey9Var = j39Var.i();
        }
        if (ey9Var != null) {
            this.f.add(ey9Var);
        }
        E(j39Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(j39Var.F()) && j39Var.F().get(0) != null && j39Var.N() != null) {
            j39Var.N().setItem(j39Var.F().get(0).S());
            j39Var.N().setItemStar(j39Var.F().get(0).T());
        }
        if (j39Var.N() != null && j39Var.N().getRawThreadInfo() != null) {
            l45 l45Var = new l45();
            l45Var.t = j39Var.N();
            l45Var.n = true;
            this.f.add(l45Var);
        }
        a49 a49Var = new a49(j39Var.N(), j39Var.c());
        a49Var.h(false);
        a49Var.b = false;
        this.f.add(a49Var);
        if (ey9Var != null && ey9Var.r0 != null && (j39Var.k() == null || !TextUtils.equals(j39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            m39 m39Var = new m39(ey9Var.r0);
            m39Var.b = this.a.Q().R1();
            this.f.add(m39Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && j39Var.k() != null && !StringUtils.isNull(j39Var.k().getName()) && (!TextUtils.equals(j39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            l39 l39Var = new l39(j39Var.k());
            l39Var.g = this.a.Q().R1();
            l39Var.e = false;
            this.f.add(l39Var);
            a49Var.h(false);
            a49Var.b = false;
        }
        if (j39Var.N() != null && !StringUtils.isNull(j39Var.N().getForum_name())) {
            f49 f49Var = new f49();
            f49Var.a = j39Var.N();
            this.f.add(f49Var);
        } else if (j39Var.N() != null && !StringUtils.isNull(j39Var.m())) {
            j39Var.N().setForum_name(j39Var.m());
            f49 f49Var2 = new f49();
            f49Var2.a = j39Var.N();
            this.f.add(f49Var2);
        }
        if (j() && j39Var.y() != null && j39Var.y().c() == 1) {
            u39 u39Var = new u39(u39.c);
            u39Var.b(true);
            this.f.add(u39Var);
        }
        z39 z39Var = new z39(z39.g);
        z39Var.c = k();
        z39Var.b = j39Var.g;
        z39Var.d = j39Var.i0();
        z39Var.e = j39Var.f;
        C(j39Var);
        this.f.add(z39Var);
        if (j39Var.J() == 4) {
            this.f.add(new y39());
        }
        G();
        p(i());
        Iterator<ey9> it2 = j39Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            ey9 next2 = it2.next();
            if ((next2 instanceof ey9) && next2.D() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((j39Var2 = this.c) == null || !j39Var2.s()))) {
            w39 w39Var = new w39();
            w39Var.c1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            w39Var.b1 = R.drawable.new_pic_emotion_03;
            w39Var.d1 = vi.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(w39Var);
        }
        q(j39Var, this.i, this.g, this.h);
        if (j39Var.y().b() == 0) {
            j39 j39Var3 = this.c;
            if (j39Var3 != null && j39Var3.s()) {
                B(this.a.N().t3());
                this.f.add(new t39());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().t3());
                s39 s39Var = new s39();
                s39Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(s39Var);
            }
            List<dy9> Z = j39Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                dy9Var = Z.get(0);
                i2 = dy9Var.getPosition();
            }
            if (!ListUtils.isEmpty(j39Var.e())) {
                int i3 = 1;
                for (w15 w15Var : j39Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (dy9Var != null) {
                            b(dy9Var);
                            this.f.add(dy9Var);
                            i++;
                            if (dy9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            dy9 dy9Var2 = Z.get(i);
                            dy9Var = dy9Var2;
                            i2 = dy9Var2.getPosition();
                        }
                    }
                    this.f.add(w15Var);
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
