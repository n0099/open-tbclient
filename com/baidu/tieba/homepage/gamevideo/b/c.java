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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private int dRA;
    private com.baidu.tieba.homepage.gamevideo.view.b iaM;
    private com.baidu.tieba.homepage.gamevideo.d.b iaN;
    private a iaO;
    private b iaP;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gWb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iaM != null) {
                c.this.iaM.cfy();
            }
        }
    };
    private NEGFeedBackView.a iaQ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ak akVar) {
            if (akVar != null) {
                TiebaStatic.log(new an("c13500").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).ag("obj_type", c.this.dRA).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ak akVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
            int i = 0;
            if (arrayList != null && akVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (akVar.threadType == 0) {
                    i = 1;
                } else if (akVar.threadType == 40) {
                    i = 2;
                } else if (akVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.iaM != null) {
                    c.this.iaM.CZ();
                }
                TiebaStatic.log(new an("c13500").dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iaR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iaM.cfG()) {
                c.this.iaM.ok(true);
                if (c.this.iaP.isShowing()) {
                    c.this.iaP.cfl();
                    c.this.iaM.cfF();
                    am.setBackgroundResource(c.this.iaM.cfD(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iaP.cg(c.this.iaM.cfD());
                c.this.iaM.cfE();
                am.setBackgroundResource(c.this.iaM.cfD(), R.color.cp_bg_line_d);
                if (c.this.iaN != null && !v.isEmpty(c.this.iaN.cfs())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fda = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iaN.wA(c.this.dRA);
                c.this.cfq();
                c.this.iaM.oj(false);
                return;
            }
            c.this.iaM.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iaS = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iaM.bqK();
            c.this.iaN.wB(c.this.dRA);
            c.this.cfq();
        }
    };
    private b.a iaT = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.iaM.hideLoadingView();
            c.this.iaM.bqO();
            if (z || z2) {
                c.this.iaM.b((f.e) null);
            } else {
                c.this.iaM.b(c.this.wz(i));
            }
            if (!c.this.cfr()) {
                if (!v.isEmpty(c.this.iaN.cfs()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iaM.ol(c.this.iaP.isShowing());
                    c.this.iaM.cfH();
                    c.this.iaP.setData(c.this.iaN.cfs());
                }
                if (i != 0) {
                    c.this.iaM.az(c.this.iaN.getDataList());
                    c.this.iaM.z(c.this.iaU);
                } else if (v.isEmpty(c.this.iaM.getDataList())) {
                    c.this.iaM.showNoDataView();
                } else if (z) {
                    c.this.iaM.bqJ();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.iaM.b((f.e) null);
            c.this.iaM.hideLoadingView();
            c.this.iaM.bqO();
            if (v.isEmpty(c.this.iaM.getDataList())) {
                c.this.iaM.k(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iaM.z(c.this.iaU);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iaU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iaM != null && c.this.iaN != null) {
                c.this.iaM.bqK();
                c.this.iaN.wB(c.this.dRA);
            }
        }
    };
    private b.a iaV = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cfo() {
            c.this.iaM.mX(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dRA = aVar.sub_class_id;
                c.this.wy(aVar.sub_class_id);
                if (c.this.iaM != null) {
                    c.this.iaM.ww(aVar.sub_class_id);
                    c.this.iaM.ol(false);
                    c.this.iaM.FC(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cfp() {
            if (c.this.iaM != null) {
                c.this.iaM.ol(false);
                c.this.iaM.mX(false);
            }
        }
    };
    private a.InterfaceC0625a iaB = new a.InterfaceC0625a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0625a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dRA = aVar.sub_class_id;
                c.this.wy(aVar.sub_class_id);
                if (c.this.iaM != null) {
                    c.this.iaM.ww(aVar.sub_class_id);
                    c.this.iaM.ol(false);
                    c.this.iaM.FC(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iaM = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iaQ);
        this.iaN = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iaT);
        this.iaP = new b(tbPageContext, this.mBdUniqueId);
        this.iaP.a(this.iaV);
        this.iaO = new a(tbPageContext, this.mBdUniqueId);
        this.iaO.a(this.iaB);
        this.iaM.A(this.iaR);
        this.dRA = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iaM.ww(this.dRA);
    }

    public void init() {
        this.iaN.registerListener();
        this.iaM.init();
        this.iaM.setListPullRefreshListener(this.fda);
        this.iaM.a(this.iaS);
        MessageManager.getInstance().registerListener(this.gWb);
    }

    public View getView() {
        if (this.iaM != null) {
            return this.iaM.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfq() {
        TiebaStatic.log(new an("c13493").ag("obj_type", this.dRA));
    }

    public void loadData() {
        if (this.iaM != null) {
            this.iaM.cfB();
            this.iaM.showLoadingView();
        }
        if (this.iaN != null) {
            this.iaN.wA(this.dRA);
        }
    }

    public void Ho() {
        if (this.iaM != null) {
            this.iaM.cfx();
            this.iaM.startPullRefresh();
            this.iaM.oj(false);
            this.iaM.cfz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy(int i) {
        if (this.iaP != null) {
            this.iaP.wx(i);
        }
        if (this.iaN != null) {
            this.iaN.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfr() {
        if (this.iaN == null || v.isEmpty(this.iaN.cfs()) || (!(this.iaN.cft() || this.dRA == 0) || this.iaO == null)) {
            return false;
        }
        this.iaO.setData(this.iaN.cfs());
        this.iaO.bw((ViewGroup) this.iaM.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aTX().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aTX().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e wz(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aWq() {
        if (this.iaM != null) {
            this.iaM.aWq();
        }
        if (this.iaP != null) {
            this.iaP.onChangeSkinType();
        }
        if (this.iaO != null) {
            this.iaO.onChangeSkinType();
        }
        if (this.iaP.isShowing()) {
            am.setBackgroundResource(this.iaM.cfD(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.iaM.cfD(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iaM != null) {
            this.iaM.onPause();
            this.iaM.ces();
            this.iaM.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iaM != null) {
            this.iaM.setListPullRefreshListener(null);
            this.iaM.a((BdListView.e) null);
            this.iaM.onDestroy();
        }
        if (this.iaP != null) {
            this.iaP.onDestroy();
        }
        if (this.iaO != null) {
            this.iaO.onDestroy();
        }
        if (this.iaN != null) {
            this.iaN.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gWb);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").ag("obj_type", this.dRA));
            if (!this.iaP.isShowing()) {
                this.iaM.setViewForeground();
                return;
            }
            return;
        }
        if (this.iaP != null) {
            this.iaP.cfm();
        }
        this.iaM.ces();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iaN != null && !v.isEmpty(this.iaN.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iaN.EY(optString);
            this.iaN.FB(optString);
            if (this.iaM != null) {
                this.iaM.FD(optString);
            }
        }
    }
}
