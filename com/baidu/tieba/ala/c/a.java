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
    private BdListView eJT;
    private LinearLayout eJU;
    private LinearLayout eJV;
    private com.baidu.tieba.ala.adapter.a eJW;
    private AlaChallengeHistoryHeaderView eJX;
    private TextView eJY;
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
        this.eJT = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.eJT.setVisibility(4);
        this.eJU = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.eJV = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.eJY = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.eJW = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.eJT.setAdapter((ListAdapter) this.eJW);
        this.eJX = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.eJT.setEmptyView(this.eJU);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.eJT.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.eJX.getParent() == null) {
                if (this.eJX.getParent() != null) {
                    ((ViewGroup) this.eJX.getParent()).removeView(this.eJX);
                }
                this.eJT.addHeaderView(this.eJX);
                this.eJX.setData(kVar);
            }
        } else if (this.eJX.getParent() != null) {
            ((ViewGroup) this.eJX.getParent()).removeView(this.eJX);
        }
        if (this.eJW != null && arrayList != null) {
            this.eJW.setData(arrayList);
        }
    }

    public void yD(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.eJW != null && this.eJW.getCount() <= 0) {
                this.eJU.setVisibility(8);
                this.eJV.setVisibility(0);
                this.eJY.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
