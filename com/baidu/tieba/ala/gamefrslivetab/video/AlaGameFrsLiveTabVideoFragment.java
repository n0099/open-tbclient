package com.baidu.tieba.ala.gamefrslivetab.video;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import d.b.j0.q0.r0;
import java.net.URL;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements r0 {

    /* renamed from: f  reason: collision with root package name */
    public String f14687f;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.t.g.a.b f14689h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14686e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14688g = true;
    public CustomMessageListener i = new a(0);
    public CustomMessageListener j = new b(2921023);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsGameLive".equals(split[0]) && 8 == d.b.c.e.m.b.d(split[1], 0)) {
                if (AlaGameFrsLiveTabVideoFragment.this.f14689h != null) {
                    AlaGameFrsLiveTabVideoFragment.this.f14689h.i();
                }
            } else if ("FrsGameLiveLive".equals(split[0]) && 3 == d.b.c.e.m.b.d(split[1], 0) && AlaGameFrsLiveTabVideoFragment.this.f14689h != null) {
                AlaGameFrsLiveTabVideoFragment.this.f14689h.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaGameFrsLiveTabVideoFragment.this.G0().contains(str) || str.contains(AlaGameFrsLiveTabVideoFragment.this.G0())) {
                    AlaGameFrsLiveTabVideoFragment.this.f14689h.l();
                }
            }
        }
    }

    public final String F0(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        try {
            if (StringUtils.isNull(new URL(str).getQuery())) {
                return str + "?isNightModel=1";
            }
            return str + "&isNightModel=1";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public String G0() {
        String p = d.b.i0.r.d0.b.j().p("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
        if (p != null) {
            StringBuilder sb = new StringBuilder(p);
            if (p.endsWith("?")) {
                sb.append("fid=");
                sb.append(this.f14687f);
            } else {
                sb.append("?fid=");
                sb.append(this.f14687f);
            }
            return sb.toString();
        }
        return "http://tieba.baidu.com/n/interact/video/game";
    }

    public void H0(String str) {
        this.f14687f = str;
    }

    public void I0(String str) {
    }

    public void J0(boolean z) {
        this.f14686e = z;
    }

    @Override // d.b.j0.q0.r0
    public NavigationBar Q() {
        return this.f14689h.j();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14689h.o(this);
        registerListener(this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.f14688g) {
            return;
        }
        if (i == 1) {
            this.f14689h.y(F0(G0()));
        } else {
            this.f14689h.y(G0());
        }
        this.f14689h.A(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(2001446, this.i, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.j0.t.g.a.b bVar = new d.b.j0.t.g.a.b(this.f14686e);
        this.f14689h = bVar;
        return bVar.B(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.t.g.a.b bVar = this.f14689h;
        if (bVar != null) {
            bVar.C();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.f14688g || StringUtils.isNull(this.f14689h.k().getUrl())) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f14689h.y(F0(G0()));
            } else {
                this.f14689h.y(G0());
            }
            this.f14688g = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
