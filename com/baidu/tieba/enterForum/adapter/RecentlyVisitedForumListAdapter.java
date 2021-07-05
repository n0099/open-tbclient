package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14590a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f14591b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14592c;

    /* renamed from: d  reason: collision with root package name */
    public a f14593d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f14594e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14595f;

    /* loaded from: classes5.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f14596a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14597b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14598c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f14599d;

        /* renamed from: e  reason: collision with root package name */
        public MessageRedDotView f14600e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14601f;

        /* renamed from: g  reason: collision with root package name */
        public LinearGradientView f14602g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14603h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f14604i;
        public final /* synthetic */ RecentlyVisitedForumListAdapter j;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f14605e;

            public a(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14605e = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14605e.j.f14593d == null) {
                    return;
                }
                this.f14605e.j.f14593d.a(this.f14605e);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f14606e;

            public b(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14606e = forumViewHolder;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    if (this.f14606e.j.f14594e != null) {
                        this.f14606e.j.f14594e.onLongClick(view);
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f14607e;

            public c(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14607e = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14607e.j.f14595f == null) {
                    return;
                }
                this.f14607e.j.f14595f.onClick(view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recentlyVisitedForumListAdapter, view};
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
            this.j = recentlyVisitedForumListAdapter;
            view.setOnClickListener(new a(this, recentlyVisitedForumListAdapter));
            view.setOnLongClickListener(new b(this, recentlyVisitedForumListAdapter));
            this.f14596a = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.f14599d = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.f14597b = (TextView) view.findViewById(R.id.forum_name);
            this.f14600e = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.f14598c = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.f14602g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(recentlyVisitedForumListAdapter.f14590a.getPageActivity(), R.dimen.tbds10));
            this.f14602g.setRoundMode(3);
            this.f14602g.setVisibility(8);
            this.f14600e.setThreeDotMode(2);
            this.f14600e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.f14601f = imageView;
            imageView.setOnClickListener(new c(this, recentlyVisitedForumListAdapter));
            this.f14603h = (TextView) view.findViewById(R.id.live_label_view);
            this.f14604i = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14590a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedList<VisitedForumData> linkedList = this.f14591b;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        LinkedList<VisitedForumData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumViewHolder, i2) == null) || forumViewHolder == null || (linkedList = this.f14591b) == null || linkedList.get(i2) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f14591b.get(i2);
        forumViewHolder.itemView.setTag(visitedForumData);
        p(visitedForumData, forumViewHolder);
        o(visitedForumData, forumViewHolder);
        q(visitedForumData, forumViewHolder);
        forumViewHolder.f14599d.M(visitedForumData.y(), 10, false);
        forumViewHolder.f14599d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.f14599d.setStrokeWith(3);
        forumViewHolder.f14599d.setShowOval(true);
        r(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f14601f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.f14597b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.f14598c, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f14590a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f14590a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f14590a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.f14604i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new ForumViewHolder(this, this.f14590a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null)) : (ForumViewHolder) invokeLI.objValue;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, linkedList) == null) {
            this.f14591b = linkedList;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f14595f = onClickListener;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f14592c = z;
            notifyDataSetChanged();
        }
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f14593d = aVar;
        }
    }

    public void n(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f14594e = onLongClickListener;
        }
    }

    public final void o(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int x = visitedForumData.x();
        TextView textView = forumViewHolder.f14598c;
        textView.setText("关注 " + StringHelper.numFormatOverWanNa(x));
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        String forumName = visitedForumData.getForumName();
        if (k.isEmpty(forumName)) {
            forumName = "";
        }
        forumViewHolder.f14597b.setText(forumName);
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f14600e.setVisibility(8);
        forumViewHolder.f14601f.setVisibility(8);
        forumViewHolder.f14603h.setVisibility(8);
        if (this.f14592c) {
            forumViewHolder.f14601f.setVisibility(0);
            forumViewHolder.f14601f.setTag(visitedForumData);
        } else if (!visitedForumData.F()) {
            if (visitedForumData.B() <= 0) {
                forumViewHolder.f14600e.setVisibility(8);
                return;
            }
            forumViewHolder.f14600e.setVisibility(0);
            forumViewHolder.f14600e.f(visitedForumData.B());
        } else {
            forumViewHolder.f14603h.setVisibility(0);
        }
    }

    public final void r(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo D = visitedForumData.D();
        if (D == null) {
            forumViewHolder.f14602g.setVisibility(0);
            forumViewHolder.f14602g.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.f14602g;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(D.day, D.night, D.dark);
            forumViewHolder.f14602g.setVisibility(0);
        }
    }
}
