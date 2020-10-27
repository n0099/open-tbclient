package com.baidu.tieba.frs.view;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private TextView imf;
    private RelativeLayout jhC;
    private c jhD;
    private View.OnClickListener jhE;
    private TbPageContext mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitleView;

    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        setGravity(80);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_choose_layout, this);
        this.jhC = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.mTitleView = (TextView) findViewById(R.id.frs_move_area_choose_title);
        this.imf = (TextView) findViewById(R.id.frs_move_area_choose_done);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.tbds78), l.getDimens(getContext(), R.dimen.tbds53), false));
        this.jhD = new c(this);
        this.mRecyclerView.setAdapter(this.jhD);
        this.jhC.setOnClickListener(this);
        this.imf.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jhE = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cEJ();
        } else if (view == this.imf && this.mPageContext != null && getParent() != null && this.jhD.cEI() >= 0) {
            boolean z = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_frs_move_area_tip", true);
            List<FrsTabInfo> cuH = com.baidu.tieba.frs.a.cuE().cuH();
            FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cuH, this.jhD.cEH());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cuH, this.jhD.cEI());
            if (frsTabInfo != null && frsTabInfo2 != null) {
                if (z) {
                    new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                } else {
                    com.baidu.tieba.frs.a.cuE().ci(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                }
                if (this.jhE != null) {
                    view.setTag("choose_done");
                    this.jhE.onClick(view);
                }
            }
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        ap.setBackgroundResource(this.jhC, R.drawable.frs_move_area_choose_bg);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_c);
        cEJ();
        ap.setBackgroundColor(this.mRecyclerView, R.color.cp_bg_line_k);
    }

    private void cEJ() {
        if (this.jhD.cEI() >= 0) {
            ap.setViewTextColor(this.imf, R.color.cp_link_tip_a);
        } else {
            ap.setViewTextColor(this.imf, R.color.cp_link_tip_a_alpha50);
        }
    }
}
