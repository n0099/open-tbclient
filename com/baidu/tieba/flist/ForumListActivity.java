package com.baidu.tieba.flist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ag;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public static boolean avT = false;
    private static String avU = "";
    private static String avV = "";
    private static String avW = "";
    private static String avX = "";
    public u avH;
    private ForumListModel.RequestParams avI;
    private p avL;
    private p avM;
    private c avN;
    private r avO;
    private int avp;
    private int avq;
    private Drawable avr;
    private Drawable avs;
    private Drawable avt;
    private Drawable avu;
    private Drawable avv;
    private Drawable avw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int avx = Constants.MEDIA_INFO;
    private int avy = Constants.MEDIA_INFO;
    private int avz = 0;
    private final ag avA = new ag(this);
    private boolean avB = false;
    private int menu_choose = 0;
    private boolean avC = false;
    private int avD = 0;
    private int avE = Constants.MEDIA_INFO;
    private boolean avF = true;
    private boolean avG = true;
    private boolean avJ = false;
    private boolean avK = false;
    private final s avP = new f(this);
    private final e avQ = new g(this);
    private final AdapterView.OnItemClickListener avR = new h(this);
    private final com.baidu.adp.widget.ListView.f avS = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str) {
        com.baidu.tieba.square.q DK = this.avH.awM.DK();
        if (DK != null) {
            ArrayList<com.baidu.tieba.square.q> arrayList = DK.bMJ;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).avi.equals(str)) {
                    this.menu_choose = i;
                    this.avH.awM.ez(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3) {
        try {
            this.avI.menu_id = Integer.valueOf(str2).intValue();
            this.avI.menu_name = str;
            this.avI.menu_type = Integer.valueOf(str3).intValue();
            this.avI.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.avI.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.avI.offset = 0;
            this.avI.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        this.avD = this.avI.recommend_type;
        this.avE = this.avI.rn;
        this.avI.recommend_type = 0;
        this.avI.rn = Constants.MEDIA_INFO;
        this.avC = true;
        this.avO.a(this.avI);
        this.avO.LoadData();
    }

    public static void c(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("parent_menu_name", str);
        intent.putExtra("menu_type", str2);
        intent.putExtra("parent_menu_id", str3);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra("parent_menu_name", str);
        intent.putExtra("menu_type", str2);
        intent.putExtra("parent_menu_id", str3);
        intent.putExtra("level_2_menu_name", str4);
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.forum_list_activity);
        this.avH = new u(this);
        this.avH.aww = (BdListView) DM();
        this.avH.awx = (BdListView) DO();
        this.avH.mProgressBar.setVisibility(0);
        this.avH.awN.setOnClickListener(null);
        this.avH.awN.setClickable(false);
        this.avH.Cu.setAdapter(new m(this));
        this.avL = new p(this, 0);
        this.avH.aww.setAdapter((ListAdapter) this.avL);
        this.avM = new p(this, 1);
        this.avH.awx.setAdapter((ListAdapter) this.avM);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        if (az.aA(str4)) {
            str4 = str;
        }
        this.avH.atJ.setText(str4);
        this.avH.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        this.avI = new ForumListModel.RequestParams();
        try {
            this.avI.menu_id = Integer.valueOf(str2).intValue();
            this.avI.menu_name = str4;
            this.avI.menu_type = Integer.valueOf(str3).intValue();
            this.avI.parent_menu_id = Integer.valueOf(str2).intValue();
            this.avI.parent_menu_name = str;
            this.avI.offset = 0;
            this.avI.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        if (this.avI.menu_id != 0) {
            this.avH.DV();
            this.avB = true;
            this.avG = false;
            this.avL.e(Boolean.valueOf(this.avG));
            this.avH.Cu.getAdapter().notifyDataSetChanged();
        } else {
            this.avG = true;
            this.avL.e(Boolean.valueOf(this.avG));
            this.avH.DU();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.avH.aww.setPullRefresh(this.avH.awG);
        this.avH.awx.setPullRefresh(this.avH.awH);
        this.avH.awG.a(this.avS);
        this.avH.awH.a(this.avS);
        if (str3.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
            this.avH.awO.setVisibility(8);
            this.avH.DX();
        } else {
            this.avN = new c(this, str, str3, str2);
            this.avN.a(this.avQ);
            this.avN.LoadData();
        }
        this.avO = new r(this, this.avI);
        this.avO.a(this.avP);
        this.avH.aww.hO();
    }

    public static void c(String str, String str2, String str3, String str4) {
        avU = str;
        avV = str2;
        avW = str3;
        avX = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (avT) {
            avT = false;
            finish();
            a(this, avU, avW, avV, avX);
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.avL != null) {
                this.avL.DS();
                this.avL.notifyDataSetChanged();
            }
            if (this.avM != null) {
                this.avM.DS();
                this.avM.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.avA != null) {
            this.avA.TI();
        }
        this.avH.Cu.setAdapter(null);
        this.avH.awx.setAdapter((ListAdapter) null);
        this.avH.aww.setAdapter((ListAdapter) null);
        if (this.avH.awL != null) {
            this.avH.awL.setAdapter((ListAdapter) null);
        }
        if (this.avN != null) {
            this.avN.cancelLoadData();
        }
        if (this.avO != null) {
            this.avO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.avH.asH);
        this.avH.mNavigationBar.onChangeSkinType(i);
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.avL.bG(true);
            this.avM.bG(true);
        } else {
            this.avL.bG(false);
            this.avM.bG(false);
        }
        this.avL.notifyDataSetChanged();
        this.avM.notifyDataSetChanged();
        if (this.avH.awI != null) {
            this.avH.awI.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.u.bg_allsproutpop_dropdown));
        }
        aw.c(this.avH.awO, com.baidu.tieba.u.btn_allsproutpop_down);
        aw.h(this.avH.awu, com.baidu.tieba.u.bg_pop_most);
        this.avp = aw.getColor(com.baidu.tieba.s.flist_text_color_day);
        this.avq = aw.getColor(com.baidu.tieba.s.forum_list_tab_text_select);
        this.avr = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_left_n);
        this.avs = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_right_n);
        this.avt = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_left_s);
        this.avu = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_right_s);
        this.avv = aw.getDrawable(com.baidu.tieba.u.ico_downward);
        this.avw = aw.getDrawable(com.baidu.tieba.u.ico_upward);
        this.avL.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        this.avM.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        aw.h(this.avH.awt, com.baidu.tieba.u.bg_black_banner_down);
        aw.b(this.avH.awE, com.baidu.tieba.s.flist_text_color_day, 1);
        aw.h(this.avH.aws, com.baidu.tieba.u.bg_black_banner_down);
        aw.b(this.avH.awB, com.baidu.tieba.s.flist_text_color_day, 1);
        if (this.avJ) {
            aw.c(this.avH.awC, com.baidu.tieba.u.ico_upward);
        } else {
            aw.c(this.avH.awC, com.baidu.tieba.u.ico_downward);
        }
        if (this.avK) {
            aw.c(this.avH.awF, com.baidu.tieba.u.ico_upward);
        } else {
            aw.c(this.avH.awF, com.baidu.tieba.u.ico_downward);
        }
        if (this.avH.Cu.getCurrentItem() == 0) {
            this.avH.awy.setTextColor(this.avq);
            this.avH.awy.setBackgroundDrawable(this.avt);
            this.avH.awz.setBackgroundDrawable(this.avs);
            this.avH.awz.setTextColor(this.avp);
            return;
        }
        this.avH.awz.setTextColor(this.avq);
        this.avH.awz.setBackgroundDrawable(this.avu);
        this.avH.awy.setBackgroundDrawable(this.avr);
        this.avH.awy.setTextColor(this.avp);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.tab_recommends) {
            this.avH.Cu.setCurrentItem(0);
            this.avz = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.v.tab_hot) {
            this.avH.Cu.setCurrentItem(1);
            this.avz = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.v.title_menu) {
            this.avH.b(this.avR);
        }
    }

    private View DM() {
        this.avH.aww = DQ();
        this.avH.awA.setOnClickListener(new j(this));
        return this.avH.aww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN() {
        if (this.avJ) {
            int min = Math.min(this.avL.getCount(), (int) Constants.MEDIA_INFO);
            this.avx = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.avL.DR(), 0, forumInfoDataArr, 0, min);
            this.avL.eA(min);
            this.avL.a(forumInfoDataArr);
            this.avJ = false;
            this.avH.awB.setText(getString(com.baidu.tieba.y.flist_expand_list));
            this.avH.awC.setImageDrawable(this.avv);
            return;
        }
        this.avx = 50;
        o oVar = new o(this, null);
        oVar.bF(true);
        oVar.execute(new Void[0]);
    }

    private View DO() {
        this.avH.awx = DQ();
        this.avH.awD.setOnClickListener(new k(this));
        return this.avH.awx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP() {
        if (this.avK) {
            int min = Math.min(this.avM.getCount(), (int) Constants.MEDIA_INFO);
            this.avy = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.avM.DR(), 0, forumInfoDataArr, 0, min);
            this.avM.eA(min);
            this.avM.a(forumInfoDataArr);
            this.avK = false;
            this.avH.awE.setText(getString(com.baidu.tieba.y.flist_expand_list));
            this.avH.awF.setImageDrawable(this.avv);
            return;
        }
        this.avy = 50;
        n nVar = new n(this, null);
        nVar.bF(true);
        nVar.execute(new Void[0]);
    }

    private BdListView DQ() {
        BdListView bdListView = new BdListView(this);
        bdListView.setScrollingCacheEnabled(false);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        bdListView.setDivider(new ColorDrawable(0));
        bdListView.setDividerHeight(0);
        bdListView.setFooterDividersEnabled(false);
        bdListView.setHorizontalFadingEdgeEnabled(false);
        bdListView.setVerticalFadingEdgeEnabled(false);
        return bdListView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.avB) {
            if (i == 0) {
                this.avL.DS();
                this.avL.notifyDataSetChanged();
                this.avH.awy.setBackgroundDrawable(this.avt);
                this.avH.awy.setTextColor(this.avq);
                this.avH.awz.setBackgroundDrawable(this.avs);
                this.avH.awz.setTextColor(this.avp);
            } else if (i == 1) {
                this.avM.DS();
                this.avM.notifyDataSetChanged();
                this.avH.awz.setBackgroundDrawable(this.avu);
                this.avH.awz.setTextColor(this.avq);
                this.avH.awy.setBackgroundDrawable(this.avr);
                this.avH.awy.setTextColor(this.avp);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumInfoData[] DR;
        if (i == 11002 && i2 == -1) {
            this.avO.LoadData();
            if (this.avz == 0) {
                DR = this.avL.DR();
            } else {
                DR = this.avM.DR();
            }
            this.avA.setLoadDataCallBack(new l(this, DR));
            if (this.avz == 0) {
                this.avA.ay(DR[this.avL.awb].forum_name, String.valueOf(DR[this.avL.awb].forum_id));
            } else {
                this.avA.ay(DR[this.avM.awb].forum_name, String.valueOf(DR[this.avM.awb].forum_id));
            }
        }
    }
}
