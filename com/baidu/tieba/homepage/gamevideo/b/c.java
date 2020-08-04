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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private int eeE;
    private com.baidu.tieba.homepage.gamevideo.view.b iwc;
    private com.baidu.tieba.homepage.gamevideo.d.b iwd;
    private a iwe;
    private b iwf;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iwc != null) {
                c.this.iwc.cmF();
            }
        }
    };
    private NEGFeedBackView.a iwg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aq aqVar) {
            if (aqVar != null) {
                TiebaStatic.log(new ap("c13500").dn("obj_locate", "1").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ap("c13499").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).ah("obj_type", c.this.eeE).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
            int i = 0;
            if (arrayList != null && aqVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (aqVar.threadType == 0) {
                    i = 1;
                } else if (aqVar.threadType == 40) {
                    i = 2;
                } else if (aqVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.iwc != null) {
                    c.this.iwc.DT();
                }
                TiebaStatic.log(new ap("c13500").dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", aqVar.getFid()).dn("obj_param1", aqVar.weight).dn("obj_source", aqVar.source).dn("obj_id", aqVar.extra).dn("obj_type", sb.toString()).dn("obj_name", str).ah(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iwh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iwc.cmN()) {
                c.this.iwc.pa(true);
                if (c.this.iwf.isShowing()) {
                    c.this.iwf.cms();
                    c.this.iwc.cmM();
                    ao.setBackgroundResource(c.this.iwc.cmK(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iwf.cn(c.this.iwc.cmK());
                c.this.iwc.cmL();
                ao.setBackgroundResource(c.this.iwc.cmK(), R.color.cp_bg_line_d);
                if (c.this.iwd != null && !x.isEmpty(c.this.iwd.cmz())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c ftG = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iwd.xA(c.this.eeE);
                c.this.cmx();
                c.this.iwc.oZ(false);
                return;
            }
            c.this.iwc.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iwi = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iwc.bwT();
            c.this.iwd.xB(c.this.eeE);
            c.this.cmx();
        }
    };
    private b.a iwj = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.iwc.hideLoadingView();
            c.this.iwc.bwX();
            if (z || z2) {
                c.this.iwc.b((f.e) null);
            } else {
                c.this.iwc.b(c.this.xz(i));
            }
            if (!c.this.cmy()) {
                if (!x.isEmpty(c.this.iwd.cmz()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iwc.pb(c.this.iwf.isShowing());
                    c.this.iwc.cmO();
                    c.this.iwf.setData(c.this.iwd.cmz());
                }
                if (i != 0) {
                    c.this.iwc.aK(c.this.iwd.getDataList());
                    c.this.iwc.A(c.this.iwk);
                } else if (x.isEmpty(c.this.iwc.getDataList())) {
                    c.this.iwc.showNoDataView();
                } else if (z) {
                    c.this.iwc.bwS();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.iwc.b((f.e) null);
            c.this.iwc.hideLoadingView();
            c.this.iwc.bwX();
            if (x.isEmpty(c.this.iwc.getDataList())) {
                c.this.iwc.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iwc.A(c.this.iwk);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iwk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iwc != null && c.this.iwd != null) {
                c.this.iwc.bwT();
                c.this.iwd.xB(c.this.eeE);
            }
        }
    };
    private b.a iwl = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cmv() {
            c.this.iwc.nN(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eeE = aVar.sub_class_id;
                c.this.xy(aVar.sub_class_id);
                if (c.this.iwc != null) {
                    c.this.iwc.xw(aVar.sub_class_id);
                    c.this.iwc.pb(false);
                    c.this.iwc.GP(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cmw() {
            if (c.this.iwc != null) {
                c.this.iwc.pb(false);
                c.this.iwc.nN(false);
            }
        }
    };
    private a.InterfaceC0644a ivR = new a.InterfaceC0644a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0644a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eeE = aVar.sub_class_id;
                c.this.xy(aVar.sub_class_id);
                if (c.this.iwc != null) {
                    c.this.iwc.xw(aVar.sub_class_id);
                    c.this.iwc.pb(false);
                    c.this.iwc.GP(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iwc = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iwg);
        this.iwd = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iwj);
        this.iwf = new b(tbPageContext, this.mBdUniqueId);
        this.iwf.a(this.iwl);
        this.iwe = new a(tbPageContext, this.mBdUniqueId);
        this.iwe.a(this.ivR);
        this.iwc.B(this.iwh);
        this.eeE = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iwc.xw(this.eeE);
    }

    public void init() {
        this.iwd.registerListener();
        this.iwc.init();
        this.iwc.setListPullRefreshListener(this.ftG);
        this.iwc.a(this.iwi);
        MessageManager.getInstance().registerListener(this.hoJ);
    }

    public View getView() {
        if (this.iwc != null) {
            return this.iwc.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmx() {
        TiebaStatic.log(new ap("c13493").ah("obj_type", this.eeE));
    }

    public void loadData() {
        if (this.iwc != null) {
            this.iwc.cmI();
            this.iwc.showLoadingView();
        }
        if (this.iwd != null) {
            this.iwd.xA(this.eeE);
        }
    }

    public void IH() {
        if (this.iwc != null) {
            this.iwc.cmE();
            this.iwc.startPullRefresh();
            this.iwc.oZ(false);
            this.iwc.cmG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        if (this.iwf != null) {
            this.iwf.xx(i);
        }
        if (this.iwd != null) {
            this.iwd.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmy() {
        if (this.iwd == null || x.isEmpty(this.iwd.cmz()) || (!(this.iwd.cmA() || this.eeE == 0) || this.iwe == null)) {
            return false;
        }
        this.iwe.setData(this.iwd.cmz());
        this.iwe.bB((ViewGroup) this.iwc.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aZP().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aZP().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e xz(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bci() {
        if (this.iwc != null) {
            this.iwc.bci();
        }
        if (this.iwf != null) {
            this.iwf.onChangeSkinType();
        }
        if (this.iwe != null) {
            this.iwe.onChangeSkinType();
        }
        if (this.iwf.isShowing()) {
            ao.setBackgroundResource(this.iwc.cmK(), R.color.cp_bg_line_d);
        } else {
            ao.setBackgroundResource(this.iwc.cmK(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iwc != null) {
            this.iwc.onPause();
            this.iwc.clx();
            this.iwc.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iwc != null) {
            this.iwc.setListPullRefreshListener(null);
            this.iwc.a((BdListView.e) null);
            this.iwc.onDestroy();
        }
        if (this.iwf != null) {
            this.iwf.onDestroy();
        }
        if (this.iwe != null) {
            this.iwe.onDestroy();
        }
        if (this.iwd != null) {
            this.iwd.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hoJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ap("c13486").ah("obj_type", this.eeE));
            if (!this.iwf.isShowing()) {
                this.iwc.setViewForeground();
                return;
            }
            return;
        }
        if (this.iwf != null) {
            this.iwf.cmt();
        }
        this.iwc.clx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iwd != null && !x.isEmpty(this.iwd.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iwd.Gl(optString);
            this.iwd.GO(optString);
            if (this.iwc != null) {
                this.iwc.GQ(optString);
            }
        }
    }
}
