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
    private Activity bFt;
    private BdListView gva;
    private LinearLayout gvb;
    private LinearLayout gvc;
    private com.baidu.tieba.ala.adapter.a gvd;
    private AlaChallengeHistoryHeaderView gve;
    private TextView gvf;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bFt = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bFt).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gva = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.gva.setVisibility(4);
        this.gvb = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.gvc = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.gvf = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.gvd = new com.baidu.tieba.ala.adapter.a(this.bFt);
        this.gva.setAdapter((ListAdapter) this.gvd);
        this.gve = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gva.setEmptyView(this.gvb);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, l lVar) {
        this.gva.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && lVar != null) {
            if (this.gve.getParent() == null) {
                if (this.gve.getParent() != null) {
                    ((ViewGroup) this.gve.getParent()).removeView(this.gve);
                }
                this.gva.addHeaderView(this.gve);
                this.gve.setData(lVar);
            }
        } else if (this.gve.getParent() != null) {
            ((ViewGroup) this.gve.getParent()).removeView(this.gve);
        }
        if (this.gvd != null && arrayList != null) {
            this.gvd.setData(arrayList);
        }
    }

    public void GL(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gvd != null && this.gvd.getCount() <= 0) {
                this.gvb.setVisibility(8);
                this.gvc.setVisibility(0);
                this.gvf.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bFt, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
