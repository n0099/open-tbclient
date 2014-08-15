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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context a;
    private e b = null;
    private List<ImMessageCenterShowItemData> c = null;

    public n(Context context) {
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
        o oVar = null;
        if (view != null) {
            oVar = (o) view.getTag();
        }
        if (oVar == null) {
            view = LayoutInflater.from(this.a).inflate(v.chat_list_item, viewGroup, false);
            oVar = a(view);
            view.setTag(oVar);
        }
        o oVar2 = oVar;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType == 1) {
            ay.e(view, t.list_selector_1);
        } else {
            ay.e(view, t.list_selector);
        }
        ay.f(oVar2.g, r.cp_bg_line_b);
        oVar2.a.setVisibility(0);
        oVar2.g.setVisibility(0);
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            try {
                oVar2.c.setText(imMessageCenterShowItemData.getFriendName());
                b(oVar2, imMessageCenterShowItemData);
                d(oVar2, imMessageCenterShowItemData);
                Date date = new Date();
                date.setTime(imMessageCenterShowItemData.getServerTime());
                String str = "";
                if (imMessageCenterShowItemData.getServerTime() != 0) {
                    str = ba.f(date);
                }
                oVar2.e.setText(str);
                c(oVar2, imMessageCenterShowItemData);
                a(oVar2, skinType, imMessageCenterShowItemData);
                if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                    if (imMessageCenterShowItemData.getUnReadCount() >= 30) {
                        if (this.b != null) {
                            this.b.a(true);
                        }
                    } else if (this.b != null) {
                        this.b.a(false);
                    }
                }
                a(oVar2, imMessageCenterShowItemData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    private void a(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (oVar != null) {
            if (imMessageCenterShowItemData == null) {
                oVar.h.setVisibility(8);
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    oVar.h.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    oVar.h.setVisibility(0);
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        oVar.h.setImageResource(t.icon_news_stop_1);
                    } else {
                        oVar.h.setImageResource(t.icon_news_stop);
                    }
                } else {
                    oVar.h.setVisibility(8);
                }
            } else {
                oVar.h.setVisibility(8);
            }
        }
    }

    private void b(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.c.setText(this.a.getString(x.updates_activity_title));
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.c.setText(this.a.getString(x.live_chat_room_more_livenotify));
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.c.setText(this.a.getString(x.official_message_activity_title));
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.c.setText(this.a.getString(x.stranger_message_activity_title));
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            oVar.d.setText((CharSequence) null);
        } else {
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void a(o oVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i2;
        String str;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            oVar.f.setVisibility(0);
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
            oVar.f.setText(str);
        } else {
            oVar.f.setVisibility(8);
            i2 = unReadCount;
        }
        if (i == 1) {
            oVar.c.setTextColor(this.a.getResources().getColor(r.cp_cont_b_1));
            oVar.d.setTextColor(this.a.getResources().getColor(r.cp_cont_d_1));
            oVar.e.setTextColor(this.a.getResources().getColor(r.cp_cont_e_1));
            if (i2 < 10) {
                if (i2 == 0) {
                    oVar.f.setBackgroundResource(t.icon_news_down_bar_one_1);
                    oVar.f.setWidth(0);
                    oVar.f.setHeight(0);
                } else {
                    oVar.f.setBackgroundResource(t.icon_news_head_prompt_one_1);
                }
            } else if (i2 < 100) {
                oVar.f.setBackgroundResource(t.icon_news_head_prompt_two_1);
            } else {
                oVar.f.setBackgroundResource(t.icon_news_head_prompt_more_1);
                oVar.f.setText("");
            }
            oVar.f.setTextColor(this.a.getResources().getColor(r.top_msg_num_night));
            return;
        }
        oVar.c.setTextColor(this.a.getResources().getColor(r.cp_cont_b));
        oVar.d.setTextColor(this.a.getResources().getColor(r.cp_cont_d));
        oVar.e.setTextColor(this.a.getResources().getColor(r.cp_cont_e));
        if (i2 < 10) {
            if (i2 == 0) {
                oVar.f.setBackgroundResource(t.icon_news_down_bar_one);
                oVar.f.setWidth(0);
                oVar.f.setHeight(0);
            } else {
                oVar.f.setBackgroundResource(t.icon_news_head_prompt_one);
            }
        } else if (i2 < 100) {
            oVar.f.setBackgroundResource(t.icon_news_head_prompt_two);
        } else {
            oVar.f.setBackgroundResource(t.icon_news_head_prompt_more);
            oVar.f.setText("");
        }
        oVar.f.setTextColor(this.a.getResources().getColor(r.top_msg_num_day));
    }

    private void c(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        oVar.b.setDrawerType(1);
        oVar.b.setRadius(com.baidu.adp.lib.util.j.a(this.a, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                oVar.b.a(String.valueOf(t.icon_new_test_1), 24, false);
            } else {
                oVar.b.a(String.valueOf(t.icon_new_test), 24, false);
            }
            oVar.b.setUserName(String.valueOf(2));
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            oVar.b.setUserName(String.valueOf(3));
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                oVar.b.a(String.valueOf(t.icon_new_trends_1), 24, false);
            } else {
                oVar.b.a(String.valueOf(t.icon_new_trends), 24, false);
            }
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            oVar.b.setUserName(String.valueOf(6));
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                oVar.b.a(String.valueOf(t.icon_new_live_1), 24, false);
            } else {
                oVar.b.a(String.valueOf(t.icon_new_live), 24, false);
            }
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(true);
            oVar.b.setAutoChangeStyle(true);
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            if (TextUtils.isEmpty(friendPortrait)) {
                oVar.b.a(String.valueOf(t.avatar_poto_defaul140), 24, false);
            } else {
                oVar.b.a(friendPortrait, 10, false);
            }
            oVar.b.setClickable(false);
            oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            oVar.b.setUserName(String.valueOf(1));
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            oVar.b.setUserName(String.valueOf(5));
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                oVar.b.a(String.valueOf(t.icon_new_official_1), 24, false);
            } else {
                oVar.b.a(String.valueOf(t.icon_new_official), 24, false);
            }
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            oVar.b.setUserName(String.valueOf(7));
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                oVar.b.a(String.valueOf(t.icon_new_stranger_1), 24, false);
            } else {
                oVar.b.a(String.valueOf(t.icon_new_stranger), 24, false);
            }
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else {
            oVar.b.setDrawBorder(true);
            oVar.b.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            if (!TextUtils.isEmpty(friendPortrait2)) {
                oVar.b.a(friendPortrait2, 12, false);
            } else {
                oVar.b.a(String.valueOf(t.person_photo), 24, false);
            }
            oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            oVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        }
    }

    private o a(View view) {
        o oVar = new o(this, null);
        oVar.a = (ViewGroup) view.findViewById(u.list_content);
        oVar.b = (HeadImageView) view.findViewById(u.chat_head);
        oVar.c = (TextView) view.findViewById(u.chat_name);
        oVar.d = (TextView) view.findViewById(u.last_chat_content);
        oVar.e = (TextView) view.findViewById(u.chat_time);
        oVar.g = view.findViewById(u.line);
        oVar.f = (TextView) view.findViewById(u.new_message);
        oVar.h = (ImageView) view.findViewById(u.iv_bell);
        oVar.i = (ImageView) view.findViewById(u.send_status);
        return oVar;
    }

    public void a(e eVar) {
        this.b = eVar;
    }

    private void d(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (oVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                oVar.i.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        oVar.i.setBackgroundResource(t.icon_send_failed_information_1);
                        return;
                    } else {
                        oVar.i.setBackgroundResource(t.icon_send_failed_information);
                        return;
                    }
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        oVar.i.setBackgroundResource(t.icon_send_in_information_1);
                        return;
                    } else {
                        oVar.i.setBackgroundResource(t.icon_send_in_information);
                        return;
                    }
                } else if (imMessageCenterShowItemData.getSendStatus() == 3) {
                    oVar.i.setVisibility(8);
                    return;
                } else {
                    oVar.i.setVisibility(8);
                    return;
                }
            }
            oVar.i.setVisibility(8);
        }
    }
}
