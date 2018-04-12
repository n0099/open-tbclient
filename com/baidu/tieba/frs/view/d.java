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
    private View dtU;
    private ListView dtV;
    private a dtW;
    private TextView dtX;
    private StarRank dtY;
    private View dtZ;
    private View dua;
    private TextView dub;
    private TextView duc;
    private TextView dud;
    private Context mContext;

    public void a(Context context, StarRank starRank) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            this.dtY = starRank;
            if (starRank != null && !v.w(this.dtY.user_task_info)) {
                this.dtU = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.frs_star_bottom_dialog_view, (ViewGroup) null);
                this.dtZ = this.dtU.findViewById(d.g.outer_bg);
                this.dua = this.dtU.findViewById(d.g.divider_line);
                this.dub = (TextView) this.dtU.findViewById(d.g.jump_title);
                this.duc = (TextView) this.dtU.findViewById(d.g.task_title);
                this.aru = (TbImageView) this.dtU.findViewById(d.g.pic_show);
                this.dud = (TextView) this.dtU.findViewById(d.g.know_view);
                this.dtV = (ListView) this.dtU.findViewById(d.g.rank_listview);
                this.dtX = (TextView) this.dtU.findViewById(d.g.know_view);
                this.dtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        d.this.avR();
                    }
                });
                this.dtW = new a(this.mContext);
                this.dtW.setData(this.dtY.user_task_info);
                this.dtV.setAdapter((ListAdapter) this.dtW);
                this.dub.setText(this.dtY.user_current_score_notice);
                avR();
                this.acB = new AlertDialog.Builder(this.mContext).create();
                this.acB.setCanceledOnTouchOutside(true);
                g.a(this.acB, (Activity) this.mContext);
                Window window = this.acB.getWindow();
                window.setWindowAnimations(d.l.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.dtU);
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
        ak.i(this.dtZ, d.C0126d.cp_bg_line_d);
        ak.j(this.dua, d.C0126d.cp_bg_line_e);
        ak.i(this.dud, d.f.frs_star_btn_selector);
        ak.c(this.dud, d.C0126d.cp_cont_i, 1);
        ak.c(this.dub, d.C0126d.cp_cont_b, 1);
        ak.c(this.duc, d.C0126d.cp_cont_d, 1);
        this.dtW.notifyDataSetChanged();
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
        /* renamed from: lG */
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
                bVar2.duf = (TextView) view2.findViewById(d.g.task_name);
                bVar2.duh = (TextView) view2.findViewById(d.g.desc);
                bVar2.dug = (TextView) view2.findViewById(d.g.score_desc);
                bVar2.dui = (TextView) view2.findViewById(d.g.status_text);
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
            bVar.duf.setText(item.task_title);
            bVar.duh.setText(item.task_desc);
            bVar.dug.setText(item.task_score_desc);
            if (item.task_status.intValue() == 1) {
                bVar.dui.setText(d.k.task_done);
                ak.h(bVar.dui, d.C0126d.cp_cont_d);
            } else {
                bVar.dui.setText(d.k.task_not_done);
                ak.h(bVar.dui, d.C0126d.cp_cont_b);
            }
            bVar.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            ak.h(bVar.duf, d.C0126d.cp_cont_b);
            ak.h(bVar.duh, d.C0126d.cp_cont_d);
            ak.h(bVar.dug, d.C0126d.cp_cont_h);
            ak.j(bVar.divider, d.C0126d.cp_bg_line_c);
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        View divider;
        TextView duf;
        TextView dug;
        TextView duh;
        TextView dui;

        private b() {
        }
    }
}
