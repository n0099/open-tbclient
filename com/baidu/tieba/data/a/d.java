package com.baidu.tieba.data.a;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.z;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    protected long a;
    protected String b;
    protected String c;
    protected int d;
    protected int e;
    protected long f;
    protected long g;
    protected String h;
    private com.baidu.tbadk.widget.richText.a i = null;

    public static d a() {
        d dVar = new d();
        dVar.d = 0;
        dVar.a(TiebaApplication.E());
        return dVar;
    }

    public long b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public int e() {
        return this.e;
    }

    public void a(long j) {
        this.f = j;
    }

    public long f() {
        return this.g;
    }

    public com.baidu.tbadk.widget.richText.a a(Context context) {
        if (this.i == null) {
            this.i = TbRichTextView.a(context, this.h);
        }
        return this.i;
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("from") == 1) {
                this.e = 0;
            } else {
                this.e = 1;
            }
            this.h = jSONObject.optJSONArray(PushConstants.EXTRA_CONTENT).toString();
            this.g = jSONObject.getLong("time");
            try {
                this.a = jSONObject.optLong("msg_id");
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            z.b(getClass().getName(), "parserJson", e2.toString());
        }
    }

    public void b(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ArrayList a = this.i.a();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.size()) {
                break;
            }
            if (((com.baidu.tbadk.widget.richText.c) a.get(i2)).a() == 1) {
                sb.append((CharSequence) ((com.baidu.tbadk.widget.richText.c) a.get(i2)).d());
            }
            i = i2 + 1;
        }
        clipboardManager.setText(sb);
        if (clipboardManager.getText() != null) {
            z.e("ChatMessageActivity", "clip_text", clipboardManager.getText().toString());
        }
    }
}
