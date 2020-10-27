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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class c {
    private int eLh;
    private a juA;
    private b juB;
    private com.baidu.tieba.homepage.gamevideo.view.b juy;
    private com.baidu.tieba.homepage.gamevideo.d.b juz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener ikd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.juy != null) {
                c.this.juy.cHL();
            }
        }
    };
    private NEGFeedBackView.a juC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).aj("obj_type", c.this.eLh).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
            int i = 0;
            if (arrayList != null && arVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (arVar.threadType == 0) {
                    i = 1;
                } else if (arVar.threadType == 40) {
                    i = 2;
                } else if (arVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.juy != null) {
                    c.this.juy.Lz();
                }
                TiebaStatic.log(new aq("c13500").dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener juD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.juy.cHT()) {
                c.this.juy.qN(true);
                if (c.this.juB.isShowing()) {
                    c.this.juB.cHy();
                    c.this.juy.cHS();
                    ap.setBackgroundResource(c.this.juy.cHQ(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.juB.cG(c.this.juy.cHQ());
                c.this.juy.cHR();
                ap.setBackgroundResource(c.this.juy.cHQ(), R.color.cp_bg_line_d);
                if (c.this.juz != null && !y.isEmpty(c.this.juz.cHF())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c geE = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.juz.Bu(c.this.eLh);
                c.this.cHD();
                c.this.juy.qM(false);
                return;
            }
            c.this.juy.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e juE = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.juy.bMx();
            c.this.juz.Bv(c.this.eLh);
            c.this.cHD();
        }
    };
    private b.a juF = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.juy.hideLoadingView();
            c.this.juy.TK();
            if (z || z2) {
                c.this.juy.b((f.e) null);
            } else {
                c.this.juy.b(c.this.Bt(i));
            }
            if (!c.this.cHE()) {
                if (!y.isEmpty(c.this.juz.cHF()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.juy.qO(c.this.juB.isShowing());
                    c.this.juy.cHU();
                    c.this.juB.setData(c.this.juz.cHF());
                }
                if (i != 0) {
                    c.this.juy.bb(c.this.juz.getDataList());
                    c.this.juy.B(c.this.juG);
                } else if (y.isEmpty(c.this.juy.getDataList())) {
                    c.this.juy.showNoDataView();
                } else if (z) {
                    c.this.juy.bMw();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.juy.b((f.e) null);
            c.this.juy.hideLoadingView();
            c.this.juy.TK();
            if (y.isEmpty(c.this.juy.getDataList())) {
                c.this.juy.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.juy.B(c.this.juG);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener juG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.juy != null && c.this.juz != null) {
                c.this.juy.bMx();
                c.this.juz.Bv(c.this.eLh);
            }
        }
    };
    private b.a juH = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cHB() {
            c.this.juy.pw(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eLh = aVar.sub_class_id;
                c.this.Bs(aVar.sub_class_id);
                if (c.this.juy != null) {
                    c.this.juy.Bq(aVar.sub_class_id);
                    c.this.juy.qO(false);
                    c.this.juy.Lv(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cHC() {
            if (c.this.juy != null) {
                c.this.juy.qO(false);
                c.this.juy.pw(false);
            }
        }
    };
    private a.InterfaceC0726a jun = new a.InterfaceC0726a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0726a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eLh = aVar.sub_class_id;
                c.this.Bs(aVar.sub_class_id);
                if (c.this.juy != null) {
                    c.this.juy.Bq(aVar.sub_class_id);
                    c.this.juy.qO(false);
                    c.this.juy.Lv(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.juy = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.juC);
        this.juz = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.juF);
        this.juB = new b(tbPageContext, this.mBdUniqueId);
        this.juB.a(this.juH);
        this.juA = new a(tbPageContext, this.mBdUniqueId);
        this.juA.a(this.jun);
        this.juy.C(this.juD);
        this.eLh = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.juy.Bq(this.eLh);
    }

    public void init() {
        this.juz.registerListener();
        this.juy.init();
        this.juy.setListPullRefreshListener(this.geE);
        this.juy.a(this.juE);
        MessageManager.getInstance().registerListener(this.ikd);
    }

    public View getView() {
        if (this.juy != null) {
            return this.juy.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHD() {
        TiebaStatic.log(new aq("c13493").aj("obj_type", this.eLh));
    }

    public void loadData() {
        if (this.juy != null) {
            this.juy.cHO();
            this.juy.showLoadingView();
        }
        if (this.juz != null) {
            this.juz.Bu(this.eLh);
        }
    }

    public void Rd() {
        if (this.juy != null) {
            this.juy.cHK();
            this.juy.startPullRefresh();
            this.juy.qM(false);
            this.juy.cHM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs(int i) {
        if (this.juB != null) {
            this.juB.Br(i);
        }
        if (this.juz != null) {
            this.juz.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cHE() {
        if (this.juz == null || y.isEmpty(this.juz.cHF()) || (!(this.juz.cHG() || this.eLh == 0) || this.juA == null)) {
            return false;
        }
        this.juA.setData(this.juz.cHF());
        this.juA.bD((ViewGroup) this.juy.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bnH().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bnH().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Bt(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bqd() {
        if (this.juy != null) {
            this.juy.bqd();
        }
        if (this.juB != null) {
            this.juB.onChangeSkinType();
        }
        if (this.juA != null) {
            this.juA.onChangeSkinType();
        }
        if (this.juB.isShowing()) {
            ap.setBackgroundResource(this.juy.cHQ(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.juy.cHQ(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.juy != null) {
            this.juy.onPause();
            this.juy.cGf();
            this.juy.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.juy != null) {
            this.juy.setListPullRefreshListener(null);
            this.juy.a((BdListView.e) null);
            this.juy.onDestroy();
        }
        if (this.juB != null) {
            this.juB.onDestroy();
        }
        if (this.juA != null) {
            this.juA.onDestroy();
        }
        if (this.juz != null) {
            this.juz.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ikd);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").aj("obj_type", this.eLh));
            if (!this.juB.isShowing()) {
                this.juy.setViewForeground();
                return;
            }
            return;
        }
        if (this.juB != null) {
            this.juB.cHz();
        }
        this.juy.cGf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.juz != null && !y.isEmpty(this.juz.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.juz.Ky(optString);
            this.juz.Lu(optString);
            if (this.juy != null) {
                this.juy.Lw(optString);
            }
        }
    }
}
