package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.c0.a;
import b.a.q0.f1.n.d;
import b.a.q0.f1.n.e;
import b.a.q0.f1.n.f;
import b.a.q0.f1.n.g;
import b.a.q0.f1.n.h;
import b.a.q0.f1.n.j;
import b.a.q0.u.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
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
/* loaded from: classes8.dex */
public class TbRichTextItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46393e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextCommInfo f46394f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f46395g;

    /* renamed from: h  reason: collision with root package name */
    public TbRichTextVoiceInfo f46396h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextEmotionInfo f46397i;
    public j j;
    public TbRichTextLinkButtonInfo k;
    public TbRichTextLinkImageInfo l;
    public TbRichTextMemeInfo m;
    public TbRichTextTiebaPlusInfo n;
    public g o;

    /* loaded from: classes8.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ TbRichTextItem m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbRichTextItem tbRichTextItem, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = tbRichTextItem;
            this.l = str2;
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.m.Z(this.l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ TbRichTextItem m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbRichTextItem tbRichTextItem, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = tbRichTextItem;
            this.l = str2;
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.m.Z(this.l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ TbRichTextItem m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbRichTextItem tbRichTextItem, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = tbRichTextItem;
            this.l = str2;
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.m.f46394f == null) {
                return;
            }
            TbRichTextItem.W(this.m.f46394f.x(), this.l, this.m.f46394f.getItemForumName());
        }
    }

    public TbRichTextItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46393e = 0;
        this.f46394f = null;
        this.f46395g = null;
        this.f46396h = null;
        this.f46397i = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public static void W(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str3, str, 8, 8);
        }
    }

    public final CharSequence A(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.Y(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
            return tbRichTextItem.N(arrayList, null);
        }
        return (CharSequence) invokeL.objValue;
    }

    public final SpannableString B() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f46393e;
            if (i2 != 16 || (tbRichTextCommInfo = this.f46394f) == null) {
                return null;
            }
            return O(i2, tbRichTextCommInfo.getText(), this.f46394f.getLink(), 0, null);
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextCommInfo C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f46393e;
            if (i2 == 8 || i2 == 0) {
                return null;
            }
            return this.f46394f;
        }
        return (TbRichTextCommInfo) invokeV.objValue;
    }

    public TbRichTextEmotionInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f46393e == 17) {
                return this.f46397i;
            }
            return null;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public final SpannableString E(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        int b2;
        String str;
        a.C0639a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            if (this.f46393e != 4 || (tbRichTextCommInfo = this.f46394f) == null || tbRichTextCommInfo.getText() == null || this.f46394f.getLink() == null || (b2 = TbFaceManager.e().b((text = this.f46394f.getText()))) == 0) {
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
            spannableString.setSpan(new b.a.q0.f1.b(dVar, 1), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextImageInfo F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f46393e == 8) {
                return this.f46395g;
            }
            return null;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public g G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f46393e == 37) {
                return this.o;
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public TbRichTextLinkButtonInfo H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f46393e == 1024) {
                return this.k;
            }
            return null;
        }
        return (TbRichTextLinkButtonInfo) invokeV.objValue;
    }

    public final SpannableString I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f46393e != 1024 || this.k == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString("a");
            Drawable a2 = h.a(this.k.btn_type);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            b.a.q0.f1.d dVar = new b.a.q0.f1.d(a2);
            dVar.d(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
            spannableString.setSpan(dVar, 0, 1, 33);
            spannableString.setSpan(new f(1024, this.k.link), spannableString.length() - 1, 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f46393e == 1280) {
                return this.l;
            }
            return null;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public final SpannableString K(String str) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            int i2 = this.f46393e;
            if ((i2 == 2 || i2 == 18 || i2 == 39 || i2 == 1282) && (tbRichTextCommInfo = this.f46394f) != null) {
                if (tbRichTextCommInfo.w() == 1) {
                    return O(this.f46393e, this.f46394f.getText(), this.f46394f.y(), 0, str);
                }
                return O(this.f46393e, this.f46394f.getText(), this.f46394f.getLink(), this.f46394f.A(), str);
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextMemeInfo L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f46393e == 20) {
                return this.m;
            }
            return null;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public final SpannableString M() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f46393e != 256 || (tbRichTextCommInfo = this.f46394f) == null || (text = tbRichTextCommInfo.getText()) == null) {
                return null;
            }
            if (!text.endsWith(" ")) {
                text = text + " ";
            }
            SpannableString spannableString = new SpannableString(text);
            f fVar = new f(this.f46393e, text);
            fVar.i(this.f46394f.getLink());
            spannableString.setSpan(fVar, 0, text.length() - 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public CharSequence N(ArrayList<d> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, arrayList, str)) == null) {
            int i2 = this.f46393e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 16) {
                            if (i2 != 32) {
                                if (i2 != 39) {
                                    if (i2 != 128) {
                                        if (i2 != 256) {
                                            if (i2 != 1024) {
                                                if (i2 != 1282) {
                                                    return null;
                                                }
                                                return K(str);
                                            }
                                            return I();
                                        }
                                        return M();
                                    }
                                    return T(arrayList);
                                }
                                return K(str);
                            }
                            return U(arrayList);
                        }
                        return B();
                    }
                    return E(arrayList);
                }
                return K(str);
            }
            return P();
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final SpannableString O(int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            if (str != null) {
                boolean z = i2 == 2 && e.x(str, str2);
                boolean z2 = i2 == 39;
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
                int i4 = this.f46393e;
                if (i4 == 18) {
                    fVar = new a(this, i2, str2, str2);
                } else if (i4 == 1282) {
                    fVar = new b(this, i2, str2, str2);
                } else if (i4 == 39) {
                    fVar = new c(this, i2, str2, str3);
                } else {
                    fVar = new f(i2, str2);
                }
                fVar.k(i3);
                if (i3 == 1) {
                    fVar.j(R.color.CAM_X0109);
                } else {
                    fVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString.setSpan(fVar, 1, (str.length() + 1) - 1, 33);
                    return spannableString;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
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

    public final SpannableString P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f46393e != 1 || this.f46394f == null) {
                return null;
            }
            return new SpannableString(this.f46394f.getText());
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i2 = this.f46393e;
            if (i2 == 36 || i2 == 35) {
                return this.n;
            }
            return null;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    @Nullable
    public TiebaPlusInfo R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo != null) {
                return tbRichTextTiebaPlusInfo.z();
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public j S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f46393e != 32) {
                return null;
            }
            return this.j;
        }
        return (j) invokeV.objValue;
    }

    public final CharSequence T(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f46393e == 128 && this.f46394f != null) {
                CharSequence A = A(arrayList);
                if (A != null) {
                    spannableStringBuilder.append(A);
                }
                SpannableString O = O(this.f46393e, this.f46394f.getLink(), this.f46394f.getLink(), 0, null);
                if (O != null) {
                    spannableStringBuilder.append((CharSequence) O);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final CharSequence U(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        SpannableString O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f46393e == 32 && this.f46394f != null) {
                spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
                CharSequence A = A(arrayList);
                if (A != null) {
                    spannableStringBuilder.append(A);
                }
                if (this.f46394f.w() == 1) {
                    O = O(this.f46393e, this.f46394f.getText(), this.f46394f.y(), 0, null);
                } else {
                    O = O(this.f46393e, this.f46394f.getText(), this.f46394f.getText(), 0, null);
                }
                if (O != null) {
                    spannableStringBuilder.append((CharSequence) O);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public TbRichTextVoiceInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = this.f46393e;
            if (i2 == 512 || i2 == 768) {
                return this.f46396h;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public void X(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, pbContent) == null) {
            try {
                int z = z(pbContent.type);
                this.f46393e = z;
                if (z == 8) {
                    this.f46395g = new TbRichTextImageInfo(pbContent);
                } else if (z == 20) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                    this.m = tbRichTextMemeInfo;
                    tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
                } else if (z == 512) {
                    this.f46396h = new TbRichTextVoiceInfo(pbContent);
                } else if (z == 1024) {
                    this.k = new TbRichTextLinkButtonInfo(pbContent);
                } else if (z == 1280) {
                    this.l = new TbRichTextLinkImageInfo(pbContent);
                } else if (z == 16) {
                    this.f46394f = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                } else if (z != 17) {
                    switch (z) {
                        case 35:
                        case 36:
                            this.n = new TbRichTextTiebaPlusInfo(z, pbContent.tiebaplus_info);
                            break;
                        case 37:
                            this.o = new g(pbContent.item);
                            break;
                        default:
                            if (z == 32) {
                                j jVar = new j();
                                this.j = jVar;
                                jVar.k(pbContent);
                                if (this.j.j()) {
                                    break;
                                }
                            }
                            TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                            this.f46394f = tbRichTextCommInfo;
                            if (this.f46393e == 4) {
                                if (TbFaceManager.e().b(this.f46394f.getText()) <= 0) {
                                    this.f46393e = 1;
                                    this.f46394f.setText(StringUtils.isNull(pbContent.f73001c) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + pbContent.f73001c + PreferencesUtil.RIGHT_MOUNT);
                                    break;
                                } else {
                                    this.f46394f.setLink(PreferencesUtil.LEFT_MOUNT + pbContent.f73001c + PreferencesUtil.RIGHT_MOUNT);
                                    break;
                                }
                            } else if (this.f46393e == 256) {
                                tbRichTextCommInfo.setLink(pbContent.phonetype);
                                break;
                            }
                            break;
                    }
                } else {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f46397i = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.f73001c);
                    this.f46397i.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.f46397i.mGifInfo.mStaticUrl = pbContent._static;
                    this.f46397i.mType = this.f46393e;
                    this.f46397i.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.f46397i.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.f46397i.mGifInfo.mPackageName = pbContent.packet_name;
                    this.f46397i.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.f46397i.mGifInfo.mDynamicUrl.split("/");
                    int i2 = 0;
                    for (String str : split) {
                        i2++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f46397i.mGifInfo.mGid = split[i2].split("_")[0];
                }
                if (this.f46393e == 1 || this.f46394f == null) {
                    return;
                }
                this.f46394f.B();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void Y(int i2, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), tbRichTextCommInfo, tbRichTextImageInfo, tbRichTextVoiceInfo, tbRichTextEmotionInfo, tbRichTextLinkButtonInfo, tbRichTextLinkImageInfo}) == null) {
            this.f46393e = i2;
            this.f46394f = tbRichTextCommInfo;
            this.f46395g = tbRichTextImageInfo;
            this.f46396h = tbRichTextVoiceInfo;
            this.f46397i = tbRichTextEmotionInfo;
            this.k = tbRichTextLinkButtonInfo;
            this.l = tbRichTextLinkImageInfo;
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        n nVar = new n();
        nVar.f14159a = str;
        nVar.f14160b = 0;
        nVar.f14161c = "1";
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, nVar));
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f46393e : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f46393e != 32 || (tbRichTextCommInfo = this.f46394f) == null) {
                return null;
            }
            if (tbRichTextCommInfo.w() == 1) {
                return this.f46394f.y();
            }
            return this.f46394f.getText();
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jSONObject) == null) {
            try {
                int z = z(Integer.valueOf(jSONObject.optInt("type", 0)));
                this.f46393e = z;
                if (z == 8) {
                    this.f46395g = new TbRichTextImageInfo(jSONObject);
                } else if (z == 512) {
                    this.f46396h = new TbRichTextVoiceInfo(jSONObject);
                } else if (z == 16) {
                    this.f46394f = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
                } else if (z == 17) {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f46397i = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                    this.f46397i.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                    this.f46397i.mGifInfo.mStaticUrl = jSONObject.optString("static");
                    this.f46397i.mType = this.f46393e;
                    this.f46397i.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                    this.f46397i.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                    this.f46397i.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                    this.f46397i.mGifInfo.mIcon = jSONObject.optString("icon");
                    String[] split = this.f46397i.mGifInfo.mDynamicUrl.split("/");
                    int i2 = 0;
                    for (String str : split) {
                        i2++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f46397i.mGifInfo.mGid = split[i2].split("_")[0];
                } else {
                    if (z != 36 && z != 35) {
                        TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                        this.f46394f = tbRichTextCommInfo;
                        if (this.f46393e == 4) {
                            int b2 = TbFaceManager.e().b(this.f46394f.getText());
                            String optString = jSONObject.optString("c");
                            if (b2 <= 0) {
                                this.f46393e = 1;
                                this.f46394f.setText(StringUtils.isNull(optString) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                            } else {
                                this.f46394f.setLink(PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (this.f46393e == 256) {
                            tbRichTextCommInfo.setLink(jSONObject.optString("phonetype"));
                        }
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("tiebaplus_info");
                    if (optJSONObject != null) {
                        this.n = new TbRichTextTiebaPlusInfo(this.f46393e, optJSONObject);
                    }
                }
                if (this.f46393e == 1 || this.f46394f == null) {
                    return;
                }
                this.f46394f.B();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final int z(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, num)) == null) ? e.f(num) : invokeL.intValue;
    }
}
