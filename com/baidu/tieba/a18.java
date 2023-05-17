package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a18 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562433, "Lcom/baidu/tieba/a18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562433, "Lcom/baidu/tieba/a18;");
                return;
            }
        }
        js5.b();
    }

    @NonNull
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length > 1) {
                int d = (int) pg.d(split[0], 0.0f);
                int d2 = (int) pg.d(split[1], 0.0f);
                if (d > 0 && d2 > 0) {
                    return str;
                }
            }
            return "240.0,240.0";
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context, GifView gifView, ChatMessage chatMessage, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, gifView, chatMessage, Boolean.valueOf(z)}) == null) {
            double d = context.getResources().getDisplayMetrics().density;
            int i2 = 240;
            int i3 = (d > 1.5d ? 1 : (d == 1.5d ? 0 : -1));
            if (i3 > 0) {
                i = 240;
            } else {
                i = 160;
            }
            if (i3 <= 0) {
                i2 = 160;
            }
            gifView.setVisibility(0);
            GifInfo gifInfo = chatMessage.getGifInfo();
            if (chatMessage.getGifInfo() != null) {
                int i4 = gifInfo.mGifWidth;
                if (i4 > 0) {
                    i = i4;
                }
                gifInfo.mGifWidth = i;
                int i5 = gifInfo.mGifHeight;
                if (i5 > 0) {
                    i2 = i5;
                }
                gifInfo.mGifHeight = i2;
                gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.mGifWidth, gifInfo.mGifHeight));
                gifView.l0(gifInfo);
                gifView.setVisibility(0);
                return;
            }
            gifView.setVisibility(8);
        }
    }

    public static void g(Context context, ChatVoiceView chatVoiceView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65543, null, context, chatVoiceView, chatMessage, str) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() > 0) {
            try {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    cacheData = new MsgCacheData();
                    cacheData.setVoice_status(1);
                    chatMessage.setCacheData(cacheData);
                } else if (cacheData.getVoice_status() == 0) {
                    cacheData.setVoice_status(1);
                }
                VoiceMsgData r = s58.r(chatMessage);
                if (r != null && r.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceData.VoiceModel());
                    cacheData.getVoice_model().setVoiceId(r.getVoice_md5());
                    cacheData.getVoice_model().setDuration(Math.round(r.getDuring_time()));
                }
                chatVoiceView.setTag(null);
                chatVoiceView.setData(chatMessage);
                chatVoiceView.setVisibility(0);
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, View view2, ShareFromPBView shareFromPBView, ShareFromFrsView shareFromFrsView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, view2, shareFromPBView, shareFromFrsView, shareFromGameCenter, chatMessage, str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            x58 x58Var = new x58();
            int c = x58Var.c(chatMessage.getContent(), str);
            ShareFromFrsMsgData shareFromFrsMsgData = null;
            ShareFromPBMsgData shareFromPBMsgData = null;
            ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
            if (1 == x58Var.b()) {
                if (x58Var.a() != null) {
                    if (c == 0) {
                        shareFromPBView.setVisibility(0);
                        if (x58Var.a() instanceof ShareFromPBMsgData) {
                            shareFromPBMsgData = (ShareFromPBMsgData) x58Var.a();
                        }
                        shareFromPBView.setData(shareFromPBMsgData);
                    } else if (c == 1) {
                        shareFromGameCenter.setVisibility(0);
                        if (x58Var.a() instanceof ShareFromGameCenterMsgData) {
                            shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) x58Var.a();
                        }
                        if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                        } else if (!TextUtils.isEmpty(str) && str.endsWith("MsgrightView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                        }
                    }
                }
            } else if (4 == x58Var.b()) {
                shareFromFrsView.setVisibility(0);
                if (x58Var.a() instanceof ShareFromFrsMsgData) {
                    shareFromFrsMsgData = (ShareFromFrsMsgData) x58Var.a();
                }
                shareFromFrsView.setData(shareFromFrsMsgData);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:5:0x0007, B:7:0x0010, B:9:0x0019, B:11:0x001d, B:13:0x0026, B:15:0x002e, B:41:0x008a, B:43:0x00ab, B:45:0x00d3, B:44:0x00c1), top: B:58:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1 A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:5:0x0007, B:7:0x0010, B:9:0x0019, B:11:0x001d, B:13:0x0026, B:15:0x002e, B:41:0x008a, B:43:0x00ab, B:45:0x00d3, B:44:0x00c1), top: B:58:0x0007 }] */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(ChatImageWithTailView chatImageWithTailView, @NonNull String str, @NonNull String str2, int i) {
        InterceptResult invokeLLLI;
        int i2;
        int i3;
        cn z;
        int i4;
        cn cnVar;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, chatImageWithTailView, str, str2, i)) == null) {
            try {
                String[] split = str2.split(",");
                if (split.length > 0) {
                    i2 = (int) pg.d(split[0], 0.0f);
                } else {
                    i2 = 0;
                }
                if (split.length > 1) {
                    i3 = (int) pg.d(split[1], 0.0f);
                } else {
                    i3 = 0;
                }
                if (str.startsWith("http")) {
                    chatImageWithTailView.getImage().m0(str, 38);
                } else {
                    try {
                        z = TbImageMemoryCache.u().z(str);
                    } catch (Exception unused) {
                    }
                    if (z == null) {
                        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ki.d().c(str));
                        if (reSizeBitmap != null) {
                            cnVar = new cn(reSizeBitmap, false);
                            if (i2 < 1) {
                                try {
                                    i5 = cnVar.r();
                                    try {
                                        i4 = cnVar.m();
                                    } catch (Exception unused2) {
                                    }
                                } catch (Exception unused3) {
                                }
                            } else {
                                i5 = 0;
                                i4 = 0;
                            }
                            try {
                                TbImageMemoryCache.u().l(str, cnVar);
                            } catch (Exception unused4) {
                            }
                            if (i5 >= 1) {
                                i2 = i5;
                                i3 = i4;
                            }
                            IMImageSize chatImageSize = PicManager.getInstance().getChatImageSize(i2, i3);
                            ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                            layoutParams.height = chatImageSize.height;
                            layoutParams.width = chatImageSize.width;
                            chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                            if (cnVar == null) {
                                chatImageWithTailView.getImage().H();
                                chatImageWithTailView.getImage().b0();
                                cnVar.h(chatImageWithTailView.getImage());
                            } else {
                                chatImageWithTailView.getImage().setDefaultResource(SkinManager.getResourceId(i));
                                chatImageWithTailView.getImage().setTag(str);
                            }
                            chatImageWithTailView.getImage().setAutoChangeStyle(true);
                            chatImageWithTailView.setVisibility(0);
                            return i2 + "," + i3;
                        }
                    } else {
                        if (i2 < 1) {
                            try {
                                int r = z.r();
                                try {
                                    i4 = z.m();
                                } catch (Exception unused5) {
                                    i4 = 0;
                                }
                                cnVar = z;
                                i5 = r;
                            } catch (Exception unused6) {
                            }
                            if (i5 >= 1) {
                            }
                            IMImageSize chatImageSize2 = PicManager.getInstance().getChatImageSize(i2, i3);
                            ViewGroup.LayoutParams layoutParams2 = chatImageWithTailView.getImage().getLayoutParams();
                            layoutParams2.height = chatImageSize2.height;
                            layoutParams2.width = chatImageSize2.width;
                            chatImageWithTailView.getImage().setLayoutParams(layoutParams2);
                            if (cnVar == null) {
                            }
                            chatImageWithTailView.getImage().setAutoChangeStyle(true);
                            chatImageWithTailView.setVisibility(0);
                            return i2 + "," + i3;
                        }
                        cnVar = z;
                        i5 = 0;
                        i4 = 0;
                        if (i5 >= 1) {
                        }
                        IMImageSize chatImageSize22 = PicManager.getInstance().getChatImageSize(i2, i3);
                        ViewGroup.LayoutParams layoutParams22 = chatImageWithTailView.getImage().getLayoutParams();
                        layoutParams22.height = chatImageSize22.height;
                        layoutParams22.width = chatImageSize22.width;
                        chatImageWithTailView.getImage().setLayoutParams(layoutParams22);
                        if (cnVar == null) {
                        }
                        chatImageWithTailView.getImage().setAutoChangeStyle(true);
                        chatImageWithTailView.setVisibility(0);
                        return i2 + "," + i3;
                    }
                }
                cnVar = null;
                i5 = 0;
                i4 = 0;
                if (i5 >= 1) {
                }
                IMImageSize chatImageSize222 = PicManager.getInstance().getChatImageSize(i2, i3);
                ViewGroup.LayoutParams layoutParams222 = chatImageWithTailView.getImage().getLayoutParams();
                layoutParams222.height = chatImageSize222.height;
                layoutParams222.width = chatImageSize222.width;
                chatImageWithTailView.getImage().setLayoutParams(layoutParams222);
                if (cnVar == null) {
                }
                chatImageWithTailView.getImage().setAutoChangeStyle(true);
                chatImageWithTailView.setVisibility(0);
                return i2 + "," + i3;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public static void e(Context context, View view2, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        String optString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, view2, chatImageWithTailView, chatMessage, Long.valueOf(j), str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String l = s58.l(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (l == null) {
                    return;
                }
                cn cnVar = null;
                if (l.startsWith("http")) {
                    chatImageWithTailView.getImage().m0(l, 38);
                } else {
                    try {
                        cn z = TbImageMemoryCache.u().z(l);
                        if (z == null) {
                            Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ki.d().c(l));
                            if (reSizeBitmap != null) {
                                cn cnVar2 = new cn(reSizeBitmap, false);
                                try {
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(cnVar2.r());
                                        chatMessage.setHeight(cnVar2.m());
                                    }
                                    TbImageMemoryCache.u().l(l, cnVar2);
                                } catch (Exception unused) {
                                }
                                cnVar = cnVar2;
                            }
                        } else {
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(z.r());
                                    chatMessage.setHeight(z.m());
                                }
                            } catch (Exception unused2) {
                            }
                            cnVar = z;
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    String[] split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(pg.e(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(pg.e(split[1], 0));
                    }
                }
                IMImageSize chatImageSize = PicManager.getInstance().getChatImageSize(chatMessage.getWidth(), chatMessage.getHeight());
                ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                layoutParams.height = chatImageSize.height;
                layoutParams.width = chatImageSize.width;
                chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                if (cnVar != null) {
                    chatImageWithTailView.getImage().H();
                    chatImageWithTailView.getImage().b0();
                    cnVar.h(chatImageWithTailView.getImage());
                } else {
                    chatImageWithTailView.getImage().setDefaultResource(SkinManager.getResourceId(R.drawable.icon_pic_im_image_default));
                    chatImageWithTailView.getImage().setTag(l);
                }
                chatImageWithTailView.getImage().setAutoChangeStyle(true);
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(ri.g(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                        layoutParams2.height = ri.g(context, R.dimen.obfuscated_res_0x7f0703d4);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(R.drawable.tb_launcher_icon);
                    chatImageWithTailView.getIcon().N(optString2, 10, false);
                    chatImageWithTailView.getFromSource().setText(optString3);
                    chatImageWithTailView.setVisibility(0);
                    chatImageWithTailView.getTail().setVisibility(0);
                    return;
                }
                chatImageWithTailView.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void f(TbRichTextView tbRichTextView, ChatMessage chatMessage, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65542, null, tbRichTextView, chatMessage, str, i) != null) || chatMessage == null) {
            return;
        }
        MsgCacheData cacheData = chatMessage.getCacheData();
        if (cacheData == null) {
            cacheData = s58.m(chatMessage);
            chatMessage.setCacheData(cacheData);
        }
        if (cacheData.getRich_content() == null) {
            String content = chatMessage.getContent();
            if (content == null) {
                return;
            }
            TbRichText tbRichText = null;
            if (StringUtils.isJSONArray(content)) {
                try {
                    tbRichText = TbRichTextView.Y(new JSONArray(chatMessage.getContent()), 7);
                } catch (Exception unused) {
                }
            }
            if (tbRichText == null) {
                tbRichText = new TbRichText(s08.c(chatMessage.getContent(), i));
            }
            cacheData.setRich_content(tbRichText);
        }
        tbRichTextView.setVisibility(0);
        tbRichTextView.setText(cacheData.getRich_content());
    }
}
