package com.baidu.tieba.frs.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int fXA;
    private FrsMoveAreaChooseView jBI;
    private int jBK = -1;
    private List<FrsTabInfo> jBJ = com.baidu.tieba.frs.a.cAX().cBa();
    private SparseArray<FrsTabInfo> jBL = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.fXA = -1;
        this.jBI = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jBJ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jBJ.size()) {
                    FrsTabInfo frsTabInfo = this.jBJ.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cAX().cAZ() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cAX().cAZ()) {
                            this.fXA = i2;
                        }
                        this.jBL.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cMd() {
        return this.fXA;
    }

    public int cMe() {
        return this.jBK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: A */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (!y.isEmpty(this.jBJ) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jBJ, i)) != null) {
            aVar.jBM.setTag(Integer.valueOf(i));
            aVar.jBM.setText(frsTabInfo.tab_name);
            aVar.jBM.setOnClickListener(this);
            b(aVar.jBM, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jBJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jBL.get(intValue) != null) {
                if (this.jBI != null && this.jBI.getContext() != null && this.jBI.getParent() != null) {
                    if (intValue == this.fXA) {
                        new BdTopToast(this.jBI.getContext()).yW(false).Vt(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aF((ViewGroup) this.jBI.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jBI.getContext()).yW(false).Vt(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aF((ViewGroup) this.jBI.getParent());
                        return;
                    }
                }
                return;
            }
            this.jBK = intValue;
            if (this.jBI != null) {
                this.jBI.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jBK) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.rh(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.bvt();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jBL.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.rj(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.bvt();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.rj(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.bvt();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn jBM;

        a(View view) {
            super(view);
            this.jBM = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
