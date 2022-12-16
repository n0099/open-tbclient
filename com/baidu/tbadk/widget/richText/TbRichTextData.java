package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ao5;
import com.baidu.tieba.rn5;
import com.baidu.tieba.un5;
import com.baidu.tieba.xn5;
import com.baidu.tieba.zk;
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
    public ArrayList<rn5> d;
    public TbRichTextVoiceInfo e;
    public TbRichTextTextInfo f;
    public TbRichTextEmotionInfo g;
    public xn5 h;
    public TbRichTextLinkImageInfo i;
    public TbRichTextMemeInfo j;
    public int k;
    public boolean l;
    public int m;
    public TbRichTextEvaluateItemInfo n;
    public TbRichTextTiebaPlusInfo o;
    public List<ao5> p;
    public un5 q;

    public void f0(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, tbRichTextLinkButtonInfo) == null) {
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
        this.m = zk.a;
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
                    return tbRichTextImageInfo.H();
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
        this.m = zk.a;
        this.p = new ArrayList();
        this.a = i;
        this.f = new TbRichTextTextInfo(this);
    }

    public void G(@NonNull ao5 ao5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ao5Var) == null) {
            this.p.add(ao5Var);
        }
    }

    public void Y(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, tbRichTextEmotionInfo) != null) || this.a != 17) {
            return;
        }
        this.g = tbRichTextEmotionInfo;
    }

    public void Z(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, tbRichTextEvaluateItemInfo) != null) || this.a != 1281) {
            return;
        }
        this.n = tbRichTextEvaluateItemInfo;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.l = z;
        }
    }

    public void d0(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, tbRichTextImageInfo) != null) || this.a != 8) {
            return;
        }
        this.c = tbRichTextImageInfo;
    }

    public void e0(un5 un5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, un5Var) == null) {
            this.q = un5Var;
        }
    }

    public void g0(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tbRichTextLinkImageInfo) == null) {
            this.i = tbRichTextLinkImageInfo;
        }
    }

    public void h0(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, tbRichTextMemeInfo) != null) || this.a != 20) {
            return;
        }
        this.j = tbRichTextMemeInfo;
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.k = i;
        }
    }

    public void k0(xn5 xn5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, xn5Var) != null) || this.a != 32) {
            return;
        }
        this.h = xn5Var;
    }

    public void l0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tbRichTextVoiceInfo) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return;
            }
            this.e = tbRichTextVoiceInfo;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, str) == null) && this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public void H(CharSequence charSequence) {
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

    public void m0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, charSequence) == null) {
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

    public ArrayList<rn5> I() {
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

    public TbRichTextEmotionInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public TbRichTextImageInfo M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a != 8) {
                return null;
            }
            return this.c;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public un5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return (un5) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != 1280) {
                return null;
            }
            return this.i;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public TbRichTextTextInfo S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a != 1) {
                return null;
            }
            return this.f;
        }
        return (TbRichTextTextInfo) invokeV.objValue;
    }

    @NonNull
    public List<ao5> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.o;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public xn5 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.h;
        }
        return (xn5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.e;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void a0(int i, int i2) {
        ArrayList<rn5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<rn5> it = arrayList.iterator();
            while (it.hasNext()) {
                rn5 next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void b0(int i, int i2) {
        ArrayList<rn5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) && (arrayList = this.d) != null) {
            Iterator<rn5> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j0(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, tbRichTextTiebaPlusInfo, threadData) == null) {
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
