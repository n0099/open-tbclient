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
    private HeadImageView doZ;
    private com.baidu.adp.lib.c.a ekA;
    private com.baidu.adp.lib.c.b ekB;
    private TextView ekx;
    private TextView eky;
    private TextView ekz;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgactivity_view);
        this.cYJ = (TextView) findViewById(d.g.tex_msgitem_time);
        this.ekx = (TextView) findViewById(d.g.msg_msgactivity_title);
        this.eky = (TextView) findViewById(d.g.msg_msgactivity_time);
        this.ekz = (TextView) findViewById(d.g.msg_msgactivity_address);
        this.doZ = (HeadImageView) findViewById(d.g.img_msgactivity_photo);
        this.doZ.setIsRound(false);
        this.doZ.setClickable(true);
        eB().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgActivityView.this.ekA != null) {
                    MsgActivityView.this.ekA.a(view, 8, MsgActivityView.this.mPosition, 0L);
                }
            }
        });
        eB().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MsgActivityView.this.ekB != null) {
                    MsgActivityView.this.ekB.b(view, 8, MsgActivityView.this.mPosition, 0L);
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
                    this.ekx.setText(optString);
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
                            string = this.mContext.getResources().getString(d.j.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(d.j.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(d.j.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(d.j.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(d.j.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(d.j.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(d.j.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(d.j.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(d.j.am);
                    }
                    this.eky.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.ekz.setVisibility(4);
                    } else {
                        this.ekz.setVisibility(0);
                        this.ekz.setText(optString3);
                    }
                    this.doZ.setTag(optString4);
                    this.doZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MsgActivityView.this.getPageContext().getPageActivity(), optString5, optString6)));
                        }
                    });
                    this.doZ.startLoad(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekA = aVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekB = bVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
