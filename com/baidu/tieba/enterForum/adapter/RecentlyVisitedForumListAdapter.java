package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public LinkedList<VisitedForumData> b;
    public boolean c;
    public a d;
    public View.OnLongClickListener e;
    public View.OnClickListener f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    /* loaded from: classes5.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public TextView c;
        public BarImageView d;
        public MessageRedDotView e;
        public ImageView f;
        public final /* synthetic */ RecentlyVisitedForumListAdapter g;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ForumViewHolder a;

            public a(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g.d != null) {
                    this.a.g.d.a(this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ForumViewHolder a;

            public b(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = forumViewHolder;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                    if (this.a.g.e != null) {
                        this.a.g.e.onLongClick(view2);
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
            public final /* synthetic */ ForumViewHolder a;

            public c(ForumViewHolder forumViewHolder, RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {forumViewHolder, recentlyVisitedForumListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = forumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g.f != null) {
                    this.a.g.f.onClick(view2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recentlyVisitedForumListAdapter, view2};
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
            this.g = recentlyVisitedForumListAdapter;
            view2.setOnClickListener(new a(this, recentlyVisitedForumListAdapter));
            view2.setOnLongClickListener(new b(this, recentlyVisitedForumListAdapter));
            this.a = view2.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090be0);
            this.d = barImageView;
            barImageView.setShowOval(true);
            this.d.setShowOuterBorder(false);
            this.d.setShowInnerBorder(true);
            this.d.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3));
            this.d.setStrokeColorResId(R.color.CAM_X0401);
            this.d.setPlaceHolderAutoChangeSkinType(1);
            this.b = (TextView) view2.findViewById(R.id.forum_name);
            this.e = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f091e89);
            this.c = (TextView) view2.findViewById(R.id.forum_follow);
            this.e.setThreeDotMode(2);
            this.e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090879);
            this.f = imageView;
            imageView.setOnClickListener(new c(this, recentlyVisitedForumListAdapter));
        }
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void q(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
            notifyDataSetChanged();
        }
    }

    public void t(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public void u(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.e = onLongClickListener;
        }
    }

    public final void A(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, visitedForumData, forumViewHolder) != null) || visitedForumData == null || forumViewHolder == null || visitedForumData.getThemeColorInfo() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            return new ForumViewHolder(this, this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0841, (ViewGroup) null));
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void y(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, visitedForumData, forumViewHolder) == null) && visitedForumData != null && forumViewHolder != null) {
            String forumName = visitedForumData.getForumName();
            if (bi.isEmpty(forumName)) {
                forumName = "";
            }
            forumViewHolder.b.setText(forumName);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList<VisitedForumData> linkedList = this.b;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        LinkedList<VisitedForumData> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumViewHolder, i) == null) && forumViewHolder != null && (linkedList = this.b) != null && linkedList.get(i) != null) {
            VisitedForumData visitedForumData = this.b.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            y(visitedForumData, forumViewHolder);
            x(visitedForumData, forumViewHolder);
            z(visitedForumData, forumViewHolder);
            forumViewHolder.d.startLoad(visitedForumData.getForumImageUrl(), 10, false);
            forumViewHolder.d.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.d.setStrokeWith(3);
            forumViewHolder.d.setShowOval(true);
            A(visitedForumData, forumViewHolder);
            SkinManager.setImageResource(forumViewHolder.f, R.drawable.icon_ba_delete_n);
            SkinManager.setViewTextColor(forumViewHolder.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(forumViewHolder.c, (int) R.color.CAM_X0109);
        }
    }

    public final void x(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, visitedForumData, forumViewHolder) == null) && visitedForumData != null && forumViewHolder != null) {
            int followNumber = visitedForumData.getFollowNumber();
            TextView textView = forumViewHolder.c;
            textView.setText("关注 " + StringHelper.numFormatOverWanNa(followNumber));
        }
    }

    public final void z(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, visitedForumData, forumViewHolder) == null) && visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.e.setVisibility(8);
            forumViewHolder.f.setVisibility(8);
            if (this.c) {
                forumViewHolder.f.setVisibility(0);
                forumViewHolder.f.setTag(visitedForumData);
            } else if (!visitedForumData.isAlaForum()) {
                if (visitedForumData.getRedCount() <= 0) {
                    forumViewHolder.e.setVisibility(8);
                    return;
                }
                forumViewHolder.e.setVisibility(0);
                forumViewHolder.e.refresh(visitedForumData.getRedCount());
            }
        }
    }
}
