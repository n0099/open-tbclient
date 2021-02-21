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
    private com.baidu.tieba.ueg.d gEW;
    private NoPressedRelativeLayout jJS;
    private l jKq;
    public OvalActionButton jgw;
    private FrsFragment jiS;
    public com.baidu.tieba.write.g jkO;
    private com.baidu.tieba.frs.profession.permission.c jkQ;
    private c.a jkR = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                d.this.yV(1);
            } else if (z) {
                d.this.yV(0);
            } else if (i != 502) {
                d.this.yV(-1);
            } else {
                d.this.cEB();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tbadk.core.util.h.a(new ar(d.this.jiS.getPageContext().getPageActivity(), "frs_fabu")) && bh.checkUpIsLogin(d.this.jiS.getPageContext().getPageActivity()) && !d.this.gEW.dRB() && !d.this.cED() && !WriteActivityConfig.isAsyncWriting()) {
                if (d.this.jKq != null) {
                    d.this.jKq.cMd();
                }
                if (d.this.jiS.cCz().AH(502) == null || d.this.jiS.cCz().cLU() == null) {
                    d.this.yV(-1);
                } else {
                    d.this.jkQ.aZ(d.this.jiS.getForumId(), d.this.jiS.cCz().cLU().tabId);
                }
                d.this.cKW();
            }
        }
    };
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eYI = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cLa();
                return;
            }
            d.this.jgw.setImageDrawable(null);
            aVar.drawImageTo(d.this.jgw);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cEB() {
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
        if (this.jiS != null && this.jiS.cDg() != null && (forum = this.jiS.cDg().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jiS.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.jiS = frsFragment;
            this.jJS = noPressedRelativeLayout;
            this.gEW = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.jkQ = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.jkQ.a(this.jkR);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKW() {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13604");
        if (this.jiS != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jiS.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV(int i) {
        if (this.jkO == null) {
            this.jkO = new com.baidu.tieba.write.g(this.jiS.getPageContext(), this.jJS, "frs");
            this.jkO.Vj("2");
            ItemInfo itemInfo = this.jiS.cDg().itemInfo;
            this.jkO.zv((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.jkO.Vi(cLc());
        if (this.jiS.cDg().getAnti() != null) {
            this.jkO.zx(this.jiS.cDg().getAnti().getCanGoods());
        }
        ForumWriteData cDk = this.jiS.cDk();
        cDk.setDefaultZone(i);
        this.jkO.a(cDk);
        this.jkO.b(this.jiS.cDg().itemInfo);
        this.jkO.Lh(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.jiS != null && this.jiS.cDg() != null) {
            this.jkO.b(this.jiS.cDg().itemInfo);
        }
        this.jkO.a(false, (View) null, (View) this.jgw);
        this.jiS.cDd().setAlpha(0);
        if (this.jiS != null && this.jiS.cDg() != null && this.jiS.cDg().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dR("fid", this.jiS.getForumId()).dR("fname", this.jiS.getForumName()).dR("obj_param1", this.jiS.cDg().itemInfo.name));
        }
    }

    public void qC(boolean z) {
        FrsViewData cDg;
        if (this.jgw != null) {
            cLb();
            this.jgw.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cDg = this.jiS.cDg()) != null && cDg.postTopic != null && cDg.getForum() != null && !StringUtils.isNull(cDg.getForum().getId()) && !StringUtils.isNull(cDg.postTopic.recom_title) && !StringUtils.isNull(cDg.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cDu().E(cDg.getForum().getId(), cDg.postTopic.uniq_topicid.longValue())) {
                a(this.jgw, cDg);
            }
        }
    }

    public void cKX() {
        if (this.jkO != null) {
            this.jkO.onDestroy();
        }
        if (this.jKq != null) {
            this.jKq.cMd();
        }
    }

    public void cKY() {
        if (this.jKq != null) {
            this.jKq.cMd();
        }
    }

    public void cKZ() {
    }

    public boolean cDN() {
        if (this.jkO == null || !this.jkO.isShowing()) {
            return false;
        }
        this.jkO.zw(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.jkO != null) {
            this.jkO.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLa() {
        this.jgw.setImageResource(0);
    }

    public boolean cLb() {
        FrsViewData cDg;
        ActivityConfig activityConfig;
        if (this.jiS == null || (cDg = this.jiS.cDg()) == null || (activityConfig = cDg.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Lj(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Lj(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Lj(String str) {
        com.baidu.adp.lib.e.d.mw().a(str, 10, this.eYI, this.jiS.getUniqueId());
    }

    private String cLc() {
        FrsViewData cDg;
        if (this.jiS == null || (cDg = this.jiS.cDg()) == null || cDg.activityConfig == null) {
            return "";
        }
        return cDg.activityConfig.addthread_text;
    }

    public boolean cED() {
        FrsViewData cDg;
        if (this.jiS == null || (cDg = this.jiS.cDg()) == null) {
            return false;
        }
        if (bh.checkUpIsLogin(this.jiS.getPageContext().getPageActivity())) {
            AntiData anti = cDg.getAnti();
            return anti != null && a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.jiS.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i == 1 || i == 2) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jiS.getPageContext().getPageActivity());
            aVar.Au(au.getFixedText(string, 50, true));
            aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.jiS.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                        bf.bsV().b(d.this.jiS.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
            }
            aVar.b(this.jiS.getPageContext()).bqx();
            return true;
        }
        return false;
    }

    public boolean cLd() {
        if (this.jkO == null) {
            return false;
        }
        return this.jkO.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.jiS != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jKq == null) {
                this.jKq = new l(this.jiS.getActivity(), this);
            }
            this.jKq.cMd();
            this.jKq.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.d
    public boolean cGJ() {
        return (this.gEW.dRB() || cED()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.jgw = ovalActionButton;
            this.jgw.setOnClickListener(this.mOnClickListener);
            if (!cLb()) {
                cLa();
            }
        }
    }

    public boolean cEm() {
        if (this.jkO == null) {
            return false;
        }
        return this.jkO.isShowing();
    }

    public void cLe() {
        if (this.jgw != null) {
            this.jgw.performClick();
        }
    }
}
