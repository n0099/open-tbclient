package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ah5;
import com.repackage.pk;
import com.repackage.qg5;
import com.repackage.tg5;
import com.repackage.wg5;
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
    public ArrayList<qg5> d;
    public TbRichTextVoiceInfo e;
    public TbRichTextTextInfo f;
    public TbRichTextEmotionInfo g;
    public wg5 h;
    public TbRichTextLinkImageInfo i;
    public TbRichTextMemeInfo j;
    public int k;
    public boolean l;
    public int m;
    public TbRichTextEvaluateItemInfo n;
    public TbRichTextTiebaPlusInfo o;
    public List<ah5> p;
    public tg5 q;

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
        this.m = pk.a;
        this.p = new ArrayList();
    }

    public void A(@NonNull ah5 ah5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ah5Var) == null) {
            this.p.add(ah5Var);
        }
    }

    public void B(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            int i = this.a;
            if ((i == 1 || i == 768) && charSequence != null) {
                if (this.b == null) {
                    this.b = new SpannableStringBuilder("");
                }
                this.b.append(charSequence);
                this.f.charLength = this.b.length();
            }
        }
    }

    public ArrayList<qg5> C() {
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

    public TbRichTextEmotionInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public TbRichTextImageInfo G() {
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

    public tg5 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : (tg5) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo I() {
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

    public TbRichTextMemeInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (TbRichTextMemeInfo) invokeV.objValue;
    }

    public SpannableStringBuilder K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (SpannableStringBuilder) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.intValue;
    }

    public TbRichTextTextInfo M() {
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
    public List<ah5> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : (List) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    public wg5 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.h;
        }
        return (wg5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i = this.a;
            if (i == 512 || i == 768) {
                return this.e;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void S(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, tbRichTextEmotionInfo) == null) && this.a == 17) {
            this.g = tbRichTextEmotionInfo;
        }
    }

    public void T(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, tbRichTextEvaluateItemInfo) == null) && this.a == 1281) {
            this.n = tbRichTextEvaluateItemInfo;
        }
    }

    public void U(int i, int i2) {
        ArrayList<qg5> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) || (arrayList = this.d) == null) {
            return;
        }
        Iterator<qg5> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setBounds(0, 0, i, i2);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.l = z;
        }
    }

    public void W(TbRichTextImageInfo tbRichTextImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, tbRichTextImageInfo) == null) && this.a == 8) {
            this.c = tbRichTextImageInfo;
        }
    }

    public void X(tg5 tg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tg5Var) == null) {
            this.q = tg5Var;
        }
    }

    public void Y(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tbRichTextLinkButtonInfo) == null) {
        }
    }

    public void Z(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, tbRichTextLinkImageInfo) == null) {
            this.i = tbRichTextLinkImageInfo;
        }
    }

    public void a0(TbRichTextMemeInfo tbRichTextMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, tbRichTextMemeInfo) == null) && this.a == 20) {
            this.j = tbRichTextMemeInfo;
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.k = i;
        }
    }

    public void c0(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, tbRichTextTiebaPlusInfo, threadData) == null) {
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

    public void d0(wg5 wg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, wg5Var) == null) && this.a == 32) {
            this.h = wg5Var;
        }
    }

    public void e0(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tbRichTextVoiceInfo) == null) {
            int i = this.a;
            if (i == 512 || i == 768) {
                this.e = tbRichTextVoiceInfo;
            }
        }
    }

    public void f0(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, charSequence) == null) {
            int i = this.a;
            if ((i == 1 || i == 768) && charSequence != null) {
                if (this.b == null) {
                    this.b = new SpannableStringBuilder("");
                }
                this.b.replace(0, 0, charSequence);
                this.f.charLength = this.b.length();
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a : invokeV.intValue;
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            int i = this.a;
            if (i == 1) {
                SpannableStringBuilder spannableStringBuilder = this.b;
                return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
            } else if (i != 8) {
                return (i != 17 || (tbRichTextEmotionInfo = this.g) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
            } else {
                TbRichTextImageInfo tbRichTextImageInfo = this.c;
                return tbRichTextImageInfo != null ? tbRichTextImageInfo.C() : "";
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
        this.m = pk.a;
        this.p = new ArrayList();
        this.a = i;
        this.f = new TbRichTextTextInfo(this);
    }
}
