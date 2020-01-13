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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private BdListView eFY;
    private LinearLayout eFZ;
    private LinearLayout eGa;
    private com.baidu.tieba.ala.adapter.a eGb;
    private AlaChallengeHistoryHeaderView eGc;
    private TextView eGd;
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
        this.eFY = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eFY.setVisibility(4);
        this.eFZ = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eGa = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eGd = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eGb = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eFY.setAdapter((ListAdapter) this.eGb);
        this.eGc = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eFY.setEmptyView(this.eFZ);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eFY.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eGc.getParent() == null) {
                if (this.eGc.getParent() != null) {
                    ((ViewGroup) this.eGc.getParent()).removeView(this.eGc);
                }
                this.eFY.addHeaderView(this.eGc);
                this.eGc.setData(kVar);
            }
        } else if (this.eGc.getParent() != null) {
            ((ViewGroup) this.eGc.getParent()).removeView(this.eGc);
        }
        if (this.eGb != null && arrayList != null) {
            this.eGb.setData(arrayList);
        }
    }

    public void yh(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eGb != null && this.eGb.getCount() <= 0) {
                this.eFZ.setVisibility(8);
                this.eGa.setVisibility(0);
                this.eGd.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
