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
public final class br {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public br() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, as asVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, asVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(asVar);
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
                if (rw.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(as asVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        as asVar2;
        as asVar3;
        as asVar4;
        as asVar5;
        as asVar6;
        as asVar7;
        as asVar8;
        as asVar9;
        as asVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, asVar, bVar)) == null) {
            gr grVar = null;
            if (!(asVar instanceof lr)) {
                asVar2 = null;
            } else {
                asVar2 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (lr) asVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, asVar);
                lr lrVar = (lr) asVar;
                a.h(lrVar.h());
                a.i(lrVar.h(), lrVar.i());
                SubTaskState k = a.k(lrVar.f());
                if (k != null) {
                    k.setInterceptor(lrVar.j());
                    k.updateStatus(lrVar.g(), Integer.valueOf(lrVar.a()), lrVar.d());
                }
                b(a, lrVar.f());
                return a;
            }
            if (!(asVar instanceof dr)) {
                asVar3 = null;
            } else {
                asVar3 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (dr) asVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, asVar);
                dr drVar = (dr) asVar;
                SubTaskState k2 = a2.k(drVar.f());
                if (k2 != null) {
                    k2.updateStatus(drVar.g(), Integer.valueOf(drVar.a()), drVar.d());
                    k2.updateExtraUnRegisterMsg(drVar.h());
                }
                return a2;
            }
            if (!(asVar instanceof kr)) {
                asVar4 = null;
            } else {
                asVar4 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (kr) asVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, asVar);
                kr krVar = (kr) asVar;
                SubTaskState k3 = a3.k(krVar.f());
                if (k3 != null) {
                    k3.updateStatus(krVar.g(), Integer.valueOf(krVar.a()), krVar.d()).getTaskStatus().setInterruptErrorNo(krVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(asVar instanceof cr)) {
                asVar5 = null;
            } else {
                asVar5 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (cr) asVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, asVar);
                cr crVar = (cr) asVar;
                SubTaskState k4 = a4.k(crVar.f());
                if (k4 != null) {
                    k4.updateStatus(crVar.g(), Integer.valueOf(crVar.a()), crVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(asVar instanceof er)) {
                asVar6 = null;
            } else {
                asVar6 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (er) asVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, asVar);
                er erVar = (er) asVar;
                SubTaskState k5 = a5.k(erVar.f());
                if (k5 != null) {
                    k5.updateStatus(erVar.g(), Integer.valueOf(erVar.a()), erVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(erVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, erVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(erVar.h());
                    }
                }
                b(a5, erVar.f());
                return a5;
            }
            if (!(asVar instanceof fr)) {
                asVar7 = null;
            } else {
                asVar7 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (fr) asVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, asVar);
                fr frVar = (fr) asVar;
                SubTaskState k6 = a6.k(frVar.f());
                if (k6 != null) {
                    k6.updateStatus(frVar.g(), Integer.valueOf(frVar.a()), frVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(frVar.h());
                    if (!TextUtils.isEmpty(frVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, frVar.j(), frVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(frVar.i());
                }
                b(a6, frVar.f());
                return a6;
            }
            if (!(asVar instanceof jr)) {
                asVar8 = null;
            } else {
                asVar8 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (jr) asVar8)) {
                jr jrVar = (jr) asVar;
                TaskInfo k7 = jrVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, asVar);
                SubTaskState k8 = a7.k(jrVar.f());
                if (k8 != null) {
                    if (kw.a.a(jrVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(jrVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(jrVar.i(), Integer.valueOf(jrVar.a()), jrVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(jrVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(jrVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, jrVar.f());
                return a7;
            }
            if (!(asVar instanceof hr)) {
                asVar9 = null;
            } else {
                asVar9 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (hr) asVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, asVar);
                hr hrVar = (hr) asVar;
                SubTaskState k9 = a8.k(hrVar.f());
                if (k9 != null) {
                    k9.updateStatus(hrVar.g(), Integer.valueOf(hrVar.a()), hrVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(asVar instanceof ir)) {
                asVar10 = null;
            } else {
                asVar10 = asVar;
            }
            if (Intrinsics.areEqual(asVar, (ir) asVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, asVar);
                SubTaskState k10 = a9.k(((ir) asVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (asVar instanceof gr) {
                grVar = asVar;
            }
            if (Intrinsics.areEqual(asVar, grVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, asVar);
                gr grVar2 = (gr) asVar;
                SubTaskState k11 = a10.k(grVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(grVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(grVar2.g());
                }
                return a10;
            }
            return a(bVar, asVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
