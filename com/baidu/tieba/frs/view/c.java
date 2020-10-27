package com.baidu.tieba.frs.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int fJQ;
    private FrsMoveAreaChooseView jhw;
    private int jhy = -1;
    private List<FrsTabInfo> jhx = com.baidu.tieba.frs.a.cuE().cuH();
    private SparseArray<FrsTabInfo> jhz = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.fJQ = -1;
        this.jhw = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jhx)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jhx.size()) {
                    FrsTabInfo frsTabInfo = this.jhx.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cuE().cuG() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cuE().cuG()) {
                            this.fJQ = i2;
                        }
                        this.jhz.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cEH() {
        return this.fJQ;
    }

    public int cEI() {
        return this.jhy;
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
        if (!y.isEmpty(this.jhx) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jhx, i)) != null) {
            aVar.jhA.setTag(Integer.valueOf(i));
            aVar.jhA.setText(frsTabInfo.tab_name);
            aVar.jhA.setOnClickListener(this);
            g(aVar.jhA, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jhx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jhz.get(intValue) != null) {
                if (this.jhw != null && this.jhw.getContext() != null && this.jhw.getParent() != null) {
                    if (intValue == this.fJQ) {
                        new BdTopToast(this.jhw.getContext()).yb(false).Uc(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aH((ViewGroup) this.jhw.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jhw.getContext()).yb(false).Uc(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aH((ViewGroup) this.jhw.getParent());
                        return;
                    }
                }
                return;
            }
            this.jhy = intValue;
            if (this.jhw != null) {
                this.jhw.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.jhy) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.jhz.get(i) != null) {
            ap.setViewTextColor(textView, R.color.cp_cont_g);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_disable_bg);
        } else {
            ap.setViewTextColor(textView, R.color.cp_cont_b);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView jhA;

        a(View view) {
            super(view);
            this.jhA = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
