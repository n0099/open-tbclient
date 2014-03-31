package com.baidu.tieba.b;

import android.location.Address;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.a.k;
import com.baidu.tieba.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    private static final String a = String.valueOf(n.a) + "c/c/thread/add";
    private static final String b = String.valueOf(n.a) + "c/c/post/add";
    private ak c = null;
    private ErrorData d;
    private AntiData e;
    private h f;

    public d() {
        this.d = null;
        this.d = new ErrorData();
    }

    public final String a(WriteData writeData, boolean z) {
        String str = null;
        if (writeData == null) {
            return null;
        }
        if (z && writeData.isHasImages()) {
            if (this.f == null) {
                this.f = new h("HTTPWriteService.postWriteData");
            }
            this.f.a(writeData.getWriteImagesInfo());
        }
        String voice = writeData.getVoice();
        int voiceDuringTime = writeData.getVoiceDuringTime();
        if (voice != null) {
            com.baidu.tbadk.coreExtra.service.b bVar = new com.baidu.tbadk.coreExtra.service.b("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload");
            String a2 = w.a(voice, 1);
            com.baidu.tbadk.coreExtra.data.c a3 = bVar.a(a2);
            if (a3 != null && a3.b()) {
                com.baidu.tbadk.coreExtra.data.b a4 = a3.a();
                if (a4 != null) {
                    str = a4.a();
                    com.baidu.tbadk.core.voice.cache.e.a(writeData.getVoice(), str);
                } else {
                    v vVar = new v();
                    vVar.a("ErrCode", Integer.valueOf(a3.c()));
                    vVar.a("ErrMsg", a3.d());
                    TiebaStatic.b("", -1113, "audioUploadData is null", vVar.toString());
                    return null;
                }
            } else {
                v vVar2 = new v();
                vVar2.a("audioFile", a2);
                TiebaStatic.b("", -1113, "uploadService.upload null or fail", vVar2.toString());
                return null;
            }
        }
        this.c = new ak();
        this.c.a().a().a = true;
        this.c.a("anonymous", "1");
        this.c.a("fid", writeData.getForumId());
        if (str != null) {
            this.c.a("voice_md5", str);
            this.c.a("during_time", String.valueOf(voiceDuringTime));
        }
        String imagesCodeForPost = writeData.getImagesCodeForPost();
        if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
            this.c.a("vcode", writeData.getVcode());
        }
        if (r.c().x() < 3) {
            this.c.a("vcode_tag", "11");
        }
        Address b2 = com.baidu.adp.lib.c.a.a().b(false);
        this.c.a("new_vcode", "1");
        this.c.a("content", String.valueOf(writeData.getContent()) + imagesCodeForPost);
        switch (writeData.getType()) {
            case 0:
                this.c.a(a);
                this.c.a("kw", writeData.getForumName());
                this.c.a("title", writeData.getTitle());
                this.c.a("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                if (writeData.isNoTitle()) {
                    this.c.a("st_type", "notitle");
                }
                if (b2 != null && r.c().j() && !n.y().equals(writeData.getForumId())) {
                    this.c.a("lbs", String.valueOf(String.valueOf(b2.getLatitude())) + "," + String.valueOf(b2.getLongitude()));
                    break;
                }
                break;
            case 1:
                this.c.a(b);
                this.c.a("tid", writeData.getThreadId());
                this.c.a("kw", writeData.getForumName());
                this.c.a("is_ad", writeData.getIsAd() ? "1" : "0");
                break;
            case 2:
                this.c.a(b);
                this.c.a("tid", writeData.getThreadId());
                this.c.a("kw", writeData.getForumName());
                this.c.a("quote_id", String.valueOf(writeData.getFloor()));
                this.c.a("floor_num", String.valueOf(writeData.getFloorNum()));
                this.c.a("is_ad", writeData.getIsAd() ? "1" : "0");
                this.c.a("is_addition", writeData.isAddition() ? "1" : "0");
                if (writeData.isAddition()) {
                    this.c.a("st_type", "conadd");
                    break;
                }
                break;
        }
        String i = this.c.i();
        if (this.c.a().b().b()) {
            this.d.parserJson(i);
        } else {
            this.d.setError_code(this.c.c() ? this.c.d() : this.c.e());
            this.d.setError_msg(this.c.f());
        }
        if (this.d.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(writeData.getContent()) + imagesCodeForPost)) {
            ErrorData errorData = this.d;
            r.c();
            errorData.setError_msg(r.d().getString(k.img_upload_error));
        }
        try {
            this.e = new AntiData();
            this.e.parserJson(new JSONObject(i).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return i;
    }

    public final boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.a().b().b();
    }

    public final void b() {
        if (this.c != null) {
            this.c.g();
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    public final AntiData c() {
        return this.e;
    }

    public final ErrorData d() {
        return this.d;
    }
}
