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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.r;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean dbR = false;

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
    /* renamed from: lr */
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
            view = LayoutInflater.from(this.mContext).inflate(r.h.chat_list_item, viewGroup, false);
            aVar = aC(view);
            view.setTag(aVar);
        }
        at.k(view, r.f.list_selector);
        at.k(aVar.anv, r.d.cp_bg_line_b);
        aVar.dbS.setVisibility(0);
        aVar.anv.setVisibility(0);
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
        aVar.GU.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dbW.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dbW.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dbW.setVisibility(0);
                    at.c(aVar.dbW, r.f.icon_news_stop);
                } else {
                    aVar.dbW.setVisibility(8);
                }
            } else {
                aVar.dbW.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dbR) {
            aVar.dbY.setVisibility(0);
        } else {
            aVar.dbY.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            at.k(aVar.dbY, r.f.btn_bgb_choice_s);
            at.l(aVar.dbS, r.d.cp_bg_line_e);
            return;
        }
        at.k(aVar.dbY, r.f.btn_bgb_choice_n);
        at.l(aVar.dbS, r.d.cp_bg_line_d);
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dbT.setText("");
        } else {
            aVar.dbT.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ax.f(date);
            }
            aVar.dbU.setText(str);
        }
    }

    private void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.dbV.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.zh().zk() == 0) {
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
            aVar.dbV.setText(valueOf);
        } else {
            aVar.dbV.setVisibility(8);
        }
        at.c(aVar.GU, r.d.cp_cont_b, 1);
        at.c(aVar.dbT, r.d.cp_cont_d, 1);
        at.c(aVar.dbU, r.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                at.k(aVar.dbV, r.f.icon_news_down_bar_one);
                aVar.dbV.setWidth(0);
                aVar.dbV.setHeight(0);
            } else {
                at.k(aVar.dbV, r.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            at.k(aVar.dbV, r.f.icon_news_head_prompt_two);
        } else {
            at.k(aVar.dbV, r.f.icon_news_head_prompt_more);
            aVar.dbV.setText("");
        }
        at.c(aVar.dbV, r.d.common_color_10225, 1);
    }

    public boolean asK() {
        return this.dbR;
    }

    public void fO(boolean z) {
        this.dbR = z;
    }

    private a aC(View view) {
        a aVar = new a();
        aVar.dbS = (ViewGroup) view.findViewById(r.g.chat_item);
        aVar.GT = (HeadImageView) view.findViewById(r.g.chat_head);
        aVar.GU = (TextView) view.findViewById(r.g.chat_name);
        aVar.dbT = (TextView) view.findViewById(r.g.last_chat_content);
        aVar.dbU = (TextView) view.findViewById(r.g.chat_time);
        aVar.anv = view.findViewById(r.g.line);
        aVar.dbV = (TextView) view.findViewById(r.g.new_message);
        aVar.dbW = (ImageView) view.findViewById(r.g.iv_bell);
        aVar.dbX = (ImageView) view.findViewById(r.g.send_status);
        aVar.dbY = (ImageView) view.findViewById(r.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dbS = null;
        public HeadImageView GT = null;
        public TextView GU = null;
        public TextView dbT = null;
        public TextView dbU = null;
        public TextView dbV = null;
        public View anv = null;
        public ImageView dbW = null;
        public ImageView dbX = null;
        public ImageView dbY = null;

        protected a() {
        }
    }

    private void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dbX.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    at.k(aVar.dbX, r.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    at.k(aVar.dbX, r.f.icon_send_in_information);
                    return;
                } else {
                    aVar.dbX.setVisibility(8);
                    return;
                }
            }
            aVar.dbX.setVisibility(8);
        }
    }
}
