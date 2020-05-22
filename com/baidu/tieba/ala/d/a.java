package com.baidu.tieba.ala.d;

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
    private Activity clq;
    private BdListView fCM;
    private LinearLayout fCN;
    private LinearLayout fCO;
    private com.baidu.tieba.ala.adapter.a fCP;
    private AlaChallengeHistoryHeaderView fCQ;
    private TextView fCR;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.clq = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.clq).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.fCM = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.fCM.setVisibility(4);
        this.fCN = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.fCO = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.fCR = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.fCP = new com.baidu.tieba.ala.adapter.a(this.clq);
        this.fCM.setAdapter((ListAdapter) this.fCP);
        this.fCQ = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.fCM.setEmptyView(this.fCN);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.fCM.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.fCQ.getParent() == null) {
                if (this.fCQ.getParent() != null) {
                    ((ViewGroup) this.fCQ.getParent()).removeView(this.fCQ);
                }
                this.fCM.addHeaderView(this.fCQ);
                this.fCQ.setData(kVar);
            }
        } else if (this.fCQ.getParent() != null) {
            ((ViewGroup) this.fCQ.getParent()).removeView(this.fCQ);
        }
        if (this.fCP != null && arrayList != null) {
            this.fCP.setData(arrayList);
        }
    }

    public void BX(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.fCP != null && this.fCP.getCount() <= 0) {
                this.fCN.setVisibility(8);
                this.fCO.setVisibility(0);
                this.fCR.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.clq, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
