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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes2.dex */
public class f {
    private AlertDialog aRc;
    private TbImageView ceT;
    private View dYU;
    private ListView dYV;
    private a dYW;
    private TextView dYX;
    private StarRank dYY;
    private View dYZ;
    private View dZa;
    private TextView dZb;
    private TextView dZc;
    private TextView dZd;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dYY = starRank;
            if (starRank != null && !v.E(this.dYY.user_task_info)) {
                this.dYU = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dYZ = this.dYU.findViewById(d.g.outer_bg);
                this.dZa = this.dYU.findViewById(d.g.divider_line);
                this.dZb = (TextView) this.dYU.findViewById(d.g.jump_title);
                this.dZc = (TextView) this.dYU.findViewById(d.g.task_title);
                this.ceT = (TbImageView) this.dYU.findViewById(d.g.pic_show);
                this.dZd = (TextView) this.dYU.findViewById(d.g.know_view);
                this.dYV = (ListView) this.dYU.findViewById(d.g.rank_listview);
                this.dYX = (TextView) this.dYU.findViewById(d.g.know_view);
                this.dYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aAU();
                    }
                });
                this.dYW = new a(this.mContext);
                this.dYW.setData(this.dYY.user_task_info);
                this.dYV.setAdapter((ListAdapter) this.dYW);
                this.dZb.setText(this.dYY.user_current_score_notice);
                aAU();
                this.aRc = new AlertDialog.Builder(this.mContext).create();
                this.aRc.setCanceledOnTouchOutside(true);
                com.baidu.adp.lib.g.g.a(this.aRc, (Activity) this.mContext);
                Window window = this.aRc.getWindow();
                window.setWindowAnimations(d.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dYU);
                aAV();
            }
        }
    }

    public void aAU() {
        if (this.aRc != null && this.aRc.isShowing()) {
            this.aRc.dismiss();
        }
    }

    public void aAV() {
        aj.c(this.ceT, d.f.pic_frs_idol_mission);
        aj.s(this.dYZ, d.C0141d.cp_bg_line_d);
        aj.t(this.dZa, d.C0141d.cp_bg_line_e);
        aj.s(this.dZd, d.f.frs_star_btn_selector);
        aj.e(this.dZd, d.C0141d.cp_cont_i, 1);
        aj.e(this.dZb, d.C0141d.cp_cont_b, 1);
        aj.e(this.dZc, d.C0141d.cp_cont_d, 1);
        this.dYW.notifyDataSetChanged();
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
            if (!v.E(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.E(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: of */
        public StarTaskInfo getItem(int i) {
            return (StarTaskInfo) v.f(this.data, i);
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
                bVar2.dZf = (TextView) view.findViewById(d.g.task_name);
                bVar2.bMo = (TextView) view.findViewById(d.g.desc);
                bVar2.dZg = (TextView) view.findViewById(d.g.score_desc);
                bVar2.dZh = (TextView) view.findViewById(d.g.status_text);
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
            bVar.dZf.setText(item.task_title);
            bVar.bMo.setText(item.task_desc);
            bVar.dZg.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dZh.setText(d.j.task_done);
                aj.r(bVar.dZh, d.C0141d.cp_cont_d);
            } else {
                bVar.dZh.setText(d.j.task_not_done);
                aj.r(bVar.dZh, d.C0141d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            aj.r(bVar.dZf, d.C0141d.cp_cont_b);
            aj.r(bVar.bMo, d.C0141d.cp_cont_d);
            aj.r(bVar.dZg, d.C0141d.cp_cont_h);
            aj.t(bVar.divider, d.C0141d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView bMo;
        TextView dZf;
        TextView dZg;
        TextView dZh;
        View divider;

        private b() {
        }
    }
}
