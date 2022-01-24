package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.s.k0.t.c;
import c.a.t0.e1.k1;
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
/* loaded from: classes12.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_USR_DESCRIBE = 6;
    public static final int MAX_USR_NAME = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f43133b;

    /* renamed from: c  reason: collision with root package name */
    public k1 f43134c;

    /* renamed from: d  reason: collision with root package name */
    public int f43135d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f43136e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f43137f;
    public TextView rec_user_describe;
    public EntelechyUserLikeButton rec_user_like;
    public TextView rec_user_name;
    public HeadImageView rec_usr_header;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSchoolRecommendItemView f43138e;

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
            this.f43138e = frsSchoolRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43138e.f43134c == null || m.isEmpty(this.f43138e.f43134c.a.getUserName()) || m.isEmpty(this.f43138e.f43134c.a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f43138e.getView().getContext(), this.f43138e.f43134c.a.getUserId(), this.f43138e.f43134c.a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.f43135d = 3;
        this.f43137f = new a(this);
        this.f43133b = bdUniqueId;
        this.f43136e = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.rec_usr_header = headImageView;
        headImageView.setPageId(this.f43133b);
        this.rec_usr_header.setIsRound(true);
        this.rec_user_name = (TextView) view.findViewById(R.id.rec_user_name);
        this.rec_user_describe = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.rec_user_like = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.a = cVar;
        cVar.m("1");
        this.a.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void bindDataToView(c.a.t0.q1.b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof k1)) {
            k1 k1Var = (k1) cVar;
            this.f43134c = k1Var;
            if (StringUtils.isNull(k1Var.a.getUserId())) {
                return;
            }
            this.rec_usr_header.startLoad(this.f43134c.a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f43134c.a.getUserName(), 5);
            this.rec_user_describe.setText(StringHelper.cutStringWithEllipsis(this.f43134c.a.getGodUserData().getIntro(), 6));
            this.rec_user_name.setText(cutStringWithEllipsis);
            getView().setOnClickListener(this.f43137f);
            this.a.n(this.f43134c.a);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder createItemViewHolder(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? new FrsSchoolRecommendItemView(view, this.f43136e, this.f43133b) : (ItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f43135d != i2) {
                SkinManager.setViewTextColor(this.rec_user_name, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.rec_user_describe, R.color.CAM_X0109);
                this.rec_user_like.onChangeSkinType(i2);
            }
            this.f43135d = i2;
        }
    }
}
