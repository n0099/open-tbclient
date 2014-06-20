package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class cy {
    public static boolean a = com.baidu.tbadk.editortool.ab.b();

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (chatMessage != null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                cacheData = com.baidu.tieba.im.e.r.f(chatMessage);
                chatMessage.setCacheData(cacheData);
            }
            if (cacheData.getRich_content() == null) {
                String content = chatMessage.getContent();
                if (content != null) {
                    if (content.length() > 1 && content.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(chatMessage.getContent()), 5);
                        } catch (Exception e) {
                            BdLog.e("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar == null) {
                            aVar = new com.baidu.tbadk.widget.richText.a(context, bb.a(context, chatMessage.getContent()));
                        }
                        cacheData.setRich_content(aVar);
                    }
                    aVar = null;
                    if (aVar == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[Catch: Exception -> 0x0043, TryCatch #2 {Exception -> 0x0043, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0062, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:22:0x008b, B:23:0x0096, B:25:0x0099, B:26:0x00a4, B:28:0x00f3, B:29:0x00f9, B:49:0x017a, B:42:0x0158), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[Catch: Exception -> 0x0043, TryCatch #2 {Exception -> 0x0043, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0062, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:22:0x008b, B:23:0x0096, B:25:0x0099, B:26:0x00a4, B:28:0x00f3, B:29:0x00f9, B:49:0x017a, B:42:0x0158), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f3 A[Catch: Exception -> 0x0043, TryCatch #2 {Exception -> 0x0043, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0062, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:22:0x008b, B:23:0x0096, B:25:0x0099, B:26:0x00a4, B:28:0x00f3, B:29:0x00f9, B:49:0x017a, B:42:0x0158), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0179  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, View view, TbImageView tbImageView, ChatMessage chatMessage, long j, String str) {
        com.baidu.adp.widget.a.a aVar;
        String optString;
        String[] split;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.e.r.a(jSONObject, false);
                if (a2 == null) {
                    BdLog.e(str, "showPic", "invalid small pic in content:" + chatMessage.getContent());
                    return;
                }
                if (a2.startsWith("http")) {
                    tbImageView.a(a2, 10, false);
                    aVar = null;
                } else {
                    try {
                        aVar = com.baidu.tbadk.imageManager.e.a().c(a2);
                        try {
                            if (aVar == null) {
                                Bitmap a3 = com.baidu.tbadk.core.util.ay.a().a(com.baidu.adp.lib.util.b.a().a(a2));
                                if (a3 != null) {
                                    aVar = new com.baidu.adp.widget.a.a(a3, false);
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(aVar.c());
                                        chatMessage.setHeight(aVar.d());
                                    }
                                    com.baidu.tbadk.imageManager.e.a().b(a2, aVar);
                                } else {
                                    aVar = null;
                                }
                            } else if (chatMessage.getWidth() < 1) {
                                chatMessage.setWidth(aVar.c());
                                chatMessage.setHeight(aVar.d());
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.e("codec", "showPic", e);
                            if (chatMessage.getWidth() < 1) {
                                split = optString.split(",");
                                if (split.length > 0) {
                                }
                                if (split.length > 1) {
                                }
                            }
                            LocalViewSize.a();
                            LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                            com.baidu.tbadk.core.util.resourceLoader.b a5 = com.baidu.tbadk.core.util.ay.a().a(a4.width, a4.height, true);
                            a4.height = a5.c;
                            a4.width = a5.b;
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = a4.height + com.baidu.adp.lib.util.k.a(context, 16.0f);
                            layoutParams.width = a4.width + com.baidu.adp.lib.util.k.a(context, 24.0f);
                            tbImageView.setLayoutParams(layoutParams);
                            if (aVar == null) {
                            }
                            tbImageView.setDrawerType(1);
                            tbImageView.setDrawBorder(false);
                            tbImageView.setRadius(com.baidu.adp.lib.util.k.a(context, 6.0f));
                            tbImageView.setAutoChangeStyle(false);
                            tbImageView.setSupportNoImage(false);
                            tbImageView.setVisibility(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        aVar = null;
                    }
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a42 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                com.baidu.tbadk.core.util.resourceLoader.b a52 = com.baidu.tbadk.core.util.ay.a().a(a42.width, a42.height, true);
                a42.height = a52.c;
                a42.width = a52.b;
                ViewGroup.LayoutParams layoutParams2 = tbImageView.getLayoutParams();
                layoutParams2.height = a42.height + com.baidu.adp.lib.util.k.a(context, 16.0f);
                layoutParams2.width = a42.width + com.baidu.adp.lib.util.k.a(context, 24.0f);
                tbImageView.setLayoutParams(layoutParams2);
                if (aVar == null) {
                    tbImageView.f();
                    aVar.a(tbImageView);
                } else {
                    tbImageView.setImageBitmap(null);
                    tbImageView.setDefaultResource(com.baidu.tieba.u.image_h_not);
                    tbImageView.setTag(a2);
                }
                tbImageView.setDrawerType(1);
                tbImageView.setDrawBorder(false);
                tbImageView.setRadius(com.baidu.adp.lib.util.k.a(context, 6.0f));
                tbImageView.setAutoChangeStyle(false);
                tbImageView.setSupportNoImage(false);
                tbImageView.setVisibility(0);
            } catch (Exception e3) {
                BdLog.e(str, "showPic", "error:" + e3.getMessage());
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, View view, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                String string = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                if (string != null) {
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
                    com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(context);
                    abVar.d(true);
                    abVar.a(string, true, (com.baidu.tbadk.imageManager.d) new cz(view), true);
                }
            } catch (Exception e) {
                BdLog.e(str, "showPic", "error:" + e.getMessage());
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
                VoiceMsgData g = com.baidu.tieba.im.e.r.g(chatMessage);
                if (g != null && g.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceData.VoiceModel());
                    cacheData.getVoice_model().voiceId = g.getVoice_md5();
                    cacheData.getVoice_model().duration = Math.round(g.getDuring_time());
                }
                chatVoiceView.setData(chatMessage);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e) {
                BdLog.e(str, "showVoice", "error:" + e.getMessage());
                return;
            }
        }
        BdLog.e(str, "showVoice", "msg content is null");
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
}
