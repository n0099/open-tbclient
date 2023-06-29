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
public final class ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ar() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, zr zrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, zrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(zrVar);
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
                if (qw.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(zr zrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        zr zrVar2;
        zr zrVar3;
        zr zrVar4;
        zr zrVar5;
        zr zrVar6;
        zr zrVar7;
        zr zrVar8;
        zr zrVar9;
        zr zrVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zrVar, bVar)) == null) {
            fr frVar = null;
            if (!(zrVar instanceof kr)) {
                zrVar2 = null;
            } else {
                zrVar2 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (kr) zrVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, zrVar);
                kr krVar = (kr) zrVar;
                a.h(krVar.h());
                a.i(krVar.h(), krVar.i());
                SubTaskState k = a.k(krVar.f());
                if (k != null) {
                    k.setInterceptor(krVar.j());
                    k.updateStatus(krVar.g(), Integer.valueOf(krVar.a()), krVar.d());
                }
                b(a, krVar.f());
                return a;
            }
            if (!(zrVar instanceof cr)) {
                zrVar3 = null;
            } else {
                zrVar3 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (cr) zrVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, zrVar);
                cr crVar = (cr) zrVar;
                SubTaskState k2 = a2.k(crVar.f());
                if (k2 != null) {
                    k2.updateStatus(crVar.g(), Integer.valueOf(crVar.a()), crVar.d());
                    k2.updateExtraUnRegisterMsg(crVar.h());
                }
                return a2;
            }
            if (!(zrVar instanceof jr)) {
                zrVar4 = null;
            } else {
                zrVar4 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (jr) zrVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, zrVar);
                jr jrVar = (jr) zrVar;
                SubTaskState k3 = a3.k(jrVar.f());
                if (k3 != null) {
                    k3.updateStatus(jrVar.g(), Integer.valueOf(jrVar.a()), jrVar.d()).getTaskStatus().setInterruptErrorNo(jrVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(zrVar instanceof br)) {
                zrVar5 = null;
            } else {
                zrVar5 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (br) zrVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, zrVar);
                br brVar = (br) zrVar;
                SubTaskState k4 = a4.k(brVar.f());
                if (k4 != null) {
                    k4.updateStatus(brVar.g(), Integer.valueOf(brVar.a()), brVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(zrVar instanceof dr)) {
                zrVar6 = null;
            } else {
                zrVar6 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (dr) zrVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, zrVar);
                dr drVar = (dr) zrVar;
                SubTaskState k5 = a5.k(drVar.f());
                if (k5 != null) {
                    k5.updateStatus(drVar.g(), Integer.valueOf(drVar.a()), drVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(drVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, drVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(drVar.h());
                    }
                }
                b(a5, drVar.f());
                return a5;
            }
            if (!(zrVar instanceof er)) {
                zrVar7 = null;
            } else {
                zrVar7 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (er) zrVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, zrVar);
                er erVar = (er) zrVar;
                SubTaskState k6 = a6.k(erVar.f());
                if (k6 != null) {
                    k6.updateStatus(erVar.g(), Integer.valueOf(erVar.a()), erVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(erVar.h());
                    if (!TextUtils.isEmpty(erVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, erVar.j(), erVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(erVar.i());
                }
                b(a6, erVar.f());
                return a6;
            }
            if (!(zrVar instanceof ir)) {
                zrVar8 = null;
            } else {
                zrVar8 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (ir) zrVar8)) {
                ir irVar = (ir) zrVar;
                TaskInfo k7 = irVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, zrVar);
                SubTaskState k8 = a7.k(irVar.f());
                if (k8 != null) {
                    if (jw.a.a(irVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(irVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(irVar.i(), Integer.valueOf(irVar.a()), irVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(irVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(irVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, irVar.f());
                return a7;
            }
            if (!(zrVar instanceof gr)) {
                zrVar9 = null;
            } else {
                zrVar9 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (gr) zrVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, zrVar);
                gr grVar = (gr) zrVar;
                SubTaskState k9 = a8.k(grVar.f());
                if (k9 != null) {
                    k9.updateStatus(grVar.g(), Integer.valueOf(grVar.a()), grVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(zrVar instanceof hr)) {
                zrVar10 = null;
            } else {
                zrVar10 = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, (hr) zrVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, zrVar);
                SubTaskState k10 = a9.k(((hr) zrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (zrVar instanceof fr) {
                frVar = zrVar;
            }
            if (Intrinsics.areEqual(zrVar, frVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, zrVar);
                fr frVar2 = (fr) zrVar;
                SubTaskState k11 = a10.k(frVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(frVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(frVar2.g());
                }
                return a10;
            }
            return a(bVar, zrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
