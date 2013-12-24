package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ImageView.BDImageView2;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class co {
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, TbRichTextView tbRichTextView, com.baidu.tieba.im.message.b bVar, String str) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (bVar != null) {
            MsgCacheData n = bVar.n();
            if (n == null) {
                n = com.baidu.tieba.im.d.d.d(bVar);
                bVar.a(n);
            }
            if (n.getRich_content() == null) {
                String j = bVar.j();
                if (j != null) {
                    if (j.length() > 1 && j.charAt(0) == '[') {
                        try {
                            aVar = TbRichTextView.a(context, new JSONArray(bVar.j()), 5);
                        } catch (Exception e) {
                            com.baidu.adp.lib.h.e.a("JSONArray transform error" + e.getMessage());
                        }
                        if (aVar == null) {
                            aVar = new com.baidu.tbadk.widget.richText.a(context, p.a(context, bVar.j()));
                        }
                        n.setRich_content(aVar);
                    }
                    aVar = null;
                    if (aVar == null) {
                    }
                    n.setRich_content(aVar);
                } else {
                    return;
                }
            }
            tbRichTextView.setVisibility(0);
            tbRichTextView.setText(n.getRich_content());
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
    public static void a(Context context, View view, BDImageView2 bDImageView2, com.baidu.tieba.im.message.b bVar, long j, String str) {
        com.baidu.adp.widget.ImageView.e eVar;
        String optString;
        String[] split;
        com.baidu.adp.widget.ImageView.e eVar2 = null;
        if (bVar.j() != null && bVar.j().length() != 0) {
            try {
                JSONObject jSONObject = new JSONArray(bVar.j()).getJSONObject(0);
                String a = com.baidu.tieba.im.d.d.a(jSONObject, false);
                if (a == null) {
                    com.baidu.adp.lib.h.e.b(str, "showPic", "invalid small pic in content:" + bVar.j());
                    return;
                }
                if (a.startsWith("http")) {
                    com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(context);
                    iVar.d(true);
                    eVar = iVar.a(a, true, (com.baidu.tbadk.imageManager.c) new cp(view));
                } else {
                    try {
                        eVar = com.baidu.tbadk.imageManager.d.a().c(a);
                        if (eVar == null) {
                            Bitmap a2 = com.baidu.tieba.util.m.a(com.baidu.tieba.util.a.c.a(com.baidu.adp.lib.h.a.a().a(a)), 10.0f);
                            if (a2 != null) {
                                eVar = new com.baidu.adp.widget.ImageView.e(a2, false);
                                try {
                                    if (bVar.p() < 1) {
                                        bVar.c(eVar.a());
                                        bVar.d(eVar.b());
                                    }
                                    com.baidu.tbadk.imageManager.d.a().b(a, eVar);
                                } catch (Exception e) {
                                    eVar2 = eVar;
                                    e = e;
                                    com.baidu.adp.lib.h.e.a("codec", "showPic", e);
                                    eVar = eVar2;
                                    if (bVar.p() < 1) {
                                    }
                                    LocalViewSize.a();
                                    LocalViewSize.ImageSize a3 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.q(), bVar.p());
                                    com.baidu.tieba.util.a.b a4 = com.baidu.tieba.util.a.c.a(a3.width, a3.height, true);
                                    a3.height = a4.c;
                                    a3.width = a4.b;
                                    ViewGroup.LayoutParams layoutParams = bDImageView2.getLayoutParams();
                                    layoutParams.height = a3.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                                    layoutParams.width = a3.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
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
                                if (bVar.p() < 1) {
                                    bVar.c(eVar.a());
                                    bVar.d(eVar.b());
                                }
                            } catch (Exception e2) {
                                eVar2 = eVar;
                                e = e2;
                                com.baidu.adp.lib.h.e.a("codec", "showPic", e);
                                eVar = eVar2;
                                if (bVar.p() < 1) {
                                    split = optString.split(",");
                                    if (split.length > 0) {
                                    }
                                    if (split.length > 1) {
                                    }
                                }
                                LocalViewSize.a();
                                LocalViewSize.ImageSize a32 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.q(), bVar.p());
                                com.baidu.tieba.util.a.b a42 = com.baidu.tieba.util.a.c.a(a32.width, a32.height, true);
                                a32.height = a42.c;
                                a32.width = a42.b;
                                ViewGroup.LayoutParams layoutParams2 = bDImageView2.getLayoutParams();
                                layoutParams2.height = a32.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                                layoutParams2.width = a32.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
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
                if (bVar.p() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        bVar.c(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        bVar.d(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a322 = LocalViewSize.a().a(LocalViewSize.a().c(), bVar.q(), bVar.p());
                com.baidu.tieba.util.a.b a422 = com.baidu.tieba.util.a.c.a(a322.width, a322.height, true);
                a322.height = a422.c;
                a322.width = a422.b;
                ViewGroup.LayoutParams layoutParams22 = bDImageView2.getLayoutParams();
                layoutParams22.height = a322.height + com.baidu.adp.lib.h.g.a(context, 16.0f);
                layoutParams22.width = a322.width + com.baidu.adp.lib.h.g.a(context, 24.0f);
                bDImageView2.setLayoutParams(layoutParams22);
                if (eVar != null) {
                    bDImageView2.a();
                    eVar.a(bDImageView2);
                } else {
                    bDImageView2.setImageBitmap(null);
                    bDImageView2.setDefaultResource(R.drawable.image_h_not);
                    bDImageView2.setTag(a);
                }
                bDImageView2.setVisibility(0);
            } catch (Exception e4) {
                com.baidu.adp.lib.h.e.b(str, "showPic", "error:" + e4.getMessage());
                e4.printStackTrace();
            }
        }
    }

    public static void a(Context context, View view, Invite2GroupView invite2GroupView, com.baidu.tieba.im.message.b bVar, String str) {
        if (bVar.j() != null && bVar.j().length() != 0) {
            invite2GroupView.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(bVar.j());
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
                    iVar.a(string, true, (com.baidu.tbadk.imageManager.c) new cr(view));
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.b(str, "showPic", "error:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.b bVar, String str) {
        if (bVar.j() != null && bVar.j().length() > 0) {
            try {
                MsgCacheData n = bVar.n();
                if (n == null) {
                    n = new MsgCacheData();
                    n.setVoice_status(1);
                    bVar.a(n);
                } else if (n.getVoice_status() == 0) {
                    n.setVoice_status(1);
                }
                VoiceMsgData e = com.baidu.tieba.im.d.d.e(bVar);
                if (e != null && e.getDuring_time() != 0.0f && n.getVoice_model() == null) {
                    n.setVoice_model(new VoiceManager.VoiceModel());
                    n.getVoice_model().voiceId = e.getVoice_md5();
                    n.getVoice_model().duration = Math.round(e.getDuring_time());
                }
                chatVoiceView.setData(bVar);
                chatVoiceView.setVisibility(0);
                return;
            } catch (Exception e2) {
                com.baidu.adp.lib.h.e.b(str, "showVoice", "error:" + e2.getMessage());
                return;
            }
        }
        com.baidu.adp.lib.h.e.b(str, "showVoice", "msg:" + bVar.j());
    }
}
