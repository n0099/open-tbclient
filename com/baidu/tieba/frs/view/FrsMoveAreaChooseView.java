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
    private RelativeLayout jBO;
    private EMTextView jBP;
    private EMTextView jBQ;
    private c jBR;
    private EMTextView jBS;
    private View.OnClickListener jBT;
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
        this.jBO = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jBP = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jBQ = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jBS = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new f(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jBR = new c(this);
        this.mRecyclerView.setAdapter(this.jBR);
        this.jBO.setOnClickListener(this);
        this.jBQ.setOnClickListener(this);
        this.jBS.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jBT = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cMf();
        } else if (view == this.jBQ) {
            if (this.mPageContext != null && getParent() != null && this.jBR.cMe() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cBa = com.baidu.tieba.frs.a.cAX().cBa();
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cBa, this.jBR.cMd());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cBa, this.jBR.cMe());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new d().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cAX().co(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jBT != null) {
                        view.setTag("choose_done");
                        this.jBT.onClick(view);
                    }
                }
            }
        } else if (view == this.jBS && this.jBT != null) {
            view.setTag("cancel_view");
            this.jBT.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jBO).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jBP, R.color.CAM_X0108);
        ap.setViewTextColor(this.jBQ, R.color.CAM_X0304);
        cMf();
        ap.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ap.k(this.jBS, R.color.CAM_X0107);
    }

    private void cMf() {
        if (this.jBR.cMe() >= 0) {
            this.jBQ.setAlpha(1.0f);
        } else {
            this.jBQ.setAlpha(0.5f);
        }
    }
}
