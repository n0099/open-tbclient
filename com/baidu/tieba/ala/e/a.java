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
    private BdListView hfm;
    private LinearLayout hfn;
    private LinearLayout hfo;
    private com.baidu.tieba.ala.adapter.a hfp;
    private AlaChallengeHistoryHeaderView hfq;
    private TextView hfr;
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
        this.hfm = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.hfm.setVisibility(4);
        this.hfn = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.hfo = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.hfr = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.hfp = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.hfm.setAdapter((ListAdapter) this.hfp);
        this.hfq = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.hfm.setEmptyView(this.hfn);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.hfm.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.hfq.getParent() == null) {
                if (this.hfq.getParent() != null) {
                    ((ViewGroup) this.hfq.getParent()).removeView(this.hfq);
                }
                this.hfm.addHeaderView(this.hfq);
                this.hfq.setData(nVar);
            }
        } else if (this.hfq.getParent() != null) {
            ((ViewGroup) this.hfq.getParent()).removeView(this.hfq);
        }
        if (this.hfp != null && arrayList != null) {
            this.hfp.setData(arrayList);
        }
    }

    public void GY(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.hfp != null && this.hfp.getCount() <= 0) {
                this.hfn.setVisibility(8);
                this.hfo.setVisibility(0);
                this.hfr.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
