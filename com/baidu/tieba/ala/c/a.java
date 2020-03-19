package com.baidu.tieba.ala.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private BdListView eKC;
    private LinearLayout eKD;
    private LinearLayout eKE;
    private com.baidu.tieba.ala.adapter.a eKF;
    private AlaChallengeHistoryHeaderView eKG;
    private TextView eKH;
    private Activity mContext;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.eKC = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eKC.setVisibility(4);
        this.eKD = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eKE = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eKH = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eKF = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eKC.setAdapter((ListAdapter) this.eKF);
        this.eKG = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eKC.setEmptyView(this.eKD);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eKC.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eKG.getParent() == null) {
                if (this.eKG.getParent() != null) {
                    ((ViewGroup) this.eKG.getParent()).removeView(this.eKG);
                }
                this.eKC.addHeaderView(this.eKG);
                this.eKG.setData(kVar);
            }
        } else if (this.eKG.getParent() != null) {
            ((ViewGroup) this.eKG.getParent()).removeView(this.eKG);
        }
        if (this.eKF != null && arrayList != null) {
            this.eKF.setData(arrayList);
        }
    }

    public void yF(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eKF != null && this.eKF.getCount() <= 0) {
                this.eKD.setVisibility(8);
                this.eKE.setVisibility(0);
                this.eKH.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
