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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes2.dex */
public class d {
    private AlertDialog akG;
    private TbImageView alB;
    private View dEm;
    private ListView dEn;
    private a dEo;
    private TextView dEp;
    private StarRank dEq;
    private View dEr;
    private View dEs;
    private TextView dEt;
    private TextView dEu;
    private TextView dEv;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dEq = starRank;
            if (starRank != null && !w.z(this.dEq.user_task_info)) {
                this.dEm = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dEr = this.dEm.findViewById(d.g.outer_bg);
                this.dEs = this.dEm.findViewById(d.g.divider_line);
                this.dEt = (TextView) this.dEm.findViewById(d.g.jump_title);
                this.dEu = (TextView) this.dEm.findViewById(d.g.task_title);
                this.alB = (TbImageView) this.dEm.findViewById(d.g.pic_show);
                this.dEv = (TextView) this.dEm.findViewById(d.g.know_view);
                this.dEn = (ListView) this.dEm.findViewById(d.g.rank_listview);
                this.dEp = (TextView) this.dEm.findViewById(d.g.know_view);
                this.dEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.azZ();
                    }
                });
                this.dEo = new a(this.mContext);
                this.dEo.setData(this.dEq.user_task_info);
                this.dEn.setAdapter((ListAdapter) this.dEo);
                this.dEt.setText(this.dEq.user_current_score_notice);
                azZ();
                this.akG = new AlertDialog.Builder(this.mContext).create();
                this.akG.setCanceledOnTouchOutside(true);
                g.a(this.akG, (Activity) this.mContext);
                Window window = this.akG.getWindow();
                window.setWindowAnimations(d.l.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dEm);
                aAa();
            }
        }
    }

    public void azZ() {
        if (this.akG != null && this.akG.isShowing()) {
            this.akG.dismiss();
        }
    }

    public void aAa() {
        al.c(this.alB, d.f.pic_frs_idol_mission);
        al.i(this.dEr, d.C0141d.cp_bg_line_d);
        al.j(this.dEs, d.C0141d.cp_bg_line_e);
        al.i(this.dEv, d.f.frs_star_btn_selector);
        al.c(this.dEv, d.C0141d.cp_cont_i, 1);
        al.c(this.dEt, d.C0141d.cp_cont_b, 1);
        al.c(this.dEu, d.C0141d.cp_cont_d, 1);
        this.dEo.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private final List<StarTaskInfo> data = new ArrayList();
        private Context mContext;

        a(Context context) {
            this.mContext = context;
        }

        void setData(List<StarTaskInfo> list) {
            if (!w.z(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (w.z(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lL */
        public StarTaskInfo getItem(int i) {
            return (StarTaskInfo) w.c(this.data, i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.frs_item_bottom_view, viewGroup, false);
                b bVar2 = new b();
                bVar2.dEx = (TextView) view.findViewById(d.g.task_name);
                bVar2.dEz = (TextView) view.findViewById(d.g.desc);
                bVar2.dEy = (TextView) view.findViewById(d.g.score_desc);
                bVar2.dEA = (TextView) view.findViewById(d.g.status_text);
                bVar2.divider = view.findViewById(d.g.bottom_divider_line);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            StarTaskInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            bVar.dEx.setText(item.task_title);
            bVar.dEz.setText(item.task_desc);
            bVar.dEy.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dEA.setText(d.k.task_done);
                al.h(bVar.dEA, d.C0141d.cp_cont_d);
            } else {
                bVar.dEA.setText(d.k.task_not_done);
                al.h(bVar.dEA, d.C0141d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.dEx, d.C0141d.cp_cont_b);
            al.h(bVar.dEz, d.C0141d.cp_cont_d);
            al.h(bVar.dEy, d.C0141d.cp_cont_h);
            al.j(bVar.divider, d.C0141d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dEA;
        TextView dEx;
        TextView dEy;
        TextView dEz;
        View divider;

        private b() {
        }
    }
}
