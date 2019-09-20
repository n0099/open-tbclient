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
import com.baidu.tbadk.core.util.am;
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
    private int bXG;
    private b gjA;
    private com.baidu.tieba.homepage.gamevideo.view.b gjx;
    private com.baidu.tieba.homepage.gamevideo.d.b gjy;
    private a gjz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener fPt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.gjx != null) {
                c.this.gjx.bxm();
            }
        }
    };
    private NEGFeedBackView.a gjB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                TiebaStatic.log(new an("c13500").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).P("obj_type", c.this.bXG).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.gjx != null) {
                    c.this.gjx.refreshListView();
                }
                TiebaStatic.log(new an("c13500").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
            }
        }
    };
    private final View.OnClickListener gjC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.gjx.bxu()) {
                c.this.gjx.lq(true);
                if (c.this.gjA.isShowing()) {
                    c.this.gjA.bwY();
                    c.this.gjx.bxt();
                    am.k(c.this.gjx.bxr(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.gjA.cb(c.this.gjx.bxr());
                c.this.gjx.bxs();
                am.k(c.this.gjx.bxr(), R.color.cp_bg_line_d);
                if (c.this.gjy != null && !v.aa(c.this.gjy.bxf())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private h.c dpL = new h.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (j.kc()) {
                c.this.gjy.uh(c.this.bXG);
                c.this.bxd();
                c.this.gjx.lp(false);
                return;
            }
            c.this.gjx.b((h.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e gjD = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.gjx.aJK();
            c.this.gjy.ui(c.this.bXG);
            c.this.bxd();
        }
    };
    private b.a gjE = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void d(int i, boolean z, boolean z2) {
            c.this.gjx.hideLoadingView();
            c.this.gjx.aJN();
            if (z || z2) {
                c.this.gjx.b((h.e) null);
            } else {
                c.this.gjx.b(c.this.ug(i));
            }
            if (!c.this.bxe()) {
                if (!v.aa(c.this.gjy.bxf()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.gjx.lr(c.this.gjA.isShowing());
                    c.this.gjx.bxv();
                    c.this.gjA.setData(c.this.gjy.bxf());
                }
                if (i != 0) {
                    c.this.gjx.T(c.this.gjy.getDataList());
                    c.this.gjx.x(c.this.gjF);
                } else if (v.aa(c.this.gjx.getDataList())) {
                    c.this.gjx.showNoDataView();
                } else if (z) {
                    c.this.gjx.aJJ();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void i(int i, String str, boolean z) {
            c.this.gjx.b((h.e) null);
            c.this.gjx.hideLoadingView();
            c.this.gjx.aJN();
            if (v.aa(c.this.gjx.getDataList())) {
                c.this.gjx.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.gjx.x(c.this.gjF);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener gjF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gjx != null && c.this.gjy != null) {
                c.this.gjx.aJK();
                c.this.gjy.ui(c.this.bXG);
            }
        }
    };
    private b.a gjG = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bxb() {
            c.this.gjx.kf(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bXG = aVar.sub_class_id;
                c.this.uf(aVar.sub_class_id);
                if (c.this.gjx != null) {
                    c.this.gjx.ud(aVar.sub_class_id);
                    c.this.gjx.lr(false);
                    c.this.gjx.yF(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bxc() {
            if (c.this.gjx != null) {
                c.this.gjx.lr(false);
                c.this.gjx.kf(false);
            }
        }
    };
    private a.InterfaceC0336a gjk = new a.InterfaceC0336a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0336a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bXG = aVar.sub_class_id;
                c.this.uf(aVar.sub_class_id);
                if (c.this.gjx != null) {
                    c.this.gjx.ud(aVar.sub_class_id);
                    c.this.gjx.lr(false);
                    c.this.gjx.yF(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gjx = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.gjB);
        this.gjy = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.gjE);
        this.gjA = new b(tbPageContext, this.mBdUniqueId);
        this.gjA.a(this.gjG);
        this.gjz = new a(tbPageContext, this.mBdUniqueId);
        this.gjz.a(this.gjk);
        this.gjx.y(this.gjC);
        this.bXG = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.gjx.ud(this.bXG);
    }

    public void init() {
        this.gjy.registerListener();
        this.gjx.init();
        this.gjx.setListPullRefreshListener(this.dpL);
        this.gjx.a(this.gjD);
        MessageManager.getInstance().registerListener(this.fPt);
    }

    public View getView() {
        if (this.gjx != null) {
            return this.gjx.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxd() {
        TiebaStatic.log(new an("c13493").P("obj_type", this.bXG));
    }

    public void loadData() {
        if (this.gjx != null) {
            this.gjx.bxp();
            this.gjx.showLoadingView();
        }
        if (this.gjy != null) {
            this.gjy.uh(this.bXG);
        }
    }

    public void aJO() {
        if (this.gjx != null) {
            this.gjx.bxl();
            this.gjx.startPullRefresh();
            this.gjx.lp(false);
            this.gjx.bxn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.gjA != null) {
            this.gjA.ue(i);
        }
        if (this.gjy != null) {
            this.gjy.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxe() {
        if (this.gjy == null || v.aa(this.gjy.bxf()) || (!(this.gjy.bxg() || this.bXG == 0) || this.gjz == null)) {
            return false;
        }
        this.gjz.setData(this.gjy.bxf());
        this.gjz.bh((ViewGroup) this.gjx.getRootView());
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.ahU().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.e ug(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new h.e(string, 1000);
    }

    public void akZ() {
        if (this.gjx != null) {
            this.gjx.akZ();
        }
        if (this.gjA != null) {
            this.gjA.onChangeSkinType();
        }
        if (this.gjz != null) {
            this.gjz.onChangeSkinType();
        }
        if (this.gjA.isShowing()) {
            am.k(this.gjx.bxr(), R.color.cp_bg_line_d);
        } else {
            am.k(this.gjx.bxr(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.gjx != null) {
            this.gjx.onPause();
            this.gjx.bvU();
            this.gjx.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.gjx != null) {
            this.gjx.setListPullRefreshListener(null);
            this.gjx.a((BdListView.e) null);
            this.gjx.onDestroy();
        }
        if (this.gjA != null) {
            this.gjA.onDestroy();
        }
        if (this.gjz != null) {
            this.gjz.onDestroy();
        }
        if (this.gjy != null) {
            this.gjy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fPt);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").P("obj_type", this.bXG));
            if (!this.gjA.isShowing()) {
                this.gjx.setViewForeground();
                return;
            }
            return;
        }
        if (this.gjA != null) {
            this.gjA.bwZ();
        }
        this.gjx.bvU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gjy != null && !v.aa(this.gjy.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.gjy.xU(optString);
            this.gjy.yE(optString);
            if (this.gjx != null) {
                this.gjx.yG(optString);
            }
        }
    }
}
