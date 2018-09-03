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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class c extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean elN = false;

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
    /* renamed from: nO */
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
            view = LayoutInflater.from(this.mContext).inflate(f.h.chat_list_item, viewGroup, false);
            aVar = aL(view);
            view.setTag(aVar);
        }
        am.i(view, f.C0146f.list_selector);
        am.i(aVar.mLine, f.d.cp_bg_line_c);
        aVar.elO.setVisibility(0);
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
            aVar.elQ.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.elU.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.elU.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.elU.setVisibility(0);
                    am.c(aVar.elU, f.C0146f.icon_news_stop);
                } else {
                    aVar.elU.setVisibility(8);
                }
            } else {
                aVar.elU.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.elN) {
            aVar.elW.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                am.i(aVar.elW, f.C0146f.btn_bgb_choice_s);
                am.j(aVar.elO, f.d.cp_bg_line_e);
                return;
            }
            am.i(aVar.elW, f.C0146f.btn_bgb_choice_n);
            am.j(aVar.elO, f.d.cp_bg_line_d);
            return;
        }
        aVar.elW.setVisibility(8);
        am.i(aVar.elO, f.C0146f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.elR.setText("");
        } else {
            aVar.elR.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ap.h(date);
            }
            aVar.elS.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int g;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().DV() == 0) {
                g = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                g = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.g(a2.getName(), 0);
            }
            aVar.elT.refresh(g);
            aVar.elT.setVisibility(0);
        } else {
            aVar.elT.setVisibility(8);
        }
        am.c(aVar.elQ, f.d.cp_cont_b, 1);
        am.c(aVar.elR, f.d.cp_cont_d, 1);
        am.c(aVar.elS, f.d.cp_cont_d, 1);
    }

    public boolean aHC() {
        return this.elN;
    }

    public void he(boolean z) {
        this.elN = z;
    }

    protected a aL(View view) {
        a aVar = new a();
        aVar.elO = (ViewGroup) view.findViewById(f.g.chat_item);
        aVar.elP = (HeadImageView) view.findViewById(f.g.chat_head);
        aVar.elQ = (TextView) view.findViewById(f.g.chat_name);
        aVar.elR = (TextView) view.findViewById(f.g.last_chat_content);
        aVar.elS = (TextView) view.findViewById(f.g.chat_time);
        aVar.mLine = view.findViewById(f.g.line);
        aVar.elT = (MessageRedDotView) view.findViewById(f.g.new_message);
        aVar.elU = (ImageView) view.findViewById(f.g.iv_bell);
        aVar.elV = (ImageView) view.findViewById(f.g.send_status);
        aVar.elW = (ImageView) view.findViewById(f.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup elO = null;
        public HeadImageView elP = null;
        public TextView elQ = null;
        public TextView elR = null;
        public TextView elS = null;
        public MessageRedDotView elT = null;
        public View mLine = null;
        public ImageView elU = null;
        public ImageView elV = null;
        public ImageView elW = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.elV.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    am.i(aVar.elV, f.C0146f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    am.i(aVar.elV, f.C0146f.icon_send_in_information);
                    return;
                } else {
                    aVar.elV.setVisibility(8);
                    return;
                }
            }
            aVar.elV.setVisibility(8);
        }
    }
}
