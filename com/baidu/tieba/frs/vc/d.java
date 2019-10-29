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
    private NoPressedRelativeLayout fSK;
    private i fSZ;
    private com.baidu.tieba.ueg.d fbI;
    public OvalActionButton fvp;
    private FrsFragment fxh;
    public com.baidu.tieba.write.e fyS;
    private com.baidu.tieba.frs.profession.permission.c fyU;
    private c.a fyV = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void o(boolean z, int i) {
            if (z && i == 502) {
                d.this.qG(1);
            } else if (z) {
                d.this.qG(0);
            } else if (i != 502) {
                d.this.qG(-1);
            } else {
                d.this.blx();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jX(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.fxh.getPageContext().getPageActivity()) && !d.this.fbI.csd() && !d.this.blz()) {
                if (d.this.fSZ != null) {
                    d.this.fSZ.brb();
                }
                if (d.this.fxh.bjN().rZ(502) != null) {
                    d.this.fyU.at(d.this.fxh.getForumId(), d.this.fxh.bjN().bqU().tabId);
                } else {
                    d.this.qG(-1);
                }
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cit = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bqr();
                return;
            }
            d.this.fvp.setImageDrawable(null);
            aVar.drawImageTo(d.this.fvp);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fxh != null && this.fxh.bkp() != null && (forum = this.fxh.bkp().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fxh.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fxh = frsFragment;
            this.fSK = noPressedRelativeLayout;
            this.fbI = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fyU = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fyU.a(this.fyV);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(int i) {
        if (this.fyS == null) {
            this.fyS = new com.baidu.tieba.write.e(this.fxh.getPageContext(), this.fSK, "frs", 1);
            this.fyS.Fx("2");
        }
        this.fyS.b(this.fxh.bkm());
        this.fyS.Fw(bqt());
        ForumWriteData bks = this.fxh.bks();
        bks.setDefaultZone(i);
        this.fyS.a(bks);
        this.fyS.Bw(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fyS.a(false, (View) null, (View) this.fvp);
        this.fxh.bkm().setAlpha(0);
    }

    public void jL(boolean z) {
        FrsViewData bkp;
        if (this.fvp != null) {
            bqs();
            this.fvp.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bkp = this.fxh.bkp()) != null && bkp.postTopic != null && bkp.getForum() != null && !StringUtils.isNull(bkp.getForum().getId()) && !StringUtils.isNull(bkp.postTopic.recom_title) && !StringUtils.isNull(bkp.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bky().y(bkp.getForum().getId(), bkp.postTopic.uniq_topicid.longValue())) {
                a(this.fvp, bkp);
            }
        }
    }

    public void bqo() {
        if (this.fyS != null) {
            this.fyS.onDestroy();
        }
        if (this.fSZ != null) {
            this.fSZ.brb();
        }
    }

    public void bqp() {
        if (this.fSZ != null) {
            this.fSZ.brb();
        }
    }

    public void bqq() {
    }

    public boolean bkR() {
        if (this.fyS == null || !this.fyS.isShowing()) {
            return false;
        }
        this.fyS.rM(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fyS != null) {
            this.fyS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqr() {
        this.fvp.setImageResource(0);
    }

    public boolean bqs() {
        FrsViewData bkp;
        ActivityConfig activityConfig;
        if (this.fxh == null || (bkp = this.fxh.bkp()) == null || (activityConfig = bkp.activityConfig) == null || activityConfig.type.intValue() != 2) {
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
        com.baidu.adp.lib.f.c.fT().a(str, 10, this.cit, this.fxh.getUniqueId());
    }

    private String bqt() {
        FrsViewData bkp;
        if (this.fxh == null || (bkp = this.fxh.bkp()) == null || bkp.activityConfig == null) {
            return "";
        }
        return bkp.activityConfig.addthread_text;
    }

    public boolean blz() {
        FrsViewData bkp;
        String fixedText;
        if (this.fxh != null && (bkp = this.fxh.bkp()) != null) {
            if (bc.checkUpIsLogin(this.fxh.getPageContext().getPageActivity())) {
                AntiData anti = bkp.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.fxh.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake_n_svg, true);
                        b.setExtraTextLineSpacing(1.25f);
                        b.akT();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fxh.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.fxh.getPageContext().getPageActivity(), string, R.drawable.icon_pure_toast_mistake_n_svg, true);
            b.setExtraTextLineSpacing(1.25f);
            b.akT();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxh.getPageContext().getPageActivity());
        aVar.nn(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fxh.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.amQ().b(d.this.fxh.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fxh.getPageContext()).akO();
        return true;
    }

    public boolean bqu() {
        if (this.fyS == null) {
            return false;
        }
        return this.fyS.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fxh != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fSZ == null) {
                this.fSZ = new i(this.fxh.getActivity(), this);
            }
            this.fSZ.brb();
            this.fSZ.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bnl() {
        return (this.fbI.csd() || blz()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.fvp = ovalActionButton;
            this.fvp.setOnClickListener(this.mOnClickListener);
            if (!bqs()) {
                bqr();
            }
        }
    }
}
