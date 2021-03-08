package com.baidu.tieba.NEGFeedBack;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes.dex */
public class d {
    public static void a(int i, TbPageContext tbPageContext, g gVar, h hVar, UserData userData) {
        if (1 == i) {
            a(tbPageContext, gVar, hVar, userData);
        } else {
            a(tbPageContext, gVar);
        }
    }

    private static void a(final TbPageContext tbPageContext, final g gVar, h hVar, UserData userData) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            i iVar = new i(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), hVar, userData);
            AntiData cBF = com.baidu.tieba.frs.b.cBE().cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<cb> cBB = com.baidu.tieba.frs.b.cBE().cBB();
            for (int i2 = 0; i2 < cBB.size(); i2++) {
                jSONArray.put(cBB.get(i2).getTid());
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            avVar.mY(gVar.getType());
            avVar.P(jSONArray);
            avVar.setFid(com.baidu.tieba.frs.b.cBE().getForumId());
            iVar.setData(avVar);
            iVar.setDefaultReasonArray(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            iVar.Ey("1");
            iVar.a(new i.b() { // from class: com.baidu.tieba.NEGFeedBack.d.1
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray2) {
                    if (j.isNetworkAvailableForImmediately()) {
                        d.a(jSONArray2, gVar.bKB(), gVar.bKA());
                    } else {
                        l.showToast(TbPageContext.this.getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    private static void a(final TbPageContext tbPageContext, final g gVar) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            f fVar = new f(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            AntiData cBF = com.baidu.tieba.frs.b.cBE().cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<cb> cBB = com.baidu.tieba.frs.b.cBE().cBB();
            for (int i2 = 0; i2 < cBB.size(); i2++) {
                jSONArray.put(cBB.get(i2).getTid());
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            avVar.mY(gVar.getType());
            avVar.P(jSONArray);
            avVar.setFid(com.baidu.tieba.frs.b.cBE().getForumId());
            fVar.setData(avVar);
            fVar.setDefaultReasonArray(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            fVar.Ey("1");
            fVar.a(new f.b() { // from class: com.baidu.tieba.NEGFeedBack.d.2
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray2) {
                    if (j.isNetworkAvailableForImmediately()) {
                        d.a(jSONArray2, gVar.bKB(), gVar.bKA());
                    } else {
                        l.showToast(TbPageContext.this.getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(JSONArray jSONArray, ForumManageModel forumManageModel, cb cbVar) {
        if (forumManageModel != null && cbVar != null && cbVar.bnS() != null) {
            String userId = cbVar.bnS().getUserId();
            String id = cbVar.getId();
            String bnW = cbVar.bnW();
            String valueOf = String.valueOf(cbVar.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                forumManageModel.TL(au.R(jSONArray));
            }
            forumManageModel.a(valueOf, bnW, id, null, 0, 1, isCurrentAccount, cbVar.getBaijiahaoData());
        }
    }
}
