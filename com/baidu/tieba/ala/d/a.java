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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private Activity bdo;
    private BdListView fOg;
    private LinearLayout fOh;
    private LinearLayout fOi;
    private com.baidu.tieba.ala.adapter.a fOj;
    private AlaChallengeHistoryHeaderView fOk;
    private TextView fOl;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bdo = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bdo).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.fOg = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.fOg.setVisibility(4);
        this.fOh = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.fOi = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.fOl = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.fOj = new com.baidu.tieba.ala.adapter.a(this.bdo);
        this.fOg.setAdapter((ListAdapter) this.fOj);
        this.fOk = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.fOg.setEmptyView(this.fOh);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.fOg.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.fOk.getParent() == null) {
                if (this.fOk.getParent() != null) {
                    ((ViewGroup) this.fOk.getParent()).removeView(this.fOk);
                }
                this.fOg.addHeaderView(this.fOk);
                this.fOk.setData(kVar);
            }
        } else if (this.fOk.getParent() != null) {
            ((ViewGroup) this.fOk.getParent()).removeView(this.fOk);
        }
        if (this.fOj != null && arrayList != null) {
            this.fOj.setData(arrayList);
        }
    }

    public void Cv(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.fOj != null && this.fOj.getCount() <= 0) {
                this.fOh.setVisibility(8);
                this.fOi.setVisibility(0);
                this.fOl.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bdo, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
