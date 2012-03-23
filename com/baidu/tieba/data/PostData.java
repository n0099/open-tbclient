package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PostData {
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private UserData author = new UserData();
    private ArrayList<ContentData> content = new ArrayList<>();
    private ArrayList<ContentData> unite_content = new ArrayList<>();
    private int subPostNum = 0;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFloor_num() {
        return this.floor_num;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public UserData getAuthor() {
        return this.author;
    }

    public void setAuthor(UserData author) {
        this.author = author;
    }

    public ArrayList<ContentData> getContent() {
        return this.content;
    }

    public void setContent(ArrayList<ContentData> content) {
        this.content = content;
    }

    public void setUnite_content(ArrayList<ContentData> unite_content) {
        this.unite_content = unite_content;
    }

    public ArrayList<ContentData> getUnite_content() {
        return this.unite_content;
    }

    public int getSubPostNum() {
        return this.subPostNum;
    }

    public void uniteContentExcepFace(Context context) {
        if (this.content != null) {
            int unite_type = -1;
            int unite_size = this.unite_content.size();
            if (unite_size > 0) {
                try {
                    unite_type = this.unite_content.get(unite_size - 1).getType();
                } catch (Exception ex) {
                    TiebaLog.e("PostData", "uniteContent", "error = " + ex.getMessage());
                    return;
                }
            }
            for (int i = 0; i < this.content.size(); i++) {
                ContentData data = this.content.get(i);
                if (ContentData.isNeedUniteExcepFace(unite_type, data.getType())) {
                    this.unite_content.get(unite_size - 1).appendUniteString(data.getSpannableString(context));
                } else {
                    if (data.getType() == 3 || data.getType() == 2) {
                        this.unite_content.add(data);
                        unite_type = data.getType();
                    } else {
                        ContentData tmp = new ContentData();
                        tmp.setType(0);
                        tmp.appendUniteString(data.getSpannableString(context));
                        this.unite_content.add(tmp);
                        unite_type = 0;
                    }
                    unite_size++;
                }
            }
        }
    }

    public void uniteContent(Context context) {
        if (this.content != null) {
            int unite_type = -1;
            int unite_size = this.unite_content.size();
            if (unite_size > 0) {
                try {
                    unite_type = this.unite_content.get(unite_size - 1).getType();
                } catch (Exception ex) {
                    TiebaLog.e("PostData", "uniteContent", "error = " + ex.getMessage());
                    return;
                }
            }
            for (int i = 0; i < this.content.size(); i++) {
                ContentData data = this.content.get(i);
                if (ContentData.isNeedUnite(unite_type, data.getType())) {
                    this.unite_content.get(unite_size - 1).appendUniteString(data.getSpannableString(context));
                } else {
                    if (data.getType() == 3) {
                        this.unite_content.add(data);
                        unite_type = 3;
                    } else {
                        ContentData tmp = new ContentData();
                        tmp.setType(0);
                        tmp.appendUniteString(data.getSpannableString(context));
                        this.unite_content.add(tmp);
                        unite_type = 0;
                    }
                    unite_size++;
                }
            }
        }
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("PostData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.title = json.optString("title");
                this.floor_num = json.optInt("floor", 0);
                this.time = json.optLong("time", 0L) * 1000;
                this.author.parserJson(json.optJSONObject("author"));
                JSONArray list = json.optJSONArray("content");
                this.subPostNum = json.optInt("sub_post_number");
                if (list != null) {
                    for (int i = 0; i < list.length(); i++) {
                        ContentData tmp = new ContentData();
                        tmp.parserJson(list.optJSONObject(i));
                        this.content.add(tmp);
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("PostData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("PostData", "logPrint", "id = " + this.id);
        TiebaLog.v("PostData", "logPrint", "title = " + this.title);
        TiebaLog.v("PostData", "logPrint", "floor_num = " + String.valueOf(this.floor_num));
        TiebaLog.v("PostData", "logPrint", "time = " + String.valueOf(this.time));
        this.author.logPrint();
        for (int i = 0; i < this.content.size(); i++) {
            this.content.get(i).logPrint();
        }
    }
}
