package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MsgActivityView extends g {
    private HeadImageView dmh;
    private TextView egH;
    private TextView egI;
    private TextView egJ;
    private com.baidu.adp.lib.c.a egK;
    private com.baidu.adp.lib.c.b egL;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgactivity_view);
        this.cVU = (TextView) findViewById(d.g.tex_msgitem_time);
        this.egH = (TextView) findViewById(d.g.msg_msgactivity_title);
        this.egI = (TextView) findViewById(d.g.msg_msgactivity_time);
        this.egJ = (TextView) findViewById(d.g.msg_msgactivity_address);
        this.dmh = (HeadImageView) findViewById(d.g.img_msgactivity_photo);
        this.dmh.setIsRound(false);
        this.dmh.setClickable(true);
        eC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgActivityView.this.egK != null) {
                    MsgActivityView.this.egK.a(view, 8, MsgActivityView.this.mPosition, 0L);
                }
            }
        });
        eC().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MsgActivityView.this.egL != null) {
                    MsgActivityView.this.egL.b(view, 8, MsgActivityView.this.mPosition, 0L);
                    return true;
                }
                return true;
            }
        });
    }

    public void setData(ChatMessage chatMessage) {
        String string;
        String string2;
        if (chatMessage != null) {
            g(chatMessage);
            try {
                JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject("eventParam");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    final String optString5 = optJSONObject.optString("activityUserId");
                    final String optString6 = optJSONObject.optString("activityUserName");
                    this.egH.setText(optString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.baidu.adp.lib.g.b.c(optString2, 0L) * 1000);
                    int i = calendar.get(11);
                    int i2 = calendar.get(12);
                    int i3 = calendar.get(7) - 1;
                    int i4 = calendar.get(1);
                    int i5 = calendar.get(2) + 1;
                    int i6 = calendar.get(5);
                    switch (i3) {
                        case 0:
                            string = this.mContext.getResources().getString(d.k.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(d.k.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(d.k.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(d.k.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(d.k.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(d.k.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(d.k.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(d.k.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(d.k.am);
                    }
                    this.egI.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.egJ.setVisibility(4);
                    } else {
                        this.egJ.setVisibility(0);
                        this.egJ.setText(optString3);
                    }
                    this.dmh.setTag(optString4);
                    this.dmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MsgActivityView.this.getPageContext().getPageActivity(), optString5, optString6)));
                        }
                    });
                    this.dmh.startLoad(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(com.baidu.adp.lib.c.a aVar) {
        this.egK = aVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.egL = bVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
