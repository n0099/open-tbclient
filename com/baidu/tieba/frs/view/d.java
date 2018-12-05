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
    private AlertDialog aws;
    private TbImageView axk;
    private View bGr;
    private TextView ehA;
    private TextView ehB;
    private TextView ehC;
    private View ehu;
    private ListView ehv;
    private a ehw;
    private TextView ehx;
    private StarRank ehy;
    private View ehz;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.ehy = starRank;
            if (starRank != null && !v.I(this.ehy.user_task_info)) {
                this.ehu = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.ehz = this.ehu.findViewById(e.g.outer_bg);
                this.bGr = this.ehu.findViewById(e.g.divider_line);
                this.ehA = (TextView) this.ehu.findViewById(e.g.jump_title);
                this.ehB = (TextView) this.ehu.findViewById(e.g.task_title);
                this.axk = (TbImageView) this.ehu.findViewById(e.g.pic_show);
                this.ehC = (TextView) this.ehu.findViewById(e.g.know_view);
                this.ehv = (ListView) this.ehu.findViewById(e.g.rank_listview);
                this.ehx = (TextView) this.ehu.findViewById(e.g.know_view);
                this.ehx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aHZ();
                    }
                });
                this.ehw = new a(this.mContext);
                this.ehw.setData(this.ehy.user_task_info);
                this.ehv.setAdapter((ListAdapter) this.ehw);
                this.ehA.setText(this.ehy.user_current_score_notice);
                aHZ();
                this.aws = new AlertDialog.Builder(this.mContext).create();
                this.aws.setCanceledOnTouchOutside(true);
                g.a(this.aws, (Activity) this.mContext);
                Window window = this.aws.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.ehu);
                aIa();
            }
        }
    }

    public void aHZ() {
        if (this.aws != null && this.aws.isShowing()) {
            this.aws.dismiss();
        }
    }

    public void aIa() {
        al.c(this.axk, e.f.pic_frs_idol_mission);
        al.i(this.ehz, e.d.cp_bg_line_d);
        al.j(this.bGr, e.d.cp_bg_line_e);
        al.i(this.ehC, e.f.frs_star_btn_selector);
        al.c(this.ehC, e.d.cp_cont_i, 1);
        al.c(this.ehA, e.d.cp_cont_b, 1);
        al.c(this.ehB, e.d.cp_cont_d, 1);
        this.ehw.notifyDataSetChanged();
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
            if (!v.I(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.I(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nO */
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
                bVar2.ehE = (TextView) view.findViewById(e.g.task_name);
                bVar2.ehG = (TextView) view.findViewById(e.g.desc);
                bVar2.ehF = (TextView) view.findViewById(e.g.score_desc);
                bVar2.ehH = (TextView) view.findViewById(e.g.status_text);
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
            bVar.ehE.setText(item.task_title);
            bVar.ehG.setText(item.task_desc);
            bVar.ehF.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.ehH.setText(e.j.task_done);
                al.h(bVar.ehH, e.d.cp_cont_d);
            } else {
                bVar.ehH.setText(e.j.task_not_done);
                al.h(bVar.ehH, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.ehE, e.d.cp_cont_b);
            al.h(bVar.ehG, e.d.cp_cont_d);
            al.h(bVar.ehF, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        View divider;
        TextView ehE;
        TextView ehF;
        TextView ehG;
        TextView ehH;

        private b() {
        }
    }
}
