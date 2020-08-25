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
    private FrsMoveAreaChooseView iyI;
    private int iyK;
    private int iyL = -1;
    private List<FrsTabInfo> iyJ = com.baidu.tieba.frs.a.ckL().ckO();
    private SparseArray<FrsTabInfo> iyM = new SparseArray<>();

    public c(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.iyK = -1;
        this.iyI = frsMoveAreaChooseView;
        if (!y.isEmpty(this.iyJ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iyJ.size()) {
                    FrsTabInfo frsTabInfo = this.iyJ.get(i2);
                    if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.ckL().ckN() || frsTabInfo.tab_type.intValue() == 3)) {
                        if (frsTabInfo.tab_id.intValue() == com.baidu.tieba.frs.a.ckL().ckN()) {
                            this.iyK = i2;
                        }
                        this.iyM.append(i2, frsTabInfo);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int cuJ() {
        return this.iyK;
    }

    public int cuK() {
        return this.iyL;
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
        if (!y.isEmpty(this.iyJ) && (frsTabInfo = (FrsTabInfo) y.getItem(this.iyJ, i)) != null) {
            aVar.iyN.setTag(Integer.valueOf(i));
            aVar.iyN.setText(frsTabInfo.tab_name);
            aVar.iyN.setOnClickListener(this);
            g(aVar.iyN, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.iyJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.iyM.get(intValue) != null) {
                if (this.iyI != null && this.iyI.getContext() != null && this.iyI.getParent() != null) {
                    if (intValue == this.iyK) {
                        new BdTopToast(this.iyI.getContext()).wS(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).aE((ViewGroup) this.iyI.getParent());
                        return;
                    } else {
                        new BdTopToast(this.iyI.getContext()).wS(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).aE((ViewGroup) this.iyI.getParent());
                        return;
                    }
                }
                return;
            }
            this.iyL = intValue;
            if (this.iyI != null) {
                this.iyI.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    private void g(TextView textView, int i) {
        if (i == this.iyL) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            ap.setBackgroundResource(textView, R.drawable.cell_frs_area_choose_select_bg);
        } else if (this.iyM.get(i) != null) {
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
        TextView iyN;

        a(View view) {
            super(view);
            this.iyN = (TextView) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }
}
