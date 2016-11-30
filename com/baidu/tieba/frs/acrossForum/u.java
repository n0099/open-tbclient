package com.baidu.tieba.frs.acrossForum;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.r;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class u {
    public static void a(TbPageContext tbPageContext, AcrossForumViewData acrossForumViewData, String str) {
        if (tbPageContext != null) {
            com.baidu.tieba.frs.utils.j.from = 2;
            if (acrossForumViewData == null) {
                tbPageContext.showToast(tbPageContext.getString(r.j.no_forum_data));
            } else if (bk.ak(tbPageContext.getPageActivity())) {
                com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
                fVar.title = acrossForumViewData.shareTitle;
                fVar.content = acrossForumViewData.shareAbstract;
                fVar.anO = true;
                fVar.extData = str;
                if (!StringUtils.isNull(acrossForumViewData.forumName)) {
                    fVar.linkUrl = "http://tieba.baidu.com/f?kw=" + URLEncoder.encode(acrossForumViewData.forumName);
                }
                if (!StringUtils.isNull(acrossForumViewData.sharePicURL)) {
                    fVar.imageUri = Uri.parse(acrossForumViewData.sharePicURL);
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
                shareDialogConfig.addOutsideTextView(r.j.share_tieba_qunzu, r.f.icon_unite_share_qunzu, new v(tbPageContext, str));
                shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new w(tbPageContext, str));
                shareDialogConfig.setCopyLinkListener(new x(fVar, tbPageContext));
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public static void a(BaseActivity baseActivity, Intent intent, AcrossForumViewData acrossForumViewData) {
        if (intent != null) {
            a(baseActivity, a(acrossForumViewData), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
        }
    }

    public static void b(BaseActivity baseActivity, Intent intent, AcrossForumViewData acrossForumViewData) {
        if (intent != null) {
            a(baseActivity, a(acrossForumViewData), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
        }
    }

    public static ShareFromPBMsgData a(AcrossForumViewData acrossForumViewData) {
        if (acrossForumViewData == null) {
            return null;
        }
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setContent(acrossForumViewData.shareAbstract);
        shareFromPBMsgData.setImageUrl(acrossForumViewData.sharePicURL);
        shareFromPBMsgData.setTitle(acrossForumViewData.shareTitle);
        shareFromPBMsgData.setShareSourceUrl("http://tieba.baidu.com/f?kw=" + acrossForumViewData.forumName);
        return shareFromPBMsgData;
    }

    private static void a(BaseActivity baseActivity, ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (baseActivity != null && shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            ac acVar = new ac(baseActivity.getPageContext().getPageActivity());
            acVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(acVar);
            aVar.a(r.j.share, new y(baseActivity, acVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new z(baseActivity, acVar));
            aVar.au(true);
            aVar.b(baseActivity.getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                acVar.F(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private static void a(BaseActivity baseActivity, ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (baseActivity != null && shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            ac acVar = new ac(baseActivity.getPageContext().getPageActivity());
            acVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.z(acVar);
            aVar.a(r.j.share, new aa(baseActivity, acVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new ab(baseActivity, acVar));
            aVar.au(true);
            aVar.b(baseActivity.getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                acVar.F(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }
}
