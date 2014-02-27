package com.baidu.tieba.chat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class n extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i g;
    private a b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<ImMessageCenterShowItemData> h = null;

    public n(Context context) {
        this.a = null;
        this.g = null;
        this.a = context;
        this.g = new com.baidu.tieba.util.i(this.a);
        this.g.a(true);
    }

    public final void a(List<ImMessageCenterShowItemData> list) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        this.h.clear();
        this.h.addAll(list);
        if (TiebaApplication.w()) {
            com.baidu.adp.lib.util.e.e("mRecentChatData.size():" + this.h.size());
            if (this.h.size() <= 0) {
                this.b.b(true);
            } else {
                this.b.b(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.h != null) {
            int size = this.h.size();
            if (this.c) {
                size++;
            }
            if (this.d) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.h.size()) {
            return null;
        }
        return this.h.get(itemId);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x05c3 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x05f5 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01eb A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0219 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0289 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02bf A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030a A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x036d A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0195, B:35:0x01ad, B:37:0x01bc, B:82:0x0338, B:84:0x0346, B:86:0x0357, B:39:0x01d3, B:41:0x01eb, B:42:0x01ef, B:44:0x0219, B:46:0x0239, B:47:0x0245, B:48:0x0263, B:50:0x0289, B:53:0x0295, B:56:0x02a2, B:59:0x02b7, B:62:0x02bf, B:65:0x02dd, B:66:0x02e5, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:169:0x0655, B:171:0x0659, B:76:0x0320, B:172:0x0661, B:174:0x0670, B:186:0x06c2, B:176:0x067f, B:178:0x0685, B:179:0x068e, B:181:0x0694, B:183:0x06a5, B:184:0x06af, B:185:0x06b9, B:154:0x05cc, B:157:0x05da, B:158:0x05e4, B:159:0x05f5, B:162:0x0613, B:163:0x061b, B:164:0x062f, B:167:0x063c, B:168:0x0645, B:130:0x053e, B:133:0x0555, B:135:0x0564, B:138:0x0576, B:140:0x057e, B:143:0x058c, B:145:0x059b, B:148:0x05ad, B:150:0x05b5, B:129:0x0538, B:153:0x05c3, B:87:0x035f, B:88:0x036d, B:90:0x037c, B:92:0x03af, B:93:0x03bb, B:94:0x03c8, B:95:0x03d5, B:97:0x03e4, B:99:0x040b, B:101:0x0411, B:105:0x041d, B:107:0x0429, B:108:0x042e, B:109:0x048f, B:103:0x0417, B:110:0x049c, B:112:0x04a2, B:113:0x04af, B:115:0x04cd, B:117:0x04d3, B:121:0x04df, B:123:0x04eb, B:124:0x04f0, B:125:0x0518, B:119:0x04d9, B:126:0x0525, B:128:0x052b, B:38:0x01ca), top: B:191:0x0195 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        View view2;
        int unReadCount;
        int i2;
        o oVar2 = null;
        if (view != null) {
            oVar2 = (o) view.getTag();
        }
        if (oVar2 == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.chat_list_item, viewGroup, false);
            o oVar3 = new o(this, (byte) 0);
            oVar3.a = (ViewGroup) inflate.findViewById(R.id.list_content);
            oVar3.b = (HeadImageView) inflate.findViewById(R.id.chat_head);
            oVar3.c = (TextView) inflate.findViewById(R.id.chat_name);
            oVar3.d = (TextView) inflate.findViewById(R.id.last_chat_content);
            oVar3.e = (TextView) inflate.findViewById(R.id.chat_time);
            oVar3.f = (TextView) inflate.findViewById(R.id.new_message);
            oVar3.g = (ViewGroup) inflate.findViewById(R.id.list_control);
            oVar3.h = (TextView) inflate.findViewById(R.id.list_control_tv);
            oVar3.i = (ProgressBar) inflate.findViewById(R.id.list_control_progress);
            oVar3.j = (ImageView) inflate.findViewById(R.id.iv_bell);
            inflate.setTag(oVar3);
            oVar = oVar3;
            view2 = inflate;
        } else {
            oVar = oVar2;
            view2 = view;
        }
        int ae = TiebaApplication.g().ae();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.a.setVisibility(8);
            oVar.g.setVisibility(0);
            if (this.f) {
                oVar.h.setText(R.string.loading);
                oVar.i.setVisibility(0);
            } else {
                oVar.h.setText(R.string.frs_pre);
                oVar.i.setVisibility(8);
            }
            if (ae == 1) {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square_1);
                oVar.h.setTextColor(-8682095);
            } else {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square);
                oVar.h.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            oVar.a.setVisibility(8);
            oVar.g.setVisibility(0);
            if (this.e) {
                oVar.h.setText(R.string.loading);
                oVar.i.setVisibility(0);
            } else {
                oVar.h.setText(R.string.frs_next);
                oVar.i.setVisibility(8);
            }
            if (ae == 1) {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square_1);
                oVar.h.setTextColor(-8682095);
            } else {
                bq.e((View) oVar.h, (int) R.drawable.btn_w_square);
                oVar.h.setTextColor(-14277082);
            }
        } else {
            if (ae == 1) {
                bq.e(view2, (int) R.drawable.list_selector_1);
            } else {
                bq.e(view2, (int) R.drawable.list_selector);
            }
            com.baidu.adp.lib.util.e.e("count:" + getCount());
            oVar.a.setVisibility(0);
            oVar.g.setVisibility(8);
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
            if (imMessageCenterShowItemData != null) {
                try {
                    oVar.c.setText(imMessageCenterShowItemData.getFriendName());
                    if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                        if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                            oVar.c.setText(this.a.getString(R.string.updates_activity_title));
                        } else if (!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                            com.baidu.adp.lib.util.e.e(imMessageCenterShowItemData.getMsgContent());
                            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                                oVar.d.setText((CharSequence) null);
                                Date date = new Date();
                                date.setTime(imMessageCenterShowItemData.getServerTime());
                                String str = "";
                                if (imMessageCenterShowItemData.getServerTime() != 0) {
                                    str = bs.e(date);
                                }
                                oVar.e.setText(str);
                                com.baidu.adp.lib.util.e.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
                                if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    oVar.b.setDrawBorder(false);
                                    oVar.b.setAutoChangeStyle(false);
                                    oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                    if (TiebaApplication.g().ae() == 1) {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_test_1));
                                    } else {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_test));
                                    }
                                    oVar.b.setUserName(String.valueOf(2));
                                    oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                    oVar.b.setIsRound(false);
                                    oVar.b.invalidate();
                                } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    oVar.b.setDrawBorder(false);
                                    oVar.b.setAutoChangeStyle(false);
                                    oVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                    oVar.b.setUserName(String.valueOf(3));
                                    oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                    if (TiebaApplication.g().ae() == 1) {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_trends_1));
                                    } else {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.icon_new_trends));
                                    }
                                    oVar.b.setIsRound(false);
                                    oVar.b.invalidate();
                                } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    oVar.b.setDrawBorder(true);
                                    oVar.b.setAutoChangeStyle(true);
                                    oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                    String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
                                    String str2 = (String) oVar.b.getTag();
                                    if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait)) || TextUtils.isEmpty(str2)) {
                                        com.baidu.tieba.util.i iVar = this.g;
                                        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(friendPortrait);
                                        if (c != null) {
                                            c.a(oVar.b);
                                        } else {
                                            oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.avatar_poto_defaul140));
                                        }
                                    } else if (TextUtils.isEmpty(friendPortrait)) {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.avatar_poto_defaul140));
                                    }
                                    oVar.b.setClickable(false);
                                    oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                    oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                    com.baidu.adp.lib.util.e.e("groupid:" + imMessageCenterShowItemData.getFriendId() + " groupHeadUrl:" + imMessageCenterShowItemData.getFriendPortrait() + " groupName:" + imMessageCenterShowItemData.getFriendName());
                                    oVar.b.setUserName(String.valueOf(1));
                                    oVar.b.setIsRound(false);
                                    oVar.b.invalidate();
                                } else {
                                    oVar.b.setDrawBorder(true);
                                    oVar.b.setAutoChangeStyle(true);
                                    String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
                                    String str3 = (String) oVar.b.getTag();
                                    if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str3) && !str3.equals(friendPortrait2)) || TextUtils.isEmpty(str3)) {
                                        com.baidu.tieba.util.i iVar2 = this.g;
                                        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(friendPortrait2);
                                        if (b != null) {
                                            b.a(oVar.b);
                                        } else {
                                            oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
                                        }
                                    } else if (TextUtils.isEmpty(friendPortrait2)) {
                                        oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
                                    }
                                    oVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                    oVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                    oVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                                    oVar.b.setIsRound(true);
                                    oVar.b.invalidate();
                                }
                                unReadCount = imMessageCenterShowItemData.getUnReadCount();
                                com.baidu.adp.lib.util.e.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
                                if (unReadCount <= 0) {
                                    oVar.f.setVisibility(0);
                                    String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
                                    if (TiebaApplication.g().G() == 0) {
                                        valueOf = "";
                                        i2 = 0;
                                    } else {
                                        i2 = unReadCount;
                                    }
                                    if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                                        unReadCount = 0;
                                        valueOf = "";
                                    } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                                        unReadCount = 0;
                                        valueOf = "";
                                    } else if (!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                                        if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                                            if (TiebaApplication.g().R()) {
                                                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                                                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                                                    unReadCount = 0;
                                                    valueOf = "";
                                                }
                                            } else {
                                                unReadCount = 0;
                                                valueOf = "";
                                            }
                                        }
                                        unReadCount = i2;
                                    } else if (TiebaApplication.g().S()) {
                                        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                                        if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                                            unReadCount = 0;
                                            valueOf = "";
                                        }
                                        unReadCount = i2;
                                    } else {
                                        unReadCount = 0;
                                        valueOf = "";
                                    }
                                    oVar.f.setText(valueOf);
                                } else {
                                    oVar.f.setVisibility(8);
                                }
                                if (ae != 1) {
                                    oVar.c.setTextColor(-8153171);
                                    oVar.d.setTextColor(-10391164);
                                    oVar.e.setTextColor(-10391164);
                                    if (unReadCount < 10) {
                                        if (unReadCount == 0) {
                                            oVar.f.setBackgroundResource(R.drawable.icon_news_list_prompt_1);
                                        } else {
                                            oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_one_1);
                                        }
                                    } else if (unReadCount < 100) {
                                        oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_two_1);
                                    } else {
                                        oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                                        oVar.f.setText("");
                                    }
                                    oVar.f.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_night));
                                } else {
                                    oVar.c.setTextColor(-13553101);
                                    oVar.d.setTextColor(-8749952);
                                    oVar.e.setTextColor(-3881012);
                                    if (unReadCount < 10) {
                                        if (unReadCount == 0) {
                                            oVar.f.setBackgroundResource(R.drawable.icon_news_list_prompt);
                                        } else {
                                            oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_one);
                                        }
                                    } else if (unReadCount < 100) {
                                        oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_two);
                                    } else {
                                        oVar.f.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
                                        oVar.f.setText("");
                                    }
                                    oVar.f.setTextColor(this.a.getResources().getColor(R.color.top_msg_num_day));
                                }
                                if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    if (imMessageCenterShowItemData.getUnReadCount() >= 30) {
                                        if (this.b != null) {
                                            this.b.a(true);
                                        }
                                    } else if (this.b != null) {
                                        this.b.a(false);
                                    }
                                }
                                if (oVar != null) {
                                    if (imMessageCenterShowItemData == null) {
                                        oVar.j.setVisibility(8);
                                    } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                                        com.baidu.tieba.im.c.i groupSetting = imMessageCenterShowItemData.getGroupSetting();
                                        if (groupSetting == null) {
                                            oVar.j.setVisibility(8);
                                        } else if (groupSetting.isAcceptNotify()) {
                                            oVar.j.setVisibility(8);
                                        } else {
                                            oVar.j.setVisibility(0);
                                            if (TiebaApplication.g().ae() == 1) {
                                                oVar.j.setImageResource(R.drawable.icon_news_stop_1);
                                            } else {
                                                oVar.j.setImageResource(R.drawable.icon_news_stop);
                                            }
                                        }
                                    } else {
                                        oVar.j.setVisibility(8);
                                    }
                                }
                            }
                        }
                    }
                    oVar.d.setText(imMessageCenterShowItemData.getMsgContent());
                    Date date2 = new Date();
                    date2.setTime(imMessageCenterShowItemData.getServerTime());
                    String str4 = "";
                    if (imMessageCenterShowItemData.getServerTime() != 0) {
                    }
                    oVar.e.setText(str4);
                    com.baidu.adp.lib.util.e.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
                    if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                    }
                    unReadCount = imMessageCenterShowItemData.getUnReadCount();
                    com.baidu.adp.lib.util.e.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
                    if (unReadCount <= 0) {
                    }
                    if (ae != 1) {
                    }
                    if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                    }
                    if (oVar != null) {
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    public static void a() {
    }

    public final com.baidu.tieba.util.i b() {
        return this.g;
    }

    public final void a(boolean z) {
        this.e = true;
    }

    public final void b(boolean z) {
        this.f = true;
    }
}
