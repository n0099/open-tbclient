package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.ai;
import com.baidu.tieba.x;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add";
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add";
    private ErrorData d;
    private AntiData f;
    private h g;
    private ae c = null;
    private boolean e = false;

    public d() {
        this.d = null;
        this.d = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        if (writeData == null) {
            return null;
        }
        if (z && writeData.isHasImages()) {
            if (this.g == null) {
                this.g = new h("HTTPWriteService.postWriteData");
            }
            this.g.a(writeData.getWriteImagesInfo());
        }
        if (this.e) {
            return null;
        }
        if (writeData.getIsBaobao()) {
            if (this.g == null) {
                this.g = new h("HTTPWriteService.postWriteData");
            }
            this.g.a(writeData.getBaobaoImagesInfo());
        }
        if (this.e) {
            return null;
        }
        String voice = writeData.getVoice();
        int voiceDuringTime = writeData.getVoiceDuringTime();
        if (writeData.getReturnVoiceMd5() == null) {
            z2 = false;
            returnVoiceMd5 = null;
        } else {
            returnVoiceMd5 = writeData.getReturnVoiceMd5();
            z2 = true;
        }
        if (voice != null && !z2) {
            com.baidu.tbadk.coreExtra.service.b bVar = new com.baidu.tbadk.coreExtra.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
            String a2 = s.a(voice, 1);
            com.baidu.tbadk.coreExtra.data.c a3 = bVar.a(a2);
            if (a3 != null && a3.b()) {
                com.baidu.tbadk.coreExtra.data.b a4 = a3.a();
                if (a4 != null) {
                    returnVoiceMd5 = a4.a();
                    com.baidu.tbadk.core.voice.a.b.a(writeData.getVoice(), returnVoiceMd5);
                    writeData.setReturnVoiceMd5(returnVoiceMd5);
                } else {
                    r rVar = new r();
                    rVar.a("ErrCode", Integer.valueOf(a3.c()));
                    rVar.a("ErrMsg", a3.d());
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", rVar.toString());
                    return null;
                }
            } else {
                r rVar2 = new r();
                rVar2.a("audioFile", a2);
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", rVar2.toString());
                return null;
            }
        }
        if (this.e) {
            return null;
        }
        this.c = new ae();
        this.c.a().a().a = true;
        this.c.a("anonymous", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("fid", writeData.getForumId());
        if (returnVoiceMd5 != null) {
            this.c.a("voice_md5", returnVoiceMd5);
            this.c.a("during_time", String.valueOf(voiceDuringTime));
        }
        String imagesCodeForPost = writeData.getImagesCodeForPost();
        if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
            this.c.a("vcode", writeData.getVcode());
        }
        if (ai.c().y() < 3) {
            this.c.a("vcode_tag", "11");
        }
        Address b2 = com.baidu.adp.lib.c.a.a().b(false);
        this.c.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("content", String.valueOf(writeData.getContent()) + imagesCodeForPost);
        if (writeData.getIsBaobaoImageUploaded()) {
            this.c.a("tail_type", String.valueOf(e.a));
            this.c.a("tail_content", writeData.getBaobaoContent());
            writeData.setBabaoPosted(true);
        } else {
            writeData.setBabaoPosted(false);
        }
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
        String h = this.c.h();
        if (this.c.a().b().b()) {
            this.d.parserJson(h);
        } else {
            this.d.setError_code(this.c.b() ? this.c.c() : this.c.d());
            this.d.setError_msg(this.c.e());
        }
        if (this.d.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && i.c(String.valueOf(writeData.getContent()) + imagesCodeForPost))) {
            this.d.setError_msg(ai.c().d().getString(x.img_upload_error));
        }
        try {
            this.f = new AntiData();
            this.f.parserJson(new JSONObject(h).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return h;
    }

    public boolean a() {
        if (this.c == null) {
            return false;
        }
        return this.c.a().b().b();
    }

    public void b() {
        this.e = true;
        if (this.c != null) {
            this.c.f();
        }
        if (this.g != null) {
            this.g.a();
        }
    }

    public AntiData c() {
        return this.f;
    }

    public ErrorData d() {
        return this.d;
    }
}
