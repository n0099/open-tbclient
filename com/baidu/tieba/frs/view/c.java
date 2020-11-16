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
/* loaded from: classes21.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int fPp;
    private FrsMoveAreaChooseView joe;
    private int jog = -1;
    private List<FrsTabInfo> jof = com.baidu.tieba.frs.a.cwH().cwK();
    private SparseArray<FrsTabInfo> joh = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.fPp = -1;
        this.joe = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jof)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jof.size()) {
                    FrsTabInfo frsTabInfo = this.jof.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cwH().cwJ() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cwH().cwJ()) {
                            this.fPp = i2;
                        }
                        this.joh.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cGN() {
        return this.fPp;
    }

    public int cGO() {
        return this.jog;
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
        if (!y.isEmpty(this.jof) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jof, i)) != null) {
            aVar.joi.setTag(Integer.valueOf(i));
            aVar.joi.setText(frsTabInfo.tab_name);
            aVar.joi.setOnClickListener(this);
            b(aVar.joi, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jof);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.joh.get(intValue) != null) {
                if (this.joe != null && this.joe.getContext() != null && this.joe.getParent() != null) {
                    if (intValue == this.fPp) {
                        new BdTopToast(this.joe.getContext()).yr(false).Ue(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aF((ViewGroup) this.joe.getParent());
                        return;
                    } else {
                        new BdTopToast(this.joe.getContext()).yr(false).Ue(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aF((ViewGroup) this.joe.getParent());
                        return;
                    }
                }
                return;
            }
            this.jog = intValue;
            if (this.joe != null) {
                this.joe.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jog) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.qG(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.brT();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.joh.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.qI(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.brT();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.qI(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.brT();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn joi;

        a(View view) {
            super(view);
            this.joi = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
