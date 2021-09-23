package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import c.a.r0.a0.d0.g;
import c.a.r0.h1.b.c;
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
/* loaded from: classes7.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f50051a;

    /* renamed from: b  reason: collision with root package name */
    public int f50052b;
    public EntelechyUserLikeButton mAddLoveBtnTextView;
    public BarImageView mForumAvatarImageView;
    public TextView mForumNameTextView;

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
        this.mForumAvatarImageView = null;
        this.mForumNameTextView = null;
        this.mAddLoveBtnTextView = null;
        this.f50052b = 3;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.updateLikeStatus(z);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void bindDataToView(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (cVar instanceof g)) {
                g gVar = (g) cVar;
                this.f50051a = gVar;
                this.mForumAvatarImageView.setTag(gVar.f15582b);
                this.mForumAvatarImageView.setTag(R.id.tag_forum_name, this.f50051a.f15583c);
                this.mForumAvatarImageView.startLoad(this.f50051a.f15582b, 15, false);
                TextView textView = this.mForumNameTextView;
                textView.setText(StringHelper.getFixedText(this.f50051a.f15583c, 4, true) + getView().getContext().getResources().getString(R.string.forum));
                this.mForumNameTextView.setTag(R.id.tag_forum_name, this.f50051a.f15583c);
                this.mAddLoveBtnTextView.setTag(R.id.tag_forum_id, Long.valueOf(this.f50051a.f15584d));
                this.mAddLoveBtnTextView.setTag(R.id.tag_forum_name, this.f50051a.f15583c);
                getView().setTag(R.id.tag_forum_id, Long.valueOf(this.f50051a.f15584d));
                getView().setTag(R.id.tag_forum_name, this.f50051a.f15583c);
                a(this.mAddLoveBtnTextView, this.f50051a.f15585e);
                this.mForumAvatarImageView.setOnClickListener(this.onClickListener);
                this.mAddLoveBtnTextView.setOnClickListener(this.onClickListener);
                this.mForumNameTextView.setOnClickListener(this.onClickListener);
                getView().setOnClickListener(this.onClickListener);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder createItemViewHolder(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            cardExtendForumItemHolder.mForumAvatarImageView = barImageView;
            barImageView.setGifIconSupport(false);
            cardExtendForumItemHolder.mForumNameTextView = (TextView) view.findViewById(R.id.m_forum_name_textview);
            cardExtendForumItemHolder.mAddLoveBtnTextView = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
            cardExtendForumItemHolder.textViewResourceId = 16908308;
            return cardExtendForumItemHolder;
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.f50052b != i2) {
                SkinManager.setBackgroundColor(getView(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.mForumNameTextView, R.color.CAM_X0105);
                a(this.mAddLoveBtnTextView, this.f50051a.f15585e);
            }
            this.f50052b = i2;
        }
    }
}
