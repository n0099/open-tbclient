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
    private AlertDialog awV;
    private TbImageView axN;
    private View bHh;
    private View ekR;
    private ListView ekS;
    private a ekT;
    private TextView ekU;
    private StarRank ekV;
    private View ekW;
    private TextView ekX;
    private TextView ekY;
    private TextView ekZ;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.ekV = starRank;
            if (starRank != null && !v.I(this.ekV.user_task_info)) {
                this.ekR = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.ekW = this.ekR.findViewById(e.g.outer_bg);
                this.bHh = this.ekR.findViewById(e.g.divider_line);
                this.ekX = (TextView) this.ekR.findViewById(e.g.jump_title);
                this.ekY = (TextView) this.ekR.findViewById(e.g.task_title);
                this.axN = (TbImageView) this.ekR.findViewById(e.g.pic_show);
                this.ekZ = (TextView) this.ekR.findViewById(e.g.know_view);
                this.ekS = (ListView) this.ekR.findViewById(e.g.rank_listview);
                this.ekU = (TextView) this.ekR.findViewById(e.g.know_view);
                this.ekU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aJm();
                    }
                });
                this.ekT = new a(this.mContext);
                this.ekT.setData(this.ekV.user_task_info);
                this.ekS.setAdapter((ListAdapter) this.ekT);
                this.ekX.setText(this.ekV.user_current_score_notice);
                aJm();
                this.awV = new AlertDialog.Builder(this.mContext).create();
                this.awV.setCanceledOnTouchOutside(true);
                g.a(this.awV, (Activity) this.mContext);
                Window window = this.awV.getWindow();
                window.setWindowAnimations(e.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.ekR);
                aJn();
            }
        }
    }

    public void aJm() {
        if (this.awV != null && this.awV.isShowing()) {
            this.awV.dismiss();
        }
    }

    public void aJn() {
        al.c(this.axN, e.f.pic_frs_idol_mission);
        al.i(this.ekW, e.d.cp_bg_line_d);
        al.j(this.bHh, e.d.cp_bg_line_e);
        al.i(this.ekZ, e.f.frs_star_btn_selector);
        al.c(this.ekZ, e.d.cp_cont_i, 1);
        al.c(this.ekX, e.d.cp_cont_b, 1);
        al.c(this.ekY, e.d.cp_cont_d, 1);
        this.ekT.notifyDataSetChanged();
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
        /* renamed from: oc */
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
                bVar2.elb = (TextView) view.findViewById(e.g.task_name);
                bVar2.eld = (TextView) view.findViewById(e.g.desc);
                bVar2.elc = (TextView) view.findViewById(e.g.score_desc);
                bVar2.cOY = (TextView) view.findViewById(e.g.status_text);
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
            bVar.elb.setText(item.task_title);
            bVar.eld.setText(item.task_desc);
            bVar.elc.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.cOY.setText(e.j.task_done);
                al.h(bVar.cOY, e.d.cp_cont_d);
            } else {
                bVar.cOY.setText(e.j.task_not_done);
                al.h(bVar.cOY, e.d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.h(bVar.elb, e.d.cp_cont_b);
            al.h(bVar.eld, e.d.cp_cont_d);
            al.h(bVar.elc, e.d.cp_cont_h);
            al.j(bVar.divider, e.d.cp_bg_line_c);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView cOY;
        View divider;
        TextView elb;
        TextView elc;
        TextView eld;

        private b() {
        }
    }
}
