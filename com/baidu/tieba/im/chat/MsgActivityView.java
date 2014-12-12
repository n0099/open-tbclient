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
public class MsgActivityView extends az {
    private HeadImageView aBo;
    private TextView aQI;
    private TextView aQJ;
    private TextView aQK;
    private com.baidu.adp.lib.c.a mItemViewClickListener;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgactivity_view);
        this.axA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aQI = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_title);
        this.aQJ = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_time);
        this.aQK = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_address);
        this.aBo = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgactivity_photo);
        this.aBo.setIsRound(false);
        this.aBo.setClickable(true);
        getConvertView().setOnClickListener(new as(this));
        getConvertView().setOnLongClickListener(new at(this));
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
                    this.aQI.setText(optString);
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
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(com.baidu.tieba.z.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.z.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(com.baidu.tieba.z.am);
                    }
                    this.aQJ.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.aQK.setVisibility(4);
                    } else {
                        this.aQK.setVisibility(0);
                        this.aQK.setText(optString3);
                    }
                    this.aBo.setTag(optString4);
                    this.aBo.setOnClickListener(new au(this, optString5, optString6));
                    this.aBo.d(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.az
    public void setOnItemViewClickListener(com.baidu.adp.lib.c.a aVar) {
        this.mItemViewClickListener = aVar;
    }

    @Override // com.baidu.tieba.im.chat.az
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    @Override // com.baidu.tieba.im.chat.az
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
