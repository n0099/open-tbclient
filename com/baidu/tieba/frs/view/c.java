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
/* loaded from: classes16.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private FrsMoveAreaChooseView iyO;
    private int iyQ;
    private int iyR = -1;
    private List<FrsTabInfo> iyP = com.baidu.tieba.frs.a.ckM().ckP();
    private SparseArray<FrsTabInfo> iyS = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.iyQ = -1;
        this.iyO = frsMoveAreaChooseView;
        if (!y.isEmpty(this.iyP)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iyP.size()) {
                    FrsTabInfo frsTabInfo = this.iyP.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.ckM().ckO() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.ckM().ckO()) {
                            this.iyQ = i2;
                        }
                        this.iyS.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cuK() {
        return this.iyQ;
    }

    public int cuL() {
        return this.iyR;
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
        if (!y.isEmpty(this.iyP) && (frsTabInfo = (FrsTabInfo) y.getItem(this.iyP, i)) != null) {
            aVar.iyT.setTag(Integer.valueOf(i));
            aVar.iyT.setText(frsTabInfo.tab_name);
            aVar.iyT.setOnClickListener(this);
            g(aVar.iyT, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.iyP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.iyS.get(intValue) != null) {
                if (this.iyO != null && this.iyO.getContext() != null && this.iyO.getParent() != null) {
                    if (intValue == this.iyQ) {
                        new BdTopToast(this.iyO.getContext()).wU(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aE((ViewGroup) this.iyO.getParent());
                        return;
                    } else {
                        new BdTopToast(this.iyO.getContext()).wU(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aE((ViewGroup) this.iyO.getParent());
                        return;
                    }
                }
                return;
            }
            this.iyR = intValue;
            if (this.iyO != null) {
                this.iyO.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.iyR) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.iyS.get(i) != null) {
            ap.setViewTextColor(textView, R.color.cp_cont_g);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_disable_bg);
        } else {
            ap.setViewTextColor(textView, R.color.cp_cont_b);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView iyT;

        a(View view) {
            super(view);
            this.iyT = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
