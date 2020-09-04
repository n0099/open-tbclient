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
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.view.AlaChallengeHistoryHeaderView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a {
    private Activity cAc;
    private BdListView gfC;
    private LinearLayout gfD;
    private LinearLayout gfE;
    private com.baidu.tieba.ala.adapter.a gfF;
    private AlaChallengeHistoryHeaderView gfG;
    private TextView gfH;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cAc = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.cAc).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gfC = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.gfC.setVisibility(4);
        this.gfD = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.gfE = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.gfH = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.gfF = new com.baidu.tieba.ala.adapter.a(this.cAc);
        this.gfC.setAdapter((ListAdapter) this.gfF);
        this.gfG = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gfC.setEmptyView(this.gfD);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, l lVar) {
        this.gfC.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && lVar != null) {
            if (this.gfG.getParent() == null) {
                if (this.gfG.getParent() != null) {
                    ((ViewGroup) this.gfG.getParent()).removeView(this.gfG);
                }
                this.gfC.addHeaderView(this.gfG);
                this.gfG.setData(lVar);
            }
        } else if (this.gfG.getParent() != null) {
            ((ViewGroup) this.gfG.getParent()).removeView(this.gfG);
        }
        if (this.gfF != null && arrayList != null) {
            this.gfF.setData(arrayList);
        }
    }

    public void FD(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gfF != null && this.gfF.getCount() <= 0) {
                this.gfD.setVisibility(8);
                this.gfE.setVisibility(0);
                this.gfH.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.cAc, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
