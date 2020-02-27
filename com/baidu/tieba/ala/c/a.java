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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private BdListView eJS;
    private LinearLayout eJT;
    private LinearLayout eJU;
    private com.baidu.tieba.ala.adapter.a eJV;
    private AlaChallengeHistoryHeaderView eJW;
    private TextView eJX;
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
        this.eJS = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eJS.setVisibility(4);
        this.eJT = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eJU = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eJX = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eJV = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eJS.setAdapter((ListAdapter) this.eJV);
        this.eJW = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eJS.setEmptyView(this.eJT);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eJS.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eJW.getParent() == null) {
                if (this.eJW.getParent() != null) {
                    ((ViewGroup) this.eJW.getParent()).removeView(this.eJW);
                }
                this.eJS.addHeaderView(this.eJW);
                this.eJW.setData(kVar);
            }
        } else if (this.eJW.getParent() != null) {
            ((ViewGroup) this.eJW.getParent()).removeView(this.eJW);
        }
        if (this.eJV != null && arrayList != null) {
            this.eJV.setData(arrayList);
        }
    }

    public void yD(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eJV != null && this.eJV.getCount() <= 0) {
                this.eJT.setVisibility(8);
                this.eJU.setVisibility(0);
                this.eJX.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
