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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int fgN;
    private com.baidu.tieba.homepage.gamevideo.view.b kcj;
    private com.baidu.tieba.homepage.gamevideo.d.b kck;
    private a kcl;
    private b kcm;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.kcj != null) {
                c.this.kcj.cSo();
            }
        }
    };
    private NEGFeedBackView.a kcn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                TiebaStatic.log(new aq("c13500").dX("obj_locate", "1").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).an("obj_type", c.this.fgN).dX("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
            int i = 0;
            if (arrayList != null && atVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (atVar.threadType == 0) {
                    i = 1;
                } else if (atVar.threadType == 40) {
                    i = 2;
                } else if (atVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.kcj != null) {
                    c.this.kcj.MU();
                }
                TiebaStatic.log(new aq("c13500").dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", atVar.getFid()).dX("obj_param1", atVar.weight).dX("obj_source", atVar.source).dX("obj_id", atVar.extra).dX("obj_type", sb.toString()).dX("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener kco = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.kcj.cSw()) {
                c.this.kcj.rX(true);
                if (c.this.kcm.isShowing()) {
                    c.this.kcm.cSb();
                    c.this.kcj.cSv();
                    ao.setBackgroundResource(c.this.kcj.cSt(), R.color.CAM_X0207);
                    return;
                }
                c.this.kcm.dg(c.this.kcj.cSt());
                c.this.kcj.cSu();
                ao.setBackgroundResource(c.this.kcj.cSt(), R.color.CAM_X0201);
                if (c.this.kck != null && !x.isEmpty(c.this.kck.cSi())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.kck.Di(c.this.fgN);
                c.this.cSg();
                c.this.kcj.rW(false);
                return;
            }
            c.this.kcj.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e kcp = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.kcj.bUF();
            c.this.kck.Dj(c.this.fgN);
            c.this.cSg();
        }
    };
    private b.a kcq = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.kcj.hideLoadingView();
            c.this.kcj.Zj();
            if (z || z2) {
                c.this.kcj.b((f.e) null);
            } else {
                c.this.kcj.b(c.this.Dh(i));
            }
            if (!c.this.cSh()) {
                if (!x.isEmpty(c.this.kck.cSi()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.kcj.rY(c.this.kcm.isShowing());
                    c.this.kcj.cSx();
                    c.this.kcm.setData(c.this.kck.cSi());
                }
                if (i != 0) {
                    c.this.kcj.bs(c.this.kck.getDataList());
                    c.this.kcj.E(c.this.kcr);
                } else if (x.isEmpty(c.this.kcj.getDataList())) {
                    c.this.kcj.showNoDataView();
                } else if (z) {
                    c.this.kcj.bUE();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void n(int i, String str, boolean z) {
            c.this.kcj.b((f.e) null);
            c.this.kcj.hideLoadingView();
            c.this.kcj.Zj();
            if (x.isEmpty(c.this.kcj.getDataList())) {
                c.this.kcj.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.kcj.E(c.this.kcr);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kcj != null && c.this.kck != null) {
                c.this.kcj.bUF();
                c.this.kck.Dj(c.this.fgN);
            }
        }
    };
    private b.a kcs = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cSe() {
            c.this.kcj.qD(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.fgN = aVar.sub_class_id;
                c.this.Dg(aVar.sub_class_id);
                if (c.this.kcj != null) {
                    c.this.kcj.De(aVar.sub_class_id);
                    c.this.kcj.rY(false);
                    c.this.kcj.Mt(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cSf() {
            if (c.this.kcj != null) {
                c.this.kcj.rY(false);
                c.this.kcj.qD(false);
            }
        }
    };
    private a.InterfaceC0760a kbY = new a.InterfaceC0760a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0760a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.fgN = aVar.sub_class_id;
                c.this.Dg(aVar.sub_class_id);
                if (c.this.kcj != null) {
                    c.this.kcj.De(aVar.sub_class_id);
                    c.this.kcj.rY(false);
                    c.this.kcj.Mt(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kcj = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.kcn);
        this.kck = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.kcq);
        this.kcm = new b(tbPageContext, this.mBdUniqueId);
        this.kcm.a(this.kcs);
        this.kcl = new a(tbPageContext, this.mBdUniqueId);
        this.kcl.a(this.kbY);
        this.kcj.F(this.kco);
        this.fgN = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.kcj.De(this.fgN);
    }

    public void init() {
        this.kck.registerListener();
        this.kcj.init();
        this.kcj.setListPullRefreshListener(this.gDk);
        this.kcj.a(this.kcp);
        MessageManager.getInstance().registerListener(this.iNW);
    }

    public View getView() {
        if (this.kcj != null) {
            return this.kcj.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSg() {
        TiebaStatic.log(new aq("c13493").an("obj_type", this.fgN));
    }

    public void loadData() {
        if (this.kcj != null) {
            this.kcj.cSr();
            this.kcj.showLoadingView();
        }
        if (this.kck != null) {
            this.kck.Di(this.fgN);
        }
    }

    public void WF() {
        if (this.kcj != null) {
            this.kcj.cSn();
            this.kcj.startPullRefresh();
            this.kcj.rW(false);
            this.kcj.cSp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg(int i) {
        if (this.kcm != null) {
            this.kcm.Df(i);
        }
        if (this.kck != null) {
            this.kck.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cSh() {
        if (this.kck == null || x.isEmpty(this.kck.cSi()) || (!(this.kck.cSj() || this.fgN == 0) || this.kcl == null)) {
            return false;
        }
        this.kcl.setData(this.kck.cSi());
        this.kcl.bT((ViewGroup) this.kcj.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bvr().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bvr().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Dh(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bxP() {
        if (this.kcj != null) {
            this.kcj.bxP();
        }
        if (this.kcm != null) {
            this.kcm.onChangeSkinType();
        }
        if (this.kcl != null) {
            this.kcl.onChangeSkinType();
        }
        if (this.kcm.isShowing()) {
            ao.setBackgroundResource(this.kcj.cSt(), R.color.CAM_X0201);
        } else {
            ao.setBackgroundResource(this.kcj.cSt(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.kcj != null) {
            this.kcj.onPause();
            this.kcj.cQI();
            this.kcj.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kcj != null) {
            this.kcj.setListPullRefreshListener(null);
            this.kcj.a((BdListView.e) null);
            this.kcj.onDestroy();
        }
        if (this.kcm != null) {
            this.kcm.onDestroy();
        }
        if (this.kcl != null) {
            this.kcl.onDestroy();
        }
        if (this.kck != null) {
            this.kck.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iNW);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").an("obj_type", this.fgN));
            if (!this.kcm.isShowing()) {
                this.kcj.setViewForeground();
                return;
            }
            return;
        }
        if (this.kcm != null) {
            this.kcm.cSc();
        }
        this.kcj.cQI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kck != null && !x.isEmpty(this.kck.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kck.Lw(optString);
            this.kck.Ms(optString);
            if (this.kcj != null) {
                this.kcj.Mu(optString);
            }
        }
    }
}
