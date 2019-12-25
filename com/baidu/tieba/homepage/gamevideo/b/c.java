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
/* loaded from: classes6.dex */
public class c {
    private int cZa;
    private com.baidu.tieba.homepage.gamevideo.view.b gVv;
    private com.baidu.tieba.homepage.gamevideo.d.b gVw;
    private a gVx;
    private b gVy;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gCj = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.gVv != null) {
                c.this.gVv.bLC();
            }
        }
    };
    private NEGFeedBackView.a gVz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).Z("obj_type", c.this.cZa).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.gVv != null) {
                    c.this.gVv.uS();
                }
                TiebaStatic.log(new an("c13500").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener gVA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.gVv.bLK()) {
                c.this.gVv.mr(true);
                if (c.this.gVy.isShowing()) {
                    c.this.gVy.bLp();
                    c.this.gVv.bLJ();
                    am.setBackgroundResource(c.this.gVv.bLH(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.gVy.bT(c.this.gVv.bLH());
                c.this.gVv.bLI();
                am.setBackgroundResource(c.this.gVv.bLH(), R.color.cp_bg_line_d);
                if (c.this.gVw != null && !v.isEmpty(c.this.gVw.bLw())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c ehg = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.gVw.ve(c.this.cZa);
                c.this.bLu();
                c.this.gVv.mq(false);
                return;
            }
            c.this.gVv.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e gVB = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.gVv.aZH();
            c.this.gVw.vf(c.this.cZa);
            c.this.bLu();
        }
    };
    private b.a gVC = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.gVv.hideLoadingView();
            c.this.gVv.aZK();
            if (z || z2) {
                c.this.gVv.b((g.e) null);
            } else {
                c.this.gVv.b(c.this.vd(i));
            }
            if (!c.this.bLv()) {
                if (!v.isEmpty(c.this.gVw.bLw()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.gVv.ms(c.this.gVy.isShowing());
                    c.this.gVv.bLL();
                    c.this.gVy.setData(c.this.gVw.bLw());
                }
                if (i != 0) {
                    c.this.gVv.aw(c.this.gVw.getDataList());
                    c.this.gVv.z(c.this.gVD);
                } else if (v.isEmpty(c.this.gVv.getDataList())) {
                    c.this.gVv.showNoDataView();
                } else if (z) {
                    c.this.gVv.aZG();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.gVv.b((g.e) null);
            c.this.gVv.hideLoadingView();
            c.this.gVv.aZK();
            if (v.isEmpty(c.this.gVv.getDataList())) {
                c.this.gVv.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.gVv.z(c.this.gVD);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener gVD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gVv != null && c.this.gVw != null) {
                c.this.gVv.aZH();
                c.this.gVw.vf(c.this.cZa);
            }
        }
    };
    private b.a gVE = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bLs() {
            c.this.gVv.lf(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cZa = aVar.sub_class_id;
                c.this.vc(aVar.sub_class_id);
                if (c.this.gVv != null) {
                    c.this.gVv.va(aVar.sub_class_id);
                    c.this.gVv.ms(false);
                    c.this.gVv.BH(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bLt() {
            if (c.this.gVv != null) {
                c.this.gVv.ms(false);
                c.this.gVv.lf(false);
            }
        }
    };
    private a.InterfaceC0506a gVk = new a.InterfaceC0506a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0506a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.cZa = aVar.sub_class_id;
                c.this.vc(aVar.sub_class_id);
                if (c.this.gVv != null) {
                    c.this.gVv.va(aVar.sub_class_id);
                    c.this.gVv.ms(false);
                    c.this.gVv.BH(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gVv = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.gVz);
        this.gVw = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.gVC);
        this.gVy = new b(tbPageContext, this.mBdUniqueId);
        this.gVy.a(this.gVE);
        this.gVx = new a(tbPageContext, this.mBdUniqueId);
        this.gVx.a(this.gVk);
        this.gVv.A(this.gVA);
        this.cZa = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.gVv.va(this.cZa);
    }

    public void init() {
        this.gVw.registerListener();
        this.gVv.init();
        this.gVv.setListPullRefreshListener(this.ehg);
        this.gVv.a(this.gVB);
        MessageManager.getInstance().registerListener(this.gCj);
    }

    public View getView() {
        if (this.gVv != null) {
            return this.gVv.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLu() {
        TiebaStatic.log(new an("c13493").Z("obj_type", this.cZa));
    }

    public void loadData() {
        if (this.gVv != null) {
            this.gVv.bLF();
            this.gVv.showLoadingView();
        }
        if (this.gVw != null) {
            this.gVw.ve(this.cZa);
        }
    }

    public void xT() {
        if (this.gVv != null) {
            this.gVv.bLB();
            this.gVv.startPullRefresh();
            this.gVv.mq(false);
            this.gVv.bLD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(int i) {
        if (this.gVy != null) {
            this.gVy.vb(i);
        }
        if (this.gVw != null) {
            this.gVw.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLv() {
        if (this.gVw == null || v.isEmpty(this.gVw.bLw()) || (!(this.gVw.bLx() || this.cZa == 0) || this.gVx == null)) {
            return false;
        }
        this.gVx.setData(this.gVw.bLw());
        this.gVx.bf((ViewGroup) this.gVv.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aCY().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aCY().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vd(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aFd() {
        if (this.gVv != null) {
            this.gVv.aFd();
        }
        if (this.gVy != null) {
            this.gVy.onChangeSkinType();
        }
        if (this.gVx != null) {
            this.gVx.onChangeSkinType();
        }
        if (this.gVy.isShowing()) {
            am.setBackgroundResource(this.gVv.bLH(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.gVv.bLH(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.gVv != null) {
            this.gVv.onPause();
            this.gVv.bKv();
            this.gVv.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.gVv != null) {
            this.gVv.setListPullRefreshListener(null);
            this.gVv.a((BdListView.e) null);
            this.gVv.onDestroy();
        }
        if (this.gVy != null) {
            this.gVy.onDestroy();
        }
        if (this.gVx != null) {
            this.gVx.onDestroy();
        }
        if (this.gVw != null) {
            this.gVw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gCj);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").Z("obj_type", this.cZa));
            if (!this.gVy.isShowing()) {
                this.gVv.setViewForeground();
                return;
            }
            return;
        }
        if (this.gVy != null) {
            this.gVy.bLq();
        }
        this.gVv.bKv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gVw != null && !v.isEmpty(this.gVw.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.gVw.Bb(optString);
            this.gVw.BG(optString);
            if (this.gVv != null) {
                this.gVv.BI(optString);
            }
        }
    }
}
