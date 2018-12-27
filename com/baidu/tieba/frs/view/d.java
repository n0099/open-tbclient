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
    private AlertDialog awt;
    private TbImageView axl;
    private View bGu;
    private View ekl;
    private ListView ekm;
    private a ekn;
    private TextView eko;
    private StarRank ekp;
    private View ekq;
    private TextView ekr;
    private TextView eks;
    private TextView ekt;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.ekp = starRank;
            if (starRank != null && !v.I(this.ekp.user_task_info)) {
                this.ekl = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.ekq = this.ekl.findViewById(e.g.outer_bg);
                this.bGu = this.ekl.findViewById(e.g.divider_line);
                this.ekr = (TextView) this.ekl.findViewById(e.g.jump_title);
                this.eks = (TextView) this.ekl.findViewById(e.g.task_title);
                this.axl = (TbImageView) this.ekl.findViewById(e.g.pic_show);
                this.ekt = (TextView) this.ekl.findViewById(e.g.know_view);
                this.ekm = (ListView) this.ekl.findViewById(e.g.rank_listview);
                this.eko = (TextView) this.ekl.findViewById(e.g.know_view);
                this.eko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aIO();
                    }
                });
                this.ekn = new a(this.mContext);
                this.ekn.setData(this.ekp.user_task_info);
                this.ekm.setAdapter((ListAdapter) this.ekn);
                this.ekr.setText(this.ekp.user_current_score_notice);
                aIO();
                this.awt = new AlertDialog.Builder(this.mContext).create();
                this.awt.setCanceledOnTouchOutside(true);
                g.a(this.awt, (Activity) this.mContext);
                Window window = this.awt.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.ekl);
                aIP();
            }
        }
    }

    public void aIO() {
        if (this.awt != null && this.awt.isShowing()) {
            this.awt.dismiss();
        }
    }

    public void aIP() {
        al.c(this.axl, e.f.pic_frs_idol_mission);
        al.i(this.ekq, e.d.cp_bg_line_d);
        al.j(this.bGu, e.d.cp_bg_line_e);
        al.i(this.ekt, e.f.frs_star_btn_selector);
        al.c(this.ekt, e.d.cp_cont_i, 1);
        al.c(this.ekr, e.d.cp_cont_b, 1);
        al.c(this.eks, e.d.cp_cont_d, 1);
        this.ekn.notifyDataSetChanged();
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
        /* renamed from: ob */
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
                bVar2.ekv = (TextView) view.findViewById(e.g.task_name);
                bVar2.ekx = (TextView) view.findViewById(e.g.desc);
                bVar2.ekw = (TextView) view.findViewById(e.g.score_desc);
                bVar2.cOn = (TextView) view.findViewById(e.g.status_text);
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
            bVar.ekv.setText(item.task_title);
            bVar.ekx.setText(item.task_desc);
            bVar.ekw.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.cOn.setText(e.j.task_done);
                al.h(bVar.cOn, e.d.cp_cont_d);
            } else {
                bVar.cOn.setText(e.j.task_not_done);
                al.h(bVar.cOn, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.ekv, e.d.cp_cont_b);
            al.h(bVar.ekx, e.d.cp_cont_d);
            al.h(bVar.ekw, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView cOn;
        View divider;
        TextView ekv;
        TextView ekw;
        TextView ekx;

        private b() {
        }
    }
}
