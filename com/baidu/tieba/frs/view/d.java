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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes2.dex */
public class d {
    private AlertDialog acC;
    private TbImageView aru;
    private View duZ;
    private ListView dva;
    private a dvb;
    private TextView dvc;
    private StarRank dvd;
    private View dve;
    private View dvf;
    private TextView dvg;
    private TextView dvh;
    private TextView dvi;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dvd = starRank;
            if (starRank != null && !v.w(this.dvd.user_task_info)) {
                this.duZ = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dve = this.duZ.findViewById(d.g.outer_bg);
                this.dvf = this.duZ.findViewById(d.g.divider_line);
                this.dvg = (TextView) this.duZ.findViewById(d.g.jump_title);
                this.dvh = (TextView) this.duZ.findViewById(d.g.task_title);
                this.aru = (TbImageView) this.duZ.findViewById(d.g.pic_show);
                this.dvi = (TextView) this.duZ.findViewById(d.g.know_view);
                this.dva = (ListView) this.duZ.findViewById(d.g.rank_listview);
                this.dvc = (TextView) this.duZ.findViewById(d.g.know_view);
                this.dvc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        d.this.avQ();
                    }
                });
                this.dvb = new a(this.mContext);
                this.dvb.setData(this.dvd.user_task_info);
                this.dva.setAdapter((ListAdapter) this.dvb);
                this.dvg.setText(this.dvd.user_current_score_notice);
                avQ();
                this.acC = new AlertDialog.Builder(this.mContext).create();
                this.acC.setCanceledOnTouchOutside(true);
                g.a(this.acC, (Activity) this.mContext);
                Window window = this.acC.getWindow();
                window.setWindowAnimations(d.l.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.duZ);
                avR();
            }
        }
    }

    public void avQ() {
        if (this.acC != null && this.acC.isShowing()) {
            this.acC.dismiss();
        }
    }

    public void avR() {
        ak.c(this.aru, d.f.pic_frs_idol_mission);
        ak.i(this.dve, d.C0126d.cp_bg_line_d);
        ak.j(this.dvf, d.C0126d.cp_bg_line_e);
        ak.i(this.dvi, d.f.frs_star_btn_selector);
        ak.c(this.dvi, d.C0126d.cp_cont_i, 1);
        ak.c(this.dvg, d.C0126d.cp_cont_b, 1);
        ak.c(this.dvh, d.C0126d.cp_cont_d, 1);
        this.dvb.notifyDataSetChanged();
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
            if (!v.w(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.w(this.data)) {
                return 0;
            }
            return this.data.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lE */
        public StarTaskInfo getItem(int i) {
            return (StarTaskInfo) v.c(this.data, i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            b bVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.frs_item_bottom_view, viewGroup, false);
                b bVar2 = new b();
                bVar2.dvk = (TextView) view2.findViewById(d.g.task_name);
                bVar2.dvm = (TextView) view2.findViewById(d.g.desc);
                bVar2.dvl = (TextView) view2.findViewById(d.g.score_desc);
                bVar2.dvn = (TextView) view2.findViewById(d.g.status_text);
                bVar2.divider = view2.findViewById(d.g.bottom_divider_line);
                view2.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            StarTaskInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            bVar.dvk.setText(item.task_title);
            bVar.dvm.setText(item.task_desc);
            bVar.dvl.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dvn.setText(d.k.task_done);
                ak.h(bVar.dvn, d.C0126d.cp_cont_d);
            } else {
                bVar.dvn.setText(d.k.task_not_done);
                ak.h(bVar.dvn, d.C0126d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            ak.h(bVar.dvk, d.C0126d.cp_cont_b);
            ak.h(bVar.dvm, d.C0126d.cp_cont_d);
            ak.h(bVar.dvl, d.C0126d.cp_cont_h);
            ak.j(bVar.divider, d.C0126d.cp_bg_line_c);
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        View divider;
        TextView dvk;
        TextView dvl;
        TextView dvm;
        TextView dvn;

        private b() {
        }
    }
}
