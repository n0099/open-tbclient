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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class eb7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947728655, "Lcom/baidu/tieba/eb7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947728655, "Lcom/baidu/tieba/eb7;");
                return;
            }
        }
        nj5.b();
    }

    public static void a(Context context, GifView gifView, ChatMessage chatMessage, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, gifView, chatMessage, Boolean.valueOf(z)}) == null) {
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
                gifView.i0(gifInfo);
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
                VoiceMsgData r = eg7.r(chatMessage);
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

    public static void b(Context context, View view2, ShareFromPBView shareFromPBView, ShareFromFrsView shareFromFrsView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, view2, shareFromPBView, shareFromFrsView, shareFromGameCenter, chatMessage, str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            jg7 jg7Var = new jg7();
            int c = jg7Var.c(chatMessage.getContent(), str);
            ShareFromFrsMsgData shareFromFrsMsgData = null;
            ShareFromPBMsgData shareFromPBMsgData = null;
            ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
            if (1 == jg7Var.b()) {
                if (jg7Var.a() != null) {
                    if (c == 0) {
                        shareFromPBView.setVisibility(0);
                        if (jg7Var.a() instanceof ShareFromPBMsgData) {
                            shareFromPBMsgData = (ShareFromPBMsgData) jg7Var.a();
                        }
                        shareFromPBView.setData(shareFromPBMsgData);
                    } else if (c == 1) {
                        shareFromGameCenter.setVisibility(0);
                        if (jg7Var.a() instanceof ShareFromGameCenterMsgData) {
                            shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) jg7Var.a();
                        }
                        if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                        } else if (!TextUtils.isEmpty(str) && str.endsWith("MsgrightView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                        }
                    }
                }
            } else if (4 == jg7Var.b()) {
                shareFromFrsView.setVisibility(0);
                if (jg7Var.a() instanceof ShareFromFrsMsgData) {
                    shareFromFrsMsgData = (ShareFromFrsMsgData) jg7Var.a();
                }
                shareFromFrsView.setData(shareFromFrsMsgData);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab A[Catch: Exception -> 0x00f3, TryCatch #4 {Exception -> 0x00f3, blocks: (B:5:0x0007, B:7:0x0010, B:9:0x0019, B:11:0x001d, B:13:0x0026, B:15:0x002e, B:41:0x008a, B:43:0x00ab, B:45:0x00d6, B:44:0x00c1), top: B:66:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1 A[Catch: Exception -> 0x00f3, TryCatch #4 {Exception -> 0x00f3, blocks: (B:5:0x0007, B:7:0x0010, B:9:0x0019, B:11:0x001d, B:13:0x0026, B:15:0x002e, B:41:0x008a, B:43:0x00ab, B:45:0x00d6, B:44:0x00c1), top: B:66:0x0007 }] */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(ChatImageWithTailView chatImageWithTailView, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        in m;
        int i3;
        in inVar;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, chatImageWithTailView, str, str2)) == null) {
            try {
                String[] split = str2.split(",");
                if (split.length > 0) {
                    i = (int) xg.d(split[0], 0.0f);
                } else {
                    i = 0;
                }
                if (split.length > 1) {
                    i2 = (int) xg.d(split[1], 0.0f);
                } else {
                    i2 = 0;
                }
                if (str.startsWith("http")) {
                    chatImageWithTailView.getImage().j0(str, 38);
                } else {
                    try {
                        m = m95.k().m(str);
                    } catch (Exception unused) {
                    }
                    if (m == null) {
                        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ri.d().c(str));
                        if (reSizeBitmap != null) {
                            inVar = new in(reSizeBitmap, false);
                            if (i < 1) {
                                try {
                                    i4 = inVar.r();
                                    try {
                                        i3 = inVar.m();
                                    } catch (Exception unused2) {
                                    }
                                } catch (Exception unused3) {
                                }
                            } else {
                                i4 = 0;
                                i3 = 0;
                            }
                            try {
                                m95.k().d(str, inVar);
                            } catch (Exception unused4) {
                            }
                            if (i4 >= 1) {
                                i = i4;
                                i2 = i3;
                            }
                            IMImageSize chatImageSize = PicManager.getInstance().getChatImageSize(i, i2);
                            ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                            layoutParams.height = chatImageSize.height;
                            layoutParams.width = chatImageSize.width;
                            chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                            if (inVar == null) {
                                chatImageWithTailView.getImage().F();
                                chatImageWithTailView.getImage().Y();
                                inVar.h(chatImageWithTailView.getImage());
                            } else {
                                chatImageWithTailView.getImage().setDefaultResource(SkinManager.getResourceId(R.drawable.icon_pic_im_image_default));
                                chatImageWithTailView.getImage().setTag(str);
                            }
                            chatImageWithTailView.getImage().setAutoChangeStyle(true);
                            chatImageWithTailView.setVisibility(0);
                            return i + "," + i2;
                        }
                    } else {
                        if (i < 1) {
                            try {
                                int r = m.r();
                                try {
                                    i3 = m.m();
                                } catch (Exception unused5) {
                                    i3 = 0;
                                }
                                inVar = m;
                                i4 = r;
                            } catch (Exception unused6) {
                            }
                            if (i4 >= 1) {
                            }
                            IMImageSize chatImageSize2 = PicManager.getInstance().getChatImageSize(i, i2);
                            ViewGroup.LayoutParams layoutParams2 = chatImageWithTailView.getImage().getLayoutParams();
                            layoutParams2.height = chatImageSize2.height;
                            layoutParams2.width = chatImageSize2.width;
                            chatImageWithTailView.getImage().setLayoutParams(layoutParams2);
                            if (inVar == null) {
                            }
                            chatImageWithTailView.getImage().setAutoChangeStyle(true);
                            chatImageWithTailView.setVisibility(0);
                            return i + "," + i2;
                        }
                        inVar = m;
                        i4 = 0;
                        i3 = 0;
                        if (i4 >= 1) {
                        }
                        IMImageSize chatImageSize22 = PicManager.getInstance().getChatImageSize(i, i2);
                        ViewGroup.LayoutParams layoutParams22 = chatImageWithTailView.getImage().getLayoutParams();
                        layoutParams22.height = chatImageSize22.height;
                        layoutParams22.width = chatImageSize22.width;
                        chatImageWithTailView.getImage().setLayoutParams(layoutParams22);
                        if (inVar == null) {
                        }
                        chatImageWithTailView.getImage().setAutoChangeStyle(true);
                        chatImageWithTailView.setVisibility(0);
                        return i + "," + i2;
                    }
                }
                inVar = null;
                i4 = 0;
                i3 = 0;
                if (i4 >= 1) {
                }
                IMImageSize chatImageSize222 = PicManager.getInstance().getChatImageSize(i, i2);
                ViewGroup.LayoutParams layoutParams222 = chatImageWithTailView.getImage().getLayoutParams();
                layoutParams222.height = chatImageSize222.height;
                layoutParams222.width = chatImageSize222.width;
                chatImageWithTailView.getImage().setLayoutParams(layoutParams222);
                if (inVar == null) {
                }
                chatImageWithTailView.getImage().setAutoChangeStyle(true);
                chatImageWithTailView.setVisibility(0);
                return i + "," + i2;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(TbPageContext<?> tbPageContext, Context context, View view2, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tbPageContext, context, view2, invite2GroupView, chatMessage, str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                if (jSONObject.getString("portrait") == null) {
                    return;
                }
                InviteMsgData inviteMsgData = new InviteMsgData();
                inviteMsgData.setFromUid(jSONObject.getLong("fromUid"));
                inviteMsgData.setGroupId(jSONObject.getLong(TbEnum.SystemMessage.KEY_GROUP_ID));
                inviteMsgData.setNotice(jSONObject.getString("notice"));
                inviteMsgData.setPortrait(jSONObject.getString("portrait"));
                inviteMsgData.setText(jSONObject.getString("text"));
                inviteMsgData.setTitle(jSONObject.getString("title"));
                inviteMsgData.setToUid(jSONObject.getLong("toUid"));
                inviteMsgData.setGroupName(jSONObject.getString(TbEnum.SystemMessage.KEY_GROUP_NAME));
                inviteMsgData.setGroupOwnerId(jSONObject.getLong("groupOwnerId"));
                invite2GroupView.setData(tbPageContext, inviteMsgData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public static void e(Context context, View view2, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        String optString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, view2, chatImageWithTailView, chatMessage, Long.valueOf(j), str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String k = eg7.k(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (k == null) {
                    return;
                }
                in inVar = null;
                if (k.startsWith("http")) {
                    chatImageWithTailView.getImage().j0(k, 38);
                } else {
                    try {
                        in m = m95.k().m(k);
                        if (m == null) {
                            Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ri.d().c(k));
                            if (reSizeBitmap != null) {
                                in inVar2 = new in(reSizeBitmap, false);
                                try {
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(inVar2.r());
                                        chatMessage.setHeight(inVar2.m());
                                    }
                                    m95.k().d(k, inVar2);
                                } catch (Exception unused) {
                                }
                                inVar = inVar2;
                            }
                        } else {
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(m.r());
                                    chatMessage.setHeight(m.m());
                                }
                            } catch (Exception unused2) {
                            }
                            inVar = m;
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    String[] split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(xg.e(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(xg.e(split[1], 0));
                    }
                }
                IMImageSize chatImageSize = PicManager.getInstance().getChatImageSize(chatMessage.getWidth(), chatMessage.getHeight());
                ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                layoutParams.height = chatImageSize.height;
                layoutParams.width = chatImageSize.width;
                chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                if (inVar != null) {
                    chatImageWithTailView.getImage().F();
                    chatImageWithTailView.getImage().Y();
                    inVar.h(chatImageWithTailView.getImage());
                } else {
                    chatImageWithTailView.getImage().setDefaultResource(SkinManager.getResourceId(R.drawable.icon_pic_im_image_default));
                    chatImageWithTailView.getImage().setTag(k);
                }
                chatImageWithTailView.getImage().setAutoChangeStyle(true);
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(yi.g(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                        layoutParams2.height = yi.g(context, R.dimen.obfuscated_res_0x7f0702cb);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(R.drawable.tb_launcher_icon);
                    chatImageWithTailView.getIcon().K(optString2, 10, false);
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
            cacheData = eg7.l(chatMessage);
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
                    tbRichText = TbRichTextView.U(new JSONArray(chatMessage.getContent()), 7);
                } catch (Exception unused) {
                }
            }
            if (tbRichText == null) {
                tbRichText = new TbRichText(xa7.c(chatMessage.getContent(), i));
            }
            cacheData.setRich_content(tbRichText);
        }
        tbRichTextView.setVisibility(0);
        tbRichTextView.setText(cacheData.getRich_content());
    }
}
