package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int gcz;
    private FrsMoveAreaChooseView jJE;
    private int jJG = -1;
    private List<FrsTabInfo> jJF = com.baidu.tieba.frs.a.czZ().cAc();
    private SparseArray<FrsTabInfo> jJH = new SparseArray<>();

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.gcz = -1;
        this.jJE = frsMoveAreaChooseView;
        if (!x.isEmpty(this.jJF)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jJF.size()) {
                    FrsTabInfo frsTabInfo = this.jJF.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.czZ().cAb() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.czZ().cAb()) {
                            this.gcz = i2;
                        }
                        this.jJH.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cLp() {
        return this.gcz;
    }

    public int cLq() {
        return this.jJG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: E */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (!x.isEmpty(this.jJF) && (frsTabInfo = (FrsTabInfo) x.getItem(this.jJF, i)) != null) {
            aVar.jJI.setTag(Integer.valueOf(i));
            aVar.jJI.setText(frsTabInfo.tab_name);
            aVar.jJI.setOnClickListener(this);
            b(aVar.jJI, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.jJF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jJH.get(intValue) != null) {
                if (this.jJE != null && this.jJE.getContext() != null && this.jJE.getParent() != null) {
                    if (intValue == this.gcz) {
                        new BdTopToast(this.jJE.getContext()).yS(false).TQ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aR((ViewGroup) this.jJE.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jJE.getContext()).yS(false).TQ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aR((ViewGroup) this.jJE.getParent());
                        return;
                    }
                }
                return;
            }
            this.jJG = intValue;
            if (this.jJE != null) {
                this.jJE.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jJG) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.pM(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.btV();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jJH.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.pO(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.btV();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.pO(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.btV();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn jJI;

        a(View view) {
            super(view);
            this.jJI = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
