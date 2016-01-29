package com.baidu.tieba.hottopic.controller;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o {
    private SparseArray<String> bfX = null;
    private TbPageContext<HotTopicActivity> context;

    public o(TbPageContext<HotTopicActivity> tbPageContext) {
        this.context = tbPageContext;
    }

    private SparseArray<String> qJ() {
        if (this.bfX == null) {
            this.bfX = new SparseArray<>(7);
            this.bfX.put(2, "topic_wx_timeline");
            this.bfX.put(3, "topic_wx_friend");
            this.bfX.put(4, "topic_qq_zone");
            this.bfX.put(5, "topic_tencent_weibo");
            this.bfX.put(6, "topic_sina_weibo");
        }
        return this.bfX;
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.XO() != null) {
            if (TextUtils.isEmpty(eVar.XO().bKm)) {
                this.context.showToast(this.context.getString(t.j.no_hot_topic_data));
                return;
            }
            String str = eVar.XO().Wm;
            String str2 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + eVar.XO().bKm;
            Uri parse = StringUtils.isNull(eVar.XO().bLg) ? null : Uri.parse(eVar.XO().bLg);
            String str3 = eVar.XO().bLf;
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = str;
            fVar.content = str3;
            fVar.linkUrl = str2;
            fVar.amF = true;
            fVar.extData = eVar.XO().bKm;
            fVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.context.getOrignalPage().getPageContext().getPageActivity(), fVar, true, qJ());
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new p(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new q(this));
            shareDialogConfig.setCopyLinkListener(new r(this, fVar));
            this.context.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void a(ShareFromTopicMsgData shareFromTopicMsgData, int i, String str, long j, com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.XO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getOrignalPage().getPageContext().getPageActivity());
            com.baidu.tieba.hottopic.view.r rVar = new com.baidu.tieba.hottopic.view.r(this.context.getOrignalPage().getPageContext().getPageActivity());
            rVar.setData(shareFromTopicMsgData);
            aVar.ca(1);
            aVar.z(rVar);
            aVar.a(t.j.share, new s(this, rVar, i, str, j, shareFromTopicMsgData));
            aVar.b(t.j.alert_no_button, new t(this, rVar));
            aVar.b(this.context.getOrignalPage().getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                rVar.x(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }

    public void a(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.XO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getOrignalPage().getPageContext().getPageActivity());
            com.baidu.tieba.hottopic.view.r rVar = new com.baidu.tieba.hottopic.view.r(this.context.getOrignalPage().getPageContext().getPageActivity());
            rVar.setData(shareFromTopicMsgData);
            aVar.ca(1);
            aVar.z(rVar);
            aVar.a(t.j.share, new u(this, rVar, j, str, str2, shareFromTopicMsgData));
            aVar.b(t.j.alert_no_button, new v(this, rVar));
            aVar.b(this.context.getOrignalPage().getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                rVar.x(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }
}
