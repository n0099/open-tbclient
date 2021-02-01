package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int geO;
    private FrsMoveAreaChooseView jQB;
    private int jQD = -1;
    private List<FrsTabInfo> jQC = com.baidu.tieba.frs.a.cBk().cBn();
    private SparseArray<FrsTabInfo> jQE = new SparseArray<>();

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.geO = -1;
        this.jQB = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jQC)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jQC.size()) {
                    FrsTabInfo frsTabInfo = this.jQC.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBk().cBm() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBk().cBm()) {
                            this.geO = i2;
                        }
                        this.jQE.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cMy() {
        return this.geO;
    }

    public int cNe() {
        return this.jQD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: F */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (!y.isEmpty(this.jQC) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jQC, i)) != null) {
            aVar.jQF.setTag(Integer.valueOf(i));
            aVar.jQF.setText(frsTabInfo.tab_name);
            aVar.jQF.setOnClickListener(this);
            b(aVar.jQF, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jQC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jQE.get(intValue) != null) {
                if (this.jQB != null && this.jQB.getContext() != null && this.jQB.getParent() != null) {
                    if (intValue == this.geO) {
                        new BdTopToast(this.jQB.getContext()).zn(false).UN(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aR((ViewGroup) this.jQB.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jQB.getContext()).zn(false).UN(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aR((ViewGroup) this.jQB.getParent());
                        return;
                    }
                }
                return;
            }
            this.jQD = intValue;
            if (this.jQB != null) {
                this.jQB.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jQD) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.pR(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.bup();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jQE.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.pT(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.bup();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.pT(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.bup();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn jQF;

        a(View view) {
            super(view);
            this.jQF = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
