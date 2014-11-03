package com.baidu.tieba.game;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import tbclient.GetGameCenter.AdList;
/* loaded from: classes.dex */
public class av {
    private View HT;
    private View aIG;
    private TextView aIH;
    private TextView aII;
    private View aIJ;
    private View aIK;
    private TextView aIL;
    private LinearLayout aIM;
    private LinearLayout aIS;
    private View aIT;
    private boolean aIU;
    private LinearLayout aIV;
    private RelativeLayout aIW;
    private View aIX;
    private TextView aIY;
    private GameCenterActivity aIs;
    private com.baidu.adp.widget.ListView.aa aJb;
    private RelativeLayout aJc;
    private NoNetworkView aoS;
    private BdListView vl;
    private CarouselRecommendView aIR = null;
    private Handler mHandler = new Handler();
    private com.baidu.adp.lib.guide.d aHP = null;
    private Set<String> aIZ = new HashSet();
    private boolean aJa = false;
    private com.baidu.tieba.game.view.c aJd = new aw(this);
    private com.baidu.tieba.game.view.d aJe = new ax(this);
    private View.OnClickListener aJf = new ay(this);
    private AdapterView.OnItemClickListener aJg = new az(this);
    private View.OnClickListener aJh = new ba(this);
    private View.OnClickListener aJi = new bb(this);
    private Runnable aHR = new bc(this);
    private List<GameInfoData> aIN = new LinkedList();
    private List<GameInfoData> aIO = new LinkedList();
    private List<GameInfoData> mRecommendGames = new LinkedList();
    private List<AdList> aIP = new LinkedList();
    private bf aIQ = new bf(this, null);

    public void cn(boolean z) {
        this.aJa = z;
    }

    public View HA() {
        return this.vl;
    }

    public List<GameInfoData> HB() {
        return this.aIN;
    }

    public List<GameInfoData> HC() {
        return this.aIO;
    }

    public void onChangeSkinType(int i) {
        if (this.aoS != null) {
            this.aoS.onChangeSkinType(i);
        }
        this.aIs.getLayoutMode().L(i == 1);
        this.aIs.getLayoutMode().h(this.HT);
        this.aIs.getLayoutMode().h(this.aIG);
        if (this.aIR != null) {
            this.aIR.onChangeSkinType(i);
        }
    }

    public void HD() {
        if (this.aIN != null && this.aIN.size() != 0) {
            for (GameInfoData gameInfoData : this.aIN) {
                if (ab.Hu().c(gameInfoData)) {
                    Hq();
                    return;
                }
            }
        }
    }

    public void HE() {
        HG();
        HH();
        if (this.aIQ != null) {
            this.aIQ.notifyDataSetChanged();
        }
    }

    public void onResume() {
        if (this.aIR != null) {
            this.aIR.startMarqueen();
        }
        HE();
    }

    public void onPause() {
        if (this.aIR != null) {
            this.aIR.stopMarqueen();
        }
    }

