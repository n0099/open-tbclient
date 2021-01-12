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
/* loaded from: classes10.dex */
public class a {
    private BdListView hcD;
    private LinearLayout hcE;
    private LinearLayout hcF;
    private com.baidu.tieba.ala.adapter.a hcG;
    private AlaChallengeHistoryHeaderView hcH;
    private TextView hcI;
    private Activity mContext;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.hcD = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.hcD.setVisibility(4);
        this.hcE = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.hcF = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.hcI = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.hcG = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.hcD.setAdapter((ListAdapter) this.hcG);
        this.hcH = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.hcD.setEmptyView(this.hcE);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.hcD.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.hcH.getParent() == null) {
                if (this.hcH.getParent() != null) {
                    ((ViewGroup) this.hcH.getParent()).removeView(this.hcH);
                }
                this.hcD.addHeaderView(this.hcH);
                this.hcH.setData(nVar);
            }
        } else if (this.hcH.getParent() != null) {
            ((ViewGroup) this.hcH.getParent()).removeView(this.hcH);
        }
        if (this.hcG != null && arrayList != null) {
            this.hcG.setData(arrayList);
        }
    }

    public void Gz(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.hcG != null && this.hcG.getCount() <= 0) {
                this.hcE.setVisibility(8);
                this.hcF.setVisibility(0);
                this.hcI.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
