package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
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
import d.a.s0.a0.e0.g;
import d.a.s0.f1.b.c;
/* loaded from: classes5.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14441b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14442c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14443d;

    /* renamed from: e  reason: collision with root package name */
    public g f14444e;

    /* renamed from: f  reason: collision with root package name */
    public int f14445f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardExtendForumItemHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f14441b = null;
        this.f14442c = null;
        this.f14443d = null;
        this.f14445f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && (cVar instanceof g)) {
                g gVar = (g) cVar;
                this.f14444e = gVar;
                this.f14441b.setTag(gVar.f57060b);
                this.f14441b.setTag(R.id.tag_forum_name, this.f14444e.f57061c);
                this.f14441b.M(this.f14444e.f57060b, 15, false);
                TextView textView = this.f14442c;
                textView.setText(StringHelper.getFixedText(this.f14444e.f57061c, 4, true) + a().getContext().getResources().getString(R.string.forum));
                this.f14442c.setTag(R.id.tag_forum_name, this.f14444e.f57061c);
                this.f14443d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14444e.f57062d));
                this.f14443d.setTag(R.id.tag_forum_name, this.f14444e.f57061c);
                a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14444e.f57062d));
                a().setTag(R.id.tag_forum_name, this.f14444e.f57061c);
                f(this.f14443d, this.f14444e.f57063e);
                this.f14441b.setOnClickListener(this.f17013a);
                this.f14443d.setOnClickListener(this.f17013a);
                this.f14442c.setOnClickListener(this.f17013a);
                a().setOnClickListener(this.f17013a);
            }
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            cardExtendForumItemHolder.f14441b = barImageView;
            barImageView.setGifIconSupport(false);
            cardExtendForumItemHolder.f14442c = (TextView) view.findViewById(R.id.m_forum_name_textview);
            cardExtendForumItemHolder.f14443d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
            return cardExtendForumItemHolder;
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f14445f != i2) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.f14442c, R.color.CAM_X0105);
                f(this.f14443d, this.f14444e.f57063e);
            }
            this.f14445f = i2;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void f(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }
}
