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
/* loaded from: classes11.dex */
public class a {
    private BdListView hfA;
    private LinearLayout hfB;
    private LinearLayout hfC;
    private com.baidu.tieba.ala.adapter.a hfD;
    private AlaChallengeHistoryHeaderView hfE;
    private TextView hfF;
    private Activity mContext;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.hfA = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.hfA.setVisibility(4);
        this.hfB = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.hfC = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.hfF = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.hfD = new com.baidu.tieba.ala.adapter.a(this.mContext);
        this.hfA.setAdapter((ListAdapter) this.hfD);
        this.hfE = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.hfA.setEmptyView(this.hfB);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.hfA.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.hfE.getParent() == null) {
                if (this.hfE.getParent() != null) {
                    ((ViewGroup) this.hfE.getParent()).removeView(this.hfE);
                }
                this.hfA.addHeaderView(this.hfE);
                this.hfE.setData(nVar);
            }
        } else if (this.hfE.getParent() != null) {
            ((ViewGroup) this.hfE.getParent()).removeView(this.hfE);
        }
        if (this.hfD != null && arrayList != null) {
            this.hfD.setData(arrayList);
        }
    }

    public void GZ(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.hfD != null && this.hfD.getCount() <= 0) {
                this.hfB.setVisibility(8);
                this.hfC.setVisibility(0);
                this.hfF.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.mContext, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
