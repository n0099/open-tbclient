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
    private int feu;
    private com.baidu.tieba.homepage.gamevideo.view.b kfg;
    private com.baidu.tieba.homepage.gamevideo.d.b kfh;
    private a kfi;
    private b kfj;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iOX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.kfg != null) {
                c.this.kfg.cQt();
            }
        }
    };
    private NEGFeedBackView.a kfk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar != null) {
                TiebaStatic.log(new ar("c13500").dR("obj_locate", "1").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ar("c13499").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).ap("obj_type", c.this.feu).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.kfg != null) {
                    c.this.kfg.Kx();
                }
                TiebaStatic.log(new ar("c13500").dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener kfl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.kfg.cQB()) {
                c.this.kfg.sf(true);
                if (c.this.kfj.isShowing()) {
                    c.this.kfj.cQg();
                    c.this.kfg.cQA();
                    ap.setBackgroundResource(c.this.kfg.cQy(), R.color.CAM_X0207);
                    return;
                }
                c.this.kfj.de(c.this.kfg.cQy());
                c.this.kfg.cQz();
                ap.setBackgroundResource(c.this.kfg.cQy(), R.color.CAM_X0201);
                if (c.this.kfh != null && !y.isEmpty(c.this.kfh.cQn())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gBn = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.kfh.BR(c.this.feu);
                c.this.cQl();
                c.this.kfg.se(false);
                return;
            }
            c.this.kfg.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e kfm = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.kfg.bRr();
            c.this.kfh.BS(c.this.feu);
            c.this.cQl();
        }
    };
    private b.a kfn = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.kfg.hideLoadingView();
            c.this.kfg.WZ();
            if (z || z2) {
                c.this.kfg.b((f.e) null);
            } else {
                c.this.kfg.b(c.this.BQ(i));
            }
            if (!c.this.cQm()) {
                if (!y.isEmpty(c.this.kfh.cQn()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.kfg.sg(c.this.kfj.isShowing());
                    c.this.kfg.cQC();
                    c.this.kfj.setData(c.this.kfh.cQn());
                }
                if (i != 0) {
                    c.this.kfg.bn(c.this.kfh.getDataList());
                    c.this.kfg.E(c.this.kfo);
                } else if (y.isEmpty(c.this.kfg.getDataList())) {
                    c.this.kfg.showNoDataView();
                } else if (z) {
                    c.this.kfg.bRq();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.kfg.b((f.e) null);
            c.this.kfg.hideLoadingView();
            c.this.kfg.WZ();
            if (y.isEmpty(c.this.kfg.getDataList())) {
                c.this.kfg.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.kfg.E(c.this.kfo);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener kfo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kfg != null && c.this.kfh != null) {
                c.this.kfg.bRr();
                c.this.kfh.BS(c.this.feu);
            }
        }
    };
    private b.a kfp = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQj() {
            c.this.kfg.qJ(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.feu = aVar.sub_class_id;
                c.this.BP(aVar.sub_class_id);
                if (c.this.kfg != null) {
                    c.this.kfg.BN(aVar.sub_class_id);
                    c.this.kfg.sg(false);
                    c.this.kfg.LW(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQk() {
            if (c.this.kfg != null) {
                c.this.kfg.sg(false);
                c.this.kfg.qJ(false);
            }
        }
    };
    private a.InterfaceC0744a keV = new a.InterfaceC0744a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0744a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.feu = aVar.sub_class_id;
                c.this.BP(aVar.sub_class_id);
                if (c.this.kfg != null) {
                    c.this.kfg.BN(aVar.sub_class_id);
                    c.this.kfg.sg(false);
                    c.this.kfg.LW(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfg = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.kfk);
        this.kfh = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.kfn);
        this.kfj = new b(tbPageContext, this.mBdUniqueId);
        this.kfj.a(this.kfp);
        this.kfi = new a(tbPageContext, this.mBdUniqueId);
        this.kfi.a(this.keV);
        this.kfg.F(this.kfl);
        this.feu = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.kfg.BN(this.feu);
    }

    public void init() {
        this.kfh.registerListener();
        this.kfg.init();
        this.kfg.setListPullRefreshListener(this.gBn);
        this.kfg.a(this.kfm);
        MessageManager.getInstance().registerListener(this.iOX);
    }

    public View getView() {
        if (this.kfg != null) {
            return this.kfg.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQl() {
        TiebaStatic.log(new ar("c13493").ap("obj_type", this.feu));
    }

    public void loadData() {
        if (this.kfg != null) {
            this.kfg.cQw();
            this.kfg.showLoadingView();
        }
        if (this.kfh != null) {
            this.kfh.BR(this.feu);
        }
    }

    public void Ut() {
        if (this.kfg != null) {
            this.kfg.cQs();
            this.kfg.startPullRefresh();
            this.kfg.se(false);
            this.kfg.cQu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(int i) {
        if (this.kfj != null) {
            this.kfj.BO(i);
        }
        if (this.kfh != null) {
            this.kfh.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQm() {
        if (this.kfh == null || y.isEmpty(this.kfh.cQn()) || (!(this.kfh.cQo() || this.feu == 0) || this.kfi == null)) {
            return false;
        }
        this.kfi.setData(this.kfh.cQn());
        this.kfi.bT((ViewGroup) this.kfg.getRootView());
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BQ(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bup() {
        if (this.kfg != null) {
            this.kfg.bup();
        }
        if (this.kfj != null) {
            this.kfj.onChangeSkinType();
        }
        if (this.kfi != null) {
            this.kfi.onChangeSkinType();
        }
        if (this.kfj.isShowing()) {
            ap.setBackgroundResource(this.kfg.cQy(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.kfg.cQy(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.kfg != null) {
            this.kfg.onPause();
            this.kfg.cON();
            this.kfg.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kfg != null) {
            this.kfg.setListPullRefreshListener(null);
            this.kfg.a((BdListView.e) null);
            this.kfg.onDestroy();
        }
        if (this.kfj != null) {
            this.kfj.onDestroy();
        }
        if (this.kfi != null) {
            this.kfi.onDestroy();
        }
        if (this.kfh != null) {
            this.kfh.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iOX);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").ap("obj_type", this.feu));
            if (!this.kfj.isShowing()) {
                this.kfg.setViewForeground();
                return;
            }
            return;
        }
        if (this.kfj != null) {
            this.kfj.cQh();
        }
        this.kfg.cON();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kfh != null && !y.isEmpty(this.kfh.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kfh.KX(optString);
            this.kfh.LV(optString);
            if (this.kfg != null) {
                this.kfg.LX(optString);
            }
        }
    }
}
