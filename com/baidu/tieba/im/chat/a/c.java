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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class c extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean gtP = false;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public c(Context context) {
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
    /* renamed from: uE */
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.chat_list_item, viewGroup, false);
            aVar = ca(view);
            view.setTag(aVar);
        }
        al.k(view, R.drawable.list_selector);
        al.k(aVar.mLine, R.color.cp_bg_line_c);
        aVar.gtQ.setVisibility(0);
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

    protected void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            aVar.gtS.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.gtW.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.gtW.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.gtW.setVisibility(0);
                    al.c(aVar.gtW, (int) R.drawable.icon_news_stop);
                } else {
                    aVar.gtW.setVisibility(8);
                }
            } else {
                aVar.gtW.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.gtP) {
            aVar.gtY.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                al.k(aVar.gtY, R.drawable.btn_bgb_choice_s);
                al.l(aVar.gtQ, R.color.cp_bg_line_e);
                return;
            }
            al.k(aVar.gtY, R.drawable.btn_bgb_choice_n);
            al.l(aVar.gtQ, R.color.cp_bg_line_d);
            return;
        }
        aVar.gtY.setVisibility(8);
        al.k(aVar.gtQ, R.drawable.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.gtT.setText("");
        } else {
            aVar.gtT.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ap.n(date);
            }
            aVar.gtU.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int f;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.anf().ani() == 0) {
                f = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                f = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.f(a2.getName(), 0);
            }
            aVar.gtV.refresh(f);
            aVar.gtV.setVisibility(0);
        } else {
            aVar.gtV.setVisibility(8);
        }
        al.f(aVar.gtS, R.color.cp_cont_b, 1);
        al.f(aVar.gtT, R.color.cp_cont_d, 1);
        al.f(aVar.gtU, R.color.cp_cont_d, 1);
    }

    public boolean byb() {
        return this.gtP;
    }

    public void ly(boolean z) {
        this.gtP = z;
    }

    protected a ca(View view) {
        a aVar = new a();
        aVar.gtQ = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.gtR = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.gtS = (TextView) view.findViewById(R.id.chat_name);
        aVar.gtT = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.gtU = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.gtV = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.gtW = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.gtX = (ImageView) view.findViewById(R.id.send_status);
        aVar.gtY = (ImageView) view.findViewById(R.id.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup gtQ = null;
        public HeadImageView gtR = null;
        public TextView gtS = null;
        public TextView gtT = null;
        public TextView gtU = null;
        public MessageRedDotView gtV = null;
        public View mLine = null;
        public ImageView gtW = null;
        public ImageView gtX = null;
        public ImageView gtY = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.gtX.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    al.k(aVar.gtX, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    al.k(aVar.gtX, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.gtX.setVisibility(8);
                    return;
                }
            }
            aVar.gtX.setVisibility(8);
        }
    }
}
