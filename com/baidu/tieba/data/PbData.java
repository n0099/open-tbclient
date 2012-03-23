package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbData {
    private ForumData forum = new ForumData();
    private ThreadData thread = new ThreadData();
    private ArrayList<PostData> post_list = new ArrayList<>();
    private PageData page = new PageData();
    private AntiData anti = new AntiData();
    private boolean isHasFloor = false;

    public ForumData getForum() {
        return this.forum;
    }

    public void setForum(ForumData forum) {
        this.forum = forum;
    }

    public ThreadData getThread() {
        return this.thread;
    }

    public void setThread(ThreadData thread) {
        this.thread = thread;
    }

    public ArrayList<PostData> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(ArrayList<PostData> post_list) {
        this.post_list = post_list;
    }

    public PageData getPage() {
        return this.page;
    }

    public void setPage(PageData page) {
        this.page = page;
    }

    public void setAnti(AntiData anti) {
        this.anti = anti;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("PbData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.forum.parserJson(json.optJSONObject("forum"));
                this.thread.parserJson(json.optJSONObject("thread"));
                JSONArray list = json.optJSONArray("post_list");
                if (list != null) {
                    for (int i = 0; i < list.length(); i++) {
                        PostData tmp = new PostData();
                        tmp.parserJson(list.optJSONObject(i));
                        this.post_list.add(tmp);
                    }
                }
                this.page.parserJson(json.optJSONObject("page"));
                this.anti.parserJson(json.optJSONObject("anti"));
                int hasFloor = json.optInt("has_floor");
                this.isHasFloor = hasFloor == 1;
            } catch (Exception ex) {
                TiebaLog.e("PbData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        this.forum.logPrint();
        this.thread.logPrint();
        for (int i = 0; i < this.post_list.size(); i++) {
            this.post_list.get(i).logPrint();
        }
        this.page.logPrint();
        this.anti.logPrint();
    }

    public boolean getIsHasFloor() {
        return this.isHasFloor;
    }
}
