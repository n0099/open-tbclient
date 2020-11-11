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
    private int fPG;
    private FrsMoveAreaChooseView jnv;
    private int jnx = -1;
    private List<FrsTabInfo> jnw = com.baidu.tieba.frs.a.cxf().cxi();
    private SparseArray<FrsTabInfo> jny = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.fPG = -1;
        this.jnv = frsMoveAreaChooseView;
        if (!y.isEmpty(this.jnw)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jnw.size()) {
                    FrsTabInfo frsTabInfo = this.jnw.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cxf().cxh() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.cxf().cxh()) {
                            this.fPG = i2;
                        }
                        this.jny.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cHi() {
        return this.fPG;
    }

    public int cHj() {
        return this.jnx;
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
        if (!y.isEmpty(this.jnw) && (frsTabInfo = (FrsTabInfo) y.getItem(this.jnw, i)) != null) {
            aVar.jnz.setTag(Integer.valueOf(i));
            aVar.jnz.setText(frsTabInfo.tab_name);
            aVar.jnz.setOnClickListener(this);
            g(aVar.jnz, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jnw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.jny.get(intValue) != null) {
                if (this.jnv != null && this.jnv.getContext() != null && this.jnv.getParent() != null) {
                    if (intValue == this.fPG) {
                        new BdTopToast(this.jnv.getContext()).yk(false).Ut(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aJ((ViewGroup) this.jnv.getParent());
                        return;
                    } else {
                        new BdTopToast(this.jnv.getContext()).yk(false).Ut(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aJ((ViewGroup) this.jnv.getParent());
                        return;
                    }
                }
                return;
            }
            this.jnx = intValue;
            if (this.jnv != null) {
                this.jnv.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.jnx) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.jny.get(i) != null) {
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
        TextView jnz;

        a(View view) {
            super(view);
            this.jnz = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
