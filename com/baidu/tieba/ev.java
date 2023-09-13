package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.toast.TaskToastViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.fv;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ev extends ct<bq> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv a;
    public final long b;
    public final int c;

    /* loaded from: classes5.dex */
    public static final class a<T> implements zs<TaskToastViewData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev a;

        public a(ev evVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {evVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = evVar;
        }

        /* renamed from: com.baidu.tieba.ev$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0271a implements fv.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ TaskToastViewData b;
            public final /* synthetic */ a c;

            public C0271a(String str, TaskToastViewData taskToastViewData, a aVar, TaskToastViewData taskToastViewData2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, taskToastViewData, aVar, taskToastViewData2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = taskToastViewData;
                this.c = aVar;
            }

            @Override // com.baidu.tieba.fv.a
            public final void onToastClick() {
                ls b;
                gu d;
                gu d2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    fu v = BDPTask.m.v();
                    if (v != null && (d2 = v.d()) != null) {
                        d2.b(this.b.getTaskInfoSingleKey(), br.c.a());
                    }
                    fu v2 = BDPTask.m.v();
                    if (v2 != null && (d = v2.d()) != null) {
                        d.a(this.b.getTaskInfoSingleKey());
                    }
                    fu v3 = BDPTask.m.v();
                    if (v3 != null && (b = v3.b()) != null) {
                        b.a(this.a, 2);
                    }
                    this.c.a.h(this.b.getTaskInfo());
                }
            }
        }

        /* loaded from: classes5.dex */
        public static final class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ a b;

            public b(Context context, a aVar, TaskToastViewData taskToastViewData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, aVar, taskToastViewData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = context;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a.k(this.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zs
        /* renamed from: a */
        public final void onChanged(TaskToastViewData taskToastViewData) {
            Context context;
            fs h;
            fs h2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, taskToastViewData) == null) && taskToastViewData != null) {
                this.a.a.a(this.a.c);
                this.a.a.d(taskToastViewData.getMessage());
                this.a.a.e(taskToastViewData.getBackColor());
                this.a.a.h(taskToastViewData.getDuration());
                this.a.a.j(taskToastViewData.getTxtColor());
                this.a.a.b(taskToastViewData.getToastLayoutParams());
                this.a.a.q(taskToastViewData.getBgUrl());
                String backBtnBgUrl = taskToastViewData.getBackBtnBgUrl();
                if (backBtnBgUrl != null) {
                    this.a.a.o(backBtnBgUrl);
                }
                String backBtnColor = taskToastViewData.getBackBtnColor();
                if (backBtnColor != null) {
                    this.a.a.n(backBtnColor);
                }
                String backBtnSchema = taskToastViewData.getBackBtnSchema();
                if (backBtnSchema != null) {
                    this.a.a.c(new C0271a(backBtnSchema, taskToastViewData, this, taskToastViewData));
                }
                String backBtnTxt = taskToastViewData.getBackBtnTxt();
                if (backBtnTxt != null) {
                    this.a.a.i(backBtnTxt);
                }
                String backBtnTxtColor = taskToastViewData.getBackBtnTxtColor();
                if (backBtnTxtColor != null) {
                    this.a.a.p(backBtnTxtColor);
                }
                fu v = BDPTask.m.v();
                Activity activity = null;
                if (v != null && (h2 = v.h()) != null) {
                    context = h2.getAppContext();
                } else {
                    context = null;
                }
                fu v2 = BDPTask.m.v();
                if (v2 != null && (h = v2.h()) != null) {
                    activity = h.a();
                }
                if (activity == null) {
                    activity = context;
                }
                if (activity != null) {
                    int showType = taskToastViewData.getShowType();
                    if (showType != 1) {
                        if (showType == 2) {
                            it.d(new b(activity, this, taskToastViewData), this.a.b);
                        }
                    } else if (context != null) {
                        this.a.a.g(context);
                    }
                    this.a.i(taskToastViewData.getTaskInfo(), taskToastViewData.getTaskStatus());
                }
            }
        }
    }

    public ev() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new fv();
        this.b = 100L;
        this.c = 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vs
    /* renamed from: g */
    public void a(bq bqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bqVar) == null) {
            bqVar.a().l(new a(this));
        }
    }

    public final void h(TaskInfo taskInfo) {
        fu v;
        ou f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.a("y_task_toast", "icon_clk", pu.b(pu.a, taskInfo.getId(), taskInfo.getActTaskId(), null, 4, null));
        }
    }

    public final void i(TaskInfo taskInfo, TaskStatus taskStatus) {
        ou f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, taskInfo, taskStatus) == null) {
            String c = pu.a.c(taskStatus);
            fu v = BDPTask.m.v();
            if (v != null && (f = v.f()) != null) {
                f.a("y_task_toast", "c_pv", pu.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c));
            }
        }
    }
}
