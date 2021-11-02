package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.f0.g;
import b.a.r0.o0.k.c.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47728e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f47729f;

    /* renamed from: g  reason: collision with root package name */
    public ForumTestView f47730g;

    /* renamed from: h  reason: collision with root package name */
    public g f47731h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47732i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumHeaderView f47733a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendForumHeaderView recommendForumHeaderView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumHeaderView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47733a = recommendForumHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                this.f47733a.destoryForumTip();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumHeaderView f47734a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendForumHeaderView recommendForumHeaderView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendForumHeaderView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47734a = recommendForumHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                if (this.f47734a.f47730g == null || this.f47734a.f47730g.getVisibility() == 8) {
                    this.f47734a.f47732i = false;
                } else {
                    this.f47734a.e();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47728e = 3;
        this.f47732i = true;
        this.j = new a(this, 2921386);
        this.k = new b(this, 2921385);
        this.f47729f = tbPageContext;
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.recom_forum_header_layout, (ViewGroup) this, true);
            ForumTestView forumTestView = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
            this.f47730g = forumTestView;
            forumTestView.setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void destoryForumTip() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.f47731h) == null) {
            return;
        }
        gVar.I();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f47731h == null) {
            g gVar = new g(this.f47729f, this.f47730g);
            this.f47731h = gVar;
            gVar.g0(R.drawable.bg_tip_blue_up);
            this.f47731h.O(32);
            this.f47731h.h0(true);
            this.f47731h.N(3000);
            this.f47731h.k0(0);
            this.f47731h.M(this);
            this.f47731h.m0(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f47728e) {
            return;
        }
        this.f47728e = skinType;
        ForumTestView forumTestView = this.f47730g;
        if (forumTestView != null) {
            forumTestView.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == this.f47730g || this.f47731h == null) {
            return;
        }
        destoryForumTip();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            super.onDetachedFromWindow();
        }
    }

    public void setData(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f47730g.setVisibility(8);
                return;
            }
            this.f47730g.setVisibility(0);
            this.f47730g.setData(list);
            if (this.f47732i) {
                return;
            }
            e();
            this.f47732i = true;
        }
    }

    public void setOnSecectedListener(ForumTestView.c cVar) {
        ForumTestView forumTestView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || (forumTestView = this.f47730g) == null) {
            return;
        }
        forumTestView.setOnSecectedListener(cVar);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            ForumTestView forumTestView = this.f47730g;
            if (forumTestView != null) {
                forumTestView.setPageId(bdUniqueId);
            }
            this.k.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.k);
            this.j.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.j);
        }
    }

    public void unregisterDisappearTipListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
