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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    public com.baidu.tieba.write.c dBq;
    private com.baidu.tieba.ueg.c dBz;
    private NoPressedRelativeLayout dGa;
    private com.baidu.tieba.tblauncher.a dGp;
    private FrsFragment dnR;
    public ImageView dsn;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.aV(d.this.dnR.getPageContext().getPageActivity()) && !d.this.dBz.bzK() && !d.this.ayR()) {
                if (d.this.dGp != null) {
                    d.this.dGp.bxT();
                }
                if (d.this.dBq == null) {
                    d.this.dBq = new com.baidu.tieba.write.c(d.this.dnR.getPageContext(), d.this.dGa, "frs");
                    d.this.dBq.vx("2");
                }
                d.this.dBq.vw(d.this.aAw());
                d.this.dBq.a(d.this.dnR.auG());
                d.this.dBq.np(false);
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
                d.this.aAu();
                return;
            }
            d.this.dsn.setBackgroundResource(0);
            d.this.dsn.setImageDrawable(null);
            aVar.a(d.this.dsn);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.dnR = frsFragment;
            this.dGa = noPressedRelativeLayout;
            this.dsn = (ImageView) this.dGa.findViewById(d.g.normal_write_icon);
            this.dsn.setOnClickListener(this.mOnClickListener);
            this.dBz = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fC(boolean z) {
        l auD;
        if (this.dsn != null) {
            aAv();
            this.dsn.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (auD = this.dnR.auD()) != null && auD.gLE != null && auD.aZl() != null && !StringUtils.isNull(auD.aZl().getId()) && !StringUtils.isNull(auD.gLE.recom_title) && !StringUtils.isNull(auD.gLE.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.auL().k(auD.aZl().getId(), auD.gLE.uniq_topicid.longValue())) {
                a(this.dsn, auD);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axn() {
        if (this.dBq != null) {
            this.dBq.onDestroy();
        }
        if (this.dGp != null) {
            this.dGp.bxT();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axo() {
        if (this.dGp != null) {
            this.dGp.bxT();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axp() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avj() {
        if (this.dBq == null || !this.dBq.isShowing()) {
            return false;
        }
        this.dBq.bFr();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dBq != null) {
            this.dBq.onChangeSkinType();
        }
        if (!aAv()) {
            aAu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAu() {
        am.i(this.dsn, d.f.icon_tabbar_chaticon_n);
        am.c(this.dsn, d.f.icon_tabbar_add_n);
    }

    public boolean aAv() {
        l auD;
        ActivityConfig activityConfig;
        if (this.dnR == null || (auD = this.dnR.auD()) == null || (activityConfig = auD.gMg) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            nc(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            nc(activityConfig.addthread_icon);
            return true;
        }
    }

    private void nc(String str) {
        com.baidu.adp.lib.f.c.ih().a(str, 10, this.mCallback, this.dnR.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aAw() {
        l auD;
        if (this.dnR == null || (auD = this.dnR.auD()) == null || auD.gMg == null) {
            return "";
        }
        return auD.gMg.addthread_text;
    }

    public boolean ayR() {
        l auD;
        String fixedText;
        if (this.dnR != null && (auD = this.dnR.auD()) != null) {
            if (ba.aV(this.dnR.getPageContext().getPageActivity())) {
                AntiData uh = auD.uh();
                if (uh != null) {
                    if (a(uh.getBlock_stat(), uh.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (uh.getIfpost() == 0 && !StringUtils.isNull(uh.getForbid_info())) {
                        String forbid_info = uh.getForbid_info();
                        if (ap.eK(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dnR.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.Y(1.25f);
                        b.xn();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dnR.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dnR.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.Y(1.25f);
            b.xn();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dnR.getPageContext().getPageActivity());
        aVar.dB(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dnR.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ay.zK().c(d.this.dnR.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dnR.getPageContext()).xf();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axq() {
        if (this.dBq == null) {
            return false;
        }
        return this.dBq.isShowing();
    }

    public void a(View view, l lVar) {
        if (this.dnR != null && lVar != null && lVar.aZl() != null && lVar.gLE != null) {
            if (this.dGp == null) {
                this.dGp = new com.baidu.tieba.tblauncher.a(this.dnR.getActivity(), this);
            }
            this.dGp.bxT();
            this.dGp.b(view, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axr() {
        return (this.dBz.bzK() || ayR()) ? false : true;
    }
}
