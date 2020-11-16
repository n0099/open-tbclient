package com.baidu.tieba.frs.view;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes21.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private RelativeLayout jok;
    private EMTextView jol;
    private EMTextView jom;
    private c jon;
    private EMTextView joo;
    private View.OnClickListener jop;
    private TbPageContext mPageContext;
    private RecyclerView mRecyclerView;

    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        setGravity(80);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_choose_layout, this);
        this.jok = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jol = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jom = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.joo = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jon = new c(this);
        this.mRecyclerView.setAdapter(this.jon);
        this.jok.setOnClickListener(this);
        this.jom.setOnClickListener(this);
        this.joo.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jop = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cGP();
        } else if (view == this.jom) {
            if (this.mPageContext != null && getParent() != null && this.jon.cGO() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cwK = com.baidu.tieba.frs.a.cwH().cwK();
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cwK, this.jon.cGN());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cwK, this.jon.cGO());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cwH().ck(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jop != null) {
                        view.setTag("choose_done");
                        this.jop.onClick(view);
                    }
                }
            }
        } else if (view == this.joo && this.jop != null) {
            view.setTag("cancel_view");
            this.jop.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.jok).pb(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jol, R.color.CAM_X0108);
        ap.setViewTextColor(this.jom, R.color.CAM_X0304);
        cGP();
        ap.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ap.k(this.joo, R.color.CAM_X0107);
    }

    private void cGP() {
        if (this.jon.cGO() >= 0) {
            this.jom.setAlpha(1.0f);
        } else {
            this.jom.setAlpha(0.5f);
        }
    }
}
