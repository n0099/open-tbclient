package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ThreadData {
    private SpannableString span_str;
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int repost_num = 0;
    private int view_num = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private MetaData author = new MetaData();
    private MetaData last_replyer = new MetaData();
    private int comment_num = 0;
    private int has_commented = 0;
    private int show_commented = 0;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setReply_num(int reply_num) {
        this.reply_num = reply_num;
    }

    public int getReply_num() {
        return this.reply_num;
    }

    public void setRepost_num(int repost_num) {
        this.repost_num = repost_num;
    }

    public int getRepost_num() {
        return this.repost_num;
    }

    public int getView_num() {
        return this.view_num;
    }

    public void setView_num(int view_num) {
        this.view_num = view_num;
    }

    public String getLast_time() {
        return this.last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    public long getLast_time_int() {
        return this.last_time_int;
    }

    public void setLast_time_int(long last_time_int) {
        this.last_time_int = last_time_int;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void setIs_good(int is_good) {
        this.is_good = is_good;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData author) {
        this.author = author;
    }

    public MetaData getLast_replyer() {
        return this.last_replyer;
    }

    public void setLast_replyer(MetaData last_replyer) {
        this.last_replyer = last_replyer;
    }

    public int getComment_num() {
        return this.comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getHas_commented() {
        return this.has_commented;
    }

    public void setHas_commented(int has_commented) {
        this.has_commented = has_commented;
    }

    public int getShow_commented() {
        return this.show_commented;
    }

    public void setShow_commented(int show_commented) {
        this.show_commented = show_commented;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("ThreadData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.tid = json.optString("tid");
                this.title = json.optString("title");
                this.reply_num = json.optInt("reply_num", 0);
                this.repost_num = json.optInt("repost_num", 0);
                this.view_num = json.optInt("view_num", 0);
                this.last_time = json.optString("last_time");
                this.last_time_int = json.optLong("last_time_int", 0L);
                this.is_top = json.optInt("is_top", 0);
                this.is_good = json.optInt("is_good", 0);
                this.author.parserJson(json.optJSONObject("author"));
                this.last_replyer.parserJson(json.optJSONObject("last_replyer"));
                this.comment_num = json.optInt("comment_num", 0);
                this.has_commented = json.optInt("has_commented", 0);
                this.show_commented = json.optInt("show_commented", 0);
            } catch (Exception ex) {
                TiebaLog.e("ThreadData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("ThreadData", "logPrint", "id = " + this.id);
        TiebaLog.v("ThreadData", "logPrint", "tid = " + this.tid);
        TiebaLog.v("ThreadData", "logPrint", "title = " + this.title);
        TiebaLog.v("ThreadData", "logPrint", "reply_num = " + String.valueOf(this.reply_num));
        TiebaLog.v("ThreadData", "logPrint", "repost_num = " + String.valueOf(this.repost_num));
        TiebaLog.v("ThreadData", "logPrint", "view_num = " + String.valueOf(this.view_num));
        TiebaLog.v("ThreadData", "logPrint", "last_time = " + String.valueOf(this.last_time));
        TiebaLog.v("ThreadData", "logPrint", "last_time_int = " + this.last_time_int);
        TiebaLog.v("ThreadData", "logPrint", "is_top = " + String.valueOf(this.is_top));
        TiebaLog.v("ThreadData", "logPrint", "is_good = " + String.valueOf(this.is_good));
        TiebaLog.v("ThreadData", "logPrint", "comment_num = " + String.valueOf(this.comment_num));
        TiebaLog.v("ThreadData", "logPrint", "has_commented = " + String.valueOf(this.has_commented));
        this.author.logPrint();
        this.last_replyer.logPrint();
    }

    public void setSpan_str(SpannableString span_str) {
        this.span_str = span_str;
    }

    public SpannableString getSpan_str() {
        return this.span_str;
    }

    public void parser_title() {
        SpannableString tmp;
        Bitmap bm = null;
        if (getIs_top() == 1) {
            bm = BitmapHelper.getCashBitmap(R.drawable.frs_post_top);
        } else if (getIs_good() == 1) {
            bm = BitmapHelper.getCashBitmap(R.drawable.frs_post_good);
        } else if (getShow_commented() == 1) {
            bm = BitmapHelper.getCashBitmap(R.drawable.frs_post_ding);
        }
        if (bm != null) {
            tmp = new SpannableString("1 " + this.title);
            BitmapDrawable r = new BitmapDrawable(bm);
            r.setBounds(0, 0, bm.getWidth(), bm.getHeight());
            ImageSpan span = new ImageSpan(r, 0);
            tmp.setSpan(span, 0, 1, 33);
        } else {
            tmp = new SpannableString(this.title);
        }
        this.title = null;
        this.span_str = tmp;
    }
}
