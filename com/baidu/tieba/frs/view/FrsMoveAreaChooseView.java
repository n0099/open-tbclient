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
    private RelativeLayout jQV;
    private EMTextView jQW;
    private EMTextView jQX;
    private FrsMoveAreaChooseAdapter jQY;
    private EMTextView jQZ;
    private View.OnClickListener jRa;
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
        this.jQV = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.jQW = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.jQX = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.jQZ = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_H_X003), false));
        this.jQY = new FrsMoveAreaChooseAdapter(this);
        this.mRecyclerView.setAdapter(this.jQY);
        this.jQV.setOnClickListener(this);
        this.jQX.setOnClickListener(this);
        this.jQZ.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.jRa = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            cNm();
        } else if (view == this.jQX) {
            if (this.mPageContext != null && getParent() != null && this.jQY.cNl() >= 0) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_frs_move_area_tip", true);
                List<FrsTabInfo> cBu = com.baidu.tieba.frs.a.cBr().cBu();
                FrsTabInfo frsTabInfo = (FrsTabInfo) y.getItem(cBu, this.jQY.cMF());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(cBu, this.jQY.cNl());
                if (frsTabInfo != null && frsTabInfo2 != null) {
                    if (z) {
                        new c().a(this.mPageContext, frsTabInfo, frsTabInfo2);
                    } else {
                        com.baidu.tieba.frs.a.cBr().cl(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                    }
                    if (this.jRa != null) {
                        view.setTag("choose_done");
                        this.jRa.onClick(view);
                    }
                }
            }
        } else if (view == this.jQZ && this.jRa != null) {
            view.setTag("cancel_view");
            this.jRa.onClick(view);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jQV).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jQW, R.color.CAM_X0108);
        ap.setViewTextColor(this.jQX, R.color.CAM_X0304);
        cNm();
        ap.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0204);
        ap.n(this.jQZ, R.color.CAM_X0107);
    }

    private void cNm() {
        if (this.jQY.cNl() >= 0) {
            this.jQX.setAlpha(1.0f);
        } else {
            this.jQX.setAlpha(0.5f);
        }
    }
}
