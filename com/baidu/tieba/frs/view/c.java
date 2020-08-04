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
    private FrsMoveAreaChooseView ikF;
    private int ikH;
    private int ikI = -1;
    private List<FrsTabInfo> ikG = com.baidu.tieba.frs.a.cap().cas();
    private SparseArray<FrsTabInfo> ikJ = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.ikH = -1;
        this.ikF = frsMoveAreaChooseView;
        if (!x.isEmpty(this.ikG)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ikG.size()) {
                    FrsTabInfo frsTabInfo = this.ikG.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cap().car())) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cap().car()) {
                            this.ikH = i2;
                        }
                        this.ikJ.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int ckf() {
        return this.ikH;
    }

    public int ckg() {
        return this.ikI;
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
        if (!x.isEmpty(this.ikG) && (frsTabInfo = (FrsTabInfo) x.getItem(this.ikG, i)) != null) {
            aVar.ikK.setTag(Integer.valueOf(i));
            aVar.ikK.setText(frsTabInfo.tab_name);
            aVar.ikK.setOnClickListener(this);
            g(aVar.ikK, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.ikG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.ikJ.get(intValue) != null) {
                if (this.ikF != null && this.ikF.getContext() != null && this.ikF.getParent() != null) {
                    if (intValue == this.ikH) {
                        new BdTopToast(this.ikF.getContext()).wd(false).Pr(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aF((ViewGroup) this.ikF.getParent());
                        return;
                    } else {
                        new BdTopToast(this.ikF.getContext()).wd(false).Pr(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aF((ViewGroup) this.ikF.getParent());
                        return;
                    }
                }
                return;
            }
            this.ikI = intValue;
            if (this.ikF != null) {
                this.ikF.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.ikI) {
            ao.setViewTextColor(textView, R.color.cp_link_tip_a);
            ao.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.ikJ.get(i) != null) {
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
        TextView ikK;

        a(View view) {
            super(view);
            this.ikK = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
