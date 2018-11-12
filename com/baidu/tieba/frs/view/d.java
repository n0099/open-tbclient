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
    private AlertDialog asS;
    private TbImageView atK;
    private View bCY;
    private View eaR;
    private ListView eaS;
    private a eaT;
    private TextView eaU;
    private StarRank eaV;
    private View eaW;
    private TextView eaX;
    private TextView eaY;
    private TextView eaZ;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.eaV = starRank;
            if (starRank != null && !v.I(this.eaV.user_task_info)) {
                this.eaR = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.eaW = this.eaR.findViewById(e.g.outer_bg);
                this.bCY = this.eaR.findViewById(e.g.divider_line);
                this.eaX = (TextView) this.eaR.findViewById(e.g.jump_title);
                this.eaY = (TextView) this.eaR.findViewById(e.g.task_title);
                this.atK = (TbImageView) this.eaR.findViewById(e.g.pic_show);
                this.eaZ = (TextView) this.eaR.findViewById(e.g.know_view);
                this.eaS = (ListView) this.eaR.findViewById(e.g.rank_listview);
                this.eaU = (TextView) this.eaR.findViewById(e.g.know_view);
                this.eaU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aGn();
                    }
                });
                this.eaT = new a(this.mContext);
                this.eaT.setData(this.eaV.user_task_info);
                this.eaS.setAdapter((ListAdapter) this.eaT);
                this.eaX.setText(this.eaV.user_current_score_notice);
                aGn();
                this.asS = new AlertDialog.Builder(this.mContext).create();
                this.asS.setCanceledOnTouchOutside(true);
                g.a(this.asS, (Activity) this.mContext);
                Window window = this.asS.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.eaR);
                aGo();
            }
        }
    }

    public void aGn() {
        if (this.asS != null && this.asS.isShowing()) {
            this.asS.dismiss();
        }
    }

    public void aGo() {
        al.c(this.atK, e.f.pic_frs_idol_mission);
        al.i(this.eaW, e.d.cp_bg_line_d);
        al.j(this.bCY, e.d.cp_bg_line_e);
        al.i(this.eaZ, e.f.frs_star_btn_selector);
        al.c(this.eaZ, e.d.cp_cont_i, 1);
        al.c(this.eaX, e.d.cp_cont_b, 1);
        al.c(this.eaY, e.d.cp_cont_d, 1);
        this.eaT.notifyDataSetChanged();
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
        /* renamed from: ny */
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
                bVar2.ebb = (TextView) view.findViewById(e.g.task_name);
                bVar2.ebd = (TextView) view.findViewById(e.g.desc);
                bVar2.ebc = (TextView) view.findViewById(e.g.score_desc);
                bVar2.ebe = (TextView) view.findViewById(e.g.status_text);
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
            bVar.ebb.setText(item.task_title);
            bVar.ebd.setText(item.task_desc);
            bVar.ebc.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.ebe.setText(e.j.task_done);
                al.h(bVar.ebe, e.d.cp_cont_d);
            } else {
                bVar.ebe.setText(e.j.task_not_done);
                al.h(bVar.ebe, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.ebb, e.d.cp_cont_b);
            al.h(bVar.ebd, e.d.cp_cont_d);
            al.h(bVar.ebc, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        View divider;
        TextView ebb;
        TextView ebc;
        TextView ebd;
        TextView ebe;

        private b() {
        }
    }
}
