package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.l;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends i {
    private e cqr;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cqr = this.cws.agR();
    }

    private void akL() {
        if (this.cqr == null) {
            this.cqr = this.cws.agR();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        akL();
        if (i2 == -1) {
            c(i, intent);
        } else if (i2 == 0) {
            b(i, intent);
        }
    }

    private void b(int i, Intent intent) {
        switch (i) {
            case 12003:
            default:
                return;
        }
    }

    private void c(int i, Intent intent) {
        bj rX;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.i ahq = this.cws.ahq();
        switch (i) {
            case 11001:
                this.cws.iS(0);
                return;
            case 11002:
                this.cqg.fn(true);
                return;
            case 11011:
                com.baidu.tieba.frs.g.i.a(this.cws, this.cws.getThreadId(), this.cws.bgF, this.cws.aha());
                return;
            case 11012:
                com.baidu.tieba.frs.g.i.b(this.cws, this.cws.getThreadId(), this.cws.bgF, this.cws.aha());
                return;
            case 11014:
                this.cqg.alY();
                return;
            case 11016:
                this.cpW.ahJ();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cqg.alX();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cqr != null) {
                        this.cqr.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.cpW.ahR().notifyDataSetChanged();
                if (this.cqg != null) {
                    this.cqg.aiD();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cws.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rX = ahq.rX(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rX.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rX.sj();
                    }
                    a(ahq, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.g.i.a(this.cws.getPageContext(), ahq);
                return;
            case 23003:
                if (intent != null && ahq != null) {
                    com.baidu.tieba.frs.g.e.a(this.cws, ahq, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                N(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.g.i.A(this.cws);
                return;
            case 23019:
                com.baidu.tieba.frs.g.i.a(this.cws, this.cws.cpN);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cws.getForumId(), 0)) {
                        this.cqg.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (iVar != null && intent != null && !TextUtils.isEmpty(str) && this.cqf != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cqf.ald()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cEK.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        iVar.aA(dataList);
                        this.cpW.a(dataList, iVar);
                        aY(str, this.cws.getForumId());
                    }
                }
            }
        }
    }

    public static void aY(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ad("tid", str);
            akVar.ad("fid", str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData akM() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.auz == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.auz.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.auC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aux);
        shareFromPBMsgData.setThreadId(shareItem.Xe);
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        a(akM(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cws.getActivity());
            final l lVar = new l(this.cws.getActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(lVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cws.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.k.a(a.this.cws.getActivity(), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cws.getActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.AW() != null) {
                        Bundle AW = shareItem.AW();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", AW.getInt("obj_type")).r("obj_param1", 3).ad("fid", AW.getString("fid")).ad("tid", AW.getString("tid")));
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cws.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.k.a(a.this.cws.getActivity(), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(this.cws.getPageContext()).to();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.L(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }
}
