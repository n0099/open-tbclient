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
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i g;
    private a b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<ImMessageCenterShowItemData> h = null;

    public n(Context context) {
        this.a = null;
        this.g = null;
        this.a = context;
        this.g = new com.baidu.tieba.util.i(this.a);
        this.g.d(true);
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        this.h.clear();
        this.h.addAll(list);
        if (TiebaApplication.B()) {
            com.baidu.adp.lib.util.f.e("mRecentChatData.size():" + this.h.size());
            if (this.h.size() <= 0) {
                this.b.b(true);
            } else {
                this.b.b(false);
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
        o oVar;
        View view2;
        o oVar2 = null;
        if (view != null) {
            oVar2 = (o) view.getTag();
        }
        if (oVar2 == null) {
            view2 = LayoutInflater.from(this.a).inflate(R.layout.chat_list_item, viewGroup, false);
            o a = a(view2);
            view2.setTag(a);
            oVar = a;
        } else {
            oVar = oVar2;
            view2 = view;
        }
        int al = TiebaApplication.g().al();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.a.setVisibility(8);
            oVar.g.setVisibility(0);
            if (this.f) {
                oVar.h.setText(R.string.loading);
                oVar.i.setVisibility(0);
            } else {
                oVar.h.setText(R.string.frs_pre);
                oVar.i.setVisibility(8);
            }
            if (al == 1) {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square_1);
                oVar.h.setTextColor(-8682095);
            } else {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square);
                oVar.h.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.a.setVisibility(8);
            oVar.g.setVisibility(0);
            if (this.e) {
                oVar.h.setText(R.string.loading);
                oVar.i.setVisibility(0);
            } else {
                oVar.h.setText(R.string.frs_next);
                oVar.i.setVisibility(8);
            }
            if (al == 1) {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square_1);
                oVar.h.setTextColor(-8682095);
            } else {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square);
                oVar.h.setTextColor(-14277082);
            }
        } else {
            if (al == 1) {
                bq.e(view2, (int) R.drawable.common_list_item_bg_selector_1);
            } else {
                bq.e(view2, (int) R.drawable.common_list_item_bg_selector);
            }
            com.baidu.adp.lib.util.f.e("count:" + getCount());
            oVar.a.setVisibility(0);
            oVar.g.setVisibility(8);
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
            if (imMessageCenterShowItemData != null) {
                try {
                    oVar.c.setText(imMessageCenterShowItemData.getFriendName());
                    b(oVar, imMessageCenterShowItemData);
                    Date date = new Date();
                    date.setTime(imMessageCenterShowItemData.getServerTime());
                    String str = "";
                    if (imMessageCenterShowItemData.getServerTime() != 0) {
                        str = bs.e(date);
                    }
                    oVar.e.setText(str);
                    c(oVar, imMessageCenterShowItemData);
                    a(oVar, al, imMessageCenterShowItemData);
                    if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                        if (imMessageCenterShowItemData.getUnReadCount() >= 30) {
                            if (this.b != null) {
                                this.b.a(true);
                            }
                        } else if (this.b != null) {
                            this.b.a(false);
                        }
                    }
                    a(oVar, imMessageCenterShowItemData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    private void a(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (oVar != null) {
            if (imMessageCenterShowItemData == null) {
                oVar.j.setVisibility(8);
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                com.baidu.tieba.im.c.i groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    oVar.j.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    oVar.j.setVisibility(0);
                    if (TiebaApplication.g().al() == 1) {
                        oVar.j.setImageResource(R.drawable.icon_news_stop_1);
                    } else {
                        oVar.j.setImageResource(R.drawable.icon_news_stop);
                    }
                } else {
                    oVar.j.setVisibility(8);
                }
            } else {
                oVar.j.setVisibility(8);
            }
        }
    }

    private void b(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.c.setText(this.a.getString(R.string.updates_activity_title));
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
        } else {
            com.baidu.adp.lib.util.f.e(imMessageCenterShowItemData.getMsgContent());
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                oVar.d.setText((CharSequence) null);
            } else {
                oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
            }
        }
    }

    private void a(o oVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i2;
        String str;
        int i3 = 0;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        com.baidu.adp.lib.util.f.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
        if (unReadCount > 0) {
            oVar.f.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (TiebaApplication.g().M() == 0) {
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
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!TiebaApplication.g().Y()) {
                    str = "";
                } else {
                    GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                    if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                        str = "";
                    }
                    i3 = i2;
                }
            } else {
                if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                    if (!TiebaApplication.g().X()) {
                        str = "";
                    } else {
                        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                        if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                            str = "";
                        }
                    }
                }
                i3 = i2;
            }
            oVar.f.setText(str);
        } else {
            oVar.f.setVisibility(8);
            i3 = unReadCount;
        }
        if (i == 1) {
            oVar.c.setTextColor(-8153171);
            oVar.d.setTextColor(-10391164);
            oVar.e.setTextColor(-10391164);
            if (i3 < 10) {
                if (i3 == 0) {
                    oVar.f.setBackgroundResource(R.drawable.icon_news_list_prompt_1);
                } else {
                    oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_one_1);
                }
            } else if (i3 < 100) {
                oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_two_1);
            } else {
                oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                oVar.f.setText("");
            }
            oVar.f.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_night));
            return;
        }
        oVar.c.setTextColor(-13553101);
        oVar.d.setTextColor(-8749952);
        oVar.e.setTextColor(-3881012);
        if (i3 < 10) {
            if (i3 == 0) {
                oVar.f.setBackgroundResource(R.drawable.icon_news_list_prompt);
            } else {
                oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_one);
            }
        } else if (i3 < 100) {
            oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_two);
        } else {
            oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
            oVar.f.setText("");
        }
        oVar.f.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_day));
    }

    private void c(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        com.baidu.adp.lib.util.f.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(false);
            oVar.b.setAutoChangeStyle(false);
            oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
            if (TiebaApplication.g().al() == 1) {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_test_1));
            } else {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_test));
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
            if (TiebaApplication.g().al() == 1) {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_trends_1));
            } else {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_trends));
            }
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            oVar.b.setDrawBorder(true);
            oVar.b.setAutoChangeStyle(true);
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            String str = (String) oVar.b.getTag();
            if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str) && !str.equals(friendPortrait)) || TextUtils.isEmpty(str)) {
                com.baidu.adp.widget.ImageView.b d = this.g.d(friendPortrait);
                if (d != null) {
                    d.a(oVar.b);
                } else {
                    oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.avatar_poto_defaul140));
                }
            } else if (TextUtils.isEmpty(friendPortrait)) {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.avatar_poto_defaul140));
            }
            oVar.b.setClickable(false);
            oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            com.baidu.adp.lib.util.f.e("groupid:" + imMessageCenterShowItemData.getFriendId() + " groupHeadUrl:" + imMessageCenterShowItemData.getFriendPortrait() + " groupName:" + imMessageCenterShowItemData.getFriendName());
            oVar.b.setUserName(String.valueOf(1));
            oVar.b.setIsRound(false);
            oVar.b.invalidate();
        } else {
            oVar.b.setDrawBorder(true);
            oVar.b.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            String str2 = (String) oVar.b.getTag();
            if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait2)) || TextUtils.isEmpty(str2)) {
                com.baidu.adp.widget.ImageView.b c = this.g.c(friendPortrait2);
                if (c != null) {
                    c.a(oVar.b);
                } else {
                    oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
                }
            } else if (TextUtils.isEmpty(friendPortrait2)) {
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
            }
            oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
            oVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
            oVar.b.setIsRound(true);
            oVar.b.invalidate();
        }
    }

    private o a(View view) {
        o oVar = new o(this, null);
        oVar.a = (ViewGroup) view.findViewById(R.id.list_content);
        oVar.b = (HeadImageView) view.findViewById(R.id.chat_head);
        oVar.c = (TextView) view.findViewById(R.id.chat_name);
        oVar.d = (TextView) view.findViewById(R.id.last_chat_content);
        oVar.e = (TextView) view.findViewById(R.id.chat_time);
        oVar.f = (TextView) view.findViewById(R.id.new_message);
        oVar.g = (ViewGroup) view.findViewById(R.id.list_control);
        oVar.h = (TextView) view.findViewById(R.id.list_control_tv);
        oVar.i = (ProgressBar) view.findViewById(R.id.list_control_progress);
        oVar.j = (ImageView) view.findViewById(R.id.iv_bell);
        return oVar;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public com.baidu.tieba.util.i a() {
        return this.g;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }
}
