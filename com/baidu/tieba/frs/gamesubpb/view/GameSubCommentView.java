package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.x0.w1.a;
import c.a.r0.x0.w1.d.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class GameSubCommentView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f51319a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f51320b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1321a f51321c;

    /* loaded from: classes7.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f51322a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSubCommentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51322a = gameSubCommentView;
        }

        public void bindData(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                this.f51322a.b(dVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f51323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GameSubCommentView f51324f;

        public a(GameSubCommentView gameSubCommentView, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSubCommentView, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51324f = gameSubCommentView;
            this.f51323e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51324f.f51321c == null) {
                return;
            }
            this.f51324f.f51321c.c(this.f51323e);
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f51319a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f51320b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || dVar.f28144h == null) {
            return;
        }
        this.f51320b.bindData(dVar);
        this.f51320b.setOnClickListener(new a(this, dVar));
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51319a : (View) invokeV.objValue;
    }

    public void d(a.InterfaceC1321a interfaceC1321a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1321a) == null) {
            this.f51321c = interfaceC1321a;
            this.f51320b.setClickListener(interfaceC1321a);
        }
    }
}
