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
    protected boolean gtR = false;

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
        aVar.gtS.setVisibility(0);
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
            aVar.gtU.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.gtY.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.gtY.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.gtY.setVisibility(0);
                    al.c(aVar.gtY, (int) R.drawable.icon_news_stop);
                } else {
                    aVar.gtY.setVisibility(8);
                }
            } else {
                aVar.gtY.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.gtR) {
            aVar.gua.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                al.k(aVar.gua, R.drawable.btn_bgb_choice_s);
                al.l(aVar.gtS, R.color.cp_bg_line_e);
                return;
            }
            al.k(aVar.gua, R.drawable.btn_bgb_choice_n);
            al.l(aVar.gtS, R.color.cp_bg_line_d);
            return;
        }
        aVar.gua.setVisibility(8);
        al.k(aVar.gtS, R.drawable.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.gtV.setText("");
        } else {
            aVar.gtV.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.gtW.setText(str);
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
            aVar.gtX.refresh(f);
            aVar.gtX.setVisibility(0);
        } else {
            aVar.gtX.setVisibility(8);
        }
        al.f(aVar.gtU, R.color.cp_cont_b, 1);
        al.f(aVar.gtV, R.color.cp_cont_d, 1);
        al.f(aVar.gtW, R.color.cp_cont_d, 1);
    }

    public boolean byc() {
        return this.gtR;
    }

    public void lz(boolean z) {
        this.gtR = z;
    }

    protected a ca(View view) {
        a aVar = new a();
        aVar.gtS = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.gtT = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.gtU = (TextView) view.findViewById(R.id.chat_name);
        aVar.gtV = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.gtW = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.gtX = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.gtY = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.gtZ = (ImageView) view.findViewById(R.id.send_status);
        aVar.gua = (ImageView) view.findViewById(R.id.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup gtS = null;
        public HeadImageView gtT = null;
        public TextView gtU = null;
        public TextView gtV = null;
        public TextView gtW = null;
        public MessageRedDotView gtX = null;
        public View mLine = null;
        public ImageView gtY = null;
        public ImageView gtZ = null;
        public ImageView gua = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.gtZ.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    al.k(aVar.gtZ, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    al.k(aVar.gtZ, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.gtZ.setVisibility(8);
                    return;
                }
            }
            aVar.gtZ.setVisibility(8);
        }
    }
}
