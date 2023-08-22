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
/* loaded from: classes5.dex */
public abstract class bq9 extends hq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public yh9 c;
    public final List<om> d;
    public boolean e;
    public ArrayList<bn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public nn m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(yh9 yh9Var);

    public void E(fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fj9Var) == null) {
        }
    }

    public abstract void F(yh9 yh9Var);

    public abstract void G(String str);

    public abstract zl9 f();

    public abstract tk9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(yh9 yh9Var, boolean z, String str, boolean z2);

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

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq9 a;

        public a(bq9 bq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bq9 bq9Var = this.a;
                bq9Var.b.setData(bq9Var.f);
            }
        }
    }

    public bq9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.Q() != null && detailInfoAndReplyFragment.Q().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.Q().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
        this.m = new nn(bdTypeRecyclerView);
    }

    public void s(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, yh9Var) == null) {
            t(yh9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        yh9 yh9Var;
        yfa yfaVar;
        yfa yfaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (yh9Var = this.c) == null || yh9Var.Z || yh9Var.a0 == 2) {
            return;
        }
        ArrayList<zfa> F = yh9Var.F();
        ArrayList<yfa> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<yfa> it = d.iterator();
            while (it.hasNext()) {
                yfa next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<yfa> it2 = d.iterator();
            while (it2.hasNext()) {
                yfa next2 = it2.next();
                if (next2 != null) {
                    next2.n1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<yfa> it3 = d.iterator();
            while (it3.hasNext()) {
                yfa next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        g3a.j(next3, h);
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
                yfa yfaVar3 = (yfa) sparseArray.get(sparseArray.keyAt(i));
                if (yfaVar3 != null && (yfaVar2 = (yfa) hashMap.put(yfaVar3.z1(), yfaVar3)) != null) {
                    g3a.j(yfaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (yfaVar = (yfa) entry.getValue()) != null) {
                    sparseArray.put(yfaVar.getPosition(), yfaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                yfa yfaVar4 = (yfa) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    yfaVar4.h1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    yfaVar4.k1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                yh9 yh9Var2 = this.c;
                if (yh9Var2 != null && yh9Var2.y() != null) {
                    yfaVar4.l1 = this.c.y().a();
                }
                c(yfaVar4);
                int position = yfaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    yfaVar4.n1 = position;
                    g3a.k(yfaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    yfaVar4.n1 = position;
                }
                if (position < 0) {
                    g3a.j(yfaVar4, 23);
                } else if (i(F, position)) {
                    g3a.j(yfaVar4, 1);
                } else {
                    F.add(position, yfaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", yfaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.hq9
    public ArrayList<bn> a() {
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
            if (this.a.W() != null) {
                return this.a.W().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(yfa yfaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, yfaVar) == null) && yfaVar != null && this.c != null && yfaVar.getAdvertAppInfo() != null) {
            yfaVar.getAdvertAppInfo().i = new b15();
            if (this.c.y() != null) {
                yfaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            yfaVar.getAdvertAppInfo().i.a = yfaVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                yfaVar.getAdvertAppInfo().i.c = k.getId();
                yfaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                yfaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                yfaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            yfaVar.getAdvertAppInfo().i.g = yfaVar.getAdvertAppInfo().g;
            yfaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<zfa> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof yfa) {
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
                if (this.f.get(i) instanceof ni9) {
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

    public void t(yh9 yh9Var, boolean z) {
        yfa yfaVar;
        zfa zfaVar;
        boolean z2;
        yh9 yh9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, yh9Var, z) != null) || yh9Var == null) {
            return;
        }
        this.c = yh9Var;
        if (yh9Var != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
            this.g = yh9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<zfa> it = yh9Var.F().iterator();
        while (true) {
            yfaVar = null;
            if (it.hasNext()) {
                zfa next = it.next();
                if (next instanceof zfa) {
                    zfaVar = next;
                    if (zfaVar.I() == 1) {
                        break;
                    }
                }
            } else {
                zfaVar = null;
                break;
            }
        }
        if (zfaVar == null && yh9Var.i() != null) {
            zfaVar = yh9Var.i();
        }
        if (zfaVar != null) {
            this.f.add(zfaVar);
        }
        F(yh9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(yh9Var.F()) && yh9Var.F().get(0) != null && yh9Var.O() != null) {
            yh9Var.O().setItem(yh9Var.F().get(0).W());
            yh9Var.O().setItemStar(yh9Var.F().get(0).X());
        }
        if (yh9Var.O() != null && yh9Var.O().getRawThreadInfo() != null) {
            c45 c45Var = new c45();
            c45Var.t = yh9Var.O();
            c45Var.n = true;
            this.f.add(c45Var);
        }
        oi9 oi9Var = new oi9(yh9Var.O(), yh9Var.c());
        oi9Var.g(false);
        oi9Var.b = false;
        this.f.add(oi9Var);
        if (zfaVar != null && zfaVar.s0 != null && (yh9Var.k() == null || !TextUtils.equals(yh9Var.k().getName(), this.a.W().R0()) || !this.a.W().X0())) {
            bi9 bi9Var = new bi9(zfaVar.s0);
            bi9Var.b = this.a.W().M1();
            this.f.add(bi9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && yh9Var.k() != null && !StringUtils.isNull(yh9Var.k().getName()) && (!TextUtils.equals(yh9Var.k().getName(), this.a.W().R0()) || !this.a.W().X0())) {
            ai9 ai9Var = new ai9(yh9Var.k());
            ai9Var.g = this.a.W().M1();
            ai9Var.e = false;
            this.f.add(ai9Var);
            oi9Var.g(false);
            oi9Var.b = false;
        }
        if (yh9Var.O() != null && !StringUtils.isNull(yh9Var.O().getForum_name())) {
            ti9 ti9Var = new ti9();
            ti9Var.a = yh9Var.O();
            this.f.add(ti9Var);
        } else if (yh9Var.O() != null && !StringUtils.isNull(yh9Var.m())) {
            yh9Var.O().setForum_name(yh9Var.m());
            ti9 ti9Var2 = new ti9();
            ti9Var2.a = yh9Var.O();
            this.f.add(ti9Var2);
        }
        if (k() && yh9Var.y() != null && yh9Var.y().c() == 1) {
            ii9 ii9Var = new ii9(ii9.c);
            ii9Var.b(true);
            this.f.add(ii9Var);
        }
        ni9 ni9Var = new ni9(ni9.g);
        ni9Var.c = l();
        ni9Var.b = yh9Var.g;
        ni9Var.d = yh9Var.j0();
        ni9Var.e = yh9Var.f;
        D(yh9Var);
        this.f.add(ni9Var);
        if (yh9Var.J() == 4) {
            this.f.add(new mi9());
        }
        H();
        q(j());
        Iterator<zfa> it2 = yh9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            zfa next2 = it2.next();
            if ((next2 instanceof zfa) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((yh9Var2 = this.c) == null || !yh9Var2.s()))) {
            ki9 ki9Var = new ki9();
            ki9Var.g1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            ki9Var.f1 = R.drawable.new_pic_emotion_03;
            ki9Var.h1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(ki9Var);
        }
        r(yh9Var, this.i, this.g, this.h);
        if (yh9Var.y().b() == 0) {
            yh9 yh9Var3 = this.c;
            if (yh9Var3 != null && yh9Var3.s()) {
                C(this.a.Q().H3());
                this.f.add(new hi9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.Q().H3());
                gi9 gi9Var = new gi9();
                gi9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(gi9Var);
            }
            List<yfa> a0 = yh9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                yfaVar = a0.get(0);
                i2 = yfaVar.getPosition();
            }
            if (!ListUtils.isEmpty(yh9Var.e())) {
                int i3 = 1;
                for (n15 n15Var : yh9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (yfaVar != null) {
                            c(yfaVar);
                            this.f.add(yfaVar);
                            i++;
                            if (yfaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            yfa yfaVar2 = a0.get(i);
                            yfaVar = yfaVar2;
                            i2 = yfaVar2.getPosition();
                        }
                    }
                    this.f.add(n15Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.m == null) {
                this.m = new nn(bdTypeRecyclerView);
            }
            this.m.e(new a(this));
        }
        p();
    }
}
