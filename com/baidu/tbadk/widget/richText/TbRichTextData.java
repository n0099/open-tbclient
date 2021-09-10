package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.f.a.b;
import c.a.q0.f1.m.d;
import c.a.q0.f1.m.i;
import c.a.q0.f1.o.a;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class TbRichTextData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48842e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f48843f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f48844g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f48845h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextVoiceInfo f48846i;

    /* renamed from: j  reason: collision with root package name */
    public TbRichTextTextInfo f48847j;
    public TbRichTextEmotionInfo k;
    public i l;
    public TbRichTextLinkImageInfo m;
    public TbRichTextMemeInfo n;
    public int o;
    public boolean p;
    public int q;
    public TbRichTextEvaluateItemInfo r;
    public TbRichTextTiebaPlusInfo s;
    public List<a> t;

    /* loaded from: classes6.dex */
    public class TbRichTextTextInfo extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int charLength;
        public boolean needRecompute;
        public int viewHeight;
        public int viewWidth;

        public TbRichTextTextInfo(TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.charLength = 0;
            this.viewWidth = 0;
            this.viewHeight = 0;
        }
    }

    public TbRichTextData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48842e = 0;
        this.f48843f = null;
        this.f48844g = null;
        this.f48845h = null;
        this.f48846i = null;
        this.f48847j = null;
        this.p = false;
        this.q = b.f2715a;
        this.t = new ArrayList();
    }

    public TbRichTextEvaluateItemInfo A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.intValue;
    }

    public TbRichTextImageInfo C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f48842e != 8) {
                return null;
            }
            return this.f48844g;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f48842e != 1280) {
                return null;
            }
            return this.m;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48843f : (SpannableStringBuilder) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.intValue;
    }

    public TbRichTextTextInfo H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f48842e != 1) {
                return null;
            }
            return this.f48847j;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<a> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s : (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public i K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f48842e != 32) {
                return null;
            }
            return this.l;
        }
        return (i) invokeV.objValue;
    }

    public TbRichTextVoiceInfo L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.f48842e;
            if (i2 == 512 || i2 == 768) {
                return this.f48846i;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void N(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, tbRichTextEmotionInfo) == null) && this.f48842e == 17) {
            this.k = tbRichTextEmotionInfo;
        }
    }

    public void O(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, tbRichTextEvaluateItemInfo) == null) && this.f48842e == 1281) {
            this.r = tbRichTextEvaluateItemInfo;
        }
    }

    public void P(int i2, int i3) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (arrayList = this.f48845h) == null) {
            return;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setBounds(0, 0, i2, i3);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.p = z;
        }
    }

    public void R(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, tbRichTextImageInfo) == null) && this.f48842e == 8) {
            this.f48844g = tbRichTextImageInfo;
        }
    }

    public void S(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

    public void T(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tbRichTextLinkImageInfo) == null) {
            this.m = tbRichTextLinkImageInfo;
        }
    }

    public void U(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, tbRichTextMemeInfo) == null) && this.f48842e == 20) {
            this.n = tbRichTextMemeInfo;
        }
    }

    public void V(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.o = i2;
        }
    }

    public void W(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, tbRichTextTiebaPlusInfo, d2Var) == null) {
            int i2 = this.f48842e;
            if (i2 == 30 || i2 == 31 || i2 == 33 || i2 == 50) {
                this.s = tbRichTextTiebaPlusInfo;
                if (d2Var != null) {
                    tbRichTextTiebaPlusInfo.A(d2Var);
                    this.s.setTid(d2Var.s1());
                    this.s.setForumId(String.valueOf(d2Var.T()));
                }
            }
        }
    }

    public void X(i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) && this.f48842e == 32) {
            this.l = iVar;
        }
    }

    public void Y(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tbRichTextVoiceInfo) == null) {
            int i2 = this.f48842e;
            if (i2 == 512 || i2 == 768) {
                this.f48846i = tbRichTextVoiceInfo;
            }
        }
    }

    public void Z(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, charSequence) == null) {
            int i2 = this.f48842e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f48843f == null) {
                    this.f48843f = new SpannableStringBuilder("");
                }
                this.f48843f.replace(0, 0, charSequence);
                this.f48847j.charLength = this.f48843f.length();
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f48842e : invokeV.intValue;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, str) == null) && this.f48842e == 32 && str != null) {
            this.f48843f = new SpannableStringBuilder(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int i2 = this.f48842e;
            if (i2 == 1) {
                SpannableStringBuilder spannableStringBuilder = this.f48843f;
                return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
            } else if (i2 != 8) {
                return (i2 != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
            } else {
                TbRichTextImageInfo tbRichTextImageInfo = this.f48844g;
                return tbRichTextImageInfo != null ? tbRichTextImageInfo.y() : "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void w(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) {
            this.t.add(aVar);
        }
    }

    public void x(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, charSequence) == null) {
            int i2 = this.f48842e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f48843f == null) {
                    this.f48843f = new SpannableStringBuilder("");
                }
                this.f48843f.append(charSequence);
                this.f48847j.charLength = this.f48843f.length();
            }
        }
    }

    public ArrayList<d> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.f48845h == null) {
                this.f48845h = new ArrayList<>();
            }
            return this.f48845h;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.k : (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48842e = 0;
        this.f48843f = null;
        this.f48844g = null;
        this.f48845h = null;
        this.f48846i = null;
        this.f48847j = null;
        this.p = false;
        this.q = b.f2715a;
        this.t = new ArrayList();
        this.f48842e = i2;
        this.f48847j = new TbRichTextTextInfo(this);
    }
}
