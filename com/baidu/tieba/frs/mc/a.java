package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends w {
    private l bNe;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.bNe = this.bST.YR();
    }

    private void acF() {
        if (this.bNe == null) {
            this.bNe = this.bST.YR();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        acF();
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
        bi pR;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
        switch (i) {
            case 11001:
                this.bST.hM(0);
                return;
            case 11002:
                this.bMP.el(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.t.a(this.bST, this.bST.getThreadId(), this.bST.aRV, this.bST.Zc());
                return;
            case 11012:
                com.baidu.tieba.frs.f.t.b(this.bST, this.bST.getThreadId(), this.bST.aRV, this.bST.Zc());
                return;
            case 11014:
                this.bMP.aeb();
                return;
            case 11016:
                this.bMD.ZX();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bMP.Zu();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bNe != null) {
                        this.bNe.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bMD.aae().notifyDataSetChanged();
                if (this.bMP != null) {
                    this.bMP.aaW();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bST.cj(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (pR = Zr.pR(stringExtra)) != null) {
                    if (intExtra == 2) {
                        pR.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        pR.sW();
                    } else if (intExtra == 0) {
                        Zr.I(pR);
                        this.bMD.ZY();
                        if (com.baidu.tieba.tbadkCore.c.bgh() != null) {
                            com.baidu.tieba.tbadkCore.c.bgh().V(this.bST.getForumName(), false);
                        }
                    }
                    a(Zr, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.t.b(this.bST, Zr);
                return;
            case 23003:
                if (intent != null && Zr != null) {
                    com.baidu.tieba.frs.f.j.a(this.bST, Zr, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.f.j.a(this.bST, Zr, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.t.E(this.bST);
                return;
            case 23019:
                com.baidu.tieba.frs.f.t.b(this.bST, this.bST.bMt);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bST.getForumId(), 0)) {
                        this.bMP.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bMO != null && this.bMQ != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.bMO.acW() && this.bMQ.aef() != null && this.bMQ.aef().aaK() != null && this.bMQ.aef().aaK().fU()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.bYv.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.ax(dataList);
                        this.bMD.a(dataList, nVar);
                        aO(str, this.bST.getForumId());
                    }
                }
            }
        }
    }

    public static void aO(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as("c11959");
            asVar.aa("tid", str);
            asVar.aa("fid", str2);
            asVar.s("obj_type", 1);
            TiebaStatic.log(asVar);
        }
    }
}
