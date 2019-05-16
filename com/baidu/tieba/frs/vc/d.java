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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d eSg;
    private NoPressedRelativeLayout fLL;
    private i fMa;
    public OvalActionButton foQ;
    private FrsFragment fqI;
    public com.baidu.tieba.write.e fsu;
    private com.baidu.tieba.frs.profession.permission.c fsw;
    private c.a fsx = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jV(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.rq(1);
            } else if (z) {
                d.this.rq(0);
            } else if (i != 502) {
                d.this.rq(-1);
            } else {
                d.this.blu();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cE(d.this.fqI.getPageContext().getPageActivity()) && !d.this.eSg.cqr() && !d.this.blw()) {
                if (d.this.fMa != null) {
                    d.this.fMa.bqR();
                }
                if (d.this.fqI.bjK().sH(502) != null) {
                    d.this.fsw.av(d.this.fqI.getForumId(), d.this.fqI.bjK().bqK().tabId);
                } else {
                    d.this.rq(-1);
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
            if (aVar == null || !aVar.nt()) {
                d.this.bqi();
                return;
            }
            d.this.foQ.setImageDrawable(null);
            aVar.a(d.this.foQ);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void blu() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fqI != null && this.fqI.bkj() != null && (forum = this.fqI.bkj().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fqI.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fqI = frsFragment;
            this.fLL = noPressedRelativeLayout;
            this.eSg = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fsw = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fsw.a(this.fsx);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(int i) {
        if (this.fsu == null) {
            this.fsu = new com.baidu.tieba.write.e(this.fqI.getPageContext(), this.fLL, "frs", 1);
            this.fsu.FG("2");
        }
        this.fsu.b(this.fqI.bkg());
        this.fsu.FF(bqk());
        ForumWriteData bkm = this.fqI.bkm();
        bkm.setDefaultZone(i);
        this.fsu.a(bkm);
        this.fsu.Cf(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fsu.a(false, null, this.foQ);
        this.fqI.bkg().setAlpha(0);
    }

    public void jK(boolean z) {
        FrsViewData bkj;
        if (this.foQ != null) {
            bqj();
            this.foQ.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bkj = this.fqI.bkj()) != null && bkj.postTopic != null && bkj.getForum() != null && !StringUtils.isNull(bkj.getForum().getId()) && !StringUtils.isNull(bkj.postTopic.recom_title) && !StringUtils.isNull(bkj.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bks().s(bkj.getForum().getId(), bkj.postTopic.uniq_topicid.longValue())) {
                a(this.foQ, bkj);
            }
        }
    }

    public void bqf() {
        if (this.fsu != null) {
            this.fsu.onDestroy();
        }
        if (this.fMa != null) {
            this.fMa.bqR();
        }
    }

    public void bqg() {
        if (this.fMa != null) {
            this.fMa.bqR();
        }
    }

    public void bqh() {
    }

    public boolean bkM() {
        if (this.fsu == null || !this.fsu.isShowing()) {
            return false;
        }
        this.fsu.rL(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fsu != null) {
            this.fsu.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqi() {
        this.foQ.setImageResource(0);
    }

    public boolean bqj() {
        FrsViewData bkj;
        ActivityConfig activityConfig;
        if (this.fqI == null || (bkj = this.fqI.bkj()) == null || (activityConfig = bkj.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            xa(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            xa(activityConfig.addthread_icon);
            return true;
        }
    }

    private void xa(String str) {
        com.baidu.adp.lib.f.c.iv().a(str, 10, this.mCallback, this.fqI.getUniqueId());
    }

    private String bqk() {
        FrsViewData bkj;
        if (this.fqI == null || (bkj = this.fqI.bkj()) == null || bkj.activityConfig == null) {
            return "";
        }
        return bkj.activityConfig.addthread_text;
    }

    public boolean blw() {
        FrsViewData bkj;
        String fixedText;
        if (this.fqI != null && (bkj = this.fqI.bkj()) != null) {
            if (bc.cE(this.fqI.getPageContext().getPageActivity())) {
                AntiData anti = bkj.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ap.nQ(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.fqI.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_toast_game_error);
                        c.am(1.25f);
                        c.afO();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fqI.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.fqI.getPageContext().getPageActivity(), string, R.drawable.icon_toast_game_error);
            c.am(1.25f);
            c.afO();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fqI.getPageContext().getPageActivity());
        aVar.mE(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fqI.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aiz().c(d.this.fqI.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fqI.getPageContext()).afG();
        return true;
    }

    public boolean bql() {
        if (this.fsu == null) {
            return false;
        }
        return this.fsu.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fqI != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fMa == null) {
                this.fMa = new i(this.fqI.getActivity(), this);
            }
            this.fMa.bqR();
            this.fMa.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bne() {
        return (this.eSg.cqr() || blw()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.foQ = ovalActionButton;
            this.foQ.setOnClickListener(this.mOnClickListener);
            if (!bqj()) {
                bqi();
            }
        }
    }
}
