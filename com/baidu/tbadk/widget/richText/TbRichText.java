package com.baidu.tbadk.widget.richText;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
    public int appendLength;

    /* renamed from: e  reason: collision with root package name */
    public long f13491e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f13492f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f13493g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13494h;
    public boolean hasAppendTime;

    /* renamed from: i  reason: collision with root package name */
    public String f13495i;
    public boolean isChanged;
    public String j;
    public String k;
    public String l;

    public TbRichText(Context context, JSONArray jSONArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13491e = -1L;
        this.f13492f = null;
        this.f13493g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, i2, false);
    }

    public ArrayList<TbRichTextImageInfo> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13494h : (ArrayList) invokeV.objValue;
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f13495i = context.getString(R.string.pic_str);
            this.j = context.getString(R.string.voice_str);
            this.k = context.getString(R.string.video_text);
        }
    }

    public final void C(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), str}) == null) || this.f13492f == null) {
            return;
        }
        this.f13493g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f13494h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f13494h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f13492f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.O(next.E());
                    this.f13493g.add(tbRichTextData2);
                    this.f13494h.add(next.E());
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.T(next.O());
                    this.f13493g.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence L = next.L(tbRichTextData.x(), str);
                    if (L != null) {
                        tbRichTextData.w(L);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.U(next.R());
                    this.f13493g.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.K(next.C());
                    this.f13493g.add(tbRichTextData5);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                    tbRichTextData6.R(next.J());
                    this.f13493g.add(tbRichTextData6);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f13493g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                    tbRichTextData7.Q(next.H());
                    this.f13493g.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.P(next.F());
                        this.f13493g.add(tbRichTextData8);
                    }
                    if (next.getType() == 18 || next.getType() == 2 || next.getType() == 39) {
                        tbRichTextData.N(true);
                    }
                    CharSequence L2 = next.L(tbRichTextData.x(), str);
                    if (L2 != null) {
                        tbRichTextData.w(L2);
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.f13493g.add(tbRichTextData);
        }
        this.f13492f.clear();
        this.f13492f = null;
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f13491e = j;
        }
    }

    public String getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13491e : invokeV.longValue;
    }

    public void setAuthorId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f13493g == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(100);
            int size = this.f13493g.size();
            for (int i2 = 0; i2 < size; i2++) {
                TbRichTextData tbRichTextData = this.f13493g.get(i2);
                String tbRichTextData2 = tbRichTextData.toString();
                if (tbRichTextData.getType() == 1 && tbRichTextData.F() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.F());
                }
                if (i2 == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.f13495i);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.j);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.H() != null) {
                    if (StringUtils.isNull(tbRichTextData.H().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.k);
                        sb.append(tbRichTextData.H().a());
                    }
                } else {
                    sb.append(tbRichTextData2);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void w(Context context, List<PbContent> list, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, list, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || list == null) {
            return;
        }
        this.f13492f = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.T(pbContent);
                if ((tbRichTextItem.getType() & i2) != 0) {
                    this.f13492f.add(tbRichTextItem);
                }
            }
        }
        C(context, z, str);
        B(context);
    }

    public final void x(Context context, JSONArray jSONArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, jSONArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || jSONArray == null) {
            return;
        }
        this.f13492f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i3));
            if ((tbRichTextItem.getType() & i2) != 0) {
                this.f13492f.add(tbRichTextItem);
            }
        }
        C(context, z, null);
        B(context);
    }

    public ArrayList<TbRichTextData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13493g : (ArrayList) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<TbRichTextImageInfo> arrayList = this.f13494h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13491e = -1L;
        this.f13492f = null;
        this.f13493g = null;
        this.l = "";
        this.isChanged = false;
        w(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f13491e = -1L;
        this.f13492f = null;
        this.f13493g = null;
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
        this.f13491e = -1L;
        this.f13492f = null;
        this.f13493g = null;
        this.l = "";
        this.isChanged = false;
        this.f13493g = arrayList;
        B(context);
    }
}
