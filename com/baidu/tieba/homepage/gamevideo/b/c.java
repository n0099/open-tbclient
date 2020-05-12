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
    private int dDt;
    private com.baidu.tieba.homepage.gamevideo.view.b hMl;
    private com.baidu.tieba.homepage.gamevideo.d.b hMm;
    private a hMn;
    private b hMo;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.hMl != null) {
                c.this.hMl.bZd();
            }
        }
    };
    private NEGFeedBackView.a hMp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cI("obj_locate", "1").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).af("obj_type", c.this.dDt).cI("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.hMl != null) {
                    c.this.hMl.BC();
                }
                TiebaStatic.log(new an("c13500").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener hMq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.hMl.bZl()) {
                c.this.hMl.nO(true);
                if (c.this.hMo.isShowing()) {
                    c.this.hMo.bYQ();
                    c.this.hMl.bZk();
                    am.setBackgroundResource(c.this.hMl.bZi(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.hMo.cg(c.this.hMl.bZi());
                c.this.hMl.bZj();
                am.setBackgroundResource(c.this.hMl.bZi(), R.color.cp_bg_line_d);
                if (c.this.hMm != null && !v.isEmpty(c.this.hMm.bYX())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c eQs = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.hMm.vU(c.this.dDt);
                c.this.bYV();
                c.this.hMl.nN(false);
                return;
            }
            c.this.hMl.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e hMr = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.hMl.blo();
            c.this.hMm.vV(c.this.dDt);
            c.this.bYV();
        }
    };
    private b.a hMs = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.hMl.hideLoadingView();
            c.this.hMl.blr();
            if (z || z2) {
                c.this.hMl.b((g.e) null);
            } else {
                c.this.hMl.b(c.this.vT(i));
            }
            if (!c.this.bYW()) {
                if (!v.isEmpty(c.this.hMm.bYX()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.hMl.nP(c.this.hMo.isShowing());
                    c.this.hMl.bZm();
                    c.this.hMo.setData(c.this.hMm.bYX());
                }
                if (i != 0) {
                    c.this.hMl.aE(c.this.hMm.getDataList());
                    c.this.hMl.A(c.this.hMt);
                } else if (v.isEmpty(c.this.hMl.getDataList())) {
                    c.this.hMl.showNoDataView();
                } else if (z) {
                    c.this.hMl.bln();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.hMl.b((g.e) null);
            c.this.hMl.hideLoadingView();
            c.this.hMl.blr();
            if (v.isEmpty(c.this.hMl.getDataList())) {
                c.this.hMl.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.hMl.A(c.this.hMt);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hMt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hMl != null && c.this.hMm != null) {
                c.this.hMl.blo();
                c.this.hMm.vV(c.this.dDt);
            }
        }
    };
    private b.a hMu = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bYT() {
            c.this.hMl.mC(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dDt = aVar.sub_class_id;
                c.this.vS(aVar.sub_class_id);
                if (c.this.hMl != null) {
                    c.this.hMl.vQ(aVar.sub_class_id);
                    c.this.hMl.nP(false);
                    c.this.hMl.DT(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bYU() {
            if (c.this.hMl != null) {
                c.this.hMl.nP(false);
                c.this.hMl.mC(false);
            }
        }
    };
    private a.InterfaceC0575a hMa = new a.InterfaceC0575a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0575a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dDt = aVar.sub_class_id;
                c.this.vS(aVar.sub_class_id);
                if (c.this.hMl != null) {
                    c.this.hMl.vQ(aVar.sub_class_id);
                    c.this.hMl.nP(false);
                    c.this.hMl.DT(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMl = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.hMp);
        this.hMm = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hMs);
        this.hMo = new b(tbPageContext, this.mBdUniqueId);
        this.hMo.a(this.hMu);
        this.hMn = new a(tbPageContext, this.mBdUniqueId);
        this.hMn.a(this.hMa);
        this.hMl.B(this.hMq);
        this.dDt = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.hMl.vQ(this.dDt);
    }

    public void init() {
        this.hMm.registerListener();
        this.hMl.init();
        this.hMl.setListPullRefreshListener(this.eQs);
        this.hMl.a(this.hMr);
        MessageManager.getInstance().registerListener(this.gHs);
    }

    public View getView() {
        if (this.hMl != null) {
            return this.hMl.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYV() {
        TiebaStatic.log(new an("c13493").af("obj_type", this.dDt));
    }

    public void loadData() {
        if (this.hMl != null) {
            this.hMl.bZg();
            this.hMl.showLoadingView();
        }
        if (this.hMm != null) {
            this.hMm.vU(this.dDt);
        }
    }

    public void FG() {
        if (this.hMl != null) {
            this.hMl.bZc();
            this.hMl.startPullRefresh();
            this.hMl.nN(false);
            this.hMl.bZe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        if (this.hMo != null) {
            this.hMo.vR(i);
        }
        if (this.hMm != null) {
            this.hMm.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYW() {
        if (this.hMm == null || v.isEmpty(this.hMm.bYX()) || (!(this.hMm.bYY() || this.dDt == 0) || this.hMn == null)) {
            return false;
        }
        this.hMn.setData(this.hMm.bYX());
        this.hMn.bm((ViewGroup) this.hMl.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aNT().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aNT().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aQm() {
        if (this.hMl != null) {
            this.hMl.aQm();
        }
        if (this.hMo != null) {
            this.hMo.onChangeSkinType();
        }
        if (this.hMn != null) {
            this.hMn.onChangeSkinType();
        }
        if (this.hMo.isShowing()) {
            am.setBackgroundResource(this.hMl.bZi(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.hMl.bZi(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.hMl != null) {
            this.hMl.onPause();
            this.hMl.bXU();
            this.hMl.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hMl != null) {
            this.hMl.setListPullRefreshListener(null);
            this.hMl.a((BdListView.e) null);
            this.hMl.onDestroy();
        }
        if (this.hMo != null) {
            this.hMo.onDestroy();
        }
        if (this.hMn != null) {
            this.hMn.onDestroy();
        }
        if (this.hMm != null) {
            this.hMm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHs);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").af("obj_type", this.dDt));
            if (!this.hMo.isShowing()) {
                this.hMl.setViewForeground();
                return;
            }
            return;
        }
        if (this.hMo != null) {
            this.hMo.bYR();
        }
        this.hMl.bXU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hMm != null && !v.isEmpty(this.hMm.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hMm.Dp(optString);
            this.hMm.DS(optString);
            if (this.hMl != null) {
                this.hMl.DU(optString);
            }
        }
    }
}
