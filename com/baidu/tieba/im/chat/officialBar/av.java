package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import android.view.LayoutInflater;
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
public class av extends BaseAdapter {
    private OfficialBarTipActivity a;
    private List<ImMessageCenterShowItemData> b = new ArrayList();
    private com.baidu.tbadk.editortool.ab c;

    public av(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
        this.c = new com.baidu.tbadk.editortool.ab(officialBarTipActivity);
        this.c.d(true);
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
        aw awVar;
        if (view != null) {
            awVar = (aw) view.getTag();
        } else {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.officialbar_msg_list_item, viewGroup, false);
            aw b = b(view);
            view.setTag(b);
            awVar = b;
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            awVar.c.setText(this.a.getString(com.baidu.tieba.u.official_msg_list_name, new Object[]{imMessageCenterShowItemData.getFriendName()}));
            awVar.d.setText(a(imMessageCenterShowItemData.getMsgContent()));
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                awVar.e.setText(com.baidu.tbadk.core.util.be.f(new Date(imMessageCenterShowItemData.getServerTime())));
            }
            awVar.f.setVisibility(8);
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                awVar.b.setVisibility(0);
                a(imMessageCenterShowItemData, awVar.b, awVar.f, imMessageCenterShowItemData.getUnReadCount());
            } else {
                awVar.b.setVisibility(8);
            }
            awVar.a.setTag(null);
            awVar.a.setDrawBorder(true);
            awVar.a.setDefaultResource(com.baidu.tieba.q.avatar_poto_defaul140);
            awVar.a.setNightDefaultResource(com.baidu.tieba.q.avatar_poto_defaul140);
            awVar.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                awVar.a.setTag(imMessageCenterShowItemData.getFriendPortrait());
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
                textView.setBackgroundResource(com.baidu.tieba.q.icon_news_list_prompt_1);
                textView.setText("");
                imageView.setVisibility(0);
            } else if (i < 10) {
                textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_one_1);
                textView.setText(String.valueOf(i));
            } else if (i < 100) {
                textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_two_1);
                textView.setText(String.valueOf(i));
            } else {
                textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_more_1);
                textView.setText("");
            }
        } else if (i == 0) {
            textView.setBackgroundResource(com.baidu.tieba.q.icon_news_list_prompt);
            textView.setText("");
            imageView.setVisibility(0);
        } else if (i < 10) {
            textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_one);
            textView.setText(String.valueOf(i));
        } else if (i < 100) {
            textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_two);
            textView.setText(String.valueOf(i));
        } else {
            textView.setBackgroundResource(com.baidu.tieba.q.icon_news_head_prompt_more);
            textView.setText("");
        }
    }

    private aw b(View view) {
        aw awVar = new aw(null);
        awVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.r.item_head);
        awVar.b = (TextView) view.findViewById(com.baidu.tieba.r.item_new_message);
        awVar.c = (TextView) view.findViewById(com.baidu.tieba.r.item_name);
        awVar.d = (TextView) view.findViewById(com.baidu.tieba.r.item_last_msg_content);
        awVar.e = (TextView) view.findViewById(com.baidu.tieba.r.item_time);
        awVar.f = (ImageView) view.findViewById(com.baidu.tieba.r.item_bell);
        return awVar;
    }

    public com.baidu.tbadk.editortool.ab a() {
        return this.c;
    }
}
