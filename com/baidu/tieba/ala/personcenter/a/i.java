package com.baidu.tieba.ala.personcenter.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private String fXa;
    private com.baidu.tieba.ueg.d fgm;
    private TextView fmp;
    private boolean goe;
    private boolean gof;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), l.goJ);
        this.goe = false;
        this.gof = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        a(lVar, aVar.bLU());
        aVar.bLU().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.a(lVar);
            }
        });
        return aVar.bLU().getView();
    }

    private void a(l lVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (lVar.getPersonCenterData() != null) {
            this.fmp = aVar.bIM();
            bIj();
            aVar.rO(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_center_publish_live));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bIj() {
        if (!this.gof) {
            this.gof = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), false)) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
                a(this.fmp, null, true);
                return;
            }
            a(this.fmp, null, false);
        }
    }

    private void a(TextView textView, String str, boolean z) {
        if (textView != null && this.mPageContext != null) {
            if (z) {
                textView.setText("");
                Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText("");
            }
            textView.setCompoundDrawables(null, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar != null && lVar.getPersonCenterData() != null) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
            a(this.fmp, null, false);
            bro();
            TiebaStatic.log("c13618");
        }
    }

    private void bro() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kC(R.string.prompt);
            aVar.vO(this.mPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.personcenter.a.i.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mPageContext).aST();
        } else if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fgm == null) {
                this.fgm = new com.baidu.tieba.ueg.d(this.mPageContext);
            }
            if (this.goe) {
                if (this.fgm.dhl()) {
                    return;
                }
            } else if (this.fgm.dhk()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_config_not_found);
            } else {
                m(this.mPageContext);
            }
        }
    }

    private void m(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.ala.personcenter.a.i.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    String str;
                    if (i.this.goe) {
                        str = i.this.mForumId;
                    } else {
                        str = "0";
                    }
                    String str2 = i.this.goe ? i.this.mForumName : null;
                    String str3 = i.this.goe ? i.this.fXa : null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.kq().getAddress(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void jl(boolean z) {
        this.goe = z;
    }

    public void CX(String str) {
        this.fXa = str;
    }
}
