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
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
public class CardItemInfoAlbumLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public c f32704b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AlbumElement> f32705c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<String> f32706d;

    /* renamed from: e  reason: collision with root package name */
    public final Point f32707e;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoAlbumLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i, recyclerView) == null) {
                if (i != 0) {
                    if (i == this.a.f32705c.size()) {
                        rect.set(0, 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
                        return;
                    }
                }
                rect.set(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoAlbumLayout a;

        public b(CardItemInfoAlbumLayout cardItemInfoAlbumLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoAlbumLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoAlbumLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || ListUtils.getItem(this.a.f32705c, i) == null) {
                return;
            }
            AlbumElement albumElement = (AlbumElement) ListUtils.getItem(this.a.f32705c, i);
            if (albumElement.album_type.intValue() == 1) {
                SimpleVideoPlayActivityConfig.b bVar = new SimpleVideoPlayActivityConfig.b();
                bVar.d(albumElement.album_thumb_url);
                bVar.e(albumElement.album_url);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar.c(this.a.getContext())));
            } else {
                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                bVar2.x(this.a.f32706d);
                bVar2.B(i - (ListUtils.getCount(this.a.f32705c) - ListUtils.getCount(this.a.f32706d)));
                bVar2.C(true);
                bVar2.J((String) ListUtils.getItem(this.a.f32706d, ListUtils.getCount(this.a.f32706d) - 1));
                bVar2.F(true);
                bVar2.H(true);
                ImageViewerConfig v = bVar2.v(this.a.getContext());
                v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
                v.getIntent().putExtra("from", "index");
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.o0.r.l0.p.b(1, i + 1, albumElement.album_type.intValue())));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoAlbumLayout a;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final TbImageView a;

            /* renamed from: b  reason: collision with root package name */
            public final View f32708b;

            /* renamed from: c  reason: collision with root package name */
            public final ImageView f32709c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NonNull c cVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view};
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
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090b3f);
                this.a = tbImageView;
                tbImageView.setConrers(15);
                this.a.setRadiusById(R.string.J_X05);
                this.a.setDrawCorner(true);
                this.a.setPlaceHolder(3);
                this.a.setPageId(j.a(view.getContext()).getUniqueId());
                View findViewById = view.findViewById(R.id.obfuscated_res_0x7f090b40);
                this.f32708b = findViewById;
                c.a.o0.r.v.c.d(findViewById).s(R.array.Mask_X001);
                c.a.o0.r.v.c.d(this.f32708b).n(R.string.J_X05);
                this.f32709c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090b41);
            }

            public void a(AlbumElement albumElement) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, albumElement) == null) || albumElement == null) {
                    return;
                }
                if (albumElement.album_type.intValue() != 1 && albumElement.album_height.intValue() > 0 && albumElement.album_width.intValue() > 0) {
                    this.a.getLayoutParams().width = (albumElement.album_width.intValue() * this.a.getLayoutParams().height) / albumElement.album_height.intValue();
                } else {
                    this.a.getLayoutParams().width = n.f(this.itemView.getContext(), R.dimen.tbds580);
                }
                this.a.J(albumElement.album_thumb_url, 10, false);
                b(albumElement.album_type.intValue() == 1);
            }

            public final void b(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f32708b.setVisibility(z ? 0 : 8);
                    this.f32709c.setVisibility(z ? 0 : 8);
                }
            }

            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoAlbumLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) || ListUtils.getItem(this.a.f32705c, i) == null) {
                return;
            }
            aVar.a((AlbumElement) ListUtils.getItem(this.a.f32705c, i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                a aVar = new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d032f, (ViewGroup) null));
                aVar.c(TbadkCoreApplication.getInst().getSkinType());
                return aVar;
            }
            return (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.f32705c == null) {
                    return 0;
                }
                return this.a.f32705c.size();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32705c = new ArrayList();
        this.f32706d = new ArrayList<>();
        this.f32707e = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setOrientation(0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.a = bdRecyclerView;
            bdRecyclerView.setPadding(0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), 0, 0);
            this.a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.a.addItemDecoration(new a(this));
            this.a.setNestedScrollingEnabled(false);
            this.a.setOnItemClickListener(new b(this));
            addView(this.a, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.f32704b = cVar;
            this.a.setAdapter(cVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            this.f32704b.notifyDataSetChanged();
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
                    this.f32707e.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.a.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f32707e.x - motionEvent.getX()) > Math.abs(this.f32707e.y - motionEvent.getY())) {
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
            this.f32705c.clear();
            this.f32706d.clear();
            for (AlbumElement albumElement : list) {
                if (!StringUtils.isNull(albumElement.album_thumb_url)) {
                    this.f32705c.add(albumElement);
                    if (albumElement != null && albumElement.album_type.intValue() != 1) {
                        this.f32706d.add(albumElement.album_url);
                    }
                }
            }
            this.a.setVisibility(ListUtils.isEmpty(this.f32705c) ? 8 : 0);
            this.f32704b.notifyDataSetChanged();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32705c = new ArrayList();
        this.f32706d = new ArrayList<>();
        this.f32707e = new Point();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoAlbumLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32705c = new ArrayList();
        this.f32706d = new ArrayList<>();
        this.f32707e = new Point();
        c();
    }
}
