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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private int ddQ;
    private com.baidu.tieba.homepage.gamevideo.view.b hcp;
    private com.baidu.tieba.homepage.gamevideo.d.b hcq;
    private a hcr;
    private b hcs;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gIJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.hcp != null) {
                c.this.hcp.bOD();
            }
        }
    };
    private NEGFeedBackView.a hct = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cx("obj_locate", "1").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).X("obj_type", c.this.ddQ).cx("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            int i = 0;
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (alVar.threadType == 0) {
                    i = 1;
                } else if (alVar.threadType == 40) {
                    i = 2;
                } else if (alVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.hcp != null) {
                    c.this.hcp.wS();
                }
                TiebaStatic.log(new an("c13500").cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", alVar.getFid()).cx("obj_param1", alVar.weight).cx("obj_source", alVar.source).cx("obj_id", alVar.extra).cx("obj_type", sb.toString()).cx("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener hcu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.hcp.bOL()) {
                c.this.hcp.mK(true);
                if (c.this.hcs.isShowing()) {
                    c.this.hcs.bOq();
                    c.this.hcp.bOK();
                    am.setBackgroundResource(c.this.hcp.bOI(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.hcs.bY(c.this.hcp.bOI());
                c.this.hcp.bOJ();
                am.setBackgroundResource(c.this.hcp.bOI(), R.color.cp_bg_line_d);
                if (c.this.hcq != null && !v.isEmpty(c.this.hcq.bOx())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c emN = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.hcq.vw(c.this.ddQ);
                c.this.bOv();
                c.this.hcp.mJ(false);
                return;
            }
            c.this.hcp.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e hcv = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.hcp.bcz();
            c.this.hcq.vx(c.this.ddQ);
            c.this.bOv();
        }
    };
    private b.a hcw = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.hcp.hideLoadingView();
            c.this.hcp.bcC();
            if (z || z2) {
                c.this.hcp.b((g.e) null);
            } else {
                c.this.hcp.b(c.this.vv(i));
            }
            if (!c.this.bOw()) {
                if (!v.isEmpty(c.this.hcq.bOx()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.hcp.mL(c.this.hcs.isShowing());
                    c.this.hcp.bOM();
                    c.this.hcs.setData(c.this.hcq.bOx());
                }
                if (i != 0) {
                    c.this.hcp.av(c.this.hcq.getDataList());
                    c.this.hcp.z(c.this.hcx);
                } else if (v.isEmpty(c.this.hcp.getDataList())) {
                    c.this.hcp.showNoDataView();
                } else if (z) {
                    c.this.hcp.bcy();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.hcp.b((g.e) null);
            c.this.hcp.hideLoadingView();
            c.this.hcp.bcC();
            if (v.isEmpty(c.this.hcp.getDataList())) {
                c.this.hcp.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.hcp.z(c.this.hcx);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hcx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hcp != null && c.this.hcq != null) {
                c.this.hcp.bcz();
                c.this.hcq.vx(c.this.ddQ);
            }
        }
    };
    private b.a hcy = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOt() {
            c.this.hcp.lz(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddQ = aVar.sub_class_id;
                c.this.vu(aVar.sub_class_id);
                if (c.this.hcp != null) {
                    c.this.hcp.vs(aVar.sub_class_id);
                    c.this.hcp.mL(false);
                    c.this.hcp.Ci(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOu() {
            if (c.this.hcp != null) {
                c.this.hcp.mL(false);
                c.this.hcp.lz(false);
            }
        }
    };
    private a.InterfaceC0517a hce = new a.InterfaceC0517a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0517a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddQ = aVar.sub_class_id;
                c.this.vu(aVar.sub_class_id);
                if (c.this.hcp != null) {
                    c.this.hcp.vs(aVar.sub_class_id);
                    c.this.hcp.mL(false);
                    c.this.hcp.Ci(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hcp = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.hct);
        this.hcq = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hcw);
        this.hcs = new b(tbPageContext, this.mBdUniqueId);
        this.hcs.a(this.hcy);
        this.hcr = new a(tbPageContext, this.mBdUniqueId);
        this.hcr.a(this.hce);
        this.hcp.A(this.hcu);
        this.ddQ = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.hcp.vs(this.ddQ);
    }

    public void init() {
        this.hcq.registerListener();
        this.hcp.init();
        this.hcp.setListPullRefreshListener(this.emN);
        this.hcp.a(this.hcv);
        MessageManager.getInstance().registerListener(this.gIJ);
    }

    public View getView() {
        if (this.hcp != null) {
            return this.hcp.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOv() {
        TiebaStatic.log(new an("c13493").X("obj_type", this.ddQ));
    }

    public void loadData() {
        if (this.hcp != null) {
            this.hcp.bOG();
            this.hcp.showLoadingView();
        }
        if (this.hcq != null) {
            this.hcq.vw(this.ddQ);
        }
    }

    public void AJ() {
        if (this.hcp != null) {
            this.hcp.bOC();
            this.hcp.startPullRefresh();
            this.hcp.mJ(false);
            this.hcp.bOE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.hcs != null) {
            this.hcs.vt(i);
        }
        if (this.hcq != null) {
            this.hcq.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOw() {
        if (this.hcq == null || v.isEmpty(this.hcq.bOx()) || (!(this.hcq.bOy() || this.ddQ == 0) || this.hcr == null)) {
            return false;
        }
        this.hcr.setData(this.hcq.bOx());
        this.hcr.bk((ViewGroup) this.hcp.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aFH().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aFH().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vv(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aHS() {
        if (this.hcp != null) {
            this.hcp.aHS();
        }
        if (this.hcs != null) {
            this.hcs.onChangeSkinType();
        }
        if (this.hcr != null) {
            this.hcr.onChangeSkinType();
        }
        if (this.hcs.isShowing()) {
            am.setBackgroundResource(this.hcp.bOI(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.hcp.bOI(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.hcp != null) {
            this.hcp.onPause();
            this.hcp.bNu();
            this.hcp.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hcp != null) {
            this.hcp.setListPullRefreshListener(null);
            this.hcp.a((BdListView.e) null);
            this.hcp.onDestroy();
        }
        if (this.hcs != null) {
            this.hcs.onDestroy();
        }
        if (this.hcr != null) {
            this.hcr.onDestroy();
        }
        if (this.hcq != null) {
            this.hcq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gIJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").X("obj_type", this.ddQ));
            if (!this.hcs.isShowing()) {
                this.hcp.setViewForeground();
                return;
            }
            return;
        }
        if (this.hcs != null) {
            this.hcs.bOr();
        }
        this.hcp.bNu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hcq != null && !v.isEmpty(this.hcq.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hcq.BC(optString);
            this.hcq.Ch(optString);
            if (this.hcp != null) {
                this.hcp.Cj(optString);
            }
        }
    }
}
