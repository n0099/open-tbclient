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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.model.ag;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForumListActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public static boolean avK = false;
    private static String avL = "";
    private static String avM = "";
    private static String avN = "";
    private static String avO = "";
    private p avC;
    private p avD;
    private c avE;
    private r avF;
    private int avg;
    private int avh;
    private Drawable avi;
    private Drawable avj;
    private Drawable avk;
    private Drawable avl;
    private Drawable avm;
    private Drawable avn;
    public u avy;
    private ForumListModel.RequestParams avz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int avo = Constants.MEDIA_INFO;
    private int avp = Constants.MEDIA_INFO;
    private int avq = 0;
    private final ag avr = new ag(this);
    private boolean avs = false;
    private int menu_choose = 0;
    private boolean avt = false;
    private int avu = 0;
    private int avv = Constants.MEDIA_INFO;
    private boolean avw = true;
    private boolean avx = true;
    private boolean avA = false;
    private boolean avB = false;
    private final s avG = new f(this);
    private final e avH = new g(this);
    private final AdapterView.OnItemClickListener avI = new h(this);
    private final com.baidu.adp.widget.ListView.f avJ = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str) {
        com.baidu.tieba.square.q DI = this.avy.awD.DI();
        if (DI != null) {
            ArrayList<com.baidu.tieba.square.q> arrayList = DI.bMu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).auZ.equals(str)) {
                    this.menu_choose = i;
                    this.avy.awD.ez(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3) {
        try {
            this.avz.menu_id = Integer.valueOf(str2).intValue();
            this.avz.menu_name = str;
            this.avz.menu_type = Integer.valueOf(str3).intValue();
            this.avz.parent_menu_id = Integer.valueOf(getIntent().getStringExtra("parent_menu_id")).intValue();
            this.avz.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            this.avz.offset = 0;
            this.avz.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        this.avu = this.avz.recommend_type;
        this.avv = this.avz.rn;
        this.avz.recommend_type = 0;
        this.avz.rn = Constants.MEDIA_INFO;
        this.avt = true;
        this.avF.a(this.avz);
        this.avF.LoadData();
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
        this.avy = new u(this);
        this.avy.awn = (BdListView) DK();
        this.avy.awo = (BdListView) DM();
        this.avy.mProgressBar.setVisibility(0);
        this.avy.awE.setOnClickListener(null);
        this.avy.awE.setClickable(false);
        this.avy.Ct.setAdapter(new m(this));
        this.avC = new p(this, 0);
        this.avy.awn.setAdapter((ListAdapter) this.avC);
        this.avD = new p(this, 1);
        this.avy.awo.setAdapter((ListAdapter) this.avD);
        b(getIntent().getStringExtra("parent_menu_name"), getIntent().getStringExtra("parent_menu_id"), getIntent().getStringExtra("menu_type"), getIntent().getStringExtra("level_2_menu_name"));
    }

    private void b(String str, String str2, String str3, String str4) {
        if (ay.aA(str4)) {
            str4 = str;
        }
        this.avy.atA.setText(str4);
        this.avy.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        this.avz = new ForumListModel.RequestParams();
        try {
            this.avz.menu_id = Integer.valueOf(str2).intValue();
            this.avz.menu_name = str4;
            this.avz.menu_type = Integer.valueOf(str3).intValue();
            this.avz.parent_menu_id = Integer.valueOf(str2).intValue();
            this.avz.parent_menu_name = str;
            this.avz.offset = 0;
            this.avz.rn = 10;
        } catch (NullPointerException e) {
            finish();
        }
        if (this.avz.menu_id != 0) {
            this.avy.DT();
            this.avs = true;
            this.avx = false;
            this.avC.e(Boolean.valueOf(this.avx));
            this.avy.Ct.getAdapter().notifyDataSetChanged();
        } else {
            this.avx = true;
            this.avC.e(Boolean.valueOf(this.avx));
            this.avy.DS();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.avy.awn.setPullRefresh(this.avy.awx);
        this.avy.awo.setPullRefresh(this.avy.awy);
        this.avy.awx.a(this.avJ);
        this.avy.awy.a(this.avJ);
        if (str3.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
            this.avy.awF.setVisibility(8);
            this.avy.DV();
        } else {
            this.avE = new c(this, str, str3, str2);
            this.avE.a(this.avH);
            this.avE.LoadData();
        }
        this.avF = new r(this, this.avz);
        this.avF.a(this.avG);
        this.avy.awn.hO();
    }

    public static void c(String str, String str2, String str3, String str4) {
        avL = str;
        avM = str2;
        avN = str3;
        avO = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (avK) {
            avK = false;
            finish();
            a(this, avL, avN, avM, avO);
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.avC != null) {
                this.avC.DQ();
                this.avC.notifyDataSetChanged();
            }
            if (this.avD != null) {
                this.avD.DQ();
                this.avD.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.avr != null) {
            this.avr.TF();
        }
        this.avy.Ct.setAdapter(null);
        this.avy.awo.setAdapter((ListAdapter) null);
        this.avy.awn.setAdapter((ListAdapter) null);
        if (this.avy.awC != null) {
            this.avy.awC.setAdapter((ListAdapter) null);
        }
        if (this.avE != null) {
            this.avE.cancelLoadData();
        }
        if (this.avF != null) {
            this.avF.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.avy.asy);
        this.avy.mNavigationBar.onChangeSkinType(i);
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.avC.bG(true);
            this.avD.bG(true);
        } else {
            this.avC.bG(false);
            this.avD.bG(false);
        }
        this.avC.notifyDataSetChanged();
        this.avD.notifyDataSetChanged();
        if (this.avy.awz != null) {
            this.avy.awz.setBackgroundDrawable(aw.getDrawable(com.baidu.tieba.u.bg_allsproutpop_dropdown));
        }
        aw.c(this.avy.awF, com.baidu.tieba.u.btn_allsproutpop_down);
        aw.h(this.avy.awl, com.baidu.tieba.u.bg_pop_most);
        this.avg = aw.getColor(com.baidu.tieba.s.flist_text_color_day);
        this.avh = aw.getColor(com.baidu.tieba.s.forum_list_tab_text_select);
        this.avi = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_left_n);
        this.avj = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_right_n);
        this.avk = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_left_s);
        this.avl = aw.getDrawable(com.baidu.tieba.u.btn_pop_most_right_s);
        this.avm = aw.getDrawable(com.baidu.tieba.u.ico_downward);
        this.avn = aw.getDrawable(com.baidu.tieba.u.ico_upward);
        this.avC.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        this.avD.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        aw.h(this.avy.awk, com.baidu.tieba.u.bg_black_banner_down);
        aw.b(this.avy.awv, com.baidu.tieba.s.flist_text_color_day, 1);
        aw.h(this.avy.awj, com.baidu.tieba.u.bg_black_banner_down);
        aw.b(this.avy.aws, com.baidu.tieba.s.flist_text_color_day, 1);
        if (this.avA) {
            aw.c(this.avy.awt, com.baidu.tieba.u.ico_upward);
        } else {
            aw.c(this.avy.awt, com.baidu.tieba.u.ico_downward);
        }
        if (this.avB) {
            aw.c(this.avy.aww, com.baidu.tieba.u.ico_upward);
        } else {
            aw.c(this.avy.aww, com.baidu.tieba.u.ico_downward);
        }
        if (this.avy.Ct.getCurrentItem() == 0) {
            this.avy.awp.setTextColor(this.avh);
            this.avy.awp.setBackgroundDrawable(this.avk);
            this.avy.awq.setBackgroundDrawable(this.avj);
            this.avy.awq.setTextColor(this.avg);
            return;
        }
        this.avy.awq.setTextColor(this.avh);
        this.avy.awq.setBackgroundDrawable(this.avl);
        this.avy.awp.setBackgroundDrawable(this.avi);
        this.avy.awp.setTextColor(this.avg);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.tab_recommends) {
            this.avy.Ct.setCurrentItem(0);
            this.avq = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.v.tab_hot) {
            this.avy.Ct.setCurrentItem(1);
            this.avq = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.v.title_menu) {
            this.avy.b(this.avI);
        }
    }

    private View DK() {
        this.avy.awn = DO();
        this.avy.awr.setOnClickListener(new j(this));
        return this.avy.awn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DL() {
        if (this.avA) {
            int min = Math.min(this.avC.getCount(), (int) Constants.MEDIA_INFO);
            this.avo = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.avC.DP(), 0, forumInfoDataArr, 0, min);
            this.avC.eA(min);
            this.avC.a(forumInfoDataArr);
            this.avA = false;
            this.avy.aws.setText(getString(com.baidu.tieba.y.flist_expand_list));
            this.avy.awt.setImageDrawable(this.avm);
            return;
        }
        this.avo = 50;
        o oVar = new o(this, null);
        oVar.bF(true);
        oVar.execute(new Void[0]);
    }

    private View DM() {
        this.avy.awo = DO();
        this.avy.awu.setOnClickListener(new k(this));
        return this.avy.awo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN() {
        if (this.avB) {
            int min = Math.min(this.avD.getCount(), (int) Constants.MEDIA_INFO);
            this.avp = Constants.MEDIA_INFO;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.avD.DP(), 0, forumInfoDataArr, 0, min);
            this.avD.eA(min);
            this.avD.a(forumInfoDataArr);
            this.avB = false;
            this.avy.awv.setText(getString(com.baidu.tieba.y.flist_expand_list));
            this.avy.aww.setImageDrawable(this.avm);
            return;
        }
        this.avp = 50;
        n nVar = new n(this, null);
        nVar.bF(true);
        nVar.execute(new Void[0]);
    }

    private BdListView DO() {
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
        if (!this.avs) {
            if (i == 0) {
                this.avC.DQ();
                this.avC.notifyDataSetChanged();
                this.avy.awp.setBackgroundDrawable(this.avk);
                this.avy.awp.setTextColor(this.avh);
                this.avy.awq.setBackgroundDrawable(this.avj);
                this.avy.awq.setTextColor(this.avg);
            } else if (i == 1) {
                this.avD.DQ();
                this.avD.notifyDataSetChanged();
                this.avy.awq.setBackgroundDrawable(this.avl);
                this.avy.awq.setTextColor(this.avh);
                this.avy.awp.setBackgroundDrawable(this.avi);
                this.avy.awp.setTextColor(this.avg);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ForumInfoData[] DP;
        if (i == 11002 && i2 == -1) {
            this.avF.LoadData();
            if (this.avq == 0) {
                DP = this.avC.DP();
            } else {
                DP = this.avD.DP();
            }
            this.avr.setLoadDataCallBack(new l(this, DP));
            if (this.avq == 0) {
                this.avr.ay(DP[this.avC.avS].forum_name, String.valueOf(DP[this.avC.avS].forum_id));
            } else {
                this.avr.ay(DP[this.avD.avS].forum_name, String.valueOf(DP[this.avD.avS].forum_id));
            }
        }
    }
}
