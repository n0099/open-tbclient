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
    private Activity clq;
    private BdListView fCX;
    private LinearLayout fCY;
    private LinearLayout fCZ;
    private com.baidu.tieba.ala.adapter.a fDa;
    private AlaChallengeHistoryHeaderView fDb;
    private TextView fDc;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.clq = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.clq).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.fCX = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.fCX.setVisibility(4);
        this.fCY = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.fCZ = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.fDc = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.fDa = new com.baidu.tieba.ala.adapter.a(this.clq);
        this.fCX.setAdapter((ListAdapter) this.fDa);
        this.fDb = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.fCX.setEmptyView(this.fCY);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.fCX.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.fDb.getParent() == null) {
                if (this.fDb.getParent() != null) {
                    ((ViewGroup) this.fDb.getParent()).removeView(this.fDb);
                }
                this.fCX.addHeaderView(this.fDb);
                this.fDb.setData(kVar);
            }
        } else if (this.fDb.getParent() != null) {
            ((ViewGroup) this.fDb.getParent()).removeView(this.fDb);
        }
        if (this.fDa != null && arrayList != null) {
            this.fDa.setData(arrayList);
        }
    }

    public void BX(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.fDa != null && this.fDa.getCount() <= 0) {
                this.fCY.setVisibility(8);
                this.fCZ.setVisibility(0);
                this.fDc.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.clq, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
