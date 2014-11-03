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
public class MsgActivityView extends cc {
    private int UC;
    private TextView aOV;
    private TextView aOW;
    private TextView aOX;
    private com.baidu.adp.lib.c.a aOY;
    private com.baidu.adp.lib.c.b aOZ;
    private HeadImageView azt;

    public MsgActivityView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgactivity_view);
        this.auq = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aOV = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_title);
        this.aOW = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_time);
        this.aOX = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_address);
        this.azt = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgactivity_photo);
        this.azt.setIsRound(false);
        this.azt.setClickable(true);
        O().setOnClickListener(new bv(this));
        O().setOnLongClickListener(new bw(this));
    }

    public void setData(ChatMessage chatMessage) {
        String string;
        String string2;
        if (chatMessage != null) {
            h(chatMessage);
            try {
                JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject("eventParam");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    String optString5 = optJSONObject.optString("activityUserId");
                    String optString6 = optJSONObject.optString("activityUserName");
                    this.aOV.setText(optString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.baidu.adp.lib.g.c.a(optString2, 0L) * 1000);
                    int i = calendar.get(11);
                    int i2 = calendar.get(12);
                    int i3 = calendar.get(7) - 1;
                    int i4 = calendar.get(1);
                    int i5 = calendar.get(2) + 1;
                    int i6 = calendar.get(5);
                    switch (i3) {
                        case 0:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(com.baidu.tieba.y.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.y.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.y.am);
                    }
                    this.aOW.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.aOX.setVisibility(4);
                    } else {
                        this.aOX.setVisibility(0);
                        this.aOX.setText(optString3);
                    }
                    this.azt.setTag(optString4);
                    this.azt.setOnClickListener(new bx(this, optString5, optString6));
                    this.azt.c(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aOY = aVar;
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOZ = bVar;
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void setPosition(int i) {
        this.UC = i;
    }
}
