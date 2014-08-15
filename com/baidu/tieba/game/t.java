package com.baidu.tieba.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    final /* synthetic */ n a;

    private t(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(n nVar, t tVar) {
        this(nVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.a.l;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        List list2;
        if (i >= 0) {
            list = this.a.l;
            if (i < list.size()) {
                list2 = this.a.l;
                return list2.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        u uVar;
        GameCenterHomeActivity gameCenterHomeActivity;
        GameCenterHomeActivity gameCenterHomeActivity2;
        GameCenterHomeActivity gameCenterHomeActivity3;
        GameCenterHomeActivity gameCenterHomeActivity4;
        GameCenterHomeActivity gameCenterHomeActivity5;
        GameCenterHomeActivity gameCenterHomeActivity6;
        GameCenterHomeActivity gameCenterHomeActivity7;
        GameCenterHomeActivity gameCenterHomeActivity8;
        GameCenterHomeActivity gameCenterHomeActivity9;
        GameCenterHomeActivity gameCenterHomeActivity10;
        GameCenterHomeActivity gameCenterHomeActivity11;
        GameCenterHomeActivity gameCenterHomeActivity12;
        GameCenterHomeActivity gameCenterHomeActivity13;
        GameCenterHomeActivity gameCenterHomeActivity14;
        GameCenterHomeActivity gameCenterHomeActivity15;
        GameCenterHomeActivity gameCenterHomeActivity16;
        View.OnClickListener onClickListener;
        GameCenterHomeActivity gameCenterHomeActivity17;
        GameCenterHomeActivity gameCenterHomeActivity18;
        GameCenterHomeActivity gameCenterHomeActivity19;
        boolean a;
        GameCenterHomeActivity gameCenterHomeActivity20;
        GameCenterHomeActivity gameCenterHomeActivity21;
        if (view == null) {
            gameCenterHomeActivity20 = this.a.a;
            view = LayoutInflater.from(gameCenterHomeActivity20).inflate(com.baidu.tieba.v.game_center_list_item, viewGroup, false);
            uVar = new u();
            uVar.a = (RelativeLayout) view.findViewById(com.baidu.tieba.u.game_center_item);
            uVar.b = (TbImageView) view.findViewById(com.baidu.tieba.u.game_center_item_image);
            uVar.c = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_game_name);
            uVar.d = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_user_num);
            uVar.e = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_btn);
            uVar.g = (ImageView) view.findViewById(com.baidu.tieba.u.game_center_status_new);
            uVar.f = (TextView) view.findViewById(com.baidu.tieba.u.game_center_status_waiting);
            TbImageView tbImageView = uVar.b;
            gameCenterHomeActivity21 = this.a.a;
            tbImageView.setRadius(com.baidu.adp.lib.util.j.c(gameCenterHomeActivity21, com.baidu.tieba.s.ds26));
            view.setTag(uVar);
        } else {
            uVar = (u) view.getTag();
        }
        ab abVar = (ab) getItem(i);
        uVar.b.a(abVar.d(), 10, false);
        String b = abVar.b();
        if (com.baidu.tieba.game.a.a.a(b) > 14) {
            b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
        }
        uVar.c.setText(b);
        gameCenterHomeActivity = this.a.a;
        uVar.d.setText(String.format(gameCenterHomeActivity.getResources().getString(com.baidu.tieba.x.game_center_player_num), com.baidu.tieba.game.a.a.a(abVar.e())));
        uVar.e.setBackgroundDrawable(null);
        if (abVar.i() == 1) {
            view.setEnabled(false);
            uVar.f.setVisibility(0);
            uVar.e.setVisibility(8);
            uVar.d.setVisibility(4);
        } else {
            view.setEnabled(true);
            uVar.f.setVisibility(8);
            if (abVar.i() == 2) {
                a = this.a.a(abVar.a());
                if (!a) {
                    uVar.g.setVisibility(0);
                } else {
                    uVar.g.setVisibility(8);
                }
            } else {
                uVar.g.setVisibility(8);
            }
            uVar.e.setVisibility(0);
            uVar.d.setVisibility(0);
            if (abVar.c() == 2) {
                TextView textView = uVar.e;
                gameCenterHomeActivity17 = this.a.a;
                textView.setTextColor(gameCenterHomeActivity17.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                TextView textView2 = uVar.e;
                gameCenterHomeActivity18 = this.a.a;
                textView2.setBackgroundDrawable(gameCenterHomeActivity18.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                TextView textView3 = uVar.e;
                gameCenterHomeActivity19 = this.a.a;
                textView3.setText(gameCenterHomeActivity19.getResources().getString(com.baidu.tieba.x.game_center_start));
            } else {
                int j = ac.a().j(abVar);
                switch (j) {
                    case 1:
                        TextView textView4 = uVar.e;
                        gameCenterHomeActivity14 = this.a.a;
                        textView4.setTextColor(gameCenterHomeActivity14.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                        TextView textView5 = uVar.e;
                        gameCenterHomeActivity15 = this.a.a;
                        textView5.setText(gameCenterHomeActivity15.getResources().getString(com.baidu.tieba.x.game_center_download));
                        TextView textView6 = uVar.e;
                        gameCenterHomeActivity16 = this.a.a;
                        textView6.setBackgroundDrawable(gameCenterHomeActivity16.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                        break;
                    case 2:
                        TextView textView7 = uVar.e;
                        gameCenterHomeActivity11 = this.a.a;
                        textView7.setText(gameCenterHomeActivity11.getResources().getString(com.baidu.tieba.x.game_center_stop));
                        TextView textView8 = uVar.e;
                        gameCenterHomeActivity12 = this.a.a;
                        textView8.setTextColor(gameCenterHomeActivity12.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a));
                        TextView textView9 = uVar.e;
                        gameCenterHomeActivity13 = this.a.a;
                        textView9.setBackgroundDrawable(gameCenterHomeActivity13.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                        break;
                    case 3:
                        TextView textView10 = uVar.e;
                        gameCenterHomeActivity8 = this.a.a;
                        textView10.setText(gameCenterHomeActivity8.getResources().getString(com.baidu.tieba.x.game_center_continue));
                        TextView textView11 = uVar.e;
                        gameCenterHomeActivity9 = this.a.a;
                        textView11.setTextColor(gameCenterHomeActivity9.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a));
                        TextView textView12 = uVar.e;
                        gameCenterHomeActivity10 = this.a.a;
                        textView12.setBackgroundDrawable(gameCenterHomeActivity10.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                        break;
                    case 4:
                        TextView textView13 = uVar.e;
                        gameCenterHomeActivity5 = this.a.a;
                        textView13.setTextColor(gameCenterHomeActivity5.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                        TextView textView14 = uVar.e;
                        gameCenterHomeActivity6 = this.a.a;
                        textView14.setBackgroundDrawable(gameCenterHomeActivity6.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                        TextView textView15 = uVar.e;
                        gameCenterHomeActivity7 = this.a.a;
                        textView15.setText(gameCenterHomeActivity7.getResources().getString(com.baidu.tieba.x.game_center_install));
                        break;
                    case 5:
                        TextView textView16 = uVar.e;
                        gameCenterHomeActivity2 = this.a.a;
                        textView16.setTextColor(gameCenterHomeActivity2.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                        TextView textView17 = uVar.e;
                        gameCenterHomeActivity3 = this.a.a;
                        textView17.setBackgroundDrawable(gameCenterHomeActivity3.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                        TextView textView18 = uVar.e;
                        gameCenterHomeActivity4 = this.a.a;
                        textView18.setText(gameCenterHomeActivity4.getResources().getString(com.baidu.tieba.x.game_center_start));
                        break;
                }
                abVar.c(j);
            }
            uVar.e.setTag(Integer.valueOf(i));
            TextView textView19 = uVar.e;
            onClickListener = this.a.w;
            textView19.setOnClickListener(onClickListener);
        }
        return view;
    }
}
