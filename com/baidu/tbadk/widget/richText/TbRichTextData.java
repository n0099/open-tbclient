package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.cu5;
import com.baidu.tieba.jk;
import com.baidu.tieba.tt5;
import com.baidu.tieba.vp9;
import com.baidu.tieba.wt5;
import com.baidu.tieba.xp9;
import com.baidu.tieba.zt5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class TbRichTextData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public SpannableStringBuilder b;
    public TbRichTextImageInfo c;
    public ArrayList<tt5> d;
    public TbRichTextVoiceInfo e;
    public TbRichTextTextInfo f;
    public TbRichTextEmotionInfo g;
    public zt5 h;
    public TbRichTextLinkImageInfo i;
    public TbRichTextMemeInfo j;
    public int k;
    public boolean l;
    public int m;
    public TbRichTextEvaluateItemInfo n;
    public TbRichTextTiebaPlusInfo o;
    public List<cu5> p;
    public wt5 q;
    public vp9 r;
    public xp9 s;

    public void u0(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.l = false;
        this.m = jk.a;
        this.p = new ArrayList();
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int i = this.a;
            if (i == 1) {
                SpannableStringBuilder spannableStringBuilder = this.b;
                if (spannableStringBuilder != null) {
                    return spannableStringBuilder.toString();
                }
                return "";
            } else if (i == 8) {
                TbRichTextImageInfo tbRichTextImageInfo = this.c;
                if (tbRichTextImageInfo != null) {
                    return tbRichTextImageInfo.S();
                }
                return "";
            } else if (i == 17 && (tbRichTextEmotionInfo = this.g) != null) {
                return tbRichTextEmotionInfo.mGifInfo.mSharpText;
            } else {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public TbRichTextData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.l = false;
        this.m = jk.a;
        this.p = new ArrayList();
        this.a = i;
        this.f = new TbRichTextTextInfo(this);
    }

    public void A0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbRichTextVoiceInfo) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return;
            }
            this.e = tbRichTextVoiceInfo;
        }
    }

    public void R(@NonNull cu5 cu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cu5Var) == null) {
            this.p.add(cu5Var);
        }
    }

    public void l0(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, tbRichTextEmotionInfo) != null) || this.a != 17) {
            return;
        }
        this.g = tbRichTextEmotionInfo;
    }

    public void m0(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, tbRichTextEvaluateItemInfo) != null) || this.a != 1281) {
            return;
        }
        this.n = tbRichTextEvaluateItemInfo;
    }

    public void p0(vp9 vp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, vp9Var) == null) {
            this.r = vp9Var;
        }
    }

    public void q0(xp9 xp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, xp9Var) == null) {
            this.s = xp9Var;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.l = z;
        }
    }

    public void s0(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, tbRichTextImageInfo) != null) || this.a != 8) {
            return;
        }
        this.c = tbRichTextImageInfo;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public void t0(wt5 wt5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, wt5Var) == null) {
            this.q = wt5Var;
        }
    }

    public void v0(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tbRichTextLinkImageInfo) == null) {
            this.i = tbRichTextLinkImageInfo;
        }
    }

    public void w0(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, tbRichTextMemeInfo) != null) || this.a != 20) {
            return;
        }
        this.j = tbRichTextMemeInfo;
    }

    public void x0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.k = i;
        }
    }

    public void z0(zt5 zt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, zt5Var) != null) || this.a != 32) {
            return;
        }
        this.h = zt5Var;
    }

    public void B0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            int i = this.a;
            if ((i != 1 && i != 768) || charSequence == null) {
                return;
            }
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.replace(0, 0, charSequence);
            this.f.charLength = this.b.length();
        }
    }

    public void S(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            int i = this.a;
            if ((i != 1 && i != 768) || charSequence == null) {
                return;
            }
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.append(charSequence);
            this.f.charLength = this.b.length();
        }
    }

    public ArrayList<tt5> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public vp9 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.r;
        }
        return (vp9) invokeV.objValue;
    }

    public xp9 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.s;
        }
        return (xp9) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public TbRichTextImageInfo Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a != 8) {
                return null;
            }
            return this.c;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public wt5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.q;
        }
        return (wt5) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a != 1280) {
                return null;
            }
            return this.i;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public TbRichTextTextInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a != 1) {
                return null;
            }
            return this.f;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<cu5> g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.p;
        }
        return (List) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public TbRichTextTiebaPlusInfo h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public zt5 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.h;
        }
        return (zt5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.e;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void n0(int i, int i2) {
        ArrayList<tt5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<tt5> it = arrayList.iterator();
            while (it.hasNext()) {
                tt5 next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void o0(int i, int i2) {
        ArrayList<tt5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<tt5> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void y0(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, tbRichTextTiebaPlusInfo, threadData) == null) {
            int i = this.a;
            if (i == 35 || i == 36) {
                this.o = tbRichTextTiebaPlusInfo;
                if (threadData != null) {
                    tbRichTextTiebaPlusInfo.setThreadData(threadData);
                    this.o.setTid(threadData.getTid());
                    this.o.setForumId(String.valueOf(threadData.getFid()));
                }
            }
        }
    }
}
