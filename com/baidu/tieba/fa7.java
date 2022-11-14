package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
public class fa7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947757485, "Lcom/baidu/tieba/fa7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947757485, "Lcom/baidu/tieba/fa7;");
                return;
            }
        }
        ti5.b();
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

    public static void f(Context context, ChatVoiceView chatVoiceView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, context, chatVoiceView, chatMessage, str) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() > 0) {
            try {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    cacheData = new MsgCacheData();
                    cacheData.setVoice_status(1);
                    chatMessage.setCacheData(cacheData);
                } else if (cacheData.getVoice_status() == 0) {
                    cacheData.setVoice_status(1);
                }
                VoiceMsgData q = we7.q(chatMessage);
                if (q != null && q.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceData.VoiceModel());
                    cacheData.getVoice_model().voiceId = q.getVoice_md5();
                    cacheData.getVoice_model().duration = Math.round(q.getDuring_time());
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
            af7 af7Var = new af7();
            int c = af7Var.c(chatMessage.getContent(), str);
            ShareFromFrsMsgData shareFromFrsMsgData = null;
            ShareFromPBMsgData shareFromPBMsgData = null;
            ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
            if (1 == af7Var.b()) {
                if (af7Var.a() != null) {
                    if (c == 0) {
                        shareFromPBView.setVisibility(0);
                        if (af7Var.a() instanceof ShareFromPBMsgData) {
                            shareFromPBMsgData = (ShareFromPBMsgData) af7Var.a();
                        }
                        shareFromPBView.setData(shareFromPBMsgData);
                    } else if (c == 1) {
                        shareFromGameCenter.setVisibility(0);
                        if (af7Var.a() instanceof ShareFromGameCenterMsgData) {
                            shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) af7Var.a();
                        }
                        if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                        } else if (!TextUtils.isEmpty(str) && str.endsWith("MsgrightView")) {
                            shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                        }
                    }
                }
            } else if (4 == af7Var.b()) {
                shareFromFrsView.setVisibility(0);
                if (af7Var.a() instanceof ShareFromFrsMsgData) {
                    shareFromFrsMsgData = (ShareFromFrsMsgData) af7Var.a();
                }
                shareFromFrsView.setData(shareFromFrsMsgData);
            }
        }
    }

    public static void c(TbPageContext<?> tbPageContext, Context context, View view2, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, context, view2, invite2GroupView, chatMessage, str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
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
    public static void d(Context context, View view2, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        String optString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, view2, chatImageWithTailView, chatMessage, Long.valueOf(j), str}) == null) && chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String j2 = we7.j(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (j2 == null) {
                    return;
                }
                in inVar = null;
                if (j2.startsWith("http")) {
                    chatImageWithTailView.getImage().j0(j2, 38);
                } else {
                    try {
                        in m = k95.k().m(j2);
                        if (m == null) {
                            Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ri.d().c(j2));
                            if (reSizeBitmap != null) {
                                in inVar2 = new in(reSizeBitmap, false);
                                try {
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(inVar2.r());
                                        chatMessage.setHeight(inVar2.m());
                                    }
                                    k95.k().d(j2, inVar2);
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
                    chatImageWithTailView.getImage().setTag(j2);
                }
                chatImageWithTailView.getImage().setAutoChangeStyle(true);
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(yi.g(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                        layoutParams2.height = yi.g(context, R.dimen.obfuscated_res_0x7f0702cb);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
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

    public static void e(TbRichTextView tbRichTextView, ChatMessage chatMessage, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65541, null, tbRichTextView, chatMessage, str, i) != null) || chatMessage == null) {
            return;
        }
        MsgCacheData cacheData = chatMessage.getCacheData();
        if (cacheData == null) {
            cacheData = we7.k(chatMessage);
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
                    tbRichText = TbRichTextView.T(new JSONArray(chatMessage.getContent()), 7);
                } catch (Exception unused) {
                }
            }
            if (tbRichText == null) {
                tbRichText = new TbRichText(y97.c(chatMessage.getContent(), i));
            }
            cacheData.setRich_content(tbRichText);
        }
        tbRichTextView.setVisibility(0);
        tbRichTextView.setText(cacheData.getRich_content());
    }
}
