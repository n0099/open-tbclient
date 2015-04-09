package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgActivityView extends bk {
    private HeadImageView aIq;
    private TextView aXp;
    private TextView aXq;
    private TextView aXr;
    private com.baidu.adp.lib.c.a aXs;
    private com.baidu.adp.lib.c.b aXt;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgactivity_view);
        this.aGS = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aXp = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_title);
        this.aXq = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_time);
        this.aXr = (TextView) findViewById(com.baidu.tieba.v.msg_msgactivity_address);
        this.aIq = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgactivity_photo);
        this.aIq.setIsRound(false);
        this.aIq.setClickable(true);
        getConvertView().setOnClickListener(new ay(this));
        getConvertView().setOnLongClickListener(new az(this));
    }

    public void setData(ChatMessage chatMessage) {
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
                    this.aXp.setText(optString);
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
                    this.aXq.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.aXr.setVisibility(4);
                    } else {
                        this.aXr.setVisibility(0);
                        this.aXr.setText(optString3);
                    }
                    this.aIq.setTag(optString4);
                    this.aIq.setOnClickListener(new ba(this, optString5, optString6));
                    this.aIq.c(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aXs = aVar;
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aXt = bVar;
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
