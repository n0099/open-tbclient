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
public final class gq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, fr frVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, frVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(frVar);
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
                if (wv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(fr frVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        fr frVar2;
        fr frVar3;
        fr frVar4;
        fr frVar5;
        fr frVar6;
        fr frVar7;
        fr frVar8;
        fr frVar9;
        fr frVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, frVar, bVar)) == null) {
            lq lqVar = null;
            if (!(frVar instanceof qq)) {
                frVar2 = null;
            } else {
                frVar2 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (qq) frVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, frVar);
                qq qqVar = (qq) frVar;
                a.h(qqVar.h());
                a.i(qqVar.h(), qqVar.i());
                SubTaskState k = a.k(qqVar.f());
                if (k != null) {
                    k.setInterceptor(qqVar.j());
                    k.updateStatus(qqVar.g(), Integer.valueOf(qqVar.a()), qqVar.d());
                }
                b(a, qqVar.f());
                return a;
            }
            if (!(frVar instanceof iq)) {
                frVar3 = null;
            } else {
                frVar3 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (iq) frVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, frVar);
                iq iqVar = (iq) frVar;
                SubTaskState k2 = a2.k(iqVar.f());
                if (k2 != null) {
                    k2.updateStatus(iqVar.g(), Integer.valueOf(iqVar.a()), iqVar.d());
                    k2.updateExtraUnRegisterMsg(iqVar.h());
                }
                return a2;
            }
            if (!(frVar instanceof pq)) {
                frVar4 = null;
            } else {
                frVar4 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (pq) frVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, frVar);
                pq pqVar = (pq) frVar;
                SubTaskState k3 = a3.k(pqVar.f());
                if (k3 != null) {
                    k3.updateStatus(pqVar.g(), Integer.valueOf(pqVar.a()), pqVar.d()).getTaskStatus().setInterruptErrorNo(pqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(frVar instanceof hq)) {
                frVar5 = null;
            } else {
                frVar5 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (hq) frVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, frVar);
                hq hqVar = (hq) frVar;
                SubTaskState k4 = a4.k(hqVar.f());
                if (k4 != null) {
                    k4.updateStatus(hqVar.g(), Integer.valueOf(hqVar.a()), hqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(frVar instanceof jq)) {
                frVar6 = null;
            } else {
                frVar6 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (jq) frVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, frVar);
                jq jqVar = (jq) frVar;
                SubTaskState k5 = a5.k(jqVar.f());
                if (k5 != null) {
                    k5.updateStatus(jqVar.g(), Integer.valueOf(jqVar.a()), jqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(jqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, jqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(jqVar.h());
                    }
                }
                b(a5, jqVar.f());
                return a5;
            }
            if (!(frVar instanceof kq)) {
                frVar7 = null;
            } else {
                frVar7 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (kq) frVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, frVar);
                kq kqVar = (kq) frVar;
                SubTaskState k6 = a6.k(kqVar.f());
                if (k6 != null) {
                    k6.updateStatus(kqVar.g(), Integer.valueOf(kqVar.a()), kqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(kqVar.h());
                    if (!TextUtils.isEmpty(kqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, kqVar.j(), kqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(kqVar.i());
                }
                b(a6, kqVar.f());
                return a6;
            }
            if (!(frVar instanceof oq)) {
                frVar8 = null;
            } else {
                frVar8 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (oq) frVar8)) {
                oq oqVar = (oq) frVar;
                TaskInfo k7 = oqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, frVar);
                SubTaskState k8 = a7.k(oqVar.f());
                if (k8 != null) {
                    if (pv.a.a(oqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(oqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(oqVar.i(), Integer.valueOf(oqVar.a()), oqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(oqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(oqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, oqVar.f());
                return a7;
            }
            if (!(frVar instanceof mq)) {
                frVar9 = null;
            } else {
                frVar9 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (mq) frVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, frVar);
                mq mqVar = (mq) frVar;
                SubTaskState k9 = a8.k(mqVar.f());
                if (k9 != null) {
                    k9.updateStatus(mqVar.g(), Integer.valueOf(mqVar.a()), mqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(frVar instanceof nq)) {
                frVar10 = null;
            } else {
                frVar10 = frVar;
            }
            if (Intrinsics.areEqual(frVar, (nq) frVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, frVar);
                SubTaskState k10 = a9.k(((nq) frVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (frVar instanceof lq) {
                lqVar = frVar;
            }
            if (Intrinsics.areEqual(frVar, lqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, frVar);
                lq lqVar2 = (lq) frVar;
                SubTaskState k11 = a10.k(lqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(lqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(lqVar2.g());
                }
                return a10;
            }
            return a(bVar, frVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
