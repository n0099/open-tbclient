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
import com.baidu.tieba.wi;
import com.baidu.tieba.xca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView j;
    public EditorScrollView k;
    public int l;
    public boolean m;

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
        n = wi.g(TbadkApplication.getInst(), R.dimen.tbds348);
        o = wi.g(TbadkApplication.getInst(), R.dimen.tbds308);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = false;
        h(context);
    }

    public final void g(Pair<Integer, Integer> pair) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) != null) || pair == null) {
            return;
        }
        if (((Integer) pair.second).intValue() > 2) {
            if (i()) {
                this.l = o + AbsFloorImageTextView.d + AbsFloorImageTextView.e;
            } else {
                this.l = n + AbsFloorImageTextView.d + AbsFloorImageTextView.e;
            }
        } else {
            this.l = -2;
        }
        a(this.l);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65538, this, z) != null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        if (this.m) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
        if (z) {
            layoutParams.height = this.l;
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
            this.a = imageUrlData;
            JSONArray jSONArray = null;
            if (imageUrlData != null) {
                try {
                    if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                        jSONArray = new JSONArray(imageUrlData.richTextArray);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int i = 0;
            if (imageUrlData != null && jSONArray != null && jSONArray.length() > 0) {
                this.m = true;
                xca.a().d(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                TbRichText Z = TbRichTextView.Z(jSONArray, false);
                g(d(Z.toString()));
                this.j.setText(Z);
            } else {
                this.m = false;
            }
            if (!this.m) {
                i = 8;
            }
            setVisibility(i);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
            TbRichTextView tbRichTextView = (TbRichTextView) findViewById(R.id.obfuscated_res_0x7f0923fa);
            this.j = tbRichTextView;
            tbRichTextView.setVerticalScrollBarEnabled(true);
            this.j.setTextSize(AbsFloorImageTextView.i);
            this.j.setTextColor(SkinManager.getColor(R.color.white_alpha83));
            this.j.S = true;
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.obfuscated_res_0x7f092031);
            this.k = editorScrollView;
            editorScrollView.setPadding(0, wi.g(TbadkApplication.getInst(), R.dimen.tbds34), 0, AbsFloorImageTextView.e);
            this.k.setOnTouchListener(this.c);
            ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds174);
            setVisibility(8);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float i = wi.i(getContext());
            int j = wi.j(getContext());
            int l = wi.l(getContext());
            double d = i;
            int i2 = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
            if (i2 == 0 && l >= 1920 && j >= 2049) {
                return true;
            }
            if (i2 == 0 && l >= 1080 && j >= 2280) {
                return true;
            }
            if (d == 3.5d && j >= 2434) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
