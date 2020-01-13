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
/* loaded from: classes7.dex */
public class c {
    private int cZk;
    private com.baidu.tieba.homepage.gamevideo.view.b gYT;
    private com.baidu.tieba.homepage.gamevideo.d.b gYU;
    private a gYV;
    private b gYW;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gFy = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.gYT != null) {
                c.this.gYT.bMK();
            }
        }
    };
    private NEGFeedBackView.a gYX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).Z("obj_type", c.this.cZk).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.gYT != null) {
                    c.this.gYT.vj();
                }
                TiebaStatic.log(new an("c13500").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener gYY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.gYT.bMS()) {
                c.this.gYT.mC(true);
                if (c.this.gYW.isShowing()) {
                    c.this.gYW.bMx();
                    c.this.gYT.bMR();
                    am.setBackgroundResource(c.this.gYT.bMP(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.gYW.bY(c.this.gYT.bMP());
                c.this.gYT.bMQ();
                am.setBackgroundResource(c.this.gYT.bMP(), R.color.cp_bg_line_d);
                if (c.this.gYU != null && !v.isEmpty(c.this.gYU.bME())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c eib = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.gYU.vj(c.this.cZk);
                c.this.bMC();
                c.this.gYT.mB(false);
                return;
            }
            c.this.gYT.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e gYZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.gYT.bac();
            c.this.gYU.vk(c.this.cZk);
            c.this.bMC();
        }
    };
    private b.a gZa = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.gYT.hideLoadingView();
            c.this.gYT.baf();
            if (z || z2) {
                c.this.gYT.b((g.e) null);
            } else {
                c.this.gYT.b(c.this.vi(i));
            }
            if (!c.this.bMD()) {
                if (!v.isEmpty(c.this.gYU.bME()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.gYT.mD(c.this.gYW.isShowing());
                    c.this.gYT.bMT();
                    c.this.gYW.setData(c.this.gYU.bME());
                }
                if (i != 0) {
                    c.this.gYT.av(c.this.gYU.getDataList());
                    c.this.gYT.y(c.this.gZb);
                } else if (v.isEmpty(c.this.gYT.getDataList())) {
                    c.this.gYT.showNoDataView();
                } else if (z) {
                    c.this.gYT.bab();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.gYT.b((g.e) null);
            c.this.gYT.hideLoadingView();
            c.this.gYT.baf();
            if (v.isEmpty(c.this.gYT.getDataList())) {
                c.this.gYT.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.gYT.y(c.this.gZb);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener gZb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gYT != null && c.this.gYU != null) {
                c.this.gYT.bac();
                c.this.gYU.vk(c.this.cZk);
            }
        }
    };
    private b.a gZc = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bMA() {
            c.this.gYT.lq(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cZk = aVar.sub_class_id;
                c.this.vh(aVar.sub_class_id);
                if (c.this.gYT != null) {
                    c.this.gYT.vf(aVar.sub_class_id);
                    c.this.gYT.mD(false);
                    c.this.gYT.BR(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bMB() {
            if (c.this.gYT != null) {
                c.this.gYT.mD(false);
                c.this.gYT.lq(false);
            }
        }
    };
    private a.InterfaceC0510a gYI = new a.InterfaceC0510a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0510a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cZk = aVar.sub_class_id;
                c.this.vh(aVar.sub_class_id);
                if (c.this.gYT != null) {
                    c.this.gYT.vf(aVar.sub_class_id);
                    c.this.gYT.mD(false);
                    c.this.gYT.BR(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gYT = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.gYX);
        this.gYU = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.gZa);
        this.gYW = new b(tbPageContext, this.mBdUniqueId);
        this.gYW.a(this.gZc);
        this.gYV = new a(tbPageContext, this.mBdUniqueId);
        this.gYV.a(this.gYI);
        this.gYT.z(this.gYY);
        this.cZk = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.gYT.vf(this.cZk);
    }

    public void init() {
        this.gYU.registerListener();
        this.gYT.init();
        this.gYT.setListPullRefreshListener(this.eib);
        this.gYT.a(this.gYZ);
        MessageManager.getInstance().registerListener(this.gFy);
    }

    public View getView() {
        if (this.gYT != null) {
            return this.gYT.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMC() {
        TiebaStatic.log(new an("c13493").Z("obj_type", this.cZk));
    }

    public void loadData() {
        if (this.gYT != null) {
            this.gYT.bMN();
            this.gYT.showLoadingView();
        }
        if (this.gYU != null) {
            this.gYU.vj(this.cZk);
        }
    }

    public void yj() {
        if (this.gYT != null) {
            this.gYT.bMJ();
            this.gYT.startPullRefresh();
            this.gYT.mB(false);
            this.gYT.bML();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(int i) {
        if (this.gYW != null) {
            this.gYW.vg(i);
        }
        if (this.gYU != null) {
            this.gYU.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMD() {
        if (this.gYU == null || v.isEmpty(this.gYU.bME()) || (!(this.gYU.bMF() || this.cZk == 0) || this.gYV == null)) {
            return false;
        }
        this.gYV.setData(this.gYU.bME());
        this.gYV.bj((ViewGroup) this.gYT.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aDr().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aDr().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vi(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aFw() {
        if (this.gYT != null) {
            this.gYT.aFw();
        }
        if (this.gYW != null) {
            this.gYW.onChangeSkinType();
        }
        if (this.gYV != null) {
            this.gYV.onChangeSkinType();
        }
        if (this.gYW.isShowing()) {
            am.setBackgroundResource(this.gYT.bMP(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.gYT.bMP(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.gYT != null) {
            this.gYT.onPause();
            this.gYT.bLA();
            this.gYT.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.gYT != null) {
            this.gYT.setListPullRefreshListener(null);
            this.gYT.a((BdListView.e) null);
            this.gYT.onDestroy();
        }
        if (this.gYW != null) {
            this.gYW.onDestroy();
        }
        if (this.gYV != null) {
            this.gYV.onDestroy();
        }
        if (this.gYU != null) {
            this.gYU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gFy);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").Z("obj_type", this.cZk));
            if (!this.gYW.isShowing()) {
                this.gYT.setViewForeground();
                return;
            }
            return;
        }
        if (this.gYW != null) {
            this.gYW.bMy();
        }
        this.gYT.bLA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gYU != null && !v.isEmpty(this.gYU.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.gYU.Bl(optString);
            this.gYU.BQ(optString);
            if (this.gYT != null) {
                this.gYT.BS(optString);
            }
        }
    }
}
