package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.r;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.p;
import com.baidu.tieba.util.z;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f873a = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/thread/add";
    private static final String b = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/add";
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/upload";
    private z d = null;
    private r e;

    public n() {
        this.e = null;
        this.e = new r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
        if (r11.d.c() != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(WriteData writeData, boolean z) {
        String b2;
        com.baidu.tieba.data.d dVar;
        com.baidu.tieba.data.d a2;
        String str = null;
        if (writeData != null) {
            if (z) {
                try {
                    File c2 = p.c("tieba_resized_image");
                    this.d = new z(c);
                    if (c2.length() <= 102400 || (com.baidu.tieba.data.g.n() == 0 && this.d.f() != null && !this.d.f().equals("2"))) {
                        av.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                        b2 = this.d.b("tieba_resized_image");
                    } else {
                        av.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String a3 = at.a(p.a(c2));
                        com.baidu.tieba.data.d o = DatabaseService.o(a3);
                        if (o == null) {
                            av.e("PostThreadTask", "doInBackground", "upload data is null");
                            com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                            dVar2.a(a3);
                            dVar2.a(0);
                            dVar2.a(c2.length());
                            dVar = dVar2;
                        } else {
                            dVar = o;
                        }
                        if (new com.baidu.tieba.util.f("tieba_resized_image", dVar, String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/chunkupload").b().b()) {
                            this.d = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/finupload");
                            this.d.a("md5", dVar.a());
                            this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                            b2 = this.d.j();
                            if (b2 == null || !this.d.c()) {
                                long b3 = dVar.b();
                                dVar.a((int) (b3 % 102400 == 0 ? b3 / 102400 : (b3 / 102400) + 1));
                                DatabaseService.a(dVar);
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
                    av.b(getClass().getName(), "doInBackground", e.getMessage());
                }
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (voice != null) {
                com.baidu.tieba.data.e a4 = new a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.voice.a.e.a(voice));
                if (a4 != null && a4.b() && (a2 = a4.a()) != null) {
                    str = a2.a();
                    com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str);
                }
            }
            this.d = new z();
            this.d.e(true);
            this.d.a("anonymous", "1");
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
            if (TiebaApplication.g().as() < 3) {
                this.d.a("vcode_tag", "11");
            }
            Address aK = TiebaApplication.g().aK();
            this.d.a("new_vcode", "1");
            this.d.a("content", String.valueOf(writeData.getContent()) + str2);
            switch (writeData.getType()) {
                case 0:
                    this.d.a(f873a);
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("title", writeData.getTitle());
                    if (aK != null && TiebaApplication.g().t() && !com.baidu.tieba.data.g.h().equals(writeData.getForumId())) {
                        this.d.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
                        break;
                    }
                    break;
                case 1:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("is_ad", writeData.getIsAd() ? "1" : "0");
                    break;
                case 2:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("quote_id", String.valueOf(writeData.getFloor()));
                    this.d.a("floor_num", String.valueOf(writeData.getFloorNum()));
                    this.d.a("is_ad", writeData.getIsAd() ? "1" : "0");
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
