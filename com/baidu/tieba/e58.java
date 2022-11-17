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
/* loaded from: classes3.dex */
public abstract class e58 extends q58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public px7 d;
    public final List<kn> e;
    public boolean f;
    public ArrayList<xn> g;
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

    public abstract void D(px7 px7Var);

    public void E(ry7 ry7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ry7Var) == null) {
        }
    }

    public abstract void F(px7 px7Var);

    public abstract void G(String str);

    public abstract j18 e();

    public abstract e08 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(px7 px7Var, boolean z, String str, boolean z2);

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

    public e58(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        px7 px7Var;
        lp8 lp8Var;
        lp8 lp8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (px7Var = this.d) == null || px7Var.c0 || px7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = px7Var.H();
        ArrayList<lp8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<lp8> it = e.iterator();
            while (it.hasNext()) {
                lp8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<lp8> it2 = e.iterator();
            while (it2.hasNext()) {
                lp8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<lp8> it3 = e.iterator();
            while (it3.hasNext()) {
                lp8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        uh8.j(next3, n);
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
                lp8 lp8Var3 = (lp8) sparseArray.get(sparseArray.keyAt(i));
                if (lp8Var3 != null && (lp8Var2 = (lp8) hashMap.put(lp8Var3.m1(), lp8Var3)) != null) {
                    uh8.j(lp8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (lp8Var = (lp8) entry.getValue()) != null) {
                    sparseArray.put(lp8Var.getPosition(), lp8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                lp8 lp8Var4 = (lp8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    lp8Var4.Y0 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    lp8Var4.b1 = xg.g(this.d.Q().getId(), 0L);
                }
                px7 px7Var2 = this.d;
                if (px7Var2 != null && px7Var2.z() != null) {
                    lp8Var4.c1 = this.d.z().a();
                }
                b(lp8Var4);
                int position = lp8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    lp8Var4.e1 = position;
                    uh8.k(lp8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    lp8Var4.e1 = position;
                }
                if (position < 0) {
                    uh8.j(lp8Var4, 23);
                } else if (h(H, position)) {
                    uh8.j(lp8Var4, 1);
                } else {
                    H.add(position, lp8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", lp8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q58
    public ArrayList<xn> a() {
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

    public final void b(lp8 lp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lp8Var) == null) && lp8Var != null && this.d != null && lp8Var.getAdvertAppInfo() != null) {
            lp8Var.getAdvertAppInfo().i = new yr4();
            if (this.d.z() != null) {
                lp8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            lp8Var.getAdvertAppInfo().i.a = lp8Var.o1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                lp8Var.getAdvertAppInfo().i.c = l.getId();
                lp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                lp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lp8Var.getAdvertAppInfo().i.g = lp8Var.getAdvertAppInfo().g;
            lp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof lp8) {
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
                xn xnVar = this.g.get(i);
                if (xnVar instanceof cy7) {
                    this.l = i;
                    z = true;
                } else if ((xnVar instanceof ox7) && ((ox7) xnVar).a() == this.a) {
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

    public void r(px7 px7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, px7Var) == null) {
            s(px7Var, false);
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

    public void s(px7 px7Var, boolean z) {
        lp8 lp8Var;
        PostData postData;
        boolean z2;
        px7 px7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, px7Var, z) != null) || px7Var == null) {
            return;
        }
        this.d = px7Var;
        if (px7Var != null && px7Var.Q() != null && px7Var.Q().getAuthor() != null) {
            this.h = px7Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = px7Var.H().iterator();
        while (true) {
            lp8Var = null;
            if (it.hasNext()) {
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.D() == 1) {
                        break;
                    }
                }
            } else {
                postData = null;
                break;
            }
        }
        if (postData == null && px7Var.j() != null) {
            postData = px7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(px7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(px7Var.H()) && px7Var.H().get(0) != null && px7Var.Q() != null) {
            px7Var.Q().setItem(px7Var.H().get(0).Q());
            px7Var.Q().setItemStar(px7Var.H().get(0).R());
        }
        if (px7Var.Q() != null && px7Var.Q().getRawThreadInfo() != null) {
            xu4 xu4Var = new xu4();
            xu4Var.t = px7Var.Q();
            xu4Var.n = true;
            this.g.add(xu4Var);
        }
        dy7 dy7Var = new dy7(px7Var.Q(), px7Var.d());
        dy7Var.j(false);
        dy7Var.b = false;
        this.g.add(dy7Var);
        if (postData != null && postData.q0 != null && (px7Var.l() == null || !TextUtils.equals(px7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            sx7 sx7Var = new sx7(postData.q0);
            sx7Var.b = this.b.K().m2();
            this.g.add(sx7Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && px7Var.l() != null && !StringUtils.isNull(px7Var.l().getName()) && (!TextUtils.equals(px7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            rx7 rx7Var = new rx7(px7Var.l());
            rx7Var.g = this.b.K().m2();
            rx7Var.e = false;
            this.g.add(rx7Var);
            dy7Var.j(false);
            dy7Var.b = false;
        }
        if (px7Var.Q() != null && !StringUtils.isNull(px7Var.Q().getForum_name())) {
            jy7 jy7Var = new jy7();
            jy7Var.a = px7Var.Q();
            this.g.add(jy7Var);
        } else if (px7Var.Q() != null && !StringUtils.isNull(px7Var.n())) {
            px7Var.Q().setForum_name(px7Var.n());
            jy7 jy7Var2 = new jy7();
            jy7Var2.a = px7Var.Q();
            this.g.add(jy7Var2);
        }
        if (j() && px7Var.z() != null && px7Var.z().c() == 1) {
            xx7 xx7Var = new xx7(xx7.c);
            xx7Var.b(true);
            this.g.add(xx7Var);
        }
        cy7 cy7Var = new cy7(cy7.i);
        ThreadData Q = px7Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.K().k2();
        cy7Var.d = k();
        cy7Var.c = px7Var.g;
        px7Var.c();
        cy7Var.e = px7Var.l0();
        cy7Var.g = px7Var.f;
        D(px7Var);
        this.g.add(cy7Var);
        if (px7Var.N() == 4) {
            this.g.add(new by7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = px7Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.D() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((px7Var2 = this.d) == null || !px7Var2.t()))) {
            zx7 zx7Var = new zx7();
            zx7Var.X0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0afd);
            zx7Var.W0 = R.drawable.new_pic_emotion_03;
            zx7Var.Y0 = -2;
            zx7Var.Z0 = yi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(zx7Var);
        }
        q(px7Var, this.j, this.h, this.i);
        if (px7Var.z().b() == 0) {
            px7 px7Var3 = this.d;
            if (px7Var3 != null && px7Var3.t()) {
                C(this.b.B().O3());
                this.g.add(new wx7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().O3());
                vx7 vx7Var = new vx7();
                vx7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a);
                this.g.add(vx7Var);
            }
            List<lp8> c0 = px7Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                lp8Var = c0.get(0);
                i2 = lp8Var.getPosition();
            }
            if (!ListUtils.isEmpty(px7Var.f())) {
                ox7 ox7Var = new ox7();
                ox7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1011));
                ox7Var.c(this.a);
                this.g.add(ox7Var);
                int i3 = 1;
                for (ks4 ks4Var : px7Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (lp8Var != null) {
                            b(lp8Var);
                            this.g.add(lp8Var);
                            i++;
                            if (lp8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            lp8 lp8Var2 = c0.get(i);
                            lp8Var = lp8Var2;
                            i2 = lp8Var2.getPosition();
                        }
                    }
                    this.g.add(ks4Var);
                    i3++;
                    if (i3 == 4 && px7Var.D() != null) {
                        this.g.add(px7Var.D());
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
