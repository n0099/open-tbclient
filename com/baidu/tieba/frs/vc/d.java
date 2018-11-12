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
    private FrsFragment dDf;
    public com.baidu.tieba.write.c dEH;
    private com.baidu.tieba.ueg.c dEJ;
    public ImageView dHQ;
    private NoPressedRelativeLayout dWf;
    private i dWu;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bG(d.this.dDf.getPageContext().getPageActivity()) && !d.this.dEJ.bFo() && !d.this.aAD()) {
                if (d.this.dWu != null) {
                    d.this.dWu.aFN();
                }
                if (d.this.dEH == null) {
                    d.this.dEH = new com.baidu.tieba.write.c(d.this.dDf.getPageContext(), d.this.dWf, "frs");
                    d.this.dEH.wQ("2");
                }
                d.this.dEH.wP(d.this.aFq());
                d.this.dEH.a(d.this.dDf.azs());
                d.this.dEH.oq(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.or()) {
                d.this.aFo();
                return;
            }
            d.this.dHQ.setBackgroundResource(0);
            d.this.dHQ.setImageDrawable(null);
            aVar.a(d.this.dHQ);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dDf = frsFragment;
            this.dWf = noPressedRelativeLayout;
            this.dHQ = (ImageView) this.dWf.findViewById(e.g.normal_write_icon);
            this.dHQ.setOnClickListener(this.mOnClickListener);
            this.dEJ = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gv(boolean z) {
        l azp;
        if (this.dHQ != null) {
            aFp();
            this.dHQ.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (azp = this.dDf.azp()) != null && azp.hcb != null && azp.ber() != null && !StringUtils.isNull(azp.ber().getId()) && !StringUtils.isNull(azp.hcb.recom_title) && !StringUtils.isNull(azp.hcb.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.azx().m(azp.ber().getId(), azp.hcb.uniq_topicid.longValue())) {
                a(this.dHQ, azp);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCn() {
        if (this.dEH != null) {
            this.dEH.onDestroy();
        }
        if (this.dWu != null) {
            this.dWu.aFN();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCo() {
        if (this.dWu != null) {
            this.dWu.aFN();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aCp() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean azU() {
        if (this.dEH == null || !this.dEH.isShowing()) {
            return false;
        }
        this.dEH.aAG();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dEH != null) {
            this.dEH.onChangeSkinType();
        }
        if (!aFp()) {
            aFo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFo() {
        al.i(this.dHQ, e.f.icon_tabbar_chaticon_n);
        al.c(this.dHQ, e.f.icon_tabbar_add_n);
    }

    public boolean aFp() {
        l azp;
        ActivityConfig activityConfig;
        if (this.dDf == null || (azp = this.dDf.azp()) == null || (activityConfig = azp.hcD) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            oo(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            oo(activityConfig.addthread_icon);
            return true;
        }
    }

    private void oo(String str) {
        com.baidu.adp.lib.f.c.jA().a(str, 10, this.mCallback, this.dDf.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aFq() {
        l azp;
        if (this.dDf == null || (azp = this.dDf.azp()) == null || azp.hcD == null) {
            return "";
        }
        return azp.hcD.addthread_text;
    }

    public boolean aAD() {
        l azp;
        String fixedText;
        if (this.dDf != null && (azp = this.dDf.azp()) != null) {
            if (ba.bG(this.dDf.getPageContext().getPageActivity())) {
                AntiData xA = azp.xA();
                if (xA != null) {
                    if (a(xA.getBlock_stat(), xA.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (xA.getIfpost() == 0 && !StringUtils.isNull(xA.getForbid_info())) {
                        String forbid_info = xA.getForbid_info();
                        if (ao.fq(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dDf.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
                        b.Z(1.25f);
                        b.AJ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dDf.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dDf.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Z(1.25f);
            b.AJ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dDf.getPageContext().getPageActivity());
        aVar.ej(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dDf.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.Db().c(d.this.dDf.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dDf.getPageContext()).AB();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCq() {
        if (this.dEH == null) {
            return false;
        }
        return this.dEH.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dDf != null && lVar != null && lVar.ber() != null && lVar.hcb != null) {
            if (this.dWu == null) {
                this.dWu = new i(this.dDf.getActivity(), this);
            }
            this.dWu.aFN();
            this.dWu.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCr() {
        return (this.dEJ.bFo() || aAD()) ? false : true;
    }
}
