package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes6.dex */
public class d {
    private TbImageView asX;
    private AlertDialog asf;
    private View bCm;
    private a dZA;
    private TextView dZB;
    private StarRank dZC;
    private View dZD;
    private TextView dZE;
    private TextView dZF;
    private TextView dZG;
    private View dZy;
    private ListView dZz;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dZC = starRank;
            if (starRank != null && !v.J(this.dZC.user_task_info)) {
                this.dZy = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dZD = this.dZy.findViewById(e.g.outer_bg);
                this.bCm = this.dZy.findViewById(e.g.divider_line);
                this.dZE = (TextView) this.dZy.findViewById(e.g.jump_title);
                this.dZF = (TextView) this.dZy.findViewById(e.g.task_title);
                this.asX = (TbImageView) this.dZy.findViewById(e.g.pic_show);
                this.dZG = (TextView) this.dZy.findViewById(e.g.know_view);
                this.dZz = (ListView) this.dZy.findViewById(e.g.rank_listview);
                this.dZB = (TextView) this.dZy.findViewById(e.g.know_view);
                this.dZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aGP();
                    }
                });
                this.dZA = new a(this.mContext);
                this.dZA.setData(this.dZC.user_task_info);
                this.dZz.setAdapter((ListAdapter) this.dZA);
                this.dZE.setText(this.dZC.user_current_score_notice);
                aGP();
                this.asf = new AlertDialog.Builder(this.mContext).create();
                this.asf.setCanceledOnTouchOutside(true);
                g.a(this.asf, (Activity) this.mContext);
                Window window = this.asf.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dZy);
                aGQ();
            }
        }
    }

    public void aGP() {
        if (this.asf != null && this.asf.isShowing()) {
            this.asf.dismiss();
        }
    }

    public void aGQ() {
        al.c(this.asX, e.f.pic_frs_idol_mission);
        al.i(this.dZD, e.d.cp_bg_line_d);
        al.j(this.bCm, e.d.cp_bg_line_e);
        al.i(this.dZG, e.f.frs_star_btn_selector);
        al.c(this.dZG, e.d.cp_cont_i, 1);
        al.c(this.dZE, e.d.cp_cont_b, 1);
        al.c(this.dZF, e.d.cp_cont_d, 1);
        this.dZA.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BaseAdapter {
        private final List<StarTaskInfo> data = new ArrayList();
        private Context mContext;

        a(Context context) {
            this.mContext = context;
        }

        void setData(List<StarTaskInfo> list) {
            if (!v.J(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.J(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: ng */
        public StarTaskInfo getItem(int i) {
            return (StarTaskInfo) v.d(this.data, i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.frs_item_bottom_view, viewGroup, false);
                b bVar2 = new b();
                bVar2.dZI = (TextView) view.findViewById(e.g.task_name);
                bVar2.dZK = (TextView) view.findViewById(e.g.desc);
                bVar2.dZJ = (TextView) view.findViewById(e.g.score_desc);
                bVar2.dZL = (TextView) view.findViewById(e.g.status_text);
                bVar2.divider = view.findViewById(e.g.bottom_divider_line);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            StarTaskInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            bVar.dZI.setText(item.task_title);
            bVar.dZK.setText(item.task_desc);
            bVar.dZJ.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dZL.setText(e.j.task_done);
                al.h(bVar.dZL, e.d.cp_cont_d);
            } else {
                bVar.dZL.setText(e.j.task_not_done);
                al.h(bVar.dZL, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.dZI, e.d.cp_cont_b);
            al.h(bVar.dZK, e.d.cp_cont_d);
            al.h(bVar.dZJ, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView dZI;
        TextView dZJ;
        TextView dZK;
        TextView dZL;
        View divider;

        private b() {
        }
    }
}
