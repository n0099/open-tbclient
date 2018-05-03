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
    private AlertDialog acB;
    private TbImageView aru;
    private View dtR;
    private ListView dtS;
    private a dtT;
    private TextView dtU;
    private StarRank dtV;
    private View dtW;
    private View dtX;
    private TextView dtY;
    private TextView dtZ;
    private TextView dua;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dtV = starRank;
            if (starRank != null && !v.w(this.dtV.user_task_info)) {
                this.dtR = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dtW = this.dtR.findViewById(d.g.outer_bg);
                this.dtX = this.dtR.findViewById(d.g.divider_line);
                this.dtY = (TextView) this.dtR.findViewById(d.g.jump_title);
                this.dtZ = (TextView) this.dtR.findViewById(d.g.task_title);
                this.aru = (TbImageView) this.dtR.findViewById(d.g.pic_show);
                this.dua = (TextView) this.dtR.findViewById(d.g.know_view);
                this.dtS = (ListView) this.dtR.findViewById(d.g.rank_listview);
                this.dtU = (TextView) this.dtR.findViewById(d.g.know_view);
                this.dtU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        d.this.avR();
                    }
                });
                this.dtT = new a(this.mContext);
                this.dtT.setData(this.dtV.user_task_info);
                this.dtS.setAdapter((ListAdapter) this.dtT);
                this.dtY.setText(this.dtV.user_current_score_notice);
                avR();
                this.acB = new AlertDialog.Builder(this.mContext).create();
                this.acB.setCanceledOnTouchOutside(true);
                g.a(this.acB, (Activity) this.mContext);
                Window window = this.acB.getWindow();
                window.setWindowAnimations(d.l.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dtR);
                avS();
            }
        }
    }

    public void avR() {
        if (this.acB != null && this.acB.isShowing()) {
            this.acB.dismiss();
        }
    }

    public void avS() {
        ak.c(this.aru, d.f.pic_frs_idol_mission);
        ak.i(this.dtW, d.C0126d.cp_bg_line_d);
        ak.j(this.dtX, d.C0126d.cp_bg_line_e);
        ak.i(this.dua, d.f.frs_star_btn_selector);
        ak.c(this.dua, d.C0126d.cp_cont_i, 1);
        ak.c(this.dtY, d.C0126d.cp_cont_b, 1);
        ak.c(this.dtZ, d.C0126d.cp_cont_d, 1);
        this.dtT.notifyDataSetChanged();
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
        /* renamed from: lF */
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
                bVar2.duc = (TextView) view2.findViewById(d.g.task_name);
                bVar2.due = (TextView) view2.findViewById(d.g.desc);
                bVar2.dud = (TextView) view2.findViewById(d.g.score_desc);
                bVar2.duf = (TextView) view2.findViewById(d.g.status_text);
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
            bVar.duc.setText(item.task_title);
            bVar.due.setText(item.task_desc);
            bVar.dud.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.duf.setText(d.k.task_done);
                ak.h(bVar.duf, d.C0126d.cp_cont_d);
            } else {
                bVar.duf.setText(d.k.task_not_done);
                ak.h(bVar.duf, d.C0126d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            ak.h(bVar.duc, d.C0126d.cp_cont_b);
            ak.h(bVar.due, d.C0126d.cp_cont_d);
            ak.h(bVar.dud, d.C0126d.cp_cont_h);
            ak.j(bVar.divider, d.C0126d.cp_bg_line_c);
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        View divider;
        TextView duc;
        TextView dud;
        TextView due;
        TextView duf;

        private b() {
        }
    }
}
