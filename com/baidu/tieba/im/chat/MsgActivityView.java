package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.j0.e1.f.e;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MsgActivityView extends e {
    public HeadImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public int x;
    public d.a.c.e.h.a y;
    public d.a.c.e.h.b z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MsgActivityView.this.y != null) {
                MsgActivityView.this.y.onItemViewClick(view, 8, MsgActivityView.this.x, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MsgActivityView.this.z != null) {
                MsgActivityView.this.z.onItemViewLongClick(view, 8, MsgActivityView.this.x, 0L);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17754f;

        public c(String str, String str2) {
            this.f17753e = str;
            this.f17754f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MsgActivityView.this.getPageContext().getPageActivity(), this.f17753e, this.f17754f)));
        }
    }

    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgactivity_view);
        this.f53447h = (TextView) d(R.id.tex_msgitem_time);
        this.u = (TextView) d(R.id.msg_msgactivity_title);
        this.v = (TextView) d(R.id.msg_msgactivity_time);
        this.w = (TextView) d(R.id.msg_msgactivity_address);
        HeadImageView headImageView = (HeadImageView) d(R.id.img_msgactivity_photo);
        this.t = headImageView;
        headImageView.setIsRound(false);
        this.t.setClickable(true);
        e().setOnClickListener(new a());
        e().setOnLongClickListener(new b());
    }

    public void H(ChatMessage chatMessage) {
        String string;
        if (chatMessage == null) {
            return;
        }
        w(chatMessage);
        try {
            JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("activityTitle");
                String optString2 = optJSONObject.optString("activityTime");
                String optString3 = optJSONObject.optString("activityArea");
                String optString4 = optJSONObject.optString("activityImage");
                String optString5 = optJSONObject.optString("activityUserId");
                String optString6 = optJSONObject.optString("activityUserName");
                this.u.setText(optString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(d.a.c.e.m.b.f(optString2, 0L) * 1000);
                int i2 = calendar.get(11);
                int i3 = calendar.get(12);
                int i4 = calendar.get(7) - 1;
                int i5 = calendar.get(1);
                int i6 = calendar.get(2) + 1;
                int i7 = calendar.get(5);
                String str = "";
                switch (i4) {
                    case 0:
                        str = this.mContext.getResources().getString(R.string.seven);
                        break;
                    case 1:
                        str = this.mContext.getResources().getString(R.string.one);
                        break;
                    case 2:
                        str = this.mContext.getResources().getString(R.string.two);
                        break;
                    case 3:
                        str = this.mContext.getResources().getString(R.string.three);
                        break;
                    case 4:
                        str = this.mContext.getResources().getString(R.string.four);
                        break;
                    case 5:
                        str = this.mContext.getResources().getString(R.string.five);
                        break;
                    case 6:
                        str = this.mContext.getResources().getString(R.string.six);
                        break;
                }
                if (i2 > 12) {
                    string = this.mContext.getResources().getString(R.string.pm);
                    i2 -= 12;
                } else {
                    string = this.mContext.getResources().getString(R.string.am);
                }
                this.v.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str, string, Integer.valueOf(i2), Integer.valueOf(i3)));
                if (TextUtils.isEmpty(optString3)) {
                    this.w.setVisibility(4);
                } else {
                    this.w.setVisibility(0);
                    this.w.setText(optString3);
                }
                this.t.setTag(optString4);
                this.t.setOnClickListener(new c(optString5, optString6));
                this.t.V(optString4, 12, false);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.j0.e1.f.e
    public void p(d.a.c.e.h.a aVar) {
        this.y = aVar;
    }

    @Override // d.a.j0.e1.f.e
    public void q(d.a.c.e.h.b bVar) {
        this.z = bVar;
    }

    @Override // d.a.j0.e1.f.e
    public void r(int i2) {
        this.x = i2;
    }
}
