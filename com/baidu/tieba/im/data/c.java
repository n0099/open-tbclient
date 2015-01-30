package com.baidu.tieba.im.data;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.chat.officialBar.p;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private long aUh;
    private String aXS;
    List<p> list;

    public c(List<p> list) {
        this.list = list;
        MG();
    }

    private void MG() {
        List<p> list = this.list;
        if (list != null && !list.isEmpty()) {
            long j = 0;
            long j2 = 0;
            String str = null;
            String str2 = null;
            for (p pVar : list) {
                if (pVar != null) {
                    if (str2 == null) {
                        str2 = pVar.aUe;
                    }
                    if (str == null) {
                        str = pVar.aUg;
                    }
                    j2 += pVar.aUf;
                    j += pVar.aUh;
                }
            }
            this.aUh = j;
            if (j2 <= 0) {
                this.aXS = null;
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
            this.aXS = sb.toString();
        }
    }

    public boolean isShow() {
        return (!StringUtils.isNull(this.aXS)) || ((this.aUh > 0L ? 1 : (this.aUh == 0L ? 0 : -1)) > 0);
    }

    public void G(View view) {
        TextView textView = (TextView) view.findViewById(w.office_msg_praise_text);
        TextView textView2 = (TextView) view.findViewById(w.office_msg_praise_number);
        if (!isShow()) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (StringUtils.isNull(this.aXS)) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(this.aXS);
        }
        if (this.aUh <= 0) {
            textView2.setVisibility(4);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(new StringBuilder(String.valueOf(this.aUh)).toString());
    }
}
