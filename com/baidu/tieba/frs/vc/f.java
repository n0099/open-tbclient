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
/* loaded from: classes22.dex */
public class f {
    private FrsFragment iVs;
    private TBSpecificationBtn jwQ;
    private boolean jwS;
    private LikeModel fgf = null;
    private ae jwR = null;
    private AntiHelper.a jwT = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d jwU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cCK;
            w wVar;
            if (f.this.iVs != null && (cCK = f.this.iVs.cCK()) != null && cCK.getForum() != null && obj != null) {
                if (AntiHelper.bP(f.this.fgf.getErrorCode(), f.this.fgf.getErrorString())) {
                    if (AntiHelper.a(f.this.iVs.getActivity(), f.this.fgf.getBlockPopInfoData(), f.this.jwT) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cCK.getForum().getName();
                String id = cCK.getForum().getId();
                if (!(obj instanceof w)) {
                    wVar = null;
                } else {
                    wVar = (w) obj;
                }
                boolean z = wVar != null && f.this.fgf.getErrorCode() == 0;
                if (wVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).brB();
                    z = false;
                }
                if (wVar == null || !z) {
                    if (f.this.fgf.getErrorCode() == 22) {
                        f.this.iVs.showToast(f.this.iVs.getString(R.string.had_liked_forum));
                    } else {
                        f.this.iVs.showToast(f.this.fgf.getErrorString());
                    }
                } else {
                    h cCc = f.this.iVs.cCc();
                    if (cCc != null) {
                        cCc.LK(name);
                    }
                    wVar.setLike(1);
                    cCK.updateLikeData(wVar);
                    cCK.setLikeFeedForumDataList(wVar.dOs());
                    if (cCc != null) {
                        cCc.a(cCK, f.this.jwS);
                    }
                    f.this.jwS = true;
                    f.this.iVs.showToast(f.this.iVs.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.F(f.this.iVs.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.iVs.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cKC();
                }
                f.this.iVs.aK(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jwV = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            FrsViewData cCK;
            if (f.this.iVs != null && (cCK = f.this.iVs.cCK()) != null && cCK.getForum() != null) {
                String name = cCK.getForum().getName();
                String id = cCK.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cCc = f.this.iVs.cCc();
                    if (cCc != null) {
                        cCc.LK(str);
                    }
                    cCK.getForum().setLike(0);
                    if (cCc != null) {
                        cCc.BJ(0);
                    }
                    f.this.iVs.aJ(true);
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
        this.iVs = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jwQ = tBSpecificationBtn;
        cFG();
    }

    public void cFG() {
        if (this.jwQ != null) {
            this.jwQ.bvt();
        }
    }

    public void aOG() {
        bSO();
        cKB();
    }

    public void cID() {
        if (this.fgf != null) {
            this.fgf.dOB();
        }
    }

    private void bSO() {
        if (this.iVs != null) {
            this.fgf = new LikeModel(this.iVs.getPageContext());
            this.fgf.setLoadDataCallBack(this.jwU);
        }
    }

    private void cKB() {
        this.jwR = new ae();
        this.jwR.setFrom("from_frs");
        this.jwR.a(this.jwV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKC() {
        ar arVar = new ar("c13605");
        if (this.iVs != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iVs.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cZZ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void qW(boolean z) {
        if (this.iVs != null && this.fgf != null) {
            FrsViewData cCK = this.iVs.cCK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iVs.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iVs.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cCK != null && cCK.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.iVs.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dY("fid", cCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.iVs.getFrom())) {
                    TiebaStatic.log(new ar("c10590").al("obj_type", 2).dY("fid", cCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.iVs.getFrom())) {
                    TiebaStatic.log(new ar("c10587").al("obj_type", 2).dY("fid", cCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.iVs.getFrom())) {
                    TiebaStatic.log(new ar("c10578").al("obj_type", 2).dY("fid", cCK.getForum().getId()));
                }
                this.fgf.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.iVs.getFrom())) {
                    TiebaStatic.eventStat(this.iVs.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.iVs.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dY("fid", cCK.getForum().getId()));
                }
                this.fgf.aL(cCK.getForum().getName(), cCK.getForum().getId(), "FRS");
                this.jwS = z;
            }
        }
    }

    public void cKD() {
        if (this.iVs != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iVs.getActivity());
            String str = "";
            FrsViewData cCK = this.iVs.cCK();
            if (cCK != null && cCK.getForum() != null && cCK.getForum().getName() != null) {
                str = cCK.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Bq(String.format(this.iVs.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Bq(this.iVs.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.iVs.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.iVs != null && f.this.jwR != null) {
                        FrsViewData cCK2 = f.this.iVs.cCK();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.iVs.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.iVs.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cCK2 != null && cCK2.getForum() != null) {
                            f.this.jwR.O(cCK2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cCK2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.iVs.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iVs.getTbPageContext()).brv();
        }
    }

    public void fl(String str, String str2) {
        if (this.fgf != null) {
            this.fgf.aL(str, str2, "FRS");
        }
    }
}
