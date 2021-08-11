package com.baidu.tbadk.widget.richText;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.d1.o.a;
import c.a.o0.s.q.c2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
    public long f48588e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f48589f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f48590g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f48591h;
    public boolean hasAppendTime;

    /* renamed from: i  reason: collision with root package name */
    public String f48592i;
    public boolean isChanged;

    /* renamed from: j  reason: collision with root package name */
    public String f48593j;
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
        this.f48588e = -1L;
        this.f48589f = null;
        this.f48590g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, i2, false);
    }

    public ArrayList<TbRichTextImageInfo> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48591h : (ArrayList) invokeV.objValue;
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f48592i = context.getString(R.string.pic_str);
            this.f48593j = context.getString(R.string.voice_str);
            this.k = context.getString(R.string.video_text);
        }
    }

    public final void C(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            D(context, z, str, null, null, -1);
        }
    }

    public final void D(Context context, boolean z, String str, @Nullable PostData postData, @Nullable c2 c2Var, int i2) {
        Pair<CharSequence, a> p;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), str, postData, c2Var, Integer.valueOf(i2)}) == null) || this.f48589f == null) {
            return;
        }
        this.f48590g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f48591h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f48591h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f48589f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.R(next.E());
                    this.f48590g.add(tbRichTextData2);
                    this.f48591h.add(next.E());
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.X(next.Q());
                    this.f48590g.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence L = next.L(tbRichTextData.y(), str);
                    if (L != null) {
                        tbRichTextData.x(L);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.Y(next.T());
                    this.f48590g.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.N(next.C());
                    this.f48590g.add(tbRichTextData5);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                    tbRichTextData6.U(next.J());
                    this.f48590g.add(tbRichTextData6);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                    tbRichTextData7.T(next.H());
                    this.f48590g.add(tbRichTextData7);
                } else if (next.getType() != 50 && next.getType() != 33) {
                    int type = next.getType();
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (type == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.S(next.F());
                        this.f48590g.add(tbRichTextData8);
                    }
                    if (type == 18 || type == 2 || type == 39) {
                        tbRichTextData.Q(true);
                    }
                    if ((type == 30 || type == 31) && (p = TbRichTextHelper.p(type, c2Var, next.P())) != null) {
                        charSequence = p.first;
                        a aVar = p.second;
                        aVar.a(postData);
                        aVar.b(i2);
                        tbRichTextData.Q(true);
                        tbRichTextData.w(aVar);
                    } else {
                        charSequence = null;
                    }
                    if (charSequence == null) {
                        charSequence = next.L(tbRichTextData.y(), str);
                    }
                    if (charSequence != null) {
                        tbRichTextData.x(charSequence);
                    }
                } else {
                    if (tbRichTextData != null) {
                        this.f48590g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData9 = new TbRichTextData(next.getType());
                    tbRichTextData9.W(next.O(), c2Var);
                    this.f48590g.add(tbRichTextData9);
                }
            }
        }
        if (tbRichTextData != null) {
            this.f48590g.add(tbRichTextData);
        }
        this.f48589f.clear();
        this.f48589f = null;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f48588e = j2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48588e : invokeV.longValue;
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
            if (this.f48590g == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(100);
            int size = this.f48590g.size();
            for (int i2 = 0; i2 < size; i2++) {
                TbRichTextData tbRichTextData = this.f48590g.get(i2);
                String tbRichTextData2 = tbRichTextData.toString();
                if (tbRichTextData.getType() == 1 && tbRichTextData.G() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.G());
                }
                if (i2 == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.f48592i);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.f48593j);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.K() != null) {
                    if (StringUtils.isNull(tbRichTextData.K().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.k);
                        sb.append(tbRichTextData.K().a());
                    }
                } else {
                    sb.append(tbRichTextData2);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void w(Context context, List<PbContent> list, int i2, boolean z, String str, @Nullable PostData postData, @Nullable c2 c2Var, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, list, Integer.valueOf(i2), Boolean.valueOf(z), str, postData, c2Var, Integer.valueOf(i3)}) == null) || list == null) {
            return;
        }
        this.f48589f = new ArrayList<>();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            PbContent pbContent = list.get(i4);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.V(pbContent);
                if ((tbRichTextItem.getType() & i2) != 0) {
                    this.f48589f.add(tbRichTextItem);
                }
            }
        }
        D(context, z, str, postData, c2Var, i3);
        B(context);
    }

    public final void x(Context context, JSONArray jSONArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, jSONArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || jSONArray == null) {
            return;
        }
        this.f48589f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i3));
            if ((tbRichTextItem.getType() & i2) != 0) {
                this.f48589f.add(tbRichTextItem);
            }
        }
        C(context, z, null);
        B(context);
    }

    public ArrayList<TbRichTextData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f48590g : (ArrayList) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList<TbRichTextImageInfo> arrayList = this.f48591h;
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
                this((Context) objArr2[0], (List) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), (PostData) objArr2[4], (c2) objArr2[5], ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z, @Nullable PostData postData, @Nullable c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, Boolean.valueOf(z), postData, c2Var, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48588e = -1L;
        this.f48589f = null;
        this.f48590g = null;
        this.l = "";
        this.isChanged = false;
        w(context, list, -1, z, str, postData, c2Var, i2);
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
        this.f48588e = -1L;
        this.f48589f = null;
        this.f48590g = null;
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
        this.f48588e = -1L;
        this.f48589f = null;
        this.f48590g = null;
        this.l = "";
        this.isChanged = false;
        this.f48590g = arrayList;
        B(context);
    }
}
