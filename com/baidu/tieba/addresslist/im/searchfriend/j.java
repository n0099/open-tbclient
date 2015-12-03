package com.baidu.tieba.addresslist.im.searchfriend;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j {
    private View.OnClickListener aEI = new k(this);
    private TextWatcher aGT;
    private a aJA;
    private EditText aJx;
    private TextView aJy;
    private ImageView aJz;
    private Context context;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void gu(String str);
    }

    public void bL(boolean z) {
        this.aJy.setClickable(z);
    }

    public void gv(String str) {
        this.aJx.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.aJx = (EditText) view.findViewById(n.f.new_search_friend_input);
        this.aJy = (TextView) view.findViewById(n.f.new_search_friend_search);
        this.aJz = (ImageView) view.findViewById(n.f.new_search_friend_del);
        this.aJy.setOnClickListener(this.aEI);
        this.aJz.setOnClickListener(this.aEI);
        this.aGT = new l(this);
        this.aJx.addTextChangedListener(this.aGT);
        cV(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void Hz() {
        this.aJx.removeTextChangedListener(this.aGT);
    }

    public void HA() {
        com.baidu.adp.lib.util.k.c(this.context, this.aJx);
    }

    public void a(a aVar) {
        this.aJA = aVar;
    }

    public void cV(int i) {
        as.b(this.aJy, n.c.cp_cont_g, 1);
        this.aJx.setHintTextColor(as.getColor(n.c.cp_cont_e));
        as.c(this.aJz, n.e.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        if (this.aJA != null) {
            this.aJA.gu(str);
        }
    }
}
