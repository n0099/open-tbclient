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
import d.a.c.e.p.k;
import d.a.r0.r.f0.s.c;
import d.a.s0.u0.z0;
/* loaded from: classes5.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15376b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15377c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15378d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15379e;

    /* renamed from: f  reason: collision with root package name */
    public c f15380f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15381g;

    /* renamed from: h  reason: collision with root package name */
    public z0 f15382h;

    /* renamed from: i  reason: collision with root package name */
    public int f15383i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSchoolRecommendItemView f15384e;

        public a(FrsSchoolRecommendItemView frsSchoolRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15384e = frsSchoolRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15384e.f15382h == null || k.isEmpty(this.f15384e.f15382h.f67237a.getUserName()) || k.isEmpty(this.f15384e.f15382h.f67237a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f15384e.a().getContext(), this.f15384e.f15382h.f67237a.getUserId(), this.f15384e.f15382h.f67237a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
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
        this.f15383i = 3;
        this.k = new a(this);
        this.f15381g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15376b = headImageView;
        headImageView.setPageId(this.f15381g);
        this.f15376b.setIsRound(true);
        this.f15377c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15378d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15379e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15380f = cVar;
        cVar.m("1");
        this.f15380f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.a.s0.f1.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof z0)) {
            z0 z0Var = (z0) cVar;
            this.f15382h = z0Var;
            if (StringUtils.isNull(z0Var.f67237a.getUserId())) {
                return;
            }
            this.f15376b.M(this.f15382h.f67237a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15382h.f67237a.getUserName(), 5);
            this.f15378d.setText(StringHelper.cutStringWithEllipsis(this.f15382h.f67237a.getGodUserData().getIntro(), 6));
            this.f15377c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15380f.n(this.f15382h.f67237a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? new FrsSchoolRecommendItemView(view, this.j, this.f15381g) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f15383i != i2) {
                SkinManager.setViewTextColor(this.f15377c, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f15378d, R.color.CAM_X0109);
                this.f15379e.g(i2);
            }
            this.f15383i = i2;
        }
    }
}
