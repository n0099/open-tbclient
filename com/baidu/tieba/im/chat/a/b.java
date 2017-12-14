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
    protected boolean dEX = false;

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
    /* renamed from: mX */
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
            view = LayoutInflater.from(this.mContext).inflate(d.h.chat_list_item, viewGroup, false);
            aVar = aK(view);
            view.setTag(aVar);
        }
        aj.j(view, d.f.list_selector);
        aj.j(aVar.mLine, d.C0096d.cp_bg_line_b);
        aVar.dEY.setVisibility(0);
        aVar.mLine.setVisibility(0);
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
        aVar.dFa.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dFe.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dFe.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dFe.setVisibility(0);
                    aj.c(aVar.dFe, d.f.icon_news_stop);
                } else {
                    aVar.dFe.setVisibility(8);
                }
            } else {
                aVar.dFe.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dEX) {
            aVar.dFg.setVisibility(0);
        } else {
            aVar.dFg.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            aj.j(aVar.dFg, d.f.btn_bgb_choice_s);
            aj.k(aVar.dEY, d.C0096d.cp_bg_line_e);
            return;
        }
        aj.j(aVar.dFg, d.f.btn_bgb_choice_n);
        aj.k(aVar.dEY, d.C0096d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dFb.setText("");
        } else {
            aVar.dFb.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.dFc.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.dFd.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.zk().zn() == 0) {
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
            aVar.dFd.setText(valueOf);
        } else {
            aVar.dFd.setVisibility(8);
        }
        aj.c(aVar.dFa, d.C0096d.cp_cont_b, 1);
        aj.c(aVar.dFb, d.C0096d.cp_cont_d, 1);
        aj.c(aVar.dFc, d.C0096d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aj.j(aVar.dFd, d.f.icon_news_down_bar_one);
                aVar.dFd.setWidth(0);
                aVar.dFd.setHeight(0);
            } else {
                aj.j(aVar.dFd, d.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aj.j(aVar.dFd, d.f.icon_news_head_prompt_two);
        } else {
            aj.j(aVar.dFd, d.f.icon_news_head_prompt_more);
            aVar.dFd.setText("");
        }
        aj.c(aVar.dFd, d.C0096d.common_color_10225, 1);
    }

    public boolean axz() {
        return this.dEX;
    }

    public void gq(boolean z) {
        this.dEX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aK(View view) {
        a aVar = new a();
        aVar.dEY = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.dEZ = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.dFa = (TextView) view.findViewById(d.g.chat_name);
        aVar.dFb = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.dFc = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.dFd = (TextView) view.findViewById(d.g.new_message);
        aVar.dFe = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.dFf = (ImageView) view.findViewById(d.g.send_status);
        aVar.dFg = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dEY = null;
        public HeadImageView dEZ = null;
        public TextView dFa = null;
        public TextView dFb = null;
        public TextView dFc = null;
        public TextView dFd = null;
        public View mLine = null;
        public ImageView dFe = null;
        public ImageView dFf = null;
        public ImageView dFg = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dFf.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.j(aVar.dFf, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.j(aVar.dFf, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.dFf.setVisibility(8);
                    return;
                }
            }
            aVar.dFf.setVisibility(8);
        }
    }
}
