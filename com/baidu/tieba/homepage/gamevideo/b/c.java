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
    private int bWH;
    private com.baidu.tieba.homepage.gamevideo.view.b ggO;
    private com.baidu.tieba.homepage.gamevideo.d.b ggP;
    private a ggQ;
    private b ggR;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener fMP = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.ggO != null) {
                c.this.ggO.bwk();
            }
        }
    };
    private NEGFeedBackView.a ggS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                TiebaStatic.log(new an("c13500").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).P("obj_type", c.this.bWH).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.ggO != null) {
                    c.this.ggO.refreshListView();
                }
                TiebaStatic.log(new an("c13500").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
            }
        }
    };
    private final View.OnClickListener ggT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.ggO.bws()) {
                c.this.ggO.ln(true);
                if (c.this.ggR.isShowing()) {
                    c.this.ggR.bvW();
                    c.this.ggO.bwr();
                    return;
                }
                c.this.ggR.ca(c.this.ggO.bwp());
                c.this.ggO.bwq();
                if (c.this.ggP != null && !v.aa(c.this.ggP.bwd())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private h.c dnS = new h.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (j.kc()) {
                c.this.ggP.ub(c.this.bWH);
                c.this.bwb();
                c.this.ggO.lm(false);
                return;
            }
            c.this.ggO.b((h.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e ggU = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.ggO.aJe();
            c.this.ggP.uc(c.this.bWH);
            c.this.bwb();
        }
    };
    private b.a ggV = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void d(int i, boolean z, boolean z2) {
            c.this.ggO.hideLoadingView();
            c.this.ggO.aJh();
            if (z || z2) {
                c.this.ggO.b((h.e) null);
            } else {
                c.this.ggO.b(c.this.ua(i));
            }
            if (!c.this.bwc()) {
                if (!v.aa(c.this.ggP.bwd()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.ggO.lo(c.this.ggR.isShowing());
                    c.this.ggO.bwt();
                    c.this.ggR.setData(c.this.ggP.bwd());
                }
                if (i != 0) {
                    c.this.ggO.T(c.this.ggP.getDataList());
                    c.this.ggO.x(c.this.ggW);
                } else if (v.aa(c.this.ggO.getDataList())) {
                    c.this.ggO.showNoDataView();
                } else if (z) {
                    c.this.ggO.aJd();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void i(int i, String str, boolean z) {
            c.this.ggO.b((h.e) null);
            c.this.ggO.hideLoadingView();
            c.this.ggO.aJh();
            if (v.aa(c.this.ggO.getDataList())) {
                c.this.ggO.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.ggO.x(c.this.ggW);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener ggW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ggO != null && c.this.ggP != null) {
                c.this.ggO.aJe();
                c.this.ggP.uc(c.this.bWH);
            }
        }
    };
    private b.a ggX = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bvZ() {
            c.this.ggO.kc(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bWH = aVar.sub_class_id;
                c.this.tZ(aVar.sub_class_id);
                if (c.this.ggO != null) {
                    c.this.ggO.tX(aVar.sub_class_id);
                    c.this.ggO.lo(false);
                    c.this.ggO.yf(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bwa() {
            if (c.this.ggO != null) {
                c.this.ggO.lo(false);
                c.this.ggO.kc(false);
            }
        }
    };
    private a.InterfaceC0325a ggB = new a.InterfaceC0325a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0325a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.bWH = aVar.sub_class_id;
                c.this.tZ(aVar.sub_class_id);
                if (c.this.ggO != null) {
                    c.this.ggO.tX(aVar.sub_class_id);
                    c.this.ggO.lo(false);
                    c.this.ggO.yf(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ggO = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.ggS);
        this.ggP = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.ggV);
        this.ggR = new b(tbPageContext, this.mBdUniqueId);
        this.ggR.a(this.ggX);
        this.ggQ = new a(tbPageContext, this.mBdUniqueId);
        this.ggQ.a(this.ggB);
        this.ggO.y(this.ggT);
        this.bWH = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.ggO.tX(this.bWH);
    }

    public void init() {
        this.ggP.registerListener();
        this.ggO.init();
        this.ggO.setListPullRefreshListener(this.dnS);
        this.ggO.a(this.ggU);
        MessageManager.getInstance().registerListener(this.fMP);
    }

    public View getView() {
        if (this.ggO != null) {
            return this.ggO.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwb() {
        TiebaStatic.log(new an("c13493").P("obj_type", this.bWH));
    }

    public void loadData() {
        if (this.ggO != null) {
            this.ggO.bwn();
            this.ggO.showLoadingView();
        }
        if (this.ggP != null) {
            this.ggP.ub(this.bWH);
        }
    }

    public void aJi() {
        if (this.ggO != null) {
            this.ggO.bwj();
            this.ggO.startPullRefresh();
            this.ggO.lm(false);
            this.ggO.bwl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(int i) {
        if (this.ggR != null) {
            this.ggR.tY(i);
        }
        if (this.ggP != null) {
            this.ggP.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwc() {
        if (this.ggP == null || v.aa(this.ggP.bwd()) || (!(this.ggP.bwe() || this.bWH == 0) || this.ggQ == null)) {
            return false;
        }
        this.ggQ.setData(this.ggP.bwd());
        this.ggQ.bh((ViewGroup) this.ggO.getRootView());
        com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.e ua(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new h.e(string, 1000);
    }

    public void akL() {
        if (this.ggO != null) {
            this.ggO.akL();
        }
        if (this.ggR != null) {
            this.ggR.onChangeSkinType();
        }
        if (this.ggQ != null) {
            this.ggQ.onChangeSkinType();
        }
    }

    public void onPause() {
        if (this.ggO != null) {
            this.ggO.onPause();
            this.ggO.buT();
            this.ggO.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ggO != null) {
            this.ggO.setListPullRefreshListener(null);
            this.ggO.a((BdListView.e) null);
            this.ggO.onDestroy();
        }
        if (this.ggR != null) {
            this.ggR.onDestroy();
        }
        if (this.ggQ != null) {
            this.ggQ.onDestroy();
        }
        if (this.ggP != null) {
            this.ggP.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fMP);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").P("obj_type", this.bWH));
            if (!this.ggR.isShowing()) {
                this.ggO.setViewForeground();
                return;
            }
            return;
        }
        if (this.ggR != null) {
            this.ggR.bvX();
        }
        this.ggO.buT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ggP != null && !v.aa(this.ggP.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ggP.xu(optString);
            this.ggP.ye(optString);
            if (this.ggO != null) {
                this.ggO.yg(optString);
            }
        }
    }
}
