package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.aj;
import com.baidu.tieba.write.ck;
import com.baidu.tieba.y;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static final String amH = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add";
    private static final String amI = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add";
    public static final String amJ = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/sdkshare";
    private h UV;
    private ErrorData amK;
    private AntiData amL;
    private ac yV = null;
    private boolean Vh = false;

    public c() {
        this.amK = null;
        this.amK = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.yV = new ac();
        this.yV.mc().na().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.yV.k("vcode", writeData.getVcode());
            }
            if (aj.wk().wG() < 3) {
                this.yV.k("tag", "11");
            }
            this.yV.k("newVcode", "1");
            this.yV.k("content", writeData.getContent());
            this.yV.setUrl(amJ);
            this.yV.k(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.yV.k("title", writeData.getTitle());
            this.yV.k("apiKey", writeData.getShareApiKey());
            this.yV.k("appName", writeData.getShareAppName());
            this.yV.k("signKey", writeData.getShareSignKey());
            this.yV.k("summary_title", writeData.getShareSummaryTitle());
            this.yV.k("summary_content", writeData.getShareSummaryContent());
            this.yV.k("summary_img", writeData.getShareSummaryImg());
            this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.yV.k("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.UV == null) {
                    this.UV = new h("HTTPWriteService.postWriteData");
                }
                this.UV.a(writeData.getWriteImagesInfo());
            }
            if (this.Vh) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.UV == null) {
                    this.UV = new h("HTTPWriteService.postWriteData");
                }
                this.UV.a(writeData.getBaobaoImagesInfo());
            }
            if (this.Vh) {
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
                String n = s.n(voice, 1);
                com.baidu.tbadk.coreExtra.data.c cH = bVar.cH(n);
                if (cH != null && cH.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b ox = cH.ox();
                    if (ox != null) {
                        returnVoiceMd5 = ox.ou();
                        com.baidu.tbadk.core.voice.a.b.P(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        r rVar = new r();
                        rVar.g("ErrCode", Integer.valueOf(cH.getErrorCode()));
                        rVar.g("ErrMsg", cH.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", rVar.toString());
                        return null;
                    }
                } else {
                    r rVar2 = new r();
                    rVar2.g("audioFile", n);
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", rVar2.toString());
                    return null;
                }
            }
            if (!this.Vh) {
                this.yV.k("anonymous", "1");
                this.yV.k(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.yV.k("voice_md5", returnVoiceMd5);
                    this.yV.k("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.yV.k("vcode", writeData.getVcode());
                }
                if (aj.wk().wG() < 3) {
                    this.yV.k("vcode_tag", "11");
                }
                Address address = com.baidu.adp.lib.d.a.dE().getAddress(false);
                this.yV.k("new_vcode", "1");
                this.yV.k("content", String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.yV.k("tail_type", String.valueOf(d.amM));
                    this.yV.k("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.yV.setUrl(amH);
                        this.yV.k("kw", writeData.getForumName());
                        this.yV.k("title", writeData.getTitle());
                        this.yV.k("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.yV.k("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.yV.k("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.yV.k("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (address != null && aj.wk().wu() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.yV.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
                        }
                        ck.a(this.yV, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.yV.setUrl(amI);
                        this.yV.k("tid", writeData.getThreadId());
                        this.yV.k("kw", writeData.getForumName());
                        this.yV.k("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.yV.k("st_param", "frs");
                        }
                        ck.a(this.yV, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.yV.setUrl(amI);
                        this.yV.k("tid", writeData.getThreadId());
                        this.yV.k("kw", writeData.getForumName());
                        this.yV.k("quote_id", String.valueOf(writeData.getFloor()));
                        this.yV.k(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.yV.k("repostid", writeData.getRepostId());
                        }
                        this.yV.k("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.yV.k(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.yV.k("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String lA = this.yV.lA();
        if (this.yV.mc().nb().jq()) {
            this.amK.parserJson(lA);
        } else {
            this.amK.setError_code(this.yV.mf() ? this.yV.mg() : this.yV.mh());
            this.amK.setError_msg(this.yV.getErrorString());
        }
        if (this.amK.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && l.aA(String.valueOf(writeData.getContent()) + str))) {
            this.amK.setError_msg(aj.wk().getApp().getString(y.img_upload_error));
        }
        try {
            this.amL = new AntiData();
            this.amL.parserJson(new JSONObject(lA).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return lA;
    }

    public boolean jq() {
        if (this.yV == null) {
            return false;
        }
        return this.yV.mc().nb().jq();
    }

    public void cancel() {
        this.Vh = true;
        if (this.yV != null) {
            this.yV.dM();
        }
        if (this.UV != null) {
            this.UV.cancel();
        }
    }

    public AntiData AE() {
        return this.amL;
    }

    public ErrorData AF() {
        return this.amK;
    }
}
