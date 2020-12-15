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
/* loaded from: classes4.dex */
public class a {
    private Activity beD;
    private AlaChallengeHistoryHeaderView gVA;
    private TextView gVB;
    private BdListView gVw;
    private LinearLayout gVx;
    private LinearLayout gVy;
    private com.baidu.tieba.ala.adapter.a gVz;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.beD = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.beD).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gVw = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.gVw.setVisibility(4);
        this.gVx = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.gVy = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.gVB = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.gVz = new com.baidu.tieba.ala.adapter.a(this.beD);
        this.gVw.setAdapter((ListAdapter) this.gVz);
        this.gVA = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gVw.setEmptyView(this.gVx);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.gVw.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.gVA.getParent() == null) {
                if (this.gVA.getParent() != null) {
                    ((ViewGroup) this.gVA.getParent()).removeView(this.gVA);
                }
                this.gVw.addHeaderView(this.gVA);
                this.gVA.setData(nVar);
            }
        } else if (this.gVA.getParent() != null) {
            ((ViewGroup) this.gVA.getParent()).removeView(this.gVA);
        }
        if (this.gVz != null && arrayList != null) {
            this.gVz.setData(arrayList);
        }
    }

    public void HL(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gVz != null && this.gVz.getCount() <= 0) {
                this.gVx.setVisibility(8);
                this.gVy.setVisibility(0);
                this.gVB.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.beD, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
