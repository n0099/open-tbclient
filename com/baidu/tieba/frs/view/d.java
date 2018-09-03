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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes2.dex */
public class d {
    private AlertDialog akE;
    private TbImageView alA;
    private TextView dKA;
    private TextView dKB;
    private View dKs;
    private ListView dKt;
    private a dKu;
    private TextView dKv;
    private StarRank dKw;
    private View dKx;
    private View dKy;
    private TextView dKz;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dKw = starRank;
            if (starRank != null && !w.z(this.dKw.user_task_info)) {
                this.dKs = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(f.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dKx = this.dKs.findViewById(f.g.outer_bg);
                this.dKy = this.dKs.findViewById(f.g.divider_line);
                this.dKz = (TextView) this.dKs.findViewById(f.g.jump_title);
                this.dKA = (TextView) this.dKs.findViewById(f.g.task_title);
                this.alA = (TbImageView) this.dKs.findViewById(f.g.pic_show);
                this.dKB = (TextView) this.dKs.findViewById(f.g.know_view);
                this.dKt = (ListView) this.dKs.findViewById(f.g.rank_listview);
                this.dKv = (TextView) this.dKs.findViewById(f.g.know_view);
                this.dKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aBm();
                    }
                });
                this.dKu = new a(this.mContext);
                this.dKu.setData(this.dKw.user_task_info);
                this.dKt.setAdapter((ListAdapter) this.dKu);
                this.dKz.setText(this.dKw.user_current_score_notice);
                aBm();
                this.akE = new AlertDialog.Builder(this.mContext).create();
                this.akE.setCanceledOnTouchOutside(true);
                g.a(this.akE, (Activity) this.mContext);
                Window window = this.akE.getWindow();
                window.setWindowAnimations(f.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dKs);
                aBn();
            }
        }
    }

    public void aBm() {
        if (this.akE != null && this.akE.isShowing()) {
            this.akE.dismiss();
        }
    }

    public void aBn() {
        am.c(this.alA, f.C0146f.pic_frs_idol_mission);
        am.i(this.dKx, f.d.cp_bg_line_d);
        am.j(this.dKy, f.d.cp_bg_line_e);
        am.i(this.dKB, f.C0146f.frs_star_btn_selector);
        am.c(this.dKB, f.d.cp_cont_i, 1);
        am.c(this.dKz, f.d.cp_cont_b, 1);
        am.c(this.dKA, f.d.cp_cont_d, 1);
        this.dKu.notifyDataSetChanged();
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
                view = LayoutInflater.from(this.mContext).inflate(f.h.frs_item_bottom_view, viewGroup, false);
                b bVar2 = new b();
                bVar2.dKD = (TextView) view.findViewById(f.g.task_name);
                bVar2.dKF = (TextView) view.findViewById(f.g.desc);
                bVar2.dKE = (TextView) view.findViewById(f.g.score_desc);
                bVar2.dKG = (TextView) view.findViewById(f.g.status_text);
                bVar2.divider = view.findViewById(f.g.bottom_divider_line);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            StarTaskInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            bVar.dKD.setText(item.task_title);
            bVar.dKF.setText(item.task_desc);
            bVar.dKE.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dKG.setText(f.j.task_done);
                am.h(bVar.dKG, f.d.cp_cont_d);
            } else {
                bVar.dKG.setText(f.j.task_not_done);
                am.h(bVar.dKG, f.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            am.h(bVar.dKD, f.d.cp_cont_b);
            am.h(bVar.dKF, f.d.cp_cont_d);
            am.h(bVar.dKE, f.d.cp_cont_h);
            am.j(bVar.divider, f.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dKD;
        TextView dKE;
        TextView dKF;
        TextView dKG;
        View divider;

        private b() {
        }
    }
}
