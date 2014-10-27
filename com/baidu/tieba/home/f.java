package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.ai;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.ad;
import com.baidu.tieba.data.y;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private BaseFragmentActivity axV;
    private r aMd = null;
    private m aMe = null;
    private com.baidu.tieba.model.n aMf = null;
    private y aMg = null;
    private boolean aMh = true;
    private boolean aMi = false;
    private Boolean aMj = false;
    private long aAK = -1;
    private boolean aMk = false;
    private com.baidu.adp.framework.listener.a aMl = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private final com.baidu.tieba.model.r aMm = new h(this);
    private final View.OnKeyListener aMn = new i(this);
    private final com.baidu.adp.widget.ListView.f uo = new j(this);

    static {
        HM();
    }

    private void IG() {
        MessageManager.getInstance().unRegisterListener(this.aMl);
        MessageManager.getInstance().registerListener(this.aMl);
    }

    private static void HM() {
        ai.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        ai.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aMd.Ja() || dialogInterface == this.aMd.Jb()) {
            switch (i) {
                case 0:
                    if (this.aMg != null) {
                        String name = this.aMg.getName();
                        if (ay.az(name)) {
                            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.axV).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    IH();
                    return;
                default:
                    return;
            }
        }
    }

    private void IH() {
        if (this.aMg != null) {
            if (this.aMg.isLike() == 1) {
                this.aMd.IZ();
            } else if (this.aMe == null) {
                this.aMe = new m(this, this.aMg);
                this.aMe.execute(new y[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.axV = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return d(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aMl.setTag(BdUniqueId.gen());
        IG();
        this.aAK = System.currentTimeMillis();
        initUI();
        d(getArguments());
    }

    private View d(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aMd = new r(this.axV, this, this.aMn);
        this.aMd.a(this.uo);
        this.aMd.e(new k(this));
        this.aMd.IP().setOnClickListener(this);
    }

    private void d(Bundle bundle) {
        this.aMh = true;
        this.aMi = false;
        this.aMj = false;
        this.aMf = new com.baidu.tieba.model.n(this.axV);
        this.aMf.a(this.aMm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aMd.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aMk = false;
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            getActivity().finish();
        }
        this.aMd.onResume();
        ct(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        so();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Hao123Plugin hao123Plugin;
        if (view.getId() == com.baidu.tieba.v.search_bg_layout) {
            sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.axV)));
        } else if (view.getId() == this.aMd.IT() || view.getId() == this.aMd.IU()) {
            if (!this.aMk) {
                y yVar = view.getTag() instanceof y ? (y) view.getTag() : null;
                if (yVar != null) {
                    String name = yVar.getName();
                    if (ay.az(name)) {
                        TiebaStatic.eventStat(this.axV, "ef_recent", "click", 1, new Object[0]);
                        this.aMk = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.axV).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else if (view.getId() == this.aMd.IV() || view.getId() == this.aMd.IW()) {
            ad adVar = view.getTag() instanceof ad ? (ad) view.getTag() : null;
            if (adVar != null) {
                String forumName = adVar.getForumName();
                if (ay.az(forumName)) {
                    sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.axV).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            }
        } else if (view.getId() == com.baidu.tieba.v.square_all_cat) {
            TiebaStatic.eventStat(this.axV, "enter_icon_category", "click", 1, new Object[0]);
            BarFolderFirstDirActivity.b(this.axV, "enter_icon_category");
        } else if (view == this.aMd.IP()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.axV)));
        } else if (view == this.aMd.IM()) {
            this.aMd.Jd();
        } else if (view == this.aMd.IL() && PluginHelper.isHao123CanUse(this.axV)) {
            TbadkApplication.m251getInst().setTiebaHelperOpen(true);
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
            if (pluginByName != null && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                hao123Plugin.openFloating(this.axV);
            }
            this.aMd.Jd();
            com.baidu.tbadk.core.i.l(this.axV, "tb_zs_entering");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.aMd.IT() || view.getId() == this.aMd.IU()) {
            this.aMg = null;
            y yVar = view.getTag() instanceof y ? (y) view.getTag() : null;
            if (yVar != null) {
                this.aMg = yVar;
                String name = yVar.getName();
                int isLike = yVar.isLike();
                if (ay.az(name)) {
                    if (isLike == 1) {
                        this.aMd.IX();
                    } else {
                        this.aMd.IY();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aMd.onChangeSkinType(i);
    }

    public void so() {
        if (this.aMe != null) {
            this.aMe.cancel();
            this.aMe = null;
        }
        this.aMf.cancelLoadData();
    }

    public void ct(boolean z) {
        boolean z2;
        boolean z3;
        if (this.aMf != null) {
            boolean booleanValue = this.aMj.booleanValue();
            this.aMj = Boolean.valueOf((TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true);
            if (this.aMh) {
                this.aMh = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.aMj.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (aj.wk().wx()) {
                aj.wk().aR(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (aj.wk().wq() > 0) {
                if (this.aMf != null && this.aMf.Tm() != null && this.aMf.Tm().yQ() != null) {
                    Iterator<y> it = this.aMf.Tm().yQ().zx().iterator();
                    while (it.hasNext()) {
                        y next = it.next();
                        if (aj.wk().dT(next.getName())) {
                            next.ec(1);
                            int dU = aj.wk().dU(next.getName());
                            if (dU > 0) {
                                next.setLevel(dU);
                            }
                        }
                    }
                }
                aj.wk().wp();
                String currentAccount = TbadkApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.util.j.hx(currentAccount);
                }
                this.aMd.notifyDataSetChanged();
            }
            if (z2 || z4) {
                so();
                if (z4) {
                    this.aMd.hO();
                } else if (z2) {
                    this.aMf.dE(this.aMj.booleanValue());
                    new Handler().postDelayed(new l(this), 1000L);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
