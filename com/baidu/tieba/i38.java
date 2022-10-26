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
/* loaded from: classes4.dex */
public abstract class i38 extends u38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public uv7 d;
    public final List e;
    public boolean f;
    public ArrayList g;
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

    public abstract void D(uv7 uv7Var);

    public void E(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ww7Var) == null) {
        }
    }

    public abstract void F(uv7 uv7Var);

    public abstract void G(String str);

    public abstract oz7 e();

    public abstract jy7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(uv7 uv7Var, boolean z, String str, boolean z2);

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

    public i38(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void H() {
        uv7 uv7Var;
        qn8 qn8Var;
        qn8 qn8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (uv7Var = this.d) == null || uv7Var.b0 || uv7Var.c0 == 2) {
            return;
        }
        ArrayList G = uv7Var.G();
        ArrayList e = this.d.e();
        if (e != null && !e.isEmpty() && G != null && !G.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = e.iterator();
            while (it.hasNext()) {
                qn8 qn8Var3 = (qn8) it.next();
                if (qn8Var3 != null && qn8Var3.l1() != null) {
                    sb.append(qn8Var3.l1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator it2 = e.iterator();
            while (it2.hasNext()) {
                qn8 qn8Var4 = (qn8) it2.next();
                if (qn8Var4 != null) {
                    qn8Var4.c1 = qn8Var4.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it3 = e.iterator();
            while (it3.hasNext()) {
                qn8 qn8Var5 = (qn8) it3.next();
                if (qn8Var5.getAdvertAppInfo() != null) {
                    int n = qn8Var5.getAdvertAppInfo().n();
                    if (n != 0) {
                        yf8.j(qn8Var5, n);
                        if (n != 28 && n != 31) {
                            qn8Var5.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + n);
                        }
                    }
                    sparseArray.put(qn8Var5.getPosition(), qn8Var5);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                qn8 qn8Var6 = (qn8) sparseArray.get(sparseArray.keyAt(i));
                if (qn8Var6 != null && (qn8Var2 = (qn8) hashMap.put(qn8Var6.k1(), qn8Var6)) != null) {
                    yf8.j(qn8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qn8Var = (qn8) entry.getValue()) != null) {
                    sparseArray.put(qn8Var.getPosition(), qn8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                qn8 qn8Var7 = (qn8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    qn8Var7.W0 = this.d.l().getId();
                }
                if (this.d.P() != null) {
                    qn8Var7.Z0 = eh.g(this.d.P().getId(), 0L);
                }
                uv7 uv7Var2 = this.d;
                if (uv7Var2 != null && uv7Var2.y() != null) {
                    qn8Var7.a1 = this.d.y().a();
                }
                b(qn8Var7);
                int position = qn8Var7.getPosition() + this.d.a0;
                if (position >= G.size()) {
                    qn8Var7.c1 = position;
                    yf8.k(qn8Var7, 2, position + i3, G.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    qn8Var7.c1 = position;
                }
                if (position < 0) {
                    yf8.j(qn8Var7, 23);
                } else if (h(G, position)) {
                    yf8.j(qn8Var7, 1);
                } else {
                    G.add(position, qn8Var7);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qn8Var7.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.u38
    public ArrayList a() {
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

    public final void b(qn8 qn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qn8Var) == null) && qn8Var != null && this.d != null && qn8Var.getAdvertAppInfo() != null) {
            qn8Var.getAdvertAppInfo().i = new fr4();
            if (this.d.y() != null) {
                qn8Var.getAdvertAppInfo().i.b = this.d.y().a();
            }
            qn8Var.getAdvertAppInfo().i.a = qn8Var.m1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                qn8Var.getAdvertAppInfo().i.c = l.getId();
                qn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                qn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qn8Var.getAdvertAppInfo().i.g = qn8Var.getAdvertAppInfo().g;
            qn8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof qn8) {
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
                eo eoVar = (eo) this.g.get(i);
                if (eoVar instanceof hw7) {
                    this.l = i;
                    z = true;
                } else if ((eoVar instanceof tv7) && ((tv7) eoVar).a() == this.a) {
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

    public void r(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, uv7Var) == null) {
            s(uv7Var, false);
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

    public void s(uv7 uv7Var, boolean z) {
        qn8 qn8Var;
        PostData postData;
        boolean z2;
        uv7 uv7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, uv7Var, z) != null) || uv7Var == null) {
            return;
        }
        this.d = uv7Var;
        if (uv7Var != null && uv7Var.P() != null && uv7Var.P().getAuthor() != null) {
            this.h = uv7Var.P().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.clear();
        Iterator it = uv7Var.G().iterator();
        while (true) {
            qn8Var = null;
            if (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof PostData) {
                    postData = (PostData) eoVar;
                    if (postData.D() == 1) {
                        break;
                    }
                }
            } else {
                postData = null;
                break;
            }
        }
        if (postData == null && uv7Var.j() != null) {
            postData = uv7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(uv7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(uv7Var.G()) && uv7Var.G().get(0) != null && uv7Var.P() != null) {
            uv7Var.P().setItem(((PostData) uv7Var.G().get(0)).Q());
            uv7Var.P().setItemStar(((PostData) uv7Var.G().get(0)).R());
        }
        if (uv7Var.P() != null && uv7Var.P().getRawThreadInfo() != null) {
            du4 du4Var = new du4();
            du4Var.t = uv7Var.P();
            du4Var.n = true;
            this.g.add(du4Var);
        }
        iw7 iw7Var = new iw7(uv7Var.P(), uv7Var.d());
        iw7Var.j(false);
        iw7Var.b = false;
        this.g.add(iw7Var);
        if (postData != null && postData.j0 != null && (uv7Var.l() == null || !TextUtils.equals(uv7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            xv7 xv7Var = new xv7(postData.j0);
            xv7Var.b = this.b.K().m2();
            this.g.add(xv7Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && uv7Var.l() != null && !StringUtils.isNull(uv7Var.l().getName()) && (!TextUtils.equals(uv7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            wv7 wv7Var = new wv7(uv7Var.l());
            wv7Var.g = this.b.K().m2();
            wv7Var.e = false;
            this.g.add(wv7Var);
            iw7Var.j(false);
            iw7Var.b = false;
        }
        if (uv7Var.P() != null && !StringUtils.isNull(uv7Var.P().getForum_name())) {
            ow7 ow7Var = new ow7();
            ow7Var.a = uv7Var.P();
            this.g.add(ow7Var);
        } else if (uv7Var.P() != null && !StringUtils.isNull(uv7Var.n())) {
            uv7Var.P().setForum_name(uv7Var.n());
            ow7 ow7Var2 = new ow7();
            ow7Var2.a = uv7Var.P();
            this.g.add(ow7Var2);
        }
        if (j() && uv7Var.y() != null && uv7Var.y().c() == 1) {
            cw7 cw7Var = new cw7(cw7.c);
            cw7Var.b(true);
            this.g.add(cw7Var);
        }
        hw7 hw7Var = new hw7(hw7.i);
        ThreadData P = uv7Var.P();
        if (P != null) {
            P.getReply_num();
        }
        this.b.K().k2();
        hw7Var.d = k();
        hw7Var.c = uv7Var.g;
        uv7Var.c();
        hw7Var.e = uv7Var.k0();
        hw7Var.g = uv7Var.f;
        D(uv7Var);
        this.g.add(hw7Var);
        if (uv7Var.M() == 4) {
            this.g.add(new gw7());
        }
        H();
        p(i());
        Iterator it2 = uv7Var.G().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            eo eoVar2 = (eo) it2.next();
            if ((eoVar2 instanceof PostData) && ((PostData) eoVar2).D() != 1) {
                this.g.add(eoVar2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((uv7Var2 = this.d) == null || !uv7Var2.t()))) {
            ew7 ew7Var = new ew7();
            ew7Var.V0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0aef);
            ew7Var.U0 = R.drawable.new_pic_emotion_03;
            ew7Var.W0 = -2;
            ew7Var.X0 = fj.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(ew7Var);
        }
        q(uv7Var, this.j, this.h, this.i);
        if (uv7Var.y().b() == 0) {
            uv7 uv7Var3 = this.d;
            if (uv7Var3 != null && uv7Var3.t()) {
                C(this.b.B().O3());
                this.g.add(new bw7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.R());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().O3());
                aw7 aw7Var = new aw7();
                aw7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a0c);
                this.g.add(aw7Var);
            }
            List b0 = uv7Var.b0();
            int i2 = -1;
            if (b0 != null && !b0.isEmpty()) {
                qn8Var = (qn8) b0.get(0);
                i2 = qn8Var.getPosition();
            }
            if (!ListUtils.isEmpty(uv7Var.f())) {
                tv7 tv7Var = new tv7();
                tv7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff0));
                tv7Var.c(this.a);
                this.g.add(tv7Var);
                int i3 = 1;
                for (rr4 rr4Var : uv7Var.f()) {
                    if (b0 != null && i3 == i2) {
                        if (qn8Var != null) {
                            b(qn8Var);
                            this.g.add(qn8Var);
                            i++;
                            if (qn8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < b0.size()) {
                            qn8 qn8Var2 = (qn8) b0.get(i);
                            qn8Var = qn8Var2;
                            i2 = qn8Var2.getPosition();
                        }
                    }
                    this.g.add(rr4Var);
                    i3++;
                    if (i3 == 4 && uv7Var.C() != null) {
                        this.g.add(uv7Var.C());
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
