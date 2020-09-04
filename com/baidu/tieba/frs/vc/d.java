package com.baidu.tieba.frs.vc;

import android.content.Context;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes16.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fIp;
    public OvalActionButton hSW;
    private FrsFragment hVq;
    public com.baidu.tieba.write.g hXo;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private l itM;
    private NoPressedRelativeLayout ito;
    private c.a hXr = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ow(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                d.this.xr(1);
            } else if (z) {
                d.this.xr(0);
            } else if (i != 502) {
                d.this.xr(-1);
            } else {
                d.this.cnR();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ox(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.hVq.getPageContext().getPageActivity()) && !d.this.fIp.dAA() && !d.this.cnT()) {
                if (d.this.itM != null) {
                    d.this.itM.cud();
                }
                if (d.this.hVq.clR().yV(502) == null || d.this.hVq.clR().ctU() == null) {
                    d.this.xr(-1);
                } else {
                    d.this.hXq.aN(d.this.hVq.getForumId(), d.this.hVq.clR().ctU().tabId);
                }
                d.this.ctc();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eif = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.ctg();
                return;
            }
            d.this.hSW.setImageDrawable(null);
            aVar.drawImageTo(d.this.hSW);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = null;
        if (this.hVq != null && this.hVq.cmx() != null && (forum = this.hVq.cmx().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str7 = themeColorInfo.day.dark_color;
                    str8 = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str7 = null;
                    str6 = null;
                    str8 = null;
                }
                if (themeColorInfo.night != null) {
                    String str12 = themeColorInfo.night.light_color;
                    String str13 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str4 = str12;
                        str9 = themeColorInfo.night.pattern_image;
                        str10 = str13;
                    } else {
                        str4 = str12;
                        str9 = str8;
                        str10 = str13;
                    }
                } else {
                    str4 = null;
                    str9 = str8;
                    str10 = null;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str14 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str14;
                        str11 = themeColorInfo.dark.pattern_image;
                        str3 = str10;
                        str5 = str7;
                    } else {
                        str = str14;
                        str11 = str9;
                        str3 = str10;
                        str5 = str7;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str11 = str9;
                    str3 = str10;
                    str5 = str7;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hVq.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hVq = frsFragment;
            this.ito = noPressedRelativeLayout;
            this.fIp = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hXq = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hXq.a(this.hXr);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctc() {
        aq aqVar = new aq("c13604");
        if (this.hVq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hVq.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        if (this.hXo == null) {
            this.hXo = new com.baidu.tieba.write.g(this.hVq.getPageContext(), this.ito, "frs");
            this.hXo.Sy("2");
            ItemInfo itemInfo = this.hVq.cmx().itemInfo;
            this.hXo.xb((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.hXo.Sx(cti());
        if (this.hVq.cmx().getAnti() != null) {
            this.hXo.setCanGoods(this.hVq.cmx().getAnti().getCanGoods());
        }
        ForumWriteData cmB = this.hVq.cmB();
        cmB.setDefaultZone(i);
        this.hXo.a(cmB);
        this.hXo.b(this.hVq.cmx().itemInfo);
        this.hXo.Jv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.hVq != null && this.hVq.cmx() != null) {
            this.hXo.b(this.hVq.cmx().itemInfo);
        }
        this.hXo.a(false, (View) null, (View) this.hSW);
        this.hVq.cmu().setAlpha(0);
        if (this.hVq != null && this.hVq.cmx() != null && this.hVq.cmx().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dD("fid", this.hVq.getForumId()).dD("fname", this.hVq.getForumName()).dD("obj_param1", this.hVq.cmx().itemInfo.name));
        }
    }

    public void om(boolean z) {
        FrsViewData cmx;
        if (this.hSW != null) {
            cth();
            this.hSW.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cmx = this.hVq.cmx()) != null && cmx.postTopic != null && cmx.getForum() != null && !StringUtils.isNull(cmx.getForum().getId()) && !StringUtils.isNull(cmx.postTopic.recom_title) && !StringUtils.isNull(cmx.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cmL().B(cmx.getForum().getId(), cmx.postTopic.uniq_topicid.longValue())) {
                a(this.hSW, cmx);
            }
        }
    }

    public void ctd() {
        if (this.hXo != null) {
            this.hXo.onDestroy();
        }
        if (this.itM != null) {
            this.itM.cud();
        }
    }

    public void cte() {
        if (this.itM != null) {
            this.itM.cud();
        }
    }

    public void ctf() {
    }

    public boolean cne() {
        if (this.hXo == null || !this.hXo.isShowing()) {
            return false;
        }
        this.hXo.xc(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hXo != null) {
            this.hXo.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctg() {
        this.hSW.setImageResource(0);
    }

    public boolean cth() {
        FrsViewData cmx;
        ActivityConfig activityConfig;
        if (this.hVq == null || (cmx = this.hVq.cmx()) == null || (activityConfig = cmx.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            IZ(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            IZ(activityConfig.addthread_icon);
            return true;
        }
    }

    private void IZ(String str) {
        com.baidu.adp.lib.e.c.mM().a(str, 10, this.eif, this.hVq.getUniqueId());
    }

    private String cti() {
        FrsViewData cmx;
        if (this.hVq == null || (cmx = this.hVq.cmx()) == null || cmx.activityConfig == null) {
            return "";
        }
        return cmx.activityConfig.addthread_text;
    }

    public boolean cnT() {
        FrsViewData cmx;
        String fixedText;
        if (this.hVq != null && (cmx = this.hVq.cmx()) != null) {
            if (bg.checkUpIsLogin(this.hVq.getPageContext().getPageActivity())) {
                AntiData anti = cmx.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hVq.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.bhm();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hVq.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hVq.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.bhm();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hVq.getPageContext().getPageActivity());
        aVar.zA(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hVq.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(at.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    be.bju().b(d.this.hVq.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hVq.getPageContext()).bhg();
        return true;
    }

    public boolean ctj() {
        if (this.hXo == null) {
            return false;
        }
        return this.hXo.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hVq != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.itM == null) {
                this.itM = new l(this.hVq.getActivity(), this);
            }
            this.itM.cud();
            this.itM.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cpS() {
        return (this.fIp.dAA() || cnT()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hSW = ovalActionButton;
            this.hSW.setOnClickListener(this.mOnClickListener);
            if (!cth()) {
                ctg();
            }
        }
    }

    public boolean cnE() {
        if (this.hXo == null) {
            return false;
        }
        return this.hXo.isShowing();
    }
}
