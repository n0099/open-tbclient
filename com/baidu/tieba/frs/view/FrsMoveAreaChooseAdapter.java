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
    private int ghh;
    private FrsMoveAreaChooseView jOk;
    private int jOm = -1;
    private List<FrsTabInfo> jOl = com.baidu.tieba.frs.a.cDR().cDU();
    private SparseArray<FrsTabInfo> jOn = new SparseArray<>();

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.ghh = -1;
        this.jOk = frsMoveAreaChooseView;
        if (!x.isEmpty(this.jOl)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jOl.size()) {
                    FrsTabInfo frsTabInfo = this.jOl.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cDR().cDT() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cDR().cDT()) {
                            this.ghh = i2;
                        }
                        this.jOn.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cPh() {
        return this.ghh;
    }

    public int cPi() {
        return this.jOm;
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
        if (!x.isEmpty(this.jOl) && (frsTabInfo = (FrsTabInfo) x.getItem(this.jOl, i)) != null) {
            aVar.jOo.setTag(Integer.valueOf(i));
            aVar.jOo.setText(frsTabInfo.tab_name);
            aVar.jOo.setOnClickListener(this);
            b(aVar.jOo, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.jOl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jOn.get(intValue) != null) {
                if (this.jOk != null && this.jOk.getContext() != null && this.jOk.getParent() != null) {
                    if (intValue == this.ghh) {
                        new BdTopToast(this.jOk.getContext()).yW(false).UX(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aR((ViewGroup) this.jOk.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jOk.getContext()).yW(false).UX(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aR((ViewGroup) this.jOk.getParent());
                        return;
                    }
                }
                return;
            }
            this.jOm = intValue;
            if (this.jOk != null) {
                this.jOk.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jOm) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.rs(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.bxP();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jOn.get(i) != null) {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.ru(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.bxP();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar3.ru(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.bxP();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        TBSpecificationBtn jOo;

        a(View view) {
            super(view);
            this.jOo = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
