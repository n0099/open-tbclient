package com.baidu.tieba.ala.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.e.a;
import com.baidu.tieba.ala.message.AlaGetChallengeHistoryListResponseMessage;
/* loaded from: classes3.dex */
public class AlaChallengeHistoryListFragment extends BaseFragment {
    private a eBb;
    private com.baidu.tieba.ala.c.a eBc;
    private a.InterfaceC0430a eBd = new a.InterfaceC0430a() { // from class: com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment.1
        @Override // com.baidu.tieba.ala.e.a.InterfaceC0430a
        public void a(int i, String str, Object obj) {
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaChallengeHistoryListFragment.this.eBc != null) {
                    AlaChallengeHistoryListFragment.this.eBc.yD(AlaChallengeHistoryListFragment.this.getString(a.i.ala_rank_list_net_error));
                }
            } else if (obj != null && (obj instanceof AlaGetChallengeHistoryListResponseMessage)) {
                AlaGetChallengeHistoryListResponseMessage alaGetChallengeHistoryListResponseMessage = (AlaGetChallengeHistoryListResponseMessage) obj;
                AlaChallengeHistoryListFragment.this.eBc.a(alaGetChallengeHistoryListResponseMessage.ejo, alaGetChallengeHistoryListResponseMessage.foT);
            }
        }
    };
    private boolean ehN;
    private String portrait;

    public static AlaChallengeHistoryListFragment g(int i, String str, boolean z) {
        AlaChallengeHistoryListFragment alaChallengeHistoryListFragment = new AlaChallengeHistoryListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("portrait", str);
        bundle.putBoolean("is_from_host", z);
        alaChallengeHistoryListFragment.setArguments(bundle);
        return alaChallengeHistoryListFragment;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.portrait = arguments.getString("portrait");
        this.ehN = arguments.getBoolean("is_from_host");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBc = new com.baidu.tieba.ala.c.a(getPageContext());
        this.eBb = new com.baidu.tieba.ala.e.a(getPageContext(), this.eBd);
        refreshData();
        return this.eBc.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!isAdded()) {
        }
    }

    private void refreshData() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.eBb.zx(this.portrait);
        } else if (this.eBc != null) {
            this.eBc.yD(getString(a.i.ala_rank_list_no_net));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eBb != null) {
            this.eBb.destroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }
}
