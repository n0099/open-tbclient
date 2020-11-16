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
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes21.dex */
public class f {
    private FrsFragment iKx;
    private TBSpecificationBtn jjm;
    private boolean jjo;
    private LikeModel eYI = null;
    private ad jjn = null;
    private AntiHelper.a jjp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d jjq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cys;
            v vVar;
            if (f.this.iKx != null && (cys = f.this.iKx.cys()) != null && cys.getForum() != null && obj != null) {
                if (AntiHelper.bP(f.this.eYI.getErrorCode(), f.this.eYI.getErrorString())) {
                    if (AntiHelper.a(f.this.iKx.getActivity(), f.this.eYI.getBlockPopInfoData(), f.this.jjp) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cys.getForum().getName();
                String id = cys.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.eYI.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bom();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.eYI.getErrorCode() == 22) {
                        f.this.iKx.showToast(f.this.iKx.getString(R.string.had_liked_forum));
                    } else {
                        f.this.iKx.showToast(f.this.eYI.getErrorString());
                    }
                } else {
                    h cxL = f.this.iKx.cxL();
                    if (cxL != null) {
                        cxL.KD(name);
                    }
                    vVar.setLike(1);
                    cys.updateLikeData(vVar);
                    cys.setLikeFeedForumDataList(vVar.dJb());
                    if (cxL != null) {
                        cxL.a(cys, f.this.jjo);
                    }
                    f.this.jjo = true;
                    f.this.iKx.showToast(f.this.iKx.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.iKx.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.iKx.getPageContext(), 4, 2000L);
                    }
                    f.this.t(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.cFo();
                }
                f.this.iKx.aK(Boolean.valueOf(z));
            }
        }
    };
    private ad.a jjr = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            FrsViewData cys;
            if (f.this.iKx != null && (cys = f.this.iKx.cys()) != null && cys.getForum() != null) {
                String name = cys.getForum().getName();
                String id = cys.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cxL = f.this.iKx.cxL();
                    if (cxL != null) {
                        cxL.KD(str);
                    }
                    cys.getForum().setLike(0);
                    if (cxL != null) {
                        cxL.AV(0);
                    }
                    f.this.iKx.aJ(true);
                    f.this.t(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    v vVar = new v();
                    vVar.setLike(0);
                    vVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.iKx = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jjm = tBSpecificationBtn;
        cBp();
    }

    public void cBp() {
        if (this.jjm != null) {
            this.jjm.brT();
        }
    }

    public void aLz() {
        bPc();
        cFn();
    }

    public void cDp() {
        if (this.eYI != null) {
            this.eYI.dJj();
        }
    }

    private void bPc() {
        if (this.iKx != null) {
            this.eYI = new LikeModel(this.iKx.getPageContext());
            this.eYI.setLoadDataCallBack(this.jjq);
        }
    }

    private void cFn() {
        this.jjn = new ad();
        this.jjn.setFrom("from_frs");
        this.jjn.a(this.jjr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFo() {
        ar arVar = new ar("c13605");
        if (this.iKx != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iKx.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cUM().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void qv(boolean z) {
        if (this.iKx != null && this.eYI != null) {
            FrsViewData cys = this.iKx.cys();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iKx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iKx.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cys != null && cys.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.iKx.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dR("fid", cys.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.iKx.getFrom())) {
                    TiebaStatic.log(new ar("c10590").ak("obj_type", 2).dR("fid", cys.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.iKx.getFrom())) {
                    TiebaStatic.log(new ar("c10587").ak("obj_type", 2).dR("fid", cys.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.iKx.getFrom())) {
                    TiebaStatic.log(new ar("c10578").ak("obj_type", 2).dR("fid", cys.getForum().getId()));
                }
                this.eYI.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.iKx.getFrom())) {
                    TiebaStatic.eventStat(this.iKx.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.iKx.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dR("fid", cys.getForum().getId()));
                }
                this.eYI.aI(cys.getForum().getName(), cys.getForum().getId(), "FRS");
                this.jjo = z;
            }
        }
    }

    public void cFp() {
        if (this.iKx != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iKx.getActivity());
            String str = "";
            FrsViewData cys = this.iKx.cys();
            if (cys != null && cys.getForum() != null && cys.getForum().getName() != null) {
                str = cys.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.AJ(String.format(this.iKx.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.AJ(this.iKx.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.iKx.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.iKx != null && f.this.jjn != null) {
                        FrsViewData cys2 = f.this.iKx.cys();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.iKx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.iKx.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cys2 != null && cys2.getForum() != null) {
                            f.this.jjn.O(cys2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cys2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.iKx.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iKx.getTbPageContext()).bog();
        }
    }

    public void ff(String str, String str2) {
        if (this.eYI != null) {
            this.eYI.aI(str, str2, "FRS");
        }
    }
}
