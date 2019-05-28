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
    private com.baidu.tieba.ueg.d eSh;
    private NoPressedRelativeLayout fLM;
    private i fMb;
    public OvalActionButton foR;
    private FrsFragment fqJ;
    public com.baidu.tieba.write.e fsv;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    private c.a fsy = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
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
                d.this.blx();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cE(d.this.fqJ.getPageContext().getPageActivity()) && !d.this.eSh.cqt() && !d.this.blz()) {
                if (d.this.fMb != null) {
                    d.this.fMb.bqU();
                }
                if (d.this.fqJ.bjN().sH(502) != null) {
                    d.this.fsx.av(d.this.fqJ.getForumId(), d.this.fqJ.bjN().bqN().tabId);
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
                d.this.bql();
                return;
            }
            d.this.foR.setImageDrawable(null);
            aVar.a(d.this.foR);
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
        if (this.fqJ != null && this.fqJ.bkm() != null && (forum = this.fqJ.bkm().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fqJ.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fqJ = frsFragment;
            this.fLM = noPressedRelativeLayout;
            this.eSh = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fsx = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fsx.a(this.fsy);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(int i) {
        if (this.fsv == null) {
            this.fsv = new com.baidu.tieba.write.e(this.fqJ.getPageContext(), this.fLM, "frs", 1);
            this.fsv.FG("2");
        }
        this.fsv.b(this.fqJ.bkj());
        this.fsv.FF(bqn());
        ForumWriteData bkp = this.fqJ.bkp();
        bkp.setDefaultZone(i);
        this.fsv.a(bkp);
        this.fsv.Cf(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fsv.a(false, null, this.foR);
        this.fqJ.bkj().setAlpha(0);
    }

    public void jK(boolean z) {
        FrsViewData bkm;
        if (this.foR != null) {
            bqm();
            this.foR.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bkm = this.fqJ.bkm()) != null && bkm.postTopic != null && bkm.getForum() != null && !StringUtils.isNull(bkm.getForum().getId()) && !StringUtils.isNull(bkm.postTopic.recom_title) && !StringUtils.isNull(bkm.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bkv().s(bkm.getForum().getId(), bkm.postTopic.uniq_topicid.longValue())) {
                a(this.foR, bkm);
            }
        }
    }

    public void bqi() {
        if (this.fsv != null) {
            this.fsv.onDestroy();
        }
        if (this.fMb != null) {
            this.fMb.bqU();
        }
    }

    public void bqj() {
        if (this.fMb != null) {
            this.fMb.bqU();
        }
    }

    public void bqk() {
    }

    public boolean bkP() {
        if (this.fsv == null || !this.fsv.isShowing()) {
            return false;
        }
        this.fsv.rL(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fsv != null) {
            this.fsv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bql() {
        this.foR.setImageResource(0);
    }

    public boolean bqm() {
        FrsViewData bkm;
        ActivityConfig activityConfig;
        if (this.fqJ == null || (bkm = this.fqJ.bkm()) == null || (activityConfig = bkm.activityConfig) == null || activityConfig.type.intValue() != 2) {
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
        com.baidu.adp.lib.f.c.iv().a(str, 10, this.mCallback, this.fqJ.getUniqueId());
    }

    private String bqn() {
        FrsViewData bkm;
        if (this.fqJ == null || (bkm = this.fqJ.bkm()) == null || bkm.activityConfig == null) {
            return "";
        }
        return bkm.activityConfig.addthread_text;
    }

    public boolean blz() {
        FrsViewData bkm;
        String fixedText;
        if (this.fqJ != null && (bkm = this.fqJ.bkm()) != null) {
            if (bc.cE(this.fqJ.getPageContext().getPageActivity())) {
                AntiData anti = bkm.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ap.nQ(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.fqJ.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fqJ.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.fqJ.getPageContext().getPageActivity(), string, R.drawable.icon_toast_game_error);
            c.am(1.25f);
            c.afO();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fqJ.getPageContext().getPageActivity());
        aVar.mE(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fqJ.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aiz().c(d.this.fqJ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fqJ.getPageContext()).afG();
        return true;
    }

    public boolean bqo() {
        if (this.fsv == null) {
            return false;
        }
        return this.fsv.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fqJ != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fMb == null) {
                this.fMb = new i(this.fqJ.getActivity(), this);
            }
            this.fMb.bqU();
            this.fMb.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bnh() {
        return (this.eSh.cqt() || blz()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.foR = ovalActionButton;
            this.foR.setOnClickListener(this.mOnClickListener);
            if (!bqm()) {
                bql();
            }
        }
    }
}
