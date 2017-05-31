package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends w {
    private l bUw;

    public a(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bUw = this.bTw.ZW();
    }

    private void acO() {
        if (this.bUw == null) {
            this.bUw = this.bTw.ZW();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        acO();
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
        bl qf;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
        switch (i) {
            case 11001:
                this.bTw.ih(0);
                return;
            case 11002:
                this.bUk.ez(true);
                return;
            case 11011:
                com.baidu.tieba.frs.e.p.a(this.bTw, this.bTw.getThreadId(), this.bTw.bbF, this.bTw.aaf());
                return;
            case 11012:
                com.baidu.tieba.frs.e.p.b(this.bTw, this.bTw.getThreadId(), this.bTw.bbF, this.bTw.aaf());
                return;
            case 11014:
                this.bUk.aef();
                return;
            case 11016:
                this.bUa.aaJ();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bUk.aee();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bUw != null) {
                        this.bUw.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bUa.aaR().notifyDataSetChanged();
                if (this.bUk != null) {
                    this.bUk.abm();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bTw.ci(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (qf = aau.qf(stringExtra)) != null) {
                    if (intExtra == 2) {
                        qf.bT(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        qf.sc();
                    } else if (intExtra == 0) {
                        aau.W(qf);
                        this.bUa.aaK();
                        if (com.baidu.tieba.tbadkCore.c.bgf() != null) {
                            com.baidu.tieba.tbadkCore.c.bgf().S(this.bTw.getForumName(), false);
                        }
                    }
                    a(aau, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.e.p.a(this.bTw.getPageContext(), aau);
                return;
            case 23003:
                if (intent != null && aau != null) {
                    com.baidu.tieba.frs.e.h.a(this.bTw, aau, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.e.h.a(this.bTw, aau, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.e.p.y(this.bTw);
                return;
            case 23019:
                com.baidu.tieba.frs.e.p.a(this.bTw, this.bTw.bTR);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bTw.getForumId(), 0)) {
                        this.bUk.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bUj != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.bUj.adf()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.ceQ.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.ay(dataList);
                        this.bUa.a(dataList, nVar);
                        aL(str, this.bTw.getForumId());
                    }
                }
            }
        }
    }

    public static void aL(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as("c11959");
            asVar.Z("tid", str);
            asVar.Z("fid", str2);
            asVar.r("obj_type", 1);
            TiebaStatic.log(asVar);
        }
    }
}
