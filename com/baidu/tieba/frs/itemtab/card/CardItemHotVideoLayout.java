package com.baidu.tieba.frs.itemtab.card;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.l.q;
import b.a.q0.s.q.d2;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.WorkIntroSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class CardItemHotVideoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f48790e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f48791f;

    /* renamed from: g  reason: collision with root package name */
    public c f48792g;

    /* renamed from: h  reason: collision with root package name */
    public List<d2> f48793h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f48794i;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f48795a;

        public a(CardItemHotVideoLayout cardItemHotVideoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48795a = cardItemHotVideoLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.f48795a.f48793h.size() - 1) {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), c1.tbds19), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.g(this.f48795a.getContext(), c1.M_W_X005), 0);
                        return;
                    }
                }
                rect.set(l.g(this.f48795a.getContext(), c1.M_W_X005), 0, l.g(TbadkCoreApplication.getInst().getContext(), c1.tbds19), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f48796e;

        public b(CardItemHotVideoLayout cardItemHotVideoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48796e = cardItemHotVideoLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData((d2) this.f48796e.f48793h.get(i2));
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f48796e.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                videoPlayActivityConfig.setVideoShowIndex(i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(12, i2 + 1);
                bVar.o(videoItemData.post_id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f48797a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48798e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f48799f;

            public a(c cVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48799f = cVar;
                this.f48798e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((d2) this.f48799f.f48797a.f48793h.get(this.f48798e));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f48799f.f48797a.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.f48798e);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(12, this.f48798e + 1);
                    bVar.o(videoItemData.post_id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }

        public c(CardItemHotVideoLayout cardItemHotVideoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48797a = cardItemHotVideoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dVar, i2) == null) || ListUtils.getItem(this.f48797a.f48793h, i2) == null) {
                return;
            }
            dVar.a((d2) ListUtils.getItem(this.f48797a.f48793h, i2), i2);
            dVar.itemView.setOnClickListener(new a(this, i2));
            if (TbSingleton.getInstance().isItemTabVisible) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b.a.q0.s.g0.p.b(11, i2 + 1)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                d dVar = new d(this.f48797a, LayoutInflater.from(viewGroup.getContext()).inflate(f1.frs_item_hot_video_view, (ViewGroup) null));
                dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return dVar;
            }
            return (d) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f48797a.f48793h == null) {
                    return 0;
                }
                return this.f48797a.f48793h.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TbImageView f48800a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f48801b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f48802c;

        /* renamed from: d  reason: collision with root package name */
        public final EMTextView f48803d;

        /* renamed from: e  reason: collision with root package name */
        public final EMTextView f48804e;

        /* renamed from: f  reason: collision with root package name */
        public final TextView f48805f;

        /* renamed from: g  reason: collision with root package name */
        public final View f48806g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f48807h;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48808e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f48809f;

            public a(d dVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48809f = dVar;
                this.f48808e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((d2) this.f48809f.f48807h.f48793h.get(this.f48808e));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f48809f.f48807h.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.f48808e);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(12, this.f48808e + 1);
                    bVar.o(videoItemData.post_id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SpannableStringBuilder f48810e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f48811f;

            public b(d dVar, SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, spannableStringBuilder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48811f = dVar;
                this.f48810e = spannableStringBuilder;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    TextView textView = (TextView) view;
                    if (motionEvent.getAction() != 1) {
                        return CardItemHotVideoLayout.super.onTouchEvent(motionEvent);
                    }
                    int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                    int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                    int scrollX = x + textView.getScrollX();
                    int scrollY = y + textView.getScrollY();
                    Layout layout = textView.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.f48810e.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        clickableSpanArr[0].onClick(textView);
                        return true;
                    }
                    this.f48811f.f48807h.performClick();
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        /* loaded from: classes9.dex */
        public class c extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull CardItemHotVideoLayout cardItemHotVideoLayout, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout, view};
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
            this.f48807h = cardItemHotVideoLayout;
            TbImageView tbImageView = (TbImageView) view.findViewById(e1.frs_item_hot_video_image);
            this.f48800a = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48800a.setConrers(15);
            this.f48800a.setRadiusById(h1.J_X05);
            this.f48800a.setDrawCorner(true);
            this.f48800a.setPageId(j.a(view.getContext()).getUniqueId());
            this.f48806g = view.findViewById(e1.frs_item_hot_video_image_mask);
            this.f48801b = (ImageView) view.findViewById(e1.frs_item_hot_video_play_image);
            this.f48802c = (ImageView) view.findViewById(e1.frs_item_hot_video_playback_image);
            this.f48803d = (EMTextView) view.findViewById(e1.frs_item_hot_video_playback_num);
            this.f48804e = (EMTextView) view.findViewById(e1.frs_item_hot_video_duration);
            this.f48805f = (TextView) view.findViewById(e1.frs_item_hot_video_title);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public void a(d2 d2Var, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, d2Var, i2) == null) || d2Var == null) {
                return;
            }
            this.f48800a.startLoad(d2Var.q1().thumbnail_url, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(d2Var.u1());
            if (d2Var.U1()) {
                b(spannableStringBuilder);
            }
            this.f48805f.setOnClickListener(new a(this, i2));
            this.f48805f.setOnTouchListener(new b(this, spannableStringBuilder));
            this.f48805f.setText(spannableStringBuilder);
            this.f48803d.setText(StringHelper.numFormatOverWan(d2Var.q1().play_count.intValue()));
            this.f48804e.setText(StringHelper.stringForVideoTime(d2Var.q1().video_duration.intValue() * 1000));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spannableStringBuilder) == null) || spannableStringBuilder == null) {
                return;
            }
            String string = TbadkCoreApplication.getInst().getString(h1.frs_item_tab_hot_video_tag_high_quality);
            spannableStringBuilder.insert(0, (CharSequence) string);
            int g2 = l.g(TbadkCoreApplication.getInst(), c1.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), c1.tbds10);
            int i2 = b1.CAM_X0319;
            int i3 = b1.CAM_X0101;
            int g4 = l.g(TbadkCoreApplication.getInst(), c1.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), c1.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), c1.M_W_X002);
            b.a.q0.s.g0.b bVar = new b.a.q0.s.g0.b(g2, -1, i2, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), c1.tbds40));
            bVar.b(g3);
            bVar.i(g6);
            bVar.f(true);
            if (WorkIntroSwitch.isOn()) {
                spannableStringBuilder.setSpan(new c(this), 0, string.length(), 33);
            }
            spannableStringBuilder.setSpan(bVar, 0, string.length(), 33);
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                SkinManager.setImageResource(this.f48801b, d1.icon_video26);
                SkinManager.setBackgroundResource(this.f48802c, d1.icon_mask_play_12);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f48805f);
                d2.z(c1.T_X12);
                d2.v(b1.CAM_X0105);
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f48804e);
                d3.z(c1.T_X09);
                d3.v(b1.CAM_X0101);
                b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.f48803d);
                d4.z(c1.T_X09);
                d4.v(b1.CAM_X0101);
                SkinManager.setBackgroundResource(this.f48806g, d1.bg_gradient_frs_item_hot_video);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemHotVideoLayout(Context context) {
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
        this.f48794i = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f48790e = eMTextView;
            eMTextView.setGravity(16);
            this.f48790e.setText(h1.frs_item_tab_hot_video_title);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), c1.M_W_X005), l.g(getContext(), c1.tbds32), 0, 0);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f48790e);
            d2.A(h1.F_X02);
            d2.z(c1.T_X07);
            addView(this.f48790e, layoutParams);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f48791f = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f48791f.addItemDecoration(new a(this));
            this.f48791f.setOnItemClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, l.g(getContext(), c1.tbds36), 0, 0);
            addView(this.f48791f, layoutParams2);
            c cVar = new c(this);
            this.f48792g = cVar;
            this.f48791f.setAdapter(cVar);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f48792g.notifyDataSetChanged();
            b.a.q0.s.u.c.d(this.f48790e).v(b1.CAM_X0105);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this);
            d2.n(h1.J_X06);
            d2.f(b1.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f48794i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f48791f.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f48794i.x - motionEvent.getX()) > Math.abs(this.f48794i.y - motionEvent.getY())) {
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

    public void setData(b.a.r0.x0.l2.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f48793h = dVar.g();
            this.f48792g.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemHotVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f48794i = new Point();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemHotVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f48794i = new Point();
        c();
    }
}
