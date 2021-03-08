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
    private int ggw;
    private FrsMoveAreaChooseView jSy;
    private int jSA = -1;
    private List<FrsTabInfo> jSz = com.baidu.tieba.frs.a.cBx().cBA();
    private SparseArray<FrsTabInfo> jSB = new SparseArray<>();

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.ggw = -1;
        this.jSy = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jSz)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jSz.size()) {
                    FrsTabInfo frsTabInfo = this.jSz.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBx().cBz() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBx().cBz()) {
                            this.ggw = i2;
                        }
                        this.jSB.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cML() {
        return this.ggw;
    }

    public int cNr() {
        return this.jSA;
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
        if (!y.isEmpty(this.jSz) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jSz, i)) != null) {
            aVar.jSC.setTag(Integer.valueOf(i));
            aVar.jSC.setText(frsTabInfo.tab_name);
            aVar.jSC.setOnClickListener(this);
            b(aVar.jSC, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jSz);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jSB.get(intValue) != null) {
                if (this.jSy != null && this.jSy.getContext() != null && this.jSy.getParent() != null) {
                    if (intValue == this.ggw) {
                        new BdTopToast(this.jSy.getContext()).zm(false).Vg(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aR((ViewGroup) this.jSy.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jSy.getContext()).zm(false).Vg(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aR((ViewGroup) this.jSy.getParent());
                        return;
                    }
                }
                return;
            }
            this.jSA = intValue;
            if (this.jSy != null) {
                this.jSy.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jSA) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.pS(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.bus();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jSB.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.pU(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.bus();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.pU(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.bus();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn jSC;

        a(View view) {
            super(view);
            this.jSC = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
