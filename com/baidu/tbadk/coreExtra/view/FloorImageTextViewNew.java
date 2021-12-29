package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.d.f.p.n;
import c.a.t0.n4.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f42280j;

    /* renamed from: k  reason: collision with root package name */
    public static final int f42281k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f42282f;

    /* renamed from: g  reason: collision with root package name */
    public EditorScrollView f42283g;

    /* renamed from: h  reason: collision with root package name */
    public int f42284h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42285i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(284725317, "Lcom/baidu/tbadk/coreExtra/view/FloorImageTextViewNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(284725317, "Lcom/baidu/tbadk/coreExtra/view/FloorImageTextViewNew;");
                return;
            }
        }
        f42280j = n.f(TbadkApplication.getInst(), R.dimen.tbds348);
        f42281k = n.f(TbadkApplication.getInst(), R.dimen.tbds308);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloorImageTextViewNew(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42285i = false;
        b(context);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        setVisibility(this.f42285i ? 0 : 8);
        if (z) {
            layoutParams.height = this.f42284h;
            setLayoutParams(layoutParams);
            return;
        }
        layoutParams.height = 0;
        setLayoutParams(layoutParams);
    }

    public final void a(Pair<Integer, Integer> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pair) == null) || pair == null) {
            return;
        }
        if (((Integer) pair.second).intValue() > 2) {
            if (c()) {
                this.f42284h = f42281k + AbsFloorImageTextView.TOP + AbsFloorImageTextView.BOTTOM;
            } else {
                this.f42284h = f42280j + AbsFloorImageTextView.TOP + AbsFloorImageTextView.BOTTOM;
            }
        } else {
            this.f42284h = -2;
        }
        checkAndSetViewHeight(this.f42284h);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
            TbRichTextView tbRichTextView = (TbRichTextView) findViewById(R.id.textview);
            this.f42282f = tbRichTextView;
            tbRichTextView.setVerticalScrollBarEnabled(true);
            this.f42282f.setTextSize(AbsFloorImageTextView.TEXT_SIZE);
            this.f42282f.setTextColor(SkinManager.getColor(R.color.white_alpha83));
            this.f42282f.hasShadow = true;
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.scrollview);
            this.f42283g = editorScrollView;
            editorScrollView.setPadding(0, n.f(TbadkApplication.getInst(), R.dimen.tbds34), 0, AbsFloorImageTextView.BOTTOM);
            this.f42283g.setOnTouchListener(this.mTbGestureDetector);
            ((ViewGroup.MarginLayoutParams) this.f42283g.getLayoutParams()).topMargin = n.f(TbadkApplication.getInst(), R.dimen.tbds174);
            setVisibility(8);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            float h2 = n.h(getContext());
            int i2 = n.i(getContext());
            int k2 = n.k(getContext());
            double d2 = h2;
            int i3 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
            if (i3 != 0 || k2 < 1920 || i2 < 2049) {
                if (i3 != 0 || k2 < 1080 || i2 < 2280) {
                    return d2 == 3.5d && i2 >= 2434;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void updateExpandState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            setExpandState(z);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void updateTextView(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, imageUrlData) == null) {
            this.mAssistUrlData = imageUrlData;
            JSONArray jSONArray = null;
            if (imageUrlData != null) {
                try {
                    if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                        jSONArray = new JSONArray(imageUrlData.richTextArray);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (imageUrlData != null && jSONArray != null && jSONArray.length() > 0) {
                this.f42285i = true;
                b.a().d(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                TbRichText parse = TbRichTextView.parse(jSONArray, false);
                a(measureTextViewHeightAndLine(parse.toString()));
                this.f42282f.setText(parse);
            } else {
                this.f42285i = false;
            }
            setVisibility(this.f42285i ? 0 : 8);
        }
    }
}
