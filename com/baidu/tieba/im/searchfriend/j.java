package com.baidu.tieba.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private EditText bmD;
    private TextView bmE;
    private ImageView bmF;
    private m bmG;
    private View.OnClickListener bmH = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void df(boolean z) {
        this.bmE.setClickable(z);
    }

    public void hg(String str) {
        this.bmD.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bmD = (EditText) view.findViewById(w.new_search_friend_input);
        this.bmE = (TextView) view.findViewById(w.new_search_friend_search);
        this.bmF = (ImageView) view.findViewById(w.new_search_friend_del);
        this.bmE.setOnClickListener(this.bmH);
        this.bmF.setOnClickListener(this.bmH);
        this.bmD.addTextChangedListener(new l(this));
        cl(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.l.c(this.context, this.bmD);
    }

    public void a(m mVar) {
        this.bmG = mVar;
    }

    public void cl(int i) {
        ax.b(this.bmE, com.baidu.tieba.t.cp_cont_g, 1);
        this.bmD.setHintTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_e));
        ax.c(this.bmF, com.baidu.tieba.v.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        if (this.bmG != null) {
            this.bmG.hf(str);
        }
    }
}
