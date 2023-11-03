package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout;
import com.baidu.tieba.j65;
import com.baidu.tieba.r25;
import com.baidu.tieba.ura;
import com.baidu.tieba.uu4;
import com.baidu.tieba.yd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class HotCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer k;
    public static int l;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public EMTextView c;
    public TbImageView d;
    public ViewFlipper e;
    public int f;
    public ThreadData g;
    public View h;
    public int i;
    public uu4 j;

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ HotCardView b;

        public a(HotCardView hotCardView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotCardView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hotCardView;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.j != null) {
                this.b.j.b(view2, "", this.a, 0L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-898596555, "Lcom/baidu/tieba/homepage/personalize/view/HotCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-898596555, "Lcom/baidu/tieba/homepage/personalize/view/HotCardView;");
                return;
            }
        }
        k = 1;
    }

    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 3;
        b();
    }

    public void setOutOnClickListener(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uu4Var) == null) {
            this.j = uu4Var;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0877, (ViewGroup) this, true);
            setOrientation(1);
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0925fe);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0907eb);
            this.c = (EMTextView) findViewById(R.id.more_label_view);
            this.d = (TbImageView) findViewById(R.id.image_content);
            this.e = (ViewFlipper) findViewById(R.id.obfuscated_res_0x7f090788);
            this.a.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            this.b.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = BdUtilHelper.getDimens(getContext(), R.dimen.tbds237);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            int i = this.f;
            marginLayoutParams.width = i;
            marginLayoutParams.height = (i * 3) / 4;
            this.d.setLayoutParams(marginLayoutParams);
            this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setDrawCorner(true);
            this.d.setPlaceHolder(2);
            this.d.setConrers(15);
            this.d.setRadiusById(R.string.J_X05);
            this.d.setForegroundColor(0);
            this.d.setBorderSurroundContent(true);
            this.d.setDrawBorder(true);
            this.d.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.tbds1));
            this.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.i == i) {
            return;
        }
        this.i = i;
        EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0105);
        EMManager.from(this.b).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0107);
        EMManager.from(this.c).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        this.d.setSkinType(i);
    }

    public final void e(@NonNull ThreadData threadData, int i, ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, threadData, i, themeColorInfo) == null) {
            this.e.removeAllViews();
            this.e.stopFlipping();
            List<ura> postList = threadData.getPostList();
            if (!ListUtils.isEmpty(postList)) {
                for (int i2 = 0; i2 < postList.size(); i2++) {
                    RecommendHotReplyLayout recommendHotReplyLayout = new RecommendHotReplyLayout(getContext());
                    recommendHotReplyLayout.setOutOnClickListener(new a(this, i));
                    recommendHotReplyLayout.setData(postList.get(i2), themeColorInfo);
                    this.e.addView(recommendHotReplyLayout, new ViewGroup.LayoutParams(-1, -2));
                }
                if (this.e.getChildCount() > 1) {
                    this.e.startFlipping();
                } else {
                    this.e.stopFlipping();
                }
            }
        }
    }

    public final void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (!ListUtils.isEmpty(medias)) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.isEmpty(linkedList)) {
                    return;
                }
                this.d.setVisibility(0);
                this.d.startLoad(ThreadCardUtils.getThumbnailsUrl((MediaData) linkedList.get(0)), 10, false);
                if (linkedList.size() > k.intValue()) {
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - k.intValue())}));
                    this.c.setVisibility(0);
                    return;
                }
                this.c.setVisibility(8);
            }
        }
    }

    public void setData(ThreadData threadData, int i, ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048582, this, threadData, i, themeColorInfo) != null) || threadData == null) {
            return;
        }
        this.g = threadData;
        f(threadData);
        int i2 = 2;
        l = (BdUtilHelper.getEquipmentWidth(getContext()) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005) * 2);
        if (this.d.getVisibility() == 0) {
            l = (l - BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006)) - this.f;
        }
        if (threadData.getIsNoTitle() == 1) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setText(threadData.getAbstractText());
            i2 = (2 - yd.a(l, this.b.getPaint(), this.b.getText().toString(), 2)) + 1;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(threadData.getTitleText());
        float[] B = r25.B(R.string.J_X04);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.T_X10);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
        j65 j65Var = new j65(TagTextHelper.getIndexTextColorRes(i), (int) B[0], dimenPixelSize, R.color.CAM_X0101, UtilHelper.getDimenPixelSize(R.dimen.tbds3), UtilHelper.getDimenPixelSize(R.dimen.tbds5), 0);
        j65Var.b(dimenPixelSize2);
        j65Var.a(false);
        String valueOf = String.valueOf(i);
        spannableStringBuilder.insert(0, (CharSequence) valueOf);
        spannableStringBuilder.setSpan(j65Var, 0, valueOf.length(), 17);
        this.a.setMaxLines(i2);
        this.a.setText(spannableStringBuilder);
        e(threadData, i - 1, themeColorInfo);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
