package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ce {
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (chatMessage != null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                cacheData = com.baidu.tieba.im.e.d.d(chatMessage);
                chatMessage.setCacheData(cacheData);
            }
            if (cacheData.getRich_content() == null) {
                String content = chatMessage.getContent();
                if (content != null) {
                    if (content.length() > 1 && content.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(chatMessage.getContent()), 5);
                        } catch (Exception e) {
                            com.baidu.adp.lib.h.e.a("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar == null) {
                            aVar = new com.baidu.tbadk.widget.richText.a(context, j.a(context, chatMessage.getContent()));
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0087 A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x00fc, B:29:0x0102, B:52:0x0173, B:43:0x014d), top: B:63:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x00fc, B:29:0x0102, B:52:0x0173, B:43:0x014d), top: B:63:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6 A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x00fc, B:29:0x0102, B:52:0x0173, B:43:0x014d), top: B:63:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x00fc, B:29:0x0102, B:52:0x0173, B:43:0x014d), top: B:63:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, View view, BDImageView2 bDImageView2, ChatMessage chatMessage, long j, String str) {
        com.baidu.adp.widget.ImageView.e eVar;
        String optString;
        String[] split;
        com.baidu.adp.widget.ImageView.e eVar2 = null;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.e.d.a(jSONObject, false);
                if (a2 == null) {
                    com.baidu.adp.lib.h.e.b(str, "showPic", "invalid small pic in content:" + chatMessage.getContent());
                    return;
                }
                if (a2.startsWith("http")) {
                    com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(context);
                    iVar.d(true);
                    eVar = iVar.a(a2, true, (com.baidu.tbadk.imageManager.c) new cf(view));
                } else {
                    try {
                        eVar = com.baidu.tbadk.imageManager.d.a().c(a2);
                        if (eVar == null) {
                            Bitmap a3 = com.baidu.tieba.util.m.a(com.baidu.tieba.util.a.c.a(com.baidu.adp.lib.h.a.a().a(a2)), 10.0f);
                            if (a3 != null) {
                                eVar = new com.baidu.adp.widget.ImageView.e(a3, false);
                                try {
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(eVar.a());
                                        chatMessage.setHeight(eVar.b());
                                    }
                                    com.baidu.tbadk.imageManager.d.a().b(a2, eVar);
                                } catch (Exception e) {
                                    eVar2 = eVar;
                                    e = e;
                                    com.baidu.adp.lib.h.e.a("codec", "showPic", e);
                                    eVar = eVar2;
                                    if (chatMessage.getWidth() < 1) {
                                    }
                                    LocalViewSize.a();
                                    LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                                    com.baidu.tieba.util.a.b a5 = com.baidu.tieba.util.a.c.a(a4.width, a4.height, true);
                                    a4.height = a5.c;
                                    a4.width = a5.b;
                                    ViewGroup.LayoutParams layoutParams = bDImageView2.getLayoutParams();
                                    layoutParams.height = a4.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                                    layoutParams.width = a4.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
                                    bDImageView2.setLayoutParams(layoutParams);
                                    if (eVar != null) {
                                    }
                                    bDImageView2.setVisibility(0);
                                }
                            } else {
                                eVar = null;
                            }
                        } else {
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(eVar.a());
                                    chatMessage.setHeight(eVar.b());
                                }
                            } catch (Exception e2) {
                                eVar2 = eVar;
                                e = e2;
                                com.baidu.adp.lib.h.e.a("codec", "showPic", e);
                                eVar = eVar2;
                                if (chatMessage.getWidth() < 1) {
                                    split = optString.split(",");
                                    if (split.length > 0) {
                                    }
                                    if (split.length > 1) {
                                    }
                                }
                                LocalViewSize.a();
                                LocalViewSize.ImageSize a42 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                                com.baidu.tieba.util.a.b a52 = com.baidu.tieba.util.a.c.a(a42.width, a42.height, true);
                                a42.height = a52.c;
                                a42.width = a52.b;
                                ViewGroup.LayoutParams layoutParams2 = bDImageView2.getLayoutParams();
                                layoutParams2.height = a42.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                                layoutParams2.width = a42.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
                                bDImageView2.setLayoutParams(layoutParams2);
                                if (eVar != null) {
                                }
                                bDImageView2.setVisibility(0);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
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
                LocalViewSize.ImageSize a422 = LocalViewSize.a().a(LocalViewSize.a().c(), chatMessage.getHeight(), chatMessage.getWidth());
                com.baidu.tieba.util.a.b a522 = com.baidu.tieba.util.a.c.a(a422.width, a422.height, true);
                a422.height = a522.c;
                a422.width = a522.b;
                ViewGroup.LayoutParams layoutParams22 = bDImageView2.getLayoutParams();
                layoutParams22.height = a422.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                layoutParams22.width = a422.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
                bDImageView2.setLayoutParams(layoutParams22);
                if (eVar != null) {
                    bDImageView2.a();
                    eVar.a(bDImageView2);
                } else {
                    bDImageView2.setImageBitmap(null);
                    bDImageView2.setDefaultResource(R.drawable.image_h_not);
                    bDImageView2.setTag(a2);
                }
                bDImageView2.setVisibility(0);
            } catch (Exception e4) {
                com.baidu.adp.lib.h.e.b(str, "showPic", "error:" + e4.getMessage());
                e4.printStackTrace();
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
                VoiceMsgData e = com.baidu.tieba.im.e.d.e(chatMessage);
                if (e != null && e.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                    cacheData.setVoice_model(new VoiceManager.VoiceModel());
                    cacheData.getVoice_model().voiceId = e.getVoice_md5();
                    cacheData.getVoice_model().duration = Math.round(e.getDuring_time());
                }
                chatVoiceView.setData(chatMessage);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e2) {
                com.baidu.adp.lib.h.e.b(str, "showVoice", "error:" + e2.getMessage());
                return;
            }
        }
        com.baidu.adp.lib.h.e.b(str, "showVoice", "msg:" + chatMessage.getContent());
    }
}
