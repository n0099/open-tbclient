package com.baidu.tieba.ala.e;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private Activity bIs;
    private BdListView gGO;
    private LinearLayout gGP;
    private LinearLayout gGQ;
    private com.baidu.tieba.ala.adapter.a gGR;
    private AlaChallengeHistoryHeaderView gGS;
    private TextView gGT;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bIs = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bIs).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gGO = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.gGO.setVisibility(4);
        this.gGP = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.gGQ = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.gGT = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.gGR = new com.baidu.tieba.ala.adapter.a(this.bIs);
        this.gGO.setAdapter((ListAdapter) this.gGR);
        this.gGS = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gGO.setEmptyView(this.gGP);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.gGO.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.gGS.getParent() == null) {
                if (this.gGS.getParent() != null) {
                    ((ViewGroup) this.gGS.getParent()).removeView(this.gGS);
                }
                this.gGO.addHeaderView(this.gGS);
                this.gGS.setData(nVar);
            }
        } else if (this.gGS.getParent() != null) {
            ((ViewGroup) this.gGS.getParent()).removeView(this.gGS);
        }
        if (this.gGR != null && arrayList != null) {
            this.gGR.setData(arrayList);
        }
    }

    public void Hj(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gGR != null && this.gGR.getCount() <= 0) {
                this.gGP.setVisibility(8);
                this.gGQ.setVisibility(0);
                this.gGT.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bIs, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
