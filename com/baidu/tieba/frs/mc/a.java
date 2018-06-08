package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends h {
    private d dhY;
    private com.baidu.tieba.c.f dxn;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.dhY = this.dxw.atk();
    }

    private void ayl() {
        if (this.dhY == null) {
            this.dhY = this.dxw.atk();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ayl();
        if (i2 == -1) {
            c(i, intent);
        } else if (i2 == 0) {
            b(i, intent);
        }
    }

    private void b(int i, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
            default:
                return;
        }
    }

    private void c(int i, Intent intent) {
        bd mD;
        PostWriteCallBackData postWriteCallBackData;
        l atI = this.dxw.atI();
        switch (i) {
            case 11001:
                this.dxw.ke(0);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED /* 11002 */:
                this.dhO.gd(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.dxw, this.dxw.getThreadId(), this.dxw.bso, this.dxw.att());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.dxw, this.dxw.getThreadId(), this.dxw.bso, this.dxw.att());
                return;
            case 11014:
                this.dhO.azx();
                return;
            case 11016:
                this.dhC.auq();
                return;
            case 11033:
            case 23013:
            case 23019:
            default:
                return;
            case 11036:
                this.dhO.azw();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dhY != null) {
                        this.dhY.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.dhC.aux().notifyDataSetChanged();
                if (this.dhO != null) {
                    this.dhO.avu();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.dxw.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (mD = atI.mD(stringExtra)) != null) {
                    if (intExtra == 2) {
                        mD.bT(intent.getIntExtra("good_data", 0));
                        mD.vT();
                    }
                    a(atI, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.b(this.dxw.getPageContext(), atI);
                return;
            case 23003:
                if (intent != null && atI != null) {
                    com.baidu.tieba.frs.f.e.a(this.dxw, atI, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                J(intent);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.dxw.getForumId(), 0)) {
                        this.dhO.A(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.dxw.mu(intent.getStringExtra("tid"));
                    return;
                }
                return;
        }
    }

    private void a(l lVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.h> dataList;
        if (lVar != null && intent != null && !TextUtils.isEmpty(str) && this.dhN != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dhN.ayD()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.dyu.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        lVar.av(dataList);
                        this.dhC.a(dataList, lVar);
                        bd(str, this.dxw.getForumId());
                    }
                }
            }
        }
    }

    public static void bd(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            am amVar = new am("c11959");
            amVar.ah("tid", str);
            amVar.ah(ImageViewerConfig.FORUM_ID, str2);
            amVar.r("obj_type", 1);
            TiebaStatic.log(amVar);
        }
    }

    private ShareFromPBMsgData aym() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.aFj == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.aFj.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aFm);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aFh);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aym(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dxw.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.dxw.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dxw.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.dxw.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.dxw.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Fl() != null) {
                        Bundle Fl = shareItem.Fl();
                        TiebaStatic.log(new am("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Fl.getInt("obj_type")).r("obj_param1", 3).ah(ImageViewerConfig.FORUM_ID, Fl.getString(ImageViewerConfig.FORUM_ID)).ah("tid", Fl.getString("tid")));
                    }
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dxw.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.dxw.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.av(true);
            aVar.b(this.dxw.getPageContext()).xa();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.dxw.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dxn == null) {
            this.dxn = new com.baidu.tieba.c.f(this.dxw.getPageContext(), (NavigationBarCoverTip) this.dxw.getView().findViewById(d.g.navigation_cover_tip));
        }
        if (this.dxw.atI() != null && this.dxw.atI().bam() != null && this.dxw.atI().bam().isLike() == 1) {
            this.dxn.eL(true);
        } else {
            this.dxn.eL(false);
        }
        this.dxn.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.dxn != null) {
            this.dxn.onDestroy();
        }
    }
}
