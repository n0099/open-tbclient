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
    private int dDp;
    private com.baidu.tieba.homepage.gamevideo.view.b hMf;
    private com.baidu.tieba.homepage.gamevideo.d.b hMg;
    private a hMh;
    private b hMi;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.hMf != null) {
                c.this.hMf.bZe();
            }
        }
    };
    private NEGFeedBackView.a hMj = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cI("obj_locate", "1").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).af("obj_type", c.this.dDp).cI("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.hMf != null) {
                    c.this.hMf.BD();
                }
                TiebaStatic.log(new an("c13500").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener hMk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.hMf.bZm()) {
                c.this.hMf.nO(true);
                if (c.this.hMi.isShowing()) {
                    c.this.hMi.bYR();
                    c.this.hMf.bZl();
                    am.setBackgroundResource(c.this.hMf.bZj(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.hMi.cg(c.this.hMf.bZj());
                c.this.hMf.bZk();
                am.setBackgroundResource(c.this.hMf.bZj(), R.color.cp_bg_line_d);
                if (c.this.hMg != null && !v.isEmpty(c.this.hMg.bYY())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c eQn = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.hMg.vU(c.this.dDp);
                c.this.bYW();
                c.this.hMf.nN(false);
                return;
            }
            c.this.hMf.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e hMl = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.hMf.blq();
            c.this.hMg.vV(c.this.dDp);
            c.this.bYW();
        }
    };
    private b.a hMm = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.hMf.hideLoadingView();
            c.this.hMf.blt();
            if (z || z2) {
                c.this.hMf.b((g.e) null);
            } else {
                c.this.hMf.b(c.this.vT(i));
            }
            if (!c.this.bYX()) {
                if (!v.isEmpty(c.this.hMg.bYY()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.hMf.nP(c.this.hMi.isShowing());
                    c.this.hMf.bZn();
                    c.this.hMi.setData(c.this.hMg.bYY());
                }
                if (i != 0) {
                    c.this.hMf.aE(c.this.hMg.getDataList());
                    c.this.hMf.A(c.this.hMn);
                } else if (v.isEmpty(c.this.hMf.getDataList())) {
                    c.this.hMf.showNoDataView();
                } else if (z) {
                    c.this.hMf.blp();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.hMf.b((g.e) null);
            c.this.hMf.hideLoadingView();
            c.this.hMf.blt();
            if (v.isEmpty(c.this.hMf.getDataList())) {
                c.this.hMf.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.hMf.A(c.this.hMn);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hMn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hMf != null && c.this.hMg != null) {
                c.this.hMf.blq();
                c.this.hMg.vV(c.this.dDp);
            }
        }
    };
    private b.a hMo = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bYU() {
            c.this.hMf.mC(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dDp = aVar.sub_class_id;
                c.this.vS(aVar.sub_class_id);
                if (c.this.hMf != null) {
                    c.this.hMf.vQ(aVar.sub_class_id);
                    c.this.hMf.nP(false);
                    c.this.hMf.DQ(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bYV() {
            if (c.this.hMf != null) {
                c.this.hMf.nP(false);
                c.this.hMf.mC(false);
            }
        }
    };
    private a.InterfaceC0554a hLU = new a.InterfaceC0554a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0554a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dDp = aVar.sub_class_id;
                c.this.vS(aVar.sub_class_id);
                if (c.this.hMf != null) {
                    c.this.hMf.vQ(aVar.sub_class_id);
                    c.this.hMf.nP(false);
                    c.this.hMf.DQ(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMf = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.hMj);
        this.hMg = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hMm);
        this.hMi = new b(tbPageContext, this.mBdUniqueId);
        this.hMi.a(this.hMo);
        this.hMh = new a(tbPageContext, this.mBdUniqueId);
        this.hMh.a(this.hLU);
        this.hMf.B(this.hMk);
        this.dDp = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.hMf.vQ(this.dDp);
    }

    public void init() {
        this.hMg.registerListener();
        this.hMf.init();
        this.hMf.setListPullRefreshListener(this.eQn);
        this.hMf.a(this.hMl);
        MessageManager.getInstance().registerListener(this.gHm);
    }

    public View getView() {
        if (this.hMf != null) {
            return this.hMf.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYW() {
        TiebaStatic.log(new an("c13493").af("obj_type", this.dDp));
    }

    public void loadData() {
        if (this.hMf != null) {
            this.hMf.bZh();
            this.hMf.showLoadingView();
        }
        if (this.hMg != null) {
            this.hMg.vU(this.dDp);
        }
    }

    public void FH() {
        if (this.hMf != null) {
            this.hMf.bZd();
            this.hMf.startPullRefresh();
            this.hMf.nN(false);
            this.hMf.bZf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        if (this.hMi != null) {
            this.hMi.vR(i);
        }
        if (this.hMg != null) {
            this.hMg.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYX() {
        if (this.hMg == null || v.isEmpty(this.hMg.bYY()) || (!(this.hMg.bYZ() || this.dDp == 0) || this.hMh == null)) {
            return false;
        }
        this.hMh.setData(this.hMg.bYY());
        this.hMh.bm((ViewGroup) this.hMf.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aNV().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aNV().remove("key_game_video_tab_has_choosed_sub_class_name");
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

    public void aQp() {
        if (this.hMf != null) {
            this.hMf.aQp();
        }
        if (this.hMi != null) {
            this.hMi.onChangeSkinType();
        }
        if (this.hMh != null) {
            this.hMh.onChangeSkinType();
        }
        if (this.hMi.isShowing()) {
            am.setBackgroundResource(this.hMf.bZj(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.hMf.bZj(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.hMf != null) {
            this.hMf.onPause();
            this.hMf.bXV();
            this.hMf.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hMf != null) {
            this.hMf.setListPullRefreshListener(null);
            this.hMf.a((BdListView.e) null);
            this.hMf.onDestroy();
        }
        if (this.hMi != null) {
            this.hMi.onDestroy();
        }
        if (this.hMh != null) {
            this.hMh.onDestroy();
        }
        if (this.hMg != null) {
            this.hMg.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHm);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").af("obj_type", this.dDp));
            if (!this.hMi.isShowing()) {
                this.hMf.setViewForeground();
                return;
            }
            return;
        }
        if (this.hMi != null) {
            this.hMi.bYS();
        }
        this.hMf.bXV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hMg != null && !v.isEmpty(this.hMg.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hMg.Dm(optString);
            this.hMg.DP(optString);
            if (this.hMf != null) {
                this.hMf.DR(optString);
            }
        }
    }
}
