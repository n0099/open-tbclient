package com.baidu.tbadk.widget.richText;

import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.b0a;
import com.baidu.tieba.d26;
import com.baidu.tieba.gy9;
import com.baidu.tieba.oo5;
import com.baidu.tieba.v16;
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
/* loaded from: classes4.dex */
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

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
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
        Z();
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
                this((List) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (b0a) objArr2[3], (ThreadData) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TbRichText(List<PbContent> list, String str, boolean z, @Nullable b0a b0aVar, @Nullable ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, Boolean.valueOf(z), b0aVar, threadData, Integer.valueOf(i)};
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
        U(list, -1, z, str, b0aVar, threadData, i);
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
        V(jSONArray, i, false);
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
        V(jSONArray, -1, z);
    }

    public final void U(List<PbContent> list, int i, boolean z, String str, @Nullable b0a b0aVar, @Nullable ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), str, b0aVar, threadData, Integer.valueOf(i2)}) != null) || list == null) {
            return;
        }
        this.b = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                if (b0aVar != null) {
                    tbRichTextItem.y0(b0aVar.I());
                }
                tbRichTextItem.w0(pbContent);
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.b.add(tbRichTextItem);
                }
            }
        }
        b0(z, str, b0aVar, threadData, i2);
        Z();
    }

    public final void V(JSONArray jSONArray, int i, boolean z) {
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
        a0(z, null);
        Z();
    }

    public ArrayList<TbRichTextData> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int X() {
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

    public ArrayList<TbRichTextImageInfo> Y() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.pic_str);
            this.f = TbadkCoreApplication.getInst().getResources().getString(R.string.voice_str);
            this.g = TbadkCoreApplication.getInst().getResources().getString(R.string.video_text);
        }
    }

    public final void a0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            b0(z, str, null, null, -1);
        }
    }

    public final void b0(boolean z, String str, @Nullable b0a b0aVar, @Nullable ThreadData threadData, int i) {
        TbRichTextData tbRichTextData;
        CharSequence charSequence;
        TbRichTextCommInfo a0;
        Pair<CharSequence, d26> r;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, b0aVar, threadData, Integer.valueOf(i)}) != null) || this.b == null) {
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
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.v0(next.d0());
                        this.c.add(tbRichTextData2);
                        this.d.add(next.d0());
                    } else if (next.getType() == 37) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        if (next.e0() != null) {
                            TbRichTextData tbRichTextData3 = new TbRichTextData(37);
                            tbRichTextData3.w0(next.e0());
                            this.c.add(tbRichTextData3);
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(32);
                        tbRichTextData4.setVideoUrl(next.getVideoUrl());
                        tbRichTextData4.C0(next.r0());
                        this.c.add(tbRichTextData4);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence l0 = next.l0(tbRichTextData.W(), str);
                        if (l0 != null) {
                            tbRichTextData.V(l0);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(512);
                        tbRichTextData5.D0(next.u0());
                        this.c.add(tbRichTextData5);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(17);
                        tbRichTextData6.o0(next.b0());
                        this.c.add(tbRichTextData6);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(20);
                        tbRichTextData7.z0(next.j0());
                        this.c.add(tbRichTextData7);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1280);
                        tbRichTextData8.y0(next.h0());
                        this.c.add(tbRichTextData8);
                    } else if (next.getType() == 36) {
                        if (TiePlusHelper.l(next.p0())) {
                            if (tbRichTextData != null) {
                                this.c.add(tbRichTextData);
                                tbRichTextData = null;
                            }
                            TbRichTextData tbRichTextData9 = new TbRichTextData(next.getType());
                            tbRichTextData9.B0(next.p0(), threadData);
                            this.c.add(tbRichTextData9);
                        }
                    } else {
                        int type = next.getType();
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (type == 1024) {
                            TbRichTextData tbRichTextData10 = new TbRichTextData(1024);
                            tbRichTextData10.x0(next.f0());
                            this.c.add(tbRichTextData10);
                        }
                        if (type == 18 || type == 2 || type == 39 || type == 1282) {
                            tbRichTextData.u0(true);
                        }
                        if (type == 35 && TiePlusHelper.l(next.p0()) && (r = v16.r(type, threadData, next.q0())) != null) {
                            charSequence = r.first;
                            d26 d26Var = r.second;
                            d26Var.a(b0aVar);
                            d26Var.b(i);
                            tbRichTextData.u0(true);
                            tbRichTextData.U(d26Var);
                        } else {
                            charSequence = null;
                        }
                        if (charSequence == null && type == 18 && (a0 = next.a0()) != null) {
                            oo5 h = oo5.h(a0.getText(), a0.getLink());
                            h.d(gy9.d(TbadkCoreApplication.getInst(), a0.W()));
                            h.e(threadData);
                            h.c(b0aVar);
                            h.f(a0.a0());
                            h.b(HotTopicStat.Locate.VIDEO_MIDDLE_COMMENT);
                            charSequence = v16.q(h);
                        }
                        if (charSequence == null && tbRichTextData != null) {
                            charSequence = next.l0(tbRichTextData.W(), str);
                        }
                        if (charSequence != null && tbRichTextData != null) {
                            tbRichTextData.V(charSequence);
                        }
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.c.add(tbRichTextData);
        }
        if (b0aVar != null && b0aVar.D() != null) {
            TbRichTextData tbRichTextData11 = new TbRichTextData(1282);
            tbRichTextData11.s0(b0aVar.D());
            tbRichTextData11.t0(b0aVar.E());
            this.c.add(tbRichTextData11);
        }
        this.b.clear();
        this.b = null;
    }

    public void d0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.a = j;
        }
    }

    public void setAuthorId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.h = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(100);
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                TbRichTextData tbRichTextData = this.c.get(i);
                String tbRichTextData2 = tbRichTextData.toString();
                if (tbRichTextData.getType() == 1 && tbRichTextData.h0() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.h0());
                }
                if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.e);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.f);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.l0() != null) {
                    if (StringUtils.isNull(tbRichTextData.l0().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.g);
                        sb.append(tbRichTextData.l0().a());
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
