package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class q extends BaseAdapter {
    private Context a;
    private ab g;
    private b b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<ImMessageCenterShowItemData> h = null;

    public q(Context context) {
        this.a = null;
        this.g = null;
        this.a = context;
        this.g = new ab(this.a);
        this.g.a(true);
    }

    public final void a(List<ImMessageCenterShowItemData> list) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        ArrayList arrayList = new ArrayList();
        for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.h) {
            arrayList.add(imMessageCenterShowItemData);
        }
        this.h.removeAll(arrayList);
        this.h.addAll(list);
        if (TbadkApplication.F()) {
            com.baidu.adp.lib.util.f.e("mRecentChatData.size():" + this.h.size());
            if (this.h.size() <= 0) {
                this.b.c(true);
            } else {
                this.b.c(false);
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0421 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06f7 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0726 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0214 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0242 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02b1 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e7 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0330 A[Catch: JSONException -> 0x034f, TryCatch #0 {JSONException -> 0x034f, blocks: (B:33:0x01bf, B:35:0x01d7, B:37:0x01e6, B:82:0x035d, B:84:0x036b, B:86:0x037a, B:89:0x039d, B:39:0x01fc, B:41:0x0214, B:42:0x0218, B:44:0x0242, B:46:0x0262, B:47:0x026d, B:48:0x028b, B:50:0x02b1, B:53:0x02bd, B:56:0x02ca, B:59:0x02df, B:62:0x02e7, B:65:0x0305, B:66:0x030c, B:67:0x031d, B:69:0x0330, B:71:0x0338, B:73:0x033c, B:196:0x0781, B:198:0x0785, B:76:0x0346, B:199:0x078d, B:201:0x079c, B:213:0x07ec, B:203:0x07ab, B:205:0x07b1, B:206:0x07ba, B:208:0x07c0, B:210:0x07d1, B:211:0x07da, B:212:0x07e3, B:181:0x0700, B:184:0x070d, B:185:0x0716, B:186:0x0726, B:189:0x0744, B:190:0x074b, B:191:0x075e, B:194:0x076a, B:195:0x0772, B:152:0x0652, B:155:0x0669, B:157:0x0678, B:160:0x0689, B:162:0x0691, B:165:0x069f, B:167:0x06ae, B:170:0x06c0, B:172:0x06c8, B:175:0x06d6, B:177:0x06e5, B:151:0x064c, B:180:0x06f7, B:102:0x0414, B:103:0x0421, B:105:0x0430, B:107:0x0463, B:108:0x046e, B:109:0x047b, B:110:0x0487, B:112:0x0496, B:114:0x04bd, B:116:0x04c3, B:120:0x04cf, B:122:0x04db, B:123:0x04e0, B:124:0x0541, B:118:0x04c9, B:125:0x054d, B:127:0x0553, B:128:0x055f, B:130:0x056e, B:132:0x05a1, B:133:0x05ac, B:134:0x05b9, B:135:0x05c5, B:137:0x05e3, B:139:0x05e9, B:143:0x05f5, B:145:0x0601, B:146:0x0606, B:147:0x062e, B:141:0x05ef, B:148:0x063a, B:150:0x0640, B:91:0x03a4, B:92:0x03b3, B:94:0x03bd, B:96:0x03c6, B:98:0x03cf, B:99:0x03fb, B:101:0x040c, B:38:0x01f3), top: B:218:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0344  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        r rVar;
        View view2;
        int unReadCount;
        int i2;
        r rVar2 = null;
        if (view != null) {
            rVar2 = (r) view.getTag();
        }
        if (rVar2 == null) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.chat_list_item, viewGroup, false);
            r rVar3 = new r(this, (byte) 0);
            rVar3.a = (ViewGroup) inflate.findViewById(com.baidu.tieba.im.h.list_content);
            rVar3.b = (HeadImageView) inflate.findViewById(com.baidu.tieba.im.h.chat_head);
            rVar3.c = (TextView) inflate.findViewById(com.baidu.tieba.im.h.chat_name);
            rVar3.d = (TextView) inflate.findViewById(com.baidu.tieba.im.h.last_chat_content);
            rVar3.e = (TextView) inflate.findViewById(com.baidu.tieba.im.h.chat_time);
            rVar3.g = inflate.findViewById(com.baidu.tieba.im.h.line);
            rVar3.f = (TextView) inflate.findViewById(com.baidu.tieba.im.h.new_message);
            rVar3.h = (ViewGroup) inflate.findViewById(com.baidu.tieba.im.h.list_control);
            rVar3.i = (TextView) inflate.findViewById(com.baidu.tieba.im.h.list_control_tv);
            rVar3.j = (ProgressBar) inflate.findViewById(com.baidu.tieba.im.h.list_control_progress);
            rVar3.k = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.iv_bell);
            inflate.setTag(rVar3);
            rVar = rVar3;
            view2 = inflate;
        } else {
            rVar = rVar2;
            view2 = view;
        }
        int l = TbadkApplication.j().l();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            rVar.a.setVisibility(8);
            rVar.g.setVisibility(8);
            rVar.h.setVisibility(0);
            if (this.f) {
                rVar.i.setText(com.baidu.tieba.im.j.loading);
                rVar.j.setVisibility(0);
            } else {
                rVar.i.setText(com.baidu.tieba.im.j.frs_pre);
                rVar.j.setVisibility(8);
            }
            if (l == 1) {
                ba.e((View) rVar.i, com.baidu.tieba.im.g.btn_w_square_1);
                rVar.i.setTextColor(-8682095);
            } else {
                ba.e((View) rVar.i, com.baidu.tieba.im.g.btn_w_square);
                rVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            rVar.a.setVisibility(8);
            rVar.g.setVisibility(8);
            rVar.h.setVisibility(0);
            if (this.e) {
                rVar.i.setText(com.baidu.tieba.im.j.loading);
                rVar.j.setVisibility(0);
            } else {
                rVar.i.setText(com.baidu.tieba.im.j.frs_next);
                rVar.j.setVisibility(8);
            }
            if (l == 1) {
                ba.e((View) rVar.i, com.baidu.tieba.im.g.btn_w_square_1);
                rVar.i.setTextColor(-8682095);
            } else {
                ba.e((View) rVar.i, com.baidu.tieba.im.g.btn_w_square);
                rVar.i.setTextColor(-14277082);
            }
        } else {
            if (l == 1) {
                ba.e(view2, com.baidu.tieba.im.g.list_selector_1);
            } else {
                ba.e(view2, com.baidu.tieba.im.g.list_selector);
            }
            ba.f(rVar.g, com.baidu.tieba.im.e.cp_bg_line_b);
            com.baidu.adp.lib.util.f.e("count:" + getCount());
            rVar.a.setVisibility(0);
            rVar.g.setVisibility(0);
            rVar.h.setVisibility(8);
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
            if (imMessageCenterShowItemData != null) {
                try {
                    rVar.c.setText(imMessageCenterShowItemData.getFriendName());
                    if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                        if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                            rVar.c.setText(this.a.getString(com.baidu.tieba.im.j.updates_activity_title));
                        } else if (!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                                rVar.c.setText(this.a.getString(com.baidu.tieba.im.j.official_message_activity_title));
                                TextView textView = rVar.d;
                                boolean isSelf = imMessageCenterShowItemData.isSelf();
                                String msgContent = imMessageCenterShowItemData.getMsgContent();
                                if (TextUtils.isEmpty(msgContent.trim())) {
                                    msgContent = "";
                                } else if (isSelf) {
                                    msgContent = this.a.getString(com.baidu.tieba.im.j.official_msg_pre, msgContent);
                                } else {
                                    String[] split = msgContent.split(":");
                                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                        msgContent = String.valueOf(this.a.getString(com.baidu.tieba.im.j.official_msg_list_name, split[0])) + ":" + split[1];
                                    }
                                }
                                textView.setText(msgContent);
                            } else {
                                com.baidu.adp.lib.util.f.e(imMessageCenterShowItemData.getMsgContent());
                                if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                                    rVar.d.setText((CharSequence) null);
                                }
                            }
                            Date date = new Date();
                            date.setTime(imMessageCenterShowItemData.getServerTime());
                            String str = "";
                            if (imMessageCenterShowItemData.getServerTime() != 0) {
                                str = bc.f(date);
                            }
                            rVar.e.setText(str);
                            com.baidu.adp.lib.util.f.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
                            if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                                rVar.b.setDrawBorder(false);
                                rVar.b.setAutoChangeStyle(false);
                                rVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                if (TbadkApplication.j().l() == 1) {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_test_1));
                                } else {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_test));
                                }
                                rVar.b.setUserName(String.valueOf(2));
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                rVar.b.setIsRound(false);
                                rVar.b.invalidate();
                            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                                rVar.b.setDrawBorder(false);
                                rVar.b.setAutoChangeStyle(false);
                                rVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                rVar.b.setUserName(String.valueOf(3));
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                if (TbadkApplication.j().l() == 1) {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_trends_1));
                                } else {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_trends));
                                }
                                rVar.b.setIsRound(false);
                                rVar.b.invalidate();
                            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                                rVar.b.setDrawBorder(true);
                                rVar.b.setAutoChangeStyle(true);
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
                                String str2 = (String) rVar.b.getTag();
                                if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait)) || TextUtils.isEmpty(str2)) {
                                    ab abVar = this.g;
                                    com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(friendPortrait);
                                    if (c != null) {
                                        c.a(rVar.b);
                                    } else {
                                        rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.avatar_poto_defaul140));
                                    }
                                } else if (TextUtils.isEmpty(friendPortrait)) {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.avatar_poto_defaul140));
                                }
                                rVar.b.setClickable(false);
                                rVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                com.baidu.adp.lib.util.f.e("groupid:" + imMessageCenterShowItemData.getFriendId() + " groupHeadUrl:" + imMessageCenterShowItemData.getFriendPortrait() + " groupName:" + imMessageCenterShowItemData.getFriendName());
                                rVar.b.setUserName(String.valueOf(1));
                                rVar.b.setIsRound(false);
                                rVar.b.invalidate();
                            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                                rVar.b.setDrawBorder(false);
                                rVar.b.setAutoChangeStyle(false);
                                rVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                rVar.b.setUserName(String.valueOf(5));
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                if (TbadkApplication.j().l() == 1) {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_official_1));
                                } else {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_official));
                                }
                                rVar.b.setIsRound(false);
                                rVar.b.invalidate();
                            } else {
                                rVar.b.setDrawBorder(true);
                                rVar.b.setAutoChangeStyle(true);
                                String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
                                String str3 = (String) rVar.b.getTag();
                                if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str3) && !str3.equals(friendPortrait2)) || TextUtils.isEmpty(str3)) {
                                    ab abVar2 = this.g;
                                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(friendPortrait2);
                                    if (b != null) {
                                        b.a(rVar.b);
                                    } else {
                                        rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.person_photo));
                                    }
                                } else if (TextUtils.isEmpty(friendPortrait2)) {
                                    rVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.person_photo));
                                }
                                rVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                rVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                rVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                                rVar.b.setIsRound(true);
                                rVar.b.invalidate();
                            }
                            unReadCount = imMessageCenterShowItemData.getUnReadCount();
                            com.baidu.adp.lib.util.f.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
                            if (unReadCount <= 0) {
                                rVar.f.setVisibility(0);
                                String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
                                if (TbadkApplication.j().ai() == 0) {
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
                                } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    TbadkApplication.j();
                                    if (TbadkApplication.af()) {
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
                                } else if (!String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) && !TbadkApplication.j().ag()) {
                                        unReadCount = 0;
                                        valueOf = "";
                                    }
                                    unReadCount = i2;
                                } else if (TbadkApplication.j().ag()) {
                                    PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                                    if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                                        unReadCount = 0;
                                        valueOf = "";
                                    }
                                    unReadCount = i2;
                                } else {
                                    unReadCount = 0;
                                    valueOf = "";
                                }
                                rVar.f.setText(valueOf);
                            } else {
                                rVar.f.setVisibility(8);
                            }
                            if (l != 1) {
                                rVar.c.setTextColor(-8153171);
                                rVar.d.setTextColor(-10391164);
                                rVar.e.setTextColor(-10391164);
                                if (unReadCount < 10) {
                                    if (unReadCount == 0) {
                                        rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt_1);
                                    } else {
                                        rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one_1);
                                    }
                                } else if (unReadCount < 100) {
                                    rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two_1);
                                } else {
                                    rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more_1);
                                    rVar.f.setText("");
                                }
                                rVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.top_msg_num_night));
                            } else {
                                rVar.c.setTextColor(-13553101);
                                rVar.d.setTextColor(-8749952);
                                rVar.e.setTextColor(-3881012);
                                if (unReadCount < 10) {
                                    if (unReadCount == 0) {
                                        rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt);
                                    } else {
                                        rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one);
                                    }
                                } else if (unReadCount < 100) {
                                    rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two);
                                } else {
                                    rVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more);
                                    rVar.f.setText("");
                                }
                                rVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.top_msg_num_day));
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
                            if (rVar != null) {
                                if (imMessageCenterShowItemData == null) {
                                    rVar.k.setVisibility(8);
                                } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    com.baidu.tieba.im.pushNotify.l groupSetting = imMessageCenterShowItemData.getGroupSetting();
                                    if (groupSetting == null) {
                                        rVar.k.setVisibility(8);
                                    } else if (groupSetting.isAcceptNotify()) {
                                        rVar.k.setVisibility(8);
                                    } else {
                                        rVar.k.setVisibility(0);
                                        if (TbadkApplication.j().l() == 1) {
                                            rVar.k.setImageResource(com.baidu.tieba.im.g.icon_news_stop_1);
                                        } else {
                                            rVar.k.setImageResource(com.baidu.tieba.im.g.icon_news_stop);
                                        }
                                    }
                                } else {
                                    rVar.k.setVisibility(8);
                                }
                            }
                        }
                    }
                    rVar.d.setText(imMessageCenterShowItemData.getMsgContent());
                    Date date2 = new Date();
                    date2.setTime(imMessageCenterShowItemData.getServerTime());
                    String str4 = "";
                    if (imMessageCenterShowItemData.getServerTime() != 0) {
                    }
                    rVar.e.setText(str4);
                    com.baidu.adp.lib.util.f.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
                    if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                    }
                    unReadCount = imMessageCenterShowItemData.getUnReadCount();
                    com.baidu.adp.lib.util.f.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
                    if (unReadCount <= 0) {
                    }
                    if (l != 1) {
                    }
                    if (String.valueOf(String.valueOf(2)).equals(imMessageCenterShowItemData.getOwnerName())) {
                    }
                    if (rVar != null) {
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view2;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public static void a() {
    }

    public final ab b() {
        return this.g;
    }

    public final void a(boolean z) {
        this.e = true;
    }

    public final void b(boolean z) {
        this.f = true;
    }
}
