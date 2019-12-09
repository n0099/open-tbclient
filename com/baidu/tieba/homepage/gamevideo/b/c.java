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
    private int clT;
    private com.baidu.tieba.homepage.gamevideo.view.b gic;
    private com.baidu.tieba.homepage.gamevideo.d.b gie;
    private a gif;
    private b gig;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener fNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.gic != null) {
                c.this.gic.buo();
            }
        }
    };
    private NEGFeedBackView.a gih = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                TiebaStatic.log(new an("c13500").bS("obj_locate", "1").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).O("obj_type", c.this.clT).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.gic != null) {
                    c.this.gic.sZ();
                }
                TiebaStatic.log(new an("c13500").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener gii = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.gic.buw()) {
                c.this.gic.le(true);
                if (c.this.gig.isShowing()) {
                    c.this.gig.bub();
                    c.this.gic.buv();
                    am.setBackgroundResource(c.this.gic.but(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.gig.bY(c.this.gic.but());
                c.this.gic.buu();
                am.setBackgroundResource(c.this.gic.but(), R.color.cp_bg_line_d);
                if (c.this.gie != null && !v.isEmpty(c.this.gie.bui())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private h.c dwe = new h.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.gie.tb(c.this.clT);
                c.this.bug();
                c.this.gic.ld(false);
                return;
            }
            c.this.gic.b((h.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e gij = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.gic.aJj();
            c.this.gie.tc(c.this.clT);
            c.this.bug();
        }
    };
    private b.a gik = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void d(int i, boolean z, boolean z2) {
            c.this.gic.hideLoadingView();
            c.this.gic.aJm();
            if (z || z2) {
                c.this.gic.b((h.e) null);
            } else {
                c.this.gic.b(c.this.ta(i));
            }
            if (!c.this.buh()) {
                if (!v.isEmpty(c.this.gie.bui()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.alP().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.gic.lf(c.this.gig.isShowing());
                    c.this.gic.bux();
                    c.this.gig.setData(c.this.gie.bui());
                }
                if (i != 0) {
                    c.this.gic.aq(c.this.gie.getDataList());
                    c.this.gic.y(c.this.gil);
                } else if (v.isEmpty(c.this.gic.getDataList())) {
                    c.this.gic.showNoDataView();
                } else if (z) {
                    c.this.gic.aJi();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void i(int i, String str, boolean z) {
            c.this.gic.b((h.e) null);
            c.this.gic.hideLoadingView();
            c.this.gic.aJm();
            if (v.isEmpty(c.this.gic.getDataList())) {
                c.this.gic.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.gic.y(c.this.gil);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener gil = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gic != null && c.this.gie != null) {
                c.this.gic.aJj();
                c.this.gie.tc(c.this.clT);
            }
        }
    };
    private b.a gim = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bue() {
            c.this.gic.jT(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.clT = aVar.sub_class_id;
                c.this.sZ(aVar.sub_class_id);
                if (c.this.gic != null) {
                    c.this.gic.sX(aVar.sub_class_id);
                    c.this.gic.lf(false);
                    c.this.gic.wY(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void buf() {
            if (c.this.gic != null) {
                c.this.gic.lf(false);
                c.this.gic.jT(false);
            }
        }
    };
    private a.InterfaceC0420a ghQ = new a.InterfaceC0420a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0420a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.clT = aVar.sub_class_id;
                c.this.sZ(aVar.sub_class_id);
                if (c.this.gic != null) {
                    c.this.gic.sX(aVar.sub_class_id);
                    c.this.gic.lf(false);
                    c.this.gic.wY(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gic = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.gih);
        this.gie = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.gik);
        this.gig = new b(tbPageContext, this.mBdUniqueId);
        this.gig.a(this.gim);
        this.gif = new a(tbPageContext, this.mBdUniqueId);
        this.gif.a(this.ghQ);
        this.gic.z(this.gii);
        this.clT = com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.gic.sX(this.clT);
    }

    public void init() {
        this.gie.registerListener();
        this.gic.init();
        this.gic.setListPullRefreshListener(this.dwe);
        this.gic.a(this.gij);
        MessageManager.getInstance().registerListener(this.fNW);
    }

    public View getView() {
        if (this.gic != null) {
            return this.gic.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bug() {
        TiebaStatic.log(new an("c13493").O("obj_type", this.clT));
    }

    public void loadData() {
        if (this.gic != null) {
            this.gic.bur();
            this.gic.showLoadingView();
        }
        if (this.gie != null) {
            this.gie.tb(this.clT);
        }
    }

    public void vV() {
        if (this.gic != null) {
            this.gic.bun();
            this.gic.startPullRefresh();
            this.gic.ld(false);
            this.gic.bup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(int i) {
        if (this.gig != null) {
            this.gig.sY(i);
        }
        if (this.gie != null) {
            this.gie.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buh() {
        if (this.gie == null || v.isEmpty(this.gie.bui()) || (!(this.gie.buj() || this.clT == 0) || this.gif == null)) {
            return false;
        }
        this.gif.setData(this.gie.bui());
        this.gif.bj((ViewGroup) this.gic.getRootView());
        com.baidu.tbadk.core.sharedPref.b.alP().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.alP().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.e ta(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new h.e(string, 1000);
    }

    public void anM() {
        if (this.gic != null) {
            this.gic.anM();
        }
        if (this.gig != null) {
            this.gig.onChangeSkinType();
        }
        if (this.gif != null) {
            this.gif.onChangeSkinType();
        }
        if (this.gig.isShowing()) {
            am.setBackgroundResource(this.gic.but(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.gic.but(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.gic != null) {
            this.gic.onPause();
            this.gic.bsX();
            this.gic.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.gic != null) {
            this.gic.setListPullRefreshListener(null);
            this.gic.a((BdListView.e) null);
            this.gic.onDestroy();
        }
        if (this.gig != null) {
            this.gig.onDestroy();
        }
        if (this.gif != null) {
            this.gif.onDestroy();
        }
        if (this.gie != null) {
            this.gie.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fNW);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").O("obj_type", this.clT));
            if (!this.gig.isShowing()) {
                this.gic.setViewForeground();
                return;
            }
            return;
        }
        if (this.gig != null) {
            this.gig.buc();
        }
        this.gic.bsX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gie != null && !v.isEmpty(this.gie.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.gie.wm(optString);
            this.gie.wX(optString);
            if (this.gic != null) {
                this.gic.wZ(optString);
            }
        }
    }
}
