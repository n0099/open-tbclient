package com.baidu.tieba.homepage.gamevideo.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int cmL;
    private com.baidu.tieba.homepage.gamevideo.view.b giU;
    private com.baidu.tieba.homepage.gamevideo.d.b giV;
    private a giW;
    private b giX;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener fON = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.giU != null) {
                c.this.giU.buq();
            }
        }
    };
    private NEGFeedBackView.a giY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                TiebaStatic.log(new an("c13500").bS("obj_locate", "1").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).O("obj_type", c.this.cmL).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
            int i = 0;
            if (arrayList != null && ajVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (ajVar.threadType == 0) {
                    i = 1;
                } else if (ajVar.threadType == 40) {
                    i = 2;
                } else if (ajVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.giU != null) {
                    c.this.giU.sY();
                }
                TiebaStatic.log(new an("c13500").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener giZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.giU.buy()) {
                c.this.giU.le(true);
                if (c.this.giX.isShowing()) {
                    c.this.giX.bud();
                    c.this.giU.bux();
                    am.setBackgroundResource(c.this.giU.buv(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.giX.bY(c.this.giU.buv());
                c.this.giU.buw();
                am.setBackgroundResource(c.this.giU.buv(), R.color.cp_bg_line_d);
                if (c.this.giV != null && !v.isEmpty(c.this.giV.buk())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private h.c dwV = new h.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.giV.tc(c.this.cmL);
                c.this.bui();
                c.this.giU.ld(false);
                return;
            }
            c.this.giU.b((h.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e gja = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.giU.aJl();
            c.this.giV.td(c.this.cmL);
            c.this.bui();
        }
    };
    private b.a gjb = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void d(int i, boolean z, boolean z2) {
            c.this.giU.hideLoadingView();
            c.this.giU.aJo();
            if (z || z2) {
                c.this.giU.b((h.e) null);
            } else {
                c.this.giU.b(c.this.tb(i));
            }
            if (!c.this.buj()) {
                if (!v.isEmpty(c.this.giV.buk()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.alR().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.giU.lf(c.this.giX.isShowing());
                    c.this.giU.buz();
                    c.this.giX.setData(c.this.giV.buk());
                }
                if (i != 0) {
                    c.this.giU.aq(c.this.giV.getDataList());
                    c.this.giU.y(c.this.gjc);
                } else if (v.isEmpty(c.this.giU.getDataList())) {
                    c.this.giU.showNoDataView();
                } else if (z) {
                    c.this.giU.aJk();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void i(int i, String str, boolean z) {
            c.this.giU.b((h.e) null);
            c.this.giU.hideLoadingView();
            c.this.giU.aJo();
            if (v.isEmpty(c.this.giU.getDataList())) {
                c.this.giU.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.giU.y(c.this.gjc);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener gjc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.giU != null && c.this.giV != null) {
                c.this.giU.aJl();
                c.this.giV.td(c.this.cmL);
            }
        }
    };
    private b.a gjd = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bug() {
            c.this.giU.jT(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cmL = aVar.sub_class_id;
                c.this.ta(aVar.sub_class_id);
                if (c.this.giU != null) {
                    c.this.giU.sY(aVar.sub_class_id);
                    c.this.giU.lf(false);
                    c.this.giU.wY(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void buh() {
            if (c.this.giU != null) {
                c.this.giU.lf(false);
                c.this.giU.jT(false);
            }
        }
    };
    private a.InterfaceC0425a giI = new a.InterfaceC0425a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0425a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cmL = aVar.sub_class_id;
                c.this.ta(aVar.sub_class_id);
                if (c.this.giU != null) {
                    c.this.giU.sY(aVar.sub_class_id);
                    c.this.giU.lf(false);
                    c.this.giU.wY(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.giU = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.giY);
        this.giV = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.gjb);
        this.giX = new b(tbPageContext, this.mBdUniqueId);
        this.giX.a(this.gjd);
        this.giW = new a(tbPageContext, this.mBdUniqueId);
        this.giW.a(this.giI);
        this.giU.z(this.giZ);
        this.cmL = com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.giU.sY(this.cmL);
    }

    public void init() {
        this.giV.registerListener();
        this.giU.init();
        this.giU.setListPullRefreshListener(this.dwV);
        this.giU.a(this.gja);
        MessageManager.getInstance().registerListener(this.fON);
    }

    public View getView() {
        if (this.giU != null) {
            return this.giU.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bui() {
        TiebaStatic.log(new an("c13493").O("obj_type", this.cmL));
    }

    public void loadData() {
        if (this.giU != null) {
            this.giU.but();
            this.giU.showLoadingView();
        }
        if (this.giV != null) {
            this.giV.tc(this.cmL);
        }
    }

    public void vU() {
        if (this.giU != null) {
            this.giU.bup();
            this.giU.startPullRefresh();
            this.giU.ld(false);
            this.giU.bur();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(int i) {
        if (this.giX != null) {
            this.giX.sZ(i);
        }
        if (this.giV != null) {
            this.giV.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buj() {
        if (this.giV == null || v.isEmpty(this.giV.buk()) || (!(this.giV.bul() || this.cmL == 0) || this.giW == null)) {
            return false;
        }
        this.giW.setData(this.giV.buk());
        this.giW.bj((ViewGroup) this.giU.getRootView());
        com.baidu.tbadk.core.sharedPref.b.alR().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.alR().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.e tb(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new h.e(string, 1000);
    }

    public void anO() {
        if (this.giU != null) {
            this.giU.anO();
        }
        if (this.giX != null) {
            this.giX.onChangeSkinType();
        }
        if (this.giW != null) {
            this.giW.onChangeSkinType();
        }
        if (this.giX.isShowing()) {
            am.setBackgroundResource(this.giU.buv(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.giU.buv(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.giU != null) {
            this.giU.onPause();
            this.giU.bsZ();
            this.giU.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.giU != null) {
            this.giU.setListPullRefreshListener(null);
            this.giU.a((BdListView.e) null);
            this.giU.onDestroy();
        }
        if (this.giX != null) {
            this.giX.onDestroy();
        }
        if (this.giW != null) {
            this.giW.onDestroy();
        }
        if (this.giV != null) {
            this.giV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fON);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").O("obj_type", this.cmL));
            if (!this.giX.isShowing()) {
                this.giU.setViewForeground();
                return;
            }
            return;
        }
        if (this.giX != null) {
            this.giX.bue();
        }
        this.giU.bsZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.giV != null && !v.isEmpty(this.giV.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.giV.wm(optString);
            this.giV.wX(optString);
            if (this.giU != null) {
                this.giU.wZ(optString);
            }
        }
    }
}
