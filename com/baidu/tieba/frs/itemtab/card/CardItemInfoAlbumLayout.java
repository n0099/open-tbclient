package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.l.q;
import b.a.r0.x0.a1;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlbumElement;
/* loaded from: classes9.dex */
public class CardItemInfoAlbumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f48812e;

    /* renamed from: f  reason: collision with root package name */
    public c f48813f;

    /* renamed from: g  reason: collision with root package name */
    public final List<AlbumElement> f48814g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<String> f48815h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f48816i;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f48817a;

        public a(CardItemInfoAlbumLayout cardItemInfoAlbumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoAlbumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48817a = cardItemInfoAlbumLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.f48817a.f48814g.size()) {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X004), 0);
                        return;
                    }
                }
                rect.set(l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X005), 0, l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X004), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f48818e;

        public b(CardItemInfoAlbumLayout cardItemInfoAlbumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoAlbumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48818e = cardItemInfoAlbumLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || ListUtils.getItem(this.f48818e.f48814g, i2) == null) {
                return;
            }
            AlbumElement albumElement = (AlbumElement) ListUtils.getItem(this.f48818e.f48814g, i2);
            if (albumElement.album_type.intValue() == 1) {
                SimpleVideoPlayActivityConfig.b bVar = new SimpleVideoPlayActivityConfig.b();
                bVar.d(albumElement.album_thumb_url);
                bVar.e(albumElement.album_url);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar.c(this.f48818e.getContext())));
            } else {
                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                bVar2.x(this.f48818e.f48815h);
                bVar2.B(i2 - (ListUtils.getCount(this.f48818e.f48814g) - ListUtils.getCount(this.f48818e.f48815h)));
                bVar2.C(true);
                bVar2.J((String) ListUtils.getItem(this.f48818e.f48815h, ListUtils.getCount(this.f48818e.f48815h) - 1));
                bVar2.F(true);
                bVar2.H(true);
                ImageViewerConfig v = bVar2.v(this.f48818e.getContext());
                v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
                v.getIntent().putExtra("from", "index");
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b.a.q0.s.g0.p.b(1, i2 + 1, albumElement.album_type.intValue())));
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f48819a;

        /* loaded from: classes9.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final TbImageView f48820a;

            /* renamed from: b  reason: collision with root package name */
            public final View f48821b;

            /* renamed from: c  reason: collision with root package name */
            public final ImageView f48822c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NonNull c cVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view};
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
                TbImageView tbImageView = (TbImageView) view.findViewById(e1.frs_item_album_image);
                this.f48820a = tbImageView;
                tbImageView.setConrers(15);
                this.f48820a.setRadiusById(h1.J_X05);
                this.f48820a.setDrawCorner(true);
                this.f48820a.setPlaceHolder(3);
                this.f48820a.setPageId(j.a(view.getContext()).getUniqueId());
                View findViewById = view.findViewById(e1.frs_item_album_video_mask);
                this.f48821b = findViewById;
                b.a.q0.s.u.c.d(findViewById).s(a1.Mask_X001);
                b.a.q0.s.u.c.d(this.f48821b).n(h1.J_X05);
                this.f48822c = (ImageView) view.findViewById(e1.frs_item_album_video_play);
            }

            public void a(AlbumElement albumElement) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, albumElement) == null) || albumElement == null) {
                    return;
                }
                if (albumElement.album_type.intValue() != 1 && albumElement.album_height.intValue() > 0 && albumElement.album_width.intValue() > 0) {
                    this.f48820a.getLayoutParams().width = (albumElement.album_width.intValue() * this.f48820a.getLayoutParams().height) / albumElement.album_height.intValue();
                } else {
                    this.f48820a.getLayoutParams().width = l.g(this.itemView.getContext(), c1.tbds580);
                }
                this.f48820a.startLoad(albumElement.album_thumb_url, 10, false);
                b(albumElement.album_type.intValue() == 1);
            }

            public final void b(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f48821b.setVisibility(z ? 0 : 8);
                    this.f48822c.setVisibility(z ? 0 : 8);
                }
            }

            public void onChangeSkinType(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                }
            }
        }

        public c(CardItemInfoAlbumLayout cardItemInfoAlbumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoAlbumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48819a = cardItemInfoAlbumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || ListUtils.getItem(this.f48819a.f48814g, i2) == null) {
                return;
            }
            aVar.a((AlbumElement) ListUtils.getItem(this.f48819a.f48814g, i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                a aVar = new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(f1.frs_item_album_view, (ViewGroup) null));
                aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return aVar;
            }
            return (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f48819a.f48814g == null) {
                    return 0;
                }
                return this.f48819a.f48814g.size();
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoAlbumLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f48814g = new ArrayList();
        this.f48815h = new ArrayList<>();
        this.f48816i = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setOrientation(0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f48812e = bdRecyclerView;
            bdRecyclerView.setPadding(0, l.g(TbadkCoreApplication.getInst().getContext(), c1.M_H_X004), 0, 0);
            this.f48812e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f48812e.addItemDecoration(new a(this));
            this.f48812e.setNestedScrollingEnabled(false);
            this.f48812e.setOnItemClickListener(new b(this));
            addView(this.f48812e, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.f48813f = cVar;
            this.f48812e.setAdapter(cVar);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f48813f.notifyDataSetChanged();
            SkinManager.setBackgroundColor(this, b1.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f48816i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f48812e.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f48816i.x - motionEvent.getX()) > Math.abs(this.f48816i.y - motionEvent.getY())) {
                            z = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setData(List<AlbumElement> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f48814g.clear();
            this.f48815h.clear();
            for (AlbumElement albumElement : list) {
                if (!StringUtils.isNull(albumElement.album_thumb_url)) {
                    this.f48814g.add(albumElement);
                    if (albumElement != null && albumElement.album_type.intValue() != 1) {
                        this.f48815h.add(albumElement.album_url);
                    }
                }
            }
            this.f48812e.setVisibility(ListUtils.isEmpty(this.f48814g) ? 8 : 0);
            this.f48813f.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoAlbumLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48814g = new ArrayList();
        this.f48815h = new ArrayList<>();
        this.f48816i = new Point();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoAlbumLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48814g = new ArrayList();
        this.f48815h = new ArrayList<>();
        this.f48816i = new Point();
        c();
    }
}
