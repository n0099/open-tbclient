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
public abstract class h1a extends n1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public ds9 c;
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

    public abstract void D(ds9 ds9Var);

    public void E(yt9 yt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yt9Var) == null) {
        }
    }

    public abstract void F(ds9 ds9Var);

    public abstract void G(String str);

    public abstract ax9 f();

    public abstract tv9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(ds9 ds9Var, boolean z, String str, boolean z2);

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
        public final /* synthetic */ h1a a;

        public a(h1a h1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h1a h1aVar = this.a;
                h1aVar.b.setData(h1aVar.f);
            }
        }
    }

    public h1a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void s(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ds9Var) == null) {
            t(ds9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        ds9 ds9Var;
        tra traVar;
        tra traVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ds9Var = this.c) == null || ds9Var.Z || ds9Var.a0 == 2) {
            return;
        }
        ArrayList<ura> F = ds9Var.F();
        ArrayList<tra> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<tra> it = d.iterator();
            while (it.hasNext()) {
                tra next = it.next();
                if (next != null && next.G1() != null) {
                    sb.append(next.G1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<tra> it2 = d.iterator();
            while (it2.hasNext()) {
                tra next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<tra> it3 = d.iterator();
            while (it3.hasNext()) {
                tra next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        nea.j(next3, h);
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
                tra traVar3 = (tra) sparseArray.get(sparseArray.keyAt(i));
                if (traVar3 != null && (traVar2 = (tra) hashMap.put(traVar3.F1(), traVar3)) != null) {
                    nea.j(traVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (traVar = (tra) entry.getValue()) != null) {
                    sparseArray.put(traVar.getPosition(), traVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                tra traVar4 = (tra) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    traVar4.i1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    traVar4.l1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                ds9 ds9Var2 = this.c;
                if (ds9Var2 != null && ds9Var2.y() != null) {
                    traVar4.m1 = this.c.y().a();
                }
                c(traVar4);
                int position = traVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    traVar4.o1 = position;
                    nea.k(traVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    traVar4.o1 = position;
                }
                if (position < 0) {
                    nea.j(traVar4, 23);
                } else if (i(F, position)) {
                    nea.j(traVar4, 1);
                } else {
                    F.add(position, traVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", traVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.n1a
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

    public final void c(tra traVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, traVar) == null) && traVar != null && this.c != null && traVar.getAdvertAppInfo() != null) {
            traVar.getAdvertAppInfo().i = new gw4();
            if (this.c.y() != null) {
                traVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            traVar.getAdvertAppInfo().i.a = traVar.H1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                traVar.getAdvertAppInfo().i.c = k.getId();
                traVar.getAdvertAppInfo().i.d = k.getFirst_class();
                traVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                traVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            traVar.getAdvertAppInfo().i.g = traVar.getAdvertAppInfo().g;
            traVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<ura> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof tra) {
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
                if (this.f.get(i) instanceof ss9) {
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

    public void t(ds9 ds9Var, boolean z) {
        tra traVar;
        ura uraVar;
        boolean z2;
        ds9 ds9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, ds9Var, z) != null) || ds9Var == null) {
            return;
        }
        this.c = ds9Var;
        if (ds9Var != null && ds9Var.O() != null && ds9Var.O().getAuthor() != null) {
            this.g = ds9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<ura> it = ds9Var.F().iterator();
        while (true) {
            traVar = null;
            if (it.hasNext()) {
                ura next = it.next();
                if (next instanceof ura) {
                    uraVar = next;
                    if (uraVar.J() == 1) {
                        break;
                    }
                }
            } else {
                uraVar = null;
                break;
            }
        }
        if (uraVar == null && ds9Var.i() != null) {
            uraVar = ds9Var.i();
        }
        if (uraVar != null) {
            this.f.add(uraVar);
        }
        F(ds9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(ds9Var.F()) && ds9Var.F().get(0) != null && ds9Var.O() != null) {
            ds9Var.O().setItem(ds9Var.F().get(0).W());
            ds9Var.O().setItemStar(ds9Var.F().get(0).X());
        }
        if (ds9Var.O() != null && ds9Var.O().getRawThreadInfo() != null) {
            hz4 hz4Var = new hz4();
            hz4Var.t = ds9Var.O();
            hz4Var.n = true;
            this.f.add(hz4Var);
        }
        ts9 ts9Var = new ts9(ds9Var.O(), ds9Var.c());
        ts9Var.g(false);
        ts9Var.b = false;
        this.f.add(ts9Var);
        if (uraVar != null && uraVar.u0 != null && (ds9Var.k() == null || !TextUtils.equals(ds9Var.k().getName(), this.a.i0().S0()) || !this.a.i0().Y0())) {
            gs9 gs9Var = new gs9(uraVar.u0);
            gs9Var.b = this.a.i0().N1();
            this.f.add(gs9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && ds9Var.k() != null && !StringUtils.isNull(ds9Var.k().getName()) && (!TextUtils.equals(ds9Var.k().getName(), this.a.i0().S0()) || !this.a.i0().Y0())) {
            fs9 fs9Var = new fs9(ds9Var.k());
            fs9Var.g = this.a.i0().N1();
            fs9Var.e = false;
            this.f.add(fs9Var);
            ts9Var.g(false);
            ts9Var.b = false;
        }
        if (ds9Var.O() != null && !StringUtils.isNull(ds9Var.O().getForum_name())) {
            ys9 ys9Var = new ys9();
            ys9Var.a = ds9Var.O();
            this.f.add(ys9Var);
        } else if (ds9Var.O() != null && !StringUtils.isNull(ds9Var.m())) {
            ds9Var.O().setForum_name(ds9Var.m());
            ys9 ys9Var2 = new ys9();
            ys9Var2.a = ds9Var.O();
            this.f.add(ys9Var2);
        }
        if (k() && ds9Var.y() != null && ds9Var.y().c() == 1) {
            ns9 ns9Var = new ns9(ns9.c);
            ns9Var.b(true);
            this.f.add(ns9Var);
        }
        ss9 ss9Var = new ss9(ss9.g);
        ss9Var.c = l();
        ss9Var.b = ds9Var.g;
        ss9Var.d = ds9Var.j0();
        ss9Var.e = ds9Var.f;
        D(ds9Var);
        this.f.add(ss9Var);
        if (ds9Var.J() == 4) {
            this.f.add(new rs9());
        }
        H();
        q(j());
        Iterator<ura> it2 = ds9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            ura next2 = it2.next();
            if ((next2 instanceof ura) && next2.J() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((ds9Var2 = this.c) == null || !ds9Var2.s()))) {
            ps9 ps9Var = new ps9();
            ps9Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            ps9Var.g1 = R.drawable.new_pic_emotion_03;
            ps9Var.i1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(ps9Var);
        }
        r(ds9Var, this.i, this.g, this.h);
        if (ds9Var.y().b() == 0) {
            ds9 ds9Var3 = this.c;
            if (ds9Var3 != null && ds9Var3.s()) {
                C(this.a.e0().g4());
                this.f.add(new ms9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.e0().g4());
                ls9 ls9Var = new ls9();
                ls9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(ls9Var);
            }
            List<tra> a0 = ds9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                traVar = a0.get(0);
                i2 = traVar.getPosition();
            }
            if (!ListUtils.isEmpty(ds9Var.e())) {
                int i3 = 1;
                for (sw4 sw4Var : ds9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (traVar != null) {
                            c(traVar);
                            this.f.add(traVar);
                            i++;
                            if (traVar.getType() != AdvertAppInfo.z) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            tra traVar2 = a0.get(i);
                            traVar = traVar2;
                            i2 = traVar2.getPosition();
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
