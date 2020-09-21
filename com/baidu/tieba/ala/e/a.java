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
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private Activity byQ;
    private BdListView giN;
    private LinearLayout giO;
    private LinearLayout giP;
    private com.baidu.tieba.ala.adapter.a giQ;
    private AlaChallengeHistoryHeaderView giR;
    private TextView giS;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.byQ = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.byQ).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.giN = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.giN.setVisibility(4);
        this.giO = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.giP = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.giS = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.giQ = new com.baidu.tieba.ala.adapter.a(this.byQ);
        this.giN.setAdapter((ListAdapter) this.giQ);
        this.giR = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.giN.setEmptyView(this.giO);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, l lVar) {
        this.giN.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && lVar != null) {
            if (this.giR.getParent() == null) {
                if (this.giR.getParent() != null) {
                    ((ViewGroup) this.giR.getParent()).removeView(this.giR);
                }
                this.giN.addHeaderView(this.giR);
                this.giR.setData(lVar);
            }
        } else if (this.giR.getParent() != null) {
            ((ViewGroup) this.giR.getParent()).removeView(this.giR);
        }
        if (this.giQ != null && arrayList != null) {
            this.giQ.setData(arrayList);
        }
    }

    public void Ga(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.giQ != null && this.giQ.getCount() <= 0) {
                this.giO.setVisibility(8);
                this.giP.setVisibility(0);
                this.giS.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.byQ, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
