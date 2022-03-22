package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import c.a.p0.h0.e0.g;
import c.a.p0.r1.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f31621b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31622c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f31623d;

    /* renamed from: e  reason: collision with root package name */
    public g f31624e;

    /* renamed from: f  reason: collision with root package name */
    public int f31625f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardExtendForumItemHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f31621b = null;
        this.f31622c = null;
        this.f31623d = null;
        this.f31625f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && (cVar instanceof g)) {
                g gVar = (g) cVar;
                this.f31624e = gVar;
                this.f31621b.setTag(gVar.f15326b);
                this.f31621b.setTag(R.id.obfuscated_res_0x7f091e7b, this.f31624e.f15327c);
                this.f31621b.J(this.f31624e.f15326b, 15, false);
                TextView textView = this.f31622c;
                textView.setText(StringHelper.getFixedText(this.f31624e.f15327c, 4, true) + b().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f063c));
                this.f31622c.setTag(R.id.obfuscated_res_0x7f091e7b, this.f31624e.f15327c);
                this.f31623d.setTag(R.id.obfuscated_res_0x7f091e7a, Long.valueOf(this.f31624e.f15328d));
                this.f31623d.setTag(R.id.obfuscated_res_0x7f091e7b, this.f31624e.f15327c);
                b().setTag(R.id.obfuscated_res_0x7f091e7a, Long.valueOf(this.f31624e.f15328d));
                b().setTag(R.id.obfuscated_res_0x7f091e7b, this.f31624e.f15327c);
                g(this.f31623d, this.f31624e.f15329e);
                this.f31621b.setOnClickListener(this.a);
                this.f31623d.setOnClickListener(this.a);
                this.f31622c.setOnClickListener(this.a);
                b().setOnClickListener(this.a);
            }
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
            cardExtendForumItemHolder.f31621b = barImageView;
            barImageView.setGifIconSupport(false);
            cardExtendForumItemHolder.f31622c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091366);
            cardExtendForumItemHolder.f31623d = (EntelechyUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f090a19);
            return cardExtendForumItemHolder;
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.f31625f != i) {
                SkinManager.setBackgroundColor(b(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.f31622c, (int) R.color.CAM_X0105);
                g(this.f31623d, this.f31624e.f15329e);
            }
            this.f31625f = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.obfuscated_res_0x7f090a3f, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }
}
