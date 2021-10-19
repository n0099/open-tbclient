package com.baidu.tbadk.widget.richText;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.f1.m.e;
import c.a.q0.f1.o.a;
import c.a.q0.i0.c.b;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes6.dex */
public class TbRichText extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appendLength;

    /* renamed from: e  reason: collision with root package name */
    public long f48879e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f48880f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f48881g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f48882h;
    public boolean hasAppendTime;

    /* renamed from: i  reason: collision with root package name */
    public String f48883i;
    public boolean isChanged;

    /* renamed from: j  reason: collision with root package name */
    public String f48884j;
    public String k;
    public String l;

    public TbRichText(Context context, JSONArray jSONArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f48879e = -1L;
        this.f48880f = null;
        this.f48881g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, i2, false);
    }

    public ArrayList<TbRichTextImageInfo> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48882h : (ArrayList) invokeV.objValue;
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f48883i = context.getString(R.string.pic_str);
            this.f48884j = context.getString(R.string.voice_str);
            this.k = context.getString(R.string.video_text);
        }
    }

    public final void C(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            D(context, z, str, null, null, -1);
        }
    }

    public final void D(Context context, boolean z, String str, @Nullable PostData postData, @Nullable d2 d2Var, int i2) {
        CharSequence charSequence;
        TbRichTextCommInfo C;
        Pair<CharSequence, a> p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), str, postData, d2Var, Integer.valueOf(i2)}) == null) || this.f48880f == null) {
            return;
        }
        this.f48881g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f48882h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f48882h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f48880f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.S(next.F());
                    this.f48881g.add(tbRichTextData2);
                    this.f48882h.add(next.F());
                } else if (next.getType() == 37) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    if (next.G() != null) {
                        TbRichTextData tbRichTextData3 = new TbRichTextData(37);
                        tbRichTextData3.T(next.G());
                        this.f48881g.add(tbRichTextData3);
                    }
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(32);
                    tbRichTextData4.setVideoUrl(next.getVideoUrl());
                    tbRichTextData4.Z(next.S());
                    this.f48881g.add(tbRichTextData4);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence N = next.N(tbRichTextData.y(), str);
                    if (N != null) {
                        tbRichTextData.x(N);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(512);
                    tbRichTextData5.a0(next.V());
                    this.f48881g.add(tbRichTextData5);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(17);
                    tbRichTextData6.O(next.D());
                    this.f48881g.add(tbRichTextData6);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(20);
                    tbRichTextData7.W(next.L());
                    this.f48881g.add(tbRichTextData7);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData8 = new TbRichTextData(1280);
                    tbRichTextData8.V(next.J());
                    this.f48881g.add(tbRichTextData8);
                } else if (next.getType() == 36) {
                    if (tbRichTextData != null) {
                        this.f48881g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData9 = new TbRichTextData(next.getType());
                    tbRichTextData9.Y(next.Q(), d2Var);
                    this.f48881g.add(tbRichTextData9);
                } else {
                    int type = next.getType();
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (type == 1024) {
                        TbRichTextData tbRichTextData10 = new TbRichTextData(1024);
                        tbRichTextData10.U(next.H());
                        this.f48881g.add(tbRichTextData10);
                    }
                    if (type == 18 || type == 2 || type == 39 || type == 1282) {
                        tbRichTextData.R(true);
                    }
                    if (type != 35 || (p = e.p(type, d2Var, next.R())) == null) {
                        charSequence = null;
                    } else {
                        charSequence = p.first;
                        a aVar = p.second;
                        aVar.a(postData);
                        aVar.b(i2);
                        tbRichTextData.R(true);
                        tbRichTextData.w(aVar);
                    }
                    if (charSequence == null && type == 18 && (C = next.C()) != null) {
                        PbContent z2 = C.z();
                        if (d2Var != null && z2 != null) {
                            b f2 = b.f(d2Var, z2);
                            f2.c(postData);
                            f2.b(HotTopicStat.Locate.VIDEO_MIDDLE_COMMENT);
                            charSequence = e.o(f2);
                        }
                    }
                    if (charSequence == null) {
                        charSequence = next.N(tbRichTextData.y(), str);
                    }
                    if (charSequence != null) {
                        tbRichTextData.x(charSequence);
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.f48881g.add(tbRichTextData);
        }
        this.f48880f.clear();
        this.f48880f = null;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f48879e = j2;
        }
    }

    public String getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48879e : invokeV.longValue;
    }

    public void setAuthorId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f48881g == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(100);
            int size = this.f48881g.size();
            for (int i2 = 0; i2 < size; i2++) {
                TbRichTextData tbRichTextData = this.f48881g.get(i2);
                String tbRichTextData2 = tbRichTextData.toString();
                if (tbRichTextData.getType() == 1 && tbRichTextData.H() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.H());
                }
                if (i2 == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.f48883i);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.f48884j);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.L() != null) {
                    if (StringUtils.isNull(tbRichTextData.L().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.k);
                        sb.append(tbRichTextData.L().a());
                    }
                } else {
                    sb.append(tbRichTextData2);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void w(Context context, List<PbContent> list, int i2, boolean z, String str, @Nullable PostData postData, @Nullable d2 d2Var, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, list, Integer.valueOf(i2), Boolean.valueOf(z), str, postData, d2Var, Integer.valueOf(i3)}) == null) || list == null) {
            return;
        }
        this.f48880f = new ArrayList<>();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            PbContent pbContent = list.get(i4);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.X(pbContent);
                if ((tbRichTextItem.getType() & i2) != 0) {
                    this.f48880f.add(tbRichTextItem);
                }
            }
        }
        D(context, z, str, postData, d2Var, i3);
        B(context);
    }

    public final void x(Context context, JSONArray jSONArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, jSONArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || jSONArray == null) {
            return;
        }
        this.f48880f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i3));
            if ((tbRichTextItem.getType() & i2) != 0) {
                this.f48880f.add(tbRichTextItem);
            }
        }
        C(context, z, null);
        B(context);
    }

    public ArrayList<TbRichTextData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f48881g : (ArrayList) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList<TbRichTextImageInfo> arrayList = this.f48882h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this(context, list, str, z, null, null, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), (PostData) objArr2[4], (d2) objArr2[5], ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z, @Nullable PostData postData, @Nullable d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, Boolean.valueOf(z), postData, d2Var, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48879e = -1L;
        this.f48880f = null;
        this.f48881g = null;
        this.l = "";
        this.isChanged = false;
        w(context, list, -1, z, str, postData, d2Var, i2);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f48879e = -1L;
        this.f48880f = null;
        this.f48881g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, -1, z);
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48879e = -1L;
        this.f48880f = null;
        this.f48881g = null;
        this.l = "";
        this.isChanged = false;
        this.f48881g = arrayList;
        B(context);
    }
}
