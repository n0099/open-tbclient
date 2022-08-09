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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fi5;
import com.repackage.oi5;
import com.repackage.z65;
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
        A(jSONArray, i, false);
    }

    public final void A(JSONArray jSONArray, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONArray, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || jSONArray == null) {
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
        G(z, null);
        E();
    }

    public ArrayList<TbRichTextData> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<TbRichTextImageInfo> arrayList = this.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<TbRichTextImageInfo> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (ArrayList) invokeV.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e79);
            this.f = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1577);
            this.g = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1537);
        }
    }

    public final void F(TbRichTextItem tbRichTextItem) {
        TbRichTextTiebaPlusInfo T;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbRichTextItem) == null) || tbRichTextItem == null || tbRichTextItem.getType() != 36 || !UbsABTestHelper.isTiebaPlusCardModelABTestB() || (T = tbRichTextItem.T()) == null || T.B() == null || T.B().plugin_user == null || T.B().plugin_user.is_download_card_whiteuser.intValue() != 1) {
            return;
        }
        tbRichTextItem.setType(35);
    }

    public final void G(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            H(z, str, null, null, -1);
        }
    }

    public final void H(boolean z, String str, @Nullable PostData postData, @Nullable ThreadData threadData, int i) {
        TbRichTextData tbRichTextData;
        CharSequence charSequence;
        TbRichTextCommInfo F;
        Pair<CharSequence, oi5> p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, postData, threadData, Integer.valueOf(i)}) == null) || this.b == null) {
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
                    F(next);
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.V(next.I());
                        this.c.add(tbRichTextData2);
                        this.d.add(next.I());
                    } else if (next.getType() == 37) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        if (next.J() != null) {
                            TbRichTextData tbRichTextData3 = new TbRichTextData(37);
                            tbRichTextData3.W(next.J());
                            this.c.add(tbRichTextData3);
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(32);
                        tbRichTextData4.setVideoUrl(next.getVideoUrl());
                        tbRichTextData4.c0(next.V());
                        this.c.add(tbRichTextData4);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence Q = next.Q(tbRichTextData.B(), str);
                        if (Q != null) {
                            tbRichTextData.A(Q);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(512);
                        tbRichTextData5.d0(next.Y());
                        this.c.add(tbRichTextData5);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(17);
                        tbRichTextData6.R(next.G());
                        this.c.add(tbRichTextData6);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(20);
                        tbRichTextData7.Z(next.O());
                        this.c.add(tbRichTextData7);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.c.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1280);
                        tbRichTextData8.Y(next.M());
                        this.c.add(tbRichTextData8);
                    } else if (next.getType() == 36) {
                        if (TiePlusHelper.i(next.T())) {
                            if (tbRichTextData != null) {
                                this.c.add(tbRichTextData);
                                tbRichTextData = null;
                            }
                            TbRichTextData tbRichTextData9 = new TbRichTextData(next.getType());
                            tbRichTextData9.b0(next.T(), threadData);
                            this.c.add(tbRichTextData9);
                        }
                    } else {
                        int type = next.getType();
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (type == 1024) {
                            TbRichTextData tbRichTextData10 = new TbRichTextData(1024);
                            tbRichTextData10.X(next.K());
                            this.c.add(tbRichTextData10);
                        }
                        if (type == 18 || type == 2 || type == 39 || type == 1282) {
                            tbRichTextData.U(true);
                        }
                        if (type == 35 && TiePlusHelper.i(next.T()) && (p = fi5.p(type, threadData, next.U())) != null) {
                            charSequence = p.first;
                            oi5 oi5Var = p.second;
                            oi5Var.a(postData);
                            oi5Var.b(i);
                            tbRichTextData.U(true);
                            tbRichTextData.z(oi5Var);
                        } else {
                            charSequence = null;
                        }
                        if (charSequence == null && type == 18 && (F = next.F()) != null) {
                            PbContent C = F.C();
                            if (threadData != null && C != null) {
                                z65 f = z65.f(threadData, C);
                                f.c(postData);
                                f.b(HotTopicStat.Locate.VIDEO_MIDDLE_COMMENT);
                                charSequence = fi5.o(f);
                            }
                        }
                        if (charSequence == null && tbRichTextData != null) {
                            charSequence = next.Q(tbRichTextData.B(), str);
                        }
                        if (charSequence != null && tbRichTextData != null) {
                            tbRichTextData.A(charSequence);
                        }
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.c.add(tbRichTextData);
        }
        this.b.clear();
        this.b = null;
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void J(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.a = j;
        }
    }

    public String getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.longValue;
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
                if (tbRichTextData.getType() == 1 && tbRichTextData.K() > 0) {
                    tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.K());
                }
                if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                    sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
                } else if (tbRichTextData.getType() == 8) {
                    sb.append(this.e);
                } else if (tbRichTextData.getType() == 512) {
                    sb.append(this.f);
                } else if (tbRichTextData.getType() == 32 && tbRichTextData.O() != null) {
                    if (StringUtils.isNull(tbRichTextData.O().a())) {
                        sb.append(tbRichTextData2);
                    } else {
                        sb.append(this.g);
                        sb.append(tbRichTextData.O().a());
                    }
                } else {
                    sb.append(tbRichTextData2);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void z(List<PbContent> list, int i, boolean z, String str, @Nullable PostData postData, @Nullable ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), str, postData, threadData, Integer.valueOf(i2)}) == null) || list == null) {
            return;
        }
        this.b = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.a0(pbContent);
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.b.add(tbRichTextItem);
                }
            }
        }
        H(z, str, postData, threadData, i2);
        E();
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
                this((List) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (PostData) objArr2[3], (ThreadData) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TbRichText(List<PbContent> list, String str, boolean z, @Nullable PostData postData, @Nullable ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, Boolean.valueOf(z), postData, threadData, Integer.valueOf(i)};
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
        z(list, -1, z, str, postData, threadData, i);
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
        A(jSONArray, -1, z);
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
        E();
    }
}
