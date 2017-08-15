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
    private e ckf;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.ckf = this.coU.afo();
    }

    private void aiY() {
        if (this.ckf == null) {
            this.ckf = this.coU.afo();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aiY();
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
        bl rV;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.i afN = this.coU.afN();
        switch (i) {
            case 11001:
                this.coU.iE(0);
                return;
            case 11002:
                this.cjU.fe(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.coU, this.coU.getThreadId(), this.coU.bgF, this.coU.afx());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.coU, this.coU.getThreadId(), this.coU.bgF, this.coU.afx());
                return;
            case 11014:
                this.cjU.akl();
                return;
            case 11016:
                this.cjK.agg();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.cjU.akk();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.ckf != null) {
                        this.ckf.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.cjK.ago().notifyDataSetChanged();
                if (this.cjU != null) {
                    this.cjU.agM();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.coU.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rV = afN.rV(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rV.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rV.sn();
                    }
                    a(afN, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.a(this.coU.getPageContext(), afN);
                return;
            case 23003:
                if (intent != null && afN != null) {
                    com.baidu.tieba.frs.f.e.a(this.coU, afN, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.f.e.a(this.coU, afN, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.i.B(this.coU);
                return;
            case 23019:
                com.baidu.tieba.frs.f.i.a(this.coU, this.coU.cjB);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.coU.getForumId(), 0)) {
                        this.cjU.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (iVar != null && intent != null && !TextUtils.isEmpty(str) && this.cjT != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cjT.ajp()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cxq.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        iVar.aB(dataList);
                        this.cjK.a(dataList, iVar);
                        aT(str, this.coU.getForumId());
                    }
                }
            }
        }
    }

    public static void aT(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            aj ajVar = new aj("c11959");
            ajVar.aa("tid", str);
            ajVar.aa("fid", str2);
            ajVar.r("obj_type", 1);
            TiebaStatic.log(ajVar);
        }
    }
}
