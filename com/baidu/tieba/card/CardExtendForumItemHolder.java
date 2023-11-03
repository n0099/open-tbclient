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
import com.baidu.tieba.km6;
import com.baidu.tieba.li8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView b;
    public TextView c;
    public EntelechyUserLikeButton d;
    public km6 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardExtendForumItemHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view2);
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.forum_avatar);
            cardExtendForumItemHolder.b = barImageView;
            barImageView.setGifIconSupport(false);
            cardExtendForumItemHolder.c = (TextView) view2.findViewById(R.id.m_forum_name_textview);
            cardExtendForumItemHolder.d = (EntelechyUserLikeButton) view2.findViewById(R.id.forum_add_love);
            return cardExtendForumItemHolder;
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(li8 li8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, li8Var) == null) {
            if (li8Var != null && (li8Var instanceof km6)) {
                km6 km6Var = (km6) li8Var;
                this.e = km6Var;
                this.b.setTag(km6Var.b);
                this.b.setTag(R.id.tag_forum_name, this.e.c);
                this.b.startLoad(this.e.b, 15, false);
                TextView textView = this.c;
                textView.setText(StringHelper.getFixedText(this.e.c, 4, true) + getView().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0787));
                this.c.setTag(R.id.tag_forum_name, this.e.c);
                this.d.setTag(R.id.tag_forum_id, Long.valueOf(this.e.d));
                this.d.setTag(R.id.tag_forum_name, this.e.c);
                getView().setTag(R.id.tag_forum_id, Long.valueOf(this.e.d));
                getView().setTag(R.id.tag_forum_name, this.e.c);
                e(this.d, this.e.e);
                this.b.setOnClickListener(this.a);
                this.d.setOnClickListener(this.a);
                this.c.setOnClickListener(this.a);
                getView().setOnClickListener(this.a);
            }
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.f != i) {
                SkinManager.setBackgroundColor(getView(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
                e(this.d, this.e.e);
            }
            this.f = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, entelechyUserLikeButton, z) != null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }
}
