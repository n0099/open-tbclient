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
public class MsgActivityView extends cb {
    private HeadImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private int t;
    private com.baidu.adp.lib.b.a u;
    private com.baidu.adp.lib.b.b v;

    public MsgActivityView(Context context) {
        super(context, com.baidu.tieba.v.msg_msgactivity_view);
        this.g = (TextView) a(com.baidu.tieba.u.tex_msgitem_time);
        this.q = (TextView) a(com.baidu.tieba.u.msg_msgactivity_title);
        this.r = (TextView) a(com.baidu.tieba.u.msg_msgactivity_time);
        this.s = (TextView) a(com.baidu.tieba.u.msg_msgactivity_address);
        this.p = (HeadImageView) a(com.baidu.tieba.u.img_msgactivity_photo);
        this.p.setIsRound(false);
        this.p.setClickable(true);
        a().setOnClickListener(new bv(this));
        a().setOnLongClickListener(new bw(this));
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
                    this.q.setText(optString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.baidu.adp.lib.e.b.a(optString2, 0L) * 1000);
                    int i = calendar.get(11);
                    int i2 = calendar.get(12);
                    int i3 = calendar.get(7) - 1;
                    int i4 = calendar.get(1);
                    int i5 = calendar.get(2) + 1;
                    int i6 = calendar.get(5);
                    switch (i3) {
                        case 0:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(com.baidu.tieba.x.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.x.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.x.am);
                    }
                    this.r.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.s.setVisibility(4);
                    } else {
                        this.s.setVisibility(0);
                        this.s.setText(optString3);
                    }
                    this.p.setTag(optString4);
                    this.p.setOnClickListener(new bx(this, optString5, optString6));
                    this.p.a(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.cb
    public void a(com.baidu.adp.lib.b.a aVar) {
        this.u = aVar;
    }

    @Override // com.baidu.tieba.im.chat.cb
    public void a(com.baidu.adp.lib.b.b bVar) {
        this.v = bVar;
    }

    @Override // com.baidu.tieba.im.chat.cb
    public void b(int i) {
        this.t = i;
    }
}
