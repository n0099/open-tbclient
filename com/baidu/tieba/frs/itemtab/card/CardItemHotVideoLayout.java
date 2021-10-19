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
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.l.q;
import c.a.q0.s.q.d2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class CardItemHotVideoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f51461e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f51462f;

    /* renamed from: g  reason: collision with root package name */
    public c f51463g;

    /* renamed from: h  reason: collision with root package name */
    public List<d2> f51464h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f51465i;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f51466a;

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
            this.f51466a = cardItemHotVideoLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.f51466a.f51464h.size() - 1) {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds19), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.g(this.f51466a.getContext(), R.dimen.M_W_X005), 0);
                        return;
                    }
                }
                rect.set(l.g(this.f51466a.getContext(), R.dimen.M_W_X005), 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds19), 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f51467e;

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
            this.f51467e = cardItemHotVideoLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData((d2) this.f51467e.f51464h.get(i2));
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f51467e.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                videoPlayActivityConfig.setVideoShowIndex(i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(12, i2 + 1);
                bVar.n(videoItemData.post_id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f51468a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f51469e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f51470f;

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
                this.f51470f = cVar;
                this.f51469e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((d2) this.f51470f.f51468a.f51464h.get(this.f51469e));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f51470f.f51468a.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.f51469e);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(12, this.f51469e + 1);
                    bVar.n(videoItemData.post_id);
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
            this.f51468a = cardItemHotVideoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dVar, i2) == null) || ListUtils.getItem(this.f51468a.f51464h, i2) == null) {
                return;
            }
            dVar.a((d2) ListUtils.getItem(this.f51468a.f51464h, i2), i2);
            dVar.itemView.setOnClickListener(new a(this, i2));
            if (TbSingleton.getInstance().isItemTabVisible) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.s.f0.p.b(11, i2 + 1)));
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
                d dVar = new d(this.f51468a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frs_item_hot_video_view, (ViewGroup) null));
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
                if (this.f51468a.f51464h == null) {
                    return 0;
                }
                return this.f51468a.f51464h.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TbImageView f51471a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f51472b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f51473c;

        /* renamed from: d  reason: collision with root package name */
        public final EMTextView f51474d;

        /* renamed from: e  reason: collision with root package name */
        public final EMTextView f51475e;

        /* renamed from: f  reason: collision with root package name */
        public final TextView f51476f;

        /* renamed from: g  reason: collision with root package name */
        public final View f51477g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CardItemHotVideoLayout f51478h;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f51479e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f51480f;

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
                this.f51480f = dVar;
                this.f51479e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((d2) this.f51480f.f51478h.f51464h.get(this.f51479e));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f51480f.f51478h.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.f51479e);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(12, this.f51479e + 1);
                    bVar.n(videoItemData.post_id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SpannableStringBuilder f51481e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f51482f;

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
                this.f51482f = dVar;
                this.f51481e = spannableStringBuilder;
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
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.f51481e.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        clickableSpanArr[0].onClick(textView);
                        return true;
                    }
                    this.f51482f.f51478h.performClick();
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        /* loaded from: classes7.dex */
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
            this.f51478h = cardItemHotVideoLayout;
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.frs_item_hot_video_image);
            this.f51471a = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f51471a.setConrers(15);
            this.f51471a.setRadiusById(R.string.J_X05);
            this.f51471a.setDrawCorner(true);
            this.f51471a.setPageId(j.a(view.getContext()).getUniqueId());
            this.f51477g = view.findViewById(R.id.frs_item_hot_video_image_mask);
            this.f51472b = (ImageView) view.findViewById(R.id.frs_item_hot_video_play_image);
            this.f51473c = (ImageView) view.findViewById(R.id.frs_item_hot_video_playback_image);
            this.f51474d = (EMTextView) view.findViewById(R.id.frs_item_hot_video_playback_num);
            this.f51475e = (EMTextView) view.findViewById(R.id.frs_item_hot_video_duration);
            this.f51476f = (TextView) view.findViewById(R.id.frs_item_hot_video_title);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public void a(d2 d2Var, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, d2Var, i2) == null) || d2Var == null) {
                return;
            }
            this.f51471a.startLoad(d2Var.q1().thumbnail_url, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(d2Var.u1());
            if (d2Var.U1()) {
                b(spannableStringBuilder);
            }
            this.f51476f.setOnClickListener(new a(this, i2));
            this.f51476f.setOnTouchListener(new b(this, spannableStringBuilder));
            this.f51476f.setText(spannableStringBuilder);
            this.f51474d.setText(StringHelper.numFormatOverWan(d2Var.q1().play_count.intValue()));
            this.f51475e.setText(StringHelper.stringForVideoTime(d2Var.q1().video_duration.intValue() * 1000));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spannableStringBuilder) == null) || spannableStringBuilder == null) {
                return;
            }
            String string = TbadkCoreApplication.getInst().getString(R.string.frs_item_tab_hot_video_tag_high_quality);
            spannableStringBuilder.insert(0, (CharSequence) string);
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0319;
            int i3 = R.color.CAM_X0101;
            int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            c.a.q0.s.f0.b bVar = new c.a.q0.s.f0.b(g2, -1, i2, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40));
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
                SkinManager.setImageResource(this.f51472b, R.drawable.icon_video26);
                SkinManager.setBackgroundResource(this.f51473c, R.drawable.icon_mask_play_12);
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f51476f);
                d2.z(R.dimen.T_X12);
                d2.v(R.color.CAM_X0105);
                c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f51475e);
                d3.z(R.dimen.T_X09);
                d3.v(R.color.CAM_X0101);
                c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.f51474d);
                d4.z(R.dimen.T_X09);
                d4.v(R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f51477g, R.drawable.bg_gradient_frs_item_hot_video);
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
        this.f51465i = new Point();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f51461e = eMTextView;
            eMTextView.setGravity(16);
            this.f51461e.setText(R.string.frs_item_tab_hot_video_title);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.M_W_X005), l.g(getContext(), R.dimen.tbds32), 0, 0);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f51461e);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            addView(this.f51461e, layoutParams);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f51462f = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f51462f.addItemDecoration(new a(this));
            this.f51462f.setOnItemClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, l.g(getContext(), R.dimen.tbds36), 0, 0);
            addView(this.f51462f, layoutParams2);
            c cVar = new c(this);
            this.f51463g = cVar;
            this.f51462f.setAdapter(cVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f51463g.notifyDataSetChanged();
            c.a.q0.s.u.c.d(this.f51461e).v(R.color.CAM_X0105);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f51465i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f51462f.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f51465i.x - motionEvent.getX()) > Math.abs(this.f51465i.y - motionEvent.getY())) {
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

    public void setData(c.a.r0.x0.b2.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f51464h = cVar.g();
            this.f51463g.notifyDataSetChanged();
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
        this.f51465i = new Point();
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
        this.f51465i = new Point();
        c();
    }
}
