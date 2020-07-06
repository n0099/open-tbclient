package com.baidu.tieba.frs.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private FrsMoveAreaChooseView ieD;
    private int ieF;
    private int ieG = -1;
    private List<FrsTabInfo> ieE = com.baidu.tieba.frs.a.bWW().bWZ();
    private SparseArray<FrsTabInfo> ieH = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.ieF = -1;
        this.ieD = frsMoveAreaChooseView;
        if (!w.isEmpty(this.ieE)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ieE.size()) {
                    FrsTabInfo frsTabInfo = this.ieE.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.bWW().bWY())) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.bWW().bWY()) {
                            this.ieF = i2;
                        }
                        this.ieH.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cgG() {
        return this.ieF;
    }

    public int cgH() {
        return this.ieG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: w */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (!w.isEmpty(this.ieE) && (frsTabInfo = (FrsTabInfo) w.getItem(this.ieE, i)) != null) {
            aVar.ieI.setTag(Integer.valueOf(i));
            aVar.ieI.setText(frsTabInfo.tab_name);
            aVar.ieI.setOnClickListener(this);
            g(aVar.ieI, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.getCount(this.ieE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.ieH.get(intValue) != null) {
                if (this.ieD != null && this.ieD.getContext() != null && this.ieD.getParent() != null) {
                    if (intValue == this.ieF) {
                        new BdTopToast(this.ieD.getContext()).vz(false).OJ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aE((ViewGroup) this.ieD.getParent());
                        return;
                    } else {
                        new BdTopToast(this.ieD.getContext()).vz(false).OJ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aE((ViewGroup) this.ieD.getParent());
                        return;
                    }
                }
                return;
            }
            this.ieG = intValue;
            if (this.ieD != null) {
                this.ieD.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.ieG) {
            an.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            an.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.ieH.get(i) != null) {
            an.setViewTextColor(textView, (int) R.color.cp_cont_g);
            an.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_disable_bg);
        } else {
            an.setViewTextColor(textView, (int) R.color.cp_cont_b);
            an.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView ieI;

        a(View view) {
            super(view);
            this.ieI = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
