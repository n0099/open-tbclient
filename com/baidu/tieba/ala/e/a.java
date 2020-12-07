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
    private BdListView gVu;
    private LinearLayout gVv;
    private LinearLayout gVw;
    private com.baidu.tieba.ala.adapter.a gVx;
    private AlaChallengeHistoryHeaderView gVy;
    private TextView gVz;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.beD = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.beD).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gVu = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.gVu.setVisibility(4);
        this.gVv = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.gVw = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.gVz = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.gVx = new com.baidu.tieba.ala.adapter.a(this.beD);
        this.gVu.setAdapter((ListAdapter) this.gVx);
        this.gVy = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gVu.setEmptyView(this.gVv);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.gVu.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.gVy.getParent() == null) {
                if (this.gVy.getParent() != null) {
                    ((ViewGroup) this.gVy.getParent()).removeView(this.gVy);
                }
                this.gVu.addHeaderView(this.gVy);
                this.gVy.setData(nVar);
            }
        } else if (this.gVy.getParent() != null) {
            ((ViewGroup) this.gVy.getParent()).removeView(this.gVy);
        }
        if (this.gVx != null && arrayList != null) {
            this.gVx.setData(arrayList);
        }
    }

    public void HL(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gVx != null && this.gVx.getCount() <= 0) {
                this.gVv.setVisibility(8);
                this.gVw.setVisibility(0);
                this.gVz.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.beD, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
