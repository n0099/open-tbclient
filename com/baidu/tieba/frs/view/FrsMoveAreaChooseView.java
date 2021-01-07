package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private RelativeLayout jOq;
    private EMTextView jOr;
    private EMTextView jOs;
    private FrsMoveAreaChooseAdapter jOt;
    private EMTextView jOu;
    private View.OnClickListener jOv;
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
        this.jOq = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jOr = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jOs = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jOu = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jOt = new FrsMoveAreaChooseAdapter(this);
        this.mRecyclerView.setAdapter(this.jOt);
        this.jOq.setOnClickListener(this);
        this.jOs.setOnClickListener(this);
        this.jOu.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jOv = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cPj();
        } else if (view == this.jOs) {
            if (this.mPageContext != null && getParent() != null && this.jOt.cPi() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cDU = com.baidu.tieba.frs.a.cDR().cDU();
                FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(cDU, this.jOt.cPh());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(cDU, this.jOt.cPi());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new c().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cDR().cn(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jOv != null) {
                        view.setTag("choose_done");
                        this.jOv.onClick(view);
                    }
                }
            }
        } else if (view == this.jOu && this.jOv != null) {
            view.setTag("cancel_view");
            this.jOv.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jOq).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ao.setViewTextColor(this.jOr, R.color.CAM_X0108);
        ao.setViewTextColor(this.jOs, R.color.CAM_X0304);
        cPj();
        ao.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ao.n(this.jOu, R.color.CAM_X0107);
    }

    private void cPj() {
        if (this.jOt.cPi() >= 0) {
            this.jOs.setAlpha(1.0f);
        } else {
            this.jOs.setAlpha(0.5f);
        }
    }
}
