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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private TextView hla;
    private RelativeLayout ieK;
    private c ieL;
    private View.OnClickListener ieM;
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
        this.ieK = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.mTitleView = (TextView) findViewById(R.id.frs_move_area_choose_title);
        this.hla = (TextView) findViewById(R.id.frs_move_area_choose_done);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.tbds78), l.getDimens(getContext(), R.dimen.tbds53), false));
        this.ieL = new c(this);
        this.mRecyclerView.setAdapter(this.ieL);
        this.ieK.setOnClickListener(this);
        this.hla.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.ieM = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cgI();
        } else if (view == this.hla && this.mPageContext != null && getParent() != null && this.ieL.cgH() >= 0) {
            boolean z = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_frs_move_area_tip", true);
            List<FrsTabInfo> bWZ = com.baidu.tieba.frs.a.bWW().bWZ();
            FrsTabInfo frsTabInfo = (FrsTabInfo) w.getItem(bWZ, this.ieL.cgG());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) w.getItem(bWZ, this.ieL.cgH());
            if (frsTabInfo != null && frsTabInfo2 != null) {
                if (z) {
                    new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                } else {
                    com.baidu.tieba.frs.a.bWW().bS(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                }
                if (this.ieM != null) {
                    view.setTag("choose_done");
                    this.ieM.onClick(view);
                }
            }
        }
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        an.setBackgroundResource(this.ieK, R.drawable.frs_move_area_choose_bg);
        an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_c);
        cgI();
        an.setBackgroundColor(this.mRecyclerView, R.color.cp_bg_line_k);
    }

    private void cgI() {
        if (this.ieL.cgH() >= 0) {
            an.setViewTextColor(this.hla, (int) R.color.cp_link_tip_a);
        } else {
            an.setViewTextColor(this.hla, (int) R.color.cp_link_tip_a_alpha50);
        }
    }
}
