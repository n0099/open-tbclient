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
    private Activity ceC;
    private LinearLayout dPA;
    private com.baidu.tieba.ala.adapter.a dPB;
    private AlaChallengeHistoryHeaderView dPC;
    private TextView dPD;
    private BdListView dPy;
    private LinearLayout dPz;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ceC = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.ceC).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.dPy = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.dPy.setVisibility(4);
        this.dPz = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.dPA = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.dPD = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.dPB = new com.baidu.tieba.ala.adapter.a(this.ceC);
        this.dPy.setAdapter((ListAdapter) this.dPB);
        this.dPC = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.dPy.setEmptyView(this.dPz);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, d dVar) {
        this.dPy.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && dVar != null) {
            if (this.dPC.getParent() == null) {
                if (this.dPC.getParent() != null) {
                    ((ViewGroup) this.dPC.getParent()).removeView(this.dPC);
                }
                this.dPy.addHeaderView(this.dPC);
                this.dPC.setData(dVar);
            }
        } else if (this.dPC.getParent() != null) {
            ((ViewGroup) this.dPC.getParent()).removeView(this.dPC);
        }
        if (this.dPB != null && arrayList != null) {
            this.dPB.setData(arrayList);
        }
    }

    public void tq(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.dPB != null && this.dPB.getCount() <= 0) {
                this.dPz.setVisibility(8);
                this.dPA.setVisibility(0);
                this.dPD.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.ceC, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
