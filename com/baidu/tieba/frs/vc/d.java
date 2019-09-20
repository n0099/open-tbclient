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
    private com.baidu.tieba.ueg.d eYX;
    private i fTG;
    private NoPressedRelativeLayout fTr;
    public OvalActionButton fwc;
    private FrsFragment fxT;
    public com.baidu.tieba.write.e fzD;
    private com.baidu.tieba.frs.profession.permission.c fzF;
    private c.a fzG = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ki(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.rN(1);
            } else if (z) {
                d.this.rN(0);
            } else if (i != 502) {
                d.this.rN(-1);
            } else {
                d.this.bot();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kj(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cF(d.this.fxT.getPageContext().getPageActivity()) && !d.this.eYX.cuo() && !d.this.bov()) {
                if (d.this.fTG != null) {
                    d.this.fTG.btY();
                }
                if (d.this.fxT.bmH().tf(502) != null) {
                    d.this.fzF.ay(d.this.fxT.getForumId(), d.this.fxT.bmH().btR().tabId);
                } else {
                    d.this.rN(-1);
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
                d.this.bto();
                return;
            }
            d.this.fwc.setImageDrawable(null);
            aVar.a(d.this.fwc);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fxT != null && this.fxT.bnj() != null && (forum = this.fxT.bnj().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fxT.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fxT = frsFragment;
            this.fTr = noPressedRelativeLayout;
            this.eYX = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.fzF = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fzF.a(this.fzG);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(int i) {
        if (this.fzD == null) {
            this.fzD = new com.baidu.tieba.write.e(this.fxT.getPageContext(), this.fTr, "frs", 1);
            this.fzD.Hd("2");
        }
        this.fzD.b(this.fxT.bng());
        this.fzD.Hc(btq());
        ForumWriteData bnm = this.fxT.bnm();
        bnm.setDefaultZone(i);
        this.fzD.a(bnm);
        this.fzD.CS(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fzD.a(false, (View) null, (View) this.fwc);
        this.fxT.bng().setAlpha(0);
    }

    public void jX(boolean z) {
        FrsViewData bnj;
        if (this.fwc != null) {
            btp();
            this.fwc.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bnj = this.fxT.bnj()) != null && bnj.postTopic != null && bnj.getForum() != null && !StringUtils.isNull(bnj.getForum().getId()) && !StringUtils.isNull(bnj.postTopic.recom_title) && !StringUtils.isNull(bnj.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bns().u(bnj.getForum().getId(), bnj.postTopic.uniq_topicid.longValue())) {
                a(this.fwc, bnj);
            }
        }
    }

    public void btl() {
        if (this.fzD != null) {
            this.fzD.onDestroy();
        }
        if (this.fTG != null) {
            this.fTG.btY();
        }
    }

    public void btm() {
        if (this.fTG != null) {
            this.fTG.btY();
        }
    }

    public void btn() {
    }

    public boolean bnM() {
        if (this.fzD == null || !this.fzD.isShowing()) {
            return false;
        }
        this.fzD.sf(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fzD != null) {
            this.fzD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bto() {
        this.fwc.setImageResource(0);
    }

    public boolean btp() {
        FrsViewData bnj;
        ActivityConfig activityConfig;
        if (this.fxT == null || (bnj = this.fxT.bnj()) == null || (activityConfig = bnj.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            yh(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            yh(activityConfig.addthread_icon);
            return true;
        }
    }

    private void yh(String str) {
        com.baidu.adp.lib.f.c.iE().a(str, 10, this.mCallback, this.fxT.getUniqueId());
    }

    private String btq() {
        FrsViewData bnj;
        if (this.fxT == null || (bnj = this.fxT.bnj()) == null || bnj.activityConfig == null) {
            return "";
        }
        return bnj.activityConfig.addthread_text;
    }

    public boolean bov() {
        FrsViewData bnj;
        String fixedText;
        if (this.fxT != null && (bnj = this.fxT.bnj()) != null) {
            if (bc.cF(this.fxT.getPageContext().getPageActivity())) {
                AntiData anti = bnj.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.oe(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.fxT.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake_n_svg, true);
                        b.am(1.25f);
                        b.agW();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fxT.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.fxT.getPageContext().getPageActivity(), string, R.drawable.icon_pure_toast_mistake_n_svg, true);
            b.am(1.25f);
            b.agW();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxT.getPageContext().getPageActivity());
        aVar.mQ(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fxT.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.ajK().c(d.this.fxT.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fxT.getPageContext()).agO();
        return true;
    }

    public boolean btr() {
        if (this.fzD == null) {
            return false;
        }
        return this.fzD.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fxT != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fTG == null) {
                this.fTG = new i(this.fxT.getActivity(), this);
            }
            this.fTG.btY();
            this.fTG.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bqg() {
        return (this.eYX.cuo() || bov()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.fwc = ovalActionButton;
            this.fwc.setOnClickListener(this.mOnClickListener);
            if (!btp()) {
                bto();
            }
        }
    }
}
