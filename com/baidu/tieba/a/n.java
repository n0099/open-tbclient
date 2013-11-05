package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.s;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.w;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1002a = com.baidu.tieba.data.h.f1165a + "c/c/thread/add";
    private static final String b = com.baidu.tieba.data.h.f1165a + "c/c/post/add";
    private static final String c = com.baidu.tieba.data.h.f1165a + "c/c/img/upload";
    private ag d = null;
    private s e;

    public n() {
        this.e = null;
        this.e = new s();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        if (r11.d.c() != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(WriteData writeData, boolean z) {
        String b2;
        com.baidu.tieba.data.e eVar;
        com.baidu.tieba.data.e a2;
        String str = null;
        if (writeData != null) {
            if (z) {
                try {
                    File d = w.d("tieba_resized_image");
                    this.d = new ag(c);
                    if (d.length() <= 102400 || (com.baidu.tieba.data.h.n() == 0 && this.d.f() != null && !this.d.f().equals("2"))) {
                        be.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                        b2 = this.d.b("tieba_resized_image");
                    } else {
                        be.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String a3 = bc.a(w.a(d));
                        com.baidu.tieba.data.e o = DatabaseService.o(a3);
                        if (o == null) {
                            be.e("PostThreadTask", "doInBackground", "upload data is null");
                            com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                            eVar2.a(a3);
                            eVar2.a(0);
                            eVar2.a(d.length());
                            eVar = eVar2;
                        } else {
                            eVar = o;
                        }
                        if (new com.baidu.tieba.util.f("tieba_resized_image", eVar, com.baidu.tieba.data.h.f1165a + "c/c/img/chunkupload").b().b()) {
                            this.d = new ag(com.baidu.tieba.data.h.f1165a + "c/c/img/finupload");
                            this.d.a("md5", eVar.a());
                            this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                            b2 = this.d.j();
                            if (b2 == null || !this.d.c()) {
                                long b3 = eVar.b();
                                eVar.a((int) (b3 % 102400 == 0 ? b3 / 102400 : (b3 / 102400) + 1));
                                DatabaseService.a(eVar);
                            } else {
                                DatabaseService.n(a3);
                                JSONObject jSONObject = new JSONObject(b2);
                                InfoData infoData = new InfoData();
                                infoData.parserJson(jSONObject.optJSONObject("info"));
                                writeData.setBitmapId(infoData);
                            }
                        }
                    }
                } catch (Exception e) {
                    be.b(getClass().getName(), "doInBackground", e.getMessage());
                }
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (voice != null) {
                com.baidu.tieba.data.f a4 = new a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.voice.a.e.a(voice));
                if (a4 != null && a4.b() && (a2 = a4.a()) != null) {
                    str = a2.a();
                    com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str);
                }
            }
            this.d = new ag();
            this.d.e(true);
            this.d.a("anonymous", SocialConstants.TRUE);
            this.d.a("fid", writeData.getForumId());
            if (str != null) {
                this.d.a("voice_md5", str);
                this.d.a("during_time", String.valueOf(voiceDuringTime));
            }
            String str2 = "";
            if (writeData.getBitmapId() != null && writeData.getBitmapId().getPic_id() != null && writeData.getBitmapId().getPic_id().length() > 0) {
                str2 = String.format("#(pic,%s,%d,%d)", writeData.getBitmapId().getPic_id(), Integer.valueOf(writeData.getBitmapId().getWidth()), Integer.valueOf(writeData.getBitmapId().getHeight()));
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.d.a("vcode", writeData.getVcode());
            }
            if (TiebaApplication.g().av() < 3) {
                this.d.a("vcode_tag", "11");
            }
            Address aP = TiebaApplication.g().aP();
            this.d.a("new_vcode", SocialConstants.TRUE);
            this.d.a("content", writeData.getContent() + str2);
            switch (writeData.getType()) {
                case 0:
                    this.d.a(f1002a);
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("title", writeData.getTitle());
                    if (aP != null && TiebaApplication.g().t() && !com.baidu.tieba.data.h.h().equals(writeData.getForumId())) {
                        this.d.a("lbs", String.valueOf(aP.getLatitude()) + "," + String.valueOf(aP.getLongitude()));
                        break;
                    }
                    break;
                case 1:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("is_ad", writeData.getIsAd() ? SocialConstants.TRUE : SocialConstants.FALSE);
                    break;
                case 2:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("quote_id", String.valueOf(writeData.getFloor()));
                    this.d.a("floor_num", String.valueOf(writeData.getFloorNum()));
                    this.d.a("is_ad", writeData.getIsAd() ? SocialConstants.TRUE : SocialConstants.FALSE);
                    break;
            }
            str = this.d.j();
            if (this.d.c()) {
                this.e.b(str);
            } else {
                this.e.a(this.d.e());
                this.e.a(this.d.g());
            }
        }
        return str;
    }

    public boolean a() {
        if (this.d == null) {
            return false;
        }
        return this.d.c();
    }

    public int b() {
        if (this.d == null) {
            return -1;
        }
        return this.d.e();
    }

    public String c() {
        if (this.d == null) {
            return null;
        }
        return this.d.g();
    }

    public void d() {
        if (this.d != null) {
            this.d.h();
        }
    }
}
