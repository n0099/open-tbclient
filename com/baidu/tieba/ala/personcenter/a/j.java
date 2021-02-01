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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.widget.ListView.a<m, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ueg.d gEI;
    private TextView gLI;
    private String hGs;
    private boolean hZh;
    private boolean hZi;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.hZN);
        this.hZh = false;
        this.hZi = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final m mVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.ctb() == null) {
            return null;
        }
        a(mVar, cardViewHolder.ctb());
        cardViewHolder.ctb().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.a(mVar);
            }
        });
        return cardViewHolder.ctb().getView();
    }

    private void a(m mVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (mVar.getPersonCenterData() != null) {
            this.gLI = aVar.cno();
            cmL();
            aVar.wv(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_center_publish_live));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cmL() {
        if (!this.hZi) {
            this.hZi = true;
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), false)) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
                a(this.gLI, null, true);
                return;
            }
            a(this.gLI, null, false);
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
    public void a(m mVar) {
        if (mVar != null && mVar.getPersonCenterData() != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
            a(this.gLI, null, false);
            bRT();
            TiebaStatic.log("c13618");
        }
    }

    private void bRT() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.nw(R.string.prompt);
            aVar.Au(this.mPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.personcenter.a.j.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mPageContext).bqx();
        } else if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.gEI == null) {
                this.gEI = new com.baidu.tieba.ueg.d(this.mPageContext);
            }
            if (this.hZh) {
                if (this.gEI.dRt()) {
                    return;
                }
            } else if (this.gEI.dRs()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_config_not_found);
            } else {
                o(this.mPageContext);
            }
        }
    }

    private void o(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.ala.personcenter.a.j.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    String str;
                    if (j.this.hZh) {
                        str = j.this.mForumId;
                    } else {
                        str = "0";
                    }
                    String str2 = j.this.hZh ? j.this.mForumName : null;
                    String str3 = j.this.hZh ? j.this.hGs : null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.lH().getAddress(false);
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

    public void mw(boolean z) {
        this.hZh = z;
    }

    public void Im(String str) {
        this.hGs = str;
    }
}
