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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private TextView hqL;
    private RelativeLayout ikK;
    private c ikL;
    private View.OnClickListener ikM;
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
        this.ikK = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.mTitleView = (TextView) findViewById(R.id.frs_move_area_choose_title);
        this.hqL = (TextView) findViewById(R.id.frs_move_area_choose_done);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.tbds78), l.getDimens(getContext(), R.dimen.tbds53), false));
        this.ikL = new c(this);
        this.mRecyclerView.setAdapter(this.ikL);
        this.ikK.setOnClickListener(this);
        this.hqL.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.ikM = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            ckh();
        } else if (view == this.hqL && this.mPageContext != null && getParent() != null && this.ikL.ckg() >= 0) {
            boolean z = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_frs_move_area_tip", true);
            List<FrsTabInfo> cas = com.baidu.tieba.frs.a.cap().cas();
            FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(cas, this.ikL.ckf());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(cas, this.ikL.ckg());
            if (frsTabInfo != null && frsTabInfo2 != null) {
                if (z) {
                    new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                } else {
                    com.baidu.tieba.frs.a.cap().bV(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                }
                if (this.ikM != null) {
                    view.setTag("choose_done");
                    this.ikM.onClick(view);
                }
            }
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        ao.setBackgroundResource(this.ikK, R.drawable.frs_move_area_choose_bg);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_c);
        ckh();
        ao.setBackgroundColor(this.mRecyclerView, R.color.cp_bg_line_k);
    }

    private void ckh() {
        if (this.ikL.ckg() >= 0) {
            ao.setViewTextColor(this.hqL, R.color.cp_link_tip_a);
        } else {
            ao.setViewTextColor(this.hqL, R.color.cp_link_tip_a_alpha50);
        }
    }
}
