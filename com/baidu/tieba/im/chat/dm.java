package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
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
public class dm {
    public static boolean aQc = com.baidu.tbadk.util.e.vb();

    public static void a(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str) {
        if (chatMessage != null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                cacheData = com.baidu.tieba.im.util.i.u(chatMessage);
                chatMessage.setCacheData(cacheData);
            }
            if (cacheData.getRich_content() == null) {
                String content = chatMessage.getContent();
                if (content != null) {
                    com.baidu.tbadk.widget.richText.a aVar = null;
                    if (StringUtils.isJSONArray(content)) {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(chatMessage.getContent()), 5);
                        } catch (Exception e) {
                        }
                    }
                    if (aVar == null) {
                        aVar = new com.baidu.tbadk.widget.richText.a(context, ba.C(context, chatMessage.getContent()));
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

    public static void a(Context context, View view, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        com.baidu.adp.widget.a.a aVar;
        String optString;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String b = com.baidu.tieba.im.util.i.b(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (b != null) {
                    if (b.startsWith("http")) {
                        chatImageWithTailView.getImage().c(b, 10, false);
                        aVar = null;
                    } else {
                        try {
                            aVar = com.baidu.tbadk.imageManager.e.si().dt(b);
                            try {
                                if (aVar == null) {
                                    Bitmap c = com.baidu.tbadk.core.util.ap.mw().c(com.baidu.adp.lib.util.c.eS().ao(b));
                                    if (c == null) {
                                        aVar = null;
                                    } else {
                                        aVar = new com.baidu.adp.widget.a.a(c, false);
                                        if (chatMessage.getWidth() < 1) {
                                            chatMessage.setWidth(aVar.getWidth());
                                            chatMessage.setHeight(aVar.getHeight());
                                        }
                                        com.baidu.tbadk.imageManager.e.si().c(b, aVar);
                                    }
                                } else if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(aVar.getWidth());
                                    chatMessage.setHeight(aVar.getHeight());
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
                            chatMessage.setWidth(com.baidu.adp.lib.g.c.f(split[0], 0));
                        }
                        if (split.length > 1) {
                            chatMessage.setHeight(com.baidu.adp.lib.g.c.f(split[1], 0));
                        }
                    }
                    LocalViewSize.lV();
                    LocalViewSize.ImageSize a = LocalViewSize.lV().a(LocalViewSize.lV().lX(), chatMessage.getHeight(), chatMessage.getWidth());
                    com.baidu.tbadk.core.util.a.a a2 = com.baidu.tbadk.core.util.ap.mw().a(a.width, a.height, true);
                    a.height = a2.height;
                    a.width = a2.width;
                    ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                    layoutParams.height = a.height;
                    layoutParams.width = a.width;
                    chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                    if (aVar != null) {
                        chatImageWithTailView.getImage().reset();
                        if (chatImageWithTailView.getImage() instanceof ChatClipImageItemView) {
                            chatImageWithTailView.getImage().KR();
                        }
                        aVar.a(chatImageWithTailView.getImage());
                    } else {
                        chatImageWithTailView.getImage().setImageDrawable(null);
                        chatImageWithTailView.getImage().setDefaultResource(com.baidu.tieba.u.image_h_not);
                        chatImageWithTailView.getImage().setTag(b);
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
                        layoutParams2.setMargins(com.baidu.adp.lib.util.m.c(context, com.baidu.tieba.t.ds14), 0, 0, 0);
                        layoutParams2.height = com.baidu.adp.lib.util.m.c(context, com.baidu.tieba.t.ds48);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(com.baidu.tieba.u.icon);
                    chatImageWithTailView.getIcon().c(optString2, 10, false);
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
                VoiceMsgData v = com.baidu.tieba.im.util.i.v(chatMessage);
                if (v != null && v.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceData.VoiceModel());
                    cacheData.getVoice_model().voiceId = v.getVoice_md5();
                    cacheData.getVoice_model().duration = Math.round(v.getDuring_time());
                }
                chatVoiceView.setTag(null);
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
            gifInfo.Tn = gifInfo.Tn > 0 ? gifInfo.Tn : i;
            if (gifInfo.To > 0) {
                i2 = gifInfo.To;
            }
            gifInfo.To = i2;
            gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.Tn, gifInfo.To));
            gifView.a(gifInfo);
            gifView.setVisibility(0);
            return;
        }
        gifView.setVisibility(8);
    }

    public static void a(Context context, View view, ShareFromPBView shareFromPBView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
            int aw = aVar.aw(chatMessage.getContent(), str);
            if (1 == aVar.RY() && aVar.RZ() != null) {
                if (aw == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData((ShareFromPBMsgData) aVar.RZ());
                } else if (aw == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
                    if (aVar.RZ() instanceof ShareFromGameCenterMsgData) {
                        shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) aVar.RZ();
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
