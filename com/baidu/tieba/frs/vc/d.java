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
    private FrsFragment dNb;
    public com.baidu.tieba.write.c dOD;
    private com.baidu.tieba.ueg.c dOF;
    public ImageView dRM;
    private NoPressedRelativeLayout egg;
    private i egv;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bJ(d.this.dNb.getPageContext().getPageActivity()) && !d.this.dOF.bIQ() && !d.this.aDz()) {
                if (d.this.egv != null) {
                    d.this.egv.aIL();
                }
                if (d.this.dOD == null) {
                    d.this.dOD = new com.baidu.tieba.write.c(d.this.dNb.getPageContext(), d.this.egg, "frs");
                    d.this.dOD.xM("2");
                }
                d.this.dOD.xL(d.this.aIo());
                d.this.dOD.a(d.this.dNb.aCo());
                d.this.dOD.ow(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.ou()) {
                d.this.aIm();
                return;
            }
            d.this.dRM.setBackgroundResource(0);
            d.this.dRM.setImageDrawable(null);
            aVar.a(d.this.dRM);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dNb = frsFragment;
            this.egg = noPressedRelativeLayout;
            this.dRM = (ImageView) this.egg.findViewById(e.g.normal_write_icon);
            this.dRM.setOnClickListener(this.mOnClickListener);
            this.dOF = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gC(boolean z) {
        l aCl;
        if (this.dRM != null) {
            aIn();
            this.dRM.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (aCl = this.dNb.aCl()) != null && aCl.hnk != null && aCl.bhx() != null && !StringUtils.isNull(aCl.bhx().getId()) && !StringUtils.isNull(aCl.hnk.recom_title) && !StringUtils.isNull(aCl.hnk.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.aCu().n(aCl.bhx().getId(), aCl.hnk.uniq_topicid.longValue())) {
                a(this.dRM, aCl);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aFl() {
        if (this.dOD != null) {
            this.dOD.onDestroy();
        }
        if (this.egv != null) {
            this.egv.aIL();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aFm() {
        if (this.egv != null) {
            this.egv.aIL();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aFn() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aCQ() {
        if (this.dOD == null || !this.dOD.isShowing()) {
            return false;
        }
        this.dOD.aDC();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dOD != null) {
            this.dOD.onChangeSkinType();
        }
        if (!aIn()) {
            aIm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIm() {
        al.i(this.dRM, e.f.icon_tabbar_chaticon_n);
        al.c(this.dRM, e.f.icon_tabbar_add_n);
    }

    public boolean aIn() {
        l aCl;
        ActivityConfig activityConfig;
        if (this.dNb == null || (aCl = this.dNb.aCl()) == null || (activityConfig = aCl.hnM) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            pg(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            pg(activityConfig.addthread_icon);
            return true;
        }
    }

    private void pg(String str) {
        com.baidu.adp.lib.f.c.jA().a(str, 10, this.mCallback, this.dNb.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aIo() {
        l aCl;
        if (this.dNb == null || (aCl = this.dNb.aCl()) == null || aCl.hnM == null) {
            return "";
        }
        return aCl.hnM.addthread_text;
    }

    public boolean aDz() {
        l aCl;
        String fixedText;
        if (this.dNb != null && (aCl = this.dNb.aCl()) != null) {
            if (ba.bJ(this.dNb.getPageContext().getPageActivity())) {
                AntiData yR = aCl.yR();
                if (yR != null) {
                    if (a(yR.getBlock_stat(), yR.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (yR.getIfpost() == 0 && !StringUtils.isNull(yR.getForbid_info())) {
                        String forbid_info = yR.getForbid_info();
                        if (ao.fV(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dNb.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
                        b.Z(1.25f);
                        b.Ca();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dNb.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dNb.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Z(1.25f);
            b.Ca();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dNb.getPageContext().getPageActivity());
        aVar.eK(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dNb.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.Es().c(d.this.dNb.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dNb.getPageContext()).BS();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aFo() {
        if (this.dOD == null) {
            return false;
        }
        return this.dOD.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dNb != null && lVar != null && lVar.bhx() != null && lVar.hnk != null) {
            if (this.egv == null) {
                this.egv = new i(this.dNb.getActivity(), this);
            }
            this.egv.aIL();
            this.egv.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aFp() {
        return (this.dOF.bIQ() || aDz()) ? false : true;
    }
}
