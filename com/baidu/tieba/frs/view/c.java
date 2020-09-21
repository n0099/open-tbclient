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
/* loaded from: classes21.dex */
public class c extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private int fph;
    private FrsMoveAreaChooseView iGk;
    private int iGm = -1;
    private List<FrsTabInfo> iGl = com.baidu.tieba.frs.a.cnZ().coc();
    private SparseArray<FrsTabInfo> iGn = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.fph = -1;
        this.iGk = frsMoveAreaChooseView;
        if (!y.isEmpty(this.iGl)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iGl.size()) {
                    FrsTabInfo frsTabInfo = this.iGl.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cnZ().cob() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cnZ().cob()) {
                            this.fph = i2;
                        }
                        this.iGn.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cyd() {
        return this.fph;
    }

    public int cye() {
        return this.iGm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (!y.isEmpty(this.iGl) && (frsTabInfo = (FrsTabInfo) y.getItem(this.iGl, i)) != null) {
            aVar.iGo.setTag(Integer.valueOf(i));
            aVar.iGo.setText(frsTabInfo.tab_name);
            aVar.iGo.setOnClickListener(this);
            g(aVar.iGo, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.iGl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.iGn.get(intValue) != null) {
                if (this.iGk != null && this.iGk.getContext() != null && this.iGk.getParent() != null) {
                    if (intValue == this.fph) {
                        new BdTopToast(this.iGk.getContext()).xd(false).SP(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aF((ViewGroup) this.iGk.getParent());
                        return;
                    } else {
                        new BdTopToast(this.iGk.getContext()).xd(false).SP(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aF((ViewGroup) this.iGk.getParent());
                        return;
                    }
                }
                return;
            }
            this.iGm = intValue;
            if (this.iGk != null) {
                this.iGk.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.iGm) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.iGn.get(i) != null) {
            ap.setViewTextColor(textView, R.color.cp_cont_g);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_disable_bg);
        } else {
            ap.setViewTextColor(textView, R.color.cp_cont_b);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView iGo;

        a(View view) {
            super(view);
            this.iGo = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
