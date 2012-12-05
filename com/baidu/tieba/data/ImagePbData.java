package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.TiebaLog;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImagePbData {
    private AntiData antiData;
    private long fid;
    private String forum;
    private LinkedList<ImageData> imageInfos;
    private int imageNumber;
    private Context mContext;
    private String nextTid;
    private String nextTitle;
    private String tid;
    private String title;

    public ImagePbData(Context context) {
        this.forum = null;
        this.fid = 0L;
        this.imageNumber = 0;
        this.antiData = null;
        this.mContext = null;
        this.imageInfos = null;
        this.nextTid = null;
        this.nextTitle = null;
        this.tid = null;
        this.title = null;
        this.mContext = context;
        this.imageInfos = new LinkedList<>();
        this.antiData = new AntiData();
    }

    public boolean hasNext() {
        return (this.nextTid == null || this.nextTid.length() == 0 || this.nextTitle == null || this.nextTitle.length() == 0) ? false : true;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTitle() {
        return this.title;
    }

    public AntiData getAntiData() {
        return this.antiData;
    }

    public String getNextTid() {
        return this.nextTid;
    }

    public String getNextTitle() {
        return this.nextTitle;
    }

    public ImagePbData() {
        this.forum = null;
        this.fid = 0L;
        this.imageNumber = 0;
        this.antiData = null;
        this.mContext = null;
        this.imageInfos = null;
        this.nextTid = null;
        this.nextTitle = null;
        this.tid = null;
        this.title = null;
        this.imageInfos = new LinkedList<>();
        this.antiData = new AntiData();
    }

    public void paserJson(String jsonString, boolean isNext) {
        try {
            JSONObject json = new JSONObject(jsonString);
            paserJson(json, Boolean.valueOf(isNext));
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "paserJson", e.toString());
        }
    }

    public LinkedList<ImageData> getImageInfo() {
        return this.imageInfos;
    }

    public String getForum() {
        return this.forum;
    }

    public long getFid() {
        return this.fid;
    }

    public int getImageNum() {
        return this.imageNumber;
    }

    public String getLastPicID() {
        return this.imageInfos.size() > 0 ? this.imageInfos.get(this.imageInfos.size() - 1).getImageID() : "";
    }

    public void paserJson(JSONObject json, Boolean isNext) {
        if (json != null) {
            try {
                JSONObject forumJson = json.optJSONObject("forum");
                if (forumJson != null) {
                    this.forum = forumJson.getString(PersonInfoActivity.TAG_NAME);
                    this.fid = forumJson.optLong("id");
                }
                this.imageNumber = json.optInt("pic_amount", 0);
                JSONArray picJosn = json.getJSONArray("pic_list");
                if (isNext.booleanValue()) {
                    for (int i = 0; i < picJosn.length(); i++) {
                        ImageData tempData = new ImageData(this.mContext);
                        tempData.paserJson(picJosn.getJSONObject(i));
                        int index = tempData.getIndex();
                        if (index >= 1 && index <= this.imageNumber) {
                            this.imageInfos.addLast(tempData);
                        }
                    }
                } else {
                    for (int i2 = picJosn.length() - 1; i2 >= 0; i2--) {
                        ImageData tempData2 = new ImageData(this.mContext);
                        tempData2.paserJson(picJosn.getJSONObject(i2));
                        int index2 = tempData2.getIndex();
                        if (index2 >= 1 && index2 <= this.imageNumber) {
                            this.imageInfos.addFirst(tempData2);
                        }
                    }
                }
                JSONArray albumlList = json.getJSONArray("album_list");
                JSONObject album = albumlList.getJSONObject(0);
                this.nextTid = album.optString("tid");
                this.nextTitle = album.optString("title");
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "paserJson", e.toString());
            }
        }
    }
}
