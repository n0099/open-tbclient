package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.o0.s.f0.t.c;
import c.a.p0.v0.z0;
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
/* loaded from: classes7.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_USR_DESCRIBE = 6;
    public static final int MAX_USR_NAME = 5;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f50636a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f50637b;

    /* renamed from: c  reason: collision with root package name */
    public z0 f50638c;

    /* renamed from: d  reason: collision with root package name */
    public int f50639d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f50640e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f50641f;
    public TextView rec_user_describe;
    public EntelechyUserLikeButton rec_user_like;
    public TextView rec_user_name;
    public HeadImageView rec_usr_header;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSchoolRecommendItemView f50642e;

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
            this.f50642e = frsSchoolRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50642e.f50638c == null || k.isEmpty(this.f50642e.f50638c.f27043a.getUserName()) || k.isEmpty(this.f50642e.f50638c.f27043a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f50642e.getView().getContext(), this.f50642e.f50638c.f27043a.getUserId(), this.f50642e.f50638c.f27043a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.f50639d = 3;
        this.f50641f = new a(this);
        this.f50637b = bdUniqueId;
        this.f50640e = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.rec_usr_header = headImageView;
        headImageView.setPageId(this.f50637b);
        this.rec_usr_header.setIsRound(true);
        this.rec_user_name = (TextView) view.findViewById(R.id.rec_user_name);
        this.rec_user_describe = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.rec_user_like = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f50636a = cVar;
        cVar.m("1");
        this.f50636a.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void bindDataToView(c.a.p0.g1.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof z0)) {
            z0 z0Var = (z0) cVar;
            this.f50638c = z0Var;
            if (StringUtils.isNull(z0Var.f27043a.getUserId())) {
                return;
            }
            this.rec_usr_header.startLoad(this.f50638c.f27043a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f50638c.f27043a.getUserName(), 5);
            this.rec_user_describe.setText(StringHelper.cutStringWithEllipsis(this.f50638c.f27043a.getGodUserData().getIntro(), 6));
            this.rec_user_name.setText(cutStringWithEllipsis);
            getView().setOnClickListener(this.f50641f);
            this.f50636a.n(this.f50638c.f27043a);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder createItemViewHolder(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? new FrsSchoolRecommendItemView(view, this.f50640e, this.f50637b) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f50639d != i2) {
                SkinManager.setViewTextColor(this.rec_user_name, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.rec_user_describe, R.color.CAM_X0109);
                this.rec_user_like.onChangeSkinType(i2);
            }
            this.f50639d = i2;
        }
    }
}
