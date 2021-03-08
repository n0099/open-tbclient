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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    private RelativeLayout jSE;
    private EMTextView jSF;
    private EMTextView jSG;
    private FrsMoveAreaChooseAdapter jSH;
    private EMTextView jSI;
    private View.OnClickListener jSJ;
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
        this.jSE = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jSF = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jSG = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jSI = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jSH = new FrsMoveAreaChooseAdapter(this);
        this.mRecyclerView.setAdapter(this.jSH);
        this.jSE.setOnClickListener(this);
        this.jSG.setOnClickListener(this);
        this.jSI.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jSJ = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cNs();
        } else if (view == this.jSG) {
            if (this.mPageContext != null && getParent() != null && this.jSH.cNr() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cBA = com.baidu.tieba.frs.a.cBx().cBA();
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cBA, this.jSH.cML());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cBA, this.jSH.cNr());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new c().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cBx().cl(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jSJ != null) {
                        view.setTag("choose_done");
                        this.jSJ.onClick(view);
                    }
                }
            }
        } else if (view == this.jSI && this.jSJ != null) {
            view.setTag("cancel_view");
            this.jSJ.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jSE).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jSF, R.color.CAM_X0108);
        ap.setViewTextColor(this.jSG, R.color.CAM_X0304);
        cNs();
        ap.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ap.n(this.jSI, R.color.CAM_X0107);
    }

    private void cNs() {
        if (this.jSH.cNr() >= 0) {
            this.jSG.setAlpha(1.0f);
        } else {
            this.jSG.setAlpha(0.5f);
        }
    }
}
