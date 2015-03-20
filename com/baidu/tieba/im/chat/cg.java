package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ao;
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
public class cg {
    public static boolean aYc = com.baidu.tbadk.util.g.Df();

    public static void a(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str, int i) {
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
                        aVar = new com.baidu.tbadk.widget.richText.a(context, z.c(context, chatMessage.getContent(), i));
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
                String a = com.baidu.tieba.im.util.i.a(jSONObject, false);
                String optString2 = jSONObject.optString("shareSourceIcon");
                String optString3 = jSONObject.optString("shareSource");
                String optString4 = jSONObject.optString("shareSourceUrl");
                if (a != null) {
                    if (a.startsWith("http")) {
                        chatImageWithTailView.getImage().c(a, 10, false);
                        aVar = null;
                    } else {
                        try {
                            aVar = com.baidu.tbadk.imageManager.e.zs().er(a);
                            try {
                                if (aVar == null) {
                                    Bitmap f = ao.sJ().f(com.baidu.adp.lib.util.e.it().ay(a));
                                    if (f == null) {
                                        aVar = null;
                                    } else {
                                        aVar = new com.baidu.adp.widget.a.a(f, false);
                                        if (chatMessage.getWidth() < 1) {
                                            chatMessage.setWidth(aVar.getWidth());
                                            chatMessage.setHeight(aVar.getHeight());
                                        }
                                        com.baidu.tbadk.imageManager.e.zs().c(a, aVar);
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
                            chatMessage.setWidth(com.baidu.adp.lib.g.c.toInt(split[0], 0));
                        }
                        if (split.length > 1) {
                            chatMessage.setHeight(com.baidu.adp.lib.g.c.toInt(split[1], 0));
                        }
                    }
                    LocalViewSize.sj();
                    LocalViewSize.ImageSize a2 = LocalViewSize.sj().a(LocalViewSize.sj().getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
                    com.baidu.tbadk.core.util.a.a imageSize = ao.sJ().getImageSize(a2.width, a2.height, true);
                    a2.height = imageSize.height;
                    a2.width = imageSize.width;
                    ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                    layoutParams.height = a2.height;
                    layoutParams.width = a2.width;
                    chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                    if (aVar != null) {
                        chatImageWithTailView.getImage().reset();
                        if (chatImageWithTailView.getImage() instanceof ChatClipImageItemView) {
                            chatImageWithTailView.getImage().Oh();
                        }
                        aVar.a(chatImageWithTailView.getImage());
                    } else {
                        chatImageWithTailView.getImage().setImageDrawable(null);
                        chatImageWithTailView.getImage().setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
                        chatImageWithTailView.getImage().setTag(a);
                    }
                    chatImageWithTailView.getImage().setDrawBorder(false);
                    chatImageWithTailView.getImage().setAutoChangeStyle(false);
                    if (TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString2)) {
                        chatImageWithTailView.setVisibility(0);
                        return;
                    }
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(com.baidu.adp.lib.util.n.d(context, com.baidu.tieba.t.ds14), 0, 0, 0);
                        layoutParams2.height = com.baidu.adp.lib.util.n.d(context, com.baidu.tieba.t.ds48);
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

    public static void a(TbPageContext<?> tbPageContext, Context context, View view, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
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
                    invite2GroupView.a(tbPageContext, inviteMsgData);
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
        gifView.setVisibility(0);
        com.baidu.tbadk.gif.a gifInfo = chatMessage.getGifInfo();
        if (chatMessage.getGifInfo() != null) {
            gifInfo.ako = gifInfo.ako > 0 ? gifInfo.ako : i;
            if (gifInfo.akp > 0) {
                i2 = gifInfo.akp;
            }
            gifInfo.akp = i2;
            gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.ako, gifInfo.akp));
            gifView.a(gifInfo);
            gifView.setVisibility(0);
            return;
        }
        gifView.setVisibility(8);
    }

    public static void a(Context context, View view, ShareFromPBView shareFromPBView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
            int aJ = aVar.aJ(chatMessage.getContent(), str);
            if (1 == aVar.TH() && aVar.TI() != null) {
                if (aJ == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData((ShareFromPBMsgData) aVar.TI());
                } else if (aJ == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = null;
                    if (aVar.TI() instanceof ShareFromGameCenterMsgData) {
                        shareFromGameCenterMsgData = (ShareFromGameCenterMsgData) aVar.TI();
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
