package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.bk;
import com.baidu.tieba.kqa;
import com.baidu.tieba.mqa;
import com.baidu.tieba.n06;
import com.baidu.tieba.q06;
import com.baidu.tieba.t06;
import com.baidu.tieba.w06;
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
    public ArrayList<n06> d;
    public TbRichTextVoiceInfo e;
    public TbRichTextTextInfo f;
    public TbRichTextEmotionInfo g;
    public t06 h;
    public TbRichTextLinkImageInfo i;
    public TbRichTextMemeInfo j;
    public int k;
    public boolean l;
    public int m;
    public TbRichTextEvaluateItemInfo n;
    public TbRichTextTiebaPlusInfo o;
    public List<w06> p;
    public q06 q;
    public kqa r;
    public mqa s;

    public void q0(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tbRichTextLinkButtonInfo) == null) {
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
        this.m = bk.a;
        this.p = new ArrayList();
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
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
                    return tbRichTextImageInfo.O();
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
        this.m = bk.a;
        this.p = new ArrayList();
        this.a = i;
        this.f = new TbRichTextTextInfo(this);
    }

    public void N(@NonNull w06 w06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w06Var) == null) {
            this.p.add(w06Var);
        }
    }

    public void h0(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, tbRichTextEmotionInfo) != null) || this.a != 17) {
            return;
        }
        this.g = tbRichTextEmotionInfo;
    }

    public void i0(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, tbRichTextEvaluateItemInfo) != null) || this.a != 1281) {
            return;
        }
        this.n = tbRichTextEvaluateItemInfo;
    }

    public void l0(kqa kqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, kqaVar) == null) {
            this.r = kqaVar;
        }
    }

    public void m0(mqa mqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mqaVar) == null) {
            this.s = mqaVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.l = z;
        }
    }

    public void o0(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, tbRichTextImageInfo) != null) || this.a != 8) {
            return;
        }
        this.c = tbRichTextImageInfo;
    }

    public void p0(q06 q06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, q06Var) == null) {
            this.q = q06Var;
        }
    }

    public void r0(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, tbRichTextLinkImageInfo) == null) {
            this.i = tbRichTextLinkImageInfo;
        }
    }

    public void s0(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, tbRichTextMemeInfo) != null) || this.a != 20) {
            return;
        }
        this.j = tbRichTextMemeInfo;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.k = i;
        }
    }

    public void v0(t06 t06Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, t06Var) != null) || this.a != 32) {
            return;
        }
        this.h = t06Var;
    }

    public void w0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, tbRichTextVoiceInfo) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return;
            }
            this.e = tbRichTextVoiceInfo;
        }
    }

    public void O(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
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

    public void x0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, charSequence) == null) {
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

    public ArrayList<n06> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEmotionInfo Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public kqa S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (kqa) invokeV.objValue;
    }

    public mqa T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.s;
        }
        return (mqa) invokeV.objValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public TbRichTextImageInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != 8) {
                return null;
            }
            return this.c;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public q06 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return (q06) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a != 1280) {
                return null;
            }
            return this.i;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public TbRichTextTextInfo b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a != 1) {
                return null;
            }
            return this.f;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<w06> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.p;
        }
        return (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public t06 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.h;
        }
        return (t06) invokeV.objValue;
    }

    public TbRichTextVoiceInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.e;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void j0(int i, int i2) {
        ArrayList<n06> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<n06> it = arrayList.iterator();
            while (it.hasNext()) {
                n06 next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void k0(int i, int i2) {
        ArrayList<n06> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<n06> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void u0(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, tbRichTextTiebaPlusInfo, threadData) == null) {
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
