package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.tieba.q65;
import com.baidu.tieba.s67;
import com.baidu.tieba.zv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public EntelechyUserLikeButton e;
    public q65 f;
    public BdUniqueId g;
    public s67 h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSchoolRecommendItemView a;

        public a(FrsSchoolRecommendItemView frsSchoolRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSchoolRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null && !hi.isEmpty(this.a.h.a.getUserName()) && !hi.isEmpty(this.a.h.a.getUserId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getView().getContext(), this.a.h.a.getUserId(), this.a.h.a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSchoolRecommendItemView(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
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
        this.i = 3;
        this.k = new a(this);
        this.g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cfd);
        this.b = headImageView;
        headImageView.setPageId(this.g);
        this.b.setIsRound(true);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cfc);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cfa);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f091cfb);
        this.e = entelechyUserLikeButton;
        q65 q65Var = new q65(tbPageContext, entelechyUserLikeButton);
        this.f = q65Var;
        q65Var.m("1");
        this.f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return new FrsSchoolRecommendItemView(view2, this.j, this.g);
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.i != i) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                this.e.g(i);
            }
            this.i = i;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(zv7 zv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zv7Var) != null) || !(zv7Var instanceof s67)) {
            return;
        }
        s67 s67Var = (s67) zv7Var;
        this.h = s67Var;
        if (StringUtils.isNull(s67Var.a.getUserId())) {
            return;
        }
        this.b.N(this.h.a.getPortrait(), 28, false);
        String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.h.a.getUserName(), 5);
        this.d.setText(StringHelper.cutStringWithEllipsis(this.h.a.getGodUserData().getIntro(), 6));
        this.c.setText(cutStringWithEllipsis);
        getView().setOnClickListener(this.k);
        this.f.n(this.h.a);
        c(TbadkCoreApplication.getInst().getSkinType());
    }
}
