package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes6.dex */
public abstract class i1a extends o1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public es9 c;
    public final List<bi> d;
    public boolean e;
    public ArrayList<oi> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public aj m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(es9 es9Var);

    public void E(zt9 zt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zt9Var) == null) {
        }
    }

    public abstract void F(es9 es9Var);

    public abstract void G(String str);

    public abstract bx9 f();

    public abstract uv9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(es9 es9Var, boolean z, String str, boolean z2);

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, zVar) == null) {
        }
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onLongClickListener) == null) {
        }
    }

    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i1a a;

        public a(i1a i1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i1a i1aVar = this.a;
                i1aVar.b.setData(i1aVar.f);
            }
        }
    }

    public i1a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.e0() != null && detailInfoAndReplyFragment.e0().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.e0().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
        this.m = new aj(bdTypeRecyclerView);
    }

    public void s(es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, es9Var) == null) {
            t(es9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        es9 es9Var;
        ura uraVar;
        ura uraVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (es9Var = this.c) == null || es9Var.Z || es9Var.a0 == 2) {
            return;
        }
        ArrayList<vra> F = es9Var.F();
        ArrayList<ura> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ura> it = d.iterator();
            while (it.hasNext()) {
                ura next = it.next();
                if (next != null && next.G1() != null) {
                    sb.append(next.G1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ura> it2 = d.iterator();
            while (it2.hasNext()) {
                ura next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ura> it3 = d.iterator();
            while (it3.hasNext()) {
                ura next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        oea.j(next3, h);
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
                ura uraVar3 = (ura) sparseArray.get(sparseArray.keyAt(i));
                if (uraVar3 != null && (uraVar2 = (ura) hashMap.put(uraVar3.F1(), uraVar3)) != null) {
                    oea.j(uraVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (uraVar = (ura) entry.getValue()) != null) {
                    sparseArray.put(uraVar.getPosition(), uraVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ura uraVar4 = (ura) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    uraVar4.i1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    uraVar4.l1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                es9 es9Var2 = this.c;
                if (es9Var2 != null && es9Var2.y() != null) {
                    uraVar4.m1 = this.c.y().a();
                }
                c(uraVar4);
                int position = uraVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    uraVar4.o1 = position;
                    oea.k(uraVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    uraVar4.o1 = position;
                }
                if (position < 0) {
                    oea.j(uraVar4, 23);
                } else if (i(F, position)) {
                    oea.j(uraVar4, 1);
                } else {
                    F.add(position, uraVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", uraVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.o1a
    public ArrayList<oi> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (12 == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a.i0() != null) {
                return this.a.i0().W0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(ura uraVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, uraVar) == null) && uraVar != null && this.c != null && uraVar.getAdvertAppInfo() != null) {
            uraVar.getAdvertAppInfo().i = new gw4();
            if (this.c.y() != null) {
                uraVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            uraVar.getAdvertAppInfo().i.a = uraVar.H1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                uraVar.getAdvertAppInfo().i.c = k.getId();
                uraVar.getAdvertAppInfo().i.d = k.getFirst_class();
                uraVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                uraVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            uraVar.getAdvertAppInfo().i.g = uraVar.getAdvertAppInfo().g;
            uraVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<vra> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ura) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) instanceof ts9) {
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

    public void t(es9 es9Var, boolean z) {
        ura uraVar;
        vra vraVar;
        boolean z2;
        es9 es9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, es9Var, z) != null) || es9Var == null) {
            return;
        }
        this.c = es9Var;
        if (es9Var != null && es9Var.O() != null && es9Var.O().getAuthor() != null) {
            this.g = es9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<vra> it = es9Var.F().iterator();
        while (true) {
            uraVar = null;
            if (it.hasNext()) {
                vra next = it.next();
                if (next instanceof vra) {
                    vraVar = next;
                    if (vraVar.J() == 1) {
                        break;
                    }
                }
            } else {
                vraVar = null;
                break;
            }
        }
        if (vraVar == null && es9Var.i() != null) {
            vraVar = es9Var.i();
        }
        if (vraVar != null) {
            this.f.add(vraVar);
        }
        F(es9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(es9Var.F()) && es9Var.F().get(0) != null && es9Var.O() != null) {
            es9Var.O().setItem(es9Var.F().get(0).W());
            es9Var.O().setItemStar(es9Var.F().get(0).X());
        }
        if (es9Var.O() != null && es9Var.O().getRawThreadInfo() != null) {
            hz4 hz4Var = new hz4();
            hz4Var.t = es9Var.O();
            hz4Var.n = true;
            this.f.add(hz4Var);
        }
        us9 us9Var = new us9(es9Var.O(), es9Var.c());
        us9Var.g(false);
        us9Var.b = false;
        this.f.add(us9Var);
        if (vraVar != null && vraVar.u0 != null && (es9Var.k() == null || !TextUtils.equals(es9Var.k().getName(), this.a.i0().S0()) || !this.a.i0().Y0())) {
            hs9 hs9Var = new hs9(vraVar.u0);
            hs9Var.b = this.a.i0().N1();
            this.f.add(hs9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && es9Var.k() != null && !StringUtils.isNull(es9Var.k().getName()) && (!TextUtils.equals(es9Var.k().getName(), this.a.i0().S0()) || !this.a.i0().Y0())) {
            gs9 gs9Var = new gs9(es9Var.k());
            gs9Var.g = this.a.i0().N1();
            gs9Var.e = false;
            this.f.add(gs9Var);
            us9Var.g(false);
            us9Var.b = false;
        }
        if (es9Var.O() != null && !StringUtils.isNull(es9Var.O().getForum_name())) {
            zs9 zs9Var = new zs9();
            zs9Var.a = es9Var.O();
            this.f.add(zs9Var);
        } else if (es9Var.O() != null && !StringUtils.isNull(es9Var.m())) {
            es9Var.O().setForum_name(es9Var.m());
            zs9 zs9Var2 = new zs9();
            zs9Var2.a = es9Var.O();
            this.f.add(zs9Var2);
        }
        if (k() && es9Var.y() != null && es9Var.y().c() == 1) {
            os9 os9Var = new os9(os9.c);
            os9Var.b(true);
            this.f.add(os9Var);
        }
        ts9 ts9Var = new ts9(ts9.g);
        ts9Var.c = l();
        ts9Var.b = es9Var.g;
        ts9Var.d = es9Var.j0();
        ts9Var.e = es9Var.f;
        D(es9Var);
        this.f.add(ts9Var);
        if (es9Var.J() == 4) {
            this.f.add(new ss9());
        }
        H();
        q(j());
        Iterator<vra> it2 = es9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            vra next2 = it2.next();
            if ((next2 instanceof vra) && next2.J() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((es9Var2 = this.c) == null || !es9Var2.s()))) {
            qs9 qs9Var = new qs9();
            qs9Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            qs9Var.g1 = R.drawable.new_pic_emotion_03;
            qs9Var.i1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(qs9Var);
        }
        r(es9Var, this.i, this.g, this.h);
        if (es9Var.y().b() == 0) {
            es9 es9Var3 = this.c;
            if (es9Var3 != null && es9Var3.s()) {
                C(this.a.e0().g4());
                this.f.add(new ns9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.e0().g4());
                ms9 ms9Var = new ms9();
                ms9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(ms9Var);
            }
            List<ura> a0 = es9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                uraVar = a0.get(0);
                i2 = uraVar.getPosition();
            }
            if (!ListUtils.isEmpty(es9Var.e())) {
                int i3 = 1;
                for (sw4 sw4Var : es9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (uraVar != null) {
                            c(uraVar);
                            this.f.add(uraVar);
                            i++;
                            if (uraVar.getType() != AdvertAppInfo.z) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            ura uraVar2 = a0.get(i);
                            uraVar = uraVar2;
                            i2 = uraVar2.getPosition();
                        }
                    }
                    this.f.add(sw4Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.m == null) {
                this.m = new aj(bdTypeRecyclerView);
            }
            this.m.e(new a(this));
        }
        p();
    }
}
