package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageSubPbData {
    private AntiData anti;
    private int commentAmount;
    private int dataNum;
    private Context mContext;
    private ArrayList<PostData> mData;

    public ImageSubPbData() {
        this.dataNum = 0;
        this.commentAmount = 0;
        this.mContext = null;
        this.mData = null;
        this.mData = new ArrayList<>();
        this.anti = new AntiData();
    }

    public ImageSubPbData(Context mContext) {
        this.dataNum = 0;
        this.commentAmount = 0;
        this.mContext = null;
        this.mData = null;
        this.mData = new ArrayList<>();
        this.anti = new AntiData();
        this.mContext = mContext;
    }

    public boolean isEmpty() {
        return this.mData == null || this.mData.isEmpty();
    }

    public void setPostData(ArrayList<PostData> datas) {
        this.mData = datas;
        this.dataNum = this.mData.size();
    }

    public void addPostData(PostData datas) {
        this.mData.add(datas);
        this.dataNum = this.mData.size();
        this.commentAmount++;
    }

    public ArrayList<PostData> getData() {
        return this.mData;
    }

    public int getDataNum() {
        return this.dataNum;
    }

    public int getCommentAmount() {
        return this.commentAmount;
    }

    public void increaseCommentAmount() {
        this.commentAmount++;
    }

    public boolean isLast() {
        return this.mData.size() >= this.commentAmount;
    }

    public boolean hasNext() {
        return this.mData != null && this.mData.size() < this.commentAmount && this.mData.size() < 200;
    }

    public void paserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            paserJson(json);
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "paserJson", e.toString());
        }
    }

    private void paserJson(JSONObject json) {
        try {
            JSONArray list = json.getJSONArray("comment_list");
            if (list != null) {
                int count = this.mData.size() - (this.mData.size() % 10);
                for (int i = 0; i < list.length(); i++) {
                    JSONObject item = list.getJSONObject(i);
                    PostData itemData = new PostData();
                    itemData.parserJson(item);
                    if (this.mContext != null) {
                        itemData.uniteContent(this.mContext);
                    }
                    if (count < this.mData.size()) {
                        this.mData.remove(count);
                        this.mData.add(count, itemData);
                    } else {
                        this.mData.add(itemData);
                    }
                    count++;
                }
                this.dataNum = this.mData.size();
            }
            this.commentAmount = json.optInt("comment_amount", 0);
            JSONObject antiObject = json.getJSONObject("tbs");
            this.anti.setTbs(antiObject.optString("common"));
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "paserJson", e.toString());
        }
    }
}
