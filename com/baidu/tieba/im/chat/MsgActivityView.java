package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgActivityView extends ch {
    private HeadImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private int t;
    private com.baidu.tbadk.imageManager.d u;
    private com.baidu.adp.lib.b.a v;
    private com.baidu.adp.lib.b.b w;

    public MsgActivityView(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msgactivity_view);
        this.u = new ca(this);
        this.i = (TextView) a(com.baidu.tieba.im.h.tex_msgitem_time);
        this.q = (TextView) a(com.baidu.tieba.im.h.msg_msgactivity_title);
        this.r = (TextView) a(com.baidu.tieba.im.h.msg_msgactivity_time);
        this.s = (TextView) a(com.baidu.tieba.im.h.msg_msgactivity_address);
        this.p = (HeadImageView) a(com.baidu.tieba.im.h.img_msgactivity_photo);
        this.p.setIsRound(false);
        this.p.setClickable(true);
        a().setOnClickListener(new cb(this));
        a().setOnLongClickListener(new cc(this));
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar) {
        String string;
        String string2;
        if (aVar != null) {
            c(aVar);
            try {
                JSONObject optJSONObject = new JSONObject(aVar.v()).optJSONObject("eventParam");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    String optString5 = optJSONObject.optString("activityUserId");
                    String optString6 = optJSONObject.optString("activityUserName");
                    this.q.setText(optString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.baidu.adp.lib.f.b.a(optString2, 0L) * 1000);
                    int i = calendar.get(11);
                    int i2 = calendar.get(12);
                    int i3 = calendar.get(7) - 1;
                    int i4 = calendar.get(1);
                    int i5 = calendar.get(2) + 1;
                    int i6 = calendar.get(5);
                    switch (i3) {
                        case 0:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.seven);
                            break;
                        case 1:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.one);
                            break;
                        case 2:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.two);
                            break;
                        case 3:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.three);
                            break;
                        case 4:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.four);
                            break;
                        case 5:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.five);
                            break;
                        case 6:
                            string = this.b.getResources().getString(com.baidu.tieba.im.j.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.b.getResources().getString(com.baidu.tieba.im.j.pm);
                        i -= 12;
                    } else {
                        string2 = this.b.getResources().getString(com.baidu.tieba.im.j.am);
                    }
                    this.r.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.s.setVisibility(4);
                    } else {
                        this.s.setVisibility(0);
                        this.s.setText(optString3);
                    }
                    this.p.setTag(optString4);
                    this.p.setOnClickListener(new cd(this, optString5, optString6));
                    if (this.e != null) {
                        this.e.c(optString4, this.u);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void a(com.baidu.adp.lib.b.a aVar) {
        this.v = aVar;
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void a(com.baidu.adp.lib.b.b bVar) {
        this.w = bVar;
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void b(int i) {
        this.t = i;
    }
}
