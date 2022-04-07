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
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ni;
import com.repackage.o37;
import com.repackage.ov4;
import com.repackage.ye6;
/* loaded from: classes3.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public EntelechyUserLikeButton e;
    public ov4 f;
    public BdUniqueId g;
    public ye6 h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.h == null || ni.isEmpty(this.a.h.a.getUserName()) || ni.isEmpty(this.a.h.a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.b().getContext(), this.a.h.a.getUserId(), this.a.h.a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919c2);
        this.b = headImageView;
        headImageView.setPageId(this.g);
        this.b.setIsRound(true);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c1);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919bf);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0919c0);
        this.e = entelechyUserLikeButton;
        ov4 ov4Var = new ov4(tbPageContext, entelechyUserLikeButton);
        this.f = ov4Var;
        ov4Var.m("1");
        this.f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void c(o37 o37Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, o37Var) == null) && (o37Var instanceof ye6)) {
            ye6 ye6Var = (ye6) o37Var;
            this.h = ye6Var;
            if (StringUtils.isNull(ye6Var.a.getUserId())) {
                return;
            }
            this.b.K(this.h.a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.h.a.getUserName(), 5);
            this.d.setText(StringHelper.cutStringWithEllipsis(this.h.a.getGodUserData().getIntro(), 6));
            this.c.setText(cutStringWithEllipsis);
            b().setOnClickListener(this.k);
            this.f.n(this.h.a);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) ? new FrsSchoolRecommendItemView(view2, this.j, this.g) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void e(int i) {
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
}
