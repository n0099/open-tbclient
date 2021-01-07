package com.baidu.tieba.frs.d;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsPrivateShareDialogView;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class h {
    public static void a(final TbPageContext tbPageContext, final FrsViewData frsViewData, String str) {
        final String str2;
        Uri parse;
        if (tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
            if (frsViewData.getForum().getName() == null || frsViewData.getForum().getId() == null) {
                tbPageContext.showToast(tbPageContext.getString(R.string.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            ForumData forum = frsViewData.getForum();
            String encode = URLEncoder.encode(name);
            if (!TextUtils.isEmpty(forum.forum_share_link)) {
                str2 = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
            } else {
                str2 = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
            }
            Uri parse2 = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            final ShareItem shareItem = new ShareItem();
            shareItem.title = name + tbPageContext.getString(R.string.forum);
            shareItem.content = slogan;
            shareItem.linkUrl = str2;
            shareItem.fwX = true;
            shareItem.fxo = 10;
            shareItem.extData = str;
            if (parse2 != null) {
                shareItem.imageUri = parse2;
            }
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = name + tbPageContext.getString(R.string.forum);
            shareItem2.content = slogan;
            shareItem2.linkUrl = str2;
            shareItem2.fwX = true;
            shareItem2.fxo = 10;
            shareItem2.extData = str;
            shareItem2.fName = frsViewData.getForum().getName();
            String str3 = frsViewData.getForum().getfShareImage();
            if (StringUtils.isNull(str3)) {
                shareItem2.typeShareToSmallApp = 4;
                shareItem2.fid = frsViewData.getForum().getId();
                parse = parse2;
            } else {
                parse = Uri.parse(str3);
                shareItem2.typeShareToSmallApp = 2;
            }
            if (parse2 != null) {
                shareItem2.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
            shareDialogConfig.setHasSpecialItem(true);
            shareDialogConfig.setSpecialShareItems(3, shareItem2);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCustomCopyTitle(R.string.copy_link);
            shareDialogConfig.addOutsideTextView(R.string.poster_share, R.drawable.icon_pure_share_poster40, new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("fid", ShareItem.this.extData).an("obj_type", 18).an("obj_source", 10));
                    FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                    if (frsPrivateShareDialogView.a(frsViewData, tbPageContext, aVar)) {
                        aVar.pd(2);
                        aVar.br(frsPrivateShareDialogView);
                        aVar.b(tbPageContext).btY();
                    }
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(str2);
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void b(TbPageContext tbPageContext, FrsViewData frsViewData) {
        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        if (frsPrivateShareDialogView.a(frsViewData, tbPageContext, aVar)) {
            aVar.pd(2);
            aVar.br(frsPrivateShareDialogView);
            aVar.b(tbPageContext).btY();
        }
    }

    private static ShareFromFrsMsgData i(FrsViewData frsViewData) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
        shareFromFrsMsgData.setName(frsViewData.getForum().getName());
        shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
        shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
        shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final FrsFragment frsFragment, FrsViewData frsViewData, final long j, final String str, final long j2) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            final ShareFromFrsMsgData i = i(frsViewData);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsFragment.getPageContext().getPageActivity());
            final FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
            frsShareCardView.setPageId(frsFragment.getUniqueId());
            frsShareCardView.setData(i);
            aVar.pd(1);
            aVar.br(frsShareCardView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.d.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(FrsFragment.this.getTbPageContext().getPageActivity(), j, str, j2, "from_share", frsShareCardView.getLeaveMsg(), i.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.d.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jI(true);
            aVar.b(frsFragment.getPageContext()).btY();
            if (!com.baidu.adp.lib.util.k.isEmpty(i.getImageUrl())) {
                frsShareCardView.aQ(i.getImageUrl(), false);
            }
        }
    }
}
