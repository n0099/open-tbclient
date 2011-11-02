package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.IntentSpan;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ContentData {
    public static final int TYPE_AT = 4;
    public static final int TYPE_FACE = 2;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_PIC = 3;
    public static final int TYPE_SONG = 6;
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_VIDEO = 5;
    private int type = 0;
    private String text = null;
    private String link = null;
    private SpannableStringBuilder uniteString = null;

    public static boolean isNeedUnite(int parent_ype, int child_type) {
        return parent_ype == 0 && child_type != 3;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUniteString(SpannableStringBuilder uniteString) {
        this.uniteString = uniteString;
    }

    public SpannableStringBuilder getUniteString() {
        return this.uniteString;
    }

    public SpannableStringBuilder appendUniteString(SpannableString str) {
        if (this.uniteString == null) {
            this.uniteString = new SpannableStringBuilder();
        }
        this.uniteString.append((CharSequence) str);
        return this.uniteString;
    }

    public SpannableString getSpannableString(Context context) {
        switch (this.type) {
            case 0:
                return new SpannableString(this.text);
            case 1:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString tmp = new SpannableString(this.text);
                IntentSpan click = new IntentSpan(context) { // from class: com.baidu.tieba.data.ContentData.2
                    @Override // com.baidu.tieba.util.IntentSpan, android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        WebActivity.startActivity(getContext(), ContentData.this.link);
                    }
                };
                tmp.setSpan(click, 0, this.text.length() - 1, 33);
                return tmp;
            case 2:
                String str = this.text;
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString tmp2 = new SpannableString(this.text);
                Bitmap bm = TiebaApplication.app.getFace(str);
                if (bm != null) {
                    BitmapDrawable dr = new BitmapDrawable(bm);
                    dr.setBounds(0, 0, bm.getWidth(), bm.getHeight());
                    ImageSpan span = new ImageSpan(dr, 0);
                    tmp2.setSpan(span, 0, this.text.length() - 1, 33);
                }
                return tmp2;
            case 3:
                return null;
            case 4:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString tmp3 = new SpannableString(this.text);
                IntentSpan click2 = new IntentSpan(context) { // from class: com.baidu.tieba.data.ContentData.3
                    @Override // com.baidu.tieba.util.IntentSpan, android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        String name = null;
                        if (ContentData.this.text != null) {
                            name = ContentData.this.text.replace("@", "").replace(" ", "");
                        }
                        PersonInfoActivity.startActivity(getContext(), ContentData.this.link, name);
                    }
                };
                tmp3.setSpan(click2, 0, this.text.length() - 1, 33);
                return tmp3;
            case 5:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                String title = context.getString(R.string.video);
                String link = title + this.text;
                SpannableString tmp4 = new SpannableString(link);
                IntentSpan click3 = new IntentSpan(context) { // from class: com.baidu.tieba.data.ContentData.1
                    @Override // com.baidu.tieba.util.IntentSpan, android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        WebActivity.startActivity(getContext(), ContentData.this.text);
                    }
                };
                tmp4.setSpan(click3, title.length(), link.length() - 1, 33);
                return tmp4;
            default:
                return null;
        }
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.type = json.optInt("type", 0);
                if (this.type == 3) {
                    this.link = json.optString("src");
                    this.text = json.optString("bsize");
                } else if (this.type == 4) {
                    this.text = json.optString("text");
                    this.link = json.optString("uid");
                } else {
                    this.text = json.optString("text");
                    this.link = json.optString("link");
                }
                if (this.type != 0) {
                    this.text = this.text.replaceAll("\n", "");
                    this.link = this.link.replaceAll("\n", "");
                }
            } catch (Exception ex) {
                TiebaLog.e("ContentData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("ContentData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        TiebaLog.v("ContentData", "logPrint", "type = " + String.valueOf(this.type));
        TiebaLog.v("ContentData", "logPrint", "text = " + this.text);
        TiebaLog.v("ContentData", "logPrint", "link = " + this.link);
    }
}
