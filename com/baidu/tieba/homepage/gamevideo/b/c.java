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
    private com.baidu.tieba.homepage.gamevideo.view.b kfu;
    private com.baidu.tieba.homepage.gamevideo.d.b kfv;
    private a kfw;
    private b kfx;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iPl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.kfu != null) {
                c.this.kfu.cQA();
            }
        }
    };
    private NEGFeedBackView.a kfy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
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
                if (c.this.kfu != null) {
                    c.this.kfu.Kx();
                }
                TiebaStatic.log(new ar("c13500").dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", avVar.getFid()).dR("obj_param1", avVar.weight).dR("obj_source", avVar.source).dR("obj_id", avVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ap(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener kfz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.kfu.cQI()) {
                c.this.kfu.sf(true);
                if (c.this.kfx.isShowing()) {
                    c.this.kfx.cQn();
                    c.this.kfu.cQH();
                    ap.setBackgroundResource(c.this.kfu.cQF(), R.color.CAM_X0207);
                    return;
                }
                c.this.kfx.de(c.this.kfu.cQF());
                c.this.kfu.cQG();
                ap.setBackgroundResource(c.this.kfu.cQF(), R.color.CAM_X0201);
                if (c.this.kfv != null && !y.isEmpty(c.this.kfv.cQu())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c gBB = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.kfv.BR(c.this.feu);
                c.this.cQs();
                c.this.kfu.se(false);
                return;
            }
            c.this.kfu.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e kfA = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.kfu.bRy();
            c.this.kfv.BS(c.this.feu);
            c.this.cQs();
        }
    };
    private b.a kfB = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.kfu.hideLoadingView();
            c.this.kfu.WZ();
            if (z || z2) {
                c.this.kfu.b((f.e) null);
            } else {
                c.this.kfu.b(c.this.BQ(i));
            }
            if (!c.this.cQt()) {
                if (!y.isEmpty(c.this.kfv.cQu()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.kfu.sg(c.this.kfx.isShowing());
                    c.this.kfu.cQJ();
                    c.this.kfx.setData(c.this.kfv.cQu());
                }
                if (i != 0) {
                    c.this.kfu.bn(c.this.kfv.getDataList());
                    c.this.kfu.E(c.this.kfC);
                } else if (y.isEmpty(c.this.kfu.getDataList())) {
                    c.this.kfu.showNoDataView();
                } else if (z) {
                    c.this.kfu.bRx();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.kfu.b((f.e) null);
            c.this.kfu.hideLoadingView();
            c.this.kfu.WZ();
            if (y.isEmpty(c.this.kfu.getDataList())) {
                c.this.kfu.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.kfu.E(c.this.kfC);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener kfC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kfu != null && c.this.kfv != null) {
                c.this.kfu.bRy();
                c.this.kfv.BS(c.this.feu);
            }
        }
    };
    private b.a kfD = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQq() {
            c.this.kfu.qJ(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.feu = aVar.sub_class_id;
                c.this.BP(aVar.sub_class_id);
                if (c.this.kfu != null) {
                    c.this.kfu.BN(aVar.sub_class_id);
                    c.this.kfu.sg(false);
                    c.this.kfu.LX(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cQr() {
            if (c.this.kfu != null) {
                c.this.kfu.sg(false);
                c.this.kfu.qJ(false);
            }
        }
    };
    private a.InterfaceC0745a kfj = new a.InterfaceC0745a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0745a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.feu = aVar.sub_class_id;
                c.this.BP(aVar.sub_class_id);
                if (c.this.kfu != null) {
                    c.this.kfu.BN(aVar.sub_class_id);
                    c.this.kfu.sg(false);
                    c.this.kfu.LX(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfu = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.kfy);
        this.kfv = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.kfB);
        this.kfx = new b(tbPageContext, this.mBdUniqueId);
        this.kfx.a(this.kfD);
        this.kfw = new a(tbPageContext, this.mBdUniqueId);
        this.kfw.a(this.kfj);
        this.kfu.F(this.kfz);
        this.feu = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.kfu.BN(this.feu);
    }

    public void init() {
        this.kfv.registerListener();
        this.kfu.init();
        this.kfu.setListPullRefreshListener(this.gBB);
        this.kfu.a(this.kfA);
        MessageManager.getInstance().registerListener(this.iPl);
    }

    public View getView() {
        if (this.kfu != null) {
            return this.kfu.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQs() {
        TiebaStatic.log(new ar("c13493").ap("obj_type", this.feu));
    }

    public void loadData() {
        if (this.kfu != null) {
            this.kfu.cQD();
            this.kfu.showLoadingView();
        }
        if (this.kfv != null) {
            this.kfv.BR(this.feu);
        }
    }

    public void Ut() {
        if (this.kfu != null) {
            this.kfu.cQz();
            this.kfu.startPullRefresh();
            this.kfu.se(false);
            this.kfu.cQB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(int i) {
        if (this.kfx != null) {
            this.kfx.BO(i);
        }
        if (this.kfv != null) {
            this.kfv.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQt() {
        if (this.kfv == null || y.isEmpty(this.kfv.cQu()) || (!(this.kfv.cQv() || this.feu == 0) || this.kfw == null)) {
            return false;
        }
        this.kfw.setData(this.kfv.cQu());
        this.kfw.bT((ViewGroup) this.kfu.getRootView());
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
        if (this.kfu != null) {
            this.kfu.bup();
        }
        if (this.kfx != null) {
            this.kfx.onChangeSkinType();
        }
        if (this.kfw != null) {
            this.kfw.onChangeSkinType();
        }
        if (this.kfx.isShowing()) {
            ap.setBackgroundResource(this.kfu.cQF(), R.color.CAM_X0201);
        } else {
            ap.setBackgroundResource(this.kfu.cQF(), R.color.CAM_X0207);
        }
    }

    public void onPause() {
        if (this.kfu != null) {
            this.kfu.onPause();
            this.kfu.cOU();
            this.kfu.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kfu != null) {
            this.kfu.setListPullRefreshListener(null);
            this.kfu.a((BdListView.e) null);
            this.kfu.onDestroy();
        }
        if (this.kfx != null) {
            this.kfx.onDestroy();
        }
        if (this.kfw != null) {
            this.kfw.onDestroy();
        }
        if (this.kfv != null) {
            this.kfv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iPl);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ar("c13486").ap("obj_type", this.feu));
            if (!this.kfx.isShowing()) {
                this.kfu.setViewForeground();
                return;
            }
            return;
        }
        if (this.kfx != null) {
            this.kfx.cQo();
        }
        this.kfu.cOU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kfv != null && !y.isEmpty(this.kfv.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kfv.KY(optString);
            this.kfv.LW(optString);
            if (this.kfu != null) {
                this.kfu.LY(optString);
            }
        }
    }
}
