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
/* loaded from: classes22.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private RelativeLayout jBM;
    private EMTextView jBN;
    private EMTextView jBO;
    private c jBP;
    private EMTextView jBQ;
    private View.OnClickListener jBR;
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
        this.jBM = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jBN = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jBO = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jBQ = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jBP = new c(this);
        this.mRecyclerView.setAdapter(this.jBP);
        this.jBM.setOnClickListener(this);
        this.jBO.setOnClickListener(this);
        this.jBQ.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jBR = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cMe();
        } else if (view == this.jBO) {
            if (this.mPageContext != null && getParent() != null && this.jBP.cMd() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cAZ = com.baidu.tieba.frs.a.cAW().cAZ();
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cAZ, this.jBP.cMc());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cAZ, this.jBP.cMd());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cAW().co(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jBR != null) {
                        view.setTag("choose_done");
                        this.jBR.onClick(view);
                    }
                }
            }
        } else if (view == this.jBQ && this.jBR != null) {
            view.setTag("cancel_view");
            this.jBR.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jBM).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jBN, R.color.CAM_X0108);
        ap.setViewTextColor(this.jBO, R.color.CAM_X0304);
        cMe();
        ap.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ap.k(this.jBQ, R.color.CAM_X0107);
    }

    private void cMe() {
        if (this.jBP.cMd() >= 0) {
            this.jBO.setAlpha(1.0f);
        } else {
            this.jBO.setAlpha(0.5f);
        }
    }
}
