package com.baidu.tieba.hottopic.controller;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.view.ShareCardView;
import java.net.URLEncoder;
/* loaded from: classes15.dex */
public class b {
    private BaseActivity<?> iJv;
    private SparseArray<String> iJw = null;

    public b(BaseActivity<?> baseActivity) {
        this.iJv = baseActivity;
    }

    private SparseArray<String> aTh() {
        if (this.iJw == null) {
            this.iJw = new SparseArray<>(8);
            this.iJw.put(2, "topic_wx_timeline");
            this.iJw.put(3, "topic_wx_friend");
            this.iJw.put(4, "topic_qq_zone");
            this.iJw.put(5, "topic_tencent_weibo");
            this.iJw.put(6, "topic_sina_weibo");
        }
        return this.iJw;
    }

    public void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            this.iJv.showToast(this.iJv.getActivity().getString(R.string.no_hot_topic_data));
            return;
        }
        if (StringUtils.isNull(str3)) {
            str3 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + str + "&topic_name=" + URLEncoder.encode(str2);
        }
        Uri parse = StringUtils.isNull(str4) ? null : Uri.parse(str4);
        final ShareItem shareItem = new ShareItem();
        shareItem.title = str2;
        shareItem.content = str5;
        shareItem.linkUrl = str3;
        shareItem.etD = true;
        shareItem.extData = str;
        shareItem.imageUri = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.iJv.getActivity(), shareItem, true, aTh());
        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.controller.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                l.showToast(b.this.iJv.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        });
        shareDialogConfig.setIsCopyLink(true);
        this.iJv.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
    }

    public void a(final ShareFromTopicMsgData shareFromTopicMsgData, final long j, final String str, final long j2, e eVar) {
        if (eVar != null && eVar.cpf() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJv.getActivity());
            final ShareCardView shareCardView = new ShareCardView(this.iJv.getActivity());
            shareCardView.setData(shareFromTopicMsgData);
            aVar.lq(1);
            aVar.aV(shareCardView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.hottopic.controller.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ((InputMethodManager) b.this.iJv.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(shareCardView.getChatMsgView().getWindowToken(), 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.iJv.getActivity(), j, str, j2, "from_share", shareCardView.getLeaveMsg(), shareFromTopicMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.controller.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ((InputMethodManager) b.this.iJv.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(shareCardView.getChatMsgView().getWindowToken(), 2);
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iJv.getPageContext()).aYL();
            if (!k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                shareCardView.aF(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }

    public void a(final ShareFromTopicMsgData shareFromTopicMsgData, final long j, final String str, final String str2, final String str3, e eVar) {
        if (eVar != null && eVar.cpf() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJv.getActivity());
            final ShareCardView shareCardView = new ShareCardView(this.iJv.getActivity());
            shareCardView.setData(shareFromTopicMsgData);
            aVar.lq(1);
            aVar.aV(shareCardView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.hottopic.controller.b.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ((InputMethodManager) b.this.iJv.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(shareCardView.getChatMsgView().getWindowToken(), 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.iJv.getActivity(), j, str, str2, str3, 0, shareCardView.getLeaveMsg(), shareFromTopicMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.controller.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ((InputMethodManager) b.this.iJv.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(shareCardView.getChatMsgView().getWindowToken(), 2);
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iJv.getPageContext()).aYL();
            if (!k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
                shareCardView.aF(shareFromTopicMsgData.getImageUrl(), false);
            }
        }
    }
}
