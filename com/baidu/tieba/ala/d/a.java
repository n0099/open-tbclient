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
    private Activity caN;
    private BdListView foY;
    private LinearLayout foZ;
    private LinearLayout fpa;
    private com.baidu.tieba.ala.adapter.a fpb;
    private AlaChallengeHistoryHeaderView fpc;
    private TextView fpd;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.caN = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.caN).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.foY = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.foY.setVisibility(4);
        this.foZ = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.fpa = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.fpd = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.fpb = new com.baidu.tieba.ala.adapter.a(this.caN);
        this.foY.setAdapter((ListAdapter) this.fpb);
        this.fpc = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.foY.setEmptyView(this.foZ);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.foY.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.fpc.getParent() == null) {
                if (this.fpc.getParent() != null) {
                    ((ViewGroup) this.fpc.getParent()).removeView(this.fpc);
                }
                this.foY.addHeaderView(this.fpc);
                this.fpc.setData(kVar);
            }
        } else if (this.fpc.getParent() != null) {
            ((ViewGroup) this.fpc.getParent()).removeView(this.fpc);
        }
        if (this.fpb != null && arrayList != null) {
            this.fpb.setData(arrayList);
        }
    }

    public void Aq(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.fpb != null && this.fpb.getCount() <= 0) {
                this.foZ.setVisibility(8);
                this.fpa.setVisibility(0);
                this.fpd.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.caN, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
