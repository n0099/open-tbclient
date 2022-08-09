package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.qi;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public LinkedList<VisitedForumData> b;
    public boolean c;
    public a d;
    public View.OnLongClickListener e;
    public View.OnClickListener f;

    /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g.d == null) {
                    return;
                }
                this.a.g.d.a(this.a);
            }
        }

        /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g.f == null) {
                    return;
                }
                this.a.g.f.onClick(view2);
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
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f092239);
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a5f);
            this.d = barImageView;
            barImageView.setShowOval(true);
            this.d.setShowOuterBorder(false);
            this.d.setShowInnerBorder(true);
            this.d.setStrokeWith(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds3));
            this.d.setStrokeColorResId(R.color.CAM_X0401);
            this.d.setPlaceHolderAutoChangeSkinType(1);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a73);
            this.e = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f091b77);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a52);
            this.e.setThreeDotMode(2);
            this.e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090777);
            this.f = imageView;
            imageView.setOnClickListener(new c(this, recentlyVisitedForumListAdapter));
        }
    }

    /* loaded from: classes3.dex */
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        LinkedList<VisitedForumData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, forumViewHolder, i) == null) || forumViewHolder == null || (linkedList = this.b) == null || linkedList.get(i) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.b.get(i);
        forumViewHolder.itemView.setTag(visitedForumData);
        o(visitedForumData, forumViewHolder);
        n(visitedForumData, forumViewHolder);
        p(visitedForumData, forumViewHolder);
        forumViewHolder.d.K(visitedForumData.getForumImageUrl(), 10, false);
        forumViewHolder.d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.d.setStrokeWith(3);
        forumViewHolder.d.setShowOval(true);
        q(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.b, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.c, (int) R.color.CAM_X0109);
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
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new ForumViewHolder(this, this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d074c, (ViewGroup) null)) : (ForumViewHolder) invokeLI.objValue;
    }

    public void i(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
            notifyDataSetChanged();
        }
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public void m(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.e = onLongClickListener;
        }
    }

    public final void n(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int followNumber = visitedForumData.getFollowNumber();
        TextView textView = forumViewHolder.c;
        textView.setText("关注 " + StringHelper.numFormatOverWanNa(followNumber));
    }

    public final void o(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        String forumName = visitedForumData.getForumName();
        if (pi.isEmpty(forumName)) {
            forumName = "";
        }
        forumViewHolder.b.setText(forumName);
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, visitedForumData, forumViewHolder) == null) || visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.e.setVisibility(8);
        forumViewHolder.f.setVisibility(8);
        if (this.c) {
            forumViewHolder.f.setVisibility(0);
            forumViewHolder.f.setTag(visitedForumData);
        } else if (visitedForumData.isAlaForum()) {
        } else {
            if (visitedForumData.getRedCount() <= 0) {
                forumViewHolder.e.setVisibility(8);
                return;
            }
            forumViewHolder.e.setVisibility(0);
            forumViewHolder.e.f(visitedForumData.getRedCount());
        }
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, visitedForumData, forumViewHolder) != null) || visitedForumData == null || forumViewHolder == null || visitedForumData.getThemeColorInfo() == null) {
        }
    }
}
