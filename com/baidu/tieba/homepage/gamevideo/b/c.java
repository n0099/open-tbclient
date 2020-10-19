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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class c {
    private int eCL;
    private com.baidu.tieba.homepage.gamevideo.view.b jia;
    private com.baidu.tieba.homepage.gamevideo.d.b jib;
    private a jic;
    private b jie;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hXD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.jia != null) {
                c.this.jia.cEE();
            }
        }
    };
    private NEGFeedBackView.a jif = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dK("obj_locate", "1").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).aj("obj_type", c.this.eCL).dK("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
            int i = 0;
            if (arrayList != null && arVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (arVar.threadType == 0) {
                    i = 1;
                } else if (arVar.threadType == 40) {
                    i = 2;
                } else if (arVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.jia != null) {
                    c.this.jia.Lf();
                }
                TiebaStatic.log(new aq("c13500").dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", arVar.getFid()).dK("obj_param1", arVar.weight).dK("obj_source", arVar.source).dK("obj_id", arVar.extra).dK("obj_type", sb.toString()).dK("obj_name", str).aj(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener jig = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.jia.cEM()) {
                c.this.jia.qv(true);
                if (c.this.jie.isShowing()) {
                    c.this.jie.cEr();
                    c.this.jia.cEL();
                    ap.setBackgroundResource(c.this.jia.cEJ(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.jie.cC(c.this.jia.cEJ());
                c.this.jia.cEK();
                ap.setBackgroundResource(c.this.jia.cEJ(), R.color.cp_bg_line_d);
                if (c.this.jib != null && !y.isEmpty(c.this.jib.cEy())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fUA = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.jib.Bb(c.this.eCL);
                c.this.cEw();
                c.this.jia.qu(false);
                return;
            }
            c.this.jia.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e jih = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.jia.bJV();
            c.this.jib.Bc(c.this.eCL);
            c.this.cEw();
        }
    };
    private b.a jii = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.jia.hideLoadingView();
            c.this.jia.SK();
            if (z || z2) {
                c.this.jia.b((f.e) null);
            } else {
                c.this.jia.b(c.this.Ba(i));
            }
            if (!c.this.cEx()) {
                if (!y.isEmpty(c.this.jib.cEy()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.blO().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.jia.qw(c.this.jie.isShowing());
                    c.this.jia.cEN();
                    c.this.jie.setData(c.this.jib.cEy());
                }
                if (i != 0) {
                    c.this.jia.aR(c.this.jib.getDataList());
                    c.this.jia.B(c.this.jij);
                } else if (y.isEmpty(c.this.jia.getDataList())) {
                    c.this.jia.showNoDataView();
                } else if (z) {
                    c.this.jia.bJU();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void m(int i, String str, boolean z) {
            c.this.jia.b((f.e) null);
            c.this.jia.hideLoadingView();
            c.this.jia.SK();
            if (y.isEmpty(c.this.jia.getDataList())) {
                c.this.jia.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.jia.B(c.this.jij);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener jij = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.jia != null && c.this.jib != null) {
                c.this.jia.bJV();
                c.this.jib.Bc(c.this.eCL);
            }
        }
    };
    private b.a jik = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cEu() {
            c.this.jia.pe(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eCL = aVar.sub_class_id;
                c.this.AZ(aVar.sub_class_id);
                if (c.this.jia != null) {
                    c.this.jia.AX(aVar.sub_class_id);
                    c.this.jia.qw(false);
                    c.this.jia.KX(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cEv() {
            if (c.this.jia != null) {
                c.this.jia.qw(false);
                c.this.jia.pe(false);
            }
        }
    };
    private a.InterfaceC0710a jhP = new a.InterfaceC0710a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0710a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eCL = aVar.sub_class_id;
                c.this.AZ(aVar.sub_class_id);
                if (c.this.jia != null) {
                    c.this.jia.AX(aVar.sub_class_id);
                    c.this.jia.qw(false);
                    c.this.jia.KX(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jia = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.jif);
        this.jib = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.jii);
        this.jie = new b(tbPageContext, this.mBdUniqueId);
        this.jie.a(this.jik);
        this.jic = new a(tbPageContext, this.mBdUniqueId);
        this.jic.a(this.jhP);
        this.jia.C(this.jig);
        this.eCL = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.jia.AX(this.eCL);
    }

    public void init() {
        this.jib.registerListener();
        this.jia.init();
        this.jia.setListPullRefreshListener(this.fUA);
        this.jia.a(this.jih);
        MessageManager.getInstance().registerListener(this.hXD);
    }

    public View getView() {
        if (this.jia != null) {
            return this.jia.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEw() {
        TiebaStatic.log(new aq("c13493").aj("obj_type", this.eCL));
    }

    public void loadData() {
        if (this.jia != null) {
            this.jia.cEH();
            this.jia.showLoadingView();
        }
        if (this.jib != null) {
            this.jib.Bb(this.eCL);
        }
    }

    public void Qi() {
        if (this.jia != null) {
            this.jia.cED();
            this.jia.startPullRefresh();
            this.jia.qu(false);
            this.jia.cEF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ(int i) {
        if (this.jie != null) {
            this.jie.AY(i);
        }
        if (this.jib != null) {
            this.jib.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cEx() {
        if (this.jib == null || y.isEmpty(this.jib.cEy()) || (!(this.jib.cEz() || this.eCL == 0) || this.jic == null)) {
            return false;
        }
        this.jic.setData(this.jib.cEy());
        this.jic.bD((ViewGroup) this.jia.getRootView());
        com.baidu.tbadk.core.sharedPref.b.blO().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.blO().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Ba(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bok() {
        if (this.jia != null) {
            this.jia.bok();
        }
        if (this.jie != null) {
            this.jie.onChangeSkinType();
        }
        if (this.jic != null) {
            this.jic.onChangeSkinType();
        }
        if (this.jie.isShowing()) {
            ap.setBackgroundResource(this.jia.cEJ(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.jia.cEJ(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.jia != null) {
            this.jia.onPause();
            this.jia.cCY();
            this.jia.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jia != null) {
            this.jia.setListPullRefreshListener(null);
            this.jia.a((BdListView.e) null);
            this.jia.onDestroy();
        }
        if (this.jie != null) {
            this.jie.onDestroy();
        }
        if (this.jic != null) {
            this.jic.onDestroy();
        }
        if (this.jib != null) {
            this.jib.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hXD);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").aj("obj_type", this.eCL));
            if (!this.jie.isShowing()) {
                this.jia.setViewForeground();
                return;
            }
            return;
        }
        if (this.jie != null) {
            this.jie.cEs();
        }
        this.jia.cCY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jib != null && !y.isEmpty(this.jib.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jib.JZ(optString);
            this.jib.KW(optString);
            if (this.jia != null) {
                this.jia.KY(optString);
            }
        }
    }
}
