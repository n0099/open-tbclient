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
import com.baidu.tbadk.core.util.TiebaStatic;
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
    private View HS;
    private LinearLayout aIF;
    private View aIG;
    private boolean aIH;
    private LinearLayout aII;
    private RelativeLayout aIJ;
    private View aIK;
    private TextView aIL;
    private com.baidu.adp.widget.ListView.aa aIO;
    private RelativeLayout aIP;
    private GameCenterActivity aIg;
    private View aIt;
    private TextView aIu;
    private TextView aIv;
    private View aIw;
    private View aIx;
    private TextView aIy;
    private LinearLayout aIz;
    private NoNetworkView aoJ;
    private BdListView vl;
    private CarouselRecommendView aIE = null;
    private Handler mHandler = new Handler();
    private com.baidu.adp.lib.guide.d aHF = null;
    private Set<String> aIM = new HashSet();
    private boolean aIN = false;
    private com.baidu.tieba.game.view.c aIQ = new aw(this);
    private com.baidu.tieba.game.view.d aIR = new ax(this);
    private View.OnClickListener aIS = new ay(this);
    private AdapterView.OnItemClickListener aIT = new az(this);
    private View.OnClickListener aIU = new ba(this);
    private View.OnClickListener aIV = new bb(this);
    private Runnable aHH = new bc(this);
    private List<GameInfoData> aIA = new LinkedList();
    private List<GameInfoData> aIB = new LinkedList();
    private List<GameInfoData> mRecommendGames = new LinkedList();
    private List<AdList> aIC = new LinkedList();
    private be aID = new be(this, null);

    public void cn(boolean z) {
        this.aIN = z;
    }

    public View Hx() {
        return this.vl;
    }

    public List<GameInfoData> Hy() {
        return this.aIA;
    }

    public List<GameInfoData> Hz() {
        return this.aIB;
    }

    public void onChangeSkinType(int i) {
        if (this.aoJ != null) {
            this.aoJ.onChangeSkinType(i);
        }
        this.aIg.getLayoutMode().L(i == 1);
        this.aIg.getLayoutMode().h(this.HS);
        this.aIg.getLayoutMode().h(this.aIt);
        if (this.aIE != null) {
            this.aIE.onChangeSkinType(i);
        }
    }

    public void HA() {
        if (this.aIA != null && this.aIA.size() != 0) {
            for (GameInfoData gameInfoData : this.aIA) {
                if (ab.Hs().b(gameInfoData)) {
                    Ho();
                    return;
                }
            }
        }
    }

    public void HB() {
        HD();
        HE();
        if (this.aID != null) {
            this.aID.notifyDataSetChanged();
        }
    }

    public void onPause() {
        if (this.aIE != null) {
            this.aIE.stopMarqueen();
        }
    }

    private void HC() {
        HashSet hashSet = new HashSet();
        if (this.aIC != null && this.aIC.size() > 0) {
            Iterator<AdList> it = this.aIC.iterator();
            while (it.hasNext()) {
                AdList next = it.next();
                if (TextUtils.isEmpty(next.img_url) || TextUtils.isEmpty(next.link_url)) {
                    it.remove();
                }
            }
            Iterator<AdList> it2 = this.aIC.iterator();
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
        if (this.aIB != null && this.aIB.size() > 0) {
            Iterator<GameInfoData> it4 = this.aIB.iterator();
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
        if (this.aIA != null && this.aIA.size() > 0) {
            HashSet hashSet4 = new HashSet();
            if (!this.aIN) {
                this.aIM.clear();
            }
            Iterator<GameInfoData> it6 = this.aIA.iterator();
            while (it6.hasNext()) {
                String gameId2 = it6.next().getGameId();
                this.aIM.add(gameId2);
                if (!hashSet4.add(gameId2)) {
                    it6.remove();
                }
            }
            Iterator<GameInfoData> it7 = this.aIB.iterator();
            while (it7.hasNext()) {
                if (this.aIM.add(it7.next().getGameId())) {
                    it7.remove();
                }
            }
            Iterator<GameInfoData> it8 = this.aIA.iterator();
            while (it8.hasNext()) {
                if (!hashSet.add(it8.next().getGameId())) {
                    it8.remove();
                }
            }
        } else if (this.aIB != null) {
            this.aIB.clear();
        }
    }

    public void a(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4) {
        a(list, list2, list3, list4, false);
    }

    public void b(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4) {
        a(list, list2, list3, list4, true);
    }

    private void a(List<AdList> list, List<GameInfoData> list2, List<GameInfoData> list3, List<GameInfoData> list4, boolean z) {
        if (this.aIH) {
            this.aIC.clear();
            this.aIA.clear();
            if (this.aIB != null) {
                this.aIB.clear();
            }
            this.mRecommendGames.clear();
        }
        if (list != null) {
            this.aIC.addAll(list);
        }
        if (list2 != null) {
            this.aIA.addAll(list2);
        }
        if (list4 != null) {
            this.aIB.addAll(list4);
        }
        if (list3 != null) {
            this.mRecommendGames.addAll(list3);
        }
        if ((this.aIB == null || this.aIB.size() == 0) && ((this.aIA == null || this.aIA.size() == 0) && (this.aIC == null || this.aIC.size() == 0))) {
            this.vl.setVisibility(8);
            return;
        }
        this.vl.setVisibility(0);
        this.aIw.setVisibility(0);
        this.aIx.setVisibility(0);
        this.aIE.getViewPagerBottomLine().setVisibility(0);
        HC();
        this.aIH = z;
        if (this.aIC.size() >= 1) {
            this.aIE.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            int size = this.aIC.size() > 5 ? 5 : this.aIC.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.square.ak akVar = new com.baidu.tieba.square.ak();
                akVar.hu(this.aIC.get(i).img_url);
                akVar.setLink(this.aIC.get(i).link_url);
                arrayList.add(akVar);
            }
            this.aIE.setData(arrayList);
        } else {
            this.aIE.getViewPagerBottomLine().setVisibility(8);
            this.aIE.setData(null);
        }
        HD();
        HE();
        this.aID.notifyDataSetChanged();
    }

    public av(GameCenterActivity gameCenterActivity, View view, com.baidu.adp.widget.ListView.aa aaVar) {
        this.aIg = gameCenterActivity;
        this.aIO = aaVar;
        G(view);
    }

    private void HD() {
        String string = this.aIg.getResources().getString(com.baidu.tieba.y.game_center_undownload_num);
        if (this.aIA == null || this.aIA.size() == 0) {
            if (this.aIB.size() != 0) {
                this.aIv.setText(String.format(string, 0));
                this.aIy.setVisibility(0);
                this.aIx.setVisibility(0);
            }
        } else {
            this.aIy.setVisibility(8);
            this.aIx.setVisibility(0);
            this.aIv.setText(String.format(string, Integer.valueOf(this.aIA.size())));
        }
        if (this.aIB == null || this.aIB.size() == 0) {
            this.aIF.setVisibility(8);
            return;
        }
        this.aIF.setVisibility(0);
        this.aIu.setText(String.format(this.aIg.getResources().getString(com.baidu.tieba.y.game_center_download_num), Integer.valueOf(this.aIB.size())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.adp.lib.util.m.c(this.aIg, com.baidu.tieba.t.ds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.m.c(this.aIg, com.baidu.tieba.t.ds30);
        this.aIz.removeAllViews();
        for (int i = 0; i < this.aIB.size(); i++) {
            View a = com.baidu.adp.lib.g.b.ek().a(this.aIg, com.baidu.tieba.w.game_center_downloaded_item, null, false);
            TbImageView tbImageView = (TbImageView) a.findViewById(com.baidu.tieba.v.game_center_downloaded_image);
            TextView textView = (TextView) a.findViewById(com.baidu.tieba.v.game_center_downloaded_game_name);
            tbImageView.c(this.aIB.get(i).getIconUrl(), 10, false);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(com.baidu.adp.lib.util.m.c(this.aIg, com.baidu.tieba.t.ds26));
            String gameName = this.aIB.get(i).getGameName();
            if (com.baidu.tieba.game.a.g.fy(gameName) > 14) {
                gameName = String.valueOf(com.baidu.tieba.game.a.g.g(gameName, 0, 14)) + "...";
            }
            textView.setText(gameName);
            a.setTag(Integer.valueOf(i));
            a.setOnClickListener(this.aIU);
            F(a);
            this.aIz.addView(a, layoutParams);
        }
    }

    private void HE() {
        if (this.mRecommendGames.size() == 0) {
            this.aII.setVisibility(8);
            this.aIJ.setVisibility(8);
            this.aIK.setVisibility(8);
            return;
        }
        this.aII.setVisibility(0);
        this.aIJ.setVisibility(0);
        this.aIK.setVisibility(0);
        this.aIL.setOnClickListener(this.aIS);
        int size = this.mRecommendGames.size();
        this.aII.removeAllViews();
        if (size > 2) {
            size = 2;
        }
        for (int i = 0; i < size; i++) {
            GameInfoData gameInfoData = this.mRecommendGames.get(i);
            ae aeVar = new ae(this.aIg);
            aeVar.setData(gameInfoData);
            aeVar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            if (i == size - 1) {
                aeVar.setBottomLineVisible(false);
            }
            aeVar.setTag(com.baidu.tieba.v.tag_first, gameInfoData);
            aeVar.setTag(com.baidu.tieba.v.tag_second, Integer.valueOf(i + 1));
            aeVar.setOnClickListener(this.aIV);
            TiebaStatic.eventStat(this.aIg, "gcenter_recom_" + (i + 1), "visit", 1, gameInfoData.getGameId());
            this.aII.addView(aeVar);
        }
    }

    private void Ho() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.aIG).A(0).r(false);
        gVar.a(new bd(this));
        this.aHF = gVar.dA();
        this.aHF.c(this.aIg);
        this.mHandler.postDelayed(this.aHH, 3000L);
    }

    private void G(View view) {
        this.HS = view.findViewById(com.baidu.tieba.v.game_center_home_view);
        this.aoJ = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aIG = view.findViewById(com.baidu.tieba.v.anchor);
        this.vl = (BdListView) view.findViewById(com.baidu.tieba.v.game_center_list);
        this.aIP = (RelativeLayout) view.findViewById(com.baidu.tieba.v.light_game_content_view);
        this.aIt = com.baidu.adp.lib.g.b.ek().a(this.aIg, com.baidu.tieba.w.game_center_header_below, null, false);
        this.aIE = (CarouselRecommendView) this.aIt.findViewById(com.baidu.tieba.v.carousel_view);
        this.aIE.setGameRefId("4000201");
        this.aIF = (LinearLayout) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_downloaded_part);
        this.aII = (LinearLayout) this.aIt.findViewById(com.baidu.tieba.v.game_center_good_items);
        this.aIJ = (RelativeLayout) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_good_title);
        this.aIL = (TextView) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_good_more);
        this.aIK = this.aIt.findViewById(com.baidu.tieba.v.game_center_header_good_line);
        this.aIu = (TextView) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_download_num);
        this.aIv = (TextView) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_undownload_num);
        this.aIw = this.aIt.findViewById(com.baidu.tieba.v.game_center_header_download_line);
        this.aIx = this.aIt.findViewById(com.baidu.tieba.v.game_center_header_undownload_line);
        this.aIy = (TextView) this.aIt.findViewById(com.baidu.tieba.v.waiting);
        this.aIz = (LinearLayout) this.aIt.findViewById(com.baidu.tieba.v.game_center_header_horizontal_view);
        this.vl.addHeaderView(this.aIt);
        this.vl.setAdapter((ListAdapter) this.aID);
        this.vl.setOnSrollToBottomListener(this.aIO);
        this.vl.setOnItemClickListener(this.aIT);
    }

    public RelativeLayout HF() {
        return this.aIP;
    }

    private void F(View view) {
        this.aIg.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aIg.getLayoutMode().h(view);
    }
}
