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
    private int geT;
    private FrsMoveAreaChooseView jQP;
    private int jQR = -1;
    private List<FrsTabInfo> jQQ = com.baidu.tieba.frs.a.cBr().cBu();
    private SparseArray<FrsTabInfo> jQS = new SparseArray<>();

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.geT = -1;
        this.jQP = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jQQ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jQQ.size()) {
                    FrsTabInfo frsTabInfo = this.jQQ.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBr().cBt() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cBr().cBt()) {
                            this.geT = i2;
                        }
                        this.jQS.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cMF() {
        return this.geT;
    }

    public int cNl() {
        return this.jQR;
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
        if (!y.isEmpty(this.jQQ) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jQQ, i)) != null) {
            aVar.jQT.setTag(Integer.valueOf(i));
            aVar.jQT.setText(frsTabInfo.tab_name);
            aVar.jQT.setOnClickListener(this);
            b(aVar.jQT, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jQQ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jQS.get(intValue) != null) {
                if (this.jQP != null && this.jQP.getContext() != null && this.jQP.getParent() != null) {
                    if (intValue == this.geT) {
                        new BdTopToast(this.jQP.getContext()).zn(false).UZ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aR((ViewGroup) this.jQP.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jQP.getContext()).zn(false).UZ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aR((ViewGroup) this.jQP.getParent());
                        return;
                    }
                }
                return;
            }
            this.jQR = intValue;
            if (this.jQP != null) {
                this.jQP.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void b(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.jQR) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.pR(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.bup();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.jQS.get(i) != null) {
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
        TBSpecificationBtn jQT;

        a(View view) {
            super(view);
            this.jQT = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
