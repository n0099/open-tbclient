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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
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
    private int ddo;
    private com.baidu.tieba.homepage.gamevideo.view.b haT;
    private com.baidu.tieba.homepage.gamevideo.d.b haU;
    private a haV;
    private b haW;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.haT != null) {
                c.this.haT.bOm();
            }
        }
    };
    private NEGFeedBackView.a haX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).X("obj_type", c.this.ddo).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            int i = 0;
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (alVar.threadType == 0) {
                    i = 1;
                } else if (alVar.threadType == 40) {
                    i = 2;
                } else if (alVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.haT != null) {
                    c.this.haT.wN();
                }
                TiebaStatic.log(new an("c13500").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener haY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.haT.bOu()) {
                c.this.haT.mE(true);
                if (c.this.haW.isShowing()) {
                    c.this.haW.bNZ();
                    c.this.haT.bOt();
                    am.setBackgroundResource(c.this.haT.bOr(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.haW.bY(c.this.haT.bOr());
                c.this.haT.bOs();
                am.setBackgroundResource(c.this.haT.bOr(), R.color.cp_bg_line_d);
                if (c.this.haU != null && !v.isEmpty(c.this.haU.bOg())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c emi = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.haU.vp(c.this.ddo);
                c.this.bOe();
                c.this.haT.mD(false);
                return;
            }
            c.this.haT.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e haZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.haT.bcs();
            c.this.haU.vq(c.this.ddo);
            c.this.bOe();
        }
    };
    private b.a hba = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.haT.hideLoadingView();
            c.this.haT.bcv();
            if (z || z2) {
                c.this.haT.b((g.e) null);
            } else {
                c.this.haT.b(c.this.vo(i));
            }
            if (!c.this.bOf()) {
                if (!v.isEmpty(c.this.haU.bOg()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.haT.mF(c.this.haW.isShowing());
                    c.this.haT.bOv();
                    c.this.haW.setData(c.this.haU.bOg());
                }
                if (i != 0) {
                    c.this.haT.av(c.this.haU.getDataList());
                    c.this.haT.z(c.this.hbb);
                } else if (v.isEmpty(c.this.haT.getDataList())) {
                    c.this.haT.showNoDataView();
                } else if (z) {
                    c.this.haT.bcr();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.haT.b((g.e) null);
            c.this.haT.hideLoadingView();
            c.this.haT.bcv();
            if (v.isEmpty(c.this.haT.getDataList())) {
                c.this.haT.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.haT.z(c.this.hbb);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hbb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.haT != null && c.this.haU != null) {
                c.this.haT.bcs();
                c.this.haU.vq(c.this.ddo);
            }
        }
    };
    private b.a hbc = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOc() {
            c.this.haT.lt(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddo = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.haT != null) {
                    c.this.haT.vl(aVar.sub_class_id);
                    c.this.haT.mF(false);
                    c.this.haT.Ch(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOd() {
            if (c.this.haT != null) {
                c.this.haT.mF(false);
                c.this.haT.lt(false);
            }
        }
    };
    private a.InterfaceC0517a haI = new a.InterfaceC0517a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0517a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddo = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.haT != null) {
                    c.this.haT.vl(aVar.sub_class_id);
                    c.this.haT.mF(false);
                    c.this.haT.Ch(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haT = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.haX);
        this.haU = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hba);
        this.haW = new b(tbPageContext, this.mBdUniqueId);
        this.haW.a(this.hbc);
        this.haV = new a(tbPageContext, this.mBdUniqueId);
        this.haV.a(this.haI);
        this.haT.A(this.haY);
        this.ddo = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.haT.vl(this.ddo);
    }

    public void init() {
        this.haU.registerListener();
        this.haT.init();
        this.haT.setListPullRefreshListener(this.emi);
        this.haT.a(this.haZ);
        MessageManager.getInstance().registerListener(this.gHx);
    }

    public View getView() {
        if (this.haT != null) {
            return this.haT.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOe() {
        TiebaStatic.log(new an("c13493").X("obj_type", this.ddo));
    }

    public void loadData() {
        if (this.haT != null) {
            this.haT.bOp();
            this.haT.showLoadingView();
        }
        if (this.haU != null) {
            this.haU.vp(this.ddo);
        }
    }

    public void AA() {
        if (this.haT != null) {
            this.haT.bOl();
            this.haT.startPullRefresh();
            this.haT.mD(false);
            this.haT.bOn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        if (this.haW != null) {
            this.haW.vm(i);
        }
        if (this.haU != null) {
            this.haU.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOf() {
        if (this.haU == null || v.isEmpty(this.haU.bOg()) || (!(this.haU.bOh() || this.ddo == 0) || this.haV == null)) {
            return false;
        }
        this.haV.setData(this.haU.bOg());
        this.haV.bj((ViewGroup) this.haT.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aFB().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aFB().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vo(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aHL() {
        if (this.haT != null) {
            this.haT.aHL();
        }
        if (this.haW != null) {
            this.haW.onChangeSkinType();
        }
        if (this.haV != null) {
            this.haV.onChangeSkinType();
        }
        if (this.haW.isShowing()) {
            am.setBackgroundResource(this.haT.bOr(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.haT.bOr(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.haT != null) {
            this.haT.onPause();
            this.haT.bNd();
            this.haT.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.haT != null) {
            this.haT.setListPullRefreshListener(null);
            this.haT.a((BdListView.e) null);
            this.haT.onDestroy();
        }
        if (this.haW != null) {
            this.haW.onDestroy();
        }
        if (this.haV != null) {
            this.haV.onDestroy();
        }
        if (this.haU != null) {
            this.haU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHx);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").X("obj_type", this.ddo));
            if (!this.haW.isShowing()) {
                this.haT.setViewForeground();
                return;
            }
            return;
        }
        if (this.haW != null) {
            this.haW.bOa();
        }
        this.haT.bNd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.haU != null && !v.isEmpty(this.haU.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.haU.BB(optString);
            this.haU.Cg(optString);
            if (this.haT != null) {
                this.haT.Ci(optString);
            }
        }
    }
}
