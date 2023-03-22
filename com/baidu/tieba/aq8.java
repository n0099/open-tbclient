package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
public abstract class aq8 extends mq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public ki8 d;
    public final List<tm> e;
    public boolean f;
    public ArrayList<gn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(ki8 ki8Var);

    public void E(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mj8Var) == null) {
        }
    }

    public abstract void F(ki8 ki8Var);

    public abstract void G(String str);

    public abstract em8 e();

    public abstract zk8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(ki8 ki8Var, boolean z, String str, boolean z2);

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, a0Var) == null) {
        }
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onLongClickListener) == null) {
        }
    }

    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
        }
    }

    public aq8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.a = BdUniqueId.gen();
        this.e = new ArrayList();
        this.f = true;
        this.h = null;
        this.i = true;
        this.j = false;
        this.l = -1;
        this.m = -1;
        this.b = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.D() != null && detailInfoAndReplyFragment.D().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.D().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public final void H() {
        ki8 ki8Var;
        ac9 ac9Var;
        ac9 ac9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ki8Var = this.d) == null || ki8Var.c0 || ki8Var.d0 == 2) {
            return;
        }
        ArrayList<bc9> H = ki8Var.H();
        ArrayList<ac9> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ac9> it = e.iterator();
            while (it.hasNext()) {
                ac9 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ac9> it2 = e.iterator();
            while (it2.hasNext()) {
                ac9 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ac9> it3 = e.iterator();
            while (it3.hasNext()) {
                ac9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int k = next3.getAdvertAppInfo().k();
                    if (k != 0) {
                        s29.j(next3, k);
                        if (k != 28 && k != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + k);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                ac9 ac9Var3 = (ac9) sparseArray.get(sparseArray.keyAt(i));
                if (ac9Var3 != null && (ac9Var2 = (ac9) hashMap.put(ac9Var3.p1(), ac9Var3)) != null) {
                    s29.j(ac9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ac9Var = (ac9) entry.getValue()) != null) {
                    sparseArray.put(ac9Var.getPosition(), ac9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ac9 ac9Var4 = (ac9) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    ac9Var4.b1 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    ac9Var4.e1 = gg.g(this.d.Q().getId(), 0L);
                }
                ki8 ki8Var2 = this.d;
                if (ki8Var2 != null && ki8Var2.z() != null) {
                    ac9Var4.f1 = this.d.z().a();
                }
                b(ac9Var4);
                int position = ac9Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    ac9Var4.h1 = position;
                    s29.k(ac9Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    ac9Var4.h1 = position;
                }
                if (position < 0) {
                    s29.j(ac9Var4, 23);
                } else if (h(H, position)) {
                    s29.j(ac9Var4, 1);
                } else {
                    H.add(position, ac9Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ac9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mq8
    public ArrayList<gn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (12 == this.k) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.b.L() != null) {
                return this.b.L().Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (this.c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public final void b(ac9 ac9Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ac9Var) == null) && ac9Var != null && this.d != null && ac9Var.getAdvertAppInfo() != null) {
            ac9Var.getAdvertAppInfo().i = new mw4();
            if (this.d.z() != null) {
                ac9Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            ac9Var.getAdvertAppInfo().i.a = ac9Var.r1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                ac9Var.getAdvertAppInfo().i.c = l.getId();
                ac9Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ac9Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ac9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ac9Var.getAdvertAppInfo().i.g = ac9Var.getAdvertAppInfo().g;
            ac9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<bc9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ac9) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                gn gnVar = this.g.get(i);
                if (gnVar instanceof xi8) {
                    this.l = i;
                    z = true;
                } else if ((gnVar instanceof ji8) && ((ji8) gnVar).a() == this.a) {
                    this.m = i;
                    z2 = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            if (!z2) {
                this.m = -1;
            }
        }
    }

    public void r(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ki8Var) == null) {
            s(ki8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.j = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f = z;
        }
    }

    public void s(ki8 ki8Var, boolean z) {
        ac9 ac9Var;
        bc9 bc9Var;
        boolean z2;
        ki8 ki8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, ki8Var, z) != null) || ki8Var == null) {
            return;
        }
        this.d = ki8Var;
        if (ki8Var != null && ki8Var.Q() != null && ki8Var.Q().getAuthor() != null) {
            this.h = ki8Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<bc9> it = ki8Var.H().iterator();
        while (true) {
            ac9Var = null;
            if (it.hasNext()) {
                bc9 next = it.next();
                if (next instanceof bc9) {
                    bc9Var = next;
                    if (bc9Var.E() == 1) {
                        break;
                    }
                }
            } else {
                bc9Var = null;
                break;
            }
        }
        if (bc9Var == null && ki8Var.j() != null) {
            bc9Var = ki8Var.j();
        }
        if (bc9Var != null) {
            this.g.add(bc9Var);
        }
        F(ki8Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(ki8Var.H()) && ki8Var.H().get(0) != null && ki8Var.Q() != null) {
            ki8Var.Q().setItem(ki8Var.H().get(0).S());
            ki8Var.Q().setItemStar(ki8Var.H().get(0).T());
        }
        if (ki8Var.Q() != null && ki8Var.Q().getRawThreadInfo() != null) {
            mz4 mz4Var = new mz4();
            mz4Var.t = ki8Var.Q();
            mz4Var.n = true;
            this.g.add(mz4Var);
        }
        yi8 yi8Var = new yi8(ki8Var.Q(), ki8Var.d());
        yi8Var.i(false);
        yi8Var.b = false;
        this.g.add(yi8Var);
        if (bc9Var != null && bc9Var.r0 != null && (ki8Var.l() == null || !TextUtils.equals(ki8Var.l().getName(), this.b.L().V0()) || !this.b.L().b1())) {
            ni8 ni8Var = new ni8(bc9Var.r0);
            ni8Var.b = this.b.L().Q1();
            this.g.add(ni8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && ki8Var.l() != null && !StringUtils.isNull(ki8Var.l().getName()) && (!TextUtils.equals(ki8Var.l().getName(), this.b.L().V0()) || !this.b.L().b1())) {
            mi8 mi8Var = new mi8(ki8Var.l());
            mi8Var.g = this.b.L().Q1();
            mi8Var.e = false;
            this.g.add(mi8Var);
            yi8Var.i(false);
            yi8Var.b = false;
        }
        if (ki8Var.Q() != null && !StringUtils.isNull(ki8Var.Q().getForum_name())) {
            ej8 ej8Var = new ej8();
            ej8Var.a = ki8Var.Q();
            this.g.add(ej8Var);
        } else if (ki8Var.Q() != null && !StringUtils.isNull(ki8Var.n())) {
            ki8Var.Q().setForum_name(ki8Var.n());
            ej8 ej8Var2 = new ej8();
            ej8Var2.a = ki8Var.Q();
            this.g.add(ej8Var2);
        }
        if (j() && ki8Var.z() != null && ki8Var.z().c() == 1) {
            si8 si8Var = new si8(si8.c);
            si8Var.b(true);
            this.g.add(si8Var);
        }
        xi8 xi8Var = new xi8(xi8.i);
        ThreadData Q = ki8Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.L().O1();
        xi8Var.d = k();
        xi8Var.c = ki8Var.g;
        ki8Var.c();
        xi8Var.e = ki8Var.l0();
        xi8Var.g = ki8Var.f;
        D(ki8Var);
        this.g.add(xi8Var);
        if (ki8Var.N() == 4) {
            this.g.add(new wi8());
        }
        H();
        p(i());
        Iterator<bc9> it2 = ki8Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            bc9 next2 = it2.next();
            if ((next2 instanceof bc9) && next2.E() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((ki8Var2 = this.d) == null || !ki8Var2.t()))) {
            ui8 ui8Var = new ui8();
            ui8Var.a1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            ui8Var.Z0 = R.drawable.new_pic_emotion_03;
            ui8Var.b1 = -2;
            ui8Var.c1 = hi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(ui8Var);
        }
        q(ki8Var, this.j, this.h, this.i);
        if (ki8Var.z().b() == 0) {
            ki8 ki8Var3 = this.d;
            if (ki8Var3 != null && ki8Var3.t()) {
                C(this.b.D().c4());
                this.g.add(new ri8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.D().c4());
                qi8 qi8Var = new qi8();
                qi8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(qi8Var);
            }
            List<ac9> c0 = ki8Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                ac9Var = c0.get(0);
                i2 = ac9Var.getPosition();
            }
            if (!ListUtils.isEmpty(ki8Var.f())) {
                ji8 ji8Var = new ji8();
                ji8Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                ji8Var.c(this.a);
                this.g.add(ji8Var);
                int i3 = 1;
                for (yw4 yw4Var : ki8Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (ac9Var != null) {
                            b(ac9Var);
                            this.g.add(ac9Var);
                            i++;
                            if (ac9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            ac9 ac9Var2 = c0.get(i);
                            ac9Var = ac9Var2;
                            i2 = ac9Var2.getPosition();
                        }
                    }
                    this.g.add(yw4Var);
                    i3++;
                    if (i3 == 4 && ki8Var.D() != null) {
                        this.g.add(ki8Var.D());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.g);
        }
        o();
    }
}
