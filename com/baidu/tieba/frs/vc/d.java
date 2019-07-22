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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
    private com.baidu.tieba.ueg.d eXh;
    private NoPressedRelativeLayout fQM;
    private i fRb;
    public OvalActionButton ftQ;
    private FrsFragment fvH;
    public com.baidu.tieba.write.e fxr;
    private com.baidu.tieba.frs.profession.permission.c fxt;
    private c.a fxu = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kf(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.rI(1);
            } else if (z) {
                d.this.rI(0);
            } else if (i != 502) {
                d.this.rI(-1);
            } else {
                d.this.bny();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kg(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bd.cF(d.this.fvH.getPageContext().getPageActivity()) && !d.this.eXh.cte() && !d.this.bnA()) {
                if (d.this.fRb != null) {
                    d.this.fRb.bsX();
                }
                if (d.this.fvH.blP().sZ(502) != null) {
                    d.this.fxt.aw(d.this.fvH.getForumId(), d.this.fvH.blP().bsQ().tabId);
                } else {
                    d.this.rI(-1);
                }
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.nL()) {
                d.this.bso();
                return;
            }
            d.this.ftQ.setImageDrawable(null);
            aVar.a(d.this.ftQ);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bny() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fvH != null && this.fvH.bmo() != null && (forum = this.fvH.bmo().getForum()) != null) {
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
                    if (skinType == 1) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fvH.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fvH = frsFragment;
            this.fQM = noPressedRelativeLayout;
            this.eXh = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fxt = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fxt.a(this.fxu);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(int i) {
        if (this.fxr == null) {
            this.fxr = new com.baidu.tieba.write.e(this.fvH.getPageContext(), this.fQM, "frs", 1);
            this.fxr.GC("2");
        }
        this.fxr.b(this.fvH.bml());
        this.fxr.GB(bsq());
        ForumWriteData bmr = this.fvH.bmr();
        bmr.setDefaultZone(i);
        this.fxr.a(bmr);
        this.fxr.CM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fxr.a(false, (View) null, (View) this.ftQ);
        this.fvH.bml().setAlpha(0);
    }

    public void jU(boolean z) {
        FrsViewData bmo;
        if (this.ftQ != null) {
            bsp();
            this.ftQ.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bmo = this.fvH.bmo()) != null && bmo.postTopic != null && bmo.getForum() != null && !StringUtils.isNull(bmo.getForum().getId()) && !StringUtils.isNull(bmo.postTopic.recom_title) && !StringUtils.isNull(bmo.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bmx().s(bmo.getForum().getId(), bmo.postTopic.uniq_topicid.longValue())) {
                a(this.ftQ, bmo);
            }
        }
    }

    public void bsl() {
        if (this.fxr != null) {
            this.fxr.onDestroy();
        }
        if (this.fRb != null) {
            this.fRb.bsX();
        }
    }

    public void bsm() {
        if (this.fRb != null) {
            this.fRb.bsX();
        }
    }

    public void bsn() {
    }

    public boolean bmR() {
        if (this.fxr == null || !this.fxr.isShowing()) {
            return false;
        }
        this.fxr.sb(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fxr != null) {
            this.fxr.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bso() {
        this.ftQ.setImageResource(0);
    }

    public boolean bsp() {
        FrsViewData bmo;
        ActivityConfig activityConfig;
        if (this.fvH == null || (bmo = this.fvH.bmo()) == null || (activityConfig = bmo.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            xH(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            xH(activityConfig.addthread_icon);
            return true;
        }
    }

    private void xH(String str) {
        com.baidu.adp.lib.f.c.iE().a(str, 10, this.mCallback, this.fvH.getUniqueId());
    }

    private String bsq() {
        FrsViewData bmo;
        if (this.fvH == null || (bmo = this.fvH.bmo()) == null || bmo.activityConfig == null) {
            return "";
        }
        return bmo.activityConfig.addthread_text;
    }

    public boolean bnA() {
        FrsViewData bmo;
        String fixedText;
        if (this.fvH != null && (bmo = this.fvH.bmo()) != null) {
            if (bd.cF(this.fvH.getPageContext().getPageActivity())) {
                AntiData anti = bmo.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.oc(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.fvH.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_toast_game_error);
                        c.am(1.25f);
                        c.agQ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fvH.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.fvH.getPageContext().getPageActivity(), string, R.drawable.icon_toast_game_error);
            c.am(1.25f);
            c.agQ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvH.getPageContext().getPageActivity());
        aVar.mO(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fvH.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    bb.ajC().c(d.this.fvH.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fvH.getPageContext()).agI();
        return true;
    }

    public boolean bsr() {
        if (this.fxr == null) {
            return false;
        }
        return this.fxr.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fvH != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fRb == null) {
                this.fRb = new i(this.fvH.getActivity(), this);
            }
            this.fRb.bsX();
            this.fRb.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bpi() {
        return (this.eXh.cte() || bnA()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.ftQ = ovalActionButton;
            this.ftQ.setOnClickListener(this.mOnClickListener);
            if (!bsp()) {
                bso();
            }
        }
    }
}
