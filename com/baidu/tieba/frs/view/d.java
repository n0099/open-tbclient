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
/* loaded from: classes2.dex */
public class d {
    private AlertDialog ank;
    private TbImageView aof;
    private View dRC;
    private ListView dRD;
    private a dRE;
    private TextView dRF;
    private StarRank dRG;
    private View dRH;
    private View dRI;
    private TextView dRJ;
    private TextView dRK;
    private TextView dRL;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dRG = starRank;
            if (starRank != null && !v.z(this.dRG.user_task_info)) {
                this.dRC = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dRH = this.dRC.findViewById(e.g.outer_bg);
                this.dRI = this.dRC.findViewById(e.g.divider_line);
                this.dRJ = (TextView) this.dRC.findViewById(e.g.jump_title);
                this.dRK = (TextView) this.dRC.findViewById(e.g.task_title);
                this.aof = (TbImageView) this.dRC.findViewById(e.g.pic_show);
                this.dRL = (TextView) this.dRC.findViewById(e.g.know_view);
                this.dRD = (ListView) this.dRC.findViewById(e.g.rank_listview);
                this.dRF = (TextView) this.dRC.findViewById(e.g.know_view);
                this.dRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aDx();
                    }
                });
                this.dRE = new a(this.mContext);
                this.dRE.setData(this.dRG.user_task_info);
                this.dRD.setAdapter((ListAdapter) this.dRE);
                this.dRJ.setText(this.dRG.user_current_score_notice);
                aDx();
                this.ank = new AlertDialog.Builder(this.mContext).create();
                this.ank.setCanceledOnTouchOutside(true);
                g.a(this.ank, (Activity) this.mContext);
                Window window = this.ank.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dRC);
                aDy();
            }
        }
    }

    public void aDx() {
        if (this.ank != null && this.ank.isShowing()) {
            this.ank.dismiss();
        }
    }

    public void aDy() {
        al.c(this.aof, e.f.pic_frs_idol_mission);
        al.i(this.dRH, e.d.cp_bg_line_d);
        al.j(this.dRI, e.d.cp_bg_line_e);
        al.i(this.dRL, e.f.frs_star_btn_selector);
        al.c(this.dRL, e.d.cp_cont_i, 1);
        al.c(this.dRJ, e.d.cp_cont_b, 1);
        al.c(this.dRK, e.d.cp_cont_d, 1);
        this.dRE.notifyDataSetChanged();
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
            if (!v.z(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.z(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: mI */
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
                bVar2.dRN = (TextView) view.findViewById(e.g.task_name);
                bVar2.dRP = (TextView) view.findViewById(e.g.desc);
                bVar2.dRO = (TextView) view.findViewById(e.g.score_desc);
                bVar2.dRQ = (TextView) view.findViewById(e.g.status_text);
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
            bVar.dRN.setText(item.task_title);
            bVar.dRP.setText(item.task_desc);
            bVar.dRO.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dRQ.setText(e.j.task_done);
                al.h(bVar.dRQ, e.d.cp_cont_d);
            } else {
                bVar.dRQ.setText(e.j.task_not_done);
                al.h(bVar.dRQ, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.dRN, e.d.cp_cont_b);
            al.h(bVar.dRP, e.d.cp_cont_d);
            al.h(bVar.dRO, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dRN;
        TextView dRO;
        TextView dRP;
        TextView dRQ;
        View divider;

        private b() {
        }
    }
}
