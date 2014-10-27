package com.baidu.tieba.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class h {
    private EditText bhM;
    private TextView bhN;
    private ImageView bhO;
    private k bhP;
    private View.OnClickListener bhQ = new i(this);
    private Context context;

    public void ds(boolean z) {
        this.bhN.setClickable(z);
    }

    public void gC(String str) {
        this.bhM.setText(str);
    }

    public h(Context context, View view) {
        this.context = context;
        this.bhM = (EditText) view.findViewById(v.new_search_friend_input);
        this.bhN = (TextView) view.findViewById(v.new_search_friend_search);
        this.bhO = (ImageView) view.findViewById(v.new_search_friend_del);
        this.bhN.setOnClickListener(this.bhQ);
        this.bhO.setOnClickListener(this.bhQ);
        this.bhM.addTextChangedListener(new j(this));
        bM(TbadkApplication.m251getInst().getSkinType());
    }

    public void Rv() {
        com.baidu.adp.lib.util.m.b(this.context, this.bhM);
    }

    public void a(k kVar) {
        this.bhP = kVar;
    }

    public void bM(int i) {
        aw.b(this.bhN, com.baidu.tieba.s.cp_cont_g, 1);
        this.bhM.setHintTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_e));
        aw.c(this.bhO, u.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        if (this.bhP != null) {
            this.bhP.gB(str);
        }
    }
}
