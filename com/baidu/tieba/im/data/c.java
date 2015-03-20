package com.baidu.tieba.im.data;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.chat.officialBar.q;
import com.baidu.tieba.v;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private long aYN;
    private String bbZ;
    List<q> list;

    public c(List<q> list) {
        this.list = list;
        PA();
    }

    private void PA() {
        List<q> list = this.list;
        if (list != null && !list.isEmpty()) {
            long j = 0;
            long j2 = 0;
            String str = null;
            String str2 = null;
            for (q qVar : list) {
                if (qVar != null) {
                    if (str2 == null) {
                        str2 = qVar.aYK;
                    }
                    if (str == null) {
                        str = qVar.aYM;
                    }
                    j2 += qVar.aYL;
                    j += qVar.aYN;
                }
            }
            this.aYN = j;
            if (j2 == 0) {
                this.bbZ = null;
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (!StringUtils.isNull(str2)) {
                sb.append(str2);
            }
            sb.append(j2);
            if (!StringUtils.isNull(str)) {
                sb.append(str);
            }
            this.bbZ = sb.toString();
        }
    }

    public boolean isShow() {
        return (!StringUtils.isNull(this.bbZ)) || ((this.aYN > 0L ? 1 : (this.aYN == 0L ? 0 : -1)) > 0);
    }

    public void E(View view) {
        TextView textView = (TextView) view.findViewById(v.office_msg_praise_text);
        TextView textView2 = (TextView) view.findViewById(v.office_msg_praise_number);
        if (!isShow()) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (StringUtils.isNull(this.bbZ)) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(this.bbZ);
        }
        if (this.aYN <= 0) {
            textView2.setVisibility(4);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(new StringBuilder(String.valueOf(this.aYN)).toString());
    }
}
