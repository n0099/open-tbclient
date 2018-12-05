package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes6.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private FrsFragment dJE;
    public com.baidu.tieba.write.c dLg;
    private com.baidu.tieba.ueg.c dLi;
    public ImageView dOp;
    private NoPressedRelativeLayout ecJ;
    private i ecY;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bJ(d.this.dJE.getPageContext().getPageActivity()) && !d.this.dLi.bHs() && !d.this.aCn()) {
                if (d.this.ecY != null) {
                    d.this.ecY.aHz();
                }
                if (d.this.dLg == null) {
                    d.this.dLg = new com.baidu.tieba.write.c(d.this.dJE.getPageContext(), d.this.ecJ, "frs");
                    d.this.dLg.xt("2");
                }
                d.this.dLg.xs(d.this.aHc());
                d.this.dLg.a(d.this.dJE.aBc());
                d.this.dLg.os(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.oq()) {
                d.this.aHa();
                return;
            }
            d.this.dOp.setBackgroundResource(0);
            d.this.dOp.setImageDrawable(null);
            aVar.a(d.this.dOp);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dJE = frsFragment;
            this.ecJ = noPressedRelativeLayout;
            this.dOp = (ImageView) this.ecJ.findViewById(e.g.normal_write_icon);
            this.dOp.setOnClickListener(this.mOnClickListener);
            this.dLi = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gw(boolean z) {
        l aAZ;
        if (this.dOp != null) {
            aHb();
            this.dOp.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (aAZ = this.dJE.aAZ()) != null && aAZ.hiU != null && aAZ.bgi() != null && !StringUtils.isNull(aAZ.bgi().getId()) && !StringUtils.isNull(aAZ.hiU.recom_title) && !StringUtils.isNull(aAZ.hiU.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.aBi().n(aAZ.bgi().getId(), aAZ.hiU.uniq_topicid.longValue())) {
                a(this.dOp, aAZ);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aDZ() {
        if (this.dLg != null) {
            this.dLg.onDestroy();
        }
        if (this.ecY != null) {
            this.ecY.aHz();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aEa() {
        if (this.ecY != null) {
            this.ecY.aHz();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aEb() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aBE() {
        if (this.dLg == null || !this.dLg.isShowing()) {
            return false;
        }
        this.dLg.aCq();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dLg != null) {
            this.dLg.onChangeSkinType();
        }
        if (!aHb()) {
            aHa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHa() {
        al.i(this.dOp, e.f.icon_tabbar_chaticon_n);
        al.c(this.dOp, e.f.icon_tabbar_add_n);
    }

    public boolean aHb() {
        l aAZ;
        ActivityConfig activityConfig;
        if (this.dJE == null || (aAZ = this.dJE.aAZ()) == null || (activityConfig = aAZ.hjw) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            oN(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            oN(activityConfig.addthread_icon);
            return true;
        }
    }

    private void oN(String str) {
        com.baidu.adp.lib.f.c.jA().a(str, 10, this.mCallback, this.dJE.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aHc() {
        l aAZ;
        if (this.dJE == null || (aAZ = this.dJE.aAZ()) == null || aAZ.hjw == null) {
            return "";
        }
        return aAZ.hjw.addthread_text;
    }

    public boolean aCn() {
        l aAZ;
        String fixedText;
        if (this.dJE != null && (aAZ = this.dJE.aAZ()) != null) {
            if (ba.bJ(this.dJE.getPageContext().getPageActivity())) {
                AntiData yE = aAZ.yE();
                if (yE != null) {
                    if (a(yE.getBlock_stat(), yE.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (yE.getIfpost() == 0 && !StringUtils.isNull(yE.getForbid_info())) {
                        String forbid_info = yE.getForbid_info();
                        if (ao.fI(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dJE.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
                        b.Z(1.25f);
                        b.BN();
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dJE.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dJE.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Z(1.25f);
            b.BN();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dJE.getPageContext().getPageActivity());
        aVar.eB(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dJE.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ao.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ay.Ef().c(d.this.dJE.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dJE.getPageContext()).BF();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aEc() {
        if (this.dLg == null) {
            return false;
        }
        return this.dLg.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dJE != null && lVar != null && lVar.bgi() != null && lVar.hiU != null) {
            if (this.ecY == null) {
                this.ecY = new i(this.dJE.getActivity(), this);
            }
            this.ecY.aHz();
            this.ecY.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aEd() {
        return (this.dLi.bHs() || aCn()) ? false : true;
    }
}
