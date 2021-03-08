package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.a.d {
    private com.baidu.tieba.ueg.d gGF;
    private NoPressedRelativeLayout jLB;
    private l jLZ;
    public OvalActionButton jig;
    private FrsFragment jkB;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    public com.baidu.tieba.write.g jmy;
    private c.a jmB = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                d.this.yW(1);
            } else if (z) {
                d.this.yW(0);
            } else if (i != 502) {
                d.this.yW(-1);
            } else {
                d.this.cEH();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tbadk.core.util.h.a(new ar(d.this.jkB.getPageContext().getPageActivity(), "frs_fabu")) && bh.checkUpIsLogin(d.this.jkB.getPageContext().getPageActivity()) && !d.this.gGF.dRJ() && !d.this.cEJ() && !WriteActivityConfig.isAsyncWriting()) {
                if (d.this.jLZ != null) {
                    d.this.jLZ.cMj();
                }
                if (d.this.jkB.cCF().AI(502) == null || d.this.jkB.cCF().cMa() == null) {
                    d.this.yW(-1);
                } else {
                    d.this.jmA.ba(d.this.jkB.getForumId(), d.this.jkB.cCF().cMa().tabId);
                }
                d.this.cLc();
            }
        }
    };
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fah = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cLg();
                return;
            }
            d.this.jig.setImageDrawable(null);
            aVar.drawImageTo(d.this.jig);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cEH() {
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
        if (this.jkB != null && this.jkB.cDm() != null && (forum = this.jkB.cDm().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    String str11 = themeColorInfo.day.light_color;
                    str8 = themeColorInfo.day.dark_color;
                    if (skinType == 0) {
                        str9 = themeColorInfo.day.pattern_image;
                        str6 = str11;
                    } else {
                        str6 = str11;
                        str9 = null;
                    }
                } else {
                    str8 = null;
                    str6 = null;
                    str9 = null;
                }
                if (themeColorInfo.night != null) {
                    str4 = themeColorInfo.night.light_color;
                    String str12 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str3 = str12;
                        str10 = themeColorInfo.night.pattern_image;
                    } else {
                        str3 = str12;
                        str10 = str9;
                    }
                } else {
                    str3 = null;
                    str4 = null;
                    str10 = str9;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str13 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str13;
                        str5 = str8;
                        str7 = themeColorInfo.dark.pattern_image;
                    } else {
                        str = str13;
                        str5 = str8;
                        str7 = str10;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str5 = str8;
                    str7 = str10;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jkB.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.jkB = frsFragment;
            this.jLB = noPressedRelativeLayout;
            this.gGF = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.jmA = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.jmA.a(this.jmB);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13604");
        if (this.jkB != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jkB.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW(int i) {
        if (this.jmy == null) {
            this.jmy = new com.baidu.tieba.write.g(this.jkB.getPageContext(), this.jLB, "frs");
            this.jmy.Vq("2");
            ItemInfo itemInfo = this.jkB.cDm().itemInfo;
            this.jmy.zu((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.jmy.Vp(cLi());
        if (this.jkB.cDm().getAnti() != null) {
            this.jmy.zw(this.jkB.cDm().getAnti().getCanGoods());
        }
        ForumWriteData cDq = this.jkB.cDq();
        cDq.setDefaultZone(i);
        this.jmy.a(cDq);
        this.jmy.b(this.jkB.cDm().itemInfo);
        this.jmy.Ll(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.jkB != null && this.jkB.cDm() != null) {
            this.jmy.b(this.jkB.cDm().itemInfo);
        }
        this.jmy.a(false, (View) null, (View) this.jig);
        this.jkB.cDj().setAlpha(0);
        if (this.jkB != null && this.jkB.cDm() != null && this.jkB.cDm().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dR("fid", this.jkB.getForumId()).dR("fname", this.jkB.getForumName()).dR("obj_param1", this.jkB.cDm().itemInfo.name));
        }
    }

    public void qC(boolean z) {
        FrsViewData cDm;
        if (this.jig != null) {
            cLh();
            this.jig.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cDm = this.jkB.cDm()) != null && cDm.postTopic != null && cDm.getForum() != null && !StringUtils.isNull(cDm.getForum().getId()) && !StringUtils.isNull(cDm.postTopic.recom_title) && !StringUtils.isNull(cDm.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cDA().E(cDm.getForum().getId(), cDm.postTopic.uniq_topicid.longValue())) {
                a(this.jig, cDm);
            }
        }
    }

    public void cLd() {
        if (this.jmy != null) {
            this.jmy.onDestroy();
        }
        if (this.jLZ != null) {
            this.jLZ.cMj();
        }
    }

    public void cLe() {
        if (this.jLZ != null) {
            this.jLZ.cMj();
        }
    }

    public void cLf() {
    }

    public boolean cDT() {
        if (this.jmy == null || !this.jmy.isShowing()) {
            return false;
        }
        this.jmy.zv(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.jmy != null) {
            this.jmy.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLg() {
        this.jig.setImageResource(0);
    }

    public boolean cLh() {
        FrsViewData cDm;
        ActivityConfig activityConfig;
        if (this.jkB == null || (cDm = this.jkB.cDm()) == null || (activityConfig = cDm.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Ls(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Ls(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Ls(String str) {
        com.baidu.adp.lib.e.d.mw().a(str, 10, this.fah, this.jkB.getUniqueId());
    }

    private String cLi() {
        FrsViewData cDm;
        if (this.jkB == null || (cDm = this.jkB.cDm()) == null || cDm.activityConfig == null) {
            return "";
        }
        return cDm.activityConfig.addthread_text;
    }

    public boolean cEJ() {
        FrsViewData cDm;
        if (this.jkB == null || (cDm = this.jkB.cDm()) == null) {
            return false;
        }
        if (bh.checkUpIsLogin(this.jkB.getPageContext().getPageActivity())) {
            AntiData anti = cDm.getAnti();
            return anti != null && a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.jkB.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i == 1 || i == 2) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jkB.getPageContext().getPageActivity());
            aVar.AB(au.getFixedText(string, 50, true));
            aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.jkB.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.a(au.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        bf.bsY().b(d.this.jkB.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
            }
            aVar.b(this.jkB.getPageContext()).bqz();
            return true;
        }
        return false;
    }

    public boolean cLj() {
        if (this.jmy == null) {
            return false;
        }
        return this.jmy.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.jkB != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jLZ == null) {
                this.jLZ = new l(this.jkB.getActivity(), this);
            }
            this.jLZ.cMj();
            this.jLZ.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.d
    public boolean cGP() {
        return (this.gGF.dRJ() || cEJ()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.jig = ovalActionButton;
            this.jig.setOnClickListener(this.mOnClickListener);
            if (!cLh()) {
                cLg();
            }
        }
    }

    public boolean cEs() {
        if (this.jmy == null) {
            return false;
        }
        return this.jmy.isShowing();
    }

    public void cLk() {
        if (this.jig != null) {
            this.jig.performClick();
        }
    }
}
