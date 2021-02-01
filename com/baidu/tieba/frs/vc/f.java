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
    private TBSpecificationBtn jKj;
    private boolean jKl;
    private FrsFragment jiE;
    private LikeModel fnw = null;
    private ae jKk = null;
    private AntiHelper.a jKm = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.e jKn = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            FrsViewData cCZ;
            w wVar;
            if (f.this.jiE != null && (cCZ = f.this.jiE.cCZ()) != null && cCZ.getForum() != null && obj != null) {
                if (AntiHelper.bX(f.this.fnw.getErrorCode(), f.this.fnw.getErrorString())) {
                    if (AntiHelper.a(f.this.jiE.getActivity(), f.this.fnw.getBlockPopInfoData(), f.this.jKm) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cCZ.getForum().getName();
                String id = cCZ.getForum().getId();
                if (!(obj instanceof w)) {
                    wVar = null;
                } else {
                    wVar = (w) obj;
                }
                boolean z = wVar != null && f.this.fnw.getErrorCode() == 0;
                if (wVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                    z = false;
                }
                if (wVar == null || !z) {
                    if (f.this.fnw.getErrorCode() == 22) {
                        f.this.jiE.showToast(f.this.jiE.getString(R.string.had_liked_forum));
                    } else {
                        f.this.jiE.showToast(f.this.fnw.getErrorString());
                    }
                } else {
                    h cCr = f.this.jiE.cCr();
                    if (cCr != null) {
                        cCr.Lk(name);
                    }
                    wVar.setLike(1);
                    cCZ.updateLikeData(wVar);
                    cCZ.setLikeFeedForumDataList(wVar.dME());
                    if (cCr != null) {
                        cCr.a(cCZ, f.this.jKl);
                    }
                    f.this.jKl = true;
                    f.this.jiE.showToast(f.this.jiE.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.G(f.this.jiE.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.jiE.getPageContext(), 4, 2000L);
                    }
                    f.this.z(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cKZ();
                }
                f.this.jiE.aL(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jKo = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            FrsViewData cCZ;
            if (f.this.jiE != null && (cCZ = f.this.jiE.cCZ()) != null && cCZ.getForum() != null) {
                String name = cCZ.getForum().getName();
                String id = cCZ.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cCr = f.this.jiE.cCr();
                    if (cCr != null) {
                        cCr.Lk(str);
                    }
                    cCZ.getForum().setLike(0);
                    if (cCr != null) {
                        cCr.Az(0);
                    }
                    f.this.jiE.aK(true);
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
        this.jiE = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jKj = tBSpecificationBtn;
        cFY();
    }

    public void cFY() {
        if (this.jKj != null) {
            this.jKj.bup();
        }
    }

    public void aNx() {
        bSe();
        cKY();
    }

    public void cIZ() {
        if (this.fnw != null) {
            this.fnw.dMN();
        }
    }

    private void bSe() {
        if (this.jiE != null) {
            this.fnw = new LikeModel(this.jiE.getPageContext());
            this.fnw.setLoadDataCallBack(this.jKn);
        }
    }

    private void cKY() {
        this.jKk = new ae();
        this.jKk.setFrom("from_frs");
        this.jKk.a(this.jKo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKZ() {
        ar arVar = new ar("c13605");
        if (this.jiE != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jiE.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cXT().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void rA(boolean z) {
        if (this.jiE != null && this.fnw != null) {
            FrsViewData cCZ = this.jiE.cCZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jiE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jiE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cCZ != null && cCZ.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.jiE.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dR("fid", cCZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.jiE.getFrom())) {
                    TiebaStatic.log(new ar("c10590").ap("obj_type", 2).dR("fid", cCZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.jiE.getFrom())) {
                    TiebaStatic.log(new ar("c10587").ap("obj_type", 2).dR("fid", cCZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.jiE.getFrom())) {
                    TiebaStatic.log(new ar("c10578").ap("obj_type", 2).dR("fid", cCZ.getForum().getId()));
                }
                this.fnw.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.jiE.getFrom())) {
                    TiebaStatic.eventStat(this.jiE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.jiE.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dR("fid", cCZ.getForum().getId()));
                }
                this.fnw.aP(cCZ.getForum().getName(), cCZ.getForum().getId(), "FRS");
                this.jKl = z;
            }
        }
    }

    public void cLa() {
        if (this.jiE != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jiE.getActivity());
            String str = "";
            FrsViewData cCZ = this.jiE.cCZ();
            if (cCZ != null && cCZ.getForum() != null && cCZ.getForum().getName() != null) {
                str = cCZ.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Au(String.format(this.jiE.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Au(this.jiE.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.jiE.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.jiE != null && f.this.jKk != null) {
                        FrsViewData cCZ2 = f.this.jiE.cCZ();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.jiE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.jiE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cCZ2 != null && cCZ2.getForum() != null) {
                            f.this.jKk.O(cCZ2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cCZ2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.jiE.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jiE.getTbPageContext()).bqx();
        }
    }

    public void fl(String str, String str2) {
        if (this.fnw != null) {
            this.fnw.aP(str, str2, "FRS");
        }
    }
}
