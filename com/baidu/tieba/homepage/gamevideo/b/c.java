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
    private com.baidu.tieba.homepage.gamevideo.view.b iwa;
    private com.baidu.tieba.homepage.gamevideo.d.b iwb;
    private a iwc;
    private b iwd;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iwa != null) {
                c.this.iwa.cmF();
            }
        }
    };
    private NEGFeedBackView.a iwe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
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
                if (c.this.iwa != null) {
                    c.this.iwa.DT();
                }
                TiebaStatic.log(new ap("c13500").dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", aqVar.getFid()).dn("obj_param1", aqVar.weight).dn("obj_source", aqVar.source).dn("obj_id", aqVar.extra).dn("obj_type", sb.toString()).dn("obj_name", str).ah(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iwf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iwa.cmN()) {
                c.this.iwa.pa(true);
                if (c.this.iwd.isShowing()) {
                    c.this.iwd.cms();
                    c.this.iwa.cmM();
                    ao.setBackgroundResource(c.this.iwa.cmK(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iwd.cn(c.this.iwa.cmK());
                c.this.iwa.cmL();
                ao.setBackgroundResource(c.this.iwa.cmK(), R.color.cp_bg_line_d);
                if (c.this.iwb != null && !x.isEmpty(c.this.iwb.cmz())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c ftG = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iwb.xA(c.this.eeE);
                c.this.cmx();
                c.this.iwa.oZ(false);
                return;
            }
            c.this.iwa.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iwg = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iwa.bwT();
            c.this.iwb.xB(c.this.eeE);
            c.this.cmx();
        }
    };
    private b.a iwh = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.iwa.hideLoadingView();
            c.this.iwa.bwX();
            if (z || z2) {
                c.this.iwa.b((f.e) null);
            } else {
                c.this.iwa.b(c.this.xz(i));
            }
            if (!c.this.cmy()) {
                if (!x.isEmpty(c.this.iwb.cmz()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iwa.pb(c.this.iwd.isShowing());
                    c.this.iwa.cmO();
                    c.this.iwd.setData(c.this.iwb.cmz());
                }
                if (i != 0) {
                    c.this.iwa.aK(c.this.iwb.getDataList());
                    c.this.iwa.A(c.this.iwi);
                } else if (x.isEmpty(c.this.iwa.getDataList())) {
                    c.this.iwa.showNoDataView();
                } else if (z) {
                    c.this.iwa.bwS();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.iwa.b((f.e) null);
            c.this.iwa.hideLoadingView();
            c.this.iwa.bwX();
            if (x.isEmpty(c.this.iwa.getDataList())) {
                c.this.iwa.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iwa.A(c.this.iwi);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iwi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iwa != null && c.this.iwb != null) {
                c.this.iwa.bwT();
                c.this.iwb.xB(c.this.eeE);
            }
        }
    };
    private b.a iwj = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cmv() {
            c.this.iwa.nN(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eeE = aVar.sub_class_id;
                c.this.xy(aVar.sub_class_id);
                if (c.this.iwa != null) {
                    c.this.iwa.xw(aVar.sub_class_id);
                    c.this.iwa.pb(false);
                    c.this.iwa.GP(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cmw() {
            if (c.this.iwa != null) {
                c.this.iwa.pb(false);
                c.this.iwa.nN(false);
            }
        }
    };
    private a.InterfaceC0644a ivP = new a.InterfaceC0644a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0644a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eeE = aVar.sub_class_id;
                c.this.xy(aVar.sub_class_id);
                if (c.this.iwa != null) {
                    c.this.iwa.xw(aVar.sub_class_id);
                    c.this.iwa.pb(false);
                    c.this.iwa.GP(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iwa = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iwe);
        this.iwb = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iwh);
        this.iwd = new b(tbPageContext, this.mBdUniqueId);
        this.iwd.a(this.iwj);
        this.iwc = new a(tbPageContext, this.mBdUniqueId);
        this.iwc.a(this.ivP);
        this.iwa.B(this.iwf);
        this.eeE = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iwa.xw(this.eeE);
    }

    public void init() {
        this.iwb.registerListener();
        this.iwa.init();
        this.iwa.setListPullRefreshListener(this.ftG);
        this.iwa.a(this.iwg);
        MessageManager.getInstance().registerListener(this.hoJ);
    }

    public View getView() {
        if (this.iwa != null) {
            return this.iwa.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmx() {
        TiebaStatic.log(new ap("c13493").ah("obj_type", this.eeE));
    }

    public void loadData() {
        if (this.iwa != null) {
            this.iwa.cmI();
            this.iwa.showLoadingView();
        }
        if (this.iwb != null) {
            this.iwb.xA(this.eeE);
        }
    }

    public void IH() {
        if (this.iwa != null) {
            this.iwa.cmE();
            this.iwa.startPullRefresh();
            this.iwa.oZ(false);
            this.iwa.cmG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        if (this.iwd != null) {
            this.iwd.xx(i);
        }
        if (this.iwb != null) {
            this.iwb.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmy() {
        if (this.iwb == null || x.isEmpty(this.iwb.cmz()) || (!(this.iwb.cmA() || this.eeE == 0) || this.iwc == null)) {
            return false;
        }
        this.iwc.setData(this.iwb.cmz());
        this.iwc.bB((ViewGroup) this.iwa.getRootView());
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
        if (this.iwa != null) {
            this.iwa.bci();
        }
        if (this.iwd != null) {
            this.iwd.onChangeSkinType();
        }
        if (this.iwc != null) {
            this.iwc.onChangeSkinType();
        }
        if (this.iwd.isShowing()) {
            ao.setBackgroundResource(this.iwa.cmK(), R.color.cp_bg_line_d);
        } else {
            ao.setBackgroundResource(this.iwa.cmK(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iwa != null) {
            this.iwa.onPause();
            this.iwa.clx();
            this.iwa.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iwa != null) {
            this.iwa.setListPullRefreshListener(null);
            this.iwa.a((BdListView.e) null);
            this.iwa.onDestroy();
        }
        if (this.iwd != null) {
            this.iwd.onDestroy();
        }
        if (this.iwc != null) {
            this.iwc.onDestroy();
        }
        if (this.iwb != null) {
            this.iwb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hoJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ap("c13486").ah("obj_type", this.eeE));
            if (!this.iwd.isShowing()) {
                this.iwa.setViewForeground();
                return;
            }
            return;
        }
        if (this.iwd != null) {
            this.iwd.cmt();
        }
        this.iwa.clx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iwb != null && !x.isEmpty(this.iwb.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iwb.Gl(optString);
            this.iwb.GO(optString);
            if (this.iwa != null) {
                this.iwa.GQ(optString);
            }
        }
    }
}
