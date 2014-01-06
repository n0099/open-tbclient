package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.browser.explorer.share.BdSharer;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.util.n;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private static final String a = com.baidu.tieba.data.h.a + "c/c/thread/add";
    private static final String b = com.baidu.tieba.data.h.a + "c/c/post/add";
    private static final String c = com.baidu.tieba.data.h.a + "c/c/img/upload";
    private at d = null;
    private ErrorData e;
    private AntiData f;

    public i() {
        this.e = null;
        this.e = new ErrorData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r11.d.c() != false) goto L79;
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
                    File d = aa.d("tieba_resized_image");
                    this.d = new at(c);
                    if (d.length() <= BdSharer.IMAGE_MIN_SIZE_TO_SHARE || (com.baidu.tieba.data.h.q() == 0 && this.d.h() != null && !this.d.h().equals("2"))) {
                        bo.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                        b2 = this.d.b("tieba_resized_image");
                    } else {
                        bo.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String a3 = bm.a(aa.a(d));
                        com.baidu.tieba.data.e p = DatabaseService.p(a3);
                        if (p == null) {
                            bo.e("PostThreadTask", "doInBackground", "upload data is null");
                            com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                            eVar2.a(a3);
                            eVar2.a(0);
                            eVar2.a(d.length());
                            eVar = eVar2;
                        } else {
                            eVar = p;
                        }
                        if (new n("tieba_resized_image", eVar, com.baidu.tieba.data.h.a + "c/c/img/chunkupload").b().b()) {
                            this.d = new at(com.baidu.tieba.data.h.a + "c/c/img/finupload");
                            this.d.a("md5", eVar.a());
                            this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                            b2 = this.d.l();
                            if (b2 == null || !this.d.c()) {
                                long b3 = eVar.b();
                                eVar.a((int) (b3 % BdSharer.IMAGE_MIN_SIZE_TO_SHARE == 0 ? b3 / BdSharer.IMAGE_MIN_SIZE_TO_SHARE : (b3 / BdSharer.IMAGE_MIN_SIZE_TO_SHARE) + 1));
                                DatabaseService.a(eVar);
                            } else {
                                DatabaseService.o(a3);
                            }
                        }
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    InfoData infoData = new InfoData();
                    infoData.parserJson(jSONObject.optJSONObject("info"));
                    writeData.setBitmapId(infoData);
                } catch (Exception e) {
                    bo.b(getClass().getName(), "doInBackground", e.getMessage());
                }
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (voice != null) {
                com.baidu.tieba.data.f a4 = new a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(aa.a(voice, 1));
                if (a4 != null && a4.b() && (a2 = a4.a()) != null) {
                    str = a2.a();
                    com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str);
                }
            }
            this.d = new at();
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
            if (TiebaApplication.g().aq() < 3) {
                this.d.a("vcode_tag", "11");
            }
            Address aQ = TiebaApplication.g().aQ();
            this.d.a("new_vcode", SocialConstants.TRUE);
            this.d.a(PushConstants.EXTRA_CONTENT, writeData.getContent() + str2);
            switch (writeData.getType()) {
                case 0:
                    this.d.a(a);
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("title", writeData.getTitle());
                    if (aQ != null && TiebaApplication.g().t() && !com.baidu.tieba.data.h.h().equals(writeData.getForumId())) {
                        this.d.a("lbs", String.valueOf(aQ.getLatitude()) + "," + String.valueOf(aQ.getLongitude()));
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
            str = this.d.l();
            if (this.d.c()) {
                this.e.parserJson(str);
            } else {
                this.e.setError_code(this.d.e());
                this.e.setError_msg(this.d.i());
            }
            try {
                this.f = new AntiData();
                this.f.parserJson(new JSONObject(str).optJSONObject("anti_stat"));
            } catch (Exception e2) {
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
        return this.d.i();
    }

    public void d() {
        if (this.d != null) {
            this.d.j();
        }
    }

    public AntiData e() {
        return this.f;
    }
}
