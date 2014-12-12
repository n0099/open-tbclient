package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AnchorInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.a;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.FriendFeedPage.FriendThreadInfo;
import tbclient.Media;
import tbclient.Voice;
/* loaded from: classes.dex */
public class FriendFeedThreadData extends a implements Serializable {
    private static final long serialVersionUID = -8881889728582490817L;
    private transient SpannableString EI;
    private String abstract_text;
    private String authorId;
    private String fid;
    private String first_post_id;
    private String fname;
    private String id;
    private int is_global_top;
    private int is_good;
    private int is_livepost;
    private int is_membertop;
    private int is_ntitle;
    private int is_top;
    private int is_voice_thread;
    private long last_time_int;
    private int reply_num;
    private String tid;
    private String timeline;
    private String title;
    private HashMap<String, MetaData> userMap;
    private ArrayList<MediaData> medias = new ArrayList<>();
    private ArrayList<VoiceData.VoiceModel> voices = new ArrayList<>();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private PraiseData praise = new PraiseData();
    private MetaData author = new MetaData();

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public SpannableString getSpan_str() {
        return this.EI;
    }

    public String getFname() {
        return this.fname;
    }

    public String getFid() {
        return this.fid;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getId() {
        return this.id;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTimeline() {
        return this.timeline;
    }

    public String getTitle() {
        return this.title;
    }

    public int getReply_num() {
        return this.reply_num;
    }

    public void setReply_num(int i) {
        this.reply_num = i;
    }

    public long getLast_time_int() {
        return this.last_time_int;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public int getIs_global_top() {
        return this.is_global_top;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public int getIs_livepost() {
        return this.is_livepost;
    }

    public int getIs_ntitle() {
        return this.is_ntitle;
    }

    public int getIs_membertop() {
        return this.is_membertop;
    }

    public String getFirst_post_id() {
        return this.first_post_id;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String getAbstract_text() {
        return this.abstract_text;
    }

    public ArrayList<MediaData> getMedias() {
        return this.medias;
    }

    public ArrayList<VoiceData.VoiceModel> getVoices() {
        return this.voices;
    }

    public PraiseData getPraise() {
        return this.praise;
    }

    public void setPraise(PraiseData praiseData) {
        this.praise = praiseData;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0009: IGET  (r2v0 java.lang.Long A[REMOVE]) = (r7v0 tbclient.FriendFeedPage.FriendThreadInfo) tbclient.FriendFeedPage.FriendThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x001a: IGET  (r2v1 java.lang.Long A[REMOVE]) = (r7v0 tbclient.FriendFeedPage.FriendThreadInfo) tbclient.FriendFeedPage.FriendThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0074: IGET  (r2v3 java.lang.Long A[REMOVE]) = (r7v0 tbclient.FriendFeedPage.FriendThreadInfo) tbclient.FriendFeedPage.FriendThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0089: IGET  (r2v4 java.lang.Long A[REMOVE]) = (r7v0 tbclient.FriendFeedPage.FriendThreadInfo) tbclient.FriendFeedPage.FriendThreadInfo.fid java.lang.Long)] */
    public void parserProtobuf(FriendThreadInfo friendThreadInfo) {
        MetaData metaData;
        if (friendThreadInfo != null) {
            try {
                this.id = new StringBuilder().append(friendThreadInfo.id).toString();
                this.tid = new StringBuilder().append(friendThreadInfo.tid).toString();
                this.timeline = friendThreadInfo.timeline;
                this.title = friendThreadInfo.title;
                this.reply_num = friendThreadInfo.reply_num.intValue();
                this.last_time_int = friendThreadInfo.last_time_int.intValue();
                this.is_top = friendThreadInfo.is_top.intValue();
                this.is_good = friendThreadInfo.is_good.intValue();
                this.is_voice_thread = friendThreadInfo.is_voice_thread.intValue();
                this.is_livepost = friendThreadInfo.is_livepost.intValue();
                this.is_ntitle = friendThreadInfo.is_ntitle.intValue();
                this.is_membertop = friendThreadInfo.is_membertop.intValue();
                this.first_post_id = new StringBuilder().append(friendThreadInfo.first_post_id).toString();
                this.fname = friendThreadInfo.fname;
                this.fid = new StringBuilder().append(friendThreadInfo.fid).toString();
                if (friendThreadInfo.author != null) {
                    this.author.parserProtobuf(friendThreadInfo.author);
                }
                this.authorId = friendThreadInfo.author_id.toString();
                if ((this.author == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                StringBuilder sb = new StringBuilder();
                List<Abstract> list = friendThreadInfo._abstract;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null) {
                            if (list.get(i).type.intValue() == 0) {
                                sb.append(list.get(i).text);
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.abstract_text = sb.toString();
                List<Media> list2 = friendThreadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.medias.add(mediaData);
                    }
                }
                List<Voice> list3 = friendThreadInfo.voice_info;
                if (list3 != null) {
                    int size = list3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        Voice voice = list3.get(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = voice.voice_md5;
                        voiceModel.duration = voice.during_time.intValue() / 1000;
                        this.voices.add(voiceModel);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(friendThreadInfo.zan);
                this.anchorInfoData.parserProtobuf(friendThreadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parser_title() {
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (this.is_livepost == 1) {
                arrayList.add(Integer.valueOf(v.icon_live));
            }
            if (getIs_good() == 1) {
                arrayList.add(Integer.valueOf(v.icon_elite));
            }
            if (this.is_voice_thread == 1) {
                arrayList.add(Integer.valueOf(v.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(v.icon_live_on));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.title);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap bX = ax.bX(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bX);
                    bitmapDrawable.setBounds(0, 0, bX.getWidth(), bX.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.EI = spannableString;
        }
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                arrayList.add(medias.get(i2).getPicUrl());
            }
            i = i2 + 1;
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getPhotoUrl() {
        if (this.author == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.author != null) {
            arrayList.add(this.author.getPortrait());
            return arrayList;
        }
        return arrayList;
    }
}
