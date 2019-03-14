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
    private com.baidu.tieba.ueg.c eCG;
    public OvalActionButton eYT;
    private FrsFragment faG;
    public com.baidu.tieba.write.e fct;
    private com.baidu.tieba.frs.profession.permission.c fcv;
    private NoPressedRelativeLayout fvi;
    private i fvx;
    private c.a fcw = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
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
            } else {
                d.this.bee();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cZ(d.this.faG.getPageContext().getPageActivity()) && !d.this.eCG.ciq() && !d.this.beg()) {
                if (d.this.fvx != null) {
                    d.this.fvx.bjB();
                }
                if (d.this.faG.bcs().rD(502) != null) {
                    d.this.fcv.az(d.this.faG.getForumId(), d.this.faG.bcs().bju().tabId);
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
                d.this.biS();
                return;
            }
            d.this.eYT.setImageDrawable(null);
            aVar.a(d.this.eYT);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bee() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.faG != null && this.faG.bcR() != null && (forum = this.faG.bcR().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.faG.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.faG = frsFragment;
            this.fvi = noPressedRelativeLayout;
            this.eCG = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            this.fcv = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fcv.a(this.fcw);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(int i) {
        if (this.fct == null) {
            this.fct = new com.baidu.tieba.write.e(this.faG.getPageContext(), this.fvi, "frs", 1);
            this.fct.El("2");
        }
        this.fct.b(this.faG.bcO());
        this.fct.Ek(biU());
        ForumWriteData bcU = this.faG.bcU();
        bcU.setDefaultZone(i);
        this.fct.a(bcU);
        this.fct.Ba(i == 1 ? d.f.btn_frs_professional_edit_n : 0);
        this.fct.a(false, null, this.eYT);
        this.faG.bcO().setAlpha(0);
    }

    public void ja(boolean z) {
        FrsViewData bcR;
        if (this.eYT != null) {
            biT();
            this.eYT.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bcR = this.faG.bcR()) != null && bcR.postTopic != null && bcR.getForum() != null && !StringUtils.isNull(bcR.getForum().getId()) && !StringUtils.isNull(bcR.postTopic.recom_title) && !StringUtils.isNull(bcR.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bda().p(bcR.getForum().getId(), bcR.postTopic.uniq_topicid.longValue())) {
                a(this.eYT, bcR);
            }
        }
    }

    public void biP() {
        if (this.fct != null) {
            this.fct.onDestroy();
        }
        if (this.fvx != null) {
            this.fvx.bjB();
        }
    }

    public void biQ() {
        if (this.fvx != null) {
            this.fvx.bjB();
        }
    }

    public void biR() {
    }

    public boolean bdw() {
        if (this.fct == null || !this.fct.isShowing()) {
            return false;
        }
        this.fct.qW(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fct != null) {
            this.fct.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biS() {
        this.eYT.setImageResource(0);
    }

    public boolean biT() {
        FrsViewData bcR;
        ActivityConfig activityConfig;
        if (this.faG == null || (bcR = this.faG.bcR()) == null || (activityConfig = bcR.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            vM(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            vM(activityConfig.addthread_icon);
            return true;
        }
    }

    private void vM(String str) {
        com.baidu.adp.lib.f.c.jB().a(str, 10, this.mCallback, this.faG.getUniqueId());
    }

    private String biU() {
        FrsViewData bcR;
        if (this.faG == null || (bcR = this.faG.bcR()) == null || bcR.activityConfig == null) {
            return "";
        }
        return bcR.activityConfig.addthread_text;
    }

    public boolean beg() {
        FrsViewData bcR;
        String fixedText;
        if (this.faG != null && (bcR = this.faG.bcR()) != null) {
            if (bc.cZ(this.faG.getPageContext().getPageActivity())) {
                AntiData anti = bcR.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ap.mH(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.faG.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.faG.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.faG.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            c.ak(1.25f);
            c.abh();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.faG.getPageContext().getPageActivity());
        aVar.ly(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.faG.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.adD().c(d.this.faG.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.faG.getPageContext()).aaZ();
        return true;
    }

    public boolean biV() {
        if (this.fct == null) {
            return false;
        }
        return this.fct.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.faG != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fvx == null) {
                this.fvx = new i(this.faG.getActivity(), this);
            }
            this.fvx.bjB();
            this.fvx.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bfN() {
        return (this.eCG.ciq() || beg()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.eYT = ovalActionButton;
            this.eYT.setOnClickListener(this.mOnClickListener);
            if (!biT()) {
                biS();
            }
        }
    }
}
