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
import com.baidu.tbadk.core.data.av;
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
/* loaded from: classes2.dex */
public class c {
    private int ffT;
    private com.baidu.tieba.homepage.gamevideo.view.b khw;
    private com.baidu.tieba.homepage.gamevideo.d.b khx;
    private a khy;
    private b khz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iQU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.khw != null) {
                c.this.khw.cQH();
            }
        }
    };
    private NEGFeedBackView.a khA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar != null) {
                TiebaStatic.log(new ar("c13500").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ar("c13499").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).aq("obj_type", c.this.ffT).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            int i = 0;
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (avVar.threadType == 0) {
                    i = 1;
                } else if (avVar.threadType == 40) {
                    i = 2;
                } else if (avVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.khw != null) {
                    c.this.khw.KA();
                }
                TiebaStatic.log(new ar("c13500").dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).aq(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener khB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.khw.cQP()) {
                c.this.khw.sf(true);
                if (c.this.khz.isShowing()) {
                    c.this.khz.cQu();
                    c.this.khw.cQO();
                    ap.setBackgroundResource(c.this.khw.cQM(), R.color.CAM_X0207);
                    return;
                }
                c.this.khz.de(c.this.khw.cQM());
                c.this.khw.cQN();
                ap.setBackgroundResource(c.this.khw.cQM(), R.color.CAM_X0201);
                if (c.this.khx != null && !y.isEmpty(c.this.khx.cQB())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.khx.BU(c.this.ffT);
                c.this.cQz();
                c.this.khw.se(false);
                return;
            }
            c.this.khw.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e khC = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.khw.bRE();
            c.this.khx.BV(c.this.ffT);
            c.this.cQz();
        }
    };
    private b.a khD = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.khw.hideLoadingView();
            c.this.khw.Xc();
            if (z || z2) {
                c.this.khw.b((f.e) null);
            } else {
                c.this.khw.b(c.this.BT(i));
            }
            if (!c.this.cQA()) {
                if (!y.isEmpty(c.this.khx.cQB()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.brR().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.khw.sg(c.this.khz.isShowing());
                    c.this.khw.cQQ();
                    c.this.khz.setData(c.this.khx.cQB());
                }
                if (i != 0) {
                    c.this.khw.bn(c.this.khx.getDataList());
                    c.this.khw.F(c.this.khE);
                } else if (y.isEmpty(c.this.khw.getDataList())) {
                    c.this.khw.showNoDataView();
                } else if (z) {
                    c.this.khw.bRD();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.khw.b((f.e) null);
            c.this.khw.hideLoadingView();
            c.this.khw.Xc();
            if (y.isEmpty(c.this.khw.getDataList())) {
                c.this.khw.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.khw.F(c.this.khE);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener khE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.khw != null && c.this.khx != null) {
                c.this.khw.bRE();
                c.this.khx.BV(c.this.ffT);
            }
        }
    };
    private b.a khF = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQx() {
            c.this.khw.qJ(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ffT = aVar.sub_class_id;
                c.this.BS(aVar.sub_class_id);
                if (c.this.khw != null) {
                    c.this.khw.BQ(aVar.sub_class_id);
                    c.this.khw.sg(false);
                    c.this.khw.Md(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQy() {
            if (c.this.khw != null) {
                c.this.khw.sg(false);
                c.this.khw.qJ(false);
            }
        }
    };
    private a.InterfaceC0751a khl = new a.InterfaceC0751a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0751a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ffT = aVar.sub_class_id;
                c.this.BS(aVar.sub_class_id);
                if (c.this.khw != null) {
                    c.this.khw.BQ(aVar.sub_class_id);
                    c.this.khw.sg(false);
                    c.this.khw.Md(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.khw = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.khA);
        this.khx = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.khD);
        this.khz = new b(tbPageContext, this.mBdUniqueId);
        this.khz.a(this.khF);
        this.khy = new a(tbPageContext, this.mBdUniqueId);
        this.khy.a(this.khl);
        this.khw.G(this.khB);
        this.ffT = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.khw.BQ(this.ffT);
    }

    public void init() {
        this.khx.registerListener();
        this.khw.init();
        this.khw.setListPullRefreshListener(this.gDk);
        this.khw.a(this.khC);
        MessageManager.getInstance().registerListener(this.iQU);
    }

    public View getView() {
        if (this.khw != null) {
            return this.khw.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQz() {
        TiebaStatic.log(new ar("c13493").aq("obj_type", this.ffT));
    }

    public void loadData() {
        if (this.khw != null) {
            this.khw.cQK();
            this.khw.showLoadingView();
        }
        if (this.khx != null) {
            this.khx.BU(this.ffT);
        }
    }

    public void Uw() {
        if (this.khw != null) {
            this.khw.cQG();
            this.khw.startPullRefresh();
            this.khw.se(false);
            this.khw.cQI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS(int i) {
        if (this.khz != null) {
            this.khz.BR(i);
        }
        if (this.khx != null) {
            this.khx.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQA() {
        if (this.khx == null || y.isEmpty(this.khx.cQB()) || (!(this.khx.cQC() || this.ffT == 0) || this.khy == null)) {
            return false;
        }
        this.khy.setData(this.khx.cQB());
        this.khy.bS((ViewGroup) this.khw.getRootView());
        com.baidu.tbadk.core.sharedPref.b.brR().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.brR().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bus() {
        if (this.khw != null) {
            this.khw.bus();
        }
        if (this.khz != null) {
            this.khz.onChangeSkinType();
        }
        if (this.khy != null) {
            this.khy.onChangeSkinType();
        }
        if (this.khz.isShowing()) {
            ap.setBackgroundResource(this.khw.cQM(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.khw.cQM(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.khw != null) {
            this.khw.onPause();
            this.khw.cPb();
            this.khw.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.khw != null) {
            this.khw.setListPullRefreshListener(null);
            this.khw.a((BdListView.e) null);
            this.khw.onDestroy();
        }
        if (this.khz != null) {
            this.khz.onDestroy();
        }
        if (this.khy != null) {
            this.khy.onDestroy();
        }
        if (this.khx != null) {
            this.khx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iQU);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").aq("obj_type", this.ffT));
            if (!this.khz.isShowing()) {
                this.khw.setViewForeground();
                return;
            }
            return;
        }
        if (this.khz != null) {
            this.khz.cQv();
        }
        this.khw.cPb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.khx != null && !y.isEmpty(this.khx.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.khx.Lh(optString);
            this.khx.Mc(optString);
            if (this.khw != null) {
                this.khw.Me(optString);
            }
        }
    }
}
