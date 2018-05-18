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
    private FrsFragment cZJ;
    public com.baidu.tieba.write.c dmh;
    private com.baidu.tieba.q.a dmq;
    private NoPressedRelativeLayout dqP;
    private com.baidu.tieba.tblauncher.a dre;
    public ImageView drf;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (az.aK(d.this.cZJ.getPageContext().getPageActivity()) && !d.this.dmq.bvB() && !d.this.atx()) {
                if (d.this.dre != null) {
                    d.this.dre.btC();
                }
                if (d.this.dmh == null) {
                    d.this.dmh = new com.baidu.tieba.write.c(d.this.cZJ.getPageContext(), d.this.dqP, "frs");
                    d.this.dmh.uG("2");
                }
                d.this.dmh.uF(d.this.ava());
                d.this.dmh.a(d.this.cZJ.apG());
                d.this.dmh.nl(false);
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || !aVar.km()) {
                d.this.auY();
                return;
            }
            d.this.drf.setBackgroundResource(0);
            d.this.drf.setImageDrawable(null);
            aVar.a(d.this.drf);
        }
    };

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.cZJ = frsFragment;
            this.dqP = noPressedRelativeLayout;
            this.drf = (ImageView) this.dqP.findViewById(d.g.normal_write_icon);
            this.drf.setOnClickListener(this.mOnClickListener);
            this.dmq = new com.baidu.tieba.q.a(frsFragment.getPageContext());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ft(boolean z) {
        l apD;
        if (this.drf != null) {
            auZ();
            this.drf.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (apD = this.cZJ.apD()) != null && apD.gvp != null && apD.aVq() != null && !StringUtils.isNull(apD.aVq().getId()) && !StringUtils.isNull(apD.gvp.recom_title) && !StringUtils.isNull(apD.gvp.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.apK().k(apD.aVq().getId(), apD.gvp.uniq_topicid.longValue())) {
                a(this.drf, apD);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void arZ() {
        if (this.dmh != null) {
            this.dmh.onDestroy();
        }
        if (this.dre != null) {
            this.dre.btC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void asa() {
        if (this.dre != null) {
            this.dre.btC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void asb() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean aqi() {
        if (this.dmh == null || !this.dmh.isShowing()) {
            return false;
        }
        this.dmh.bAZ();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dmh != null) {
            this.dmh.onChangeSkinType();
        }
        if (!auZ()) {
            auY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auY() {
        ak.i(this.drf, d.f.icon_tabbar_chaticon_n);
        ak.c(this.drf, d.f.icon_tabbar_add_n);
    }

    public boolean auZ() {
        l apD;
        ActivityConfig activityConfig;
        if (this.cZJ == null || (apD = this.cZJ.apD()) == null || (activityConfig = apD.gvR) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            mw(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            mw(activityConfig.addthread_icon);
            return true;
        }
    }

    private void mw(String str) {
        com.baidu.adp.lib.f.c.fp().a(str, 10, this.mCallback, this.cZJ.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ava() {
        l apD;
        if (this.cZJ == null || (apD = this.cZJ.apD()) == null || apD.gvR == null) {
            return "";
        }
        return apD.gvR.addthread_text;
    }

    public boolean atx() {
        l apD;
        String fixedText;
        if (this.cZJ != null && (apD = this.cZJ.apD()) != null) {
            if (az.aK(this.cZJ.getPageContext().getPageActivity())) {
                AntiData qS = apD.qS();
                if (qS != null) {
                    if (a(qS.getBlock_stat(), qS.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qS.getIfpost() == 0 && !StringUtils.isNull(qS.getForbid_info())) {
                        String forbid_info = qS.getForbid_info();
                        if (an.ek(forbid_info) > 14) {
                            forbid_info = an.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cZJ.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.O(1.25f);
                        b.tK();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cZJ.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cZJ.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.O(1.25f);
            b.tK();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cZJ.getPageContext().getPageActivity());
        aVar.dc(an.getFixedText(string, 50, true));
        aVar.b(an.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cZJ.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.3
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
                    ax.wf().c(d.this.cZJ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cZJ.getPageContext()).tC();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean asc() {
        if (this.dmh == null) {
            return false;
        }
        return this.dmh.isShowing();
    }

    public void a(View view2, l lVar) {
        if (this.cZJ != null && lVar != null && lVar.aVq() != null && lVar.gvp != null) {
            if (this.dre == null) {
                this.dre = new com.baidu.tieba.tblauncher.a(this.cZJ.getActivity(), this);
            }
            this.dre.btC();
            this.dre.b(view2, lVar);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean asd() {
        return (this.dmq.bvB() || atx()) ? false : true;
    }
}
