package com.baidu.tieba.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
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
        list = this.a.m;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        List list2;
        if (i >= 0) {
            list = this.a.m;
            if (i < list.size()) {
                list2 = this.a.m;
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
        GameCenterHomeActivity gameCenterHomeActivity17;
        GameCenterHomeActivity gameCenterHomeActivity18;
        GameCenterHomeActivity gameCenterHomeActivity19;
        GameCenterHomeActivity gameCenterHomeActivity20;
        GameCenterHomeActivity gameCenterHomeActivity21;
        GameCenterHomeActivity gameCenterHomeActivity22;
        GameCenterHomeActivity gameCenterHomeActivity23;
        GameCenterHomeActivity gameCenterHomeActivity24;
        GameCenterHomeActivity gameCenterHomeActivity25;
        GameCenterHomeActivity gameCenterHomeActivity26;
        View.OnClickListener onClickListener;
        GameCenterHomeActivity gameCenterHomeActivity27;
        GameCenterHomeActivity gameCenterHomeActivity28;
        GameCenterHomeActivity gameCenterHomeActivity29;
        GameCenterHomeActivity gameCenterHomeActivity30;
        GameCenterHomeActivity gameCenterHomeActivity31;
        boolean a;
        TextView textView;
        GameCenterHomeActivity gameCenterHomeActivity32;
        TextView textView2;
        GameCenterHomeActivity gameCenterHomeActivity33;
        TextView textView3;
        GameCenterHomeActivity gameCenterHomeActivity34;
        TextView textView4;
        GameCenterHomeActivity gameCenterHomeActivity35;
        GameCenterHomeActivity gameCenterHomeActivity36;
        GameCenterHomeActivity gameCenterHomeActivity37;
        if (view == null) {
            com.baidu.adp.lib.e.b a2 = com.baidu.adp.lib.e.b.a();
            gameCenterHomeActivity36 = this.a.b;
            view = a2.a(gameCenterHomeActivity36, com.baidu.tieba.v.game_center_list_item, viewGroup, false);
            uVar = new u();
            uVar.a = (RelativeLayout) view.findViewById(com.baidu.tieba.u.game_center_item);
            uVar.b = (TbImageView) view.findViewById(com.baidu.tieba.u.game_center_item_image);
            uVar.c = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_game_name);
            uVar.d = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_user_num);
            uVar.e = (TextView) view.findViewById(com.baidu.tieba.u.game_center_item_btn);
            uVar.g = (ImageView) view.findViewById(com.baidu.tieba.u.game_center_status_new);
            uVar.f = (TextView) view.findViewById(com.baidu.tieba.u.game_center_status_waiting);
            uVar.b.setDrawerType(1);
            TbImageView tbImageView = uVar.b;
            gameCenterHomeActivity37 = this.a.b;
            tbImageView.setRadius(com.baidu.adp.lib.util.j.c(gameCenterHomeActivity37, com.baidu.tieba.s.ds26));
            this.a.a(view);
            view.setTag(uVar);
        } else {
            uVar = (u) view.getTag();
        }
        com.baidu.tbadk.game.b bVar = (com.baidu.tbadk.game.b) getItem(i);
        uVar.b.a(bVar.d(), 10, false);
        String b = bVar.b();
        if (com.baidu.tieba.game.a.a.a(b) > 14) {
            b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
        }
        uVar.c.setText(b);
        gameCenterHomeActivity = this.a.b;
        uVar.d.setText(String.format(gameCenterHomeActivity.getResources().getString(com.baidu.tieba.x.game_center_player_num), com.baidu.tieba.game.a.a.a(bVar.e())));
        uVar.e.setBackgroundDrawable(null);
        if (bVar.i() == 1) {
            view.setEnabled(false);
            uVar.f.setVisibility(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView3 = this.a.j;
                gameCenterHomeActivity34 = this.a.b;
                textView3.setBackgroundDrawable(gameCenterHomeActivity34.getResources().getDrawable(com.baidu.tieba.t.game_center_status_waiting_1));
                textView4 = this.a.j;
                gameCenterHomeActivity35 = this.a.b;
                textView4.setTextColor(gameCenterHomeActivity35.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
            } else {
                textView = this.a.j;
                gameCenterHomeActivity32 = this.a.b;
                textView.setBackgroundDrawable(gameCenterHomeActivity32.getResources().getDrawable(com.baidu.tieba.t.game_center_status_waiting));
                textView2 = this.a.j;
                gameCenterHomeActivity33 = this.a.b;
                textView2.setTextColor(gameCenterHomeActivity33.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            }
            uVar.e.setVisibility(8);
            uVar.d.setVisibility(4);
        } else {
            view.setEnabled(true);
            uVar.f.setVisibility(8);
            if (bVar.i() == 2) {
                a = this.a.a(bVar.a());
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
            if (bVar.c() == 2) {
                TextView textView5 = uVar.e;
                gameCenterHomeActivity27 = this.a.b;
                textView5.setText(gameCenterHomeActivity27.getResources().getString(com.baidu.tieba.x.game_center_start));
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    TextView textView6 = uVar.e;
                    gameCenterHomeActivity30 = this.a.b;
                    textView6.setTextColor(gameCenterHomeActivity30.getResources().getColor(com.baidu.tieba.r.cp_cont_g_1));
                    TextView textView7 = uVar.e;
                    gameCenterHomeActivity31 = this.a.b;
                    textView7.setBackgroundDrawable(gameCenterHomeActivity31.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn_1));
                } else {
                    TextView textView8 = uVar.e;
                    gameCenterHomeActivity28 = this.a.b;
                    textView8.setTextColor(gameCenterHomeActivity28.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                    TextView textView9 = uVar.e;
                    gameCenterHomeActivity29 = this.a.b;
                    textView9.setBackgroundDrawable(gameCenterHomeActivity29.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                }
            } else {
                int j = ae.a().j(bVar);
                switch (j) {
                    case 1:
                        TextView textView10 = uVar.e;
                        gameCenterHomeActivity22 = this.a.b;
                        textView10.setText(gameCenterHomeActivity22.getResources().getString(com.baidu.tieba.x.game_center_download));
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            TextView textView11 = uVar.e;
                            gameCenterHomeActivity25 = this.a.b;
                            textView11.setTextColor(gameCenterHomeActivity25.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                            TextView textView12 = uVar.e;
                            gameCenterHomeActivity26 = this.a.b;
                            textView12.setBackgroundDrawable(gameCenterHomeActivity26.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn_1));
                            break;
                        } else {
                            TextView textView13 = uVar.e;
                            gameCenterHomeActivity23 = this.a.b;
                            textView13.setTextColor(gameCenterHomeActivity23.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                            TextView textView14 = uVar.e;
                            gameCenterHomeActivity24 = this.a.b;
                            textView14.setBackgroundDrawable(gameCenterHomeActivity24.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                            break;
                        }
                    case 2:
                        TextView textView15 = uVar.e;
                        gameCenterHomeActivity17 = this.a.b;
                        textView15.setText(gameCenterHomeActivity17.getResources().getString(com.baidu.tieba.x.game_center_stop));
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            TextView textView16 = uVar.e;
                            gameCenterHomeActivity20 = this.a.b;
                            textView16.setTextColor(gameCenterHomeActivity20.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a_1));
                            TextView textView17 = uVar.e;
                            gameCenterHomeActivity21 = this.a.b;
                            textView17.setBackgroundDrawable(gameCenterHomeActivity21.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn_1));
                            break;
                        } else {
                            TextView textView18 = uVar.e;
                            gameCenterHomeActivity18 = this.a.b;
                            textView18.setTextColor(gameCenterHomeActivity18.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a));
                            TextView textView19 = uVar.e;
                            gameCenterHomeActivity19 = this.a.b;
                            textView19.setBackgroundDrawable(gameCenterHomeActivity19.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                            break;
                        }
                    case 3:
                        TextView textView20 = uVar.e;
                        gameCenterHomeActivity12 = this.a.b;
                        textView20.setText(gameCenterHomeActivity12.getResources().getString(com.baidu.tieba.x.game_center_continue));
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            TextView textView21 = uVar.e;
                            gameCenterHomeActivity15 = this.a.b;
                            textView21.setTextColor(gameCenterHomeActivity15.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a_1));
                            TextView textView22 = uVar.e;
                            gameCenterHomeActivity16 = this.a.b;
                            textView22.setBackgroundDrawable(gameCenterHomeActivity16.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn_1));
                            break;
                        } else {
                            TextView textView23 = uVar.e;
                            gameCenterHomeActivity13 = this.a.b;
                            textView23.setTextColor(gameCenterHomeActivity13.getResources().getColor(com.baidu.tieba.r.cp_link_tip_a));
                            TextView textView24 = uVar.e;
                            gameCenterHomeActivity14 = this.a.b;
                            textView24.setBackgroundDrawable(gameCenterHomeActivity14.getResources().getDrawable(com.baidu.tieba.t.game_center_download_btn));
                            break;
                        }
                    case 4:
                        TextView textView25 = uVar.e;
                        gameCenterHomeActivity7 = this.a.b;
                        textView25.setText(gameCenterHomeActivity7.getResources().getString(com.baidu.tieba.x.game_center_install));
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            TextView textView26 = uVar.e;
                            gameCenterHomeActivity10 = this.a.b;
                            textView26.setTextColor(gameCenterHomeActivity10.getResources().getColor(com.baidu.tieba.r.cp_cont_g_1));
                            TextView textView27 = uVar.e;
                            gameCenterHomeActivity11 = this.a.b;
                            textView27.setBackgroundDrawable(gameCenterHomeActivity11.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn_1));
                            break;
                        } else {
                            TextView textView28 = uVar.e;
                            gameCenterHomeActivity8 = this.a.b;
                            textView28.setTextColor(gameCenterHomeActivity8.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                            TextView textView29 = uVar.e;
                            gameCenterHomeActivity9 = this.a.b;
                            textView29.setBackgroundDrawable(gameCenterHomeActivity9.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                            break;
                        }
                    case 5:
                        TextView textView30 = uVar.e;
                        gameCenterHomeActivity2 = this.a.b;
                        textView30.setText(gameCenterHomeActivity2.getResources().getString(com.baidu.tieba.x.game_center_start));
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            TextView textView31 = uVar.e;
                            gameCenterHomeActivity5 = this.a.b;
                            textView31.setTextColor(gameCenterHomeActivity5.getResources().getColor(com.baidu.tieba.r.cp_cont_g_1));
                            TextView textView32 = uVar.e;
                            gameCenterHomeActivity6 = this.a.b;
                            textView32.setBackgroundDrawable(gameCenterHomeActivity6.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn_1));
                            break;
                        } else {
                            TextView textView33 = uVar.e;
                            gameCenterHomeActivity3 = this.a.b;
                            textView33.setTextColor(gameCenterHomeActivity3.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
                            TextView textView34 = uVar.e;
                            gameCenterHomeActivity4 = this.a.b;
                            textView34.setBackgroundDrawable(gameCenterHomeActivity4.getResources().getDrawable(com.baidu.tieba.t.game_center_start_btn));
                            break;
                        }
                }
                bVar.c(j);
            }
            uVar.e.setTag(Integer.valueOf(i));
            TextView textView35 = uVar.e;
            onClickListener = this.a.y;
            textView35.setOnClickListener(onClickListener);
        }
        return view;
    }
}
