package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private Context a;
    private ab g;
    private b b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<ImMessageCenterShowItemData> h = null;

    public s(Context context) {
        this.a = null;
        this.g = null;
        this.a = context;
        this.g = new ab(this.a);
        this.g.d(true);
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        this.h.clear();
        for (int i = 0; i < list.size(); i++) {
            this.h.add(list.get(i));
        }
        if (TbadkApplication.isLogin()) {
            BdLog.d("mRecentChatData.size():" + this.h.size());
            if (this.h.size() <= 0) {
                this.b.c(true);
            } else {
                this.b.c(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.h != null) {
            int size = this.h.size();
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
        if (itemId < 0 || itemId >= this.h.size()) {
            return null;
        }
        return this.h.get(itemId);
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
        t tVar;
        View view2;
        t tVar2 = null;
        if (view != null) {
            tVar2 = (t) view.getTag();
        }
        if (tVar2 == null) {
            view2 = LayoutInflater.from(this.a).inflate(w.chat_list_item, viewGroup, false);
            t a = a(view2);
            view2.setTag(a);
            tVar = a;
        } else {
            tVar = tVar2;
            view2 = view;
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            tVar.a.setVisibility(8);
            tVar.g.setVisibility(8);
            tVar.h.setVisibility(0);
            if (this.f) {
                tVar.i.setText(y.loading);
                tVar.j.setVisibility(0);
            } else {
                tVar.i.setText(y.frs_pre);
                tVar.j.setVisibility(8);
            }
            if (skinType == 1) {
                bc.e((View) tVar.i, u.btn_w_square_1);
                tVar.i.setTextColor(-8682095);
            } else {
                bc.e((View) tVar.i, u.btn_w_square);
                tVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            tVar.a.setVisibility(8);
            tVar.g.setVisibility(8);
            tVar.h.setVisibility(0);
            if (this.e) {
                tVar.i.setText(y.loading);
                tVar.j.setVisibility(0);
            } else {
                tVar.i.setText(y.frs_next);
                tVar.j.setVisibility(8);
            }
            if (skinType == 1) {
                bc.e((View) tVar.i, u.btn_w_square_1);
                tVar.i.setTextColor(-8682095);
            } else {
                bc.e((View) tVar.i, u.btn_w_square);
                tVar.i.setTextColor(-14277082);
            }
        } else {
            if (skinType == 1) {
                bc.e(view2, u.list_selector_1);
            } else {
                bc.e(view2, u.list_selector);
            }
            bc.f(tVar.g, com.baidu.tieba.s.cp_bg_line_b);
            BdLog.d("count:" + getCount());
            tVar.a.setVisibility(0);
            tVar.g.setVisibility(0);
            tVar.h.setVisibility(8);
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
            if (imMessageCenterShowItemData != null) {
                try {
                    tVar.c.setText(imMessageCenterShowItemData.getFriendName());
                    b(tVar, imMessageCenterShowItemData);
                    Date date = new Date();
                    date.setTime(imMessageCenterShowItemData.getServerTime());
                    String str = "";
                    if (imMessageCenterShowItemData.getServerTime() != 0) {
                        str = be.f(date);
                    }
                    tVar.e.setText(str);
                    c(tVar, imMessageCenterShowItemData);
                    a(tVar, skinType, imMessageCenterShowItemData);
                    if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                        if (imMessageCenterShowItemData.getUnReadCount() >= 30) {
                            if (this.b != null) {
                                this.b.a(true);
                            }
                        } else if (this.b != null) {
                            this.b.a(false);
                        }
                    }
                    a(tVar, imMessageCenterShowItemData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    private void a(t tVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (tVar != null) {
            if (imMessageCenterShowItemData == null) {
                tVar.k.setVisibility(8);
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                com.baidu.tieba.im.pushNotify.m groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    tVar.k.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    tVar.k.setVisibility(0);
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        tVar.k.setImageResource(u.icon_news_stop_1);
                    } else {
                        tVar.k.setImageResource(u.icon_news_stop);
                    }
                } else {
                    tVar.k.setVisibility(8);
                }
            } else {
                tVar.k.setVisibility(8);
            }
        }
    }

    private void b(t tVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.c.setText(this.a.getString(y.updates_activity_title));
            tVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.c.setText(this.a.getString(y.live_chat_room_more_livenotify));
            tVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.c.setText(this.a.getString(y.official_message_activity_title));
            tVar.d.setText(a(imMessageCenterShowItemData.isSelf(), imMessageCenterShowItemData.getMsgContent()));
        } else {
            BdLog.d(imMessageCenterShowItemData.getMsgContent());
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                tVar.d.setText((CharSequence) null);
            } else {
                tVar.d.setText(imMessageCenterShowItemData.getMsgContent());
            }
        }
    }

    private String a(boolean z, String str) {
        if (TextUtils.isEmpty(str.trim())) {
            return "";
        }
        if (z) {
            return this.a.getString(y.official_msg_pre, str);
        }
        String[] split = str.split(":");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? str : String.valueOf(this.a.getString(y.official_msg_list_name, split[0])) + ":" + split[1];
    }

    private void a(t tVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i2;
        String str;
        int i3 = 0;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        BdLog.d("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
        if (unReadCount > 0) {
            tVar.f.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (TbadkApplication.m252getInst().getMsgFrequency() == 0) {
                str = "";
                i2 = 0;
            } else {
                i2 = unReadCount;
                str = valueOf;
            }
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
            } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!TbadkApplication.m252getInst().isGroupMsgOn()) {
                    str = "";
                } else {
                    GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                    if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                        str = "";
                    }
                    i3 = i2;
                }
            } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!TbadkApplication.m252getInst().isMsgChatOn()) {
                    str = "";
                } else {
                    PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                    if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                        str = "";
                    }
                    i3 = i2;
                }
            } else {
                if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) && !TbadkApplication.m252getInst().isMsgChatOn()) {
                    str = "";
                }
                i3 = i2;
            }
            tVar.f.setText(str);
        } else {
            tVar.f.setVisibility(8);
            i3 = unReadCount;
        }
        if (i == 1) {
            tVar.c.setTextColor(-8153171);
            tVar.d.setTextColor(-10391164);
            tVar.e.setTextColor(-10391164);
            if (i3 < 10) {
                if (i3 == 0) {
                    tVar.f.setBackgroundResource(u.icon_news_list_prompt_1);
                } else {
                    tVar.f.setBackgroundResource(u.icon_news_head_prompt_one_1);
                }
            } else if (i3 < 100) {
                tVar.f.setBackgroundResource(u.icon_news_head_prompt_two_1);
            } else {
                tVar.f.setBackgroundResource(u.icon_news_head_prompt_more_1);
                tVar.f.setText("");
            }
            tVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_night));
            return;
        }
        tVar.c.setTextColor(-13553101);
        tVar.d.setTextColor(-8749952);
        tVar.e.setTextColor(-3881012);
        if (i3 < 10) {
            if (i3 == 0) {
                tVar.f.setBackgroundResource(u.icon_news_list_prompt);
            } else {
                tVar.f.setBackgroundResource(u.icon_news_head_prompt_one);
            }
        } else if (i3 < 100) {
            tVar.f.setBackgroundResource(u.icon_news_head_prompt_two);
        } else {
            tVar.f.setBackgroundResource(u.icon_news_head_prompt_more);
            tVar.f.setText("");
        }
        tVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_day));
    }

    private void c(t tVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        BdLog.d("ownername:" + imMessageCenterShowItemData.getOwnerName());
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.b.setDrawBorder(false);
            tVar.b.setAutoChangeStyle(false);
            tVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_test_1));
            } else {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_test));
            }
            tVar.b.setUserName(String.valueOf(2));
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            tVar.b.setIsRound(false);
            tVar.b.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.b.setDrawBorder(false);
            tVar.b.setAutoChangeStyle(false);
            tVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            tVar.b.setUserName(String.valueOf(3));
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_trends_1));
            } else {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_trends));
            }
            tVar.b.setIsRound(false);
            tVar.b.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.b.setDrawBorder(false);
            tVar.b.setAutoChangeStyle(false);
            tVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            tVar.b.setUserName(String.valueOf(6));
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_live_1));
            } else {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_live));
            }
            tVar.b.setIsRound(false);
            tVar.b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.b.setDrawBorder(true);
            tVar.b.setAutoChangeStyle(true);
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            String str = (String) tVar.b.getTag();
            if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str) && !str.equals(friendPortrait)) || TextUtils.isEmpty(str)) {
                com.baidu.adp.widget.a.a d = this.g.d(friendPortrait);
                if (d != null) {
                    d.a(tVar.b);
                } else {
                    tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.avatar_poto_defaul140));
                }
            } else if (TextUtils.isEmpty(friendPortrait)) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.avatar_poto_defaul140));
            }
            tVar.b.setClickable(false);
            tVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            BdLog.d("groupid:" + imMessageCenterShowItemData.getFriendId() + " groupHeadUrl:" + imMessageCenterShowItemData.getFriendPortrait() + " groupName:" + imMessageCenterShowItemData.getFriendName());
            tVar.b.setUserName(String.valueOf(1));
            tVar.b.setIsRound(false);
            tVar.b.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            tVar.b.setDrawBorder(false);
            tVar.b.setAutoChangeStyle(false);
            tVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            tVar.b.setUserName(String.valueOf(5));
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_official_1));
            } else {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.icon_new_official));
            }
            tVar.b.setIsRound(false);
            tVar.b.invalidate();
        } else {
            tVar.b.setDrawBorder(true);
            tVar.b.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            String str2 = (String) tVar.b.getTag();
            if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait2)) || TextUtils.isEmpty(str2)) {
                com.baidu.adp.widget.a.a c = this.g.c(friendPortrait2);
                if (c != null) {
                    c.a(tVar.b);
                } else {
                    tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.person_photo));
                }
            } else if (TextUtils.isEmpty(friendPortrait2)) {
                tVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(u.person_photo));
            }
            tVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            tVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            tVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
            tVar.b.setIsRound(true);
            tVar.b.invalidate();
        }
    }

    private t a(View view) {
        t tVar = new t(this, null);
        tVar.a = (ViewGroup) view.findViewById(v.list_content);
        tVar.b = (HeadImageView) view.findViewById(v.chat_head);
        tVar.c = (TextView) view.findViewById(v.chat_name);
        tVar.d = (TextView) view.findViewById(v.last_chat_content);
        tVar.e = (TextView) view.findViewById(v.chat_time);
        tVar.g = view.findViewById(v.line);
        tVar.f = (TextView) view.findViewById(v.new_message);
        tVar.h = (ViewGroup) view.findViewById(v.list_control);
        tVar.i = (TextView) view.findViewById(v.list_control_tv);
        tVar.j = (ProgressBar) view.findViewById(v.list_control_progress);
        tVar.k = (ImageView) view.findViewById(v.iv_bell);
        return tVar;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public ab a() {
        return this.g;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }
}
