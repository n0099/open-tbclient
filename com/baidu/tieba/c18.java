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
public abstract class c18 extends o18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public kt7 d;
    public final List<cn> e;
    public boolean f;
    public ArrayList<pn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public c18(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public abstract void D(kt7 kt7Var);

    public void E(mu7 mu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mu7Var) == null) {
        }
    }

    public abstract void F(kt7 kt7Var);

    public abstract void G(String str);

    public final void H() {
        kt7 kt7Var;
        gl8 gl8Var;
        gl8 gl8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kt7Var = this.d) == null || kt7Var.b0 || kt7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = kt7Var.F();
        ArrayList<gl8> e = this.d.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<gl8> it = e.iterator();
        while (it.hasNext()) {
            gl8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<gl8> it2 = e.iterator();
        while (it2.hasNext()) {
            gl8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<gl8> it3 = e.iterator();
        while (it3.hasNext()) {
            gl8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    rd8.j(next3, n);
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
            gl8 gl8Var3 = (gl8) sparseArray.get(sparseArray.keyAt(i));
            if (gl8Var3 != null && (gl8Var2 = (gl8) hashMap.put(gl8Var3.i1(), gl8Var3)) != null) {
                rd8.j(gl8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (gl8Var = (gl8) entry.getValue()) != null) {
                sparseArray.put(gl8Var.getPosition(), gl8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            gl8 gl8Var4 = (gl8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.d.l() != null) {
                gl8Var4.V0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                gl8Var4.Y0 = pg.g(this.d.O().getId(), 0L);
            }
            kt7 kt7Var2 = this.d;
            if (kt7Var2 != null && kt7Var2.y() != null) {
                gl8Var4.Z0 = this.d.y().a();
            }
            b(gl8Var4);
            int position = gl8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                gl8Var4.b1 = position;
                rd8.k(gl8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                gl8Var4.b1 = position;
            }
            if (position < 0) {
                rd8.j(gl8Var4, 23);
            } else if (h(F, position)) {
                rd8.j(gl8Var4, 1);
            } else {
                F.add(position, gl8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", gl8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.baidu.tieba.o18
    public ArrayList<pn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(gl8 gl8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gl8Var) == null) || gl8Var == null || this.d == null || gl8Var.getAdvertAppInfo() == null) {
            return;
        }
        gl8Var.getAdvertAppInfo().i = new lo4();
        if (this.d.y() != null) {
            gl8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        gl8Var.getAdvertAppInfo().i.a = gl8Var.k1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
            gl8Var.getAdvertAppInfo().i.c = l.getId();
            gl8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            gl8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            gl8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        gl8Var.getAdvertAppInfo().i.g = gl8Var.getAdvertAppInfo().g;
        gl8Var.getAdvertAppInfo().i.h = false;
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

    public abstract ix7 e();

    public abstract ew7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof gl8) {
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
                if (pnVar instanceof xt7) {
                    this.l = i;
                    z = true;
                } else if ((pnVar instanceof jt7) && ((jt7) pnVar).a() == this.a) {
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

    public abstract void q(kt7 kt7Var, boolean z, String str, boolean z2);

    public void r(kt7 kt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, kt7Var) == null) {
            s(kt7Var, false);
        }
    }

    public void s(kt7 kt7Var, boolean z) {
        gl8 gl8Var;
        PostData postData;
        boolean z2;
        kt7 kt7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, kt7Var, z) == null) || kt7Var == null) {
            return;
        }
        this.d = kt7Var;
        if (kt7Var != null && kt7Var.O() != null && kt7Var.O().getAuthor() != null) {
            this.h = kt7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = kt7Var.F().iterator();
        while (true) {
            gl8Var = null;
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
        if (postData == null && kt7Var.j() != null) {
            postData = kt7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(kt7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(kt7Var.F()) && kt7Var.F().get(0) != null && kt7Var.O() != null) {
            kt7Var.O().setItem(kt7Var.F().get(0).O());
            kt7Var.O().setItemStar(kt7Var.F().get(0).P());
        }
        if (kt7Var.O() != null && kt7Var.O().getRawThreadInfo() != null) {
            jr4 jr4Var = new jr4();
            jr4Var.t = kt7Var.O();
            jr4Var.n = true;
            this.g.add(jr4Var);
        }
        yt7 yt7Var = new yt7(kt7Var.O(), kt7Var.d());
        yt7Var.j(false);
        yt7Var.b = false;
        this.g.add(yt7Var);
        if (postData == null || postData.i0 == null || (kt7Var.l() != null && TextUtils.equals(kt7Var.l().getName(), this.b.K().r1()) && this.b.K().x1())) {
            z2 = false;
        } else {
            nt7 nt7Var = new nt7(postData.i0);
            nt7Var.b = this.b.K().m2();
            this.g.add(nt7Var);
            z2 = true;
        }
        if (!z2 && kt7Var.l() != null && !StringUtils.isNull(kt7Var.l().getName()) && (!TextUtils.equals(kt7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            mt7 mt7Var = new mt7(kt7Var.l());
            mt7Var.g = this.b.K().m2();
            mt7Var.e = false;
            this.g.add(mt7Var);
            yt7Var.j(false);
            yt7Var.b = false;
        }
        if (kt7Var.O() != null && !StringUtils.isNull(kt7Var.O().getForum_name())) {
            eu7 eu7Var = new eu7();
            eu7Var.a = kt7Var.O();
            this.g.add(eu7Var);
        } else if (kt7Var.O() != null && !StringUtils.isNull(kt7Var.n())) {
            kt7Var.O().setForum_name(kt7Var.n());
            eu7 eu7Var2 = new eu7();
            eu7Var2.a = kt7Var.O();
            this.g.add(eu7Var2);
        }
        if (j() && kt7Var.y() != null && kt7Var.y().c() == 1) {
            st7 st7Var = new st7(st7.c);
            st7Var.b(true);
            this.g.add(st7Var);
        }
        xt7 xt7Var = new xt7(xt7.i);
        ThreadData O = kt7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().k2();
        xt7Var.d = k();
        xt7Var.c = kt7Var.g;
        kt7Var.c();
        xt7Var.e = kt7Var.i0();
        xt7Var.g = kt7Var.f;
        D(kt7Var);
        this.g.add(xt7Var);
        if (kt7Var.L() == 4) {
            this.g.add(new wt7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = kt7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !pi.z()) && ((kt7Var2 = this.d) == null || !kt7Var2.t()))) {
            ut7 ut7Var = new ut7();
            ut7Var.U0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0acb);
            ut7Var.T0 = R.drawable.new_pic_emotion_03;
            ut7Var.V0 = -2;
            ut7Var.W0 = ri.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(ut7Var);
        }
        q(kt7Var, this.j, this.h, this.i);
        if (kt7Var.y().b() == 0) {
            kt7 kt7Var3 = this.d;
            if (kt7Var3 != null && kt7Var3.t()) {
                C(this.b.B().R3());
                this.g.add(new rt7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().R3());
                qt7 qt7Var = new qt7();
                qt7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec);
                this.g.add(qt7Var);
            }
            List<gl8> Z = kt7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                gl8Var = Z.get(0);
                i2 = gl8Var.getPosition();
            }
            if (!ListUtils.isEmpty(kt7Var.f())) {
                jt7 jt7Var = new jt7();
                jt7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc1));
                jt7Var.c(this.a);
                this.g.add(jt7Var);
                int i3 = 1;
                for (xo4 xo4Var : kt7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (gl8Var != null) {
                            b(gl8Var);
                            this.g.add(gl8Var);
                            i++;
                            if (gl8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            gl8 gl8Var2 = Z.get(i);
                            gl8Var = gl8Var2;
                            i2 = gl8Var2.getPosition();
                        }
                    }
                    this.g.add(xo4Var);
                    i3++;
                    if (i3 == 4 && kt7Var.C() != null) {
                        this.g.add(kt7Var.C());
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
