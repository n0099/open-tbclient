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
import d.a.c.e.p.j;
import d.a.i0.d0.g;
import d.a.j0.t.j.g.c.a;
import d.a.j0.t.j.g.c.d.a;
/* loaded from: classes4.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static final String l = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.t.j.g.c.d.a f14797e;

    /* renamed from: f  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel f14798f;

    /* renamed from: g  reason: collision with root package name */
    public g f14799g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t.j.g.c.a f14800h;

    /* renamed from: i  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel.b f14801i = new b();
    public View.OnClickListener j = new c();
    public a.c k = new d();

    /* loaded from: classes4.dex */
    public class a implements a.i {
        public a() {
        }

        @Override // d.a.j0.t.j.g.c.a.i
        public void a(boolean z, d.a.j0.t.j.g.c.c.b bVar) {
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
        public void a(int i2, String str, Object obj) {
            AlaAchievementMarkFragment.this.n();
            if (i2 != 0 && !StringUtils.isNull(str)) {
                if (AlaAchievementMarkFragment.this.f14797e != null) {
                    if (j.z()) {
                        AlaAchievementMarkFragment.this.f14797e.h(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    } else {
                        AlaAchievementMarkFragment.this.f14797e.h(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, AlaAchievementMarkFragment.this.j);
                    }
                    AlaAchievementMarkFragment.this.f14797e.g(null, null);
                }
            } else if (obj == null) {
                AlaAchievementMarkFragment.this.f14797e.g(null, null);
            } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                if (AlaAchievementMarkFragment.this.f14797e != null) {
                    AlaAchievementMarkFragment.this.f14797e.d();
                    AlaAchievementMarkFragment.this.f14797e.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
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

        @Override // d.a.j0.t.j.g.c.d.a.c
        public void a(d.a.j0.t.j.g.c.c.b bVar) {
        }
    }

    public final void I0() {
        if (this.f14798f == null) {
            this.f14798f = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.f14801i);
        }
        this.f14798f.u();
    }

    public final void J0() {
        if (this.f14799g == null) {
            this.f14799g = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        d.a.j0.t.j.g.c.d.a aVar = this.f14797e;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f14799g.attachView(this.f14797e.c(), false);
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
        d.a.j0.t.j.g.c.d.a aVar;
        if (this.f14799g == null || (aVar = this.f14797e) == null || aVar.c() == null) {
            return;
        }
        this.f14799g.dettachView(this.f14797e.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        g gVar = this.f14799g;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f14797e = new d.a.j0.t.j.g.c.d.a(getPageContext(), this.k);
        J0();
        I0();
        this.f14800h = new d.a.j0.t.j.g.c.a(getPageContext(), new a());
        return this.f14797e.c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.f14798f;
        if (alaPersonCenterPrivilegeMarkModel != null) {
            alaPersonCenterPrivilegeMarkModel.destory();
        }
        d.a.j0.t.j.g.c.a aVar = this.f14800h;
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
