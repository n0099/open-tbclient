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
/* loaded from: classes21.dex */
public class c {
    private int eqz;
    private com.baidu.tieba.homepage.gamevideo.view.b iTd;
    private com.baidu.tieba.homepage.gamevideo.d.b iTe;
    private a iTf;
    private b iTg;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.iTd != null) {
                c.this.iTd.cAX();
            }
        }
    };
    private NEGFeedBackView.a iTh = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                TiebaStatic.log(new aq("c13500").dF("obj_locate", "1").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new aq("c13499").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).ai("obj_type", c.this.eqz).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.iTd != null) {
                    c.this.iTd.Ka();
                }
                TiebaStatic.log(new aq("c13500").dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", arVar.getFid()).dF("obj_param1", arVar.weight).dF("obj_source", arVar.source).dF("obj_id", arVar.extra).dF("obj_type", sb.toString()).dF("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iTi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.iTd.cBf()) {
                c.this.iTd.pP(true);
                if (c.this.iTg.isShowing()) {
                    c.this.iTg.cAK();
                    c.this.iTd.cBe();
                    ap.setBackgroundResource(c.this.iTd.cBc(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.iTg.cy(c.this.iTd.cBc());
                c.this.iTd.cBd();
                ap.setBackgroundResource(c.this.iTd.cBc(), R.color.cp_bg_line_d);
                if (c.this.iTe != null && !y.isEmpty(c.this.iTe.cAR())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fIp = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.iTe.Av(c.this.eqz);
                c.this.cAP();
                c.this.iTd.pO(false);
                return;
            }
            c.this.iTd.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iTj = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.iTd.bHj();
            c.this.iTe.Aw(c.this.eqz);
            c.this.cAP();
        }
    };
    private b.a iTk = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void f(int i, boolean z, boolean z2) {
            c.this.iTd.hideLoadingView();
            c.this.iTd.bHn();
            if (z || z2) {
                c.this.iTd.b((f.e) null);
            } else {
                c.this.iTd.b(c.this.Au(i));
            }
            if (!c.this.cAQ()) {
                if (!y.isEmpty(c.this.iTe.cAR()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.iTd.pQ(c.this.iTg.isShowing());
                    c.this.iTd.cBg();
                    c.this.iTg.setData(c.this.iTe.cAR());
                }
                if (i != 0) {
                    c.this.iTd.aO(c.this.iTe.getDataList());
                    c.this.iTd.B(c.this.iTl);
                } else if (y.isEmpty(c.this.iTd.getDataList())) {
                    c.this.iTd.showNoDataView();
                } else if (z) {
                    c.this.iTd.bHi();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.iTd.b((f.e) null);
            c.this.iTd.hideLoadingView();
            c.this.iTd.bHn();
            if (y.isEmpty(c.this.iTd.getDataList())) {
                c.this.iTd.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.iTd.B(c.this.iTl);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iTl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iTd != null && c.this.iTe != null) {
                c.this.iTd.bHj();
                c.this.iTe.Aw(c.this.eqz);
            }
        }
    };
    private b.a iTm = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cAN() {
            c.this.iTd.oz(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eqz = aVar.sub_class_id;
                c.this.At(aVar.sub_class_id);
                if (c.this.iTd != null) {
                    c.this.iTd.Ar(aVar.sub_class_id);
                    c.this.iTd.pQ(false);
                    c.this.iTd.Ki(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void cAO() {
            if (c.this.iTd != null) {
                c.this.iTd.pQ(false);
                c.this.iTd.oz(false);
            }
        }
    };
    private a.InterfaceC0692a iSS = new a.InterfaceC0692a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0692a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.eqz = aVar.sub_class_id;
                c.this.At(aVar.sub_class_id);
                if (c.this.iTd != null) {
                    c.this.iTd.Ar(aVar.sub_class_id);
                    c.this.iTd.pQ(false);
                    c.this.iTd.Ki(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iTd = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iTh);
        this.iTe = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iTk);
        this.iTg = new b(tbPageContext, this.mBdUniqueId);
        this.iTg.a(this.iTm);
        this.iTf = new a(tbPageContext, this.mBdUniqueId);
        this.iTf.a(this.iSS);
        this.iTd.C(this.iTi);
        this.eqz = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.iTd.Ar(this.eqz);
    }

    public void init() {
        this.iTe.registerListener();
        this.iTd.init();
        this.iTd.setListPullRefreshListener(this.fIp);
        this.iTd.a(this.iTj);
        MessageManager.getInstance().registerListener(this.hII);
    }

    public View getView() {
        if (this.iTd != null) {
            return this.iTd.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAP() {
        TiebaStatic.log(new aq("c13493").ai("obj_type", this.eqz));
    }

    public void loadData() {
        if (this.iTd != null) {
            this.iTd.cBa();
            this.iTd.showLoadingView();
        }
        if (this.iTe != null) {
            this.iTe.Av(this.eqz);
        }
    }

    public void Pd() {
        if (this.iTd != null) {
            this.iTd.cAW();
            this.iTd.startPullRefresh();
            this.iTd.pO(false);
            this.iTd.cAY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At(int i) {
        if (this.iTg != null) {
            this.iTg.As(i);
        }
        if (this.iTe != null) {
            this.iTe.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAQ() {
        if (this.iTe == null || y.isEmpty(this.iTe.cAR()) || (!(this.iTe.cAS() || this.eqz == 0) || this.iTf == null)) {
            return false;
        }
        this.iTf.setData(this.iTe.cAR());
        this.iTf.bB((ViewGroup) this.iTd.getRootView());
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Au(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void blA() {
        if (this.iTd != null) {
            this.iTd.blA();
        }
        if (this.iTg != null) {
            this.iTg.onChangeSkinType();
        }
        if (this.iTf != null) {
            this.iTf.onChangeSkinType();
        }
        if (this.iTg.isShowing()) {
            ap.setBackgroundResource(this.iTd.cBc(), R.color.cp_bg_line_d);
        } else {
            ap.setBackgroundResource(this.iTd.cBc(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.iTd != null) {
            this.iTd.onPause();
            this.iTd.czB();
            this.iTd.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iTd != null) {
            this.iTd.setListPullRefreshListener(null);
            this.iTd.a((BdListView.e) null);
            this.iTd.onDestroy();
        }
        if (this.iTg != null) {
            this.iTg.onDestroy();
        }
        if (this.iTf != null) {
            this.iTf.onDestroy();
        }
        if (this.iTe != null) {
            this.iTe.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hII);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new aq("c13486").ai("obj_type", this.eqz));
            if (!this.iTg.isShowing()) {
                this.iTd.setViewForeground();
                return;
            }
            return;
        }
        if (this.iTg != null) {
            this.iTg.cAL();
        }
        this.iTd.czB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iTe != null && !y.isEmpty(this.iTe.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iTe.Jm(optString);
            this.iTe.Kh(optString);
            if (this.iTd != null) {
                this.iTd.Kj(optString);
            }
        }
    }
}
