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
    private com.baidu.tieba.ueg.d eXr;
    private NoPressedRelativeLayout fRA;
    private i fRP;
    public OvalActionButton fup;
    private FrsFragment fwg;
    public com.baidu.tieba.write.e fxQ;
    private com.baidu.tieba.frs.profession.permission.c fxS;
    private c.a fxT = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kf(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.rK(1);
            } else if (z) {
                d.this.rK(0);
            } else if (i != 502) {
                d.this.rK(-1);
            } else {
                d.this.bnI();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kg(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bd.cF(d.this.fwg.getPageContext().getPageActivity()) && !d.this.eXr.ctA() && !d.this.bnK()) {
                if (d.this.fRP != null) {
                    d.this.fRP.btk();
                }
                if (d.this.fwg.blW().tb(502) != null) {
                    d.this.fxS.aw(d.this.fwg.getForumId(), d.this.fwg.blW().btd().tabId);
                } else {
                    d.this.rK(-1);
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
                d.this.bsB();
                return;
            }
            d.this.fup.setImageDrawable(null);
            aVar.a(d.this.fup);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bnI() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fwg != null && this.fwg.bmy() != null && (forum = this.fwg.bmy().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fwg.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fwg = frsFragment;
            this.fRA = noPressedRelativeLayout;
            this.eXr = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fxS = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fxS.a(this.fxT);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(int i) {
        if (this.fxQ == null) {
            this.fxQ = new com.baidu.tieba.write.e(this.fwg.getPageContext(), this.fRA, "frs", 1);
            this.fxQ.GD("2");
        }
        this.fxQ.b(this.fwg.bmv());
        this.fxQ.GC(bsD());
        ForumWriteData bmB = this.fwg.bmB();
        bmB.setDefaultZone(i);
        this.fxQ.a(bmB);
        this.fxQ.CO(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fxQ.a(false, (View) null, (View) this.fup);
        this.fwg.bmv().setAlpha(0);
    }

    public void jU(boolean z) {
        FrsViewData bmy;
        if (this.fup != null) {
            bsC();
            this.fup.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bmy = this.fwg.bmy()) != null && bmy.postTopic != null && bmy.getForum() != null && !StringUtils.isNull(bmy.getForum().getId()) && !StringUtils.isNull(bmy.postTopic.recom_title) && !StringUtils.isNull(bmy.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bmH().s(bmy.getForum().getId(), bmy.postTopic.uniq_topicid.longValue())) {
                a(this.fup, bmy);
            }
        }
    }

    public void bsy() {
        if (this.fxQ != null) {
            this.fxQ.onDestroy();
        }
        if (this.fRP != null) {
            this.fRP.btk();
        }
    }

    public void bsz() {
        if (this.fRP != null) {
            this.fRP.btk();
        }
    }

    public void bsA() {
    }

    public boolean bnb() {
        if (this.fxQ == null || !this.fxQ.isShowing()) {
            return false;
        }
        this.fxQ.sc(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fxQ != null) {
            this.fxQ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsB() {
        this.fup.setImageResource(0);
    }

    public boolean bsC() {
        FrsViewData bmy;
        ActivityConfig activityConfig;
        if (this.fwg == null || (bmy = this.fwg.bmy()) == null || (activityConfig = bmy.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            xI(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            xI(activityConfig.addthread_icon);
            return true;
        }
    }

    private void xI(String str) {
        com.baidu.adp.lib.f.c.iE().a(str, 10, this.mCallback, this.fwg.getUniqueId());
    }

    private String bsD() {
        FrsViewData bmy;
        if (this.fwg == null || (bmy = this.fwg.bmy()) == null || bmy.activityConfig == null) {
            return "";
        }
        return bmy.activityConfig.addthread_text;
    }

    public boolean bnK() {
        FrsViewData bmy;
        String fixedText;
        if (this.fwg != null && (bmy = this.fwg.bmy()) != null) {
            if (bd.cF(this.fwg.getPageContext().getPageActivity())) {
                AntiData anti = bmy.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.oc(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.fwg.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_toast_game_error);
                        c.am(1.25f);
                        c.agS();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fwg.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.fwg.getPageContext().getPageActivity(), string, R.drawable.icon_toast_game_error);
            c.am(1.25f);
            c.agS();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fwg.getPageContext().getPageActivity());
        aVar.mO(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fwg.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    bb.ajE().c(d.this.fwg.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fwg.getPageContext()).agK();
        return true;
    }

    public boolean bsE() {
        if (this.fxQ == null) {
            return false;
        }
        return this.fxQ.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fwg != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fRP == null) {
                this.fRP = new i(this.fwg.getActivity(), this);
            }
            this.fRP.btk();
            this.fRP.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bpv() {
        return (this.eXr.ctA() || bnK()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.fup = ovalActionButton;
            this.fup.setOnClickListener(this.mOnClickListener);
            if (!bsC()) {
                bsB();
            }
        }
    }
}
