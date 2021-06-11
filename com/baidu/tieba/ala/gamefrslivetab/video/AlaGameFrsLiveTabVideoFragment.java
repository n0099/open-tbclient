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
import d.a.n0.r0.r0;
import java.net.URL;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements r0 {

    /* renamed from: f  reason: collision with root package name */
    public String f14041f;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.g.a.b f14043h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14040e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14042g = true;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f14044i = new a(0);
    public CustomMessageListener j = new b(2921023);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
            if ("FrsGameLive".equals(split[0]) && 8 == d.a.c.e.m.b.d(split[1], 0)) {
                if (AlaGameFrsLiveTabVideoFragment.this.f14043h != null) {
                    AlaGameFrsLiveTabVideoFragment.this.f14043h.i();
                }
            } else if ("FrsGameLiveLive".equals(split[0]) && 3 == d.a.c.e.m.b.d(split[1], 0) && AlaGameFrsLiveTabVideoFragment.this.f14043h != null) {
                AlaGameFrsLiveTabVideoFragment.this.f14043h.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaGameFrsLiveTabVideoFragment.this.I0().contains(str) || str.contains(AlaGameFrsLiveTabVideoFragment.this.I0())) {
                    AlaGameFrsLiveTabVideoFragment.this.f14043h.l();
                }
            }
        }
    }

    public final String H0(String str) {
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

    public String I0() {
        String p = d.a.m0.r.d0.b.j().p("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
        if (p != null) {
            StringBuilder sb = new StringBuilder(p);
            if (p.endsWith("?")) {
                sb.append("fid=");
                sb.append(this.f14041f);
            } else {
                sb.append("?fid=");
                sb.append(this.f14041f);
            }
            return sb.toString();
        }
        return "http://tieba.baidu.com/n/interact/video/game";
    }

    public void J0(String str) {
        this.f14041f = str;
    }

    public void K0(String str) {
    }

    public void L0(boolean z) {
        this.f14040e = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // d.a.n0.r0.r0
    public NavigationBar h0() {
        return this.f14043h.j();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14043h.o(this);
        registerListener(this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.f14042g) {
            return;
        }
        if (i2 == 1) {
            this.f14043h.y(H0(I0()));
        } else {
            this.f14043h.y(I0());
        }
        this.f14043h.A(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(2001446, this.f14044i, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.n0.v.g.a.b bVar = new d.a.n0.v.g.a.b(this.f14040e);
        this.f14043h = bVar;
        return bVar.B(layoutInflater, viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.v.g.a.b bVar = this.f14043h;
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
        if (this.f14042g || StringUtils.isNull(this.f14043h.k().getUrl())) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f14043h.y(H0(I0()));
            } else {
                this.f14043h.y(I0());
            }
            this.f14042g = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