    private void HF() {
        HashSet hashSet = new HashSet();
        if (this.aIP != null && this.aIP.size() > 0) {
            Iterator<AdList> it = this.aIP.iterator();
            while (it.hasNext()) {
                AdList next = it.next();
                if (TextUtils.isEmpty(next.img_url) || TextUtils.isEmpty(next.link_url)) {
                    it.remove();
                }
            }
            Iterator<AdList> it2 = this.aIP.iterator();
            while (it2.hasNext()) {
                if (!hashSet.add(it2.next().img_url)) {
                    it2.remove();
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        if (this.mRecommendGames != null && this.mRecommendGames.size() > 0) {
            Iterator<GameInfoData> it3 = this.mRecommendGames.iterator();
            while (it3.hasNext()) {
                if (!hashSet2.add(it3.next().getGameId())) {
                    it3.remove();
                }
            }
        }
        hashSet.clear();
        HashSet hashSet3 = new HashSet();
        if (this.aIO != null && this.aIO.size() > 0) {
            Iterator<GameInfoData> it4 = this.aIO.iterator();
            while (it4.hasNext()) {
                String gameId = it4.next().getGameId();
                hashSet3.add(gameId);
                if (!hashSet.add(gameId)) {
                    it4.remove();
                }
            }
        }
        if (this.mRecommendGames != null && this.mRecommendGames.size() > 0) {
            Iterator<GameInfoData> it5 = this.mRecommendGames.iterator();
            while (it5.hasNext()) {
                if (!hashSet3.add(it5.next().getGameId())) {
                    it5.remove();
                }
            }
        }
        if (this.aIN != null && this.aIN.size() > 0) {
            HashSet hashSet4 = new HashSet();
            if (!this.aJa) {
                this.aIZ.clear();
            }
            Iterator<GameInfoData> it6 = this.aIN.iterator();
            while (it6.hasNext()) {
                String gameId2 = it6.next().getGameId();
                this.aIZ.add(gameId2);
                if (!hashSet4.add(gameId2)) {
                    it6.remove();
                }
            }
            Iterator<GameInfoData> it7 = this.aIO.iterator();
            while (it7.hasNext()) {
                if (this.aIZ.add(it7.next().getGameId())) {
                    it7.remove();
                }
            }
            Iterator<GameInfoData> it8 = this.aIN.iterator();
            while (it8.hasNext()) {
                if (!hashSet.add(it8.next().getGameId())) {
                    it8.remove();
                }
            }
        } else if (this.aIO != null) {
            this.aIO.clear();
        }
    }

    public void a(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4) {
        a(list, list2, list3, list4, false);
    }

    public void b(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4) {
        a(list, list2, list3, list4, true);
    }

    private void a(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4, boolean z) {
        if (this.aIU) {
            this.aIP.clear();
            this.aIN.clear();
            if (this.aIO != null) {
                this.aIO.clear();
            }
            this.mRecommendGames.clear();
        }
        if (list != null) {
            this.aIP.addAll(list);
        }
        if (list2 != null) {
            this.aIN.addAll(list2);
        }
        if (list4 != null) {
            this.aIO.addAll(list4);
        }
        if (list3 != null) {
            this.mRecommendGames.addAll(list3);
        }
        if ((this.aIO == null || this.aIO.size() == 0) && ((this.aIN == null || this.aIN.size() == 0) && (this.aIP == null || this.aIP.size() == 0))) {
            this.vl.setVisibility(8);
            return;
        }
        this.vl.setVisibility(0);
        this.aIJ.setVisibility(0);
        this.aIK.setVisibility(0);
        this.aIR.getViewPagerBottomLine().setVisibility(0);
        HF();
        this.aIU = z;
        if (this.aIP.size() >= 1) {
            this.aIR.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            int size = this.aIP.size() > 5 ? 5 : this.aIP.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.square.ak akVar = new com.baidu.tieba.square.ak();
                akVar.hu(this.aIP.get(i).img_url);
                akVar.setLink(this.aIP.get(i).link_url);
                arrayList.add(akVar);
            }
            this.aIR.setData(arrayList);
        } else {
            this.aIR.getViewPagerBottomLine().setVisibility(8);
            this.aIR.setData(null);
        }
        HG();
        HH();
        this.aIQ.notifyDataSetChanged();
    }

    public av(GameCenterActivity gameCenterActivity, View view, com.baidu.adp.widget.ListView.aa aaVar) {
        this.aIs = gameCenterActivity;
        this.aJb = aaVar;
        G(view);
    }

    private void HG() {
        String string = this.aIs.getResources().getString(com.baidu.tieba.y.game_center_undownload_num);
        if (this.aIN == null || this.aIN.size() == 0) {
            if (this.aIO.size() != 0) {
                this.aII.setText(String.format(string, 0));
                this.aIL.setVisibility(0);
                this.aIK.setVisibility(0);
            }
        } else {
            this.aIL.setVisibility(8);
            this.aIK.setVisibility(0);
            this.aII.setText(String.format(string, Integer.valueOf(this.aIN.size())));
        }
        if (this.aIO == null || this.aIO.size() == 0) {
            this.aIS.setVisibility(8);
            return;
        }
        this.aIS.setVisibility(0);
        this.aIH.setText(String.format(this.aIs.getResources().getString(com.baidu.tieba.y.game_center_download_num), Integer.valueOf(this.aIO.size())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.adp.lib.util.m.c(this.aIs, com.baidu.tieba.t.ds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.m.c(this.aIs, com.baidu.tieba.t.ds30);
        this.aIM.removeAllViews();
        for (int i = 0; i < this.aIO.size(); i++) {
            View a = com.baidu.adp.lib.g.b.ek().a(this.aIs, com.baidu.tieba.w.game_center_downloaded_item, null, false);
            TbImageView tbImageView = (TbImageView) a.findViewById(com.baidu.tieba.v.game_center_downloaded_image);
            TextView textView = (TextView) a.findViewById(com.baidu.tieba.v.game_center_downloaded_game_name);
            tbImageView.c(this.aIO.get(i).getIconUrl(), 10, false);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(com.baidu.adp.lib.util.m.c(this.aIs, com.baidu.tieba.t.ds26));
            String gameName = this.aIO.get(i).getGameName();
            if (com.baidu.tieba.game.a.g.fy(gameName) > 14) {
                gameName = String.valueOf(com.baidu.tieba.game.a.g.g(gameName, 0, 14)) + "...";
            }
            textView.setText(gameName);
            a.setTag(Integer.valueOf(i));
            a.setOnClickListener(this.aJh);
            F(a);
            this.aIM.addView(a, layoutParams);
        }
    }

    private void HH() {
        if (this.mRecommendGames.size() == 0) {
            this.aIV.setVisibility(8);
            this.aIW.setVisibility(8);
            this.aIX.setVisibility(8);
            return;
        }
        this.aIV.setVisibility(0);
        this.aIW.setVisibility(0);
        this.aIX.setVisibility(0);
        this.aIY.setOnClickListener(this.aJf);
        int size = this.mRecommendGames.size();
        this.aIV.removeAllViews();
        if (size > 2) {
            size = 2;
        }
        for (int i = 0; i < size; i++) {
            GameInfoData gameInfoData = this.mRecommendGames.get(i);
            gameInfoData.setRefId("1000202");
            ae aeVar = new ae(this.aIs);
            aeVar.a(this.aIs.getUniqueId(), gameInfoData);
            aeVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            if (i == size - 1) {
                aeVar.setBottomLineVisible(false);
            }
            aeVar.setTag(com.baidu.tieba.v.tag_first, gameInfoData);
            aeVar.setTag(com.baidu.tieba.v.tag_second, Integer.valueOf(i + 1));
            aeVar.setOnClickListener(this.aJi);
            this.aIV.addView(aeVar);
        }
    }

    private void Hq() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.aIT).A(0).r(false);
        gVar.a(new bd(this));
        this.aHP = gVar.dA();
        this.aHP.c(this.aIs);
        this.mHandler.postDelayed(this.aHR, 3000L);
    }

    public CarouselRecommendView HI() {
        return this.aIR;
    }

    private void G(View view) {
        this.HT = view.findViewById(com.baidu.tieba.v.game_center_home_view);
        this.aoS = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aIT = view.findViewById(com.baidu.tieba.v.anchor);
        this.vl = (BdListView) view.findViewById(com.baidu.tieba.v.game_center_list);
        this.aJc = (RelativeLayout) view.findViewById(com.baidu.tieba.v.light_game_content_view);
        this.aIG = com.baidu.adp.lib.g.b.ek().a(this.aIs, com.baidu.tieba.w.game_center_header_below, null, false);
        this.aIR = (CarouselRecommendView) this.aIG.findViewById(com.baidu.tieba.v.carousel_view);
        this.aIR.setGameRefId("4000201");
        this.aIS = (LinearLayout) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_downloaded_part);
        this.aIV = (LinearLayout) this.aIG.findViewById(com.baidu.tieba.v.game_center_good_items);
        this.aIW = (RelativeLayout) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_good_title);
        this.aIY = (TextView) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_good_more);
        this.aIX = this.aIG.findViewById(com.baidu.tieba.v.game_center_header_good_line);
        this.aIH = (TextView) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_download_num);
        this.aII = (TextView) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_undownload_num);
        this.aIJ = this.aIG.findViewById(com.baidu.tieba.v.game_center_header_download_line);
        this.aIK = this.aIG.findViewById(com.baidu.tieba.v.game_center_header_undownload_line);
        this.aIL = (TextView) this.aIG.findViewById(com.baidu.tieba.v.waiting);
        this.aIM = (LinearLayout) this.aIG.findViewById(com.baidu.tieba.v.game_center_header_horizontal_view);
        this.vl.addHeaderView(this.aIG);
        this.vl.setOnScrollListener(new be(this));
        this.vl.setAdapter((ListAdapter) this.aIQ);
        this.vl.setOnSrollToBottomListener(this.aJb);
        this.vl.setOnItemClickListener(this.aJg);
    }

    public RelativeLayout HJ() {
        return this.aJc;
    }

    private void F(View view) {
        this.aIs.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aIs.getLayoutMode().h(view);
    }
}
