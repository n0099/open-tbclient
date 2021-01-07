package com.baidu.tieba.NEGFeedBack;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
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
            AntiData cDZ = com.baidu.tieba.frs.b.cDY().cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bz> cDV = com.baidu.tieba.frs.b.cDY().cDV();
            for (int i2 = 0; i2 < cDV.size(); i2++) {
                jSONArray.put(cDV.get(i2).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.oA(gVar.getType());
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cDY().getForumId());
            iVar.setData(atVar);
            iVar.setDefaultReasonArray(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            iVar.Fg("1");
            iVar.a(new i.b() { // from class: com.baidu.tieba.NEGFeedBack.d.1
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray2) {
                    if (j.isNetworkAvailableForImmediately()) {
                        d.a(jSONArray2, gVar.bNQ(), gVar.bNP());
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
            AntiData cDZ = com.baidu.tieba.frs.b.cDY().cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bz> cDV = com.baidu.tieba.frs.b.cDY().cDV();
            for (int i2 = 0; i2 < cDV.size(); i2++) {
                jSONArray.put(cDV.get(i2).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.oA(gVar.getType());
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cDY().getForumId());
            fVar.setData(atVar);
            fVar.setDefaultReasonArray(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            fVar.Fg("1");
            fVar.a(new f.b() { // from class: com.baidu.tieba.NEGFeedBack.d.2
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray2) {
                    if (j.isNetworkAvailableForImmediately()) {
                        d.a(jSONArray2, gVar.bNQ(), gVar.bNP());
                    } else {
                        l.showToast(TbPageContext.this.getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(JSONArray jSONArray, ForumManageModel forumManageModel, bz bzVar) {
        if (forumManageModel != null && bzVar != null && bzVar.brr() != null) {
            String userId = bzVar.brr().getUserId();
            String id = bzVar.getId();
            String brv = bzVar.brv();
            String valueOf = String.valueOf(bzVar.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                forumManageModel.TC(com.baidu.tbadk.core.util.at.S(jSONArray));
            }
            forumManageModel.a(valueOf, brv, id, null, 0, 1, isCurrentAccount, bzVar.getBaijiahaoData());
        }
    }
}
