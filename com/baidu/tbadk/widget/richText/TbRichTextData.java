package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.g.a.b;
import c.a.s0.g1.n.d;
import c.a.s0.g1.n.g;
import c.a.s0.g1.n.j;
import c.a.s0.g1.p.a;
import c.a.s0.s.q.e2;
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
/* loaded from: classes11.dex */
public class TbRichTextData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41454e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f41455f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f41456g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f41457h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextVoiceInfo f41458i;

    /* renamed from: j  reason: collision with root package name */
    public TbRichTextTextInfo f41459j;
    public TbRichTextEmotionInfo k;
    public j l;
    public TbRichTextLinkImageInfo m;
    public TbRichTextMemeInfo n;
    public int o;
    public boolean p;
    public int q;
    public TbRichTextEvaluateItemInfo r;
    public TbRichTextTiebaPlusInfo s;
    public List<a> t;
    public g u;

    /* loaded from: classes11.dex */
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
        this.f41454e = 0;
        this.f41455f = null;
        this.f41456g = null;
        this.f41457h = null;
        this.f41458i = null;
        this.f41459j = null;
        this.p = false;
        this.q = b.a;
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
            if (this.f41454e != 8) {
                return null;
            }
            return this.f41456g;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public g D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : (g) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f41454e != 1280) {
                return null;
            }
            return this.m;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41455f : (SpannableStringBuilder) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.intValue;
    }

    public TbRichTextTextInfo I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f41454e != 1) {
                return null;
            }
            return this.f41459j;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<a> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public j L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f41454e != 32) {
                return null;
            }
            return this.l;
        }
        return (j) invokeV.objValue;
    }

    public TbRichTextVoiceInfo M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f41454e;
            if (i2 == 512 || i2 == 768) {
                return this.f41458i;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void O(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, tbRichTextEmotionInfo) == null) && this.f41454e == 17) {
            this.k = tbRichTextEmotionInfo;
        }
    }

    public void P(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, tbRichTextEvaluateItemInfo) == null) && this.f41454e == 1281) {
            this.r = tbRichTextEvaluateItemInfo;
        }
    }

    public void Q(int i2, int i3) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || (arrayList = this.f41457h) == null) {
            return;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setBounds(0, 0, i2, i3);
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.p = z;
        }
    }

    public void S(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, tbRichTextImageInfo) == null) && this.f41454e == 8) {
            this.f41456g = tbRichTextImageInfo;
        }
    }

    public void T(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.u = gVar;
        }
    }

    public void U(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

    public void V(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbRichTextLinkImageInfo) == null) {
            this.m = tbRichTextLinkImageInfo;
        }
    }

    public void W(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, tbRichTextMemeInfo) == null) && this.f41454e == 20) {
            this.n = tbRichTextMemeInfo;
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.o = i2;
        }
    }

    public void Y(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, tbRichTextTiebaPlusInfo, e2Var) == null) {
            int i2 = this.f41454e;
            if (i2 == 35 || i2 == 36) {
                this.s = tbRichTextTiebaPlusInfo;
                if (e2Var != null) {
                    tbRichTextTiebaPlusInfo.A(e2Var);
                    this.s.setTid(e2Var.v1());
                    this.s.setForumId(String.valueOf(e2Var.U()));
                }
            }
        }
    }

    public void Z(j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, jVar) == null) && this.f41454e == 32) {
            this.l = jVar;
        }
    }

    public void a0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tbRichTextVoiceInfo) == null) {
            int i2 = this.f41454e;
            if (i2 == 512 || i2 == 768) {
                this.f41458i = tbRichTextVoiceInfo;
            }
        }
    }

    public void b0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, charSequence) == null) {
            int i2 = this.f41454e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f41455f == null) {
                    this.f41455f = new SpannableStringBuilder("");
                }
                this.f41455f.replace(0, 0, charSequence);
                this.f41459j.charLength = this.f41455f.length();
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f41454e : invokeV.intValue;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && this.f41454e == 32 && str != null) {
            this.f41455f = new SpannableStringBuilder(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i2 = this.f41454e;
            if (i2 == 1) {
                SpannableStringBuilder spannableStringBuilder = this.f41455f;
                return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
            } else if (i2 != 8) {
                return (i2 != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
            } else {
                TbRichTextImageInfo tbRichTextImageInfo = this.f41456g;
                return tbRichTextImageInfo != null ? tbRichTextImageInfo.y() : "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void w(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            this.t.add(aVar);
        }
    }

    public void x(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, charSequence) == null) {
            int i2 = this.f41454e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f41455f == null) {
                    this.f41455f = new SpannableStringBuilder("");
                }
                this.f41455f.append(charSequence);
                this.f41459j.charLength = this.f41455f.length();
            }
        }
    }

    public ArrayList<d> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f41457h == null) {
                this.f41457h = new ArrayList<>();
            }
            return this.f41457h;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.k : (TbRichTextEmotionInfo) invokeV.objValue;
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
        this.f41454e = 0;
        this.f41455f = null;
        this.f41456g = null;
        this.f41457h = null;
        this.f41458i = null;
        this.f41459j = null;
        this.p = false;
        this.q = b.a;
        this.t = new ArrayList();
        this.f41454e = i2;
        this.f41459j = new TbRichTextTextInfo(this);
    }
}
