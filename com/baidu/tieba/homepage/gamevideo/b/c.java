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
    private com.baidu.tieba.homepage.gamevideo.view.b jOV;
    private com.baidu.tieba.homepage.gamevideo.d.b jOW;
    private a jOX;
    private b jOY;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iBK = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jOV != null) {
                c.this.jOV.cPh();
            }
        }
    };
    private NEGFeedBackView.a jOZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
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
                if (c.this.jOV != null) {
                    c.this.jOV.Nv();
                }
                TiebaStatic.log(new ar("c13500").dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jPa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jOV.cPp()) {
                c.this.jOV.rA(true);
                if (c.this.jOY.isShowing()) {
                    c.this.jOY.cOU();
                    c.this.jOV.cPo();
                    ap.setBackgroundResource(c.this.jOV.cPm(), R.color.CAM_X0207);
                    return;
                }
                c.this.jOY.cW(c.this.jOV.cPm());
                c.this.jOV.cPn();
                ap.setBackgroundResource(c.this.jOV.cPm(), R.color.CAM_X0201);
                if (c.this.jOW != null && !y.isEmpty(c.this.jOW.cPb())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gsl = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jOW.CU(c.this.eXm);
                c.this.cOZ();
                c.this.jOV.rz(false);
                return;
            }
            c.this.jOV.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jPb = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jOV.bSc();
            c.this.jOW.CV(c.this.eXm);
            c.this.cOZ();
        }
    };
    private b.a jPc = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jOV.hideLoadingView();
            c.this.jOV.Yb();
            if (z || z2) {
                c.this.jOV.b((f.e) null);
            } else {
                c.this.jOV.b(c.this.CT(i));
            }
            if (!c.this.cPa()) {
                if (!y.isEmpty(c.this.jOW.cPb()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jOV.rB(c.this.jOY.isShowing());
                    c.this.jOV.cPq();
                    c.this.jOY.setData(c.this.jOW.cPb());
                }
                if (i != 0) {
                    c.this.jOV.bl(c.this.jOW.getDataList());
                    c.this.jOV.C(c.this.jPd);
                } else if (y.isEmpty(c.this.jOV.getDataList())) {
                    c.this.jOV.showNoDataView();
                } else if (z) {
                    c.this.jOV.bSb();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void n(int i, String str, boolean z) {
            c.this.jOV.b((f.e) null);
            c.this.jOV.hideLoadingView();
            c.this.jOV.Yb();
            if (y.isEmpty(c.this.jOV.getDataList())) {
                c.this.jOV.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jOV.C(c.this.jPd);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jPd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jOV != null && c.this.jOW != null) {
                c.this.jOV.bSc();
                c.this.jOW.CV(c.this.eXm);
            }
        }
    };
    private b.a jPe = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOX() {
            c.this.jOV.qf(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eXm = aVar.sub_class_id;
                c.this.CS(aVar.sub_class_id);
                if (c.this.jOV != null) {
                    c.this.jOV.CQ(aVar.sub_class_id);
                    c.this.jOV.rB(false);
                    c.this.jOV.Mu(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cOY() {
            if (c.this.jOV != null) {
                c.this.jOV.rB(false);
                c.this.jOV.qf(false);
            }
        }
    };
    private a.InterfaceC0759a jOK = new a.InterfaceC0759a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0759a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eXm = aVar.sub_class_id;
                c.this.CS(aVar.sub_class_id);
                if (c.this.jOV != null) {
                    c.this.jOV.CQ(aVar.sub_class_id);
                    c.this.jOV.rB(false);
                    c.this.jOV.Mu(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOV = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jOZ);
        this.jOW = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jPc);
        this.jOY = new b(tbPageContext, this.mBdUniqueId);
        this.jOY.a(this.jPe);
        this.jOX = new a(tbPageContext, this.mBdUniqueId);
        this.jOX.a(this.jOK);
        this.jOV.D(this.jPa);
        this.eXm = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jOV.CQ(this.eXm);
    }

    public void init() {
        this.jOW.registerListener();
        this.jOV.init();
        this.jOV.setListPullRefreshListener(this.gsl);
        this.jOV.a(this.jPb);
        MessageManager.getInstance().registerListener(this.iBK);
    }

    public View getView() {
        if (this.jOV != null) {
            return this.jOV.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOZ() {
        TiebaStatic.log(new ar("c13493").al("obj_type", this.eXm));
    }

    public void loadData() {
        if (this.jOV != null) {
            this.jOV.cPk();
            this.jOV.showLoadingView();
        }
        if (this.jOW != null) {
            this.jOW.CU(this.eXm);
        }
    }

    public void VC() {
        if (this.jOV != null) {
            this.jOV.cPg();
            this.jOV.startPullRefresh();
            this.jOV.rz(false);
            this.jOV.cPi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS(int i) {
        if (this.jOY != null) {
            this.jOY.CR(i);
        }
        if (this.jOW != null) {
            this.jOW.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPa() {
        if (this.jOW == null || y.isEmpty(this.jOW.cPb()) || (!(this.jOW.cPc() || this.eXm == 0) || this.jOX == null)) {
            return false;
        }
        this.jOX.setData(this.jOW.cPb());
        this.jOX.bE((ViewGroup) this.jOV.getRootView());
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
        if (this.jOV != null) {
            this.jOV.bvt();
        }
        if (this.jOY != null) {
            this.jOY.onChangeSkinType();
        }
        if (this.jOX != null) {
            this.jOX.onChangeSkinType();
        }
        if (this.jOY.isShowing()) {
            ap.setBackgroundResource(this.jOV.cPm(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.jOV.cPm(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.jOV != null) {
            this.jOV.onPause();
            this.jOV.cNB();
            this.jOV.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jOV != null) {
            this.jOV.setListPullRefreshListener(null);
            this.jOV.a((BdListView.e) null);
            this.jOV.onDestroy();
        }
        if (this.jOY != null) {
            this.jOY.onDestroy();
        }
        if (this.jOX != null) {
            this.jOX.onDestroy();
        }
        if (this.jOW != null) {
            this.jOW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iBK);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").al("obj_type", this.eXm));
            if (!this.jOY.isShowing()) {
                this.jOV.setViewForeground();
                return;
            }
            return;
        }
        if (this.jOY != null) {
            this.jOY.cOV();
        }
        this.jOV.cNB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jOW != null && !y.isEmpty(this.jOW.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jOW.Lx(optString);
            this.jOW.Mt(optString);
            if (this.jOV != null) {
                this.jOV.Mv(optString);
            }
        }
    }
}
