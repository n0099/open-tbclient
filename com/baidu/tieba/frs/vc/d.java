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
    private FrsFragment dMs;
    public com.baidu.tieba.write.c dNU;
    private com.baidu.tieba.ueg.c dNW;
    public ImageView dRd;
    private NoPressedRelativeLayout efA;
    private i efP;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bJ(d.this.dMs.getPageContext().getPageActivity()) && !d.this.dNW.bIh() && !d.this.aDc()) {
                if (d.this.efP != null) {
                    d.this.efP.aIo();
                }
                if (d.this.dNU == null) {
                    d.this.dNU = new com.baidu.tieba.write.c(d.this.dMs.getPageContext(), d.this.efA, "frs");
                    d.this.dNU.xw("2");
                }
                d.this.dNU.xv(d.this.aHR());
                d.this.dNU.a(d.this.dMs.aBR());
                d.this.dNU.ov(false);
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
                d.this.aHP();
                return;
            }
            d.this.dRd.setBackgroundResource(0);
            d.this.dRd.setImageDrawable(null);
            aVar.a(d.this.dRd);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dMs = frsFragment;
            this.efA = noPressedRelativeLayout;
            this.dRd = (ImageView) this.efA.findViewById(e.g.normal_write_icon);
            this.dRd.setOnClickListener(this.mOnClickListener);
            this.dNW = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gz(boolean z) {
        l aBO;
        if (this.dRd != null) {
            aHQ();
            this.dRd.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (aBO = this.dMs.aBO()) != null && aBO.hmf != null && aBO.bgT() != null && !StringUtils.isNull(aBO.bgT().getId()) && !StringUtils.isNull(aBO.hmf.recom_title) && !StringUtils.isNull(aBO.hmf.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.aBX().n(aBO.bgT().getId(), aBO.hmf.uniq_topicid.longValue())) {
                a(this.dRd, aBO);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aEO() {
        if (this.dNU != null) {
            this.dNU.onDestroy();
        }
        if (this.efP != null) {
            this.efP.aIo();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aEP() {
        if (this.efP != null) {
            this.efP.aIo();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aEQ() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCt() {
        if (this.dNU == null || !this.dNU.isShowing()) {
            return false;
        }
        this.dNU.aDf();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dNU != null) {
            this.dNU.onChangeSkinType();
        }
        if (!aHQ()) {
            aHP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHP() {
        al.i(this.dRd, e.f.icon_tabbar_chaticon_n);
        al.c(this.dRd, e.f.icon_tabbar_add_n);
    }

    public boolean aHQ() {
        l aBO;
        ActivityConfig activityConfig;
        if (this.dMs == null || (aBO = this.dMs.aBO()) == null || (activityConfig = aBO.hmH) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            oQ(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            oQ(activityConfig.addthread_icon);
            return true;
        }
    }

    private void oQ(String str) {
        com.baidu.adp.lib.f.c.jA().a(str, 10, this.mCallback, this.dMs.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aHR() {
        l aBO;
        if (this.dMs == null || (aBO = this.dMs.aBO()) == null || aBO.hmH == null) {
            return "";
        }
        return aBO.hmH.addthread_text;
    }

    public boolean aDc() {
        l aBO;
        String fixedText;
        if (this.dMs != null && (aBO = this.dMs.aBO()) != null) {
            if (ba.bJ(this.dMs.getPageContext().getPageActivity())) {
                AntiData yE = aBO.yE();
                if (yE != null) {
                    if (a(yE.getBlock_stat(), yE.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (yE.getIfpost() == 0 && !StringUtils.isNull(yE.getForbid_info())) {
                        String forbid_info = yE.getForbid_info();
                        if (ao.fI(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dMs.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dMs.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dMs.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Z(1.25f);
            b.BN();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dMs.getPageContext().getPageActivity());
        aVar.eB(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dMs.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.Ef().c(d.this.dMs.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dMs.getPageContext()).BF();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aER() {
        if (this.dNU == null) {
            return false;
        }
        return this.dNU.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dMs != null && lVar != null && lVar.bgT() != null && lVar.hmf != null) {
            if (this.efP == null) {
                this.efP = new i(this.dMs.getActivity(), this);
            }
            this.efP.aIo();
            this.efP.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aES() {
        return (this.dNW.bIh() || aDc()) ? false : true;
    }
}
