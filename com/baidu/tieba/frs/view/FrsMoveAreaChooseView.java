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
/* loaded from: classes16.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private TextView hDC;
    private RelativeLayout iyP;
    private c iyQ;
    private View.OnClickListener iyR;
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
        this.iyP = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.mTitleView = (TextView) findViewById(R.id.frs_move_area_choose_title);
        this.hDC = (TextView) findViewById(R.id.frs_move_area_choose_done);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.tbds78), l.getDimens(getContext(), R.dimen.tbds53), false));
        this.iyQ = new c(this);
        this.mRecyclerView.setAdapter(this.iyQ);
        this.iyP.setOnClickListener(this);
        this.hDC.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.iyR = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cuL();
        } else if (view == this.hDC && this.mPageContext != null && getParent() != null && this.iyQ.cuK() >= 0) {
            boolean z = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_frs_move_area_tip", true);
            List<FrsTabInfo> ckO = com.baidu.tieba.frs.a.ckL().ckO();
            FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(ckO, this.iyQ.cuJ());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(ckO, this.iyQ.cuK());
            if (frsTabInfo != null && frsTabInfo2 != null) {
                if (z) {
                    new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                } else {
                    com.baidu.tieba.frs.a.ckL().cd(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                }
                if (this.iyR != null) {
                    view.setTag("choose_done");
                    this.iyR.onClick(view);
                }
            }
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        ap.setBackgroundResource(this.iyP, R.drawable.frs_move_area_choose_bg);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_c);
        cuL();
        ap.setBackgroundColor(this.mRecyclerView, R.color.cp_bg_line_k);
    }

    private void cuL() {
        if (this.iyQ.cuK() >= 0) {
            ap.setViewTextColor(this.hDC, R.color.cp_link_tip_a);
        } else {
            ap.setViewTextColor(this.hDC, R.color.cp_link_tip_a_alpha50);
        }
    }
}
