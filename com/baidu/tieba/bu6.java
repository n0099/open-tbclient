package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public PopupWindow b;
    public View c;
    public FrsViewData d;
    public vl6 e;
    public Runnable f;
    public Runnable g;
    public View.OnClickListener h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu6 a;

        public a(bu6 bu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.c == null || this.a.b == null || this.a.b.getContentView() == null) {
                return;
            }
            int f = ej.f(this.a.a, R.dimen.obfuscated_res_0x7f07028e);
            this.a.b.getContentView().measure(0, 0);
            ih.l(this.a.b, this.a.c, (-ej.f(this.a.a, R.dimen.obfuscated_res_0x7f0702c1)) + (this.a.c.getMeasuredWidth() / 2) + 30, -f);
            gh.a().postDelayed(this.a.g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu6 a;

        public b(bu6 bu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu6 a;

        public c(bu6 bu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i();
                if (this.a.d == null || this.a.d.postTopic == null || this.a.d.getForum() == null) {
                    return;
                }
                if ((this.a.e == null || this.a.e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.a.a).setType(9).setForumData(this.a.d.getForum()).setAntiData(this.a.d.getAnti()).setTitle(this.a.d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public bu6(Activity activity, vl6 vl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, vl6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
        this.h = new c(this);
        this.a = activity;
        this.e = vl6Var;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ih.c(this.b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gh.a().removeCallbacks(this.f);
            gh.a().removeCallbacks(this.g);
            h();
        }
    }

    public void j(View view2, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, frsViewData) == null) || view2 == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.a) == null) {
            return;
        }
        this.d = frsViewData;
        this.c = view2;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d034f, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092215)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092216)).setText(R.string.obfuscated_res_0x7f0f145f);
        inflate.setOnClickListener(this.h);
        this.b = new PopupWindow(inflate, -2, -2);
        gh.a().removeCallbacks(this.f);
        gh.a().postDelayed(this.f, 100L);
    }
}
