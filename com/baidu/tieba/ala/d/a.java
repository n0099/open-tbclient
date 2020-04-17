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
    private Activity caH;
    private BdListView foT;
    private LinearLayout foU;
    private LinearLayout foV;
    private com.baidu.tieba.ala.adapter.a foW;
    private AlaChallengeHistoryHeaderView foX;
    private TextView foY;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.caH = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.caH).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.foT = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.foT.setVisibility(4);
        this.foU = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.foV = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.foY = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.foW = new com.baidu.tieba.ala.adapter.a(this.caH);
        this.foT.setAdapter((ListAdapter) this.foW);
        this.foX = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.foT.setEmptyView(this.foU);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, k kVar) {
        this.foT.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && kVar != null) {
            if (this.foX.getParent() == null) {
                if (this.foX.getParent() != null) {
                    ((ViewGroup) this.foX.getParent()).removeView(this.foX);
                }
                this.foT.addHeaderView(this.foX);
                this.foX.setData(kVar);
            }
        } else if (this.foX.getParent() != null) {
            ((ViewGroup) this.foX.getParent()).removeView(this.foX);
        }
        if (this.foW != null && arrayList != null) {
            this.foW.setData(arrayList);
        }
    }

    public void An(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.foW != null && this.foW.getCount() <= 0) {
                this.foU.setVisibility(8);
                this.foV.setVisibility(0);
                this.foY.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.caH, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
