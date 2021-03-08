package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MsgActivityView extends e {
    private HeadImageView kCr;
    private TextView kCs;
    private TextView kCt;
    private TextView kCu;
    private com.baidu.adp.lib.b.a kCv;
    private com.baidu.adp.lib.b.b kCw;
    private int mPosition;

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgactivity_view);
        this.gFl = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kCs = (TextView) findViewById(R.id.msg_msgactivity_title);
        this.kCt = (TextView) findViewById(R.id.msg_msgactivity_time);
        this.kCu = (TextView) findViewById(R.id.msg_msgactivity_address);
        this.kCr = (HeadImageView) findViewById(R.id.img_msgactivity_photo);
        this.kCr.setIsRound(false);
        this.kCr.setClickable(true);
        getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MsgActivityView.this.kCv != null) {
                    MsgActivityView.this.kCv.onItemViewClick(view, 8, MsgActivityView.this.mPosition, 0L);
                }
            }
        });
        getConvertView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MsgActivityView.this.kCw != null) {
                    MsgActivityView.this.kCw.onItemViewLongClick(view, 8, MsgActivityView.this.mPosition, 0L);
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
            b(chatMessage);
            try {
                JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    final String optString5 = optJSONObject.optString("activityUserId");
                    final String optString6 = optJSONObject.optString("activityUserName");
                    this.kCs.setText(optString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(com.baidu.adp.lib.f.b.toLong(optString2, 0L) * 1000);
                    int i = calendar.get(11);
                    int i2 = calendar.get(12);
                    int i3 = calendar.get(7) - 1;
                    int i4 = calendar.get(1);
                    int i5 = calendar.get(2) + 1;
                    int i6 = calendar.get(5);
                    switch (i3) {
                        case 0:
                            string = this.mContext.getResources().getString(R.string.seven);
                            break;
                        case 1:
                            string = this.mContext.getResources().getString(R.string.one);
                            break;
                        case 2:
                            string = this.mContext.getResources().getString(R.string.two);
                            break;
                        case 3:
                            string = this.mContext.getResources().getString(R.string.three);
                            break;
                        case 4:
                            string = this.mContext.getResources().getString(R.string.four);
                            break;
                        case 5:
                            string = this.mContext.getResources().getString(R.string.five);
                            break;
                        case 6:
                            string = this.mContext.getResources().getString(R.string.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.mContext.getResources().getString(R.string.pm);
                        i -= 12;
                    } else {
                        string2 = this.mContext.getResources().getString(R.string.am);
                    }
                    this.kCt.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.kCu.setVisibility(4);
                    } else {
                        this.kCu.setVisibility(0);
                        this.kCu.setText(optString3);
                    }
                    this.kCr.setTag(optString4);
                    this.kCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgActivityView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MsgActivityView.this.getPageContext().getPageActivity(), optString5, optString6)));
                        }
                    });
                    this.kCr.startLoad(optString4, 12, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(com.baidu.adp.lib.b.a aVar) {
        this.kCv = aVar;
    }

    @Override // com.baidu.tieba.im.chat.e
    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kCw = bVar;
    }

    @Override // com.baidu.tieba.im.chat.e
    public void setPosition(int i) {
        this.mPosition = i;
    }
}
