package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends i {
    private e cjs;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cjs = this.f5com.aeS();
    }

    private void air() {
        if (this.cjs == null) {
            this.cjs = this.f5com.aeS();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        air();
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
        bl rT;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.i afr = this.f5com.afr();
        switch (i) {
            case 11001:
                this.f5com.iC(0);
                return;
            case 11002:
                this.cjh.fb(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.f5com, this.f5com.getThreadId(), this.f5com.bgF, this.f5com.afb());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.f5com, this.f5com.getThreadId(), this.f5com.bgF, this.f5com.afb());
                return;
            case 11014:
                this.cjh.ajF();
                return;
            case 11016:
                this.ciX.afJ();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.cjh.ajE();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cjs != null) {
                        this.cjs.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.ciX.afR().notifyDataSetChanged();
                if (this.cjh != null) {
                    this.cjh.agr();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.f5com.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rT = afr.rT(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rT.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rT.sn();
                    }
                    a(afr, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.a(this.f5com.getPageContext(), afr);
                return;
            case 23003:
                if (intent != null && afr != null) {
                    com.baidu.tieba.frs.f.e.a(this.f5com, afr, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.f.e.a(this.f5com, afr, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.i.B(this.f5com);
                return;
            case 23019:
                com.baidu.tieba.frs.f.i.a(this.f5com, this.f5com.ciO);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.f5com.getForumId(), 0)) {
                        this.cjh.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (iVar != null && intent != null && !TextUtils.isEmpty(str) && this.cjg != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cjg.aiI()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cvn.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        iVar.aB(dataList);
                        this.ciX.a(dataList, iVar);
                        aS(str, this.f5com.getForumId());
                    }
                }
            }
        }
    }

    public static void aS(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            aj ajVar = new aj("c11959");
            ajVar.aa("tid", str);
            ajVar.aa("fid", str2);
            ajVar.r("obj_type", 1);
            TiebaStatic.log(ajVar);
        }
    }
}
