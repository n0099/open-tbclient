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
    private com.baidu.tieba.homepage.gamevideo.d.b ibA;
    private a ibB;
    private b ibC;
    private com.baidu.tieba.homepage.gamevideo.view.b ibz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gWm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.ibz != null) {
                c.this.ibz.cfH();
            }
        }
    };
    private NEGFeedBackView.a ibD = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
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
                if (c.this.ibz != null) {
                    c.this.ibz.CZ();
                }
                TiebaStatic.log(new an("c13500").dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener ibE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.ibz.cfP()) {
                c.this.ibz.ok(true);
                if (c.this.ibC.isShowing()) {
                    c.this.ibC.cfu();
                    c.this.ibz.cfO();
                    am.setBackgroundResource(c.this.ibz.cfM(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.ibC.cg(c.this.ibz.cfM());
                c.this.ibz.cfN();
                am.setBackgroundResource(c.this.ibz.cfM(), R.color.cp_bg_line_d);
                if (c.this.ibA != null && !v.isEmpty(c.this.ibA.cfB())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fdl = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.ibA.wC(c.this.dRA);
                c.this.cfz();
                c.this.ibz.oj(false);
                return;
            }
            c.this.ibz.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e ibF = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.ibz.bqM();
            c.this.ibA.wD(c.this.dRA);
            c.this.cfz();
        }
    };
    private b.a ibG = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.ibz.hideLoadingView();
            c.this.ibz.bqQ();
            if (z || z2) {
                c.this.ibz.b((f.e) null);
            } else {
                c.this.ibz.b(c.this.wB(i));
            }
            if (!c.this.cfA()) {
                if (!v.isEmpty(c.this.ibA.cfB()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.ibz.ol(c.this.ibC.isShowing());
                    c.this.ibz.cfQ();
                    c.this.ibC.setData(c.this.ibA.cfB());
                }
                if (i != 0) {
                    c.this.ibz.az(c.this.ibA.getDataList());
                    c.this.ibz.z(c.this.ibH);
                } else if (v.isEmpty(c.this.ibz.getDataList())) {
                    c.this.ibz.showNoDataView();
                } else if (z) {
                    c.this.ibz.bqL();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.ibz.b((f.e) null);
            c.this.ibz.hideLoadingView();
            c.this.ibz.bqQ();
            if (v.isEmpty(c.this.ibz.getDataList())) {
                c.this.ibz.k(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.ibz.z(c.this.ibH);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener ibH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ibz != null && c.this.ibA != null) {
                c.this.ibz.bqM();
                c.this.ibA.wD(c.this.dRA);
            }
        }
    };
    private b.a ibI = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cfx() {
            c.this.ibz.mX(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dRA = aVar.sub_class_id;
                c.this.wA(aVar.sub_class_id);
                if (c.this.ibz != null) {
                    c.this.ibz.wy(aVar.sub_class_id);
                    c.this.ibz.ol(false);
                    c.this.ibz.FC(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cfy() {
            if (c.this.ibz != null) {
                c.this.ibz.ol(false);
                c.this.ibz.mX(false);
            }
        }
    };
    private a.InterfaceC0625a ibo = new a.InterfaceC0625a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0625a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dRA = aVar.sub_class_id;
                c.this.wA(aVar.sub_class_id);
                if (c.this.ibz != null) {
                    c.this.ibz.wy(aVar.sub_class_id);
                    c.this.ibz.ol(false);
                    c.this.ibz.FC(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ibz = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.ibD);
        this.ibA = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.ibG);
        this.ibC = new b(tbPageContext, this.mBdUniqueId);
        this.ibC.a(this.ibI);
        this.ibB = new a(tbPageContext, this.mBdUniqueId);
        this.ibB.a(this.ibo);
        this.ibz.A(this.ibE);
        this.dRA = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.ibz.wy(this.dRA);
    }

    public void init() {
        this.ibA.registerListener();
        this.ibz.init();
        this.ibz.setListPullRefreshListener(this.fdl);
        this.ibz.a(this.ibF);
        MessageManager.getInstance().registerListener(this.gWm);
    }

    public View getView() {
        if (this.ibz != null) {
            return this.ibz.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfz() {
        TiebaStatic.log(new an("c13493").ag("obj_type", this.dRA));
    }

    public void loadData() {
        if (this.ibz != null) {
            this.ibz.cfK();
            this.ibz.showLoadingView();
        }
        if (this.ibA != null) {
            this.ibA.wC(this.dRA);
        }
    }

    public void Ho() {
        if (this.ibz != null) {
            this.ibz.cfG();
            this.ibz.startPullRefresh();
            this.ibz.oj(false);
            this.ibz.cfI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(int i) {
        if (this.ibC != null) {
            this.ibC.wz(i);
        }
        if (this.ibA != null) {
            this.ibA.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfA() {
        if (this.ibA == null || v.isEmpty(this.ibA.cfB()) || (!(this.ibA.cfC() || this.dRA == 0) || this.ibB == null)) {
            return false;
        }
        this.ibB.setData(this.ibA.cfB());
        this.ibB.bw((ViewGroup) this.ibz.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aTX().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aTX().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e wB(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aWr() {
        if (this.ibz != null) {
            this.ibz.aWr();
        }
        if (this.ibC != null) {
            this.ibC.onChangeSkinType();
        }
        if (this.ibB != null) {
            this.ibB.onChangeSkinType();
        }
        if (this.ibC.isShowing()) {
            am.setBackgroundResource(this.ibz.cfM(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.ibz.cfM(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.ibz != null) {
            this.ibz.onPause();
            this.ibz.ceA();
            this.ibz.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ibz != null) {
            this.ibz.setListPullRefreshListener(null);
            this.ibz.a((BdListView.e) null);
            this.ibz.onDestroy();
        }
        if (this.ibC != null) {
            this.ibC.onDestroy();
        }
        if (this.ibB != null) {
            this.ibB.onDestroy();
        }
        if (this.ibA != null) {
            this.ibA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gWm);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").ag("obj_type", this.dRA));
            if (!this.ibC.isShowing()) {
                this.ibz.setViewForeground();
                return;
            }
            return;
        }
        if (this.ibC != null) {
            this.ibC.cfv();
        }
        this.ibz.ceA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ibA != null && !v.isEmpty(this.ibA.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ibA.EY(optString);
            this.ibA.FB(optString);
            if (this.ibz != null) {
                this.ibz.FD(optString);
            }
        }
    }
}
