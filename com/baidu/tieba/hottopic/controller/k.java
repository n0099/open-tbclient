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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class k {
    private SparseArray<String> aZJ = null;
    private TbPageContext<HotTopicActivity> context;

    public k(TbPageContext<HotTopicActivity> tbPageContext) {
        this.context = tbPageContext;
    }

    private SparseArray<String> qF() {
        if (this.aZJ == null) {
            this.aZJ = new SparseArray<>(7);
            this.aZJ.put(2, "topic_wx_timeline");
            this.aZJ.put(3, "topic_wx_friend");
            this.aZJ.put(4, "topic_qq_zone");
            this.aZJ.put(5, "topic_tencent_weibo");
            this.aZJ.put(6, "topic_sina_weibo");
        }
        return this.aZJ;
    }

    public void b(com.baidu.tieba.hottopic.data.c cVar) {
        if (cVar != null && cVar.Us() != null) {
            if (TextUtils.isEmpty(cVar.Us().bDj)) {
                this.context.showToast(this.context.getString(n.i.no_hot_topic_data));
                return;
            }
            String str = cVar.Us().bDS;
            String str2 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + cVar.Us().bDj;
            Uri parse = StringUtils.isNull(cVar.Us().bDR) ? null : Uri.parse(cVar.Us().bDR);
            String str3 = cVar.Us().bDQ;
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = str;
            fVar.content = str3;
            fVar.linkUrl = str2;
            fVar.akH = true;
            fVar.extData = cVar.Us().bDj;
            fVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.context.getOrignalPage().getPageContext().getPageActivity(), fVar, true, qF());
            shareDialogConfig.addOutsideTextView(n.i.share_tieba_qunzu, n.e.icon_unite_share_qunzu, new l(this));
            shareDialogConfig.addOutsideTextView(n.i.forum_friend, n.e.icon_unite_share_baf, new m(this));
            shareDialogConfig.setCopyLinkListener(new n(this, fVar));
            this.context.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void a(ShareFromTopicMsgData shareFromTopicMsgData, int i, String str, long j, com.baidu.tieba.hottopic.data.c cVar) {
        if (cVar != null && cVar.Us() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getOrignalPage().getPageContext().getPageActivity());
            com.baidu.tieba.hottopic.view.j jVar = new com.baidu.tieba.hottopic.view.j(this.context.getOrignalPage().getPageContext().getPageActivity());
            jVar.setData(shareFromTopicMsgData);
            aVar.bP(1);
            aVar.m(jVar);
            aVar.a(n.i.share, new o(this, jVar, i, str, j, shareFromTopicMsgData));
            aVar.b(n.i.alert_no_button, new p(this, jVar));
            aVar.am(false);
            aVar.b(this.context.getOrignalPage().getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                jVar.x(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }

    public void a(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, com.baidu.tieba.hottopic.data.c cVar) {
        if (cVar != null && cVar.Us() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getOrignalPage().getPageContext().getPageActivity());
            com.baidu.tieba.hottopic.view.j jVar = new com.baidu.tieba.hottopic.view.j(this.context.getOrignalPage().getPageContext().getPageActivity());
            jVar.setData(shareFromTopicMsgData);
            aVar.bP(1);
            aVar.m(jVar);
            aVar.a(n.i.share, new q(this, jVar, j, str, str2, shareFromTopicMsgData));
            aVar.b(n.i.alert_no_button, new r(this, jVar));
            aVar.am(false);
            aVar.b(this.context.getOrignalPage().getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                jVar.x(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }
}
