package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends h {
    private com.baidu.tieba.d.b cEu;
    private d cqB;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cqB = this.cwW.agI();
    }

    private void akK() {
        if (this.cqB == null) {
            this.cqB = this.cwW.agI();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        akK();
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
        bh rG;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.i ahf = this.cwW.ahf();
        switch (i) {
            case 11001:
                this.cwW.iZ(0);
                return;
            case 11002:
                this.cqr.fg(true);
                return;
            case 11011:
                com.baidu.tieba.frs.g.i.a(this.cwW, this.cwW.getThreadId(), this.cwW.bie, this.cwW.agR());
                return;
            case 11012:
                com.baidu.tieba.frs.g.i.b(this.cwW, this.cwW.getThreadId(), this.cwW.bie, this.cwW.agR());
                return;
            case 11014:
                this.cqr.alX();
                return;
            case 11016:
                this.cqh.ahx();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cqr.alW();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cqB != null) {
                        this.cqB.b(postWriteCallBackData);
                    }
                    a(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.cqh.ahF().notifyDataSetChanged();
                if (this.cqr != null) {
                    this.cqr.aiC();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cwW.cl(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rG = ahf.rG(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rG.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rG.rW();
                    }
                    a(ahf, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.g.i.a(this.cwW.getPageContext(), ahf);
                return;
            case 23003:
                if (intent != null && ahf != null) {
                    com.baidu.tieba.frs.g.e.a(this.cwW, ahf, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                L(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.g.i.B(this.cwW);
                return;
            case 23019:
                com.baidu.tieba.frs.g.i.a(this.cwW, this.cwW.cpZ);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cwW.getForumId(), 0)) {
                        this.cqr.y(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (iVar != null && intent != null && !TextUtils.isEmpty(str) && this.cqq != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cqq.alc()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cFr.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        iVar.az(dataList);
                        this.cqh.a(dataList, iVar);
                        aX(str, this.cwW.getForumId());
                    }
                }
            }
        }
    }

    public static void aX(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ac("tid", str);
            akVar.ac("fid", str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData akL() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atv == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atv.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aty);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.att);
        shareFromPBMsgData.setThreadId(shareItem.WT);
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(akL(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cwW.getActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.cwW.getActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cwW.getActivity().getSystemService("input_method");
                    l.a(a.this.cwW.getActivity(), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cwW.getActivity(), j, str, str2, 0, jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ao() != null) {
                        Bundle Ao = shareItem.Ao();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Ao.getInt("obj_type")).r("obj_param1", 3).ac("fid", Ao.getString("fid")).ac("tid", Ao.getString("tid")));
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cwW.getActivity().getSystemService("input_method");
                    l.a(a.this.cwW.getActivity(), jVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(this.cwW.getPageContext()).tb();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cEu == null) {
            this.cEu = new com.baidu.tieba.d.b(this.cwW.getPageContext(), (ViewStub) this.cwW.getView().findViewById(d.h.write_share_viewStub));
        }
        this.cEu.a(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.cEu != null) {
            this.cEu.onDestroy();
        }
    }
}
