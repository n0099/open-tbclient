package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
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
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f50135a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f50136b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50137c;

    /* renamed from: d  reason: collision with root package name */
    public a f50138d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f50139e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f50140f;

    /* loaded from: classes7.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecentlyVisitedForumListAdapter f50141a;
        public LinearLayout mBottomContainer;
        public ImageView mDeleteView;
        public LinearGradientView mForumBgImage;
        public TextView mForumFollow;
        public BarImageView mForumImage;
        public TextView mForumName;
        public TextView mLiveLabelView;
        public MessageRedDotView mRedDot;
        public View mTopContainer;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f50142e;

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
                this.f50142e = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50142e.f50141a.f50138d == null) {
                    return;
                }
                this.f50142e.f50141a.f50138d.a(this.f50142e);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f50143e;

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
                this.f50143e = forumViewHolder;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    if (this.f50143e.f50141a.f50139e != null) {
                        this.f50143e.f50141a.f50139e.onLongClick(view);
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes7.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ForumViewHolder f50144e;

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
                this.f50144e = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50144e.f50141a.f50140f == null) {
                    return;
                }
                this.f50144e.f50141a.f50140f.onClick(view);
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
            this.f50141a = recentlyVisitedForumListAdapter;
            view.setOnClickListener(new a(this, recentlyVisitedForumListAdapter));
            view.setOnLongClickListener(new b(this, recentlyVisitedForumListAdapter));
            this.mTopContainer = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.mForumImage = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.mForumName = (TextView) view.findViewById(R.id.forum_name);
            this.mRedDot = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.mForumFollow = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.mForumBgImage = linearGradientView;
            linearGradientView.setCornerRadius(l.g(recentlyVisitedForumListAdapter.f50135a.getPageActivity(), R.dimen.tbds10));
            this.mForumBgImage.setRoundMode(3);
            this.mForumBgImage.setVisibility(8);
            this.mRedDot.setThreeDotMode(2);
            this.mRedDot.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.mDeleteView = imageView;
            imageView.setOnClickListener(new c(this, recentlyVisitedForumListAdapter));
            this.mLiveLabelView = (TextView) view.findViewById(R.id.live_label_view);
            this.mBottomContainer = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes7.dex */
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
        this.f50135a = tbPageContext;
    }

    public final void e(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int x = visitedForumData.x();
        TextView textView = forumViewHolder.mForumFollow;
        textView.setText("关注 " + StringHelper.numFormatOverWanNa(x));
    }

    public final void f(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        String forumName = visitedForumData.getForumName();
        if (k.isEmpty(forumName)) {
            forumName = "";
        }
        forumViewHolder.mForumName.setText(forumName);
    }

    public final void g(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.mRedDot.setVisibility(8);
        forumViewHolder.mDeleteView.setVisibility(8);
        forumViewHolder.mLiveLabelView.setVisibility(8);
        if (this.f50137c) {
            forumViewHolder.mDeleteView.setVisibility(0);
            forumViewHolder.mDeleteView.setTag(visitedForumData);
        } else if (!visitedForumData.F()) {
            if (visitedForumData.B() <= 0) {
                forumViewHolder.mRedDot.setVisibility(8);
                return;
            }
            forumViewHolder.mRedDot.setVisibility(0);
            forumViewHolder.mRedDot.refresh(visitedForumData.B());
        } else {
            forumViewHolder.mLiveLabelView.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<VisitedForumData> linkedList = this.f50136b;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public final void h(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo D = visitedForumData.D();
        if (D == null) {
            forumViewHolder.mForumBgImage.setVisibility(0);
            forumViewHolder.mForumBgImage.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.mForumBgImage;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(D.day, D.night, D.dark);
            forumViewHolder.mForumBgImage.setVisibility(0);
        }
    }

    public void setData(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, linkedList) == null) {
            this.f50136b = linkedList;
        }
    }

    public void setDeleteClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f50140f = onClickListener;
        }
    }

    public void setEditState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f50137c = z;
            notifyDataSetChanged();
        }
    }

    public void setItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f50138d = aVar;
        }
    }

    public void setItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onLongClickListener) == null) {
            this.f50139e = onLongClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        LinkedList<VisitedForumData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, forumViewHolder, i2) == null) || forumViewHolder == null || (linkedList = this.f50136b) == null || linkedList.get(i2) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f50136b.get(i2);
        forumViewHolder.itemView.setTag(visitedForumData);
        f(visitedForumData, forumViewHolder);
        e(visitedForumData, forumViewHolder);
        g(visitedForumData, forumViewHolder);
        forumViewHolder.mForumImage.startLoad(visitedForumData.y(), 10, false);
        forumViewHolder.mForumImage.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.mForumImage.setStrokeWith(3);
        forumViewHolder.mForumImage.setShowOval(true);
        h(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.mDeleteView, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.mForumName, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.mForumFollow, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f50135a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f50135a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f50135a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.mBottomContainer);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) ? new ForumViewHolder(this, this.f50135a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null)) : (ForumViewHolder) invokeLI.objValue;
    }
}
