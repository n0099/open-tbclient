package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.k.b0;
import d.a.p0.h0.h;
import d.a.p0.s.d0.b;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import d.a.q0.h3.h0.e;
import d.a.q0.v2.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UtilityComponents implements TiebaUtilityComponentsAuto.HostUtilityComponents {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0 mNegFeedBackItem;

    public UtilityComponents() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, agreeData, str) == null) {
            AgreeEvent agreeEvent = new AgreeEvent();
            agreeEvent.agreeData = agreeData;
            agreeEvent.agreeExtra = str;
            h.i(agreeEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doAgreeAndDisagree(boolean z, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), jSONObject, str}) == null) {
            b2 b2Var = new b2();
            b2Var.J2(jSONObject);
            AgreeData z2 = b2Var.z();
            int i2 = 1;
            if (z) {
                TbPageContext pageContext = TbadkApplication.getInst().getCurrentActivity() != null ? ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext() : null;
                if (z2.hasAgree) {
                    if (z2.agreeType == 2) {
                        z2.agreeType = 2;
                        z2.hasAgree = false;
                        z2.agreeNum--;
                        if (!StringUtil.isEmpty(str)) {
                            z2.objSource = str;
                        }
                        sendMesage(i2, z2);
                    } else {
                        z2.agreeType = 2;
                        z2.hasAgree = true;
                        z2.agreeNum++;
                        a.g().l(pageContext);
                    }
                } else {
                    z2.agreeType = 2;
                    z2.hasAgree = true;
                    z2.agreeNum++;
                    a.g().l(pageContext);
                }
                i2 = 0;
                if (!StringUtil.isEmpty(str)) {
                }
                sendMesage(i2, z2);
            } else {
                if (z2.hasAgree) {
                    if (z2.agreeType == 5) {
                        z2.agreeType = 5;
                        z2.hasAgree = false;
                        NoNetworkView.f();
                        if (!StringUtil.isEmpty(str)) {
                            z2.objSource = str;
                        }
                        sendMesage(i2, z2);
                    } else {
                        z2.agreeType = 5;
                        z2.hasAgree = true;
                        z2.agreeNum--;
                    }
                } else {
                    z2.agreeType = 5;
                    z2.hasAgree = true;
                }
                i2 = 0;
                if (!StringUtil.isEmpty(str)) {
                }
                sendMesage(i2, z2);
            }
            e eVar = new e();
            eVar.f58547b = z2;
            if (b2Var.J() != null) {
                z2.nid = b2Var.J().oriUgcNid;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            dispatchMutiProcessAgree(z2, AgreeEvent.IS_THREAD);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void agreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam) {
        HashMap result;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, agreeThreadParam) == null) || (result = agreeThreadParam.getResult()) == null || result.get("item") == null || !(result.get("item") instanceof HashMap)) {
            return;
        }
        doAgreeAndDisagree(true, new JSONObject((HashMap) result.get("item")), result.get("obj_source") instanceof String ? (String) result.get("obj_source") : "");
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void delLikeForum(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentsStringValue) == null) {
            TbadkCoreApplication.getInst().delLikeForum(componentsStringValue.getResult());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void deleteRecentlyVisitedForumHistory(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentsStringValue) == null) {
            String result = componentsStringValue.getResult();
            if (TextUtils.isEmpty(result)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921519, result));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void disagreeThread(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam) {
        HashMap result;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeThreadParam) == null) || (result = agreeThreadParam.getResult()) == null || result.get("item") == null || !(result.get("item") instanceof HashMap)) {
            return;
        }
        doAgreeAndDisagree(false, new JSONObject((HashMap) result.get("item")), result.get("obj_source") instanceof String ? (String) result.get("obj_source") : "");
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getHistoryCount(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsStringValue> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            boolean[] zArr = {false};
            if (currentActivity instanceof TbPageContextSupport) {
                PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(((TbPageContextSupport) currentActivity).getPageContext());
                pbHistoryCacheModel.O(new CacheModel.c<d.a.q0.a2.h.a>(this, zArr, result) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UtilityComponents this$0;
                    public final /* synthetic */ boolean[] val$issubmitted;
                    public final /* synthetic */ TiebaUtilityComponentsAuto.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, zArr, result};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$issubmitted = zArr;
                        this.val$result = result;
                    }

                    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
                    public void onCacheDataGet(ReadCacheRespMsg<List<d.a.q0.a2.h.a>> readCacheRespMsg, ReadCacheMessage<d.a.q0.a2.h.a> readCacheMessage) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) || readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                            return;
                        }
                        List<d.a.q0.a2.h.a> data = readCacheRespMsg.getData();
                        if (this.val$issubmitted[0] || this.val$result == null) {
                            return;
                        }
                        TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue = new TiebaUtilityComponentsAuto.ComponentsStringValue();
                        componentsStringValue.setResult(String.valueOf(data.size()));
                        this.val$result.success(componentsStringValue);
                        this.val$issubmitted[0] = true;
                    }

                    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
                    public void onCacheDataWrite(WriteCacheRespMsg<List<d.a.q0.a2.h.a>> writeCacheRespMsg, WriteCacheMessage<d.a.q0.a2.h.a> writeCacheMessage) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
                        }
                    }
                });
                pbHistoryCacheModel.L();
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getHistoryForumStr(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsStringValue> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, result) == null) {
            TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue = new TiebaUtilityComponentsAuto.ComponentsStringValue();
            componentsStringValue.setResult((String) MessageManager.getInstance().runTask(2921483, String.class).getData());
            result.success(componentsStringValue);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void getRecnbarShow(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, result) == null) {
            b j = b.j();
            boolean g2 = j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
            TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
            componentsBoolResult.setResult(Boolean.valueOf(g2));
            result.success(componentsBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void hasOfficialChat(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, result) == null) {
            TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
            componentsBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.getInst().appResponseToCmd(2002006)));
            result.success(componentsBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void negativeFeedBack(TiebaUtilityComponentsAuto.AgreeThreadParam agreeThreadParam, TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        HashMap result2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, agreeThreadParam, result) == null) || (result2 = agreeThreadParam.getResult()) == null) {
            return;
        }
        if (result2.get("offsetXAndroid") != null) {
            Math.round(Float.parseFloat(String.valueOf(result2.get("offsetXAndroid"))));
        }
        int round = result2.get("offsetYAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(result2.get("offsetYAndroid")))) : 0;
        int round2 = result2.get("width") != null ? Math.round(Float.parseFloat(String.valueOf(result2.get("width")))) : 0;
        if (result2.get("item") != null) {
            JSONObject optJSONObject = new JSONObject((HashMap) result2.get("item")).optJSONObject("item");
            b2 b2Var = new b2();
            b2Var.J2(optJSONObject);
            w0 negFeedBackData = b2Var.getNegFeedBackData();
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
                b0Var2.u(new NEGFeedBackView.b(this, result) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UtilityComponents this$0;
                    public final /* synthetic */ TiebaUtilityComponentsAuto.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, result};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$result = result;
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
                        }
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || this.val$result == null) {
                            return;
                        }
                        TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
                        componentsBoolResult.setResult(Boolean.TRUE);
                        this.val$result.success(componentsBoolResult);
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackWindowShow(w0 w0Var) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) {
                        }
                    }
                });
                this.mNegFeedBackItem.a(negFeedBackData);
                int k = l.k(tbPageContextSupport.getPageContext().getPageActivity());
                if (Build.VERSION.SDK_INT >= 11) {
                    this.mNegFeedBackItem.b().setY(round - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 16.0f));
                    this.mNegFeedBackItem.b().setX((k - round2) - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 20.0f));
                }
                viewGroup.addView(this.mNegFeedBackItem.b(), this.mNegFeedBackItem.c());
                this.mNegFeedBackItem.b().setVisibility(4);
                d.a.d.e.m.e.a().postDelayed(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UtilityComponents this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mNegFeedBackItem.b().performClick();
                            this.this$0.mNegFeedBackItem.b().setVisibility(8);
                        }
                    }
                }, 150L);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void selectForumCategory(TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, componentsStringValue) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921541, componentsStringValue.getResult()));
        }
    }

    public void sendMesage(int i2, AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, agreeData) == null) || agreeData == null) {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityComponentsAuto.HostUtilityComponents
    public void showRedDotForMyTab(TiebaUtilityComponentsAuto.Result<TiebaUtilityComponentsAuto.ComponentsBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, result) == null) {
            TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
            componentsBoolResult.setResult(Boolean.valueOf(d.a.q0.x2.a.v().z()));
            result.success(componentsBoolResult);
        }
    }
}
