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
public class MsgActivityView extends bc {
    private HeadImageView aCp;
    private TextView aRR;
    private TextView aRS;
    private TextView aRT;
    private com.baidu.adp.lib.c.a mItemViewClickListener;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgactivity_view);
        this.ayA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aRR = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_title);
        this.aRS = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_time);
        this.aRT = (TextView) findViewById(com.baidu.tieba.w.msg_msgactivity_address);
        this.aCp = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgactivity_photo);
        this.aCp.setIsRound(false);
        this.aCp.setClickable(true);
        getConvertView().setOnClickListener(new av(this));
        getConvertView().setOnLongClickListener(new aw(this));
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
                    this.aRR.setText(optString);
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
                    this.aRS.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.aRT.setVisibility(4);
                    } else {
                        this.aRT.setVisibility(0);
                        this.aRT.setText(optString3);
                    }
                    this.aCp.setTag(optString4);
                    this.aCp.setOnClickListener(new ax(this, optString5, optString6));
                    this.aCp.d(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void setOnItemViewClickListener(com.baidu.adp.lib.c.a aVar) {
        this.mItemViewClickListener = aVar;
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
