package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gh5;
import com.baidu.tieba.lt5;
import com.baidu.tieba.mw5;
import com.baidu.tieba.nw5;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pw5;
import com.baidu.tieba.qw5;
import com.baidu.tieba.sw5;
import com.baidu.tieba.vca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class TbRichTextItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbRichTextCommInfo b;
    public TbRichTextImageInfo c;
    public TbRichTextVoiceInfo d;
    public TbRichTextEmotionInfo e;
    public sw5 f;
    public TbRichTextLinkButtonInfo g;
    public TbRichTextLinkImageInfo h;
    public TbRichTextMemeInfo i;
    public TbRichTextTiebaPlusInfo j;
    public pw5 k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ TbRichTextItem o;

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
            this.o = tbRichTextItem;
            this.n = str2;
        }

        @Override // com.baidu.tieba.ow5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.o.t0(this.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ TbRichTextItem o;

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
            this.o = tbRichTextItem;
            this.n = str2;
        }

        @Override // com.baidu.tieba.ow5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.o.t0(this.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String n;
        public final /* synthetic */ TbRichTextItem o;

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
            this.o = tbRichTextItem;
            this.n = str2;
        }

        @Override // com.baidu.tieba.ow5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.o.b == null) {
                return;
            }
            TbRichTextItem.p0(this.o.b.Q(), this.n, this.o.b.getItemForumName(), this.o.b.getLink(), this.o.b.V());
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public final SpannableString S() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.a;
            if (i == 16 && (tbRichTextCommInfo = this.b) != null) {
                return h0(i, tbRichTextCommInfo.getText(), this.b.getLink(), f0(), 0, null);
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == 32 && (tbRichTextCommInfo = this.b) != null) {
                if (tbRichTextCommInfo.P() == 1) {
                    return this.b.T();
                }
                return this.b.getText();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final int Q(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, num)) == null) {
            return nw5.f(num);
        }
        return invokeL.intValue;
    }

    public final CharSequence R(ArrayList<mw5> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.r0(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
            return tbRichTextItem.e0(arrayList, null);
        }
        return (CharSequence) invokeL.objValue;
    }

    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.l = z;
        }
    }

    public static void p0(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_type", str);
            statisticItem.param("obj_param1", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str3, str, 8, 8, str4);
        }
    }

    public TbRichTextCommInfo T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.a;
            if (i != 8 && i != 0) {
                return this.b;
            }
            return null;
        }
        return (TbRichTextCommInfo) invokeV.objValue;
    }

    public TbRichTextEmotionInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == 17) {
                return this.e;
            }
            return null;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextImageInfo W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == 8) {
                return this.c;
            }
            return null;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public pw5 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == 37) {
                return this.k;
            }
            return null;
        }
        return (pw5) invokeV.objValue;
    }

    public TbRichTextLinkButtonInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == 1024) {
                return this.g;
            }
            return null;
        }
        return (TbRichTextLinkButtonInfo) invokeV.objValue;
    }

    public TbRichTextLinkImageInfo a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a == 1280) {
                return this.h;
            }
            return null;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo c0() {
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

    @Nullable
    public final String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b.U() != null) {
                return this.b.U().target_scheme;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public TbRichTextTiebaPlusInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i = this.a;
            if (i != 36 && i != 35) {
                return null;
            }
            return this.j;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    @Nullable
    public TiebaPlusInfo k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.j;
            if (tbRichTextTiebaPlusInfo != null) {
                return tbRichTextTiebaPlusInfo.P();
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public sw5 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.f;
        }
        return (sw5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.d;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public final SpannableString V(ArrayList<mw5> arrayList) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        String str;
        gh5.a f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            if (this.a == 4 && (tbRichTextCommInfo = this.b) != null && tbRichTextCommInfo.getText() != null && this.b.getLink() != null) {
                String text = this.b.getText();
                if (TbFaceManager.i().o(text)) {
                    String j = TbFaceManager.i().j(text);
                    if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
                        str = PreferencesUtil.LEFT_MOUNT + j + PreferencesUtil.RIGHT_MOUNT;
                    } else {
                        str = SmallTailInfo.EMOTION_PREFIX + j + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    SpannableString spannableString = new SpannableString(str + " ");
                    mw5 c2 = TbFaceManager.i().c(text);
                    if (arrayList != null) {
                        arrayList.add(c2);
                    }
                    if (TbFaceManager.i().f(text) != null) {
                        int a2 = (int) (f.a() * 0.5d);
                        c2.setBounds(new Rect(0, 0, a2, a2));
                    } else {
                        c2.setBounds(new Rect(0, 0, 0, 0));
                    }
                    spannableString.setSpan(new lt5(c2, 1), 0, str.length(), 33);
                    return spannableString;
                }
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final SpannableString Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a == 1024 && this.g != null) {
                SpannableString spannableString = new SpannableString("a");
                Drawable a2 = qw5.a(this.g.btn_type);
                a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(a2);
                vCenterTextSpan.setVerticalOffset(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070224));
                spannableString.setSpan(vCenterTextSpan, 0, 1, 33);
                spannableString.setSpan(new ow5(1024, this.g.link), spannableString.length() - 1, 1, 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final SpannableString b0(String str) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int i = this.a;
            if ((i == 2 || i == 18 || i == 39 || i == 1282) && (tbRichTextCommInfo = this.b) != null) {
                if (tbRichTextCommInfo.P() == 1) {
                    return h0(this.a, this.b.getText(), this.b.T(), f0(), 0, str);
                }
                return g0(this.a, this.b.getText(), this.b.getLink(), f0(), this.b.W(), this.b.V(), str);
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final CharSequence n0(ArrayList<mw5> arrayList) {
        InterceptResult invokeL;
        SpannableString h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 32 && this.b != null) {
                spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
                CharSequence R = R(arrayList);
                if (R != null) {
                    spannableStringBuilder.append(R);
                }
                if (this.b.P() == 1) {
                    h0 = h0(this.a, this.b.getText(), this.b.T(), f0(), 0, null);
                } else {
                    h0 = h0(this.a, this.b.getText(), this.b.getText(), f0(), 0, null);
                }
                if (h0 != null) {
                    spannableStringBuilder.append((CharSequence) h0);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final SpannableString d0() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a != 256 || (tbRichTextCommInfo = this.b) == null || (text = tbRichTextCommInfo.getText()) == null) {
                return null;
            }
            if (!text.endsWith(" ")) {
                text = text + " ";
            }
            SpannableString spannableString = new SpannableString(text);
            ow5 ow5Var = new ow5(this.a, text);
            ow5Var.q(this.b.getLink());
            spannableString.setSpan(ow5Var, 0, text.length() - 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final SpannableString i0() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.a == 1 && (tbRichTextCommInfo = this.b) != null) {
                if (this.l) {
                    String replaceAll = tbRichTextCommInfo.getText().replaceAll("\n", "\n\u0000");
                    SpannableString spannableString = new SpannableString(replaceAll);
                    Matcher matcher = Pattern.compile("\n\u0000").matcher(replaceAll);
                    while (matcher.find()) {
                        spannableString.setSpan(new RelativeSizeSpan(1.5f), matcher.start() + 1, matcher.end(), 33);
                    }
                    return spannableString;
                }
                return new SpannableString(this.b.getText());
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public CharSequence e0(ArrayList<mw5> arrayList, String str) {
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
                                                return b0(str);
                                            }
                                            return Z();
                                        }
                                        return d0();
                                    }
                                    return m0(arrayList);
                                }
                                return b0(str);
                            }
                            return n0(arrayList);
                        }
                        return S();
                    }
                    return V(arrayList);
                }
                return b0(str);
            }
            return i0();
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final SpannableString g0(int i, String str, String str2, @Nullable String str3, int i2, int i3, String str4) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        SpannableString spannableString;
        ow5 ow5Var;
        TbRichTextCommInfo tbRichTextCommInfo;
        TbRichTextCommInfo tbRichTextCommInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4})) == null) {
            String str5 = str;
            if (str5 != null) {
                if (i == 2 && nw5.A(str, str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == 39) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!str5.endsWith(" ")) {
                    str5 = str5 + " ";
                }
                if (z) {
                    spannableString = new SpannableString("m" + str5);
                } else if (z2) {
                    spannableString = new SpannableString(str5 + "m");
                } else {
                    spannableString = new SpannableString(str5);
                }
                int i4 = this.a;
                if (i4 == 18) {
                    ow5Var = new a(this, i, str2, str2);
                } else if (i4 == 1282) {
                    ow5Var = new b(this, i, str2, str2);
                } else if (i4 == 39) {
                    ow5Var = new c(this, i, str2, str4);
                } else {
                    ow5Var = new ow5(i, str2);
                    ow5Var.r(str3);
                }
                ow5Var.n(str5);
                ow5Var.u(i2);
                ow5Var.t(i3);
                ow5Var.l(this.b.O());
                ow5Var.k(this.b.N());
                if (this.a == 2 && (tbRichTextCommInfo2 = this.b) != null && !TextUtils.isEmpty(tbRichTextCommInfo2.R())) {
                    ow5Var.s(vca.d(TbadkCoreApplication.getInst(), this.b.R()));
                } else if (i2 == 1) {
                    ow5Var.s(R.color.CAM_X0109);
                } else {
                    ow5Var.s(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(nw5.o(i3), R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    if (this.a == 2 && (tbRichTextCommInfo = this.b) != null && !TextUtils.isEmpty(tbRichTextCommInfo.S())) {
                        eMRichTextAnyIconSpan.g(this.b.S());
                    }
                    eMRichTextAnyIconSpan.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString.setSpan(ow5Var, 1, (str5.length() + 1) - 1, 33);
                    return spannableString;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    eMRichTextAnyIconSpan2.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString.setSpan(eMRichTextAnyIconSpan2, str5.length() - 1, str5.length() + 1, 33);
                    spannableString.setSpan(ow5Var, 0, str5.length() - 1, 33);
                    if (!TextUtils.isEmpty(str4) && !TextUtils.equals("0", str4)) {
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", str4);
                        statisticItem.param("obj_locate", 4);
                        TbRichTextCommInfo tbRichTextCommInfo3 = this.b;
                        if (tbRichTextCommInfo3 != null) {
                            statisticItem.param("obj_param1", tbRichTextCommInfo3.V());
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.b.Q());
                        }
                        TiebaStatic.log(statisticItem);
                        return spannableString;
                    }
                    return spannableString;
                } else {
                    spannableString.setSpan(ow5Var, 0, str5.length() - 1, 33);
                    return spannableString;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString h0(int i, String str, String str2, @Nullable String str3, int i2, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), str4})) == null) {
            return g0(i, str, str2, str3, i2, 0, str4);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final CharSequence m0(ArrayList<mw5> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 128 && this.b != null) {
                CharSequence R = R(arrayList);
                if (R != null) {
                    spannableStringBuilder.append(R);
                }
                SpannableString h0 = h0(this.a, this.b.getLink(), this.b.getLink(), f0(), 0, null);
                if (h0 != null) {
                    spannableStringBuilder.append((CharSequence) h0);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jSONObject) == null) {
            try {
                int Q = Q(Integer.valueOf(jSONObject.optInt("type", 0)));
                this.a = Q;
                if (Q == 8) {
                    this.c = new TbRichTextImageInfo(jSONObject);
                } else if (Q == 512) {
                    this.d = new TbRichTextVoiceInfo(jSONObject);
                } else if (Q == 16) {
                    this.b = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
                } else if (Q == 17) {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.e = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                    this.e.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                    this.e.mGifInfo.mStaticUrl = jSONObject.optString("static");
                    this.e.mType = this.a;
                    this.e.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                    this.e.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                    this.e.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                    this.e.mGifInfo.mIcon = jSONObject.optString("icon");
                    String[] split = this.e.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            break;
                        }
                    }
                    this.e.mGifInfo.mGid = split[i].split("_")[0];
                } else {
                    if (Q != 36 && Q != 35) {
                        TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                        this.b = tbRichTextCommInfo;
                        if (this.a == 4) {
                            String optString = jSONObject.optString("c");
                            if (!TbFaceManager.i().o(this.b.getText())) {
                                this.a = 1;
                                if (StringUtils.isNull(optString)) {
                                    str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT;
                                } else {
                                    str = PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT;
                                }
                                this.b.setText(str);
                            } else {
                                this.b.setLink(PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
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
                if (this.a != 1 && this.b != null) {
                    this.b.Y();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void q0(PbContent pbContent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, pbContent) == null) {
            try {
                int Q = Q(pbContent.type);
                this.a = Q;
                if (Q != 8) {
                    if (Q != 20) {
                        if (Q != 512) {
                            if (Q != 1024) {
                                if (Q != 1280) {
                                    if (Q != 16) {
                                        if (Q != 17) {
                                            switch (Q) {
                                                case 35:
                                                case 36:
                                                    this.j = new TbRichTextTiebaPlusInfo(Q, pbContent.tiebaplus_info);
                                                    break;
                                                case 37:
                                                    this.k = new pw5(pbContent.item);
                                                    break;
                                                default:
                                                    if (Q == 32) {
                                                        sw5 sw5Var = new sw5();
                                                        this.f = sw5Var;
                                                        sw5Var.g(pbContent);
                                                        if (this.f.f()) {
                                                            break;
                                                        }
                                                    }
                                                    TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                                                    this.b = tbRichTextCommInfo;
                                                    if (this.a == 4) {
                                                        if (!TbFaceManager.i().o(this.b.getText())) {
                                                            this.a = 1;
                                                            if (StringUtils.isNull(pbContent.c)) {
                                                                str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT;
                                                            } else {
                                                                str = PreferencesUtil.LEFT_MOUNT + pbContent.c + PreferencesUtil.RIGHT_MOUNT;
                                                            }
                                                            this.b.setText(str);
                                                            break;
                                                        } else {
                                                            this.b.setLink(PreferencesUtil.LEFT_MOUNT + pbContent.c + PreferencesUtil.RIGHT_MOUNT);
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
                                            this.e = tbRichTextEmotionInfo;
                                            tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                                            this.e.mGifInfo.mDynamicUrl = pbContent.dynamic;
                                            this.e.mGifInfo.mStaticUrl = pbContent._static;
                                            this.e.mType = this.a;
                                            this.e.mGifInfo.mGifWidth = pbContent.width.intValue();
                                            this.e.mGifInfo.mGifHeight = pbContent.height.intValue();
                                            this.e.mGifInfo.mPackageName = pbContent.packet_name;
                                            this.e.mGifInfo.mIcon = pbContent._static;
                                            String[] split = this.e.mGifInfo.mDynamicUrl.split("/");
                                            int i = 0;
                                            for (String str2 : split) {
                                                i++;
                                                if (str2.equals("faceshop")) {
                                                    break;
                                                }
                                            }
                                            this.e.mGifInfo.mGid = split[i].split("_")[0];
                                        }
                                    } else {
                                        TbRichTextCommInfo tbRichTextCommInfo2 = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                                        this.b = tbRichTextCommInfo2;
                                        tbRichTextCommInfo2.X(pbContent);
                                    }
                                } else {
                                    this.h = new TbRichTextLinkImageInfo(pbContent);
                                }
                            } else {
                                this.g = new TbRichTextLinkButtonInfo(pbContent);
                            }
                        } else {
                            this.d = new TbRichTextVoiceInfo(pbContent);
                        }
                    } else {
                        TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                        this.i = tbRichTextMemeInfo;
                        tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
                    }
                } else {
                    this.c = new TbRichTextImageInfo(pbContent);
                }
                if (this.a != 1 && this.b != null) {
                    this.b.Y();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void r0(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), tbRichTextCommInfo, tbRichTextImageInfo, tbRichTextVoiceInfo, tbRichTextEmotionInfo, tbRichTextLinkButtonInfo, tbRichTextLinkImageInfo}) == null) {
            this.a = i;
            this.b = tbRichTextCommInfo;
            this.c = tbRichTextImageInfo;
            this.d = tbRichTextVoiceInfo;
            this.e = tbRichTextEmotionInfo;
            this.g = tbRichTextLinkButtonInfo;
            this.h = tbRichTextLinkImageInfo;
        }
    }

    public final void t0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && !TextUtils.isEmpty(str)) {
            gc5 gc5Var = new gc5();
            gc5Var.a = str;
            gc5Var.b = 0;
            gc5Var.c = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, gc5Var));
        }
    }
}
