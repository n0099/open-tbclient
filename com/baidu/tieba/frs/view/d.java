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
    private AlertDialog akE;
    private TbImageView alB;
    private StarRank dKA;
    private View dKB;
    private View dKC;
    private TextView dKD;
    private TextView dKE;
    private TextView dKF;
    private View dKw;
    private ListView dKx;
    private a dKy;
    private TextView dKz;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dKA = starRank;
            if (starRank != null && !w.z(this.dKA.user_task_info)) {
                this.dKw = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dKB = this.dKw.findViewById(d.g.outer_bg);
                this.dKC = this.dKw.findViewById(d.g.divider_line);
                this.dKD = (TextView) this.dKw.findViewById(d.g.jump_title);
                this.dKE = (TextView) this.dKw.findViewById(d.g.task_title);
                this.alB = (TbImageView) this.dKw.findViewById(d.g.pic_show);
                this.dKF = (TextView) this.dKw.findViewById(d.g.know_view);
                this.dKx = (ListView) this.dKw.findViewById(d.g.rank_listview);
                this.dKz = (TextView) this.dKw.findViewById(d.g.know_view);
                this.dKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aBp();
                    }
                });
                this.dKy = new a(this.mContext);
                this.dKy.setData(this.dKA.user_task_info);
                this.dKx.setAdapter((ListAdapter) this.dKy);
                this.dKD.setText(this.dKA.user_current_score_notice);
                aBp();
                this.akE = new AlertDialog.Builder(this.mContext).create();
                this.akE.setCanceledOnTouchOutside(true);
                g.a(this.akE, (Activity) this.mContext);
                Window window = this.akE.getWindow();
                window.setWindowAnimations(d.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dKw);
                aBq();
            }
        }
    }

    public void aBp() {
        if (this.akE != null && this.akE.isShowing()) {
            this.akE.dismiss();
        }
    }

    public void aBq() {
        am.c(this.alB, d.f.pic_frs_idol_mission);
        am.i(this.dKB, d.C0140d.cp_bg_line_d);
        am.j(this.dKC, d.C0140d.cp_bg_line_e);
        am.i(this.dKF, d.f.frs_star_btn_selector);
        am.c(this.dKF, d.C0140d.cp_cont_i, 1);
        am.c(this.dKD, d.C0140d.cp_cont_b, 1);
        am.c(this.dKE, d.C0140d.cp_cont_d, 1);
        this.dKy.notifyDataSetChanged();
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
        /* renamed from: me */
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
                view = LayoutInflater.from(this.mContext).inflate(d.h.frs_item_bottom_view, viewGroup, false);
                b bVar2 = new b();
                bVar2.dKH = (TextView) view.findViewById(d.g.task_name);
                bVar2.dKJ = (TextView) view.findViewById(d.g.desc);
                bVar2.dKI = (TextView) view.findViewById(d.g.score_desc);
                bVar2.dKK = (TextView) view.findViewById(d.g.status_text);
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
            bVar.dKH.setText(item.task_title);
            bVar.dKJ.setText(item.task_desc);
            bVar.dKI.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dKK.setText(d.j.task_done);
                am.h(bVar.dKK, d.C0140d.cp_cont_d);
            } else {
                bVar.dKK.setText(d.j.task_not_done);
                am.h(bVar.dKK, d.C0140d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            am.h(bVar.dKH, d.C0140d.cp_cont_b);
            am.h(bVar.dKJ, d.C0140d.cp_cont_d);
            am.h(bVar.dKI, d.C0140d.cp_cont_h);
            am.j(bVar.divider, d.C0140d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dKH;
        TextView dKI;
        TextView dKJ;
        TextView dKK;
        View divider;

        private b() {
        }
    }
}
