package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatNameViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bz8 {
    public static /* synthetic */ Interceptable $ic;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public qz8 a;
    @NonNull
    public zy8 b;
    public View c;
    public ChatNameViewHolder d;
    public String e;
    public long f;
    public final View.OnClickListener g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz8 a;

        public a(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            qz8 qz8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.e() && (qz8Var = this.a.a) != null) {
                if (qz8Var.d()) {
                    if (this.a.e.equals("message_tab")) {
                        WebPManager.setPureDrawable(this.a.b.d(), R.drawable.obfuscated_res_0x7f080abe, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
                    } else {
                        this.a.b.d().setImageResource(R.drawable.obfuscated_res_0x7f080941);
                    }
                    bz8 bz8Var = this.a;
                    oy8.d(bz8Var.d, bz8Var.b.c());
                    int unused = bz8.h = 1;
                } else {
                    if (this.a.e.equals("message_tab")) {
                        WebPManager.setPureDrawable(this.a.b.d(), R.drawable.icon_close, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
                    } else {
                        this.a.b.d().setImageResource(R.drawable.obfuscated_res_0x7f08093e);
                    }
                    bz8 bz8Var2 = this.a;
                    oy8.a(bz8Var2.d, bz8Var2.b.c());
                    int unused2 = bz8.h = 2;
                }
                this.a.d();
                qz8 qz8Var2 = this.a.a;
                qz8Var2.g(true ^ qz8Var2.d());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bz8 bz8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public bz8(@NonNull qz8 qz8Var, @NonNull zy8 zy8Var, View view2, ChatNameViewHolder chatNameViewHolder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qz8Var, zy8Var, view2, chatNameViewHolder, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0L;
        this.g = new a(this);
        this.a = qz8Var;
        this.b = zy8Var;
        this.c = view2;
        this.d = chatNameViewHolder;
        this.e = str;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.icon_close, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.obfuscated_res_0x7f080abe, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_CLICK);
            yj8 yj8Var = this.a.getSubItems().get(0);
            if (yj8Var instanceof rz8) {
                rz8 rz8Var = (rz8) yj8Var;
                if (rz8Var.a() != null) {
                    statisticItem.param("fid", rz8Var.a().getForumId());
                    statisticItem.param("fname", rz8Var.a().getForumName());
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", h);
            statisticItem.param("obj_source", this.a.b());
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (System.currentTimeMillis() - this.f < 400) {
                return true;
            }
            this.f = System.currentTimeMillis();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.b(TbadkCoreApplication.getInst().getSkinType(), this.a);
        }
    }

    public void f(@NonNull qz8 qz8Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qz8Var) == null) {
            this.b.c().setLayoutManager(new b(this, this.c.getContext()));
            this.b.c().setFocusable(false);
            this.b.a().setOnClickListener(this.g);
            this.b.e().setText(qz8Var.b());
            boolean equals = this.e.equals("message_tab");
            int i2 = R.drawable.obfuscated_res_0x7f080941;
            if (equals) {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.obfuscated_res_0x7f080abe, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            } else {
                this.b.d().setImageResource(R.drawable.obfuscated_res_0x7f080941);
            }
            if (this.b.c().getAdapter() != qz8Var.getAdapter()) {
                if (this.b.c().getAdapter() != null) {
                    this.b.c().swapAdapter(qz8Var.getAdapter(), true);
                } else {
                    this.b.c().setAdapter(qz8Var.getAdapter());
                }
            } else {
                qz8Var.f();
            }
            RecyclerView c = this.b.c();
            if (qz8Var.d()) {
                i = 8;
            } else {
                i = 0;
            }
            c.setVisibility(i);
            if (this.e.equals("message_tab")) {
                h(qz8Var.d());
            } else {
                ImageView d = this.b.d();
                if (qz8Var.d()) {
                    i2 = R.drawable.obfuscated_res_0x7f08093e;
                }
                d.setImageResource(i2);
            }
            if (this.a.e()) {
                this.b.a().setVisibility(8);
            } else {
                this.b.a().setVisibility(0);
            }
            g();
        }
    }
}
