package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.b0.a;
import c.a.o0.e1.n.d;
import c.a.o0.e1.n.e;
import c.a.o0.e1.n.f;
import c.a.o0.e1.n.g;
import c.a.o0.e1.n.h;
import c.a.o0.e1.n.j;
import c.a.o0.t.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class TbRichTextItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbRichTextCommInfo f30950b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextImageInfo f30951c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextVoiceInfo f30952d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextEmotionInfo f30953e;

    /* renamed from: f  reason: collision with root package name */
    public j f30954f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextLinkButtonInfo f30955g;

    /* renamed from: h  reason: collision with root package name */
    public TbRichTextLinkImageInfo f30956h;
    public TbRichTextMemeInfo i;
    public TbRichTextTiebaPlusInfo j;
    public g k;

    /* loaded from: classes5.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f30957h;
        public final /* synthetic */ TbRichTextItem i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tbRichTextItem;
            this.f30957h = str2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(R.id.obfuscated_res_0x7f091eaf, Boolean.TRUE);
                this.i.b0(this.f30957h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f30958h;
        public final /* synthetic */ TbRichTextItem i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tbRichTextItem;
            this.f30958h = str2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(R.id.obfuscated_res_0x7f091eaf, Boolean.TRUE);
                this.i.b0(this.f30958h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f30959h;
        public final /* synthetic */ TbRichTextItem i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tbRichTextItem;
            this.f30959h = str2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.i.f30950b == null) {
                return;
            }
            TbRichTextItem.Y(this.i.f30950b.z(), this.f30959h, this.i.f30950b.getItemForumName());
        }
    }

    public TbRichTextItem() {
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
        this.f30950b = null;
        this.f30951c = null;
        this.f30952d = null;
        this.f30953e = null;
        this.f30954f = null;
        this.f30955g = null;
        this.f30956h = null;
    }

    public static void Y(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str3, str, 8, 8);
        }
    }

    public final int B(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, num)) == null) ? e.f(num) : invokeL.intValue;
    }

    public final CharSequence C(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.a0(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
            return tbRichTextItem.P(arrayList, null);
        }
        return (CharSequence) invokeL.objValue;
    }

    public final SpannableString D() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.a;
            if (i != 16 || (tbRichTextCommInfo = this.f30950b) == null) {
                return null;
            }
            return Q(i, tbRichTextCommInfo.getText(), this.f30950b.getLink(), 0, null);
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextCommInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.a;
            if (i == 8 || i == 0) {
                return null;
            }
            return this.f30950b;
        }
        return (TbRichTextCommInfo) invokeV.objValue;
    }

    public TbRichTextEmotionInfo F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == 17) {
                return this.f30953e;
            }
            return null;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public final SpannableString G(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        int b2;
        String str;
        a.C0786a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            if (this.a != 4 || (tbRichTextCommInfo = this.f30950b) == null || tbRichTextCommInfo.getText() == null || this.f30950b.getLink() == null || (b2 = TbFaceManager.e().b((text = this.f30950b.getText()))) == 0) {
                return null;
            }
            String f2 = TbFaceManager.e().f(text);
            if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
                str = PreferencesUtil.LEFT_MOUNT + f2 + PreferencesUtil.RIGHT_MOUNT;
            } else {
                str = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
            }
            SpannableString spannableString = new SpannableString(str + " ");
            d dVar = new d(TbadkCoreApplication.getInst().getContext(), b2);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            if (TbFaceManager.e().c(text) != null) {
                int a2 = (int) (c2.a() * 0.5d);
                dVar.setBounds(new Rect(0, 0, a2, a2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new c.a.o0.e1.b(dVar, 1), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextImageInfo H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == 8) {
                return this.f30951c;
            }
            return null;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public g I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == 37) {
                return this.k;
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public TbRichTextLinkButtonInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == 1024) {
                return this.f30955g;
            }
            return null;
        }
        return (TbRichTextLinkButtonInfo) invokeV.objValue;
    }

    public final SpannableString K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a != 1024 || this.f30955g == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString("a");
            Drawable a2 = h.a(this.f30955g.btn_type);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            c.a.o0.e1.d dVar = new c.a.o0.e1.d(a2);
            dVar.d(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070224));
            spannableString.setSpan(dVar, 0, 1, 33);
            spannableString.setSpan(new f(1024, this.f30955g.link), spannableString.length() - 1, 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a == 1280) {
                return this.f30956h;
            }
            return null;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public final SpannableString M(String str) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int i = this.a;
            if ((i == 2 || i == 18 || i == 39 || i == 1282) && (tbRichTextCommInfo = this.f30950b) != null) {
                if (tbRichTextCommInfo.y() == 1) {
                    return Q(this.a, this.f30950b.getText(), this.f30950b.A(), 0, str);
                }
                return Q(this.a, this.f30950b.getText(), this.f30950b.getLink(), this.f30950b.C(), str);
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextMemeInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == 20) {
                return this.i;
            }
            return null;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public final SpannableString O() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a != 256 || (tbRichTextCommInfo = this.f30950b) == null || (text = tbRichTextCommInfo.getText()) == null) {
                return null;
            }
            if (!text.endsWith(" ")) {
                text = text + " ";
            }
            SpannableString spannableString = new SpannableString(text);
            f fVar = new f(this.a, text);
            fVar.i(this.f30950b.getLink());
            spannableString.setSpan(fVar, 0, text.length() - 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public CharSequence P(ArrayList<d> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, arrayList, str)) == null) {
            int i = this.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 39) {
                                    if (i != 128) {
                                        if (i != 256) {
                                            if (i != 1024) {
                                                if (i != 1282) {
                                                    return null;
                                                }
                                                return M(str);
                                            }
                                            return K();
                                        }
                                        return O();
                                    }
                                    return V(arrayList);
                                }
                                return M(str);
                            }
                            return W(arrayList);
                        }
                        return D();
                    }
                    return G(arrayList);
                }
                return M(str);
            }
            return R();
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final SpannableString Q(int i, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3})) == null) {
            if (str != null) {
                boolean z = i == 2 && e.x(str, str2);
                boolean z2 = i == 39;
                if (!str.endsWith(" ")) {
                    str = str + " ";
                }
                if (z) {
                    spannableString = new SpannableString("m" + str);
                } else if (z2) {
                    spannableString = new SpannableString(str + "m");
                } else {
                    spannableString = new SpannableString(str);
                }
                int i3 = this.a;
                if (i3 == 18) {
                    fVar = new a(this, i, str2, str2);
                } else if (i3 == 1282) {
                    fVar = new b(this, i, str2, str2);
                } else if (i3 == 39) {
                    fVar = new c(this, i, str2, str3);
                } else {
                    fVar = new f(i, str2);
                }
                fVar.k(i2);
                if (i2 == 1) {
                    fVar.j(R.color.CAM_X0109);
                } else {
                    fVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080962, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString.setSpan(fVar, 1, (str.length() + 1) - 1, 33);
                    return spannableString;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a98, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    eMRichTextAnyIconSpan2.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString.setSpan(eMRichTextAnyIconSpan2, str.length() - 1, str.length() + 1, 33);
                    spannableString.setSpan(fVar, 0, str.length() - 1, 33);
                    if (TextUtils.isEmpty(str3) || TextUtils.equals("0", str3)) {
                        return spannableString;
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                    statisticItem.param("tid", str3);
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                    return spannableString;
                } else {
                    spannableString.setSpan(fVar, 0, str.length() - 1, 33);
                    return spannableString;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a != 1 || this.f30950b == null) {
                return null;
            }
            return new SpannableString(this.f30950b.getText());
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = this.a;
            if (i == 36 || i == 35) {
                return this.j;
            }
            return null;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    @Nullable
    public TiebaPlusInfo T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.j;
            if (tbRichTextTiebaPlusInfo != null) {
                return tbRichTextTiebaPlusInfo.B();
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public j U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.f30954f;
        }
        return (j) invokeV.objValue;
    }

    public final CharSequence V(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 128 && this.f30950b != null) {
                CharSequence C = C(arrayList);
                if (C != null) {
                    spannableStringBuilder.append(C);
                }
                SpannableString Q = Q(this.a, this.f30950b.getLink(), this.f30950b.getLink(), 0, null);
                if (Q != null) {
                    spannableStringBuilder.append((CharSequence) Q);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final CharSequence W(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        SpannableString Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 32 && this.f30950b != null) {
                spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14f6));
                CharSequence C = C(arrayList);
                if (C != null) {
                    spannableStringBuilder.append(C);
                }
                if (this.f30950b.y() == 1) {
                    Q = Q(this.a, this.f30950b.getText(), this.f30950b.A(), 0, null);
                } else {
                    Q = Q(this.a, this.f30950b.getText(), this.f30950b.getText(), 0, null);
                }
                if (Q != null) {
                    spannableStringBuilder.append((CharSequence) Q);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public TbRichTextVoiceInfo X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = this.a;
            if (i == 512 || i == 768) {
                return this.f30952d;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public void Z(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pbContent) == null) {
            try {
                int B = B(pbContent.type);
                this.a = B;
                if (B == 8) {
                    this.f30951c = new TbRichTextImageInfo(pbContent);
                } else if (B == 20) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                    this.i = tbRichTextMemeInfo;
                    tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
                } else if (B == 512) {
                    this.f30952d = new TbRichTextVoiceInfo(pbContent);
                } else if (B == 1024) {
                    this.f30955g = new TbRichTextLinkButtonInfo(pbContent);
                } else if (B == 1280) {
                    this.f30956h = new TbRichTextLinkImageInfo(pbContent);
                } else if (B == 16) {
                    this.f30950b = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                } else if (B != 17) {
                    switch (B) {
                        case 35:
                        case 36:
                            this.j = new TbRichTextTiebaPlusInfo(B, pbContent.tiebaplus_info);
                            break;
                        case 37:
                            this.k = new g(pbContent.item);
                            break;
                        default:
                            if (B == 32) {
                                j jVar = new j();
                                this.f30954f = jVar;
                                jVar.g(pbContent);
                                if (this.f30954f.f()) {
                                    break;
                                }
                            }
                            TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                            this.f30950b = tbRichTextCommInfo;
                            if (this.a == 4) {
                                if (TbFaceManager.e().b(this.f30950b.getText()) <= 0) {
                                    this.a = 1;
                                    this.f30950b.setText(StringUtils.isNull(pbContent.f45722c) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0517) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + pbContent.f45722c + PreferencesUtil.RIGHT_MOUNT);
                                    break;
                                } else {
                                    this.f30950b.setLink(PreferencesUtil.LEFT_MOUNT + pbContent.f45722c + PreferencesUtil.RIGHT_MOUNT);
                                    break;
                                }
                            } else if (this.a == 256) {
                                tbRichTextCommInfo.setLink(pbContent.phonetype);
                                break;
                            }
                            break;
                    }
                } else {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f30953e = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.f45722c);
                    this.f30953e.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.f30953e.mGifInfo.mStaticUrl = pbContent._static;
                    this.f30953e.mType = this.a;
                    this.f30953e.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.f30953e.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.f30953e.mGifInfo.mPackageName = pbContent.packet_name;
                    this.f30953e.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.f30953e.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f30953e.mGifInfo.mGid = split[i].split("_")[0];
                }
                if (this.a == 1 || this.f30950b == null) {
                    return;
                }
                this.f30950b.D();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a0(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), tbRichTextCommInfo, tbRichTextImageInfo, tbRichTextVoiceInfo, tbRichTextEmotionInfo, tbRichTextLinkButtonInfo, tbRichTextLinkImageInfo}) == null) {
            this.a = i;
            this.f30950b = tbRichTextCommInfo;
            this.f30951c = tbRichTextImageInfo;
            this.f30952d = tbRichTextVoiceInfo;
            this.f30953e = tbRichTextEmotionInfo;
            this.f30955g = tbRichTextLinkButtonInfo;
            this.f30956h = tbRichTextLinkImageInfo;
        }
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        p pVar = new p();
        pVar.a = str;
        pVar.f11477b = 0;
        pVar.f11478c = "1";
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, pVar));
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.a != 32 || (tbRichTextCommInfo = this.f30950b) == null) {
                return null;
            }
            if (tbRichTextCommInfo.y() == 1) {
                return this.f30950b.A();
            }
            return this.f30950b.getText();
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jSONObject) == null) {
            try {
                int B = B(Integer.valueOf(jSONObject.optInt("type", 0)));
                this.a = B;
                if (B == 8) {
                    this.f30951c = new TbRichTextImageInfo(jSONObject);
                } else if (B == 512) {
                    this.f30952d = new TbRichTextVoiceInfo(jSONObject);
                } else if (B == 16) {
                    this.f30950b = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
                } else if (B == 17) {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f30953e = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                    this.f30953e.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                    this.f30953e.mGifInfo.mStaticUrl = jSONObject.optString("static");
                    this.f30953e.mType = this.a;
                    this.f30953e.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                    this.f30953e.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                    this.f30953e.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                    this.f30953e.mGifInfo.mIcon = jSONObject.optString("icon");
                    String[] split = this.f30953e.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str : split) {
                        i++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f30953e.mGifInfo.mGid = split[i].split("_")[0];
                } else {
                    if (B != 36 && B != 35) {
                        TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                        this.f30950b = tbRichTextCommInfo;
                        if (this.a == 4) {
                            int b2 = TbFaceManager.e().b(this.f30950b.getText());
                            String optString = jSONObject.optString("c");
                            if (b2 <= 0) {
                                this.a = 1;
                                this.f30950b.setText(StringUtils.isNull(optString) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0517) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                            } else {
                                this.f30950b.setLink(PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (this.a == 256) {
                            tbRichTextCommInfo.setLink(jSONObject.optString("phonetype"));
                        }
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("tiebaplus_info");
                    if (optJSONObject != null) {
                        this.j = new TbRichTextTiebaPlusInfo(this.a, optJSONObject);
                    }
                }
                if (this.a == 1 || this.f30950b == null) {
                    return;
                }
                this.f30950b.D();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.a = i;
        }
    }
}
