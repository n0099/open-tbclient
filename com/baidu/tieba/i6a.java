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
public abstract class i6a extends o6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public zv9 c;
    public final List<ci> d;
    public boolean e;
    public ArrayList<pi> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public bj n;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(zv9 zv9Var);

    public void E(tx9 tx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tx9Var) == null) {
        }
    }

    public abstract void F(zv9 zv9Var);

    public abstract void G(String str);

    public abstract f1a f();

    public abstract xz9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(zv9 zv9Var, boolean z, String str, boolean z2);

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
        public final /* synthetic */ i6a a;

        public a(i6a i6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i6aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i6a i6aVar = this.a;
                i6aVar.b.setData(i6aVar.f);
            }
        }
    }

    public i6a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.k = false;
        this.l = -1;
        this.m = -1;
        this.a = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.h0() != null && detailInfoAndReplyFragment.h0().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.h0().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
            this.k = detailInfoAndReplyFragment.h0().getArguments().getBoolean("is_check_pre_floor");
        }
        this.b = bdTypeRecyclerView;
        this.n = new bj(bdTypeRecyclerView);
    }

    public void s(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, zv9Var) == null) {
            t(zv9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        zv9 zv9Var;
        lwa lwaVar;
        lwa lwaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (zv9Var = this.c) == null || zv9Var.Z || zv9Var.a0 == 2) {
            return;
        }
        ArrayList<mwa> I = zv9Var.I();
        ArrayList<lwa> g = this.c.g();
        if (g != null && !g.isEmpty() && I != null && !I.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<lwa> it = g.iterator();
            while (it.hasNext()) {
                lwa next = it.next();
                if (next != null && next.I1() != null) {
                    sb.append(next.I1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<lwa> it2 = g.iterator();
            while (it2.hasNext()) {
                lwa next2 = it2.next();
                if (next2 != null) {
                    next2.q1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<lwa> it3 = g.iterator();
            while (it3.hasNext()) {
                lwa next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        kja.j(next3, h);
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
                lwa lwaVar3 = (lwa) sparseArray.get(sparseArray.keyAt(i));
                if (lwaVar3 != null && (lwaVar2 = (lwa) hashMap.put(lwaVar3.H1(), lwaVar3)) != null) {
                    kja.j(lwaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (lwaVar = (lwa) entry.getValue()) != null) {
                    sparseArray.put(lwaVar.getPosition(), lwaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                lwa lwaVar4 = (lwa) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.n() != null) {
                    lwaVar4.k1 = this.c.n().getId();
                }
                if (this.c.R() != null) {
                    lwaVar4.n1 = JavaTypesHelper.toLong(this.c.R().getId(), 0L);
                }
                zv9 zv9Var2 = this.c;
                if (zv9Var2 != null && zv9Var2.B() != null) {
                    lwaVar4.o1 = this.c.B().a();
                }
                c(lwaVar4);
                int position = lwaVar4.getPosition() + this.c.Y;
                if (position >= I.size()) {
                    lwaVar4.q1 = position;
                    kja.k(lwaVar4, 2, position + i3, I.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    lwaVar4.q1 = position;
                }
                if (position < 0) {
                    kja.j(lwaVar4, 23);
                } else if (i(I, position)) {
                    kja.j(lwaVar4, 1);
                } else {
                    I.add(position, lwaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", lwaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.o6a
    public ArrayList<pi> a() {
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
            return this.m;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.k && 12 != this.j) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a.l0() != null) {
                return this.a.l0().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(lwa lwaVar) {
        ForumData n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lwaVar) == null) && lwaVar != null && this.c != null && lwaVar.getAdvertAppInfo() != null) {
            lwaVar.getAdvertAppInfo().i = new kw4();
            if (this.c.B() != null) {
                lwaVar.getAdvertAppInfo().i.b = this.c.B().a();
            }
            lwaVar.getAdvertAppInfo().i.a = lwaVar.J1();
            if (this.c.n() != null && (n = this.c.n()) != null) {
                lwaVar.getAdvertAppInfo().i.c = n.getId();
                lwaVar.getAdvertAppInfo().i.d = n.getFirst_class();
                lwaVar.getAdvertAppInfo().i.e = n.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lwaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lwaVar.getAdvertAppInfo().i.g = lwaVar.getAdvertAppInfo().g;
            lwaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<mwa> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof lwa) {
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
                if (this.f.get(i) instanceof nw9) {
                    this.l = i;
                    z = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            this.m = -1;
        }
    }

    public void t(zv9 zv9Var, boolean z) {
        lwa lwaVar;
        mwa mwaVar;
        boolean z2;
        zv9 zv9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, zv9Var, z) != null) || zv9Var == null) {
            return;
        }
        this.c = zv9Var;
        if (zv9Var != null && zv9Var.R() != null && zv9Var.R().getAuthor() != null) {
            this.g = zv9Var.R().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<mwa> it = zv9Var.I().iterator();
        while (true) {
            lwaVar = null;
            if (it.hasNext()) {
                mwa next = it.next();
                if (next instanceof mwa) {
                    mwaVar = next;
                    if (mwaVar.L() == 1) {
                        break;
                    }
                }
            } else {
                mwaVar = null;
                break;
            }
        }
        if (mwaVar == null && zv9Var.l() != null) {
            mwaVar = zv9Var.l();
        }
        if (mwaVar != null) {
            this.f.add(mwaVar);
        }
        F(zv9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(zv9Var.I()) && zv9Var.I().get(0) != null && zv9Var.R() != null) {
            zv9Var.R().setItem(zv9Var.I().get(0).X());
            zv9Var.R().setItemStar(zv9Var.I().get(0).Y());
        }
        if (zv9Var.R() != null && zv9Var.R().getRawThreadInfo() != null) {
            mz4 mz4Var = new mz4();
            mz4Var.t = zv9Var.R();
            mz4Var.n = true;
            this.f.add(mz4Var);
        }
        ow9 ow9Var = new ow9(zv9Var.R(), zv9Var.f());
        ow9Var.h(false);
        ow9Var.b = false;
        this.f.add(ow9Var);
        if (mwaVar != null && mwaVar.v0 != null && (zv9Var.n() == null || !TextUtils.equals(zv9Var.n().getName(), this.a.l0().R0()) || !this.a.l0().X0())) {
            cw9 cw9Var = new cw9(mwaVar.v0);
            cw9Var.b = this.a.l0().M1();
            this.f.add(cw9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && zv9Var.n() != null && !StringUtils.isNull(zv9Var.n().getName()) && (!TextUtils.equals(zv9Var.n().getName(), this.a.l0().R0()) || !this.a.l0().X0())) {
            bw9 bw9Var = new bw9(zv9Var.n());
            bw9Var.g = this.a.l0().M1();
            bw9Var.e = false;
            this.f.add(bw9Var);
            ow9Var.h(false);
            ow9Var.b = false;
        }
        if (zv9Var.R() != null && !StringUtils.isNull(zv9Var.R().getForum_name())) {
            tw9 tw9Var = new tw9();
            tw9Var.a = zv9Var.R();
            this.f.add(tw9Var);
        } else if (zv9Var.R() != null && !StringUtils.isNull(zv9Var.p())) {
            zv9Var.R().setForum_name(zv9Var.p());
            tw9 tw9Var2 = new tw9();
            tw9Var2.a = zv9Var.R();
            this.f.add(tw9Var2);
        }
        if (j() && zv9Var.B() != null && zv9Var.B().c() == 1) {
            jw9 jw9Var = new jw9(jw9.c);
            jw9Var.b(true);
            this.f.add(jw9Var);
        }
        nw9 nw9Var = new nw9(nw9.g);
        nw9Var.c = l();
        nw9Var.b = zv9Var.g;
        nw9Var.d = zv9Var.a();
        nw9Var.e = zv9Var.f;
        D(zv9Var);
        this.f.add(nw9Var);
        if (zv9Var.M() == 4) {
            this.f.add(new mw9());
        }
        H();
        q(k());
        Iterator<mwa> it2 = zv9Var.I().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            mwa next2 = it2.next();
            if ((next2 instanceof mwa) && next2.L() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((zv9Var2 = this.c) == null || !zv9Var2.v()))) {
            lw9 lw9Var = new lw9();
            lw9Var.j1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lw9Var.i1 = R.drawable.new_pic_emotion_03;
            lw9Var.k1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(lw9Var);
        }
        r(zv9Var, this.i, this.g, this.h);
        if (zv9Var.B().b() == 0) {
            zv9 zv9Var3 = this.c;
            if (zv9Var3 != null && zv9Var3.v()) {
                C(this.a.h0().s4());
                this.f.add(new iw9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.o());
                statisticItem.param("fname", this.c.p());
                statisticItem.param("tid", this.c.T());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.h0().s4());
                hw9 hw9Var = new hw9();
                hw9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(hw9Var);
            }
            List<lwa> d0 = zv9Var.d0();
            int i2 = -1;
            if (d0 != null && !d0.isEmpty()) {
                lwaVar = d0.get(0);
                i2 = lwaVar.getPosition();
            }
            if (!ListUtils.isEmpty(zv9Var.h())) {
                int i3 = 1;
                for (xw4 xw4Var : zv9Var.h()) {
                    if (d0 != null && i3 == i2) {
                        if (lwaVar != null) {
                            c(lwaVar);
                            this.f.add(lwaVar);
                            i++;
                            if (lwaVar.getType() != AdvertAppInfo.z) {
                                i3++;
                            }
                        }
                        if (i < d0.size()) {
                            lwa lwaVar2 = d0.get(i);
                            lwaVar = lwaVar2;
                            i2 = lwaVar2.getPosition();
                        }
                    }
                    this.f.add(xw4Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.n == null) {
                this.n = new bj(bdTypeRecyclerView);
            }
            this.n.e(new a(this));
        }
        p();
    }
}
