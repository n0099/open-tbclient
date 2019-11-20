package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private NoPressedRelativeLayout fRT;
    private i fSi;
    private com.baidu.tieba.ueg.d faR;
    public OvalActionButton fuy;
    private FrsFragment fwq;
    public com.baidu.tieba.write.e fyb;
    private com.baidu.tieba.frs.profession.permission.c fyd;
    private c.a fye = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void o(boolean z, int i) {
            if (z && i == 502) {
                d.this.qF(1);
            } else if (z) {
                d.this.qF(0);
            } else if (i != 502) {
                d.this.qF(-1);
            } else {
                d.this.blv();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jX(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.fwq.getPageContext().getPageActivity()) && !d.this.faR.csb() && !d.this.blx()) {
                if (d.this.fSi != null) {
                    d.this.fSi.bqZ();
                }
                if (d.this.fwq.bjL().rY(502) != null) {
                    d.this.fyd.at(d.this.fwq.getForumId(), d.this.fwq.bjL().bqS().tabId);
                } else {
                    d.this.qF(-1);
                }
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bqp();
                return;
            }
            d.this.fuy.setImageDrawable(null);
            aVar.drawImageTo(d.this.fuy);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void blv() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fwq != null && this.fwq.bkn() != null && (forum = this.fwq.bkn().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str5 = themeColorInfo.day.dark_color;
                    str = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str = null;
                    str5 = null;
                    str6 = null;
                }
                if (themeColorInfo.night != null) {
                    String str8 = themeColorInfo.night.light_color;
                    str7 = themeColorInfo.night.dark_color;
                    if (skinType == 1 || skinType == 4) {
                        str = themeColorInfo.night.pattern_image;
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    } else {
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    }
                } else {
                    str4 = str6;
                    str3 = str5;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fwq.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fwq = frsFragment;
            this.fRT = noPressedRelativeLayout;
            this.faR = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fyd = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fyd.a(this.fye);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        if (this.fyb == null) {
            this.fyb = new com.baidu.tieba.write.e(this.fwq.getPageContext(), this.fRT, "frs", 1);
            this.fyb.Fx("2");
        }
        this.fyb.b(this.fwq.bkk());
        this.fyb.Fw(bqr());
        ForumWriteData bkq = this.fwq.bkq();
        bkq.setDefaultZone(i);
        this.fyb.a(bkq);
        this.fyb.Bv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fyb.a(false, (View) null, (View) this.fuy);
        this.fwq.bkk().setAlpha(0);
    }

    public void jL(boolean z) {
        FrsViewData bkn;
        if (this.fuy != null) {
            bqq();
            this.fuy.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bkn = this.fwq.bkn()) != null && bkn.postTopic != null && bkn.getForum() != null && !StringUtils.isNull(bkn.getForum().getId()) && !StringUtils.isNull(bkn.postTopic.recom_title) && !StringUtils.isNull(bkn.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bkw().y(bkn.getForum().getId(), bkn.postTopic.uniq_topicid.longValue())) {
                a(this.fuy, bkn);
            }
        }
    }

    public void bqm() {
        if (this.fyb != null) {
            this.fyb.onDestroy();
        }
        if (this.fSi != null) {
            this.fSi.bqZ();
        }
    }

    public void bqn() {
        if (this.fSi != null) {
            this.fSi.bqZ();
        }
    }

    public void bqo() {
    }

    public boolean bkP() {
        if (this.fyb == null || !this.fyb.isShowing()) {
            return false;
        }
        this.fyb.rM(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fyb != null) {
            this.fyb.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        this.fuy.setImageResource(0);
    }

    public boolean bqq() {
        FrsViewData bkn;
        ActivityConfig activityConfig;
        if (this.fwq == null || (bkn = this.fwq.bkn()) == null || (activityConfig = bkn.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            wz(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            wz(activityConfig.addthread_icon);
            return true;
        }
    }

    private void wz(String str) {
        com.baidu.adp.lib.f.c.fT().a(str, 10, this.chB, this.fwq.getUniqueId());
    }

    private String bqr() {
        FrsViewData bkn;
        if (this.fwq == null || (bkn = this.fwq.bkn()) == null || bkn.activityConfig == null) {
            return "";
        }
        return bkn.activityConfig.addthread_text;
    }

    public boolean blx() {
        FrsViewData bkn;
        String fixedText;
        if (this.fwq != null && (bkn = this.fwq.bkn()) != null) {
            if (bc.checkUpIsLogin(this.fwq.getPageContext().getPageActivity())) {
                AntiData anti = bkn.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.fwq.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake_n_svg, true);
                        b.setExtraTextLineSpacing(1.25f);
                        b.akR();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fwq.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.fwq.getPageContext().getPageActivity(), string, R.drawable.icon_pure_toast_mistake_n_svg, true);
            b.setExtraTextLineSpacing(1.25f);
            b.akR();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fwq.getPageContext().getPageActivity());
        aVar.nn(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fwq.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(aq.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ba.amO().b(d.this.fwq.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fwq.getPageContext()).akM();
        return true;
    }

    public boolean bqs() {
        if (this.fyb == null) {
            return false;
        }
        return this.fyb.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fwq != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fSi == null) {
                this.fSi = new i(this.fwq.getActivity(), this);
            }
            this.fSi.bqZ();
            this.fSi.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bnj() {
        return (this.faR.csb() || blx()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.fuy = ovalActionButton;
            this.fuy.setOnClickListener(this.mOnClickListener);
            if (!bqq()) {
                bqp();
            }
        }
    }
}
