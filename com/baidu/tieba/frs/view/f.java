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
    private AlertDialog aRe;
    private TbImageView ceW;
    private TextView dYN;
    private View dZl;
    private ListView dZm;
    private a dZn;
    private TextView dZo;
    private StarRank dZp;
    private View dZq;
    private View dZr;
    private TextView dZs;
    private TextView dZt;
    private Context mContext;

    public void a(Context context, StarRank starRank, boolean z) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dZp = starRank;
            if (starRank != null && !v.E(this.dZp.user_task_info)) {
                this.dZl = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dZq = this.dZl.findViewById(d.g.outer_bg);
                this.dZr = this.dZl.findViewById(d.g.divider_line);
                this.dZs = (TextView) this.dZl.findViewById(d.g.jump_title);
                this.dZt = (TextView) this.dZl.findViewById(d.g.task_title);
                this.ceW = (TbImageView) this.dZl.findViewById(d.g.pic_show);
                this.ceW.changeGrayScaleMode(z);
                this.dYN = (TextView) this.dZl.findViewById(d.g.know_view);
                this.dZm = (ListView) this.dZl.findViewById(d.g.rank_listview);
                this.dZo = (TextView) this.dZl.findViewById(d.g.know_view);
                this.dZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aAW();
                    }
                });
                this.dZn = new a(this.mContext);
                this.dZn.setData(this.dZp.user_task_info, z);
                this.dZm.setAdapter((ListAdapter) this.dZn);
                this.dZs.setText(this.dZp.user_current_score_notice);
                aAW();
                this.aRe = new AlertDialog.Builder(this.mContext).create();
                this.aRe.setCanceledOnTouchOutside(true);
                com.baidu.adp.lib.g.g.a(this.aRe, (Activity) this.mContext);
                Window window = this.aRe.getWindow();
                window.setWindowAnimations(d.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dZl);
                gE(z);
            }
        }
    }

    public void aAW() {
        if (this.aRe != null && this.aRe.isShowing()) {
            this.aRe.dismiss();
        }
    }

    public void gE(boolean z) {
        aj.c(this.ceW, d.f.pic_frs_idol_mission);
        aj.s(this.dZq, d.C0141d.cp_bg_line_d);
        aj.t(this.dZr, d.C0141d.cp_bg_line_e);
        aj.s(this.dYN, z ? d.f.frs_attention_btn_bg_gray_n : d.f.frs_star_btn_selector);
        aj.e(this.dYN, d.C0141d.cp_cont_i, 1);
        aj.e(this.dZs, d.C0141d.cp_cont_b, 1);
        aj.e(this.dZt, d.C0141d.cp_cont_d, 1);
        this.dZn.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private boolean aQq = false;
        private final List<StarTaskInfo> data = new ArrayList();
        private Context mContext;

        a(Context context) {
            this.mContext = context;
        }

        void setData(List<StarTaskInfo> list, boolean z) {
            if (!v.E(list)) {
                this.aQq = z;
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
        /* renamed from: og */
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
                bVar2.dZv = (TextView) view.findViewById(d.g.task_name);
                bVar2.bMr = (TextView) view.findViewById(d.g.desc);
                bVar2.dZw = (TextView) view.findViewById(d.g.score_desc);
                bVar2.dZx = (TextView) view.findViewById(d.g.status_text);
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
            bVar.dZv.setText(item.task_title);
            bVar.bMr.setText(item.task_desc);
            bVar.dZw.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dZx.setText(d.j.task_done);
                aj.r(bVar.dZx, d.C0141d.cp_cont_d);
            } else {
                bVar.dZx.setText(d.j.task_not_done);
                aj.r(bVar.dZx, d.C0141d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            aj.r(bVar.dZv, d.C0141d.cp_cont_b);
            aj.r(bVar.bMr, d.C0141d.cp_cont_d);
            aj.r(bVar.dZw, this.aQq ? d.C0141d.cp_cont_f : d.C0141d.cp_cont_h);
            aj.t(bVar.divider, d.C0141d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView bMr;
        TextView dZv;
        TextView dZw;
        TextView dZx;
        View divider;

        private b() {
        }
    }
}
