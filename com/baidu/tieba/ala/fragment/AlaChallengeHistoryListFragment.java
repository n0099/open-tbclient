package com.baidu.tieba.ala.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.tieba.ala.f.a;
import com.baidu.tieba.ala.message.AlaGetChallengeHistoryListResponseMessage;
/* loaded from: classes3.dex */
public class AlaChallengeHistoryListFragment extends BaseFragment {
    private com.baidu.tieba.ala.f.a fFk;
    private com.baidu.tieba.ala.d.a fFl;
    private a.InterfaceC0542a fFm = new a.InterfaceC0542a() { // from class: com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment.1
        @Override // com.baidu.tieba.ala.f.a.InterfaceC0542a
        public void a(int i, String str, Object obj) {
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaChallengeHistoryListFragment.this.fFl != null) {
                    AlaChallengeHistoryListFragment.this.fFl.Cv(AlaChallengeHistoryListFragment.this.getString(a.i.ala_rank_list_net_error));
                }
            } else if (obj != null && (obj instanceof AlaGetChallengeHistoryListResponseMessage)) {
                AlaGetChallengeHistoryListResponseMessage alaGetChallengeHistoryListResponseMessage = (AlaGetChallengeHistoryListResponseMessage) obj;
                AlaChallengeHistoryListFragment.this.fFl.a(alaGetChallengeHistoryListResponseMessage.fgC, alaGetChallengeHistoryListResponseMessage.gvY);
            }
        }
    };
    private boolean ffg;
    private String portrait;

    public static AlaChallengeHistoryListFragment i(int i, String str, boolean z) {
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
        this.ffg = arguments.getBoolean("is_from_host");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fFl = new com.baidu.tieba.ala.d.a(getPageContext());
        this.fFk = new com.baidu.tieba.ala.f.a(getPageContext(), this.fFm);
        refreshData();
        return this.fFl.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!isAdded()) {
        }
    }

    private void refreshData() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.fFk.Dq(this.portrait);
        } else if (this.fFl != null) {
            this.fFl.Cv(getString(a.i.ala_rank_list_no_net));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fFk != null) {
            this.fFk.destroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }
}
