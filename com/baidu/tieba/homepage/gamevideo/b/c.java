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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes21.dex */
public class c {
    private int ePX;
    private com.baidu.tieba.homepage.gamevideo.view.b jBr;
    private com.baidu.tieba.homepage.gamevideo.d.b jBs;
    private a jBt;
    private b jBu;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iqQ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jBr != null) {
                c.this.jBr.cJR();
            }
        }
    };
    private NEGFeedBackView.a jBv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(as asVar) {
            if (asVar != null) {
                TiebaStatic.log(new ar("c13500").dR("obj_locate", "1").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ar("c13499").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).ak("obj_type", c.this.ePX).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
            int i = 0;
            if (arrayList != null && asVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (asVar.threadType == 0) {
                    i = 1;
                } else if (asVar.threadType == 40) {
                    i = 2;
                } else if (asVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.jBr != null) {
                    c.this.jBr.Lq();
                }
                TiebaStatic.log(new ar("c13500").dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", asVar.getFid()).dR("obj_param1", asVar.weight).dR("obj_source", asVar.source).dR("obj_id", asVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ak(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jBw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jBr.cJZ()) {
                c.this.jBr.qZ(true);
                if (c.this.jBu.isShowing()) {
                    c.this.jBu.cJE();
                    c.this.jBr.cJY();
                    ap.setBackgroundResource(c.this.jBr.cJW(), R.color.CAM_X0207);
                    return;
                }
                c.this.jBu.cP(c.this.jBr.cJW());
                c.this.jBr.cJX();
                ap.setBackgroundResource(c.this.jBr.cJW(), R.color.CAM_X0201);
                if (c.this.jBs != null && !y.isEmpty(c.this.jBs.cJL())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gka = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jBs.Cf(c.this.ePX);
                c.this.cJJ();
                c.this.jBr.qY(false);
                return;
            }
            c.this.jBr.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jBx = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jBr.bOq();
            c.this.jBs.Cg(c.this.ePX);
            c.this.cJJ();
        }
    };
    private b.a jBy = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jBr.hideLoadingView();
            c.this.jBr.VB();
            if (z || z2) {
                c.this.jBr.b((f.e) null);
            } else {
                c.this.jBr.b(c.this.Ce(i));
            }
            if (!c.this.cJK()) {
                if (!y.isEmpty(c.this.jBs.cJL()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jBr.ra(c.this.jBu.isShowing());
                    c.this.jBr.cKa();
                    c.this.jBu.setData(c.this.jBs.cJL());
                }
                if (i != 0) {
                    c.this.jBr.bi(c.this.jBs.getDataList());
                    c.this.jBr.C(c.this.jBz);
                } else if (y.isEmpty(c.this.jBr.getDataList())) {
                    c.this.jBr.showNoDataView();
                } else if (z) {
                    c.this.jBr.bOp();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.jBr.b((f.e) null);
            c.this.jBr.hideLoadingView();
            c.this.jBr.VB();
            if (y.isEmpty(c.this.jBr.getDataList())) {
                c.this.jBr.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jBr.C(c.this.jBz);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jBz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jBr != null && c.this.jBs != null) {
                c.this.jBr.bOq();
                c.this.jBs.Cg(c.this.ePX);
            }
        }
    };
    private b.a jBA = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cJH() {
            c.this.jBr.pI(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ePX = aVar.sub_class_id;
                c.this.Cd(aVar.sub_class_id);
                if (c.this.jBr != null) {
                    c.this.jBr.Cb(aVar.sub_class_id);
                    c.this.jBr.ra(false);
                    c.this.jBr.Ln(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cJI() {
            if (c.this.jBr != null) {
                c.this.jBr.ra(false);
                c.this.jBr.pI(false);
            }
        }
    };
    private a.InterfaceC0743a jBg = new a.InterfaceC0743a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0743a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ePX = aVar.sub_class_id;
                c.this.Cd(aVar.sub_class_id);
                if (c.this.jBr != null) {
                    c.this.jBr.Cb(aVar.sub_class_id);
                    c.this.jBr.ra(false);
                    c.this.jBr.Ln(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jBr = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jBv);
        this.jBs = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jBy);
        this.jBu = new b(tbPageContext, this.mBdUniqueId);
        this.jBu.a(this.jBA);
        this.jBt = new a(tbPageContext, this.mBdUniqueId);
        this.jBt.a(this.jBg);
        this.jBr.D(this.jBw);
        this.ePX = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jBr.Cb(this.ePX);
    }

    public void init() {
        this.jBs.registerListener();
        this.jBr.init();
        this.jBr.setListPullRefreshListener(this.gka);
        this.jBr.a(this.jBx);
        MessageManager.getInstance().registerListener(this.iqQ);
    }

    public View getView() {
        if (this.jBr != null) {
            return this.jBr.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJJ() {
        TiebaStatic.log(new ar("c13493").ak("obj_type", this.ePX));
    }

    public void loadData() {
        if (this.jBr != null) {
            this.jBr.cJU();
            this.jBr.showLoadingView();
        }
        if (this.jBs != null) {
            this.jBs.Cf(this.ePX);
        }
    }

    public void Tc() {
        if (this.jBr != null) {
            this.jBr.cJQ();
            this.jBr.startPullRefresh();
            this.jBr.qY(false);
            this.jBr.cJS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(int i) {
        if (this.jBu != null) {
            this.jBu.Cc(i);
        }
        if (this.jBs != null) {
            this.jBs.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJK() {
        if (this.jBs == null || y.isEmpty(this.jBs.cJL()) || (!(this.jBs.cJM() || this.ePX == 0) || this.jBt == null)) {
            return false;
        }
        this.jBt.setData(this.jBs.cJL());
        this.jBt.bB((ViewGroup) this.jBr.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bpu().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bpu().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Ce(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void brT() {
        if (this.jBr != null) {
            this.jBr.brT();
        }
        if (this.jBu != null) {
            this.jBu.onChangeSkinType();
        }
        if (this.jBt != null) {
            this.jBt.onChangeSkinType();
        }
        if (this.jBu.isShowing()) {
            ap.setBackgroundResource(this.jBr.cJW(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.jBr.cJW(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.jBr != null) {
            this.jBr.onPause();
            this.jBr.cIl();
            this.jBr.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jBr != null) {
            this.jBr.setListPullRefreshListener(null);
            this.jBr.a((BdListView.e) null);
            this.jBr.onDestroy();
        }
        if (this.jBu != null) {
            this.jBu.onDestroy();
        }
        if (this.jBt != null) {
            this.jBt.onDestroy();
        }
        if (this.jBs != null) {
            this.jBs.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iqQ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").ak("obj_type", this.ePX));
            if (!this.jBu.isShowing()) {
                this.jBr.setViewForeground();
                return;
            }
            return;
        }
        if (this.jBu != null) {
            this.jBu.cJF();
        }
        this.jBr.cIl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jBs != null && !y.isEmpty(this.jBs.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jBs.Kq(optString);
            this.jBs.Lm(optString);
            if (this.jBr != null) {
                this.jBr.Lo(optString);
            }
        }
    }
}
