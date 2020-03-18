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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ueg.d eqc;
    private TextView ewf;
    private String feP;
    private boolean fuH;
    private boolean fuI;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.fvk);
        this.fuH = false;
        this.fuI = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bvQ() == null) {
            return null;
        }
        a(kVar, aVar.bvQ());
        aVar.bvQ().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.a(kVar);
            }
        });
        return aVar.bvQ().getView();
    }

    private void a(k kVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (kVar.getPersonCenterData() != null) {
            this.ewf = aVar.bsM();
            bsm();
            aVar.qS(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_center_publish_live));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bsm() {
        if (!this.fuI) {
            this.fuI = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), false)) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
                a(this.ewf, null, true);
                return;
            }
            a(this.ewf, null, false);
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
    public void a(k kVar) {
        if (kVar != null && kVar.getPersonCenterData() != null) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
            a(this.ewf, null, false);
            bdb();
            TiebaStatic.log("c13618");
        }
    }

    private void bdb() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sR(this.mPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.personcenter.a.i.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mPageContext).aEG();
        } else if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eqc == null) {
                this.eqc = new com.baidu.tieba.ueg.d(this.mPageContext);
            }
            if (this.fuH) {
                if (this.eqc.cPc()) {
                    return;
                }
            } else if (this.eqc.cPb()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_config_not_found);
            } else {
                l(this.mPageContext);
            }
        }
    }

    private void l(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.ala.personcenter.a.i.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                public void onPermissionsGranted() {
                    String str;
                    if (i.this.fuH) {
                        str = i.this.mForumId;
                    } else {
                        str = "0";
                    }
                    String str2 = i.this.fuH ? i.this.mForumName : null;
                    String str3 = i.this.fuH ? i.this.feP : null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.fK().getAddress(false);
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

    public void jZ(boolean z) {
        this.fuH = z;
    }

    public void zF(String str) {
        this.feP = str;
    }
}
