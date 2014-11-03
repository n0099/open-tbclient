package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private View aGj;
    private TextView aGk;
    private TextView aGl;
    private PraiseData aGm;
    private boolean aGn;
    private TextView azw;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.aGn = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGn = false;
        setOrientation(0);
        this.mContext = context;
        nu();
    }

    private void nu() {
        this.aGj = View.inflate(this.mContext, com.baidu.tieba.w.frs_item_praise, this);
        this.azw = (TextView) this.aGj.findViewById(com.baidu.tieba.v.frs_go_praise_list_num);
        this.aGk = (TextView) this.aGj.findViewById(com.baidu.tieba.v.frs_praise_user_name_text1);
        this.aGl = (TextView) this.aGj.findViewById(com.baidu.tieba.v.frs_praise_user_name_text2);
        setOnClickListener(new o(this));
        this.aGl.setOnClickListener(new p(this));
        this.aGk.setOnClickListener(new q(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.aGm = praiseData;
            ck(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.aGn = z;
    }

    private void ck(boolean z) {
        long num = this.aGm.getNum();
        this.aGl.setVisibility(8);
        this.aGk.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.aGm.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.aGk.setVisibility(0);
                        this.aGk.setText(fi(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.aGk.setVisibility(0);
                        this.aGk.setText(fi(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.aGl.setVisibility(0);
                        this.aGl.setText("、" + fi(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.azw.setText(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text));
            } else if (num <= 999999) {
                this.azw.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            } else {
                this.azw.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            }
        }
    }

    private String fi(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void bN(int i) {
        if (this.aGn) {
            aw.h(this.aGj, com.baidu.tieba.u.praise_head_selector);
            aw.b(this.azw, com.baidu.tieba.s.cp_cont_d, 1);
            aw.b(this.aGk, com.baidu.tieba.s.cp_cont_c, 1);
            aw.b(this.aGl, com.baidu.tieba.s.cp_cont_c, 1);
            return;
        }
        aw.h(this.aGj, com.baidu.tieba.u.praise_view_btn_color);
        aw.b(this.azw, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.aGk, com.baidu.tieba.s.cp_cont_c, 1);
        aw.b(this.aGl, com.baidu.tieba.s.cp_cont_c, 1);
    }
}
