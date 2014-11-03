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
import com.baidu.tbadk.core.util.az;
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
    private BaseFragmentActivity aye;
    private r aMr = null;
    private m aMs = null;
    private com.baidu.tieba.model.n aMt = null;
    private y aMu = null;
    private boolean aMv = true;
    private boolean aMw = false;
    private Boolean aMx = false;
    private long aAU = -1;
    private boolean aMy = false;
    private com.baidu.adp.framework.listener.a aMz = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private final com.baidu.tieba.model.r aMA = new h(this);
    private final View.OnKeyListener aMB = new i(this);
    private final com.baidu.adp.widget.ListView.f uo = new j(this);

    static {
        HQ();
    }

    private void IK() {
        MessageManager.getInstance().unRegisterListener(this.aMz);
        MessageManager.getInstance().registerListener(this.aMz);
    }

    private static void HQ() {
        ai.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        ai.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aMr.Je() || dialogInterface == this.aMr.Jf()) {
            switch (i) {
                case 0:
                    if (this.aMu != null) {
                        String name = this.aMu.getName();
                        if (az.az(name)) {
                            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aye).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    IL();
                    return;
                default:
                    return;
            }
        }
    }

    private void IL() {
        if (this.aMu != null) {
            if (this.aMu.isLike() == 1) {
                this.aMr.Jd();
            } else if (this.aMs == null) {
                this.aMs = new m(this, this.aMu);
                this.aMs.execute(new y[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aye = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return d(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aMz.setTag(BdUniqueId.gen());
        IK();
        this.aAU = System.currentTimeMillis();
        initUI();
        d(getArguments());
    }

    private View d(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aMr = new r(this.aye, this, this.aMB);
        this.aMr.a(this.uo);
        this.aMr.e(new k(this));
        this.aMr.IT().setOnClickListener(this);
    }

    private void d(Bundle bundle) {
        this.aMv = true;
        this.aMw = false;
        this.aMx = false;
        this.aMt = new com.baidu.tieba.model.n(this.aye);
        this.aMt.a(this.aMA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aMr.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aMy = false;
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
        this.aMr.onResume();
        ct(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        sq();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Hao123Plugin hao123Plugin;
        if (view.getId() == com.baidu.tieba.v.search_bg_layout) {
            sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aye)));
        } else if (view.getId() == this.aMr.IX() || view.getId() == this.aMr.IY()) {
            if (!this.aMy) {
                y yVar = view.getTag() instanceof y ? (y) view.getTag() : null;
                if (yVar != null) {
                    String name = yVar.getName();
                    if (az.az(name)) {
                        TiebaStatic.eventStat(this.aye, "ef_recent", "click", 1, new Object[0]);
                        this.aMy = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aye).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else if (view.getId() == this.aMr.IZ() || view.getId() == this.aMr.Ja()) {
            ad adVar = view.getTag() instanceof ad ? (ad) view.getTag() : null;
            if (adVar != null) {
                String forumName = adVar.getForumName();
                if (az.az(forumName)) {
                    sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aye).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            }
        } else if (view.getId() == com.baidu.tieba.v.square_all_cat) {
            TiebaStatic.eventStat(this.aye, "enter_icon_category", "click", 1, new Object[0]);
            BarFolderFirstDirActivity.b(this.aye, "enter_icon_category");
        } else if (view == this.aMr.IT()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(this.aye)));
        } else if (view == this.aMr.IQ()) {
            this.aMr.Jh();
        } else if (view == this.aMr.IP() && PluginHelper.isHao123CanUse(this.aye)) {
            TbadkApplication.m251getInst().setTiebaHelperOpen(true);
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
            if (pluginByName != null && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                hao123Plugin.openFloating(this.aye);
            }
            this.aMr.Jh();
            com.baidu.tbadk.core.j.l(this.aye, "tb_zs_entering");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.aMr.IX() || view.getId() == this.aMr.IY()) {
            this.aMu = null;
            y yVar = view.getTag() instanceof y ? (y) view.getTag() : null;
            if (yVar != null) {
                this.aMu = yVar;
                String name = yVar.getName();
                int isLike = yVar.isLike();
                if (az.az(name)) {
                    if (isLike == 1) {
                        this.aMr.Jb();
                    } else {
                        this.aMr.Jc();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aMr.onChangeSkinType(i);
    }

    public void sq() {
        if (this.aMs != null) {
            this.aMs.cancel();
            this.aMs = null;
        }
        this.aMt.cancelLoadData();
    }

    public void ct(boolean z) {
        boolean z2;
        boolean z3;
        if (this.aMt != null) {
            boolean booleanValue = this.aMx.booleanValue();
            this.aMx = Boolean.valueOf((TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true);
            if (this.aMv) {
                this.aMv = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.aMx.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (aj.wm().wz()) {
                aj.wm().aR(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (aj.wm().ws() > 0) {
                if (this.aMt != null && this.aMt.Tp() != null && this.aMt.Tp().yS() != null) {
                    Iterator<y> it = this.aMt.Tp().yS().zz().iterator();
                    while (it.hasNext()) {
                        y next = it.next();
                        if (aj.wm().dT(next.getName())) {
                            next.ec(1);
                            int dU = aj.wm().dU(next.getName());
                            if (dU > 0) {
                                next.setLevel(dU);
                            }
                        }
                    }
                }
                aj.wm().wr();
                String currentAccount = TbadkApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.util.j.hx(currentAccount);
                }
                this.aMr.notifyDataSetChanged();
            }
            if (z2 || z4) {
                sq();
                if (z4) {
                    this.aMr.hO();
                } else if (z2) {
                    this.aMt.dE(this.aMx.booleanValue());
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
