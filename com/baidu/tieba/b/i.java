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
public final class i {
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

    public final String a(WriteData writeData, boolean z) {
        ba baVar;
        String str;
        String str2;
        String str3 = null;
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
                    str3 = a4.a();
                    com.baidu.tieba.voice.a.e.a(writeData.getVoice(), str3);
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
        if (str3 != null) {
            this.c.a("voice_md5", str3);
            this.c.a("during_time", String.valueOf(voiceDuringTime));
        }
        String imagesCodeForPost = writeData.getImagesCodeForPost();
        if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
            this.c.a("vcode", writeData.getVcode());
        }
        if (TiebaApplication.g().ah() < 3) {
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
                if (b2 != null && TiebaApplication.g().o() && !com.baidu.tieba.data.i.s().equals(writeData.getForumId())) {
                    baVar = this.c;
                    str = "lbs";
                    str2 = String.valueOf(String.valueOf(b2.getLatitude())) + "," + String.valueOf(b2.getLongitude());
                    baVar.a(str, str2);
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
                baVar = this.c;
                str = "is_ad";
                str2 = writeData.getIsAd() ? SocialConstants.TRUE : SocialConstants.FALSE;
                baVar.a(str, str2);
                break;
        }
        String l = this.c.l();
        if (this.c.c()) {
            this.d.parserJson(l);
        } else {
            this.d.setError_code(this.c.d() ? this.c.e() : this.c.f());
            this.d.setError_msg(this.c.i());
        }
        if (this.d.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(writeData.getContent()) + imagesCodeForPost)) {
            this.d.setError_msg(TiebaApplication.g().b().getString(R.string.img_upload_error));
        }
        try {
            this.e = new AntiData();
            this.e.parserJson(new JSONObject(l).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return l;
    }

    public final boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.c();
    }

    public final void b() {
        if (this.c != null) {
            this.c.j();
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
