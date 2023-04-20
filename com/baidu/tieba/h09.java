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
/* loaded from: classes4.dex */
public abstract class h09 extends n09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public ht8 c;
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

    public abstract void C(ht8 ht8Var);

    public void D(ku8 ku8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ku8Var) == null) {
        }
    }

    public abstract void E(ht8 ht8Var);

    public abstract void F(String str);

    public abstract xw8 e();

    public abstract vv8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(ht8 ht8Var, boolean z, String str, boolean z2);

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

    public h09(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.M() != null && detailInfoAndReplyFragment.M().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.M().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
    }

    public final void G() {
        ht8 ht8Var;
        zl9 zl9Var;
        zl9 zl9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (ht8Var = this.c) == null || ht8Var.Z || ht8Var.a0 == 2) {
            return;
        }
        ArrayList<am9> F = ht8Var.F();
        ArrayList<zl9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<zl9> it = d.iterator();
            while (it.hasNext()) {
                zl9 next = it.next();
                if (next != null && next.r1() != null) {
                    sb.append(next.r1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<zl9> it2 = d.iterator();
            while (it2.hasNext()) {
                zl9 next2 = it2.next();
                if (next2 != null) {
                    next2.i1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<zl9> it3 = d.iterator();
            while (it3.hasNext()) {
                zl9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        rc9.j(next3, i);
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
                zl9 zl9Var3 = (zl9) sparseArray.get(sparseArray.keyAt(i2));
                if (zl9Var3 != null && (zl9Var2 = (zl9) hashMap.put(zl9Var3.q1(), zl9Var3)) != null) {
                    rc9.j(zl9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (zl9Var = (zl9) entry.getValue()) != null) {
                    sparseArray.put(zl9Var.getPosition(), zl9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                zl9 zl9Var4 = (zl9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    zl9Var4.c1 = this.c.k().getId();
                }
                if (this.c.M() != null) {
                    zl9Var4.f1 = gg.g(this.c.M().getId(), 0L);
                }
                ht8 ht8Var2 = this.c;
                if (ht8Var2 != null && ht8Var2.y() != null) {
                    zl9Var4.g1 = this.c.y().a();
                }
                b(zl9Var4);
                int position = zl9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    zl9Var4.i1 = position;
                    rc9.k(zl9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    zl9Var4.i1 = position;
                }
                if (position < 0) {
                    rc9.j(zl9Var4, 23);
                } else if (h(F, position)) {
                    rc9.j(zl9Var4, 1);
                } else {
                    F.add(position, zl9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zl9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.n09
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
            if (this.a.P() != null) {
                return this.a.P().X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(zl9 zl9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zl9Var) == null) && zl9Var != null && this.c != null && zl9Var.getAdvertAppInfo() != null) {
            zl9Var.getAdvertAppInfo().i = new pw4();
            if (this.c.y() != null) {
                zl9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            zl9Var.getAdvertAppInfo().i.a = zl9Var.s1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                zl9Var.getAdvertAppInfo().i.c = k.getId();
                zl9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                zl9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                zl9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            zl9Var.getAdvertAppInfo().i.g = zl9Var.getAdvertAppInfo().g;
            zl9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<am9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof zl9) {
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
                if (this.f.get(i) instanceof ut8) {
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

    public void r(ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ht8Var) == null) {
            s(ht8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(ht8 ht8Var, boolean z) {
        zl9 zl9Var;
        am9 am9Var;
        boolean z2;
        ht8 ht8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, ht8Var, z) != null) || ht8Var == null) {
            return;
        }
        this.c = ht8Var;
        if (ht8Var != null && ht8Var.M() != null && ht8Var.M().getAuthor() != null) {
            this.g = ht8Var.M().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<am9> it = ht8Var.F().iterator();
        while (true) {
            zl9Var = null;
            if (it.hasNext()) {
                am9 next = it.next();
                if (next instanceof am9) {
                    am9Var = next;
                    if (am9Var.E() == 1) {
                        break;
                    }
                }
            } else {
                am9Var = null;
                break;
            }
        }
        if (am9Var == null && ht8Var.i() != null) {
            am9Var = ht8Var.i();
        }
        if (am9Var != null) {
            this.f.add(am9Var);
        }
        E(ht8Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(ht8Var.F()) && ht8Var.F().get(0) != null && ht8Var.M() != null) {
            ht8Var.M().setItem(ht8Var.F().get(0).S());
            ht8Var.M().setItemStar(ht8Var.F().get(0).T());
        }
        if (ht8Var.M() != null && ht8Var.M().getRawThreadInfo() != null) {
            pz4 pz4Var = new pz4();
            pz4Var.t = ht8Var.M();
            pz4Var.n = true;
            this.f.add(pz4Var);
        }
        vt8 vt8Var = new vt8(ht8Var.M(), ht8Var.c());
        vt8Var.h(false);
        vt8Var.b = false;
        this.f.add(vt8Var);
        if (am9Var != null && am9Var.r0 != null && (ht8Var.k() == null || !TextUtils.equals(ht8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0())) {
            kt8 kt8Var = new kt8(am9Var.r0);
            kt8Var.b = this.a.P().N1();
            this.f.add(kt8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && ht8Var.k() != null && !StringUtils.isNull(ht8Var.k().getName()) && (!TextUtils.equals(ht8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0())) {
            jt8 jt8Var = new jt8(ht8Var.k());
            jt8Var.g = this.a.P().N1();
            jt8Var.e = false;
            this.f.add(jt8Var);
            vt8Var.h(false);
            vt8Var.b = false;
        }
        if (ht8Var.M() != null && !StringUtils.isNull(ht8Var.M().getForum_name())) {
            au8 au8Var = new au8();
            au8Var.a = ht8Var.M();
            this.f.add(au8Var);
        } else if (ht8Var.M() != null && !StringUtils.isNull(ht8Var.m())) {
            ht8Var.M().setForum_name(ht8Var.m());
            au8 au8Var2 = new au8();
            au8Var2.a = ht8Var.M();
            this.f.add(au8Var2);
        }
        if (j() && ht8Var.y() != null && ht8Var.y().c() == 1) {
            pt8 pt8Var = new pt8(pt8.c);
            pt8Var.b(true);
            this.f.add(pt8Var);
        }
        ut8 ut8Var = new ut8(ut8.g);
        ut8Var.c = k();
        ut8Var.b = ht8Var.g;
        ut8Var.d = ht8Var.h0();
        ut8Var.e = ht8Var.f;
        C(ht8Var);
        this.f.add(ut8Var);
        if (ht8Var.J() == 4) {
            this.f.add(new tt8());
        }
        G();
        p(i());
        Iterator<am9> it2 = ht8Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            am9 next2 = it2.next();
            if ((next2 instanceof am9) && next2.E() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((ht8Var2 = this.c) == null || !ht8Var2.s()))) {
            rt8 rt8Var = new rt8();
            rt8Var.b1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            rt8Var.a1 = R.drawable.new_pic_emotion_03;
            rt8Var.c1 = -2;
            rt8Var.d1 = ii.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(rt8Var);
        }
        q(ht8Var, this.i, this.g, this.h);
        if (ht8Var.y().b() == 0) {
            ht8 ht8Var3 = this.c;
            if (ht8Var3 != null && ht8Var3.s()) {
                B(this.a.M().q3());
                this.f.add(new ot8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.O());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.M().q3());
                nt8 nt8Var = new nt8();
                nt8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(nt8Var);
            }
            List<zl9> Y = ht8Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                zl9Var = Y.get(0);
                i2 = zl9Var.getPosition();
            }
            if (!ListUtils.isEmpty(ht8Var.e())) {
                int i3 = 1;
                for (bx4 bx4Var : ht8Var.e()) {
                    if (Y != null && i3 == i2) {
                        if (zl9Var != null) {
                            b(zl9Var);
                            this.f.add(zl9Var);
                            i++;
                            if (zl9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            zl9 zl9Var2 = Y.get(i);
                            zl9Var = zl9Var2;
                            i2 = zl9Var2.getPosition();
                        }
                    }
                    this.f.add(bx4Var);
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
