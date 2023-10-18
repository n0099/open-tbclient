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
public final class al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public al() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, zl zlVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, zlVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(zlVar);
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
                if (qq.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(zl zlVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        zl zlVar2;
        zl zlVar3;
        zl zlVar4;
        zl zlVar5;
        zl zlVar6;
        zl zlVar7;
        zl zlVar8;
        zl zlVar9;
        zl zlVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zlVar, bVar)) == null) {
            fl flVar = null;
            if (!(zlVar instanceof kl)) {
                zlVar2 = null;
            } else {
                zlVar2 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (kl) zlVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, zlVar);
                kl klVar = (kl) zlVar;
                a.h(klVar.h());
                a.i(klVar.h(), klVar.i());
                SubTaskState k = a.k(klVar.f());
                if (k != null) {
                    k.setInterceptor(klVar.j());
                    k.updateStatus(klVar.g(), Integer.valueOf(klVar.a()), klVar.d());
                }
                b(a, klVar.f());
                return a;
            }
            if (!(zlVar instanceof cl)) {
                zlVar3 = null;
            } else {
                zlVar3 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (cl) zlVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, zlVar);
                cl clVar = (cl) zlVar;
                SubTaskState k2 = a2.k(clVar.f());
                if (k2 != null) {
                    k2.updateStatus(clVar.g(), Integer.valueOf(clVar.a()), clVar.d());
                    k2.updateExtraUnRegisterMsg(clVar.h());
                }
                return a2;
            }
            if (!(zlVar instanceof jl)) {
                zlVar4 = null;
            } else {
                zlVar4 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (jl) zlVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, zlVar);
                jl jlVar = (jl) zlVar;
                SubTaskState k3 = a3.k(jlVar.f());
                if (k3 != null) {
                    k3.updateStatus(jlVar.g(), Integer.valueOf(jlVar.a()), jlVar.d()).getTaskStatus().setInterruptErrorNo(jlVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(zlVar instanceof bl)) {
                zlVar5 = null;
            } else {
                zlVar5 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (bl) zlVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, zlVar);
                bl blVar = (bl) zlVar;
                SubTaskState k4 = a4.k(blVar.f());
                if (k4 != null) {
                    k4.updateStatus(blVar.g(), Integer.valueOf(blVar.a()), blVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(zlVar instanceof dl)) {
                zlVar6 = null;
            } else {
                zlVar6 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (dl) zlVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, zlVar);
                dl dlVar = (dl) zlVar;
                SubTaskState k5 = a5.k(dlVar.f());
                if (k5 != null) {
                    k5.updateStatus(dlVar.g(), Integer.valueOf(dlVar.a()), dlVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(dlVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, dlVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(dlVar.h());
                    }
                }
                b(a5, dlVar.f());
                return a5;
            }
            if (!(zlVar instanceof el)) {
                zlVar7 = null;
            } else {
                zlVar7 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (el) zlVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, zlVar);
                el elVar = (el) zlVar;
                SubTaskState k6 = a6.k(elVar.f());
                if (k6 != null) {
                    k6.updateStatus(elVar.g(), Integer.valueOf(elVar.a()), elVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(elVar.h());
                    if (!TextUtils.isEmpty(elVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, elVar.j(), elVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(elVar.i());
                }
                b(a6, elVar.f());
                return a6;
            }
            if (!(zlVar instanceof il)) {
                zlVar8 = null;
            } else {
                zlVar8 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (il) zlVar8)) {
                il ilVar = (il) zlVar;
                TaskInfo k7 = ilVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, zlVar);
                SubTaskState k8 = a7.k(ilVar.f());
                if (k8 != null) {
                    if (jq.a.a(ilVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(ilVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(ilVar.i(), Integer.valueOf(ilVar.a()), ilVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(ilVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(ilVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, ilVar.f());
                return a7;
            }
            if (!(zlVar instanceof gl)) {
                zlVar9 = null;
            } else {
                zlVar9 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (gl) zlVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, zlVar);
                gl glVar = (gl) zlVar;
                SubTaskState k9 = a8.k(glVar.f());
                if (k9 != null) {
                    k9.updateStatus(glVar.g(), Integer.valueOf(glVar.a()), glVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(zlVar instanceof hl)) {
                zlVar10 = null;
            } else {
                zlVar10 = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, (hl) zlVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, zlVar);
                SubTaskState k10 = a9.k(((hl) zlVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (zlVar instanceof fl) {
                flVar = zlVar;
            }
            if (Intrinsics.areEqual(zlVar, flVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, zlVar);
                fl flVar2 = (fl) zlVar;
                SubTaskState k11 = a10.k(flVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(flVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(flVar2.g());
                }
                return a10;
            }
            return a(bVar, zlVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
