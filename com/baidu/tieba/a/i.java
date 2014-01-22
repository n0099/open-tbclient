package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.im.model.ag;
import com.baidu.tieba.util.ac;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.by;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private static final String a = com.baidu.tieba.data.h.a + "c/c/thread/add";
    private static final String b = com.baidu.tieba.data.h.a + "c/c/post/add";
    private ErrorData d;
    private AntiData f;
    private ax c = null;
    private boolean e = false;

    public i() {
        this.d = null;
        this.d = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String str;
        String str2 = null;
        if (writeData != null) {
            if (z) {
                writeData.setBitmapId(new ag(ad.c("tieba_resized_image"), 0, 0, 0, 0).a(this.e, "HTTPWriteService.postWriteData"));
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (voice != null) {
                a aVar = new a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload");
                String a2 = ad.a(voice, 1);
                com.baidu.tieba.data.f a3 = aVar.a(a2);
                if (a3 != null && a3.b()) {
                    com.baidu.tieba.data.e a4 = a3.a();
                    if (a4 != null) {
                        str = a4.a();
                        com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str);
                    } else {
                        ac acVar = new ac();
                        acVar.a("ErrCode", Integer.valueOf(a3.c()));
                        acVar.a("ErrMsg", a3.d());
                        by.b("", -1113, "audioUploadData is null", acVar.toString());
                    }
                } else {
                    ac acVar2 = new ac();
                    acVar2.a("audioFile", a2);
                    by.b("", -1113, "uploadService.upload null or fail", acVar2.toString());
                }
            } else {
                str = null;
            }
            this.c = new ax();
            this.c.e(true);
            this.c.a("anonymous", SocialConstants.TRUE);
            this.c.a("fid", writeData.getForumId());
            if (str != null) {
                this.c.a("voice_md5", str);
                this.c.a("during_time", String.valueOf(voiceDuringTime));
            }
            String str3 = "";
            if (writeData.getBitmapId() != null && writeData.getBitmapId().getPic_id() != null && writeData.getBitmapId().getPic_id().length() > 0) {
                str3 = String.format("#(pic,%s,%d,%d)", writeData.getBitmapId().getPic_id(), Integer.valueOf(writeData.getBitmapId().getWidth()), Integer.valueOf(writeData.getBitmapId().getHeight()));
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.c.a("vcode", writeData.getVcode());
            }
            if (TiebaApplication.h().ao() < 3) {
                this.c.a("vcode_tag", "11");
            }
            Address aO = TiebaApplication.h().aO();
            this.c.a("new_vcode", SocialConstants.TRUE);
            this.c.a(PushConstants.EXTRA_CONTENT, writeData.getContent() + str3);
            switch (writeData.getType()) {
                case 0:
                    this.c.a(a);
                    this.c.a("kw", writeData.getForumName());
                    this.c.a("title", writeData.getTitle());
                    if (aO != null && TiebaApplication.h().t() && !com.baidu.tieba.data.h.h().equals(writeData.getForumId())) {
                        this.c.a("lbs", String.valueOf(aO.getLatitude()) + "," + String.valueOf(aO.getLongitude()));
                        break;
                    }
                    break;
                case 1:
                    this.c.a(b);
                    this.c.a("tid", writeData.getThreadId());
                    this.c.a("kw", writeData.getForumName());
                    this.c.a("is_ad", writeData.getIsAd() ? SocialConstants.TRUE : SocialConstants.FALSE);
                    break;
                case 2:
                    this.c.a(b);
                    this.c.a("tid", writeData.getThreadId());
                    this.c.a("kw", writeData.getForumName());
                    this.c.a("quote_id", String.valueOf(writeData.getFloor()));
                    this.c.a("floor_num", String.valueOf(writeData.getFloorNum()));
                    this.c.a("is_ad", writeData.getIsAd() ? SocialConstants.TRUE : SocialConstants.FALSE);
                    break;
            }
            str2 = this.c.m();
            if (this.c.d()) {
                this.d.parserJson(str2);
            } else {
                this.d.setError_code(this.c.f());
                this.d.setError_msg(this.c.j());
            }
            try {
                this.f = new AntiData();
                this.f.parserJson(new JSONObject(str2).optJSONObject("anti_stat"));
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.d();
    }

    public int b() {
        if (this.c == null) {
            return -1;
        }
        return this.c.f();
    }

    public String c() {
        if (this.c == null) {
            return null;
        }
        return this.c.j();
    }

    public void d() {
        if (this.c != null) {
            this.c.k();
        }
        this.e = true;
    }

    public AntiData e() {
        return this.f;
    }
}
