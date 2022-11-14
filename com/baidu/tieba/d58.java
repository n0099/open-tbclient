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
public abstract class d58 extends p58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public ox7 d;
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

    public abstract void D(ox7 ox7Var);

    public void E(qy7 qy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qy7Var) == null) {
        }
    }

    public abstract void F(ox7 ox7Var);

    public abstract void G(String str);

    public abstract i18 e();

    public abstract d08 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(ox7 ox7Var, boolean z, String str, boolean z2);

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

    public d58(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        ox7 ox7Var;
        kp8 kp8Var;
        kp8 kp8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ox7Var = this.d) == null || ox7Var.c0 || ox7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = ox7Var.H();
        ArrayList<kp8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<kp8> it = e.iterator();
            while (it.hasNext()) {
                kp8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<kp8> it2 = e.iterator();
            while (it2.hasNext()) {
                kp8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<kp8> it3 = e.iterator();
            while (it3.hasNext()) {
                kp8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        th8.j(next3, n);
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
                kp8 kp8Var3 = (kp8) sparseArray.get(sparseArray.keyAt(i));
                if (kp8Var3 != null && (kp8Var2 = (kp8) hashMap.put(kp8Var3.m1(), kp8Var3)) != null) {
                    th8.j(kp8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (kp8Var = (kp8) entry.getValue()) != null) {
                    sparseArray.put(kp8Var.getPosition(), kp8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                kp8 kp8Var4 = (kp8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    kp8Var4.Y0 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    kp8Var4.b1 = xg.g(this.d.Q().getId(), 0L);
                }
                ox7 ox7Var2 = this.d;
                if (ox7Var2 != null && ox7Var2.z() != null) {
                    kp8Var4.c1 = this.d.z().a();
                }
                b(kp8Var4);
                int position = kp8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    kp8Var4.e1 = position;
                    th8.k(kp8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    kp8Var4.e1 = position;
                }
                if (position < 0) {
                    th8.j(kp8Var4, 23);
                } else if (h(H, position)) {
                    th8.j(kp8Var4, 1);
                } else {
                    H.add(position, kp8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", kp8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.p58
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

    public final void b(kp8 kp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, kp8Var) == null) && kp8Var != null && this.d != null && kp8Var.getAdvertAppInfo() != null) {
            kp8Var.getAdvertAppInfo().i = new xr4();
            if (this.d.z() != null) {
                kp8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            kp8Var.getAdvertAppInfo().i.a = kp8Var.o1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                kp8Var.getAdvertAppInfo().i.c = l.getId();
                kp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                kp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                kp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            kp8Var.getAdvertAppInfo().i.g = kp8Var.getAdvertAppInfo().g;
            kp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof kp8) {
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
                if (xnVar instanceof by7) {
                    this.l = i;
                    z = true;
                } else if ((xnVar instanceof nx7) && ((nx7) xnVar).a() == this.a) {
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

    public void r(ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ox7Var) == null) {
            s(ox7Var, false);
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

    public void s(ox7 ox7Var, boolean z) {
        kp8 kp8Var;
        PostData postData;
        boolean z2;
        ox7 ox7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, ox7Var, z) != null) || ox7Var == null) {
            return;
        }
        this.d = ox7Var;
        if (ox7Var != null && ox7Var.Q() != null && ox7Var.Q().getAuthor() != null) {
            this.h = ox7Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = ox7Var.H().iterator();
        while (true) {
            kp8Var = null;
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
        if (postData == null && ox7Var.j() != null) {
            postData = ox7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(ox7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(ox7Var.H()) && ox7Var.H().get(0) != null && ox7Var.Q() != null) {
            ox7Var.Q().setItem(ox7Var.H().get(0).Q());
            ox7Var.Q().setItemStar(ox7Var.H().get(0).R());
        }
        if (ox7Var.Q() != null && ox7Var.Q().getRawThreadInfo() != null) {
            wu4 wu4Var = new wu4();
            wu4Var.t = ox7Var.Q();
            wu4Var.n = true;
            this.g.add(wu4Var);
        }
        cy7 cy7Var = new cy7(ox7Var.Q(), ox7Var.d());
        cy7Var.j(false);
        cy7Var.b = false;
        this.g.add(cy7Var);
        if (postData != null && postData.q0 != null && (ox7Var.l() == null || !TextUtils.equals(ox7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            rx7 rx7Var = new rx7(postData.q0);
            rx7Var.b = this.b.K().m2();
            this.g.add(rx7Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && ox7Var.l() != null && !StringUtils.isNull(ox7Var.l().getName()) && (!TextUtils.equals(ox7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            qx7 qx7Var = new qx7(ox7Var.l());
            qx7Var.g = this.b.K().m2();
            qx7Var.e = false;
            this.g.add(qx7Var);
            cy7Var.j(false);
            cy7Var.b = false;
        }
        if (ox7Var.Q() != null && !StringUtils.isNull(ox7Var.Q().getForum_name())) {
            iy7 iy7Var = new iy7();
            iy7Var.a = ox7Var.Q();
            this.g.add(iy7Var);
        } else if (ox7Var.Q() != null && !StringUtils.isNull(ox7Var.n())) {
            ox7Var.Q().setForum_name(ox7Var.n());
            iy7 iy7Var2 = new iy7();
            iy7Var2.a = ox7Var.Q();
            this.g.add(iy7Var2);
        }
        if (j() && ox7Var.z() != null && ox7Var.z().c() == 1) {
            wx7 wx7Var = new wx7(wx7.c);
            wx7Var.b(true);
            this.g.add(wx7Var);
        }
        by7 by7Var = new by7(by7.i);
        ThreadData Q = ox7Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.K().k2();
        by7Var.d = k();
        by7Var.c = ox7Var.g;
        ox7Var.c();
        by7Var.e = ox7Var.l0();
        by7Var.g = ox7Var.f;
        D(ox7Var);
        this.g.add(by7Var);
        if (ox7Var.N() == 4) {
            this.g.add(new ay7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = ox7Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.D() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((ox7Var2 = this.d) == null || !ox7Var2.t()))) {
            yx7 yx7Var = new yx7();
            yx7Var.X0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0afd);
            yx7Var.W0 = R.drawable.new_pic_emotion_03;
            yx7Var.Y0 = -2;
            yx7Var.Z0 = yi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(yx7Var);
        }
        q(ox7Var, this.j, this.h, this.i);
        if (ox7Var.z().b() == 0) {
            ox7 ox7Var3 = this.d;
            if (ox7Var3 != null && ox7Var3.t()) {
                C(this.b.B().O3());
                this.g.add(new vx7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().O3());
                ux7 ux7Var = new ux7();
                ux7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a);
                this.g.add(ux7Var);
            }
            List<kp8> c0 = ox7Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                kp8Var = c0.get(0);
                i2 = kp8Var.getPosition();
            }
            if (!ListUtils.isEmpty(ox7Var.f())) {
                nx7 nx7Var = new nx7();
                nx7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1011));
                nx7Var.c(this.a);
                this.g.add(nx7Var);
                int i3 = 1;
                for (js4 js4Var : ox7Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (kp8Var != null) {
                            b(kp8Var);
                            this.g.add(kp8Var);
                            i++;
                            if (kp8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            kp8 kp8Var2 = c0.get(i);
                            kp8Var = kp8Var2;
                            i2 = kp8Var2.getPosition();
                        }
                    }
                    this.g.add(js4Var);
                    i3++;
                    if (i3 == 4 && ox7Var.D() != null) {
                        this.g.add(ox7Var.D());
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
