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
/* loaded from: classes16.dex */
public class c {
    private int eoe;
    private com.baidu.tieba.homepage.gamevideo.view.b iKr;
    private com.baidu.tieba.homepage.gamevideo.d.b iKs;
    private a iKt;
    private b iKu;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hBA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iKr != null) {
                c.this.iKr.cxo();
            }
        }
    };
    private NEGFeedBackView.a iKv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dD("obj_locate", "1").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).ai("obj_type", c.this.eoe).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.iKr != null) {
                    c.this.iKr.Jw();
                }
                TiebaStatic.log(new aq("c13500").dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iKw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iKr.cxw()) {
                c.this.iKr.pF(true);
                if (c.this.iKu.isShowing()) {
                    c.this.iKu.cxb();
                    c.this.iKr.cxv();
                    ap.setBackgroundResource(c.this.iKr.cxt(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iKu.cp(c.this.iKr.cxt());
                c.this.iKr.cxu();
                ap.setBackgroundResource(c.this.iKr.cxt(), R.color.cp_bg_line_d);
                if (c.this.iKs != null && !y.isEmpty(c.this.iKs.cxi())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fEZ = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iKs.zU(c.this.eoe);
                c.this.cxg();
                c.this.iKr.pE(false);
                return;
            }
            c.this.iKr.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iKx = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iKr.bFS();
            c.this.iKs.zV(c.this.eoe);
            c.this.cxg();
        }
    };
    private b.a iKy = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.iKr.hideLoadingView();
            c.this.iKr.bFW();
            if (z || z2) {
                c.this.iKr.b((f.e) null);
            } else {
                c.this.iKr.b(c.this.zT(i));
            }
            if (!c.this.cxh()) {
                if (!y.isEmpty(c.this.iKs.cxi()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iKr.pG(c.this.iKu.isShowing());
                    c.this.iKr.cxx();
                    c.this.iKu.setData(c.this.iKs.cxi());
                }
                if (i != 0) {
                    c.this.iKr.aK(c.this.iKs.getDataList());
                    c.this.iKr.B(c.this.iKz);
                } else if (y.isEmpty(c.this.iKr.getDataList())) {
                    c.this.iKr.showNoDataView();
                } else if (z) {
                    c.this.iKr.bFR();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.iKr.b((f.e) null);
            c.this.iKr.hideLoadingView();
            c.this.iKr.bFW();
            if (y.isEmpty(c.this.iKr.getDataList())) {
                c.this.iKr.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iKr.B(c.this.iKz);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iKz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iKr != null && c.this.iKs != null) {
                c.this.iKr.bFS();
                c.this.iKs.zV(c.this.eoe);
            }
        }
    };
    private b.a iKA = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cxe() {
            c.this.iKr.or(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eoe = aVar.sub_class_id;
                c.this.zS(aVar.sub_class_id);
                if (c.this.iKr != null) {
                    c.this.iKr.zQ(aVar.sub_class_id);
                    c.this.iKr.pG(false);
                    c.this.iKr.JF(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cxf() {
            if (c.this.iKr != null) {
                c.this.iKr.pG(false);
                c.this.iKr.or(false);
            }
        }
    };
    private a.InterfaceC0695a iKg = new a.InterfaceC0695a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0695a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eoe = aVar.sub_class_id;
                c.this.zS(aVar.sub_class_id);
                if (c.this.iKr != null) {
                    c.this.iKr.zQ(aVar.sub_class_id);
                    c.this.iKr.pG(false);
                    c.this.iKr.JF(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKr = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iKv);
        this.iKs = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iKy);
        this.iKu = new b(tbPageContext, this.mBdUniqueId);
        this.iKu.a(this.iKA);
        this.iKt = new a(tbPageContext, this.mBdUniqueId);
        this.iKt.a(this.iKg);
        this.iKr.C(this.iKw);
        this.eoe = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iKr.zQ(this.eoe);
    }

    public void init() {
        this.iKs.registerListener();
        this.iKr.init();
        this.iKr.setListPullRefreshListener(this.fEZ);
        this.iKr.a(this.iKx);
        MessageManager.getInstance().registerListener(this.hBA);
    }

    public View getView() {
        if (this.iKr != null) {
            return this.iKr.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxg() {
        TiebaStatic.log(new aq("c13493").ai("obj_type", this.eoe));
    }

    public void loadData() {
        if (this.iKr != null) {
            this.iKr.cxr();
            this.iKr.showLoadingView();
        }
        if (this.iKs != null) {
            this.iKs.zU(this.eoe);
        }
    }

    public void OA() {
        if (this.iKr != null) {
            this.iKr.cxn();
            this.iKr.startPullRefresh();
            this.iKr.pE(false);
            this.iKr.cxp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        if (this.iKu != null) {
            this.iKu.zR(i);
        }
        if (this.iKs != null) {
            this.iKs.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxh() {
        if (this.iKs == null || y.isEmpty(this.iKs.cxi()) || (!(this.iKs.cxj() || this.eoe == 0) || this.iKt == null)) {
            return false;
        }
        this.iKt.setData(this.iKs.cxi());
        this.iKt.bA((ViewGroup) this.iKr.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bik().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bik().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e zT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bkF() {
        if (this.iKr != null) {
            this.iKr.bkF();
        }
        if (this.iKu != null) {
            this.iKu.onChangeSkinType();
        }
        if (this.iKt != null) {
            this.iKt.onChangeSkinType();
        }
        if (this.iKu.isShowing()) {
            ap.setBackgroundResource(this.iKr.cxt(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.iKr.cxt(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iKr != null) {
            this.iKr.onPause();
            this.iKr.cwg();
            this.iKr.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iKr != null) {
            this.iKr.setListPullRefreshListener(null);
            this.iKr.a((BdListView.e) null);
            this.iKr.onDestroy();
        }
        if (this.iKu != null) {
            this.iKu.onDestroy();
        }
        if (this.iKt != null) {
            this.iKt.onDestroy();
        }
        if (this.iKs != null) {
            this.iKs.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hBA);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").ai("obj_type", this.eoe));
            if (!this.iKu.isShowing()) {
                this.iKr.setViewForeground();
                return;
            }
            return;
        }
        if (this.iKu != null) {
            this.iKu.cxc();
        }
        this.iKr.cwg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iKs != null && !y.isEmpty(this.iKs.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iKs.IN(optString);
            this.iKs.JE(optString);
            if (this.iKr != null) {
                this.iKr.JG(optString);
            }
        }
    }
}
