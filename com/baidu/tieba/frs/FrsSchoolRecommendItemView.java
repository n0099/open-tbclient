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
import d.a.d.e.p.k;
import d.a.p0.s.f0.t.c;
import d.a.q0.u0.z0;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15463b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15464c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15465d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15466e;

    /* renamed from: f  reason: collision with root package name */
    public c f15467f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15468g;

    /* renamed from: h  reason: collision with root package name */
    public z0 f15469h;

    /* renamed from: i  reason: collision with root package name */
    public int f15470i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSchoolRecommendItemView f15471e;

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
            this.f15471e = frsSchoolRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15471e.f15469h == null || k.isEmpty(this.f15471e.f15469h.f64665a.getUserName()) || k.isEmpty(this.f15471e.f15469h.f64665a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f15471e.a().getContext(), this.f15471e.f15469h.f64665a.getUserId(), this.f15471e.f15469h.f64665a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.f15470i = 3;
        this.k = new a(this);
        this.f15468g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15463b = headImageView;
        headImageView.setPageId(this.f15468g);
        this.f15463b.setIsRound(true);
        this.f15464c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15465d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15466e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15467f = cVar;
        cVar.m("1");
        this.f15467f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.a.q0.f1.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof z0)) {
            z0 z0Var = (z0) cVar;
            this.f15469h = z0Var;
            if (StringUtils.isNull(z0Var.f64665a.getUserId())) {
                return;
            }
            this.f15463b.M(this.f15469h.f64665a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15469h.f64665a.getUserName(), 5);
            this.f15465d.setText(StringHelper.cutStringWithEllipsis(this.f15469h.f64665a.getGodUserData().getIntro(), 6));
            this.f15464c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15467f.n(this.f15469h.f64665a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? new FrsSchoolRecommendItemView(view, this.j, this.f15468g) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f15470i != i2) {
                SkinManager.setViewTextColor(this.f15464c, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f15465d, R.color.CAM_X0109);
                this.f15466e.g(i2);
            }
            this.f15470i = i2;
        }
    }
}
