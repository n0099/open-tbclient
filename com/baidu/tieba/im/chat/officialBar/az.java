package com.baidu.tieba.im.chat.officialBar;

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
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class az extends BaseAdapter {
    private OfficialBarTipActivity a;
    private List<ImMessageCenterShowItemData> b = new ArrayList();
    private com.baidu.tbadk.editortool.aa c;

    public az(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
        this.c = new com.baidu.tbadk.editortool.aa(officialBarTipActivity);
        this.c.b(true);
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
        ba baVar;
        if (view != null) {
            baVar = (ba) view.getTag();
        } else {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.chat_list_item, viewGroup, false);
            ba b = b(view);
            view.setTag(b);
            baVar = b;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            bk.e(view, com.baidu.tieba.u.list_selector_1);
        } else {
            bk.e(view, com.baidu.tieba.u.list_selector);
        }
        bk.f(baVar.g, com.baidu.tieba.s.cp_bg_line_b);
        baVar.h.setVisibility(0);
        baVar.g.setVisibility(0);
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            baVar.c.setText(this.a.getString(com.baidu.tieba.y.official_msg_list_name, new Object[]{imMessageCenterShowItemData.getFriendName()}));
            baVar.d.setText(a(imMessageCenterShowItemData.getMsgContent()));
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                baVar.e.setText(bm.f(new Date(imMessageCenterShowItemData.getServerTime())));
            }
            baVar.f.setVisibility(8);
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                baVar.b.setVisibility(0);
                a(imMessageCenterShowItemData, baVar.b, baVar.f, imMessageCenterShowItemData.getUnReadCount());
            } else {
                baVar.b.setVisibility(8);
            }
            baVar.a.setTag(null);
            baVar.a.setDrawBorder(true);
            baVar.a.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
            baVar.a.setNightDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
            baVar.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                baVar.a.setTag(imMessageCenterShowItemData.getFriendPortrait());
            }
        }
        a(view);
        return view;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(":");
        if (split.length == 2) {
            String str2 = split[1];
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        }
        return str;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, TextView textView, ImageView imageView, int i) {
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
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
                textView.setText("");
                textView.setWidth(0);
                textView.setHeight(0);
                imageView.setVisibility(0);
            } else if (i < 10) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one_1);
                textView.setText(String.valueOf(i));
            } else if (i < 100) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two_1);
                textView.setText(String.valueOf(i));
            } else {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more_1);
                textView.setText("");
            }
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_night));
            return;
        }
        if (i == 0) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_down_bar_one);
            textView.setWidth(0);
            textView.setHeight(0);
            textView.setText("");
            imageView.setVisibility(0);
        } else if (i < 10) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one);
            textView.setText(String.valueOf(i));
        } else if (i < 100) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two);
            textView.setText(String.valueOf(i));
        } else {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more);
            textView.setText("");
        }
        textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.top_msg_num_day));
    }

    private ba b(View view) {
        ba baVar = new ba(null);
        baVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.v.chat_head);
        baVar.b = (TextView) view.findViewById(com.baidu.tieba.v.new_message);
        baVar.c = (TextView) view.findViewById(com.baidu.tieba.v.chat_name);
        baVar.d = (TextView) view.findViewById(com.baidu.tieba.v.last_chat_content);
        baVar.e = (TextView) view.findViewById(com.baidu.tieba.v.chat_time);
        baVar.f = (ImageView) view.findViewById(com.baidu.tieba.v.iv_bell);
        baVar.g = view.findViewById(com.baidu.tieba.v.line);
        baVar.h = (ViewGroup) view.findViewById(com.baidu.tieba.v.list_content);
        return baVar;
    }

    public com.baidu.tbadk.editortool.aa a() {
        return this.c;
    }
}
