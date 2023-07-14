package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.al;
import com.baidu.tieba.d36;
import com.baidu.tieba.fra;
import com.baidu.tieba.g36;
import com.baidu.tieba.hra;
import com.baidu.tieba.j36;
import com.baidu.tieba.m36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class TbRichTextData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public SpannableStringBuilder b;
    public TbRichTextImageInfo c;
    public ArrayList<d36> d;
    public TbRichTextVoiceInfo e;
    public TbRichTextTextInfo f;
    public TbRichTextEmotionInfo g;
    public j36 h;
    public TbRichTextLinkImageInfo i;
    public TbRichTextMemeInfo j;
    public int k;
    public boolean l;
    public int m;
    public TbRichTextEvaluateItemInfo n;
    public TbRichTextTiebaPlusInfo o;
    public List<m36> p;
    public g36 q;
    public fra r;
    public hra s;

    public void y0(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
        this.m = al.a;
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
                    return tbRichTextImageInfo.W();
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
        this.m = al.a;
        this.p = new ArrayList();
        this.a = i;
        this.f = new TbRichTextTextInfo(this);
    }

    public void A0(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbRichTextMemeInfo) != null) || this.a != 20) {
            return;
        }
        this.j = tbRichTextMemeInfo;
    }

    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.k = i;
        }
    }

    public void D0(j36 j36Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, j36Var) != null) || this.a != 32) {
            return;
        }
        this.h = j36Var;
    }

    public void E0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbRichTextVoiceInfo) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return;
            }
            this.e = tbRichTextVoiceInfo;
        }
    }

    public void V(@NonNull m36 m36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, m36Var) == null) {
            this.p.add(m36Var);
        }
    }

    public void p0(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, tbRichTextEmotionInfo) != null) || this.a != 17) {
            return;
        }
        this.g = tbRichTextEmotionInfo;
    }

    public void q0(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, tbRichTextEvaluateItemInfo) != null) || this.a != 1281) {
            return;
        }
        this.n = tbRichTextEvaluateItemInfo;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public void t0(fra fraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fraVar) == null) {
            this.r = fraVar;
        }
    }

    public void u0(hra hraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hraVar) == null) {
            this.s = hraVar;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.l = z;
        }
    }

    public void w0(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, tbRichTextImageInfo) != null) || this.a != 8) {
            return;
        }
        this.c = tbRichTextImageInfo;
    }

    public void x0(g36 g36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, g36Var) == null) {
            this.q = g36Var;
        }
    }

    public void z0(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, tbRichTextLinkImageInfo) == null) {
            this.i = tbRichTextLinkImageInfo;
        }
    }

    public void C0(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextTiebaPlusInfo, threadData) == null) {
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

    public void F0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
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

    public void W(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) {
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

    public ArrayList<d36> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n;
        }
        return (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public fra a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (fra) invokeV.objValue;
    }

    public hra b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.s;
        }
        return (hra) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public TbRichTextImageInfo d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a != 8) {
                return null;
            }
            return this.c;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public g36 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return (g36) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a != 1280) {
                return null;
            }
            return this.i;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.j;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public SpannableStringBuilder h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.b;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public TbRichTextTextInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a != 1) {
                return null;
            }
            return this.f;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<m36> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p;
        }
        return (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.o;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public j36 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.h;
        }
        return (j36) invokeV.objValue;
    }

    public TbRichTextVoiceInfo n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.e;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void r0(int i, int i2) {
        ArrayList<d36> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<d36> it = arrayList.iterator();
            while (it.hasNext()) {
                d36 next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void s0(int i, int i2) {
        ArrayList<d36> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<d36> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }
}
