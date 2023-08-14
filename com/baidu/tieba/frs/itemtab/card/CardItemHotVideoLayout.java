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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.WorkIntroSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d95;
import com.baidu.tieba.do7;
import com.baidu.tieba.ea5;
import com.baidu.tieba.l9;
import com.baidu.tieba.rx;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class CardItemHotVideoLayout extends LinearLayout implements rx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public BdRecyclerView b;
    public c c;
    public List<ThreadData> d;
    public final Point e;

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemHotVideoLayout a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

            public a(c cVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((ThreadData) this.b.a.d.get(this.a));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.b.a.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.a);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    ea5 ea5Var = new ea5(12, this.a + 1);
                    ea5Var.r(videoItemData.post_id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ea5Var));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemHotVideoLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.d == null) {
                    return 0;
                }
                return this.a.d.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, i) == null) && ListUtils.getItem(this.a.d, i) != null) {
                dVar.b((ThreadData) ListUtils.getItem(this.a.d, i), i);
                dVar.itemView.setOnClickListener(new a(this, i));
                if (TbSingleton.getInstance().isItemTabVisible) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new ea5(11, i + 1)));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: m */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                d dVar = new d(this.a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d037b, (ViewGroup) null));
                dVar.c(TbadkCoreApplication.getInst().getSkinType());
                return dVar;
            }
            return (d) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TbImageView a;
        public final ImageView b;
        public final ImageView c;
        public final EMTextView d;
        public final EMTextView e;
        public final TextView f;
        public final View g;
        public final /* synthetic */ CardItemHotVideoLayout h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ d b;

            public a(d dVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData((ThreadData) this.b.h.d.get(this.a));
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.b.h.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                    videoPlayActivityConfig.setVideoShowIndex(this.a);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    ea5 ea5Var = new ea5(12, this.a + 1);
                    ea5Var.r(videoItemData.post_id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ea5Var));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpannableStringBuilder a;
            public final /* synthetic */ d b;

            public b(d dVar, SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, spannableStringBuilder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = spannableStringBuilder;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    TextView textView = (TextView) view2;
                    if (motionEvent.getAction() == 1) {
                        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                        int scrollX = x + textView.getScrollX();
                        int scrollY = y + textView.getScrollY();
                        Layout layout = textView.getLayout();
                        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.a.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        if (clickableSpanArr.length != 0) {
                            clickableSpanArr[0].onClick(textView);
                            return true;
                        }
                        this.b.h.performClick();
                        return false;
                    }
                    return CardItemHotVideoLayout.super.onTouchEvent(motionEvent);
                }
                return invokeLL.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull CardItemHotVideoLayout cardItemHotVideoLayout, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout, view2};
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
            this.h = cardItemHotVideoLayout;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ce3);
            this.a = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.a.setConrers(15);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setDrawCorner(true);
            this.a.setPageId(l9.a(view2.getContext()).getUniqueId());
            this.g = view2.findViewById(R.id.obfuscated_res_0x7f090ce4);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ce5);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ce6);
            this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090ce7);
            this.e = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090ce2);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ce8);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public void b(ThreadData threadData, int i) {
            CharSequence charSequence;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, threadData, i) != null) || threadData == null) {
                return;
            }
            this.a.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            if (threadData.getTitleText() != null) {
                charSequence = threadData.getTitleText();
            } else {
                charSequence = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            if (threadData.isDisplayHighQualityPrefix()) {
                d(spannableStringBuilder);
            }
            this.f.setOnClickListener(new a(this, i));
            this.f.setOnTouchListener(new b(this, spannableStringBuilder));
            this.f.setText(spannableStringBuilder);
            this.d.setText(StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue()));
            this.e.setText(StringHelper.stringForVideoTime(threadData.getThreadVideoInfo().video_duration.intValue() * 1000));
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                SkinManager.setImageResource(this.b, R.drawable.icon_video26);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0809e7);
                EMManager.from(this.f).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.e).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
                EMManager.from(this.d).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f0802f2);
            }
        }

        public void d(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder) != null) || spannableStringBuilder == null) {
                return;
            }
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0838);
            spannableStringBuilder.insert(0, (CharSequence) string);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            d95 d95Var = new d95(dimens, -1, R.color.CAM_X0319, dimens3, R.color.CAM_X0101, dimens4, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40));
            d95Var.b(dimens2);
            d95Var.i(dimens5);
            d95Var.f(true);
            if (WorkIntroSwitch.isOn()) {
                spannableStringBuilder.setSpan(new c(this), 0, string.length(), 33);
            }
            spannableStringBuilder.setSpan(d95Var, 0, string.length(), 33);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemHotVideoLayout a;

        public a(CardItemHotVideoLayout cardItemHotVideoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemHotVideoLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i, recyclerView) == null) {
                if (i == 0) {
                    rect.set(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.M_W_X005), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds19), 0);
                } else if (i == this.a.d.size() - 1) {
                    rect.set(0, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds19), 0);
                } else {
                    rect.set(0, 0, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.M_W_X005), 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemHotVideoLayout a;

        public b(CardItemHotVideoLayout cardItemHotVideoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemHotVideoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemHotVideoLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithThreadData((ThreadData) this.a.d.get(i));
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.a.getContext(), Arrays.asList(videoItemData), 0, null, "frs");
                videoPlayActivityConfig.setVideoShowIndex(i);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                ea5 ea5Var = new ea5(12, i + 1);
                ea5Var.r(videoItemData.post_id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ea5Var));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Point();
        c();
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
        this.e = new Point();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemHotVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = new Point();
        c();
    }

    public void setData(do7 do7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, do7Var) == null) {
            this.d = do7Var.c();
            this.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.rx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            this.c.notifyDataSetChanged();
            EMManager.from(this.a).setTextColor(R.color.CAM_X0105);
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.a = eMTextView;
            eMTextView.setGravity(16);
            this.a.setText(R.string.obfuscated_res_0x7f0f0839);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), BdUtilHelper.getDimens(getContext(), R.dimen.tbds32), 0, 0);
            EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07);
            addView(this.a, layoutParams);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.b.addItemDecoration(new a(this));
            this.b.setOnItemClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds36), 0, 0);
            addView(this.b, layoutParams2);
            c cVar = new c(this);
            this.c = cVar;
            this.b.setAdapter(cVar);
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
                    if (this.b.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
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
