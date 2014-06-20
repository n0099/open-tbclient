package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.ai;
import com.baidu.tieba.y;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add";
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add";
    private an c = null;
    private ErrorData d;
    private AntiData e;
    private h f;

    public d() {
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
                this.f = new h("HTTPWriteService.postWriteData");
            }
            this.f.a(writeData.getWriteImagesInfo());
        }
        String voice = writeData.getVoice();
        int voiceDuringTime = writeData.getVoiceDuringTime();
        if (voice != null) {
            com.baidu.tbadk.coreExtra.service.b bVar = new com.baidu.tbadk.coreExtra.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
            String a2 = x.a(voice, 1);
            com.baidu.tbadk.coreExtra.data.c a3 = bVar.a(a2);
            if (a3 != null && a3.b()) {
                com.baidu.tbadk.coreExtra.data.b a4 = a3.a();
                if (a4 != null) {
                    str = a4.a();
                    com.baidu.tbadk.core.voice.a.e.a(writeData.getVoice(), str);
                } else {
                    w wVar = new w();
                    wVar.a("ErrCode", Integer.valueOf(a3.c()));
                    wVar.a("ErrMsg", a3.d());
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", wVar.toString());
                    return null;
                }
            } else {
                w wVar2 = new w();
                wVar2.a("audioFile", a2);
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", wVar2.toString());
                return null;
            }
        }
        this.c = new an();
        this.c.a().a().a = true;
        this.c.a("anonymous", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("fid", writeData.getForumId());
        if (str != null) {
            this.c.a("voice_md5", str);
            this.c.a("during_time", String.valueOf(voiceDuringTime));
        }
        String imagesCodeForPost = writeData.getImagesCodeForPost();
        if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
            this.c.a("vcode", writeData.getVcode());
        }
        if (ai.c().z() < 3) {
            this.c.a("vcode_tag", "11");
        }
        Address b2 = com.baidu.adp.lib.c.a.a().b(false);
        this.c.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("content", String.valueOf(writeData.getContent()) + imagesCodeForPost);
        switch (writeData.getType()) {
            case 0:
                this.c.a(a);
                this.c.a("kw", writeData.getForumName());
                this.c.a("title", writeData.getTitle());
                this.c.a("is_ntitle", writeData.isNoTitle() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                if (writeData.isNoTitle()) {
                    this.c.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "notitle");
                }
                if (writeData.getLiveCardData() != null) {
                    this.c.a(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, String.valueOf(writeData.getLiveCardData().getGroupId()));
                    this.c.a("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                }
                if (b2 != null && ai.c().m() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                    this.c.a("lbs", String.valueOf(String.valueOf(b2.getLatitude())) + "," + String.valueOf(b2.getLongitude()));
                    break;
                }
                break;
            case 1:
                this.c.a(b);
                this.c.a("tid", writeData.getThreadId());
                this.c.a("kw", writeData.getForumName());
                this.c.a("is_ad", writeData.getIsAd() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                if (writeData.isFrsReply()) {
                    this.c.a("st_param", "frs");
                    break;
                }
                break;
            case 2:
                this.c.a(b);
                this.c.a("tid", writeData.getThreadId());
                this.c.a("kw", writeData.getForumName());
                this.c.a("quote_id", String.valueOf(writeData.getFloor()));
                this.c.a("floor_num", String.valueOf(writeData.getFloorNum()));
                this.c.a("is_ad", writeData.getIsAd() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                this.c.a("is_addition", writeData.isAddition() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                if (writeData.isAddition()) {
                    this.c.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "conadd");
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
        if (this.d.error_code != 0 && writeData.isHasImages() && j.b(String.valueOf(writeData.getContent()) + imagesCodeForPost)) {
            this.d.setError_msg(ai.c().d().getString(y.img_upload_error));
        }
        try {
            this.e = new AntiData();
            this.e.parserJson(new JSONObject(i).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return i;
    }

    public boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.a().b().b();
    }

    public void b() {
        if (this.c != null) {
            this.c.g();
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
