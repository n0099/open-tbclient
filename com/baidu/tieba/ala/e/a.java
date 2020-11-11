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
    private Activity bNY;
    private BdListView gMA;
    private LinearLayout gMB;
    private LinearLayout gMC;
    private com.baidu.tieba.ala.adapter.a gMD;
    private AlaChallengeHistoryHeaderView gME;
    private TextView gMF;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bNY = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bNY).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gMA = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.gMA.setVisibility(4);
        this.gMB = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.gMC = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.gMF = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.gMD = new com.baidu.tieba.ala.adapter.a(this.bNY);
        this.gMA.setAdapter((ListAdapter) this.gMD);
        this.gME = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gMA.setEmptyView(this.gMB);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.gMA.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.gME.getParent() == null) {
                if (this.gME.getParent() != null) {
                    ((ViewGroup) this.gME.getParent()).removeView(this.gME);
                }
                this.gMA.addHeaderView(this.gME);
                this.gME.setData(nVar);
            }
        } else if (this.gME.getParent() != null) {
            ((ViewGroup) this.gME.getParent()).removeView(this.gME);
        }
        if (this.gMD != null && arrayList != null) {
            this.gMD.setData(arrayList);
        }
    }

    public void Hw(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gMD != null && this.gMD.getCount() <= 0) {
                this.gMB.setVisibility(8);
                this.gMC.setVisibility(0);
                this.gMF.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bNY, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
