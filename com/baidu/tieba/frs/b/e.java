package com.baidu.tieba.frs.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bmZ = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v27, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        int i;
        String str;
        String str2;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        FrsActivity frsActivity13;
        frsActivity = this.bmZ.blE;
        com.baidu.tieba.tbadkCore.p Nn = frsActivity.Nn();
        if (Nn != null && Nn.akG() != null) {
            if (this.bmZ.PD() != null && (view == this.bmZ.PD().PV() || view == this.bmZ.PD().Qk())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bmZ.getPageContext().getPageActivity(), Nn.akG().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bmZ.PE() != null && (view == this.bmZ.PE().PV() || view == this.bmZ.PE().Qk())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bmZ.getPageContext().getPageActivity(), Nn.akG().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView PD = this.bmZ.PD();
        com.baidu.tieba.frs.view.q PE = this.bmZ.PE();
        if ((PD != null && PD.K(view)) || (PE != null && PE.K(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity12 = this.bmZ.blE;
                frsActivity12.Ni();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity13 = this.bmZ.blE;
                m411getInst.login(frsActivity13.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bmZ.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == n.g.btn_love) {
            frsActivity9 = this.bmZ.blE;
            if (!frsActivity9.No() && com.baidu.adp.lib.util.i.iQ()) {
                frsActivity10 = this.bmZ.blE;
                if (!frsActivity10.checkUpIsLogin()) {
                    av r = new av("c10517").r("obj_locate", 1);
                    frsActivity11 = this.bmZ.blE;
                    TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, frsActivity11.getForumId()));
                    return;
                }
                this.bmZ.os();
            }
        } else if (id == n.g.btn_sign || id == n.g.sign_done) {
            frsActivity2 = this.bmZ.blE;
            if (!frsActivity2.No() && com.baidu.adp.lib.util.i.iQ()) {
                frsActivity3 = this.bmZ.blE;
                if (frsActivity3.checkUpIsLogin()) {
                    if (!this.bmZ.PT()) {
                        this.bmZ.PW();
                    } else if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
                        frsActivity4 = this.bmZ.blE;
                        Activity pageActivity = frsActivity4.getPageContext().getPageActivity();
                        frsActivity5 = this.bmZ.blE;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity5.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == n.g.frs_header_games) {
            frsActivity7 = this.bmZ.blE;
            if (frsActivity7.checkUpIsLogin() && Nn != null && Nn.aDV() != null) {
                String aDV = Nn.aDV();
                int dl = com.baidu.tbadk.core.util.o.dl(aDV);
                if (dl == 2) {
                    bf.vn().a((TbPageContext) this.bmZ.getPageContext(), new String[]{aDV}, true);
                } else if (dl == 1) {
                    String mz = com.baidu.tieba.tbadkCore.util.n.mz(aDV);
                    if (TextUtils.isEmpty(mz) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bmZ.getPageContext().getPageActivity(), this.bmZ.getPageContext().getPageActivity().getString(n.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bmZ.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", mz, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bmZ.getPageContext().getPageActivity(), mz, "1000601")));
                } else if (dl == 3) {
                    frsActivity8 = this.bmZ.blE;
                    com.baidu.tbadk.core.util.o.a(frsActivity8.getPageContext(), aDV);
                }
            }
        } else if (id == n.g.btn_love_content) {
            frsActivity6 = this.bmZ.blE;
            if (!frsActivity6.No()) {
                i = this.bmZ.mScrollState;
                if (i == 0) {
                    str = this.bmZ.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bmZ.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bmZ.I(view);
                            return;
                        }
                        return;
                    }
                    this.bmZ.H(view);
                }
            }
        } else if (id == n.g.frs_bawu_center && Nn != null && Nn.getUserData() != null && Nn.getUserData().isBawu()) {
            String aEd = Nn.aEd();
            if (!ax.isEmpty(aEd)) {
                com.baidu.tbadk.browser.f.B(this.bmZ.getPageContext().getPageActivity(), aEd);
                if (Nn.akG() != null) {
                    TiebaStatic.log(new av("c10502").aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()).aa("uid", Nn.getUserData().getUserId()));
                }
            }
        }
    }
}
