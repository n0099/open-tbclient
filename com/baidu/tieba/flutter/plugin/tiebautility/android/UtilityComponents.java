package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.l.b0;
import c.a.o0.h0.h;
import c.a.o0.s.d0.b;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.x0;
import c.a.p0.i3.h0.e;
import c.a.p0.w2.a;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
            c2 c2Var = new c2();
            c2Var.R2(jSONObject);
            AgreeData B = c2Var.B();
            int i2 = 1;
            if (z) {
                TbPageContext pageContext = TbadkApplication.getInst().getCurrentActivity() != null ? ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext() : null;
                if (B.hasAgree) {
                    if (B.agreeType == 2) {
                        B.agreeType = 2;
                        B.hasAgree = false;
                        B.agreeNum--;
                        if (!StringUtil.isEmpty(str)) {
                            B.objSource = str;
                        }
                        sendMesage(i2, B);
                    } else {
                        B.agreeType = 2;
                        B.hasAgree = true;
                        B.agreeNum++;
                        a.g().l(pageContext);
                    }
                } else {
                    B.agreeType = 2;
                    B.hasAgree = true;
                    B.agreeNum++;
                    a.g().l(pageContext);
                }
                i2 = 0;
                if (!StringUtil.isEmpty(str)) {
                }
                sendMesage(i2, B);
            } else {
                if (B.hasAgree) {
                    if (B.agreeType == 5) {
                        B.agreeType = 5;
                        B.hasAgree = false;
                        NoNetworkView.updateUI();
                        if (!StringUtil.isEmpty(str)) {
                            B.objSource = str;
                        }
                        sendMesage(i2, B);
                    } else {
                        B.agreeType = 5;
                        B.hasAgree = true;
                        B.agreeNum--;
                    }
                } else {
                    B.agreeType = 5;
                    B.hasAgree = true;
                }
                i2 = 0;
                if (!StringUtil.isEmpty(str)) {
                }
                sendMesage(i2, B);
            }
            e eVar = new e();
            eVar.f19938b = B;
            if (c2Var.L() != null) {
                B.nid = c2Var.L().oriUgcNid;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            dispatchMutiProcessAgree(B, AgreeEvent.IS_THREAD);
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
                pbHistoryCacheModel.O(new CacheModel.c<c.a.p0.b2.h.a>(this, zArr, result) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.1
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
                    public void onCacheDataGet(ReadCacheRespMsg<List<c.a.p0.b2.h.a>> readCacheRespMsg, ReadCacheMessage<c.a.p0.b2.h.a> readCacheMessage) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) || readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                            return;
                        }
                        List<c.a.p0.b2.h.a> data = readCacheRespMsg.getData();
                        if (this.val$issubmitted[0] || this.val$result == null) {
                            return;
                        }
                        TiebaUtilityComponentsAuto.ComponentsStringValue componentsStringValue = new TiebaUtilityComponentsAuto.ComponentsStringValue();
                        componentsStringValue.setResult(String.valueOf(data.size()));
                        this.val$result.success(componentsStringValue);
                        this.val$issubmitted[0] = true;
                    }

                    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
                    public void onCacheDataWrite(WriteCacheRespMsg<List<c.a.p0.b2.h.a>> writeCacheRespMsg, WriteCacheMessage<c.a.p0.b2.h.a> writeCacheMessage) {
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
            b j2 = b.j();
            boolean g2 = j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
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
            c2 c2Var = new c2();
            c2Var.R2(optJSONObject);
            x0 negFeedBackData = c2Var.getNegFeedBackData();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(16908290);
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
                if (viewGroup == null || tbPageContextSupport == null) {
                    return;
                }
                b0 b0Var = this.mNegFeedBackItem;
                if (b0Var != null && b0Var.a() != null) {
                    viewGroup.removeView(this.mNegFeedBackItem.a());
                }
                b0 b0Var2 = new b0(tbPageContextSupport.getPageContext(), Align.ALIGN_RIGHT_TOP);
                this.mNegFeedBackItem = b0Var2;
                b0Var2.t(new NEGFeedBackView.b(this, result) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.2
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
                    public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
                        }
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || this.val$result == null) {
                            return;
                        }
                        TiebaUtilityComponentsAuto.ComponentsBoolResult componentsBoolResult = new TiebaUtilityComponentsAuto.ComponentsBoolResult();
                        componentsBoolResult.setResult(Boolean.TRUE);
                        this.val$result.success(componentsBoolResult);
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                    public void onNEGFeedbackWindowShow(x0 x0Var) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                        }
                    }
                });
                this.mNegFeedBackItem.onBindDataToView(negFeedBackData);
                int k = l.k(tbPageContextSupport.getPageContext().getPageActivity());
                if (Build.VERSION.SDK_INT >= 11) {
                    this.mNegFeedBackItem.a().setY(round - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 16.0f));
                    this.mNegFeedBackItem.a().setX((k - round2) - l.e(tbPageContextSupport.getPageContext().getPageActivity(), 20.0f));
                }
                viewGroup.addView(this.mNegFeedBackItem.a(), this.mNegFeedBackItem.b());
                this.mNegFeedBackItem.a().setVisibility(4);
                c.a.e.e.m.e.a().postDelayed(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityComponents.3
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
                            this.this$0.mNegFeedBackItem.a().performClick();
                            this.this$0.mNegFeedBackItem.a().setVisibility(8);
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
            componentsBoolResult.setResult(Boolean.valueOf(c.a.p0.y2.a.v().z()));
            result.success(componentsBoolResult);
        }
    }
}
