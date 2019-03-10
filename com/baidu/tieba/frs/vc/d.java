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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.c eCK;
    public OvalActionButton eYU;
    private FrsFragment faH;
    public com.baidu.tieba.write.e fcu;
    private com.baidu.tieba.frs.profession.permission.c fcw;
    private NoPressedRelativeLayout fvj;
    private i fvy;
    private c.a fcx = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.qn(1);
            } else if (z) {
                d.this.qn(0);
            } else if (i != 502) {
                d.this.qn(-1);
            } else if (com.baidu.tbadk.plugins.c.b(d.this.faH.getTbPageContext(), "com.baidu.tieba.pluginMember")) {
                d.this.bef();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cZ(d.this.faH.getPageContext().getPageActivity()) && !d.this.eCK.cin() && !d.this.beh()) {
                if (d.this.fvy != null) {
                    d.this.fvy.bjC();
                }
                if (d.this.faH.bct().rD(502) != null) {
                    d.this.fcw.az(d.this.faH.getForumId(), d.this.faH.bct().bjv().tabId);
                } else {
                    d.this.qn(-1);
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
            if (aVar == null || !aVar.oz()) {
                d.this.biT();
                return;
            }
            d.this.eYU.setImageDrawable(null);
            aVar.a(d.this.eYU);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bef() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.faH != null && this.faH.bcS() != null && (forum = this.faH.bcS().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.faH.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.faH = frsFragment;
            this.fvj = noPressedRelativeLayout;
            this.eCK = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            this.fcw = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fcw.a(this.fcx);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(int i) {
        if (this.fcu == null) {
            this.fcu = new com.baidu.tieba.write.e(this.faH.getPageContext(), this.fvj, "frs", 1);
            this.fcu.En("2");
        }
        this.fcu.b(this.faH.bcP());
        this.fcu.Em(biV());
        ForumWriteData bcV = this.faH.bcV();
        bcV.setDefaultZone(i);
        this.fcu.a(bcV);
        this.fcu.Ba(i == 1 ? d.f.btn_frs_professional_edit_n : 0);
        this.fcu.a(false, null, this.eYU);
        this.faH.bcP().setAlpha(0);
    }

    public void ja(boolean z) {
        FrsViewData bcS;
        if (this.eYU != null) {
            biU();
            this.eYU.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bcS = this.faH.bcS()) != null && bcS.postTopic != null && bcS.getForum() != null && !StringUtils.isNull(bcS.getForum().getId()) && !StringUtils.isNull(bcS.postTopic.recom_title) && !StringUtils.isNull(bcS.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bdb().p(bcS.getForum().getId(), bcS.postTopic.uniq_topicid.longValue())) {
                a(this.eYU, bcS);
            }
        }
    }

    public void biQ() {
        if (this.fcu != null) {
            this.fcu.onDestroy();
        }
        if (this.fvy != null) {
            this.fvy.bjC();
        }
    }

    public void biR() {
        if (this.fvy != null) {
            this.fvy.bjC();
        }
    }

    public void biS() {
    }

    public boolean bdx() {
        if (this.fcu == null || !this.fcu.isShowing()) {
            return false;
        }
        this.fcu.qW(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fcu != null) {
            this.fcu.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biT() {
        this.eYU.setImageResource(0);
    }

    public boolean biU() {
        FrsViewData bcS;
        ActivityConfig activityConfig;
        if (this.faH == null || (bcS = this.faH.bcS()) == null || (activityConfig = bcS.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            vO(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            vO(activityConfig.addthread_icon);
            return true;
        }
    }

    private void vO(String str) {
        com.baidu.adp.lib.f.c.jB().a(str, 10, this.mCallback, this.faH.getUniqueId());
    }

    private String biV() {
        FrsViewData bcS;
        if (this.faH == null || (bcS = this.faH.bcS()) == null || bcS.activityConfig == null) {
            return "";
        }
        return bcS.activityConfig.addthread_text;
    }

    public boolean beh() {
        FrsViewData bcS;
        String fixedText;
        if (this.faH != null && (bcS = this.faH.bcS()) != null) {
            if (bc.cZ(this.faH.getPageContext().getPageActivity())) {
                AntiData anti = bcS.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ap.mH(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.faH.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        c.ak(1.25f);
                        c.abh();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.faH.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.faH.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            c.ak(1.25f);
            c.abh();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.faH.getPageContext().getPageActivity());
        aVar.ly(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.faH.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ap.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ba.adD().c(d.this.faH.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.faH.getPageContext()).aaZ();
        return true;
    }

    public boolean biW() {
        if (this.fcu == null) {
            return false;
        }
        return this.fcu.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.faH != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fvy == null) {
                this.fvy = new i(this.faH.getActivity(), this);
            }
            this.fvy.bjC();
            this.fvy.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bfO() {
        return (this.eCK.cin() || beh()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.eYU = ovalActionButton;
            this.eYU.setOnClickListener(this.mOnClickListener);
            if (!biU()) {
                biT();
            }
        }
    }
}
