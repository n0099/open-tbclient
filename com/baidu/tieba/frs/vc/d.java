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
    private FrsFragment dBO;
    public com.baidu.tieba.write.c dDr;
    private com.baidu.tieba.ueg.c dDt;
    public ImageView dGB;
    private NoPressedRelativeLayout dUZ;
    private com.baidu.tieba.tblauncher.a dVo;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bI(d.this.dBO.getPageContext().getPageActivity()) && !d.this.dDt.bFP() && !d.this.aBg()) {
                if (d.this.dVo != null) {
                    d.this.dVo.bDQ();
                }
                if (d.this.dDr == null) {
                    d.this.dDr = new com.baidu.tieba.write.c(d.this.dBO.getPageContext(), d.this.dUZ, "frs");
                    d.this.dDr.wL("2");
                }
                d.this.dDr.wK(d.this.aFU());
                d.this.dDr.a(d.this.dBO.azV());
                d.this.dDr.oc(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.ot()) {
                d.this.aFS();
                return;
            }
            d.this.dGB.setBackgroundResource(0);
            d.this.dGB.setImageDrawable(null);
            aVar.a(d.this.dGB);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dBO = frsFragment;
            this.dUZ = noPressedRelativeLayout;
            this.dGB = (ImageView) this.dUZ.findViewById(e.g.normal_write_icon);
            this.dGB.setOnClickListener(this.mOnClickListener);
            this.dDt = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gl(boolean z) {
        l azS;
        if (this.dGB != null) {
            aFT();
            this.dGB.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (azS = this.dBO.azS()) != null && azS.haE != null && azS.beT() != null && !StringUtils.isNull(azS.beT().getId()) && !StringUtils.isNull(azS.haE.recom_title) && !StringUtils.isNull(azS.haE.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.aAa().n(azS.beT().getId(), azS.haE.uniq_topicid.longValue())) {
                a(this.dGB, azS);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCT() {
        if (this.dDr != null) {
            this.dDr.onDestroy();
        }
        if (this.dVo != null) {
            this.dVo.bDQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCU() {
        if (this.dVo != null) {
            this.dVo.bDQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCV() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aAx() {
        if (this.dDr == null || !this.dDr.isShowing()) {
            return false;
        }
        this.dDr.aBj();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dDr != null) {
            this.dDr.onChangeSkinType();
        }
        if (!aFT()) {
            aFS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFS() {
        al.i(this.dGB, e.f.icon_tabbar_chaticon_n);
        al.c(this.dGB, e.f.icon_tabbar_add_n);
    }

    public boolean aFT() {
        l azS;
        ActivityConfig activityConfig;
        if (this.dBO == null || (azS = this.dBO.azS()) == null || (activityConfig = azS.hbg) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            om(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            om(activityConfig.addthread_icon);
            return true;
        }
    }

    private void om(String str) {
        com.baidu.adp.lib.f.c.jC().a(str, 10, this.mCallback, this.dBO.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aFU() {
        l azS;
        if (this.dBO == null || (azS = this.dBO.azS()) == null || azS.hbg == null) {
            return "";
        }
        return azS.hbg.addthread_text;
    }

    public boolean aBg() {
        l azS;
        String fixedText;
        if (this.dBO != null && (azS = this.dBO.azS()) != null) {
            if (ba.bI(this.dBO.getPageContext().getPageActivity())) {
                AntiData xs = azS.xs();
                if (xs != null) {
                    if (a(xs.getBlock_stat(), xs.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (xs.getIfpost() == 0 && !StringUtils.isNull(xs.getForbid_info())) {
                        String forbid_info = xs.getForbid_info();
                        if (ao.fq(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dBO.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
                        b.Z(1.25f);
                        b.AC();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dBO.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dBO.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Z(1.25f);
            b.AC();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dBO.getPageContext().getPageActivity());
        aVar.ej(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dBO.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.CU().c(d.this.dBO.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dBO.getPageContext()).Au();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCW() {
        if (this.dDr == null) {
            return false;
        }
        return this.dDr.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dBO != null && lVar != null && lVar.beT() != null && lVar.haE != null) {
            if (this.dVo == null) {
                this.dVo = new com.baidu.tieba.tblauncher.a(this.dBO.getActivity(), this);
            }
            this.dVo.bDQ();
            this.dVo.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCX() {
        return (this.dDt.bFP() || aBg()) ? false : true;
    }
}
