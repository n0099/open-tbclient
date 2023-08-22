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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.l9;
import com.baidu.tieba.la5;
import com.baidu.tieba.ux;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlbumElement;
/* loaded from: classes5.dex */
public class CardItemInfoAlbumLayout extends LinearLayout implements ux {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;
    public c b;
    public final List<AlbumElement> c;
    public final ArrayList<String> d;
    public final Point e;

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
            public final View b;
            public final ImageView c;

            public void d(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NonNull c cVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2};
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
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ce9);
                this.a = tbImageView;
                tbImageView.setConrers(15);
                this.a.setRadiusById(R.string.J_X05);
                this.a.setDrawCorner(true);
                this.a.setPlaceHolder(3);
                this.a.setPageId(l9.a(view2.getContext()).getUniqueId());
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090cea);
                this.b = findViewById;
                EMManager.from(findViewById).setMaskBackGround(R.array.Mask_X001);
                EMManager.from(this.b).setCorner(R.string.J_X05);
                this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ceb);
            }

            public void b(AlbumElement albumElement) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, albumElement) != null) || albumElement == null) {
                    return;
                }
                boolean z = true;
                if (albumElement.album_type.intValue() != 1 && albumElement.album_height.intValue() > 0 && albumElement.album_width.intValue() > 0) {
                    this.a.getLayoutParams().width = (albumElement.album_width.intValue() * this.a.getLayoutParams().height) / albumElement.album_height.intValue();
                } else {
                    this.a.getLayoutParams().width = BdUtilHelper.getDimens(this.itemView.getContext(), R.dimen.tbds580);
                }
                this.a.startLoad(albumElement.album_thumb_url, 10, false);
                if (albumElement.album_type.intValue() != 1) {
                    z = false;
                }
                c(z);
            }

            public final void c(boolean z) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    View view2 = this.b;
                    int i2 = 0;
                    if (z) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    view2.setVisibility(i);
                    ImageView imageView = this.c;
                    if (!z) {
                        i2 = 8;
                    }
                    imageView.setVisibility(i2);
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.c == null) {
                    return 0;
                }
                return this.a.c.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) && ListUtils.getItem(this.a.c, i) != null) {
                aVar.b((AlbumElement) ListUtils.getItem(this.a.c, i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: m */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                a aVar = new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d037c, (ViewGroup) null));
                aVar.d(TbadkCoreApplication.getInst().getSkinType());
                return aVar;
            }
            return (a) invokeLI.objValue;
        }
    }

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
                if (i == 0) {
                    rect.set(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
                } else if (i == this.a.c.size()) {
                    rect.set(0, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
                } else {
                    rect.set(0, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004), 0);
                }
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
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && ListUtils.getItem(this.a.c, i) != null) {
                AlbumElement albumElement = (AlbumElement) ListUtils.getItem(this.a.c, i);
                if (albumElement.album_type.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    SimpleVideoPlayActivityConfig.Builder builder = new SimpleVideoPlayActivityConfig.Builder();
                    builder.setThumbUrl(albumElement.album_thumb_url).setVideoUrl(albumElement.album_url);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, builder.build(this.a.getContext())));
                } else {
                    ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                    builder2.setData(this.a.d).setIndex(i - (ListUtils.getCount(this.a.c) - ListUtils.getCount(this.a.d))).setIsCDN(true).setLastId((String) ListUtils.getItem(this.a.d, ListUtils.getCount(this.a.d) - 1)).setIsReserve(true).setIsShowAd(true);
                    ImageViewerConfig bulid = builder2.bulid(this.a.getContext());
                    bulid.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
                    bulid.getIntent().putExtra("from", "index");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2010000, bulid));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new la5(1, i + 1, albumElement.album_type.intValue())));
            }
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
        this.c = new ArrayList();
        this.d = new ArrayList<>();
        this.e = new Point();
        c();
    }

    public void setData(List<AlbumElement> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.clear();
            this.d.clear();
            for (AlbumElement albumElement : list) {
                if (!StringUtils.isNull(albumElement.album_thumb_url)) {
                    this.c.add(albumElement);
                    if (albumElement != null && albumElement.album_type.intValue() != 1) {
                        this.d.add(albumElement.album_url);
                    }
                }
            }
            BdRecyclerView bdRecyclerView = this.a;
            if (ListUtils.isEmpty(this.c)) {
                i = 8;
            } else {
                i = 0;
            }
            bdRecyclerView.setVisibility(i);
            this.b.notifyDataSetChanged();
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
        this.c = new ArrayList();
        this.d = new ArrayList<>();
        this.e = new Point();
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
        this.c = new ArrayList();
        this.d = new ArrayList<>();
        this.e = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setOrientation(0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.a = bdRecyclerView;
            bdRecyclerView.setPadding(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), 0, 0);
            this.a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.a.addItemDecoration(new a(this));
            this.a.setNestedScrollingEnabled(false);
            this.a.setOnItemClickListener(new b(this));
            addView(this.a, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.b = cVar;
            this.a.setAdapter(cVar);
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            this.b.notifyDataSetChanged();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.e.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.a.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z2 = false;
                    if (motionEvent.getAction() == 2) {
                        if ((getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ViewParent parent = getParent();
                        if (!z && Math.abs(this.e.x - motionEvent.getX()) > Math.abs(this.e.y - motionEvent.getY())) {
                            z2 = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z2);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
