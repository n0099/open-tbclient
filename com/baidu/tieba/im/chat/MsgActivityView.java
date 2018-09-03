package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MsgActivityView extends g {
    private HeadImageView doX;
    private TextView ekt;
    private TextView eku;
    private TextView ekv;
    private com.baidu.adp.lib.c.a ekw;
    private com.baidu.adp.lib.c.b ekx;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, f.h.msg_msgactivity_view);
        this.cYF = (TextView) findViewById(f.g.tex_msgitem_time);
        this.ekt = (TextView) findViewById(f.g.msg_msgactivity_title);
        this.eku = (TextView) findViewById(f.g.msg_msgactivity_time);
        this.ekv = (TextView) findViewById(f.g.msg_msgactivity_address);
        this.doX = (HeadImageView) findViewById(f.g.img_msgactivity_photo);
        this.doX.setIsRound(false);
        this.doX.setClickable(true);
        eB().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgActivityView.this.ekw != null) {
                    MsgActivityView.this.ekw.a(view, 8, MsgActivityView.this.mPosition, 0L);
                }
            }
        });
        eB().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MsgActivityView.this.ekx != null) {
                    MsgActivityView.this.ekx.b(view, 8, MsgActivityView.this.mPosition, 0L);
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
                    this.ekt.setText(optString);
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
                            string = this.mContext.getResources().getString(f.j.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(f.j.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(f.j.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(f.j.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(f.j.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(f.j.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(f.j.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(f.j.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(f.j.am);
                    }
                    this.eku.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.ekv.setVisibility(4);
                    } else {
                        this.ekv.setVisibility(0);
                        this.ekv.setText(optString3);
                    }
                    this.doX.setTag(optString4);
                    this.doX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MsgActivityView.this.getPageContext().getPageActivity(), optString5, optString6)));
                        }
                    });
                    this.doX.startLoad(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(com.baidu.adp.lib.c.a aVar) {
        this.ekw = aVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
