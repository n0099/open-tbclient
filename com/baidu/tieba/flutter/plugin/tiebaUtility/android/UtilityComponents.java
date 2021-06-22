package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.a.c.e.p.l;
import d.a.i.b0;
import d.a.n0.f0.h;
import d.a.n0.r.d0.b;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.e3.h0.e;
import d.a.o0.s2.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UtilityComponents implements TiebaUtilityComponentsAuto.HostUtilityComponents {
    public b0 mNegFeedBackItem;

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        h.i(agreeEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doAgreeAndDisagree(boolean z, JSONObject jSONObject, String str) {
        a2 a2Var = new a2();
        a2Var.U2(jSONObject);
        AgreeData L = a2Var.L();
        int i2 = 1;
        if (z) {
            TbPageContext pageContext = TbadkApplication.getInst().getCurrentActivity() != null ? ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext() : null;
            if (L.hasAgree) {
                if (L.agreeType == 2) {
                    L.agreeType = 2;
                    L.hasAgree = false;
                    L.agreeNum--;
                    if (!StringUtil.isEmpty(str)) {
                        L.objSource = str;
                    }
                    sendMesage(i2, L);
                } else {
                    L.agreeType = 2;
                    L.hasAgree = true;
                    L.agreeNum++;
                    a.g().l(pageContext);
                }
            } else {
                L.agreeType = 2;
                L.hasAgree = true;
                L.agreeNum++;
                a.g().l(pageContext);
            }
            i2 = 0;
            if (!StringUtil.isEmpty(str)) {
            }
            sendMesage(i2, L);
        } else {
            if (L.hasAgree) {
                if (L.agreeType == 5) {
                    L.agreeType = 5;
                    L.hasAgree = false;
                    NoNetworkView.f();
                    if (!StringUtil.isEmpty(str)) {
                        L.objSource = str;
                    }
                    sendMesage(i2, L);
                } else {
                    L.agreeType = 5;
                    L.hasAgree = true;
                    L.agreeNum--;
                }
            } else {
                L.agreeType = 5;
                L.hasAgree = true;
            }
            i2 = 0;
            if (!StringUtil.isEmpty(str)) {
            }
            sendMesage(i2, L);
        }
        e eVar = new e();
        eVar.f57811b = L;
        if (a2Var.V() != null) {
            L.nid = a2Var.V().oriUgcNid;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
        dispatchMutiProcessAgree(L, AgreeEvent.IS_THREAD);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void agreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam) {
        HashMap result = agreeThreadParam.getResult();
        if (result == null || result.get("item") == null || !(result.get("item") instanceof HashMap)) {
            return;
        }
        doAgreeAndDisagree(true, new JSONObject((HashMap) result.get("item")), result.get("obj_source") instanceof String ? (String) result.get("obj_source") : "");
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void delLikeForum(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        TbadkCoreApplication.getInst().delLikeForum(componentsStringValue.getResult());
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void deleteRecentlyVisitedForumHistory(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        String result = componentsStringValue.getResult();
        if (TextUtils.isEmpty(result)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921519, result));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void disagreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam) {
        HashMap result = agreeThreadParam.getResult();
        if (result == null || result.get("item") == null || !(result.get("item") instanceof HashMap)) {
            return;
        }
        doAgreeAndDisagree(false, new JSONObject((HashMap) result.get("item")), result.get("obj_source") instanceof String ? (String) result.get("obj_source") : "");
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getHistoryCount(final TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsStringValue> result) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        final boolean[] zArr = {false};
        if (currentActivity instanceof TbPageContextSupport) {
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(((TbPageContextSupport) currentActivity).getPageContext());
            pbHistoryCacheModel.O(new CacheModel.c<d.a.o0.x1.h.a>() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.UtilityComponents.1
                @Override // com.baidu.tbadk.mvc.model.CacheModel.c
                public void onCacheDataGet(ReadCacheRespMsg<List<d.a.o0.x1.h.a>> readCacheRespMsg, ReadCacheMessage<d.a.o0.x1.h.a> readCacheMessage) {
                    if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                        return;
                    }
                    List<d.a.o0.x1.h.a> data = readCacheRespMsg.getData();
                    if (zArr[0] || result == null) {
                        return;
                    }
                    TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue = new TiebaUtilityComponentsAuto.ComponentsStringValue();
                    componentsStringValue.setResult(String.valueOf(data.size()));
                    result.success(componentsStringValue);
                    zArr[0] = true;
                }

                @Override // com.baidu.tbadk.mvc.model.CacheModel.c
                public void onCacheDataWrite(WriteCacheRespMsg<List<d.a.o0.x1.h.a>> writeCacheRespMsg, WriteCacheMessage<d.a.o0.x1.h.a> writeCacheMessage) {
                }
            });
            pbHistoryCacheModel.L();
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getHistoryForumStr(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsStringValue> result) {
        TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue = new TiebaUtilityComponentsAuto.ComponentsStringValue();
        componentsStringValue.setResult((String) MessageManager.getInstance().runTask(2921483, String.class).getData());
        result.success(componentsStringValue);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getRecnbarShow(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        b j = b.j();
        boolean g2 = j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
        TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
        componentsBoolResult.setResult(Boolean.valueOf(g2));
        result.success(componentsBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void hasOfficialChat(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
        componentsBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.getInst().appResponseToCmd(2002006)));
        result.success(componentsBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void negativeFeedBack(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam, final TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        HashMap result2 = agreeThreadParam.getResult();
        if (result2 == null) {
            return;
        }
        if (result2.get("offsetXAndroid") != null) {
            Math.round(Float.parseFloat(String.valueOf(result2.get("offsetXAndroid"))));
        }
        int round = result2.get("offsetYAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(result2.get("offsetYAndroid")))) : 0;
        int round2 = result2.get("width") != null ? Math.round(Float.parseFloat(String.valueOf(result2.get("width")))) : 0;
        if (result2.get("item") != null) {
            JSONObject optJSONObject = new JSONObject((HashMap) result2.get("item")).optJSONObject("item");
            a2 a2Var = new a2();
            a2Var.U2(optJSONObject);
            v0 c2 = a2Var.c();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(16908290);
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
                if (viewGroup == null || tbPageContextSupport == null) {
                    return;
                }
                b0 b0Var = this.mNegFeedBackItem;
                if (b0Var != null && b0Var.b() != null) {
                    viewGroup.removeView(this.mNegFeedBackItem.b());
                }
                b0 b0Var2 = new b0(tbPageContextSupport.getPageContext(), Align.ALIGN_RIGHT_TOP);
                this.mNegFeedBackItem = b0Var2;
                b0Var2.u(new NEGFeedBackView.b() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.UtilityComponents.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
                        if (result != null) {
                            TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
                            componentsBoolResult.setResult(Boolean.TRUE);
                            result.success(componentsBoolResult);
                        }
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackWindowShow(v0 v0Var) {
                    }
                });
                this.mNegFeedBackItem.a(c2);
                int k = l.k(tbPageContextSupport.getPageContext().getPageActivity());
                if (Build.VERSION.SDK_INT >= 11) {
                    this.mNegFeedBackItem.b().setY(round - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 16.0f));
                    this.mNegFeedBackItem.b().setX((k - round2) - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 20.0f));
                }
                viewGroup.addView(this.mNegFeedBackItem.b(), this.mNegFeedBackItem.c());
                this.mNegFeedBackItem.b().setVisibility(4);
                d.a.c.e.m.e.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.UtilityComponents.3
                    @Override // java.lang.Runnable
                    public void run() {
                        UtilityComponents.this.mNegFeedBackItem.b().performClick();
                        UtilityComponents.this.mNegFeedBackItem.b().setVisibility(8);
                    }
                }, 150L);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void selectForumCategory(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921541, componentsStringValue.getResult()));
    }

    public void sendMesage(int i2, AgreeData agreeData) {
        if (agreeData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", agreeData.threadId);
        httpMessage.addParam("op_type", i2);
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", agreeData.objType);
        httpMessage.addParam("agree_type", agreeData.agreeType);
        httpMessage.addParam("forum_id", agreeData.forumId);
        if (!TextUtils.isEmpty(agreeData.postId)) {
            httpMessage.addParam("post_id", agreeData.postId);
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, agreeData.baijiahaoData.oriUgcType);
        }
        if (!StringUtil.isEmpty(agreeData.objSource)) {
            httpMessage.addParam("obj_source", agreeData.objSource);
        }
        httpMessage.setExtra(Integer.valueOf(i2));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void showRedDotForMyTab(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
        componentsBoolResult.setResult(Boolean.valueOf(d.a.o0.u2.a.v().z()));
        result.success(componentsBoolResult);
    }
}
