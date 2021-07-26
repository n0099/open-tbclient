package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
import d.a.p0.b0.a;
import d.a.p0.d1.m.d;
import d.a.p0.d1.m.e;
import d.a.p0.d1.m.f;
import d.a.p0.d1.m.g;
import d.a.p0.d1.m.i;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13560e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextCommInfo f13561f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f13562g;

    /* renamed from: h  reason: collision with root package name */
    public TbRichTextVoiceInfo f13563h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextEmotionInfo f13564i;
    public i j;
    public TbRichTextLinkButtonInfo k;
    public TbRichTextLinkImageInfo l;
    public TbRichTextMemeInfo m;

    /* loaded from: classes3.dex */
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

        @Override // d.a.p0.d1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.m.V(this.l);
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // d.a.p0.d1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.m.f13561f == null) {
                return;
            }
            TbRichTextItem.S(this.m.f13561f.x(), this.l, this.m.f13561f.getItemForumName());
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
        this.f13560e = 0;
        this.f13561f = null;
        this.f13562g = null;
        this.f13563h = null;
        this.f13564i = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public static void S(String str, String str2, String str3) {
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
            tbRichTextItem.U(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
            return tbRichTextItem.L(arrayList, null);
        }
        return (CharSequence) invokeL.objValue;
    }

    public final SpannableString B() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f13560e;
            if (i2 != 16 || (tbRichTextCommInfo = this.f13561f) == null) {
                return null;
            }
            return M(i2, tbRichTextCommInfo.getText(), this.f13561f.getLink(), 0, null);
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextEmotionInfo C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f13560e == 17) {
                return this.f13564i;
            }
            return null;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public final SpannableString D(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        int b2;
        String str;
        a.C1177a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            if (this.f13560e != 4 || (tbRichTextCommInfo = this.f13561f) == null || tbRichTextCommInfo.getText() == null || this.f13561f.getLink() == null || (b2 = TbFaceManager.e().b((text = this.f13561f.getText()))) == 0) {
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
            spannableString.setSpan(new d.a.p0.d1.b(dVar, 1), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextImageInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f13560e == 8) {
                return this.f13562g;
            }
            return null;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public TbRichTextLinkButtonInfo F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f13560e == 1024) {
                return this.k;
            }
            return null;
        }
        return (TbRichTextLinkButtonInfo) invokeV.objValue;
    }

    public final SpannableString G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f13560e != 1024 || this.k == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString("a");
            Drawable a2 = g.a(this.k.btn_type);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            d.a.p0.d1.d dVar = new d.a.p0.d1.d(a2);
            dVar.d(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
            spannableString.setSpan(dVar, 0, 1, 33);
            spannableString.setSpan(new f(1024, this.k.link), spannableString.length() - 1, 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f13560e == 1280) {
                return this.l;
            }
            return null;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public final SpannableString I(String str) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int i2 = this.f13560e;
            if ((i2 == 2 || i2 == 18 || i2 == 39) && (tbRichTextCommInfo = this.f13561f) != null) {
                if (tbRichTextCommInfo.w() == 1) {
                    return M(this.f13560e, this.f13561f.getText(), this.f13561f.y(), 0, str);
                }
                return M(this.f13560e, this.f13561f.getText(), this.f13561f.getLink(), this.f13561f.z(), str);
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public TbRichTextMemeInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f13560e == 20) {
                return this.m;
            }
            return null;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public final SpannableString K() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f13560e != 256 || (tbRichTextCommInfo = this.f13561f) == null || (text = tbRichTextCommInfo.getText()) == null) {
                return null;
            }
            if (!text.endsWith(" ")) {
                text = text + " ";
            }
            SpannableString spannableString = new SpannableString(text);
            f fVar = new f(this.f13560e, text);
            fVar.i(this.f13561f.getLink());
            spannableString.setSpan(fVar, 0, text.length() - 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public CharSequence L(ArrayList<d> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, arrayList, str)) == null) {
            int i2 = this.f13560e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 16) {
                            if (i2 != 18) {
                                if (i2 != 32) {
                                    if (i2 != 39) {
                                        if (i2 != 128) {
                                            if (i2 != 256) {
                                                if (i2 != 1024) {
                                                    return null;
                                                }
                                                return G();
                                            }
                                            return K();
                                        }
                                        return P(arrayList);
                                    }
                                    return I(str);
                                }
                                return Q(arrayList);
                            }
                            return I(str);
                        }
                        return B();
                    }
                    return D(arrayList);
                }
                return I(str);
            }
            return N();
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final SpannableString M(int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            if (str != null) {
                boolean z = i2 == 2 && e.s(str, str2);
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
                int i4 = this.f13560e;
                if (i4 == 18) {
                    fVar = new a(this, i2, str2, str2);
                } else if (i4 == 39) {
                    fVar = new b(this, i2, str2, str3);
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
                    eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString.setSpan(fVar, 1, (str.length() + 1) - 1, 33);
                    return spannableString;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    eMRichTextAnyIconSpan2.e(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
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

    public final SpannableString N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f13560e != 1 || this.f13561f == null) {
                return null;
            }
            return new SpannableString(this.f13561f.getText());
        }
        return (SpannableString) invokeV.objValue;
    }

    public i O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f13560e != 32) {
                return null;
            }
            return this.j;
        }
        return (i) invokeV.objValue;
    }

    public final CharSequence P(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f13560e == 128 && this.f13561f != null) {
                CharSequence A = A(arrayList);
                if (A != null) {
                    spannableStringBuilder.append(A);
                }
                SpannableString M = M(this.f13560e, this.f13561f.getLink(), this.f13561f.getLink(), 0, null);
                if (M != null) {
                    spannableStringBuilder.append((CharSequence) M);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final CharSequence Q(ArrayList<d> arrayList) {
        InterceptResult invokeL;
        SpannableString M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f13560e == 32 && this.f13561f != null) {
                spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
                CharSequence A = A(arrayList);
                if (A != null) {
                    spannableStringBuilder.append(A);
                }
                if (this.f13561f.w() == 1) {
                    M = M(this.f13560e, this.f13561f.getText(), this.f13561f.y(), 0, null);
                } else {
                    M = M(this.f13560e, this.f13561f.getText(), this.f13561f.getText(), 0, null);
                }
                if (M != null) {
                    spannableStringBuilder.append((CharSequence) M);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public TbRichTextVoiceInfo R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = this.f13560e;
            if (i2 == 512 || i2 == 768) {
                return this.f13563h;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public void T(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pbContent) == null) {
            try {
                int z = z(pbContent.type.intValue());
                this.f13560e = z;
                if (z == 8) {
                    this.f13562g = new TbRichTextImageInfo(pbContent);
                } else if (z == 20) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                    this.m = tbRichTextMemeInfo;
                    tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
                } else if (z == 512) {
                    this.f13563h = new TbRichTextVoiceInfo(pbContent);
                } else if (z == 1024) {
                    this.k = new TbRichTextLinkButtonInfo(pbContent);
                } else if (z == 1280) {
                    this.l = new TbRichTextLinkImageInfo(pbContent);
                } else if (z == 16) {
                    this.f13561f = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                } else if (z != 17) {
                    if (z == 32) {
                        i iVar = new i();
                        this.j = iVar;
                        iVar.j(pbContent);
                        if (this.j.i()) {
                        }
                    }
                    TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                    this.f13561f = tbRichTextCommInfo;
                    if (this.f13560e == 4) {
                        if (TbFaceManager.e().b(this.f13561f.getText()) <= 0) {
                            this.f13560e = 1;
                            this.f13561f.setText(StringUtils.isNull(pbContent.f74064c) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + pbContent.f74064c + PreferencesUtil.RIGHT_MOUNT);
                        } else {
                            this.f13561f.setLink(PreferencesUtil.LEFT_MOUNT + pbContent.f74064c + PreferencesUtil.RIGHT_MOUNT);
                        }
                    } else if (this.f13560e == 256) {
                        tbRichTextCommInfo.setLink(pbContent.phonetype);
                    }
                } else {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f13564i = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.f74064c);
                    this.f13564i.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.f13564i.mGifInfo.mStaticUrl = pbContent._static;
                    this.f13564i.mType = this.f13560e;
                    this.f13564i.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.f13564i.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.f13564i.mGifInfo.mPackageName = pbContent.packet_name;
                    this.f13564i.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.f13564i.mGifInfo.mDynamicUrl.split("/");
                    int i2 = 0;
                    for (String str : split) {
                        i2++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f13564i.mGifInfo.mGid = split[i2].split("_")[0];
                }
                if (this.f13560e == 1 || this.f13561f == null) {
                    return;
                }
                this.f13561f.A();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void U(int i2, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), tbRichTextCommInfo, tbRichTextImageInfo, tbRichTextVoiceInfo, tbRichTextEmotionInfo, tbRichTextLinkButtonInfo, tbRichTextLinkImageInfo}) == null) {
            this.f13560e = i2;
            this.f13561f = tbRichTextCommInfo;
            this.f13562g = tbRichTextImageInfo;
            this.f13563h = tbRichTextVoiceInfo;
            this.f13564i = tbRichTextEmotionInfo;
            this.k = tbRichTextLinkButtonInfo;
            this.l = tbRichTextLinkImageInfo;
        }
    }

    public final void V(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.p0.u.l lVar = new d.a.p0.u.l();
        lVar.f54114a = str;
        lVar.f54115b = 0;
        lVar.f54116c = "1";
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f13560e : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f13560e != 32 || (tbRichTextCommInfo = this.f13561f) == null) {
                return null;
            }
            if (tbRichTextCommInfo.w() == 1) {
                return this.f13561f.y();
            }
            return this.f13561f.getText();
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jSONObject) == null) {
            try {
                int z = z(jSONObject.optInt("type", 0));
                this.f13560e = z;
                if (z == 8) {
                    this.f13562g = new TbRichTextImageInfo(jSONObject);
                } else if (z == 512) {
                    this.f13563h = new TbRichTextVoiceInfo(jSONObject);
                } else if (z == 16) {
                    this.f13561f = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
                } else if (z == 17) {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.f13564i = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                    this.f13564i.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                    this.f13564i.mGifInfo.mStaticUrl = jSONObject.optString("static");
                    this.f13564i.mType = this.f13560e;
                    this.f13564i.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                    this.f13564i.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                    this.f13564i.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                    this.f13564i.mGifInfo.mIcon = jSONObject.optString("icon");
                    String[] split = this.f13564i.mGifInfo.mDynamicUrl.split("/");
                    int i2 = 0;
                    for (String str : split) {
                        i2++;
                        if (str.equals("faceshop")) {
                            break;
                        }
                    }
                    this.f13564i.mGifInfo.mGid = split[i2].split("_")[0];
                } else {
                    TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                    this.f13561f = tbRichTextCommInfo;
                    if (this.f13560e == 4) {
                        int b2 = TbFaceManager.e().b(this.f13561f.getText());
                        String optString = jSONObject.optString("c");
                        if (b2 <= 0) {
                            this.f13560e = 1;
                            this.f13561f.setText(StringUtils.isNull(optString) ? PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT : PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                        } else {
                            this.f13561f.setLink(PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                        }
                    } else if (this.f13560e == 256) {
                        tbRichTextCommInfo.setLink(jSONObject.optString("phonetype"));
                    }
                }
                if (this.f13560e == 1 || this.f13561f == null) {
                    return;
                }
                this.f13561f.A();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final int z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? e.g(i2) : invokeI.intValue;
    }
}
