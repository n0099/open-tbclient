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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes2.dex */
public class d {
    private AlertDialog alf;
    private TbImageView amb;
    private View dHH;
    private ListView dHI;
    private a dHJ;
    private TextView dHK;
    private StarRank dHL;
    private View dHM;
    private View dHN;
    private TextView dHO;
    private TextView dHP;
    private TextView dHQ;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dHL = starRank;
            if (starRank != null && !w.A(this.dHL.user_task_info)) {
                this.dHH = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dHM = this.dHH.findViewById(d.g.outer_bg);
                this.dHN = this.dHH.findViewById(d.g.divider_line);
                this.dHO = (TextView) this.dHH.findViewById(d.g.jump_title);
                this.dHP = (TextView) this.dHH.findViewById(d.g.task_title);
                this.amb = (TbImageView) this.dHH.findViewById(d.g.pic_show);
                this.dHQ = (TextView) this.dHH.findViewById(d.g.know_view);
                this.dHI = (ListView) this.dHH.findViewById(d.g.rank_listview);
                this.dHK = (TextView) this.dHH.findViewById(d.g.know_view);
                this.dHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aAG();
                    }
                });
                this.dHJ = new a(this.mContext);
                this.dHJ.setData(this.dHL.user_task_info);
                this.dHI.setAdapter((ListAdapter) this.dHJ);
                this.dHO.setText(this.dHL.user_current_score_notice);
                aAG();
                this.alf = new AlertDialog.Builder(this.mContext).create();
                this.alf.setCanceledOnTouchOutside(true);
                g.a(this.alf, (Activity) this.mContext);
                Window window = this.alf.getWindow();
                window.setWindowAnimations(d.l.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dHH);
                aAH();
            }
        }
    }

    public void aAG() {
        if (this.alf != null && this.alf.isShowing()) {
            this.alf.dismiss();
        }
    }

    public void aAH() {
        am.c(this.amb, d.f.pic_frs_idol_mission);
        am.i(this.dHM, d.C0142d.cp_bg_line_d);
        am.j(this.dHN, d.C0142d.cp_bg_line_e);
        am.i(this.dHQ, d.f.frs_star_btn_selector);
        am.c(this.dHQ, d.C0142d.cp_cont_i, 1);
        am.c(this.dHO, d.C0142d.cp_cont_b, 1);
        am.c(this.dHP, d.C0142d.cp_cont_d, 1);
        this.dHJ.notifyDataSetChanged();
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
            if (!w.A(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (w.A(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lS */
        public StarTaskInfo getItem(int i) {
            return (StarTaskInfo) w.d(this.data, i);
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
                bVar2.dHS = (TextView) view.findViewById(d.g.task_name);
                bVar2.dHU = (TextView) view.findViewById(d.g.desc);
                bVar2.dHT = (TextView) view.findViewById(d.g.score_desc);
                bVar2.dHV = (TextView) view.findViewById(d.g.status_text);
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
            bVar.dHS.setText(item.task_title);
            bVar.dHU.setText(item.task_desc);
            bVar.dHT.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dHV.setText(d.k.task_done);
                am.h(bVar.dHV, d.C0142d.cp_cont_d);
            } else {
                bVar.dHV.setText(d.k.task_not_done);
                am.h(bVar.dHV, d.C0142d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            am.h(bVar.dHS, d.C0142d.cp_cont_b);
            am.h(bVar.dHU, d.C0142d.cp_cont_d);
            am.h(bVar.dHT, d.C0142d.cp_cont_h);
            am.j(bVar.divider, d.C0142d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dHS;
        TextView dHT;
        TextView dHU;
        TextView dHV;
        View divider;

        private b() {
        }
    }
}
