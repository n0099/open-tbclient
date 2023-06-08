package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.h15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class hn6<T extends h15> extends in6<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public BdUniqueId j;
    public T k;
    public ThreadCommentAndPraiseInfoLayout l;
    public ThreadCommentAndPraiseInfoLayout m;
    public NEGFeedBackView n;
    public UnfollowedDecorView o;
    public FollowUserDecorView p;
    public ForumEnterLayout q;
    public boolean r;
    public boolean s;
    public boolean t;
    public View u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn6(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = null;
        this.r = false;
        this.s = false;
        this.t = false;
    }

    public void F(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewGroup) == null) {
            I(viewGroup, J(viewGroup));
            K(viewGroup);
            H();
            if (u()) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.setVisibility(8);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setVisibility(8);
                }
                View view2 = this.u;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else {
                G();
            }
            r();
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.t = z;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
        }
    }

    public void D(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (nEGFeedBackView = this.n) != null) {
            nEGFeedBackView.setEventCallback(bVar);
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.h = i;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.U = i;
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.U = i;
            }
        }
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return vi.g(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        o(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.n;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.p;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void C(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) && view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void G() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (t = this.k) != null && t.getThreadData() != null) {
            ThreadData threadData = this.k.getThreadData();
            this.l.setVisibility(8);
            this.m.setData(threadData);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            C(this.l, 0);
            C(this.m, 0);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (t = this.k) != null && t.getThreadData() != null && this.q != null) {
            if (this.k.showCardEnterFourm()) {
                this.q.setData(this.k.getThreadData());
            } else if (this.r) {
                this.q.setData(this.k.getThreadData());
            }
        }
    }

    public final void I(ViewGroup viewGroup, boolean z) {
        T t;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, z) == null) && (t = this.k) != null && t.getThreadData() != null) {
            if (this.p == null) {
                FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.i.getPageActivity());
                this.p = followUserDecorView;
                followUserDecorView.setIsShowIcon(this.s);
                viewGroup.addView(this.p);
            }
            if (x()) {
                this.p.setPageUniqueId(this.j);
                this.p.setSvgIconResId(0);
                int s = s(R.dimen.tbds177);
                int s2 = s(R.dimen.tbds76);
                if (z) {
                    i = R.dimen.tbds126;
                } else {
                    i = R.dimen.tbds44;
                }
                int s3 = s(i);
                int s4 = s(R.dimen.tbds52);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, s2);
                layoutParams.topMargin = s4;
                layoutParams.rightMargin = s3;
                layoutParams.gravity = 53;
                this.p.setLayoutParams(layoutParams);
                this.p.setData(this.k.getThreadData());
                return;
            }
            FollowUserDecorView followUserDecorView2 = this.p;
            if (followUserDecorView2 != null) {
                followUserDecorView2.setVisibility(8);
            }
        }
    }

    public final boolean J(ViewGroup viewGroup) {
        InterceptResult invokeL;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null) {
                return false;
            }
            if (this.k.getThreadData() != null && (sparseArray = this.k.feedBackReasonMap) != null && sparseArray.size() > 0) {
                if (this.n == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(g());
                    this.n = nEGFeedBackView;
                    viewGroup.addView(nEGFeedBackView);
                }
                this.n.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, g);
                layoutParams.rightMargin = g3;
                layoutParams.topMargin = g4;
                layoutParams.gravity = 53;
                this.n.setPadding(g2, g2, g2, g2);
                this.n.setLayoutParams(layoutParams);
                g35 g35Var = new g35();
                g35Var.o(this.k.getThreadData().getTid());
                g35Var.k(this.k.getThreadData().getFid());
                g35Var.n(this.k.getThreadData().getNid());
                g35Var.j(this.k.feedBackReasonMap);
                this.n.setVisibility(0);
                this.n.setData(g35Var);
                this.n.setFirstRowSingleColumn(true);
                return true;
            }
            NEGFeedBackView nEGFeedBackView2 = this.n;
            if (nEGFeedBackView2 == null) {
                return false;
            }
            nEGFeedBackView2.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void K(ViewGroup viewGroup) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) && (t = this.k) != null && t.getThreadData() != null) {
            if (this.o == null) {
                UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.i.getPageActivity());
                this.o = unfollowedDecorView;
                viewGroup.addView(unfollowedDecorView);
            }
            if (this.k.getThreadData().isFromConcern && !ThreadCardUtils.isSelf(this.k.getThreadData())) {
                this.o.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, g);
                layoutParams.rightMargin = g3;
                layoutParams.topMargin = g4;
                layoutParams.gravity = 53;
                this.o.setPadding(g2, g2, g2, g2);
                this.o.setLayoutParams(layoutParams);
                this.o.setVisibility(0);
                this.o.n(this.k.getThreadData());
                return;
            }
            UnfollowedDecorView unfollowedDecorView2 = this.o;
            if (unfollowedDecorView2 != null) {
                unfollowedDecorView2.setVisibility(8);
            }
        }
    }

    public void t(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, threadCommentAndPraiseInfoLayout) != null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnClickListener(this);
        threadCommentAndPraiseInfoLayout.setReplyTimeVisible(false);
        threadCommentAndPraiseInfoLayout.setShowPraiseNum(true);
        threadCommentAndPraiseInfoLayout.setCommentNumEnable(true);
        threadCommentAndPraiseInfoLayout.setNeedAddReplyIcon(true);
        threadCommentAndPraiseInfoLayout.setNeedAddPraiseIcon(true);
        if (threadCommentAndPraiseInfoLayout.getCommentContainer() != null) {
            threadCommentAndPraiseInfoLayout.getCommentContainer().setOnClickListener(this);
        }
        threadCommentAndPraiseInfoLayout.setShareVisible(true);
        threadCommentAndPraiseInfoLayout.setFrom(7);
        threadCommentAndPraiseInfoLayout.setShareReportFrom(3);
        threadCommentAndPraiseInfoLayout.hideDisagree();
        n15 n15Var = new n15();
        n15Var.b = 7;
        n15Var.h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(n15Var);
    }

    public final boolean x() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null || this.k.getThreadData().getAuthor() == null) {
                return false;
            }
            ThreadData threadData = this.k.getThreadData();
            if (ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            if (!threadData.isBjhDynamicThread() && !threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                z = false;
            } else {
                z = true;
            }
            if ((!z || !threadData.isFromHomPage) && (!z || !threadData.isFromVideoTab || threadData.getAuthor().hadConcerned())) {
                if (threadData.getThreadAlaInfo() == null || !vo6.X(threadData)) {
                    return false;
                }
                if (!threadData.isFromHomPage && !threadData.isFromFeedTab) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i) == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.onChangeSkinType();
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.onChangeSkinType();
            }
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.u();
            }
            UnfollowedDecorView unfollowedDecorView = this.o;
            if (unfollowedDecorView != null) {
                unfollowedDecorView.p();
            }
            ForumEnterLayout forumEnterLayout = this.q;
            if (forumEnterLayout != null) {
                forumEnterLayout.n(tbPageContext, i);
            }
            FollowUserDecorView followUserDecorView = this.p;
            if (followUserDecorView != null) {
                followUserDecorView.onChangeSkinType(i);
            }
        }
    }
}
