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
    private int fce;
    private com.baidu.tieba.homepage.gamevideo.view.b jXE;
    private com.baidu.tieba.homepage.gamevideo.d.b jXF;
    private a jXG;
    private b jXH;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jXE != null) {
                c.this.jXE.cOw();
            }
        }
    };
    private NEGFeedBackView.a jXI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                TiebaStatic.log(new aq("c13500").dW("obj_locate", "1").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).an("obj_type", c.this.fce).dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.jXE != null) {
                    c.this.jXE.IZ();
                }
                TiebaStatic.log(new aq("c13500").dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", atVar.getFid()).dW("obj_param1", atVar.weight).dW("obj_source", atVar.source).dW("obj_id", atVar.extra).dW("obj_type", sb.toString()).dW("obj_name", str).an(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jXJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jXE.cOE()) {
                c.this.jXE.rT(true);
                if (c.this.jXH.isShowing()) {
                    c.this.jXH.cOj();
                    c.this.jXE.cOD();
                    ao.setBackgroundResource(c.this.jXE.cOB(), R.color.CAM_X0207);
                    return;
                }
                c.this.jXH.dg(c.this.jXE.cOB());
                c.this.jXE.cOC();
                ao.setBackgroundResource(c.this.jXE.cOB(), R.color.CAM_X0201);
                if (c.this.jXF != null && !x.isEmpty(c.this.jXF.cOq())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gyD = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jXF.BC(c.this.fce);
                c.this.cOo();
                c.this.jXE.rS(false);
                return;
            }
            c.this.jXE.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jXK = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jXE.bQN();
            c.this.jXF.BD(c.this.fce);
            c.this.cOo();
        }
    };
    private b.a jXL = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jXE.hideLoadingView();
            c.this.jXE.Vq();
            if (z || z2) {
                c.this.jXE.b((f.e) null);
            } else {
                c.this.jXE.b(c.this.BB(i));
            }
            if (!c.this.cOp()) {
                if (!x.isEmpty(c.this.jXF.cOq()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.brx().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jXE.rU(c.this.jXH.isShowing());
                    c.this.jXE.cOF();
                    c.this.jXH.setData(c.this.jXF.cOq());
                }
                if (i != 0) {
                    c.this.jXE.bs(c.this.jXF.getDataList());
                    c.this.jXE.E(c.this.jXM);
                } else if (x.isEmpty(c.this.jXE.getDataList())) {
                    c.this.jXE.showNoDataView();
                } else if (z) {
                    c.this.jXE.bQM();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void n(int i, String str, boolean z) {
            c.this.jXE.b((f.e) null);
            c.this.jXE.hideLoadingView();
            c.this.jXE.Vq();
            if (x.isEmpty(c.this.jXE.getDataList())) {
                c.this.jXE.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jXE.E(c.this.jXM);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jXM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jXE != null && c.this.jXF != null) {
                c.this.jXE.bQN();
                c.this.jXF.BD(c.this.fce);
            }
        }
    };
    private b.a jXN = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOm() {
            c.this.jXE.qz(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.fce = aVar.sub_class_id;
                c.this.BA(aVar.sub_class_id);
                if (c.this.jXE != null) {
                    c.this.jXE.By(aVar.sub_class_id);
                    c.this.jXE.rU(false);
                    c.this.jXE.Ll(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOn() {
            if (c.this.jXE != null) {
                c.this.jXE.rU(false);
                c.this.jXE.qz(false);
            }
        }
    };
    private a.InterfaceC0743a jXt = new a.InterfaceC0743a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0743a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.fce = aVar.sub_class_id;
                c.this.BA(aVar.sub_class_id);
                if (c.this.jXE != null) {
                    c.this.jXE.By(aVar.sub_class_id);
                    c.this.jXE.rU(false);
                    c.this.jXE.Ll(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jXE = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jXI);
        this.jXF = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jXL);
        this.jXH = new b(tbPageContext, this.mBdUniqueId);
        this.jXH.a(this.jXN);
        this.jXG = new a(tbPageContext, this.mBdUniqueId);
        this.jXG.a(this.jXt);
        this.jXE.F(this.jXJ);
        this.fce = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jXE.By(this.fce);
    }

    public void init() {
        this.jXF.registerListener();
        this.jXE.init();
        this.jXE.setListPullRefreshListener(this.gyD);
        this.jXE.a(this.jXK);
        MessageManager.getInstance().registerListener(this.iJp);
    }

    public View getView() {
        if (this.jXE != null) {
            return this.jXE.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOo() {
        TiebaStatic.log(new aq("c13493").an("obj_type", this.fce));
    }

    public void loadData() {
        if (this.jXE != null) {
            this.jXE.cOz();
            this.jXE.showLoadingView();
        }
        if (this.jXF != null) {
            this.jXF.BC(this.fce);
        }
    }

    public void SM() {
        if (this.jXE != null) {
            this.jXE.cOv();
            this.jXE.startPullRefresh();
            this.jXE.rS(false);
            this.jXE.cOx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA(int i) {
        if (this.jXH != null) {
            this.jXH.Bz(i);
        }
        if (this.jXF != null) {
            this.jXF.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOp() {
        if (this.jXF == null || x.isEmpty(this.jXF.cOq()) || (!(this.jXF.cOr() || this.fce == 0) || this.jXG == null)) {
            return false;
        }
        this.jXG.setData(this.jXF.cOq());
        this.jXG.bT((ViewGroup) this.jXE.getRootView());
        com.baidu.tbadk.core.sharedPref.b.brx().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.brx().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BB(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void btV() {
        if (this.jXE != null) {
            this.jXE.btV();
        }
        if (this.jXH != null) {
            this.jXH.onChangeSkinType();
        }
        if (this.jXG != null) {
            this.jXG.onChangeSkinType();
        }
        if (this.jXH.isShowing()) {
            ao.setBackgroundResource(this.jXE.cOB(), R.color.CAM_X0201);
        } else {
            ao.setBackgroundResource(this.jXE.cOB(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.jXE != null) {
            this.jXE.onPause();
            this.jXE.cMQ();
            this.jXE.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jXE != null) {
            this.jXE.setListPullRefreshListener(null);
            this.jXE.a((BdListView.e) null);
            this.jXE.onDestroy();
        }
        if (this.jXH != null) {
            this.jXH.onDestroy();
        }
        if (this.jXG != null) {
            this.jXG.onDestroy();
        }
        if (this.jXF != null) {
            this.jXF.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iJp);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").an("obj_type", this.fce));
            if (!this.jXH.isShowing()) {
                this.jXE.setViewForeground();
                return;
            }
            return;
        }
        if (this.jXH != null) {
            this.jXH.cOk();
        }
        this.jXE.cMQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jXF != null && !x.isEmpty(this.jXF.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jXF.Km(optString);
            this.jXF.Lk(optString);
            if (this.jXE != null) {
                this.jXE.Lm(optString);
            }
        }
    }
}
