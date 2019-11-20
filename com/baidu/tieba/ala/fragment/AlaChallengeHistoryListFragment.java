package com.baidu.tieba.ala.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.tieba.ala.c.a;
import com.baidu.tieba.ala.message.AlaGetChallengeHistoryListResponseMessage;
/* loaded from: classes6.dex */
public class AlaChallengeHistoryListFragment extends BaseFragment {
    private a dHu;
    private com.baidu.tieba.ala.a.a dHv;
    private a.InterfaceC0338a dHw = new a.InterfaceC0338a() { // from class: com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment.1
        @Override // com.baidu.tieba.ala.c.a.InterfaceC0338a
        public void a(int i, String str, Object obj) {
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaChallengeHistoryListFragment.this.dHv != null) {
                    AlaChallengeHistoryListFragment.this.dHv.tq(AlaChallengeHistoryListFragment.this.getString(a.i.ala_rank_list_net_error));
                }
            } else if (obj != null && (obj instanceof AlaGetChallengeHistoryListResponseMessage)) {
                AlaGetChallengeHistoryListResponseMessage alaGetChallengeHistoryListResponseMessage = (AlaGetChallengeHistoryListResponseMessage) obj;
                AlaChallengeHistoryListFragment.this.dHv.a(alaGetChallengeHistoryListResponseMessage.dub, alaGetChallengeHistoryListResponseMessage.esg);
            }
        }
    };
    private boolean dtP;
    private String portrait;

    public static AlaChallengeHistoryListFragment e(int i, String str, boolean z) {
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
        this.dtP = arguments.getBoolean("is_from_host");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dHv = new com.baidu.tieba.ala.a.a(getPageContext());
        this.dHu = new com.baidu.tieba.ala.c.a(getPageContext(), this.dHw);
        refreshData();
        return this.dHv.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!isAdded()) {
        }
    }

    private void refreshData() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.dHu.uf(this.portrait);
        } else if (this.dHv != null) {
            this.dHv.tq(getString(a.i.ala_rank_list_no_net));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dHu != null) {
            this.dHu.destroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }
}
