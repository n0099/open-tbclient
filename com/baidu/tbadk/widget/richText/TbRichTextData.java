package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.f.a.b;
import d.a.p0.d1.m.d;
import d.a.p0.d1.m.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TbRichTextData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13550e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f13551f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f13552g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f13553h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextVoiceInfo f13554i;
    public TbRichTextTextInfo j;
    public TbRichTextEmotionInfo k;
    public i l;
    public TbRichTextLinkImageInfo m;
    public TbRichTextMemeInfo n;
    public int o;
    public boolean p;
    public int q;
    public TbRichTextEvaluateItemInfo r;

    /* loaded from: classes3.dex */
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
        this.f13550e = 0;
        this.f13551f = null;
        this.f13552g = null;
        this.f13553h = null;
        this.f13554i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42100a;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : invokeV.intValue;
    }

    public TbRichTextImageInfo B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f13550e != 8) {
                return null;
            }
            return this.f13552g;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f13550e != 1280) {
                return null;
            }
            return this.m;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13551f : (SpannableStringBuilder) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.intValue;
    }

    public TbRichTextTextInfo G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f13550e != 1) {
                return null;
            }
            return this.j;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    public i H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f13550e != 32) {
                return null;
            }
            return this.l;
        }
        return (i) invokeV.objValue;
    }

    public TbRichTextVoiceInfo I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f13550e;
            if (i2 == 512 || i2 == 768) {
                return this.f13554i;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void K(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, tbRichTextEmotionInfo) == null) && this.f13550e == 17) {
            this.k = tbRichTextEmotionInfo;
        }
    }

    public void L(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, tbRichTextEvaluateItemInfo) == null) && this.f13550e == 1281) {
            this.r = tbRichTextEvaluateItemInfo;
        }
    }

    public void M(int i2, int i3) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || (arrayList = this.f13553h) == null) {
            return;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setBounds(0, 0, i2, i3);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.p = z;
        }
    }

    public void O(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, tbRichTextImageInfo) == null) && this.f13550e == 8) {
            this.f13552g = tbRichTextImageInfo;
        }
    }

    public void P(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

    public void Q(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbRichTextLinkImageInfo) == null) {
            this.m = tbRichTextLinkImageInfo;
        }
    }

    public void R(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, tbRichTextMemeInfo) == null) && this.f13550e == 20) {
            this.n = tbRichTextMemeInfo;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.o = i2;
        }
    }

    public void T(i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, iVar) == null) && this.f13550e == 32) {
            this.l = iVar;
        }
    }

    public void U(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, tbRichTextVoiceInfo) == null) {
            int i2 = this.f13550e;
            if (i2 == 512 || i2 == 768) {
                this.f13554i = tbRichTextVoiceInfo;
            }
        }
    }

    public void V(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, charSequence) == null) {
            int i2 = this.f13550e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f13551f == null) {
                    this.f13551f = new SpannableStringBuilder("");
                }
                this.f13551f.replace(0, 0, charSequence);
                this.j.charLength = this.f13551f.length();
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f13550e : invokeV.intValue;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && this.f13550e == 32 && str != null) {
            this.f13551f = new SpannableStringBuilder(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = this.f13550e;
            if (i2 == 1) {
                SpannableStringBuilder spannableStringBuilder = this.f13551f;
                return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
            } else if (i2 != 8) {
                return (i2 != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
            } else {
                TbRichTextImageInfo tbRichTextImageInfo = this.f13552g;
                return tbRichTextImageInfo != null ? tbRichTextImageInfo.y() : "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void w(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, charSequence) == null) {
            int i2 = this.f13550e;
            if ((i2 == 1 || i2 == 768) && charSequence != null) {
                if (this.f13551f == null) {
                    this.f13551f = new SpannableStringBuilder("");
                }
                this.f13551f.append(charSequence);
                this.j.charLength = this.f13551f.length();
            }
        }
    }

    public ArrayList<d> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f13553h == null) {
                this.f13553h = new ArrayList<>();
            }
            return this.f13553h;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k : (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.r : (TbRichTextEvaluateItemInfo) invokeV.objValue;
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
        this.f13550e = 0;
        this.f13551f = null;
        this.f13552g = null;
        this.f13553h = null;
        this.f13554i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42100a;
        this.f13550e = i2;
        this.j = new TbRichTextTextInfo(this);
    }
}
