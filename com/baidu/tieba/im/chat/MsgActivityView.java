package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgActivityView extends cd {
    private HeadImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private int s;
    private com.baidu.adp.lib.b.a t;
    private com.baidu.adp.lib.b.b u;

    public MsgActivityView(Context context) {
        super(context, com.baidu.tieba.s.msg_msgactivity_view);
        this.h = (TextView) a(com.baidu.tieba.r.tex_msgitem_time);
        this.p = (TextView) a(com.baidu.tieba.r.msg_msgactivity_title);
        this.q = (TextView) a(com.baidu.tieba.r.msg_msgactivity_time);
        this.r = (TextView) a(com.baidu.tieba.r.msg_msgactivity_address);
        this.o = (HeadImageView) a(com.baidu.tieba.r.img_msgactivity_photo);
        this.o.setIsRound(false);
        this.o.setClickable(true);
        a().setOnClickListener(new bx(this));
        a().setOnLongClickListener(new by(this));
    }

    public void a(ChatMessage chatMessage) {
        String string;
        String string2;
        if (chatMessage != null) {
            b(chatMessage);
            try {
                JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject("eventParam");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    String optString5 = optJSONObject.optString("activityUserId");
                    String optString6 = optJSONObject.optString("activityUserName");
                    this.p.setText(optString);
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
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(com.baidu.tieba.u.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.u.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.u.am);
                    }
                    this.q.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.r.setVisibility(4);
                    } else {
                        this.r.setVisibility(0);
                        this.r.setText(optString3);
                    }
                    this.o.setTag(optString4);
                    this.o.setOnClickListener(new bz(this, optString5, optString6));
                    this.o.a(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void a(com.baidu.adp.lib.b.a aVar) {
        this.t = aVar;
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void a(com.baidu.adp.lib.b.b bVar) {
        this.u = bVar;
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void b(int i) {
        this.s = i;
    }
}
