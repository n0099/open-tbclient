package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import d.b.b.e.p.j;
import d.b.h0.d0.g;
import d.b.i0.t.j.g.c.a;
import d.b.i0.t.j.g.c.d.a;
/* loaded from: classes4.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static final String l = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.j.g.c.d.a f15044e;

    /* renamed from: f  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel f15045f;

    /* renamed from: g  reason: collision with root package name */
    public g f15046g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.j.g.c.a f15047h;
    public AlaPersonCenterPrivilegeMarkModel.b i = new b();
    public View.OnClickListener j = new c();
    public a.c k = new d();

    /* loaded from: classes4.dex */
    public class a implements a.i {
        public a() {
        }

        @Override // d.b.i0.t.j.g.c.a.i
        public void a(boolean z, d.b.i0.t.j.g.c.c.b bVar) {
            if (z) {
                AlaAchievementMarkFragment.this.I0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaPersonCenterPrivilegeMarkModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.b
        public void a(int i, String str, Object obj) {
            AlaAchievementMarkFragment.this.n();
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaAchievementMarkFragment.this.f15044e != null) {
                    if (j.z()) {
                        AlaAchievementMarkFragment.this.f15044e.h(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    } else {
                        AlaAchievementMarkFragment.this.f15044e.h(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, AlaAchievementMarkFragment.this.j);
                    }
                    AlaAchievementMarkFragment.this.f15044e.g(null, null);
                }
            } else if (obj == null) {
                AlaAchievementMarkFragment.this.f15044e.g(null, null);
            } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                if (AlaAchievementMarkFragment.this.f15044e != null) {
                    AlaAchievementMarkFragment.this.f15044e.d();
                    AlaAchievementMarkFragment.this.f15044e.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                AlaAchievementMarkFragment.this.I0();
                return;
            }
            AlaAchievementMarkFragment alaAchievementMarkFragment = AlaAchievementMarkFragment.this;
            alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.no_network_guide));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.c {
        public d() {
        }

        @Override // d.b.i0.t.j.g.c.d.a.c
        public void a(d.b.i0.t.j.g.c.c.b bVar) {
        }
    }

    public final void I0() {
        if (this.f15045f == null) {
            this.f15045f = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.i);
        }
        this.f15045f.u();
    }

    public final void J0() {
        if (this.f15046g == null) {
            this.f15046g = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        d.b.i0.t.j.g.c.d.a aVar = this.f15044e;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f15046g.attachView(this.f15044e.c(), false);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        return 0;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        return l;
    }

    public final void n() {
        d.b.i0.t.j.g.c.d.a aVar;
        if (this.f15046g == null || (aVar = this.f15044e) == null || aVar.c() == null) {
            return;
        }
        this.f15046g.dettachView(this.f15044e.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        g gVar = this.f15046g;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f15044e = new d.b.i0.t.j.g.c.d.a(getPageContext(), this.k);
        J0();
        I0();
        this.f15047h = new d.b.i0.t.j.g.c.a(getPageContext(), new a());
        return this.f15044e.c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.f15045f;
        if (alaPersonCenterPrivilegeMarkModel != null) {
            alaPersonCenterPrivilegeMarkModel.destory();
        }
        d.b.i0.t.j.g.c.a aVar = this.f15047h;
        if (aVar != null) {
            aVar.p();
        }
        n();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            TiebaStatic.log("c13334");
        }
    }
}
