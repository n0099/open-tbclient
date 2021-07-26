package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
import d.a.d.e.p.l;
import d.a.q0.z3.c;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView n;
    public EditorScrollView o;
    public int p;
    public boolean q;

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
        r = l.g(TbadkApplication.getInst(), R.dimen.tbds348);
        s = l.g(TbadkApplication.getInst(), R.dimen.tbds308);
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
        this.q = false;
        h(context);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        setVisibility(this.q ? 0 : 8);
        if (z) {
            layoutParams.height = this.p;
            setLayoutParams(layoutParams);
            return;
        }
        layoutParams.height = 0;
        setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            setExpandState(z);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void f(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageUrlData) == null) {
            this.f12898e = imageUrlData;
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
                this.q = true;
                c.a().d(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                TbRichText T = TbRichTextView.T(getContext(), jSONArray, false);
                g(d(T.toString()));
                this.n.setText(T);
            } else {
                this.q = false;
            }
            setVisibility(this.q ? 0 : 8);
        }
    }

    public final void g(Pair<Integer, Integer> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) || pair == null) {
            return;
        }
        if (((Integer) pair.second).intValue() > 2) {
            if (i()) {
                this.p = s + AbsFloorImageTextView.f12896h + AbsFloorImageTextView.f12897i;
            } else {
                this.p = r + AbsFloorImageTextView.f12896h + AbsFloorImageTextView.f12897i;
            }
        } else {
            this.p = -2;
        }
        a(this.p);
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
            TbRichTextView tbRichTextView = (TbRichTextView) findViewById(R.id.textview);
            this.n = tbRichTextView;
            tbRichTextView.setVerticalScrollBarEnabled(true);
            this.n.setTextSize(AbsFloorImageTextView.m);
            this.n.setTextColor(SkinManager.getColor(R.color.white_alpha83));
            this.n.U = true;
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.scrollview);
            this.o = editorScrollView;
            editorScrollView.setPadding(0, l.g(TbadkApplication.getInst(), R.dimen.tbds34), 0, AbsFloorImageTextView.f12897i);
            this.o.setOnTouchListener(this.f12900g);
            ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(TbadkApplication.getInst(), R.dimen.tbds174);
            setVisibility(8);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float h2 = l.h(getContext());
            int i2 = l.i(getContext());
            int k = l.k(getContext());
            double d2 = h2;
            int i3 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
            if (i3 != 0 || k < 1920 || i2 < 2049) {
                if (i3 != 0 || k < 1080 || i2 < 2280) {
                    return d2 == 3.5d && i2 >= 2434;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
