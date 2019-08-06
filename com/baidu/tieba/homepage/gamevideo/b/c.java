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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int bWN;
    private com.baidu.tieba.homepage.gamevideo.view.b ghE;
    private com.baidu.tieba.homepage.gamevideo.d.b ghF;
    private a ghG;
    private b ghH;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener fND = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.ghE != null) {
                c.this.ghE.bwy();
            }
        }
    };
    private NEGFeedBackView.a ghI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                TiebaStatic.log(new an("c13500").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).P("obj_type", c.this.bWN).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
            int i = 0;
            if (arrayList != null && ajVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (ajVar.threadType == 0) {
                    i = 1;
                } else if (ajVar.threadType == 40) {
                    i = 2;
                } else if (ajVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.ghE != null) {
                    c.this.ghE.refreshListView();
                }
                TiebaStatic.log(new an("c13500").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
            }
        }
    };
    private final View.OnClickListener ghJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.ghE.bwG()) {
                c.this.ghE.ln(true);
                if (c.this.ghH.isShowing()) {
                    c.this.ghH.bwk();
                    c.this.ghE.bwF();
                    return;
                }
                c.this.ghH.cb(c.this.ghE.bwD());
                c.this.ghE.bwE();
                if (c.this.ghF != null && !v.aa(c.this.ghF.bwr())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private h.c dnZ = new h.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (j.kc()) {
                c.this.ghF.ud(c.this.bWN);
                c.this.bwp();
                c.this.ghE.lm(false);
                return;
            }
            c.this.ghE.b((h.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e ghK = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.ghE.aJg();
            c.this.ghF.ue(c.this.bWN);
            c.this.bwp();
        }
    };
    private b.a ghL = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void d(int i, boolean z, boolean z2) {
            c.this.ghE.hideLoadingView();
            c.this.ghE.aJj();
            if (z || z2) {
                c.this.ghE.b((h.e) null);
            } else {
                c.this.ghE.b(c.this.uc(i));
            }
            if (!c.this.bwq()) {
                if (!v.aa(c.this.ghF.bwr()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.ghE.lo(c.this.ghH.isShowing());
                    c.this.ghE.bwH();
                    c.this.ghH.setData(c.this.ghF.bwr());
                }
                if (i != 0) {
                    c.this.ghE.T(c.this.ghF.getDataList());
                    c.this.ghE.x(c.this.ghM);
                } else if (v.aa(c.this.ghE.getDataList())) {
                    c.this.ghE.showNoDataView();
                } else if (z) {
                    c.this.ghE.aJf();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void i(int i, String str, boolean z) {
            c.this.ghE.b((h.e) null);
            c.this.ghE.hideLoadingView();
            c.this.ghE.aJj();
            if (v.aa(c.this.ghE.getDataList())) {
                c.this.ghE.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.ghE.x(c.this.ghM);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener ghM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ghE != null && c.this.ghF != null) {
                c.this.ghE.aJg();
                c.this.ghF.ue(c.this.bWN);
            }
        }
    };
    private b.a ghN = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bwn() {
            c.this.ghE.kc(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bWN = aVar.sub_class_id;
                c.this.ub(aVar.sub_class_id);
                if (c.this.ghE != null) {
                    c.this.ghE.tZ(aVar.sub_class_id);
                    c.this.ghE.lo(false);
                    c.this.ghE.yg(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bwo() {
            if (c.this.ghE != null) {
                c.this.ghE.lo(false);
                c.this.ghE.kc(false);
            }
        }
    };
    private a.InterfaceC0325a ghr = new a.InterfaceC0325a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0325a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bWN = aVar.sub_class_id;
                c.this.ub(aVar.sub_class_id);
                if (c.this.ghE != null) {
                    c.this.ghE.tZ(aVar.sub_class_id);
                    c.this.ghE.lo(false);
                    c.this.ghE.yg(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ghE = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.ghI);
        this.ghF = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.ghL);
        this.ghH = new b(tbPageContext, this.mBdUniqueId);
        this.ghH.a(this.ghN);
        this.ghG = new a(tbPageContext, this.mBdUniqueId);
        this.ghG.a(this.ghr);
        this.ghE.y(this.ghJ);
        this.bWN = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.ghE.tZ(this.bWN);
    }

    public void init() {
        this.ghF.registerListener();
        this.ghE.init();
        this.ghE.setListPullRefreshListener(this.dnZ);
        this.ghE.a(this.ghK);
        MessageManager.getInstance().registerListener(this.fND);
    }

    public View getView() {
        if (this.ghE != null) {
            return this.ghE.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwp() {
        TiebaStatic.log(new an("c13493").P("obj_type", this.bWN));
    }

    public void loadData() {
        if (this.ghE != null) {
            this.ghE.bwB();
            this.ghE.showLoadingView();
        }
        if (this.ghF != null) {
            this.ghF.ud(this.bWN);
        }
    }

    public void aJk() {
        if (this.ghE != null) {
            this.ghE.bwx();
            this.ghE.startPullRefresh();
            this.ghE.lm(false);
            this.ghE.bwz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        if (this.ghH != null) {
            this.ghH.ua(i);
        }
        if (this.ghF != null) {
            this.ghF.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwq() {
        if (this.ghF == null || v.aa(this.ghF.bwr()) || (!(this.ghF.bws() || this.bWN == 0) || this.ghG == null)) {
            return false;
        }
        this.ghG.setData(this.ghF.bwr());
        this.ghG.bh((ViewGroup) this.ghE.getRootView());
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.ahQ().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.e uc(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new h.e(string, 1000);
    }

    public void akN() {
        if (this.ghE != null) {
            this.ghE.akN();
        }
        if (this.ghH != null) {
            this.ghH.onChangeSkinType();
        }
        if (this.ghG != null) {
            this.ghG.onChangeSkinType();
        }
    }

    public void onPause() {
        if (this.ghE != null) {
            this.ghE.onPause();
            this.ghE.bvg();
            this.ghE.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ghE != null) {
            this.ghE.setListPullRefreshListener(null);
            this.ghE.a((BdListView.e) null);
            this.ghE.onDestroy();
        }
        if (this.ghH != null) {
            this.ghH.onDestroy();
        }
        if (this.ghG != null) {
            this.ghG.onDestroy();
        }
        if (this.ghF != null) {
            this.ghF.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fND);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").P("obj_type", this.bWN));
            if (!this.ghH.isShowing()) {
                this.ghE.setViewForeground();
                return;
            }
            return;
        }
        if (this.ghH != null) {
            this.ghH.bwl();
        }
        this.ghE.bvg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ghF != null && !v.aa(this.ghF.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ghF.xv(optString);
            this.ghF.yf(optString);
            if (this.ghE != null) {
                this.ghE.yh(optString);
            }
        }
    }
}
