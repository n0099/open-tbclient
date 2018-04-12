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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private FrsFragment cYF;
    public com.baidu.tieba.write.c dld;
    private com.baidu.tieba.q.a dlm;
    private NoPressedRelativeLayout dpK;
    private com.baidu.tieba.tblauncher.a dpZ;
    public ImageView dqa;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (az.aK(d.this.cYF.getPageContext().getPageActivity()) && !d.this.dlm.bvD() && !d.this.aty()) {
                if (d.this.dpZ != null) {
                    d.this.dpZ.btE();
                }
                if (d.this.dld == null) {
                    d.this.dld = new com.baidu.tieba.write.c(d.this.cYF.getPageContext(), d.this.dpK, "frs");
                    d.this.dld.uD("2");
                }
                d.this.dld.uC(d.this.avb());
                d.this.dld.a(d.this.cYF.apH());
                d.this.dld.nk(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.kn()) {
                d.this.auZ();
                return;
            }
            d.this.dqa.setBackgroundResource(0);
            d.this.dqa.setImageDrawable(null);
            aVar.a(d.this.dqa);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.cYF = frsFragment;
            this.dpK = noPressedRelativeLayout;
            this.dqa = (ImageView) this.dpK.findViewById(d.g.normal_write_icon);
            this.dqa.setOnClickListener(this.mOnClickListener);
            this.dlm = new com.baidu.tieba.q.a(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fs(boolean z) {
        l apE;
        if (this.dqa != null) {
            ava();
            this.dqa.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (apE = this.cYF.apE()) != null && apE.guo != null && apE.aVq() != null && !StringUtils.isNull(apE.aVq().getId()) && !StringUtils.isNull(apE.guo.recom_title) && !StringUtils.isNull(apE.guo.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.apL().k(apE.aVq().getId(), apE.guo.uniq_topicid.longValue())) {
                a(this.dqa, apE);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void asa() {
        if (this.dld != null) {
            this.dld.onDestroy();
        }
        if (this.dpZ != null) {
            this.dpZ.btE();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void asb() {
        if (this.dpZ != null) {
            this.dpZ.btE();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void asc() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aqj() {
        if (this.dld == null || !this.dld.isShowing()) {
            return false;
        }
        this.dld.bBb();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dld != null) {
            this.dld.onChangeSkinType();
        }
        if (!ava()) {
            auZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auZ() {
        ak.i(this.dqa, d.f.icon_tabbar_chaticon_n);
        ak.c(this.dqa, d.f.icon_tabbar_add_n);
    }

    public boolean ava() {
        l apE;
        ActivityConfig activityConfig;
        if (this.cYF == null || (apE = this.cYF.apE()) == null || (activityConfig = apE.guQ) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            mt(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            mt(activityConfig.addthread_icon);
            return true;
        }
    }

    private void mt(String str) {
        com.baidu.adp.lib.f.c.fp().a(str, 10, this.mCallback, this.cYF.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String avb() {
        l apE;
        if (this.cYF == null || (apE = this.cYF.apE()) == null || apE.guQ == null) {
            return "";
        }
        return apE.guQ.addthread_text;
    }

    public boolean aty() {
        l apE;
        String fixedText;
        if (this.cYF != null && (apE = this.cYF.apE()) != null) {
            if (az.aK(this.cYF.getPageContext().getPageActivity())) {
                AntiData qT = apE.qT();
                if (qT != null) {
                    if (a(qT.getBlock_stat(), qT.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qT.getIfpost() == 0 && !StringUtils.isNull(qT.getForbid_info())) {
                        String forbid_info = qT.getForbid_info();
                        if (an.ek(forbid_info) > 14) {
                            forbid_info = an.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cYF.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.O(1.25f);
                        b.tL();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cYF.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cYF.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.O(1.25f);
            b.tL();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cYF.getPageContext().getPageActivity());
        aVar.dc(an.getFixedText(string, 50, true));
        aVar.b(an.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cYF.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(an.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ax.wg().c(d.this.cYF.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cYF.getPageContext()).tD();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean asd() {
        if (this.dld == null) {
            return false;
        }
        return this.dld.isShowing();
    }

    public void a(View view2, l lVar) {
        if (this.cYF != null && lVar != null && lVar.aVq() != null && lVar.guo != null) {
            if (this.dpZ == null) {
                this.dpZ = new com.baidu.tieba.tblauncher.a(this.cYF.getActivity(), this);
            }
            this.dpZ.btE();
            this.dpZ.b(view2, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean ase() {
        return (this.dlm.bvD() || aty()) ? false : true;
    }
}
