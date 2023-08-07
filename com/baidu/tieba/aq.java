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
public final class aq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, zq zqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, zqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(zqVar);
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
                if (qv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(zq zqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        zq zqVar2;
        zq zqVar3;
        zq zqVar4;
        zq zqVar5;
        zq zqVar6;
        zq zqVar7;
        zq zqVar8;
        zq zqVar9;
        zq zqVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zqVar, bVar)) == null) {
            fq fqVar = null;
            if (!(zqVar instanceof kq)) {
                zqVar2 = null;
            } else {
                zqVar2 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (kq) zqVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, zqVar);
                kq kqVar = (kq) zqVar;
                a.h(kqVar.h());
                a.i(kqVar.h(), kqVar.i());
                SubTaskState k = a.k(kqVar.f());
                if (k != null) {
                    k.setInterceptor(kqVar.j());
                    k.updateStatus(kqVar.g(), Integer.valueOf(kqVar.a()), kqVar.d());
                }
                b(a, kqVar.f());
                return a;
            }
            if (!(zqVar instanceof cq)) {
                zqVar3 = null;
            } else {
                zqVar3 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (cq) zqVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, zqVar);
                cq cqVar = (cq) zqVar;
                SubTaskState k2 = a2.k(cqVar.f());
                if (k2 != null) {
                    k2.updateStatus(cqVar.g(), Integer.valueOf(cqVar.a()), cqVar.d());
                    k2.updateExtraUnRegisterMsg(cqVar.h());
                }
                return a2;
            }
            if (!(zqVar instanceof jq)) {
                zqVar4 = null;
            } else {
                zqVar4 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (jq) zqVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, zqVar);
                jq jqVar = (jq) zqVar;
                SubTaskState k3 = a3.k(jqVar.f());
                if (k3 != null) {
                    k3.updateStatus(jqVar.g(), Integer.valueOf(jqVar.a()), jqVar.d()).getTaskStatus().setInterruptErrorNo(jqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(zqVar instanceof bq)) {
                zqVar5 = null;
            } else {
                zqVar5 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (bq) zqVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, zqVar);
                bq bqVar = (bq) zqVar;
                SubTaskState k4 = a4.k(bqVar.f());
                if (k4 != null) {
                    k4.updateStatus(bqVar.g(), Integer.valueOf(bqVar.a()), bqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(zqVar instanceof dq)) {
                zqVar6 = null;
            } else {
                zqVar6 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (dq) zqVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, zqVar);
                dq dqVar = (dq) zqVar;
                SubTaskState k5 = a5.k(dqVar.f());
                if (k5 != null) {
                    k5.updateStatus(dqVar.g(), Integer.valueOf(dqVar.a()), dqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(dqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, dqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(dqVar.h());
                    }
                }
                b(a5, dqVar.f());
                return a5;
            }
            if (!(zqVar instanceof eq)) {
                zqVar7 = null;
            } else {
                zqVar7 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (eq) zqVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, zqVar);
                eq eqVar = (eq) zqVar;
                SubTaskState k6 = a6.k(eqVar.f());
                if (k6 != null) {
                    k6.updateStatus(eqVar.g(), Integer.valueOf(eqVar.a()), eqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(eqVar.h());
                    if (!TextUtils.isEmpty(eqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, eqVar.j(), eqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(eqVar.i());
                }
                b(a6, eqVar.f());
                return a6;
            }
            if (!(zqVar instanceof iq)) {
                zqVar8 = null;
            } else {
                zqVar8 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (iq) zqVar8)) {
                iq iqVar = (iq) zqVar;
                TaskInfo k7 = iqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, zqVar);
                SubTaskState k8 = a7.k(iqVar.f());
                if (k8 != null) {
                    if (jv.a.a(iqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(iqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(iqVar.i(), Integer.valueOf(iqVar.a()), iqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(iqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(iqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, iqVar.f());
                return a7;
            }
            if (!(zqVar instanceof gq)) {
                zqVar9 = null;
            } else {
                zqVar9 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (gq) zqVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, zqVar);
                gq gqVar = (gq) zqVar;
                SubTaskState k9 = a8.k(gqVar.f());
                if (k9 != null) {
                    k9.updateStatus(gqVar.g(), Integer.valueOf(gqVar.a()), gqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(zqVar instanceof hq)) {
                zqVar10 = null;
            } else {
                zqVar10 = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, (hq) zqVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, zqVar);
                SubTaskState k10 = a9.k(((hq) zqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (zqVar instanceof fq) {
                fqVar = zqVar;
            }
            if (Intrinsics.areEqual(zqVar, fqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, zqVar);
                fq fqVar2 = (fq) zqVar;
                SubTaskState k11 = a10.k(fqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(fqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(fqVar2.g());
                }
                return a10;
            }
            return a(bVar, zqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
