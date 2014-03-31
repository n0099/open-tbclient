package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
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
public final class ax extends BaseAdapter {
    private OfficialBarTipActivity a;
    private List<ImMessageCenterShowItemData> b = new ArrayList();
    private com.baidu.tbadk.editortool.aa c;

    public ax(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
        this.c = new com.baidu.tbadk.editortool.aa(officialBarTipActivity);
        this.c.a(true);
    }

    public final void a(List<ImMessageCenterShowItemData> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (i < 0 || i >= this.b.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ay ayVar;
        if (view != null) {
            ayVar = (ay) view.getTag();
        } else {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.officialbar_msg_list_item, viewGroup, false);
            ayVar = new ay((byte) 0);
            ayVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.im.h.item_head);
            ayVar.b = (TextView) view.findViewById(com.baidu.tieba.im.h.item_new_message);
            ayVar.c = (TextView) view.findViewById(com.baidu.tieba.im.h.item_name);
            ayVar.d = (TextView) view.findViewById(com.baidu.tieba.im.h.item_last_msg_content);
            ayVar.e = (TextView) view.findViewById(com.baidu.tieba.im.h.item_time);
            ayVar.f = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_bell);
            view.setTag(ayVar);
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
        if (imMessageCenterShowItemData != null) {
            ayVar.c.setText(this.a.getString(com.baidu.tieba.im.j.official_msg_list_name, new Object[]{imMessageCenterShowItemData.getFriendName()}));
            TextView textView = ayVar.d;
            String msgContent = imMessageCenterShowItemData.getMsgContent();
            if (TextUtils.isEmpty(msgContent)) {
                msgContent = "";
            } else {
                String[] split = msgContent.split(":");
                if (split.length == 2) {
                    msgContent = split[1];
                    if (TextUtils.isEmpty(msgContent)) {
                        msgContent = "";
                    }
                }
            }
            textView.setText(msgContent);
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                ayVar.e.setText(com.baidu.tbadk.core.util.bc.f(new Date(imMessageCenterShowItemData.getServerTime())));
            }
            ayVar.f.setVisibility(8);
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                ayVar.b.setVisibility(0);
                TextView textView2 = ayVar.b;
                ImageView imageView = ayVar.f;
                int unReadCount = imMessageCenterShowItemData.getUnReadCount();
                if (TbadkApplication.j().ag() == 0) {
                    unReadCount = 0;
                }
                if (!TbadkApplication.j().ae()) {
                    unReadCount = 0;
                }
                if (!imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                    unReadCount = 0;
                }
                if (TbadkApplication.j().l() == 1) {
                    if (unReadCount == 0) {
                        textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt_1);
                        textView2.setText("");
                        imageView.setVisibility(0);
                    } else if (unReadCount < 10) {
                        textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one_1);
                        textView2.setText(String.valueOf(unReadCount));
                    } else if (unReadCount < 100) {
                        textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two_1);
                        textView2.setText(String.valueOf(unReadCount));
                    } else {
                        textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more_1);
                        textView2.setText("");
                    }
                } else if (unReadCount == 0) {
                    textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt);
                    textView2.setText("");
                    imageView.setVisibility(0);
                } else if (unReadCount < 10) {
                    textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one);
                    textView2.setText(String.valueOf(unReadCount));
                } else if (unReadCount < 100) {
                    textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two);
                    textView2.setText(String.valueOf(unReadCount));
                } else {
                    textView2.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more);
                    textView2.setText("");
                }
            } else {
                ayVar.b.setVisibility(8);
            }
            ayVar.a.setTag(null);
            ayVar.a.setDrawBorder(true);
            ayVar.a.setRadius(com.baidu.adp.lib.util.i.a((Context) this.a, 3.0f));
            ayVar.a.setDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140);
            ayVar.a.setNightDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140);
            ayVar.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                ayVar.a.setTag(imMessageCenterShowItemData.getFriendPortrait());
            }
        }
        this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.a.getLayoutMode().a(view);
        return view;
    }

    public final com.baidu.tbadk.editortool.aa a() {
        return this.c;
    }
}
