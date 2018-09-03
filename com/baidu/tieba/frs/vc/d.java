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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    public com.baidu.tieba.write.c dBn;
    private com.baidu.tieba.ueg.c dBw;
    private NoPressedRelativeLayout dFW;
    private com.baidu.tieba.tblauncher.a dGl;
    private FrsFragment dnP;
    public ImageView dsk;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bb.aU(d.this.dnP.getPageContext().getPageActivity()) && !d.this.dBw.bzM() && !d.this.ayP()) {
                if (d.this.dGl != null) {
                    d.this.dGl.bxU();
                }
                if (d.this.dBn == null) {
                    d.this.dBn = new com.baidu.tieba.write.c(d.this.dnP.getPageContext(), d.this.dFW, "frs");
                    d.this.dBn.vB("2");
                }
                d.this.dBn.vA(d.this.aAt());
                d.this.dBn.a(d.this.dnP.auF());
                d.this.dBn.np(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.nc()) {
                d.this.aAr();
                return;
            }
            d.this.dsk.setBackgroundResource(0);
            d.this.dsk.setImageDrawable(null);
            aVar.a(d.this.dsk);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dnP = frsFragment;
            this.dFW = noPressedRelativeLayout;
            this.dsk = (ImageView) this.dFW.findViewById(f.g.normal_write_icon);
            this.dsk.setOnClickListener(this.mOnClickListener);
            this.dBw = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fC(boolean z) {
        l auC;
        if (this.dsk != null) {
            aAs();
            this.dsk.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (auC = this.dnP.auC()) != null && auC.gLG != null && auC.aZg() != null && !StringUtils.isNull(auC.aZg().getId()) && !StringUtils.isNull(auC.gLG.recom_title) && !StringUtils.isNull(auC.gLG.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.auK().k(auC.aZg().getId(), auC.gLG.uniq_topicid.longValue())) {
                a(this.dsk, auC);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axm() {
        if (this.dBn != null) {
            this.dBn.onDestroy();
        }
        if (this.dGl != null) {
            this.dGl.bxU();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axn() {
        if (this.dGl != null) {
            this.dGl.bxU();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axo() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avi() {
        if (this.dBn == null || !this.dBn.isShowing()) {
            return false;
        }
        this.dBn.bFv();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dBn != null) {
            this.dBn.onChangeSkinType();
        }
        if (!aAs()) {
            aAr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAr() {
        am.i(this.dsk, f.C0146f.icon_tabbar_chaticon_n);
        am.c(this.dsk, f.C0146f.icon_tabbar_add_n);
    }

    public boolean aAs() {
        l auC;
        ActivityConfig activityConfig;
        if (this.dnP == null || (auC = this.dnP.auC()) == null || (activityConfig = auC.gMi) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            ne(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            ne(activityConfig.addthread_icon);
            return true;
        }
    }

    private void ne(String str) {
        com.baidu.adp.lib.f.c.ih().a(str, 10, this.mCallback, this.dnP.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aAt() {
        l auC;
        if (this.dnP == null || (auC = this.dnP.auC()) == null || auC.gMi == null) {
            return "";
        }
        return auC.gMi.addthread_text;
    }

    public boolean ayP() {
        l auC;
        String fixedText;
        if (this.dnP != null && (auC = this.dnP.auC()) != null) {
            if (bb.aU(this.dnP.getPageContext().getPageActivity())) {
                AntiData ug = auC.ug();
                if (ug != null) {
                    if (a(ug.getBlock_stat(), ug.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (ug.getIfpost() == 0 && !StringUtils.isNull(ug.getForbid_info())) {
                        String forbid_info = ug.getForbid_info();
                        if (ap.eK(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dnP.getPageContext().getPageActivity(), forbid_info, f.C0146f.icon_toast_game_error);
                        b.Y(1.25f);
                        b.xm();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dnP.getResources().getString(f.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dnP.getPageContext().getPageActivity(), string, f.C0146f.icon_toast_game_error);
            b.Y(1.25f);
            b.xm();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dnP.getPageContext().getPageActivity());
        aVar.dB(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dnP.getResources().getString(f.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ap.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    az.zI().c(d.this.dnP.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dnP.getPageContext()).xe();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axp() {
        if (this.dBn == null) {
            return false;
        }
        return this.dBn.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dnP != null && lVar != null && lVar.aZg() != null && lVar.gLG != null) {
            if (this.dGl == null) {
                this.dGl = new com.baidu.tieba.tblauncher.a(this.dnP.getActivity(), this);
            }
            this.dGl.bxU();
            this.dGl.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axq() {
        return (this.dBw.bzM() || ayP()) ? false : true;
    }
}
