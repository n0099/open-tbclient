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
import com.baidu.tieba.bh7;
import com.baidu.tieba.bi;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.tieba.m88;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public EntelechyUserLikeButton e;
    public za5 f;
    public BdUniqueId g;
    public bh7 h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null && !bi.isEmpty(this.a.h.a.getUserName()) && !bi.isEmpty(this.a.h.a.getUserId())) {
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
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e2c);
        this.b = headImageView;
        headImageView.setPageId(this.g);
        this.b.setIsRound(true);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e2b);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e29);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f091e2a);
        this.e = entelechyUserLikeButton;
        za5 za5Var = new za5(tbPageContext, entelechyUserLikeButton);
        this.f = za5Var;
        za5Var.k("1");
        this.f.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return new FrsSchoolRecommendItemView(view2, this.j, this.g);
        }
        return (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
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
    public void b(m88 m88Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, m88Var) != null) || !(m88Var instanceof bh7)) {
            return;
        }
        bh7 bh7Var = (bh7) m88Var;
        this.h = bh7Var;
        if (StringUtils.isNull(bh7Var.a.getUserId())) {
            return;
        }
        this.b.startLoad(this.h.a.getPortrait(), 28, false);
        String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.h.a.getUserName(), 5);
        this.d.setText(StringHelper.cutStringWithEllipsis(this.h.a.getGodUserData().getIntro(), 6));
        this.c.setText(cutStringWithEllipsis);
        getView().setOnClickListener(this.k);
        this.f.l(this.h.a);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
