package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public class ci {
    public static boolean a = com.baidu.tieba.util.i.b();

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, com.baidu.tieba.im.message.b bVar, String str) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (bVar != null) {
            MsgCacheData o = bVar.o();
            if (o == null) {
                o = com.baidu.tieba.im.d.d.e(bVar);
                bVar.a(o);
            }
            if (o.getRich_content() == null) {
                String k = bVar.k();
                if (k != null) {
                    if (k.length() > 1 && k.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(bVar.k()), 5);
                        } catch (Exception e) {
                            com.baidu.adp.lib.g.e.a("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar == null) {
                            aVar = new com.baidu.tbadk.widget.richText.a(context, af.a(context, bVar.k()));
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0087 A[Catch: Exception -> 0x0045, TryCatch #2 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x0100, B:29:0x0106, B:52:0x017b, B:43:0x0155), top: B:61:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[Catch: Exception -> 0x0045, TryCatch #2 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x0100, B:29:0x0106, B:52:0x017b, B:43:0x0155), top: B:61:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6 A[Catch: Exception -> 0x0045, TryCatch #2 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x0100, B:29:0x0106, B:52:0x017b, B:43:0x0155), top: B:61:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0100 A[Catch: Exception -> 0x0045, TryCatch #2 {Exception -> 0x0045, blocks: (B:7:0x0013, B:9:0x0028, B:13:0x0066, B:15:0x006e, B:16:0x0081, B:18:0x0087, B:20:0x008f, B:22:0x0098, B:23:0x00a3, B:25:0x00a6, B:26:0x00b1, B:28:0x0100, B:29:0x0106, B:52:0x017b, B:43:0x0155), top: B:61:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, View view, BDImageView2 bDImageView2, com.baidu.tieba.im.message.b bVar, long j, String str) {
        com.baidu.adp.widget.ImageView.d dVar;
        String optString;
        String[] split;
        com.baidu.adp.widget.ImageView.d dVar2 = null;
        if (bVar.k() != null && bVar.k().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(bVar.k()).getJSONObject(0);
                String a2 = com.baidu.tieba.im.d.d.a(jSONObject, false);
                if (a2 == null) {
                    com.baidu.adp.lib.g.e.b(str, "showPic", "invalid small pic in content:" + bVar.k());
                    return;
                }
                if (a2.startsWith("http")) {
                    com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(context);
                    iVar.d(true);
                    dVar = iVar.b(a2, true, new cj(view));
                } else {
                    try {
                        dVar = com.baidu.tbadk.imageManager.d.a().c(a2);
                        if (dVar == null) {
                            Bitmap a3 = com.baidu.tieba.util.n.a(com.baidu.tieba.util.bo.a().a(com.baidu.adp.lib.g.a.a().a(a2)), 10.0f);
                            if (a3 != null) {
                                dVar = new com.baidu.adp.widget.ImageView.d(a3, false);
                                try {
                                    if (bVar.q() < 1) {
                                        bVar.c(dVar.c());
                                        bVar.d(dVar.d());
                                    }
                                    com.baidu.tbadk.imageManager.d.a().b(a2, dVar);
                                } catch (Exception e) {
                                    dVar2 = dVar;
                                    e = e;
                                    com.baidu.adp.lib.g.e.a("codec", "showPic", e);
                                    dVar = dVar2;
                                    if (bVar.q() < 1) {
                                    }
                                    LocalViewSize.a();
                                    LocalViewSize.ImageSize a4 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.r(), bVar.q());
                                    com.baidu.tieba.util.a.c a5 = com.baidu.tieba.util.bo.a().a(a4.width, a4.height, true);
                                    a4.height = a5.c;
                                    a4.width = a5.b;
                                    ViewGroup.LayoutParams layoutParams = bDImageView2.getLayoutParams();
                                    layoutParams.height = a4.height + com.baidu.adp.lib.g.g.a(context, 16.0f);
                                    layoutParams.width = a4.width + com.baidu.adp.lib.g.g.a(context, 24.0f);
                                    bDImageView2.setLayoutParams(layoutParams);
                                    if (dVar != null) {
                                    }
                                    bDImageView2.setVisibility(0);
                                }
                            } else {
                                dVar = null;
                            }
                        } else {
                            try {
                                if (bVar.q() < 1) {
                                    bVar.c(dVar.c());
                                    bVar.d(dVar.d());
                                }
                            } catch (Exception e2) {
                                dVar2 = dVar;
                                e = e2;
                                com.baidu.adp.lib.g.e.a("codec", "showPic", e);
                                dVar = dVar2;
                                if (bVar.q() < 1) {
                                    split = optString.split(",");
                                    if (split.length > 0) {
                                    }
                                    if (split.length > 1) {
                                    }
                                }
                                LocalViewSize.a();
                                LocalViewSize.ImageSize a42 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.r(), bVar.q());
                                com.baidu.tieba.util.a.c a52 = com.baidu.tieba.util.bo.a().a(a42.width, a42.height, true);
                                a42.height = a52.c;
                                a42.width = a52.b;
                                ViewGroup.LayoutParams layoutParams2 = bDImageView2.getLayoutParams();
                                layoutParams2.height = a42.height + com.baidu.adp.lib.g.g.a(context, 16.0f);
                                layoutParams2.width = a42.width + com.baidu.adp.lib.g.g.a(context, 24.0f);
                                bDImageView2.setLayoutParams(layoutParams2);
                                if (dVar != null) {
                                }
                                bDImageView2.setVisibility(0);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (bVar.q() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        bVar.c(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        bVar.d(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a422 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.r(), bVar.q());
                com.baidu.tieba.util.a.c a522 = com.baidu.tieba.util.bo.a().a(a422.width, a422.height, true);
                a422.height = a522.c;
                a422.width = a522.b;
                ViewGroup.LayoutParams layoutParams22 = bDImageView2.getLayoutParams();
                layoutParams22.height = a422.height + com.baidu.adp.lib.g.g.a(context, 16.0f);
                layoutParams22.width = a422.width + com.baidu.adp.lib.g.g.a(context, 24.0f);
                bDImageView2.setLayoutParams(layoutParams22);
                if (dVar != null) {
                    bDImageView2.a();
                    dVar.a(bDImageView2);
                } else {
                    bDImageView2.setImageBitmap(null);
                    bDImageView2.setDefaultResource(R.drawable.image_h_not);
                    bDImageView2.setTag(a2);
                }
                bDImageView2.setVisibility(0);
            } catch (Exception e4) {
                com.baidu.adp.lib.g.e.b(str, "showPic", "error:" + e4.getMessage());
                e4.printStackTrace();
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
                    iVar.d(true);
                    iVar.a(string, true, (com.baidu.tbadk.imageManager.c) new cl(view), true);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(str, "showPic", "error:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.b bVar, String str) {
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
                VoiceMsgData f = com.baidu.tieba.im.d.d.f(bVar);
                if (f != null && f.getDuring_time() != 0.0f && o.getVoice_model() == null) {
                    o.setVoice_model(new VoiceManager.VoiceModel());
                    o.getVoice_model().voiceId = f.getVoice_md5();
                    o.getVoice_model().duration = Math.round(f.getDuring_time());
                }
                chatVoiceView.setData(bVar);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(str, "showVoice", "error:" + e.getMessage());
                return;
            }
        }
        com.baidu.adp.lib.g.e.b(str, "showVoice", "msg content is null");
    }

    public static void a(Context context, GifView gifView, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.util.i iVar, boolean z) {
        JSONObject jSONObject;
        gifView.setVisibility(0);
        float f = context.getResources().getDisplayMetrics().density;
        int i = ((double) f) > 1.5d ? 240 : 160;
        int i2 = ((double) f) <= 1.5d ? 160 : 240;
        String k = bVar.k();
        try {
            JSONArray jSONArray = new JSONArray(k);
            jSONObject = jSONArray.length() > 0 ? jSONArray.getJSONObject(0) : null;
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
                a(gifView, bVar, iVar, optString, optString4, optString2, optString3);
            } else {
                b(gifView, bVar, iVar, optString, optString4, optString2, optString3);
            }
        }
    }

    private static void a(GifView gifView, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.util.i iVar, String str, String str2, String str3, String str4) {
        boolean z;
        String str5;
        if (com.baidu.tieba.util.i.c()) {
            z = true;
            str5 = str4;
        } else {
            z = false;
            str5 = str3;
        }
        cn cnVar = new cn(gifView, str, bVar, str4, iVar, str2, str3);
        gifView.setTag(str);
        com.baidu.adp.widget.ImageView.d b = b(iVar, str2, str, str5, z, cnVar);
        if (b != null) {
            gifView.setGif(b);
            gifView.setIsLoading(false);
            bVar.b(true);
            return;
        }
        gifView.setIsLoading(true);
    }

    private static void b(GifView gifView, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.util.i iVar, String str, String str2, String str3, String str4) {
        boolean z;
        String str5;
        if (a) {
            z = true;
            str5 = str4;
        } else {
            z = false;
            str5 = str3;
        }
        co coVar = new co(gifView, str, bVar, str4, iVar, str2, str3);
        gifView.setTag(str);
        com.baidu.adp.widget.ImageView.d b = b(iVar, str2, str, str5, z, coVar);
        if (b != null) {
            gifView.setGif(b);
            gifView.setIsLoading(false);
            bVar.b(true);
            return;
        }
        gifView.setIsLoading(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.adp.widget.ImageView.d b(com.baidu.tieba.util.i iVar, String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.c cVar) {
        return iVar.a(str, str2, str3, z, cVar);
    }
}
