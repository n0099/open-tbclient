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
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.l.q;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlbumElement;
/* loaded from: classes7.dex */
public class CardItemInfoAlbumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f51483e;

    /* renamed from: f  reason: collision with root package name */
    public c f51484f;

    /* renamed from: g  reason: collision with root package name */
    public final List<AlbumElement> f51485g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<String> f51486h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f51487i;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f51488a;

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
            this.f51488a = cardItemInfoAlbumLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.f51488a.f51485g.size()) {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
                        return;
                    }
                }
                rect.set(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f51489e;

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
            this.f51489e = cardItemInfoAlbumLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ListUtils.getItem(this.f51489e.f51485g, i2) == null) {
                return;
            }
            AlbumElement albumElement = (AlbumElement) ListUtils.getItem(this.f51489e.f51485g, i2);
            if (albumElement.album_type.intValue() == 1) {
                SimpleVideoPlayActivityConfig.b bVar = new SimpleVideoPlayActivityConfig.b();
                bVar.d(albumElement.album_thumb_url);
                bVar.e(albumElement.album_url);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar.c(this.f51489e.getContext())));
            } else {
                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                bVar2.x(this.f51489e.f51486h);
                bVar2.B(i2 - (ListUtils.getCount(this.f51489e.f51485g) - ListUtils.getCount(this.f51489e.f51486h)));
                bVar2.C(true);
                bVar2.J((String) ListUtils.getItem(this.f51489e.f51486h, ListUtils.getCount(this.f51489e.f51486h) - 1));
                bVar2.F(true);
                bVar2.H(true);
                ImageViewerConfig v = bVar2.v(this.f51489e.getContext());
                v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
                v.getIntent().putExtra("from", "index");
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.s.f0.p.b(1, i2 + 1, albumElement.album_type.intValue())));
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoAlbumLayout f51490a;

        /* loaded from: classes7.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final TbImageView f51491a;

            /* renamed from: b  reason: collision with root package name */
            public final View f51492b;

            /* renamed from: c  reason: collision with root package name */
            public final ImageView f51493c;

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
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.frs_item_album_image);
                this.f51491a = tbImageView;
                tbImageView.setConrers(15);
                this.f51491a.setRadiusById(R.string.J_X05);
                this.f51491a.setDrawCorner(true);
                this.f51491a.setPlaceHolder(3);
                this.f51491a.setPageId(j.a(view.getContext()).getUniqueId());
                View findViewById = view.findViewById(R.id.frs_item_album_video_mask);
                this.f51492b = findViewById;
                c.a.q0.s.u.c.d(findViewById).s(R.array.Mask_X001);
                c.a.q0.s.u.c.d(this.f51492b).n(R.string.J_X05);
                this.f51493c = (ImageView) view.findViewById(R.id.frs_item_album_video_play);
            }

            public void a(AlbumElement albumElement) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, albumElement) == null) || albumElement == null) {
                    return;
                }
                if (albumElement.album_type.intValue() != 1 && albumElement.album_height.intValue() > 0 && albumElement.album_width.intValue() > 0) {
                    this.f51491a.getLayoutParams().width = (albumElement.album_width.intValue() * this.f51491a.getLayoutParams().height) / albumElement.album_height.intValue();
                } else {
                    this.f51491a.getLayoutParams().width = l.g(this.itemView.getContext(), R.dimen.tbds580);
                }
                this.f51491a.startLoad(albumElement.album_thumb_url, 10, false);
                b(albumElement.album_type.intValue() == 1);
            }

            public final void b(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f51492b.setVisibility(z ? 0 : 8);
                    this.f51493c.setVisibility(z ? 0 : 8);
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
            this.f51490a = cardItemInfoAlbumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || ListUtils.getItem(this.f51490a.f51485g, i2) == null) {
                return;
            }
            aVar.a((AlbumElement) ListUtils.getItem(this.f51490a.f51485g, i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                a aVar = new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frs_item_album_view, (ViewGroup) null));
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
                if (this.f51490a.f51485g == null) {
                    return 0;
                }
                return this.f51490a.f51485g.size();
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
        this.f51485g = new ArrayList();
        this.f51486h = new ArrayList<>();
        this.f51487i = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setOrientation(0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f51483e = bdRecyclerView;
            bdRecyclerView.setPadding(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), 0, 0);
            this.f51483e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f51483e.addItemDecoration(new a(this));
            this.f51483e.setNestedScrollingEnabled(false);
            this.f51483e.setOnItemClickListener(new b(this));
            addView(this.f51483e, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.f51484f = cVar;
            this.f51483e.setAdapter(cVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f51484f.notifyDataSetChanged();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f51487i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f51483e.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f51487i.x - motionEvent.getX()) > Math.abs(this.f51487i.y - motionEvent.getY())) {
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
            this.f51485g.clear();
            this.f51486h.clear();
            for (AlbumElement albumElement : list) {
                if (!StringUtils.isNull(albumElement.album_thumb_url)) {
                    this.f51485g.add(albumElement);
                    if (albumElement != null && albumElement.album_type.intValue() != 1) {
                        this.f51486h.add(albumElement.album_url);
                    }
                }
            }
            this.f51483e.setVisibility(ListUtils.isEmpty(this.f51485g) ? 8 : 0);
            this.f51484f.notifyDataSetChanged();
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
        this.f51485g = new ArrayList();
        this.f51486h = new ArrayList<>();
        this.f51487i = new Point();
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
        this.f51485g = new ArrayList();
        this.f51486h = new ArrayList<>();
        this.f51487i = new Point();
        c();
    }
}
