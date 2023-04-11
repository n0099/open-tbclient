package com.baidu.tbadk.widget.richText;

import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.av5;
import com.baidu.tieba.di5;
import com.baidu.tieba.iv5;
import com.baidu.tieba.sl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichText extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int appendLength;
    public ArrayList<TbRichTextItem> b;
    public ArrayList<TbRichTextData> c;
    public ArrayList<TbRichTextImageInfo> d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean hasAppendTime;
    public boolean isChanged;

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public TbRichText(ArrayList<TbRichTextData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.h = "";
        this.isChanged = false;
        this.c = arrayList;
        V();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbRichText(List<PbContent> list, String str, boolean z) {
        this(list, str, z, null, null, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (sl9) objArr2[3], (ThreadData) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TbRichText(List<PbContent> list, String str, boolean z, @Nullable sl9 sl9Var, @Nullable ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, Boolean.valueOf(z), sl9Var, threadData, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.h = "";
        this.isChanged = false;
        Q(list, -1, z, str, sl9Var, threadData, i);
    }

    public TbRichText(JSONArray jSONArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.h = "";
        this.isChanged = false;
        R(jSONArray, i, false);
    }

    public TbRichText(JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.h = "";
        this.isChanged = false;
        R(jSONArray, -1, z);
    }

    public final void Q(List<PbContent> list, int i, boolean z, String str, @Nullable sl9 sl9Var, @Nullable ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), str, sl9Var, threadData, Integer.valueOf(i2)}) != null) || list == null) {
            return;
        }
        this.b = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                if (sl9Var != null) {
                    tbRichTextItem.u0(sl9Var.E());
                }
                tbRichTextItem.s0(pbContent);
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.b.add(tbRichTextItem);
                }
            }
        }
        Y(z, str, sl9Var, threadData, i2);
        V();
    }

    public final void R(JSONArray jSONArray, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONArray, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || jSONArray == null) {
            return;
        }
        this.b = new ArrayList<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
            if ((tbRichTextItem.getType() & i) != 0) {
                this.b.add(tbRichTextItem);
            }
        }
        X(z, null);
        V();
    }

    public ArrayList<TbRichTextData> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<TbRichTextImageInfo> arrayList = this.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<TbRichTextImageInfo> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.pic_str);
            this.f = TbadkCoreApplication.getInst().getResources().getString(R.string.voice_str);
            this.g = TbadkCoreApplication.getInst().getResources().getString(R.string.video_text);
        }
    }

    public final void W(TbRichTextItem tbRichTextItem) {
        TbRichTextTiebaPlusInfo l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, tbRichTextItem) == null) && tbRichTextItem != null && tbRichTextItem.getType() == 36 && UbsABTestHelper.isTiebaPlusCardModelABTestB() && (l0 = tbRichTextItem.l0()) != null && l0.S() != null && l0.S().plugin_user != null && l0.S().plugin_user.is_download_card_whiteuser.intValue() == 1) {
            tbRichTextItem.setType(35);
        }
    }

    public final void X(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            Y(z, str, null, null, -1);
        }
    }

    public final void Y(boolean z, String str, @Nullable sl9 sl9Var, @Nullable ThreadData threadData, int i) {
        TbRichTextData tbRichTextData;
        CharSequence charSequence;
        TbRichTextCommInfo W;
        Pair<CharSequence, iv5> r;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, sl9Var, threadData, Integer.valueOf(i)}) != null) || this.b == null) {
            return;
        }
        this.c = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.d;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.d = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.b.iterator();
        loop0: while (true) {
            tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    W(next);
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.r0(next.Z());
                        this.c.add(tbRichTextData2);
                        this.d.add(next.Z());
                    } else if (next.getType() == 37) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        if (next.a0() != null) {
                            TbRichTextData tbRichTextData3 = new TbRichTextData(37);
                            tbRichTextData3.s0(next.a0());
                            this.c.add(tbRichTextData3);
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(32);
                        tbRichTextData4.setVideoUrl(next.getVideoUrl());
                        tbRichTextData4.y0(next.n0());
                        this.c.add(tbRichTextData4);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence h0 = next.h0(tbRichTextData.S(), str);
                        if (h0 != null) {
                            tbRichTextData.R(h0);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(512);
                        tbRichTextData5.z0(next.q0());
                        this.c.add(tbRichTextData5);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(17);
                        tbRichTextData6.k0(next.X());
                        this.c.add(tbRichTextData6);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(20);
                        tbRichTextData7.v0(next.f0());
                        this.c.add(tbRichTextData7);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1280);
                        tbRichTextData8.u0(next.d0());
                        this.c.add(tbRichTextData8);
                    } else if (next.getType() == 36) {
                        if (TiePlusHelper.l(next.l0())) {
                            if (tbRichTextData != null) {
                                this.c.add(tbRichTextData);
                                tbRichTextData = null;
                            }
                            TbRichTextData tbRichTextData9 = new TbRichTextData(next.getType());
                            tbRichTextData9.x0(next.l0(), threadData);
                            this.c.add(tbRichTextData9);
                        }
                    } else {
                        int type = next.getType();
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (type == 1024) {
                            TbRichTextData tbRichTextData10 = new TbRichTextData(1024);
                            tbRichTextData10.t0(next.b0());
                            this.c.add(tbRichTextData10);
                        }
                        if (type == 18 || type == 2 || type == 39 || type == 1282) {
                            tbRichTextData.q0(true);
                        }
                        if (type == 35 && TiePlusHelper.l(next.l0()) && (r = av5.r(type, threadData, next.m0())) != null) {
                            charSequence = r.first;
                            iv5 iv5Var = r.second;
                            iv5Var.a(sl9Var);
                            iv5Var.b(i);
                            tbRichTextData.q0(true);
                            tbRichTextData.Q(iv5Var);
                        } else {
                            charSequence = null;
                        }
                        if (charSequence == null && type == 18 && (W = next.W()) != null) {
                            PbContent T = W.T();
                            if (threadData != null && T != null) {
                                di5 f = di5.f(threadData, T);
                                f.c(sl9Var);
                                f.b(HotTopicStat.Locate.VIDEO_MIDDLE_COMMENT);
                                charSequence = av5.q(f);
                            }
                        }
                        if (charSequence == null && tbRichTextData != null) {
                            charSequence = next.h0(tbRichTextData.S(), str);
                        }
                        if (charSequence != null && tbRichTextData != null) {
                            tbRichTextData.R(charSequence);
                        }
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.c.add(tbRichTextData);
        }
        if (sl9Var != null && sl9Var.z() != null) {
            TbRichTextData tbRichTextData11 = new TbRichTextData(1282);
            tbRichTextData11.o0(sl9Var.z());
            tbRichTextData11.p0(sl9Var.A());
            this.c.add(tbRichTextData11);
        }
        this.b.clear();
        this.b = null;
    }

    public void a0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.a = j;
        }
    }

    public void setAuthorId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.h = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.c == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(100);
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                TbRichTextData tbRichTextData = this.c.get(i);
                String tbRichTextData2 = tbRichTextData.toString();
                if (tbRichTextData.getType() == 1 && tbRichTextData.d0() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.d0());
                }
                if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.e);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.f);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.h0() != null) {
                    if (StringUtils.isNull(tbRichTextData.h0().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.g);
                        sb.append(tbRichTextData.h0().a());
                    }
                } else {
                    sb.append(tbRichTextData2);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
