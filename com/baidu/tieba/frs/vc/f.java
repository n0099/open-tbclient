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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ay;
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
    private TBSpecificationBtn jMg;
    private boolean jMi;
    private FrsFragment jkB;
    private LikeModel foW = null;
    private ae jMh = null;
    private AntiHelper.a jMj = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.e jMk = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            FrsViewData cDm;
            w wVar;
            if (f.this.jkB != null && (cDm = f.this.jkB.cDm()) != null && cDm.getForum() != null && obj != null) {
                if (AntiHelper.bX(f.this.foW.getErrorCode(), f.this.foW.getErrorString())) {
                    if (AntiHelper.a(f.this.jkB.getActivity(), f.this.foW.getBlockPopInfoData(), f.this.jMj) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cDm.getForum().getName();
                String id = cDm.getForum().getId();
                if (!(obj instanceof w)) {
                    wVar = null;
                } else {
                    wVar = (w) obj;
                }
                boolean z = wVar != null && f.this.foW.getErrorCode() == 0;
                if (wVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqF();
                    z = false;
                }
                if (wVar == null || !z) {
                    if (f.this.foW.getErrorCode() == 22) {
                        f.this.jkB.showToast(f.this.jkB.getString(R.string.had_liked_forum));
                    } else {
                        f.this.jkB.showToast(f.this.foW.getErrorString());
                    }
                } else {
                    h cCE = f.this.jkB.cCE();
                    if (cCE != null) {
                        cCE.Lu(name);
                    }
                    wVar.setLike(1);
                    cDm.updateLikeData(wVar);
                    cDm.setLikeFeedForumDataList(wVar.dMU());
                    if (cCE != null) {
                        cCE.a(cDm, f.this.jMi);
                    }
                    f.this.jMi = true;
                    f.this.jkB.showToast(f.this.jkB.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.G(f.this.jkB.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.jkB.getPageContext(), 4, 2000L);
                    }
                    f.this.z(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cLm();
                }
                f.this.jkB.aN(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jMl = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            FrsViewData cDm;
            if (f.this.jkB != null && (cDm = f.this.jkB.cDm()) != null && cDm.getForum() != null) {
                String name = cDm.getForum().getName();
                String id = cDm.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cCE = f.this.jkB.cCE();
                    if (cCE != null) {
                        cCE.Lu(str);
                    }
                    cDm.getForum().setLike(0);
                    if (cCE != null) {
                        cCE.AA(0);
                    }
                    f.this.jkB.aM(true);
                    f.this.z(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    w wVar = new w();
                    wVar.setLike(0);
                    wVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.jkB = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jMg = tBSpecificationBtn;
        cGl();
    }

    public void cGl() {
        if (this.jMg != null) {
            this.jMg.bus();
        }
    }

    public void aNA() {
        bSr();
        cLl();
    }

    public void cJm() {
        if (this.foW != null) {
            this.foW.dNd();
        }
    }

    private void bSr() {
        if (this.jkB != null) {
            this.foW = new LikeModel(this.jkB.getPageContext());
            this.foW.setLoadDataCallBack(this.jMk);
        }
    }

    private void cLl() {
        this.jMh = new ae();
        this.jMh.setFrom("from_frs");
        this.jMh.a(this.jMl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLm() {
        ar arVar = new ar("c13605");
        if (this.jkB != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jkB.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cYh().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void rA(boolean z) {
        if (this.jkB != null && this.foW != null) {
            FrsViewData cDm = this.jkB.cDm();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jkB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jkB.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cDm != null && cDm.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.jkB.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dR("fid", cDm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.jkB.getFrom())) {
                    TiebaStatic.log(new ar("c10590").aq("obj_type", 2).dR("fid", cDm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.jkB.getFrom())) {
                    TiebaStatic.log(new ar("c10587").aq("obj_type", 2).dR("fid", cDm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.jkB.getFrom())) {
                    TiebaStatic.log(new ar("c10578").aq("obj_type", 2).dR("fid", cDm.getForum().getId()));
                }
                this.foW.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.jkB.getFrom())) {
                    TiebaStatic.eventStat(this.jkB.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.jkB.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dR("fid", cDm.getForum().getId()));
                }
                this.foW.aP(cDm.getForum().getName(), cDm.getForum().getId(), "FRS");
                this.jMi = z;
            }
        }
    }

    public void cLn() {
        if (this.jkB != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jkB.getActivity());
            String str = "";
            FrsViewData cDm = this.jkB.cDm();
            if (cDm != null && cDm.getForum() != null && cDm.getForum().getName() != null) {
                str = cDm.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.AB(String.format(this.jkB.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.AB(this.jkB.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.jkB.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.jkB != null && f.this.jMh != null) {
                        FrsViewData cDm2 = f.this.jkB.cDm();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.jkB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.jkB.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cDm2 != null && cDm2.getForum() != null) {
                            f.this.jMh.O(cDm2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cDm2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.jkB.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jkB.getTbPageContext()).bqz();
        }
    }

    public void fl(String str, String str2) {
        if (this.foW != null) {
            this.foW.aP(str, str2, "FRS");
        }
    }
}
