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
    private BdListView eKg;
    private LinearLayout eKh;
    private LinearLayout eKi;
    private com.baidu.tieba.ala.adapter.a eKj;
    private AlaChallengeHistoryHeaderView eKk;
    private TextView eKl;
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
        this.eKg = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eKg.setVisibility(4);
        this.eKh = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eKi = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eKl = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eKj = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eKg.setAdapter((ListAdapter) this.eKj);
        this.eKk = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eKg.setEmptyView(this.eKh);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eKg.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eKk.getParent() == null) {
                if (this.eKk.getParent() != null) {
                    ((ViewGroup) this.eKk.getParent()).removeView(this.eKk);
                }
                this.eKg.addHeaderView(this.eKk);
                this.eKk.setData(kVar);
            }
        } else if (this.eKk.getParent() != null) {
            ((ViewGroup) this.eKk.getParent()).removeView(this.eKk);
        }
        if (this.eKj != null && arrayList != null) {
            this.eKj.setData(arrayList);
        }
    }

    public void yE(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eKj != null && this.eKj.getCount() <= 0) {
                this.eKh.setVisibility(8);
                this.eKi.setVisibility(0);
                this.eKl.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
