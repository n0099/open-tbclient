package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f {
    private TBSpecificationBtn jJl;
    private boolean jJn;
    private FrsFragment jhE;
    private LikeModel fpO = null;
    private ae jJm = null;
    private AntiHelper.a jJo = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.e jJp = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            FrsViewData cFF;
            w wVar;
            if (f.this.jhE != null && (cFF = f.this.jhE.cFF()) != null && cFF.getForum() != null && obj != null) {
                if (AntiHelper.bP(f.this.fpO.getErrorCode(), f.this.fpO.getErrorString())) {
                    if (AntiHelper.a(f.this.jhE.getActivity(), f.this.fpO.getBlockPopInfoData(), f.this.jJo) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cFF.getForum().getName();
                String id = cFF.getForum().getId();
                if (!(obj instanceof w)) {
                    wVar = null;
                } else {
                    wVar = (w) obj;
                }
                boolean z = wVar != null && f.this.fpO.getErrorCode() == 0;
                if (wVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bue();
                    z = false;
                }
                if (wVar == null || !z) {
                    if (f.this.fpO.getErrorCode() == 22) {
                        f.this.jhE.showToast(f.this.jhE.getString(R.string.had_liked_forum));
                    } else {
                        f.this.jhE.showToast(f.this.fpO.getErrorString());
                    }
                } else {
                    h cEX = f.this.jhE.cEX();
                    if (cEX != null) {
                        cEX.LJ(name);
                    }
                    wVar.setLike(1);
                    cFF.updateLikeData(wVar);
                    cFF.setLikeFeedForumDataList(wVar.dOl());
                    if (cEX != null) {
                        cEX.a(cFF, f.this.jJn);
                    }
                    f.this.jJn = true;
                    f.this.jhE.showToast(f.this.jhE.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.G(f.this.jhE.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.jhE.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cND();
                }
                f.this.jhE.aL(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jJq = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            FrsViewData cFF;
            if (f.this.jhE != null && (cFF = f.this.jhE.cFF()) != null && cFF.getForum() != null) {
                String name = cFF.getForum().getName();
                String id = cFF.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cEX = f.this.jhE.cEX();
                    if (cEX != null) {
                        cEX.LJ(str);
                    }
                    cFF.getForum().setLike(0);
                    if (cEX != null) {
                        cEX.BV(0);
                    }
                    f.this.jhE.aK(true);
                    f.this.s(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    w wVar = new w();
                    wVar.setLike(0);
                    wVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.jhE = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jJl = tBSpecificationBtn;
        cID();
    }

    public void cID() {
        if (this.jJl != null) {
            this.jJl.bxP();
        }
    }

    public void aQY() {
        bVt();
        cNC();
    }

    public void cLE() {
        if (this.fpO != null) {
            this.fpO.dOu();
        }
    }

    private void bVt() {
        if (this.jhE != null) {
            this.fpO = new LikeModel(this.jhE.getPageContext());
            this.fpO.setLoadDataCallBack(this.jJp);
        }
    }

    private void cNC() {
        this.jJm = new ae();
        this.jJm.setFrom("from_frs");
        this.jJm.a(this.jJq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cND() {
        aq aqVar = new aq("c13605");
        if (this.jhE != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jhE.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cZN().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void ru(boolean z) {
        if (this.jhE != null && this.fpO != null) {
            FrsViewData cFF = this.jhE.cFF();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jhE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jhE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cFF != null && cFF.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.jhE.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dX("fid", cFF.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.jhE.getFrom())) {
                    TiebaStatic.log(new aq("c10590").an("obj_type", 2).dX("fid", cFF.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.jhE.getFrom())) {
                    TiebaStatic.log(new aq("c10587").an("obj_type", 2).dX("fid", cFF.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.jhE.getFrom())) {
                    TiebaStatic.log(new aq("c10578").an("obj_type", 2).dX("fid", cFF.getForum().getId()));
                }
                this.fpO.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.jhE.getFrom())) {
                    TiebaStatic.eventStat(this.jhE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.jhE.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dX("fid", cFF.getForum().getId()));
                }
                this.fpO.aO(cFF.getForum().getName(), cFF.getForum().getId(), "FRS");
                this.jJn = z;
            }
        }
    }

    public void cNE() {
        if (this.jhE != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jhE.getActivity());
            String str = "";
            FrsViewData cFF = this.jhE.cFF();
            if (cFF != null && cFF.getForum() != null && cFF.getForum().getName() != null) {
                str = cFF.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Bo(String.format(this.jhE.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Bo(this.jhE.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.jhE.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.jhE != null && f.this.jJm != null) {
                        FrsViewData cFF2 = f.this.jhE.cFF();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.jhE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.jhE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cFF2 != null && cFF2.getForum() != null) {
                            f.this.jJm.P(cFF2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cFF2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.jhE.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jhE.getTbPageContext()).btY();
        }
    }

    public void fm(String str, String str2) {
        if (this.fpO != null) {
            this.fpO.aO(str, str2, "FRS");
        }
    }
}
