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
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private NoPressedRelativeLayout dNd;
    private com.baidu.tieba.tblauncher.a dNs;
    private FrsFragment dtN;
    public com.baidu.tieba.write.c dvq;
    private com.baidu.tieba.ueg.c dvs;
    public ImageView dyA;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bA(d.this.dtN.getPageContext().getPageActivity()) && !d.this.dvs.bCB() && !d.this.axK()) {
                if (d.this.dNs != null) {
                    d.this.dNs.bAC();
                }
                if (d.this.dvq == null) {
                    d.this.dvq = new com.baidu.tieba.write.c(d.this.dtN.getPageContext(), d.this.dNd, "frs");
                    d.this.dvq.wk("2");
                }
                d.this.dvq.wj(d.this.aCC());
                d.this.dvq.a(d.this.dtN.awy());
                d.this.dvq.nM(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.oi()) {
                d.this.aCA();
                return;
            }
            d.this.dyA.setBackgroundResource(0);
            d.this.dyA.setImageDrawable(null);
            aVar.a(d.this.dyA);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dtN = frsFragment;
            this.dNd = noPressedRelativeLayout;
            this.dyA = (ImageView) this.dNd.findViewById(e.g.normal_write_icon);
            this.dyA.setOnClickListener(this.mOnClickListener);
            this.dvs = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fT(boolean z) {
        l awv;
        if (this.dyA != null) {
            aCB();
            this.dyA.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (awv = this.dtN.awv()) != null && awv.gTi != null && awv.bbH() != null && !StringUtils.isNull(awv.bbH().getId()) && !StringUtils.isNull(awv.gTi.recom_title) && !StringUtils.isNull(awv.gTi.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.awD().m(awv.bbH().getId(), awv.gTi.uniq_topicid.longValue())) {
                a(this.dyA, awv);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void azz() {
        if (this.dvq != null) {
            this.dvq.onDestroy();
        }
        if (this.dNs != null) {
            this.dNs.bAC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void azA() {
        if (this.dNs != null) {
            this.dNs.bAC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void azB() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axb() {
        if (this.dvq == null || !this.dvq.isShowing()) {
            return false;
        }
        this.dvq.axN();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dvq != null) {
            this.dvq.onChangeSkinType();
        }
        if (!aCB()) {
            aCA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCA() {
        al.i(this.dyA, e.f.icon_tabbar_chaticon_n);
        al.c(this.dyA, e.f.icon_tabbar_add_n);
    }

    public boolean aCB() {
        l awv;
        ActivityConfig activityConfig;
        if (this.dtN == null || (awv = this.dtN.awv()) == null || (activityConfig = awv.gTK) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            nJ(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            nJ(activityConfig.addthread_icon);
            return true;
        }
    }

    private void nJ(String str) {
        com.baidu.adp.lib.f.c.jn().a(str, 10, this.mCallback, this.dtN.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aCC() {
        l awv;
        if (this.dtN == null || (awv = this.dtN.awv()) == null || awv.gTK == null) {
            return "";
        }
        return awv.gTK.addthread_text;
    }

    public boolean axK() {
        l awv;
        String fixedText;
        if (this.dtN != null && (awv = this.dtN.awv()) != null) {
            if (ba.bA(this.dtN.getPageContext().getPageActivity())) {
                AntiData vj = awv.vj();
                if (vj != null) {
                    if (a(vj.getBlock_stat(), vj.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (vj.getIfpost() == 0 && !StringUtils.isNull(vj.getForbid_info())) {
                        String forbid_info = vj.getForbid_info();
                        if (ao.fc(forbid_info) > 14) {
                            forbid_info = ao.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dtN.getPageContext().getPageActivity(), forbid_info, e.f.icon_toast_game_error);
                        b.Y(1.25f);
                        b.yt();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dtN.getResources().getString(e.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dtN.getPageContext().getPageActivity(), string, e.f.icon_toast_game_error);
            b.Y(1.25f);
            b.yt();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dtN.getPageContext().getPageActivity());
        aVar.dT(ao.getFixedText(string, 50, true));
        aVar.b(ao.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dtN.getResources().getString(e.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.AN().c(d.this.dtN.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dtN.getPageContext()).yl();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean azC() {
        if (this.dvq == null) {
            return false;
        }
        return this.dvq.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dtN != null && lVar != null && lVar.bbH() != null && lVar.gTi != null) {
            if (this.dNs == null) {
                this.dNs = new com.baidu.tieba.tblauncher.a(this.dtN.getActivity(), this);
            }
            this.dNs.bAC();
            this.dNs.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean azD() {
        return (this.dvs.bCB() || axK()) ? false : true;
    }
}
