package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.tbadkCore.data.PostData;
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
public abstract class e18 extends q18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public mt7 d;
    public final List<cn> e;
    public boolean f;
    public ArrayList<pn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public e18(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.B() != null && detailInfoAndReplyFragment.B().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.B().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(mt7 mt7Var);

    public void E(ou7 ou7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ou7Var) == null) {
        }
    }

    public abstract void F(mt7 mt7Var);

    public abstract void G(String str);

    public final void H() {
        mt7 mt7Var;
        il8 il8Var;
        il8 il8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mt7Var = this.d) == null || mt7Var.b0 || mt7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = mt7Var.F();
        ArrayList<il8> e = this.d.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<il8> it = e.iterator();
        while (it.hasNext()) {
            il8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<il8> it2 = e.iterator();
        while (it2.hasNext()) {
            il8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<il8> it3 = e.iterator();
        while (it3.hasNext()) {
            il8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    td8.j(next3, n);
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
            il8 il8Var3 = (il8) sparseArray.get(sparseArray.keyAt(i));
            if (il8Var3 != null && (il8Var2 = (il8) hashMap.put(il8Var3.i1(), il8Var3)) != null) {
                td8.j(il8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (il8Var = (il8) entry.getValue()) != null) {
                sparseArray.put(il8Var.getPosition(), il8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            il8 il8Var4 = (il8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.d.l() != null) {
                il8Var4.V0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                il8Var4.Y0 = pg.g(this.d.O().getId(), 0L);
            }
            mt7 mt7Var2 = this.d;
            if (mt7Var2 != null && mt7Var2.y() != null) {
                il8Var4.Z0 = this.d.y().a();
            }
            b(il8Var4);
            int position = il8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                il8Var4.b1 = position;
                td8.k(il8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                il8Var4.b1 = position;
            }
            if (position < 0) {
                td8.j(il8Var4, 23);
            } else if (h(F, position)) {
                td8.j(il8Var4, 1);
            } else {
                F.add(position, il8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", il8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.baidu.tieba.q18
    public ArrayList<pn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(il8 il8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, il8Var) == null) || il8Var == null || this.d == null || il8Var.getAdvertAppInfo() == null) {
            return;
        }
        il8Var.getAdvertAppInfo().i = new mo4();
        if (this.d.y() != null) {
            il8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        il8Var.getAdvertAppInfo().i.a = il8Var.k1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
            il8Var.getAdvertAppInfo().i.c = l.getId();
            il8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            il8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            il8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        il8Var.getAdvertAppInfo().i.g = il8Var.getAdvertAppInfo().g;
        il8Var.getAdvertAppInfo().i.h = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public abstract kx7 e();

    public abstract gw7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof il8) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? 12 == this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.b.K() != null) {
                return this.b.K().v1();
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

    public abstract void m();

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                pn pnVar = this.g.get(i);
                if (pnVar instanceof zt7) {
                    this.l = i;
                    z = true;
                } else if ((pnVar instanceof lt7) && ((lt7) pnVar).a() == this.a) {
                    this.m = i;
                    z2 = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            if (z2) {
                return;
            }
            this.m = -1;
        }
    }

    public abstract void p(boolean z);

    public abstract void q(mt7 mt7Var, boolean z, String str, boolean z2);

    public void r(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, mt7Var) == null) {
            s(mt7Var, false);
        }
    }

    public void s(mt7 mt7Var, boolean z) {
        il8 il8Var;
        PostData postData;
        boolean z2;
        mt7 mt7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, mt7Var, z) == null) || mt7Var == null) {
            return;
        }
        this.d = mt7Var;
        if (mt7Var != null && mt7Var.O() != null && mt7Var.O().getAuthor() != null) {
            this.h = mt7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = mt7Var.F().iterator();
        while (true) {
            il8Var = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.B() == 1) {
                    break;
                }
            }
        }
        if (postData == null && mt7Var.j() != null) {
            postData = mt7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(mt7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(mt7Var.F()) && mt7Var.F().get(0) != null && mt7Var.O() != null) {
            mt7Var.O().setItem(mt7Var.F().get(0).O());
            mt7Var.O().setItemStar(mt7Var.F().get(0).P());
        }
        if (mt7Var.O() != null && mt7Var.O().getRawThreadInfo() != null) {
            kr4 kr4Var = new kr4();
            kr4Var.t = mt7Var.O();
            kr4Var.n = true;
            this.g.add(kr4Var);
        }
        au7 au7Var = new au7(mt7Var.O(), mt7Var.d());
        au7Var.j(false);
        au7Var.b = false;
        this.g.add(au7Var);
        if (postData == null || postData.i0 == null || (mt7Var.l() != null && TextUtils.equals(mt7Var.l().getName(), this.b.K().r1()) && this.b.K().x1())) {
            z2 = false;
        } else {
            pt7 pt7Var = new pt7(postData.i0);
            pt7Var.b = this.b.K().m2();
            this.g.add(pt7Var);
            z2 = true;
        }
        if (!z2 && mt7Var.l() != null && !StringUtils.isNull(mt7Var.l().getName()) && (!TextUtils.equals(mt7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            ot7 ot7Var = new ot7(mt7Var.l());
            ot7Var.g = this.b.K().m2();
            ot7Var.e = false;
            this.g.add(ot7Var);
            au7Var.j(false);
            au7Var.b = false;
        }
        if (mt7Var.O() != null && !StringUtils.isNull(mt7Var.O().getForum_name())) {
            gu7 gu7Var = new gu7();
            gu7Var.a = mt7Var.O();
            this.g.add(gu7Var);
        } else if (mt7Var.O() != null && !StringUtils.isNull(mt7Var.n())) {
            mt7Var.O().setForum_name(mt7Var.n());
            gu7 gu7Var2 = new gu7();
            gu7Var2.a = mt7Var.O();
            this.g.add(gu7Var2);
        }
        if (j() && mt7Var.y() != null && mt7Var.y().c() == 1) {
            ut7 ut7Var = new ut7(ut7.c);
            ut7Var.b(true);
            this.g.add(ut7Var);
        }
        zt7 zt7Var = new zt7(zt7.i);
        ThreadData O = mt7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().k2();
        zt7Var.d = k();
        zt7Var.c = mt7Var.g;
        mt7Var.c();
        zt7Var.e = mt7Var.i0();
        zt7Var.g = mt7Var.f;
        D(mt7Var);
        this.g.add(zt7Var);
        if (mt7Var.L() == 4) {
            this.g.add(new yt7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = mt7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !pi.z()) && ((mt7Var2 = this.d) == null || !mt7Var2.t()))) {
            wt7 wt7Var = new wt7();
            wt7Var.U0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0acb);
            wt7Var.T0 = R.drawable.new_pic_emotion_03;
            wt7Var.V0 = -2;
            wt7Var.W0 = ri.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(wt7Var);
        }
        q(mt7Var, this.j, this.h, this.i);
        if (mt7Var.y().b() == 0) {
            mt7 mt7Var3 = this.d;
            if (mt7Var3 != null && mt7Var3.t()) {
                C(this.b.B().R3());
                this.g.add(new tt7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().R3());
                st7 st7Var = new st7();
                st7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec);
                this.g.add(st7Var);
            }
            List<il8> Z = mt7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                il8Var = Z.get(0);
                i2 = il8Var.getPosition();
            }
            if (!ListUtils.isEmpty(mt7Var.f())) {
                lt7 lt7Var = new lt7();
                lt7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc1));
                lt7Var.c(this.a);
                this.g.add(lt7Var);
                int i3 = 1;
                for (yo4 yo4Var : mt7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (il8Var != null) {
                            b(il8Var);
                            this.g.add(il8Var);
                            i++;
                            if (il8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            il8 il8Var2 = Z.get(i);
                            il8Var = il8Var2;
                            i2 = il8Var2.getPosition();
                        }
                    }
                    this.g.add(yo4Var);
                    i3++;
                    if (i3 == 4 && mt7Var.C() != null) {
                        this.g.add(mt7Var.C());
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

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, yVar) == null) {
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
}
