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
    private RelativeLayout jJK;
    private EMTextView jJL;
    private EMTextView jJM;
    private FrsMoveAreaChooseAdapter jJN;
    private EMTextView jJO;
    private View.OnClickListener jJP;
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
        this.jJK = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jJL = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jJM = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jJO = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jJN = new FrsMoveAreaChooseAdapter(this);
        this.mRecyclerView.setAdapter(this.jJN);
        this.jJK.setOnClickListener(this);
        this.jJM.setOnClickListener(this);
        this.jJO.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jJP = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cLr();
        } else if (view == this.jJM) {
            if (this.mPageContext != null && getParent() != null && this.jJN.cLq() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cAc = com.baidu.tieba.frs.a.czZ().cAc();
                FrsTabInfo frsTabInfo = (FrsTabInfo) x.getItem(cAc, this.jJN.cLp());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(cAc, this.jJN.cLq());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new c().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.czZ().cn(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jJP != null) {
                        view.setTag("choose_done");
                        this.jJP.onClick(view);
                    }
                }
            }
        } else if (view == this.jJO && this.jJP != null) {
            view.setTag("cancel_view");
            this.jJP.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jJK).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ao.setViewTextColor(this.jJL, R.color.CAM_X0108);
        ao.setViewTextColor(this.jJM, R.color.CAM_X0304);
        cLr();
        ao.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ao.n(this.jJO, R.color.CAM_X0107);
    }

    private void cLr() {
        if (this.jJN.cLq() >= 0) {
            this.jJM.setAlpha(1.0f);
        } else {
            this.jJM.setAlpha(0.5f);
        }
    }
}
