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
/* loaded from: classes11.dex */
public class a {
    private BdListView hhj;
    private LinearLayout hhk;
    private LinearLayout hhl;
    private com.baidu.tieba.ala.adapter.a hhm;
    private AlaChallengeHistoryHeaderView hhn;
    private TextView hho;
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
        this.hhj = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.hhj.setVisibility(4);
        this.hhk = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.hhl = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.hho = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.hhm = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.hhj.setAdapter((ListAdapter) this.hhm);
        this.hhn = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.hhj.setEmptyView(this.hhk);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.hhj.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.hhn.getParent() == null) {
                if (this.hhn.getParent() != null) {
                    ((ViewGroup) this.hhn.getParent()).removeView(this.hhn);
                }
                this.hhj.addHeaderView(this.hhn);
                this.hhn.setData(nVar);
            }
        } else if (this.hhn.getParent() != null) {
            ((ViewGroup) this.hhn.getParent()).removeView(this.hhn);
        }
        if (this.hhm != null && arrayList != null) {
            this.hhm.setData(arrayList);
        }
    }

    public void HK(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.hhm != null && this.hhm.getCount() <= 0) {
                this.hhk.setVisibility(8);
                this.hhl.setVisibility(0);
                this.hho.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
