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
/* loaded from: classes4.dex */
public final class hq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, gr grVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, grVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(grVar);
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
                if (xv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(gr grVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        gr grVar2;
        gr grVar3;
        gr grVar4;
        gr grVar5;
        gr grVar6;
        gr grVar7;
        gr grVar8;
        gr grVar9;
        gr grVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, grVar, bVar)) == null) {
            mq mqVar = null;
            if (!(grVar instanceof rq)) {
                grVar2 = null;
            } else {
                grVar2 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (rq) grVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, grVar);
                rq rqVar = (rq) grVar;
                a.h(rqVar.h());
                a.i(rqVar.h(), rqVar.i());
                SubTaskState k = a.k(rqVar.f());
                if (k != null) {
                    k.setInterceptor(rqVar.j());
                    k.updateStatus(rqVar.g(), Integer.valueOf(rqVar.a()), rqVar.d());
                }
                b(a, rqVar.f());
                return a;
            }
            if (!(grVar instanceof jq)) {
                grVar3 = null;
            } else {
                grVar3 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (jq) grVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, grVar);
                jq jqVar = (jq) grVar;
                SubTaskState k2 = a2.k(jqVar.f());
                if (k2 != null) {
                    k2.updateStatus(jqVar.g(), Integer.valueOf(jqVar.a()), jqVar.d());
                    k2.updateExtraUnRegisterMsg(jqVar.h());
                }
                return a2;
            }
            if (!(grVar instanceof qq)) {
                grVar4 = null;
            } else {
                grVar4 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (qq) grVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, grVar);
                qq qqVar = (qq) grVar;
                SubTaskState k3 = a3.k(qqVar.f());
                if (k3 != null) {
                    k3.updateStatus(qqVar.g(), Integer.valueOf(qqVar.a()), qqVar.d()).getTaskStatus().setInterruptErrorNo(qqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(grVar instanceof iq)) {
                grVar5 = null;
            } else {
                grVar5 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (iq) grVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, grVar);
                iq iqVar = (iq) grVar;
                SubTaskState k4 = a4.k(iqVar.f());
                if (k4 != null) {
                    k4.updateStatus(iqVar.g(), Integer.valueOf(iqVar.a()), iqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(grVar instanceof kq)) {
                grVar6 = null;
            } else {
                grVar6 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (kq) grVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, grVar);
                kq kqVar = (kq) grVar;
                SubTaskState k5 = a5.k(kqVar.f());
                if (k5 != null) {
                    k5.updateStatus(kqVar.g(), Integer.valueOf(kqVar.a()), kqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(kqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, kqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(kqVar.h());
                    }
                }
                b(a5, kqVar.f());
                return a5;
            }
            if (!(grVar instanceof lq)) {
                grVar7 = null;
            } else {
                grVar7 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (lq) grVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, grVar);
                lq lqVar = (lq) grVar;
                SubTaskState k6 = a6.k(lqVar.f());
                if (k6 != null) {
                    k6.updateStatus(lqVar.g(), Integer.valueOf(lqVar.a()), lqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(lqVar.h());
                    if (!TextUtils.isEmpty(lqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, lqVar.j(), lqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(lqVar.i());
                }
                b(a6, lqVar.f());
                return a6;
            }
            if (!(grVar instanceof pq)) {
                grVar8 = null;
            } else {
                grVar8 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (pq) grVar8)) {
                pq pqVar = (pq) grVar;
                TaskInfo k7 = pqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, grVar);
                SubTaskState k8 = a7.k(pqVar.f());
                if (k8 != null) {
                    if (qv.a.a(pqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(pqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(pqVar.i(), Integer.valueOf(pqVar.a()), pqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(pqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(pqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, pqVar.f());
                return a7;
            }
            if (!(grVar instanceof nq)) {
                grVar9 = null;
            } else {
                grVar9 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (nq) grVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, grVar);
                nq nqVar = (nq) grVar;
                SubTaskState k9 = a8.k(nqVar.f());
                if (k9 != null) {
                    k9.updateStatus(nqVar.g(), Integer.valueOf(nqVar.a()), nqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(grVar instanceof oq)) {
                grVar10 = null;
            } else {
                grVar10 = grVar;
            }
            if (Intrinsics.areEqual(grVar, (oq) grVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, grVar);
                SubTaskState k10 = a9.k(((oq) grVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (grVar instanceof mq) {
                mqVar = grVar;
            }
            if (Intrinsics.areEqual(grVar, mqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, grVar);
                mq mqVar2 = (mq) grVar;
                SubTaskState k11 = a10.k(mqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(mqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(mqVar2.g());
                }
                return a10;
            }
            return a(bVar, grVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
