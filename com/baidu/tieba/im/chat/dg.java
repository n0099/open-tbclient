package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class dg {
    public static boolean a = com.baidu.tbadk.core.util.b.b();

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, com.baidu.tieba.im.message.a.a aVar) {
        com.baidu.tbadk.widget.richText.a aVar2;
        if (aVar != null) {
            MsgCacheData z = aVar.z();
            if (z == null) {
                z = com.baidu.tieba.im.f.q.a();
                aVar.a(z);
            }
            if (z.getRich_content() == null) {
                String v = aVar.v();
                if (v != null) {
                    if (v.length() > 1 && v.charAt(0) == '[') {
                        try {
                            aVar2 = TbRichTextView.a(context, new JSONArray(aVar.v()), 5);
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar2 == null) {
                            aVar2 = new com.baidu.tbadk.widget.richText.a(context, bc.a(context, aVar.v()));
                        }
                        z.setRich_content(aVar2);
                    }
                    aVar2 = null;
                    if (aVar2 == null) {
                    }
                    z.setRich_content(aVar2);
                } else {
                    return;
                }
            }
            tbRichTextView.setVisibility(0);
            tbRichTextView.setText(z.getRich_content());
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
    public static void a(Context context, View view, BDImageView2 bDImageView2, com.baidu.tieba.im.message.a.a aVar, String str) {
        com.baidu.adp.widget.ImageView.b bVar;
        String optString;
        String[] split;
        if (aVar.v() != null && aVar.v().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(aVar.v()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.f.q.a(jSONObject, false);
                if (a2 == null) {
                    com.baidu.adp.lib.util.f.b(str, "showPic", "invalid small pic in content:" + aVar.v());
                    return;
                }
                if (a2.startsWith("http")) {
                    com.baidu.tbadk.editortool.aa aaVar = new com.baidu.tbadk.editortool.aa(context);
                    aaVar.a(true);
                    bVar = aaVar.a(a2, true, (com.baidu.tbadk.imageManager.d) new dh(view));
                } else {
                    try {
                        bVar = com.baidu.tbadk.imageManager.e.a().c(a2);
                        try {
                            if (bVar == null) {
                                com.baidu.adp.lib.util.b.a();
                                Bitmap a3 = com.baidu.tbadk.core.util.g.a(com.baidu.tbadk.core.util.av.a().a(com.baidu.adp.lib.util.b.a(a2), true), 10.0f, true);
                                if (a3 != null) {
                                    bVar = new com.baidu.adp.widget.ImageView.b(a3, false);
                                    if (aVar.B() <= 0) {
                                        aVar.f(bVar.c());
                                        aVar.h(bVar.d());
                                    }
                                    com.baidu.tbadk.imageManager.e.a().c(a2, bVar);
                                } else {
                                    bVar = null;
                                }
                            } else if (aVar.B() <= 0) {
                                aVar.f(bVar.c());
                                aVar.h(bVar.d());
                            }
                        } catch (Exception e) {
                            e = e;
                            com.baidu.adp.lib.util.f.a("codec", "showPic", e);
                            if (aVar.B() <= 0) {
                                split = optString.split(",");
                                if (split.length > 0) {
                                }
                                if (split.length > 1) {
                                }
                            }
                            LocalViewSize.a();
                            LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), aVar.C(), aVar.B());
                            com.baidu.tbadk.core.util.av.a();
                            com.baidu.tbadk.core.util.resourceLoader.b a5 = com.baidu.tbadk.core.util.av.a(a4.width, a4.height, true);
                            a4.height = a5.c;
                            a4.width = a5.b;
                            ViewGroup.LayoutParams layoutParams = bDImageView2.getLayoutParams();
                            layoutParams.height = a4.height + com.baidu.adp.lib.util.i.a(context, 16.0f);
                            layoutParams.width = a4.width + com.baidu.adp.lib.util.i.a(context, 24.0f);
                            bDImageView2.setLayoutParams(layoutParams);
                            if (bVar == null) {
                            }
                            bDImageView2.setVisibility(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bVar = null;
                    }
                }
                if (aVar.B() <= 0 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        aVar.f(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        aVar.h(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a42 = LocalViewSize.a().a(LocalViewSize.a().c(), aVar.C(), aVar.B());
                com.baidu.tbadk.core.util.av.a();
                com.baidu.tbadk.core.util.resourceLoader.b a52 = com.baidu.tbadk.core.util.av.a(a42.width, a42.height, true);
                a42.height = a52.c;
                a42.width = a52.b;
                ViewGroup.LayoutParams layoutParams2 = bDImageView2.getLayoutParams();
                layoutParams2.height = a42.height + com.baidu.adp.lib.util.i.a(context, 16.0f);
                layoutParams2.width = a42.width + com.baidu.adp.lib.util.i.a(context, 24.0f);
                bDImageView2.setLayoutParams(layoutParams2);
                if (bVar == null) {
                    bDImageView2.a();
                    bVar.a(bDImageView2);
                } else {
                    bDImageView2.setImageBitmap(null);
                    bDImageView2.setDefaultResource(com.baidu.tieba.im.g.image_h_not);
                    bDImageView2.setTag(a2);
                }
                bDImageView2.setVisibility(0);
            } catch (Exception e3) {
                com.baidu.adp.lib.util.f.b(str, "showPic", "error:" + e3.getMessage());
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, View view, Invite2GroupView invite2GroupView, com.baidu.tieba.im.message.a.a aVar, String str) {
        if (aVar.v() != null && aVar.v().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(aVar.v());
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
                    com.baidu.tbadk.editortool.aa aaVar = new com.baidu.tbadk.editortool.aa(context);
                    aaVar.a(true);
                    aaVar.a(string, true, (com.baidu.tbadk.imageManager.d) new dj(view), true);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(str, "showPic", "error:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void a(ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.a.a aVar, String str) {
        if (aVar.v() != null && aVar.v().length() > 0) {
            try {
                MsgCacheData z = aVar.z();
                if (z == null) {
                    z = new MsgCacheData();
                    z.setVoice_status(1);
                    aVar.a(z);
                } else if (z.getVoice_status() == 0) {
                    z.setVoice_status(1);
                }
                VoiceMsgData f = com.baidu.tieba.im.f.q.f(aVar);
                if (f != null && f.getDuring_time() != 0.0f && z.getVoice_model() == null) {
                    z.setVoice_model(new VoiceData.VoiceModel());
                    z.getVoice_model().voiceId = f.getVoice_md5();
                    z.getVoice_model().duration = Math.round(f.getDuring_time());
                }
                chatVoiceView.setData(aVar);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(str, "showVoice", "error:" + e.getMessage());
                return;
            }
        }
        com.baidu.adp.lib.util.f.b(str, "showVoice", "msg content is null");
    }

    public static void a(Context context, GifView gifView, com.baidu.tieba.im.message.a.a aVar, com.baidu.tbadk.editortool.aa aaVar, boolean z) {
        String str;
        String str2;
        gifView.setVisibility(0);
        float f = context.getResources().getDisplayMetrics().density;
        int i = ((double) f) > 1.5d ? 240 : 160;
        int i2 = ((double) f) > 1.5d ? 240 : 160;
        String v = aVar.v();
        JSONObject jSONObject = null;
        try {
            JSONArray jSONArray = new JSONArray(v);
            if (jSONArray.length() > 0) {
                jSONObject = jSONArray.getJSONObject(0);
            }
        } catch (JSONException e) {
            try {
                jSONObject = new JSONObject(v);
            } catch (JSONException e2) {
                gifView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
                gifView.setGif(null);
                aVar.b(false);
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
            if (!aVar.D()) {
                gifView.setGif(null);
            } else if (z) {
                boolean z2 = true;
                if (com.baidu.tbadk.editortool.aa.b()) {
                    str2 = optString3;
                } else {
                    z2 = false;
                    str2 = optString2;
                }
                dl dlVar = new dl(gifView, optString, aVar, optString3, aaVar, optString4, optString2);
                gifView.setTag(optString);
                com.baidu.adp.widget.ImageView.b b = b(aaVar, optString4, optString, str2, z2, dlVar);
                if (b != null) {
                    gifView.setGif(b);
                    gifView.setIsLoading(false);
                    aVar.b(true);
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
                dm dmVar = new dm(gifView, optString, aVar, optString3, aaVar, optString4, optString2);
                gifView.setTag(optString);
                com.baidu.adp.widget.ImageView.b b2 = b(aaVar, optString4, optString, str, z3, dmVar);
                if (b2 != null) {
                    gifView.setGif(b2);
                    gifView.setIsLoading(false);
                    aVar.b(true);
                    return;
                }
                gifView.setIsLoading(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.adp.widget.ImageView.b b(com.baidu.tbadk.editortool.aa aaVar, String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return aaVar.a(str, str2, str3, z, dVar);
    }
}
