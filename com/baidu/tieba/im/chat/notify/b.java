package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.t;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean cUM = false;

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
    /* renamed from: lb */
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
            view = LayoutInflater.from(this.mContext).inflate(t.h.chat_list_item, viewGroup, false);
            aVar = aE(view);
            view.setTag(aVar);
        }
        av.k(view, t.f.list_selector);
        av.k(aVar.amU, t.d.cp_bg_line_b);
        aVar.cUN.setVisibility(0);
        aVar.amU.setVisibility(0);
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

    protected void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.GR.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cUR.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cUR.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cUR.setVisibility(0);
                    av.c(aVar.cUR, t.f.icon_news_stop);
                } else {
                    aVar.cUR.setVisibility(8);
                }
            } else {
                aVar.cUR.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cUM) {
            aVar.cUT.setVisibility(0);
        } else {
            aVar.cUT.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            av.k(aVar.cUT, t.f.btn_bgb_choice_s);
            av.l(aVar.cUN, t.d.cp_bg_line_e);
            return;
        }
        av.k(aVar.cUT, t.f.btn_bgb_choice_n);
        av.l(aVar.cUN, t.d.cp_bg_line_d);
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cUO.setText("");
        } else {
            aVar.cUO.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ba.f(date);
            }
            aVar.cUP.setText(str);
        }
    }

    private void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cUQ.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.yX().za() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.h.b.g(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.cUQ.setText(valueOf);
        } else {
            aVar.cUQ.setVisibility(8);
        }
        av.c(aVar.GR, t.d.cp_cont_b, 1);
        av.c(aVar.cUO, t.d.cp_cont_d, 1);
        av.c(aVar.cUP, t.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                av.k(aVar.cUQ, t.f.icon_news_down_bar_one);
                aVar.cUQ.setWidth(0);
                aVar.cUQ.setHeight(0);
            } else {
                av.k(aVar.cUQ, t.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            av.k(aVar.cUQ, t.f.icon_news_head_prompt_two);
        } else {
            av.k(aVar.cUQ, t.f.icon_news_head_prompt_more);
            aVar.cUQ.setText("");
        }
        av.c(aVar.cUQ, t.d.common_color_10225, 1);
    }

    public boolean aqo() {
        return this.cUM;
    }

    public void fr(boolean z) {
        this.cUM = z;
    }

    private a aE(View view) {
        a aVar = new a();
        aVar.cUN = (ViewGroup) view.findViewById(t.g.chat_item);
        aVar.GQ = (HeadImageView) view.findViewById(t.g.chat_head);
        aVar.GR = (TextView) view.findViewById(t.g.chat_name);
        aVar.cUO = (TextView) view.findViewById(t.g.last_chat_content);
        aVar.cUP = (TextView) view.findViewById(t.g.chat_time);
        aVar.amU = view.findViewById(t.g.line);
        aVar.cUQ = (TextView) view.findViewById(t.g.new_message);
        aVar.cUR = (ImageView) view.findViewById(t.g.iv_bell);
        aVar.cUS = (ImageView) view.findViewById(t.g.send_status);
        aVar.cUT = (ImageView) view.findViewById(t.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cUN = null;
        public HeadImageView GQ = null;
        public TextView GR = null;
        public TextView cUO = null;
        public TextView cUP = null;
        public TextView cUQ = null;
        public View amU = null;
        public ImageView cUR = null;
        public ImageView cUS = null;
        public ImageView cUT = null;

        protected a() {
        }
    }

    private void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cUS.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    av.k(aVar.cUS, t.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    av.k(aVar.cUS, t.f.icon_send_in_information);
                    return;
                } else {
                    aVar.cUS.setVisibility(8);
                    return;
                }
            }
            aVar.cUS.setVisibility(8);
        }
    }
}
