package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends w {
    private l bOJ;

    public a(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bOJ = this.bNK.YS();
    }

    private void abK() {
        if (this.bOJ == null) {
            this.bOJ = this.bNK.YS();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        abK();
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
        bk pR;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
        switch (i) {
            case 11001:
                this.bNK.hJ(0);
                return;
            case 11002:
                this.bOx.ej(true);
                return;
            case 11011:
                com.baidu.tieba.frs.d.p.a(this.bNK, this.bNK.getThreadId(), this.bNK.aSs, this.bNK.Zb());
                return;
            case 11012:
                com.baidu.tieba.frs.d.p.b(this.bNK, this.bNK.getThreadId(), this.bNK.aSs, this.bNK.Zb());
                return;
            case 11014:
                this.bOx.adc();
                return;
            case 11016:
                this.bOn.ZG();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bOx.adb();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bOJ != null) {
                        this.bOJ.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bOn.ZO().notifyDataSetChanged();
                if (this.bOx != null) {
                    this.bOx.aak();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bNK.ch(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (pR = Zq.pR(stringExtra)) != null) {
                    if (intExtra == 2) {
                        pR.bS(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        pR.sg();
                    } else if (intExtra == 0) {
                        Zq.M(pR);
                        this.bOn.ZH();
                        if (com.baidu.tieba.tbadkCore.c.beL() != null) {
                            com.baidu.tieba.tbadkCore.c.beL().V(this.bNK.getForumName(), false);
                        }
                    }
                    a(Zq, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.d.p.a(this.bNK.getPageContext(), Zq);
                return;
            case 23003:
                if (intent != null && Zq != null) {
                    com.baidu.tieba.frs.d.h.a(this.bNK, Zq, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.d.h.a(this.bNK, Zq, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.d.p.y(this.bNK);
                return;
            case 23019:
                com.baidu.tieba.frs.d.p.a(this.bNK, this.bNK.bOe);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bNK.getForumId(), 0)) {
                        this.bOx.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bOw != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.bOw.acb()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.bYE.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.ay(dataList);
                        this.bOn.a(dataList, nVar);
                        aN(str, this.bNK.getForumId());
                    }
                }
            }
        }
    }

    public static void aN(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as("c11959");
            asVar.aa("tid", str);
            asVar.aa("fid", str2);
            asVar.s("obj_type", 1);
            TiebaStatic.log(asVar);
        }
    }
}
