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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.tblauncher.a dDD;
    private NoPressedRelativeLayout dDo;
    private FrsFragment dla;
    public ImageView dpA;
    public com.baidu.tieba.write.c dyE;
    private com.baidu.tieba.s.b dyN;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bb.aU(d.this.dla.getPageContext().getPageActivity()) && !d.this.dyN.bBi() && !d.this.aym()) {
                if (d.this.dDD != null) {
                    d.this.dDD.bzq();
                }
                if (d.this.dyE == null) {
                    d.this.dyE = new com.baidu.tieba.write.c(d.this.dla.getPageContext(), d.this.dDo, "frs");
                    d.this.dyE.vw("2");
                }
                d.this.dyE.vv(d.this.azP());
                d.this.dyE.a(d.this.dla.auc());
                d.this.dyE.nB(false);
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
                d.this.azN();
                return;
            }
            d.this.dpA.setBackgroundResource(0);
            d.this.dpA.setImageDrawable(null);
            aVar.a(d.this.dpA);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dla = frsFragment;
            this.dDo = noPressedRelativeLayout;
            this.dpA = (ImageView) this.dDo.findViewById(d.g.normal_write_icon);
            this.dpA.setOnClickListener(this.mOnClickListener);
            this.dyN = new com.baidu.tieba.s.b(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fA(boolean z) {
        l atZ;
        if (this.dpA != null) {
            azO();
            this.dpA.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (atZ = this.dla.atZ()) != null && atZ.gKH != null && atZ.baT() != null && !StringUtils.isNull(atZ.baT().getId()) && !StringUtils.isNull(atZ.gKH.recom_title) && !StringUtils.isNull(atZ.gKH.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.auh().k(atZ.baT().getId(), atZ.gKH.uniq_topicid.longValue())) {
                a(this.dpA, atZ);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awI() {
        if (this.dyE != null) {
            this.dyE.onDestroy();
        }
        if (this.dDD != null) {
            this.dDD.bzq();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awJ() {
        if (this.dDD != null) {
            this.dDD.bzq();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awK() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean auF() {
        if (this.dyE == null || !this.dyE.isShowing()) {
            return false;
        }
        this.dyE.bGG();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dyE != null) {
            this.dyE.onChangeSkinType();
        }
        if (!azO()) {
            azN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azN() {
        am.i(this.dpA, d.f.icon_tabbar_chaticon_n);
        am.c(this.dpA, d.f.icon_tabbar_add_n);
    }

    public boolean azO() {
        l atZ;
        ActivityConfig activityConfig;
        if (this.dla == null || (atZ = this.dla.atZ()) == null || (activityConfig = atZ.gLj) == null || activityConfig.type.intValue() != 2) {
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
        com.baidu.adp.lib.f.c.ig().a(str, 10, this.mCallback, this.dla.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String azP() {
        l atZ;
        if (this.dla == null || (atZ = this.dla.atZ()) == null || atZ.gLj == null) {
            return "";
        }
        return atZ.gLj.addthread_text;
    }

    public boolean aym() {
        l atZ;
        String fixedText;
        if (this.dla != null && (atZ = this.dla.atZ()) != null) {
            if (bb.aU(this.dla.getPageContext().getPageActivity())) {
                AntiData uu = atZ.uu();
                if (uu != null) {
                    if (a(uu.getBlock_stat(), uu.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (uu.getIfpost() == 0 && !StringUtils.isNull(uu.getForbid_info())) {
                        String forbid_info = uu.getForbid_info();
                        if (ap.eM(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dla.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.Y(1.25f);
                        b.xv();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dla.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dla.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.Y(1.25f);
            b.xv();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dla.getPageContext().getPageActivity());
        aVar.dE(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dla.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    az.zV().c(d.this.dla.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dla.getPageContext()).xn();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awL() {
        if (this.dyE == null) {
            return false;
        }
        return this.dyE.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dla != null && lVar != null && lVar.baT() != null && lVar.gKH != null) {
            if (this.dDD == null) {
                this.dDD = new com.baidu.tieba.tblauncher.a(this.dla.getActivity(), this);
            }
            this.dDD.bzq();
            this.dDD.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awM() {
        return (this.dyN.bBi() || aym()) ? false : true;
    }
}
