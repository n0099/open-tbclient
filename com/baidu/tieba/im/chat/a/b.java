package com.baidu.tieba.im.chat.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean dqX = false;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        if (this.mList == null) {
            this.mList = new LinkedList();
        }
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mo */
    public ImMessageCenterShowItemData getItem(int i) {
        if (this.mList == null || this.mList.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = null;
        if (view != null) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.j.chat_list_item, viewGroup, false);
            aVar = aN(view);
            view.setTag(aVar);
        }
        aj.j(view, d.g.list_selector);
        aj.j(aVar.aXa, d.e.cp_bg_line_b);
        aVar.dqY.setVisibility(0);
        aVar.aXa.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            a(aVar, item);
            d(aVar, item);
            h(aVar, item);
            e(aVar, item);
            g(aVar, item);
            f(aVar, item);
            b(aVar, item);
            c(aVar, item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.dra.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dre.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dre.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dre.setVisibility(0);
                    aj.c(aVar.dre, d.g.icon_news_stop);
                } else {
                    aVar.dre.setVisibility(8);
                }
            } else {
                aVar.dre.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dqX) {
            aVar.drg.setVisibility(0);
        } else {
            aVar.drg.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            aj.j(aVar.drg, d.g.btn_bgb_choice_s);
            aj.k(aVar.dqY, d.e.cp_bg_line_e);
            return;
        }
        aj.j(aVar.drg, d.g.btn_bgb_choice_n);
        aj.k(aVar.dqY, d.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.drb.setText("");
        } else {
            aVar.drb.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = am.f(date);
            }
            aVar.drc.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.drd.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.zA().zD() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.b.g(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.drd.setText(valueOf);
        } else {
            aVar.drd.setVisibility(8);
        }
        aj.c(aVar.dra, d.e.cp_cont_b, 1);
        aj.c(aVar.drb, d.e.cp_cont_d, 1);
        aj.c(aVar.drc, d.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aj.j(aVar.drd, d.g.icon_news_down_bar_one);
                aVar.drd.setWidth(0);
                aVar.drd.setHeight(0);
            } else {
                aj.j(aVar.drd, d.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aj.j(aVar.drd, d.g.icon_news_head_prompt_two);
        } else {
            aj.j(aVar.drd, d.g.icon_news_head_prompt_more);
            aVar.drd.setText("");
        }
        aj.c(aVar.drd, d.e.common_color_10225, 1);
    }

    public boolean aun() {
        return this.dqX;
    }

    public void gh(boolean z) {
        this.dqX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aN(View view) {
        a aVar = new a();
        aVar.dqY = (ViewGroup) view.findViewById(d.h.chat_item);
        aVar.dqZ = (HeadImageView) view.findViewById(d.h.chat_head);
        aVar.dra = (TextView) view.findViewById(d.h.chat_name);
        aVar.drb = (TextView) view.findViewById(d.h.last_chat_content);
        aVar.drc = (TextView) view.findViewById(d.h.chat_time);
        aVar.aXa = view.findViewById(d.h.line);
        aVar.drd = (TextView) view.findViewById(d.h.new_message);
        aVar.dre = (ImageView) view.findViewById(d.h.iv_bell);
        aVar.drf = (ImageView) view.findViewById(d.h.send_status);
        aVar.drg = (ImageView) view.findViewById(d.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dqY = null;
        public HeadImageView dqZ = null;
        public TextView dra = null;
        public TextView drb = null;
        public TextView drc = null;
        public TextView drd = null;
        public View aXa = null;
        public ImageView dre = null;
        public ImageView drf = null;
        public ImageView drg = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.drf.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.j(aVar.drf, d.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.j(aVar.drf, d.g.icon_send_in_information);
                    return;
                } else {
                    aVar.drf.setVisibility(8);
                    return;
                }
            }
            aVar.drf.setVisibility(8);
        }
    }
}
