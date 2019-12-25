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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private BdListView eEO;
    private LinearLayout eEP;
    private LinearLayout eEQ;
    private com.baidu.tieba.ala.adapter.a eER;
    private AlaChallengeHistoryHeaderView eES;
    private TextView eET;
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
        this.eEO = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eEO.setVisibility(4);
        this.eEP = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eEQ = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eET = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eER = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eEO.setAdapter((ListAdapter) this.eER);
        this.eES = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eEO.setEmptyView(this.eEP);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eEO.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eES.getParent() == null) {
                if (this.eES.getParent() != null) {
                    ((ViewGroup) this.eES.getParent()).removeView(this.eES);
                }
                this.eEO.addHeaderView(this.eES);
                this.eES.setData(kVar);
            }
        } else if (this.eES.getParent() != null) {
            ((ViewGroup) this.eES.getParent()).removeView(this.eES);
        }
        if (this.eER != null && arrayList != null) {
            this.eER.setData(arrayList);
        }
    }

    public void yc(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eER != null && this.eER.getCount() <= 0) {
                this.eEP.setVisibility(8);
                this.eEQ.setVisibility(0);
                this.eET.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
