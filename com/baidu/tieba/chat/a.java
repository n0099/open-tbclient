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
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
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
import org.json.JSONException;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i h;
    private ChatListFragment b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private View.OnClickListener i = null;
    private List<RecentChatFriendData> j = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public a(Context context) {
        this.a = null;
        this.h = null;
        this.a = context;
        this.h = new com.baidu.tieba.util.i(this.a);
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
        if (TiebaApplication.C()) {
            com.baidu.adp.lib.h.e.d("mRecentChatData.size():" + this.j.size());
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
        c cVar;
        View view2;
        c cVar2 = null;
        if (view != null) {
            cVar2 = (c) view.getTag();
        }
        if (cVar2 == null) {
            view2 = LayoutInflater.from(this.a).inflate(R.layout.chat_list_item, viewGroup, false);
            c a = a(view2);
            view2.setTag(a);
            this.g.add(a.j);
            cVar = a;
        } else {
            cVar = cVar2;
            view2 = view;
        }
        int an = TiebaApplication.h().an();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            cVar.b.setVisibility(8);
            cVar.h.setVisibility(0);
            if (this.f) {
                cVar.i.setText(R.string.loading);
                cVar.j.setVisibility(0);
            } else {
                cVar.i.setText(R.string.frs_pre);
                cVar.j.setVisibility(8);
            }
            if (an == 1) {
                bb.e((View) cVar.i, (int) R.drawable.btn_w_square_1);
                cVar.i.setTextColor(-8682095);
            } else {
                bb.e((View) cVar.i, (int) R.drawable.btn_w_square);
                cVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            cVar.b.setVisibility(8);
            cVar.h.setVisibility(0);
            if (this.e) {
                cVar.i.setText(R.string.loading);
                cVar.j.setVisibility(0);
            } else {
                cVar.i.setText(R.string.frs_next);
                cVar.j.setVisibility(8);
            }
            if (an == 1) {
                bb.e((View) cVar.i, (int) R.drawable.btn_w_square_1);
                cVar.i.setTextColor(-8682095);
            } else {
                bb.e((View) cVar.i, (int) R.drawable.btn_w_square);
                cVar.i.setTextColor(-14277082);
            }
        } else {
            if (an == 1) {
                bb.e(view2, (int) R.drawable.list_selector_1);
            } else {
                bb.e(view2, (int) R.drawable.list_selector_divider1);
            }
            com.baidu.adp.lib.h.e.d("count:" + getCount());
            cVar.b.setVisibility(0);
            cVar.h.setVisibility(8);
            RecentChatFriendData recentChatFriendData = (RecentChatFriendData) getItem(i);
            if (recentChatFriendData != null) {
                try {
                    cVar.d.setText(recentChatFriendData.getFriendName());
                    b(cVar, recentChatFriendData);
                    Date date = new Date();
                    date.setTime(recentChatFriendData.getServerTime());
                    String str = "";
                    if (recentChatFriendData.getServerTime() != 0) {
                        str = bc.f(date);
                    }
                    cVar.f.setText(str);
                    c(cVar, recentChatFriendData);
                    a(cVar, an, recentChatFriendData);
                    if (String.valueOf(String.valueOf(2)).equals(recentChatFriendData.getOwnerName())) {
                        if (recentChatFriendData.getUnReadCount() >= 30) {
                            if (this.b != null) {
                                this.b.a(true);
                            }
                        } else if (this.b != null) {
                            this.b.a(false);
                        }
                    }
                    a(cVar, recentChatFriendData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    private void a(c cVar, RecentChatFriendData recentChatFriendData) {
        if (cVar != null) {
            if (recentChatFriendData == null) {
                cVar.k.setVisibility(8);
            } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName()) || String.valueOf(4).equals(recentChatFriendData.getOwnerName())) {
                com.baidu.tieba.im.c.k groupSetting = recentChatFriendData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.k.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.k.setVisibility(0);
                    if (TiebaApplication.h().an() == 1) {
                        cVar.k.setImageResource(R.drawable.icon_news_stop_1);
                    } else {
                        cVar.k.setImageResource(R.drawable.icon_news_stop);
                    }
                } else {
                    cVar.k.setVisibility(8);
                }
            } else {
                cVar.k.setVisibility(8);
            }
        }
    }

    private void b(c cVar, RecentChatFriendData recentChatFriendData) {
        if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
            cVar.e.setText(recentChatFriendData.getMsgContent());
        } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
            cVar.d.setText(this.a.getString(R.string.updates_activity_title));
            cVar.e.setText(recentChatFriendData.getMsgContent());
        } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
            cVar.e.setText(recentChatFriendData.getMsgContent());
        } else {
            com.baidu.adp.lib.h.e.d(recentChatFriendData.getMsgContent());
            if (TextUtils.isEmpty(recentChatFriendData.getMsgContent())) {
                cVar.e.setText((CharSequence) null);
            } else {
                cVar.e.setText(recentChatFriendData.getMsgContent());
            }
        }
    }

    private void a(c cVar, int i, RecentChatFriendData recentChatFriendData) {
        int i2;
        String str;
        int i3 = 0;
        int unReadCount = recentChatFriendData.getUnReadCount();
        com.baidu.adp.lib.h.e.d("type:" + recentChatFriendData.getOwnerName() + "  count:" + unReadCount);
        if (unReadCount > 0) {
            cVar.g.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (TiebaApplication.h().N() == 0) {
                str = "";
                i2 = 0;
            } else {
                i2 = unReadCount;
                str = valueOf;
            }
            if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
                str = "";
            } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
                str = "";
            } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
                if (!TiebaApplication.h().aa()) {
                    str = "";
                } else {
                    GroupSettingItemData groupSettingItemData = (GroupSettingItemData) recentChatFriendData.getGroupSetting();
                    if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                        str = "";
                        i2 = 0;
                    }
                    i3 = i2;
                }
            } else {
                if (String.valueOf(4).equals(recentChatFriendData.getOwnerName())) {
                    if (!TiebaApplication.h().Z()) {
                        str = "";
                    } else {
                        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) recentChatFriendData.getGroupSetting();
                        if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                            str = "";
                        }
                    }
                }
                i3 = i2;
            }
            cVar.g.setText(str);
        } else {
            cVar.g.setVisibility(8);
            i3 = unReadCount;
        }
        if (i == 1) {
            cVar.d.setTextColor(-8153171);
            cVar.e.setTextColor(-10391164);
            cVar.f.setTextColor(-10391164);
            if (i3 < 10) {
                if (i3 == 0) {
                    cVar.g.setBackgroundResource(R.drawable.icon_news_list_prompt_1);
                } else {
                    cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_one_1);
                }
            } else if (i3 < 100) {
                cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_two_1);
            } else {
                cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                cVar.g.setText("");
            }
            cVar.g.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_night));
            return;
        }
        cVar.d.setTextColor(-14277082);
        cVar.e.setTextColor(-7829368);
        cVar.f.setTextColor(-7829368);
        if (i3 < 10) {
            if (i3 == 0) {
                cVar.g.setBackgroundResource(R.drawable.icon_news_list_prompt);
            } else {
                cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_one);
            }
        } else if (i3 < 100) {
            cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_two);
        } else {
            cVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
            cVar.g.setText("");
        }
        cVar.g.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_day));
    }

    private void c(c cVar, RecentChatFriendData recentChatFriendData) {
        com.baidu.adp.lib.h.e.d("ownername:" + recentChatFriendData.getOwnerName());
        if (String.valueOf(2).equals(recentChatFriendData.getOwnerName())) {
            cVar.c.setDrawBorder(false);
            cVar.c.setAutoChangeStyle(false);
            cVar.c.setTag(recentChatFriendData.getOwnerName());
            if (TiebaApplication.h().an() == 1) {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.icon_new_test_1));
            } else {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.icon_new_test));
            }
            cVar.c.setUserName(String.valueOf(2));
            cVar.c.setUserId(recentChatFriendData.getFriendId());
            cVar.c.setIsRound(false);
            cVar.c.invalidate();
        } else if (String.valueOf(3).equals(recentChatFriendData.getOwnerName())) {
            cVar.c.setDrawBorder(false);
            cVar.c.setAutoChangeStyle(false);
            cVar.c.setTag(recentChatFriendData.getOwnerName());
            cVar.c.setUserName(String.valueOf(3));
            cVar.c.setUserId(recentChatFriendData.getFriendId());
            if (TiebaApplication.h().an() == 1) {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.icon_new_trends_1));
            } else {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.icon_new_trends));
            }
            cVar.c.setIsRound(false);
            cVar.c.invalidate();
        } else if (String.valueOf(1).equals(recentChatFriendData.getOwnerName())) {
            cVar.c.setDrawBorder(true);
            cVar.c.setAutoChangeStyle(true);
            cVar.c.setUserId(recentChatFriendData.getFriendId());
            String friendPortrait = recentChatFriendData.getFriendPortrait();
            String str = (String) cVar.c.getTag();
            if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str) && !str.equals(friendPortrait)) || TextUtils.isEmpty(str)) {
                com.baidu.adp.widget.ImageView.e d = this.h.d(friendPortrait);
                if (d != null) {
                    d.a(cVar.c);
                } else {
                    cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.avatar_poto_defaul140));
                }
            } else if (TextUtils.isEmpty(friendPortrait)) {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.avatar_poto_defaul140));
            }
            cVar.c.setClickable(false);
            cVar.c.setTag(recentChatFriendData.getFriendPortrait());
            cVar.c.setUserId(recentChatFriendData.getFriendId());
            com.baidu.adp.lib.h.e.d("groupid:" + recentChatFriendData.getFriendId() + " groupHeadUrl:" + recentChatFriendData.getFriendPortrait() + " groupName:" + recentChatFriendData.getFriendName());
            cVar.c.setUserName(String.valueOf(1));
            cVar.c.setIsRound(false);
            cVar.c.invalidate();
        } else {
            cVar.c.setDrawBorder(true);
            cVar.c.setAutoChangeStyle(true);
            String friendPortrait2 = recentChatFriendData.getFriendPortrait();
            String str2 = (String) cVar.c.getTag();
            if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait2)) || TextUtils.isEmpty(str2)) {
                com.baidu.adp.widget.ImageView.e c = this.h.c(friendPortrait2);
                if (c != null) {
                    c.a(cVar.c);
                } else {
                    cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
                }
            } else if (TextUtils.isEmpty(friendPortrait2)) {
                cVar.c.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
            }
            cVar.c.setTag(recentChatFriendData.getFriendPortrait());
            cVar.c.setUserId(recentChatFriendData.getFriendId());
            cVar.c.setUserName(recentChatFriendData.getFriendName());
            cVar.c.setOnClickListener(this.i);
            cVar.c.setIsRound(true);
            cVar.c.invalidate();
        }
    }

    private c a(View view) {
        c cVar = new c(this);
        cVar.a = (ViewGroup) view.findViewById(R.id.chat_item);
        cVar.b = (ViewGroup) view.findViewById(R.id.list_content);
        cVar.c = (HeadImageView) view.findViewById(R.id.chat_head);
        cVar.d = (TextView) view.findViewById(R.id.chat_name);
        cVar.e = (TextView) view.findViewById(R.id.last_chat_content);
        cVar.f = (TextView) view.findViewById(R.id.chat_time);
        cVar.g = (TextView) view.findViewById(R.id.new_message);
        cVar.h = (ViewGroup) view.findViewById(R.id.list_control);
        cVar.i = (TextView) view.findViewById(R.id.list_control_tv);
        cVar.j = (ProgressBar) view.findViewById(R.id.list_control_progress);
        cVar.k = (ImageView) view.findViewById(R.id.iv_bell);
        return cVar;
    }

    public void a(ChatListFragment chatListFragment) {
        this.b = chatListFragment;
    }

    public void a(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public com.baidu.tieba.util.i b() {
        return this.h;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }
}
