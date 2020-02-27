package com.baidu.tieba.im.chat.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    protected boolean htB = false;

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
    /* renamed from: wc */
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
            aVar = cc(view);
            view.setTag(aVar);
        }
        am.setBackgroundResource(view, R.drawable.list_selector);
        am.setBackgroundResource(aVar.mLine, R.color.cp_bg_line_e);
        aVar.htC.setVisibility(0);
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
            aVar.htE.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.htI.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.htI.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.htI.setVisibility(0);
                    am.setImageResource(aVar.htI, R.drawable.icon_news_stop);
                } else {
                    aVar.htI.setVisibility(8);
                }
            } else {
                aVar.htI.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.htB) {
            aVar.htK.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                am.setBackgroundResource(aVar.htK, R.drawable.btn_bgb_choice_s);
                am.setBackgroundColor(aVar.htC, R.color.cp_bg_line_e);
                return;
            }
            am.setBackgroundResource(aVar.htK, R.drawable.btn_bgb_choice_n);
            am.setBackgroundColor(aVar.htC, R.color.cp_bg_line_e);
            return;
        }
        aVar.htK.setVisibility(8);
        aVar.htC.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.htF.setText("");
        } else {
            aVar.htF.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = aq.getChatTimeString(date);
            }
            aVar.htG.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.aLj().aLm() == 0) {
                i = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? StringHelper.STRING_MORE : String.valueOf(unReadCount));
                i = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
            }
            aVar.htH.refresh(i);
            aVar.htH.setVisibility(0);
        } else {
            aVar.htH.setVisibility(8);
        }
        am.setViewTextColor(aVar.htE, R.color.cp_cont_b, 1);
        am.setViewTextColor(aVar.htF, R.color.cp_cont_d, 1);
        am.setViewTextColor(aVar.htG, R.color.cp_cont_d, 1);
    }

    public boolean bSs() {
        return this.htB;
    }

    public void ng(boolean z) {
        this.htB = z;
    }

    protected a cc(View view) {
        a aVar = new a();
        aVar.htC = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.htD = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.htE = (TextView) view.findViewById(R.id.chat_name);
        aVar.htF = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.htG = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.htH = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.htI = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.htJ = (ImageView) view.findViewById(R.id.send_status);
        aVar.htK = (ImageView) view.findViewById(R.id.select_status);
        aVar.htD.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup htC = null;
        public HeadImageView htD = null;
        public TextView htE = null;
        public TextView htF = null;
        public TextView htG = null;
        public MessageRedDotView htH = null;
        public View mLine = null;
        public ImageView htI = null;
        public ImageView htJ = null;
        public ImageView htK = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.htJ.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    am.setBackgroundResource(aVar.htJ, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    am.setBackgroundResource(aVar.htJ, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.htJ.setVisibility(8);
                    return;
                }
            }
            aVar.htJ.setVisibility(8);
        }
    }
}
