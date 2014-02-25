package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgActivityView extends bs {
    private static final String o = MsgActivityView.class.getName();
    private HeadImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private int t;
    private com.baidu.tbadk.imageManager.d u;
    private com.baidu.adp.lib.b.a v;
    private com.baidu.adp.lib.b.b w;

    public MsgActivityView(Context context) {
        super(context, R.layout.msg_msgactivity_view);
        this.u = new bf(this);
        this.i = (TextView) a(R.id.tex_msgitem_time);
        this.q = (TextView) a(R.id.msg_msgactivity_title);
        this.r = (TextView) a(R.id.msg_msgactivity_time);
        this.s = (TextView) a(R.id.msg_msgactivity_address);
        this.p = (HeadImageView) a(R.id.img_msgactivity_photo);
        this.p.setIsRound(false);
        this.p.setClickable(true);
        a().setOnClickListener(new bg(this));
        a().setOnLongClickListener(new bh(this));
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        String string;
        String string2;
        if (bVar != null) {
            b(bVar);
            try {
                JSONObject optJSONObject = new JSONObject(bVar.k()).optJSONObject("eventParam");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("activityTitle");
                    String optString2 = optJSONObject.optString("activityTime");
                    String optString3 = optJSONObject.optString("activityArea");
                    String optString4 = optJSONObject.optString("activityImage");
                    String optString5 = optJSONObject.optString("activityUserId");
                    String optString6 = optJSONObject.optString("activityUserName");
                    this.q.setText(optString);
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
                            string = this.b.getResources().getString(R.string.seven);
                            break;
                        case 1:
                            string = this.b.getResources().getString(R.string.one);
                            break;
                        case 2:
                            string = this.b.getResources().getString(R.string.two);
                            break;
                        case 3:
                            string = this.b.getResources().getString(R.string.three);
                            break;
                        case 4:
                            string = this.b.getResources().getString(R.string.four);
                            break;
                        case 5:
                            string = this.b.getResources().getString(R.string.five);
                            break;
                        case 6:
                            string = this.b.getResources().getString(R.string.six);
                            break;
                        default:
                            string = "";
                            break;
                    }
                    if (i > 12) {
                        string2 = this.b.getResources().getString(R.string.pm);
                        i -= 12;
                    } else {
                        string2 = this.b.getResources().getString(R.string.am);
                    }
                    this.r.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), string, string2, Integer.valueOf(i), Integer.valueOf(i2)));
                    if (TextUtils.isEmpty(optString3)) {
                        this.s.setVisibility(4);
                    } else {
                        this.s.setVisibility(0);
                        this.s.setText(optString3);
                    }
                    this.p.setTag(optString4);
                    this.p.setOnClickListener(new bi(this, optString5, optString6));
                    if (this.e != null) {
                        this.e.c(optString4, this.u);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.bs
    public void a(com.baidu.adp.lib.b.a aVar) {
        this.v = aVar;
    }

    @Override // com.baidu.tieba.im.chat.bs
    public void a(com.baidu.adp.lib.b.b bVar) {
        this.w = bVar;
    }

    @Override // com.baidu.tieba.im.chat.bs
    public void b(int i) {
        this.t = i;
    }
}
