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
    private TBSpecificationBtn jKx;
    private boolean jKz;
    private FrsFragment jiS;
    private LikeModel fnw = null;
    private ae jKy = null;
    private AntiHelper.a jKA = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.e jKB = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            FrsViewData cDg;
            w wVar;
            if (f.this.jiS != null && (cDg = f.this.jiS.cDg()) != null && cDg.getForum() != null && obj != null) {
                if (AntiHelper.bX(f.this.fnw.getErrorCode(), f.this.fnw.getErrorString())) {
                    if (AntiHelper.a(f.this.jiS.getActivity(), f.this.fnw.getBlockPopInfoData(), f.this.jKA) != null) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cDg.getForum().getName();
                String id = cDg.getForum().getId();
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
                        f.this.jiS.showToast(f.this.jiS.getString(R.string.had_liked_forum));
                    } else {
                        f.this.jiS.showToast(f.this.fnw.getErrorString());
                    }
                } else {
                    h cCy = f.this.jiS.cCy();
                    if (cCy != null) {
                        cCy.Ll(name);
                    }
                    wVar.setLike(1);
                    cDg.updateLikeData(wVar);
                    cDg.setLikeFeedForumDataList(wVar.dMM());
                    if (cCy != null) {
                        cCy.a(cDg, f.this.jKz);
                    }
                    f.this.jKz = true;
                    f.this.jiS.showToast(f.this.jiS.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.G(f.this.jiS.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.jiS.getPageContext(), 4, 2000L);
                    }
                    f.this.z(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cLg();
                }
                f.this.jiS.aL(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jKC = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            FrsViewData cDg;
            if (f.this.jiS != null && (cDg = f.this.jiS.cDg()) != null && cDg.getForum() != null) {
                String name = cDg.getForum().getName();
                String id = cDg.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cCy = f.this.jiS.cCy();
                    if (cCy != null) {
                        cCy.Ll(str);
                    }
                    cDg.getForum().setLike(0);
                    if (cCy != null) {
                        cCy.Az(0);
                    }
                    f.this.jiS.aK(true);
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
        this.jiS = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jKx = tBSpecificationBtn;
        cGf();
    }

    public void cGf() {
        if (this.jKx != null) {
            this.jKx.bup();
        }
    }

    public void aNx() {
        bSl();
        cLf();
    }

    public void cJg() {
        if (this.fnw != null) {
            this.fnw.dMV();
        }
    }

    private void bSl() {
        if (this.jiS != null) {
            this.fnw = new LikeModel(this.jiS.getPageContext());
            this.fnw.setLoadDataCallBack(this.jKB);
        }
    }

    private void cLf() {
        this.jKy = new ae();
        this.jKy.setFrom("from_frs");
        this.jKy.a(this.jKC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLg() {
        ar arVar = new ar("c13605");
        if (this.jiS != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jiS.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cYa().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void rA(boolean z) {
        if (this.jiS != null && this.fnw != null) {
            FrsViewData cDg = this.jiS.cDg();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jiS.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jiS.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cDg != null && cDg.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.jiS.getFrom())) {
                    TiebaStatic.log(new ar("c10356").dR("fid", cDg.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.jiS.getFrom())) {
                    TiebaStatic.log(new ar("c10590").ap("obj_type", 2).dR("fid", cDg.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.jiS.getFrom())) {
                    TiebaStatic.log(new ar("c10587").ap("obj_type", 2).dR("fid", cDg.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.jiS.getFrom())) {
                    TiebaStatic.log(new ar("c10578").ap("obj_type", 2).dR("fid", cDg.getForum().getId()));
                }
                this.fnw.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.jiS.getFrom())) {
                    TiebaStatic.eventStat(this.jiS.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.jiS.getFrom())) {
                    TiebaStatic.log(new ar("c10359").dR("fid", cDg.getForum().getId()));
                }
                this.fnw.aP(cDg.getForum().getName(), cDg.getForum().getId(), "FRS");
                this.jKz = z;
            }
        }
    }

    public void cLh() {
        if (this.jiS != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jiS.getActivity());
            String str = "";
            FrsViewData cDg = this.jiS.cDg();
            if (cDg != null && cDg.getForum() != null && cDg.getForum().getName() != null) {
                str = cDg.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Au(String.format(this.jiS.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Au(this.jiS.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.jiS.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.jiS != null && f.this.jKy != null) {
                        FrsViewData cDg2 = f.this.jiS.cDg();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.jiS.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.jiS.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cDg2 != null && cDg2.getForum() != null) {
                            f.this.jKy.O(cDg2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cDg2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.jiS.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jiS.getTbPageContext()).bqx();
        }
    }

    public void fl(String str, String str2) {
        if (this.fnw != null) {
            this.fnw.aP(str, str2, "FRS");
        }
    }
}
