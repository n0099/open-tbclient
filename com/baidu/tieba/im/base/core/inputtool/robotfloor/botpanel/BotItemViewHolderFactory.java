package com.baidu.tieba.im.base.core.inputtool.robotfloor.botpanel;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.botpanel.BotItemViewHolderFactory;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.v98;
import com.baidu.tieba.w88;
import com.baidu.tieba.x98;
import com.baidu.tieba.y88;
import com.baidu.tieba.yg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
/* loaded from: classes6.dex */
public class BotItemViewHolderFactory extends x98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y88 d;

    /* loaded from: classes6.dex */
    public static class a extends BaseTagItemViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CardView c;
        public ImageView d;

        /* renamed from: com.baidu.tieba.im.base.core.inputtool.robotfloor.botpanel.BotItemViewHolderFactory$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0331a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y88 a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0331a(a aVar, y88 y88Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, y88Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = y88Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                y88 y88Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.b.d() instanceof w88) && (y88Var = this.a) != null) {
                    y88Var.a(((w88) this.b.d()).b());
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements RequestListener<Drawable> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ GlideUrl b;
            public final /* synthetic */ a c;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: b */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            public b(a aVar, int i, GlideUrl glideUrl) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), glideUrl};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = glideUrl;
            }

            public /* synthetic */ void a(Target target, int i, GlideUrl glideUrl) {
                target.getRequest().clear();
                this.c.q(i + 1, glideUrl);
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, final Target<Drawable> target, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                    yg6.a a = yg6.a();
                    final int i = this.a;
                    final GlideUrl glideUrl = this.b;
                    a.c(new Runnable() { // from class: com.baidu.tieba.u88
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                BotItemViewHolderFactory.a.b.this.a(target, i, glideUrl);
                            }
                        }
                    });
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2, y88 y88Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, y88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = (CardView) view2.findViewById(R.id.obfuscated_res_0x7f090440);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090441);
            view2.setOnClickListener(new View$OnClickListenerC0331a(this, y88Var));
        }

        @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.h(i);
                p();
            }
        }

        @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
        public void f(v98 v98Var, Context context, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, v98Var, context, i) == null) && (v98Var instanceof w88)) {
                q(1, new GlideUrl(((w88) v98Var).c()));
                p();
            }
        }

        public final void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                EMManager.from(this.d).setCorner(R.string.J_X05).setBorderWidth(R.dimen.obfuscated_res_0x7f0708c0).setBorderColor(R.color.CAM_X0401);
            }
        }

        public final void q(int i, GlideUrl glideUrl) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048579, this, i, glideUrl) == null) && i <= 2) {
                Glide.with(this.d.getContext()).load((Object) glideUrl).placeholder((int) R.drawable.pic_use_header_40_n).listener(new b(this, i, glideUrl)).into(this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class BotThinkItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BotThinkItemDecoration() {
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

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) / 2;
                if (childAdapterPosition == 0) {
                    i = UtilHelper.getDimenPixelSize(R.dimen.tbds0);
                } else {
                    i = dimenPixelSize;
                }
                rect.set(i, 0, dimenPixelSize, 0);
            }
        }
    }

    public BotItemViewHolderFactory(y88 y88Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y88Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = y88Var;
    }

    @Override // com.baidu.tieba.x98
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 1) {
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d017e, viewGroup, false), this.d);
            }
            return null;
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }
}
