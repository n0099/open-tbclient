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
    private Activity czY;
    private LinearLayout gfA;
    private com.baidu.tieba.ala.adapter.a gfB;
    private AlaChallengeHistoryHeaderView gfC;
    private TextView gfD;
    private BdListView gfy;
    private LinearLayout gfz;
    private TbPageContext<BaseFragmentActivity> mTbPageContext;
    private View view;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.czY = this.mTbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.czY).inflate(a.h.ala_challenge_fragment_layout, (ViewGroup) null);
        this.gfy = (BdListView) this.view.findViewById(a.g.ala_challenge_list_view);
        this.gfy.setVisibility(4);
        this.gfz = (LinearLayout) this.view.findViewById(a.g.layout_ala_challenge_list_empty);
        this.gfA = (LinearLayout) this.view.findViewById(a.g.ala_challenge_list_no_network);
        this.gfD = (TextView) this.view.findViewById(a.g.ala_challenge_list_no_net_tip);
        this.gfB = new com.baidu.tieba.ala.adapter.a(this.czY);
        this.gfy.setAdapter((ListAdapter) this.gfB);
        this.gfC = new AlaChallengeHistoryHeaderView(this.mTbPageContext.getPageActivity());
        this.gfy.setEmptyView(this.gfz);
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.a> arrayList, l lVar) {
        this.gfy.setVisibility(0);
        if (!ListUtils.isEmpty(arrayList) && lVar != null) {
            if (this.gfC.getParent() == null) {
                if (this.gfC.getParent() != null) {
                    ((ViewGroup) this.gfC.getParent()).removeView(this.gfC);
                }
                this.gfy.addHeaderView(this.gfC);
                this.gfC.setData(lVar);
            }
        } else if (this.gfC.getParent() != null) {
            ((ViewGroup) this.gfC.getParent()).removeView(this.gfC);
        }
        if (this.gfB != null && arrayList != null) {
            this.gfB.setData(arrayList);
        }
    }

    public void FC(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gfB != null && this.gfB.getCount() <= 0) {
                this.gfz.setVisibility(8);
                this.gfA.setVisibility(0);
                this.gfD.setText(str);
                return;
            }
            BdUtilHelper.showToast(this.czY, str, 1);
        }
    }

    public View getView() {
        return this.view;
    }
}
