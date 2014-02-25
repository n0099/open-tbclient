package com.baidu.tieba.b;

import android.location.Address;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.ae;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private static final String a = String.valueOf(com.baidu.tieba.data.i.a) + "c/c/thread/add";
    private static final String b = String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/add";
    private ba c = null;
    private ErrorData d;
    private AntiData e;
    private com.baidu.tieba.img.h f;

    public i() {
        this.d = null;
        this.d = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String str = null;
        if (writeData == null) {
            return null;
        }
        if (z && writeData.isHasImages()) {
            if (this.f == null) {
                this.f = new com.baidu.tieba.img.h("HTTPWriteService.postWriteData");
            }
            this.f.a(writeData.getWriteImagesInfo());
        }
        String voice = writeData.getVoice();
        int voiceDuringTime = writeData.getVoiceDuringTime();
        if (voice != null) {
            a aVar = new a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload");
            String a2 = af.a(voice, 1);
            com.baidu.tieba.data.g a3 = aVar.a(a2);
            if (a3 != null && a3.b()) {
                com.baidu.tieba.data.f a4 = a3.a();
                if (a4 != null) {
                    str = a4.a();
                    com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str);
                } else {
                    ae aeVar = new ae();
                    aeVar.a("ErrCode", Integer.valueOf(a3.c()));
                    aeVar.a("ErrMsg", a3.d());
                    cb.b("", -1113, "audioUploadData is null", aeVar.toString());
                    return null;
                }
            } else {
                ae aeVar2 = new ae();
                aeVar2.a("audioFile", a2);
                cb.b("", -1113, "uploadService.upload null or fail", aeVar2.toString());
                return null;
            }
        }
        this.c = new ba();
        this.c.e(true);
        this.c.a("anonymous", SocialConstants.TRUE);
        this.c.a("fid", writeData.getForumId());
        if (str != null) {
            this.c.a("voice_md5", str);
            this.c.a("during_time", String.valueOf(voiceDuringTime));
        }
        String imagesCodeForPost = writeData.getImagesCodeForPost();
        if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
            this.c.a("vcode", writeData.getVcode());
        }
        if (TiebaApplication.g().ao() < 3) {
            this.c.a("vcode_tag", "11");
        }
        Address b2 = com.baidu.adp.lib.c.a.a().b(false);
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
        switch (writeData.getType()) {
            case 0:
                this.c.a(a);
                this.c.a("kw", writeData.getForumName());
                this.c.a("title", writeData.getTitle());
                if (b2 != null && TiebaApplication.g().t() && !com.baidu.tieba.data.i.s().equals(writeData.getForumId())) {
                    this.c.a("lbs", String.valueOf(String.valueOf(b2.getLatitude())) + "," + String.valueOf(b2.getLongitude()));
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
        String m = this.c.m();
        if (this.c.d()) {
            this.d.parserJson(m);
        } else {
            this.d.setError_code(this.c.e() ? this.c.f() : this.c.g());
            this.d.setError_msg(this.c.j());
        }
        if (this.d.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(writeData.getContent()) + imagesCodeForPost)) {
            this.d.setError_msg(TiebaApplication.g().b().getString(R.string.img_upload_error));
        }
        try {
            this.e = new AntiData();
            this.e.parserJson(new JSONObject(m).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return m;
    }

    public boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.d();
    }

    public void b() {
        if (this.c != null) {
            this.c.k();
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    public AntiData c() {
        return this.e;
    }

    public ErrorData d() {
        return this.d;
    }
}
