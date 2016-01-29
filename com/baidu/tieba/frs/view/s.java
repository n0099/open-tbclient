package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends LinearLayout {
    private LinearLayout aCx;
    private TextView aHk;
    private EditText brF;
    private HeadImageView brG;
    private TextView brH;
    private TextView brI;
    private ShareFromFrsMsgData brJ;
    private Context context;

    public EditText getChatMsgView() {
        return this.brF;
    }

    public void x(String str, boolean z) {
        if (this.brG != null) {
            this.brG.d(str, 15, false);
        }
    }

    public s(Context context) {
        super(context);
        this.context = context;
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_share_card_view, this);
        setOrientation(1);
        this.aCx = (LinearLayout) findViewById(t.g.share_content);
        this.aHk = (TextView) findViewById(t.g.frs_card_name);
        this.brF = (EditText) findViewById(t.g.chat_msg);
        this.brG = (HeadImageView) findViewById(t.g.frs_card_img);
        this.brI = (TextView) findViewById(t.g.frs_card_member_num);
        this.brH = (TextView) findViewById(t.g.frs_card_post_num);
        ar.b(this.aHk, t.d.cp_cont_b, 1);
        ar.b(this.brF, t.d.cp_cont_b, 2);
        this.brF.setHintTextColor(ar.getColor(t.d.cp_cont_e));
        this.brF.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Sx();
    }

    public void Sx() {
        this.aCx.setFocusable(true);
        this.aCx.setFocusableInTouchMode(true);
        this.aCx.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.brF != null) {
            return com.baidu.adp.lib.util.j.a(this.brF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.brJ = shareFromFrsMsgData;
        wV();
    }

    private void wV() {
        this.aHk.setText(dA(this.brJ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.brJ.getImageUrl());
        this.brG.d(this.brJ.getImageUrl(), 15, false);
        this.brI.setText(aw.y(this.brJ.getMemberNum()));
        this.brH.setText(aw.y(this.brJ.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(aw.j(str, 18)) + this.context.getString(t.j.forum);
    }
}
