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
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.c75;
import com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout;
import com.baidu.tieba.li;
import com.baidu.tieba.qz4;
import com.baidu.tieba.ta5;
import com.baidu.tieba.ux;
import com.baidu.tieba.zfa;
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
public class HotCardView extends LinearLayout implements ux {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer l;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public EMTextView b;
    public EMTextView c;
    public EMTextView d;
    public TbImageView e;
    public ViewFlipper f;
    public int g;
    public ThreadData h;
    public View i;
    public int j;
    public qz4 k;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.k != null) {
                this.b.k.d(view2, "", this.a, 0L);
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
        l = 1;
    }

    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.j = 3;
        this.a = tbPageContext;
        b();
    }

    public void setOutOnClickListener(qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qz4Var) == null) {
            this.k = qz4Var;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d085d, (ViewGroup) this, true);
            setOrientation(1);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09258f);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0907c5);
            this.d = (EMTextView) findViewById(R.id.more_label_view);
            this.e = (TbImageView) findViewById(R.id.image_content);
            this.f = (ViewFlipper) findViewById(R.id.obfuscated_res_0x7f090761);
            this.b.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            this.c.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = BdUtilHelper.getDimens(getContext(), R.dimen.tbds237);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            int i = this.g;
            marginLayoutParams.width = i;
            marginLayoutParams.height = (i * 3) / 4;
            this.e.setLayoutParams(marginLayoutParams);
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e.setDrawCorner(true);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.e.setRadiusById(R.string.J_X05);
            this.e.setForegroundColor(0);
            this.e.setBorderSurroundContent(true);
            this.e.setDrawBorder(true);
            this.e.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.tbds1));
            this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public final void d(@NonNull ThreadData threadData, int i, ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, threadData, i, themeColorInfo) == null) {
            this.f.removeAllViews();
            this.f.stopFlipping();
            List<zfa> postList = threadData.getPostList();
            if (!ListUtils.isEmpty(postList)) {
                for (int i2 = 0; i2 < postList.size(); i2++) {
                    RecommendHotReplyLayout recommendHotReplyLayout = new RecommendHotReplyLayout(getContext());
                    recommendHotReplyLayout.setOutOnClickListener(new a(this, i));
                    recommendHotReplyLayout.setData(postList.get(i2), themeColorInfo);
                    this.f.addView(recommendHotReplyLayout, new ViewGroup.LayoutParams(-1, -2));
                }
                if (this.f.getChildCount() > 1) {
                    this.f.startFlipping();
                } else {
                    this.f.stopFlipping();
                }
            }
        }
    }

    public final void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
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
                this.e.setVisibility(0);
                this.e.startLoad(ThreadCardUtils.getThumbnailsUrl((MediaData) linkedList.get(0)), 10, false);
                if (linkedList.size() > l.intValue()) {
                    this.d.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - l.intValue())}));
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, tbPageContext, i) != null) || this.j == i) {
            return;
        }
        this.j = i;
        EMManager.from(this.b).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0105);
        EMManager.from(this.c).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0107);
        EMManager.from(this.d).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        this.e.setSkinType(i);
    }

    public void setData(ThreadData threadData, int i, ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048582, this, threadData, i, themeColorInfo) != null) || threadData == null) {
            return;
        }
        this.h = threadData;
        e(threadData);
        int i2 = 2;
        m = (BdUtilHelper.getEquipmentWidth(getContext()) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005) * 2);
        if (this.e.getVisibility() == 0) {
            m = (m - BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006)) - this.g;
        }
        if (threadData.getIsNoTitle() == 1) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setText(threadData.getAbstractText());
            i2 = (2 - li.a(m, this.c.getPaint(), this.c.getText().toString(), 2)) + 1;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(threadData.getTitleText());
        float[] B = c75.B(R.string.J_X04);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.T_X10);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
        ta5 ta5Var = new ta5(TagTextHelper.getIndexTextColorRes(i), (int) B[0], dimenPixelSize, R.color.CAM_X0101, UtilHelper.getDimenPixelSize(R.dimen.tbds3), UtilHelper.getDimenPixelSize(R.dimen.tbds5), 0);
        ta5Var.b(dimenPixelSize2);
        ta5Var.a(false);
        String valueOf = String.valueOf(i);
        spannableStringBuilder.insert(0, (CharSequence) valueOf);
        spannableStringBuilder.setSpan(ta5Var, 0, valueOf.length(), 17);
        this.b.setMaxLines(i2);
        this.b.setText(spannableStringBuilder);
        d(threadData, i - 1, themeColorInfo);
        onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
    }
}
