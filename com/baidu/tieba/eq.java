package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class eq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, dr drVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, drVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(drVar);
            }
            return bVar2;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b b(com.baidu.bdtask.ctrl.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str)) == null) {
            TaskInfo f = bVar.f(str);
            if (f != null) {
                if (uv.a.c(f.getTaskRule().getExpireTime())) {
                    return bVar;
                }
                SubTaskState k = bVar.k(str);
                if (k != null) {
                    k.updateStatus(22, 103, "task is expired");
                    k.getTaskStatus().clearProcess();
                }
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(dr drVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        dr drVar2;
        dr drVar3;
        dr drVar4;
        dr drVar5;
        dr drVar6;
        dr drVar7;
        dr drVar8;
        dr drVar9;
        dr drVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drVar, bVar)) == null) {
            jq jqVar = null;
            if (!(drVar instanceof oq)) {
                drVar2 = null;
            } else {
                drVar2 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (oq) drVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, drVar);
                oq oqVar = (oq) drVar;
                a.h(oqVar.h());
                a.i(oqVar.h(), oqVar.i());
                SubTaskState k = a.k(oqVar.f());
                if (k != null) {
                    k.setInterceptor(oqVar.j());
                    k.updateStatus(oqVar.g(), Integer.valueOf(oqVar.a()), oqVar.d());
                }
                b(a, oqVar.f());
                return a;
            }
            if (!(drVar instanceof gq)) {
                drVar3 = null;
            } else {
                drVar3 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (gq) drVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, drVar);
                gq gqVar = (gq) drVar;
                SubTaskState k2 = a2.k(gqVar.f());
                if (k2 != null) {
                    k2.updateStatus(gqVar.g(), Integer.valueOf(gqVar.a()), gqVar.d());
                    k2.updateExtraUnRegisterMsg(gqVar.h());
                }
                return a2;
            }
            if (!(drVar instanceof nq)) {
                drVar4 = null;
            } else {
                drVar4 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (nq) drVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, drVar);
                nq nqVar = (nq) drVar;
                SubTaskState k3 = a3.k(nqVar.f());
                if (k3 != null) {
                    k3.updateStatus(nqVar.g(), Integer.valueOf(nqVar.a()), nqVar.d()).getTaskStatus().setInterruptErrorNo(nqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(drVar instanceof fq)) {
                drVar5 = null;
            } else {
                drVar5 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (fq) drVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, drVar);
                fq fqVar = (fq) drVar;
                SubTaskState k4 = a4.k(fqVar.f());
                if (k4 != null) {
                    k4.updateStatus(fqVar.g(), Integer.valueOf(fqVar.a()), fqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(drVar instanceof hq)) {
                drVar6 = null;
            } else {
                drVar6 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (hq) drVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, drVar);
                hq hqVar = (hq) drVar;
                SubTaskState k5 = a5.k(hqVar.f());
                if (k5 != null) {
                    k5.updateStatus(hqVar.g(), Integer.valueOf(hqVar.a()), hqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(hqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, hqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(hqVar.h());
                    }
                }
                b(a5, hqVar.f());
                return a5;
            }
            if (!(drVar instanceof iq)) {
                drVar7 = null;
            } else {
                drVar7 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (iq) drVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, drVar);
                iq iqVar = (iq) drVar;
                SubTaskState k6 = a6.k(iqVar.f());
                if (k6 != null) {
                    k6.updateStatus(iqVar.g(), Integer.valueOf(iqVar.a()), iqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(iqVar.h());
                    if (!TextUtils.isEmpty(iqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, iqVar.j(), iqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(iqVar.i());
                }
                b(a6, iqVar.f());
                return a6;
            }
            if (!(drVar instanceof mq)) {
                drVar8 = null;
            } else {
                drVar8 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (mq) drVar8)) {
                mq mqVar = (mq) drVar;
                TaskInfo k7 = mqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, drVar);
                SubTaskState k8 = a7.k(mqVar.f());
                if (k8 != null) {
                    if (nv.a.a(mqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(mqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(mqVar.i(), Integer.valueOf(mqVar.a()), mqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(mqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(mqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, mqVar.f());
                return a7;
            }
            if (!(drVar instanceof kq)) {
                drVar9 = null;
            } else {
                drVar9 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (kq) drVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, drVar);
                kq kqVar = (kq) drVar;
                SubTaskState k9 = a8.k(kqVar.f());
                if (k9 != null) {
                    k9.updateStatus(kqVar.g(), Integer.valueOf(kqVar.a()), kqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(drVar instanceof lq)) {
                drVar10 = null;
            } else {
                drVar10 = drVar;
            }
            if (Intrinsics.areEqual(drVar, (lq) drVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, drVar);
                SubTaskState k10 = a9.k(((lq) drVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (drVar instanceof jq) {
                jqVar = drVar;
            }
            if (Intrinsics.areEqual(drVar, jqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, drVar);
                jq jqVar2 = (jq) drVar;
                SubTaskState k11 = a10.k(jqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(jqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(jqVar2.g());
                }
                return a10;
            }
            return a(bVar, drVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
