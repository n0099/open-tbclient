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
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.k.q;
import c.a.r0.d1.b1;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
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
/* loaded from: classes10.dex */
public class CardItemInfoAlbumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f44531e;

    /* renamed from: f  reason: collision with root package name */
    public c f44532f;

    /* renamed from: g  reason: collision with root package name */
    public final List<AlbumElement> f44533g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<String> f44534h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f44535i;

    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoAlbumLayout a;

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
            this.a = cardItemInfoAlbumLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.a.f44533g.size()) {
                        rect.set(0, 0, l.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X004), 0);
                        return;
                    }
                }
                rect.set(l.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), 0, l.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X004), 0);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f44536e;

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
            this.f44536e = cardItemInfoAlbumLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ListUtils.getItem(this.f44536e.f44533g, i2) == null) {
                return;
            }
            AlbumElement albumElement = (AlbumElement) ListUtils.getItem(this.f44536e.f44533g, i2);
            if (albumElement.album_type.intValue() == 1) {
                SimpleVideoPlayActivityConfig.b bVar = new SimpleVideoPlayActivityConfig.b();
                bVar.d(albumElement.album_thumb_url);
                bVar.e(albumElement.album_url);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar.c(this.f44536e.getContext())));
            } else {
                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                bVar2.x(this.f44536e.f44534h);
                bVar2.B(i2 - (ListUtils.getCount(this.f44536e.f44533g) - ListUtils.getCount(this.f44536e.f44534h)));
                bVar2.C(true);
                bVar2.J((String) ListUtils.getItem(this.f44536e.f44534h, ListUtils.getCount(this.f44536e.f44534h) - 1));
                bVar2.F(true);
                bVar2.H(true);
                ImageViewerConfig v = bVar2.v(this.f44536e.getContext());
                v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
                v.getIntent().putExtra("from", "index");
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.s.g0.p.b(1, i2 + 1, albumElement.album_type.intValue())));
        }
    }

    /* loaded from: classes10.dex */
    public class c extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoAlbumLayout a;

        /* loaded from: classes10.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final TbImageView a;

            /* renamed from: b  reason: collision with root package name */
            public final View f44537b;

            /* renamed from: c  reason: collision with root package name */
            public final ImageView f44538c;

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
                TbImageView tbImageView = (TbImageView) view.findViewById(f1.frs_item_album_image);
                this.a = tbImageView;
                tbImageView.setConrers(15);
                this.a.setRadiusById(i1.J_X05);
                this.a.setDrawCorner(true);
                this.a.setPlaceHolder(3);
                this.a.setPageId(j.a(view.getContext()).getUniqueId());
                View findViewById = view.findViewById(f1.frs_item_album_video_mask);
                this.f44537b = findViewById;
                c.a.q0.s.u.c.d(findViewById).s(b1.Mask_X001);
                c.a.q0.s.u.c.d(this.f44537b).n(i1.J_X05);
                this.f44538c = (ImageView) view.findViewById(f1.frs_item_album_video_play);
            }

            public void a(AlbumElement albumElement) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, albumElement) == null) || albumElement == null) {
                    return;
                }
                if (albumElement.album_type.intValue() != 1 && albumElement.album_height.intValue() > 0 && albumElement.album_width.intValue() > 0) {
                    this.a.getLayoutParams().width = (albumElement.album_width.intValue() * this.a.getLayoutParams().height) / albumElement.album_height.intValue();
                } else {
                    this.a.getLayoutParams().width = l.f(this.itemView.getContext(), d1.tbds580);
                }
                this.a.startLoad(albumElement.album_thumb_url, 10, false);
                b(albumElement.album_type.intValue() == 1);
            }

            public final void b(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f44537b.setVisibility(z ? 0 : 8);
                    this.f44538c.setVisibility(z ? 0 : 8);
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
            this.a = cardItemInfoAlbumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || ListUtils.getItem(this.a.f44533g, i2) == null) {
                return;
            }
            aVar.a((AlbumElement) ListUtils.getItem(this.a.f44533g, i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                a aVar = new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g1.frs_item_album_view, (ViewGroup) null));
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
                if (this.a.f44533g == null) {
                    return 0;
                }
                return this.a.f44533g.size();
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
        this.f44533g = new ArrayList();
        this.f44534h = new ArrayList<>();
        this.f44535i = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setOrientation(0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f44531e = bdRecyclerView;
            bdRecyclerView.setPadding(0, l.f(TbadkCoreApplication.getInst().getContext(), d1.M_H_X004), 0, 0);
            this.f44531e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f44531e.addItemDecoration(new a(this));
            this.f44531e.setNestedScrollingEnabled(false);
            this.f44531e.setOnItemClickListener(new b(this));
            addView(this.f44531e, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.f44532f = cVar;
            this.f44531e.setAdapter(cVar);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f44532f.notifyDataSetChanged();
            SkinManager.setBackgroundColor(this, c1.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f44535i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f44531e.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f44535i.x - motionEvent.getX()) > Math.abs(this.f44535i.y - motionEvent.getY())) {
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
            this.f44533g.clear();
            this.f44534h.clear();
            for (AlbumElement albumElement : list) {
                if (!StringUtils.isNull(albumElement.album_thumb_url)) {
                    this.f44533g.add(albumElement);
                    if (albumElement != null && albumElement.album_type.intValue() != 1) {
                        this.f44534h.add(albumElement.album_url);
                    }
                }
            }
            this.f44531e.setVisibility(ListUtils.isEmpty(this.f44533g) ? 8 : 0);
            this.f44532f.notifyDataSetChanged();
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
        this.f44533g = new ArrayList();
        this.f44534h = new ArrayList<>();
        this.f44535i = new Point();
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
        this.f44533g = new ArrayList();
        this.f44534h = new ArrayList<>();
        this.f44535i = new Point();
        c();
    }
}
