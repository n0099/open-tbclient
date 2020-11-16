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
    private Activity bMo;
    private BdListView gMh;
    private LinearLayout gMi;
    private LinearLayout gMj;
    private com.baidu.tieba.ala.adapter.a gMk;
    private AlaChallengeHistoryHeaderView gMl;
    private TextView gMm;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bMo = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.bMo).inflate(a.g.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gMh = (BdListView) this.view.findViewById(a.f.ala_challenge_list_view);
        this.gMh.setVisibility(4);
        this.gMi = (LinearLayout) this.view.findViewById(a.f.layout_ala_challenge_list_empty);
        this.gMj = (LinearLayout) this.view.findViewById(a.f.ala_challenge_list_no_network);
        this.gMm = (TextView) this.view.findViewById(a.f.ala_challenge_list_no_net_tip);
        this.gMk = new com.baidu.tieba.ala.adapter.a(this.bMo);
        this.gMh.setAdapter((ListAdapter) this.gMk);
        this.gMl = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gMh.setEmptyView(this.gMi);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, n nVar) {
        this.gMh.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && nVar != null) {
            if (this.gMl.getParent() == null) {
                if (this.gMl.getParent() != null) {
                    ((ViewGroup) this.gMl.getParent()).removeView(this.gMl);
                }
                this.gMh.addHeaderView(this.gMl);
                this.gMl.setData(nVar);
            }
        } else if (this.gMl.getParent() != null) {
            ((ViewGroup) this.gMl.getParent()).removeView(this.gMl);
        }
        if (this.gMk != null && arrayList != null) {
            this.gMk.setData(arrayList);
        }
    }

    public void GX(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gMk != null && this.gMk.getCount() <= 0) {
                this.gMi.setVisibility(8);
                this.gMj.setVisibility(0);
                this.gMm.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.bMo, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
