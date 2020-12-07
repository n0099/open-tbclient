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
    private FrsFragment iVq;
    private TBSpecificationBtn jwO;
    private boolean jwQ;
    private LikeModel fgf = null;
    private ae jwP = null;
    private AntiHelper.a jwR = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d jwS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cCJ;
            w wVar;
            if (f.this.iVq != null && (cCJ = f.this.iVq.cCJ()) != null && cCJ.getForum() != null && obj != null) {
                if (AntiHelper.bP(f.this.fgf.getErrorCode(), f.this.fgf.getErrorString())) {
                    if (AntiHelper.a(f.this.iVq.getActivity(), f.this.fgf.getBlockPopInfoData(), f.this.jwR) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cCJ.getForum().getName();
                String id = cCJ.getForum().getId();
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
                        f.this.iVq.showToast(f.this.iVq.getString(R.string.had_liked_forum));
                    } else {
                        f.this.iVq.showToast(f.this.fgf.getErrorString());
                    }
                } else {
                    h cCb = f.this.iVq.cCb();
                    if (cCb != null) {
                        cCb.LK(name);
                    }
                    wVar.setLike(1);
                    cCJ.updateLikeData(wVar);
                    cCJ.setLikeFeedForumDataList(wVar.dOr());
                    if (cCb != null) {
                        cCb.a(cCJ, f.this.jwQ);
                    }
                    f.this.jwQ = true;
                    f.this.iVq.showToast(f.this.iVq.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.F(f.this.iVq.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.iVq.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cKB();
                }
                f.this.iVq.aK(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jwT = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            FrsViewData cCJ;
            if (f.this.iVq != null && (cCJ = f.this.iVq.cCJ()) != null && cCJ.getForum() != null) {
                String name = cCJ.getForum().getName();
                String id = cCJ.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cCb = f.this.iVq.cCb();
                    if (cCb != null) {
                        cCb.LK(str);
                    }
                    cCJ.getForum().setLike(0);
                    if (cCb != null) {
                        cCb.BJ(0);
                    }
                    f.this.iVq.aJ(true);
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
        this.iVq = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jwO = tBSpecificationBtn;
        cFF();
    }

    public void cFF() {
        if (this.jwO != null) {
            this.jwO.bvt();
        }
    }

    public void aOG() {
        bSN();
        cKA();
    }

    public void cIC() {
        if (this.fgf != null) {
            this.fgf.dOA();
        }
    }

    private void bSN() {
        if (this.iVq != null) {
            this.fgf = new LikeModel(this.iVq.getPageContext());
            this.fgf.setLoadDataCallBack(this.jwS);
        }
    }

    private void cKA() {
        this.jwP = new ae();
        this.jwP.setFrom("from_frs");
        this.jwP.a(this.jwT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKB() {
        ar arVar = new ar("c13605");
        if (this.iVq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iVq.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cZY().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void qW(boolean z) {
        if (this.iVq != null && this.fgf != null) {
            FrsViewData cCJ = this.iVq.cCJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cCJ != null && cCJ.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.iVq.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dY("fid", cCJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.iVq.getFrom())) {
                    TiebaStatic.log(new ar("c10590").al("obj_type", 2).dY("fid", cCJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.iVq.getFrom())) {
                    TiebaStatic.log(new ar("c10587").al("obj_type", 2).dY("fid", cCJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.iVq.getFrom())) {
                    TiebaStatic.log(new ar("c10578").al("obj_type", 2).dY("fid", cCJ.getForum().getId()));
                }
                this.fgf.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.iVq.getFrom())) {
                    TiebaStatic.eventStat(this.iVq.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.iVq.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dY("fid", cCJ.getForum().getId()));
                }
                this.fgf.aL(cCJ.getForum().getName(), cCJ.getForum().getId(), "FRS");
                this.jwQ = z;
            }
        }
    }

    public void cKC() {
        if (this.iVq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iVq.getActivity());
            String str = "";
            FrsViewData cCJ = this.iVq.cCJ();
            if (cCJ != null && cCJ.getForum() != null && cCJ.getForum().getName() != null) {
                str = cCJ.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Bq(String.format(this.iVq.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Bq(this.iVq.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.iVq.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.iVq != null && f.this.jwP != null) {
                        FrsViewData cCJ2 = f.this.iVq.cCJ();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.iVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.iVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cCJ2 != null && cCJ2.getForum() != null) {
                            f.this.jwP.O(cCJ2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cCJ2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.iVq.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iVq.getTbPageContext()).brv();
        }
    }

    public void fl(String str, String str2) {
        if (this.fgf != null) {
            this.fgf.aL(str, str2, "FRS");
        }
    }
}
