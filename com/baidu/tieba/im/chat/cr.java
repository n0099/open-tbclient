package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class cr {
    public static boolean a = com.baidu.tieba.util.i.b();

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, com.baidu.tieba.im.message.b bVar) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (bVar != null) {
            MsgCacheData o = bVar.o();
            if (o == null) {
                o = com.baidu.tieba.im.util.l.a();
                bVar.a(o);
            }
            if (o.getRich_content() == null) {
                String k = bVar.k();
                if (k != null) {
                    if (k.length() > 1 && k.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(bVar.k()), 5);
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.e.b("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar == null) {
                            aVar = new com.baidu.tbadk.widget.richText.a(context, ak.a(context, bVar.k()));
                        }
                        o.setRich_content(aVar);
                    }
                    aVar = null;
                    if (aVar == null) {
                    }
                    o.setRich_content(aVar);
                } else {
                    return;
                }
            }
            tbRichTextView.setVisibility(0);
            tbRichTextView.setText(o.getRich_content());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0090 A[Catch: Exception -> 0x0041, TryCatch #2 {Exception -> 0x0041, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x005e, B:15:0x0066, B:16:0x0079, B:18:0x007f, B:20:0x0087, B:22:0x0090, B:23:0x009b, B:25:0x009e, B:26:0x00a9, B:28:0x00f7, B:29:0x00fd, B:49:0x016a, B:42:0x014a), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e A[Catch: Exception -> 0x0041, TryCatch #2 {Exception -> 0x0041, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x005e, B:15:0x0066, B:16:0x0079, B:18:0x007f, B:20:0x0087, B:22:0x0090, B:23:0x009b, B:25:0x009e, B:26:0x00a9, B:28:0x00f7, B:29:0x00fd, B:49:0x016a, B:42:0x014a), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f7 A[Catch: Exception -> 0x0041, TryCatch #2 {Exception -> 0x0041, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x005e, B:15:0x0066, B:16:0x0079, B:18:0x007f, B:20:0x0087, B:22:0x0090, B:23:0x009b, B:25:0x009e, B:26:0x00a9, B:28:0x00f7, B:29:0x00fd, B:49:0x016a, B:42:0x014a), top: B:57:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0169  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, View view, BDImageView2 bDImageView2, com.baidu.tieba.im.message.b bVar, String str) {
        com.baidu.adp.widget.ImageView.b bVar2;
        String optString;
        String[] split;
        if (bVar.k() != null && bVar.k().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(bVar.k()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.util.l.a(jSONObject, false);
                if (a2 == null) {
                    com.baidu.adp.lib.util.e.b(str, "showPic", "invalid small pic in content:" + bVar.k());
                    return;
                }
                if (a2.startsWith("http")) {
                    com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(context);
                    iVar.a(true);
                    bVar2 = iVar.b(a2, true, new cs(view));
                } else {
                    try {
                        bVar2 = com.baidu.tbadk.imageManager.e.a().c(a2);
                        try {
                            if (bVar2 == null) {
                                com.baidu.adp.lib.util.a.a();
                                Bitmap a3 = com.baidu.tieba.util.n.a(com.baidu.tieba.util.bm.a().a(com.baidu.adp.lib.util.a.a(a2), true), 10.0f, true);
                                if (a3 != null) {
                                    bVar2 = new com.baidu.adp.widget.ImageView.b(a3, false);
                                    if (bVar.q() <= 0) {
                                        bVar.c(bVar2.c());
                                        bVar.d(bVar2.d());
                                    }
                                    com.baidu.tbadk.imageManager.e.a().c(a2, bVar2);
                                } else {
                                    bVar2 = null;
                                }
                            } else if (bVar.q() <= 0) {
                                bVar.c(bVar2.c());
                                bVar.d(bVar2.d());
                            }
                        } catch (Exception e) {
                            e = e;
                            com.baidu.adp.lib.util.e.a("codec", "showPic", e);
                            if (bVar.q() <= 0) {
                                split = optString.split(",");
                                if (split.length > 0) {
                                }
                                if (split.length > 1) {
                                }
                            }
                            LocalViewSize.a();
                            LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.r(), bVar.q());
                            com.baidu.tieba.util.bm.a();
                            com.baidu.tieba.util.a.c a5 = com.baidu.tieba.util.bm.a(a4.width, a4.height, true);
                            a4.height = a5.c;
                            a4.width = a5.b;
                            ViewGroup.LayoutParams layoutParams = bDImageView2.getLayoutParams();
                            layoutParams.height = a4.height + BdUtilHelper.a(context, 16.0f);
                            layoutParams.width = a4.width + BdUtilHelper.a(context, 24.0f);
                            bDImageView2.setLayoutParams(layoutParams);
                            if (bVar2 == null) {
                            }
                            bDImageView2.setVisibility(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bVar2 = null;
                    }
                }
                if (bVar.q() <= 0 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        bVar.c(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        bVar.d(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a42 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.r(), bVar.q());
                com.baidu.tieba.util.bm.a();
                com.baidu.tieba.util.a.c a52 = com.baidu.tieba.util.bm.a(a42.width, a42.height, true);
                a42.height = a52.c;
                a42.width = a52.b;
                ViewGroup.LayoutParams layoutParams2 = bDImageView2.getLayoutParams();
                layoutParams2.height = a42.height + BdUtilHelper.a(context, 16.0f);
                layoutParams2.width = a42.width + BdUtilHelper.a(context, 24.0f);
                bDImageView2.setLayoutParams(layoutParams2);
                if (bVar2 == null) {
                    bDImageView2.a();
                    bVar2.a(bDImageView2);
                } else {
                    bDImageView2.setImageBitmap(null);
                    bDImageView2.setDefaultResource(R.drawable.image_h_not);
                    bDImageView2.setTag(a2);
                }
                bDImageView2.setVisibility(0);
            } catch (Exception e3) {
                com.baidu.adp.lib.util.e.b(str, "showPic", "error:" + e3.getMessage());
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, View view, Invite2GroupView invite2GroupView, com.baidu.tieba.im.message.b bVar, String str) {
        if (bVar.k() != null && bVar.k().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(bVar.k());
                String string = jSONObject.getString("portrait");
                if (string != null) {
                    InviteMsgData inviteMsgData = new InviteMsgData();
                    inviteMsgData.setFromUid(jSONObject.getLong("fromUid"));
                    inviteMsgData.setGroupId(jSONObject.getInt("groupId"));
                    inviteMsgData.setNotice(jSONObject.getString("notice"));
                    inviteMsgData.setPortrait(jSONObject.getString("portrait"));
                    inviteMsgData.setText(jSONObject.getString("text"));
                    inviteMsgData.setTitle(jSONObject.getString("title"));
                    inviteMsgData.setToUid(jSONObject.getLong("toUid"));
                    inviteMsgData.setGroupName(jSONObject.getString("groupName"));
                    inviteMsgData.setGroupOwnerId(jSONObject.getLong("groupOwnerId"));
                    invite2GroupView.setData(inviteMsgData);
                    com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(context);
                    iVar.a(true);
                    iVar.a(string, true, false, (com.baidu.tbadk.imageManager.d) new cu(view), true);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(str, "showPic", "error:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void a(ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.b bVar, String str) {
        if (bVar.k() != null && bVar.k().length() > 0) {
            try {
                MsgCacheData o = bVar.o();
                if (o == null) {
                    o = new MsgCacheData();
                    o.setVoice_status(1);
                    bVar.a(o);
                } else if (o.getVoice_status() == 0) {
                    o.setVoice_status(1);
                }
                VoiceMsgData f = com.baidu.tieba.im.util.l.f(bVar);
                if (f != null && f.getDuring_time() != 0.0f && o.getVoice_model() == null) {
                    o.setVoice_model(new VoiceManager.VoiceModel());
                    o.getVoice_model().voiceId = f.getVoice_md5();
                    o.getVoice_model().duration = Math.round(f.getDuring_time());
                }
                chatVoiceView.setData(bVar);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(str, "showVoice", "error:" + e.getMessage());
                return;
            }
        }
        com.baidu.adp.lib.util.e.b(str, "showVoice", "msg content is null");
    }

    public static void a(Context context, GifView gifView, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.util.i iVar, boolean z) {
        String str;
        String str2;
        gifView.setVisibility(0);
        float f = context.getResources().getDisplayMetrics().density;
        int i = ((double) f) > 1.5d ? 240 : 160;
        int i2 = ((double) f) > 1.5d ? 240 : 160;
        String k = bVar.k();
        JSONObject jSONObject = null;
        try {
            JSONArray jSONArray = new JSONArray(k);
            if (jSONArray.length() > 0) {
                jSONObject = jSONArray.getJSONObject(0);
            }
        } catch (JSONException e) {
            try {
                jSONObject = new JSONObject(k);
            } catch (JSONException e2) {
                gifView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
                gifView.setGif(null);
                bVar.b(false);
                return;
            }
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("face_name");
            String optString2 = jSONObject.optString("url_s");
            String optString3 = jSONObject.optString("url_d");
            String optString4 = jSONObject.optString("pid");
            int optInt = jSONObject.optInt("size_width", i);
            int optInt2 = jSONObject.optInt("size_height", i2);
            if (optInt > 0 && optInt2 > 0) {
                gifView.setLayoutParams(new FrameLayout.LayoutParams(optInt, optInt2));
            } else {
                gifView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            }
            if (!bVar.s()) {
                gifView.setGif(null);
            } else if (z) {
                boolean z2 = true;
                if (com.baidu.tieba.util.i.b()) {
                    str2 = optString3;
                } else {
                    z2 = false;
                    str2 = optString2;
                }
                cw cwVar = new cw(gifView, optString, bVar, optString3, iVar, optString4, optString2);
                gifView.setTag(optString);
                com.baidu.adp.widget.ImageView.b b = b(iVar, optString4, optString, str2, z2, cwVar);
                if (b != null) {
                    gifView.setGif(b);
                    gifView.setIsLoading(false);
                    bVar.b(true);
                    return;
                }
                gifView.setIsLoading(true);
            } else {
                boolean z3 = true;
                if (a) {
                    str = optString3;
                } else {
                    z3 = false;
                    str = optString2;
                }
                cx cxVar = new cx(gifView, optString, bVar, optString3, iVar, optString4, optString2);
                gifView.setTag(optString);
                com.baidu.adp.widget.ImageView.b b2 = b(iVar, optString4, optString, str, z3, cxVar);
                if (b2 != null) {
                    gifView.setGif(b2);
                    gifView.setIsLoading(false);
                    bVar.b(true);
                    return;
                }
                gifView.setIsLoading(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.adp.widget.ImageView.b b(com.baidu.tieba.util.i iVar, String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return iVar.a(str, str2, str3, z, dVar);
    }
}
