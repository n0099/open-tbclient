package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.o0.r.l0.t.c;
import c.a.p0.f1.a1;
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
/* loaded from: classes5.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f32311b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32312c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32313d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f32314e;

    /* renamed from: f  reason: collision with root package name */
    public c f32315f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f32316g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f32317h;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f32317h == null || m.isEmpty(this.a.f32317h.a.getUserName()) || m.isEmpty(this.a.f32317h.a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.b().getContext(), this.a.f32317h.a.getUserId(), this.a.f32317h.a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.f32316g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f0919d2);
        this.f32311b = headImageView;
        headImageView.setPageId(this.f32316g);
        this.f32311b.setIsRound(true);
        this.f32312c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919d1);
        this.f32313d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919cf);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f0919d0);
        this.f32314e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f32315f = cVar;
        cVar.m("1");
        this.f32315f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void c(c.a.p0.r1.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof a1)) {
            a1 a1Var = (a1) cVar;
            this.f32317h = a1Var;
            if (StringUtils.isNull(a1Var.a.getUserId())) {
                return;
            }
            this.f32311b.J(this.f32317h.a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f32317h.a.getUserName(), 5);
            this.f32313d.setText(StringHelper.cutStringWithEllipsis(this.f32317h.a.getGodUserData().getIntro(), 6));
            this.f32312c.setText(cutStringWithEllipsis);
            b().setOnClickListener(this.k);
            this.f32315f.n(this.f32317h.a);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? new FrsSchoolRecommendItemView(view, this.j, this.f32316g) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.i != i) {
                SkinManager.setViewTextColor(this.f32312c, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f32313d, (int) R.color.CAM_X0109);
                this.f32314e.g(i);
            }
            this.i = i;
        }
    }
}
