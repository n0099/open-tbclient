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
public final class dq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, cr crVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, crVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(crVar);
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
                if (tv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(cr crVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        cr crVar2;
        cr crVar3;
        cr crVar4;
        cr crVar5;
        cr crVar6;
        cr crVar7;
        cr crVar8;
        cr crVar9;
        cr crVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, crVar, bVar)) == null) {
            iq iqVar = null;
            if (!(crVar instanceof nq)) {
                crVar2 = null;
            } else {
                crVar2 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (nq) crVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, crVar);
                nq nqVar = (nq) crVar;
                a.h(nqVar.h());
                a.i(nqVar.h(), nqVar.i());
                SubTaskState k = a.k(nqVar.f());
                if (k != null) {
                    k.setInterceptor(nqVar.j());
                    k.updateStatus(nqVar.g(), Integer.valueOf(nqVar.a()), nqVar.d());
                }
                b(a, nqVar.f());
                return a;
            }
            if (!(crVar instanceof fq)) {
                crVar3 = null;
            } else {
                crVar3 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (fq) crVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, crVar);
                fq fqVar = (fq) crVar;
                SubTaskState k2 = a2.k(fqVar.f());
                if (k2 != null) {
                    k2.updateStatus(fqVar.g(), Integer.valueOf(fqVar.a()), fqVar.d());
                    k2.updateExtraUnRegisterMsg(fqVar.h());
                }
                return a2;
            }
            if (!(crVar instanceof mq)) {
                crVar4 = null;
            } else {
                crVar4 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (mq) crVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, crVar);
                mq mqVar = (mq) crVar;
                SubTaskState k3 = a3.k(mqVar.f());
                if (k3 != null) {
                    k3.updateStatus(mqVar.g(), Integer.valueOf(mqVar.a()), mqVar.d()).getTaskStatus().setInterruptErrorNo(mqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(crVar instanceof eq)) {
                crVar5 = null;
            } else {
                crVar5 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (eq) crVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, crVar);
                eq eqVar = (eq) crVar;
                SubTaskState k4 = a4.k(eqVar.f());
                if (k4 != null) {
                    k4.updateStatus(eqVar.g(), Integer.valueOf(eqVar.a()), eqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(crVar instanceof gq)) {
                crVar6 = null;
            } else {
                crVar6 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (gq) crVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, crVar);
                gq gqVar = (gq) crVar;
                SubTaskState k5 = a5.k(gqVar.f());
                if (k5 != null) {
                    k5.updateStatus(gqVar.g(), Integer.valueOf(gqVar.a()), gqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(gqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, gqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(gqVar.h());
                    }
                }
                b(a5, gqVar.f());
                return a5;
            }
            if (!(crVar instanceof hq)) {
                crVar7 = null;
            } else {
                crVar7 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (hq) crVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, crVar);
                hq hqVar = (hq) crVar;
                SubTaskState k6 = a6.k(hqVar.f());
                if (k6 != null) {
                    k6.updateStatus(hqVar.g(), Integer.valueOf(hqVar.a()), hqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(hqVar.h());
                    if (!TextUtils.isEmpty(hqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, hqVar.j(), hqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(hqVar.i());
                }
                b(a6, hqVar.f());
                return a6;
            }
            if (!(crVar instanceof lq)) {
                crVar8 = null;
            } else {
                crVar8 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (lq) crVar8)) {
                lq lqVar = (lq) crVar;
                TaskInfo k7 = lqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, crVar);
                SubTaskState k8 = a7.k(lqVar.f());
                if (k8 != null) {
                    if (mv.a.a(lqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(lqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(lqVar.i(), Integer.valueOf(lqVar.a()), lqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(lqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(lqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, lqVar.f());
                return a7;
            }
            if (!(crVar instanceof jq)) {
                crVar9 = null;
            } else {
                crVar9 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (jq) crVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, crVar);
                jq jqVar = (jq) crVar;
                SubTaskState k9 = a8.k(jqVar.f());
                if (k9 != null) {
                    k9.updateStatus(jqVar.g(), Integer.valueOf(jqVar.a()), jqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(crVar instanceof kq)) {
                crVar10 = null;
            } else {
                crVar10 = crVar;
            }
            if (Intrinsics.areEqual(crVar, (kq) crVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, crVar);
                SubTaskState k10 = a9.k(((kq) crVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (crVar instanceof iq) {
                iqVar = crVar;
            }
            if (Intrinsics.areEqual(crVar, iqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, crVar);
                iq iqVar2 = (iq) crVar;
                SubTaskState k11 = a10.k(iqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(iqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(iqVar2.g());
                }
                return a10;
            }
            return a(bVar, crVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
