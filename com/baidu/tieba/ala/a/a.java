package com.baidu.tieba.ala.a;

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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private Activity cft;
    private BdListView dQp;
    private LinearLayout dQq;
    private LinearLayout dQr;
    private com.baidu.tieba.ala.adapter.a dQs;
    private AlaChallengeHistoryHeaderView dQt;
    private TextView dQu;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cft = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.cft).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.dQp = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.dQp.setVisibility(4);
        this.dQq = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.dQr = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.dQu = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.dQs = new com.baidu.tieba.ala.adapter.a(this.cft);
        this.dQp.setAdapter((ListAdapter) this.dQs);
        this.dQt = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.dQp.setEmptyView(this.dQq);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, d dVar) {
        this.dQp.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && dVar != null) {
            if (this.dQt.getParent() == null) {
                if (this.dQt.getParent() != null) {
                    ((ViewGroup) this.dQt.getParent()).removeView(this.dQt);
                }
                this.dQp.addHeaderView(this.dQt);
                this.dQt.setData(dVar);
            }
        } else if (this.dQt.getParent() != null) {
            ((ViewGroup) this.dQt.getParent()).removeView(this.dQt);
        }
        if (this.dQs != null && arrayList != null) {
            this.dQs.setData(arrayList);
        }
    }

    public void tq(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.dQs != null && this.dQs.getCount() <= 0) {
                this.dQq.setVisibility(8);
                this.dQr.setVisibility(0);
                this.dQu.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.cft, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
