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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private NoPressedRelativeLayout dAc;
    private com.baidu.tieba.tblauncher.a dAr;
    public ImageView dAs;
    private FrsFragment diZ;
    private com.baidu.tieba.s.b dvE;
    public com.baidu.tieba.write.c dvv;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.aU(d.this.diZ.getPageContext().getPageActivity()) && !d.this.dvE.bAI() && !d.this.axI()) {
                if (d.this.dAr != null) {
                    d.this.dAr.byH();
                }
                if (d.this.dvv == null) {
                    d.this.dvv = new com.baidu.tieba.write.c(d.this.diZ.getPageContext(), d.this.dAc, "frs");
                    d.this.dvv.vA("2");
                }
                d.this.dvv.vz(d.this.azj());
                d.this.dvv.a(d.this.diZ.atL());
                d.this.dvv.nt(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.na()) {
                d.this.azh();
                return;
            }
            d.this.dAs.setBackgroundResource(0);
            d.this.dAs.setImageDrawable(null);
            aVar.a(d.this.dAs);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.diZ = frsFragment;
            this.dAc = noPressedRelativeLayout;
            this.dAs = (ImageView) this.dAc.findViewById(d.g.normal_write_icon);
            this.dAs.setOnClickListener(this.mOnClickListener);
            this.dvE = new com.baidu.tieba.s.b(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fy(boolean z) {
        l atI;
        if (this.dAs != null) {
            azi();
            this.dAs.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (atI = this.diZ.atI()) != null && atI.gGM != null && atI.bam() != null && !StringUtils.isNull(atI.bam().getId()) && !StringUtils.isNull(atI.gGM.recom_title) && !StringUtils.isNull(atI.gGM.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.atP().k(atI.bam().getId(), atI.gGM.uniq_topicid.longValue())) {
                a(this.dAs, atI);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awe() {
        if (this.dvv != null) {
            this.dvv.onDestroy();
        }
        if (this.dAr != null) {
            this.dAr.byH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awf() {
        if (this.dAr != null) {
            this.dAr.byH();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awg() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aun() {
        if (this.dvv == null || !this.dvv.isShowing()) {
            return false;
        }
        this.dvv.bGf();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dvv != null) {
            this.dvv.onChangeSkinType();
        }
        if (!azi()) {
            azh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azh() {
        al.i(this.dAs, d.f.icon_tabbar_chaticon_n);
        al.c(this.dAs, d.f.icon_tabbar_add_n);
    }

    public boolean azi() {
        l atI;
        ActivityConfig activityConfig;
        if (this.diZ == null || (atI = this.diZ.atI()) == null || (activityConfig = atI.gHo) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            nd(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            nd(activityConfig.addthread_icon);
            return true;
        }
    }

    private void nd(String str) {
        com.baidu.adp.lib.f.c.ig().a(str, 10, this.mCallback, this.diZ.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String azj() {
        l atI;
        if (this.diZ == null || (atI = this.diZ.atI()) == null || atI.gHo == null) {
            return "";
        }
        return atI.gHo.addthread_text;
    }

    public boolean axI() {
        l atI;
        String fixedText;
        if (this.diZ != null && (atI = this.diZ.atI()) != null) {
            if (ba.aU(this.diZ.getPageContext().getPageActivity())) {
                AntiData uo = atI.uo();
                if (uo != null) {
                    if (a(uo.getBlock_stat(), uo.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (uo.getIfpost() == 0 && !StringUtils.isNull(uo.getForbid_info())) {
                        String forbid_info = uo.getForbid_info();
                        if (ao.eJ(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.diZ.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.Y(1.25f);
                        b.xi();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.diZ.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.diZ.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.Y(1.25f);
            b.xi();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.diZ.getPageContext().getPageActivity());
        aVar.dB(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.diZ.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.zG().c(d.this.diZ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.diZ.getPageContext()).xa();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awh() {
        if (this.dvv == null) {
            return false;
        }
        return this.dvv.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.diZ != null && lVar != null && lVar.bam() != null && lVar.gGM != null) {
            if (this.dAr == null) {
                this.dAr = new com.baidu.tieba.tblauncher.a(this.diZ.getActivity(), this);
            }
            this.dAr.byH();
            this.dAr.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awi() {
        return (this.dvE.bAI() || axI()) ? false : true;
    }
}
