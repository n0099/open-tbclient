package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends com.baidu.tbadk.core.util.a implements com.baidu.tbadk.core.util.at {
    private int AB;
    private ArrayList<MediaData> Ax;
    private boolean akA;
    private SpannableString aku;
    private long akv;
    private String akw;
    private int akx;
    private LinkedList<IconData> akz;
    private String forum_id;
    private String forum_name;
    private int is_good;
    private int is_top;
    private LinkedList<IconData> mTShowIconInfo;
    private int reply_num;
    private String tid;
    private String user_id;
    private String user_name;
    private ArrayList<VoiceData.VoiceModel> Ay = new ArrayList<>();
    private final int aky = 0;
    private LiveCardData mLiveCardData = new LiveCardData();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.forum_id = jSONObject.optString("forum_id", "");
                this.forum_name = jSONObject.optString("forum_name", "");
                this.tid = jSONObject.optString("thread_id", "");
                String optString = jSONObject.optString("title", "");
                this.reply_num = jSONObject.optInt("post_num", 0);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.user_id = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID, "");
                this.user_name = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, "");
                this.akx = jSONObject.optInt("is_up", 0);
                this.akv = jSONObject.optLong("create_time", 0L);
                this.AB = jSONObject.optInt("is_voice_thread");
                JSONObject optJSONObject = jSONObject.optJSONObject("userinfo");
                JSONArray optJSONArray = optJSONObject.optJSONArray("iconinfo");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("tshow_icon");
                if (optJSONArray != null) {
                    if (this.akz == null) {
                        this.akz = new LinkedList<>();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        IconData iconData = new IconData();
                        iconData.parserJson(optJSONArray.getJSONObject(i));
                        this.akz.add(iconData);
                    }
                }
                if (optJSONArray2 != null) {
                    if (this.mTShowIconInfo == null) {
                        this.mTShowIconInfo = new LinkedList<>();
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        IconData iconData2 = new IconData();
                        iconData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mTShowIconInfo.add(iconData2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("abstract");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == 0) {
                            sb.append(jSONObject2.optString("text", ""));
                        }
                    }
                }
                this.akw = sb.toString();
                JSONArray optJSONArray4 = jSONObject.optJSONArray("media");
                if (optJSONArray4 != null) {
                    if (this.Ax == null) {
                        this.Ax = new ArrayList<>();
                    }
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray4.getJSONObject(i4));
                        if (mediaData.getPicUrl() != null && mediaData.getPicUrl().length() > 0) {
                            this.Ax.add(mediaData);
                        }
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray5.getJSONObject(i5);
                        voiceModel.from = "home_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.Ay.add(voiceModel);
                    }
                }
                er(optString);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject2 == null) {
                    this.akA = false;
                    return;
                }
                this.akA = true;
                this.mLiveCardData.setPortrait(optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                this.mLiveCardData.setName(optJSONObject2.optString("name"));
                this.mLiveCardData.setStartTime(optJSONObject2.optLong("start_time"));
                this.mLiveCardData.setAuthorId(optJSONObject2.optInt("author_id"));
                this.mLiveCardData.setAuthorName(optJSONObject2.optString("author_name"));
                this.mLiveCardData.setListeners(optJSONObject2.optInt("listeners"));
                this.mLiveCardData.setLikers(optJSONObject2.optInt("likers"));
                this.mLiveCardData.setGroupId(optJSONObject2.optInt("group_id"));
                this.mLiveCardData.setIntro(optJSONObject2.optString("intro"));
                this.mLiveCardData.setPublisherPortrait(optJSONObject2.optString("publisherPortrait"));
                this.mLiveCardData.setPublisherId(optJSONObject2.optInt(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID));
                this.mLiveCardData.setPublisherName(optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public void er(String str) {
        SpannableString spannableString;
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            if (this.AB == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + str);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap bl = com.baidu.tbadk.core.util.d.bl(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bl);
                    bitmapDrawable.setBounds(0, 0, bl.getWidth(), bl.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(str);
            }
            this.aku = spannableString;
        }
    }

    public String getForumId() {
        return this.forum_id;
    }

    public String getForumName() {
        return this.forum_name != null ? this.forum_name : "";
    }

    public String getTid() {
        return this.tid != null ? this.tid : "";
    }

    public SpannableString yZ() {
        return this.aku;
    }

    public int getReplyNum() {
        return this.reply_num;
    }

    public String getUserName() {
        return this.user_name != null ? this.user_name : "";
    }

    public long za() {
        return this.akv;
    }

    public String kB() {
        return this.akw != null ? this.akw : "";
    }

    public int getIsGood() {
        return this.is_good;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Ax;
    }

    public ArrayList<VoiceData.VoiceModel> getVoices() {
        return this.Ay;
    }

    public LinkedList<IconData> zb() {
        return this.akz;
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        if (this.Ax == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<MediaData> it = this.Ax.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaData next = it.next();
            i++;
            if (i > 3) {
                break;
            } else if (next.getType() == 3) {
                arrayList.add(next.getPicUrl());
            }
        }
        return arrayList;
    }

    public LiveCardData getLiveCardData() {
        return this.mLiveCardData;
    }

    public boolean zc() {
        return this.akA;
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<com.baidu.tbadk.core.util.as> getImages() {
        ArrayList<com.baidu.tbadk.core.util.as> arrayList = new ArrayList<>();
        Iterator<MediaData> it = this.Ax.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as();
            asVar.AI = it.next().getPicUrl();
            asVar.ER = 10;
            arrayList.add(asVar);
        }
        return arrayList;
    }
}
