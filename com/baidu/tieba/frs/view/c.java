package com.baidu.tieba.frs.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private FrsMoveAreaChooseView ikD;
    private int ikF;
    private int ikG = -1;
    private List<FrsTabInfo> ikE = com.baidu.tieba.frs.a.cap().cas();
    private SparseArray<FrsTabInfo> ikH = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.ikF = -1;
        this.ikD = frsMoveAreaChooseView;
        if (!x.isEmpty(this.ikE)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ikE.size()) {
                    FrsTabInfo frsTabInfo = this.ikE.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cap().car())) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cap().car()) {
                            this.ikF = i2;
                        }
                        this.ikH.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int ckf() {
        return this.ikF;
    }

    public int ckg() {
        return this.ikG;
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
        if (!x.isEmpty(this.ikE) && (frsTabInfo = (FrsTabInfo) x.getItem(this.ikE, i)) != null) {
            aVar.ikI.setTag(Integer.valueOf(i));
            aVar.ikI.setText(frsTabInfo.tab_name);
            aVar.ikI.setOnClickListener(this);
            g(aVar.ikI, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.ikE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.ikH.get(intValue) != null) {
                if (this.ikD != null && this.ikD.getContext() != null && this.ikD.getParent() != null) {
                    if (intValue == this.ikF) {
                        new BdTopToast(this.ikD.getContext()).wd(false).Pr(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aF((ViewGroup) this.ikD.getParent());
                        return;
                    } else {
                        new BdTopToast(this.ikD.getContext()).wd(false).Pr(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aF((ViewGroup) this.ikD.getParent());
                        return;
                    }
                }
                return;
            }
            this.ikG = intValue;
            if (this.ikD != null) {
                this.ikD.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.ikG) {
            ao.setViewTextColor(textView, R.color.cp_link_tip_a);
            ao.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.ikH.get(i) != null) {
            ao.setViewTextColor(textView, R.color.cp_cont_g);
            ao.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_disable_bg);
        } else {
            ao.setViewTextColor(textView, R.color.cp_cont_b);
            ao.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView ikI;

        a(View view) {
            super(view);
            this.ikI = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
