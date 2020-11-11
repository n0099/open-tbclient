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
    private int eQW;
    private com.baidu.tieba.homepage.gamevideo.view.b jAv;
    private com.baidu.tieba.homepage.gamevideo.d.b jAw;
    private a jAx;
    private b jAy;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iqc = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jAv != null) {
                c.this.jAv.cKm();
            }
        }
    };
    private NEGFeedBackView.a jAz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).al("obj_type", c.this.eQW).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.jAv != null) {
                    c.this.jAv.LZ();
                }
                TiebaStatic.log(new aq("c13500").dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jAA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jAv.cKu()) {
                c.this.jAv.qW(true);
                if (c.this.jAy.isShowing()) {
                    c.this.jAy.cJZ();
                    c.this.jAv.cKt();
                    ap.setBackgroundResource(c.this.jAv.cKr(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.jAy.cL(c.this.jAv.cKr());
                c.this.jAv.cKs();
                ap.setBackgroundResource(c.this.jAv.cKr(), R.color.cp_bg_line_d);
                if (c.this.jAw != null && !y.isEmpty(c.this.jAw.cKg())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gkt = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jAw.BH(c.this.eQW);
                c.this.cKe();
                c.this.jAv.qV(false);
                return;
            }
            c.this.jAv.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jAB = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jAv.bOX();
            c.this.jAw.BI(c.this.eQW);
            c.this.cKe();
        }
    };
    private b.a jAC = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jAv.hideLoadingView();
            c.this.jAv.Wk();
            if (z || z2) {
                c.this.jAv.b((f.e) null);
            } else {
                c.this.jAv.b(c.this.BG(i));
            }
            if (!c.this.cKf()) {
                if (!y.isEmpty(c.this.jAw.cKg()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jAv.qX(c.this.jAy.isShowing());
                    c.this.jAv.cKv();
                    c.this.jAy.setData(c.this.jAw.cKg());
                }
                if (i != 0) {
                    c.this.jAv.bi(c.this.jAw.getDataList());
                    c.this.jAv.C(c.this.jAD);
                } else if (y.isEmpty(c.this.jAv.getDataList())) {
                    c.this.jAv.showNoDataView();
                } else if (z) {
                    c.this.jAv.bOW();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.jAv.b((f.e) null);
            c.this.jAv.hideLoadingView();
            c.this.jAv.Wk();
            if (y.isEmpty(c.this.jAv.getDataList())) {
                c.this.jAv.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jAv.C(c.this.jAD);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jAD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jAv != null && c.this.jAw != null) {
                c.this.jAv.bOX();
                c.this.jAw.BI(c.this.eQW);
            }
        }
    };
    private b.a jAE = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cKc() {
            c.this.jAv.pF(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eQW = aVar.sub_class_id;
                c.this.BF(aVar.sub_class_id);
                if (c.this.jAv != null) {
                    c.this.jAv.BD(aVar.sub_class_id);
                    c.this.jAv.qX(false);
                    c.this.jAv.LM(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cKd() {
            if (c.this.jAv != null) {
                c.this.jAv.qX(false);
                c.this.jAv.pF(false);
            }
        }
    };
    private a.InterfaceC0740a jAk = new a.InterfaceC0740a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0740a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eQW = aVar.sub_class_id;
                c.this.BF(aVar.sub_class_id);
                if (c.this.jAv != null) {
                    c.this.jAv.BD(aVar.sub_class_id);
                    c.this.jAv.qX(false);
                    c.this.jAv.LM(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jAv = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jAz);
        this.jAw = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jAC);
        this.jAy = new b(tbPageContext, this.mBdUniqueId);
        this.jAy.a(this.jAE);
        this.jAx = new a(tbPageContext, this.mBdUniqueId);
        this.jAx.a(this.jAk);
        this.jAv.D(this.jAA);
        this.eQW = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jAv.BD(this.eQW);
    }

    public void init() {
        this.jAw.registerListener();
        this.jAv.init();
        this.jAv.setListPullRefreshListener(this.gkt);
        this.jAv.a(this.jAB);
        MessageManager.getInstance().registerListener(this.iqc);
    }

    public View getView() {
        if (this.jAv != null) {
            return this.jAv.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKe() {
        TiebaStatic.log(new aq("c13493").al("obj_type", this.eQW));
    }

    public void loadData() {
        if (this.jAv != null) {
            this.jAv.cKp();
            this.jAv.showLoadingView();
        }
        if (this.jAw != null) {
            this.jAw.BH(this.eQW);
        }
    }

    public void TL() {
        if (this.jAv != null) {
            this.jAv.cKl();
            this.jAv.startPullRefresh();
            this.jAv.qV(false);
            this.jAv.cKn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF(int i) {
        if (this.jAy != null) {
            this.jAy.BE(i);
        }
        if (this.jAw != null) {
            this.jAw.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKf() {
        if (this.jAw == null || y.isEmpty(this.jAw.cKg()) || (!(this.jAw.cKh() || this.eQW == 0) || this.jAx == null)) {
            return false;
        }
        this.jAx.setData(this.jAw.cKg());
        this.jAx.bF((ViewGroup) this.jAv.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bqh().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bqh().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BG(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bsD() {
        if (this.jAv != null) {
            this.jAv.bsD();
        }
        if (this.jAy != null) {
            this.jAy.onChangeSkinType();
        }
        if (this.jAx != null) {
            this.jAx.onChangeSkinType();
        }
        if (this.jAy.isShowing()) {
            ap.setBackgroundResource(this.jAv.cKr(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.jAv.cKr(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.jAv != null) {
            this.jAv.onPause();
            this.jAv.cIG();
            this.jAv.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jAv != null) {
            this.jAv.setListPullRefreshListener(null);
            this.jAv.a((BdListView.e) null);
            this.jAv.onDestroy();
        }
        if (this.jAy != null) {
            this.jAy.onDestroy();
        }
        if (this.jAx != null) {
            this.jAx.onDestroy();
        }
        if (this.jAw != null) {
            this.jAw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iqc);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").al("obj_type", this.eQW));
            if (!this.jAy.isShowing()) {
                this.jAv.setViewForeground();
                return;
            }
            return;
        }
        if (this.jAy != null) {
            this.jAy.cKa();
        }
        this.jAv.cIG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jAw != null && !y.isEmpty(this.jAw.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jAw.KP(optString);
            this.jAw.LL(optString);
            if (this.jAv != null) {
                this.jAv.LN(optString);
            }
        }
    }
}
