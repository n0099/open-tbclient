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
import d.a.q0.a0.e0.g;
import d.a.q0.f1.b.c;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14528b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14529c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14530d;

    /* renamed from: e  reason: collision with root package name */
    public g f14531e;

    /* renamed from: f  reason: collision with root package name */
    public int f14532f;

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
        this.f14528b = null;
        this.f14529c = null;
        this.f14530d = null;
        this.f14532f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && (cVar instanceof g)) {
                g gVar = (g) cVar;
                this.f14531e = gVar;
                this.f14528b.setTag(gVar.f54348b);
                this.f14528b.setTag(R.id.tag_forum_name, this.f14531e.f54349c);
                this.f14528b.M(this.f14531e.f54348b, 15, false);
                TextView textView = this.f14529c;
                textView.setText(StringHelper.getFixedText(this.f14531e.f54349c, 4, true) + a().getContext().getResources().getString(R.string.forum));
                this.f14529c.setTag(R.id.tag_forum_name, this.f14531e.f54349c);
                this.f14530d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14531e.f54350d));
                this.f14530d.setTag(R.id.tag_forum_name, this.f14531e.f54349c);
                a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14531e.f54350d));
                a().setTag(R.id.tag_forum_name, this.f14531e.f54349c);
                f(this.f14530d, this.f14531e.f54351e);
                this.f14528b.setOnClickListener(this.f17108a);
                this.f14530d.setOnClickListener(this.f17108a);
                this.f14529c.setOnClickListener(this.f17108a);
                a().setOnClickListener(this.f17108a);
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
            cardExtendForumItemHolder.f14528b = barImageView;
            barImageView.setGifIconSupport(false);
            cardExtendForumItemHolder.f14529c = (TextView) view.findViewById(R.id.m_forum_name_textview);
            cardExtendForumItemHolder.f14530d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
            return cardExtendForumItemHolder;
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f14532f != i2) {
                SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.f14529c, R.color.CAM_X0105);
                f(this.f14530d, this.f14531e.f54351e);
            }
            this.f14532f = i2;
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
