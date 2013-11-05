package com.baidu.tieba.chat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1106a;
    private com.baidu.tieba.util.a h;
    private ChatListFragment b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private View.OnClickListener i = null;
    private List<RecentChatFriendData> j = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public m(Context context) {
        this.f1106a = null;
        this.h = null;
        this.f1106a = context;
        this.h = new com.baidu.tieba.util.a(this.f1106a);
        this.h.d(true);
    }

    public void a() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        this.g.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        be.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.g.clear();
                    return;
                }
            }
        }
    }

    public void a(List<RecentChatFriendData> list) {
        if (this.j == null) {
            this.j = new LinkedList();
        }
        this.j.clear();
        this.j.addAll(list);
        if (TiebaApplication.D()) {
            com.baidu.adp.lib.h.d.d("mRecentChatData.size():" + this.j.size());
            if (this.j.size() <= 0) {
                this.b.e(true);
            } else {
                this.b.e(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j != null) {
            int size = this.j.size();
            if (this.c) {
                size++;
            }
            if (this.d) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.j.size()) {
            return null;
        }
        return this.j.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        View view2;
        o oVar2 = null;
        if (view != null) {
            oVar2 = (o) view.getTag();
        }
        if (oVar2 == null) {
            view2 = LayoutInflater.from(this.f1106a).inflate(R.layout.chat_list_item, viewGroup, false);
            o a2 = a(view2);
            view2.setTag(a2);
            this.g.add(a2.j);
            oVar = a2;
        } else {
            oVar = oVar2;
            view2 = view;
        }
        int as = TiebaApplication.g().as();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.b.setVisibility(8);
            oVar.h.setVisibility(0);
            if (this.f) {
                oVar.i.setText(R.string.loading);
                oVar.j.setVisibility(0);
            } else {
                oVar.i.setText(R.string.frs_pre);
                oVar.j.setVisibility(8);
            }
            if (as == 1) {
                bb.e((View) oVar.i, (int) R.drawable.btn_w_square_1);
                oVar.i.setTextColor(-8682095);
            } else {
                bb.e((View) oVar.i, (int) R.drawable.btn_w_square);
                oVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.b.setVisibility(8);
            oVar.h.setVisibility(0);
            if (this.e) {
                oVar.i.setText(R.string.loading);
                oVar.j.setVisibility(0);
            } else {
                oVar.i.setText(R.string.frs_next);
                oVar.j.setVisibility(8);
            }
            if (as == 1) {
                bb.e((View) oVar.i, (int) R.drawable.btn_w_square_1);
                oVar.i.setTextColor(-8682095);
            } else {
                bb.e((View) oVar.i, (int) R.drawable.btn_w_square);
                oVar.i.setTextColor(-14277082);
            }
        } else {
            if (as == 1) {
                bb.e(view2, (int) R.drawable.list_selector_1);
            } else {
                bb.e(view2, (int) R.drawable.list_selector_divider1);
            }
            com.baidu.adp.lib.h.d.d("count:" + getCount());
            oVar.b.setVisibility(0);
            oVar.h.setVisibility(8);
            RecentChatFriendData recentChatFriendData = (RecentChatFriendData) getItem(i);
            if (recentChatFriendData != null) {
                try {
                    oVar.d.setText(recentChatFriendData.getFriendName());
                    b(oVar, recentChatFriendData);
                    Date date = new Date();
                    date.setTime(recentChatFriendData.getServerTime());
                    String str = "";
                    if (recentChatFriendData.getServerTime() != 0) {
                        str = bc.i(date);
                    }
                    oVar.f.setText(str);
                    c(oVar, recentChatFriendData);
                    a(oVar, as, recentChatFriendData);
                    if (String.valueOf(String.valueOf(2)).equals(recentChatFriendData.getOwnerName())) {
                        if (recentChatFriendData.getUnReadCount() >= 30) {
                            if (this.b != null) {
                                this.b.a(true);
                            }
                        } else if (this.b != null) {
                            this.b.a(false);
                        }
                    }
                    a(oVar, recentChatFriendData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    private void a(o oVar, RecentChatFriendData recentChatFriendData) {
        if (oVar != null) {
            if (recentChatFriendData == null) {
                oVar.k.setVisibility(8);
            } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
                GroupSettingItemData groupSetting = recentChatFriendData.getGroupSetting();
                if (groupSetting == null) {
                    oVar.k.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    oVar.k.setVisibility(0);
                } else {
                    oVar.k.setVisibility(8);
                }
            } else {
                oVar.k.setVisibility(8);
            }
        }
    }

    private void b(o oVar, RecentChatFriendData recentChatFriendData) {
        if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
            oVar.e.setText(recentChatFriendData.getMsgContent());
        } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
            oVar.d.setText(this.f1106a.getString(R.string.updates_activity_title));
            oVar.e.setText(recentChatFriendData.getMsgContent());
        } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
            oVar.e.setText(recentChatFriendData.getMsgContent());
        } else {
            com.baidu.adp.lib.h.d.d(recentChatFriendData.getMsgContent());
            if (TextUtils.isEmpty(recentChatFriendData.getMsgContent())) {
                oVar.e.setText((CharSequence) null);
                return;
            }
            JSONArray jSONArray = new JSONArray(recentChatFriendData.getMsgContent());
            if (jSONArray != null && jSONArray.length() >= 1) {
                oVar.e.setText(jSONArray.optJSONObject(0).optString("text"));
                return;
            }
            oVar.e.setText((CharSequence) null);
        }
    }

    private void a(o oVar, int i, RecentChatFriendData recentChatFriendData) {
        int i2 = 0;
        int unReadCount = recentChatFriendData.getUnReadCount();
        com.baidu.adp.lib.h.d.d("type:" + recentChatFriendData.getOwnerName() + "  count:" + unReadCount);
        if (unReadCount > 0) {
            oVar.g.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (!TiebaApplication.g().ae()) {
                valueOf = "";
                unReadCount = 0;
            }
            if (TiebaApplication.g().R() == 0) {
                valueOf = "";
                unReadCount = 0;
            }
            if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
                valueOf = "";
            } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
                valueOf = "";
            } else if (!String.valueOf(1).equals(recentChatFriendData.getOwnerName()) || recentChatFriendData.getGroupSetting() == null || recentChatFriendData.getGroupSetting().isAcceptNotify()) {
                i2 = unReadCount;
            } else {
                valueOf = "";
            }
            oVar.g.setText(valueOf);
        } else {
            oVar.g.setVisibility(8);
            i2 = unReadCount;
        }
        if (i == 1) {
            oVar.d.setTextColor(-8682086);
            oVar.e.setTextColor(-11446171);
            oVar.f.setTextColor(-8682086);
            if (i2 < 10) {
                oVar.g.setBackgroundResource(R.drawable.icon_news_prompt_1);
            } else if (i2 < 100) {
                oVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_1);
            } else {
                oVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                oVar.g.setText("");
            }
            oVar.g.setTextColor(-478825);
            return;
        }
        oVar.d.setTextColor(-14277082);
        oVar.e.setTextColor(-9013642);
        oVar.f.setTextColor(-8682086);
        if (i2 < 10) {
            oVar.g.setBackgroundResource(R.drawable.icon_news_prompt);
        } else if (i2 < 100) {
            oVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt);
        } else {
            oVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
            oVar.g.setText("");
        }
        oVar.g.setTextColor(-1);
    }

    private void c(o oVar, RecentChatFriendData recentChatFriendData) {
        com.baidu.adp.lib.h.d.d("ownername:" + recentChatFriendData.getOwnerName());
        if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
            oVar.c.setDrawBorder(false);
            oVar.c.setAutoChangeStyle(false);
            oVar.c.setTag(recentChatFriendData.getOwnerName());
            if (TiebaApplication.g().as() == 1) {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.icon_new_test));
            } else {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.icon_new_test));
            }
            oVar.c.setUserName(String.valueOf(2));
            oVar.c.setUserId(recentChatFriendData.getFriendId());
            oVar.c.invalidate();
        } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
            oVar.c.setDrawBorder(false);
            oVar.c.setAutoChangeStyle(false);
            oVar.c.setTag(recentChatFriendData.getOwnerName());
            oVar.c.setUserName(String.valueOf(3));
            oVar.c.setUserId(recentChatFriendData.getFriendId());
            if (TiebaApplication.g().as() == 1) {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.icon_new_trends));
            } else {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.icon_new_trends));
            }
            oVar.c.invalidate();
        } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
            oVar.c.setDrawBorder(true);
            oVar.c.setAutoChangeStyle(true);
            oVar.c.setUserId(recentChatFriendData.getFriendId());
            String friendPortrait = recentChatFriendData.getFriendPortrait();
            String str = (String) oVar.c.getTag();
            if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str) && !str.equals(friendPortrait)) || TextUtils.isEmpty(str)) {
                com.baidu.adp.widget.ImageView.e d = this.h.d(friendPortrait);
                if (d != null) {
                    d.a(oVar.c);
                } else {
                    oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.avatar_poto_defaul140));
                }
            } else if (TextUtils.isEmpty(friendPortrait)) {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.avatar_poto_defaul140));
            }
            oVar.c.setClickable(false);
            oVar.c.setTag(recentChatFriendData.getFriendPortrait());
            oVar.c.setUserId(recentChatFriendData.getFriendId());
            com.baidu.adp.lib.h.d.d("groupid:" + recentChatFriendData.getFriendId() + " groupHeadUrl:" + recentChatFriendData.getFriendPortrait() + " groupName:" + recentChatFriendData.getFriendName());
            oVar.c.setUserName(String.valueOf(1));
            oVar.c.invalidate();
        } else {
            oVar.c.setDrawBorder(true);
            oVar.c.setAutoChangeStyle(true);
            String friendPortrait2 = recentChatFriendData.getFriendPortrait();
            String str2 = (String) oVar.c.getTag();
            if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait2)) || TextUtils.isEmpty(str2)) {
                com.baidu.adp.widget.ImageView.e c = this.h.c(friendPortrait2);
                if (c != null) {
                    c.a(oVar.c);
                } else {
                    oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.person_photo));
                }
            } else if (TextUtils.isEmpty(friendPortrait2)) {
                oVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.person_photo));
            }
            oVar.c.setTag(recentChatFriendData.getFriendPortrait());
            oVar.c.setUserId(recentChatFriendData.getFriendId());
            oVar.c.setUserName(recentChatFriendData.getFriendName());
            oVar.c.setOnClickListener(this.i);
            oVar.c.invalidate();
        }
    }

    private o a(View view) {
        o oVar = new o(this);
        oVar.f1107a = (ViewGroup) view.findViewById(R.id.chat_item);
        oVar.b = (ViewGroup) view.findViewById(R.id.list_content);
        oVar.c = (HeadImageView) view.findViewById(R.id.chat_head);
        oVar.d = (TextView) view.findViewById(R.id.chat_name);
        oVar.e = (TextView) view.findViewById(R.id.last_chat_content);
        oVar.f = (TextView) view.findViewById(R.id.chat_time);
        oVar.g = (TextView) view.findViewById(R.id.new_message);
        oVar.h = (ViewGroup) view.findViewById(R.id.list_control);
        oVar.i = (TextView) view.findViewById(R.id.list_control_tv);
        oVar.j = (ProgressBar) view.findViewById(R.id.list_control_progress);
        oVar.k = (ImageView) view.findViewById(R.id.iv_bell);
        return oVar;
    }

    public void a(ChatListFragment chatListFragment) {
        this.b = chatListFragment;
    }

    public void a(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public com.baidu.tieba.util.a b() {
        return this.h;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void d(boolean z) {
        this.d = z;
    }
}
