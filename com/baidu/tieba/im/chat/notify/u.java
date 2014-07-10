package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private Context a;
    private d b = null;
    private List<ImMessageCenterShowItemData> c = null;

    public u(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.clear();
        for (int i = 0; i < list.size(); i++) {
            this.c.add(list.get(i));
        }
        if (TbadkApplication.isLogin()) {
            if (this.c.size() <= 0) {
                this.b.c(true);
            } else {
                this.b.c(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.c.size()) {
            return null;
        }
        return this.c.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar = null;
        if (view != null) {
            vVar = (v) view.getTag();
        }
        if (vVar == null) {
            view = LayoutInflater.from(this.a).inflate(w.chat_list_item, viewGroup, false);
            vVar = a(view);
            view.setTag(vVar);
        }
        v vVar2 = vVar;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType == 1) {
            bk.e(view, com.baidu.tieba.u.list_selector_1);
        } else {
            bk.e(view, com.baidu.tieba.u.list_selector);
        }
        bk.f(vVar2.g, com.baidu.tieba.s.cp_bg_line_b);
        vVar2.a.setVisibility(0);
        vVar2.g.setVisibility(0);
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            try {
                vVar2.c.setText(imMessageCenterShowItemData.getFriendName());
                b(vVar2, imMessageCenterShowItemData);
                Date date = new Date();
                date.setTime(imMessageCenterShowItemData.getServerTime());
                String str = "";
                if (imMessageCenterShowItemData.getServerTime() != 0) {
                    str = bm.f(date);
                }
                vVar2.e.setText(str);
                c(vVar2, imMessageCenterShowItemData);
                a(vVar2, skinType, imMessageCenterShowItemData);
                if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                    if (imMessageCenterShowItemData.getUnReadCount() >= 30) {
                        if (this.b != null) {
                            this.b.a(true);
                        }
                    } else if (this.b != null) {
                        this.b.a(false);
                    }
                }
                a(vVar2, imMessageCenterShowItemData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    private void a(v vVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (vVar != null) {
            if (imMessageCenterShowItemData == null) {
                vVar.h.setVisibility(8);
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                com.baidu.tieba.im.pushNotify.n groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    vVar.h.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    vVar.h.setVisibility(0);
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        vVar.h.setImageResource(com.baidu.tieba.u.icon_news_stop_1);
                    } else {
                        vVar.h.setImageResource(com.baidu.tieba.u.icon_news_stop);
                    }
                } else {
                    vVar.h.setVisibility(8);
                }
            } else {
                vVar.h.setVisibility(8);
            }
        }
    }

    private void b(v vVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.c.setText(this.a.getString(y.updates_activity_title));
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.c.setText(this.a.getString(y.live_chat_room_more_livenotify));
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.c.setText(this.a.getString(y.official_message_activity_title));
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.c.setText(this.a.getString(y.stranger_message_activity_title));
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            vVar.d.setText((CharSequence) null);
        } else {
            vVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void a(v vVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i2;
        String str;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            vVar.f.setVisibility(0);
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
                i2 = 0;
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
                i2 = 0;
            } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
                i2 = 0;
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
                i2 = 0;
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!TbadkApplication.m252getInst().isGroupMsgOn()) {
                    str = "";
                    i2 = 0;
                } else {
                    GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                    if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                        str = "";
                        i2 = 0;
                    }
                }
            } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!TbadkApplication.m252getInst().isMsgChatOn()) {
                    str = "";
                    i2 = 0;
                } else {
                    PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                    if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                        str = "";
                        i2 = 0;
                    }
                }
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) && !TbadkApplication.m252getInst().isMsgChatOn()) {
                str = "";
                i2 = 0;
            }
            vVar.f.setText(str);
        } else {
            vVar.f.setVisibility(8);
            i2 = unReadCount;
        }
        if (i == 1) {
            vVar.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_b_1));
            vVar.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
            vVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_e_1));
            if (i2 < 10) {
                if (i2 == 0) {
                    vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
                    vVar.f.setWidth(0);
                    vVar.f.setHeight(0);
                } else {
                    vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one_1);
                }
            } else if (i2 < 100) {
                vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two_1);
            } else {
                vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more_1);
                vVar.f.setText("");
            }
            vVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_night));
            return;
        }
        vVar.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_b));
        vVar.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
        vVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_e));
        if (i2 < 10) {
            if (i2 == 0) {
                vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_down_bar_one);
                vVar.f.setWidth(0);
                vVar.f.setHeight(0);
            } else {
                vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one);
            }
        } else if (i2 < 100) {
            vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two);
        } else {
            vVar.f.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more);
            vVar.f.setText("");
        }
        vVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_day));
    }

    private void c(v vVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        vVar.b.setDrawerType(1);
        vVar.b.setRadius(com.baidu.adp.lib.util.j.a(this.a, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(false);
            vVar.b.setAutoChangeStyle(false);
            vVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_test_1), 24, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_test), 24, false);
            }
            vVar.b.setUserName(String.valueOf(2));
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(false);
            vVar.b.setAutoChangeStyle(false);
            vVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            vVar.b.setUserName(String.valueOf(3));
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_trends_1), 24, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_trends), 24, false);
            }
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(false);
            vVar.b.setAutoChangeStyle(false);
            vVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            vVar.b.setUserName(String.valueOf(6));
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_live_1), 24, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_live), 24, false);
            }
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(true);
            vVar.b.setAutoChangeStyle(true);
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            if (TextUtils.isEmpty(friendPortrait)) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.avatar_poto_defaul140), 24, false);
            } else {
                vVar.b.a(friendPortrait, 10, false);
            }
            vVar.b.setClickable(false);
            vVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            vVar.b.setUserName(String.valueOf(1));
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(false);
            vVar.b.setAutoChangeStyle(false);
            vVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            vVar.b.setUserName(String.valueOf(5));
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_official_1), 24, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_official), 24, false);
            }
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            vVar.b.setDrawBorder(false);
            vVar.b.setAutoChangeStyle(false);
            vVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            vVar.b.setUserName(String.valueOf(7));
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_stranger_1), 24, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.icon_new_stranger), 24, false);
            }
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        } else {
            vVar.b.setDrawBorder(true);
            vVar.b.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            if (!TextUtils.isEmpty(friendPortrait2)) {
                vVar.b.a(friendPortrait2, 12, false);
            } else {
                vVar.b.a(String.valueOf(com.baidu.tieba.u.person_photo), 24, false);
            }
            vVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            vVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            vVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
            vVar.b.setIsRound(false);
            vVar.b.invalidate();
        }
    }

    private v a(View view) {
        v vVar = new v(this, null);
        vVar.a = (ViewGroup) view.findViewById(com.baidu.tieba.v.list_content);
        vVar.b = (HeadImageView) view.findViewById(com.baidu.tieba.v.chat_head);
        vVar.c = (TextView) view.findViewById(com.baidu.tieba.v.chat_name);
        vVar.d = (TextView) view.findViewById(com.baidu.tieba.v.last_chat_content);
        vVar.e = (TextView) view.findViewById(com.baidu.tieba.v.chat_time);
        vVar.g = view.findViewById(com.baidu.tieba.v.line);
        vVar.f = (TextView) view.findViewById(com.baidu.tieba.v.new_message);
        vVar.h = (ImageView) view.findViewById(com.baidu.tieba.v.iv_bell);
        return vVar;
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public void a(View.OnClickListener onClickListener) {
    }
}
