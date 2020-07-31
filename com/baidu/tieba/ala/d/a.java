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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private Activity bdG;
    private LinearLayout fTA;
    private LinearLayout fTB;
    private com.baidu.tieba.ala.adapter.a fTC;
    private AlaChallengeHistoryHeaderView fTD;
    private TextView fTE;
    private BdListView fTz;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bdG = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bdG).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.fTz = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.fTz.setVisibility(4);
        this.fTA = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.fTB = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.fTE = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.fTC = new com.baidu.tieba.ala.adapter.a(this.bdG);
        this.fTz.setAdapter((ListAdapter) this.fTC);
        this.fTD = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.fTz.setEmptyView(this.fTA);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, l lVar) {
        this.fTz.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && lVar != null) {
            if (this.fTD.getParent() == null) {
                if (this.fTD.getParent() != null) {
                    ((ViewGroup) this.fTD.getParent()).removeView(this.fTD);
                }
                this.fTz.addHeaderView(this.fTD);
                this.fTD.setData(lVar);
            }
        } else if (this.fTD.getParent() != null) {
            ((ViewGroup) this.fTD.getParent()).removeView(this.fTD);
        }
        if (this.fTC != null && arrayList != null) {
            this.fTC.setData(arrayList);
        }
    }

    public void Dh(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.fTC != null && this.fTC.getCount() <= 0) {
                this.fTA.setVisibility(8);
                this.fTB.setVisibility(0);
                this.fTE.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bdG, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
