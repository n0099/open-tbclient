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
/* loaded from: classes16.dex */
public class c {
    private int eoj;
    private b iKA;
    private com.baidu.tieba.homepage.gamevideo.view.b iKx;
    private com.baidu.tieba.homepage.gamevideo.d.b iKy;
    private a iKz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hBG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iKx != null) {
                c.this.iKx.cxp();
            }
        }
    };
    private NEGFeedBackView.a iKB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dD("obj_locate", "1").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).ai("obj_type", c.this.eoj).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.iKx != null) {
                    c.this.iKx.Jw();
                }
                TiebaStatic.log(new aq("c13500").dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iKC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iKx.cxx()) {
                c.this.iKx.pH(true);
                if (c.this.iKA.isShowing()) {
                    c.this.iKA.cxc();
                    c.this.iKx.cxw();
                    ap.setBackgroundResource(c.this.iKx.cxu(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iKA.cp(c.this.iKx.cxu());
                c.this.iKx.cxv();
                ap.setBackgroundResource(c.this.iKx.cxu(), R.color.cp_bg_line_d);
                if (c.this.iKy != null && !y.isEmpty(c.this.iKy.cxj())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fFd = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iKy.zU(c.this.eoj);
                c.this.cxh();
                c.this.iKx.pG(false);
                return;
            }
            c.this.iKx.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iKD = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iKx.bFT();
            c.this.iKy.zV(c.this.eoj);
            c.this.cxh();
        }
    };
    private b.a iKE = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.iKx.hideLoadingView();
            c.this.iKx.bFX();
            if (z || z2) {
                c.this.iKx.b((f.e) null);
            } else {
                c.this.iKx.b(c.this.zT(i));
            }
            if (!c.this.cxi()) {
                if (!y.isEmpty(c.this.iKy.cxj()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iKx.pI(c.this.iKA.isShowing());
                    c.this.iKx.cxy();
                    c.this.iKA.setData(c.this.iKy.cxj());
                }
                if (i != 0) {
                    c.this.iKx.aK(c.this.iKy.getDataList());
                    c.this.iKx.B(c.this.iKF);
                } else if (y.isEmpty(c.this.iKx.getDataList())) {
                    c.this.iKx.showNoDataView();
                } else if (z) {
                    c.this.iKx.bFS();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.iKx.b((f.e) null);
            c.this.iKx.hideLoadingView();
            c.this.iKx.bFX();
            if (y.isEmpty(c.this.iKx.getDataList())) {
                c.this.iKx.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iKx.B(c.this.iKF);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iKF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iKx != null && c.this.iKy != null) {
                c.this.iKx.bFT();
                c.this.iKy.zV(c.this.eoj);
            }
        }
    };
    private b.a iKG = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cxf() {
            c.this.iKx.ot(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eoj = aVar.sub_class_id;
                c.this.zS(aVar.sub_class_id);
                if (c.this.iKx != null) {
                    c.this.iKx.zQ(aVar.sub_class_id);
                    c.this.iKx.pI(false);
                    c.this.iKx.JG(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cxg() {
            if (c.this.iKx != null) {
                c.this.iKx.pI(false);
                c.this.iKx.ot(false);
            }
        }
    };
    private a.InterfaceC0695a iKm = new a.InterfaceC0695a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0695a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eoj = aVar.sub_class_id;
                c.this.zS(aVar.sub_class_id);
                if (c.this.iKx != null) {
                    c.this.iKx.zQ(aVar.sub_class_id);
                    c.this.iKx.pI(false);
                    c.this.iKx.JG(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKx = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iKB);
        this.iKy = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iKE);
        this.iKA = new b(tbPageContext, this.mBdUniqueId);
        this.iKA.a(this.iKG);
        this.iKz = new a(tbPageContext, this.mBdUniqueId);
        this.iKz.a(this.iKm);
        this.iKx.C(this.iKC);
        this.eoj = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iKx.zQ(this.eoj);
    }

    public void init() {
        this.iKy.registerListener();
        this.iKx.init();
        this.iKx.setListPullRefreshListener(this.fFd);
        this.iKx.a(this.iKD);
        MessageManager.getInstance().registerListener(this.hBG);
    }

    public View getView() {
        if (this.iKx != null) {
            return this.iKx.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxh() {
        TiebaStatic.log(new aq("c13493").ai("obj_type", this.eoj));
    }

    public void loadData() {
        if (this.iKx != null) {
            this.iKx.cxs();
            this.iKx.showLoadingView();
        }
        if (this.iKy != null) {
            this.iKy.zU(this.eoj);
        }
    }

    public void OA() {
        if (this.iKx != null) {
            this.iKx.cxo();
            this.iKx.startPullRefresh();
            this.iKx.pG(false);
            this.iKx.cxq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        if (this.iKA != null) {
            this.iKA.zR(i);
        }
        if (this.iKy != null) {
            this.iKy.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxi() {
        if (this.iKy == null || y.isEmpty(this.iKy.cxj()) || (!(this.iKy.cxk() || this.eoj == 0) || this.iKz == null)) {
            return false;
        }
        this.iKz.setData(this.iKy.cxj());
        this.iKz.bA((ViewGroup) this.iKx.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bik().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bik().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e zT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bkF() {
        if (this.iKx != null) {
            this.iKx.bkF();
        }
        if (this.iKA != null) {
            this.iKA.onChangeSkinType();
        }
        if (this.iKz != null) {
            this.iKz.onChangeSkinType();
        }
        if (this.iKA.isShowing()) {
            ap.setBackgroundResource(this.iKx.cxu(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.iKx.cxu(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iKx != null) {
            this.iKx.onPause();
            this.iKx.cwh();
            this.iKx.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iKx != null) {
            this.iKx.setListPullRefreshListener(null);
            this.iKx.a((BdListView.e) null);
            this.iKx.onDestroy();
        }
        if (this.iKA != null) {
            this.iKA.onDestroy();
        }
        if (this.iKz != null) {
            this.iKz.onDestroy();
        }
        if (this.iKy != null) {
            this.iKy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hBG);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").ai("obj_type", this.eoj));
            if (!this.iKA.isShowing()) {
                this.iKx.setViewForeground();
                return;
            }
            return;
        }
        if (this.iKA != null) {
            this.iKA.cxd();
        }
        this.iKx.cwh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iKy != null && !y.isEmpty(this.iKy.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iKy.IO(optString);
            this.iKy.JF(optString);
            if (this.iKx != null) {
                this.iKx.JH(optString);
            }
        }
    }
}
