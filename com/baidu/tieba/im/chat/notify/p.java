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
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class p extends BaseAdapter {
    private Context a;
    private aa g;
    private b b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<ImMessageCenterShowItemData> h = null;

    public p(Context context) {
        this.a = null;
        this.g = null;
        this.a = context;
        this.g = new aa(this.a);
        this.g.a(true);
    }

    public final void a(List<ImMessageCenterShowItemData> list) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        this.h.clear();
        this.h.addAll(list);
        if (TbadkApplication.F()) {
            com.baidu.adp.lib.util.f.e("mRecentChatData.size():" + this.h.size());
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x03fb A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06d1 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0700 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ee A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021c A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x028b A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02c1 A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030a A[Catch: JSONException -> 0x0329, TryCatch #0 {JSONException -> 0x0329, blocks: (B:33:0x0199, B:35:0x01b1, B:37:0x01c0, B:82:0x0337, B:84:0x0345, B:86:0x0354, B:89:0x0377, B:39:0x01d6, B:41:0x01ee, B:42:0x01f2, B:44:0x021c, B:46:0x023c, B:47:0x0247, B:48:0x0265, B:50:0x028b, B:53:0x0297, B:56:0x02a4, B:59:0x02b9, B:62:0x02c1, B:65:0x02df, B:66:0x02e6, B:67:0x02f7, B:69:0x030a, B:71:0x0312, B:73:0x0316, B:196:0x075b, B:198:0x075f, B:76:0x0320, B:199:0x0767, B:201:0x0776, B:213:0x07c6, B:203:0x0785, B:205:0x078b, B:206:0x0794, B:208:0x079a, B:210:0x07ab, B:211:0x07b4, B:212:0x07bd, B:181:0x06da, B:184:0x06e7, B:185:0x06f0, B:186:0x0700, B:189:0x071e, B:190:0x0725, B:191:0x0738, B:194:0x0744, B:195:0x074c, B:152:0x062c, B:155:0x0643, B:157:0x0652, B:160:0x0663, B:162:0x066b, B:165:0x0679, B:167:0x0688, B:170:0x069a, B:172:0x06a2, B:175:0x06b0, B:177:0x06bf, B:151:0x0626, B:180:0x06d1, B:102:0x03ee, B:103:0x03fb, B:105:0x040a, B:107:0x043d, B:108:0x0448, B:109:0x0455, B:110:0x0461, B:112:0x0470, B:114:0x0497, B:116:0x049d, B:120:0x04a9, B:122:0x04b5, B:123:0x04ba, B:124:0x051b, B:118:0x04a3, B:125:0x0527, B:127:0x052d, B:128:0x0539, B:130:0x0548, B:132:0x057b, B:133:0x0586, B:134:0x0593, B:135:0x059f, B:137:0x05bd, B:139:0x05c3, B:143:0x05cf, B:145:0x05db, B:146:0x05e0, B:147:0x0608, B:141:0x05c9, B:148:0x0614, B:150:0x061a, B:91:0x037e, B:92:0x038d, B:94:0x0397, B:96:0x03a0, B:98:0x03a9, B:99:0x03d5, B:101:0x03e6, B:38:0x01cd), top: B:218:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x031e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        View view2;
        int unReadCount;
        int i2;
        q qVar2 = null;
        if (view != null) {
            qVar2 = (q) view.getTag();
        }
        if (qVar2 == null) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.chat_list_item, viewGroup, false);
            q qVar3 = new q(this, (byte) 0);
            qVar3.a = (ViewGroup) inflate.findViewById(com.baidu.tieba.im.h.list_content);
            qVar3.b = (HeadImageView) inflate.findViewById(com.baidu.tieba.im.h.chat_head);
            qVar3.c = (TextView) inflate.findViewById(com.baidu.tieba.im.h.chat_name);
            qVar3.d = (TextView) inflate.findViewById(com.baidu.tieba.im.h.last_chat_content);
            qVar3.e = (TextView) inflate.findViewById(com.baidu.tieba.im.h.chat_time);
            qVar3.f = (TextView) inflate.findViewById(com.baidu.tieba.im.h.new_message);
            qVar3.g = (ViewGroup) inflate.findViewById(com.baidu.tieba.im.h.list_control);
            qVar3.h = (TextView) inflate.findViewById(com.baidu.tieba.im.h.list_control_tv);
            qVar3.i = (ProgressBar) inflate.findViewById(com.baidu.tieba.im.h.list_control_progress);
            qVar3.j = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.iv_bell);
            inflate.setTag(qVar3);
            qVar = qVar3;
            view2 = inflate;
        } else {
            qVar = qVar2;
            view2 = view;
        }
        int l = TbadkApplication.j().l();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            qVar.a.setVisibility(8);
            qVar.g.setVisibility(0);
            if (this.f) {
                qVar.h.setText(com.baidu.tieba.im.j.loading);
                qVar.i.setVisibility(0);
            } else {
                qVar.h.setText(com.baidu.tieba.im.j.frs_pre);
                qVar.i.setVisibility(8);
            }
            if (l == 1) {
                ba.e((View) qVar.h, com.baidu.tieba.im.g.btn_w_square_1);
                qVar.h.setTextColor(-8682095);
            } else {
                ba.e((View) qVar.h, com.baidu.tieba.im.g.btn_w_square);
                qVar.h.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundDrawable(null);
            qVar.a.setVisibility(8);
            qVar.g.setVisibility(0);
            if (this.e) {
                qVar.h.setText(com.baidu.tieba.im.j.loading);
                qVar.i.setVisibility(0);
            } else {
                qVar.h.setText(com.baidu.tieba.im.j.frs_next);
                qVar.i.setVisibility(8);
            }
            if (l == 1) {
                ba.e((View) qVar.h, com.baidu.tieba.im.g.btn_w_square_1);
                qVar.h.setTextColor(-8682095);
            } else {
                ba.e((View) qVar.h, com.baidu.tieba.im.g.btn_w_square);
                qVar.h.setTextColor(-14277082);
            }
        } else {
            if (l == 1) {
                ba.e(view2, com.baidu.tieba.im.g.list_selector_1);
            } else {
                ba.e(view2, com.baidu.tieba.im.g.list_selector);
            }
            com.baidu.adp.lib.util.f.e("count:" + getCount());
            qVar.a.setVisibility(0);
            qVar.g.setVisibility(8);
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) getItem(i);
            if (imMessageCenterShowItemData != null) {
                try {
                    qVar.c.setText(imMessageCenterShowItemData.getFriendName());
                    if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                        if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                            qVar.c.setText(this.a.getString(com.baidu.tieba.im.j.updates_activity_title));
                        } else if (!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                                qVar.c.setText(this.a.getString(com.baidu.tieba.im.j.official_message_activity_title));
                                TextView textView = qVar.d;
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
                                    qVar.d.setText((CharSequence) null);
                                }
                            }
                            Date date = new Date();
                            date.setTime(imMessageCenterShowItemData.getServerTime());
                            String str = "";
                            if (imMessageCenterShowItemData.getServerTime() != 0) {
                                str = bc.f(date);
                            }
                            qVar.e.setText(str);
                            com.baidu.adp.lib.util.f.e("ownername:" + imMessageCenterShowItemData.getOwnerName());
                            if (!String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                                qVar.b.setDrawBorder(false);
                                qVar.b.setAutoChangeStyle(false);
                                qVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                if (TbadkApplication.j().l() == 1) {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_test_1));
                                } else {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_test));
                                }
                                qVar.b.setUserName(String.valueOf(2));
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                qVar.b.setIsRound(false);
                                qVar.b.invalidate();
                            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                                qVar.b.setDrawBorder(false);
                                qVar.b.setAutoChangeStyle(false);
                                qVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                qVar.b.setUserName(String.valueOf(3));
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                if (TbadkApplication.j().l() == 1) {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_trends_1));
                                } else {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_trends));
                                }
                                qVar.b.setIsRound(false);
                                qVar.b.invalidate();
                            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                                qVar.b.setDrawBorder(true);
                                qVar.b.setAutoChangeStyle(true);
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
                                String str2 = (String) qVar.b.getTag();
                                if ((!TextUtils.isEmpty(friendPortrait) && !TextUtils.isEmpty(str2) && !str2.equals(friendPortrait)) || TextUtils.isEmpty(str2)) {
                                    aa aaVar = this.g;
                                    com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(friendPortrait);
                                    if (c != null) {
                                        c.a(qVar.b);
                                    } else {
                                        qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.avatar_poto_defaul140));
                                    }
                                } else if (TextUtils.isEmpty(friendPortrait)) {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.avatar_poto_defaul140));
                                }
                                qVar.b.setClickable(false);
                                qVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                com.baidu.adp.lib.util.f.e("groupid:" + imMessageCenterShowItemData.getFriendId() + " groupHeadUrl:" + imMessageCenterShowItemData.getFriendPortrait() + " groupName:" + imMessageCenterShowItemData.getFriendName());
                                qVar.b.setUserName(String.valueOf(1));
                                qVar.b.setIsRound(false);
                                qVar.b.invalidate();
                            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                                qVar.b.setDrawBorder(false);
                                qVar.b.setAutoChangeStyle(false);
                                qVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                                qVar.b.setUserName(String.valueOf(5));
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                if (TbadkApplication.j().l() == 1) {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_official_1));
                                } else {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.icon_new_official));
                                }
                                qVar.b.setIsRound(false);
                                qVar.b.invalidate();
                            } else {
                                qVar.b.setDrawBorder(true);
                                qVar.b.setAutoChangeStyle(true);
                                String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
                                String str3 = (String) qVar.b.getTag();
                                if ((!TextUtils.isEmpty(friendPortrait2) && !TextUtils.isEmpty(str3) && !str3.equals(friendPortrait2)) || TextUtils.isEmpty(str3)) {
                                    aa aaVar2 = this.g;
                                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(friendPortrait2);
                                    if (b != null) {
                                        b.a(qVar.b);
                                    } else {
                                        qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.person_photo));
                                    }
                                } else if (TextUtils.isEmpty(friendPortrait2)) {
                                    qVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.person_photo));
                                }
                                qVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                                qVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                                qVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                                qVar.b.setIsRound(true);
                                qVar.b.invalidate();
                            }
                            unReadCount = imMessageCenterShowItemData.getUnReadCount();
                            com.baidu.adp.lib.util.f.e("type:" + imMessageCenterShowItemData.getOwnerName() + "  count:" + unReadCount);
                            if (unReadCount <= 0) {
                                qVar.f.setVisibility(0);
                                String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
                                if (TbadkApplication.j().ag() == 0) {
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
                                    if (TbadkApplication.ad()) {
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
                                    if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) && !TbadkApplication.j().ae()) {
                                        unReadCount = 0;
                                        valueOf = "";
                                    }
                                    unReadCount = i2;
                                } else if (TbadkApplication.j().ae()) {
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
                                qVar.f.setText(valueOf);
                            } else {
                                qVar.f.setVisibility(8);
                            }
                            if (l != 1) {
                                qVar.c.setTextColor(-8153171);
                                qVar.d.setTextColor(-10391164);
                                qVar.e.setTextColor(-10391164);
                                if (unReadCount < 10) {
                                    if (unReadCount == 0) {
                                        qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt_1);
                                    } else {
                                        qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one_1);
                                    }
                                } else if (unReadCount < 100) {
                                    qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two_1);
                                } else {
                                    qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more_1);
                                    qVar.f.setText("");
                                }
                                qVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.top_msg_num_night));
                            } else {
                                qVar.c.setTextColor(-13553101);
                                qVar.d.setTextColor(-8749952);
                                qVar.e.setTextColor(-3881012);
                                if (unReadCount < 10) {
                                    if (unReadCount == 0) {
                                        qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_list_prompt);
                                    } else {
                                        qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_one);
                                    }
                                } else if (unReadCount < 100) {
                                    qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_two);
                                } else {
                                    qVar.f.setBackgroundResource(com.baidu.tieba.im.g.icon_news_head_prompt_more);
                                    qVar.f.setText("");
                                }
                                qVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.top_msg_num_day));
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
                            if (qVar != null) {
                                if (imMessageCenterShowItemData == null) {
                                    qVar.j.setVisibility(8);
                                } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                                    com.baidu.tieba.im.pushNotify.l groupSetting = imMessageCenterShowItemData.getGroupSetting();
                                    if (groupSetting == null) {
                                        qVar.j.setVisibility(8);
                                    } else if (groupSetting.isAcceptNotify()) {
                                        qVar.j.setVisibility(8);
                                    } else {
                                        qVar.j.setVisibility(0);
                                        if (TbadkApplication.j().l() == 1) {
                                            qVar.j.setImageResource(com.baidu.tieba.im.g.icon_news_stop_1);
                                        } else {
                                            qVar.j.setImageResource(com.baidu.tieba.im.g.icon_news_stop);
                                        }
                                    }
                                } else {
                                    qVar.j.setVisibility(8);
                                }
                            }
                        }
                    }
                    qVar.d.setText(imMessageCenterShowItemData.getMsgContent());
                    Date date2 = new Date();
                    date2.setTime(imMessageCenterShowItemData.getServerTime());
                    String str4 = "";
                    if (imMessageCenterShowItemData.getServerTime() != 0) {
                    }
                    qVar.e.setText(str4);
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
                    if (qVar != null) {
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

    public final aa b() {
        return this.g;
    }

    public final void a(boolean z) {
        this.e = true;
    }

    public final void b(boolean z) {
        this.f = true;
    }
}
