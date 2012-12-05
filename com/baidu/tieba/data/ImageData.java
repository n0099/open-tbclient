package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.account.ReLoginShareActivity;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageData {
    private ArrayList<ContentData> content;
    private PostData imageDes;
    private Context mContext;
    private String imageID = null;
    private String imageUrl = null;
    private int width = 0;
    private int height = 0;
    private String commentID = null;
    private String commentNumber = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;

    public ImageData(Context context) {
        this.imageDes = null;
        this.content = null;
        this.mContext = null;
        this.mContext = context;
        this.imageDes = new PostData();
        this.content = new ArrayList<>();
    }

    public PostData getImageDescribe() {
        return this.imageDes;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.imageID;
    }

    public String getCommentID() {
        return this.commentID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getCommentNumber() {
        return this.commentNumber;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIndex() {
        return this.index;
    }

    public String getUserID() {
        return this.userID;
    }

    public void paserJson(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            paserJson(json);
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "paserJson", e.toString());
        }
    }

    public void paserJson(JSONObject json) {
        JSONObject medium;
        try {
            this.commentID = json.getString("post_id");
            this.userName = json.getString(ReLoginShareActivity.UNAME);
            this.userID = json.getString("user_id");
            this.commentNumber = json.getString("comment_amount");
            JSONObject image = json.optJSONObject("img");
            this.index = json.optInt("index", -1);
            if (image != null && (medium = image.optJSONObject("original")) != null) {
                this.imageID = medium.optString("id");
                this.imageUrl = medium.optString("url");
                this.width = medium.optInt("width", 0);
                this.height = medium.optInt("height", 0);
            }
            JSONArray cont = json.getJSONArray("descr");
            if (cont != null) {
                for (int i = 0; i < cont.length(); i++) {
                    ContentData tempContent = new ContentData();
                    tempContent.parserJson(cont.getJSONObject(i));
                    this.content.add(tempContent);
                }
            }
            this.imageDes.setContent(this.content);
            if (this.mContext != null) {
                this.imageDes.uniteContent(this.mContext);
            }
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "paserJson", e.toString());
        }
    }
}
