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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class c {
    private int eXm;
    private com.baidu.tieba.homepage.gamevideo.view.b jOT;
    private com.baidu.tieba.homepage.gamevideo.d.b jOU;
    private a jOV;
    private b jOW;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iBI = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jOT != null) {
                c.this.jOT.cPg();
            }
        }
    };
    private NEGFeedBackView.a jOX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                TiebaStatic.log(new ar("c13500").dY("obj_locate", "1").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ar("c13499").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).al("obj_type", c.this.eXm).dY("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.jOT != null) {
                    c.this.jOT.Nv();
                }
                TiebaStatic.log(new ar("c13500").dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jOY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jOT.cPo()) {
                c.this.jOT.rA(true);
                if (c.this.jOW.isShowing()) {
                    c.this.jOW.cOT();
                    c.this.jOT.cPn();
                    ap.setBackgroundResource(c.this.jOT.cPl(), R.color.CAM_X0207);
                    return;
                }
                c.this.jOW.cW(c.this.jOT.cPl());
                c.this.jOT.cPm();
                ap.setBackgroundResource(c.this.jOT.cPl(), R.color.CAM_X0201);
                if (c.this.jOU != null && !y.isEmpty(c.this.jOU.cPa())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gsj = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jOU.CU(c.this.eXm);
                c.this.cOY();
                c.this.jOT.rz(false);
                return;
            }
            c.this.jOT.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jOZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jOT.bSb();
            c.this.jOU.CV(c.this.eXm);
            c.this.cOY();
        }
    };
    private b.a jPa = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jOT.hideLoadingView();
            c.this.jOT.Yb();
            if (z || z2) {
                c.this.jOT.b((f.e) null);
            } else {
                c.this.jOT.b(c.this.CT(i));
            }
            if (!c.this.cOZ()) {
                if (!y.isEmpty(c.this.jOU.cPa()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jOT.rB(c.this.jOW.isShowing());
                    c.this.jOT.cPp();
                    c.this.jOW.setData(c.this.jOU.cPa());
                }
                if (i != 0) {
                    c.this.jOT.bl(c.this.jOU.getDataList());
                    c.this.jOT.C(c.this.jPb);
                } else if (y.isEmpty(c.this.jOT.getDataList())) {
                    c.this.jOT.showNoDataView();
                } else if (z) {
                    c.this.jOT.bSa();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void n(int i, String str, boolean z) {
            c.this.jOT.b((f.e) null);
            c.this.jOT.hideLoadingView();
            c.this.jOT.Yb();
            if (y.isEmpty(c.this.jOT.getDataList())) {
                c.this.jOT.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jOT.C(c.this.jPb);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jPb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jOT != null && c.this.jOU != null) {
                c.this.jOT.bSb();
                c.this.jOU.CV(c.this.eXm);
            }
        }
    };
    private b.a jPc = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOW() {
            c.this.jOT.qf(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eXm = aVar.sub_class_id;
                c.this.CS(aVar.sub_class_id);
                if (c.this.jOT != null) {
                    c.this.jOT.CQ(aVar.sub_class_id);
                    c.this.jOT.rB(false);
                    c.this.jOT.Mu(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOX() {
            if (c.this.jOT != null) {
                c.this.jOT.rB(false);
                c.this.jOT.qf(false);
            }
        }
    };
    private a.InterfaceC0759a jOI = new a.InterfaceC0759a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0759a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eXm = aVar.sub_class_id;
                c.this.CS(aVar.sub_class_id);
                if (c.this.jOT != null) {
                    c.this.jOT.CQ(aVar.sub_class_id);
                    c.this.jOT.rB(false);
                    c.this.jOT.Mu(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOT = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jOX);
        this.jOU = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jPa);
        this.jOW = new b(tbPageContext, this.mBdUniqueId);
        this.jOW.a(this.jPc);
        this.jOV = new a(tbPageContext, this.mBdUniqueId);
        this.jOV.a(this.jOI);
        this.jOT.D(this.jOY);
        this.eXm = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jOT.CQ(this.eXm);
    }

    public void init() {
        this.jOU.registerListener();
        this.jOT.init();
        this.jOT.setListPullRefreshListener(this.gsj);
        this.jOT.a(this.jOZ);
        MessageManager.getInstance().registerListener(this.iBI);
    }

    public View getView() {
        if (this.jOT != null) {
            return this.jOT.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOY() {
        TiebaStatic.log(new ar("c13493").al("obj_type", this.eXm));
    }

    public void loadData() {
        if (this.jOT != null) {
            this.jOT.cPj();
            this.jOT.showLoadingView();
        }
        if (this.jOU != null) {
            this.jOU.CU(this.eXm);
        }
    }

    public void VC() {
        if (this.jOT != null) {
            this.jOT.cPf();
            this.jOT.startPullRefresh();
            this.jOT.rz(false);
            this.jOT.cPh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS(int i) {
        if (this.jOW != null) {
            this.jOW.CR(i);
        }
        if (this.jOU != null) {
            this.jOU.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOZ() {
        if (this.jOU == null || y.isEmpty(this.jOU.cPa()) || (!(this.jOU.cPb() || this.eXm == 0) || this.jOV == null)) {
            return false;
        }
        this.jOV.setData(this.jOU.cPa());
        this.jOV.bE((ViewGroup) this.jOT.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bsO().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bsO().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e CT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bvt() {
        if (this.jOT != null) {
            this.jOT.bvt();
        }
        if (this.jOW != null) {
            this.jOW.onChangeSkinType();
        }
        if (this.jOV != null) {
            this.jOV.onChangeSkinType();
        }
        if (this.jOW.isShowing()) {
            ap.setBackgroundResource(this.jOT.cPl(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.jOT.cPl(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.jOT != null) {
            this.jOT.onPause();
            this.jOT.cNA();
            this.jOT.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jOT != null) {
            this.jOT.setListPullRefreshListener(null);
            this.jOT.a((BdListView.e) null);
            this.jOT.onDestroy();
        }
        if (this.jOW != null) {
            this.jOW.onDestroy();
        }
        if (this.jOV != null) {
            this.jOV.onDestroy();
        }
        if (this.jOU != null) {
            this.jOU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iBI);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").al("obj_type", this.eXm));
            if (!this.jOW.isShowing()) {
                this.jOT.setViewForeground();
                return;
            }
            return;
        }
        if (this.jOW != null) {
            this.jOW.cOU();
        }
        this.jOT.cNA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jOU != null && !y.isEmpty(this.jOU.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jOU.Lx(optString);
            this.jOU.Mt(optString);
            if (this.jOT != null) {
                this.jOT.Mv(optString);
            }
        }
    }
}
