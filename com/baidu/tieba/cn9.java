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
public abstract class cn9 extends in9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public ze9 c;
    public final List<ln> d;
    public boolean e;
    public ArrayList<yn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(ze9 ze9Var);

    public void D(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gg9Var) == null) {
        }
    }

    public abstract void E(ze9 ze9Var);

    public abstract void F(String str);

    public abstract zi9 e();

    public abstract uh9 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(ze9 ze9Var, boolean z, String str, boolean z2);

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
        }
    }

    public abstract void v(boolean z);

    public void w(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, zVar) == null) {
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

    public cn9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        ze9 ze9Var;
        xca xcaVar;
        xca xcaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (ze9Var = this.c) == null || ze9Var.Z || ze9Var.a0 == 2) {
            return;
        }
        ArrayList<yca> F = ze9Var.F();
        ArrayList<xca> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<xca> it = d.iterator();
            while (it.hasNext()) {
                xca next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<xca> it2 = d.iterator();
            while (it2.hasNext()) {
                xca next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<xca> it3 = d.iterator();
            while (it3.hasNext()) {
                xca next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        j0a.j(next3, h);
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
                xca xcaVar3 = (xca) sparseArray.get(sparseArray.keyAt(i));
                if (xcaVar3 != null && (xcaVar2 = (xca) hashMap.put(xcaVar3.z1(), xcaVar3)) != null) {
                    j0a.j(xcaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (xcaVar = (xca) entry.getValue()) != null) {
                    sparseArray.put(xcaVar.getPosition(), xcaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                xca xcaVar4 = (xca) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    xcaVar4.i1 = this.c.k().getId();
                }
                if (this.c.N() != null) {
                    xcaVar4.l1 = wg.g(this.c.N().getId(), 0L);
                }
                ze9 ze9Var2 = this.c;
                if (ze9Var2 != null && ze9Var2.y() != null) {
                    xcaVar4.m1 = this.c.y().a();
                }
                b(xcaVar4);
                int position = xcaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    xcaVar4.o1 = position;
                    j0a.k(xcaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    xcaVar4.o1 = position;
                }
                if (position < 0) {
                    j0a.j(xcaVar4, 23);
                } else if (h(F, position)) {
                    j0a.j(xcaVar4, 1);
                } else {
                    F.add(position, xcaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", xcaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.in9
    public ArrayList<yn> a() {
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

    public final void b(xca xcaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xcaVar) == null) && xcaVar != null && this.c != null && xcaVar.getAdvertAppInfo() != null) {
            xcaVar.getAdvertAppInfo().i = new y15();
            if (this.c.y() != null) {
                xcaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            xcaVar.getAdvertAppInfo().i.a = xcaVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                xcaVar.getAdvertAppInfo().i.c = k.getId();
                xcaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                xcaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                xcaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            xcaVar.getAdvertAppInfo().i.g = xcaVar.getAdvertAppInfo().g;
            xcaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<yca> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof xca) {
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
                if (this.f.get(i) instanceof of9) {
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

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ze9Var) == null) {
            s(ze9Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(ze9 ze9Var, boolean z) {
        xca xcaVar;
        yca ycaVar;
        boolean z2;
        ze9 ze9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, ze9Var, z) != null) || ze9Var == null) {
            return;
        }
        this.c = ze9Var;
        if (ze9Var != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
            this.g = ze9Var.N().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<yca> it = ze9Var.F().iterator();
        while (true) {
            xcaVar = null;
            if (it.hasNext()) {
                yca next = it.next();
                if (next instanceof yca) {
                    ycaVar = next;
                    if (ycaVar.I() == 1) {
                        break;
                    }
                }
            } else {
                ycaVar = null;
                break;
            }
        }
        if (ycaVar == null && ze9Var.i() != null) {
            ycaVar = ze9Var.i();
        }
        if (ycaVar != null) {
            this.f.add(ycaVar);
        }
        E(ze9Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(ze9Var.F()) && ze9Var.F().get(0) != null && ze9Var.N() != null) {
            ze9Var.N().setItem(ze9Var.F().get(0).W());
            ze9Var.N().setItemStar(ze9Var.F().get(0).X());
        }
        if (ze9Var.N() != null && ze9Var.N().getRawThreadInfo() != null) {
            z45 z45Var = new z45();
            z45Var.t = ze9Var.N();
            z45Var.n = true;
            this.f.add(z45Var);
        }
        pf9 pf9Var = new pf9(ze9Var.N(), ze9Var.c());
        pf9Var.g(false);
        pf9Var.b = false;
        this.f.add(pf9Var);
        if (ycaVar != null && ycaVar.s0 != null && (ze9Var.k() == null || !TextUtils.equals(ze9Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1())) {
            cf9 cf9Var = new cf9(ycaVar.s0);
            cf9Var.b = this.a.Q().S1();
            this.f.add(cf9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && ze9Var.k() != null && !StringUtils.isNull(ze9Var.k().getName()) && (!TextUtils.equals(ze9Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1())) {
            bf9 bf9Var = new bf9(ze9Var.k());
            bf9Var.g = this.a.Q().S1();
            bf9Var.e = false;
            this.f.add(bf9Var);
            pf9Var.g(false);
            pf9Var.b = false;
        }
        if (ze9Var.N() != null && !StringUtils.isNull(ze9Var.N().getForum_name())) {
            uf9 uf9Var = new uf9();
            uf9Var.a = ze9Var.N();
            this.f.add(uf9Var);
        } else if (ze9Var.N() != null && !StringUtils.isNull(ze9Var.m())) {
            ze9Var.N().setForum_name(ze9Var.m());
            uf9 uf9Var2 = new uf9();
            uf9Var2.a = ze9Var.N();
            this.f.add(uf9Var2);
        }
        if (j() && ze9Var.y() != null && ze9Var.y().c() == 1) {
            jf9 jf9Var = new jf9(jf9.c);
            jf9Var.b(true);
            this.f.add(jf9Var);
        }
        of9 of9Var = new of9(of9.g);
        of9Var.c = k();
        of9Var.b = ze9Var.g;
        of9Var.d = ze9Var.i0();
        of9Var.e = ze9Var.f;
        C(ze9Var);
        this.f.add(of9Var);
        if (ze9Var.J() == 4) {
            this.f.add(new nf9());
        }
        G();
        p(i());
        Iterator<yca> it2 = ze9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            yca next2 = it2.next();
            if ((next2 instanceof yca) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((ze9Var2 = this.c) == null || !ze9Var2.s()))) {
            lf9 lf9Var = new lf9();
            lf9Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lf9Var.g1 = R.drawable.new_pic_emotion_03;
            lf9Var.i1 = yi.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(lf9Var);
        }
        q(ze9Var, this.i, this.g, this.h);
        if (ze9Var.y().b() == 0) {
            ze9 ze9Var3 = this.c;
            if (ze9Var3 != null && ze9Var3.s()) {
                B(this.a.N().u3());
                this.f.add(new if9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().u3());
                hf9 hf9Var = new hf9();
                hf9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(hf9Var);
            }
            List<xca> Z = ze9Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                xcaVar = Z.get(0);
                i2 = xcaVar.getPosition();
            }
            if (!ListUtils.isEmpty(ze9Var.e())) {
                int i3 = 1;
                for (k25 k25Var : ze9Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (xcaVar != null) {
                            b(xcaVar);
                            this.f.add(xcaVar);
                            i++;
                            if (xcaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            xca xcaVar2 = Z.get(i);
                            xcaVar = xcaVar2;
                            i2 = xcaVar2.getPosition();
                        }
                    }
                    this.f.add(k25Var);
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
