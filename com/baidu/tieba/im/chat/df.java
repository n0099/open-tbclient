package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class df {
    public static boolean a = com.baidu.tbadk.c.c.a();

    public static void a(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str) {
        if (chatMessage != null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                cacheData = com.baidu.tieba.im.d.j.g(chatMessage);
                chatMessage.setCacheData(cacheData);
            }
            if (cacheData.getRich_content() == null) {
                String content = chatMessage.getContent();
                if (content != null) {
                    com.baidu.tbadk.widget.richText.a aVar = null;
                    if (content.length() > 1 && content.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(chatMessage.getContent()), 5);
                        } catch (Exception e) {
                        }
                    }
                    if (aVar == null) {
                        aVar = new com.baidu.tbadk.widget.richText.a(context, ba.a(context, chatMessage.getContent()));
                    }
                    cacheData.setRich_content(aVar);
                } else {
                    return;
                }
            }
            tbRichTextView.setVisibility(0);
            tbRichTextView.setText(cacheData.getRich_content());
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public static void a(Context context, View view, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        com.baidu.adp.widget.a.a aVar;
        String optString;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.d.j.a(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (a2 != null) {
                    if (a2.startsWith("http")) {
                        chatImageWithTailView.getImage().a(a2, 10, false);
                        aVar = null;
                    } else {
                        try {
                            aVar = com.baidu.tbadk.imageManager.e.a().c(a2);
                            try {
                                if (aVar == null) {
                                    Bitmap a3 = com.baidu.tbadk.core.util.ar.a().a(com.baidu.adp.lib.util.b.a().a(a2));
                                    if (a3 == null) {
                                        aVar = null;
                                    } else {
                                        aVar = new com.baidu.adp.widget.a.a(a3, false);
                                        if (chatMessage.getWidth() < 1) {
                                            chatMessage.setWidth(aVar.c());
                                            chatMessage.setHeight(aVar.d());
                                        }
                                        com.baidu.tbadk.imageManager.e.a().b(a2, aVar);
                                    }
                                } else if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(aVar.c());
                                    chatMessage.setHeight(aVar.d());
                                }
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            aVar = null;
                        }
                    }
                    if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                        String[] split = optString.split(",");
                        if (split.length > 0) {
                            chatMessage.setWidth(com.baidu.adp.lib.e.b.a(split[0], 0));
                        }
                        if (split.length > 1) {
                            chatMessage.setHeight(com.baidu.adp.lib.e.b.a(split[1], 0));
                        }
                    }
                    LocalViewSize.a();
                    LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                    com.baidu.tbadk.core.util.a.a a5 = com.baidu.tbadk.core.util.ar.a().a(a4.width, a4.height, true);
                    a4.height = a5.c;
                    a4.width = a5.b;
                    ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                    layoutParams.height = a4.height;
                    layoutParams.width = a4.width;
                    chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                    if (aVar != null) {
                        chatImageWithTailView.getImage().f();
                        if (chatImageWithTailView.getImage() instanceof ChatClipImageItemView) {
                            chatImageWithTailView.getImage().g();
                        }
                        aVar.a(chatImageWithTailView.getImage());
                    } else {
                        chatImageWithTailView.getImage().setImageDrawable(null);
                        chatImageWithTailView.getImage().setDefaultResource(com.baidu.tieba.t.image_h_not);
                        chatImageWithTailView.getImage().setTag(a2);
                    }
                    chatImageWithTailView.getImage().setDrawBorder(false);
                    chatImageWithTailView.getImage().setAutoChangeStyle(false);
                    chatImageWithTailView.getImage().setSupportNoImage(false);
                    if (TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString2)) {
                        chatImageWithTailView.setVisibility(0);
                        return;
                    }
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(com.baidu.adp.lib.util.j.c(context, com.baidu.tieba.s.ds14), 0, 0, 0);
                        layoutParams2.height = com.baidu.adp.lib.util.j.c(context, com.baidu.tieba.s.ds48);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(com.baidu.tieba.t.icon);
                    chatImageWithTailView.getIcon().a(optString2, 10, false);
                    chatImageWithTailView.getFromSource().setText(optString3);
                    chatImageWithTailView.setVisibility(0);
                    chatImageWithTailView.getTail().setVisibility(0);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, View view, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                if (jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT) != null) {
                    InviteMsgData inviteMsgData = new InviteMsgData();
                    inviteMsgData.setFromUid(jSONObject.getLong("fromUid"));
                    inviteMsgData.setGroupId(jSONObject.getInt("groupId"));
                    inviteMsgData.setNotice(jSONObject.getString("notice"));
                    inviteMsgData.setPortrait(jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                    inviteMsgData.setText(jSONObject.getString("text"));
                    inviteMsgData.setTitle(jSONObject.getString("title"));
                    inviteMsgData.setToUid(jSONObject.getLong("toUid"));
                    inviteMsgData.setGroupName(jSONObject.getString("groupName"));
                    inviteMsgData.setGroupOwnerId(jSONObject.getLong("groupOwnerId"));
                    invite2GroupView.setData(inviteMsgData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, ChatVoiceView chatVoiceView, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() > 0) {
            try {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    cacheData = new MsgCacheData();
                    cacheData.setVoice_status(1);
                    chatMessage.setCacheData(cacheData);
                } else if (cacheData.getVoice_status() == 0) {
                    cacheData.setVoice_status(1);
                }
                VoiceMsgData h = com.baidu.tieba.im.d.j.h(chatMessage);
                if (h != null && h.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceData.VoiceModel());
                    cacheData.getVoice_model().voiceId = h.getVoice_md5();
                    cacheData.getVoice_model().duration = Math.round(h.getDuring_time());
                }
                chatVoiceView.setData(chatMessage);
                chatVoiceView.setVisibility(0);
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, GifView gifView, ChatMessage chatMessage, boolean z) {
        float f = context.getResources().getDisplayMetrics().density;
        int i = ((double) f) > 1.5d ? 240 : 160;
        int i2 = ((double) f) <= 1.5d ? 160 : 240;
        gifView.setSupportNoImage(false);
        gifView.setVisibility(0);
        com.baidu.tbadk.gif.a gifInfo = chatMessage.getGifInfo();
        if (chatMessage.getGifInfo() != null) {
            gifInfo.f = gifInfo.f > 0 ? gifInfo.f : i;
            if (gifInfo.g > 0) {
                i2 = gifInfo.g;
            }
            gifInfo.g = i2;
            gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.f, gifInfo.g));
            gifView.a(gifInfo);
            gifView.setVisibility(0);
            return;
        }
        gifView.setVisibility(8);
    }

    public static void a(Context context, View view, ShareFromPBView shareFromPBView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
            int a2 = aVar.a(chatMessage.getContent(), str);
            if (1 == aVar.a() && aVar.b() != null) {
                if (a2 == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData((ShareFromPBMsgData) aVar.b());
                } else if (a2 == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
                    if (aVar.b() instanceof ShareFromGameCenterMsgData) {
                        shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) aVar.b();
                    }
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        shareFromGameCenter.a(shareFromGameCenterMsgData, false);
                    } else if (!TextUtils.isEmpty(str) && str.endsWith("MsgrightView")) {
                        shareFromGameCenter.a(shareFromGameCenterMsgData, true);
                    }
                }
            }
        }
    }
}
