package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class au extends BaseAdapter {
    private OfficialBarTipActivity a;
    private List<ImMessageCenterShowItemData> b = new ArrayList();

    public au(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.b.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        av avVar;
        if (view != null) {
            avVar = (av) view.getTag();
        } else {
            view = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.chat_list_item, viewGroup, false);
            av b = b(view);
            view.setTag(b);
            avVar = b;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            com.baidu.tbadk.core.util.ay.e(view, com.baidu.tieba.t.list_selector_1);
        } else {
            com.baidu.tbadk.core.util.ay.e(view, com.baidu.tieba.t.list_selector);
        }
        com.baidu.tbadk.core.util.ay.f(avVar.g, com.baidu.tieba.r.cp_bg_line_b);
        avVar.h.setVisibility(0);
        avVar.g.setVisibility(0);
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            avVar.c.setText(this.a.getString(com.baidu.tieba.x.official_msg_list_name, new Object[]{imMessageCenterShowItemData.getFriendName()}));
            avVar.d.setText(imMessageCenterShowItemData.getMsgContent());
            a(avVar, imMessageCenterShowItemData);
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                avVar.e.setText(com.baidu.tbadk.core.util.ba.f(new Date(imMessageCenterShowItemData.getServerTime())));
            }
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                avVar.b.setVisibility(0);
                a(imMessageCenterShowItemData, avVar.b, imMessageCenterShowItemData.getUnReadCount());
            } else {
                avVar.b.setVisibility(8);
            }
            avVar.f.setVisibility(8);
            a(avVar.f, imMessageCenterShowItemData);
            avVar.a.setTag(null);
            avVar.a.setDrawBorder(true);
            avVar.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            avVar.a.setDefaultResource(com.baidu.tieba.t.icon_default_ba_120);
            avVar.a.setNightDefaultResource(com.baidu.tieba.t.icon_default_ba_120_1);
            if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                avVar.a.setTag(imMessageCenterShowItemData.getFriendPortrait());
                avVar.a.a(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
            }
        }
        a(view);
        return view;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, TextView textView, int i) {
        if (imMessageCenterShowItemData != null && textView != null) {
            if (TbadkApplication.m252getInst().getMsgFrequency() == 0) {
                i = 0;
            }
            if (!TbadkApplication.m252getInst().isMsgChatOn()) {
                i = 0;
            }
            if (!imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                i = 0;
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (i == 0) {
                    textView.setBackgroundResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
                    textView.setText("");
                    textView.setWidth(0);
                    textView.setHeight(0);
                } else if (i < 10) {
                    textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_one_1);
                    textView.setText(String.valueOf(i));
                } else if (i < 100) {
                    textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_two_1);
                    textView.setText(String.valueOf(i));
                } else {
                    textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_more_1);
                    textView.setText("");
                }
                textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.top_msg_num_night));
                return;
            }
            if (i == 0) {
                textView.setBackgroundResource(com.baidu.tieba.t.icon_news_down_bar_one);
                textView.setWidth(0);
                textView.setHeight(0);
                textView.setText("");
            } else if (i < 10) {
                textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_one);
                textView.setText(String.valueOf(i));
            } else if (i < 100) {
                textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_two);
                textView.setText(String.valueOf(i));
            } else {
                textView.setBackgroundResource(com.baidu.tieba.t.icon_news_head_prompt_more);
                textView.setText("");
            }
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.top_msg_num_day));
        }
    }

    private av b(View view) {
        av avVar = new av(null);
        avVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.u.chat_head);
        avVar.b = (TextView) view.findViewById(com.baidu.tieba.u.new_message);
        avVar.c = (TextView) view.findViewById(com.baidu.tieba.u.chat_name);
        avVar.d = (TextView) view.findViewById(com.baidu.tieba.u.last_chat_content);
        avVar.e = (TextView) view.findViewById(com.baidu.tieba.u.chat_time);
        avVar.f = (ImageView) view.findViewById(com.baidu.tieba.u.iv_bell);
        avVar.g = view.findViewById(com.baidu.tieba.u.line);
        avVar.h = (ViewGroup) view.findViewById(com.baidu.tieba.u.list_content);
        avVar.i = (ImageView) view.findViewById(com.baidu.tieba.u.send_status);
        return avVar;
    }

    private void a(av avVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (avVar != null && imMessageCenterShowItemData != null) {
            avVar.i.setVisibility(0);
            if (imMessageCenterShowItemData.getSendStatus() == 2) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    avVar.i.setBackgroundResource(com.baidu.tieba.t.icon_send_failed_information_1);
                } else {
                    avVar.i.setBackgroundResource(com.baidu.tieba.t.icon_send_failed_information);
                }
            } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    avVar.i.setBackgroundResource(com.baidu.tieba.t.icon_send_in_information_1);
                } else {
                    avVar.i.setBackgroundResource(com.baidu.tieba.t.icon_send_in_information);
                }
            } else if (imMessageCenterShowItemData.getSendStatus() == 3) {
                avVar.i.setVisibility(8);
            } else {
                avVar.i.setVisibility(8);
            }
        }
    }

    private void a(ImageView imageView, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null && imageView != null) {
            if (imMessageCenterShowItemData.getGroupSetting() == null) {
                imageView.setVisibility(8);
            } else if (!imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                imageView.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    imageView.setImageResource(com.baidu.tieba.t.icon_news_stop_1);
                } else {
                    imageView.setImageResource(com.baidu.tieba.t.icon_news_stop);
                }
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
