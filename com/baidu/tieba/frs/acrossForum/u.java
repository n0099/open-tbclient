package com.baidu.tieba.frs.acrossForum;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bh;
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
            } else if (bh.ai(tbPageContext.getPageActivity())) {
                com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
                fVar.title = acrossForumViewData.shareTitle;
                fVar.content = acrossForumViewData.shareAbstract;
                fVar.anq = true;
                fVar.extData = str;
                if (!StringUtils.isNull(acrossForumViewData.forumName)) {
                    fVar.linkUrl = TbConfig.HTTPS_FRS_PREFIX + URLEncoder.encode(acrossForumViewData.forumName);
                }
                if (!StringUtils.isNull(acrossForumViewData.sharePicURL)) {
                    fVar.imageUri = Uri.parse(acrossForumViewData.sharePicURL);
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
                shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new v(tbPageContext, str));
                shareDialogConfig.setCopyLinkListener(new w(fVar, tbPageContext));
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public static void a(BaseActivity baseActivity, Intent intent, AcrossForumViewData acrossForumViewData) {
        if (intent != null) {
            a(baseActivity, a(acrossForumViewData), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
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
        shareFromPBMsgData.setShareSourceUrl(TbConfig.HTTPS_FRS_PREFIX + acrossForumViewData.forumName);
        return shareFromPBMsgData;
    }

    private static void a(BaseActivity baseActivity, ShareFromPBMsgData shareFromPBMsgData, int i, String str, long j) {
        if (baseActivity != null && shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            ab abVar = new ab(baseActivity.getPageContext().getPageActivity());
            abVar.setData(shareFromPBMsgData);
            aVar.cd(1);
            aVar.z(abVar);
            aVar.a(r.j.share, new x(baseActivity, abVar, i, str, j, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new y(baseActivity, abVar));
            aVar.av(true);
            aVar.b(baseActivity.getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                abVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private static void a(BaseActivity baseActivity, ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (baseActivity != null && shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            ab abVar = new ab(baseActivity.getPageContext().getPageActivity());
            abVar.setData(shareFromPBMsgData);
            aVar.cd(1);
            aVar.z(abVar);
            aVar.a(r.j.share, new z(baseActivity, abVar, j, str, str2, shareFromPBMsgData));
            aVar.b(r.j.alert_no_button, new aa(baseActivity, abVar));
            aVar.av(true);
            aVar.b(baseActivity.getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                abVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }
}
